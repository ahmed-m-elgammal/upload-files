package expo.modules.devlauncher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.bridge.ReactContext;
import com.henninghall.date_picker.props.ModeProp;
import expo.interfaces.devmenu.ReactHostWrapper;
import expo.modules.devlauncher.launcher.DevLauncherAppEntry;
import expo.modules.devlauncher.launcher.DevLauncherControllerInterface;
import expo.modules.devlauncher.launcher.DevLauncherReactActivityDelegateSupplier;
import expo.modules.manifests.core.Manifest;
import expo.modules.updatesinterface.UpdatesInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DevLauncherController.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0002ABB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0016J\u001c\u00101\u001a\u00020#2\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u00010+H\u0016J*\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u000e2\b\u00107\u001a\u0004\u0018\u00010\u000e2\b\u00108\u001a\u0004\u0018\u00010+H\u0096@¢\u0006\u0002\u00109J \u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u00010+H\u0096@¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020'H\u0016J\u0010\u0010<\u001a\u00020'2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020'H\u0016J\b\u0010@\u001a\u00020'H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006C"}, d2 = {"Lexpo/modules/devlauncher/DevLauncherController;", "Lexpo/modules/devlauncher/launcher/DevLauncherControllerInterface;", "()V", "appHost", "Lexpo/interfaces/devmenu/ReactHostWrapper;", "getAppHost", "()Lexpo/interfaces/devmenu/ReactHostWrapper;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "devClientHost", "getDevClientHost", "latestLoadedApp", "Landroid/net/Uri;", "getLatestLoadedApp", "()Landroid/net/Uri;", "manifest", "Lexpo/modules/manifests/core/Manifest;", "getManifest", "()Lexpo/modules/manifests/core/Manifest;", "manifestURL", "getManifestURL", ModeProp.name, "Lexpo/modules/devlauncher/DevLauncherController$Mode;", "getMode", "()Lexpo/modules/devlauncher/DevLauncherController$Mode;", "<anonymous parameter 0>", "Lexpo/modules/updatesinterface/UpdatesInterface;", "updatesInterface", "getUpdatesInterface", "()Lexpo/modules/updatesinterface/UpdatesInterface;", "setUpdatesInterface", "(Lexpo/modules/updatesinterface/UpdatesInterface;)V", "useDeveloperSupport", "", "getUseDeveloperSupport", "()Z", "clearRecentlyOpenedApps", "", "getCurrentReactActivityDelegate", "Lcom/facebook/react/ReactActivityDelegate;", "activity", "Lcom/facebook/react/ReactActivity;", "delegateSupplierDevLauncher", "Lexpo/modules/devlauncher/launcher/DevLauncherReactActivityDelegateSupplier;", "getRecentlyOpenedApps", "", "Lexpo/modules/devlauncher/launcher/DevLauncherAppEntry;", "handleIntent", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "activityToBeInvalidated", "loadApp", "url", "projectUrl", "mainActivity", "(Landroid/net/Uri;Landroid/net/Uri;Lcom/facebook/react/ReactActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/net/Uri;Lcom/facebook/react/ReactActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateToLauncher", "onAppLoaded", "context", "Lcom/facebook/react/bridge/ReactContext;", "onAppLoadedWithError", "onRequestRelaunch", "Companion", "Mode", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherController implements DevLauncherControllerInterface {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static DevLauncherController sInstance;
    private final Uri latestLoadedApp;
    private final boolean useDeveloperSupport;

    public /* synthetic */ DevLauncherController(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final DevLauncherController getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    public static final void initialize(Context context, ReactHostWrapper reactHostWrapper, Class<?> cls) {
        INSTANCE.initialize(context, reactHostWrapper, cls);
    }

    @JvmStatic
    public static final void initialize(ReactApplication reactApplication, List<?> list, Class<?> cls) {
        INSTANCE.initialize(reactApplication, list, cls);
    }

    @JvmStatic
    public static final boolean tryToHandleIntent(ReactActivity reactActivity, Intent intent) {
        return INSTANCE.tryToHandleIntent(reactActivity, intent);
    }

    @JvmStatic
    public static final boolean wasInitialized() {
        return INSTANCE.wasInitialized();
    }

    @JvmStatic
    public static final ReactActivityDelegate wrapReactActivityDelegate(ReactActivity reactActivity, DevLauncherReactActivityDelegateSupplier devLauncherReactActivityDelegateSupplier) {
        return INSTANCE.wrapReactActivityDelegate(reactActivity, devLauncherReactActivityDelegateSupplier);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public void setUpdatesInterface(UpdatesInterface updatesInterface) {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DevLauncherController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/devlauncher/DevLauncherController$Mode;", "", "(Ljava/lang/String;I)V", "LAUNCHER", "APP", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode LAUNCHER = new Mode("LAUNCHER", 0);
        public static final Mode APP = new Mode("APP", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{LAUNCHER, APP};
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        private Mode(String str, int i) {
        }

        static {
            Mode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    private DevLauncherController() {
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public Uri getLatestLoadedApp() {
        return this.latestLoadedApp;
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public Mode getMode() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public ReactHostWrapper getDevClientHost() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public Manifest getManifest() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public Uri getManifestURL() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public ReactHostWrapper getAppHost() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public UpdatesInterface getUpdatesInterface() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.updatesinterface.UpdatesInterfaceCallbacks
    public void onRequestRelaunch() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public CoroutineScope getCoroutineScope() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public boolean getUseDeveloperSupport() {
        return this.useDeveloperSupport;
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public ReactActivityDelegate getCurrentReactActivityDelegate(ReactActivity activity, DevLauncherReactActivityDelegateSupplier delegateSupplierDevLauncher) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(delegateSupplierDevLauncher, "delegateSupplierDevLauncher");
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public boolean handleIntent(Intent intent, ReactActivity activityToBeInvalidated) {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public void navigateToLauncher() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public Object loadApp(Uri uri, ReactActivity reactActivity, Continuation<? super Unit> continuation) {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public Object loadApp(Uri uri, Uri uri2, ReactActivity reactActivity, Continuation<? super Unit> continuation) {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public void onAppLoaded(ReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public void onAppLoadedWithError() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public List<DevLauncherAppEntry> getRecentlyOpenedApps() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    @Override // expo.modules.devlauncher.launcher.DevLauncherControllerInterface
    public void clearRecentlyOpenedApps() {
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }

    /* compiled from: DevLauncherController.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\b\u000fJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0007J0\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u0017H\u0007J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0007R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lexpo/modules/devlauncher/DevLauncherController$Companion;", "", "()V", "instance", "Lexpo/modules/devlauncher/DevLauncherController;", "getInstance$annotations", "getInstance", "()Lexpo/modules/devlauncher/DevLauncherController;", "sInstance", "initialize", "", "context", "Landroid/content/Context;", "reactHost", "Lexpo/interfaces/devmenu/ReactHostWrapper;", "initialize$expo_dev_launcher_release", "launcherClass", "Ljava/lang/Class;", "reactApplication", "Lcom/facebook/react/ReactApplication;", "additionalPackages", "", "tryToHandleIntent", "", "reactActivity", "Lcom/facebook/react/ReactActivity;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "wasInitialized", "wrapReactActivityDelegate", "Lcom/facebook/react/ReactActivityDelegate;", "devLauncherReactActivityDelegateSupplier", "Lexpo/modules/devlauncher/launcher/DevLauncherReactActivityDelegateSupplier;", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @JvmStatic
        public final boolean tryToHandleIntent(ReactActivity reactActivity, Intent intent) {
            Intrinsics.checkNotNullParameter(reactActivity, "reactActivity");
            Intrinsics.checkNotNullParameter(intent, "intent");
            return false;
        }

        @JvmStatic
        public final boolean wasInitialized() {
            return false;
        }

        private Companion() {
        }

        public final DevLauncherController getInstance() {
            DevLauncherController devLauncherController = DevLauncherController.sInstance;
            if (devLauncherController != null) {
                return devLauncherController;
            }
            throw new IllegalStateException("DevelopmentClientController.getInstance() was called before the module was initialized".toString());
        }

        @JvmStatic
        public final void initialize$expo_dev_launcher_release(Context context, ReactHostWrapper reactHost) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(reactHost, "reactHost");
            if (DevLauncherController.sInstance == null) {
                DevLauncherController.sInstance = new DevLauncherController(null);
                return;
            }
            throw new IllegalStateException("DevelopmentClientController was initialized.".toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void initialize$default(Companion companion, Context context, ReactHostWrapper reactHostWrapper, Class cls, int i, Object obj) {
            if ((i & 4) != 0) {
                cls = null;
            }
            companion.initialize(context, reactHostWrapper, (Class<?>) cls);
        }

        @JvmStatic
        public final void initialize(Context context, ReactHostWrapper reactHost, Class<?> launcherClass) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(reactHost, "reactHost");
            initialize$expo_dev_launcher_release(context, reactHost);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void initialize$default(Companion companion, ReactApplication reactApplication, List list, Class cls, int i, Object obj) {
            if ((i & 2) != 0) {
                list = null;
            }
            if ((i & 4) != 0) {
                cls = null;
            }
            companion.initialize(reactApplication, (List<?>) list, (Class<?>) cls);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final void initialize(final ReactApplication reactApplication, List<?> additionalPackages, Class<?> launcherClass) {
            Intrinsics.checkNotNullParameter(reactApplication, "reactApplication");
            initialize$expo_dev_launcher_release((Context) reactApplication, new ReactHostWrapper(reactApplication.getReactNativeHost(), new Function0<ReactHost>() { // from class: expo.modules.devlauncher.DevLauncherController$Companion$initialize$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ReactHost invoke() {
                    return ReactApplication.this.getReactHost();
                }
            }));
        }

        @JvmStatic
        public final ReactActivityDelegate wrapReactActivityDelegate(ReactActivity reactActivity, DevLauncherReactActivityDelegateSupplier devLauncherReactActivityDelegateSupplier) {
            Intrinsics.checkNotNullParameter(reactActivity, "reactActivity");
            Intrinsics.checkNotNullParameter(devLauncherReactActivityDelegateSupplier, "devLauncherReactActivityDelegateSupplier");
            return devLauncherReactActivityDelegateSupplier.get();
        }
    }
}
