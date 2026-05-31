package com.microsoft.clarity.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkerParameters;
import com.facebook.appevents.ml.ModelManager;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.l.c;
import com.microsoft.clarity.m.h;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/CleanupWorker;", "Lcom/microsoft/clarity/workers/BaseWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CleanupWorker extends BaseWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f216a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CleanupWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f216a = context;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final ListenableWorker.Result a() {
        h.d("Cleanup worker started.");
        String simpleName = Reflection.getOrCreateKotlinClass(UpdateClarityCachedConfigsWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        String simpleName2 = Reflection.getOrCreateKotlinClass(ReportExceptionWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName2);
        String simpleName3 = Reflection.getOrCreateKotlinClass(ReportMetricsWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName3);
        String simpleName4 = Reflection.getOrCreateKotlinClass(UploadSessionPayloadWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName4);
        WorkQuery build = WorkQuery.Builder.fromTags(CollectionsKt.listOf((Object[]) new String[]{simpleName, simpleName2, simpleName3, simpleName4})).build();
        Intrinsics.checkNotNullExpressionValue(build, "fromTags(tags).build()");
        WorkManager workManager = WorkManager.getInstance(this.f216a);
        Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
        List<WorkInfo> list = workManager.getWorkInfos(build).get();
        Intrinsics.checkNotNullExpressionValue(list, "workManager\n            …query)\n            .get()");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                WorkInfo w = (WorkInfo) next;
                Intrinsics.checkNotNullExpressionValue(w, "w");
                long currentTimeMillis = System.currentTimeMillis() - 172800000;
                Set<String> tags = w.getTags();
                Intrinsics.checkNotNullExpressionValue(tags, "info.tags");
                for (String enqueueTimeTag : tags) {
                    Intrinsics.checkNotNullExpressionValue(enqueueTimeTag, "t");
                    if (StringsKt.startsWith(enqueueTimeTag, "ENQUEUED_AT_", true)) {
                        Intrinsics.checkNotNullExpressionValue(enqueueTimeTag, "enqueueTimeTag");
                        long parseLong = Long.parseLong((String) CollectionsKt.last(StringsKt.split$default((CharSequence) enqueueTimeTag, new String[]{"_"}, false, 0, 6, (Object) null)));
                        boolean z = parseLong < currentTimeMillis;
                        if (z) {
                            LogLevel logLevel = h.f192a;
                            h.b("Worker " + w.getId() + " (enqueuedAt: " + parseLong + " < timestamp: " + currentTimeMillis + ") should be cancelled.");
                        }
                        if (z) {
                            arrayList.add(next);
                        }
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(workManager.cancelWorkById(((WorkInfo) it2.next()).getId()));
            }
            Object obj = a.f47a;
            c a2 = a.a(this.f216a, "");
            long currentTimeMillis2 = System.currentTimeMillis() - ModelManager.MODEL_REQUEST_INTERVAL_MILLISECONDS;
            LogLevel logLevel2 = h.f192a;
            h.b("Deleting files before " + currentTimeMillis2 + '.');
            List a3 = c.a(a2, null, true, 1);
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : a3) {
                if (((File) obj2).lastModified() < currentTimeMillis2) {
                    arrayList3.add(obj2);
                }
            }
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                ((File) it3.next()).delete();
            }
            String[] paths = {a2.f186a};
            Intrinsics.checkNotNullParameter(paths, "paths");
            Iterator it4 = SequencesKt.filter(FilesKt.walkTopDown(new File(ArraysKt.joinToString$default(paths, String.valueOf(File.separatorChar), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null))), com.microsoft.clarity.l.a.f184a).iterator();
            while (it4.hasNext()) {
                ((File) it4.next()).delete();
            }
            ListenableWorker.Result success = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(success, "success()");
            return success;
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
        a.b(this.f216a, string).a(exception, ErrorType.CleanupWorker, null);
    }
}
