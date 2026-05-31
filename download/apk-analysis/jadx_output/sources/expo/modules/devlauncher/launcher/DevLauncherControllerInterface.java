package expo.modules.devlauncher.launcher;

import android.content.Intent;
import android.net.Uri;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.bridge.ReactContext;
import com.henninghall.date_picker.props.ModeProp;
import expo.interfaces.devmenu.ReactHostWrapper;
import expo.modules.devlauncher.DevLauncherController;
import expo.modules.manifests.core.Manifest;
import expo.modules.updatesinterface.UpdatesInterface;
import expo.modules.updatesinterface.UpdatesInterfaceCallbacks;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DevLauncherControllerInterface.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010$\u001a\u00020%H&J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H&J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H&J\u001c\u0010/\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010)H&J,\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\r2\n\b\u0002\u00106\u001a\u0004\u0018\u00010)H¦@¢\u0006\u0002\u00107J\"\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020\r2\n\b\u0002\u00106\u001a\u0004\u0018\u00010)H¦@¢\u0006\u0002\u00108J\b\u00109\u001a\u00020%H&J\u0010\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<H&J\b\u0010=\u001a\u00020%H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006>"}, d2 = {"Lexpo/modules/devlauncher/launcher/DevLauncherControllerInterface;", "Lexpo/modules/updatesinterface/UpdatesInterfaceCallbacks;", "appHost", "Lexpo/interfaces/devmenu/ReactHostWrapper;", "getAppHost", "()Lexpo/interfaces/devmenu/ReactHostWrapper;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "devClientHost", "getDevClientHost", "latestLoadedApp", "Landroid/net/Uri;", "getLatestLoadedApp", "()Landroid/net/Uri;", "manifest", "Lexpo/modules/manifests/core/Manifest;", "getManifest", "()Lexpo/modules/manifests/core/Manifest;", "manifestURL", "getManifestURL", ModeProp.name, "Lexpo/modules/devlauncher/DevLauncherController$Mode;", "getMode", "()Lexpo/modules/devlauncher/DevLauncherController$Mode;", "updatesInterface", "Lexpo/modules/updatesinterface/UpdatesInterface;", "getUpdatesInterface", "()Lexpo/modules/updatesinterface/UpdatesInterface;", "setUpdatesInterface", "(Lexpo/modules/updatesinterface/UpdatesInterface;)V", "useDeveloperSupport", "", "getUseDeveloperSupport", "()Z", "clearRecentlyOpenedApps", "", "getCurrentReactActivityDelegate", "Lcom/facebook/react/ReactActivityDelegate;", "activity", "Lcom/facebook/react/ReactActivity;", "delegateSupplierDevLauncher", "Lexpo/modules/devlauncher/launcher/DevLauncherReactActivityDelegateSupplier;", "getRecentlyOpenedApps", "", "Lexpo/modules/devlauncher/launcher/DevLauncherAppEntry;", "handleIntent", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "activityToBeInvalidated", "loadApp", "url", "projectUrl", "mainActivity", "(Landroid/net/Uri;Landroid/net/Uri;Lcom/facebook/react/ReactActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/net/Uri;Lcom/facebook/react/ReactActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateToLauncher", "onAppLoaded", "context", "Lcom/facebook/react/bridge/ReactContext;", "onAppLoadedWithError", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DevLauncherControllerInterface extends UpdatesInterfaceCallbacks {
    void clearRecentlyOpenedApps();

    ReactHostWrapper getAppHost();

    CoroutineScope getCoroutineScope();

    ReactActivityDelegate getCurrentReactActivityDelegate(ReactActivity activity, DevLauncherReactActivityDelegateSupplier delegateSupplierDevLauncher);

    ReactHostWrapper getDevClientHost();

    Uri getLatestLoadedApp();

    Manifest getManifest();

    Uri getManifestURL();

    DevLauncherController.Mode getMode();

    List<DevLauncherAppEntry> getRecentlyOpenedApps();

    UpdatesInterface getUpdatesInterface();

    boolean getUseDeveloperSupport();

    boolean handleIntent(Intent intent, ReactActivity activityToBeInvalidated);

    Object loadApp(Uri uri, Uri uri2, ReactActivity reactActivity, Continuation<? super Unit> continuation);

    Object loadApp(Uri uri, ReactActivity reactActivity, Continuation<? super Unit> continuation);

    void navigateToLauncher();

    void onAppLoaded(ReactContext context);

    void onAppLoadedWithError();

    void setUpdatesInterface(UpdatesInterface updatesInterface);

    /* compiled from: DevLauncherControllerInterface.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object loadApp$default(DevLauncherControllerInterface devLauncherControllerInterface, Uri uri, ReactActivity reactActivity, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadApp");
            }
            if ((i & 2) != 0) {
                reactActivity = null;
            }
            return devLauncherControllerInterface.loadApp(uri, reactActivity, continuation);
        }

        public static /* synthetic */ Object loadApp$default(DevLauncherControllerInterface devLauncherControllerInterface, Uri uri, Uri uri2, ReactActivity reactActivity, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadApp");
            }
            if ((i & 4) != 0) {
                reactActivity = null;
            }
            return devLauncherControllerInterface.loadApp(uri, uri2, reactActivity, continuation);
        }
    }
}
