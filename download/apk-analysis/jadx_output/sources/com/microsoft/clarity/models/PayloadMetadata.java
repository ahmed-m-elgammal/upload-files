package com.microsoft.clarity.models;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.microsoft.clarity.reactnative.ClarityEmitter;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u0000 82\u00020\u0001:\u00018B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\bJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJL\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\u0006\u00104\u001a\u00020\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\u000e\u00106\u001a\u0002072\u0006\u0010(\u001a\u00020\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001b\u0010\u000eR\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!¨\u00069"}, d2 = {"Lcom/microsoft/clarity/models/PayloadMetadata;", "", ClarityEmitter.CLARITY_SESSION_ID_PARAMETER, "", "pageNum", "", "sequence", "start", "", "pageTimestamp", "firstNonBaselineEventTimestamp", "(Ljava/lang/String;IIJJLjava/lang/Long;)V", "duration", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "fallbackWorkerId", "Ljava/util/UUID;", "getFallbackWorkerId", "()Ljava/util/UUID;", "setFallbackWorkerId", "(Ljava/util/UUID;)V", "fallbackWorkerStartTime", "getFallbackWorkerStartTime", "setFallbackWorkerStartTime", "getFirstNonBaselineEventTimestamp", "maxPayloadDuration", "getMaxPayloadDuration", "()I", "getPageNum", "getPageTimestamp", "()J", "getSequence", "getSessionId", "()Ljava/lang/String;", "getStart", "canIncludeEvent", "", "eventTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;IIJJLjava/lang/Long;)Lcom/microsoft/clarity/models/PayloadMetadata;", "equals", "other", "hashCode", "toJson", InAppPurchaseConstants.METHOD_TO_STRING, "updateDuration", "", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PayloadMetadata {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private transient Long duration;
    private transient UUID fallbackWorkerId;
    private transient Long fallbackWorkerStartTime;
    private final transient Long firstNonBaselineEventTimestamp;
    private final int maxPayloadDuration;
    private final int pageNum;
    private final long pageTimestamp;
    private final int sequence;
    private final String sessionId;
    private final long start;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/PayloadMetadata$Companion;", "", "()V", "fromJson", "Lcom/microsoft/clarity/models/PayloadMetadata;", "jsonString", "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayloadMetadata fromJson(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JSONObject jSONObject = new JSONObject(jsonString);
            long j = jSONObject.has("pageTimestamp") ? jSONObject.getLong("pageTimestamp") : 0L;
            String string = jSONObject.getString(ClarityEmitter.CLARITY_SESSION_ID_PARAMETER);
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"sessionId\")");
            return new PayloadMetadata(string, jSONObject.getInt("pageNum"), jSONObject.getInt("sequence"), jSONObject.getLong("start"), j, null, 32, null);
        }

        private Companion() {
        }
    }

    public PayloadMetadata(String sessionId, int i, int i2, long j, long j2, Long l) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.pageNum = i;
        this.sequence = i2;
        this.start = j;
        this.pageTimestamp = j2;
        this.firstNonBaselineEventTimestamp = l;
        this.maxPayloadDuration = Math.min(i2 * 1000, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
    }

    public final boolean canIncludeEvent(long eventTimestamp) {
        Long l = this.firstNonBaselineEventTimestamp;
        Intrinsics.checkNotNull(l);
        return eventTimestamp - l.longValue() <= ((long) this.maxPayloadDuration);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSequence() {
        return this.sequence;
    }

    /* renamed from: component4, reason: from getter */
    public final long getStart() {
        return this.start;
    }

    /* renamed from: component5, reason: from getter */
    public final long getPageTimestamp() {
        return this.pageTimestamp;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getFirstNonBaselineEventTimestamp() {
        return this.firstNonBaselineEventTimestamp;
    }

    public final PayloadMetadata copy(String sessionId, int pageNum, int sequence, long start, long pageTimestamp, Long firstNonBaselineEventTimestamp) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new PayloadMetadata(sessionId, pageNum, sequence, start, pageTimestamp, firstNonBaselineEventTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayloadMetadata)) {
            return false;
        }
        PayloadMetadata payloadMetadata = (PayloadMetadata) other;
        return Intrinsics.areEqual(this.sessionId, payloadMetadata.sessionId) && this.pageNum == payloadMetadata.pageNum && this.sequence == payloadMetadata.sequence && this.start == payloadMetadata.start && this.pageTimestamp == payloadMetadata.pageTimestamp && Intrinsics.areEqual(this.firstNonBaselineEventTimestamp, payloadMetadata.firstNonBaselineEventTimestamp);
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final UUID getFallbackWorkerId() {
        return this.fallbackWorkerId;
    }

    public final Long getFallbackWorkerStartTime() {
        return this.fallbackWorkerStartTime;
    }

    public final Long getFirstNonBaselineEventTimestamp() {
        return this.firstNonBaselineEventTimestamp;
    }

    public final int getMaxPayloadDuration() {
        return this.maxPayloadDuration;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final long getPageTimestamp() {
        return this.pageTimestamp;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getStart() {
        return this.start;
    }

    public int hashCode() {
        int m = (UByte$$ExternalSyntheticBackport0.m(this.pageTimestamp) + ((UByte$$ExternalSyntheticBackport0.m(this.start) + ((this.sequence + ((this.pageNum + (this.sessionId.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        Long l = this.firstNonBaselineEventTimestamp;
        return m + (l == null ? 0 : l.hashCode());
    }

    public final void setDuration(Long l) {
        this.duration = l;
    }

    public final void setFallbackWorkerId(UUID uuid) {
        this.fallbackWorkerId = uuid;
    }

    public final void setFallbackWorkerStartTime(Long l) {
        this.fallbackWorkerStartTime = l;
    }

    public final String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ClarityEmitter.CLARITY_SESSION_ID_PARAMETER, this.sessionId);
        jSONObject.put("pageNum", this.pageNum);
        jSONObject.put("sequence", this.sequence);
        jSONObject.put("start", this.start);
        jSONObject.put("pageTimestamp", this.pageTimestamp);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public String toString() {
        return "PayloadMetadata(sessionId=" + this.sessionId + ", pageNum=" + this.pageNum + ", sequence=" + this.sequence + ", start=" + this.start + ", pageTimestamp=" + this.pageTimestamp + ", firstNonBaselineEventTimestamp=" + this.firstNonBaselineEventTimestamp + ')';
    }

    public final void updateDuration(long eventTimestamp) {
        long j = eventTimestamp - this.pageTimestamp;
        Long l = this.duration;
        this.duration = Long.valueOf(Math.max(l != null ? l.longValue() : 0L, j - this.start));
    }

    public /* synthetic */ PayloadMetadata(String str, int i, int i2, long j, long j2, Long l, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, j, j2, (i3 & 32) != 0 ? null : l);
    }
}
