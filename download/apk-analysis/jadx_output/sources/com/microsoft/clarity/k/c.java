package com.microsoft.clarity.k;

import android.content.Context;
import com.microsoft.clarity.models.DynamicConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f183a;

    public c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DynamicConfig a2 = com.microsoft.clarity.b.a.a(context);
        this.f183a = a2 != null ? a2.getReportUrl() : null;
    }
}
