package io.sentry.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.TypeCheckHint;
import io.sentry.android.core.SystemEventsBreadcrumbsIntegration;
import io.sentry.android.core.internal.util.AndroidCurrentDateProvider;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import io.sentry.android.core.internal.util.Debouncer;
import io.sentry.protocol.Device;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import io.sentry.util.StringUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class SystemEventsBreadcrumbsIntegration implements Integration, Closeable {
    private final String[] actions;
    private final Context context;
    private volatile IntentFilter filter;
    private final MainLooperHandler handler;
    private IHub hub;
    private volatile boolean isClosed;
    private volatile boolean isStopped;
    volatile ReceiverLifecycleHandler lifecycleHandler;
    private SentryAndroidOptions options;
    volatile SystemEventsBroadcastReceiver receiver;
    private final Object receiverLock;

    public SystemEventsBreadcrumbsIntegration(Context context) {
        this(context, getDefaultActionsInternal());
    }

    private SystemEventsBreadcrumbsIntegration(Context context, String[] strArr) {
        this(context, strArr, new MainLooperHandler());
    }

    SystemEventsBreadcrumbsIntegration(Context context, String[] strArr, MainLooperHandler mainLooperHandler) {
        this.isClosed = false;
        this.isStopped = false;
        this.filter = null;
        this.receiverLock = new Object();
        this.context = ContextUtils.getApplicationContext(context);
        this.actions = strArr;
        this.handler = mainLooperHandler;
    }

    public SystemEventsBreadcrumbsIntegration(Context context, List<String> list) {
        this.isClosed = false;
        this.isStopped = false;
        this.filter = null;
        this.receiverLock = new Object();
        this.context = ContextUtils.getApplicationContext(context);
        String[] strArr = new String[list.size()];
        this.actions = strArr;
        list.toArray(strArr);
        this.handler = new MainLooperHandler();
    }

    @Override // io.sentry.Integration
    public void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        this.hub = iHub;
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.options.isEnableSystemEventBreadcrumbs()));
        if (this.options.isEnableSystemEventBreadcrumbs()) {
            addLifecycleObserver(this.options);
            registerReceiver(this.hub, this.options, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerReceiver(final IHub iHub, final SentryAndroidOptions sentryAndroidOptions, final boolean z) {
        if (sentryAndroidOptions.isEnableSystemEventBreadcrumbs()) {
            synchronized (this.receiverLock) {
                if (!this.isClosed && !this.isStopped && this.receiver == null) {
                    try {
                        sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.SystemEventsBreadcrumbsIntegration$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                SystemEventsBreadcrumbsIntegration.this.m2498xce8519cc(iHub, sentryAndroidOptions, z);
                            }
                        });
                    } catch (Throwable unused) {
                        sentryAndroidOptions.getLogger().log(SentryLevel.WARNING, "Failed to start SystemEventsBreadcrumbsIntegration on executor thread.", new Object[0]);
                    }
                }
            }
        }
    }

    /* renamed from: lambda$registerReceiver$0$io-sentry-android-core-SystemEventsBreadcrumbsIntegration, reason: not valid java name */
    /* synthetic */ void m2498xce8519cc(IHub iHub, SentryAndroidOptions sentryAndroidOptions, boolean z) {
        synchronized (this.receiverLock) {
            if (!this.isClosed && !this.isStopped && this.receiver == null) {
                this.receiver = new SystemEventsBroadcastReceiver(iHub, sentryAndroidOptions);
                if (this.filter == null) {
                    this.filter = new IntentFilter();
                    for (String str : this.actions) {
                        this.filter.addAction(str);
                    }
                }
                try {
                    ContextUtils.registerReceiver(this.context, sentryAndroidOptions, this.receiver, this.filter);
                    if (z) {
                        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration installed.", new Object[0]);
                        IntegrationUtils.addIntegrationToSdkVersion("SystemEventsBreadcrumbs");
                    }
                } catch (Throwable th) {
                    sentryAndroidOptions.setEnableSystemEventBreadcrumbs(false);
                    sentryAndroidOptions.getLogger().log(SentryLevel.ERROR, "Failed to initialize SystemEventsBreadcrumbsIntegration.", th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterReceiver() {
        SystemEventsBroadcastReceiver systemEventsBroadcastReceiver;
        synchronized (this.receiverLock) {
            this.isStopped = true;
            systemEventsBroadcastReceiver = this.receiver;
            this.receiver = null;
        }
        if (systemEventsBroadcastReceiver != null) {
            this.context.unregisterReceiver(systemEventsBroadcastReceiver);
        }
    }

    private void addLifecycleObserver(final SentryAndroidOptions sentryAndroidOptions) {
        try {
            Class.forName("androidx.lifecycle.DefaultLifecycleObserver");
            Class.forName("androidx.lifecycle.ProcessLifecycleOwner");
            if (AndroidMainThreadChecker.getInstance().isMainThread()) {
                m2497x2f84e9a(sentryAndroidOptions);
            } else {
                this.handler.post(new Runnable() { // from class: io.sentry.android.core.SystemEventsBreadcrumbsIntegration$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SystemEventsBreadcrumbsIntegration.this.m2497x2f84e9a(sentryAndroidOptions);
                    }
                });
            }
        } catch (ClassNotFoundException unused) {
            sentryAndroidOptions.getLogger().log(SentryLevel.WARNING, "androidx.lifecycle is not available, SystemEventsBreadcrumbsIntegration won't be able to register/unregister an internal BroadcastReceiver. This may result in an increased ANR rate on Android 14 and above.", new Object[0]);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().log(SentryLevel.ERROR, "SystemEventsBreadcrumbsIntegration could not register lifecycle observer", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addObserverInternal, reason: merged with bridge method [inline-methods] */
    public void m2497x2f84e9a(SentryAndroidOptions sentryAndroidOptions) {
        this.lifecycleHandler = new ReceiverLifecycleHandler();
        try {
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this.lifecycleHandler);
        } catch (Throwable th) {
            this.lifecycleHandler = null;
            sentryAndroidOptions.getLogger().log(SentryLevel.ERROR, "SystemEventsBreadcrumbsIntegration failed to get Lifecycle and could not install lifecycle observer.", th);
        }
    }

    private void removeLifecycleObserver() {
        if (this.lifecycleHandler != null) {
            if (AndroidMainThreadChecker.getInstance().isMainThread()) {
                m2499xee09f0be();
            } else {
                this.handler.post(new Runnable() { // from class: io.sentry.android.core.SystemEventsBreadcrumbsIntegration$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        SystemEventsBreadcrumbsIntegration.this.m2499xee09f0be();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeObserverInternal, reason: merged with bridge method [inline-methods] */
    public void m2499xee09f0be() {
        ReceiverLifecycleHandler receiverLifecycleHandler = this.lifecycleHandler;
        if (receiverLifecycleHandler != null) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(receiverLifecycleHandler);
        }
        this.lifecycleHandler = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.receiverLock) {
            this.isClosed = true;
            this.filter = null;
        }
        removeLifecycleObserver();
        unregisterReceiver();
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration remove.", new Object[0]);
        }
    }

    public static List<String> getDefaultActions() {
        return Arrays.asList(getDefaultActionsInternal());
    }

    private static String[] getDefaultActionsInternal() {
        return new String[]{"android.intent.action.ACTION_SHUTDOWN", "android.intent.action.AIRPLANE_MODE", "android.intent.action.BATTERY_CHANGED", "android.intent.action.CAMERA_BUTTON", "android.intent.action.CONFIGURATION_CHANGED", "android.intent.action.DATE_CHANGED", "android.intent.action.DEVICE_STORAGE_LOW", "android.intent.action.DEVICE_STORAGE_OK", "android.intent.action.DOCK_EVENT", "android.intent.action.DREAMING_STARTED", "android.intent.action.DREAMING_STOPPED", "android.intent.action.INPUT_METHOD_CHANGED", "android.intent.action.LOCALE_CHANGED", "android.intent.action.SCREEN_OFF", "android.intent.action.SCREEN_ON", "android.intent.action.TIMEZONE_CHANGED", "android.intent.action.TIME_SET", "android.os.action.DEVICE_IDLE_MODE_CHANGED", "android.os.action.POWER_SAVE_MODE_CHANGED"};
    }

    final class ReceiverLifecycleHandler implements DefaultLifecycleObserver {
        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        }

        ReceiverLifecycleHandler() {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(LifecycleOwner lifecycleOwner) {
            if (SystemEventsBreadcrumbsIntegration.this.hub == null || SystemEventsBreadcrumbsIntegration.this.options == null) {
                return;
            }
            synchronized (SystemEventsBreadcrumbsIntegration.this.receiverLock) {
                SystemEventsBreadcrumbsIntegration.this.isStopped = false;
            }
            SystemEventsBreadcrumbsIntegration systemEventsBreadcrumbsIntegration = SystemEventsBreadcrumbsIntegration.this;
            systemEventsBreadcrumbsIntegration.registerReceiver(systemEventsBreadcrumbsIntegration.hub, SystemEventsBreadcrumbsIntegration.this.options, false);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStop(LifecycleOwner lifecycleOwner) {
            SystemEventsBreadcrumbsIntegration.this.unregisterReceiver();
        }
    }

    static final class SystemEventsBroadcastReceiver extends BroadcastReceiver {
        private static final long DEBOUNCE_WAIT_TIME_MS = 60000;
        private final Debouncer batteryChangedDebouncer = new Debouncer(AndroidCurrentDateProvider.getInstance(), 60000, 0);
        private final char[] buf = new char[64];
        private final IHub hub;
        private final SentryAndroidOptions options;

        SystemEventsBroadcastReceiver(IHub iHub, SentryAndroidOptions sentryAndroidOptions) {
            this.hub = iHub;
            this.options = sentryAndroidOptions;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            final String action = intent.getAction();
            final boolean equals = "android.intent.action.BATTERY_CHANGED".equals(action);
            if (equals && this.batteryChangedDebouncer.checkForDebounce()) {
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            try {
                this.options.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.SystemEventsBreadcrumbsIntegration$SystemEventsBroadcastReceiver$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SystemEventsBreadcrumbsIntegration.SystemEventsBroadcastReceiver.this.m2500x4f6ca208(currentTimeMillis, intent, action, equals);
                    }
                });
            } catch (Throwable unused) {
            }
        }

        /* renamed from: lambda$onReceive$0$io-sentry-android-core-SystemEventsBreadcrumbsIntegration$SystemEventsBroadcastReceiver, reason: not valid java name */
        /* synthetic */ void m2500x4f6ca208(long j, Intent intent, String str, boolean z) {
            Breadcrumb createBreadcrumb = createBreadcrumb(j, intent, str, z);
            Hint hint = new Hint();
            hint.set(TypeCheckHint.ANDROID_INTENT, intent);
            this.hub.addBreadcrumb(createBreadcrumb, hint);
        }

        String getStringAfterDotFast(String str) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            int length2 = this.buf.length;
            for (int i = length - 1; i >= 0; i--) {
                char charAt = str.charAt(i);
                if (charAt == '.') {
                    char[] cArr = this.buf;
                    return new String(cArr, length2, cArr.length - length2);
                }
                if (length2 == 0) {
                    return StringUtils.getStringAfterDot(str);
                }
                length2--;
                this.buf[length2] = charAt;
            }
            return str;
        }

        private Breadcrumb createBreadcrumb(long j, Intent intent, String str, boolean z) {
            Breadcrumb breadcrumb = new Breadcrumb(j);
            breadcrumb.setType("system");
            breadcrumb.setCategory("device.event");
            String stringAfterDotFast = getStringAfterDotFast(str);
            if (stringAfterDotFast != null) {
                breadcrumb.setData("action", stringAfterDotFast);
            }
            if (z) {
                Float batteryLevel = DeviceInfoUtil.getBatteryLevel(intent, this.options);
                if (batteryLevel != null) {
                    breadcrumb.setData("level", batteryLevel);
                }
                Boolean isCharging = DeviceInfoUtil.isCharging(intent, this.options);
                if (isCharging != null) {
                    breadcrumb.setData(Device.JsonKeys.CHARGING, isCharging);
                }
            } else {
                Bundle extras = intent.getExtras();
                HashMap hashMap = new HashMap();
                if (extras != null && !extras.isEmpty()) {
                    for (String str2 : extras.keySet()) {
                        try {
                            Object obj = extras.get(str2);
                            if (obj != null) {
                                hashMap.put(str2, obj.toString());
                            }
                        } catch (Throwable th) {
                            this.options.getLogger().log(SentryLevel.ERROR, th, "%s key of the %s action threw an error.", str2, str);
                        }
                    }
                    breadcrumb.setData("extras", hashMap);
                }
            }
            breadcrumb.setLevel(SentryLevel.INFO);
            return breadcrumb;
        }
    }
}
