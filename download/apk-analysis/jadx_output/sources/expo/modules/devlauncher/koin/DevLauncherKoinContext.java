package expo.modules.devlauncher.koin;

import io.sentry.protocol.App;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.koin.core.KoinApplication;

/* compiled from: DevLauncherKoinApp.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/devlauncher/koin/DevLauncherKoinContext;", "", "()V", App.TYPE, "Lorg/koin/core/KoinApplication;", "getApp", "()Lorg/koin/core/KoinApplication;", "internalApp", "reinitialize", "", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherKoinContext {
    public static final DevLauncherKoinContext INSTANCE = new DevLauncherKoinContext();
    private static KoinApplication internalApp;

    private DevLauncherKoinContext() {
    }

    static {
        Function0 function0;
        function0 = DevLauncherKoinAppKt.koinAppFactory;
        internalApp = (KoinApplication) function0.invoke();
    }

    public final void reinitialize() {
        Function0 function0;
        internalApp.close();
        function0 = DevLauncherKoinAppKt.koinAppFactory;
        internalApp = (KoinApplication) function0.invoke();
    }

    public final KoinApplication getApp() {
        return internalApp;
    }
}
