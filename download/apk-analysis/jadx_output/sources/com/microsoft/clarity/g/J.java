package com.microsoft.clarity.g;

import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class J extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedHashSet f143a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(LinkedHashSet linkedHashSet) {
        super(1);
        this.f143a = linkedHashSet;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        y it = (y) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(this.f143a.contains(it));
    }
}
