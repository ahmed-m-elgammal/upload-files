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
public final class G extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f106a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(M m, String str) {
        super(0);
        this.f106a = m;
        this.b = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        DisplayFrame displayFrame;
        M m = this.f106a;
        if (m.l == null && (displayFrame = m.t) != null) {
            long j = m.p;
            Intrinsics.checkNotNull(displayFrame);
            m.b(new VariableEvent(j, displayFrame.getScreenMetadata(), MapsKt.mapOf(TuplesKt.to("userId", this.b))));
        }
        this.f106a.l = this.b;
        return Unit.INSTANCE;
    }
}
