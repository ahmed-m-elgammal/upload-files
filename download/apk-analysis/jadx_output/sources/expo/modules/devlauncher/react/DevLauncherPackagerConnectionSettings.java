package expo.modules.devlauncher.react;

import android.content.Context;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherPackagerConnectionSettings.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lexpo/modules/devlauncher/react/DevLauncherPackagerConnectionSettings;", "Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;", "context", "Landroid/content/Context;", "serverIp", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getDebugServerHost", "setDebugServerHost", "", "host", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherPackagerConnectionSettings extends PackagerConnectionSettings {
    private String serverIp;

    @Override // com.facebook.react.packagerconnection.PackagerConnectionSettings
    public void setDebugServerHost(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevLauncherPackagerConnectionSettings(Context context, String serverIp) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serverIp, "serverIp");
        this.serverIp = serverIp;
    }

    @Override // com.facebook.react.packagerconnection.PackagerConnectionSettings
    /* renamed from: getDebugServerHost, reason: from getter */
    public String getServerIp() {
        return this.serverIp;
    }
}
