package com.microsoft.clarity.i;

import com.microsoft.clarity.a.G;
import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.models.display.images.Image;
import java.security.MessageDigest;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class i extends h {
    @Override // com.microsoft.clarity.i.h
    /* renamed from: b */
    public final Image a(g buffer) {
        int compare;
        C0108b c0108b;
        int compare2;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int d = buffer.d();
        int f = buffer.f();
        compare = Integer.compare(f ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
        byte[] bArr = null;
        if (compare > 0) {
            int m2662constructorimpl = UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(f + 3) >>> 2) << 2);
            if (f <= 0) {
                throw new IllegalArgumentException("Cannot read 0 length segment of the byte buffer!");
            }
            MessageDigest messageDigest = com.microsoft.clarity.m.b.f189a;
            c0108b = com.microsoft.clarity.m.b.a(buffer.f171a, buffer.d, f);
            buffer.d = (m2662constructorimpl - f) + buffer.d + f;
        } else {
            c0108b = null;
        }
        IRect iRect = (d & 256) != 0 ? new IRect(buffer.d(), buffer.d(), buffer.d(), buffer.d()) : null;
        if ((d & 512) != 0) {
            int f2 = buffer.f();
            compare2 = Integer.compare(f2 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
            if (compare2 > 0) {
                int m2662constructorimpl2 = UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(f2 + 3) >>> 2) << 2);
                if (f2 <= 0) {
                    throw new IllegalArgumentException("Cannot read 0 length segment of the byte buffer!");
                }
                byte[] bArr2 = buffer.f171a;
                int i = buffer.d;
                bArr = ArraysKt.copyOfRange(bArr2, i, i + f2);
                buffer.d += f2;
                buffer.d += UInt.m2662constructorimpl(m2662constructorimpl2 - f2);
            }
        }
        return c0108b != null ? new Image(iRect, c0108b.f170a, c0108b.b, bArr) : G.f19a;
    }
}
