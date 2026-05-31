package com.microsoft.clarity.e;

import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class S {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f74a;
    public final LinkedHashSet b;
    public final LinkedHashSet c;
    public final long d;

    public S(LinkedHashSet digitGlyphIds, LinkedHashSet spaceGlyphId, LinkedHashSet atSignGlyphId, long j) {
        Intrinsics.checkNotNullParameter(digitGlyphIds, "digitGlyphIds");
        Intrinsics.checkNotNullParameter(spaceGlyphId, "spaceGlyphId");
        Intrinsics.checkNotNullParameter(atSignGlyphId, "atSignGlyphId");
        this.f74a = digitGlyphIds;
        this.b = spaceGlyphId;
        this.c = atSignGlyphId;
        this.d = j;
    }
}
