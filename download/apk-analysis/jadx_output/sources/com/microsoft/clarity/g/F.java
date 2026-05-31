package com.microsoft.clarity.g;

import android.webkit.WebMessage;
import android.webkit.WebView;
import com.microsoft.clarity.f.C0084b;
import com.microsoft.clarity.models.observers.SerializedWebViewEvent;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class F extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K f139a;
    public final /* synthetic */ WebMessage b;
    public final /* synthetic */ y c;
    public final /* synthetic */ WebView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(K k, WebMessage webMessage, y yVar, WebView webView) {
        super(0);
        this.f139a = k;
        this.b = webMessage;
        this.c = yVar;
        this.d = webView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (!this.f139a.o) {
            WebMessage webMessage = this.b;
            String data = webMessage != null ? webMessage.getData() : null;
            if (data != null) {
                SerializedWebViewEvent events = SerializedWebViewEvent.INSTANCE.create(data, this.c.b, this.d.hashCode());
                Iterator it = this.f139a.b.iterator();
                while (it.hasNext()) {
                    C0084b c0084b = (C0084b) it.next();
                    c0084b.getClass();
                    Intrinsics.checkNotNullParameter(events, "events");
                    c0084b.f113a.o.add(events);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
