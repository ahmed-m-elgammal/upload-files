package com.microsoft.clarity.g;

import android.app.Activity;
import com.microsoft.clarity.models.LogLevel;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.g.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0106k extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f154a;
    public final /* synthetic */ Activity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0106k(m mVar, Activity activity) {
        super(0);
        this.f154a = mVar;
        this.b = activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        WeakReference weakReference = this.f154a.e;
        boolean z = Intrinsics.areEqual(weakReference != null ? (Activity) weakReference.get() : null, this.b) && this.f154a.c.get(Integer.valueOf(this.b.hashCode())) == EnumC0101f.ON_RESUME;
        if (!z) {
            m mVar = this.f154a;
            Activity activity = this.b;
            mVar.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            mVar.c.put(Integer.valueOf(activity.hashCode()), EnumC0101f.ON_RESUME);
            mVar.d = new WeakReference(activity);
        }
        if (this.f154a.g && !z) {
            LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
            com.microsoft.clarity.m.h.d(this.b + " is resumed.");
            Iterator it = this.f154a.b.iterator();
            while (it.hasNext()) {
                ((com.microsoft.clarity.h.b) it.next()).onActivityResumed(this.b);
            }
            this.f154a.e = new WeakReference(this.b);
        }
        return Unit.INSTANCE;
    }
}
