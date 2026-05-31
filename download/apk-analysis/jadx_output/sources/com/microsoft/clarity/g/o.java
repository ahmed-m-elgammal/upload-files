package com.microsoft.clarity.g;

import android.view.KeyEvent;
import com.microsoft.clarity.models.ingest.analytics.BackGestureEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class o extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KeyEvent f158a;
    public final /* synthetic */ w b;
    public final /* synthetic */ r c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(KeyEvent keyEvent, w wVar, r rVar) {
        super(0);
        this.f158a = keyEvent;
        this.b = wVar;
        this.c = rVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        KeyEvent keyEvent = this.f158a;
        if (keyEvent != null && 4 == keyEvent.getKeyCode() && this.f158a.getAction() == 0) {
            this.b.a(new BackGestureEvent(System.currentTimeMillis(), this.c.f161a));
        }
        return Unit.INSTANCE;
    }
}
