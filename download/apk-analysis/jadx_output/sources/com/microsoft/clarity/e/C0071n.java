package com.microsoft.clarity.e;

import android.view.Window;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* renamed from: com.microsoft.clarity.e.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0071n implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.compareValues(Float.valueOf(((Window) obj).getDecorView().getRootView().getZ()), Float.valueOf(((Window) obj2).getDecorView().getRootView().getZ()));
    }
}
