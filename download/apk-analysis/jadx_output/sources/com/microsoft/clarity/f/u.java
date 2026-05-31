package com.microsoft.clarity.f;

import com.microsoft.clarity.models.LogLevel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class u extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f128a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(M m) {
        super(0);
        this.f128a = m;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Function0 function0 = (Function0) this.f128a.B.take();
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Task deque size: " + this.f128a.B.size() + '.');
        function0.invoke();
        return Unit.INSTANCE;
    }
}
