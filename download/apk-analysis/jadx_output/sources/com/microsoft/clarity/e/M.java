package com.microsoft.clarity.e;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.microsoft.clarity.models.telemetry.AggregatedMetric;
import com.microsoft.clarity.workers.ReportMetricsWorker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public final class M extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q f69a;
    public final /* synthetic */ ArrayList b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(Q q, ArrayList arrayList) {
        super(0);
        this.f69a = q;
        this.b = arrayList;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Q q = this.f69a;
        ArrayList metrics = this.b;
        q.getClass();
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (Q.c() && !metrics.isEmpty()) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(metrics, 10));
            Iterator it = metrics.iterator();
            while (it.hasNext()) {
                arrayList.add(((AggregatedMetric) it.next()).toJsonObject());
            }
            String jSONArray = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(metrics.map { …sonObject() }).toString()");
            String simpleName = Reflection.getOrCreateKotlinClass(ReportMetricsWorker.class).getSimpleName();
            Intrinsics.checkNotNull(simpleName);
            if (q.a(simpleName) <= 50) {
                Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(ReportMetricsWorker.class);
                Pair[] pairArr = {TuplesKt.to("PROJECT_ID", q.b), TuplesKt.to("METRIC_DATA", jSONArray)};
                Data.Builder builder2 = new Data.Builder();
                for (int i = 0; i < 2; i++) {
                    Pair pair = pairArr[i];
                    builder2.put((String) pair.getFirst(), pair.getSecond());
                }
                Data build2 = builder2.build();
                Intrinsics.checkNotNullExpressionValue(build2, "dataBuilder.build()");
                WorkManager.getInstance(q.f73a).enqueue(builder.setInputData(build2).addTag(simpleName).addTag("ENQUEUED_AT_" + System.currentTimeMillis()).setConstraints(build).build());
            }
        }
        return Unit.INSTANCE;
    }
}
