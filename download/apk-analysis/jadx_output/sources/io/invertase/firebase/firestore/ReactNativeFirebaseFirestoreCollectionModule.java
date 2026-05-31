package io.invertase.firebase.firestore;

import android.util.SparseArray;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
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
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.AggregateQuerySnapshot;
import com.google.firebase.firestore.AggregateSource;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.sentry.protocol.SentryStackTrace;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public class ReactNativeFirebaseFirestoreCollectionModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "FirestoreCollection";
    private static SparseArray<ListenerRegistration> collectionSnapshotListeners = new SparseArray<>();

    ReactNativeFirebaseFirestoreCollectionModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        int size = collectionSnapshotListeners.size();
        for (int i = 0; i < size; i++) {
            collectionSnapshotListeners.get(collectionSnapshotListeners.keyAt(i)).remove();
        }
        collectionSnapshotListeners.clear();
    }

    @ReactMethod
    public void namedQueryOnSnapshot(final String str, final String str2, String str3, String str4, final ReadableArray readableArray, final ReadableArray readableArray2, final ReadableMap readableMap, final int i, final ReadableMap readableMap2) {
        if (collectionSnapshotListeners.get(i) != null) {
            return;
        }
        UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).getNamedQuery(str3).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreCollectionModule.this.lambda$namedQueryOnSnapshot$0(str, str2, i, readableArray, readableArray2, readableMap, readableMap2, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$namedQueryOnSnapshot$0(String str, String str2, int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, ReadableMap readableMap2, Task task) {
        if (task.isSuccessful()) {
            Query query = (Query) task.getResult();
            if (query == null) {
                sendOnSnapshotError(str, str2, i, new NullPointerException());
                return;
            } else {
                handleQueryOnSnapshot(new ReactNativeFirebaseFirestoreQuery(str, str2, query, readableArray, readableArray2, readableMap), str, str2, i, readableMap2);
                return;
            }
        }
        sendOnSnapshotError(str, str2, i, task.getException());
    }

    @ReactMethod
    public void collectionOnSnapshot(String str, String str2, String str3, String str4, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, int i, ReadableMap readableMap2) {
        if (collectionSnapshotListeners.get(i) != null) {
            return;
        }
        handleQueryOnSnapshot(new ReactNativeFirebaseFirestoreQuery(str, str2, UniversalFirebaseFirestoreCommon.getQueryForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3, str4), readableArray, readableArray2, readableMap), str, str2, i, readableMap2);
    }

    @ReactMethod
    public void collectionOffSnapshot(String str, String str2, int i) {
        ListenerRegistration listenerRegistration = collectionSnapshotListeners.get(i);
        if (listenerRegistration != null) {
            listenerRegistration.remove();
            collectionSnapshotListeners.remove(i);
            removeEventListeningExecutor(Integer.toString(i));
        }
    }

    @ReactMethod
    public void namedQueryGet(final String str, final String str2, String str3, String str4, final ReadableArray readableArray, final ReadableArray readableArray2, final ReadableMap readableMap, final ReadableMap readableMap2, final Promise promise) {
        UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).getNamedQuery(str3).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreCollectionModule.this.lambda$namedQueryGet$1(promise, str, str2, readableArray, readableArray2, readableMap, readableMap2, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$namedQueryGet$1(Promise promise, String str, String str2, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, ReadableMap readableMap2, Task task) {
        if (task.isSuccessful()) {
            Query query = (Query) task.getResult();
            if (query == null) {
                ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, new NullPointerException());
                return;
            } else {
                handleQueryGet(new ReactNativeFirebaseFirestoreQuery(str, str2, query, readableArray, readableArray2, readableMap), getSource(readableMap2), promise);
                return;
            }
        }
        ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
    }

    @ReactMethod
    public void collectionCount(String str, String str2, String str3, String str4, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, final Promise promise) {
        new ReactNativeFirebaseFirestoreQuery(str, str2, UniversalFirebaseFirestoreCommon.getQueryForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3, str4), readableArray, readableArray2, readableMap).query.count().get(AggregateSource.SERVER).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreCollectionModule.lambda$collectionCount$2(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$collectionCount$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("count", Long.valueOf(((AggregateQuerySnapshot) task.getResult()).getCount()).doubleValue());
            promise.resolve(createMap);
            return;
        }
        ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        if (r7.equals(io.sentry.protocol.MetricSummary.JsonKeys.SUM) == false) goto L10;
     */
    @com.facebook.react.bridge.ReactMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void aggregateQuery(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, com.facebook.react.bridge.ReadableArray r16, com.facebook.react.bridge.ReadableArray r17, com.facebook.react.bridge.ReadableMap r18, final com.facebook.react.bridge.ReadableArray r19, final com.facebook.react.bridge.Promise r20) {
        /*
            r11 = this;
            r0 = r19
            r1 = r20
            com.google.firebase.firestore.FirebaseFirestore r2 = io.invertase.firebase.firestore.UniversalFirebaseFirestoreCommon.getFirestoreForApp(r12, r13)
            io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreQuery r10 = new io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreQuery
            r3 = r14
            r4 = r15
            com.google.firebase.firestore.Query r6 = io.invertase.firebase.firestore.UniversalFirebaseFirestoreCommon.getQueryForFirestore(r2, r14, r15)
            r3 = r10
            r4 = r12
            r5 = r13
            r7 = r16
            r8 = r17
            r9 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            r4 = r3
        L23:
            int r5 = r19.size()
            r6 = 1
            if (r4 >= r5) goto L9a
            com.facebook.react.bridge.ReadableMap r5 = r0.getMap(r4)
            java.lang.String r7 = "aggregateType"
            java.lang.String r7 = r5.getString(r7)
            if (r7 != 0) goto L38
            java.lang.String r7 = ""
        L38:
            java.lang.String r8 = "field"
            java.lang.String r5 = r5.getString(r8)
            r7.hashCode()
            int r8 = r7.hashCode()
            r9 = -1
            switch(r8) {
                case -631448035: goto L5f;
                case 114251: goto L56;
                case 94851343: goto L4b;
                default: goto L49;
            }
        L49:
            r6 = r9
            goto L69
        L4b:
            java.lang.String r6 = "count"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L54
            goto L49
        L54:
            r6 = 2
            goto L69
        L56:
            java.lang.String r8 = "sum"
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L69
            goto L49
        L5f:
            java.lang.String r6 = "average"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L68
            goto L49
        L68:
            r6 = r3
        L69:
            switch(r6) {
                case 0: goto L90;
                case 1: goto L88;
                case 2: goto L80;
                default: goto L6c;
            }
        L6c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid AggregateType: "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "firestore/invalid-argument"
            rejectPromiseWithCodeAndMessage(r1, r2, r0)
            return
        L80:
            com.google.firebase.firestore.AggregateField$CountAggregateField r5 = com.google.firebase.firestore.AggregateField.count()
            r2.add(r5)
            goto L97
        L88:
            com.google.firebase.firestore.AggregateField$SumAggregateField r5 = com.google.firebase.firestore.AggregateField.sum(r5)
            r2.add(r5)
            goto L97
        L90:
            com.google.firebase.firestore.AggregateField$AverageAggregateField r5 = com.google.firebase.firestore.AggregateField.average(r5)
            r2.add(r5)
        L97:
            int r4 = r4 + 1
            goto L23
        L9a:
            com.google.firebase.firestore.Query r4 = r10.query
            java.lang.Object r5 = r2.get(r3)
            com.google.firebase.firestore.AggregateField r5 = (com.google.firebase.firestore.AggregateField) r5
            int r7 = r2.size()
            java.util.List r2 = r2.subList(r6, r7)
            com.google.firebase.firestore.AggregateField[] r3 = new com.google.firebase.firestore.AggregateField[r3]
            java.lang.Object[] r2 = r2.toArray(r3)
            com.google.firebase.firestore.AggregateField[] r2 = (com.google.firebase.firestore.AggregateField[]) r2
            com.google.firebase.firestore.AggregateQuery r2 = r4.aggregate(r5, r2)
            com.google.firebase.firestore.AggregateSource r3 = com.google.firebase.firestore.AggregateSource.SERVER
            com.google.android.gms.tasks.Task r2 = r2.get(r3)
            io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda1 r3 = new io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda1
            r3.<init>()
            r2.addOnCompleteListener(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule.aggregateQuery(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.Promise):void");
    }

    static /* synthetic */ void lambda$aggregateQuery$3(ReadableArray readableArray, Promise promise, Task task) {
        if (task.isSuccessful()) {
            WritableMap createMap = Arguments.createMap();
            AggregateQuerySnapshot aggregateQuerySnapshot = (AggregateQuerySnapshot) task.getResult();
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                String string = map.getString("aggregateType");
                if (string == null) {
                    string = "";
                }
                String string2 = map.getString("field");
                String string3 = map.getString(SDKConstants.PARAM_KEY);
                if (string3 == null) {
                    rejectPromiseWithCodeAndMessage(promise, "firestore/invalid-argument", "key may not be null");
                    return;
                }
                string.hashCode();
                switch (string) {
                    case "average":
                        Double d = aggregateQuerySnapshot.get(AggregateField.average(string2));
                        if (d == null) {
                            createMap.putNull(string3);
                            break;
                        } else {
                            createMap.putDouble(string3, d.doubleValue());
                            break;
                        }
                    case "sum":
                        Number number = (Number) aggregateQuerySnapshot.get(AggregateField.sum(string2));
                        if (number == null) {
                            rejectPromiseWithCodeAndMessage(promise, "firestore/unknown", "sum unexpectedly null");
                            return;
                        } else {
                            createMap.putDouble(string3, number.doubleValue());
                            break;
                        }
                    case "count":
                        createMap.putDouble(string3, Long.valueOf(aggregateQuerySnapshot.getCount()).doubleValue());
                        break;
                    default:
                        rejectPromiseWithCodeAndMessage(promise, "firestore/invalid-argument", "Invalid AggregateType: " + string);
                        return;
                }
            }
            promise.resolve(createMap);
            return;
        }
        ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
    }

    @ReactMethod
    public void collectionGet(String str, String str2, String str3, String str4, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        handleQueryGet(new ReactNativeFirebaseFirestoreQuery(str, str2, UniversalFirebaseFirestoreCommon.getQueryForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3, str4), readableArray, readableArray2, readableMap), getSource(readableMap2), promise);
    }

    private void handleQueryOnSnapshot(ReactNativeFirebaseFirestoreQuery reactNativeFirebaseFirestoreQuery, final String str, final String str2, final int i, ReadableMap readableMap) {
        MetadataChanges metadataChanges;
        if (readableMap != null && readableMap.hasKey("includeMetadataChanges") && readableMap.getBoolean("includeMetadataChanges")) {
            metadataChanges = MetadataChanges.INCLUDE;
        } else {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        final MetadataChanges metadataChanges2 = metadataChanges;
        collectionSnapshotListeners.put(i, reactNativeFirebaseFirestoreQuery.query.addSnapshotListener(metadataChanges, new EventListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda6
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                ReactNativeFirebaseFirestoreCollectionModule.this.lambda$handleQueryOnSnapshot$4(i, str, str2, metadataChanges2, (QuerySnapshot) obj, firebaseFirestoreException);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleQueryOnSnapshot$4(int i, String str, String str2, MetadataChanges metadataChanges, QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            ListenerRegistration listenerRegistration = collectionSnapshotListeners.get(i);
            if (listenerRegistration != null) {
                listenerRegistration.remove();
                collectionSnapshotListeners.remove(i);
            }
            sendOnSnapshotError(str, str2, i, firebaseFirestoreException);
            return;
        }
        sendOnSnapshotEvent(str, str2, i, querySnapshot, metadataChanges);
    }

    private void handleQueryGet(ReactNativeFirebaseFirestoreQuery reactNativeFirebaseFirestoreQuery, Source source, final Promise promise) {
        reactNativeFirebaseFirestoreQuery.get(getExecutor(), source).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreCollectionModule.lambda$handleQueryGet$5(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$handleQueryGet$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    private void sendOnSnapshotEvent(final String str, final String str2, final int i, final QuerySnapshot querySnapshot, final MetadataChanges metadataChanges) {
        Tasks.call(getTransactionalExecutor(Integer.toString(i)), new Callable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WritableMap snapshotToWritableMap;
                snapshotToWritableMap = ReactNativeFirebaseFirestoreSerialize.snapshotToWritableMap(str, str2, "onSnapshot", querySnapshot, metadataChanges);
                return snapshotToWritableMap;
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreCollectionModule.this.lambda$sendOnSnapshotEvent$7(str, str2, i, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendOnSnapshotEvent$7(String str, String str2, int i, Task task) {
        if (task.isSuccessful()) {
            WritableMap createMap = Arguments.createMap();
            createMap.putMap(SentryStackTrace.JsonKeys.SNAPSHOT, (ReadableMap) task.getResult());
            ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_collection_sync_event", createMap, str, str2, i));
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
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_collection_sync_event", createMap, str, str2, i));
    }

    private Source getSource(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("source")) {
            String string = readableMap.getString("source");
            if ("server".equals(string)) {
                return Source.SERVER;
            }
            if ("cache".equals(string)) {
                return Source.CACHE;
            }
            return Source.DEFAULT;
        }
        return Source.DEFAULT;
    }
}
