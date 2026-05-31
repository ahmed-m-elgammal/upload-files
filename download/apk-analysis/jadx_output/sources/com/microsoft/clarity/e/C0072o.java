package com.microsoft.clarity.e;

import android.view.View;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* renamed from: com.microsoft.clarity.e.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0072o implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.compareValues(Float.valueOf(((View) obj).getZ()), Float.valueOf(((View) obj2).getZ()));
    }
}
