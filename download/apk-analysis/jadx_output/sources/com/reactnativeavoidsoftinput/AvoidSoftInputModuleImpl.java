package com.reactnativeavoidsoftinput;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.firebase.messaging.Constants;
import com.henninghall.date_picker.props.ModeProp;
import com.reactnativeavoidsoftinput.listeners.SoftInputListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvoidSoftInputModuleImpl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0006\u0010\u000e\u001a\u00020\u000bJ \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010\"\u001a\u00020\u000bJ\u0006\u0010#\u001a\u00020\u000bJ\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u000bJ\u000e\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u001aJ\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0013J\u0015\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010/J\u0015\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010/J\u000e\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u0013J\u0015\u00104\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010/J\u0015\u00105\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010/J\u0010\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/reactnativeavoidsoftinput/AvoidSoftInputModuleImpl;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "Lcom/reactnativeavoidsoftinput/listeners/SoftInputListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mDefaultSoftInputMode", "", "mManager", "Lcom/reactnativeavoidsoftinput/AvoidSoftInputManager;", "onHostDestroy", "", "onHostPause", "onHostResume", "onInitialize", AvoidSoftInputView.ON_SOFT_INPUT_HEIGHT_CHANGE, Constants.MessagePayloadKeys.FROM, "to", "isOrientationChanged", "", AvoidSoftInputView.ON_SOFT_INPUT_HIDDEN, AvoidSoftInputView.ON_SOFT_INPUT_SHOWN, "sendAppliedOffsetChangedEvent", "offset", "sendEvent", "eventName", "", "params", "Lcom/facebook/react/bridge/WritableMap;", "sendHeightChangedEvent", "height", "sendHiddenEvent", "sendShownEvent", "setAdjustNothing", "setAdjustPan", "setAdjustResize", "setAdjustUnspecified", "setAvoidOffset", "avoidOffset", "", "setDefaultAppSoftInputMode", "setEasing", "easing", "setEnabled", "isEnabled", "setHideAnimationDelay", "delay", "(Ljava/lang/Integer;)V", "setHideAnimationDuration", "duration", "setShouldMimicIOSBehavior", "shouldMimic", "setShowAnimationDelay", "setShowAnimationDuration", "setSoftInputMode", ModeProp.name, "Companion", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvoidSoftInputModuleImpl implements LifecycleEventListener, SoftInputListener {
    public static final String NAME = "AvoidSoftInput";
    public static final String SOFT_INPUT_APPLIED_OFFSET_CHANGED = "softInputAppliedOffsetChanged";
    public static final String SOFT_INPUT_APPLIED_OFFSET_KEY = "appliedOffset";
    public static final String SOFT_INPUT_HEIGHT_CHANGED = "softInputHeightChanged";
    public static final String SOFT_INPUT_HEIGHT_KEY = "softInputHeight";
    public static final String SOFT_INPUT_HIDDEN = "softInputHidden";
    public static final String SOFT_INPUT_SHOWN = "softInputShown";
    private int mDefaultSoftInputMode;
    private AvoidSoftInputManager mManager;
    private final ReactApplicationContext reactContext;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    public AvoidSoftInputModuleImpl(ReactApplicationContext reactContext) {
        Window window;
        WindowManager.LayoutParams attributes;
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        Activity currentActivity = reactContext.getCurrentActivity();
        this.mDefaultSoftInputMode = (currentActivity == null || (window = currentActivity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? 0 : attributes.softInputMode;
        AvoidSoftInputManager avoidSoftInputManager = new AvoidSoftInputManager(reactContext);
        avoidSoftInputManager.setIsEnabled(false);
        avoidSoftInputManager.setOnOffsetChangedListener(new Function1<Integer, Unit>() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputModuleImpl$mManager$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                AvoidSoftInputModuleImpl.this.sendAppliedOffsetChangedEvent(i);
            }
        });
        avoidSoftInputManager.setOnSoftInputEventsListener(this);
        this.mManager = avoidSoftInputManager;
    }

    public final void onInitialize() {
        Window window;
        WindowManager.LayoutParams attributes;
        Activity currentActivity = this.reactContext.getCurrentActivity();
        this.mDefaultSoftInputMode = (currentActivity == null || (window = currentActivity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? 0 : attributes.softInputMode;
        this.reactContext.addLifecycleEventListener(this);
    }

    public final void setShouldMimicIOSBehavior(boolean shouldMimic) {
        this.mManager.setShouldMimicIOSBehavior(shouldMimic);
    }

    public final void setEnabled(boolean isEnabled) {
        this.mManager.setIsEnabled(isEnabled);
    }

    public final void setAvoidOffset(float avoidOffset) {
        this.mManager.setAvoidOffset(avoidOffset);
    }

    public final void setEasing(String easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.mManager.setEasing(easing);
    }

    public final void setHideAnimationDelay(Integer delay) {
        this.mManager.setHideAnimationDelay(delay);
    }

    public final void setHideAnimationDuration(Integer duration) {
        this.mManager.setHideAnimationDuration(duration);
    }

    public final void setShowAnimationDelay(Integer delay) {
        this.mManager.setShowAnimationDelay(delay);
    }

    public final void setShowAnimationDuration(Integer duration) {
        this.mManager.setShowAnimationDuration(duration);
    }

    public final void setAdjustNothing() {
        setSoftInputMode(48);
    }

    public final void setAdjustPan() {
        setSoftInputMode(32);
    }

    public final void setAdjustResize() {
        setSoftInputMode(16);
    }

    public final void setAdjustUnspecified() {
        setSoftInputMode(0);
    }

    public final void setDefaultAppSoftInputMode() {
        setSoftInputMode(this.mDefaultSoftInputMode);
    }

    private final void setSoftInputMode(final int mode) {
        final Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputModuleImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AvoidSoftInputModuleImpl.setSoftInputMode$lambda$1(currentActivity, mode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSoftInputMode$lambda$1(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        activity.getWindow().setSoftInputMode(i);
    }

    @Override // com.reactnativeavoidsoftinput.listeners.SoftInputListener
    public void onSoftInputShown(int from, int to) {
        sendShownEvent(AvoidSoftInputUtilsKt.convertFromPixelToDIP(to));
    }

    @Override // com.reactnativeavoidsoftinput.listeners.SoftInputListener
    public void onSoftInputHidden(int from, int to) {
        sendHiddenEvent(AvoidSoftInputUtilsKt.convertFromPixelToDIP(0));
    }

    @Override // com.reactnativeavoidsoftinput.listeners.SoftInputListener
    public void onSoftInputHeightChange(int from, int to, boolean isOrientationChanged) {
        sendHeightChangedEvent(AvoidSoftInputUtilsKt.convertFromPixelToDIP(to));
    }

    private final void sendEvent(String eventName, WritableMap params) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(eventName, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendAppliedOffsetChangedEvent(int offset) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(SOFT_INPUT_APPLIED_OFFSET_KEY, offset);
        Unit unit = Unit.INSTANCE;
        sendEvent(SOFT_INPUT_APPLIED_OFFSET_CHANGED, createMap);
    }

    private final void sendHeightChangedEvent(int height) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(SOFT_INPUT_HEIGHT_KEY, height);
        Unit unit = Unit.INSTANCE;
        sendEvent(SOFT_INPUT_HEIGHT_CHANGED, createMap);
    }

    private final void sendHiddenEvent(int height) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(SOFT_INPUT_HEIGHT_KEY, height);
        Unit unit = Unit.INSTANCE;
        sendEvent(SOFT_INPUT_HIDDEN, createMap);
    }

    private final void sendShownEvent(int height) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(SOFT_INPUT_HEIGHT_KEY, height);
        Unit unit = Unit.INSTANCE;
        sendEvent(SOFT_INPUT_SHOWN, createMap);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this.mManager.setRootView((View) AvoidSoftInputUtilsKt.getReactRootView(this.reactContext));
        this.mManager.initializeHandlers();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        this.mManager.cleanupHandlers();
    }
}
