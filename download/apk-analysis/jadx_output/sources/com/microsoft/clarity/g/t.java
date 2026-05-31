package com.microsoft.clarity.g;

import android.view.Window;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class t extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f163a;
    public final /* synthetic */ ScreenMetadata b;
    public final /* synthetic */ Window c;
    public final /* synthetic */ int d;
    public final /* synthetic */ v e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(w wVar, ScreenMetadata screenMetadata, Window window, int i, v vVar) {
        super(0);
        this.f163a = wVar;
        this.b = screenMetadata;
        this.c = window;
        this.d = i;
        this.e = vVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f163a.a(this.b, this.c);
        Integer num = (Integer) this.f163a.f.c.get(Integer.valueOf(this.d));
        if ((num != null ? num.intValue() : 0) > 5) {
            com.microsoft.clarity.m.h.e("Number of registrations exceeded the limit.");
        } else {
            this.f163a.b.postDelayed(this.e, com.microsoft.clarity.a.H.b);
        }
        return Unit.INSTANCE;
    }
}
