package com.microsoft.clarity.models.ingest.analytics;

import com.facebook.react.uimanager.ViewProps;
import com.microsoft.clarity.models.ingest.EventType;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/microsoft/clarity/models/ingest/analytics/BaselineEvent;", "Lcom/microsoft/clarity/models/ingest/analytics/AnalyticsEvent;", "timestamp", "", "screenMetadata", "Lcom/microsoft/clarity/models/observers/ScreenMetadata;", ViewProps.VISIBLE, "", "(JLcom/microsoft/clarity/models/observers/ScreenMetadata;Z)V", "type", "Lcom/microsoft/clarity/models/ingest/EventType;", "getType", "()Lcom/microsoft/clarity/models/ingest/EventType;", "serialize", "", "pageTimestamp", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BaselineEvent extends AnalyticsEvent {
    private final EventType type;
    private final boolean visible;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaselineEvent(long j, ScreenMetadata screenMetadata, boolean z) {
        super(j, screenMetadata);
        Intrinsics.checkNotNullParameter(screenMetadata, "screenMetadata");
        this.visible = z;
        this.type = EventType.Baseline;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize(long pageTimestamp) {
        return "[" + relativeTimestamp(pageTimestamp) + ',' + getType().getCustomOrdinal() + ',' + (this.visible ? 1 : 0) + ",0,0,0,0,0,0,0,0,0]";
    }
}
