package com.microsoft.clarity.a;

import com.microsoft.clarity.ClarityConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.a.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0053d extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClarityConfig f24a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0053d(ClarityConfig clarityConfig, String str) {
        super(0);
        this.f24a = clarityConfig;
        this.b = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f24a.userId = this.b;
        return Unit.INSTANCE;
    }
}
