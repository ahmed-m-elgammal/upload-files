package com.microsoft.clarity.models.display.blobs;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.common.Rect;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$TextBlob;
import com.microsoft.clarity.protomodels.mutationpayload.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B!\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tB'\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003J\b\u0010\u001b\u001a\u00020\u0000H\u0016J1\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\b\u0010!\u001a\u00020\u0002H\u0016J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012¨\u0006$"}, d2 = {"Lcom/microsoft/clarity/models/display/blobs/TextBlob;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$TextBlob;", "Lcom/microsoft/clarity/models/ICopyable;", "bounds", "Lcom/microsoft/clarity/models/display/common/Rect;", "runs", "", "Lcom/microsoft/clarity/models/display/blobs/TextBlobRun;", "(Lcom/microsoft/clarity/models/display/common/Rect;Ljava/util/List;)V", "masked", "", "(Lcom/microsoft/clarity/models/display/common/Rect;Ljava/util/List;Z)V", "getBounds", "()Lcom/microsoft/clarity/models/display/common/Rect;", "getMasked", "()Z", "setMasked", "(Z)V", "getRuns", "()Ljava/util/List;", "sanitized", "getSanitized", "setSanitized", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TextBlob implements IProtoModel<MutationPayload$TextBlob>, ICopyable<TextBlob> {
    private final Rect bounds;
    private transient boolean masked;
    private final List<TextBlobRun> runs;
    private transient boolean sanitized;

    public TextBlob(Rect rect, List<TextBlobRun> list, boolean z) {
        this.bounds = rect;
        this.runs = list;
        this.masked = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextBlob copy$default(TextBlob textBlob, Rect rect, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = textBlob.bounds;
        }
        if ((i & 2) != 0) {
            list = textBlob.runs;
        }
        if ((i & 4) != 0) {
            z = textBlob.masked;
        }
        return textBlob.copy(rect, list, z);
    }

    /* renamed from: component1, reason: from getter */
    public final Rect getBounds() {
        return this.bounds;
    }

    public final List<TextBlobRun> component2() {
        return this.runs;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getMasked() {
        return this.masked;
    }

    public final TextBlob copy(Rect bounds, List<TextBlobRun> runs, boolean masked) {
        return new TextBlob(bounds, runs, masked);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public TextBlob copyWithNullData() {
        return (TextBlob) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextBlob)) {
            return false;
        }
        TextBlob textBlob = (TextBlob) other;
        return Intrinsics.areEqual(this.bounds, textBlob.bounds) && Intrinsics.areEqual(this.runs, textBlob.runs) && this.masked == textBlob.masked;
    }

    public final Rect getBounds() {
        return this.bounds;
    }

    public final boolean getMasked() {
        return this.masked;
    }

    public final List<TextBlobRun> getRuns() {
        return this.runs;
    }

    public final boolean getSanitized() {
        return this.sanitized;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Rect rect = this.bounds;
        int hashCode = (rect == null ? 0 : rect.hashCode()) * 31;
        List<TextBlobRun> list = this.runs;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z = this.masked;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode2 + i;
    }

    public final void setMasked(boolean z) {
        this.masked = z;
    }

    public final void setSanitized(boolean z) {
        this.sanitized = z;
    }

    public String toString() {
        return "TextBlob(bounds=" + this.bounds + ", runs=" + this.runs + ", masked=" + this.masked + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$TextBlob toProtobufInstance() {
        b0 newBuilder = MutationPayload$TextBlob.newBuilder();
        List<TextBlobRun> list = this.runs;
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((TextBlobRun) it.next()).toProtobufInstance());
            }
            newBuilder.a(arrayList);
        }
        Rect rect = this.bounds;
        if (rect != null) {
            newBuilder.a(rect.toProtobufInstance());
        }
        GeneratedMessageLite build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$TextBlob) build;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public TextBlob copy2() {
        Rect rect = this.bounds;
        ArrayList arrayList = null;
        Rect copy2 = rect != null ? rect.copy2() : null;
        List<TextBlobRun> list = this.runs;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((TextBlobRun) it.next()).copy2());
            }
        }
        TextBlob textBlob = new TextBlob(copy2, arrayList, this.masked);
        textBlob.sanitized = this.sanitized;
        return textBlob;
    }

    public TextBlob(Rect rect, List<TextBlobRun> list) {
        this(rect, list, false);
    }
}
