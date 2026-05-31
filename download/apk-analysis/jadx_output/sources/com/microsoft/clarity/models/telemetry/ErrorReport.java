package com.microsoft.clarity.models.telemetry;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.reactnative.ClarityEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jo\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006,"}, d2 = {"Lcom/microsoft/clarity/models/telemetry/ErrorReport;", "", "version", "", "projectId", "userId", ClarityEmitter.CLARITY_SESSION_ID_PARAMETER, "pageNum", "", "errorType", "message", "stack", "timestamp", "sourcePlatform", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getErrorType", "()Ljava/lang/String;", "getMessage", "getPageNum", "()I", "getProjectId", "getSessionId", "getSourcePlatform", "getStack", "getTimestamp", "getUserId", "getVersion", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toJson", InAppPurchaseConstants.METHOD_TO_STRING, "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ErrorReport {
    private final String errorType;
    private final String message;
    private final int pageNum;
    private final String projectId;
    private final String sessionId;
    private final int sourcePlatform;
    private final String stack;
    private final String timestamp;
    private final String userId;
    private final String version;

    public ErrorReport(String version, String projectId, String userId, String sessionId, int i, String errorType, String str, String stack, String timestamp, int i2) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.version = version;
        this.projectId = projectId;
        this.userId = userId;
        this.sessionId = sessionId;
        this.pageNum = i;
        this.errorType = errorType;
        this.message = str;
        this.stack = stack;
        this.timestamp = timestamp;
        this.sourcePlatform = i2;
    }

    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component10, reason: from getter */
    public final int getSourcePlatform() {
        return this.sourcePlatform;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProjectId() {
        return this.projectId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component6, reason: from getter */
    public final String getErrorType() {
        return this.errorType;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component8, reason: from getter */
    public final String getStack() {
        return this.stack;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    public final ErrorReport copy(String version, String projectId, String userId, String sessionId, int pageNum, String errorType, String message, String stack, String timestamp, int sourcePlatform) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return new ErrorReport(version, projectId, userId, sessionId, pageNum, errorType, message, stack, timestamp, sourcePlatform);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorReport)) {
            return false;
        }
        ErrorReport errorReport = (ErrorReport) other;
        return Intrinsics.areEqual(this.version, errorReport.version) && Intrinsics.areEqual(this.projectId, errorReport.projectId) && Intrinsics.areEqual(this.userId, errorReport.userId) && Intrinsics.areEqual(this.sessionId, errorReport.sessionId) && this.pageNum == errorReport.pageNum && Intrinsics.areEqual(this.errorType, errorReport.errorType) && Intrinsics.areEqual(this.message, errorReport.message) && Intrinsics.areEqual(this.stack, errorReport.stack) && Intrinsics.areEqual(this.timestamp, errorReport.timestamp) && this.sourcePlatform == errorReport.sourcePlatform;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSourcePlatform() {
        return this.sourcePlatform;
    }

    public final String getStack() {
        return this.stack;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = (this.errorType.hashCode() + ((this.pageNum + ((this.sessionId.hashCode() + ((this.userId.hashCode() + ((this.projectId.hashCode() + (this.version.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.message;
        return this.sourcePlatform + ((this.timestamp.hashCode() + ((this.stack.hashCode() + ((hashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31);
    }

    public final String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("v", this.version);
        jSONObject.put("p", this.projectId);
        jSONObject.put("u", this.userId);
        jSONObject.put(CmcdData.Factory.STREAMING_FORMAT_SS, this.sessionId);
        jSONObject.put("n", this.pageNum);
        jSONObject.put("t", this.errorType);
        jSONObject.put("m", this.message);
        jSONObject.put("e", this.stack);
        jSONObject.put("i", this.timestamp);
        jSONObject.put("f", this.sourcePlatform);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public String toString() {
        return "ErrorReport(version=" + this.version + ", projectId=" + this.projectId + ", userId=" + this.userId + ", sessionId=" + this.sessionId + ", pageNum=" + this.pageNum + ", errorType=" + this.errorType + ", message=" + this.message + ", stack=" + this.stack + ", timestamp=" + this.timestamp + ", sourcePlatform=" + this.sourcePlatform + ')';
    }

    public /* synthetic */ ErrorReport(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, str5, str6, str7, str8, (i3 & 512) != 0 ? 1 : i2);
    }
}
