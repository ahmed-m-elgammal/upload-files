package com.facebook.react.runtime;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.HMRClient;
import com.facebook.react.devsupport.ReactInstanceDevHelper;
import com.facebook.react.devsupport.interfaces.DevSplitBundleCallback;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class NonFinalBridgelessDevSupportManager extends DevSupportManagerBase {
    private final ReactHostImpl mReactHost;

    public NonFinalBridgelessDevSupportManager(ReactHostImpl reactHostImpl, Context context, @Nullable String str) {
        super(context.getApplicationContext(), createInstanceDevHelper(reactHostImpl), str, true, null, null, 2, null, null, null);
        this.mReactHost = reactHostImpl;
    }

    @Override // com.facebook.react.devsupport.DevSupportManagerBase
    protected String getUniqueTag() {
        return "Bridgeless";
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void loadSplitBundleFromServer(final String str, final DevSplitBundleCallback devSplitBundleCallback) {
        fetchSplitBundleAndCreateBundleLoader(str, new DevSupportManagerBase.CallbackWithBundleLoader() { // from class: com.facebook.react.runtime.NonFinalBridgelessDevSupportManager.1
            @Override // com.facebook.react.devsupport.DevSupportManagerBase.CallbackWithBundleLoader
            public void onSuccess(JSBundleLoader jSBundleLoader) {
                NonFinalBridgelessDevSupportManager.this.mReactHost.loadBundle(jSBundleLoader).onSuccess(new Continuation<Boolean, Void>() { // from class: com.facebook.react.runtime.NonFinalBridgelessDevSupportManager.1.1
                    @Override // com.facebook.react.runtime.internal.bolts.Continuation
                    public Void then(Task<Boolean> task) {
                        if (!task.getResult().equals(Boolean.TRUE)) {
                            return null;
                        }
                        String devServerSplitBundleURL = NonFinalBridgelessDevSupportManager.this.getDevServerHelper().getDevServerSplitBundleURL(str);
                        ReactContext currentReactContext = NonFinalBridgelessDevSupportManager.this.mReactHost.getCurrentReactContext();
                        if (currentReactContext != null) {
                            ((HMRClient) currentReactContext.getJSModule(HMRClient.class)).registerBundle(devServerSplitBundleURL);
                        }
                        devSplitBundleCallback.onSuccess();
                        return null;
                    }
                });
            }

            @Override // com.facebook.react.devsupport.DevSupportManagerBase.CallbackWithBundleLoader
            public void onError(String str2, Throwable th) {
                devSplitBundleCallback.onError(str2, th);
            }
        });
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void handleReloadJS() {
        UiThreadUtil.assertOnUiThread();
        hideRedboxDialog();
        this.mReactHost.reload("BridgelessDevSupportManager.handleReloadJS()");
        isPackagerRunning(new PackagerStatusCallback() { // from class: com.facebook.react.runtime.NonFinalBridgelessDevSupportManager$$ExternalSyntheticLambda0
            @Override // com.facebook.react.devsupport.interfaces.PackagerStatusCallback
            public final void onPackagerStatusFetched(boolean z) {
                NonFinalBridgelessDevSupportManager.this.lambda$handleReloadJS$0(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleReloadJS$0(boolean z) {
        if (z) {
            return;
        }
        reloadJSFromServer(getDevServerHelper().getDevServerBundleURL((String) Assertions.assertNotNull(getJSAppBundleName())));
    }

    private static ReactInstanceDevHelper createInstanceDevHelper(final ReactHostImpl reactHostImpl) {
        return new ReactInstanceDevHelper() { // from class: com.facebook.react.runtime.NonFinalBridgelessDevSupportManager.2
            private WeakReference<ReactSurfaceImpl> logBoxSurface = new WeakReference<>(null);

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void onJSBundleLoadedFromServer() {
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void onReloadWithJSDebugger(JavaJSExecutor.Factory factory) {
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void toggleElementInspector() {
                ReactContext currentReactContext = ReactHostImpl.this.getCurrentReactContext();
                if (currentReactContext != null) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("toggleElementInspector", null);
                }
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public Activity getCurrentActivity() {
                return ReactHostImpl.this.getLastUsedActivity();
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
                throw new IllegalStateException("Not implemented for bridgeless mode");
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public View createRootView(String str) {
                Activity currentActivity = getCurrentActivity();
                if (currentActivity == null || ReactHostImpl.this.isSurfaceWithModuleNameAttached(str)) {
                    return null;
                }
                ReactSurfaceImpl createWithView = ReactSurfaceImpl.createWithView(currentActivity, str, new Bundle());
                if (str.equals("LogBox")) {
                    this.logBoxSurface = new WeakReference<>(createWithView);
                }
                createWithView.attach(ReactHostImpl.this);
                createWithView.start();
                return createWithView.getView();
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void destroyRootView(View view) {
                ReactSurfaceImpl reactSurfaceImpl = this.logBoxSurface.get();
                if (reactSurfaceImpl != null) {
                    ReactHostImpl.this.detachSurface(reactSurfaceImpl);
                    this.logBoxSurface.clear();
                }
            }
        };
    }
}
