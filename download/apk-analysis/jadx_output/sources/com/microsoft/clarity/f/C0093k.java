package com.microsoft.clarity.f;

import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.f.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C0093k extends FunctionReferenceImpl implements Function2 {
    public C0093k(q qVar) {
        super(2, qVar, q.class, "processError", "processError(Ljava/lang/Exception;Lcom/microsoft/clarity/models/telemetry/ErrorType;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Exception p0 = (Exception) obj;
        ErrorType p1 = (ErrorType) obj2;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        q.a((q) this.receiver, p0, p1);
        return Unit.INSTANCE;
    }
}
