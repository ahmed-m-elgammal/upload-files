package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.commands.DrawVertices;
import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.models.display.images.Lattice;
import com.microsoft.clarity.models.display.images.Sampling;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public abstract class k implements InterfaceC0111e {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f173a = CollectionsKt.arrayListOf("UNUSED", "CLIP_PATH", "CLIP_REGION", "CLIP_RECT", "CLIP_RRECT", "CONCAT", "DRAW_BITMAP_RETIRED_2016_REMOVED_2018", "DRAW_BITMAP_MATRIX_RETIRED_2016_REMOVED_2018", "DRAW_BITMAP_NINE_RETIRED_2016_REMOVED_2018", "DRAW_BITMAP_RECT_RETIRED_2016_REMOVED_2018", "DRAW_CLEAR", "DRAW_DATA", "DRAW_OVAL", "DRAW_PAINT", "DRAW_PATH", "DRAW_PICTURE", "DRAW_POINTS", "DRAW_POS_TEXT_REMOVED_1_2019", "DRAW_POS_TEXT_TOP_BOTTOM_REMOVED_1_2019", "DRAW_POS_TEXT_H_REMOVED_1_2019", "DRAW_POS_TEXT_H_TOP_BOTTOM_REMOVED_1_2019", "DRAW_RECT", "DRAW_RRECT", "DRAW_SPRITE_RETIRED_2015_REMOVED_2018", "DRAW_TEXT_REMOVED_1_2019", "DRAW_TEXT_ON_PATH_RETIRED_08_2018_REMOVED_10_2018", "DRAW_TEXT_TOP_BOTTOM_REMOVED_1_2019", "DRAW_VERTICES_RETIRED_03_2017_REMOVED_01_2018", "RESTORE", "ROTATE", "SAVE", "SAVE_LAYER_SAVEFLAGS_DEPRECATED_2015_REMOVED_12_2020", "SCALE", "SET_MATRIX", "SKEW", "TRANSLATE", "NOOP", "BEGIN_COMMENT_GROUP_obsolete", "COMMENT_obsolete", "END_COMMENT_GROUP_obsolete", "DRAW_DRRECT", "PUSH_CULL", "POP_CULL", "DRAW_PATCH", "DRAW_PICTURE_MATRIX_PAINT", "DRAW_TEXT_BLOB", "DRAW_IMAGE", "DRAW_IMAGE_RECT_STRICT_obsolete", "DRAW_ATLAS", "DRAW_IMAGE_NINE", "DRAW_IMAGE_RECT", "SAVE_LAYER_SAVELAYERFLAGS_DEPRECATED_JAN_2016_REMOVED_01_2018", "SAVE_LAYER_SAVELAYERREC", "DRAW_ANNOTATION", "DRAW_DRAWABLE", "DRAW_DRAWABLE_MATRIX", "DRAW_TEXT_RSXFORM_DEPRECATED_DEC_2018", "TRANSLATE_Z", "DRAW_SHADOW_REC", "DRAW_IMAGE_LATTICE", "DRAW_ARC", "DRAW_REGION", "DRAW_VERTICES_OBJECT", "FLUSH", "DRAW_EDGEAA_IMAGE_SET", "SAVE_BEHIND", "DRAW_EDGEAA_QUAD", "DRAW_BEHIND_PAINT", "CONCAT44", "CLIP_SHADER_IN_PAINT", "MARK_CTM", "SET_M44", "DRAW_IMAGE2", "DRAW_IMAGE_RECT2", "DRAW_IMAGE_LATTICE2", "DRAW_EDGEAA_IMAGE_SET2");
    public static final Regex b = new Regex("id=([0-9]+),");
    public static final Regex c = new Regex("name='([^']+)'");

    public static Lattice d(g gVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int d = gVar.d();
        for (int i = 0; i < d; i++) {
            arrayList.add(Integer.valueOf(gVar.d()));
        }
        int d2 = gVar.d();
        for (int i2 = 0; i2 < d2; i2++) {
            arrayList2.add(Integer.valueOf(gVar.d()));
        }
        int d3 = gVar.d();
        int m2662constructorimpl = UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(UInt.m2662constructorimpl(d3) + 3) >>> 2) << 2);
        for (int i3 = 0; i3 < d3; i3++) {
            arrayList3.add(Integer.valueOf(gVar.b()));
        }
        gVar.d += m2662constructorimpl - d3;
        for (int i4 = 0; i4 < d3; i4++) {
            arrayList4.add(UInt.m2656boximpl(gVar.f()));
        }
        IRect iRect = new IRect(gVar.d(), gVar.d(), gVar.d(), gVar.d());
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        Iterator it = arrayList4.iterator();
        while (it.hasNext()) {
            arrayList5.add(Long.valueOf(((UInt) it.next()).getData() & BodyPartID.bodyIdMax));
        }
        return new Lattice(arrayList, arrayList2, arrayList3, iRect, arrayList5);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:211:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r8v33 */
    @Override // com.microsoft.clarity.i.InterfaceC0111e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.microsoft.clarity.models.display.commands.DisplayCommand a(com.microsoft.clarity.i.g r18) {
        /*
            Method dump skipped, instructions count: 1736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.i.k.a(com.microsoft.clarity.i.g):com.microsoft.clarity.models.display.commands.DisplayCommand");
    }

    public abstract DrawVertices c(g gVar);

    public Sampling e(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return buffer.m();
    }
}
