package com.microsoft.clarity.m;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class i {
    public static Class a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        HashMap hashMap = j.f193a;
        if (hashMap.get(name) == null) {
            Class<?> cls = Class.forName(name);
            Intrinsics.checkNotNullExpressionValue(cls, "forName(name)");
            hashMap.put(name, cls);
        }
        Object obj = hashMap.get(name);
        Intrinsics.checkNotNull(obj);
        return (Class) obj;
    }

    public static Method a(String cls, String method, Class... parameterTypes) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            Pair pair = new Pair(cls, method);
            HashMap hashMap = j.b;
            if (hashMap.get(pair) == null) {
                Method declaredMethod = a(cls).getDeclaredMethod(method, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
                Intrinsics.checkNotNullExpressionValue(declaredMethod, "getClass(cls).getDeclare…(method, *parameterTypes)");
                hashMap.put(pair, declaredMethod);
                Object obj = hashMap.get(pair);
                Intrinsics.checkNotNull(obj);
                ((Method) obj).setAccessible(true);
            }
            Object obj2 = hashMap.get(pair);
            Intrinsics.checkNotNull(obj2);
            return (Method) obj2;
        } catch (Exception unused) {
            return null;
        }
    }
}
