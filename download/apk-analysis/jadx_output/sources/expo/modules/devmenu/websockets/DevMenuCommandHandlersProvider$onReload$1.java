package expo.modules.devmenu.websockets;

import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import expo.interfaces.devmenu.DevMenuManagerInterface;
import expo.interfaces.devmenu.ReactHostWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuCommandHandlersProvider.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"expo/modules/devmenu/websockets/DevMenuCommandHandlersProvider$onReload$1", "Lcom/facebook/react/packagerconnection/NotificationOnlyHandler;", "onNotification", "", "params", "", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuCommandHandlersProvider$onReload$1 extends NotificationOnlyHandler {
    final /* synthetic */ DevMenuCommandHandlersProvider this$0;

    DevMenuCommandHandlersProvider$onReload$1(DevMenuCommandHandlersProvider devMenuCommandHandlersProvider) {
        this.this$0 = devMenuCommandHandlersProvider;
    }

    @Override // com.facebook.react.packagerconnection.NotificationOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
    public void onNotification(Object params) {
        DevMenuManagerInterface devMenuManagerInterface;
        devMenuManagerInterface = this.this$0.manager;
        devMenuManagerInterface.closeMenu();
        final DevMenuCommandHandlersProvider devMenuCommandHandlersProvider = this.this$0;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: expo.modules.devmenu.websockets.DevMenuCommandHandlersProvider$onReload$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DevMenuCommandHandlersProvider$onReload$1.onNotification$lambda$0(DevMenuCommandHandlersProvider.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNotification$lambda$0(DevMenuCommandHandlersProvider this$0) {
        ReactHostWrapper host;
        DevSupportManager devSupportManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        host = this$0.getHost();
        if (host == null || (devSupportManager = host.getDevSupportManager()) == null) {
            return;
        }
        devSupportManager.handleReloadJS();
    }
}
