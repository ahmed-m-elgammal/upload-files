package com.microsoft.clarity.a;

import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.models.ApplicationFramework;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.a.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0050a extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClarityConfig f21a;
    public final /* synthetic */ ApplicationFramework b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0050a(ClarityConfig clarityConfig, ApplicationFramework applicationFramework) {
        super(0);
        this.f21a = clarityConfig;
        this.b = applicationFramework;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f21a.applicationFramework = this.b;
        return Unit.INSTANCE;
    }
}
