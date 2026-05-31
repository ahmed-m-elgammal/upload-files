package com.microsoft.clarity.a;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class r extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f38a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String str) {
        super(0);
        this.f38a = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Unit unit;
        Object obj = F.p;
        String customSessionId = this.f38a;
        synchronized (obj) {
            com.microsoft.clarity.f.s sVar = F.f18a;
            if (sVar != null) {
                Intrinsics.checkNotNullParameter(customSessionId, "customSessionId");
                sVar.b.b(customSessionId);
            } else {
                F.h = customSessionId;
            }
            unit = Unit.INSTANCE;
        }
        return unit;
    }
}
