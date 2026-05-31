package com.microsoft.clarity.i;

import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes5.dex */
public final class z extends OutputStream {
    public static final MessageDigest g = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
    public int b;
    public boolean c;
    public String f;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f177a = new byte[32];
    public final int d = 2147483639;
    public int e = 32;

    public z() {
        g.reset();
    }

    public final String a() {
        Base64.Encoder urlEncoder;
        String encodeToString;
        if (!this.c) {
            return null;
        }
        String str = this.f;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            return str;
        }
        urlEncoder = Base64.getUrlEncoder();
        encodeToString = urlEncoder.encodeToString(g.digest());
        this.f = encodeToString;
        Intrinsics.checkNotNull(encodeToString);
        return encodeToString;
    }

    public final synchronized int b() {
        return this.b;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.c = true;
    }

    public final synchronized String toString() {
        return new String(this.f177a, 0, this.b, Charsets.UTF_8);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i) {
        a(this.b + 1);
        byte[] bArr = this.f177a;
        int i2 = this.b;
        bArr[i2] = (byte) i;
        this.b = i2 + 1;
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] b, int i, int i2) {
        Intrinsics.checkNotNullParameter(b, "b");
        a(this.b + i2);
        System.arraycopy(b, i, this.f177a, this.b, i2);
        this.b += i2;
        g.update(b, i, i2);
    }

    public final void a(int i) {
        byte[] bArr = this.f177a;
        if (i - bArr.length > 0) {
            int length = bArr.length << 1;
            if (length - i < 0) {
                length = i;
            }
            int i2 = this.d;
            if (length - i2 > 0) {
                if (i < 0) {
                    throw new OutOfMemoryError();
                }
                length = i > i2 ? Integer.MAX_VALUE : i2;
            }
            this.e = length;
            byte[] copyOf = Arrays.copyOf(bArr, length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(buf, newCapacity)");
            this.f177a = copyOf;
        }
    }
}
