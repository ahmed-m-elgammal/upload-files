package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.models.display.paints.colorfilters.ModeColorFilter;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public class s extends r {
    public final long f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(long j, com.microsoft.clarity.e.C c, v parserFactory) {
        super(j, c, parserFactory);
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        this.f = j;
    }

    @Override // com.microsoft.clarity.i.r, com.microsoft.clarity.i.q, com.microsoft.clarity.i.p
    public long d() {
        return this.f;
    }

    @Override // com.microsoft.clarity.i.o
    public final ModeColorFilter e(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return new ModeColorFilter(null, new Color4f(buffer.c(), buffer.c(), buffer.c(), buffer.c()), buffer.f() & BodyPartID.bodyIdMax);
    }
}
