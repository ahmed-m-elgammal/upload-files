package com.microsoft.clarity.g;

import com.microsoft.clarity.f.C0083a;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class q extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f160a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(w wVar) {
        super(1);
        this.f160a = wVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception it = (Exception) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        w wVar = this.f160a;
        ErrorType errorType = ErrorType.CapturingTouchEvent;
        Iterator it2 = wVar.f166a.iterator();
        while (it2.hasNext()) {
            ((C0083a) it2.next()).a(it, errorType);
        }
        return Unit.INSTANCE;
    }
}
