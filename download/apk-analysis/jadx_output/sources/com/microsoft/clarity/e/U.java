package com.microsoft.clarity.e;

import android.content.Context;
import androidx.webkit.ProxyConfig;
import com.microsoft.clarity.models.MaskingMode;
import com.microsoft.clarity.models.observers.FramePicture;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import com.microsoft.clarity.models.viewhierarchy.ViewNodeDelta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class U {

    /* renamed from: a, reason: collision with root package name */
    public final Context f76a;
    public final MaskingMode b;
    public LinkedHashMap c;
    public final LinkedHashMap d;
    public final Object e;

    public U(Context context, MaskingMode maskingMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(maskingMode, "maskingMode");
        this.f76a = context;
        this.b = maskingMode;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new Object();
    }

    public final void a() {
        synchronized (this.e) {
            this.c.clear();
            this.d.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(FramePicture framePicture) {
        Intrinsics.checkNotNullParameter(framePicture, "framePicture");
        synchronized (this.e) {
            if (framePicture.getIsFullFrame()) {
                this.c.clear();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ViewHierarchy viewHierarchy = framePicture.getViewHierarchy();
            C0080x c0080x = new C0080x(framePicture.getViewHierarchy().getRoot().getIsMasked(), this.b, framePicture.getViewHierarchy().getMaskedViewRenderNodeIds(), framePicture.getViewHierarchy().getUnmaskedViewRenderNodeIds());
            ViewNodeDelta a2 = a(linkedHashMap, this, c0080x, framePicture.getViewHierarchy().getRoot());
            if (c0080x.d.size() == 1) {
                viewHierarchy.setRootDelta(a2);
                this.c = linkedHashMap;
                if (this.d.size() >= 5000) {
                    com.microsoft.clarity.m.h.e("Clearing view entry name cache");
                    this.d.clear();
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new com.microsoft.clarity.c.a("Masking failed due to imbalanced boundaries! Mask stack size: " + c0080x.d.size());
            }
        }
    }

    public static final String a(C0080x c0080x, String text) {
        if (StringsKt.isBlank(text)) {
            return "";
        }
        if (((Boolean) CollectionsKt.last(c0080x.d)).booleanValue()) {
            return ProxyConfig.MATCH_ALL_SCHEMES;
        }
        if (c0080x.f97a != MaskingMode.Balanced || c0080x.d.size() != 1) {
            return text;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(text, "text");
        List split$default = StringsKt.split$default((CharSequence) text, new String[]{" "}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((String) it.next()).length()));
        }
        String text2 = CollectionsKt.joinToString$default(split$default, " ", null, null, 0, null, new com.microsoft.clarity.m.l((int) CollectionsKt.averageOfInt(arrayList)), 30, null);
        Intrinsics.checkNotNullParameter(text2, "text");
        ArrayList arrayList2 = new ArrayList(text2.length());
        for (int i = 0; i < text2.length(); i++) {
            char charAt = text2.charAt(i);
            if (Character.isDigit(charAt)) {
                charAt = '*';
            }
            arrayList2.add(Character.valueOf(charAt));
        }
        return CollectionsKt.joinToString$default(arrayList2, "", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ba A[LOOP:0: B:16:0x00b4->B:18:0x00ba, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.microsoft.clarity.models.viewhierarchy.ViewNodeDelta a(java.util.LinkedHashMap r5, com.microsoft.clarity.e.U r6, com.microsoft.clarity.e.C0080x r7, com.microsoft.clarity.models.viewhierarchy.ViewNode r8) {
        /*
            long r0 = r8.getRenderNodeId()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r5.put(r0, r8)
            int r0 = r8.getId()
            r1 = -1
            if (r0 == r1) goto L40
            java.util.LinkedHashMap r0 = r6.d
            int r1 = r8.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L3b
            android.content.Context r2 = r6.f76a     // Catch: java.lang.Exception -> L36
            android.content.res.Resources r2 = r2.getResources()     // Catch: java.lang.Exception -> L36
            int r3 = r8.getId()     // Catch: java.lang.Exception -> L36
            java.lang.String r2 = r2.getResourceEntryName(r3)     // Catch: java.lang.Exception -> L36
            java.lang.String r3 = "context.resources.getResourceEntryName(node.id)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch: java.lang.Exception -> L36
            goto L38
        L36:
            java.lang.String r2 = ""
        L38:
            r0.put(r1, r2)
        L3b:
            java.lang.String r2 = (java.lang.String) r2
            r8.setIdEntryName(r2)
        L40:
            long r0 = r8.getRenderNodeId()
            int r0 = (int) r0
            java.util.Set r1 = r7.b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L59
            java.util.List r1 = r7.d
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r1.add(r2)
            goto L6c
        L59:
            java.util.Set r1 = r7.c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L75
            java.util.List r1 = r7.d
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.add(r2)
        L6c:
            java.util.ArrayList r1 = r7.e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r1.add(r2)
        L75:
            java.lang.String r1 = r8.getText()
            java.lang.String r1 = a(r7, r1)
            r8.setText(r1)
            java.lang.String r1 = r8.getContentDescription()
            java.lang.String r1 = a(r7, r1)
            r8.setContentDescription(r1)
            com.microsoft.clarity.models.viewhierarchy.ViewNodeDelta$Companion r1 = com.microsoft.clarity.models.viewhierarchy.ViewNodeDelta.INSTANCE
            java.util.LinkedHashMap r2 = r6.c
            long r3 = r8.getRenderNodeId()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r2 = r2.get(r3)
            com.microsoft.clarity.models.viewhierarchy.ViewNode r2 = (com.microsoft.clarity.models.viewhierarchy.ViewNode) r2
            com.microsoft.clarity.models.viewhierarchy.ViewNodeDelta r1 = r1.build(r8, r2)
            java.util.List r8 = r8.getChildren()
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r3)
            r2.<init>(r3)
            java.util.Iterator r8 = r8.iterator()
        Lb4:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto Lc8
            java.lang.Object r3 = r8.next()
            com.microsoft.clarity.models.viewhierarchy.ViewNode r3 = (com.microsoft.clarity.models.viewhierarchy.ViewNode) r3
            com.microsoft.clarity.models.viewhierarchy.ViewNodeDelta r3 = a(r5, r6, r7, r3)
            r2.add(r3)
            goto Lb4
        Lc8:
            r1.addChildren(r2)
            java.util.ArrayList r5 = r7.e
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto Lf3
            java.util.ArrayList r5 = r7.e
            java.lang.Object r5 = kotlin.collections.CollectionsKt.last(r5)
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 != r0) goto Lf3
            java.util.ArrayList r5 = r7.e
            int r6 = kotlin.collections.CollectionsKt.getLastIndex(r5)
            r5.remove(r6)
            java.util.List r5 = r7.d
            int r6 = kotlin.collections.CollectionsKt.getLastIndex(r5)
            r5.remove(r6)
        Lf3:
            java.util.List r5 = r7.d
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto Lfc
            return r1
        Lfc:
            com.microsoft.clarity.c.a r5 = new com.microsoft.clarity.c.a
            java.lang.String r6 = "Masking failed due to imbalanced boundaries (empty mask stack)!"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.e.U.a(java.util.LinkedHashMap, com.microsoft.clarity.e.U, com.microsoft.clarity.e.x, com.microsoft.clarity.models.viewhierarchy.ViewNode):com.microsoft.clarity.models.viewhierarchy.ViewNodeDelta");
    }
}
