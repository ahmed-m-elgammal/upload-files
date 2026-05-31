package com.microsoft.clarity.f;

import androidx.work.WorkInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class J extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f109a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(M m) {
        super(1);
        this.f109a = m;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        com.microsoft.clarity.m.f.a(new I((WorkInfo) obj, this.f109a), (Function1) null, (o) null, 30);
        return Unit.INSTANCE;
    }
}
