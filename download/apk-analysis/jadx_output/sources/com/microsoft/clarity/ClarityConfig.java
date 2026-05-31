package com.microsoft.clarity;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.C0050a;
import com.microsoft.clarity.a.C0051b;
import com.microsoft.clarity.a.C0052c;
import com.microsoft.clarity.a.C0053d;
import com.microsoft.clarity.m.h;
import com.microsoft.clarity.models.ApplicationFramework;
import com.microsoft.clarity.models.LogLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\r\u0010!\u001a\u00020\fH\u0000¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020\u0018H\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0018H\u0000¢\u0006\u0002\b&J\r\u0010'\u001a\u00020\u0018H\u0000¢\u0006\u0002\b(J\r\u0010)\u001a\u00020\u0018H\u0000¢\u0006\u0002\b*J\u0016\u0010+\u001a\u00020\f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0-H\u0002J\b\u0010.\u001a\u00020\u0003H\u0016R$\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RP\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001e\"\u0004\b \u0010\u0004¨\u0006/"}, d2 = {"Lcom/microsoft/clarity/ClarityConfig;", "", "projectId", "", "(Ljava/lang/String;)V", "userId", "logLevel", "Lcom/microsoft/clarity/models/LogLevel;", "applicationFramework", "Lcom/microsoft/clarity/models/ApplicationFramework;", "customSignalsCallback", "Lkotlin/Function2;", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/clarity/models/LogLevel;Lcom/microsoft/clarity/models/ApplicationFramework;Lkotlin/jvm/functions/Function2;)V", "value", "getApplicationFramework", "()Lcom/microsoft/clarity/models/ApplicationFramework;", "setApplicationFramework", "(Lcom/microsoft/clarity/models/ApplicationFramework;)V", "getCustomSignalsCallback", "()Lkotlin/jvm/functions/Function2;", "setCustomSignalsCallback", "(Lkotlin/jvm/functions/Function2;)V", "frozen", "", "getLogLevel", "()Lcom/microsoft/clarity/models/LogLevel;", "setLogLevel", "(Lcom/microsoft/clarity/models/LogLevel;)V", "getProjectId", "()Ljava/lang/String;", "getUserId", "setUserId", "freeze", "freeze$sdk_prodRelease", "isCordova", "isCordova$sdk_prodRelease", "isIonic", "isIonic$sdk_prodRelease", "isReactNative", "isReactNative$sdk_prodRelease", "isValidUserId", "isValidUserId$sdk_prodRelease", "setProperty", "callback", "Lkotlin/Function0;", InAppPurchaseConstants.METHOD_TO_STRING, "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClarityConfig {
    private ApplicationFramework applicationFramework;
    private Function2<? super String, ? super String, Unit> customSignalsCallback;
    private boolean frozen;
    private LogLevel logLevel;
    private final String projectId;
    private String userId;

    public ClarityConfig(String projectId, String str, LogLevel logLevel, ApplicationFramework applicationFramework, Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(applicationFramework, "applicationFramework");
        this.projectId = projectId;
        this.userId = str;
        this.logLevel = logLevel;
        this.applicationFramework = applicationFramework;
        this.customSignalsCallback = function2;
    }

    private final void setProperty(Function0<Unit> callback) {
        if (this.frozen) {
            h.c("Clarity config cannot be modified after initialization.");
        } else {
            callback.invoke();
        }
    }

    public final void freeze$sdk_prodRelease() {
        this.frozen = true;
    }

    public final ApplicationFramework getApplicationFramework() {
        return this.applicationFramework;
    }

    public final Function2<String, String, Unit> getCustomSignalsCallback() {
        return this.customSignalsCallback;
    }

    public final LogLevel getLogLevel() {
        return this.logLevel;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean isCordova$sdk_prodRelease() {
        return this.applicationFramework == ApplicationFramework.Cordova;
    }

    public final boolean isIonic$sdk_prodRelease() {
        return this.applicationFramework == ApplicationFramework.Ionic;
    }

    public final boolean isReactNative$sdk_prodRelease() {
        return this.applicationFramework == ApplicationFramework.ReactNative;
    }

    public final boolean isValidUserId$sdk_prodRelease() {
        if (this.userId != null && (!StringsKt.isBlank(r0))) {
            String str = this.userId;
            if ((str != null ? UStringsKt.toUIntOrNull(str, 36) : null) != null) {
                return true;
            }
        }
        return false;
    }

    public final void setApplicationFramework(ApplicationFramework value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setProperty(new C0050a(this, value));
    }

    public final void setCustomSignalsCallback(Function2<? super String, ? super String, Unit> function2) {
        setProperty(new C0051b(this, function2));
    }

    public final void setLogLevel(LogLevel value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setProperty(new C0052c(this, value));
    }

    public final void setUserId(String str) {
        setProperty(new C0053d(this, str));
    }

    public String toString() {
        return "[ProjectId: " + this.projectId + ", UserId: " + this.userId + ", LogLevel: " + this.logLevel + ", ApplicationFramework: " + this.applicationFramework + ", ]";
    }

    public /* synthetic */ ClarityConfig(String str, String str2, LogLevel logLevel, ApplicationFramework applicationFramework, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? LogLevel.None : logLevel, (i & 8) != 0 ? ApplicationFramework.Native : applicationFramework, (i & 16) != 0 ? null : function2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClarityConfig(String projectId) {
        this(projectId, null, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(projectId, "projectId");
    }
}
