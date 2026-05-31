package com.microsoft.clarity.e;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class V {

    /* renamed from: a, reason: collision with root package name */
    public final int f77a;
    public final int b;
    public final String c;
    public final String d;

    public V(int i, int i2, String assetPath, String absoluteUrl) {
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        Intrinsics.checkNotNullParameter(absoluteUrl, "absoluteUrl");
        this.f77a = i;
        this.b = i2;
        this.c = assetPath;
        this.d = absoluteUrl;
    }
}
