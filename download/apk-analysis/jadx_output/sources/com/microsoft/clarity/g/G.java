package com.microsoft.clarity.g;

import com.microsoft.clarity.f.C0084b;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class G extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K f140a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(K k) {
        super(1);
        this.f140a = k;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception it = (Exception) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        K k = this.f140a;
        ErrorType errorType = ErrorType.WebViewChannelMessageProcessing;
        Iterator it2 = k.b.iterator();
        while (it2.hasNext()) {
            ((C0084b) it2.next()).a(it, errorType);
        }
        return Unit.INSTANCE;
    }
}
