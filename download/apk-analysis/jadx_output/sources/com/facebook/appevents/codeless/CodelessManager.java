package com.facebook.appevents.codeless;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CodelessManager.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0007J\b\u0010\u0014\u001a\u00020\u0011H\u0007J\r\u0010\u0015\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0015\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\bH\u0001¢\u0006\u0002\b!R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/appevents/codeless/CodelessManager;", "", "()V", "deviceSessionID", "", "isAppIndexingEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCheckingSession", "", "isCodelessEnabled", "sensorManager", "Landroid/hardware/SensorManager;", "viewIndexer", "Lcom/facebook/appevents/codeless/ViewIndexer;", "viewIndexingTrigger", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "checkCodelessSession", "", "applicationId", "disable", "enable", "getCurrentDeviceSessionID", "getCurrentDeviceSessionID$facebook_core_release", "getIsAppIndexingEnabled", "getIsAppIndexingEnabled$facebook_core_release", "isDebugOnEmulator", "onActivityDestroyed", "activity", "Landroid/app/Activity;", "onActivityPaused", "onActivityResumed", "updateAppIndexing", "appIndexingEnabled", "updateAppIndexing$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CodelessManager {
    private static String deviceSessionID;
    private static volatile boolean isCheckingSession;
    private static SensorManager sensorManager;
    private static ViewIndexer viewIndexer;
    public static final CodelessManager INSTANCE = new CodelessManager();
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();
    private static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);
    private static final AtomicBoolean isAppIndexingEnabled = new AtomicBoolean(false);

    private final boolean isDebugOnEmulator() {
        CrashShieldHandler.isObjectCrashing(this);
        return false;
    }

    private CodelessManager() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:
    
        if (com.facebook.appevents.codeless.CodelessManager.INSTANCE.isDebugOnEmulator() != false) goto L15;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void onActivityResumed(android.app.Activity r7) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.CodelessManager> r0 = com.facebook.appevents.codeless.CodelessManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r1 == 0) goto L9
            return
        L9:
            java.lang.String r1 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)     // Catch: java.lang.Throwable -> L85
            java.util.concurrent.atomic.AtomicBoolean r1 = com.facebook.appevents.codeless.CodelessManager.isCodelessEnabled     // Catch: java.lang.Throwable -> L85
            boolean r1 = r1.get()     // Catch: java.lang.Throwable -> L85
            if (r1 != 0) goto L17
            return
        L17:
            com.facebook.appevents.codeless.CodelessMatcher$Companion r1 = com.facebook.appevents.codeless.CodelessMatcher.INSTANCE     // Catch: java.lang.Throwable -> L85
            com.facebook.appevents.codeless.CodelessMatcher r1 = r1.getInstance()     // Catch: java.lang.Throwable -> L85
            r1.add(r7)     // Catch: java.lang.Throwable -> L85
            android.content.Context r1 = r7.getApplicationContext()     // Catch: java.lang.Throwable -> L85
            java.lang.String r2 = com.facebook.FacebookSdk.getApplicationId()     // Catch: java.lang.Throwable -> L85
            com.facebook.internal.FetchedAppSettings r3 = com.facebook.internal.FetchedAppSettingsManager.getAppSettingsWithoutQuery(r2)     // Catch: java.lang.Throwable -> L85
            r4 = 1
            if (r3 == 0) goto L36
            boolean r5 = r3.getCodelessEventsEnabled()     // Catch: java.lang.Throwable -> L85
            if (r5 != r4) goto L36
            goto L3e
        L36:
            com.facebook.appevents.codeless.CodelessManager r5 = com.facebook.appevents.codeless.CodelessManager.INSTANCE     // Catch: java.lang.Throwable -> L85
            boolean r5 = r5.isDebugOnEmulator()     // Catch: java.lang.Throwable -> L85
            if (r5 == 0) goto L71
        L3e:
            java.lang.String r5 = "sensor"
            java.lang.Object r1 = r1.getSystemService(r5)     // Catch: java.lang.Throwable -> L85
            android.hardware.SensorManager r1 = (android.hardware.SensorManager) r1     // Catch: java.lang.Throwable -> L85
            if (r1 != 0) goto L49
            return
        L49:
            com.facebook.appevents.codeless.CodelessManager.sensorManager = r1     // Catch: java.lang.Throwable -> L85
            android.hardware.Sensor r4 = r1.getDefaultSensor(r4)     // Catch: java.lang.Throwable -> L85
            com.facebook.appevents.codeless.ViewIndexer r5 = new com.facebook.appevents.codeless.ViewIndexer     // Catch: java.lang.Throwable -> L85
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L85
            com.facebook.appevents.codeless.CodelessManager.viewIndexer = r5     // Catch: java.lang.Throwable -> L85
            com.facebook.appevents.codeless.ViewIndexingTrigger r7 = com.facebook.appevents.codeless.CodelessManager.viewIndexingTrigger     // Catch: java.lang.Throwable -> L85
            com.facebook.appevents.codeless.CodelessManager$$ExternalSyntheticLambda0 r6 = new com.facebook.appevents.codeless.CodelessManager$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> L85
            r6.<init>()     // Catch: java.lang.Throwable -> L85
            r7.setOnShakeListener(r6)     // Catch: java.lang.Throwable -> L85
            android.hardware.SensorEventListener r7 = (android.hardware.SensorEventListener) r7     // Catch: java.lang.Throwable -> L85
            r6 = 2
            r1.registerListener(r7, r4, r6)     // Catch: java.lang.Throwable -> L85
            if (r3 == 0) goto L71
            boolean r7 = r3.getCodelessEventsEnabled()     // Catch: java.lang.Throwable -> L85
            if (r7 == 0) goto L71
            r5.schedule()     // Catch: java.lang.Throwable -> L85
        L71:
            com.facebook.appevents.codeless.CodelessManager r7 = com.facebook.appevents.codeless.CodelessManager.INSTANCE     // Catch: java.lang.Throwable -> L85
            boolean r1 = r7.isDebugOnEmulator()     // Catch: java.lang.Throwable -> L85
            if (r1 == 0) goto L84
            java.util.concurrent.atomic.AtomicBoolean r1 = com.facebook.appevents.codeless.CodelessManager.isAppIndexingEnabled     // Catch: java.lang.Throwable -> L85
            boolean r1 = r1.get()     // Catch: java.lang.Throwable -> L85
            if (r1 != 0) goto L84
            r7.checkCodelessSession(r2)     // Catch: java.lang.Throwable -> L85
        L84:
            return
        L85:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessManager.onActivityResumed(android.app.Activity):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityResumed$lambda$0(FetchedAppSettings fetchedAppSettings, String appId) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(appId, "$appId");
            boolean z = fetchedAppSettings != null && fetchedAppSettings.getCodelessEventsEnabled();
            boolean codelessSetupEnabled = FacebookSdk.getCodelessSetupEnabled();
            if (z && codelessSetupEnabled) {
                INSTANCE.checkCodelessSession(appId);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final void onActivityPaused(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (isCodelessEnabled.get()) {
                CodelessMatcher.INSTANCE.getInstance().remove(activity);
                ViewIndexer viewIndexer2 = viewIndexer;
                if (viewIndexer2 != null) {
                    viewIndexer2.unschedule();
                }
                SensorManager sensorManager2 = sensorManager;
                if (sensorManager2 != null) {
                    sensorManager2.unregisterListener(viewIndexingTrigger);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final void onActivityDestroyed(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            CodelessMatcher.INSTANCE.getInstance().destroy(activity);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            isCodelessEnabled.set(true);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            isCodelessEnabled.set(false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    private final void checkCodelessSession(final String applicationId) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isCheckingSession) {
                return;
            }
            isCheckingSession = true;
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.codeless.CodelessManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CodelessManager.checkCodelessSession$lambda$1(applicationId);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkCodelessSession$lambda$1(String str) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.INSTANCE.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(Build.MODEL != null ? Build.MODEL : "");
            if ((attributionIdentifiers != null ? attributionIdentifiers.getAndroidAdvertiserId() : null) != null) {
                jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
            } else {
                jSONArray.put("");
            }
            jSONArray.put("0");
            jSONArray.put(AppEventUtility.isEmulator() ? "1" : "0");
            Locale currentLocale = Utility.getCurrentLocale();
            jSONArray.put(currentLocale.getLanguage() + '_' + currentLocale.getCountry());
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "extInfoArray.toString()");
            bundle.putString(Constants.DEVICE_SESSION_ID, getCurrentDeviceSessionID$facebook_core_release());
            bundle.putString(Constants.EXTINFO, jSONArray2);
            GraphRequest.Companion companion = GraphRequest.INSTANCE;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            boolean z = true;
            String format = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            JSONObject graphObject = companion.newPostRequestWithBundle(null, format, bundle, null).executeAndWait().getGraphObject();
            AtomicBoolean atomicBoolean = isAppIndexingEnabled;
            if (graphObject == null || !graphObject.optBoolean(Constants.APP_INDEXING_ENABLED, false)) {
                z = false;
            }
            atomicBoolean.set(z);
            if (!atomicBoolean.get()) {
                deviceSessionID = null;
            } else {
                ViewIndexer viewIndexer2 = viewIndexer;
                if (viewIndexer2 != null) {
                    viewIndexer2.schedule();
                }
            }
            isCheckingSession = false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final String getCurrentDeviceSessionID$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return null;
        }
        try {
            if (deviceSessionID == null) {
                deviceSessionID = UUID.randomUUID().toString();
            }
            String str = deviceSessionID;
            Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.String");
            return str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean getIsAppIndexingEnabled$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return false;
        }
        try {
            return isAppIndexingEnabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
            return false;
        }
    }

    @JvmStatic
    public static final void updateAppIndexing$facebook_core_release(boolean appIndexingEnabled) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            isAppIndexingEnabled.set(appIndexingEnabled);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }
}
