package com.microsoft.clarity.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.k.c;
import com.microsoft.clarity.m.g;
import com.microsoft.clarity.m.h;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/ReportMetricsWorker;", "Lcom/microsoft/clarity/workers/BaseWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReportMetricsWorker extends BaseWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f218a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportMetricsWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f218a = context;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final ListenableWorker.Result a() {
        String str;
        boolean b;
        h.d("Report metric worker started.");
        Object obj = a.f47a;
        c d = a.d(this.f218a);
        String projectId = getInputData().getString("PROJECT_ID");
        if (projectId == null) {
            ListenableWorker.Result failure = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure, "failure()");
            return failure;
        }
        String metric = getInputData().getString("METRIC_DATA");
        if (metric == null) {
            ListenableWorker.Result failure2 = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure2, "failure()");
            return failure2;
        }
        d.getClass();
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(metric, "metric");
        if (d.f183a == null) {
            str = null;
        } else {
            URL url = new URL(d.f183a);
            str = url.getProtocol() + "://" + url.getHost() + IOUtils.DIR_SEPARATOR_UNIX + StringsKt.replace$default("report/project/{pid}/metrics", "{pid}", projectId, false, 4, (Object) null);
        }
        if (str == null) {
            b = false;
        } else {
            HttpURLConnection a2 = g.a(str, "POST", MapsKt.emptyMap());
            g.a(a2, metric);
            b = g.b(a2);
        }
        if (b) {
            ListenableWorker.Result success = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(success, "{\n            Result.success()\n        }");
            return success;
        }
        ListenableWorker.Result retry = ListenableWorker.Result.retry();
        Intrinsics.checkNotNullExpressionValue(retry, "{\n            Result.retry()\n        }");
        return retry;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final void a(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        String string = getInputData().getString("PROJECT_ID");
        if (string == null) {
            return;
        }
        Object obj = a.f47a;
        a.b(this.f218a, string).a(exception, ErrorType.ReportMetricsWorker, null);
    }
}
