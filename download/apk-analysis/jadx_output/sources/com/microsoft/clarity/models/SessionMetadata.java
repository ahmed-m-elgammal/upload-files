package com.microsoft.clarity.models;

import com.microsoft.clarity.reactnative.ClarityEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000fJ\u0006\u0010%\u001a\u00020\u0003R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011¨\u0006'"}, d2 = {"Lcom/microsoft/clarity/models/SessionMetadata;", "", "version", "", "projectId", "userId", ClarityEmitter.CLARITY_SESSION_ID_PARAMETER, "timestamp", "", "localStorageVersion", "", "leanSession", "", "ingestUrl", "lastUploadedPayloadTimestamp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIZLjava/lang/String;Ljava/lang/Long;)V", "getIngestUrl", "()Ljava/lang/String;", "getLastUploadedPayloadTimestamp", "()Ljava/lang/Long;", "setLastUploadedPayloadTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLeanSession", "()Z", "setLeanSession", "(Z)V", "getLocalStorageVersion", "()I", "getProjectId", "getSessionId", "getTimestamp", "()J", "getUserId", "setUserId", "(Ljava/lang/String;)V", "getVersion", "toJson", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SessionMetadata {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String ingestUrl;
    private Long lastUploadedPayloadTimestamp;
    private boolean leanSession;
    private final int localStorageVersion;
    private final String projectId;
    private final String sessionId;
    private final long timestamp;
    private String userId;
    private final String version;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/SessionMetadata$Companion;", "", "()V", "fromJson", "Lcom/microsoft/clarity/models/SessionMetadata;", "serialized", "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SessionMetadata fromJson(String serialized) {
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            JSONObject jSONObject = new JSONObject(serialized);
            String string = jSONObject.getString("version");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"version\")");
            String string2 = jSONObject.getString("projectId");
            Intrinsics.checkNotNullExpressionValue(string2, "json.getString(\"projectId\")");
            String string3 = jSONObject.getString("userId");
            Intrinsics.checkNotNullExpressionValue(string3, "json.getString(\"userId\")");
            String string4 = jSONObject.getString(ClarityEmitter.CLARITY_SESSION_ID_PARAMETER);
            Intrinsics.checkNotNullExpressionValue(string4, "json.getString(\"sessionId\")");
            long j = jSONObject.getLong("timestamp");
            int i = jSONObject.getInt("localStorageVersion");
            boolean z = jSONObject.getBoolean("leanSession");
            String string5 = jSONObject.getString("ingestUrl");
            Intrinsics.checkNotNullExpressionValue(string5, "json.getString(\"ingestUrl\")");
            Long valueOf = Long.valueOf(jSONObject.optLong("lastUploadedPayloadTimestamp"));
            if (valueOf.longValue() <= 0) {
                valueOf = null;
            }
            return new SessionMetadata(string, string2, string3, string4, j, i, z, string5, valueOf);
        }

        private Companion() {
        }
    }

    public SessionMetadata(String version, String projectId, String userId, String sessionId, long j, int i, boolean z, String ingestUrl, Long l) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(ingestUrl, "ingestUrl");
        this.version = version;
        this.projectId = projectId;
        this.userId = userId;
        this.sessionId = sessionId;
        this.timestamp = j;
        this.localStorageVersion = i;
        this.leanSession = z;
        this.ingestUrl = ingestUrl;
        this.lastUploadedPayloadTimestamp = l;
    }

    public final String getIngestUrl() {
        return this.ingestUrl;
    }

    public final Long getLastUploadedPayloadTimestamp() {
        return this.lastUploadedPayloadTimestamp;
    }

    public final boolean getLeanSession() {
        return this.leanSession;
    }

    public final int getLocalStorageVersion() {
        return this.localStorageVersion;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setLastUploadedPayloadTimestamp(Long l) {
        this.lastUploadedPayloadTimestamp = l;
    }

    public final void setLeanSession(boolean z) {
        this.leanSession = z;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", this.version);
        jSONObject.put("projectId", this.projectId);
        jSONObject.put("userId", this.userId);
        jSONObject.put(ClarityEmitter.CLARITY_SESSION_ID_PARAMETER, this.sessionId);
        jSONObject.put("timestamp", this.timestamp);
        jSONObject.put("localStorageVersion", this.localStorageVersion);
        jSONObject.put("leanSession", this.leanSession);
        jSONObject.put("ingestUrl", this.ingestUrl);
        jSONObject.putOpt("lastUploadedPayloadTimestamp", this.lastUploadedPayloadTimestamp);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public /* synthetic */ SessionMetadata(String str, String str2, String str3, String str4, long j, int i, boolean z, String str5, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, j, i, z, str5, (i2 & 256) != 0 ? null : l);
    }
}
