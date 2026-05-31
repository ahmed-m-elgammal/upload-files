package expo.modules.devmenu;

import android.os.Bundle;
import expo.interfaces.devmenu.DevMenuDelegateInterface;
import expo.interfaces.devmenu.ReactHostWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuDefaultDelegate.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lexpo/modules/devmenu/DevMenuDefaultDelegate;", "Lexpo/interfaces/devmenu/DevMenuDelegateInterface;", "delegateHost", "Lexpo/interfaces/devmenu/ReactHostWrapper;", "(Lexpo/interfaces/devmenu/ReactHostWrapper;)V", "appInfo", "Landroid/os/Bundle;", "reactHost", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuDefaultDelegate implements DevMenuDelegateInterface {
    private final ReactHostWrapper delegateHost;

    @Override // expo.interfaces.devmenu.DevMenuDelegateInterface
    public Bundle appInfo() {
        return null;
    }

    public DevMenuDefaultDelegate(ReactHostWrapper delegateHost) {
        Intrinsics.checkNotNullParameter(delegateHost, "delegateHost");
        this.delegateHost = delegateHost;
    }

    @Override // expo.interfaces.devmenu.DevMenuDelegateInterface
    public boolean supportsDevelopment() {
        return DevMenuDelegateInterface.DefaultImpls.supportsDevelopment(this);
    }

    @Override // expo.interfaces.devmenu.DevMenuDelegateInterface
    /* renamed from: reactHost, reason: from getter */
    public ReactHostWrapper getDelegateHost() {
        return this.delegateHost;
    }
}
