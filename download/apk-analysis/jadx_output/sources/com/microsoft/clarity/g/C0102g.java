package com.microsoft.clarity.g;

import android.app.Activity;
import com.microsoft.clarity.models.LogLevel;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.g.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0102g extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f150a;
    public final /* synthetic */ Activity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0102g(m mVar, Activity activity) {
        super(0);
        this.f150a = mVar;
        this.b = activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f150a.c.remove(Integer.valueOf(this.b.hashCode()));
        if (this.f150a.g) {
            LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
            com.microsoft.clarity.m.h.d(this.b + " is destroyed.");
            Iterator it = this.f150a.b.iterator();
            while (it.hasNext()) {
                ((com.microsoft.clarity.h.b) it.next()).onActivityDestroyed(this.b);
            }
        }
        return Unit.INSTANCE;
    }
}
