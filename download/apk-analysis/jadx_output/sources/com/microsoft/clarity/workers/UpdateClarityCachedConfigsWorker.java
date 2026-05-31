package com.microsoft.clarity.workers;

import android.content.Context;
import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.k.b;
import com.microsoft.clarity.m.g;
import com.microsoft.clarity.m.h;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.ingest.IngestConfigs;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/UpdateClarityCachedConfigsWorker;", "Lcom/microsoft/clarity/workers/BaseWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpdateClarityCachedConfigsWorker extends BaseWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f219a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateClarityCachedConfigsWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f219a = context;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final ListenableWorker.Result a() {
        IngestConfigs ingestConfigs;
        h.d("Update Clarity config worker started.");
        String projectId = getInputData().getString("PROJECT_ID");
        if (projectId == null) {
            ListenableWorker.Result failure = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure, "failure()");
            return failure;
        }
        Context context = this.f219a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        b bVar = (b) a.a(context, a.b(context), a.b(context, projectId));
        bVar.getClass();
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        String uri = Uri.parse("https://www.clarity.ms/").buildUpon().appendPath("tag").appendPath("mobile").appendPath(projectId).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "parse(BuildConfig.API_BA…)\n            .toString()");
        HttpURLConnection a2 = g.a(uri, ShareTarget.METHOD_GET, MapsKt.emptyMap());
        try {
            a2.connect();
            String a3 = g.a(a2);
            if (a2.getResponseCode() != 200) {
                a2.disconnect();
                ingestConfigs = null;
            } else {
                bVar.a("Clarity_TagBytes", a3.length());
                bVar.d.a(a3.length());
                IngestConfigs fromJson = IngestConfigs.INSTANCE.fromJson(a3);
                a2.disconnect();
                ingestConfigs = fromJson;
            }
            if (ingestConfigs != null) {
                DynamicConfig.INSTANCE.updateSharedPreferences(context, ingestConfigs);
            }
            ListenableWorker.Result success = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(success, "success()");
            return success;
        } catch (Throwable th) {
            a2.disconnect();
            throw th;
        }
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final void a(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        String string = getInputData().getString("PROJECT_ID");
        if (string == null) {
            return;
        }
        Object obj = a.f47a;
        a.b(this.f219a, string).a(exception, ErrorType.UpdateClarityCachedConfigsWorker, null);
    }
}
