package com.microsoft.clarity.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.k.c;
import com.microsoft.clarity.m.g;
import com.microsoft.clarity.m.h;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.telemetry.ErrorDetails;
import com.microsoft.clarity.models.telemetry.ErrorReport;
import java.net.HttpURLConnection;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/ReportExceptionWorker;", "Lcom/microsoft/clarity/workers/BaseWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReportExceptionWorker extends BaseWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f217a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportExceptionWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f217a = context;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final ListenableWorker.Result a() {
        PageMetadata pageMetadata;
        h.d("Report exception worker started.");
        Object obj = a.f47a;
        c d = a.d(this.f217a);
        String string = getInputData().getString("ERROR_DETAILS");
        if (string == null) {
            ListenableWorker.Result failure = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure, "failure()");
            return failure;
        }
        String string2 = getInputData().getString("PAGE_METADATA");
        ErrorDetails errorDetails = ErrorDetails.INSTANCE.fromJson(string);
        boolean z = false;
        if (string2 == null || (pageMetadata = PageMetadata.INSTANCE.fromJson(string2)) == null) {
            String string3 = getInputData().getString("PROJECT_ID");
            if (string3 == null) {
                string3 = "DUMMY";
            }
            pageMetadata = new PageMetadata(new SessionMetadata("DUMMY", string3, "DUMMY", "DUMMY", System.currentTimeMillis(), 1, false, "https://www.clarity.ms/eus2/", null, 256, null), 0);
        }
        d.getClass();
        Intrinsics.checkNotNullParameter(errorDetails, "errorDetails");
        if (d.f183a != null) {
            ErrorReport errorReport = new ErrorReport(pageMetadata.getSessionMetadata().getVersion(), pageMetadata.getSessionMetadata().getProjectId(), pageMetadata.getSessionMetadata().getUserId(), pageMetadata.getSessionMetadata().getSessionId(), pageMetadata.getPageNum(), errorDetails.getErrorType().name(), errorDetails.getMessage(), errorDetails.getStackTrace(), errorDetails.getTimestamp(), 0, 512, null);
            HttpURLConnection a2 = g.a(d.f183a, "POST", MapsKt.emptyMap());
            g.a(a2, errorReport.toJson());
            z = g.b(a2);
        }
        if (z) {
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
        h.c(exception.getMessage());
        h.c(ExceptionsKt.stackTraceToString(exception));
    }
}
