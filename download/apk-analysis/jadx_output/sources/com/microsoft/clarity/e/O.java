package com.microsoft.clarity.e;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.telemetry.ErrorDetails;
import com.microsoft.clarity.workers.ReportExceptionWorker;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes5.dex */
public final class O extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q f71a;
    public final /* synthetic */ ErrorDetails b;
    public final /* synthetic */ PageMetadata c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(Q q, ErrorDetails errorDetails, PageMetadata pageMetadata) {
        super(0);
        this.f71a = q;
        this.b = errorDetails;
        this.c = pageMetadata;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Q q = this.f71a;
        ErrorDetails errorDetails = this.b;
        PageMetadata pageMetadata = this.c;
        q.getClass();
        Intrinsics.checkNotNullParameter(errorDetails, "errorDetails");
        if (Q.c()) {
            String simpleName = Reflection.getOrCreateKotlinClass(ReportExceptionWorker.class).getSimpleName();
            Intrinsics.checkNotNull(simpleName);
            String str = simpleName + '_' + errorDetails.getErrorType();
            if (q.a(str) <= 15) {
                String json = errorDetails.toJson();
                String json2 = pageMetadata != null ? pageMetadata.toJson() : null;
                Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(ReportExceptionWorker.class);
                Pair[] pairArr = {TuplesKt.to("PAGE_METADATA", json2), TuplesKt.to("ERROR_DETAILS", json), TuplesKt.to("PROJECT_ID", q.b)};
                Data.Builder builder2 = new Data.Builder();
                for (int i = 0; i < 3; i++) {
                    Pair pair = pairArr[i];
                    builder2.put((String) pair.getFirst(), pair.getSecond());
                }
                Data build2 = builder2.build();
                Intrinsics.checkNotNullExpressionValue(build2, "dataBuilder.build()");
                WorkManager.getInstance(q.f73a).enqueue(builder.setInputData(build2).addTag(simpleName).addTag(str).addTag("ENQUEUED_AT_" + System.currentTimeMillis()).setConstraints(build).build());
            }
        }
        return Unit.INSTANCE;
    }
}
