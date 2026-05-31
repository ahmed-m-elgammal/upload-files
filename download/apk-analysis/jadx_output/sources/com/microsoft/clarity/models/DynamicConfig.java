package com.microsoft.clarity.models;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.webkit.ProxyConfig;
import androidx.webkit.WebViewAssetLoader;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.microsoft.clarity.m.h;
import com.microsoft.clarity.models.ingest.IngestConfigs;
import com.microsoft.clarity.models.project.ScreenNameFilter;
import com.microsoft.clarity.models.project.UrlFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 N2\u00020\u0001:\u0001NB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u000eH\u0000¢\u0006\u0002\bMR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\u000e0\u000e0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\u000e0\u000e0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010*\u001a\u0004\u0018\u00010+¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u00101\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0010R\u0017\u00103\u001a\b\u0012\u0004\u0012\u0002040\u001f¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0017\u00106\u001a\b\u0012\u0004\u0012\u0002040\u001f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0017R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0017R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0017R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0017R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\"R\u001f\u0010B\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\u000e0\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0017R\u001f\u0010D\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\u000e0\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0017R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u001f¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\"R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020G0\u001f¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\"¨\u0006O"}, d2 = {"Lcom/microsoft/clarity/models/DynamicConfig;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowMeteredNetwork", "", "getAllowMeteredNetwork", "()Z", "disableForLowEndDevices", "getDisableForLowEndDevices", "disableWebViewCapture", "getDisableWebViewCapture", "ingestUrl", "", "getIngestUrl", "()Ljava/lang/String;", "isClarityActivated", "leanMode", "getLeanMode", "maskedClasses", "", "getMaskedClasses", "()Ljava/util/Set;", "maskedFragments", "getMaskedFragments", "maskedIds", "getMaskedIds", "maskedScreens", "getMaskedScreens", "maskedViewIds", "", "", "getMaskedViewIds", "()Ljava/util/List;", "maskingMode", "Lcom/microsoft/clarity/models/MaskingMode;", "getMaskingMode", "()Lcom/microsoft/clarity/models/MaskingMode;", "nativeMaskSelectors", "kotlin.jvm.PlatformType", "nativeUnmaskSelectors", "networkMaxDailyDataInMB", "", "getNetworkMaxDailyDataInMB", "()Ljava/lang/Long;", "Ljava/lang/Long;", "preferences", "Landroid/content/SharedPreferences;", "reportUrl", "getReportUrl", "screenCaptureAllowedScreens", "Lcom/microsoft/clarity/models/project/ScreenNameFilter;", "getScreenCaptureAllowedScreens", "screenCaptureDisallowedScreens", "getScreenCaptureDisallowedScreens", "unmaskedClasses", "getUnmaskedClasses", "unmaskedFragments", "getUnmaskedFragments", "unmaskedIds", "getUnmaskedIds", "unmaskedScreens", "getUnmaskedScreens", "unmaskedViewIds", "getUnmaskedViewIds", "webMaskSelectors", "getWebMaskSelectors", "webUnmaskSelectors", "getWebUnmaskSelectors", "webViewCaptureAllowedUrls", "Lcom/microsoft/clarity/models/project/UrlFilter;", "getWebViewCaptureAllowedUrls", "webViewCaptureDisallowedUrls", "getWebViewCaptureDisallowedUrls", "isAllowedUrl", "urlString", "isAllowedUrl$sdk_prodRelease", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DynamicConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean allowMeteredNetwork;
    private final boolean disableForLowEndDevices;
    private final boolean disableWebViewCapture;
    private final String ingestUrl;
    private final boolean isClarityActivated;
    private final boolean leanMode;
    private final Set<String> maskedClasses;
    private final Set<String> maskedFragments;
    private final Set<String> maskedIds;
    private final Set<String> maskedScreens;
    private final List<Integer> maskedViewIds;
    private final MaskingMode maskingMode;
    private final Set<String> nativeMaskSelectors;
    private final Set<String> nativeUnmaskSelectors;
    private final Long networkMaxDailyDataInMB;
    private final SharedPreferences preferences;
    private final String reportUrl;
    private final List<ScreenNameFilter> screenCaptureAllowedScreens;
    private final List<ScreenNameFilter> screenCaptureDisallowedScreens;
    private final Set<String> unmaskedClasses;
    private final Set<String> unmaskedFragments;
    private final Set<String> unmaskedIds;
    private final Set<String> unmaskedScreens;
    private final List<Integer> unmaskedViewIds;
    private final Set<String> webMaskSelectors;
    private final Set<String> webUnmaskSelectors;
    private final List<UrlFilter> webViewCaptureAllowedUrls;
    private final List<UrlFilter> webViewCaptureDisallowedUrls;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/microsoft/clarity/models/DynamicConfig$Companion;", "", "()V", "getPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "isFetched", "", "updateSharedPreferences", "", "ingestConfigs", "Lcom/microsoft/clarity/models/ingest/IngestConfigs;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SharedPreferences getPreferences(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("CLARITY_SHARED_PREFERENCES", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…le, Context.MODE_PRIVATE)");
            return sharedPreferences;
        }

        public final boolean isFetched(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getPreferences(context).contains("CLARITY_CONFIG_FETCHED");
        }

        private Companion() {
        }

        public final void updateSharedPreferences(Context context, IngestConfigs ingestConfigs) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(ingestConfigs, "ingestConfigs");
            SharedPreferences.Editor edit = getPreferences(context).edit();
            edit.putBoolean("CLARITY_CONFIG_FETCHED", true);
            edit.putBoolean("CLARITY_ACTIVATED", ingestConfigs.getActivate());
            edit.putBoolean("LEAN_MODE_ACTIVATED", ingestConfigs.getLean());
            edit.putString("REPORT_URL", ingestConfigs.getReportUrl());
            edit.putString("INGEST_URL", ingestConfigs.getIngestUrl());
            edit.putString("MASKING_MODE", ingestConfigs.getMaskingMode().toString());
            edit.putStringSet("MASKED_WEB_ELEMENTS_LIST", ingestConfigs.getWebMaskSelectors());
            edit.putStringSet("UNMASKED_WEB_ELEMENTS_LIST", ingestConfigs.getWebUnmaskSelectors());
            edit.putStringSet("MASKED_NATIVE_LIST", ingestConfigs.getNativeMaskSelectors());
            edit.putStringSet("UNMASKED_NATIVE_LIST", ingestConfigs.getNativeUnmaskSelectors());
            edit.putBoolean("NETWORK_ALLOW_METERED", ingestConfigs.getNetwork().getAllowMeteredNetwork());
            if (ingestConfigs.getNetwork().getMaxDataVolume() != null) {
                edit.putLong("NETWORK_MAX_DAILY_DATA_VOLUME_MB", ingestConfigs.getNetwork().getMaxDataVolume().longValue());
            } else {
                edit.remove("NETWORK_MAX_DAILY_DATA_VOLUME_MB");
            }
            edit.putBoolean("LOW_END_DEVICES_DISABLE_RECORDINGS", ingestConfigs.getLowEndDevices().getDisableRecordings());
            edit.putBoolean("WEBVIEW_CAPTURE_DISABLED", ingestConfigs.getWebViewCapture().getDisableCapture());
            edit.putString("WEBVIEW_CAPTURE_ALLOWED_URLS", "[" + CollectionsKt.joinToString$default(ingestConfigs.getWebViewCapture().getAllowedUrls(), ",", null, null, 0, null, new Function1<UrlFilter, CharSequence>() { // from class: com.microsoft.clarity.models.DynamicConfig$Companion$updateSharedPreferences$lambda$0$$inlined$listToString$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(UrlFilter urlFilter) {
                    return String.valueOf(urlFilter);
                }
            }, 30, null) + ']');
            edit.putString("WEBVIEW_CAPTURE_DISALLOWED_URLS", "[" + CollectionsKt.joinToString$default(ingestConfigs.getWebViewCapture().getDisallowedUrls(), ",", null, null, 0, null, new Function1<UrlFilter, CharSequence>() { // from class: com.microsoft.clarity.models.DynamicConfig$Companion$updateSharedPreferences$lambda$0$$inlined$listToString$2
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(UrlFilter urlFilter) {
                    return String.valueOf(urlFilter);
                }
            }, 30, null) + ']');
            edit.putString("SCREEN_CAPTURE_ALLOWED_SCREENS", "[" + CollectionsKt.joinToString$default(ingestConfigs.getScreenCapture().getAllowedScreens(), ",", null, null, 0, null, new Function1<ScreenNameFilter, CharSequence>() { // from class: com.microsoft.clarity.models.DynamicConfig$Companion$updateSharedPreferences$lambda$0$$inlined$listToString$3
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(ScreenNameFilter screenNameFilter) {
                    return String.valueOf(screenNameFilter);
                }
            }, 30, null) + ']');
            edit.putString("SCREEN_CAPTURE_DISALLOWED_SCREENS", "[" + CollectionsKt.joinToString$default(ingestConfigs.getScreenCapture().getDisallowedScreens(), ",", null, null, 0, null, new Function1<ScreenNameFilter, CharSequence>() { // from class: com.microsoft.clarity.models.DynamicConfig$Companion$updateSharedPreferences$lambda$0$$inlined$listToString$4
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(ScreenNameFilter screenNameFilter) {
                    return String.valueOf(screenNameFilter);
                }
            }, 30, null) + ']');
            edit.apply();
            h.b("Clarity shared preferences updated.");
        }
    }

    public DynamicConfig(Context context) {
        List<UrlFilter> emptyList;
        List<UrlFilter> emptyList2;
        List<ScreenNameFilter> emptyList3;
        List<ScreenNameFilter> emptyList4;
        Intrinsics.checkNotNullParameter(context, "context");
        Companion companion = INSTANCE;
        SharedPreferences preferences = companion.getPreferences(context);
        this.preferences = preferences;
        if (!companion.isFetched(context)) {
            throw new IllegalStateException("Dynamic config has not been fetched yet!");
        }
        String string = preferences.getString("MASKING_MODE", "Strict");
        this.maskingMode = MaskingMode.valueOf(string != null ? string : "Strict");
        Set<String> stringSet = preferences.getStringSet("MASKED_WEB_ELEMENTS_LIST", SetsKt.emptySet());
        this.webMaskSelectors = stringSet == null ? SetsKt.emptySet() : stringSet;
        Set<String> stringSet2 = preferences.getStringSet("UNMASKED_WEB_ELEMENTS_LIST", SetsKt.emptySet());
        this.webUnmaskSelectors = stringSet2 == null ? SetsKt.emptySet() : stringSet2;
        Set<String> stringSet3 = preferences.getStringSet("MASKED_NATIVE_LIST", SetsKt.emptySet());
        stringSet3 = stringSet3 == null ? SetsKt.emptySet() : stringSet3;
        this.nativeMaskSelectors = stringSet3;
        Set<String> stringSet4 = preferences.getStringSet("UNMASKED_NATIVE_LIST", SetsKt.emptySet());
        this.nativeUnmaskSelectors = stringSet4 == null ? SetsKt.emptySet() : stringSet4;
        this.leanMode = preferences.getBoolean("LEAN_MODE_ACTIVATED", false);
        this.isClarityActivated = preferences.getBoolean("CLARITY_ACTIVATED", false);
        String string2 = preferences.getString("INGEST_URL", "https://www.clarity.ms/eus2/");
        this.ingestUrl = string2 != null ? string2 : "https://www.clarity.ms/eus2/";
        this.reportUrl = preferences.getString("REPORT_URL", null);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : stringSet3) {
            String it = (String) obj;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (StringsKt.startsWith$default(it, ".", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (String it2 : arrayList) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            arrayList2.add(StringsKt.drop(it2, 1));
        }
        this.maskedClasses = CollectionsKt.toSet(arrayList2);
        Set<String> set = this.nativeUnmaskSelectors;
        ArrayList<String> arrayList3 = new ArrayList();
        for (Object obj2 : set) {
            String it3 = (String) obj2;
            Intrinsics.checkNotNullExpressionValue(it3, "it");
            if (StringsKt.startsWith$default(it3, ".", false, 2, (Object) null)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (String it4 : arrayList3) {
            Intrinsics.checkNotNullExpressionValue(it4, "it");
            arrayList4.add(StringsKt.drop(it4, 1));
        }
        this.unmaskedClasses = CollectionsKt.toSet(arrayList4);
        Set<String> set2 = this.nativeMaskSelectors;
        ArrayList<String> arrayList5 = new ArrayList();
        for (Object obj3 : set2) {
            String it5 = (String) obj3;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            if (StringsKt.startsWith$default(it5, "&", false, 2, (Object) null)) {
                arrayList5.add(obj3);
            }
        }
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        for (String it6 : arrayList5) {
            Intrinsics.checkNotNullExpressionValue(it6, "it");
            arrayList6.add(StringsKt.drop(it6, 1));
        }
        this.maskedScreens = CollectionsKt.toSet(arrayList6);
        Set<String> set3 = this.nativeUnmaskSelectors;
        ArrayList<String> arrayList7 = new ArrayList();
        for (Object obj4 : set3) {
            String it7 = (String) obj4;
            Intrinsics.checkNotNullExpressionValue(it7, "it");
            if (StringsKt.startsWith$default(it7, "&", false, 2, (Object) null)) {
                arrayList7.add(obj4);
            }
        }
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
        for (String it8 : arrayList7) {
            Intrinsics.checkNotNullExpressionValue(it8, "it");
            arrayList8.add(StringsKt.drop(it8, 1));
        }
        this.unmaskedScreens = CollectionsKt.toSet(arrayList8);
        Set<String> set4 = this.nativeMaskSelectors;
        ArrayList<String> arrayList9 = new ArrayList();
        for (Object obj5 : set4) {
            String it9 = (String) obj5;
            Intrinsics.checkNotNullExpressionValue(it9, "it");
            if (StringsKt.startsWith$default(it9, ProxyConfig.MATCH_ALL_SCHEMES, false, 2, (Object) null)) {
                arrayList9.add(obj5);
            }
        }
        ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, 10));
        for (String it10 : arrayList9) {
            Intrinsics.checkNotNullExpressionValue(it10, "it");
            arrayList10.add(StringsKt.drop(it10, 1));
        }
        this.maskedFragments = CollectionsKt.toSet(arrayList10);
        Set<String> set5 = this.nativeUnmaskSelectors;
        ArrayList<String> arrayList11 = new ArrayList();
        for (Object obj6 : set5) {
            String it11 = (String) obj6;
            Intrinsics.checkNotNullExpressionValue(it11, "it");
            if (StringsKt.startsWith$default(it11, ProxyConfig.MATCH_ALL_SCHEMES, false, 2, (Object) null)) {
                arrayList11.add(obj6);
            }
        }
        ArrayList arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList11, 10));
        for (String it12 : arrayList11) {
            Intrinsics.checkNotNullExpressionValue(it12, "it");
            arrayList12.add(StringsKt.drop(it12, 1));
        }
        this.unmaskedFragments = CollectionsKt.toSet(arrayList12);
        Set<String> set6 = this.nativeMaskSelectors;
        ArrayList<String> arrayList13 = new ArrayList();
        for (Object obj7 : set6) {
            String it13 = (String) obj7;
            Intrinsics.checkNotNullExpressionValue(it13, "it");
            if (StringsKt.startsWith$default(it13, "#", false, 2, (Object) null)) {
                arrayList13.add(obj7);
            }
        }
        ArrayList arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList13, 10));
        for (String it14 : arrayList13) {
            Intrinsics.checkNotNullExpressionValue(it14, "it");
            arrayList14.add(StringsKt.drop(it14, 1));
        }
        this.maskedIds = CollectionsKt.toSet(arrayList14);
        Set<String> set7 = this.nativeUnmaskSelectors;
        ArrayList<String> arrayList15 = new ArrayList();
        for (Object obj8 : set7) {
            String it15 = (String) obj8;
            Intrinsics.checkNotNullExpressionValue(it15, "it");
            if (StringsKt.startsWith$default(it15, "#", false, 2, (Object) null)) {
                arrayList15.add(obj8);
            }
        }
        ArrayList arrayList16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList15, 10));
        for (String it16 : arrayList15) {
            Intrinsics.checkNotNullExpressionValue(it16, "it");
            arrayList16.add(StringsKt.drop(it16, 1));
        }
        this.unmaskedIds = CollectionsKt.toSet(arrayList16);
        Set<String> set8 = this.maskedIds;
        ArrayList arrayList17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set8, 10));
        Iterator<T> it17 = set8.iterator();
        while (it17.hasNext()) {
            arrayList17.add(Integer.valueOf(context.getResources().getIdentifier((String) it17.next(), "id", context.getPackageName())));
        }
        ArrayList arrayList18 = new ArrayList();
        for (Object obj9 : arrayList17) {
            if (((Number) obj9).intValue() != 0) {
                arrayList18.add(obj9);
            }
        }
        this.maskedViewIds = arrayList18;
        Set<String> set9 = this.unmaskedIds;
        ArrayList arrayList19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set9, 10));
        Iterator<T> it18 = set9.iterator();
        while (it18.hasNext()) {
            arrayList19.add(Integer.valueOf(context.getResources().getIdentifier((String) it18.next(), "id", context.getPackageName())));
        }
        ArrayList arrayList20 = new ArrayList();
        for (Object obj10 : arrayList19) {
            if (((Number) obj10).intValue() != 0) {
                arrayList20.add(obj10);
            }
        }
        this.unmaskedViewIds = arrayList20;
        this.allowMeteredNetwork = this.preferences.getBoolean("NETWORK_ALLOW_METERED", false);
        this.networkMaxDailyDataInMB = this.preferences.contains("NETWORK_MAX_DAILY_DATA_VOLUME_MB") ? Long.valueOf(this.preferences.getLong("NETWORK_MAX_DAILY_DATA_VOLUME_MB", 0L)) : null;
        this.disableForLowEndDevices = this.preferences.getBoolean("LOW_END_DEVICES_DISABLE_RECORDINGS", false);
        this.disableWebViewCapture = this.preferences.getBoolean("WEBVIEW_CAPTURE_DISABLED", false);
        if (this.preferences.contains("WEBVIEW_CAPTURE_ALLOWED_URLS")) {
            String string3 = this.preferences.getString("WEBVIEW_CAPTURE_ALLOWED_URLS", null);
            UrlFilter.Companion companion2 = UrlFilter.INSTANCE;
            if (string3 == null) {
                emptyList = new ArrayList<>();
            } else {
                JSONArray jSONArray = new JSONArray(string3);
                emptyList = new ArrayList<>();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String jSONObject = jSONArray.getJSONObject(i).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "it.getJSONObject(i).toString()");
                    emptyList.add(companion2.fromJson(jSONObject));
                }
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        this.webViewCaptureAllowedUrls = emptyList;
        if (this.preferences.contains("WEBVIEW_CAPTURE_DISALLOWED_URLS")) {
            String string4 = this.preferences.getString("WEBVIEW_CAPTURE_DISALLOWED_URLS", null);
            UrlFilter.Companion companion3 = UrlFilter.INSTANCE;
            if (string4 == null) {
                emptyList2 = new ArrayList<>();
            } else {
                JSONArray jSONArray2 = new JSONArray(string4);
                emptyList2 = new ArrayList<>();
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String jSONObject2 = jSONArray2.getJSONObject(i2).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.getJSONObject(i).toString()");
                    emptyList2.add(companion3.fromJson(jSONObject2));
                }
            }
        } else {
            emptyList2 = CollectionsKt.emptyList();
        }
        this.webViewCaptureDisallowedUrls = emptyList2;
        if (this.preferences.contains("SCREEN_CAPTURE_ALLOWED_SCREENS")) {
            String string5 = this.preferences.getString("SCREEN_CAPTURE_ALLOWED_SCREENS", null);
            ScreenNameFilter.Companion companion4 = ScreenNameFilter.INSTANCE;
            if (string5 == null) {
                emptyList3 = new ArrayList<>();
            } else {
                JSONArray jSONArray3 = new JSONArray(string5);
                emptyList3 = new ArrayList<>();
                int length3 = jSONArray3.length();
                for (int i3 = 0; i3 < length3; i3++) {
                    String jSONObject3 = jSONArray3.getJSONObject(i3).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "it.getJSONObject(i).toString()");
                    emptyList3.add(companion4.fromJson(jSONObject3));
                }
            }
        } else {
            emptyList3 = CollectionsKt.emptyList();
        }
        this.screenCaptureAllowedScreens = emptyList3;
        if (this.preferences.contains("SCREEN_CAPTURE_DISALLOWED_SCREENS")) {
            String string6 = this.preferences.getString("SCREEN_CAPTURE_DISALLOWED_SCREENS", null);
            ScreenNameFilter.Companion companion5 = ScreenNameFilter.INSTANCE;
            if (string6 == null) {
                emptyList4 = new ArrayList<>();
            } else {
                JSONArray jSONArray4 = new JSONArray(string6);
                emptyList4 = new ArrayList<>();
                int length4 = jSONArray4.length();
                for (int i4 = 0; i4 < length4; i4++) {
                    String jSONObject4 = jSONArray4.getJSONObject(i4).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "it.getJSONObject(i).toString()");
                    emptyList4.add(companion5.fromJson(jSONObject4));
                }
            }
        } else {
            emptyList4 = CollectionsKt.emptyList();
        }
        this.screenCaptureDisallowedScreens = emptyList4;
    }

    public final boolean getAllowMeteredNetwork() {
        return this.allowMeteredNetwork;
    }

    public final boolean getDisableForLowEndDevices() {
        return this.disableForLowEndDevices;
    }

    public final boolean getDisableWebViewCapture() {
        return this.disableWebViewCapture;
    }

    public final String getIngestUrl() {
        return this.ingestUrl;
    }

    public final boolean getLeanMode() {
        return this.leanMode;
    }

    public final Set<String> getMaskedClasses() {
        return this.maskedClasses;
    }

    public final Set<String> getMaskedFragments() {
        return this.maskedFragments;
    }

    public final Set<String> getMaskedIds() {
        return this.maskedIds;
    }

    public final Set<String> getMaskedScreens() {
        return this.maskedScreens;
    }

    public final List<Integer> getMaskedViewIds() {
        return this.maskedViewIds;
    }

    public final MaskingMode getMaskingMode() {
        return this.maskingMode;
    }

    public final Long getNetworkMaxDailyDataInMB() {
        return this.networkMaxDailyDataInMB;
    }

    public final String getReportUrl() {
        return this.reportUrl;
    }

    public final List<ScreenNameFilter> getScreenCaptureAllowedScreens() {
        return this.screenCaptureAllowedScreens;
    }

    public final List<ScreenNameFilter> getScreenCaptureDisallowedScreens() {
        return this.screenCaptureDisallowedScreens;
    }

    public final Set<String> getUnmaskedClasses() {
        return this.unmaskedClasses;
    }

    public final Set<String> getUnmaskedFragments() {
        return this.unmaskedFragments;
    }

    public final Set<String> getUnmaskedIds() {
        return this.unmaskedIds;
    }

    public final Set<String> getUnmaskedScreens() {
        return this.unmaskedScreens;
    }

    public final List<Integer> getUnmaskedViewIds() {
        return this.unmaskedViewIds;
    }

    public final Set<String> getWebMaskSelectors() {
        return this.webMaskSelectors;
    }

    public final Set<String> getWebUnmaskSelectors() {
        return this.webUnmaskSelectors;
    }

    public final List<UrlFilter> getWebViewCaptureAllowedUrls() {
        return this.webViewCaptureAllowedUrls;
    }

    public final List<UrlFilter> getWebViewCaptureDisallowedUrls() {
        return this.webViewCaptureDisallowedUrls;
    }

    public final boolean isAllowedUrl$sdk_prodRelease(String urlString) {
        URL url;
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        List<UrlFilter> list = this.webViewCaptureDisallowedUrls;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((UrlFilter) it.next()).matches(urlString)) {
                    return false;
                }
            }
        }
        try {
            url = new URL(urlString);
        } catch (Exception e) {
            h.e("Failed to parse URL " + urlString + " because of " + e + '.');
            url = null;
        }
        if (url == null) {
            return true;
        }
        String host = url.getHost();
        if (!Intrinsics.areEqual(url.getProtocol(), "file") && !Intrinsics.areEqual(host, WebViewAssetLoader.DEFAULT_DOMAIN) && !Intrinsics.areEqual(host, AndroidInfoHelpers.DEVICE_LOCALHOST) && !this.webViewCaptureAllowedUrls.isEmpty()) {
            List<UrlFilter> list2 = this.webViewCaptureAllowedUrls;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return false;
            }
            for (UrlFilter urlFilter : list2) {
                if (!Intrinsics.areEqual(urlFilter.getUrl(), ProxyConfig.MATCH_ALL_SCHEMES) && !urlFilter.matches(urlString)) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: isClarityActivated, reason: from getter */
    public final boolean getIsClarityActivated() {
        return this.isClarityActivated;
    }
}
