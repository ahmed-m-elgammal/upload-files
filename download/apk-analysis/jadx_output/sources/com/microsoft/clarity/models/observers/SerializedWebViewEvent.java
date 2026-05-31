package com.microsoft.clarity.models.observers;

import com.microsoft.clarity.models.ingest.EventType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0006\u0010\u0019\u001a\u00020\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/microsoft/clarity/models/observers/SerializedWebViewEvent;", "Lcom/microsoft/clarity/models/observers/ObservedWebViewEvent;", "data", "", "timestamp", "", "screenMetadata", "Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "webViewHashCode", "", "(Ljava/lang/String;JLcom/microsoft/clarity/models/observers/ScreenMetadata;I)V", "getData", "()Ljava/lang/String;", "json", "Lorg/json/JSONArray;", "getJson", "()Lorg/json/JSONArray;", "json$delegate", "Lkotlin/Lazy;", "getScreenMetadata", "()Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "getWebViewHashCode", "()I", "getPageUrl", "getType", "isAnalyticsEvent", "", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SerializedWebViewEvent extends ObservedWebViewEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String data;

    /* renamed from: json$delegate, reason: from kotlin metadata */
    private final Lazy json;
    private final ScreenMetadata screenMetadata;
    private final int webViewHashCode;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/microsoft/clarity/models/observers/SerializedWebViewEvent$Companion;", "", "()V", "create", "Lcom/microsoft/clarity/models/observers/SerializedWebViewEvent;", "data", "", "screenMetadata", "Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "webViewHashCode", "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SerializedWebViewEvent create(String data, ScreenMetadata screenMetadata, int webViewHashCode) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(screenMetadata, "screenMetadata");
            Intrinsics.checkNotNullParameter(data, "event");
            Intrinsics.checkNotNullParameter(data, "event");
            return new SerializedWebViewEvent(data, Long.parseLong(StringsKt.substring(data, RangesKt.until(StringsKt.indexOf$default((CharSequence) data, '[', 0, false, 6, (Object) null) + 1, StringsKt.indexOf$default((CharSequence) data, ',', 0, false, 6, (Object) null)))), screenMetadata, webViewHashCode, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SerializedWebViewEvent(String str, long j, ScreenMetadata screenMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, screenMetadata, i);
    }

    private final JSONArray getJson() {
        return (JSONArray) this.json.getValue();
    }

    @Override // com.microsoft.clarity.models.observers.ObservedWebViewEvent
    public String getData() {
        return this.data;
    }

    @Override // com.microsoft.clarity.models.observers.ObservedWebViewEvent
    /* renamed from: getPageUrl */
    public String getUrl() {
        if (isAnalyticsEvent()) {
            throw new IllegalAccessException("Page Url is not available for analytics events!");
        }
        String string = getJson().getString(5);
        Intrinsics.checkNotNullExpressionValue(string, "json.getString(5)");
        return string;
    }

    @Override // com.microsoft.clarity.models.observers.ObservedWebViewEvent
    public ScreenMetadata getScreenMetadata() {
        return this.screenMetadata;
    }

    @Override // com.microsoft.clarity.models.observers.ObservedWebViewEvent
    public int getType() {
        return getJson().getInt(1);
    }

    @Override // com.microsoft.clarity.models.observers.ObservedWebViewEvent
    public int getWebViewHashCode() {
        return this.webViewHashCode;
    }

    public final boolean isAnalyticsEvent() {
        return (getType() == EventType.WebViewDiscover.getCustomOrdinal() || getType() == EventType.WebViewMutation.getCustomOrdinal() || getType() == EventType.StyleSheetAdoption.getCustomOrdinal() || getType() == EventType.StyleSheetUpdate.getCustomOrdinal()) ? false : true;
    }

    private SerializedWebViewEvent(String str, long j, ScreenMetadata screenMetadata, int i) {
        super(j);
        this.data = str;
        this.screenMetadata = screenMetadata;
        this.webViewHashCode = i;
        this.json = LazyKt.lazy(new Function0<JSONArray>() { // from class: com.microsoft.clarity.models.observers.SerializedWebViewEvent$json$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final JSONArray invoke() {
                return new JSONArray(SerializedWebViewEvent.this.getData());
            }
        });
    }
}
