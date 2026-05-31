package com.microsoft.clarity.g;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;

/* loaded from: classes5.dex */
public final class H extends WebMessagePort.WebMessageCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K f141a;
    public final /* synthetic */ y b;
    public final /* synthetic */ WebView c;

    public H(K k, y yVar, WebView webView) {
        this.f141a = k;
        this.b = yVar;
        this.c = webView;
    }

    @Override // android.webkit.WebMessagePort.WebMessageCallback
    public final void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
        com.microsoft.clarity.m.f.a(new F(this.f141a, webMessage, this.b, this.c), new G(this.f141a), (C) null, 10);
    }
}
