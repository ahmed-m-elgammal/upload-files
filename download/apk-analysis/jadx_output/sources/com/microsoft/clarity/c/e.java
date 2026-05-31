package com.microsoft.clarity.c;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final String f49a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String token, String module) {
        super(str);
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(module, "module");
        this.f49a = token;
        this.b = module;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "Unknown SkPicture token '" + this.f49a + "' in module '" + this.b + "'.";
    }
}
