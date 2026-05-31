package com.microsoft.clarity.e;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.e.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0064g {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f83a;
    public final SharedPreferences.Editor b;
    public final Object c;

    public C0064g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter("NETWORK_USAGE_TRACKING_SIZE", "sharedPreferencesSizeField");
        Intrinsics.checkNotNullParameter("NETWORK_USAGE_TRACKING_DATE", "sharedPreferencesDateField");
        SharedPreferences sharedPreferences = context.getSharedPreferences("CLARITY_SHARED_PREFERENCES", 0);
        this.f83a = sharedPreferences;
        this.b = sharedPreferences.edit();
        this.c = new Object();
    }

    public final void a(long j) {
        synchronized (this.c) {
            Locale locale = Locale.UK;
            String format = DateFormat.getDateInstance(3, locale).format(new Date());
            Intrinsics.checkNotNullExpressionValue(format, "getDateInstance(DateForm…Locale.UK).format(Date())");
            if (Intrinsics.areEqual(this.f83a.getString("NETWORK_USAGE_TRACKING_DATE", ""), format)) {
                SharedPreferences.Editor editor = this.b;
                String string = this.f83a.getString("NETWORK_USAGE_TRACKING_DATE", "");
                String format2 = DateFormat.getDateInstance(3, locale).format(new Date());
                Intrinsics.checkNotNullExpressionValue(format2, "getDateInstance(DateForm…Locale.UK).format(Date())");
                boolean areEqual = Intrinsics.areEqual(string, format2);
                long j2 = 0;
                if (areEqual) {
                    j2 = this.f83a.getLong("NETWORK_USAGE_TRACKING_SIZE", 0L);
                }
                editor.putLong("NETWORK_USAGE_TRACKING_SIZE", j + j2);
            } else {
                this.b.putString("NETWORK_USAGE_TRACKING_DATE", format).putLong("NETWORK_USAGE_TRACKING_SIZE", j);
            }
            this.b.apply();
            Unit unit = Unit.INSTANCE;
        }
    }
}
