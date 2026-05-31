package com.microsoft.clarity.i;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class t extends s {
    public final long g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(long j, com.microsoft.clarity.e.C c, v parserFactory) {
        super(j, c, parserFactory);
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        this.g = j;
    }

    @Override // com.microsoft.clarity.i.s, com.microsoft.clarity.i.r, com.microsoft.clarity.i.q, com.microsoft.clarity.i.p
    public final long d() {
        return this.g;
    }
}
