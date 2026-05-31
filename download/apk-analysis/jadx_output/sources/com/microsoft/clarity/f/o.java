package com.microsoft.clarity.f;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class o extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f123a;
    public final /* synthetic */ p b;
    public final /* synthetic */ Ref.LongRef c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, p pVar, Ref.LongRef longRef) {
        super(0);
        this.f123a = qVar;
        this.b = pVar;
        this.c = longRef;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f123a.s.postDelayed(this.b, this.c.element);
        return Unit.INSTANCE;
    }
}
