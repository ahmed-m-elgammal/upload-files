package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.RRect;
import com.microsoft.clarity.models.display.common.Rect;
import com.microsoft.clarity.models.display.images.CubicSampling;
import com.microsoft.clarity.models.display.images.NonCubicSampling;
import com.microsoft.clarity.models.display.images.Sampling;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g extends C0109c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(byte[] bytes, int i, int i2) {
        super(bytes, i, i2);
        Intrinsics.checkNotNullParameter(bytes, "bytes");
    }

    public final String g() {
        String str = ((("" + ((char) this.f171a[this.d + 3])) + ((char) this.f171a[this.d + 2])) + ((char) this.f171a[this.d + 1])) + ((char) this.f171a[this.d]);
        this.d += 4;
        return str;
    }

    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 9; i++) {
            arrayList.add(Float.valueOf(c()));
        }
        return arrayList;
    }

    public final ArrayList i() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 16; i++) {
            arrayList.add(Float.valueOf(c()));
        }
        int rint = (int) Math.rint(Math.sqrt(arrayList.size()));
        for (int i2 = 0; i2 < rint; i2++) {
            for (int i3 = 0; i3 < i2; i3++) {
                Collections.swap(arrayList, (i3 * rint) + i2, (i2 * rint) + i3);
            }
        }
        return arrayList;
    }

    public final int j() {
        int m2584constructorimpl = UByte.m2584constructorimpl(this.f171a[this.d]) & 255;
        this.d++;
        return m2584constructorimpl != 254 ? m2584constructorimpl != 255 ? UInt.m2662constructorimpl(m2584constructorimpl) : f() : e();
    }

    public final RRect k() {
        float c = c();
        float c2 = c();
        float c3 = c();
        float c4 = c();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
                arrayList2.add(Float.valueOf(c()));
            }
            arrayList.add(arrayList2);
        }
        return new RRect(c, c2, c3, c4, arrayList);
    }

    public final Rect l() {
        return new Rect(c(), c(), c(), c());
    }

    public final Sampling m() {
        return d() != 0 ? new CubicSampling(c(), c()) : new NonCubicSampling(d(), d());
    }
}
