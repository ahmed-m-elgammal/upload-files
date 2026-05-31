package com.microsoft.clarity.m;

import android.util.Log;
import com.microsoft.clarity.e.Q;
import com.microsoft.clarity.f.o;
import com.microsoft.clarity.g.C;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.reactnative.ClarityModule;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f {
    public static /* synthetic */ void a(Function0 function0, Function1 function1, C c, int i) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            c = null;
        }
        a(function0, false, function1, (Function0) c);
    }

    public static boolean a(Function0 logic, boolean z, Function1 function1, Function0 function0) {
        Intrinsics.checkNotNullParameter(logic, "logic");
        try {
            try {
                logic.invoke();
                if (function0 == null) {
                    return true;
                }
                function0.invoke();
                return true;
            } catch (Exception e) {
                if (function1 != null) {
                    try {
                        function1.invoke(e);
                    } catch (Exception e2) {
                        LogLevel logLevel = h.f192a;
                        String message = e2.getMessage();
                        if (h.a(LogLevel.Error)) {
                            Log.e(ClarityModule.NAME, h.a(message), e2);
                        }
                    }
                }
                if (z) {
                    throw e;
                }
                if (function0 == null) {
                    return false;
                }
                function0.invoke();
                return false;
            }
        } catch (Throwable th) {
            if (function0 != null) {
                function0.invoke();
            }
            throw th;
        }
    }

    public static boolean a(Function0 logic, Function1 function1, o oVar, int i) {
        Q q = null;
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            oVar = null;
        }
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter("Clarity_UIThreadWork", "sectionName");
        try {
            q = com.microsoft.clarity.b.a.d;
        } catch (Exception unused) {
        }
        return ((Boolean) m.a("Clarity_UIThreadWork", q, new e(logic, false, function1, oVar))).booleanValue();
    }
}
