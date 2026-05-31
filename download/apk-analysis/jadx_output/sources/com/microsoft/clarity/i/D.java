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
public final class D extends C {
    @Override // com.microsoft.clarity.i.C
    /* renamed from: b */
    public final Vertices a(g buffer) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int f = buffer.f();
        int d = buffer.d();
        int d2 = buffer.d();
        boolean z = UInt.m2662constructorimpl(f & 256) != 0;
        boolean z2 = UInt.m2662constructorimpl(f & 512) != 0;
        int m2662constructorimpl = UInt.m2662constructorimpl(f & 255);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        buffer.f();
        for (int i = 0; i < d; i++) {
            arrayList4.add(new Point(buffer.c(), buffer.c()));
        }
        if (buffer.f() != 0) {
            ArrayList arrayList6 = new ArrayList();
            for (int i2 = 0; i2 < d; i2++) {
                arrayList6.add(new Point(buffer.c(), buffer.c()));
            }
            arrayList = arrayList6;
        } else {
            arrayList = null;
        }
        if (buffer.f() != 0) {
            arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < d; i3++) {
                arrayList2.add(UInt.m2656boximpl(buffer.f()));
            }
        } else {
            arrayList2 = null;
        }
        buffer.f();
        for (int i4 = 0; i4 < d2; i4++) {
            arrayList5.add(UInt.m2656boximpl(buffer.e()));
        }
        int i5 = d * 8;
        int i6 = z ? i5 : 0;
        int i7 = z2 ? d * 4 : 0;
        int i8 = d2 * 2;
        buffer.d += (((UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(((i5 + i6) + i7) + i8) + 3) >>> 2) << 2) - i5) - i6) - i7) - i8;
        long j = m2662constructorimpl & BodyPartID.bodyIdMax;
        if (arrayList2 != null) {
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList7.add(Long.valueOf(((UInt) it.next()).getData() & BodyPartID.bodyIdMax));
            }
            arrayList3 = arrayList7;
        } else {
            arrayList3 = null;
        }
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it2 = arrayList5.iterator();
        while (it2.hasNext()) {
            arrayList8.add(Long.valueOf(((UInt) it2.next()).getData() & BodyPartID.bodyIdMax));
        }
        return new Vertices(j, false, arrayList4, arrayList, arrayList3, null, null, arrayList8);
    }
}
