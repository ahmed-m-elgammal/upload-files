package com.microsoft.clarity.models.project;

import com.microsoft.clarity.models.project.UrlFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/microsoft/clarity/models/project/WebViewCaptureConfig;", "", "disableCapture", "", "allowedUrls", "", "Lcom/microsoft/clarity/models/project/UrlFilter;", "disallowedUrls", "(ZLjava/util/List;Ljava/util/List;)V", "getAllowedUrls", "()Ljava/util/List;", "getDisableCapture", "()Z", "getDisallowedUrls", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebViewCaptureConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<UrlFilter> allowedUrls;
    private final boolean disableCapture;
    private final List<UrlFilter> disallowedUrls;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/project/WebViewCaptureConfig$Companion;", "", "()V", "fromJson", "Lcom/microsoft/clarity/models/project/WebViewCaptureConfig;", "jsonString", "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WebViewCaptureConfig fromJson(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JSONObject jSONObject = new JSONObject(jsonString);
            boolean z = jSONObject.getBoolean("disableCapture");
            UrlFilter.Companion companion = UrlFilter.INSTANCE;
            JSONArray optJSONArray = jSONObject.optJSONArray("allowedUrls");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String jSONObject2 = optJSONArray.getJSONObject(i).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.getJSONObject(i).toString()");
                    arrayList.add(companion.fromJson(jSONObject2));
                }
            }
            UrlFilter.Companion companion2 = UrlFilter.INSTANCE;
            JSONArray optJSONArray2 = jSONObject.optJSONArray("disallowedUrls");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String jSONObject3 = optJSONArray2.getJSONObject(i2).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "it.getJSONObject(i).toString()");
                    arrayList2.add(companion2.fromJson(jSONObject3));
                }
            }
            return new WebViewCaptureConfig(z, arrayList, arrayList2);
        }

        private Companion() {
        }
    }

    public WebViewCaptureConfig(boolean z, List<UrlFilter> allowedUrls, List<UrlFilter> disallowedUrls) {
        Intrinsics.checkNotNullParameter(allowedUrls, "allowedUrls");
        Intrinsics.checkNotNullParameter(disallowedUrls, "disallowedUrls");
        this.disableCapture = z;
        this.allowedUrls = allowedUrls;
        this.disallowedUrls = disallowedUrls;
    }

    public final List<UrlFilter> getAllowedUrls() {
        return this.allowedUrls;
    }

    public final boolean getDisableCapture() {
        return this.disableCapture;
    }

    public final List<UrlFilter> getDisallowedUrls() {
        return this.disallowedUrls;
    }
}
