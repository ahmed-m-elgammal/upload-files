package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.commands.DrawVertices;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public final class n extends k {
    public final com.microsoft.clarity.e.C d;

    public n(com.microsoft.clarity.e.C c) {
        this.d = c;
    }

    @Override // com.microsoft.clarity.i.f
    public final com.microsoft.clarity.h.a a() {
        return this.d;
    }

    @Override // com.microsoft.clarity.i.k
    public final DrawVertices c(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int d = buffer.d() - 1;
        int d2 = buffer.d() - 1;
        int d3 = buffer.d();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < d3; i++) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 6; i2++) {
                arrayList2.add(Float.valueOf(buffer.c()));
            }
            arrayList.add(arrayList2);
        }
        return new DrawVertices(d2, BodyPartID.bodyIdMax & buffer.f(), d, arrayList);
    }
}
