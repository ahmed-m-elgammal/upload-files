package com.microsoft.clarity.f;

import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.f.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0085c implements com.microsoft.clarity.h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f114a;

    public C0085c(q qVar) {
        this.f114a = qVar;
    }

    @Override // com.microsoft.clarity.h.a
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        q.a(this.f114a, exception, errorType);
    }
}
