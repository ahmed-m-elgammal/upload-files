package com.microsoft.clarity.e;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.installreferrer.api.InstallReferrerClient;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.e.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0079w {

    /* renamed from: a, reason: collision with root package name */
    public final Q f96a;
    public final SharedPreferences b;
    public final InstallReferrerClient c;

    public C0079w(Context context, Q telemetryTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        this.f96a = telemetryTracker;
        this.b = context.getSharedPreferences("CLARITY_SHARED_PREFERENCES", 0);
        this.c = InstallReferrerClient.newBuilder(context).build();
    }
}
