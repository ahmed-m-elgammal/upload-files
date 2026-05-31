package com.microsoft.clarity.f;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class C extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f102a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(M m) {
        super(1);
        this.f102a = m;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        com.microsoft.clarity.e.E result = (com.microsoft.clarity.e.E) obj;
        Intrinsics.checkNotNullParameter(result, "result");
        M m = this.f102a;
        m.B.add(new B(m, result));
        return Unit.INSTANCE;
    }
}
