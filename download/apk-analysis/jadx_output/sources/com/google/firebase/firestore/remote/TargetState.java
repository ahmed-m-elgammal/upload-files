package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.ByteString;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
final class TargetState {
    private int outstandingResponses = 0;
    private final Map<DocumentKey, DocumentViewChange.Type> documentChanges = new HashMap();
    private boolean hasChanges = true;
    private ByteString resumeToken = ByteString.EMPTY;
    private boolean current = false;

    TargetState() {
    }

    boolean isCurrent() {
        return this.current;
    }

    boolean isPending() {
        return this.outstandingResponses != 0;
    }

    boolean hasChanges() {
        return this.hasChanges;
    }

    void updateResumeToken(ByteString byteString) {
        if (byteString.isEmpty()) {
            return;
        }
        this.hasChanges = true;
        this.resumeToken = byteString;
    }

    TargetChange toTargetChange() {
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> emptyKeySet2 = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> emptyKeySet3 = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> immutableSortedSet = emptyKeySet;
        ImmutableSortedSet<DocumentKey> immutableSortedSet2 = emptyKeySet2;
        ImmutableSortedSet<DocumentKey> immutableSortedSet3 = emptyKeySet3;
        for (Map.Entry<DocumentKey, DocumentViewChange.Type> entry : this.documentChanges.entrySet()) {
            DocumentKey key = entry.getKey();
            DocumentViewChange.Type value = entry.getValue();
            int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[value.ordinal()];
            if (i == 1) {
                immutableSortedSet = immutableSortedSet.insert(key);
            } else if (i == 2) {
                immutableSortedSet2 = immutableSortedSet2.insert(key);
            } else {
                if (i != 3) {
                    throw Assert.fail("Encountered invalid change type: %s", value);
                }
                immutableSortedSet3 = immutableSortedSet3.insert(key);
            }
        }
        return new TargetChange(this.resumeToken, this.current, immutableSortedSet, immutableSortedSet2, immutableSortedSet3);
    }

    /* renamed from: com.google.firebase.firestore.remote.TargetState$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type;

        static {
            int[] iArr = new int[DocumentViewChange.Type.values().length];
            $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type = iArr;
            try {
                iArr[DocumentViewChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[DocumentViewChange.Type.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[DocumentViewChange.Type.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    void clearChanges() {
        this.hasChanges = false;
        this.documentChanges.clear();
    }

    void addDocumentChange(DocumentKey documentKey, DocumentViewChange.Type type) {
        this.hasChanges = true;
        this.documentChanges.put(documentKey, type);
    }

    void removeDocumentChange(DocumentKey documentKey) {
        this.hasChanges = true;
        this.documentChanges.remove(documentKey);
    }

    void recordPendingTargetRequest() {
        this.outstandingResponses++;
    }

    void recordTargetResponse() {
        this.outstandingResponses--;
    }

    void markCurrent() {
        this.hasChanges = true;
        this.current = true;
    }
}
