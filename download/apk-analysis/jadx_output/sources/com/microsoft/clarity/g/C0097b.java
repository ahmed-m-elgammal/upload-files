package com.microsoft.clarity.g;

import java.util.TimerTask;
import kotlin.jvm.functions.Function1;

/* renamed from: com.microsoft.clarity.g.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0097b extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0098c f146a;

    public C0097b(C0098c c0098c) {
        this.f146a = c0098c;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        com.microsoft.clarity.m.f.a(new C0096a(this.f146a), (Function1) null, (C) null, 14);
    }
}
