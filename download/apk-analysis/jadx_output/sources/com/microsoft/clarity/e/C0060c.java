package com.microsoft.clarity.e;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* renamed from: com.microsoft.clarity.e.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0060c implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((C0058a) obj).d), Integer.valueOf(((C0058a) obj2).d));
    }
}
