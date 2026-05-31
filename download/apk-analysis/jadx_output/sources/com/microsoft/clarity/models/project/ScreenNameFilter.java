package com.microsoft.clarity.models.project;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/microsoft/clarity/models/project/ScreenNameFilter;", "", "screenName", "", "(Ljava/lang/String;)V", "getScreenName", "()Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScreenNameFilter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String screenName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/project/ScreenNameFilter$Companion;", "", "()V", "fromJson", "Lcom/microsoft/clarity/models/project/ScreenNameFilter;", "jsonString", "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ScreenNameFilter fromJson(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            String string = new JSONObject(jsonString).getString("screenName");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"screenName\")");
            return new ScreenNameFilter(string);
        }

        private Companion() {
        }
    }

    public ScreenNameFilter(String screenName) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        this.screenName = screenName;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public String toString() {
        return "{\"screenName\": \"" + this.screenName + "\"}";
    }
}
