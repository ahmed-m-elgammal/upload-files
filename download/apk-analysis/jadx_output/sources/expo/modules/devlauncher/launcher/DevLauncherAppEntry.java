package expo.modules.devlauncher.launcher;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.imagepicker.Utils$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherRecentlyOpenedAppsRegistry.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003JT\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0007\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lexpo/modules/devlauncher/launcher/DevLauncherAppEntry;", "", "timestamp", "", "name", "", "url", "isEASUpdate", "", "updateMessage", "branchName", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getBranchName", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getTimestamp", "()J", "getUpdateMessage", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lexpo/modules/devlauncher/launcher/DevLauncherAppEntry;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DevLauncherAppEntry {
    private final String branchName;
    private final Boolean isEASUpdate;
    private final String name;
    private final long timestamp;
    private final String updateMessage;
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getIsEASUpdate() {
        return this.isEASUpdate;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUpdateMessage() {
        return this.updateMessage;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBranchName() {
        return this.branchName;
    }

    public final DevLauncherAppEntry copy(long timestamp, String name, String url, Boolean isEASUpdate, String updateMessage, String branchName) {
        return new DevLauncherAppEntry(timestamp, name, url, isEASUpdate, updateMessage, branchName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DevLauncherAppEntry)) {
            return false;
        }
        DevLauncherAppEntry devLauncherAppEntry = (DevLauncherAppEntry) other;
        return this.timestamp == devLauncherAppEntry.timestamp && Intrinsics.areEqual(this.name, devLauncherAppEntry.name) && Intrinsics.areEqual(this.url, devLauncherAppEntry.url) && Intrinsics.areEqual(this.isEASUpdate, devLauncherAppEntry.isEASUpdate) && Intrinsics.areEqual(this.updateMessage, devLauncherAppEntry.updateMessage) && Intrinsics.areEqual(this.branchName, devLauncherAppEntry.branchName);
    }

    public int hashCode() {
        int m = Utils$$ExternalSyntheticBackport0.m(this.timestamp) * 31;
        String str = this.name;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isEASUpdate;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.updateMessage;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.branchName;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DevLauncherAppEntry(timestamp=" + this.timestamp + ", name=" + this.name + ", url=" + this.url + ", isEASUpdate=" + this.isEASUpdate + ", updateMessage=" + this.updateMessage + ", branchName=" + this.branchName + ")";
    }

    public DevLauncherAppEntry(long j, String str, String str2, Boolean bool, String str3, String str4) {
        this.timestamp = j;
        this.name = str;
        this.url = str2;
        this.isEASUpdate = bool;
        this.updateMessage = str3;
        this.branchName = str4;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean isEASUpdate() {
        return this.isEASUpdate;
    }

    public final String getUpdateMessage() {
        return this.updateMessage;
    }

    public final String getBranchName() {
        return this.branchName;
    }
}
