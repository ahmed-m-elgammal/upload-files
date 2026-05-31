package com.microsoft.clarity.g;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.ingest.analytics.ClickEvent;
import com.microsoft.clarity.models.ingest.analytics.DoubleClickEvent;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class n extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final ScreenMetadata f157a;
    public final long b;
    public final /* synthetic */ w c;

    public n(w wVar, ScreenMetadata screenMetadata, long j) {
        Intrinsics.checkNotNullParameter(screenMetadata, "screenMetadata");
        this.c = wVar;
        this.f157a = screenMetadata;
        this.b = j;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        long currentTimeMillis = System.currentTimeMillis();
        DoubleClickEvent doubleClickEvent = new DoubleClickEvent(currentTimeMillis, this.f157a, e.getPointerId(e.getActionIndex()), e.getRawX(), e.getRawY());
        ClickEvent clickEvent = new ClickEvent(currentTimeMillis, this.f157a, e.getRawX(), e.getRawY(), this.b);
        this.c.a(doubleClickEvent);
        this.c.a(clickEvent);
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.d("Double click event watched (" + doubleClickEvent + ") (" + clickEvent + ").");
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        ClickEvent clickEvent = new ClickEvent(System.currentTimeMillis(), this.f157a, e.getRawX(), e.getRawY(), this.b);
        this.c.a(clickEvent);
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.d("Click event watched (" + clickEvent + ").");
        return false;
    }
}
