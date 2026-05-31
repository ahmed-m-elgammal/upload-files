package com.microsoft.clarity.f;

import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class z extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewAnalyticsEvent f133a;
    public final /* synthetic */ M b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(WebViewAnalyticsEvent webViewAnalyticsEvent, M m) {
        super(0);
        this.f133a = webViewAnalyticsEvent;
        this.b = m;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Received web view analytics event " + this.f133a.getType() + '.');
        M.a(this.b, this.f133a);
        return Unit.INSTANCE;
    }
}
