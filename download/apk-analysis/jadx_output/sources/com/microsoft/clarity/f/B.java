package com.microsoft.clarity.f;

import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.ingest.analytics.AppInstallReferrerEvent;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class B extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f101a;
    public final /* synthetic */ com.microsoft.clarity.e.E b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(M m, com.microsoft.clarity.e.E e) {
        super(0);
        this.f101a = m;
        this.b = e;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ScreenMetadata screenMetadata;
        M m = this.f101a;
        long currentTimeMillis = System.currentTimeMillis();
        DisplayFrame displayFrame = this.f101a.t;
        if (displayFrame == null || (screenMetadata = displayFrame.getScreenMetadata()) == null) {
            screenMetadata = new ScreenMetadata("", "", 0);
        }
        m.b(new AppInstallReferrerEvent(currentTimeMillis, screenMetadata, this.b));
        return Unit.INSTANCE;
    }
}
