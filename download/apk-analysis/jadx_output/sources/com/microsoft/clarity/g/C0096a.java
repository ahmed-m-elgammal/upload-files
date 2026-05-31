package com.microsoft.clarity.g;

import com.microsoft.clarity.f.C0085c;
import com.microsoft.clarity.models.observers.NetworkDisconnectedEvent;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.g.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0096a extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0098c f145a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0096a(C0098c c0098c) {
        super(0);
        this.f145a = c0098c;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i;
        boolean z;
        C0098c c0098c = this.f145a;
        synchronized (c0098c.i) {
            i = 1;
            if (!c0098c.c) {
                LinkedHashMap linkedHashMap = ((m) c0098c.f147a).c;
                if (!linkedHashMap.isEmpty()) {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        if (((Map.Entry) it.next()).getValue() == EnumC0101f.ON_RESUME) {
                            z = true;
                            break;
                        }
                    }
                }
            }
            z = false;
            if (c0098c.f == null) {
                c0098c.f = Long.valueOf(System.currentTimeMillis());
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                Long l = c0098c.f;
                Intrinsics.checkNotNull(l);
                if (currentTimeMillis - l.longValue() > c0098c.j) {
                    C0097b c0097b = c0098c.h;
                    if (c0097b != null) {
                        c0097b.cancel();
                    }
                    c0098c.h = null;
                    c0098c.g = false;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            C0098c c0098c2 = this.f145a;
            int i2 = c0098c2.d;
            if (1 <= i2) {
                while (true) {
                    try {
                        URLConnection openConnection = new URL("http://www.microsoft.com/").openConnection();
                        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                        httpURLConnection.setConnectTimeout(1000);
                        httpURLConnection.connect();
                        if (httpURLConnection.getResponseCode() == 200) {
                            break;
                        }
                    } catch (Exception unused) {
                    }
                    if (i == i2) {
                        break;
                    }
                    i++;
                }
            }
            if (!c0098c2.c) {
                Iterator it2 = c0098c2.b.iterator();
                while (it2.hasNext()) {
                    C0085c c0085c = (C0085c) it2.next();
                    NetworkDisconnectedEvent event = new NetworkDisconnectedEvent(System.currentTimeMillis());
                    c0085c.getClass();
                    Intrinsics.checkNotNullParameter(event, "event");
                    c0085c.f114a.o.add(event);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
