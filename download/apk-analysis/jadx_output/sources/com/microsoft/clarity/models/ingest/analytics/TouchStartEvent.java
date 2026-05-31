package com.microsoft.clarity.models.ingest.analytics;

import com.microsoft.clarity.models.ingest.EventType;
import com.microsoft.clarity.models.observers.ScreenMetadata;

/* loaded from: classes5.dex */
public final class TouchStartEvent extends AnalyticsEvent {
    private final boolean isPrimary;
    private final int pointerId;
    private final EventType type;
    private final float x;
    private final float y;

    public TouchStartEvent(long j, ScreenMetadata screenMetadata, int i, float f, float f2, boolean z) {
        super(j, screenMetadata);
        this.pointerId = i;
        this.x = f;
        this.y = f2;
        this.isPrimary = z;
        this.type = EventType.TouchStart;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize(long j) {
        return "[" + relativeTimestamp(j) + "," + getType().getCustomOrdinal() + ",0," + StrictMath.round(this.x) + "," + StrictMath.round(this.y) + "," + this.pointerId + ",\"" + this.isPrimary + "\"]";
    }

    public String toString() {
        return serialize(0L);
    }
}
