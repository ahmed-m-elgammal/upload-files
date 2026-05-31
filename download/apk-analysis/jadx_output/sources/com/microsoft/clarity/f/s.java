package com.microsoft.clarity.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.microsoft.clarity.e.C0073p;
import com.microsoft.clarity.e.C0074q;
import com.microsoft.clarity.e.Q;
import com.microsoft.clarity.g.InterfaceC0100e;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class s implements com.microsoft.clarity.h.b {

    /* renamed from: a, reason: collision with root package name */
    public final q f127a;
    public final M b;
    public final Q c;

    public s(Context context, q captureManager, M sessionManager, Q telemetryTracker, InterfaceC0100e lifecycleObserver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(captureManager, "captureManager");
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        this.f127a = captureManager;
        this.b = sessionManager;
        this.c = telemetryTracker;
        Intrinsics.checkNotNullParameter(this, "callback");
        com.microsoft.clarity.m.h.d("Register callback.");
        ((com.microsoft.clarity.g.m) lifecycleObserver).b.add(this);
        r callbacks = new r(this);
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        com.microsoft.clarity.m.h.b("Register a callback.");
        captureManager.m.add(callbacks);
    }

    @Override // com.microsoft.clarity.h.a
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
    }

    public final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        q qVar = this.f127a;
        Intrinsics.checkNotNullParameter(view, "view");
        com.microsoft.clarity.e.r rVar = qVar.n;
        rVar.getClass();
        Intrinsics.checkNotNullParameter(view, "view");
        CollectionsKt.removeAll(rVar.f, new C0074q(view));
        rVar.g.add(new WeakReference(view));
        qVar.a(true);
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.c.b();
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        q qVar = this.f127a;
        Intrinsics.checkNotNullParameter(view, "view");
        com.microsoft.clarity.e.r rVar = qVar.n;
        rVar.getClass();
        Intrinsics.checkNotNullParameter(view, "view");
        CollectionsKt.removeAll(rVar.g, new C0073p(view));
        rVar.f.add(new WeakReference(view));
        qVar.a(true);
    }

    public final void a(Function1 callback) {
        String a2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        M m = this.b;
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (m.k) {
            if (m.j == null && (a2 = t.a(m)) != null) {
                callback.invoke(a2);
                m.k = a2;
            }
            m.j = callback;
            Unit unit = Unit.INSTANCE;
        }
    }
}
