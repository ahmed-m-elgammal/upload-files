package com.microsoft.clarity.models.ingest.analytics;

import com.microsoft.clarity.models.ingest.EventType;
import com.microsoft.clarity.models.observers.ScreenMetadata;

/* loaded from: classes5.dex */
public final class DocumentEvent extends AnalyticsEvent {
    private final int height;
    private final EventType type;
    private final int width;

    public DocumentEvent(long j, ScreenMetadata screenMetadata, int i, int i2) {
        super(j, screenMetadata);
        this.width = i;
        this.height = i2;
        this.type = EventType.Document;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize(long j) {
        return "[" + relativeTimestamp(j) + "," + getType().getCustomOrdinal() + "," + this.width + "," + this.height + "]";
    }
}
