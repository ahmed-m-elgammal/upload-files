package com.microsoft.clarity.e;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.e.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0066i {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f85a;
    public boolean b;
    public Rect c;
    public Rect d;
    public final ViewTreeObserver.OnDrawListener e;
    public long f;

    public C0066i(WeakReference ref, Rect rect, Rect rect2, ViewTreeObserver.OnDrawListener onDrawListener) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        Intrinsics.checkNotNullParameter(onDrawListener, "onDrawListener");
        this.f85a = ref;
        this.b = true;
        this.c = rect;
        this.d = rect2;
        this.e = onDrawListener;
        this.f = 0L;
    }
}
