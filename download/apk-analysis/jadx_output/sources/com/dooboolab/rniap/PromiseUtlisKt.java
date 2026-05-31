package com.dooboolab.rniap;

import android.util.Log;
import com.facebook.react.bridge.Promise;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PromiseUtlis.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u001a&\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"TAG", "", "safeReject", "", "Lcom/facebook/react/bridge/Promise;", "message", "code", "throwable", "", "safeResolve", "value", "", "react-native-iap_playRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PromiseUtlisKt {
    public static final String TAG = "IapPromises";

    public static final void safeResolve(Promise promise, Object obj) {
        Intrinsics.checkNotNullParameter(promise, "<this>");
        try {
            promise.resolve(obj);
        } catch (RuntimeException e) {
            Log.d(TAG, "Already consumed " + e.getMessage());
        }
    }

    public static final void safeReject(Promise promise, String message) {
        Intrinsics.checkNotNullParameter(promise, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        safeReject(promise, message, null, null);
    }

    public static final void safeReject(Promise promise, String code, String str) {
        Intrinsics.checkNotNullParameter(promise, "<this>");
        Intrinsics.checkNotNullParameter(code, "code");
        safeReject(promise, code, str, null);
    }

    public static final void safeReject(Promise promise, String code, Throwable th) {
        Intrinsics.checkNotNullParameter(promise, "<this>");
        Intrinsics.checkNotNullParameter(code, "code");
        safeReject(promise, code, null, th);
    }

    public static final void safeReject(Promise promise, String code, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(promise, "<this>");
        Intrinsics.checkNotNullParameter(code, "code");
        try {
            promise.reject(code, str, th);
        } catch (RuntimeException e) {
            Log.d(TAG, "Already consumed " + e.getMessage());
        }
    }
}
