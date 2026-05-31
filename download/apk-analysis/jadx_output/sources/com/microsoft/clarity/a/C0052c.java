package com.microsoft.clarity.a;

import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.models.LogLevel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.a.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0052c extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClarityConfig f23a;
    public final /* synthetic */ LogLevel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0052c(ClarityConfig clarityConfig, LogLevel logLevel) {
        super(0);
        this.f23a = clarityConfig;
        this.b = logLevel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f23a.logLevel = this.b;
        return Unit.INSTANCE;
    }
}
