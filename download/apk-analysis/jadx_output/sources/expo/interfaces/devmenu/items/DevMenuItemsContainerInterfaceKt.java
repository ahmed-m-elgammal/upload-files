package expo.interfaces.devmenu.items;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import io.sentry.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuItemsContainerInterface.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u001a\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u000bH\u0086\b\u001a\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u000b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"screen", "Lexpo/interfaces/devmenu/items/DevMenuScreen;", "name", "", Session.JsonKeys.INIT, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "getItemsOfType", "", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/interfaces/devmenu/items/DevMenuItemsContainerInterface;", "serializeItems", "", "Landroid/os/Bundle;", "(Lexpo/interfaces/devmenu/items/DevMenuItemsContainerInterface;)[Landroid/os/Bundle;", "expo-dev-menu-interface_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuItemsContainerInterfaceKt {
    public static final Bundle[] serializeItems(DevMenuItemsContainerInterface devMenuItemsContainerInterface) {
        Intrinsics.checkNotNullParameter(devMenuItemsContainerInterface, "<this>");
        List<DevMenuScreenItem> rootItems = devMenuItemsContainerInterface.getRootItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(rootItems, 10));
        Iterator<T> it = rootItems.iterator();
        while (it.hasNext()) {
            arrayList.add(((DevMenuScreenItem) it.next()).serialize());
        }
        return (Bundle[]) arrayList.toArray(new Bundle[0]);
    }

    public static final /* synthetic */ <T> List<T> getItemsOfType(DevMenuItemsContainerInterface devMenuItemsContainerInterface) {
        Intrinsics.checkNotNullParameter(devMenuItemsContainerInterface, "<this>");
        List<DevMenuScreenItem> allItems = devMenuItemsContainerInterface.getAllItems();
        ArrayList arrayList = new ArrayList();
        for (T t : allItems) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (t instanceof Object) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final DevMenuScreen screen(String name, Function1<? super DevMenuScreen, Unit> init) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(init, "init");
        DevMenuScreen devMenuScreen = new DevMenuScreen(name, null, 2, null);
        init.invoke(devMenuScreen);
        return devMenuScreen;
    }
}
