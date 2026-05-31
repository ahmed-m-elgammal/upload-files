package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.images.AnisoSampling;
import com.microsoft.clarity.models.display.images.Sampling;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class r extends q {
    public final long e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(long j, com.microsoft.clarity.e.C c, v parserFactory) {
        super(j, c, parserFactory);
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        this.e = j;
    }

    @Override // com.microsoft.clarity.i.q, com.microsoft.clarity.i.p
    public long d() {
        return this.e;
    }

    @Override // com.microsoft.clarity.i.o
    public final Sampling d(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int d = buffer.d();
        AnisoSampling anisoSampling = d != 0 ? new AnisoSampling(d) : null;
        return anisoSampling != null ? anisoSampling : buffer.m();
    }
}
