package com.microsoft.clarity.a;

import android.app.Activity;
import android.content.Context;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.models.LogLevel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.a.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0055f extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClarityConfig f26a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Activity c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0055f(Activity activity, Context context, ClarityConfig clarityConfig) {
        super(0);
        this.f26a = clarityConfig;
        this.b = context;
        this.c = activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f26a.freeze$sdk_prodRelease();
        com.microsoft.clarity.f.s sVar = F.f18a;
        ClarityConfig clarityConfig = this.f26a;
        int ordinal = LogLevel.valueOf("None").ordinal();
        int ordinal2 = clarityConfig.getLogLevel().ordinal();
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        LogLevel logLevel2 = LogLevel.values()[Math.min(ordinal2, ordinal)];
        Intrinsics.checkNotNullParameter(logLevel2, "<set-?>");
        com.microsoft.clarity.m.h.f192a = logLevel2;
        com.microsoft.clarity.m.h.d("Initialize Clarity.");
        com.microsoft.clarity.m.h.b("Initialization configs: " + this.f26a);
        Object obj = com.microsoft.clarity.b.a.f47a;
        com.microsoft.clarity.m.m.a("Clarity_Initialize", com.microsoft.clarity.b.a.b(this.b, this.f26a.getProjectId()), new C0054e(this.c, this.b, this.f26a));
        return Unit.INSTANCE;
    }
}
