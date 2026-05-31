package expo.modules.devlauncher.helpers;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherReflectionExtensions.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a3\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u0002H\u00022\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\n\u001aM\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u0002H\u00022\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"getFieldInClassHierarchy", "Ljava/lang/reflect/Field;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "fieldName", "", "getProtectedFieldValue", "U", "obj", "filedName", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "setProtectedDeclaredField", "", "newValue", "", "predicate", "Lkotlin/Function1;", "", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "expo-dev-launcher_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherReflectionExtensionsKt {
    public static final <T> Field getFieldInClassHierarchy(Class<T> cls, String fieldName) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Field field = null;
        while (cls != null && field == null) {
            try {
                field = cls.getDeclaredField(fieldName);
            } catch (Exception unused) {
            }
            cls = cls.getSuperclass();
        }
        return field;
    }

    public static /* synthetic */ void setProtectedDeclaredField$default(Class cls, Object obj, String str, Object obj2, Function1 function1, int i, Object obj3) {
        if ((i & 8) != 0) {
            function1 = new Function1<Object, Boolean>() { // from class: expo.modules.devlauncher.helpers.DevLauncherReflectionExtensionsKt$setProtectedDeclaredField$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj4) {
                    return true;
                }
            };
        }
        setProtectedDeclaredField(cls, obj, str, obj2, function1);
    }

    public static final <T> void setProtectedDeclaredField(Class<? extends T> cls, T t, String filedName, Object newValue, Function1<Object, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(filedName, "filedName");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Field declaredField = cls.getDeclaredField(filedName);
        Field declaredField2 = Field.class.getDeclaredField("accessFlags");
        declaredField.setAccessible(true);
        declaredField2.setAccessible(true);
        declaredField2.setInt(declaredField, declaredField.getModifiers() & (-17));
        if (predicate.invoke(declaredField.get(t)).booleanValue()) {
            declaredField.set(t, newValue);
        }
    }

    public static final <T, U> U getProtectedFieldValue(Class<? extends T> cls, T t, String filedName) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(filedName, "filedName");
        Field declaredField = cls.getDeclaredField(filedName);
        declaredField.setAccessible(true);
        return (U) declaredField.get(t);
    }
}
