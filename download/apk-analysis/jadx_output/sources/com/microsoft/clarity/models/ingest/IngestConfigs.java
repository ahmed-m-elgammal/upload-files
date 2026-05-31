package com.microsoft.clarity.models.ingest;

import com.microsoft.clarity.m.k;
import com.microsoft.clarity.models.BackEndMaskingMode;
import com.microsoft.clarity.models.MaskingMode;
import com.microsoft.clarity.models.MaskingModeAdapter;
import com.microsoft.clarity.models.project.LowEndDevicesConfig;
import com.microsoft.clarity.models.project.NetworkConfig;
import com.microsoft.clarity.models.project.ScreenCaptureConfig;
import com.microsoft.clarity.models.project.WebViewCaptureConfig;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/microsoft/clarity/models/ingest/IngestConfigs;", "", "ingestUrl", "", "reportUrl", "activate", "", "lean", "maskingMode", "Lcom/microsoft/clarity/models/MaskingMode;", "webMaskSelectors", "", "webUnmaskSelectors", "nativeMaskSelectors", "nativeUnmaskSelectors", "network", "Lcom/microsoft/clarity/models/project/NetworkConfig;", "lowEndDevices", "Lcom/microsoft/clarity/models/project/LowEndDevicesConfig;", "webViewCapture", "Lcom/microsoft/clarity/models/project/WebViewCaptureConfig;", "screenCapture", "Lcom/microsoft/clarity/models/project/ScreenCaptureConfig;", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/microsoft/clarity/models/MaskingMode;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Lcom/microsoft/clarity/models/project/NetworkConfig;Lcom/microsoft/clarity/models/project/LowEndDevicesConfig;Lcom/microsoft/clarity/models/project/WebViewCaptureConfig;Lcom/microsoft/clarity/models/project/ScreenCaptureConfig;)V", "getActivate", "()Z", "getIngestUrl", "()Ljava/lang/String;", "getLean", "getLowEndDevices", "()Lcom/microsoft/clarity/models/project/LowEndDevicesConfig;", "getMaskingMode", "()Lcom/microsoft/clarity/models/MaskingMode;", "getNativeMaskSelectors", "()Ljava/util/Set;", "getNativeUnmaskSelectors", "getNetwork", "()Lcom/microsoft/clarity/models/project/NetworkConfig;", "getReportUrl", "getScreenCapture", "()Lcom/microsoft/clarity/models/project/ScreenCaptureConfig;", "getWebMaskSelectors", "getWebUnmaskSelectors", "getWebViewCapture", "()Lcom/microsoft/clarity/models/project/WebViewCaptureConfig;", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IngestConfigs {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean activate;
    private final String ingestUrl;
    private final boolean lean;
    private final LowEndDevicesConfig lowEndDevices;
    private final MaskingMode maskingMode;
    private final Set<String> nativeMaskSelectors;
    private final Set<String> nativeUnmaskSelectors;
    private final NetworkConfig network;
    private final String reportUrl;
    private final ScreenCaptureConfig screenCapture;
    private final Set<String> webMaskSelectors;
    private final Set<String> webUnmaskSelectors;
    private final WebViewCaptureConfig webViewCapture;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"Lcom/microsoft/clarity/models/ingest/IngestConfigs$Companion;", "", "()V", "fromJson", "Lcom/microsoft/clarity/models/ingest/IngestConfigs;", "jsonString", "", "getReportUrlFromJson", "json", "Lorg/json/JSONObject;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String getReportUrlFromJson(JSONObject json) {
            if (json.isNull("reportUrl")) {
                return null;
            }
            String reportUrl = json.getString("reportUrl");
            Intrinsics.checkNotNullExpressionValue(reportUrl, "reportUrl");
            if (StringsKt.isBlank(reportUrl)) {
                return null;
            }
            return reportUrl;
        }

        public final IngestConfigs fromJson(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JSONObject jSONObject = new JSONObject(jsonString);
            String string = jSONObject.getString("ingestUrl");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"ingestUrl\")");
            String reportUrlFromJson = getReportUrlFromJson(jSONObject);
            boolean z = jSONObject.getBoolean("activate");
            boolean z2 = jSONObject.getBoolean("lean");
            MaskingMode fromJson = MaskingModeAdapter.INSTANCE.fromJson(jSONObject.optInt("maskingMode", BackEndMaskingMode.Strict.ordinal()));
            Set a2 = k.a(jSONObject.optJSONArray("webMask"));
            Set a3 = k.a(jSONObject.optJSONArray("webUnmask"));
            Set a4 = k.a(jSONObject.optJSONArray("nativeMask"));
            Set a5 = k.a(jSONObject.optJSONArray("nativeUnmask"));
            NetworkConfig.Companion companion = NetworkConfig.INSTANCE;
            String string2 = jSONObject.getString("network");
            Intrinsics.checkNotNullExpressionValue(string2, "json.getString(\"network\")");
            NetworkConfig fromJson2 = companion.fromJson(string2);
            LowEndDevicesConfig.Companion companion2 = LowEndDevicesConfig.INSTANCE;
            String string3 = jSONObject.getString("lowEndDevices");
            Intrinsics.checkNotNullExpressionValue(string3, "json.getString(\"lowEndDevices\")");
            LowEndDevicesConfig fromJson3 = companion2.fromJson(string3);
            WebViewCaptureConfig.Companion companion3 = WebViewCaptureConfig.INSTANCE;
            String string4 = jSONObject.getString("webViewCapture");
            Intrinsics.checkNotNullExpressionValue(string4, "json.getString(\"webViewCapture\")");
            WebViewCaptureConfig fromJson4 = companion3.fromJson(string4);
            ScreenCaptureConfig.Companion companion4 = ScreenCaptureConfig.INSTANCE;
            String string5 = jSONObject.getString("screenCapture");
            Intrinsics.checkNotNullExpressionValue(string5, "json.getString(\"screenCapture\")");
            return new IngestConfigs(string, reportUrlFromJson, z, z2, fromJson, a2, a3, a4, a5, fromJson2, fromJson3, fromJson4, companion4.fromJson(string5));
        }

        private Companion() {
        }
    }

    public IngestConfigs(String ingestUrl, String str, boolean z, boolean z2, MaskingMode maskingMode, Set<String> webMaskSelectors, Set<String> webUnmaskSelectors, Set<String> nativeMaskSelectors, Set<String> nativeUnmaskSelectors, NetworkConfig network, LowEndDevicesConfig lowEndDevices, WebViewCaptureConfig webViewCapture, ScreenCaptureConfig screenCapture) {
        Intrinsics.checkNotNullParameter(ingestUrl, "ingestUrl");
        Intrinsics.checkNotNullParameter(maskingMode, "maskingMode");
        Intrinsics.checkNotNullParameter(webMaskSelectors, "webMaskSelectors");
        Intrinsics.checkNotNullParameter(webUnmaskSelectors, "webUnmaskSelectors");
        Intrinsics.checkNotNullParameter(nativeMaskSelectors, "nativeMaskSelectors");
        Intrinsics.checkNotNullParameter(nativeUnmaskSelectors, "nativeUnmaskSelectors");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(lowEndDevices, "lowEndDevices");
        Intrinsics.checkNotNullParameter(webViewCapture, "webViewCapture");
        Intrinsics.checkNotNullParameter(screenCapture, "screenCapture");
        this.ingestUrl = ingestUrl;
        this.reportUrl = str;
        this.activate = z;
        this.lean = z2;
        this.maskingMode = maskingMode;
        this.webMaskSelectors = webMaskSelectors;
        this.webUnmaskSelectors = webUnmaskSelectors;
        this.nativeMaskSelectors = nativeMaskSelectors;
        this.nativeUnmaskSelectors = nativeUnmaskSelectors;
        this.network = network;
        this.lowEndDevices = lowEndDevices;
        this.webViewCapture = webViewCapture;
        this.screenCapture = screenCapture;
    }

    public final boolean getActivate() {
        return this.activate;
    }

    public final String getIngestUrl() {
        return this.ingestUrl;
    }

    public final boolean getLean() {
        return this.lean;
    }

    public final LowEndDevicesConfig getLowEndDevices() {
        return this.lowEndDevices;
    }

    public final MaskingMode getMaskingMode() {
        return this.maskingMode;
    }

    public final Set<String> getNativeMaskSelectors() {
        return this.nativeMaskSelectors;
    }

    public final Set<String> getNativeUnmaskSelectors() {
        return this.nativeUnmaskSelectors;
    }

    public final NetworkConfig getNetwork() {
        return this.network;
    }

    public final String getReportUrl() {
        return this.reportUrl;
    }

    public final ScreenCaptureConfig getScreenCapture() {
        return this.screenCapture;
    }

    public final Set<String> getWebMaskSelectors() {
        return this.webMaskSelectors;
    }

    public final Set<String> getWebUnmaskSelectors() {
        return this.webUnmaskSelectors;
    }

    public final WebViewCaptureConfig getWebViewCapture() {
        return this.webViewCapture;
    }

    public /* synthetic */ IngestConfigs(String str, String str2, boolean z, boolean z2, MaskingMode maskingMode, Set set, Set set2, Set set3, Set set4, NetworkConfig networkConfig, LowEndDevicesConfig lowEndDevicesConfig, WebViewCaptureConfig webViewCaptureConfig, ScreenCaptureConfig screenCaptureConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? MaskingMode.Strict : maskingMode, set, set2, set3, set4, networkConfig, lowEndDevicesConfig, webViewCaptureConfig, screenCaptureConfig);
    }
}
