package expo.modules.devmenu.websockets;

import android.app.Activity;
import android.util.Log;
import com.facebook.fbreact.specs.NativeDevMenuSpec;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import expo.interfaces.devmenu.DevMenuManagerInterface;
import expo.interfaces.devmenu.ReactHostWrapper;
import expo.modules.devmenu.devtools.DevMenuDevToolsDelegate;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: DevMenuCommandHandlersProvider.kt */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0003\u000e\u0011\u0014\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u001a"}, d2 = {"Lexpo/modules/devmenu/websockets/DevMenuCommandHandlersProvider;", "", "manager", "Lexpo/interfaces/devmenu/DevMenuManagerInterface;", "reactHost", "Lexpo/interfaces/devmenu/ReactHostWrapper;", "(Lexpo/interfaces/devmenu/DevMenuManagerInterface;Lexpo/interfaces/devmenu/ReactHostWrapper;)V", "_host", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "host", "getHost", "()Lexpo/interfaces/devmenu/ReactHostWrapper;", "onDevCommand", "expo/modules/devmenu/websockets/DevMenuCommandHandlersProvider$onDevCommand$1", "Lexpo/modules/devmenu/websockets/DevMenuCommandHandlersProvider$onDevCommand$1;", "onDevMenu", "expo/modules/devmenu/websockets/DevMenuCommandHandlersProvider$onDevMenu$1", "Lexpo/modules/devmenu/websockets/DevMenuCommandHandlersProvider$onDevMenu$1;", "onReload", "expo/modules/devmenu/websockets/DevMenuCommandHandlersProvider$onReload$1", "Lexpo/modules/devmenu/websockets/DevMenuCommandHandlersProvider$onReload$1;", "createCommandHandlers", "", "", "Lcom/facebook/react/packagerconnection/NotificationOnlyHandler;", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuCommandHandlersProvider {
    private final WeakReference<ReactHostWrapper> _host;
    private final DevMenuManagerInterface manager;
    private final DevMenuCommandHandlersProvider$onDevCommand$1 onDevCommand;
    private final DevMenuCommandHandlersProvider$onDevMenu$1 onDevMenu;
    private final DevMenuCommandHandlersProvider$onReload$1 onReload;

    /* JADX WARN: Type inference failed for: r2v3, types: [expo.modules.devmenu.websockets.DevMenuCommandHandlersProvider$onDevMenu$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [expo.modules.devmenu.websockets.DevMenuCommandHandlersProvider$onDevCommand$1] */
    public DevMenuCommandHandlersProvider(DevMenuManagerInterface manager, ReactHostWrapper reactHost) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(reactHost, "reactHost");
        this.manager = manager;
        this._host = new WeakReference<>(reactHost);
        this.onReload = new DevMenuCommandHandlersProvider$onReload$1(this);
        this.onDevMenu = new NotificationOnlyHandler() { // from class: expo.modules.devmenu.websockets.DevMenuCommandHandlersProvider$onDevMenu$1
            @Override // com.facebook.react.packagerconnection.NotificationOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
            public void onNotification(Object params) {
                ReactHostWrapper host;
                ReactContext currentReactContext;
                Activity currentActivity;
                DevMenuManagerInterface devMenuManagerInterface;
                host = DevMenuCommandHandlersProvider.this.getHost();
                if (host == null || (currentReactContext = host.getCurrentReactContext()) == null || (currentActivity = currentReactContext.getCurrentActivity()) == null) {
                    return;
                }
                devMenuManagerInterface = DevMenuCommandHandlersProvider.this.manager;
                devMenuManagerInterface.toggleMenu(currentActivity);
            }
        };
        this.onDevCommand = new NotificationOnlyHandler() { // from class: expo.modules.devmenu.websockets.DevMenuCommandHandlersProvider$onDevCommand$1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // com.facebook.react.packagerconnection.NotificationOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
            public void onNotification(Object params) {
                ReactHostWrapper host;
                DevMenuManagerInterface devMenuManagerInterface;
                String optString;
                RCTNativeAppEventEmitter rCTNativeAppEventEmitter;
                Activity currentActivity;
                Activity currentActivity2;
                DevMenuManagerInterface devMenuManagerInterface2;
                host = DevMenuCommandHandlersProvider.this.getHost();
                if (host == null) {
                    return;
                }
                devMenuManagerInterface = DevMenuCommandHandlersProvider.this.manager;
                DevMenuDevToolsDelegate devMenuDevToolsDelegate = new DevMenuDevToolsDelegate(devMenuManagerInterface, host);
                if (!(params instanceof JSONObject) || (optString = ((JSONObject) params).optString("name")) == null) {
                    return;
                }
                switch (optString.hashCode()) {
                    case -1662852274:
                        if (optString.equals("reconnectReactDevTools")) {
                            ReactContext currentReactContext = host.getCurrentReactContext();
                            if (currentReactContext == null || (rCTNativeAppEventEmitter = (RCTNativeAppEventEmitter) currentReactContext.getJSModule(RCTNativeAppEventEmitter.class)) == null) {
                                return;
                            }
                            rCTNativeAppEventEmitter.emit("RCTDevMenuShown", null);
                            return;
                        }
                        break;
                    case -1551749425:
                        if (optString.equals("toggleElementInspector")) {
                            devMenuDevToolsDelegate.toggleElementInspector();
                            return;
                        }
                        break;
                    case -1197573762:
                        if (optString.equals("togglePerformanceMonitor")) {
                            ReactContext currentReactContext2 = host.getCurrentReactContext();
                            if (currentReactContext2 == null || (currentActivity = currentReactContext2.getCurrentActivity()) == null) {
                                return;
                            }
                            devMenuDevToolsDelegate.togglePerformanceMonitor(currentActivity);
                            return;
                        }
                        break;
                    case -934641255:
                        if (optString.equals("reload")) {
                            devMenuDevToolsDelegate.reload();
                            return;
                        }
                        break;
                    case -542401756:
                        if (optString.equals("openJSInspector")) {
                            devMenuDevToolsDelegate.openJSInspector();
                            return;
                        }
                        break;
                    case -472895200:
                        if (optString.equals("toggleDevMenu")) {
                            ReactContext currentReactContext3 = host.getCurrentReactContext();
                            if (currentReactContext3 == null || (currentActivity2 = currentReactContext3.getCurrentActivity()) == null) {
                                return;
                            }
                            devMenuManagerInterface2 = DevMenuCommandHandlersProvider.this.manager;
                            devMenuManagerInterface2.toggleMenu(currentActivity2);
                            return;
                        }
                        break;
                    case 231612244:
                        if (optString.equals("toggleRemoteDebugging")) {
                            devMenuDevToolsDelegate.toggleRemoteDebugging();
                            return;
                        }
                        break;
                }
                Log.w(NativeDevMenuSpec.NAME, "Unknown command: " + optString);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReactHostWrapper getHost() {
        return this._host.get();
    }

    public final Map<String, NotificationOnlyHandler> createCommandHandlers() {
        return MapsKt.mapOf(TuplesKt.to("reload", this.onReload), TuplesKt.to("devMenu", this.onDevMenu), TuplesKt.to("sendDevCommand", this.onDevCommand));
    }
}
