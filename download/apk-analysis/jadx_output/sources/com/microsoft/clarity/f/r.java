package com.microsoft.clarity.f;

import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r implements com.microsoft.clarity.h.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f126a;

    public r(s sVar) {
        this.f126a = sVar;
    }

    @Override // com.microsoft.clarity.h.a
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        s sVar = this.f126a;
        sVar.getClass();
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        sVar.c.a(exception, errorType, sVar.b.c());
    }
}
