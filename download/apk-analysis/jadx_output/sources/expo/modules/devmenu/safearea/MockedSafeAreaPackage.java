package expo.modules.devmenu.safearea;

import android.view.ViewGroup;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.views.view.ReactViewGroup;
import com.th3rdwave.safeareacontext.SafeAreaProviderManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MockedSafeAreaPackage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lexpo/modules/devmenu/safearea/MockedSafeAreaPackage;", "Lcom/facebook/react/ReactPackage;", "()V", "createNativeModules", "", "Lcom/facebook/react/bridge/NativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewManagers", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Landroid/view/ViewGroup;", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MockedSafeAreaPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public /* synthetic */ NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        return ReactPackage.CC.$default$getModule(this, str, reactApplicationContext);
    }

    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ArrayList();
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewGroupManager<ViewGroup>> createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.mutableListOf(new ViewGroupManager<ViewGroup>() { // from class: expo.modules.devmenu.safearea.MockedSafeAreaPackage$createViewManagers$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.uimanager.ViewManager
            public ReactViewGroup createViewInstance(ThemedReactContext reactContext2) {
                Intrinsics.checkNotNullParameter(reactContext2, "reactContext");
                return new ReactViewGroup(reactContext2);
            }

            @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
            public String getName() {
                return SafeAreaProviderManager.REACT_CLASS;
            }
        });
    }
}
