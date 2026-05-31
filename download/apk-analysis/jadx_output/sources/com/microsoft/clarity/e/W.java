package com.microsoft.clarity.e;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class W {

    /* renamed from: a, reason: collision with root package name */
    public final X f78a;
    public final byte[] b;

    public W(X metadata, byte[] content) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(content, "content");
        this.f78a = metadata;
        this.b = content;
    }
}
