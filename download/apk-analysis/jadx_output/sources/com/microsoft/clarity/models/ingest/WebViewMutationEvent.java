package com.microsoft.clarity.models.ingest;

import androidx.core.app.NotificationCompat;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/microsoft/clarity/models/ingest/WebViewMutationEvent;", "Lcom/microsoft/clarity/models/ingest/BaseWebViewEvent;", "timestamp", "", NotificationCompat.CATEGORY_EVENT, "", "webViewHashCode", "", "screenMetadata", "Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "type", "pageUrl", "(JLjava/lang/String;ILcom/microsoft/clarity/models/observers/ScreenMetadata;ILjava/lang/String;)V", "getPageUrl", "()Ljava/lang/String;", "copyWithNewData", "data", "copyWithNewTimestamp", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebViewMutationEvent extends BaseWebViewEvent {
    private final String pageUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewMutationEvent(long j, String event, int i, ScreenMetadata screenMetadata, int i2, String pageUrl) {
        super(j, event, i, screenMetadata, i2);
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(screenMetadata, "screenMetadata");
        Intrinsics.checkNotNullParameter(pageUrl, "pageUrl");
        this.pageUrl = pageUrl;
    }

    public final WebViewMutationEvent copyWithNewData(long timestamp, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (timestamp == getTimestamp() && Intrinsics.areEqual(data, getData())) {
            return this;
        }
        Intrinsics.checkNotNullParameter(data, "event");
        if (Long.parseLong(StringsKt.substring(data, RangesKt.until(StringsKt.indexOf$default((CharSequence) data, '[', 0, false, 6, (Object) null) + 1, StringsKt.indexOf$default((CharSequence) data, ',', 0, false, 6, (Object) null)))) == timestamp) {
            return new WebViewMutationEvent(timestamp, data, getWebViewHashCode(), getScreenMetadata(), getType().getCustomOrdinal(), this.pageUrl);
        }
        throw new IllegalArgumentException("timestamp value must match the one encoded in the data value");
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    @Override // com.microsoft.clarity.models.ingest.BaseWebViewEvent
    public WebViewMutationEvent copyWithNewTimestamp(long timestamp) {
        return timestamp == getTimestamp() ? this : new WebViewMutationEvent(timestamp, copyDataWithNewTimestamp(timestamp), getWebViewHashCode(), getScreenMetadata(), getType().getCustomOrdinal(), this.pageUrl);
    }
}
