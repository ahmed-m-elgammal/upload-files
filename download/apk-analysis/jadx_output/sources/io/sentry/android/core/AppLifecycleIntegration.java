package io.sentry.android.core;

import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import io.sentry.util.IntegrationUtils;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes6.dex */
public final class AppLifecycleIntegration implements Integration, Closeable {
    private final MainLooperHandler handler;
    private SentryAndroidOptions options;
    volatile LifecycleWatcher watcher;

    public AppLifecycleIntegration() {
        this(new MainLooperHandler());
    }

    AppLifecycleIntegration(MainLooperHandler mainLooperHandler) {
        this.handler = mainLooperHandler;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:18:0x008e
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.sentry.ILogger] */
    /* JADX WARN: Type inference failed for: r7v3, types: [io.sentry.ILogger] */
    /* JADX WARN: Type inference failed for: r8v0, types: [io.sentry.SentryOptions] */
    /* JADX WARN: Type inference failed for: r8v1, types: [io.sentry.SentryLevel] */
    /* JADX WARN: Type inference failed for: r8v2, types: [io.sentry.SentryOptions] */
    /* JADX WARN: Type inference failed for: r8v3, types: [io.sentry.ILogger] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [io.sentry.SentryOptions] */
    /* JADX WARN: Type inference failed for: r8v6, types: [io.sentry.SentryLevel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0082 -> B:14:0x009b). Please report as a decompilation issue!!! */
    @Override // io.sentry.Integration
    public void register(final io.sentry.IHub r7, io.sentry.SentryOptions r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Hub is required"
            io.sentry.util.Objects.requireNonNull(r7, r0)
            boolean r0 = r8 instanceof io.sentry.android.core.SentryAndroidOptions
            if (r0 == 0) goto Ld
            r0 = r8
            io.sentry.android.core.SentryAndroidOptions r0 = (io.sentry.android.core.SentryAndroidOptions) r0
            goto Le
        Ld:
            r0 = 0
        Le:
            java.lang.String r1 = "SentryAndroidOptions is required"
            java.lang.Object r0 = io.sentry.util.Objects.requireNonNull(r0, r1)
            io.sentry.android.core.SentryAndroidOptions r0 = (io.sentry.android.core.SentryAndroidOptions) r0
            r6.options = r0
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            io.sentry.android.core.SentryAndroidOptions r2 = r6.options
            boolean r2 = r2.isEnableAutoSessionTracking()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r5 = 0
            r4[r5] = r2
            java.lang.String r2 = "enableSessionTracking enabled: %s"
            r0.log(r1, r2, r4)
            io.sentry.android.core.SentryAndroidOptions r0 = r6.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            io.sentry.android.core.SentryAndroidOptions r2 = r6.options
            boolean r2 = r2.isEnableAppLifecycleBreadcrumbs()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r5] = r2
            java.lang.String r2 = "enableAppLifecycleBreadcrumbs enabled: %s"
            r0.log(r1, r2, r3)
            io.sentry.android.core.SentryAndroidOptions r0 = r6.options
            boolean r0 = r0.isEnableAutoSessionTracking()
            if (r0 != 0) goto L5e
            io.sentry.android.core.SentryAndroidOptions r0 = r6.options
            boolean r0 = r0.isEnableAppLifecycleBreadcrumbs()
            if (r0 == 0) goto L9b
        L5e:
            java.lang.String r0 = "androidx.lifecycle.DefaultLifecycleObserver"
            java.lang.Class.forName(r0)     // Catch: java.lang.IllegalStateException -> L81 java.lang.ClassNotFoundException -> L8e
            java.lang.String r0 = "androidx.lifecycle.ProcessLifecycleOwner"
            java.lang.Class.forName(r0)     // Catch: java.lang.IllegalStateException -> L81 java.lang.ClassNotFoundException -> L8e
            io.sentry.android.core.internal.util.AndroidMainThreadChecker r0 = io.sentry.android.core.internal.util.AndroidMainThreadChecker.getInstance()     // Catch: java.lang.IllegalStateException -> L81 java.lang.ClassNotFoundException -> L8e
            boolean r0 = r0.isMainThread()     // Catch: java.lang.IllegalStateException -> L81 java.lang.ClassNotFoundException -> L8e
            if (r0 == 0) goto L76
            r6.m2490lambda$register$0$iosentryandroidcoreAppLifecycleIntegration(r7)     // Catch: java.lang.IllegalStateException -> L81 java.lang.ClassNotFoundException -> L8e
            goto L9b
        L76:
            io.sentry.android.core.MainLooperHandler r0 = r6.handler     // Catch: java.lang.IllegalStateException -> L81 java.lang.ClassNotFoundException -> L8e
            io.sentry.android.core.AppLifecycleIntegration$$ExternalSyntheticLambda1 r1 = new io.sentry.android.core.AppLifecycleIntegration$$ExternalSyntheticLambda1     // Catch: java.lang.IllegalStateException -> L81 java.lang.ClassNotFoundException -> L8e
            r1.<init>()     // Catch: java.lang.IllegalStateException -> L81 java.lang.ClassNotFoundException -> L8e
            r0.post(r1)     // Catch: java.lang.IllegalStateException -> L81 java.lang.ClassNotFoundException -> L8e
            goto L9b
        L81:
            r7 = move-exception
            io.sentry.ILogger r8 = r8.getLogger()
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.ERROR
            java.lang.String r1 = "AppLifecycleIntegration could not be installed"
            r8.log(r0, r1, r7)
            goto L9b
        L8e:
            io.sentry.ILogger r7 = r8.getLogger()
            io.sentry.SentryLevel r8 = io.sentry.SentryLevel.WARNING
            java.lang.String r0 = "androidx.lifecycle is not available, AppLifecycleIntegration won't be installed"
            java.lang.Object[] r1 = new java.lang.Object[r5]
            r7.log(r8, r0, r1)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.AppLifecycleIntegration.register(io.sentry.IHub, io.sentry.SentryOptions):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addObserver, reason: merged with bridge method [inline-methods] */
    public void m2490lambda$register$0$iosentryandroidcoreAppLifecycleIntegration(IHub iHub) {
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions == null) {
            return;
        }
        this.watcher = new LifecycleWatcher(iHub, sentryAndroidOptions.getSessionTrackingIntervalMillis(), this.options.isEnableAutoSessionTracking(), this.options.isEnableAppLifecycleBreadcrumbs());
        try {
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this.watcher);
            this.options.getLogger().log(SentryLevel.DEBUG, "AppLifecycleIntegration installed.", new Object[0]);
            IntegrationUtils.addIntegrationToSdkVersion("AppLifecycle");
        } catch (Throwable th) {
            this.watcher = null;
            this.options.getLogger().log(SentryLevel.ERROR, "AppLifecycleIntegration failed to get Lifecycle and could not be installed.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeObserver, reason: merged with bridge method [inline-methods] */
    public void m2489lambda$close$1$iosentryandroidcoreAppLifecycleIntegration() {
        LifecycleWatcher lifecycleWatcher = this.watcher;
        if (lifecycleWatcher != null) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(lifecycleWatcher);
            SentryAndroidOptions sentryAndroidOptions = this.options;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "AppLifecycleIntegration removed.", new Object[0]);
            }
        }
        this.watcher = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.watcher == null) {
            return;
        }
        if (AndroidMainThreadChecker.getInstance().isMainThread()) {
            m2489lambda$close$1$iosentryandroidcoreAppLifecycleIntegration();
        } else {
            this.handler.post(new Runnable() { // from class: io.sentry.android.core.AppLifecycleIntegration$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AppLifecycleIntegration.this.m2489lambda$close$1$iosentryandroidcoreAppLifecycleIntegration();
                }
            });
        }
    }
}
