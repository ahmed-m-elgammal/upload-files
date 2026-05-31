package com.microsoft.clarity.a;

import android.app.Activity;
import android.content.Context;
import com.microsoft.clarity.ClarityConfig;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.a.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0054e extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f25a;
    public final /* synthetic */ ClarityConfig b;
    public final /* synthetic */ Activity c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0054e(Activity activity, Context context, ClarityConfig clarityConfig) {
        super(0);
        this.f25a = context;
        this.b = clarityConfig;
        this.c = activity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:
    
        if (kotlin.text.StringsKt.contains((java.lang.CharSequence) "prod", (java.lang.CharSequence) "LiveIngest", true) == false) goto L37;
     */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke() {
        /*
            r4 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L13
            java.lang.String r0 = "Please make sure to call Clarity.initialize(...) on the main thread. Otherwise, some unexpected side effects could happen!"
            com.microsoft.clarity.m.h.e(r0)
        L13:
            boolean r0 = com.microsoft.clarity.a.F.b
            if (r0 == 0) goto L1e
            java.lang.String r0 = "Clarity already initialized."
            com.microsoft.clarity.m.h.d(r0)
            goto L9a
        L1e:
            com.microsoft.clarity.f.s r0 = com.microsoft.clarity.a.F.f18a
            boolean r0 = com.microsoft.clarity.a.F.a()
            if (r0 != 0) goto L2d
            java.lang.String r0 = "API level not supported. We currently support 29-35 inclusive."
            com.microsoft.clarity.m.h.d(r0)
            goto L9a
        L2d:
            android.content.Context r0 = r4.f25a
            boolean r0 = r0 instanceof android.app.Application
            if (r0 != 0) goto L39
            java.lang.String r0 = "You should pass the application context."
            com.microsoft.clarity.m.h.c(r0)
            goto L9a
        L39:
            com.microsoft.clarity.ClarityConfig r0 = r4.b
            java.lang.String r0 = r0.getProjectId()
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L4b
            java.lang.String r0 = "Invalid project id. It cannot be a blank string."
            com.microsoft.clarity.m.h.c(r0)
            goto L9a
        L4b:
            com.microsoft.clarity.ClarityConfig r0 = r4.b
            boolean r0 = r0.isReactNative$sdk_prodRelease()
            r1 = 1
            if (r0 != 0) goto L64
            com.microsoft.clarity.ClarityConfig r0 = r4.b
            boolean r0 = r0.isCordova$sdk_prodRelease()
            if (r0 != 0) goto L64
            com.microsoft.clarity.ClarityConfig r0 = r4.b
            boolean r0 = r0.isIonic$sdk_prodRelease()
            if (r0 == 0) goto L78
        L64:
            android.app.Activity r0 = r4.c
            if (r0 != 0) goto L78
            java.lang.String r0 = "For Cordova, Ionic & ReactNative apps, 'activity' cannot be null."
            com.microsoft.clarity.m.h.c(r0)
            java.lang.String r0 = "prod"
            java.lang.String r2 = "LiveIngest"
            boolean r0 = kotlin.text.StringsKt.contains(r0, r2, r1)
            if (r0 != 0) goto L78
            goto L9a
        L78:
            boolean r0 = com.microsoft.clarity.m.a.b
            if (r0 != 0) goto L8d
            boolean r0 = com.microsoft.clarity.m.a.f188a
            if (r0 == 0) goto L81
            goto L8d
        L81:
            boolean r0 = androidx.work.WorkManager.isInitialized()
            if (r0 != 0) goto L8d
            java.lang.String r0 = "Work manager has to be initialized before starting Clarity."
            com.microsoft.clarity.m.h.c(r0)
            goto L9a
        L8d:
            android.content.Context r0 = r4.f25a
            android.app.Application r0 = (android.app.Application) r0
            com.microsoft.clarity.ClarityConfig r2 = r4.b
            android.app.Activity r3 = r4.c
            com.microsoft.clarity.a.F.a(r0, r2, r3)
            com.microsoft.clarity.a.F.b = r1
        L9a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.a.C0054e.invoke():java.lang.Object");
    }
}
