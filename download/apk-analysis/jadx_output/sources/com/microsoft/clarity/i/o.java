package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.common.Flattenable;
import com.microsoft.clarity.models.display.images.Sampling;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.models.display.paints.Paint;
import com.microsoft.clarity.models.display.paints.colorfilters.ColorFilter;
import com.microsoft.clarity.models.display.paints.colorfilters.ModeColorFilter;
import com.microsoft.clarity.models.display.paints.loopers.Looper;
import com.microsoft.clarity.models.display.paints.maskfilters.MaskFilter;
import com.microsoft.clarity.models.display.paints.patheffects.PathEffect;
import com.microsoft.clarity.models.display.paints.shaders.GradientShaderDescriptor;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import com.microsoft.clarity.models.display.paints.shaders.Shader;
import java.util.ArrayList;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public abstract class o implements f {

    /* renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.e.C f174a;

    public o(w pathParser, com.microsoft.clarity.e.C c) {
        Intrinsics.checkNotNullParameter(pathParser, "pathParser");
        this.f174a = c;
    }

    public static GradientShaderDescriptor b(g gVar) {
        ArrayList arrayList;
        int f = gVar.f();
        int m2662constructorimpl = UInt.m2662constructorimpl(UInt.m2662constructorimpl(f >>> 8) & 15);
        int m2662constructorimpl2 = UInt.m2662constructorimpl(UInt.m2662constructorimpl(f) & 255);
        int f2 = gVar.f();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < f2; i++) {
            arrayList2.add(new Color4f(gVar.c(), gVar.c(), gVar.c(), gVar.c()));
        }
        if (UInt.m2662constructorimpl(536870912 & f) != 0) {
            gVar.d += gVar.f();
        }
        if (UInt.m2662constructorimpl(Integer.MIN_VALUE & f) != 0) {
            ArrayList arrayList3 = new ArrayList();
            int f3 = gVar.f();
            for (int i2 = 0; i2 < f3; i2++) {
                arrayList3.add(Float.valueOf(gVar.c()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        return new GradientShaderDescriptor(m2662constructorimpl & BodyPartID.bodyIdMax, m2662constructorimpl2 & BodyPartID.bodyIdMax, arrayList2, arrayList, UInt.m2662constructorimpl(f & 1073741824) != 0 ? gVar.h() : null);
    }

    public final Paint a(g gVar, ArrayList arrayList) {
        MaskFilter maskFilter;
        ColorFilter colorFilter;
        Shader shader;
        Looper looper;
        PathEffect pathEffect;
        ColorFilter colorFilter2;
        Looper looper2;
        float c = gVar.c();
        float c2 = gVar.c();
        Color4f color4f = new Color4f(gVar.c(), gVar.c(), gVar.c(), gVar.c());
        int f = gVar.f();
        boolean z = UInt.m2662constructorimpl(f & 1) != 0;
        boolean z2 = UInt.m2662constructorimpl(f & 2) != 0;
        int m2662constructorimpl = UInt.m2662constructorimpl(f >>> 8);
        int m2662constructorimpl2 = UInt.m2662constructorimpl(m2662constructorimpl & 255);
        int m2662constructorimpl3 = UInt.m2662constructorimpl(m2662constructorimpl >>> 8);
        int m2662constructorimpl4 = UInt.m2662constructorimpl(m2662constructorimpl3 & 3);
        int m2662constructorimpl5 = UInt.m2662constructorimpl(m2662constructorimpl3 >>> 2);
        int m2662constructorimpl6 = UInt.m2662constructorimpl(m2662constructorimpl5 & 3);
        int m2662constructorimpl7 = UInt.m2662constructorimpl(m2662constructorimpl5 >>> 2);
        int m2662constructorimpl8 = UInt.m2662constructorimpl(m2662constructorimpl7 & 3);
        if (UInt.m2662constructorimpl(UInt.m2662constructorimpl(m2662constructorimpl7 >>> 4) & 2) != 0) {
            PathEffect pathEffect2 = (PathEffect) a(gVar, arrayList, Reflection.getOrCreateKotlinClass(PathEffect.class), false);
            Shader shader2 = (Shader) a(gVar, arrayList, Reflection.getOrCreateKotlinClass(Shader.class), false);
            MaskFilter maskFilter2 = (MaskFilter) a(gVar, arrayList, Reflection.getOrCreateKotlinClass(MaskFilter.class), false);
            ColorFilter colorFilter3 = (ColorFilter) a(gVar, arrayList, Reflection.getOrCreateKotlinClass(ColorFilter.class), false);
            if (c()) {
                colorFilter2 = colorFilter3;
                looper2 = (Looper) a(gVar, arrayList, Reflection.getOrCreateKotlinClass(Looper.class), false);
            } else {
                colorFilter2 = colorFilter3;
                looper2 = null;
            }
            a(gVar, arrayList, Reflection.getOrCreateKotlinClass(Flattenable.class), true);
            if (b()) {
                a(gVar, arrayList, Reflection.getOrCreateKotlinClass(Flattenable.class), true);
            }
            maskFilter = maskFilter2;
            shader = shader2;
            looper = looper2;
            colorFilter = colorFilter2;
            pathEffect = pathEffect2;
        } else {
            maskFilter = null;
            colorFilter = null;
            shader = null;
            looper = null;
            pathEffect = null;
        }
        return new Paint(color4f, m2662constructorimpl8 & BodyPartID.bodyIdMax, m2662constructorimpl2 & BodyPartID.bodyIdMax, m2662constructorimpl4 & BodyPartID.bodyIdMax, m2662constructorimpl6 & BodyPartID.bodyIdMax, c, c2, z, z2, colorFilter, maskFilter, shader, looper, pathEffect);
    }

    public abstract boolean b();

    public abstract ImageShader c(g gVar);

    public abstract boolean c();

    public Sampling d(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return buffer.m();
    }

    public ModeColorFilter e(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return new ModeColorFilter(Long.valueOf(buffer.f() & BodyPartID.bodyIdMax), null, buffer.f() & BodyPartID.bodyIdMax);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x040d, code lost:
    
        if (r4.equals("SkPath1DPathEffectImpl") == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0419, code lost:
    
        r11 = r19.c();
        r12 = com.microsoft.clarity.i.w.b(r19);
        r13 = r19.c();
        r14 = r19.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x042b, code lost:
    
        if (r12 != null) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x042f, code lost:
    
        r1 = new com.microsoft.clarity.models.display.paints.patheffects.Path1DPathEffect(r11, r12, r13, r14, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0416, code lost:
    
        if (r4.equals("SkPath1DPathEffect") == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009c, code lost:
    
        if (r4.equals("SkBlendModeColorFilter") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b5, code lost:
    
        if (r4.equals("SkColorMatrixFilterRowMajor255") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00dd, code lost:
    
        r12 = new java.util.ArrayList();
        r2 = r19.d();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e7, code lost:
    
        if (r3 >= r2) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e9, code lost:
    
        r12.add(java.lang.Float.valueOf(r19.c()));
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fb, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4, "SkColorMatrixFilterRowMajor255") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010e, code lost:
    
        if (r19.f() != 1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0111, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bf, code lost:
    
        if (r4.equals("SkModeColorFilter") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cf, code lost:
    
        if (r4.equals("SkColorFilter_Matrix") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d9, code lost:
    
        if (r4.equals("SkMatrixColorFilter") == false) goto L76;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.microsoft.clarity.models.display.common.Flattenable a(com.microsoft.clarity.i.g r19, java.util.ArrayList r20, kotlin.reflect.KClass r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 1274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.i.o.a(com.microsoft.clarity.i.g, java.util.ArrayList, kotlin.reflect.KClass, boolean):com.microsoft.clarity.models.display.common.Flattenable");
    }
}
