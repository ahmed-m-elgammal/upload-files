package com.microsoft.clarity.g;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.microsoft.clarity.e.AbstractC0082z;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.observers.WebViewStatus;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* loaded from: classes5.dex */
public final class z extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f168a;
    public final /* synthetic */ K b;
    public final /* synthetic */ y c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(WebView webView, K k, y yVar, String str) {
        super(0);
        this.f168a = webView;
        this.b = k;
        this.c = yVar;
        this.d = str;
    }

    public final void a() {
        Integer intOrNull;
        if (this.f168a.getUrl() == null) {
            com.microsoft.clarity.m.h.b("WebView url is null.");
            return;
        }
        DynamicConfig dynamicConfig = this.b.f144a;
        String url = this.f168a.getUrl();
        Intrinsics.checkNotNull(url);
        if (!dynamicConfig.isAllowedUrl$sdk_prodRelease(url)) {
            K.a(this.b, this.c, WebViewStatus.NotAllowed);
            com.microsoft.clarity.m.h.b("WebView url is not allowed.");
            return;
        }
        String str = this.d;
        if (str != null) {
            String trim = StringsKt.trim(str, Typography.quote);
            if (trim == null || (intOrNull = StringsKt.toIntOrNull(trim)) == null) {
                return;
            }
            int intValue = intOrNull.intValue();
            int[] iArr = new int[5];
            System.arraycopy(AbstractC0082z.f99a, 0, iArr, 0, 5);
            for (int i = 0; i < 5; i++) {
                int i2 = iArr[i];
                if (AbstractC0082z.a(i2) == intValue) {
                    int a2 = AbstractC0082z.a(i2);
                    if (a2 == 0) {
                        com.microsoft.clarity.m.h.b("Injecting Clarity.");
                        K k = this.b;
                        final String replace$default = StringsKt.replace$default(k.l, k.k, K.a(this.f168a, k), false, 4, (Object) null);
                        K.a(this.b, this.c, WebViewStatus.Loading);
                        final WebView webView = this.f168a;
                        webView.evaluateJavascript(this.b.j, new ValueCallback() { // from class: com.microsoft.clarity.g.z$$ExternalSyntheticLambda0
                            @Override // android.webkit.ValueCallback
                            public final void onReceiveValue(Object obj) {
                                z.a(webView, replace$default, (String) obj);
                            }
                        });
                        return;
                    }
                    if (a2 == 2) {
                        com.microsoft.clarity.m.h.b("Sending channel port.");
                        K.a(this.b, this.c);
                        return;
                    }
                    if (a2 == 3) {
                        com.microsoft.clarity.m.h.b("Clarity is active.");
                        return;
                    }
                    if (a2 == 4) {
                        K.a(this.b, this.c, WebViewStatus.Skipped);
                        com.microsoft.clarity.m.h.b("Injection skipped as Web script exists");
                        return;
                    }
                    LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
                    StringBuilder sb = new StringBuilder("ClarityJs state ");
                    sb.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "null" : "Skipped" : "Active" : "WaitingChannel" : "Inactive" : "Undefined");
                    sb.append('.');
                    com.microsoft.clarity.m.h.b(sb.toString());
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }

    public static final void a(WebView webView, String startScript, String str) {
        Intrinsics.checkNotNullParameter(webView, "$webView");
        Intrinsics.checkNotNullParameter(startScript, "$startScript");
        webView.evaluateJavascript(startScript, null);
    }
}
