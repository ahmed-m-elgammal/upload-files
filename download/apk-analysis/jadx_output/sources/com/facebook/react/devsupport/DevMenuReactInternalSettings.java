package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.devsupport.DevInternalSettings;
import expo.modules.devmenu.react.DevMenuPackagerConnectionSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuReactInternalSettings.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0014J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bH\u0014J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/react/devsupport/DevMenuReactInternalSettings;", "Lcom/facebook/react/devsupport/DevInternalSettings;", "serverIp", "", "application", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "packagerConnectionSettings", "Lexpo/modules/devmenu/react/DevMenuPackagerConnectionSettings;", "getPackagerConnectionSettings", "isAnimationFpsDebugEnabled", "", "isElementInspectorEnabled", "isFpsDebugEnabled", "isHotModuleReplacementEnabled", "isJSDevModeEnabled", "isJSMinifyEnabled", "isRemoteJSDebugEnabled", "isStartSamplingProfilerOnInit", "setElementInspectorEnabled", "", "enabled", "setFpsDebugEnabled", "setHotModuleReplacementEnabled", "setJSDevModeEnabled", "value", "setRemoteJSDebugEnabled", "remoteJSDebugEnabled", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevMenuReactInternalSettings extends DevInternalSettings {
    private final DevMenuPackagerConnectionSettings packagerConnectionSettings;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0() {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isAnimationFpsDebugEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isElementInspectorEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isFpsDebugEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings
    protected boolean isHotModuleReplacementEnabled() {
        return true;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isJSDevModeEnabled() {
        return true;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isJSMinifyEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isRemoteJSDebugEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isStartSamplingProfilerOnInit() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings
    protected void setElementInspectorEnabled(boolean enabled) {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings
    protected void setFpsDebugEnabled(boolean enabled) {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings
    protected void setHotModuleReplacementEnabled(boolean enabled) {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings
    protected void setJSDevModeEnabled(boolean value) {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setRemoteJSDebugEnabled(boolean remoteJSDebugEnabled) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevMenuReactInternalSettings(String serverIp, Context application) {
        super(application, new DevInternalSettings.Listener() { // from class: com.facebook.react.devsupport.DevMenuReactInternalSettings$$ExternalSyntheticLambda0
            @Override // com.facebook.react.devsupport.DevInternalSettings.Listener
            public final void onInternalSettingsChanged() {
                DevMenuReactInternalSettings._init_$lambda$0();
            }
        });
        Intrinsics.checkNotNullParameter(serverIp, "serverIp");
        Intrinsics.checkNotNullParameter(application, "application");
        this.packagerConnectionSettings = new DevMenuPackagerConnectionSettings(serverIp, application);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.devsupport.DevInternalSettings
    public DevMenuPackagerConnectionSettings getPackagerConnectionSettings() {
        return this.packagerConnectionSettings;
    }
}
