package com.microsoft.clarity.e;

import com.microsoft.clarity.f.C0088f;
import com.microsoft.clarity.models.ingest.analytics.ClickEvent;
import com.microsoft.clarity.models.viewhierarchy.ViewNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.e.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0062e {

    /* renamed from: a, reason: collision with root package name */
    public final C0088f f82a;

    public C0062e(C0088f errorCallback) {
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        this.f82a = errorCallback;
    }

    public static C0058a a(ViewNode viewNode, ClickEvent clickEvent, int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (ViewNode viewNode2 : CollectionsKt.asReversedMutable(viewNode.getChildren())) {
            Pair pair = new Pair(viewNode2.getType(), Integer.valueOf(viewNode2.getId()));
            Object obj = linkedHashMap.get(pair);
            if (obj == null) {
                obj = 0;
                linkedHashMap.put(pair, obj);
            }
            int intValue = ((Number) obj).intValue();
            if (!viewNode2.isRoot() && clickEvent.getAbsX() >= viewNode2.getX()) {
                if (clickEvent.getAbsX() <= viewNode2.getWidth() + viewNode2.getX() && clickEvent.getAbsY() >= viewNode2.getY()) {
                    if (clickEvent.getAbsY() <= viewNode2.getHeight() + viewNode2.getY()) {
                        C0058a a2 = a(viewNode2, clickEvent, intValue);
                        a2.a(viewNode.getType(), viewNode.getId(), i);
                        arrayList.add(a2);
                    }
                }
            }
            Object obj2 = linkedHashMap.get(pair);
            Intrinsics.checkNotNull(obj2);
            linkedHashMap.put(pair, Integer.valueOf(((Number) obj2).intValue() + 1));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((C0058a) next).b) {
                arrayList2.add(next);
            }
        }
        C0058a c0058a = (C0058a) CollectionsKt.minWithOrNull(arrayList2, new C0059b());
        if (c0058a != null) {
            return c0058a;
        }
        if (viewNode.getClickable() || arrayList.isEmpty()) {
            return new C0058a(viewNode, i, viewNode.getClickable());
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            if (!((C0058a) next2).b) {
                arrayList3.add(next2);
            }
        }
        Object minWithOrNull = CollectionsKt.minWithOrNull(arrayList3, new C0060c());
        Intrinsics.checkNotNull(minWithOrNull);
        return (C0058a) minWithOrNull;
    }

    public static String a(ViewNode viewNode) {
        Object text = viewNode.getText();
        Iterator<T> it = viewNode.getChildren().iterator();
        while (it.hasNext()) {
            text = ComparisonsKt.maxOf((String) text, a((ViewNode) it.next()), (Comparator<? super String>) new C0061d());
        }
        return (String) text;
    }
}
