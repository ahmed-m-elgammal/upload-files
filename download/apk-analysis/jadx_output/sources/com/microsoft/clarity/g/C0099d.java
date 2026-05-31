package com.microsoft.clarity.g;

import com.microsoft.clarity.f.C0086d;
import com.microsoft.clarity.models.ingest.analytics.ScriptErrorEvent;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.g.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0099d implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f148a = new ArrayList();
    public final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    public boolean c;
    public ScreenMetadata d;

    public C0099d() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread t, Throwable e) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(e, "e");
        if (!this.c) {
            Throwable th = e;
            while (th.getCause() != null) {
                th = th.getCause();
                Intrinsics.checkNotNull(th);
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str = "[Native] " + th.getMessage();
            String contentDeepToString = ArraysKt.contentDeepToString(th.getStackTrace());
            ScreenMetadata screenMetadata = this.d;
            if (screenMetadata == null) {
                return;
            }
            ScriptErrorEvent event = new ScriptErrorEvent(currentTimeMillis, str, contentDeepToString, screenMetadata);
            Iterator it = this.f148a.iterator();
            while (it.hasNext()) {
                C0086d c0086d = (C0086d) it.next();
                c0086d.getClass();
                Intrinsics.checkNotNullParameter(event, "event");
                com.microsoft.clarity.f.q.a(c0086d.f115a, event);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(t, e);
        }
    }
}
