package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.images.Image;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public final class u extends o {
    public final long b;
    public final v c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(long j, com.microsoft.clarity.e.C c, v parserFactory) {
        super(new w(), c);
        Intrinsics.checkNotNullParameter(parserFactory, "parserFactory");
        parserFactory.getClass();
        this.b = j;
        this.c = parserFactory;
    }

    @Override // com.microsoft.clarity.i.o
    public final boolean b() {
        return false;
    }

    @Override // com.microsoft.clarity.i.o
    public final ImageShader c(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int f = buffer.f();
        int f2 = buffer.f();
        ArrayList h = buffer.h();
        v vVar = this.c;
        long j = this.b;
        vVar.getClass();
        InterfaceC0111e jVar = j < 78 ? new j() : new i();
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Object a2 = jVar.a(buffer);
        Intrinsics.checkNotNull(a2);
        return new ImageShader(f & BodyPartID.bodyIdMax, f2 & BodyPartID.bodyIdMax, h, false, (Image) a2, null);
    }

    @Override // com.microsoft.clarity.i.o
    public final boolean c() {
        return true;
    }
}
