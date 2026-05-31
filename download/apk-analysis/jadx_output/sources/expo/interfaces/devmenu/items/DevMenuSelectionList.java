package expo.interfaces.devmenu.items;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.react.bridge.ReadableMap;
import expo.interfaces.devmenu.items.DevMenuSelectionList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuItems.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fJ\u001c\u0010\u0014\u001a\u00020\u00122\u0014\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00120\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lexpo/interfaces/devmenu/items/DevMenuSelectionList;", "Lexpo/interfaces/devmenu/items/DevMenuScreenItem;", "Lexpo/interfaces/devmenu/items/DevMenuCallableProvider;", "()V", "callable", "Lexpo/interfaces/devmenu/items/DevMenuExportedFunction;", "dataSourceId", "Lkotlin/Function0;", "", "getDataSourceId", "()Lkotlin/jvm/functions/Function0;", "setDataSourceId", "(Lkotlin/jvm/functions/Function0;)V", "items", "Ljava/util/ArrayList;", "Lexpo/interfaces/devmenu/items/DevMenuSelectionList$Item;", "Lkotlin/collections/ArrayList;", "addItem", "", "item", "addOnClick", "handler", "Lkotlin/Function1;", "Lcom/facebook/react/bridge/ReadableMap;", "getExportedType", "", "registerCallable", "Lexpo/interfaces/devmenu/items/DevMenuExportedCallable;", "serialize", "Landroid/os/Bundle;", "Companion", "Item", "expo-dev-menu-interface_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuSelectionList extends DevMenuScreenItem implements DevMenuCallableProvider {
    private static int ActionID;
    private DevMenuExportedFunction callable;
    private ArrayList<Item> items = new ArrayList<>();
    private Function0<String> dataSourceId = new Function0() { // from class: expo.interfaces.devmenu.items.DevMenuSelectionList$dataSourceId$1
        @Override // kotlin.jvm.functions.Function0
        public final Void invoke() {
            return null;
        }
    };

    @Override // expo.interfaces.devmenu.items.DevMenuItem
    public int getExportedType() {
        return 5;
    }

    /* compiled from: DevMenuItems.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\nH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR&\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lexpo/interfaces/devmenu/items/DevMenuSelectionList$Item;", "Lexpo/interfaces/devmenu/items/DevMenuDataSourceItem;", "()V", "isChecked", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "setChecked", "(Lkotlin/jvm/functions/Function0;)V", "onClickData", "Landroid/os/Bundle;", "getOnClickData", "setOnClickData", "tags", "", "Lexpo/interfaces/devmenu/items/DevMenuSelectionList$Item$Tag;", "getTags", "setTags", "title", "", "getTitle", "setTitle", "warning", "getWarning", "setWarning", "serialize", "Tag", "expo-dev-menu-interface_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Item implements DevMenuDataSourceItem {
        private Function0<String> title = new Function0<String>() { // from class: expo.interfaces.devmenu.items.DevMenuSelectionList$Item$title$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "";
            }
        };
        private Function0<? extends List<Tag>> tags = new Function0<List<? extends Tag>>() { // from class: expo.interfaces.devmenu.items.DevMenuSelectionList$Item$tags$1
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends DevMenuSelectionList.Item.Tag> invoke() {
                return CollectionsKt.emptyList();
            }
        };
        private Function0<String> warning = new Function0() { // from class: expo.interfaces.devmenu.items.DevMenuSelectionList$Item$warning$1
            @Override // kotlin.jvm.functions.Function0
            public final Void invoke() {
                return null;
            }
        };
        private Function0<Boolean> isChecked = new Function0<Boolean>() { // from class: expo.interfaces.devmenu.items.DevMenuSelectionList$Item$isChecked$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        };
        private Function0<Bundle> onClickData = new Function0() { // from class: expo.interfaces.devmenu.items.DevMenuSelectionList$Item$onClickData$1
            @Override // kotlin.jvm.functions.Function0
            public final Void invoke() {
                return null;
            }
        };

        /* compiled from: DevMenuItems.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lexpo/interfaces/devmenu/items/DevMenuSelectionList$Item$Tag;", "", "()V", "glyphName", "Lkotlin/Function0;", "", "getGlyphName", "()Lkotlin/jvm/functions/Function0;", "setGlyphName", "(Lkotlin/jvm/functions/Function0;)V", "text", "getText", "setText", "serialize", "Landroid/os/Bundle;", "serialize$expo_dev_menu_interface_release", "expo-dev-menu-interface_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Tag {
            private Function0<String> glyphName = new Function0<String>() { // from class: expo.interfaces.devmenu.items.DevMenuSelectionList$Item$Tag$glyphName$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
            private Function0<String> text = new Function0<String>() { // from class: expo.interfaces.devmenu.items.DevMenuSelectionList$Item$Tag$text$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };

            public final Function0<String> getGlyphName() {
                return this.glyphName;
            }

            public final void setGlyphName(Function0<String> function0) {
                Intrinsics.checkNotNullParameter(function0, "<set-?>");
                this.glyphName = function0;
            }

            public final Function0<String> getText() {
                return this.text;
            }

            public final void setText(Function0<String> function0) {
                Intrinsics.checkNotNullParameter(function0, "<set-?>");
                this.text = function0;
            }

            public final Bundle serialize$expo_dev_menu_interface_release() {
                Bundle bundle = new Bundle();
                bundle.putString("text", this.text.invoke());
                bundle.putString("glyphName", this.glyphName.invoke());
                return bundle;
            }
        }

        public final Function0<String> getTitle() {
            return this.title;
        }

        public final void setTitle(Function0<String> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.title = function0;
        }

        public final Function0<List<Tag>> getTags() {
            return this.tags;
        }

        public final void setTags(Function0<? extends List<Tag>> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.tags = function0;
        }

        public final Function0<String> getWarning() {
            return this.warning;
        }

        public final void setWarning(Function0<String> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.warning = function0;
        }

        public final Function0<Boolean> isChecked() {
            return this.isChecked;
        }

        public final void setChecked(Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.isChecked = function0;
        }

        public final Function0<Bundle> getOnClickData() {
            return this.onClickData;
        }

        public final void setOnClickData(Function0<Bundle> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onClickData = function0;
        }

        @Override // expo.interfaces.devmenu.items.DevMenuDataSourceItem
        public Bundle serialize() {
            Bundle bundle = new Bundle();
            bundle.putString("title", this.title.invoke());
            bundle.putString("warning", this.warning.invoke());
            bundle.putBoolean("isChecked", this.isChecked.invoke().booleanValue());
            bundle.putBundle("onClickData", this.onClickData.invoke());
            List<Tag> invoke = this.tags.invoke();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(invoke, 10));
            Iterator<T> it = invoke.iterator();
            while (it.hasNext()) {
                arrayList.add(((Tag) it.next()).serialize$expo_dev_menu_interface_release());
            }
            bundle.putParcelableArray("tags", (Parcelable[]) arrayList.toArray(new Bundle[0]));
            return bundle;
        }
    }

    public final Function0<String> getDataSourceId() {
        return this.dataSourceId;
    }

    public final void setDataSourceId(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.dataSourceId = function0;
    }

    public final void addOnClick(Function1<? super ReadableMap, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        int i = ActionID;
        ActionID = i + 1;
        this.callable = new DevMenuExportedFunction("expo-dev-menu.selection-list.#" + i, handler);
    }

    public final void addItem(Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.items.add(item);
    }

    @Override // expo.interfaces.devmenu.items.DevMenuItem
    public Bundle serialize() {
        Bundle serialize = super.serialize();
        DevMenuExportedFunction devMenuExportedFunction = this.callable;
        if (devMenuExportedFunction != null) {
            serialize.putString("actionId", devMenuExportedFunction.getId());
        }
        serialize.putString("dataSourceId", this.dataSourceId.invoke());
        ArrayList<Item> arrayList = this.items;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Item) it.next()).serialize());
        }
        serialize.putParcelableArray("items", (Parcelable[]) arrayList2.toArray(new Bundle[0]));
        return serialize;
    }

    @Override // expo.interfaces.devmenu.items.DevMenuCallableProvider
    public DevMenuExportedCallable registerCallable() {
        return this.callable;
    }
}
