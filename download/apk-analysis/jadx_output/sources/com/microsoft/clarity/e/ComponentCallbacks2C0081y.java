package com.microsoft.clarity.e;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.microsoft.clarity.g.InterfaceC0100e;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.e.y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ComponentCallbacks2C0081y implements ComponentCallbacks2, com.microsoft.clarity.h.b {

    /* renamed from: a, reason: collision with root package name */
    public int f98a;

    public ComponentCallbacks2C0081y(InterfaceC0100e lifecycleObserver) {
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        Intrinsics.checkNotNullParameter(this, "callback");
        com.microsoft.clarity.m.h.d("Register callback.");
        ((com.microsoft.clarity.g.m) lifecycleObserver).b.add(this);
    }

    @Override // com.microsoft.clarity.h.a
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.unregisterComponentCallbacks(this);
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f98a = 0;
        activity.registerComponentCallbacks(this);
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f98a = 3;
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 5) {
            this.f98a = 2;
        } else if (i == 10 || i == 15) {
            this.f98a = 3;
        }
    }
}
