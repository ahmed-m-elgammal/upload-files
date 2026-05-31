package com.microsoft.clarity.a;

import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class y extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final y f45a = new y();

    public y() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception it = (Exception) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        com.microsoft.clarity.f.s sVar = F.f18a;
        F.a(it, ErrorType.SettingOnSessionStartedOrResumedCallback);
        return Unit.INSTANCE;
    }
}
