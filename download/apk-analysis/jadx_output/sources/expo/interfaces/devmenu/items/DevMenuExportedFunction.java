package expo.interfaces.devmenu.items;

import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ReadableMap;
import io.sentry.protocol.SentryStackFrame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuExportedCallable.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0006R\u001f\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lexpo/interfaces/devmenu/items/DevMenuExportedFunction;", "Lexpo/interfaces/devmenu/items/DevMenuExportedCallable;", "id", "", SentryStackFrame.JsonKeys.FUNCTION, "Lkotlin/Function1;", "Lcom/facebook/react/bridge/ReadableMap;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getFunction", "()Lkotlin/jvm/functions/Function1;", NotificationCompat.CATEGORY_CALL, "args", "expo-dev-menu-interface_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuExportedFunction extends DevMenuExportedCallable {
    private final Function1<ReadableMap, Unit> function;

    public final Function1<ReadableMap, Unit> getFunction() {
        return this.function;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DevMenuExportedFunction(String id, Function1<? super ReadableMap, Unit> function) {
        super(id, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final void call(ReadableMap args) {
        this.function.invoke(args);
    }
}
