package expo.modules.devlauncher;

import android.content.Context;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import expo.modules.core.interfaces.ApplicationLifecycleListener;
import expo.modules.core.interfaces.ReactActivityHandler;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherPackageDelegate.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\u0013"}, d2 = {"Lexpo/modules/devlauncher/DevLauncherPackageDelegate;", "", "()V", "createApplicationLifecycleListeners", "", "Lexpo/modules/core/interfaces/ApplicationLifecycleListener;", "context", "Landroid/content/Context;", "createNativeModules", "Lcom/facebook/react/bridge/NativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createReactActivityHandlers", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "activityContext", "createReactActivityLifecycleListeners", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "createReactNativeHostHandlers", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherPackageDelegate {
    public static final DevLauncherPackageDelegate INSTANCE = new DevLauncherPackageDelegate();

    private DevLauncherPackageDelegate() {
    }

    public final List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.emptyList();
    }

    public final List<ApplicationLifecycleListener> createApplicationLifecycleListeners(Context context) {
        return CollectionsKt.emptyList();
    }

    public final List<ReactActivityLifecycleListener> createReactActivityLifecycleListeners(Context activityContext) {
        return CollectionsKt.emptyList();
    }

    public final List<ReactActivityHandler> createReactActivityHandlers(Context activityContext) {
        return CollectionsKt.emptyList();
    }

    public final List<ReactNativeHostHandler> createReactNativeHostHandlers(Context context) {
        return CollectionsKt.emptyList();
    }
}
