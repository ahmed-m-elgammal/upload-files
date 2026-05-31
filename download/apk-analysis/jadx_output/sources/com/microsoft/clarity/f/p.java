package com.microsoft.clarity.f;

import android.app.Activity;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f124a = true;
    public final /* synthetic */ q b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Activity d;

    public p(q qVar, int i, Activity activity) {
        this.b = qVar;
        this.c = i;
        this.d = activity;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.microsoft.clarity.models.observers.ScreenMetadata] */
    @Override // java.lang.Runnable
    public final void run() {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = com.microsoft.clarity.a.H.f20a;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ScreenMetadata("", "", 0);
        com.microsoft.clarity.m.f.a(new C0095m(this.b, this.c, objectRef, this.d, longRef, this), new n(this.b, objectRef), new o(this.b, this, longRef), 18);
    }
}
