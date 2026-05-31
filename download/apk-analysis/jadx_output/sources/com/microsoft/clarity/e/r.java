package com.microsoft.clarity.e;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.f.C0092j;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.models.viewhierarchy.ViewNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Context f92a;
    public final ClarityConfig b;
    public final DynamicConfig c;
    public final C0092j d;
    public final DisplayMetrics e;
    public final LinkedHashSet f;
    public final LinkedHashSet g;
    public final C0063f h;
    public final Integer i;
    public final LinkedHashMap j;
    public final LinkedHashMap k;
    public ScreenMetadata l;
    public final Class m;
    public final int n;

    public r(Context context, ClarityConfig config, DynamicConfig dynamicConfig, C0092j errorCallback) {
        Integer num;
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        this.f92a = context;
        this.b = config;
        this.c = dynamicConfig;
        this.d = errorCallback;
        this.e = context.getResources().getDisplayMetrics();
        this.f = new LinkedHashSet();
        this.g = new LinkedHashSet();
        this.h = new C0063f(errorCallback);
        Class cls = null;
        try {
            num = Integer.valueOf(context.getResources().getIdentifier("fragment_container_view_tag", "id", context.getPackageName()));
        } catch (Exception unused) {
            num = null;
        }
        this.i = num;
        this.j = new LinkedHashMap();
        this.k = new LinkedHashMap();
        try {
            HashMap hashMap = com.microsoft.clarity.m.j.f193a;
            cls = com.microsoft.clarity.m.i.a("com.facebook.react.views.view.ReactViewGroup");
        } catch (Exception unused2) {
        }
        this.m = cls;
        boolean z = (this.f92a.getResources().getConfiguration().uiMode & 48) == 32;
        try {
            i = this.f92a.getResources().getColor(Build.VERSION.SDK_INT >= 34 ? z ? R.color.system_background_dark : R.color.system_background_light : z ? R.color.background_dark : R.color.background_light, this.f92a.getTheme());
        } catch (Exception unused3) {
            i = z ? ViewCompat.MEASURED_STATE_MASK : -1;
        }
        this.n = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:202:0x0143, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7, r28) != false) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.microsoft.clarity.models.observers.FramePicture a(android.app.Activity r28, com.microsoft.clarity.models.observers.ScreenMetadata r29, boolean r30, boolean r31, boolean r32, kotlin.jvm.functions.Function1 r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 1373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.e.r.a(android.app.Activity, com.microsoft.clarity.models.observers.ScreenMetadata, boolean, boolean, boolean, kotlin.jvm.functions.Function1, boolean):com.microsoft.clarity.models.observers.FramePicture");
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x02c3, code lost:
    
        if (r10 == r4) goto L153;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x070c A[Catch: all -> 0x0923, TryCatch #2 {all -> 0x0923, blocks: (B:167:0x0708, B:169:0x070c, B:171:0x0710, B:173:0x0719, B:174:0x076c, B:175:0x0782, B:177:0x0788), top: B:166:0x0708 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0936  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x07c6 A[Catch: all -> 0x0921, TryCatch #0 {all -> 0x0921, blocks: (B:180:0x07a2, B:189:0x07ad, B:191:0x07b9, B:192:0x07c0, B:194:0x07c6, B:196:0x07ca, B:198:0x07d2, B:200:0x07f0, B:201:0x0816, B:202:0x0847, B:204:0x084b, B:205:0x0850, B:209:0x086b, B:210:0x0886, B:213:0x08d0, B:217:0x08e7, B:220:0x08fa, B:221:0x08e3, B:222:0x08ce, B:223:0x0863), top: B:179:0x07a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0904  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0601 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f7  */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.microsoft.clarity.models.viewhierarchy.ViewNode a(android.view.View r40, android.view.ViewGroup r41, boolean r42, boolean r43, com.microsoft.clarity.e.C0065h r44) {
        /*
            Method dump skipped, instructions count: 2384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.e.r.a(android.view.View, android.view.ViewGroup, boolean, boolean, com.microsoft.clarity.e.h):com.microsoft.clarity.models.viewhierarchy.ViewNode");
    }

    public static final void a(WeakReference viewWeakRef, r this$0, ViewNode node) {
        C0066i c0066i;
        Intrinsics.checkNotNullParameter(viewWeakRef, "$viewWeakRef");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(node, "$node");
        View view = (View) viewWeakRef.get();
        if (view == null || !view.isDirty() || (c0066i = (C0066i) this$0.j.get(Long.valueOf(node.getRenderNodeId()))) == null) {
            return;
        }
        c0066i.b = true;
    }

    public static ArrayList a(ViewGroup viewGroup) {
        int childDrawingOrder;
        try {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                childDrawingOrder = viewGroup.getChildDrawingOrder(i);
                View childToDraw = viewGroup.getChildAt(childDrawingOrder);
                int i2 = i;
                while (i2 > 0 && ((View) arrayList.get(i2 - 1)).getZ() > childToDraw.getZ()) {
                    i2--;
                }
                Intrinsics.checkNotNullExpressionValue(childToDraw, "childToDraw");
                arrayList.add(i2, childToDraw);
            }
            return arrayList;
        } catch (Exception unused) {
            int childCount2 = viewGroup.getChildCount();
            ArrayList arrayList2 = new ArrayList(childCount2);
            for (int i3 = 0; i3 < childCount2; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt, "viewGroup.getChildAt(i)");
                arrayList2.add(childAt);
            }
            if (arrayList2.size() > 1) {
                CollectionsKt.sortWith(arrayList2, new C0072o());
            }
            return arrayList2;
        }
    }

    public final void a() {
        ViewTreeObserver viewTreeObserver;
        LinkedHashMap linkedHashMap = this.j;
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Number) ((Map.Entry) it.next()).getKey()).longValue()));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            long longValue = ((Number) it2.next()).longValue();
            C0066i c0066i = (C0066i) this.j.get(Long.valueOf(longValue));
            if (c0066i != null) {
                View view = (View) c0066i.f85a.get();
                if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                    viewTreeObserver.removeOnDrawListener(c0066i.e);
                }
                this.j.remove(Long.valueOf(longValue));
            }
        }
    }
}
