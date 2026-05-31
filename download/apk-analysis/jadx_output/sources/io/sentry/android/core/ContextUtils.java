package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import expo.modules.interfaces.permissions.PermissionsResponse;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.util.AndroidLazyEvaluator;
import io.sentry.protocol.App;
import io.sentry.util.LazyEvaluator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public final class ContextUtils {
    private static final AndroidLazyEvaluator<String> deviceName = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda7
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            String string;
            string = Settings.Global.getString(context.getContentResolver(), "device_name");
            return string;
        }
    });
    private static final LazyEvaluator<Boolean> isForegroundImportance = new LazyEvaluator<>(new LazyEvaluator.Evaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda8
        @Override // io.sentry.util.LazyEvaluator.Evaluator
        public final Object evaluate() {
            return ContextUtils.lambda$static$1();
        }
    });
    private static final AndroidLazyEvaluator<PackageInfo> staticPackageInfo33 = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda9
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            return ContextUtils.lambda$static$2(context);
        }
    });
    private static final AndroidLazyEvaluator<PackageInfo> staticPackageInfo = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda10
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            return ContextUtils.lambda$static$3(context);
        }
    });
    private static final AndroidLazyEvaluator<String> applicationName = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda4
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            return ContextUtils.lambda$static$4(context);
        }
    });
    private static final AndroidLazyEvaluator<ApplicationInfo> staticAppInfo33 = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda5
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            return ContextUtils.lambda$static$5(context);
        }
    });
    private static final AndroidLazyEvaluator<ApplicationInfo> staticAppInfo = new AndroidLazyEvaluator<>(new AndroidLazyEvaluator.AndroidEvaluator() { // from class: io.sentry.android.core.ContextUtils$$ExternalSyntheticLambda6
        @Override // io.sentry.android.core.util.AndroidLazyEvaluator.AndroidEvaluator
        public final Object evaluate(Context context) {
            return ContextUtils.lambda$static$6(context);
        }
    });

    static class SideLoadedInfo {
        private final String installerStore;
        private final boolean isSideLoaded;

        public SideLoadedInfo(boolean z, String str) {
            this.isSideLoaded = z;
            this.installerStore = str;
        }

        public boolean isSideLoaded() {
            return this.isSideLoaded;
        }

        public String getInstallerStore() {
            return this.installerStore;
        }

        public Map<String, String> asTags() {
            HashMap hashMap = new HashMap();
            hashMap.put("isSideLoaded", String.valueOf(this.isSideLoaded));
            String str = this.installerStore;
            if (str != null) {
                hashMap.put("installerStore", str);
            }
            return hashMap;
        }
    }

    private ContextUtils() {
    }

    static /* synthetic */ Boolean lambda$static$1() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            return Boolean.valueOf(runningAppProcessInfo.importance == 100);
        } catch (Throwable unused) {
            return false;
        }
    }

    static /* synthetic */ PackageInfo lambda$static$2(Context context) {
        PackageManager.PackageInfoFlags of;
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            of = PackageManager.PackageInfoFlags.of(0L);
            packageInfo = packageManager.getPackageInfo(packageName, of);
            return packageInfo;
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ PackageInfo lambda$static$3(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ String lambda$static$4(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                if (applicationInfo.nonLocalizedLabel != null) {
                    return applicationInfo.nonLocalizedLabel.toString();
                }
                return context.getPackageManager().getApplicationLabel(applicationInfo).toString();
            }
            return context.getString(i);
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ ApplicationInfo lambda$static$5(Context context) {
        PackageManager.ApplicationInfoFlags of;
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            of = PackageManager.ApplicationInfoFlags.of(128L);
            applicationInfo = packageManager.getApplicationInfo(packageName, of);
            return applicationInfo;
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ ApplicationInfo lambda$static$6(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable unused) {
            return null;
        }
    }

    static PackageInfo getPackageInfo(Context context, BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            return staticPackageInfo33.getValue(context);
        }
        return staticPackageInfo.getValue(context);
    }

    static PackageInfo getPackageInfo(Context context, int i, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        PackageManager.PackageInfoFlags of;
        PackageInfo packageInfo;
        try {
            if (buildInfoProvider.getSdkInfoVersion() >= 33) {
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                of = PackageManager.PackageInfoFlags.of(i);
                packageInfo = packageManager.getPackageInfo(packageName, of);
                return packageInfo;
            }
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i);
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting package info.", th);
            return null;
        }
    }

    static ApplicationInfo getApplicationInfo(Context context, BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            return staticAppInfo33.getValue(context);
        }
        return staticAppInfo.getValue(context);
    }

    static String getVersionCode(PackageInfo packageInfo, BuildInfoProvider buildInfoProvider) {
        long longVersionCode;
        if (buildInfoProvider.getSdkInfoVersion() >= 28) {
            longVersionCode = packageInfo.getLongVersionCode();
            return Long.toString(longVersionCode);
        }
        return getVersionCodeDep(packageInfo);
    }

    static String getVersionName(PackageInfo packageInfo) {
        return packageInfo.versionName;
    }

    private static String getVersionCodeDep(PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }

    public static boolean isForegroundImportance() {
        return isForegroundImportance.getValue().booleanValue();
    }

    static String getKernelVersion(ILogger iLogger) {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                return readLine;
            } finally {
            }
        } catch (IOException e) {
            iLogger.log(SentryLevel.ERROR, "Exception while attempting to read kernel information", e);
            return property;
        }
    }

    static SideLoadedInfo retrieveSideLoadedInfo(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        String str;
        try {
            PackageInfo packageInfo = getPackageInfo(context, buildInfoProvider);
            PackageManager packageManager = context.getPackageManager();
            if (packageInfo != null && packageManager != null) {
                str = packageInfo.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    return new SideLoadedInfo(installerPackageName == null, installerPackageName);
                } catch (IllegalArgumentException unused) {
                    iLogger.log(SentryLevel.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
        }
        return null;
    }

    static String getApplicationName(Context context) {
        return applicationName.getValue(context);
    }

    static DisplayMetrics getDisplayMetrics(Context context, ILogger iLogger) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting DisplayMetrics.", th);
            return null;
        }
    }

    static String getFamily(ILogger iLogger) {
        try {
            return Build.MODEL.split(" ", -1)[0];
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting device family.", th);
            return null;
        }
    }

    static String getDeviceName(Context context) {
        return deviceName.getValue(context);
    }

    static String[] getArchitectures(BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    static ActivityManager.MemoryInfo getMemInfo(Context context, ILogger iLogger) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager == null) {
                iLogger.log(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
                return null;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    static Intent registerReceiver(Context context, SentryOptions sentryOptions, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return registerReceiver(context, new BuildInfoProvider(sentryOptions.getLogger()), broadcastReceiver, intentFilter);
    }

    static Intent registerReceiver(Context context, BuildInfoProvider buildInfoProvider, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        Intent registerReceiver;
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            registerReceiver = context.registerReceiver(broadcastReceiver, intentFilter, 4);
            return registerReceiver;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }

    static void setAppPackageInfo(PackageInfo packageInfo, BuildInfoProvider buildInfoProvider, App app) {
        app.setAppIdentifier(packageInfo.packageName);
        app.setAppVersion(packageInfo.versionName);
        app.setAppBuild(getVersionCode(packageInfo, buildInfoProvider));
        HashMap hashMap = new HashMap();
        String[] strArr = packageInfo.requestedPermissions;
        int[] iArr = packageInfo.requestedPermissionsFlags;
        if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                hashMap.put(str.substring(str.lastIndexOf(46) + 1), (iArr[i] & 2) == 2 ? PermissionsResponse.GRANTED_KEY : "not_granted");
            }
        }
        app.setPermissions(hashMap);
    }

    public static Context getApplicationContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    static void resetInstance() {
        deviceName.resetValue();
        isForegroundImportance.resetValue();
        staticPackageInfo33.resetValue();
        staticPackageInfo.resetValue();
        applicationName.resetValue();
        staticAppInfo33.resetValue();
        staticAppInfo.resetValue();
    }
}
