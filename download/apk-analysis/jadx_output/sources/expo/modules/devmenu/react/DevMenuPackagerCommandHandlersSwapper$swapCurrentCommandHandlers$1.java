package expo.modules.devmenu.react;

import android.util.Log;
import com.facebook.fbreact.specs.NativeDevMenuSpec;
import com.facebook.react.devsupport.DevServerHelper;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.RequestHandler;
import expo.interfaces.devmenu.ReactHostWrapper;
import expo.modules.devmenu.helpers.DevMenuReflectionExtensionsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: DevMenuPackagerCommandHandlersSwapper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.devmenu.react.DevMenuPackagerCommandHandlersSwapper$swapCurrentCommandHandlers$1", f = "DevMenuPackagerCommandHandlersSwapper.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class DevMenuPackagerCommandHandlersSwapper$swapCurrentCommandHandlers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, RequestHandler> $handlers;
    final /* synthetic */ ReactHostWrapper $reactHost;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DevMenuPackagerCommandHandlersSwapper$swapCurrentCommandHandlers$1(ReactHostWrapper reactHostWrapper, Map<String, ? extends RequestHandler> map, Continuation<? super DevMenuPackagerCommandHandlersSwapper$swapCurrentCommandHandlers$1> continuation) {
        super(2, continuation);
        this.$reactHost = reactHostWrapper;
        this.$handlers = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DevMenuPackagerCommandHandlersSwapper$swapCurrentCommandHandlers$1(this.$reactHost, this.$handlers, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DevMenuPackagerCommandHandlersSwapper$swapCurrentCommandHandlers$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LinkedHashMap linkedHashMap;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                Log.w(NativeDevMenuSpec.NAME, "Couldn't add packager command handlers to current client: " + e.getMessage(), e);
                return Unit.INSTANCE;
            }
        }
        do {
            DevSupportManager devSupportManager = this.$reactHost.getDevSupportManager();
            if (devSupportManager == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            JSPackagerClient jSPackagerClient = (JSPackagerClient) DevMenuReflectionExtensionsKt.getPrivateDeclaredFieldValue(DevServerHelper.class, "mPackagerClient", (DevServerHelper) DevMenuReflectionExtensionsKt.getPrivateDeclaredFieldValue(DevSupportManagerBase.class, "mDevServerHelper", devSupportManager));
            if (jSPackagerClient != null) {
                Map map = (Map) DevMenuReflectionExtensionsKt.getPrivateDeclaredFieldValue(JSPackagerClient.class, "mRequestHandlers", jSPackagerClient);
                if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                linkedHashMap.putAll(this.$handlers);
                DevMenuReflectionExtensionsKt.setPrivateDeclaredFieldValue(JSPackagerClient.class, "mRequestHandlers", jSPackagerClient, linkedHashMap);
                return Unit.INSTANCE;
            }
            this.label = 1;
        } while (DelayKt.delay(50L, this) != coroutine_suspended);
        return coroutine_suspended;
    }
}
