package expo.modules.devlauncher.launcher;

import android.app.Application;
import com.facebook.react.ReactHost;
import expo.modules.devlauncher.DevLauncherControllerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherReactHost.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lexpo/modules/devlauncher/launcher/DevLauncherReactHost;", "", "()V", "create", "Lcom/facebook/react/ReactHost;", "application", "Landroid/app/Application;", "launcherIp", "", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherReactHost {
    public static final DevLauncherReactHost INSTANCE = new DevLauncherReactHost();

    private DevLauncherReactHost() {
    }

    public final ReactHost create(Application application, String launcherIp) {
        Intrinsics.checkNotNullParameter(application, "application");
        throw new IllegalStateException(DevLauncherControllerKt.DEV_LAUNCHER_IS_NOT_AVAILABLE);
    }
}
