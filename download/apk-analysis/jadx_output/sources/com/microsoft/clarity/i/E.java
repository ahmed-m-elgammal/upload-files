package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.Point;
import com.microsoft.clarity.models.display.common.Vertices;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public final class E extends C {
    @Override // com.microsoft.clarity.i.C
    /* renamed from: b */
    public final Vertices a(g buffer) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        ArrayList arrayList3;
        ArrayList<ArrayList> arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.f();
        int f = buffer.f();
        int d = buffer.d();
        int d2 = buffer.d();
        boolean z = UInt.m2662constructorimpl(f & 256) != 0;
        boolean z2 = UInt.m2662constructorimpl(f & 512) != 0;
        int m2662constructorimpl = UInt.m2662constructorimpl(f & 255);
        boolean z3 = UInt.m2662constructorimpl(f & 1024) != 0;
        boolean z4 = UInt.m2662constructorimpl(f & 2048) == 0;
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        for (int i2 = 0; i2 < d; i2++) {
            arrayList8.add(new Point(buffer.c(), buffer.c()));
        }
        if (z) {
            ArrayList arrayList10 = new ArrayList();
            for (int i3 = 0; i3 < d; i3++) {
                arrayList10.add(new Point(buffer.c(), buffer.c()));
            }
            arrayList = arrayList10;
        } else {
            arrayList = null;
        }
        if (z2) {
            arrayList2 = new ArrayList();
            for (int i4 = 0; i4 < d; i4++) {
                arrayList2.add(UInt.m2656boximpl(buffer.f()));
            }
        } else {
            arrayList2 = null;
        }
        if (z3) {
            arrayList4 = new ArrayList();
            ArrayList arrayList11 = new ArrayList();
            for (int i5 = 0; i5 < d; i5++) {
                arrayList4.add(CollectionsKt.arrayListOf(UInt.m2656boximpl(buffer.f()), UInt.m2656boximpl(buffer.f()), UInt.m2656boximpl(buffer.f()), UInt.m2656boximpl(buffer.f())));
            }
            int i6 = 0;
            while (i6 < d) {
                arrayList11.add(CollectionsKt.arrayListOf(Float.valueOf(buffer.c()), Float.valueOf(buffer.c()), Float.valueOf(buffer.c()), Float.valueOf(buffer.c())));
                i6++;
                arrayList4 = arrayList4;
            }
            i = 0;
            arrayList3 = arrayList11;
        } else {
            i = 0;
            arrayList3 = null;
            arrayList4 = null;
        }
        for (int i7 = i; i7 < d2; i7++) {
            arrayList9.add(UInt.m2656boximpl(buffer.e()));
        }
        int i8 = d * 8;
        int i9 = z ? i8 : i;
        int i10 = z2 ? d * 4 : i;
        int i11 = z3 ? d * 16 : i;
        int i12 = z3 ? d * 16 : i;
        int i13 = d2 * 2;
        buffer.d += (((((UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(((((i8 + i9) + i10) + i11) + i12) + i13) + 3) >>> 2) << 2) - i8) - i9) - i10) - i11) - i12) - i13;
        long j = m2662constructorimpl & BodyPartID.bodyIdMax;
        int i14 = 10;
        if (arrayList2 != null) {
            arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList5.add(Long.valueOf(((UInt) it.next()).getData() & BodyPartID.bodyIdMax));
            }
        } else {
            arrayList5 = null;
        }
        if (arrayList4 != null) {
            arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            for (ArrayList arrayList12 : arrayList4) {
                ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList12, i14));
                Iterator it2 = arrayList12.iterator();
                while (it2.hasNext()) {
                    arrayList13.add(Long.valueOf(((UInt) it2.next()).getData() & BodyPartID.bodyIdMax));
                    arrayList9 = arrayList9;
                }
                arrayList7.add(arrayList13);
                i14 = 10;
            }
            arrayList6 = arrayList9;
        } else {
            arrayList6 = arrayList9;
            arrayList7 = null;
        }
        ArrayList arrayList14 = arrayList6;
        ArrayList arrayList15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList14, 10));
        Iterator it3 = arrayList14.iterator();
        while (it3.hasNext()) {
            arrayList15.add(Long.valueOf(((UInt) it3.next()).getData() & BodyPartID.bodyIdMax));
        }
        return new Vertices(j, z4, arrayList8, arrayList, arrayList5, arrayList7, arrayList3, arrayList15);
    }
}
