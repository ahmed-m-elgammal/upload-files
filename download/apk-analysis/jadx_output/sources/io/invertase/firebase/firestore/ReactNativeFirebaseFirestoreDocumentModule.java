package io.invertase.firebase.firestore;

import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Source;
import com.google.firebase.firestore.WriteBatch;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.sentry.protocol.SentryStackTrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes6.dex */
public class ReactNativeFirebaseFirestoreDocumentModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "FirestoreDocument";
    private static SparseArray<ListenerRegistration> documentSnapshotListeners = new SparseArray<>();

    ReactNativeFirebaseFirestoreDocumentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        int size = documentSnapshotListeners.size();
        for (int i = 0; i < size; i++) {
            documentSnapshotListeners.get(documentSnapshotListeners.keyAt(i)).remove();
        }
        documentSnapshotListeners.clear();
    }

    @ReactMethod
    public void documentOnSnapshot(final String str, final String str2, String str3, final int i, ReadableMap readableMap) {
        MetadataChanges metadataChanges;
        if (documentSnapshotListeners.get(i) != null) {
            return;
        }
        DocumentReference documentForFirestore = UniversalFirebaseFirestoreCommon.getDocumentForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3);
        EventListener<DocumentSnapshot> eventListener = new EventListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda15
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                ReactNativeFirebaseFirestoreDocumentModule.this.lambda$documentOnSnapshot$0(i, str, str2, (DocumentSnapshot) obj, firebaseFirestoreException);
            }
        };
        if (readableMap != null && readableMap.hasKey("includeMetadataChanges") && readableMap.getBoolean("includeMetadataChanges")) {
            metadataChanges = MetadataChanges.INCLUDE;
        } else {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        documentSnapshotListeners.put(i, documentForFirestore.addSnapshotListener(metadataChanges, eventListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$documentOnSnapshot$0(int i, String str, String str2, DocumentSnapshot documentSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            ListenerRegistration listenerRegistration = documentSnapshotListeners.get(i);
            if (listenerRegistration != null) {
                listenerRegistration.remove();
                documentSnapshotListeners.remove(i);
            }
            sendOnSnapshotError(str, str2, i, firebaseFirestoreException);
            return;
        }
        sendOnSnapshotEvent(str, str2, i, documentSnapshot);
    }

    @ReactMethod
    public void documentOffSnapshot(String str, String str2, int i) {
        ListenerRegistration listenerRegistration = documentSnapshotListeners.get(i);
        if (listenerRegistration != null) {
            listenerRegistration.remove();
            documentSnapshotListeners.remove(i);
        }
    }

    @ReactMethod
    public void documentGet(final String str, final String str2, String str3, ReadableMap readableMap, final Promise promise) {
        final Source source;
        final DocumentReference documentForFirestore = UniversalFirebaseFirestoreCommon.getDocumentForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3);
        if (readableMap != null && readableMap.hasKey("source")) {
            String string = readableMap.getString("source");
            if ("server".equals(string)) {
                source = Source.SERVER;
            } else if ("cache".equals(string)) {
                source = Source.CACHE;
            } else {
                source = Source.DEFAULT;
            }
        } else {
            source = Source.DEFAULT;
        }
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WritableMap snapshotToWritableMap;
                snapshotToWritableMap = ReactNativeFirebaseFirestoreSerialize.snapshotToWritableMap(str, str2, (DocumentSnapshot) Tasks.await(DocumentReference.this.get(source)));
                return snapshotToWritableMap;
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreDocumentModule.lambda$documentGet$2(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$documentGet$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void documentDelete(String str, String str2, String str3, final Promise promise) {
        final DocumentReference documentForFirestore = UniversalFirebaseFirestoreCommon.getDocumentForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3);
        ExecutorService transactionalExecutor = getTransactionalExecutor();
        Objects.requireNonNull(documentForFirestore);
        Tasks.call(transactionalExecutor, new Callable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DocumentReference.this.delete();
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreDocumentModule.lambda$documentDelete$3(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$documentDelete$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void documentSet(String str, String str2, String str3, final ReadableMap readableMap, final ReadableMap readableMap2, final Promise promise) {
        final FirebaseFirestore firestoreForApp = UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2);
        final DocumentReference documentForFirestore = UniversalFirebaseFirestoreCommon.getDocumentForFirestore(firestoreForApp, str3);
        Tasks.call(getTransactionalExecutor(), new Callable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Map parseReadableMap;
                parseReadableMap = ReactNativeFirebaseFirestoreSerialize.parseReadableMap(FirebaseFirestore.this, readableMap);
                return parseReadableMap;
            }
        }).continueWithTask(getTransactionalExecutor(), new Continuation() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda13
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return ReactNativeFirebaseFirestoreDocumentModule.lambda$documentSet$5(ReadableMap.this, documentForFirestore, task);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda14
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreDocumentModule.lambda$documentSet$6(Promise.this, task);
            }
        });
    }

    static /* synthetic */ Task lambda$documentSet$5(ReadableMap readableMap, DocumentReference documentReference, Task task) throws Exception {
        Map map = (Map) Objects.requireNonNull((Map) task.getResult());
        if (readableMap.hasKey("merge") && readableMap.getBoolean("merge")) {
            return documentReference.set(map, SetOptions.merge());
        }
        if (readableMap.hasKey("mergeFields")) {
            ArrayList arrayList = new ArrayList();
            Iterator<Object> it = ((ReadableArray) Objects.requireNonNull(readableMap.getArray("mergeFields"))).toArrayList().iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            return documentReference.set(map, SetOptions.mergeFields(arrayList));
        }
        return documentReference.set(map);
    }

    static /* synthetic */ void lambda$documentSet$6(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void documentUpdate(String str, String str2, String str3, final ReadableMap readableMap, final Promise promise) {
        final FirebaseFirestore firestoreForApp = UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2);
        final DocumentReference documentForFirestore = UniversalFirebaseFirestoreCommon.getDocumentForFirestore(firestoreForApp, str3);
        Tasks.call(getTransactionalExecutor(), new Callable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Map parseReadableMap;
                parseReadableMap = ReactNativeFirebaseFirestoreSerialize.parseReadableMap(FirebaseFirestore.this, readableMap);
                return parseReadableMap;
            }
        }).continueWithTask(getTransactionalExecutor(), new Continuation() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task update;
                update = DocumentReference.this.update((Map<String, Object>) Objects.requireNonNull((Map) task.getResult()));
                return update;
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda11
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreDocumentModule.lambda$documentUpdate$9(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$documentUpdate$9(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void documentBatch(String str, String str2, final ReadableArray readableArray, final Promise promise) {
        final FirebaseFirestore firestoreForApp = UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2);
        Tasks.call(getTransactionalExecutor(), new Callable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List parseDocumentBatches;
                parseDocumentBatches = ReactNativeFirebaseFirestoreSerialize.parseDocumentBatches(FirebaseFirestore.this, readableArray);
                return parseDocumentBatches;
            }
        }).continueWithTask(getTransactionalExecutor(), new Continuation() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return ReactNativeFirebaseFirestoreDocumentModule.lambda$documentBatch$11(FirebaseFirestore.this, task);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreDocumentModule.lambda$documentBatch$12(Promise.this, task);
            }
        });
    }

    static /* synthetic */ Task lambda$documentBatch$11(FirebaseFirestore firebaseFirestore, Task task) throws Exception {
        Map map;
        DocumentReference documentForFirestore;
        WriteBatch batch = firebaseFirestore.batch();
        for (Map map2 : (List) task.getResult()) {
            String str = (String) map2.get("type");
            String str2 = (String) map2.get("path");
            map = (Map) map2.get("data");
            documentForFirestore = UniversalFirebaseFirestoreCommon.getDocumentForFirestore(firebaseFirestore, str2);
            String str3 = (String) Objects.requireNonNull(str);
            str3.hashCode();
            switch (str3) {
                case "UPDATE":
                    batch = batch.update(documentForFirestore, (Map<String, Object>) Objects.requireNonNull(map));
                    break;
                case "SET":
                    Map map3 = (Map) map2.get("options");
                    if (((Map) Objects.requireNonNull(map3)).containsKey("merge") && ((Boolean) map3.get("merge")).booleanValue()) {
                        batch = batch.set(documentForFirestore, Objects.requireNonNull(map), SetOptions.merge());
                        break;
                    } else if (map3.containsKey("mergeFields")) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = ((List) Objects.requireNonNull((List) map3.get("mergeFields"))).iterator();
                        while (it.hasNext()) {
                            arrayList.add((String) it.next());
                        }
                        batch = batch.set(documentForFirestore, Objects.requireNonNull(map), SetOptions.mergeFields(arrayList));
                        break;
                    } else {
                        batch = batch.set(documentForFirestore, Objects.requireNonNull(map));
                        break;
                    }
                    break;
                case "DELETE":
                    batch = batch.delete(documentForFirestore);
                    break;
            }
        }
        return batch.commit();
    }

    static /* synthetic */ void lambda$documentBatch$12(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    private void sendOnSnapshotEvent(final String str, final String str2, final int i, final DocumentSnapshot documentSnapshot) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WritableMap snapshotToWritableMap;
                snapshotToWritableMap = ReactNativeFirebaseFirestoreSerialize.snapshotToWritableMap(str, str2, documentSnapshot);
                return snapshotToWritableMap;
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreDocumentModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreDocumentModule.this.lambda$sendOnSnapshotEvent$14(str, str2, i, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendOnSnapshotEvent$14(String str, String str2, int i, Task task) {
        if (task.isSuccessful()) {
            WritableMap createMap = Arguments.createMap();
            createMap.putMap(SentryStackTrace.JsonKeys.SNAPSHOT, (ReadableMap) task.getResult());
            ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_document_sync_event", createMap, str, str2, i));
            return;
        }
        sendOnSnapshotError(str, str2, i, task.getException());
    }

    private void sendOnSnapshotError(String str, String str2, int i, Exception exc) {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        if (exc instanceof FirebaseFirestoreException) {
            UniversalFirebaseFirestoreException universalFirebaseFirestoreException = new UniversalFirebaseFirestoreException((FirebaseFirestoreException) exc, exc.getCause());
            createMap2.putString("code", universalFirebaseFirestoreException.getCode());
            createMap2.putString("message", universalFirebaseFirestoreException.getMessage());
        } else {
            createMap2.putString("code", "unknown");
            createMap2.putString("message", "An unknown error occurred");
        }
        createMap.putMap("error", createMap2);
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_document_sync_event", createMap, str, str2, i));
    }
}
