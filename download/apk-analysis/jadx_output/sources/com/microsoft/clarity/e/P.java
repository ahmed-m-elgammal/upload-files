package com.microsoft.clarity.e;

import com.microsoft.clarity.models.LogLevel;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class P extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final P f72a = new P();

    public P() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception exception = (Exception) obj;
        Intrinsics.checkNotNullParameter(exception, "it");
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (com.microsoft.clarity.m.h.a(LogLevel.Error)) {
            com.microsoft.clarity.m.h.c(exception.getMessage());
            com.microsoft.clarity.m.h.c(ExceptionsKt.stackTraceToString(exception));
        }
        return Unit.INSTANCE;
    }
}
