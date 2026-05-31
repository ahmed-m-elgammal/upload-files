package com.microsoft.clarity.c;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
