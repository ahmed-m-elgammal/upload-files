package com.microsoft.clarity.i;

import com.microsoft.clarity.a.G;
import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.models.display.images.Image;
import java.security.MessageDigest;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j extends h {
    @Override // com.microsoft.clarity.i.h
    /* renamed from: b */
    public final Image a(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        IRect iRect = new IRect(buffer.d(), buffer.d(), buffer.d(), buffer.d());
        int f = buffer.f();
        if (f == 0) {
            return G.f19a;
        }
        int m2662constructorimpl = UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(f + 3) >>> 2) << 2);
        if (f <= 0) {
            throw new IllegalArgumentException("Cannot read 0 length segment of the byte buffer!");
        }
        MessageDigest messageDigest = com.microsoft.clarity.m.b.f189a;
        C0108b a2 = com.microsoft.clarity.m.b.a(buffer.f171a, buffer.d, f);
        buffer.d = (m2662constructorimpl - f) + buffer.d + f;
        return new Image(iRect, a2.f170a, a2.b, null);
    }
}
