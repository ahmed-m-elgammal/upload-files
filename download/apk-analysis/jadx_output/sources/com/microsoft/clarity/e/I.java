package com.microsoft.clarity.e;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public final String f65a;
    public int b;
    public double c;
    public double d;
    public double e;
    public double f;
    public double g;

    public I(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f65a = name;
    }

    public final void a(double d) {
        if (this.b == 0) {
            this.e = d;
            this.d = d;
        } else {
            this.e = Math.min(d, this.e);
            this.d = Math.max(d, this.d);
        }
        int i = this.b + 1;
        this.b = i;
        this.c += d;
        double d2 = this.f;
        double d3 = d - d2;
        double d4 = (d3 / i) + d2;
        this.f = d4;
        this.g = (d3 * (d - d4)) + this.g;
    }
}
