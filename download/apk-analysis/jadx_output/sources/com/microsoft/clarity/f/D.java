package com.microsoft.clarity.f;

import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.ingest.analytics.CustomEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class D extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f103a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(M m, String str) {
        super(0);
        this.f103a = m;
        this.b = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        M m = this.f103a;
        if (m.t == null) {
            m.A.add(this.b);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            DisplayFrame displayFrame = this.f103a.t;
            Intrinsics.checkNotNull(displayFrame);
            m.a(new CustomEvent(currentTimeMillis, displayFrame.getScreenMetadata(), this.b));
        }
        return Unit.INSTANCE;
    }
}
