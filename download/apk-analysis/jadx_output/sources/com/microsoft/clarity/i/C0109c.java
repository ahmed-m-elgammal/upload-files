package com.microsoft.clarity.i;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* renamed from: com.microsoft.clarity.i.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0109c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f171a;
    public final int b;
    public final int c;
    public int d;

    public C0109c(byte[] bytes, int i, int i2) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.f171a = bytes;
        this.b = i;
        this.c = i2;
        this.d = i;
    }

    public final String a(int i) {
        String str = new String(this.f171a, this.d, i, Charsets.UTF_8);
        this.d += i;
        return str;
    }

    public final int b() {
        byte[] bArr = this.f171a;
        int i = this.d;
        byte b = bArr[i];
        this.d = i + 1;
        return b;
    }

    public final float c() {
        ByteBuffer order = ByteBuffer.wrap(this.f171a, this.d, 4).order(ByteOrder.nativeOrder());
        this.d += 4;
        return order.getFloat();
    }

    public final int d() {
        ByteBuffer order = ByteBuffer.wrap(this.f171a, this.d, 4).order(ByteOrder.nativeOrder());
        this.d += 4;
        return order.getInt();
    }

    public final int e() {
        int m2662constructorimpl = UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UByte.m2584constructorimpl(this.f171a[this.d + 1]) & 255) << 8) + UInt.m2662constructorimpl(UInt.m2662constructorimpl(UByte.m2584constructorimpl(this.f171a[this.d]) & 255)));
        this.d += 2;
        return m2662constructorimpl;
    }

    public final int f() {
        int m2662constructorimpl = UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UByte.m2584constructorimpl(this.f171a[this.d + 3]) & 255) << 24) + UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UByte.m2584constructorimpl(this.f171a[this.d + 2]) & 255) << 16) + UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UByte.m2584constructorimpl(this.f171a[this.d + 1]) & 255) << 8) + UInt.m2662constructorimpl(UInt.m2662constructorimpl(UByte.m2584constructorimpl(this.f171a[this.d]) & 255)))));
        this.d += 4;
        return m2662constructorimpl;
    }

    public final int a() {
        int m2662constructorimpl = UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UByte.m2584constructorimpl(this.f171a[this.d + 3]) & 255)) + UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UByte.m2584constructorimpl(this.f171a[this.d + 2]) & 255) << 8) + UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UByte.m2584constructorimpl(this.f171a[this.d + 1]) & 255) << 16) + UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UByte.m2584constructorimpl(this.f171a[this.d]) & 255) << 24)))));
        this.d += 4;
        return m2662constructorimpl;
    }
}
