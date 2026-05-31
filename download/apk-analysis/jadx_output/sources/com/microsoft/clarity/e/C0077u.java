package com.microsoft.clarity.e;

import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.e.u, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0077u extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0078v f94a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0077u(C0078v c0078v) {
        super(1);
        this.f94a = c0078v;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception it = (Exception) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f94a.d.a(it, ErrorType.RetrievingAppInstallReferrer, null);
        return Unit.INSTANCE;
    }
}
