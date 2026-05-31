package expo.interfaces.devmenu.items;

import android.os.Bundle;
import com.facebook.react.uimanager.events.TouchesHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuItems.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/interfaces/devmenu/items/DevMenuLink;", "Lexpo/interfaces/devmenu/items/DevMenuScreenItem;", TouchesHelper.TARGET_KEY, "", "(Ljava/lang/String;)V", "glyphName", "Lkotlin/Function0;", "getGlyphName", "()Lkotlin/jvm/functions/Function0;", "setGlyphName", "(Lkotlin/jvm/functions/Function0;)V", "label", "getLabel", "setLabel", "getExportedType", "", "serialize", "Landroid/os/Bundle;", "expo-dev-menu-interface_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuLink extends DevMenuScreenItem {
    private Function0<String> glyphName;
    private Function0<String> label;
    private final String target;

    @Override // expo.interfaces.devmenu.items.DevMenuItem
    public int getExportedType() {
        return 4;
    }

    public DevMenuLink(String target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.target = target;
        this.label = new Function0<String>() { // from class: expo.interfaces.devmenu.items.DevMenuLink$label$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "";
            }
        };
        this.glyphName = new Function0<String>() { // from class: expo.interfaces.devmenu.items.DevMenuLink$glyphName$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "";
            }
        };
    }

    public final Function0<String> getLabel() {
        return this.label;
    }

    public final void setLabel(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.label = function0;
    }

    public final Function0<String> getGlyphName() {
        return this.glyphName;
    }

    public final void setGlyphName(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.glyphName = function0;
    }

    @Override // expo.interfaces.devmenu.items.DevMenuItem
    public Bundle serialize() {
        Bundle serialize = super.serialize();
        serialize.putString(TouchesHelper.TARGET_KEY, this.target);
        serialize.putString("label", this.label.invoke());
        serialize.putString("glyphName", this.glyphName.invoke());
        return serialize;
    }
}
