package com.microsoft.clarity.g;

import com.microsoft.clarity.models.telemetry.ErrorType;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class l extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f155a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar) {
        super(1);
        this.f155a = mVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception it = (Exception) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        m mVar = this.f155a;
        ErrorType errorType = ErrorType.ActivityLifecycle;
        Iterator it2 = mVar.b.iterator();
        while (it2.hasNext()) {
            ((com.microsoft.clarity.h.b) it2.next()).a(it, errorType);
        }
        return Unit.INSTANCE;
    }
}
