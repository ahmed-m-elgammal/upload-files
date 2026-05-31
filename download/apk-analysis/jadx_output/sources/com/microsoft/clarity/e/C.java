package com.microsoft.clarity.e;

import com.microsoft.clarity.f.C0093k;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final /* synthetic */ class C implements com.microsoft.clarity.h.a, FunctionAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0093k f59a;

    public C(C0093k function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f59a = function;
    }

    @Override // com.microsoft.clarity.h.a
    public final /* synthetic */ void a(Exception exc, ErrorType errorType) {
        this.f59a.invoke(exc, errorType);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof com.microsoft.clarity.h.a) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(this.f59a, ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.f59a;
    }

    public final int hashCode() {
        return this.f59a.hashCode();
    }
}
