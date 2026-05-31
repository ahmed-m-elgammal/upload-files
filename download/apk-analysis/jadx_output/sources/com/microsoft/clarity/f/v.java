package com.microsoft.clarity.f;

import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class v extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f129a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(M m) {
        super(1);
        this.f129a = m;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception exception = (Exception) obj;
        Intrinsics.checkNotNullParameter(exception, "it");
        M m = this.f129a;
        ErrorType errorType = ErrorType.EventProcessingTaskExecution;
        m.getClass();
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        m.g.a(exception, errorType, m.c());
        return Unit.INSTANCE;
    }
}
