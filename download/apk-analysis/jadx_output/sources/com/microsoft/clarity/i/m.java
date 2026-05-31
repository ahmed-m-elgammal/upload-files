package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.images.AnisoSampling;
import com.microsoft.clarity.models.display.images.Sampling;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class m extends l {
    public final com.microsoft.clarity.e.C e;

    public m(long j, com.microsoft.clarity.e.C c) {
        super(c);
        this.e = c;
    }

    @Override // com.microsoft.clarity.i.l, com.microsoft.clarity.i.f
    public final com.microsoft.clarity.h.a a() {
        return this.e;
    }

    @Override // com.microsoft.clarity.i.k
    public final Sampling e(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int d = buffer.d();
        AnisoSampling anisoSampling = d != 0 ? new AnisoSampling(d) : null;
        return anisoSampling != null ? anisoSampling : buffer.m();
    }
}
