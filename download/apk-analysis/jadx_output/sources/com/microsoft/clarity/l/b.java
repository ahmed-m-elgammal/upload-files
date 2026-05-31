package com.microsoft.clarity.l;

import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f185a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(boolean z) {
        super(1);
        this.f185a = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        File it = (File) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(this.f185a || !it.isDirectory());
    }
}
