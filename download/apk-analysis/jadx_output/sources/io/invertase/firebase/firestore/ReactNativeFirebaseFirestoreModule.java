package io.invertase.firebase.firestore;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.LoadBundleTaskProgress;
import com.google.firebase.firestore.PersistentCacheIndexManager;
import io.invertase.firebase.common.RCTConvertFirebase;
import io.invertase.firebase.common.ReactNativeFirebaseModule;

/* loaded from: classes6.dex */
public class ReactNativeFirebaseFirestoreModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Firestore";
    private final UniversalFirebaseFirestoreModule module;

    ReactNativeFirebaseFirestoreModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseFirestoreModule(reactApplicationContext, SERVICE_NAME);
    }

    @ReactMethod
    public void setLogLevel(String str) {
        if ("debug".equals(str) || "error".equals(str)) {
            FirebaseFirestore.setLoggingEnabled(true);
        } else {
            FirebaseFirestore.setLoggingEnabled(false);
        }
    }

    @ReactMethod
    public void loadBundle(String str, String str2, String str3, final Promise promise) {
        this.module.loadBundle(str, str2, str3).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreModule$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.this.lambda$loadBundle$0(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBundle$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(taskProgressToWritableMap((LoadBundleTaskProgress) task.getResult()));
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void clearPersistence(String str, String str2, final Promise promise) {
        this.module.clearPersistence(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.lambda$clearPersistence$1(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$clearPersistence$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void waitForPendingWrites(String str, String str2, final Promise promise) {
        this.module.waitForPendingWrites(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreModule$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.lambda$waitForPendingWrites$2(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$waitForPendingWrites$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void disableNetwork(String str, String str2, final Promise promise) {
        this.module.disableNetwork(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreModule$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.lambda$disableNetwork$3(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$disableNetwork$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void enableNetwork(String str, String str2, final Promise promise) {
        this.module.enableNetwork(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.lambda$enableNetwork$4(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$enableNetwork$4(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void useEmulator(String str, String str2, String str3, int i, final Promise promise) {
        this.module.useEmulator(str, str2, str3, i).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreModule$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.lambda$useEmulator$5(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$useEmulator$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void settings(String str, String str2, ReadableMap readableMap, final Promise promise) {
        this.module.settings(UniversalFirebaseFirestoreCommon.createFirestoreKey(str, str2), RCTConvertFirebase.toHashMap(readableMap)).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreModule$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.lambda$settings$6(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$settings$6(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void terminate(String str, String str2, final Promise promise) {
        this.module.terminate(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreModule$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreModule.lambda$terminate$7(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$terminate$7(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    @ReactMethod
    public void persistenceCacheIndexManager(String str, String str2, int i, Promise promise) {
        PersistentCacheIndexManager persistentCacheIndexManager = UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).getPersistentCacheIndexManager();
        if (persistentCacheIndexManager == null) {
            promise.reject("firestore/index-manager-null", "`PersistentCacheIndexManager` is not available, persistence has not been enabled for Firestore");
            return;
        }
        if (i == 0) {
            persistentCacheIndexManager.enableIndexAutoCreation();
        } else if (i == 1) {
            persistentCacheIndexManager.disableIndexAutoCreation();
        } else if (i == 2) {
            persistentCacheIndexManager.deleteAllIndexes();
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void addSnapshotsInSync(String str, String str2, int i, Promise promise) {
        this.module.addSnapshotsInSync(str, str2, i);
        promise.resolve(null);
    }

    @ReactMethod
    public void removeSnapshotsInSync(String str, String str2, int i, Promise promise) {
        this.module.removeSnapshotsInSync(str, str2, i);
        promise.resolve(null);
    }

    private WritableMap taskProgressToWritableMap(LoadBundleTaskProgress loadBundleTaskProgress) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("bytesLoaded", loadBundleTaskProgress.getBytesLoaded());
        createMap.putInt("documentsLoaded", loadBundleTaskProgress.getDocumentsLoaded());
        createMap.putDouble("totalBytes", loadBundleTaskProgress.getTotalBytes());
        createMap.putInt("totalDocuments", loadBundleTaskProgress.getTotalDocuments());
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState[loadBundleTaskProgress.getTaskState().ordinal()];
        String str = "Running";
        if (i != 1) {
            if (i == 2) {
                str = "Success";
            } else if (i == 3) {
                str = "Error";
            }
        }
        createMap.putString("taskState", str);
        return createMap;
    }

    /* renamed from: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreModule$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState;

        static {
            int[] iArr = new int[LoadBundleTaskProgress.TaskState.values().length];
            $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState = iArr;
            try {
                iArr[LoadBundleTaskProgress.TaskState.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState[LoadBundleTaskProgress.TaskState.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$LoadBundleTaskProgress$TaskState[LoadBundleTaskProgress.TaskState.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
