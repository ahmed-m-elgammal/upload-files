package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.Point;
import com.microsoft.clarity.models.display.common.RRect;
import com.microsoft.clarity.models.display.paths.AddRRectPathVerb;
import com.microsoft.clarity.models.display.paths.ClosePathVerb;
import com.microsoft.clarity.models.display.paths.ConicPathVerb;
import com.microsoft.clarity.models.display.paths.CubicPathVerb;
import com.microsoft.clarity.models.display.paths.DonePathVerb;
import com.microsoft.clarity.models.display.paths.LinePathVerb;
import com.microsoft.clarity.models.display.paths.MovePathVerb;
import com.microsoft.clarity.models.display.paths.Path;
import com.microsoft.clarity.models.display.paths.PathVerb;
import com.microsoft.clarity.models.display.paths.QuadPathVerb;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class w implements InterfaceC0111e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v21, types: [java.util.List] */
    public static Path b(g buffer) {
        int i;
        PathVerb movePathVerb;
        PathVerb pathVerb;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int d = buffer.d();
        int i2 = d & 255;
        int i3 = (d >> 8) & 3;
        if (i2 <= 3) {
            return null;
        }
        if (i2 != 4 && i2 != 5) {
            return null;
        }
        int i4 = 0;
        if (((d >> 28) & 15) != 0) {
            boolean z = ((d >> 26) & 3) != 0;
            RRect k = buffer.k();
            buffer.f();
            return new Path(i3, CollectionsKt.arrayListOf(new AddRRectPathVerb(k, z)));
        }
        boolean z2 = i2 != 5;
        int d2 = buffer.d();
        int d3 = buffer.d();
        int d4 = buffer.d();
        int i5 = (d3 * 4) + (d2 * 8) + d4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ?? arrayList3 = new ArrayList();
        for (int i6 = 0; i6 < d2; i6++) {
            arrayList.add(new Point(buffer.c(), buffer.c()));
        }
        for (int i7 = 0; i7 < d3; i7++) {
            arrayList2.add(Float.valueOf(buffer.c()));
        }
        for (int i8 = 0; i8 < d4; i8++) {
            arrayList3.add(Integer.valueOf(buffer.b()));
        }
        if (z2) {
            arrayList3 = CollectionsKt.asReversedMutable(arrayList3);
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it = arrayList3.iterator();
        int i9 = 0;
        while (it.hasNext()) {
            switch (((Number) it.next()).intValue()) {
                case 0:
                    i = i4 + 1;
                    movePathVerb = new MovePathVerb(((Point) arrayList.get(i4)).getX(), ((Point) arrayList.get(i4)).getY());
                    i4 = i;
                    pathVerb = movePathVerb;
                    break;
                case 1:
                    i = i4 + 1;
                    movePathVerb = new LinePathVerb(((Point) arrayList.get(i4)).getX(), ((Point) arrayList.get(i4)).getY());
                    i4 = i;
                    pathVerb = movePathVerb;
                    break;
                case 2:
                    i = i4 + 2;
                    float x = ((Point) arrayList.get(i4)).getX();
                    float y = ((Point) arrayList.get(i4)).getY();
                    int i10 = i4 + 1;
                    movePathVerb = new QuadPathVerb(x, y, ((Point) arrayList.get(i10)).getX(), ((Point) arrayList.get(i10)).getY());
                    i4 = i;
                    pathVerb = movePathVerb;
                    break;
                case 3:
                    int i11 = i4 + 2;
                    int i12 = i9 + 1;
                    float x2 = ((Point) arrayList.get(i4)).getX();
                    float y2 = ((Point) arrayList.get(i4)).getY();
                    int i13 = i4 + 1;
                    float x3 = ((Point) arrayList.get(i13)).getX();
                    float y3 = ((Point) arrayList.get(i13)).getY();
                    Object obj = arrayList2.get(i9);
                    Intrinsics.checkNotNullExpressionValue(obj, "conics[conicIndex - 1]");
                    PathVerb conicPathVerb = new ConicPathVerb(x2, y2, x3, y3, ((Number) obj).floatValue());
                    i4 = i11;
                    i9 = i12;
                    pathVerb = conicPathVerb;
                    break;
                case 4:
                    i = i4 + 3;
                    float x4 = ((Point) arrayList.get(i4)).getX();
                    float y4 = ((Point) arrayList.get(i4)).getY();
                    int i14 = i4 + 1;
                    int i15 = i4 + 2;
                    movePathVerb = new CubicPathVerb(x4, y4, ((Point) arrayList.get(i14)).getX(), ((Point) arrayList.get(i14)).getY(), ((Point) arrayList.get(i15)).getX(), ((Point) arrayList.get(i15)).getY());
                    i4 = i;
                    pathVerb = movePathVerb;
                    break;
                case 5:
                    pathVerb = new ClosePathVerb();
                    break;
                case 6:
                    pathVerb = new DonePathVerb();
                    break;
                default:
                    pathVerb = null;
                    break;
            }
            if (pathVerb != null) {
                arrayList4.add(pathVerb);
            }
        }
        buffer.d += UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(i5) + 3) >>> 2) << 2) - i5;
        return new Path(i3, arrayList4);
    }

    @Override // com.microsoft.clarity.i.InterfaceC0111e
    public final /* bridge */ /* synthetic */ Object a(g gVar) {
        return b(gVar);
    }
}
