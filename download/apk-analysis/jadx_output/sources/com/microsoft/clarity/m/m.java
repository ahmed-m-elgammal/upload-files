package com.microsoft.clarity.m;

import android.os.Trace;
import com.microsoft.clarity.e.Q;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public abstract class m {
    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.Object] */
    public static Object a(String section, Q q, Function0 code) {
        Intrinsics.checkNotNullParameter(section, "section");
        Intrinsics.checkNotNullParameter(code, "code");
        try {
            Trace.beginSection(section);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            long currentTimeMillis = System.currentTimeMillis();
            objectRef.element = code.invoke();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (q != null) {
                q.a(section, currentTimeMillis2);
            }
            return objectRef.element;
        } finally {
            Trace.endSection();
        }
    }
}
