package com.microsoft.clarity.e;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* renamed from: com.microsoft.clarity.e.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0061d implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((String) obj).length()), Integer.valueOf(((String) obj2).length()));
    }
}
