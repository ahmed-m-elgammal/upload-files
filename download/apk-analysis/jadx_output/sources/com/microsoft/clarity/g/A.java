package com.microsoft.clarity.g;

import com.microsoft.clarity.f.C0084b;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class A extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K f134a;
    public final /* synthetic */ y b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(K k, y yVar) {
        super(1);
        this.f134a = k;
        this.b = yVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception it = (Exception) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        K k = this.f134a;
        ErrorType errorType = ErrorType.ClarityJsInjection;
        Iterator it2 = k.b.iterator();
        while (it2.hasNext()) {
            ((C0084b) it2.next()).a(it, errorType);
        }
        this.f134a.i.add(this.b.f167a);
        return Unit.INSTANCE;
    }
}
