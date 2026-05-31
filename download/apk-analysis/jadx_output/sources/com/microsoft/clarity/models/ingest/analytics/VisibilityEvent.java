package com.microsoft.clarity.models.ingest.analytics;

import com.microsoft.clarity.models.ingest.EventType;
import com.microsoft.clarity.models.observers.ScreenMetadata;

/* loaded from: classes5.dex */
public class VisibilityEvent extends AnalyticsEvent {
    private final String state;
    private final EventType type;

    public VisibilityEvent(long j, ScreenMetadata screenMetadata, String str) {
        super(j, screenMetadata);
        this.state = str;
        this.type = EventType.Visibility;
    }

    public String getState() {
        return this.state;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize(long j) {
        return "[" + relativeTimestamp(j) + "," + getType().getCustomOrdinal() + ",\"" + this.state + "\"]";
    }
}
