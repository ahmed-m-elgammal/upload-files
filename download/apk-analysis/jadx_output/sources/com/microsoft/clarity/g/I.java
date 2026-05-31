package com.microsoft.clarity.g;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class I extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f142a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(WebView webView) {
        super(1);
        this.f142a = webView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        WeakReference it = (WeakReference) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(Intrinsics.areEqual(it.get(), this.f142a));
    }
}
