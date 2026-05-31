package com.microsoft.clarity.n;

import androidx.work.ListenableWorker;
import com.microsoft.clarity.workers.BaseWorker;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f198a;
    public final /* synthetic */ BaseWorker b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Ref.ObjectRef objectRef, BaseWorker baseWorker) {
        super(1);
        this.f198a = objectRef;
        this.b = baseWorker;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.work.ListenableWorker$Result] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception it = (Exception) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f198a.element = ListenableWorker.Result.retry();
        this.b.a(it);
        return Unit.INSTANCE;
    }
}
