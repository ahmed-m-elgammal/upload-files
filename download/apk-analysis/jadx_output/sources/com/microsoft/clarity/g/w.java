package com.microsoft.clarity.g;

import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import com.microsoft.clarity.f.C0083a;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.models.observers.UserInteraction;
import com.microsoft.clarity.models.viewhierarchy.EditTextInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class w {
    public ScreenMetadata c;
    public boolean d;
    public EditTextInfo e;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f166a = new ArrayList();
    public final Handler b = new Handler(Looper.getMainLooper());
    public final s f = new s(this);

    public final void a(ScreenMetadata screenMetadata, Window window) {
        Intrinsics.checkNotNullParameter(screenMetadata, "screenMetadata");
        Intrinsics.checkNotNullParameter(window, "window");
        int hashCode = window.hashCode();
        Integer num = (Integer) this.f.c.get(Integer.valueOf(hashCode));
        if ((num != null ? num.intValue() : 0) <= 5 && !(window.getCallback() instanceof r)) {
            LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
            com.microsoft.clarity.m.h.b("Watch touches for " + screenMetadata + ' ' + window + '.');
            r rVar = (r) this.f.b.get(Integer.valueOf(hashCode));
            if (rVar != null) {
                com.microsoft.clarity.m.h.b("Had to deactivate the previously set callback.");
                rVar.d = false;
            }
            r windowCallbackWrapper = new r(this, screenMetadata, window);
            window.setCallback(windowCallbackWrapper);
            s sVar = this.f;
            sVar.getClass();
            Intrinsics.checkNotNullParameter(windowCallbackWrapper, "windowCallbackWrapper");
            Intrinsics.checkNotNullParameter(window, "window");
            sVar.b.put(Integer.valueOf(hashCode), windowCallbackWrapper);
            sVar.d.put(Integer.valueOf(hashCode), new WeakReference(window));
            LinkedHashMap linkedHashMap = sVar.e.f.c;
            Integer valueOf = Integer.valueOf(hashCode);
            Integer num2 = (Integer) sVar.e.f.c.get(Integer.valueOf(hashCode));
            linkedHashMap.put(valueOf, Integer.valueOf((num2 != null ? num2.intValue() : 0) + 1));
        }
    }

    public final void a(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Clear window callback for " + window + '.');
        int hashCode = window.hashCode();
        Runnable runnable = (Runnable) this.f.f162a.get(Integer.valueOf(hashCode));
        if (runnable != null) {
            this.b.removeCallbacks(runnable);
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof r) {
            window.setCallback(((r) callback).b);
        }
        r rVar = (r) this.f.b.get(Integer.valueOf(hashCode));
        if (rVar != null) {
            rVar.d = false;
        }
        s sVar = this.f;
        sVar.b.remove(Integer.valueOf(hashCode));
        sVar.c.remove(Integer.valueOf(hashCode));
        sVar.f162a.remove(Integer.valueOf(hashCode));
        sVar.d.remove(Integer.valueOf(hashCode));
    }

    public final void a(AnalyticsEvent event) {
        if (!Intrinsics.areEqual(event.getScreenMetadata(), this.c)) {
            com.microsoft.clarity.m.h.b("Dropping analytics event from an old screen.");
            return;
        }
        if (this.d) {
            return;
        }
        Iterator it = this.f166a.iterator();
        while (it.hasNext()) {
            C0083a c0083a = (C0083a) it.next();
            c0083a.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            c0083a.f112a.o.add(new UserInteraction(event));
        }
    }
}
