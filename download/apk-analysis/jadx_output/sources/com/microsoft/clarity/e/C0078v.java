package com.microsoft.clarity.e;

import android.content.SharedPreferences;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.e.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0078v implements InstallReferrerStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final InstallReferrerClient f95a;
    public final SharedPreferences b;
    public final com.microsoft.clarity.f.C c;
    public final Q d;

    public C0078v(InstallReferrerClient referrerClient, SharedPreferences preferences, com.microsoft.clarity.f.C callback, Q telemetryTracker) {
        Intrinsics.checkNotNullParameter(referrerClient, "referrerClient");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        this.f95a = referrerClient;
        this.b = preferences;
        this.c = callback;
        this.d = telemetryTracker;
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        com.microsoft.clarity.m.f.a(new C0076t(i, this), new C0077u(this), (com.microsoft.clarity.f.o) null, 26);
    }
}
