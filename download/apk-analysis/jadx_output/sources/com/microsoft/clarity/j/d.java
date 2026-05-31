package com.microsoft.clarity.j;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f179a;

    public d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f179a = context.getSharedPreferences("CLARITY_SHARED_PREFERENCES", 0);
    }

    public final void a(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        SharedPreferences.Editor edit = this.f179a.edit();
        edit.putString("CLARITY_USER_ID", userId);
        edit.apply();
    }
}
