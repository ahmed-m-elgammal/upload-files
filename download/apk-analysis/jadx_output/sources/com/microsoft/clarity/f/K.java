package com.microsoft.clarity.f;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class K extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveData f110a;
    public final /* synthetic */ M b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(LiveData liveData, M m) {
        super(0);
        this.f110a = liveData;
        this.b = m;
    }

    public final void a() {
        LiveData liveData = this.f110a;
        final J j = new J(this.b);
        liveData.observeForever(new Observer() { // from class: com.microsoft.clarity.f.K$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                K.a(Function1.this, obj);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }

    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
