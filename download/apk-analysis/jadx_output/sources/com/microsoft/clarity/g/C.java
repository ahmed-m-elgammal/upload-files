package com.microsoft.clarity.g;

import android.webkit.WebView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class C extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K f136a;
    public final /* synthetic */ WebView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(WebView webView, K k) {
        super(0);
        this.f136a = k;
        this.b = webView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        CollectionsKt.removeAll((List) this.f136a.c, (Function1) new B(this.b));
        return Unit.INSTANCE;
    }
}
