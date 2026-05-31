package com.microsoft.clarity.n;

import androidx.work.ListenableWorker;
import com.microsoft.clarity.workers.BaseWorker;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f197a;
    public final /* synthetic */ BaseWorker b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Ref.ObjectRef objectRef, BaseWorker baseWorker) {
        super(0);
        this.f197a = objectRef;
        this.b = baseWorker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f197a.element = this.b.getRunAttemptCount() + 1 > 3 ? ListenableWorker.Result.failure() : this.b.a();
        return Unit.INSTANCE;
    }
}
