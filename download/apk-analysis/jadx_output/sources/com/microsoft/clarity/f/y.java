package com.microsoft.clarity.f;

import com.microsoft.clarity.models.PayloadMetadata;
import com.microsoft.clarity.models.ingest.mutation.MutationErrorEvent;
import com.microsoft.clarity.models.observers.ErrorDisplayFrame;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class y extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f132a;
    public final /* synthetic */ ErrorDisplayFrame b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(M m, ErrorDisplayFrame errorDisplayFrame) {
        super(0);
        this.f132a = m;
        this.b = errorDisplayFrame;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (this.f132a.n != null) {
            long timestamp = this.b.getTimestamp();
            M m = this.f132a;
            if (timestamp >= m.p) {
                if (m.e()) {
                    com.microsoft.clarity.m.h.b("Dropping Error Frame because current page payload count has been exceeded");
                } else {
                    this.f132a.a(this.b.getTimestamp(), this.b.getScreenMetadata());
                    PayloadMetadata payloadMetadata = this.f132a.q;
                    Intrinsics.checkNotNull(payloadMetadata);
                    payloadMetadata.updateDuration(this.b.getTimestamp());
                    M m2 = this.f132a;
                    com.microsoft.clarity.j.b bVar = m2.d;
                    PayloadMetadata payloadMetadata2 = m2.q;
                    Intrinsics.checkNotNull(payloadMetadata2);
                    MutationErrorEvent event = new MutationErrorEvent(this.b.getTimestamp(), this.b.getReason());
                    com.microsoft.clarity.j.f fVar = (com.microsoft.clarity.j.f) bVar;
                    fVar.getClass();
                    Intrinsics.checkNotNullParameter(payloadMetadata2, "payloadMetadata");
                    Intrinsics.checkNotNullParameter(event, "event");
                    com.microsoft.clarity.j.f.a(fVar.b, payloadMetadata2, event.serialize(payloadMetadata2.getPageTimestamp()));
                }
            }
        }
        return Unit.INSTANCE;
    }
}
