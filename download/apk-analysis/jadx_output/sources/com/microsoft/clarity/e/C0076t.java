package com.microsoft.clarity.e;

import android.content.SharedPreferences;
import com.android.installreferrer.api.ReferrerDetails;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* renamed from: com.microsoft.clarity.e.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0076t extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f93a;
    public final /* synthetic */ C0078v b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0076t(int i, C0078v c0078v) {
        super(0);
        this.f93a = i;
        this.b = c0078v;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (this.f93a == 0) {
            ReferrerDetails installReferrer = this.b.f95a.getInstallReferrer();
            String installReferrer2 = installReferrer.getInstallReferrer();
            String str = installReferrer2 == null ? "" : installReferrer2;
            long referrerClickTimestampSeconds = installReferrer.getReferrerClickTimestampSeconds();
            long installBeginTimestampSeconds = installReferrer.getInstallBeginTimestampSeconds();
            long referrerClickTimestampServerSeconds = installReferrer.getReferrerClickTimestampServerSeconds();
            long installBeginTimestampServerSeconds = installReferrer.getInstallBeginTimestampServerSeconds();
            boolean googlePlayInstantParam = installReferrer.getGooglePlayInstantParam();
            String installVersion = installReferrer.getInstallVersion();
            String str2 = installVersion == null ? "" : installVersion;
            if (referrerClickTimestampSeconds != 0 && installBeginTimestampSeconds != 0 && !StringsKt.isBlank(str)) {
                this.b.c.invoke(new E(str, referrerClickTimestampSeconds, installBeginTimestampSeconds, referrerClickTimestampServerSeconds, installBeginTimestampServerSeconds, googlePlayInstantParam, str2));
                this.b.f95a.endConnection();
                SharedPreferences.Editor edit = this.b.b.edit();
                edit.putBoolean("INSTALL_REFERRER_DETAILS_RETRIEVED", true);
                edit.apply();
            }
        }
        return Unit.INSTANCE;
    }
}
