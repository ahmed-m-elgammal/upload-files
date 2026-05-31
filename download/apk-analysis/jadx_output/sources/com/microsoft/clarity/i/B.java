package com.microsoft.clarity.i;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.microsoft.clarity.models.display.typefaces.FontCoordinate;
import com.microsoft.clarity.models.display.typefaces.FontStyle;
import com.microsoft.clarity.models.display.typefaces.Typeface;
import java.security.MessageDigest;
import java.util.ArrayList;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public abstract class B implements InterfaceC0111e {
    public static Typeface b(g buffer) {
        int compare;
        C0108b a2;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int j = buffer.j();
        int m2662constructorimpl = UInt.m2662constructorimpl(UInt.m2662constructorimpl(j >>> 16) & 65535);
        int i = 255;
        int m2662constructorimpl2 = UInt.m2662constructorimpl(UInt.m2662constructorimpl(j >>> 8) & 255);
        int m2662constructorimpl3 = UInt.m2662constructorimpl(j & 255);
        UInt uInt = null;
        UInt uInt2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        Float f = null;
        Float f2 = null;
        Float f3 = null;
        Float f4 = null;
        ArrayList arrayList = null;
        while (true) {
            int j2 = buffer.j();
            if (j2 == 1) {
                str = buffer.a(buffer.j());
            } else if (j2 == 4) {
                str2 = buffer.a(buffer.j());
            } else if (j2 != 6) {
                int i2 = 0;
                if (j2 != i) {
                    switch (j2) {
                        case 16:
                            f = Float.valueOf(buffer.c());
                        case 17:
                            f2 = Float.valueOf(buffer.c());
                        case 18:
                            f3 = Float.valueOf(buffer.c());
                        case 19:
                            f4 = Float.valueOf(buffer.c());
                        default:
                            switch (j2) {
                                case 248:
                                    uInt2 = UInt.m2656boximpl(buffer.j());
                                    break;
                                case 249:
                                    int j3 = buffer.j();
                                    while (i2 < j3) {
                                        buffer.j();
                                        buffer.g();
                                        i2++;
                                    }
                                    break;
                                case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                    int j4 = buffer.j();
                                    ArrayList arrayList2 = new ArrayList();
                                    while (i2 < j4) {
                                        arrayList2.add(new FontCoordinate(buffer.g(), buffer.c()));
                                        i2++;
                                        j4 = j4;
                                        i = 255;
                                    }
                                    arrayList = arrayList2;
                                case 251:
                                    int j5 = buffer.j();
                                    while (i2 < j5) {
                                        buffer.d();
                                        i2++;
                                    }
                                    break;
                                case 252:
                                    buffer.j();
                                    break;
                                case 253:
                                    uInt = UInt.m2656boximpl(buffer.j());
                            }
                            break;
                    }
                } else {
                    int j6 = buffer.j();
                    compare = Integer.compare(j6 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                    if (compare > 0) {
                        if (j6 <= 0) {
                            throw new IllegalArgumentException("Cannot read 0 length segment of the byte buffer!");
                        }
                        MessageDigest messageDigest = com.microsoft.clarity.m.b.f189a;
                        a2 = com.microsoft.clarity.m.b.a(buffer.f171a, buffer.d, j6);
                        buffer.d += j6;
                    }
                }
            } else {
                str3 = buffer.a(buffer.j());
            }
            i = 255;
        }
        a2 = null;
        if (a2 == null) {
            return null;
        }
        return new Typeface(str, str2, str3, new FontStyle(m2662constructorimpl & BodyPartID.bodyIdMax, m2662constructorimpl2 & BodyPartID.bodyIdMax, m2662constructorimpl3 & BodyPartID.bodyIdMax), uInt != null ? Long.valueOf(uInt.getData() & BodyPartID.bodyIdMax) : null, f, f2, f3, f4, uInt2 != null ? Long.valueOf(uInt2.getData() & BodyPartID.bodyIdMax) : null, arrayList, a2.f170a, a2.b);
    }
}
