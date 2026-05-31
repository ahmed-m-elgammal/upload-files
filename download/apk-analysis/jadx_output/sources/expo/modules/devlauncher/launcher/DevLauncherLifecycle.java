package expo.modules.devlauncher.launcher;

import com.facebook.react.ReactActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherLifecycle.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\u00072\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\bJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\u00072\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\bR$\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/devlauncher/launcher/DevLauncherLifecycle;", "", "()V", "delegateWillBeCreatedListeners", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "Lcom/facebook/react/ReactActivity;", "", "Lexpo/modules/devlauncher/launcher/DevLauncherDelegateWillBeCreated;", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "delegateWillBeCreated", "activity", "removeListener", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherLifecycle {
    private final LinkedList<Function1<ReactActivity, Unit>> delegateWillBeCreatedListeners = new LinkedList<>();

    public final void delegateWillBeCreated(ReactActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = this.delegateWillBeCreatedListeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(activity);
        }
    }

    public final void addListener(Function1<? super ReactActivity, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.delegateWillBeCreatedListeners.add(listener);
    }

    public final void removeListener(Function1<? super ReactActivity, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.delegateWillBeCreatedListeners.remove(listener);
    }
}
