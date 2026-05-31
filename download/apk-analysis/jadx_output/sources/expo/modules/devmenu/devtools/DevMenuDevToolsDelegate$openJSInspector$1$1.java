package expo.modules.devmenu.devtools;

import android.util.Log;
import com.facebook.react.bridge.ReactContext;
import expo.modules.devmenu.DevMenuManager;
import expo.modules.devmenu.DevMenuUtilsKt;
import expo.modules.devmenu.api.DevMenuMetroClient;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.eac.EACTags;

/* compiled from: DevMenuDevToolsDelegate.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.devmenu.devtools.DevMenuDevToolsDelegate$openJSInspector$1$1", f = "DevMenuDevToolsDelegate.kt", i = {}, l = {EACTags.HISTORICAL_BYTES}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class DevMenuDevToolsDelegate$openJSInspector$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $metroHost;
    final /* synthetic */ ReactContext $reactContext;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DevMenuDevToolsDelegate$openJSInspector$1$1(String str, ReactContext reactContext, Continuation<? super DevMenuDevToolsDelegate$openJSInspector$1$1> continuation) {
        super(2, continuation);
        this.$metroHost = str;
        this.$reactContext = reactContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DevMenuDevToolsDelegate$openJSInspector$1$1(this.$metroHost, this.$reactContext, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DevMenuDevToolsDelegate$openJSInspector$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DevMenuMetroClient metroClient = DevMenuManager.INSTANCE.getMetroClient();
                String str = this.$metroHost;
                String packageName = this.$reactContext.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                this.label = 1;
                if (metroClient.openJSInspector(str, packageName, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            Log.w(DevMenuUtilsKt.DEV_MENU_TAG, "Unable to open js inspector: " + e.getMessage(), e);
        }
        return Unit.INSTANCE;
    }
}
