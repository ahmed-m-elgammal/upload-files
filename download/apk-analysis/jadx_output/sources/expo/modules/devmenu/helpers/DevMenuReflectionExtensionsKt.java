package expo.modules.devmenu.helpers;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuReflectionExtensions.kt */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0007\u001a7\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"getPrivateDeclaredFieldValue", "R", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "filedName", "", "obj", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "setPrivateDeclaredFieldValue", "", "newValue", "", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "expo-dev-menu_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuReflectionExtensionsKt {
    public static final <T, R> R getPrivateDeclaredFieldValue(Class<? extends T> cls, String filedName, T t) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(filedName, "filedName");
        Field declaredField = cls.getDeclaredField(filedName);
        declaredField.setAccessible(true);
        return (R) declaredField.get(t);
    }

    public static final <T> void setPrivateDeclaredFieldValue(Class<? extends T> cls, String filedName, T t, Object newValue) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(filedName, "filedName");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        Field declaredField = cls.getDeclaredField(filedName);
        Field declaredField2 = Field.class.getDeclaredField("accessFlags");
        declaredField.setAccessible(true);
        declaredField2.setAccessible(true);
        declaredField2.setInt(declaredField, declaredField.getModifiers() & (-17));
        declaredField.set(t, newValue);
    }
}
