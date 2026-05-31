package com.facebook.react.util;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class RNLog {
    public static final int ADVICE = 4;
    public static final int ERROR = 6;
    public static final int LOG = 2;
    public static final int MINIMUM_LEVEL_FOR_UI = 5;
    public static final int TRACE = 3;
    public static final int WARN = 5;

    public static void l(String str) {
        FLog.i(ReactConstants.TAG, str);
    }

    public static void t(String str) {
        FLog.i(ReactConstants.TAG, str);
    }

    public static void a(String str) {
        FLog.w(ReactConstants.TAG, "(ADVICE)" + str);
    }

    public static void w(@Nullable ReactContext reactContext, String str) {
        logInternal(reactContext, str, 5);
        FLog.w(ReactConstants.TAG, str);
    }

    public static void e(@Nullable ReactContext reactContext, String str) {
        logInternal(reactContext, str, 6);
        FLog.e(ReactConstants.TAG, str);
    }

    public static void e(String str) {
        FLog.e(ReactConstants.TAG, str);
    }

    private static void logInternal(@Nullable ReactContext reactContext, @Nullable String str, int i) {
        if (i < 5 || reactContext == null || !reactContext.hasActiveReactInstance() || str == null) {
            return;
        }
        ((RCTLog) reactContext.getJSModule(RCTLog.class)).logIfNoNativeHook(levelToString(i), str);
    }

    private static String levelToString(int i) {
        if (i == 2 || i == 3) {
            return "log";
        }
        if (i == 4 || i == 5) {
            return "warn";
        }
        if (i == 6) {
            return "error";
        }
        return "none";
    }
}
