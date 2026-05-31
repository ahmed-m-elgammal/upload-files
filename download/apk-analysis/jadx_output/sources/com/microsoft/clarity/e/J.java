package com.microsoft.clarity.e;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class J {

    /* renamed from: a, reason: collision with root package name */
    public final Lambda f66a;
    public final Lambda b;

    /* JADX WARN: Multi-variable type inference failed */
    public J(Function0 logic, Function1 catchBlock) {
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter(catchBlock, "catchBlock");
        this.f66a = (Lambda) logic;
        this.b = (Lambda) catchBlock;
    }
}
