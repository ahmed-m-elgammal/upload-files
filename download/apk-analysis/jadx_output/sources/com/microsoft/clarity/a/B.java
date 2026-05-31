package com.microsoft.clarity.a;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class B extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f14a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(Function1 function1) {
        super(0);
        this.f14a = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Unit unit;
        Object obj = F.p;
        Function1 function1 = this.f14a;
        synchronized (obj) {
            com.microsoft.clarity.f.s sVar = F.f18a;
            if (sVar != null) {
                sVar.f127a.a(function1);
            } else {
                F.n = function1;
                F.m = true;
            }
            unit = Unit.INSTANCE;
        }
        return unit;
    }
}
