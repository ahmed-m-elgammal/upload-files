package com.facebook.appevents.integrity;

import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MACARuleMatchingManager.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\""}, d2 = {"Lcom/facebook/appevents/integrity/MACARuleMatchingManager;", "", "()V", "MACARules", "Lorg/json/JSONArray;", "enabled", "", "keys", "", "", "[Ljava/lang/String;", "enable", "", "generateInfo", "params", "Landroid/os/Bundle;", NotificationCompat.CATEGORY_EVENT, "getKey", "logic", "Lorg/json/JSONObject;", "getMatchPropertyIDs", "getStringArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "isMatchCCRule", "ruleString", "data", "loadMACARules", "processParameters", "removeGeneratedInfo", "stringComparison", RRWebVideoEvent.REPLAY_FRAME_RATE_TYPE_VARIABLE, "values", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MACARuleMatchingManager {
    private static JSONArray MACARules;
    private static boolean enabled;
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    private static String[] keys = {NotificationCompat.CATEGORY_EVENT, "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private MACARuleMatchingManager() {
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            INSTANCE.loadMACARules();
            if (MACARules != null) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    private final void loadMACARules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings == null) {
                return;
            }
            MACARules = queryAppSettings.getMACARuleMatchingSetting();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final String getKey(JSONObject logic) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(logic, "logic");
            Iterator<String> keys2 = logic.keys();
            if (keys2.hasNext()) {
                return keys2.next();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        if (r7 == null) goto L19;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0348 A[Catch: all -> 0x037d, TryCatch #0 {all -> 0x037d, blocks: (B:6:0x000a, B:9:0x001d, B:12:0x0038, B:20:0x004a, B:22:0x0065, B:23:0x006a, B:26:0x006f, B:30:0x0079, B:32:0x0095, B:36:0x009f, B:42:0x00af, B:48:0x0225, B:50:0x022b, B:53:0x0235, B:54:0x0239, B:56:0x023f, B:63:0x00b9, B:67:0x00c3, B:69:0x00e3, B:75:0x0270, B:77:0x0276, B:81:0x0281, B:82:0x0285, B:84:0x028b, B:91:0x00ed, B:95:0x00f7, B:97:0x0113, B:101:0x01c1, B:104:0x011d, B:108:0x01a6, B:112:0x0127, B:116:0x0181, B:120:0x0131, B:124:0x013b, B:128:0x0207, B:132:0x0145, B:136:0x014f, B:142:0x0348, B:144:0x0159, B:148:0x01d8, B:152:0x0163, B:156:0x016d, B:160:0x01f3, B:162:0x0177, B:166:0x0192, B:170:0x019c, B:174:0x01b7, B:178:0x01ce, B:182:0x01e9, B:186:0x01fd, B:190:0x0218, B:194:0x0263, B:198:0x02af, B:202:0x02b9, B:206:0x02d7, B:210:0x02e1, B:212:0x02ef, B:218:0x0333, B:220:0x02f9, B:224:0x0303, B:226:0x0314, B:230:0x031e, B:232:0x0327, B:236:0x033c, B:240:0x0351, B:244:0x035a, B:248:0x005b), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0333 A[Catch: all -> 0x037d, TryCatch #0 {all -> 0x037d, blocks: (B:6:0x000a, B:9:0x001d, B:12:0x0038, B:20:0x004a, B:22:0x0065, B:23:0x006a, B:26:0x006f, B:30:0x0079, B:32:0x0095, B:36:0x009f, B:42:0x00af, B:48:0x0225, B:50:0x022b, B:53:0x0235, B:54:0x0239, B:56:0x023f, B:63:0x00b9, B:67:0x00c3, B:69:0x00e3, B:75:0x0270, B:77:0x0276, B:81:0x0281, B:82:0x0285, B:84:0x028b, B:91:0x00ed, B:95:0x00f7, B:97:0x0113, B:101:0x01c1, B:104:0x011d, B:108:0x01a6, B:112:0x0127, B:116:0x0181, B:120:0x0131, B:124:0x013b, B:128:0x0207, B:132:0x0145, B:136:0x014f, B:142:0x0348, B:144:0x0159, B:148:0x01d8, B:152:0x0163, B:156:0x016d, B:160:0x01f3, B:162:0x0177, B:166:0x0192, B:170:0x019c, B:174:0x01b7, B:178:0x01ce, B:182:0x01e9, B:186:0x01fd, B:190:0x0218, B:194:0x0263, B:198:0x02af, B:202:0x02b9, B:206:0x02d7, B:210:0x02e1, B:212:0x02ef, B:218:0x0333, B:220:0x02f9, B:224:0x0303, B:226:0x0314, B:230:0x031e, B:232:0x0327, B:236:0x033c, B:240:0x0351, B:244:0x035a, B:248:0x005b), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0225 A[Catch: all -> 0x037d, TryCatch #0 {all -> 0x037d, blocks: (B:6:0x000a, B:9:0x001d, B:12:0x0038, B:20:0x004a, B:22:0x0065, B:23:0x006a, B:26:0x006f, B:30:0x0079, B:32:0x0095, B:36:0x009f, B:42:0x00af, B:48:0x0225, B:50:0x022b, B:53:0x0235, B:54:0x0239, B:56:0x023f, B:63:0x00b9, B:67:0x00c3, B:69:0x00e3, B:75:0x0270, B:77:0x0276, B:81:0x0281, B:82:0x0285, B:84:0x028b, B:91:0x00ed, B:95:0x00f7, B:97:0x0113, B:101:0x01c1, B:104:0x011d, B:108:0x01a6, B:112:0x0127, B:116:0x0181, B:120:0x0131, B:124:0x013b, B:128:0x0207, B:132:0x0145, B:136:0x014f, B:142:0x0348, B:144:0x0159, B:148:0x01d8, B:152:0x0163, B:156:0x016d, B:160:0x01f3, B:162:0x0177, B:166:0x0192, B:170:0x019c, B:174:0x01b7, B:178:0x01ce, B:182:0x01e9, B:186:0x01fd, B:190:0x0218, B:194:0x0263, B:198:0x02af, B:202:0x02b9, B:206:0x02d7, B:210:0x02e1, B:212:0x02ef, B:218:0x0333, B:220:0x02f9, B:224:0x0303, B:226:0x0314, B:230:0x031e, B:232:0x0327, B:236:0x033c, B:240:0x0351, B:244:0x035a, B:248:0x005b), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0270 A[Catch: all -> 0x037d, TryCatch #0 {all -> 0x037d, blocks: (B:6:0x000a, B:9:0x001d, B:12:0x0038, B:20:0x004a, B:22:0x0065, B:23:0x006a, B:26:0x006f, B:30:0x0079, B:32:0x0095, B:36:0x009f, B:42:0x00af, B:48:0x0225, B:50:0x022b, B:53:0x0235, B:54:0x0239, B:56:0x023f, B:63:0x00b9, B:67:0x00c3, B:69:0x00e3, B:75:0x0270, B:77:0x0276, B:81:0x0281, B:82:0x0285, B:84:0x028b, B:91:0x00ed, B:95:0x00f7, B:97:0x0113, B:101:0x01c1, B:104:0x011d, B:108:0x01a6, B:112:0x0127, B:116:0x0181, B:120:0x0131, B:124:0x013b, B:128:0x0207, B:132:0x0145, B:136:0x014f, B:142:0x0348, B:144:0x0159, B:148:0x01d8, B:152:0x0163, B:156:0x016d, B:160:0x01f3, B:162:0x0177, B:166:0x0192, B:170:0x019c, B:174:0x01b7, B:178:0x01ce, B:182:0x01e9, B:186:0x01fd, B:190:0x0218, B:194:0x0263, B:198:0x02af, B:202:0x02b9, B:206:0x02d7, B:210:0x02e1, B:212:0x02ef, B:218:0x0333, B:220:0x02f9, B:224:0x0303, B:226:0x0314, B:230:0x031e, B:232:0x0327, B:236:0x033c, B:240:0x0351, B:244:0x035a, B:248:0x005b), top: B:5:0x000a }] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean stringComparison(java.lang.String r8, org.json.JSONObject r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.integrity.MACARuleMatchingManager.stringComparison(java.lang.String, org.json.JSONObject, android.os.Bundle):boolean");
    }

    @JvmStatic
    public static final ArrayList<String> getStringArrayList(JSONArray jsonArray) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) || jsonArray == null) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(jsonArray.get(i).toString());
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isMatchCCRule(String ruleString, Bundle data) {
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) && ruleString != null && data != null) {
            try {
                JSONObject jSONObject = new JSONObject(ruleString);
                String key = getKey(jSONObject);
                if (key == null) {
                    return false;
                }
                Object obj = jSONObject.get(key);
                int hashCode = key.hashCode();
                if (hashCode != 3555) {
                    if (hashCode != 96727) {
                        if (hashCode == 109267 && key.equals("not")) {
                            return !isMatchCCRule(obj.toString(), data);
                        }
                    } else if (key.equals("and")) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray == null) {
                            return false;
                        }
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            if (!isMatchCCRule(jSONArray.get(i).toString(), data)) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if (key.equals("or")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2 == null) {
                        return false;
                    }
                    int length2 = jSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        if (isMatchCCRule(jSONArray2.get(i2).toString(), data)) {
                            return true;
                        }
                    }
                    return false;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    return false;
                }
                return stringComparison(key, jSONObject2, data);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            }
        }
        return false;
    }

    @JvmStatic
    public static final String getMatchPropertyIDs(Bundle params) {
        String optString;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = MACARules;
            if (jSONArray == null) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            if (jSONArray != null && jSONArray.length() == 0) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            JSONArray jSONArray2 = MACARules;
            Intrinsics.checkNotNull(jSONArray2, "null cannot be cast to non-null type org.json.JSONArray");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                String optString2 = jSONArray2.optString(i);
                if (optString2 != null) {
                    JSONObject jSONObject = new JSONObject(optString2);
                    long optLong = jSONObject.optLong("id");
                    if (optLong != 0 && (optString = jSONObject.optString("rule")) != null && isMatchCCRule(optString, params)) {
                        arrayList.add(Long.valueOf(optLong));
                    }
                }
            }
            String jSONArray3 = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray3, "JSONArray(res).toString()");
            return jSONArray3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final void processParameters(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!enabled || params == null) {
                return;
            }
            try {
                generateInfo(params, event);
                params.putString("_audiencePropertyIds", getMatchPropertyIDs(params));
                params.putString("cs_maca", "1");
                removeGeneratedInfo(params);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void generateInfo(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(event, "event");
            params.putString(NotificationCompat.CATEGORY_EVENT, event);
            StringBuilder sb = new StringBuilder();
            Locale locale = Utility.INSTANCE.getLocale();
            String language = locale != null ? locale.getLanguage() : null;
            String str = "";
            if (language == null) {
                language = "";
            }
            sb.append(language);
            sb.append('_');
            Locale locale2 = Utility.INSTANCE.getLocale();
            String country = locale2 != null ? locale2.getCountry() : null;
            if (country == null) {
                country = "";
            }
            sb.append(country);
            params.putString("_locale", sb.toString());
            String versionName = Utility.INSTANCE.getVersionName();
            if (versionName == null) {
                versionName = "";
            }
            params.putString("_appVersion", versionName);
            params.putString("_deviceOS", "ANDROID");
            params.putString("_platform", "mobile");
            String str2 = Build.MODEL;
            if (str2 == null) {
                str2 = "";
            }
            params.putString("_deviceModel", str2);
            params.putString("_nativeAppID", FacebookSdk.getApplicationId());
            String versionName2 = Utility.INSTANCE.getVersionName();
            if (versionName2 != null) {
                str = versionName2;
            }
            params.putString("_nativeAppShortVersion", str);
            params.putString("_timezone", Utility.INSTANCE.getDeviceTimeZoneName());
            params.putString("_carrier", Utility.INSTANCE.getCarrierName());
            params.putString("_deviceOSTypeName", "ANDROID");
            params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
            params.putLong("_remainingDiskGB", Utility.INSTANCE.getAvailableExternalStorageGB());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void removeGeneratedInfo(Bundle params) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            for (String str : keys) {
                params.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }
}
