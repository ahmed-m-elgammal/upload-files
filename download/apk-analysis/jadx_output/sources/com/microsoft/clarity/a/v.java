package com.microsoft.clarity.a;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class v extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f42a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(String str) {
        super(0);
        this.f42a = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Unit unit;
        Object obj = F.p;
        String customUserId = this.f42a;
        synchronized (obj) {
            com.microsoft.clarity.f.s sVar = F.f18a;
            if (sVar != null) {
                Intrinsics.checkNotNullParameter(customUserId, "customUserId");
                sVar.b.c(customUserId);
            } else {
                F.g = customUserId;
            }
            unit = Unit.INSTANCE;
        }
        return unit;
    }
}
