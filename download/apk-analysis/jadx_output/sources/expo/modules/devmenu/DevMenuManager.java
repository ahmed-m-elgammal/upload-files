package expo.modules.devmenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.bridge.ReadableMap;
import com.imagepicker.Utils$$ExternalSyntheticBackport0;
import expo.interfaces.devmenu.DevMenuDelegateInterface;
import expo.interfaces.devmenu.DevMenuExtensionInterface;
import expo.interfaces.devmenu.DevMenuManagerInterface;
import expo.interfaces.devmenu.DevMenuPreferencesInterface;
import expo.interfaces.devmenu.ReactHostWrapper;
import expo.interfaces.devmenu.items.DevMenuDataSourceItem;
import expo.modules.devmenu.api.DevMenuMetroClient;
import expo.modules.manifests.core.Manifest;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DevMenuManager.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001_B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u00101J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J\b\u00105\u001a\u000206H\u0016J\u0006\u00107\u001a\u000203J\b\u00108\u001a\u0004\u0018\u000106J\n\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020(H\u0016J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u000206H\u0016J\b\u0010>\u001a\u00020?H\u0016J\u000e\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020BJ\u0018\u0010C\u001a\u00020?2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020(2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001a\u0010K\u001a\u00020(2\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020QH\u0016J\u001a\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\u000e2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u0002030.H\u0016J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u0002030.H\u0016J\u0010\u0010X\u001a\u00020(2\u0006\u0010Y\u001a\u00020?H\u0016J\u0012\u0010Z\u001a\u00020(2\b\u0010N\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010[\u001a\u00020(2\u0006\u0010\\\u001a\u00020\u0014H\u0016J\b\u0010]\u001a\u00020(H\u0016J\u0010\u0010^\u001a\u00020(2\u0006\u0010L\u001a\u00020MH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006`"}, d2 = {"Lexpo/modules/devmenu/DevMenuManager;", "Lexpo/interfaces/devmenu/DevMenuManagerInterface;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "currentManifest", "Lexpo/modules/manifests/core/Manifest;", "getCurrentManifest", "()Lexpo/modules/manifests/core/Manifest;", "setCurrentManifest", "(Lexpo/modules/manifests/core/Manifest;)V", "currentManifestURL", "", "getCurrentManifestURL", "()Ljava/lang/String;", "setCurrentManifestURL", "(Ljava/lang/String;)V", "delegate", "Lexpo/interfaces/devmenu/DevMenuDelegateInterface;", "getDelegate$expo_dev_menu_release", "()Lexpo/interfaces/devmenu/DevMenuDelegateInterface;", "setDelegate$expo_dev_menu_release", "(Lexpo/interfaces/devmenu/DevMenuDelegateInterface;)V", "metroClient", "Lexpo/modules/devmenu/api/DevMenuMetroClient;", "getMetroClient", "()Lexpo/modules/devmenu/api/DevMenuMetroClient;", "metroClient$delegate", "Lkotlin/Lazy;", "registeredCallbacks", "Ljava/util/ArrayList;", "Lexpo/modules/devmenu/DevMenuManager$Callback;", "Lkotlin/collections/ArrayList;", "getRegisteredCallbacks", "()Ljava/util/ArrayList;", "setRegisteredCallbacks", "(Ljava/util/ArrayList;)V", "closeMenu", "", "dispatchCallable", "actionId", "args", "Lcom/facebook/react/bridge/ReadableMap;", "fetchDataSource", "", "Lexpo/interfaces/devmenu/items/DevMenuDataSourceItem;", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppInfo", "Landroid/os/Bundle;", "getDevSettings", "getMenuHost", "Lexpo/interfaces/devmenu/ReactHostWrapper;", "getMenuPreferences", "getReactHost", "getSettings", "Lexpo/interfaces/devmenu/DevMenuPreferencesInterface;", "hideMenu", "initializeWithReactHost", "reactHost", "isInitialized", "", "loadFonts", "context", "Landroid/content/Context;", "onKeyEvent", "keyCode", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "openMenu", "activity", "Landroid/app/Activity;", "screen", "registerExtensionInterface", "extensionInterface", "Lexpo/interfaces/devmenu/DevMenuExtensionInterface;", "sendEventToDelegateBridge", "eventName", "eventData", "", "serializedItems", "serializedScreens", "setCanLaunchDevMenuOnStart", "canLaunchDevMenuOnStart", "setCurrentScreen", "setDelegate", "newDelegate", "synchronizeDelegate", "toggleMenu", "Callback", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuManager implements DevMenuManagerInterface {
    private static Manifest currentManifest;
    private static String currentManifestURL;
    private static DevMenuDelegateInterface delegate;
    public static final DevMenuManager INSTANCE = new DevMenuManager();
    private static ArrayList<Callback> registeredCallbacks = new ArrayList<>();

    /* renamed from: metroClient$delegate, reason: from kotlin metadata */
    private static final Lazy metroClient = LazyKt.lazy(new Function0() { // from class: expo.modules.devmenu.DevMenuManager$metroClient$2
        @Override // kotlin.jvm.functions.Function0
        public final Void invoke() {
            throw new IllegalStateException("DevMenu isn't available in release builds");
        }
    });

    public final ReactHostWrapper getReactHost() {
        return null;
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void initializeWithReactHost(ReactHostWrapper reactHost) {
        Intrinsics.checkNotNullParameter(reactHost, "reactHost");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public boolean onKeyEvent(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void onTouchEvent(MotionEvent ev) {
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void registerExtensionInterface(DevMenuExtensionInterface extensionInterface) {
        Intrinsics.checkNotNullParameter(extensionInterface, "extensionInterface");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void setDelegate(DevMenuDelegateInterface newDelegate) {
        Intrinsics.checkNotNullParameter(newDelegate, "newDelegate");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void synchronizeDelegate() {
    }

    private DevMenuManager() {
    }

    public final DevMenuDelegateInterface getDelegate$expo_dev_menu_release() {
        return delegate;
    }

    public final void setDelegate$expo_dev_menu_release(DevMenuDelegateInterface devMenuDelegateInterface) {
        delegate = devMenuDelegateInterface;
    }

    public final Manifest getCurrentManifest() {
        return currentManifest;
    }

    public final void setCurrentManifest(Manifest manifest) {
        currentManifest = manifest;
    }

    public final String getCurrentManifestURL() {
        return currentManifestURL;
    }

    public final void setCurrentManifestURL(String str) {
        currentManifestURL = str;
    }

    /* compiled from: DevMenuManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lexpo/modules/devmenu/DevMenuManager$Callback;", "", "name", "", "shouldCollapse", "", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getShouldCollapse", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Callback {
        private final String name;
        private final boolean shouldCollapse;

        public static /* synthetic */ Callback copy$default(Callback callback, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = callback.name;
            }
            if ((i & 2) != 0) {
                z = callback.shouldCollapse;
            }
            return callback.copy(str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShouldCollapse() {
            return this.shouldCollapse;
        }

        public final Callback copy(String name, boolean shouldCollapse) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Callback(name, shouldCollapse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Callback)) {
                return false;
            }
            Callback callback = (Callback) other;
            return Intrinsics.areEqual(this.name, callback.name) && this.shouldCollapse == callback.shouldCollapse;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + Utils$$ExternalSyntheticBackport0.m(this.shouldCollapse);
        }

        public String toString() {
            return "Callback(name=" + this.name + ", shouldCollapse=" + this.shouldCollapse + ")";
        }

        public Callback(String name, boolean z) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.shouldCollapse = z;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getShouldCollapse() {
            return this.shouldCollapse;
        }
    }

    public final ArrayList<Callback> getRegisteredCallbacks() {
        return registeredCallbacks;
    }

    public final void setRegisteredCallbacks(ArrayList<Callback> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        registeredCallbacks = arrayList;
    }

    public final Bundle getAppInfo() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    public final Bundle getDevSettings() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    public final DevMenuMetroClient getMetroClient() {
        metroClient.getValue();
        throw new KotlinNothingValueException();
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void openMenu(Activity activity, String screen) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void closeMenu() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void hideMenu() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void toggleMenu(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void dispatchCallable(String actionId, ReadableMap args) {
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public List<Bundle> serializedItems() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public List<Bundle> serializedScreens() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public DevMenuPreferencesInterface getSettings() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    public final Bundle getMenuPreferences() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public ReactHostWrapper getMenuHost() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void setCurrentScreen(String screen) {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void setCanLaunchDevMenuOnStart(boolean canLaunchDevMenuOnStart) {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public void sendEventToDelegateBridge(String eventName, Object eventData) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public boolean isInitialized() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public Object fetchDataSource(String str, Continuation<? super List<? extends DevMenuDataSourceItem>> continuation) {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    public final void loadFonts(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }

    @Override // expo.interfaces.devmenu.DevMenuManagerInterface
    public CoroutineScope getCoroutineScope() {
        throw new IllegalStateException("DevMenu isn't available in release builds");
    }
}
