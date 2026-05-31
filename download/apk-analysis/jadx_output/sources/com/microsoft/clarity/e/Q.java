package com.microsoft.clarity.e;

import android.app.Activity;
import android.content.Context;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.telemetry.AggregatedMetric;
import com.microsoft.clarity.models.telemetry.ErrorDetails;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class Q implements com.microsoft.clarity.h.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f73a;
    public final String b;
    public final LinkedHashMap c;
    public final LinkedHashMap d;
    public final LinkedBlockingQueue e;
    public final LinkedHashSet f;

    public Q(Context context, String projectId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        this.f73a = context;
        this.b = projectId;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedBlockingQueue();
        a();
        this.f = new LinkedHashSet();
    }

    public static boolean c() {
        DynamicConfig dynamicConfig = com.microsoft.clarity.b.a.k;
        return dynamicConfig == null || dynamicConfig.getReportUrl() != null;
    }

    @Override // com.microsoft.clarity.h.a
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
    }

    public final void b() {
        LinkedHashMap linkedHashMap;
        double sqrt;
        Q q = this;
        if (!c()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap2 = q.c;
        synchronized (linkedHashMap2) {
            try {
                for (I i : q.c.values()) {
                    try {
                        String str = i.f65a;
                        int i2 = i.b;
                        double d = i.c;
                        double d2 = i.e;
                        double d3 = i.d;
                        if (i2 == 0) {
                            linkedHashMap = linkedHashMap2;
                            sqrt = 0.0d;
                        } else {
                            linkedHashMap = linkedHashMap2;
                            try {
                                sqrt = Math.sqrt(i.g / i2);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        arrayList.add(new AggregatedMetric("3.1.3", str, i2, d, d2, d3, sqrt, 0, 128, null));
                        q = this;
                        linkedHashMap2 = linkedHashMap;
                    } catch (Throwable th2) {
                        th = th2;
                        linkedHashMap = linkedHashMap2;
                    }
                }
                linkedHashMap = linkedHashMap2;
                try {
                    q.c.clear();
                    Unit unit = Unit.INSTANCE;
                    q.e.add(new J(new M(q, arrayList), new N(q)));
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                linkedHashMap = linkedHashMap2;
            }
        }
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void a(String name, double d) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (c()) {
            synchronized (this.c) {
                LinkedHashMap linkedHashMap = this.c;
                Object obj = linkedHashMap.get(name);
                if (obj == null) {
                    obj = new I(name);
                    linkedHashMap.put(name, obj);
                }
                ((I) obj).a(d);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void a(Exception exception, ErrorType errorType, PageMetadata pageMetadata) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (com.microsoft.clarity.m.h.a(LogLevel.Error)) {
            com.microsoft.clarity.m.h.c(exception.getMessage());
            com.microsoft.clarity.m.h.c(ExceptionsKt.stackTraceToString(exception));
        }
        if (c()) {
            synchronized (this.f) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                String message = exception.getMessage();
                ErrorDetails errorDetails = new ErrorDetails(errorType, valueOf, message != null ? StringsKt.take(message, 512) : null, StringsKt.take(ExceptionsKt.stackTraceToString(exception), RendererCapabilities.AUDIO_OFFLOAD_SUPPORT_MASK));
                int hashCode = errorDetails.hashCode();
                if (this.f.contains(Integer.valueOf(hashCode))) {
                    return;
                }
                this.f.add(Integer.valueOf(hashCode));
                Boolean USE_WORKERS = Boolean.TRUE;
                Intrinsics.checkNotNullExpressionValue(USE_WORKERS, "ENABLE_TELEMETRY_SERVICE");
                Intrinsics.checkNotNullExpressionValue(USE_WORKERS, "USE_WORKERS");
                this.e.add(new J(new O(this, errorDetails, pageMetadata), P.f72a));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final int a(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.d) {
            if (this.d.containsKey(tag)) {
                LinkedHashMap linkedHashMap = this.d;
                Object obj = linkedHashMap.get(tag);
                Intrinsics.checkNotNull(obj);
                linkedHashMap.put(tag, Integer.valueOf(((Number) obj).intValue() + 1));
                Object obj2 = this.d.get(tag);
                Intrinsics.checkNotNull(obj2);
                return ((Number) obj2).intValue();
            }
            WorkQuery build = WorkQuery.Builder.fromTags(CollectionsKt.listOf(tag)).build();
            Intrinsics.checkNotNullExpressionValue(build, "fromTags(listOf(tag)).build()");
            WorkManager workManager = WorkManager.getInstance(this.f73a);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
            this.d.put(tag, Integer.valueOf(workManager.getWorkInfos(build).get().size()));
            Object obj3 = this.d.get(tag);
            Intrinsics.checkNotNull(obj3);
            return ((Number) obj3).intValue();
        }
    }

    public final void a() {
        new Thread(new Runnable() { // from class: com.microsoft.clarity.e.Q$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Q.a(Q.this);
            }
        }).start();
    }

    public static final void a(Q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        while (true) {
            J j = (J) this$0.e.take();
            com.microsoft.clarity.m.f.a(new K(this$0, j), new L(j), (com.microsoft.clarity.g.C) null, 10);
        }
    }
}
