package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class q extends p {
    public final long d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(long j, com.microsoft.clarity.e.C c, v parserFactory) {
        super(j, c, parserFactory);
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        this.d = j;
    }

    @Override // com.microsoft.clarity.i.p, com.microsoft.clarity.i.o
    public final boolean b() {
        return true;
    }

    @Override // com.microsoft.clarity.i.p, com.microsoft.clarity.i.o
    public final boolean c() {
        return false;
    }

    @Override // com.microsoft.clarity.i.p
    public long d() {
        return this.d;
    }

    @Override // com.microsoft.clarity.i.p
    public boolean e() {
        return !(this instanceof t);
    }

    @Override // com.microsoft.clarity.i.p, com.microsoft.clarity.i.o
    public final ImageShader c(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ImageShader c = super.c(buffer);
        return new ImageShader(c.getTX(), c.getTY(), c.getMatrix(), buffer.f() != 0, c.getImage(), c.getSampling());
    }
}
