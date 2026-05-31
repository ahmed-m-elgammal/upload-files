package com.microsoft.clarity.c;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final String f48a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.f48a = message;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f48a;
    }
}
