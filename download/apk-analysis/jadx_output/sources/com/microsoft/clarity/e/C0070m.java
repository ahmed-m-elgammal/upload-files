package com.microsoft.clarity.e;

import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.e.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0070m extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0070m f89a = new C0070m();

    public C0070m() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        WeakReference r = (WeakReference) obj;
        Intrinsics.checkNotNullParameter(r, "r");
        return Boolean.valueOf(r.get() == null);
    }
}
