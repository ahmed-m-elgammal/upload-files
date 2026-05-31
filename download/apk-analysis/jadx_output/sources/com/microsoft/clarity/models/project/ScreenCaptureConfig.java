package com.microsoft.clarity.models.project;

import com.microsoft.clarity.models.project.ScreenNameFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/microsoft/clarity/models/project/ScreenCaptureConfig;", "", "allowedScreens", "", "Lcom/microsoft/clarity/models/project/ScreenNameFilter;", "disallowedScreens", "(Ljava/util/List;Ljava/util/List;)V", "getAllowedScreens", "()Ljava/util/List;", "getDisallowedScreens", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScreenCaptureConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ScreenNameFilter> allowedScreens;
    private final List<ScreenNameFilter> disallowedScreens;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/project/ScreenCaptureConfig$Companion;", "", "()V", "fromJson", "Lcom/microsoft/clarity/models/project/ScreenCaptureConfig;", "jsonString", "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ScreenCaptureConfig fromJson(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JSONObject jSONObject = new JSONObject(jsonString);
            ScreenNameFilter.Companion companion = ScreenNameFilter.INSTANCE;
            JSONArray optJSONArray = jSONObject.optJSONArray("allowedScreens");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String jSONObject2 = optJSONArray.getJSONObject(i).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.getJSONObject(i).toString()");
                    arrayList.add(companion.fromJson(jSONObject2));
                }
            }
            ScreenNameFilter.Companion companion2 = ScreenNameFilter.INSTANCE;
            JSONArray optJSONArray2 = jSONObject.optJSONArray("disallowedScreens");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String jSONObject3 = optJSONArray2.getJSONObject(i2).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "it.getJSONObject(i).toString()");
                    arrayList2.add(companion2.fromJson(jSONObject3));
                }
            }
            return new ScreenCaptureConfig(arrayList, arrayList2);
        }

        private Companion() {
        }
    }

    public ScreenCaptureConfig(List<ScreenNameFilter> allowedScreens, List<ScreenNameFilter> disallowedScreens) {
        Intrinsics.checkNotNullParameter(allowedScreens, "allowedScreens");
        Intrinsics.checkNotNullParameter(disallowedScreens, "disallowedScreens");
        this.allowedScreens = allowedScreens;
        this.disallowedScreens = disallowedScreens;
    }

    public final List<ScreenNameFilter> getAllowedScreens() {
        return this.allowedScreens;
    }

    public final List<ScreenNameFilter> getDisallowedScreens() {
        return this.disallowedScreens;
    }
}
