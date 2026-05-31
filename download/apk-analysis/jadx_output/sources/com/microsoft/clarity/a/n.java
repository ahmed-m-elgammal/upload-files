package com.microsoft.clarity.a;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class n extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final n f34a = new n();

    public n() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Unit unit;
        synchronized (F.p) {
            com.microsoft.clarity.f.s sVar = F.f18a;
            if (sVar != null) {
                com.microsoft.clarity.f.q qVar = sVar.f127a;
                qVar.u = false;
                qVar.c();
            }
            F.o = false;
            unit = Unit.INSTANCE;
        }
        return unit;
    }
}
