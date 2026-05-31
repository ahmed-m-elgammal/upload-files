package com.microsoft.clarity.i;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.i.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0108b {

    /* renamed from: a, reason: collision with root package name */
    public final C0107a f170a;
    public final String b;

    public C0108b(C0107a bytes, String hash) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(hash, "hash");
        this.f170a = bytes;
        this.b = hash;
    }
}
