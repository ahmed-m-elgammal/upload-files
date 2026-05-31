package com.microsoft.clarity.a;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class z extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f46a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(String str) {
        super(0);
        this.f46a = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Unit unit;
        Object obj = F.p;
        String str = this.f46a;
        synchronized (obj) {
            com.microsoft.clarity.f.s sVar = F.f18a;
            if (sVar != null) {
                sVar.f127a.A = str;
            } else {
                F.k = str;
            }
            unit = Unit.INSTANCE;
        }
        return unit;
    }
}
