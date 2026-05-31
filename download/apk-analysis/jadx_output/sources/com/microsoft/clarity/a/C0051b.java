package com.microsoft.clarity.a;

import com.microsoft.clarity.ClarityConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.a.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0051b extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClarityConfig f22a;
    public final /* synthetic */ Function2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0051b(ClarityConfig clarityConfig, Function2 function2) {
        super(0);
        this.f22a = clarityConfig;
        this.b = function2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f22a.customSignalsCallback = this.b;
        return Unit.INSTANCE;
    }
}
