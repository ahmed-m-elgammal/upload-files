package com.microsoft.clarity.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.e.Q;
import com.microsoft.clarity.j.c;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.PayloadMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/UploadSessionPayloadWorker;", "Lcom/microsoft/clarity/workers/BaseWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UploadSessionPayloadWorker extends BaseWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f220a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadSessionPayloadWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f220a = context;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final void a(Exception exception) {
        String string;
        Intrinsics.checkNotNullParameter(exception, "exception");
        if ((exception instanceof FileNotFoundException) || (string = getInputData().getString("PROJECT_ID")) == null) {
            return;
        }
        Object obj = a.f47a;
        Q b = a.b(this.f220a, string);
        ErrorType errorType = ErrorType.UploadSessionWorker;
        com.microsoft.clarity.j.a c = a.c(this.f220a);
        String string2 = getInputData().getString("PAYLOAD_METADATA");
        PageMetadata pageMetadata = null;
        PayloadMetadata fromJson = string2 == null ? null : PayloadMetadata.INSTANCE.fromJson(string2);
        if (fromJson != null) {
            SessionMetadata a2 = ((c) c).a(fromJson.getSessionId());
            if (a2 != null) {
                pageMetadata = new PageMetadata(a2, 0);
            }
        }
        b.a(exception, errorType, pageMetadata);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01c7  */
    @Override // com.microsoft.clarity.workers.BaseWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.work.ListenableWorker.Result a() {
        /*
            Method dump skipped, instructions count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.workers.UploadSessionPayloadWorker.a():androidx.work.ListenableWorker$Result");
    }
}
