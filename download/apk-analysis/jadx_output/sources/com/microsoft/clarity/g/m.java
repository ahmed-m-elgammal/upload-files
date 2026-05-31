package com.microsoft.clarity.g;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.models.DynamicConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class m implements InterfaceC0100e, Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final Application f156a;
    public final ArrayList b;
    public final LinkedHashMap c;
    public WeakReference d;
    public WeakReference e;
    public boolean f;
    public boolean g;

    public m(Application application, ClarityConfig config) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        this.f156a = application;
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
        if (this.f) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        this.f = true;
    }

    public static final void a(m this$0, Activity lastResumedActivity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lastResumedActivity, "$lastResumedActivity");
        this$0.onActivityResumed(lastResumedActivity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.m.f.a(new C0102g(this, activity), new C0103h(this), (com.microsoft.clarity.f.o) null, 26);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.m.f.a(new C0104i(this, activity), new C0105j(this), (com.microsoft.clarity.f.o) null, 26);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.m.f.a(new C0106k(this, activity), new l(this), (com.microsoft.clarity.f.o) null, 26);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void a() {
        this.g = false;
        this.f = false;
        this.f156a.unregisterActivityLifecycleCallbacks(this);
    }

    public final void a(DynamicConfig dynamicConfig) {
        final Activity activity;
        Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
        if (!this.f) {
            this.f156a.registerActivityLifecycleCallbacks(this);
            this.f = true;
        }
        this.g = true;
        WeakReference weakReference = this.d;
        if (weakReference == null || (activity = (Activity) weakReference.get()) == null || this.c.get(Integer.valueOf(activity.hashCode())) != EnumC0101f.ON_RESUME) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.microsoft.clarity.g.m$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                m.a(m.this, activity);
            }
        });
    }
}
