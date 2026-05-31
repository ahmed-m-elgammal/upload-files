package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.iap.InAppPurchaseLoggerManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppLinkManager;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookSdk.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0097\u0001\u0098\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020BH\u0007J\b\u0010L\u001a\u00020JH\u0007J\b\u0010M\u001a\u00020JH\u0007J\b\u0010N\u001a\u00020,H\u0007J\b\u0010O\u001a\u00020(H\u0007J\b\u0010P\u001a\u00020\u0004H\u0007J\n\u0010Q\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010S\u001a\u0004\u0018\u00010(H\u0007J\b\u0010T\u001a\u00020,H\u0007J\b\u0010U\u001a\u00020,H\u0007J\n\u0010V\u001a\u0004\u0018\u00010/H\u0007J\b\u0010W\u001a\u00020\u0018H\u0007J\b\u0010X\u001a\u00020\u0004H\u0007J\b\u0010Y\u001a\u00020,H\u0007J\b\u0010Z\u001a\u00020,H\u0007J\b\u0010[\u001a\u000204H\u0007J\b\u0010\\\u001a\u00020\u0004H\u0007J\b\u0010]\u001a\u00020\u0004H\u0007J\b\u0010^\u001a\u00020\u0004H\u0007J\b\u0010_\u001a\u00020\u0004H\u0007J\b\u0010`\u001a\u00020\u0004H\u0007J\b\u0010a\u001a\u00020\u0004H\u0007J\u0010\u0010b\u001a\u00020,2\u0006\u0010S\u001a\u00020(H\u0007J\u000e\u0010c\u001a\b\u0012\u0004\u0012\u00020B0dH\u0007J\b\u0010e\u001a\u00020,H\u0007J\b\u0010f\u001a\u00020gH\u0007J\b\u0010h\u001a\u00020\u0004H\u0007J\b\u0010i\u001a\u00020\u0004H\u0007J\b\u0010j\u001a\u00020,H\u0007J\u0010\u0010k\u001a\u00020,2\u0006\u0010l\u001a\u00020\u0018H\u0007J\b\u0010>\u001a\u00020,H\u0007J\b\u0010m\u001a\u00020,H\u0007J\b\u0010?\u001a\u00020,H\u0007J\u0010\u0010n\u001a\u00020,2\u0006\u0010K\u001a\u00020BH\u0007J\u0017\u0010o\u001a\u00020J2\b\u0010S\u001a\u0004\u0018\u00010(H\u0001¢\u0006\u0002\bpJ\u0018\u0010q\u001a\u00020J2\u0006\u0010S\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004H\u0003J\u0018\u0010r\u001a\u00020J2\u0006\u0010S\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004H\u0007J\u0010\u0010s\u001a\u00020J2\u0006\u0010K\u001a\u00020BH\u0007J\u0010\u0010t\u001a\u00020J2\u0006\u0010'\u001a\u00020(H\u0007J\u001a\u0010t\u001a\u00020J2\u0006\u0010'\u001a\u00020(2\b\u0010u\u001a\u0004\u0018\u00010vH\u0007J\u0018\u0010t\u001a\u00020J2\u0006\u0010'\u001a\u00020(2\u0006\u00100\u001a\u00020\u0018H\u0007J\"\u0010t\u001a\u00020J2\u0006\u0010'\u001a\u00020(2\u0006\u00100\u001a\u00020\u00182\b\u0010u\u001a\u0004\u0018\u00010vH\u0007J\u0010\u0010w\u001a\u00020J2\u0006\u0010x\u001a\u00020,H\u0007J\u0010\u0010y\u001a\u00020J2\u0006\u0010)\u001a\u00020\u0004H\u0007J\u0012\u0010z\u001a\u00020J2\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010{\u001a\u00020J2\u0006\u0010x\u001a\u00020,H\u0007J\u0010\u0010|\u001a\u00020J2\u0006\u0010x\u001a\u00020,H\u0007J\u0010\u0010}\u001a\u00020J2\u0006\u0010-\u001a\u00020/H\u0007J\u0012\u0010~\u001a\u00020J2\b\u0010\u007f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0011\u0010\u0080\u0001\u001a\u00020J2\u0006\u0010x\u001a\u00020,H\u0007J!\u0010\u0081\u0001\u001a\u00020J2\u0010\u0010\u0082\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0083\u0001H\u0007¢\u0006\u0003\u0010\u0084\u0001J3\u0010\u0081\u0001\u001a\u00020J2\u0010\u0010\u0082\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0083\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\u0018H\u0007¢\u0006\u0003\u0010\u0087\u0001J\u0011\u0010\u0088\u0001\u001a\u00020J2\u0006\u00103\u001a\u000204H\u0007J\u0011\u0010\u0089\u0001\u001a\u00020J2\u0006\u00105\u001a\u00020\u0004H\u0007J\u0011\u0010\u008a\u0001\u001a\u00020J2\u0006\u00106\u001a\u00020\u0004H\u0007J\u0017\u0010\u008b\u0001\u001a\u00020J2\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0003\b\u008c\u0001J\u0012\u0010\u008d\u0001\u001a\u00020J2\u0007\u0010\u008e\u0001\u001a\u00020,H\u0007J\u0012\u0010\u008f\u0001\u001a\u00020J2\u0007\u0010\u0090\u0001\u001a\u00020,H\u0007J\u001a\u0010\u0091\u0001\u001a\u00020J2\u0006\u0010S\u001a\u00020(2\u0007\u0010\u0092\u0001\u001a\u00020,H\u0007J\u0011\u0010\u0093\u0001\u001a\u00020J2\u0006\u0010x\u001a\u00020,H\u0007J\u0012\u0010\u0094\u0001\u001a\u00020J2\u0007\u0010\u0095\u0001\u001a\u00020gH\u0007J\t\u0010\u0096\u0001\u001a\u00020JH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n $*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0004\n\u0002\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u0012\u0012\u0004\u0012\u00020B0Aj\b\u0012\u0004\u0012\u00020B`CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/facebook/FacebookSdk;", "", "()V", "ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY", "", "APPLICATION_ID_PROPERTY", "APPLICATION_INTENT_URI_PACKAGE_TARGET", "APPLICATION_NAME_PROPERTY", "APPLICATION_REDIRECT_URI", "APP_EVENT_PREFERENCES", "ATTRIBUTION_PREFERENCES", "AUTO_INIT_ENABLED_PROPERTY", "AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY", "CALLBACK_OFFSET_CHANGED_AFTER_INIT", "CALLBACK_OFFSET_NEGATIVE", "CALLBACK_OFFSET_PROPERTY", "CLIENT_TOKEN_PROPERTY", "CLOUDBRIDGE_SAVED_CREDENTIALS", "CODELESS_DEBUG_LOG_ENABLED_PROPERTY", "DATA_PROCESSING_OPTIONS", "DATA_PROCESSING_OPTIONS_COUNTRY", "DATA_PROCESSING_OPTIONS_PREFERENCES", "DATA_PROCESSING_OPTIONS_STATE", "DEFAULT_CALLBACK_REQUEST_CODE_OFFSET", "", "FACEBOOK_COM", "FB_GG", "GAMING", "INSTAGRAM", "INSTAGRAM_COM", "LOCK", "Ljava/util/concurrent/locks/ReentrantLock;", "MAX_REQUEST_CODE_RANGE", "MONITOR_ENABLED_PROPERTY", "PUBLISH_ACTIVITY_PATH", "TAG", "kotlin.jvm.PlatformType", "WEB_DIALOG_THEME", "appClientToken", "applicationContext", "Landroid/content/Context;", "applicationId", "applicationName", "bypassAppSwitch", "", "cacheDir", "Lcom/facebook/internal/LockOnGetVariable;", "Ljava/io/File;", "callbackRequestCodeOffset", "codelessDebugLogEnabled", "Ljava/lang/Boolean;", "executor", "Ljava/util/concurrent/Executor;", "facebookDomain", "graphApiVersion", "graphRequestCreator", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "hasCustomTabsPrefetching", "ignoreAppSwitchToLoggedOut", "instagramDomain", "intentUriPackageTarget", "isDebugEnabledField", "isFullyInitialized", "isLegacyTokenUpgradeSupported", "loggingBehaviors", "Ljava/util/HashSet;", "Lcom/facebook/LoggingBehavior;", "Lkotlin/collections/HashSet;", "onProgressThreshold", "Ljava/util/concurrent/atomic/AtomicLong;", "redirectURI", "sdkInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "addLoggingBehavior", "", "behavior", "clearLoggingBehaviors", "fullyInitialize", "getAdvertiserIDCollectionEnabled", "getApplicationContext", "getApplicationId", "getApplicationName", "getApplicationSignature", "context", "getAutoInitEnabled", "getAutoLogAppEventsEnabled", "getCacheDir", "getCallbackRequestCodeOffset", "getClientToken", "getCodelessDebugLogEnabled", "getCodelessSetupEnabled", "getExecutor", "getFacebookDomain", "getFacebookGamingDomain", "getGraphApiVersion", "getGraphDomain", "getInstagramDomain", "getIntentUriPackageTarget", "getLimitEventAndDataUsage", "getLoggingBehaviors", "", "getMonitorEnabled", "getOnProgressThreshold", "", "getRedirectURI", "getSdkVersion", "isDebugEnabled", "isFacebookRequestCode", "requestCode", "isInitialized", "isLoggingBehaviorEnabled", "loadDefaultsFromMetadata", "loadDefaultsFromMetadata$facebook_core_release", "publishInstallAndWaitForResponse", "publishInstallAsync", "removeLoggingBehavior", "sdkInitialize", "callback", "Lcom/facebook/FacebookSdk$InitializeCallback;", "setAdvertiserIDCollectionEnabled", "flag", "setApplicationId", "setApplicationName", "setAutoInitEnabled", "setAutoLogAppEventsEnabled", "setCacheDir", "setClientToken", "clientToken", "setCodelessDebugLogEnabled", "setDataProcessingOptions", "options", "", "([Ljava/lang/String;)V", UserDataStore.COUNTRY, "state", "([Ljava/lang/String;II)V", "setExecutor", "setFacebookDomain", "setGraphApiVersion", "setGraphRequestCreator", "setGraphRequestCreator$facebook_core_release", "setIsDebugEnabled", "enabled", "setLegacyTokenUpgradeSupported", "supported", "setLimitEventAndDataUsage", "limitEventUsage", "setMonitorEnabled", "setOnProgressThreshold", "threshold", "updateGraphDebugBehavior", "GraphRequestCreator", "InitializeCallback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FacebookSdk {
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_INTENT_URI_PACKAGE_TARGET = "com.facebook.sdk.IntentUriPackageTarget";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    public static final String APPLICATION_REDIRECT_URI = "com.facebook.sdk.RedirectURI";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    public static final String AUTO_INIT_ENABLED_PROPERTY = "com.facebook.sdk.AutoInitEnabled";
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    public static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
    public static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    public static final String CLOUDBRIDGE_SAVED_CREDENTIALS = "com.facebook.sdk.CloudBridgeSavedCredentials";
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    public static final String DATA_PROCESSING_OPTIONS = "data_processing_options";
    public static final String DATA_PROCESSING_OPTIONS_COUNTRY = "data_processing_options_country";
    public static final String DATA_PROCESSING_OPTIONS_PREFERENCES = "com.facebook.sdk.DataProcessingOptions";
    public static final String DATA_PROCESSING_OPTIONS_STATE = "data_processing_options_state";
    public static final String FB_GG = "fb.gg";
    public static final String GAMING = "gaming";
    public static final String INSTAGRAM = "instagram";
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    public static final String MONITOR_ENABLED_PROPERTY = "com.facebook.sdk.MonitorEnabled";
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    private static volatile String appClientToken;
    private static Context applicationContext;
    private static volatile String applicationId;
    private static volatile String applicationName;
    public static boolean bypassAppSwitch;
    private static LockOnGetVariable<File> cacheDir;
    private static volatile Boolean codelessDebugLogEnabled;
    private static Executor executor;
    public static boolean hasCustomTabsPrefetching;
    public static boolean ignoreAppSwitchToLoggedOut;
    private static String intentUriPackageTarget;
    private static volatile boolean isDebugEnabledField;
    private static boolean isFullyInitialized;
    private static boolean isLegacyTokenUpgradeSupported;
    private static String redirectURI;
    public static final FacebookSdk INSTANCE = new FacebookSdk();
    private static final String TAG = FacebookSdk.class.getCanonicalName();
    private static final HashSet<LoggingBehavior> loggingBehaviors = SetsKt.hashSetOf(LoggingBehavior.DEVELOPER_ERRORS);
    private static AtomicLong onProgressThreshold = new AtomicLong(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    private static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    private static final AtomicBoolean sdkInitialized = new AtomicBoolean(false);
    public static final String INSTAGRAM_COM = "instagram.com";
    private static volatile String instagramDomain = INSTAGRAM_COM;
    public static final String FACEBOOK_COM = "facebook.com";
    private static volatile String facebookDomain = FACEBOOK_COM;
    private static GraphRequestCreator graphRequestCreator = new GraphRequestCreator() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda0
        @Override // com.facebook.FacebookSdk.GraphRequestCreator
        public final GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
            GraphRequest graphRequestCreator$lambda$0;
            graphRequestCreator$lambda$0 = FacebookSdk.graphRequestCreator$lambda$0(accessToken, str, jSONObject, callback);
            return graphRequestCreator$lambda$0;
        }
    };

    /* compiled from: FacebookSdk.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bá\u0080\u0001\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/facebook/FacebookSdk$GraphRequestCreator;", "", "createPostRequest", "Lcom/facebook/GraphRequest;", SDKConstants.PARAM_ACCESS_TOKEN, "Lcom/facebook/AccessToken;", "publishUrl", "", "publishParams", "Lorg/json/JSONObject;", "callback", "Lcom/facebook/GraphRequest$Callback;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface GraphRequestCreator {
        GraphRequest createPostRequest(AccessToken accessToken, String publishUrl, JSONObject publishParams, GraphRequest.Callback callback);
    }

    /* compiled from: FacebookSdk.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/FacebookSdk$InitializeCallback;", "", "onInitialized", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface InitializeCallback {
        void onInitialized();
    }

    private FacebookSdk() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GraphRequest graphRequestCreator$lambda$0(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
        return GraphRequest.INSTANCE.newPostRequest(accessToken, str, jSONObject, callback);
    }

    @JvmStatic
    public static final Executor getExecutor() {
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            Executor executor2 = executor;
            if (executor2 != null) {
                return executor2;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @JvmStatic
    public static final void setExecutor(Executor executor2) {
        Intrinsics.checkNotNullParameter(executor2, "executor");
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            executor = executor2;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @JvmStatic
    public static final long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    @JvmStatic
    public static final void setOnProgressThreshold(long threshold) {
        onProgressThreshold.set(threshold);
    }

    @JvmStatic
    public static final boolean isDebugEnabled() {
        return isDebugEnabledField;
    }

    @JvmStatic
    public static final void setIsDebugEnabled(boolean enabled) {
        isDebugEnabledField = enabled;
    }

    @JvmStatic
    public static final boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    @JvmStatic
    public static final void setLegacyTokenUpgradeSupported(boolean supported) {
        isLegacyTokenUpgradeSupported = supported;
    }

    @JvmStatic
    public static final String getGraphApiVersion() {
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{graphApiVersion}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        Utility.logd(str, format);
        return graphApiVersion;
    }

    @JvmStatic
    public static final void setGraphApiVersion(String graphApiVersion2) {
        Intrinsics.checkNotNullParameter(graphApiVersion2, "graphApiVersion");
        Log.w(TAG, "WARNING: Calling setGraphApiVersion from non-DEBUG code.");
        if (Utility.isNullOrEmpty(graphApiVersion2) || Intrinsics.areEqual(graphApiVersion, graphApiVersion2)) {
            return;
        }
        graphApiVersion = graphApiVersion2;
    }

    @JvmStatic
    public static final synchronized boolean isFullyInitialized() {
        boolean z;
        synchronized (FacebookSdk.class) {
            z = isFullyInitialized;
        }
        return z;
    }

    @JvmStatic
    public static final String getFacebookDomain() {
        return facebookDomain;
    }

    @JvmStatic
    public static final String getFacebookGamingDomain() {
        return "fb.gg";
    }

    @JvmStatic
    public static final String getInstagramDomain() {
        return instagramDomain;
    }

    @JvmStatic
    public static final void setFacebookDomain(String facebookDomain2) {
        Intrinsics.checkNotNullParameter(facebookDomain2, "facebookDomain");
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = facebookDomain2;
    }

    @Deprecated(message = "sdkInitialize is called automatically on app start. Use FacebookSdk.fullyInitialize() instead.")
    @JvmStatic
    public static final synchronized void sdkInitialize(Context applicationContext2, int callbackRequestCodeOffset2) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
            sdkInitialize(applicationContext2, callbackRequestCodeOffset2, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        com.facebook.FacebookSdk.callbackRequestCodeOffset = r3;
        sdkInitialize(r2, r4);
     */
    @kotlin.Deprecated(message = "sdkInitialize is called automatically on app start. Use FacebookSdk.fullyInitialize() instead.")
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final synchronized void sdkInitialize(android.content.Context r2, int r3, com.facebook.FacebookSdk.InitializeCallback r4) {
        /*
            java.lang.Class<com.facebook.FacebookSdk> r0 = com.facebook.FacebookSdk.class
            monitor-enter(r0)
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.atomic.AtomicBoolean r1 = com.facebook.FacebookSdk.sdkInitialized     // Catch: java.lang.Throwable -> L2e
            boolean r1 = r1.get()     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L1d
            int r1 = com.facebook.FacebookSdk.callbackRequestCodeOffset     // Catch: java.lang.Throwable -> L2e
            if (r3 != r1) goto L15
            goto L1d
        L15:
            com.facebook.FacebookException r2 = new com.facebook.FacebookException     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2e
            throw r2     // Catch: java.lang.Throwable -> L2e
        L1d:
            if (r3 < 0) goto L26
            com.facebook.FacebookSdk.callbackRequestCodeOffset = r3     // Catch: java.lang.Throwable -> L2e
            sdkInitialize(r2, r4)     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r0)
            return
        L26:
            com.facebook.FacebookException r2 = new com.facebook.FacebookException     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = "The callback request code offset can't be negative."
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2e
            throw r2     // Catch: java.lang.Throwable -> L2e
        L2e:
            r2 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.sdkInitialize(android.content.Context, int, com.facebook.FacebookSdk$InitializeCallback):void");
    }

    @Deprecated(message = "sdkInitialize is called automatically on app start. Use FacebookSdk.fullyInitialize() instead.")
    @JvmStatic
    public static final synchronized void sdkInitialize(Context applicationContext2) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
            sdkInitialize(applicationContext2, (InitializeCallback) null);
        }
    }

    @Deprecated(message = "sdkInitialize is called automatically on app start. Use FacebookSdk.fullyInitialize() instead.")
    @JvmStatic
    public static final synchronized void sdkInitialize(Context applicationContext2, final InitializeCallback callback) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
            if (sdkInitialized.get()) {
                if (callback != null) {
                    callback.onInitialized();
                }
                return;
            }
            try {
                Class.forName("com.facebook.FacebookActivity");
                Validate.hasFacebookActivity(applicationContext2, false);
            } catch (ClassNotFoundException unused) {
            }
            Validate.hasInternetPermissions(applicationContext2, false);
            Context applicationContext3 = applicationContext2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext3, "applicationContext.applicationContext");
            applicationContext = applicationContext3;
            AppEventsLogger.INSTANCE.getAnonymousAppDeviceGUID(applicationContext2);
            Context context = applicationContext;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                context = null;
            }
            loadDefaultsFromMetadata$facebook_core_release(context);
            String str = applicationId;
            if (str == null || str.length() == 0) {
                throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
            }
            String str2 = appClientToken;
            if (str2 == null || str2.length() == 0) {
                throw new FacebookException("A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk.");
            }
            sdkInitialized.set(true);
            if (getAutoInitEnabled()) {
                fullyInitialize();
            }
            Context context3 = applicationContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                context3 = null;
            }
            if ((context3 instanceof Application) && UserSettingsManager.getAutoLogAppEventsEnabled()) {
                Context context4 = applicationContext;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                    context4 = null;
                }
                ActivityLifecycleTracker.startTracking((Application) context4, applicationId);
            } else {
                InAppPurchaseLoggerManager.updateLatestPossiblePurchaseTime();
            }
            AppLinkManager companion = AppLinkManager.INSTANCE.getInstance();
            if (companion != null) {
                Context context5 = applicationContext;
                if (context5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                    context5 = null;
                }
                companion.setupLifecycleListener((Application) context5);
            }
            FetchedAppSettingsManager.loadAppSettingsAsync();
            NativeProtocol.updateAllAvailableProtocolVersionsAsync();
            BoltsMeasurementEventListener.Companion companion2 = BoltsMeasurementEventListener.INSTANCE;
            Context context6 = applicationContext;
            if (context6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            } else {
                context2 = context6;
            }
            companion2.getInstance(context2);
            cacheDir = new LockOnGetVariable<>(new Callable() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    File sdkInitialize$lambda$3;
                    sdkInitialize$lambda$3 = FacebookSdk.sdkInitialize$lambda$3();
                    return sdkInitialize$lambda$3;
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.Instrument, new FeatureManager.Callback() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda2
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    FacebookSdk.sdkInitialize$lambda$4(z);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.AppEvents, new FeatureManager.Callback() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda3
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    FacebookSdk.sdkInitialize$lambda$5(z);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.ChromeCustomTabsPrefetching, new FeatureManager.Callback() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda4
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    FacebookSdk.sdkInitialize$lambda$6(z);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.IgnoreAppSwitchToLoggedOut, new FeatureManager.Callback() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda5
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    FacebookSdk.sdkInitialize$lambda$7(z);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.BypassAppSwitch, new FeatureManager.Callback() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda6
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    FacebookSdk.sdkInitialize$lambda$8(z);
                }
            });
            getExecutor().execute(new FutureTask(new Callable() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda7
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void sdkInitialize$lambda$9;
                    sdkInitialize$lambda$9 = FacebookSdk.sdkInitialize$lambda$9(FacebookSdk.InitializeCallback.this);
                    return sdkInitialize$lambda$9;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File sdkInitialize$lambda$3() {
        Context context = applicationContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        return context.getCacheDir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sdkInitialize$lambda$4(boolean z) {
        if (z) {
            InstrumentManager.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sdkInitialize$lambda$5(boolean z) {
        if (z) {
            AppEventsManager.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sdkInitialize$lambda$6(boolean z) {
        if (z) {
            hasCustomTabsPrefetching = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sdkInitialize$lambda$7(boolean z) {
        if (z) {
            ignoreAppSwitchToLoggedOut = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sdkInitialize$lambda$8(boolean z) {
        if (z) {
            bypassAppSwitch = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void sdkInitialize$lambda$9(InitializeCallback initializeCallback) {
        AccessTokenManager.INSTANCE.getInstance().loadCurrentAccessToken();
        ProfileManager.INSTANCE.getInstance().loadCurrentProfile();
        if (AccessToken.INSTANCE.isCurrentAccessTokenActive() && Profile.INSTANCE.getCurrentProfile() == null) {
            Profile.INSTANCE.fetchProfileForCurrentAccessToken();
        }
        if (initializeCallback != null) {
            initializeCallback.onInitialized();
        }
        AppEventsLogger.INSTANCE.initializeLib(getApplicationContext(), applicationId);
        UserSettingsManager.logIfAutoAppLinkEnabled();
        AppEventsLogger.Companion companion = AppEventsLogger.INSTANCE;
        Context applicationContext2 = getApplicationContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext().applicationContext");
        companion.newLogger(applicationContext2).flush();
        return null;
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return sdkInitialized.get();
    }

    @JvmStatic
    public static final void fullyInitialize() {
        isFullyInitialized = true;
    }

    @JvmStatic
    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(hashSet));
            Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(HashSet(loggingBehaviors))");
        }
        return unmodifiableSet;
    }

    @JvmStatic
    public static final void addLoggingBehavior(LoggingBehavior behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.add(behavior);
            INSTANCE.updateGraphDebugBehavior();
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void removeLoggingBehavior(LoggingBehavior behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.remove(behavior);
        }
    }

    @JvmStatic
    public static final void clearLoggingBehaviors() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final boolean isLoggingBehaviorEnabled(LoggingBehavior behavior) {
        boolean z;
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            if (isDebugEnabled()) {
                z = hashSet.contains(behavior);
            }
        }
        return z;
    }

    private final void updateGraphDebugBehavior() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        if (!hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) || hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            return;
        }
        hashSet.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
    }

    @JvmStatic
    public static final String getGraphDomain() {
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        return Utility.getGraphDomainFromTokenDomain(currentAccessToken != null ? currentAccessToken.getGraphDomain() : null);
    }

    @JvmStatic
    public static final Context getApplicationContext() {
        Validate.sdkInitialized();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        return null;
    }

    @JvmStatic
    public static final void publishInstallAsync(Context context, final String applicationId2) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(applicationId2, "applicationId");
            final Context applicationContext2 = context.getApplicationContext();
            if (applicationContext2 == null) {
                return;
            }
            if (!FetchedAppGateKeepersManager.getGateKeeperForKey(AppEventsLoggerImpl.APP_EVENTS_KILLSWITCH, getApplicationId(), false)) {
                getExecutor().execute(new Runnable() { // from class: com.facebook.FacebookSdk$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        FacebookSdk.publishInstallAsync$lambda$15(applicationContext2, applicationId2);
                    }
                });
            }
            if (FeatureManager.isEnabled(FeatureManager.Feature.OnDeviceEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                OnDeviceProcessingManager.sendInstallEventAsync(applicationId2, ATTRIBUTION_PREFERENCES);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void publishInstallAsync$lambda$15(Context applicationContext2, String applicationId2) {
        Intrinsics.checkNotNullParameter(applicationContext2, "$applicationContext");
        Intrinsics.checkNotNullParameter(applicationId2, "$applicationId");
        INSTANCE.publishInstallAndWaitForResponse(applicationContext2, applicationId2);
    }

    private final void publishInstallAndWaitForResponse(Context context, String applicationId2) {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.INSTANCE.getAttributionIdentifiers(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
                String str = applicationId2 + "ping";
                long j = sharedPreferences.getLong(str, 0L);
                try {
                    JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.INSTANCE.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
                    String installReferrer = AppEventsLoggerImpl.INSTANCE.getInstallReferrer();
                    if (installReferrer != null) {
                        jSONObjectForGraphAPICall.put("install_referrer", installReferrer);
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(PUBLISH_ACTIVITY_PATH, Arrays.copyOf(new Object[]{applicationId2}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    GraphRequest createPostRequest = graphRequestCreator.createPostRequest(null, format, jSONObjectForGraphAPICall, null);
                    if (j == 0 && createPostRequest.executeAndWait().getError() == null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putLong(str, System.currentTimeMillis());
                        edit.apply();
                        Logger.Companion companion = Logger.INSTANCE;
                        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                        String TAG2 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        companion.log(loggingBehavior, TAG2, "MOBILE_APP_INSTALL has been logged");
                    }
                } catch (JSONException e) {
                    throw new FacebookException("An error occurred while publishing install.", e);
                }
            } catch (Exception e2) {
                Utility.logd("Facebook-publish", e2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    @JvmStatic
    public static final boolean getLimitEventAndDataUsage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Validate.sdkInitialized();
        return context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    @JvmStatic
    public static final void setLimitEventAndDataUsage(Context context, boolean limitEventUsage) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", limitEventUsage).apply();
    }

    @JvmStatic
    public static final void loadDefaultsFromMetadata$facebook_core_release(Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "try {\n                co…     return\n            }");
            if (applicationInfo.metaData == null) {
                return;
            }
            if (applicationId == null) {
                Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                if (obj instanceof String) {
                    String str = (String) obj;
                    Locale ROOT = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                    String lowerCase = str.toLowerCase(ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    if (StringsKt.startsWith$default(lowerCase, "fb", false, 2, (Object) null)) {
                        String substring = str.substring(2);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        applicationId = substring;
                    } else {
                        applicationId = str;
                    }
                } else if (obj instanceof Number) {
                    throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            redirectURI = applicationInfo.metaData.getString(APPLICATION_REDIRECT_URI);
            intentUriPackageTarget = applicationInfo.metaData.getString(APPLICATION_INTENT_URI_PACKAGE_TARGET);
            if (applicationName == null) {
                applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
            }
            if (appClientToken == null) {
                appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
            }
            if (callbackRequestCodeOffset == DEFAULT_CALLBACK_REQUEST_CODE_OFFSET) {
                callbackRequestCodeOffset = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
            }
            if (codelessDebugLogEnabled == null) {
                codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    @JvmStatic
    public static final String getApplicationSignature(Context context) {
        PackageManager packageManager;
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return null;
        }
        try {
            Validate.sdkInitialized();
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null && signatureArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    messageDigest.update(packageInfo.signatures[0].toByteArray());
                    return Base64.encodeToString(messageDigest.digest(), 9);
                }
            } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getApplicationId() {
        Validate.sdkInitialized();
        String str = applicationId;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    @JvmStatic
    public static final String getRedirectURI() {
        Validate.sdkInitialized();
        String str = redirectURI;
        return str == null ? "" : str;
    }

    @JvmStatic
    public static final String getIntentUriPackageTarget() {
        Validate.sdkInitialized();
        String str = intentUriPackageTarget;
        return str == null ? "" : str;
    }

    @JvmStatic
    public static final void setApplicationId(String applicationId2) {
        Intrinsics.checkNotNullParameter(applicationId2, "applicationId");
        Validate.notEmpty(applicationId2, "applicationId");
        applicationId = applicationId2;
    }

    @JvmStatic
    public static final String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    @JvmStatic
    public static final void setApplicationName(String applicationName2) {
        applicationName = applicationName2;
    }

    @JvmStatic
    public static final String getClientToken() {
        Validate.sdkInitialized();
        String str = appClientToken;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
    }

    @JvmStatic
    public static final void setClientToken(String clientToken) {
        appClientToken = clientToken;
    }

    @JvmStatic
    public static final boolean getAutoInitEnabled() {
        return UserSettingsManager.getAutoInitEnabled();
    }

    @JvmStatic
    public static final void setAutoInitEnabled(boolean flag) {
        UserSettingsManager.setAutoInitEnabled(flag);
        if (flag) {
            fullyInitialize();
        }
    }

    @JvmStatic
    public static final boolean getAutoLogAppEventsEnabled() {
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    @JvmStatic
    public static final void setAutoLogAppEventsEnabled(boolean flag) {
        UserSettingsManager.setAutoLogAppEventsEnabled(flag);
        if (flag) {
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkNotNull(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ActivityLifecycleTracker.startTracking((Application) applicationContext2, getApplicationId());
        }
    }

    @JvmStatic
    public static final boolean getCodelessDebugLogEnabled() {
        Validate.sdkInitialized();
        Boolean bool = codelessDebugLogEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final boolean getCodelessSetupEnabled() {
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    @JvmStatic
    public static final boolean getAdvertiserIDCollectionEnabled() {
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    @JvmStatic
    public static final void setAdvertiserIDCollectionEnabled(boolean flag) {
        UserSettingsManager.setAdvertiserIDCollectionEnabled(flag);
    }

    @JvmStatic
    public static final void setCodelessDebugLogEnabled(boolean flag) {
        codelessDebugLogEnabled = Boolean.valueOf(flag);
    }

    @JvmStatic
    public static final boolean getMonitorEnabled() {
        return UserSettingsManager.getMonitorEnabled();
    }

    @JvmStatic
    public static final void setMonitorEnabled(boolean flag) {
        UserSettingsManager.setMonitorEnabled(flag);
    }

    @JvmStatic
    public static final void setDataProcessingOptions(String[] options) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        try {
            setDataProcessingOptions(options, 0, 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
        }
    }

    @JvmStatic
    public static final void setDataProcessingOptions(String[] options, int country, int state) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        if (options == null) {
            try {
                options = new String[0];
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DATA_PROCESSING_OPTIONS, new JSONArray((Collection) ArraysKt.toList(options)));
            jSONObject.put(DATA_PROCESSING_OPTIONS_COUNTRY, country);
            jSONObject.put(DATA_PROCESSING_OPTIONS_STATE, state);
            Context context = applicationContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                context = null;
            }
            context.getSharedPreferences(DATA_PROCESSING_OPTIONS_PREFERENCES, 0).edit().putString(DATA_PROCESSING_OPTIONS, jSONObject.toString()).apply();
        } catch (JSONException unused) {
        }
    }

    @JvmStatic
    public static final File getCacheDir() {
        Validate.sdkInitialized();
        LockOnGetVariable<File> lockOnGetVariable = cacheDir;
        if (lockOnGetVariable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheDir");
            lockOnGetVariable = null;
        }
        return lockOnGetVariable.getValue();
    }

    @JvmStatic
    public static final void setCacheDir(File cacheDir2) {
        Intrinsics.checkNotNullParameter(cacheDir2, "cacheDir");
        cacheDir = new LockOnGetVariable<>(cacheDir2);
    }

    @JvmStatic
    public static final int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    @JvmStatic
    public static final boolean isFacebookRequestCode(int requestCode) {
        int i = callbackRequestCodeOffset;
        return requestCode >= i && requestCode < i + 100;
    }

    @JvmStatic
    public static final void setGraphRequestCreator$facebook_core_release(GraphRequestCreator graphRequestCreator2) {
        Intrinsics.checkNotNullParameter(graphRequestCreator2, "graphRequestCreator");
        graphRequestCreator = graphRequestCreator2;
    }
}
