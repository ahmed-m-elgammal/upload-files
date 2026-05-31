package com.microsoft.clarity.b;

import android.app.Application;
import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.e.C0064g;
import com.microsoft.clarity.e.C0075s;
import com.microsoft.clarity.e.C0079w;
import com.microsoft.clarity.e.ComponentCallbacks2C0081y;
import com.microsoft.clarity.e.H;
import com.microsoft.clarity.e.Q;
import com.microsoft.clarity.f.M;
import com.microsoft.clarity.f.q;
import com.microsoft.clarity.f.s;
import com.microsoft.clarity.g.C0098c;
import com.microsoft.clarity.g.C0099d;
import com.microsoft.clarity.g.InterfaceC0100e;
import com.microsoft.clarity.g.K;
import com.microsoft.clarity.g.m;
import com.microsoft.clarity.g.w;
import com.microsoft.clarity.i.v;
import com.microsoft.clarity.j.f;
import com.microsoft.clarity.k.b;
import com.microsoft.clarity.k.c;
import com.microsoft.clarity.m.d;
import com.microsoft.clarity.models.DynamicConfig;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.SentryStackTrace;
import java.io.File;
import java.util.HashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class a {
    public static m b;
    public static C0098c c;
    public static Q d;
    public static b e;
    public static C0064g f;
    public static c g;
    public static com.microsoft.clarity.j.c h;
    public static H j;
    public static DynamicConfig k;

    /* renamed from: a, reason: collision with root package name */
    public static final Object f47a = new Object();
    public static final HashMap i = new HashMap();

    public static s a(Context context, ClarityConfig config) {
        C0098c c0098c;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Application application = (Application) context;
        DynamicConfig a2 = a(context);
        Intrinsics.checkNotNull(a2);
        d = b(context, config.getProjectId());
        v vVar = new v();
        InterfaceC0100e lifecycleObserver = a(application, config);
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        synchronized (f47a) {
            if (c == null) {
                c = new C0098c(lifecycleObserver);
            }
            c0098c = c;
            Intrinsics.checkNotNull(c0098c);
        }
        w wVar = new w();
        C0099d c0099d = new C0099d();
        K k2 = !a2.getDisableWebViewCapture() ? new K(context, a2) : null;
        ComponentCallbacks2C0081y componentCallbacks2C0081y = new ComponentCallbacks2C0081y(lifecycleObserver);
        Q q = d;
        Intrinsics.checkNotNull(q);
        C0079w c0079w = new C0079w(context, q);
        com.microsoft.clarity.j.b b2 = b(application, 1);
        Q q2 = d;
        Intrinsics.checkNotNull(q2);
        Boolean ENABLE_LOCAL_SESSION_MODE = Boolean.FALSE;
        Intrinsics.checkNotNullExpressionValue(ENABLE_LOCAL_SESSION_MODE, "ENABLE_LIVE_MODE");
        Intrinsics.checkNotNullExpressionValue(ENABLE_LOCAL_SESSION_MODE, "ENABLE_LOCAL_SESSION_MODE");
        H a3 = a(application, a2.getNetworkMaxDailyDataInMB(), config.getProjectId());
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type android.app.Application");
        M m = new M(application, config, a2, b2, a3, c0079w, q2);
        Intrinsics.checkNotNullParameter(context, "context");
        C0075s c0075s = new C0075s(context, new d());
        Q q3 = d;
        Intrinsics.checkNotNull(q3);
        q qVar = new q(application, config, a2, vVar, lifecycleObserver, wVar, c0099d, k2, c0098c, q3, componentCallbacks2C0081y, c0075s);
        Q q4 = d;
        Intrinsics.checkNotNull(q4);
        return new s(context, qVar, m, q4, lifecycleObserver);
    }

    public static Q b(Context context, String projectId) {
        Q q;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        synchronized (f47a) {
            if (d == null) {
                d = new Q(context, projectId);
            }
            q = d;
            Intrinsics.checkNotNull(q);
        }
        return q;
    }

    public static com.microsoft.clarity.j.a c(Context context) {
        com.microsoft.clarity.j.c cVar;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (f47a) {
            if (h == null) {
                h = new com.microsoft.clarity.j.c(a(context, "metadata"));
            }
            cVar = h;
            Intrinsics.checkNotNull(cVar);
        }
        return cVar;
    }

    public static c d(Context context) {
        c cVar;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (f47a) {
            if (g == null) {
                g = new c(context);
            }
            cVar = g;
            Intrinsics.checkNotNull(cVar);
        }
        return cVar;
    }

    public static C0064g b(Context context) {
        C0064g c0064g;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (f47a) {
            if (f == null) {
                f = new C0064g(context);
            }
            c0064g = f;
            Intrinsics.checkNotNull(c0064g);
        }
        return c0064g;
    }

    public static com.microsoft.clarity.j.b b(Context context, int i2) {
        com.microsoft.clarity.j.b bVar;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (f47a) {
            HashMap hashMap = i;
            if (!hashMap.containsKey(Integer.valueOf(i2))) {
                hashMap.put(Integer.valueOf(i2), a(context, i2));
            }
            Object obj = hashMap.get(Integer.valueOf(i2));
            Intrinsics.checkNotNull(obj);
            bVar = (com.microsoft.clarity.j.b) obj;
        }
        return bVar;
    }

    public static InterfaceC0100e a(Application app, ClarityConfig config) {
        m mVar;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (f47a) {
            if (b == null) {
                b = new m(app, config);
            }
            mVar = b;
            Intrinsics.checkNotNull(mVar);
        }
        return mVar;
    }

    public static DynamicConfig a(Context context) {
        DynamicConfig dynamicConfig;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (f47a) {
            if (k == null && DynamicConfig.INSTANCE.isFetched(context)) {
                k = new DynamicConfig(context);
            }
            dynamicConfig = k;
        }
        return dynamicConfig;
    }

    public static H a(Context context, Long l, String projectId) {
        H h2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        synchronized (f47a) {
            if (j == null) {
                j = new H(context, l, projectId);
            }
            h2 = j;
            Intrinsics.checkNotNull(h2);
        }
        return h2;
    }

    public static com.microsoft.clarity.k.a a(Context context, C0064g networkUsageTracker, Q telemetryTracker) {
        b bVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(networkUsageTracker, "networkUsageTracker");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        synchronized (f47a) {
            if (e == null) {
                e = new b(context, a(context, "faulty_collect_requests"), telemetryTracker, networkUsageTracker);
            }
            bVar = e;
            Intrinsics.checkNotNull(bVar);
        }
        return bVar;
    }

    public static com.microsoft.clarity.l.c a(Context context, String directory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(directory, "directory");
        return new com.microsoft.clarity.l.c(context, directory, null);
    }

    public static f a(Context context, int i2) {
        if (i2 == 1) {
            com.microsoft.clarity.j.a c2 = c(context);
            com.microsoft.clarity.l.c a2 = a(context, SentryStackTrace.JsonKeys.FRAMES);
            com.microsoft.clarity.l.c a3 = a(context, "events");
            String[] paths = {"assets", DebugMeta.JsonKeys.IMAGES};
            Intrinsics.checkNotNullParameter(paths, "paths");
            char c3 = File.separatorChar;
            com.microsoft.clarity.l.c a4 = a(context, ArraysKt.joinToString$default(paths, String.valueOf(c3), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            String[] paths2 = {"assets", "typefaces"};
            Intrinsics.checkNotNullParameter(paths2, "paths");
            com.microsoft.clarity.l.c a5 = a(context, ArraysKt.joinToString$default(paths2, String.valueOf(c3), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            String[] paths3 = {"assets", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB};
            Intrinsics.checkNotNullParameter(paths3, "paths");
            return new f(c2, a2, a3, a4, a5, a(context, ArraysKt.joinToString$default(paths3, String.valueOf(c3), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
        }
        throw new com.microsoft.clarity.c.f(i2);
    }
}
