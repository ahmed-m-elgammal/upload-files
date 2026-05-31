package com.microsoft.clarity.e;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* loaded from: classes5.dex */
public final class Y implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((V) obj2).f77a), Integer.valueOf(((V) obj).f77a));
    }
}
