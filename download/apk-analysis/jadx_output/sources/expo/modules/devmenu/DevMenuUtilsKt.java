package expo.modules.devmenu;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.ReactPackage;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a=\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\n\u001a2\u0010\u000b\u001a\u0002H\u0003\"\u0006\b\u0000\u0010\u0003\u0018\u00012\u0006\u0010\f\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u000f\u001a9\u0010\u0010\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0011\u001a\u00020\u00012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\u0012\u001a\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0001\u001a*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"DEV_MENU_TAG", "", "constructFromClass", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "argsType", "", "args", "", "(Ljava/lang/Class;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "getPrivateFiled", "obj", "objClass", "field", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "getVendoredClass", "className", "(Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "getVendoredPackage", "Lcom/facebook/react/ReactPackage;", "setPrivateField", "", "newValue", "expo-dev-menu_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuUtilsKt {
    public static final String DEV_MENU_TAG = "ExpoDevMenu";

    public static final <T> T getVendoredClass(String className, Class<?>[] argsType, Object[] args) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(argsType, "argsType");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            cls = Class.forName("devmenu." + className);
        } catch (ClassNotFoundException unused) {
            cls = Class.forName(className);
        }
        Intrinsics.checkNotNull(cls);
        return (T) constructFromClass(cls, argsType, args);
    }

    public static final <T> T constructFromClass(Class<?> clazz, Class<?>[] argsType, Object[] args) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(argsType, "argsType");
        Intrinsics.checkNotNullParameter(args, "args");
        return (T) clazz.getConstructor((Class[]) Arrays.copyOf(argsType, argsType.length)).newInstance(Arrays.copyOf(args, args.length));
    }

    public static final void setPrivateField(Object obj, Class<?> objClass, String field, Object newValue) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(objClass, "objClass");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        Field declaredField = objClass.getDeclaredField(field);
        declaredField.setAccessible(true);
        declaredField.set(obj, newValue);
    }

    public static final /* synthetic */ <T> T getPrivateFiled(Object obj, Class<?> objClass, String field) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(objClass, "objClass");
        Intrinsics.checkNotNullParameter(field, "field");
        Field declaredField = objClass.getDeclaredField(field);
        declaredField.setAccessible(true);
        T t = (T) declaredField.get(obj);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final ReactPackage getVendoredPackage(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return (ReactPackage) getVendoredClass(className, new Class[0], new Object[0]);
    }
}
