package expo.modules.devmenu.modules;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import expo.interfaces.devmenu.DevMenuPreferencesInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuPreferences.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR#\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR$\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\n¨\u0006'"}, d2 = {"Lexpo/modules/devmenu/modules/DevMenuPreferencesHandle;", "Lexpo/interfaces/devmenu/DevMenuPreferencesInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "isOnboardingFinished", "()Z", "setOnboardingFinished", "(Z)V", "keyCommandsEnabled", "getKeyCommandsEnabled", "setKeyCommandsEnabled", "motionGestureEnabled", "getMotionGestureEnabled", "setMotionGestureEnabled", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "showsAtLaunch", "getShowsAtLaunch", "setShowsAtLaunch", "touchGestureEnabled", "getTouchGestureEnabled", "setTouchGestureEnabled", "saveBoolean", "", SDKConstants.PARAM_KEY, "", "serialize", "Lcom/facebook/react/bridge/WritableMap;", "setPreferences", "settings", "Lcom/facebook/react/bridge/ReadableMap;", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuPreferencesHandle implements DevMenuPreferencesInterface {

    /* renamed from: sharedPreferences$delegate, reason: from kotlin metadata */
    private final Lazy sharedPreferences;

    public DevMenuPreferencesHandle(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.sharedPreferences = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: expo.modules.devmenu.modules.DevMenuPreferencesHandle$sharedPreferences$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return context.getSharedPreferences("expo.modules.devmenu.sharedpreferences", 0);
            }
        });
    }

    private final SharedPreferences getSharedPreferences() {
        return (SharedPreferences) this.sharedPreferences.getValue();
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public boolean getMotionGestureEnabled() {
        return getSharedPreferences().getBoolean("motionGestureEnabled", true);
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setMotionGestureEnabled(boolean z) {
        saveBoolean("motionGestureEnabled", z);
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public boolean getTouchGestureEnabled() {
        return getSharedPreferences().getBoolean("touchGestureEnabled", true);
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setTouchGestureEnabled(boolean z) {
        saveBoolean("touchGestureEnabled", z);
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public boolean getKeyCommandsEnabled() {
        return getSharedPreferences().getBoolean("keyCommandsEnabled", true);
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setKeyCommandsEnabled(boolean z) {
        saveBoolean("keyCommandsEnabled", z);
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public boolean getShowsAtLaunch() {
        return getSharedPreferences().getBoolean("showsAtLaunch", false);
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setShowsAtLaunch(boolean z) {
        saveBoolean("showsAtLaunch", z);
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public boolean isOnboardingFinished() {
        return getSharedPreferences().getBoolean("isOnboardingFinished", false);
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setOnboardingFinished(boolean z) {
        saveBoolean("isOnboardingFinished", z);
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public WritableMap serialize() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("motionGestureEnabled", getMotionGestureEnabled());
        createMap.putBoolean("touchGestureEnabled", getTouchGestureEnabled());
        createMap.putBoolean("keyCommandsEnabled", getKeyCommandsEnabled());
        createMap.putBoolean("showsAtLaunch", getShowsAtLaunch());
        createMap.putBoolean("isOnboardingFinished", isOnboardingFinished());
        Intrinsics.checkNotNullExpressionValue(createMap, "apply(...)");
        return createMap;
    }

    private final void saveBoolean(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setPreferences(ReadableMap settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        if (settings.hasKey("motionGestureEnabled")) {
            setMotionGestureEnabled(settings.getBoolean("motionGestureEnabled"));
        }
        if (settings.hasKey("keyCommandsEnabled")) {
            setKeyCommandsEnabled(settings.getBoolean("keyCommandsEnabled"));
        }
        if (settings.hasKey("showsAtLaunch")) {
            setShowsAtLaunch(settings.getBoolean("showsAtLaunch"));
        }
        if (settings.hasKey("touchGestureEnabled")) {
            setTouchGestureEnabled(settings.getBoolean("touchGestureEnabled"));
        }
    }
}
