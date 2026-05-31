package com.reactnativeavoidsoftinput;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvoidSoftInputModule.kt */
@ReactModule(name = AvoidSoftInputModuleImpl.NAME)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\bH\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\nH\u0007J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0017\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001fJ\u0017\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001fJ\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0007J\u0017\u0010$\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001fJ\u0017\u0010%\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/reactnativeavoidsoftinput/AvoidSoftInputModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mModuleImpl", "Lcom/reactnativeavoidsoftinput/AvoidSoftInputModuleImpl;", "addListener", "", "eventName", "", "getName", "initialize", "removeListeners", "count", "", "setAdjustNothing", "setAdjustPan", "setAdjustResize", "setAdjustUnspecified", "setAvoidOffset", "avoidOffset", "", "setDefaultAppSoftInputMode", "setEasing", "easing", "setEnabled", "isEnabled", "", "setHideAnimationDelay", "delay", "(Ljava/lang/Integer;)V", "setHideAnimationDuration", "duration", "setShouldMimicIOSBehavior", "shouldMimic", "setShowAnimationDelay", "setShowAnimationDuration", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvoidSoftInputModule extends ReactContextBaseJavaModule {
    private AvoidSoftInputModuleImpl mModuleImpl;
    private final ReactApplicationContext reactContext;

    @ReactMethod
    public final void addListener(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @ReactMethod
    public final void removeListeners(int count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvoidSoftInputModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.mModuleImpl = new AvoidSoftInputModuleImpl(reactContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return AvoidSoftInputModuleImpl.NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        this.mModuleImpl.onInitialize();
    }

    @ReactMethod
    public final void setShouldMimicIOSBehavior(boolean shouldMimic) {
        this.mModuleImpl.setShouldMimicIOSBehavior(shouldMimic);
    }

    @ReactMethod
    public final void setEnabled(boolean isEnabled) {
        this.mModuleImpl.setEnabled(isEnabled);
    }

    @ReactMethod
    public final void setAvoidOffset(float avoidOffset) {
        this.mModuleImpl.setAvoidOffset(avoidOffset);
    }

    @ReactMethod
    public final void setEasing(String easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.mModuleImpl.setEasing(easing);
    }

    @ReactMethod
    public final void setHideAnimationDelay(Integer delay) {
        this.mModuleImpl.setHideAnimationDelay(delay);
    }

    @ReactMethod
    public final void setHideAnimationDuration(Integer duration) {
        this.mModuleImpl.setHideAnimationDuration(duration);
    }

    @ReactMethod
    public final void setShowAnimationDelay(Integer delay) {
        this.mModuleImpl.setShowAnimationDelay(delay);
    }

    @ReactMethod
    public final void setShowAnimationDuration(Integer duration) {
        this.mModuleImpl.setShowAnimationDuration(duration);
    }

    @ReactMethod
    public final void setAdjustNothing() {
        this.mModuleImpl.setAdjustNothing();
    }

    @ReactMethod
    public final void setAdjustPan() {
        this.mModuleImpl.setAdjustPan();
    }

    @ReactMethod
    public final void setAdjustResize() {
        this.mModuleImpl.setAdjustResize();
    }

    @ReactMethod
    public final void setAdjustUnspecified() {
        this.mModuleImpl.setAdjustUnspecified();
    }

    @ReactMethod
    public final void setDefaultAppSoftInputMode() {
        this.mModuleImpl.setDefaultAppSoftInputMode();
    }
}
