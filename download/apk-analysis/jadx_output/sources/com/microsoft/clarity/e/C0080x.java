package com.microsoft.clarity.e;

import com.microsoft.clarity.models.MaskingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.e.x, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0080x {

    /* renamed from: a, reason: collision with root package name */
    public final MaskingMode f97a;
    public final Set b;
    public final Set c;
    public final List d;
    public final ArrayList e;

    public C0080x(boolean z, MaskingMode maskingMode, Set maskedViewRenderNodeIds, Set unmaskedViewRenderNodeIds) {
        Intrinsics.checkNotNullParameter(maskingMode, "maskingMode");
        Intrinsics.checkNotNullParameter(maskedViewRenderNodeIds, "maskedViewRenderNodeIds");
        Intrinsics.checkNotNullParameter(unmaskedViewRenderNodeIds, "unmaskedViewRenderNodeIds");
        this.f97a = maskingMode;
        this.b = maskedViewRenderNodeIds;
        this.c = unmaskedViewRenderNodeIds;
        this.d = CollectionsKt.mutableListOf(Boolean.valueOf(z));
        this.e = new ArrayList();
    }
}
