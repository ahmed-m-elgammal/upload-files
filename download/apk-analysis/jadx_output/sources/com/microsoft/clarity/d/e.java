package com.microsoft.clarity.d;

import com.microsoft.clarity.i.C0107a;
import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e extends g {

    /* renamed from: a, reason: collision with root package name */
    public final C0107a f52a;
    public int b = 0;

    public e(C0107a c0107a) {
        this.f52a = c0107a;
    }

    @Override // com.microsoft.clarity.d.g
    public final void a(long j) {
        if (j >= 0 && j <= 2147483647L) {
            this.b = (int) j;
        } else {
            throw new IOException("Illegal seek position: " + j);
        }
    }

    @Override // com.microsoft.clarity.d.g
    public final long b() {
        return this.f52a.c;
    }

    @Override // com.microsoft.clarity.d.g
    public final int c() {
        int i = this.b;
        C0107a c0107a = this.f52a;
        if (i >= c0107a.c) {
            return -1;
        }
        byte b = c0107a.f169a[c0107a.b + i];
        this.b = i + 1;
        return (b + 256) % 256;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.microsoft.clarity.d.g
    public final short d() {
        int c = c();
        int c2 = c();
        if ((c | c2) >= 0) {
            return (short) ((c << 8) + c2);
        }
        throw new EOFException();
    }

    @Override // com.microsoft.clarity.d.g
    public final int h() {
        int c = c();
        int c2 = c();
        if ((c | c2) >= 0) {
            return (c << 8) + c2;
        }
        throw new EOFException();
    }

    @Override // com.microsoft.clarity.d.g
    public final int a(byte[] dest, int i, int i2) {
        int i3 = this.b;
        int i4 = this.f52a.c;
        if (i3 >= i4) {
            return -1;
        }
        int min = Math.min(i2, i4 - i3);
        C0107a c0107a = this.f52a;
        int i5 = this.b;
        c0107a.getClass();
        Intrinsics.checkNotNullParameter(dest, "dest");
        System.arraycopy(c0107a.f169a, c0107a.b + i5, dest, i, min);
        this.b += min;
        return min;
    }

    @Override // com.microsoft.clarity.d.g
    public final long a() {
        return this.b;
    }
}
