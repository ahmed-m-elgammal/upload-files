package com.microsoft.clarity.f;

import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.ingest.analytics.VariableEvent;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class F extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f105a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(M m, String str, String str2) {
        super(0);
        this.f105a = m;
        this.b = str;
        this.c = str2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        M m = this.f105a;
        DisplayFrame displayFrame = m.t;
        if (displayFrame != null) {
            long j = m.p;
            Intrinsics.checkNotNull(displayFrame);
            m.b(new VariableEvent(j, displayFrame.getScreenMetadata(), MapsKt.mapOf(TuplesKt.to(this.b, this.c))));
        }
        this.f105a.z.put(this.b, this.c);
        return Unit.INSTANCE;
    }
}
