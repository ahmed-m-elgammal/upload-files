package com.microsoft.clarity.f;

import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class w extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnalyticsEvent f130a;
    public final /* synthetic */ M b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(AnalyticsEvent analyticsEvent, M m) {
        super(0);
        this.f130a = analyticsEvent;
        this.b = m;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("New analytics event " + this.f130a.getType() + " received for screen " + this.f130a.getScreenMetadata().getName() + '#' + this.f130a.getScreenMetadata().getActivityHashCode() + '.');
        if (this.b.n != null) {
            long timestamp = this.f130a.getTimestamp();
            M m = this.b;
            if (timestamp >= m.p) {
                DisplayFrame displayFrame = m.t;
                if (Intrinsics.areEqual(displayFrame != null ? displayFrame.getScreenMetadata() : null, this.f130a.getScreenMetadata())) {
                    if (this.b.e()) {
                        com.microsoft.clarity.m.h.b("Dropping Analytics Event because current page payload count limit has been exceeded");
                    } else {
                        this.b.b(this.f130a);
                    }
                    return Unit.INSTANCE;
                }
            }
        }
        com.microsoft.clarity.m.h.b("Skipping residual analytics event from another page.");
        return Unit.INSTANCE;
    }
}
