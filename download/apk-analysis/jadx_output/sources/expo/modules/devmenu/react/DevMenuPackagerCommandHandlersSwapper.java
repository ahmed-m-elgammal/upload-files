package expo.modules.devmenu.react;

import android.util.Log;
import com.facebook.fbreact.specs.NativeDevMenuSpec;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.packagerconnection.RequestHandler;
import expo.interfaces.devmenu.ReactHostWrapper;
import expo.modules.devmenu.DevMenuManager;
import expo.modules.devmenu.helpers.DevMenuReflectionExtensionsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: DevMenuPackagerCommandHandlersSwapper.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¨\u0006\f"}, d2 = {"Lexpo/modules/devmenu/react/DevMenuPackagerCommandHandlersSwapper;", "", "()V", "swapCurrentCommandHandlers", "", "reactHost", "Lexpo/interfaces/devmenu/ReactHostWrapper;", "handlers", "", "", "Lcom/facebook/react/packagerconnection/RequestHandler;", "swapPackagerCommandHandlers", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuPackagerCommandHandlersSwapper {
    public final void swapPackagerCommandHandlers(ReactHostWrapper reactHost, Map<String, ? extends RequestHandler> handlers) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(reactHost, "reactHost");
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        try {
            DevSupportManager devSupportManager = reactHost.getDevSupportManager();
            if (devSupportManager == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            if (devSupportManager instanceof DevSupportManagerBase) {
                Map map = (Map) DevMenuReflectionExtensionsKt.getPrivateDeclaredFieldValue(DevSupportManagerBase.class, "mCustomPackagerCommandHandlers", devSupportManager);
                if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                linkedHashMap.putAll(handlers);
                DevMenuReflectionExtensionsKt.setPrivateDeclaredFieldValue(DevSupportManagerBase.class, "mCustomPackagerCommandHandlers", devSupportManager, linkedHashMap);
                swapCurrentCommandHandlers(reactHost, handlers);
            }
        } catch (Exception e) {
            Log.w(NativeDevMenuSpec.NAME, "Couldn't add packager command handlers to current client: " + e.getMessage(), e);
        }
    }

    private final void swapCurrentCommandHandlers(ReactHostWrapper reactHost, Map<String, ? extends RequestHandler> handlers) {
        BuildersKt__Builders_commonKt.launch$default(DevMenuManager.INSTANCE.getCoroutineScope(), null, null, new DevMenuPackagerCommandHandlersSwapper$swapCurrentCommandHandlers$1(reactHost, handlers, null), 3, null);
    }
}
