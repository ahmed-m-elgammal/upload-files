package com.microsoft.clarity.models.ingest;

import io.sentry.protocol.SentryStackTrace;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u001b\u0010\r\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/microsoft/clarity/models/ingest/SerializedSessionPayload;", "", SentryStackTrace.JsonKeys.FRAMES, "", "", "events", "", "pageNum", "", "sequence", "start", "", "(Ljava/util/List;Ljava/util/List;IIJ)V", "duration", "getDuration", "()J", "duration$delegate", "Lkotlin/Lazy;", "getEvents", "()Ljava/util/List;", "getFrames", "getPageNum", "()I", "getSequence", "getStart", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SerializedSessionPayload {

    /* renamed from: duration$delegate, reason: from kotlin metadata */
    private final Lazy duration;
    private final List<String> events;
    private final List<String> frames;
    private final int pageNum;
    private final int sequence;
    private final long start;

    public SerializedSessionPayload(List<String> frames, List<String> events, int i, int i2, long j) {
        Intrinsics.checkNotNullParameter(frames, "frames");
        Intrinsics.checkNotNullParameter(events, "events");
        this.frames = frames;
        this.events = events;
        this.pageNum = i;
        this.sequence = i2;
        this.start = j;
        this.duration = LazyKt.lazy(new Function0<Long>() { // from class: com.microsoft.clarity.models.ingest.SerializedSessionPayload$duration$2
            {
                super(0);
            }

            private static final void invoke$updateTimestamps(Ref.LongRef longRef, List<String> list) {
                for (String event : list) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    Intrinsics.checkNotNullParameter(event, "event");
                    longRef.element = Math.max(longRef.element, Long.parseLong(StringsKt.substring(event, RangesKt.until(StringsKt.indexOf$default((CharSequence) event, '[', 0, false, 6, (Object) null) + 1, StringsKt.indexOf$default((CharSequence) event, ',', 0, false, 6, (Object) null)))));
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                Ref.LongRef longRef = new Ref.LongRef();
                invoke$updateTimestamps(longRef, SerializedSessionPayload.this.getFrames());
                invoke$updateTimestamps(longRef, SerializedSessionPayload.this.getEvents());
                return Long.valueOf(longRef.element - SerializedSessionPayload.this.getStart());
            }
        });
    }

    public final long getDuration() {
        return ((Number) this.duration.getValue()).longValue();
    }

    public final List<String> getEvents() {
        return this.events;
    }

    public final List<String> getFrames() {
        return this.frames;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public final long getStart() {
        return this.start;
    }
}
