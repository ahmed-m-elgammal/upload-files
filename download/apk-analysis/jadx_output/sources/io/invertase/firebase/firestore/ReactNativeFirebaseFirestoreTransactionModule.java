package io.invertase.firebase.firestore;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Transaction;
import io.invertase.firebase.common.RCTConvertFirebase;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.sentry.ProfilingTraceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public class ReactNativeFirebaseFirestoreTransactionModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "FirestoreTransaction";
    private SparseArray<ReactNativeFirebaseFirestoreTransactionHandler> transactionHandlers;

    ReactNativeFirebaseFirestoreTransactionModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.transactionHandlers = new SparseArray<>();
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        int size = this.transactionHandlers.size();
        for (int i = 0; i < size; i++) {
            ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(this.transactionHandlers.keyAt(i));
            if (reactNativeFirebaseFirestoreTransactionHandler != null) {
                reactNativeFirebaseFirestoreTransactionHandler.abort();
            }
        }
        this.transactionHandlers.clear();
        super.invalidate();
    }

    @ReactMethod
    public void transactionGetDocument(final String str, final String str2, int i, String str3, final Promise promise) {
        final ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(i);
        if (reactNativeFirebaseFirestoreTransactionHandler == null) {
            rejectPromiseWithCodeAndMessage(promise, "internal-error", "An internal error occurred whilst attempting to find a native transaction by id.");
        } else {
            final DocumentReference documentForFirestore = UniversalFirebaseFirestoreCommon.getDocumentForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3);
            Tasks.call(getTransactionalExecutor(), new Callable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreTransactionModule$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    WritableMap snapshotToWritableMap;
                    snapshotToWritableMap = ReactNativeFirebaseFirestoreSerialize.snapshotToWritableMap(str, str2, reactNativeFirebaseFirestoreTransactionHandler.getDocument(documentForFirestore));
                    return snapshotToWritableMap;
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreTransactionModule$$ExternalSyntheticLambda4
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    ReactNativeFirebaseFirestoreTransactionModule.lambda$transactionGetDocument$1(Promise.this, task);
                }
            });
        }
    }

    static /* synthetic */ void lambda$transactionGetDocument$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void transactionDispose(String str, String str2, int i) {
        ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(i);
        if (reactNativeFirebaseFirestoreTransactionHandler != null) {
            reactNativeFirebaseFirestoreTransactionHandler.abort();
            this.transactionHandlers.delete(i);
        }
    }

    @ReactMethod
    public void transactionApplyBuffer(String str, String str2, int i, ReadableArray readableArray) {
        ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler = this.transactionHandlers.get(i);
        if (reactNativeFirebaseFirestoreTransactionHandler != null) {
            reactNativeFirebaseFirestoreTransactionHandler.signalBufferReceived(readableArray);
        }
    }

    @ReactMethod
    public void transactionBegin(String str, final String str2, int i) {
        final ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler = new ReactNativeFirebaseFirestoreTransactionHandler(str, i);
        this.transactionHandlers.put(i, reactNativeFirebaseFirestoreTransactionHandler);
        final FirebaseFirestore firestoreForApp = UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2);
        final ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        firestoreForApp.runTransaction(new Transaction.Function() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreTransactionModule$$ExternalSyntheticLambda0
            @Override // com.google.firebase.firestore.Transaction.Function
            public final Object apply(Transaction transaction) {
                return ReactNativeFirebaseFirestoreTransactionModule.lambda$transactionBegin$3(ReactNativeFirebaseFirestoreTransactionHandler.this, sharedInstance, str2, firestoreForApp, transaction);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreTransactionModule$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreTransactionModule.lambda$transactionBegin$4(ReactNativeFirebaseFirestoreTransactionHandler.this, sharedInstance, str2, task);
            }
        });
    }

    static /* synthetic */ Void lambda$transactionBegin$3(final ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler, final ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter, final String str, FirebaseFirestore firebaseFirestore, Transaction transaction) throws FirebaseFirestoreException {
        ReadableMap map;
        DocumentReference documentForFirestore;
        reactNativeFirebaseFirestoreTransactionHandler.resetState(transaction);
        AsyncTask.execute(new Runnable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreTransactionModule$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ReactNativeFirebaseFirestoreTransactionModule.lambda$transactionBegin$2(ReactNativeFirebaseEventEmitter.this, reactNativeFirebaseFirestoreTransactionHandler, str);
            }
        });
        reactNativeFirebaseFirestoreTransactionHandler.await();
        if (reactNativeFirebaseFirestoreTransactionHandler.aborted) {
            throw new FirebaseFirestoreException("abort", FirebaseFirestoreException.Code.ABORTED);
        }
        if (reactNativeFirebaseFirestoreTransactionHandler.timeout) {
            throw new FirebaseFirestoreException(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, FirebaseFirestoreException.Code.DEADLINE_EXCEEDED);
        }
        ReadableArray commandBuffer = reactNativeFirebaseFirestoreTransactionHandler.getCommandBuffer();
        if (commandBuffer == null) {
            return null;
        }
        int size = commandBuffer.size();
        for (int i = 0; i < size; i++) {
            map = commandBuffer.getMap(i);
            String string = ((ReadableMap) Objects.requireNonNull(map)).getString("path");
            String string2 = map.getString("type");
            documentForFirestore = UniversalFirebaseFirestoreCommon.getDocumentForFirestore(firebaseFirestore, string);
            String str2 = (String) Objects.requireNonNull(string2);
            str2.hashCode();
            switch (str2) {
                case "UPDATE":
                    transaction.update(documentForFirestore, ReactNativeFirebaseFirestoreSerialize.parseReadableMap(firebaseFirestore, map.getMap("data")));
                    break;
                case "SET":
                    Map<String, Object> parseReadableMap = ReactNativeFirebaseFirestoreSerialize.parseReadableMap(firebaseFirestore, map.getMap("data"));
                    ReadableMap map2 = map.getMap("options");
                    if (((ReadableMap) Objects.requireNonNull(map2)).hasKey("merge") && map2.getBoolean("merge")) {
                        transaction.set(documentForFirestore, parseReadableMap, SetOptions.merge());
                        break;
                    } else if (map2.hasKey("mergeFields")) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<Object> it = RCTConvertFirebase.toArrayList(map2.getArray("mergeFields")).iterator();
                        while (it.hasNext()) {
                            arrayList.add((String) it.next());
                        }
                        transaction.set(documentForFirestore, parseReadableMap, SetOptions.mergeFields(arrayList));
                        break;
                    } else {
                        transaction.set(documentForFirestore, parseReadableMap);
                        break;
                    }
                case "DELETE":
                    transaction.delete(documentForFirestore);
                    break;
            }
        }
        return null;
    }

    static /* synthetic */ void lambda$transactionBegin$2(ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter, ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "update");
        reactNativeFirebaseEventEmitter.sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_transaction_event", createMap, reactNativeFirebaseFirestoreTransactionHandler.getAppName(), str, reactNativeFirebaseFirestoreTransactionHandler.getTransactionId()));
    }

    static /* synthetic */ void lambda$transactionBegin$4(ReactNativeFirebaseFirestoreTransactionHandler reactNativeFirebaseFirestoreTransactionHandler, ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter, String str, Task task) {
        if (reactNativeFirebaseFirestoreTransactionHandler.aborted) {
            return;
        }
        WritableMap createMap = Arguments.createMap();
        if (task.isSuccessful()) {
            createMap.putString("type", "complete");
            reactNativeFirebaseEventEmitter.sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_transaction_event", createMap, reactNativeFirebaseFirestoreTransactionHandler.getAppName(), str, reactNativeFirebaseFirestoreTransactionHandler.getTransactionId()));
            return;
        }
        createMap.putString("type", "error");
        Exception exception = task.getException();
        WritableMap createMap2 = Arguments.createMap();
        UniversalFirebaseFirestoreException universalFirebaseFirestoreException = new UniversalFirebaseFirestoreException((FirebaseFirestoreException) exception, exception.getCause());
        createMap2.putString("code", universalFirebaseFirestoreException.getCode());
        createMap2.putString("message", universalFirebaseFirestoreException.getMessage());
        createMap.putMap("error", createMap2);
        reactNativeFirebaseEventEmitter.sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_transaction_event", createMap, reactNativeFirebaseFirestoreTransactionHandler.getAppName(), str, reactNativeFirebaseFirestoreTransactionHandler.getTransactionId()));
    }
}
