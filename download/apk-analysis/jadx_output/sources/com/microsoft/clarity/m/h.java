package com.microsoft.clarity.m;

import android.util.Log;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.reactnative.ClarityModule;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static LogLevel f192a = LogLevel.None;

    public static boolean a(LogLevel logLevel) {
        return logLevel.ordinal() >= f192a.ordinal();
    }

    public static void b(String str) {
        if (a(LogLevel.Debug)) {
            Log.d(ClarityModule.NAME, a(str));
        }
    }

    public static final void c(String str) {
        if (a(LogLevel.Error)) {
            Log.e(ClarityModule.NAME, a(str));
        }
    }

    public static void d(String str) {
        if (a(LogLevel.Info)) {
            Log.i(ClarityModule.NAME, a(str));
        }
    }

    public static final void e(String str) {
        if (a(LogLevel.Warning)) {
            Log.w(ClarityModule.NAME, a(str));
        }
    }

    public static String a(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
            StringBuilder sb2 = new StringBuilder("[");
            String fileName = stackTraceElement.getFileName();
            Intrinsics.checkNotNullExpressionValue(fileName, "stackTraceElement.fileName");
            sb2.append(StringsKt.replace$default(StringsKt.replace$default(fileName, ".kt", "", false, 4, (Object) null), ".java", "", false, 4, (Object) null));
            sb2.append("::");
            sb2.append(stackTraceElement.getMethodName());
            sb2.append("] ");
            str2 = sb2.toString();
        } catch (Exception unused) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }
}
