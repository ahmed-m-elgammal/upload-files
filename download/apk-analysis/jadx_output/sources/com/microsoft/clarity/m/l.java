package com.microsoft.clarity.m;

import androidx.webkit.ProxyConfig;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class l extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f194a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(int i) {
        super(1);
        this.f194a = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.contains$default((CharSequence) it, (CharSequence) "@", false, 2, (Object) null) ? StringsKt.repeat(ProxyConfig.MATCH_ALL_SCHEMES, this.f194a) : it;
    }
}
