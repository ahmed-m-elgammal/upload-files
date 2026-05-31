package com.microsoft.clarity.g;

import android.view.Window;
import com.microsoft.clarity.models.observers.ScreenMetadata;

/* loaded from: classes5.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f165a;
    public final /* synthetic */ ScreenMetadata b;
    public final /* synthetic */ Window c;
    public final /* synthetic */ int d;

    public v(w wVar, ScreenMetadata screenMetadata, Window window, int i) {
        this.f165a = wVar;
        this.b = screenMetadata;
        this.c = window;
        this.d = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.microsoft.clarity.m.f.a(new t(this.f165a, this.b, this.c, this.d, this), new u(this.f165a), (com.microsoft.clarity.f.o) null, 26);
    }
}
