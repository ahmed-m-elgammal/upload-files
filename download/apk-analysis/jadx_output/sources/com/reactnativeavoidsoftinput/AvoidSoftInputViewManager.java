package com.reactnativeavoidsoftinput;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewManager;
import com.reactnativeavoidsoftinput.events.AvoidSoftInputAppliedOffsetChangedEvent;
import com.reactnativeavoidsoftinput.events.AvoidSoftInputHeightChangedEvent;
import com.reactnativeavoidsoftinput.events.AvoidSoftInputHiddenEvent;
import com.reactnativeavoidsoftinput.events.AvoidSoftInputShownEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvoidSoftInputViewManager.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\tH\u0007J\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u001f\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016J\u001f\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/reactnativeavoidsoftinput/AvoidSoftInputViewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "()V", "createViewInstance", "Lcom/reactnativeavoidsoftinput/AvoidSoftInputView;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "setAvoidOffset", "", ViewHierarchyConstants.VIEW_KEY, "avoidOffset", "", "setEasing", "easing", "setHideAnimationDelay", "delay", "", "(Lcom/reactnativeavoidsoftinput/AvoidSoftInputView;Ljava/lang/Integer;)V", "setHideAnimationDuration", "duration", "setIsEnabled", "enabled", "", "setShowAnimationDelay", "setShowAnimationDuration", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvoidSoftInputViewManager extends ReactViewManager {
    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return AvoidSoftInputView.NAME;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public AvoidSoftInputView createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new AvoidSoftInputView(reactContext);
    }

    @ReactProp(name = "avoidOffset")
    public final void setAvoidOffset(AvoidSoftInputView view, float avoidOffset) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAvoidOffset(avoidOffset);
    }

    @ReactProp(name = "easing")
    public final void setEasing(AvoidSoftInputView view, String easing) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(easing, "easing");
        view.setEasing(easing);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public final void setIsEnabled(AvoidSoftInputView view, boolean enabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setIsEnabled(enabled);
    }

    @ReactProp(name = "hideAnimationDelay")
    public final void setHideAnimationDelay(AvoidSoftInputView view, Integer delay) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHideAnimationDelay(delay);
    }

    @ReactProp(name = "hideAnimationDuration")
    public final void setHideAnimationDuration(AvoidSoftInputView view, Integer duration) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHideAnimationDuration(duration);
    }

    @ReactProp(name = "showAnimationDelay")
    public final void setShowAnimationDelay(AvoidSoftInputView view, Integer delay) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setShowAnimationDelay(delay);
    }

    @ReactProp(name = "showAnimationDuration")
    public final void setShowAnimationDuration(AvoidSoftInputView view, Integer duration) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setShowAnimationDuration(duration);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> of = MapBuilder.of(AvoidSoftInputAppliedOffsetChangedEvent.NAME, MapBuilder.of("registrationName", AvoidSoftInputView.ON_SOFT_INPUT_APPLIED_OFFSET_CHANGE), AvoidSoftInputHeightChangedEvent.NAME, MapBuilder.of("registrationName", AvoidSoftInputView.ON_SOFT_INPUT_HEIGHT_CHANGE), AvoidSoftInputHiddenEvent.NAME, MapBuilder.of("registrationName", AvoidSoftInputView.ON_SOFT_INPUT_HIDDEN), AvoidSoftInputShownEvent.NAME, MapBuilder.of("registrationName", AvoidSoftInputView.ON_SOFT_INPUT_SHOWN));
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        return of;
    }
}
