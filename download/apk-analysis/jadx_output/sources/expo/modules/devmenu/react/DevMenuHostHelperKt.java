package expo.modules.devmenu.react;

import android.app.Application;
import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.jscexecutor.JSCExecutorFactory;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuHostHelper.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"createNonDebuggableJavaScriptExecutorFactory", "Lcom/facebook/react/bridge/JavaScriptExecutorFactory;", "application", "Landroid/app/Application;", "expo-dev-menu_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuHostHelperKt {
    public static final JavaScriptExecutorFactory createNonDebuggableJavaScriptExecutorFactory(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        SoLoader.init(application.getApplicationContext(), false);
        if (SoLoader.getLibraryPath("libjsc.so") != null) {
            String packageName = application.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            String friendlyDeviceName = AndroidInfoHelpers.getFriendlyDeviceName();
            Intrinsics.checkNotNullExpressionValue(friendlyDeviceName, "getFriendlyDeviceName(...)");
            return new JSCExecutorFactory(packageName, friendlyDeviceName);
        }
        HermesExecutorFactory hermesExecutorFactory = new HermesExecutorFactory();
        try {
            HermesExecutorFactory.class.getMethod("setEnableDebugger", Boolean.TYPE).invoke(hermesExecutorFactory, false);
        } catch (Throwable unused) {
        }
        return hermesExecutorFactory;
    }
}
