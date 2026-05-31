package expo.modules.devlauncher.logs;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.henninghall.date_picker.props.ModeProp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherRemoteLog.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u0004J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0010\u0010\u0010\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lexpo/modules/devlauncher/logs/DevLauncherRemoteLog;", "", "messages", "", "", "level", ModeProp.name, "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "data", "", "[Ljava/lang/String;", "getLevel", "()Ljava/lang/String;", "getMessages", "()Ljava/util/List;", "getMode", "type", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", InAppPurchaseConstants.METHOD_TO_STRING, "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DevLauncherRemoteLog {

    @Expose
    private final String[] data;

    @Expose
    private final String level;
    private final List<String> messages;

    @Expose
    private final String mode;

    @Expose
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DevLauncherRemoteLog copy$default(DevLauncherRemoteLog devLauncherRemoteLog, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = devLauncherRemoteLog.messages;
        }
        if ((i & 2) != 0) {
            str = devLauncherRemoteLog.level;
        }
        if ((i & 4) != 0) {
            str2 = devLauncherRemoteLog.mode;
        }
        return devLauncherRemoteLog.copy(list, str, str2);
    }

    public final List<String> component1() {
        return this.messages;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLevel() {
        return this.level;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final DevLauncherRemoteLog copy(List<String> messages, String level, String mode) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new DevLauncherRemoteLog(messages, level, mode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DevLauncherRemoteLog)) {
            return false;
        }
        DevLauncherRemoteLog devLauncherRemoteLog = (DevLauncherRemoteLog) other;
        return Intrinsics.areEqual(this.messages, devLauncherRemoteLog.messages) && Intrinsics.areEqual(this.level, devLauncherRemoteLog.level) && Intrinsics.areEqual(this.mode, devLauncherRemoteLog.mode);
    }

    public int hashCode() {
        return (((this.messages.hashCode() * 31) + this.level.hashCode()) * 31) + this.mode.hashCode();
    }

    public String toString() {
        return "DevLauncherRemoteLog(messages=" + this.messages + ", level=" + this.level + ", mode=" + this.mode + ")";
    }

    public DevLauncherRemoteLog(List<String> messages, String level, String mode) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.messages = messages;
        this.level = level;
        this.mode = mode;
        this.data = new String[]{CollectionsKt.joinToString$default(messages, "\n", null, null, 0, null, null, 62, null)};
        this.type = "log";
    }

    public final List<String> getMessages() {
        return this.messages;
    }

    public /* synthetic */ DevLauncherRemoteLog(List list, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? "error" : str, (i & 4) != 0 ? "BRIDGE" : str2);
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String toJson() {
        String json = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }
}
