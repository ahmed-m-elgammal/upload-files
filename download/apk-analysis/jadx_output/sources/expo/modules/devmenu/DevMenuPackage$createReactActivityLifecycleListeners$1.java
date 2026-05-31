package expo.modules.devmenu;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import expo.interfaces.devmenu.ReactHostWrapper;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuPackage.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"expo/modules/devmenu/DevMenuPackage$createReactActivityLifecycleListeners$1", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuPackage$createReactActivityLifecycleListeners$1 implements ReactActivityLifecycleListener {
    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ boolean onBackPressed() {
        return ReactActivityLifecycleListener.CC.$default$onBackPressed(this);
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ void onContentChanged(Activity activity) {
        ReactActivityLifecycleListener.CC.$default$onContentChanged(this, activity);
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ void onDestroy(Activity activity) {
        ReactActivityLifecycleListener.CC.$default$onDestroy(this, activity);
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ boolean onNewIntent(Intent intent) {
        return ReactActivityLifecycleListener.CC.$default$onNewIntent(this, intent);
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ void onPause(Activity activity) {
        ReactActivityLifecycleListener.CC.$default$onPause(this, activity);
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public /* synthetic */ void onResume(Activity activity) {
        ReactActivityLifecycleListener.CC.$default$onResume(this, activity);
    }

    DevMenuPackage$createReactActivityLifecycleListeners$1() {
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public void onCreate(final Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!DevMenuManager.INSTANCE.isInitialized()) {
            DevMenuManager devMenuManager = DevMenuManager.INSTANCE;
            ComponentCallbacks2 application = activity.getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
            devMenuManager.initializeWithReactHost(new ReactHostWrapper(((ReactApplication) application).getReactNativeHost(), new Function0<ReactHost>() { // from class: expo.modules.devmenu.DevMenuPackage$createReactActivityLifecycleListeners$1$onCreate$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ReactHost invoke() {
                    ComponentCallbacks2 application2 = activity.getApplication();
                    Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
                    return ((ReactApplication) application2).getReactHost();
                }
            }));
            return;
        }
        DevMenuManager.INSTANCE.synchronizeDelegate();
    }
}
