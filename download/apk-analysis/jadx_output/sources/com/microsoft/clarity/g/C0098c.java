package com.microsoft.clarity.g;

import android.app.Activity;
import androidx.work.WorkRequest;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.g.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0098c implements com.microsoft.clarity.h.b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0100e f147a;
    public final ArrayList b;
    public boolean c;
    public final int d;
    public Timer e;
    public Long f;
    public boolean g;
    public C0097b h;
    public final Object i;
    public final long j;

    public C0098c(InterfaceC0100e lifecycleObserver) {
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        this.f147a = lifecycleObserver;
        this.b = new ArrayList();
        this.d = 3;
        this.e = new Timer();
        this.i = new Object();
        this.j = TimeUnit.MINUTES.toMillis(5L);
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
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        synchronized (this.i) {
            if (!this.g) {
                this.e = new Timer();
                C0097b c0097b = new C0097b(this);
                this.h = c0097b;
                this.e.schedule(c0097b, 0L, WorkRequest.MIN_BACKOFF_MILLIS);
                this.f = null;
                this.g = true;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
