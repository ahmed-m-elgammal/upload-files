package com.microsoft.clarity.g;

import android.app.Activity;
import com.microsoft.clarity.models.LogLevel;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.g.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0104i extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f152a;
    public final /* synthetic */ Activity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0104i(m mVar, Activity activity) {
        super(0);
        this.f152a = mVar;
        this.b = activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f152a.c.put(Integer.valueOf(this.b.hashCode()), EnumC0101f.ON_PAUSE);
        if (this.f152a.g) {
            LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
            com.microsoft.clarity.m.h.d(this.b + " is paused.");
            Iterator it = this.f152a.b.iterator();
            while (it.hasNext()) {
                ((com.microsoft.clarity.h.b) it.next()).onActivityPaused(this.b);
            }
        }
        return Unit.INSTANCE;
    }
}
