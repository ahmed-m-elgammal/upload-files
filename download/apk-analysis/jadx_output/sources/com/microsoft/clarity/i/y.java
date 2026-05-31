package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.SkiaPictureHeader;
import com.microsoft.clarity.models.display.paints.Paint;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import com.microsoft.clarity.models.display.paints.shaders.LocalMatrixShader;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final v f176a;
    public final com.microsoft.clarity.e.C b;

    public y(v factory, com.microsoft.clarity.e.C c) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.f176a = factory;
        this.b = c;
    }

    public final C0110d a(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.areEqual(buffer.a(8), "skiapict");
        int f = buffer.f();
        buffer.l();
        buffer.b();
        x xVar = new x(new SkiaPictureHeader(f & BodyPartID.bodyIdMax).getPictureVersion(), this.b, this.f176a);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Object a2 = xVar.a(buffer);
        Intrinsics.checkNotNull(a2);
        C0110d c0110d = (C0110d) a2;
        ArrayList arrayList = c0110d.c;
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type java.util.ArrayList<com.microsoft.clarity.models.display.images.Image>{ kotlin.collections.TypeAliasesKt.ArrayList<com.microsoft.clarity.models.display.images.Image> }");
        Iterator it = c0110d.f.iterator();
        while (it.hasNext()) {
            Paint paint = (Paint) it.next();
            if (paint.getShader() != null && (paint.getShader() instanceof ImageShader)) {
                arrayList.add(((ImageShader) paint.getShader()).getImage());
                ((ImageShader) paint.getShader()).setImageIndex(Integer.valueOf(CollectionsKt.getLastIndex(arrayList)));
            } else if (paint.getShader() != null && (paint.getShader() instanceof LocalMatrixShader) && (((LocalMatrixShader) paint.getShader()).getShader() instanceof ImageShader)) {
                arrayList.add(((ImageShader) ((LocalMatrixShader) paint.getShader()).getShader()).getImage());
                ((ImageShader) ((LocalMatrixShader) paint.getShader()).getShader()).setImageIndex(Integer.valueOf(CollectionsKt.getLastIndex(arrayList)));
            }
        }
        return c0110d;
    }
}
