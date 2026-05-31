package expo.interfaces.devmenu.items;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuItems.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u0006+"}, d2 = {"Lexpo/interfaces/devmenu/items/DevMenuAction;", "Lexpo/interfaces/devmenu/items/DevMenuScreenItem;", "Lexpo/interfaces/devmenu/items/DevMenuCallableProvider;", "actionId", "", "action", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "callable", "Lexpo/interfaces/devmenu/items/DevMenuExportedAction;", "getCallable", "()Lexpo/interfaces/devmenu/items/DevMenuExportedAction;", "detail", "getDetail", "()Lkotlin/jvm/functions/Function0;", "setDetail", "(Lkotlin/jvm/functions/Function0;)V", "glyphName", "getGlyphName", "setGlyphName", "value", "", "isAvailable", "setAvailable", "isEnabled", "setEnabled", "Lexpo/interfaces/devmenu/items/KeyCommand;", "keyCommand", "getKeyCommand", "()Lexpo/interfaces/devmenu/items/KeyCommand;", "setKeyCommand", "(Lexpo/interfaces/devmenu/items/KeyCommand;)V", "label", "getLabel", "setLabel", "exportKeyCommandModifiers", "", "getExportedType", "registerCallable", "Lexpo/interfaces/devmenu/items/DevMenuExportedCallable;", "serialize", "Landroid/os/Bundle;", "expo-dev-menu-interface_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuAction extends DevMenuScreenItem implements DevMenuCallableProvider {
    private final DevMenuExportedAction callable;
    private Function0<String> detail;
    private Function0<String> glyphName;
    private Function0<Boolean> isEnabled;
    private Function0<String> label;

    @Override // expo.interfaces.devmenu.items.DevMenuItem
    public int getExportedType() {
        return 1;
    }

    public DevMenuAction(String actionId, Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(action, "action");
        this.callable = new DevMenuExportedAction(actionId, action);
        this.isEnabled = new Function0<Boolean>() { // from class: expo.interfaces.devmenu.items.DevMenuAction$isEnabled$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        };
        this.label = new Function0<String>() { // from class: expo.interfaces.devmenu.items.DevMenuAction$label$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "";
            }
        };
        this.detail = new Function0<String>() { // from class: expo.interfaces.devmenu.items.DevMenuAction$detail$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "";
            }
        };
        this.glyphName = new Function0<String>() { // from class: expo.interfaces.devmenu.items.DevMenuAction$glyphName$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "";
            }
        };
    }

    public final DevMenuExportedAction getCallable() {
        return this.callable;
    }

    public final Function0<Boolean> isAvailable() {
        return this.callable.isAvailable();
    }

    public final void setAvailable(Function0<Boolean> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.callable.setAvailable(value);
    }

    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.isEnabled = function0;
    }

    public final Function0<String> getLabel() {
        return this.label;
    }

    public final void setLabel(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.label = function0;
    }

    public final Function0<String> getDetail() {
        return this.detail;
    }

    public final void setDetail(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.detail = function0;
    }

    public final Function0<String> getGlyphName() {
        return this.glyphName;
    }

    public final void setGlyphName(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.glyphName = function0;
    }

    public final KeyCommand getKeyCommand() {
        return this.callable.getKeyCommand();
    }

    public final void setKeyCommand(KeyCommand keyCommand) {
        this.callable.registerKeyCommand(keyCommand);
    }

    @Override // expo.interfaces.devmenu.items.DevMenuItem
    public Bundle serialize() {
        Bundle bundle;
        Bundle serialize = super.serialize();
        serialize.putString("actionId", this.callable.getId());
        serialize.putBoolean("isAvailable", isAvailable().invoke().booleanValue());
        serialize.putBoolean("isEnabled", this.isEnabled.invoke().booleanValue());
        serialize.putString("label", this.label.invoke());
        serialize.putString("detail", this.detail.invoke());
        serialize.putString("glyphName", this.glyphName.invoke());
        KeyCommand keyCommand = getKeyCommand();
        if (keyCommand != null) {
            bundle = new Bundle();
            bundle.putString("input", String.valueOf(DevMenuItemsKt.getKeyCharacterMap().getDisplayLabel(keyCommand.getCode())));
            bundle.putInt("modifiers", exportKeyCommandModifiers());
        } else {
            bundle = null;
        }
        serialize.putBundle("keyCommand", bundle);
        return serialize;
    }

    private final int exportKeyCommandModifiers() {
        KeyCommand keyCommand = getKeyCommand();
        return (keyCommand == null || !keyCommand.getWithShift()) ? 0 : 8;
    }

    @Override // expo.interfaces.devmenu.items.DevMenuCallableProvider
    public DevMenuExportedCallable registerCallable() {
        return this.callable;
    }
}
