package com.microsoft.clarity.e;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.e.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0074q extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f91a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0074q(View view) {
        super(1);
        this.f91a = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        WeakReference it = (WeakReference) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(Intrinsics.areEqual(it.get(), this.f91a));
    }
}
