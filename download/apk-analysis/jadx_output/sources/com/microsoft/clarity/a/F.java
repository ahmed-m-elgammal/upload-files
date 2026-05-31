package com.microsoft.clarity.a;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.e.Q;
import com.microsoft.clarity.g.EnumC0101f;
import com.microsoft.clarity.g.InterfaceC0100e;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public static com.microsoft.clarity.f.s f18a;
    public static boolean b;
    public static int c;
    public static ClarityConfig d;
    public static String g;
    public static String h;
    public static String k;
    public static Function1 l;
    public static boolean m;
    public static Function1 n;
    public static boolean o;
    public static final ArrayList e = new ArrayList();
    public static final ArrayList f = new ArrayList();
    public static final LinkedHashMap i = new LinkedHashMap();
    public static final ArrayList j = new ArrayList();
    public static final Object p = new Object();

    public static boolean a(String customUserId) {
        Intrinsics.checkNotNullParameter(customUserId, "customUserId");
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.d("Setting custom user id to " + customUserId + '.');
        if (StringsKt.isBlank(customUserId)) {
            com.microsoft.clarity.m.h.c("Custom user id cannot be blank.");
            return false;
        }
        if (customUserId.length() <= 255) {
            return com.microsoft.clarity.m.f.a(new v(customUserId), w.f43a, (com.microsoft.clarity.f.o) null, 26);
        }
        com.microsoft.clarity.m.h.c("Custom user id length cannot exceed 255 characters.");
        return false;
    }

    public static final boolean a() {
        IntRange intRange = new IntRange(29, 35);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        int i2 = Build.VERSION.SDK_INT;
        return first <= i2 && i2 <= last;
    }

    public static void a(final Application application, final ClarityConfig clarityConfig, Activity activity) {
        d = clarityConfig;
        final InterfaceC0100e a2 = com.microsoft.clarity.b.a.a(application, clarityConfig);
        if (activity != null) {
            com.microsoft.clarity.g.m mVar = (com.microsoft.clarity.g.m) a2;
            mVar.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            mVar.c.put(Integer.valueOf(activity.hashCode()), EnumC0101f.ON_RESUME);
            mVar.d = new WeakReference(activity);
        }
        new Thread(new Runnable() { // from class: com.microsoft.clarity.a.F$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                F.a(application, clarityConfig, a2);
            }
        }).start();
    }

    public static final void a(Application context, ClarityConfig config, InterfaceC0100e lifecycleObserver) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(lifecycleObserver, "$lifecycleObserver");
        com.microsoft.clarity.m.f.a(new C0057h(context, config, lifecycleObserver), i.f29a, (com.microsoft.clarity.g.C) null, 10);
    }

    public static final void a(Exception exception, ErrorType errorType) {
        com.microsoft.clarity.f.s sVar = f18a;
        if (sVar != null) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            Intrinsics.checkNotNullParameter(errorType, "errorType");
            sVar.c.a(exception, errorType, sVar.b.c());
        } else {
            Q q = com.microsoft.clarity.b.a.d;
            if (q != null) {
                q.a(exception, errorType, null);
            }
            if (q == null) {
                com.microsoft.clarity.m.h.c(exception.toString());
            }
        }
    }
}
