package expo.interfaces.devmenu.items;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuExportedCallable.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lexpo/interfaces/devmenu/items/DevMenuExportedAction;", "Lexpo/interfaces/devmenu/items/DevMenuExportedCallable;", "id", "", "action", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "isAvailable", "", "setAvailable", "(Lkotlin/jvm/functions/Function0;)V", "keyCommand", "Lexpo/interfaces/devmenu/items/KeyCommand;", "getKeyCommand", "()Lexpo/interfaces/devmenu/items/KeyCommand;", "setKeyCommand", "(Lexpo/interfaces/devmenu/items/KeyCommand;)V", NotificationCompat.CATEGORY_CALL, "registerKeyCommand", "expo-dev-menu-interface_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuExportedAction extends DevMenuExportedCallable {
    private final Function0<Unit> action;
    private Function0<Boolean> isAvailable;
    private KeyCommand keyCommand;

    public final Function0<Unit> getAction() {
        return this.action;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevMenuExportedAction(String id, Function0<Unit> action) {
        super(id, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
        this.isAvailable = new Function0<Boolean>() { // from class: expo.interfaces.devmenu.items.DevMenuExportedAction$isAvailable$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return true;
            }
        };
    }

    public final KeyCommand getKeyCommand() {
        return this.keyCommand;
    }

    public final void setKeyCommand(KeyCommand keyCommand) {
        this.keyCommand = keyCommand;
    }

    public final Function0<Boolean> isAvailable() {
        return this.isAvailable;
    }

    public final void setAvailable(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.isAvailable = function0;
    }

    public final void registerKeyCommand(KeyCommand keyCommand) {
        this.keyCommand = keyCommand;
    }

    public final void call() {
        this.action.invoke();
    }
}
