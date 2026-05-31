package com.microsoft.clarity.e;

import com.microsoft.clarity.models.LogLevel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class K extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q f67a;
    public final /* synthetic */ J b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(Q q, J j) {
        super(0);
        this.f67a = q;
        this.b = j;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Telemetry task queue size: " + this.f67a.e.size() + '.');
        this.b.f66a.invoke();
        return Unit.INSTANCE;
    }
}
