package com.microsoft.clarity.m;

import android.app.ActivityManager;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes5.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Runtime f190a;

    static {
        Runtime runtime = Runtime.getRuntime();
        Intrinsics.checkNotNullExpressionValue(runtime, "getRuntime()");
        f190a = runtime;
    }

    public static int a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).getMemoryInfo(new ActivityManager.MemoryInfo());
        return Math.max(MathKt.roundToInt(r0.totalMem / 1.0E9d), 1);
    }
}
