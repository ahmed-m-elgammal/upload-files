package com.microsoft.clarity.f;

import com.facebook.internal.ServerProtocol;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class H extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f107a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(M m) {
        super(0);
        this.f107a = m;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        com.microsoft.clarity.m.h.b("Enqueuing setting network disconnected tag.");
        this.f107a.a("Network Disconnected", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        return Unit.INSTANCE;
    }
}
