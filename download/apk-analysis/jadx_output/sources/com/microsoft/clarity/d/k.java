package com.microsoft.clarity.d;

import com.microsoft.clarity.i.C0107a;
import java.io.Closeable;
import java.io.IOException;
import java.util.Set;

/* loaded from: classes5.dex */
public final class k implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final e f55a;
    public final int b;
    public final long[] c;
    public final Set d;

    public k(C0107a c0107a, Set set) {
        e eVar = new e(c0107a);
        this.f55a = eVar;
        this.d = set;
        if (!eVar.f().equals("ttcf")) {
            throw new IOException("Missing TTC header");
        }
        float h = (eVar.h() / 65536.0f) + eVar.d();
        int g = (int) eVar.g();
        this.b = g;
        if (g <= 0 || g > 1024) {
            throw new IOException("Invalid number of fonts " + g);
        }
        this.c = new long[g];
        for (int i = 0; i < this.b; i++) {
            this.c[i] = eVar.g();
        }
        if (h >= 2.0f) {
            eVar.h();
            eVar.h();
            eVar.h();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
