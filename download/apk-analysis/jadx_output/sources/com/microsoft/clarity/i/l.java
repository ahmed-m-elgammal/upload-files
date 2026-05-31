package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.commands.DrawVertices;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public class l extends k {
    public final com.microsoft.clarity.e.C d;

    public l(com.microsoft.clarity.e.C c) {
        this.d = c;
    }

    @Override // com.microsoft.clarity.i.f
    public com.microsoft.clarity.h.a a() {
        return this.d;
    }

    @Override // com.microsoft.clarity.i.k
    public final DrawVertices c(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int d = buffer.d() - 1;
        int d2 = buffer.d() - 1;
        buffer.d();
        return new DrawVertices(d2, buffer.f() & BodyPartID.bodyIdMax, d, null);
    }
}
