package com.microsoft.clarity.d;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* loaded from: classes5.dex */
public abstract class g implements Closeable {
    public abstract int a(byte[] bArr, int i, int i2);

    public abstract long a();

    public abstract void a(long j);

    public final byte[] a(int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int a2 = a(bArr, i2, i - i2);
            if (a2 == -1) {
                break;
            }
            i2 += a2;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Unexpected end of TTF stream reached");
    }

    public abstract long b();

    public final int[] b(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = h();
        }
        return iArr;
    }

    public abstract int c();

    public abstract short d();

    public final String e() {
        return new String(a(4), StandardCharsets.ISO_8859_1);
    }

    public final String f() {
        return new String(a(4), StandardCharsets.US_ASCII);
    }

    public final long g() {
        long c = c();
        long c2 = c();
        long c3 = c();
        long c4 = c();
        if (c4 >= 0) {
            return (c << 24) + (c2 << 16) + (c3 << 8) + c4;
        }
        throw new EOFException();
    }

    public abstract int h();
}
