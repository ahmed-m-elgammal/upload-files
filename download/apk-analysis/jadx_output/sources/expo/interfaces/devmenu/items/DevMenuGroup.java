package expo.interfaces.devmenu.items;

import android.os.Bundle;
import com.facebook.react.uimanager.events.TouchesHelper;
import io.sentry.Session;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuItems.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\rH\u0096\u0001J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0096\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0096\u0001J\"\u0010\u0013\u001a\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\rH\u0096\u0001J*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\rH\u0096\u0001J\"\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\rH\u0096\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, d2 = {"Lexpo/interfaces/devmenu/items/DevMenuGroup;", "Lexpo/interfaces/devmenu/items/DevMenuScreenItem;", "Lexpo/interfaces/devmenu/items/DevMenuDSLItemsContainerInterface;", "itemsContainer", "(Lexpo/interfaces/devmenu/items/DevMenuDSLItemsContainerInterface;)V", "action", "Lexpo/interfaces/devmenu/items/DevMenuAction;", "actionId", "", "Lkotlin/Function0;", "", Session.JsonKeys.INIT, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getAllItems", "", "getExportedType", "", "getRootItems", "group", "link", "Lexpo/interfaces/devmenu/items/DevMenuLink;", TouchesHelper.TARGET_KEY, "selectionList", "Lexpo/interfaces/devmenu/items/DevMenuSelectionList;", "serialize", "Landroid/os/Bundle;", "expo-dev-menu-interface_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuGroup extends DevMenuScreenItem implements DevMenuDSLItemsContainerInterface {
    private final /* synthetic */ DevMenuDSLItemsContainerInterface $$delegate_0;

    /* JADX WARN: Multi-variable type inference failed */
    public DevMenuGroup() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // expo.interfaces.devmenu.items.DevMenuDSLItemsContainerInterface
    public DevMenuAction action(String actionId, Function0<Unit> action, Function1<? super DevMenuAction, Unit> init) {
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(init, "init");
        return this.$$delegate_0.action(actionId, action, init);
    }

    @Override // expo.interfaces.devmenu.items.DevMenuItemsContainerInterface
    public List<DevMenuScreenItem> getAllItems() {
        return this.$$delegate_0.getAllItems();
    }

    @Override // expo.interfaces.devmenu.items.DevMenuItem
    public int getExportedType() {
        return 2;
    }

    @Override // expo.interfaces.devmenu.items.DevMenuItemsContainerInterface
    public List<DevMenuScreenItem> getRootItems() {
        return this.$$delegate_0.getRootItems();
    }

    @Override // expo.interfaces.devmenu.items.DevMenuDSLItemsContainerInterface
    public DevMenuGroup group(Function1<? super DevMenuGroup, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        return this.$$delegate_0.group(init);
    }

    @Override // expo.interfaces.devmenu.items.DevMenuDSLItemsContainerInterface
    public DevMenuLink link(String target, Function1<? super DevMenuLink, Unit> init) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(init, "init");
        return this.$$delegate_0.link(target, init);
    }

    @Override // expo.interfaces.devmenu.items.DevMenuDSLItemsContainerInterface
    public DevMenuSelectionList selectionList(Function1<? super DevMenuSelectionList, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        return this.$$delegate_0.selectionList(init);
    }

    public /* synthetic */ DevMenuGroup(DevMenuItemsContainer devMenuItemsContainer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DevMenuItemsContainer() : devMenuItemsContainer);
    }

    public DevMenuGroup(DevMenuDSLItemsContainerInterface itemsContainer) {
        Intrinsics.checkNotNullParameter(itemsContainer, "itemsContainer");
        this.$$delegate_0 = itemsContainer;
    }

    @Override // expo.interfaces.devmenu.items.DevMenuItem
    public Bundle serialize() {
        Bundle serialize = super.serialize();
        serialize.putParcelableArray("items", DevMenuItemsContainerInterfaceKt.serializeItems(this));
        return serialize;
    }
}
