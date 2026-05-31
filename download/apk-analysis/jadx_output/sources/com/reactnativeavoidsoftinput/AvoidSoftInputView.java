package com.reactnativeavoidsoftinput;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.firebase.messaging.Constants;
import com.reactnativeavoidsoftinput.events.AvoidSoftInputAppliedOffsetChangedEvent;
import com.reactnativeavoidsoftinput.events.AvoidSoftInputHeightChangedEvent;
import com.reactnativeavoidsoftinput.events.AvoidSoftInputHiddenEvent;
import com.reactnativeavoidsoftinput.events.AvoidSoftInputShownEvent;
import com.reactnativeavoidsoftinput.listeners.SoftInputListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvoidSoftInputView.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0015\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010#J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0012J\u0015\u0010(\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010#J\u0015\u0010)\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/reactnativeavoidsoftinput/AvoidSoftInputView;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/reactnativeavoidsoftinput/listeners/SoftInputListener;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "mManager", "Lcom/reactnativeavoidsoftinput/AvoidSoftInputManager;", "getEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "onAttachedToWindow", "", "onDetachedFromWindow", AvoidSoftInputView.ON_SOFT_INPUT_HEIGHT_CHANGE, Constants.MessagePayloadKeys.FROM, "", "to", "isOrientationChanged", "", AvoidSoftInputView.ON_SOFT_INPUT_HIDDEN, AvoidSoftInputView.ON_SOFT_INPUT_SHOWN, "sendAppliedOffsetChangedEvent", "offset", "sendHeightChangedEvent", "height", "sendHiddenEvent", "sendShownEvent", "setAvoidOffset", "avoidOffset", "", "setEasing", "easing", "", "setHideAnimationDelay", "delay", "(Ljava/lang/Integer;)V", "setHideAnimationDuration", "duration", "setIsEnabled", "enabled", "setShowAnimationDelay", "setShowAnimationDuration", "Companion", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvoidSoftInputView extends ReactViewGroup implements SoftInputListener {
    public static final String NAME = "AvoidSoftInputView";
    public static final String ON_SOFT_INPUT_APPLIED_OFFSET_CHANGE = "onSoftInputAppliedOffsetChange";
    public static final String ON_SOFT_INPUT_HEIGHT_CHANGE = "onSoftInputHeightChange";
    public static final String ON_SOFT_INPUT_HIDDEN = "onSoftInputHidden";
    public static final String ON_SOFT_INPUT_SHOWN = "onSoftInputShown";
    private final AvoidSoftInputManager mManager;
    private final ThemedReactContext reactContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvoidSoftInputView(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        ReactApplicationContext reactApplicationContext = reactContext.getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        AvoidSoftInputManager avoidSoftInputManager = new AvoidSoftInputManager(reactApplicationContext);
        avoidSoftInputManager.setIsEnabled(true);
        avoidSoftInputManager.setRootView(this);
        avoidSoftInputManager.setOnOffsetChangedListener(new Function1<Integer, Unit>() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputView$mManager$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                AvoidSoftInputView.this.sendAppliedOffsetChangedEvent(i);
            }
        });
        avoidSoftInputManager.setOnSoftInputEventsListener(this);
        this.mManager = avoidSoftInputManager;
    }

    private final EventDispatcher getEventDispatcher() {
        return AvoidSoftInputUtilsKt.getEventDispatcher(this.reactContext, this);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mManager.initializeHandlers();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mManager.cleanupHandlers();
    }

    public final void setAvoidOffset(float avoidOffset) {
        this.mManager.setAvoidOffset(avoidOffset);
    }

    public final void setEasing(String easing) {
        this.mManager.setEasing(easing);
    }

    public final void setIsEnabled(boolean enabled) {
        this.mManager.setIsEnabled(enabled);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendAppliedOffsetChangedEvent(int offset) {
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new AvoidSoftInputAppliedOffsetChangedEvent(AvoidSoftInputUtilsKt.getSurfaceId(this.reactContext), getId(), offset));
        }
    }

    private final void sendHeightChangedEvent(int height) {
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new AvoidSoftInputHeightChangedEvent(AvoidSoftInputUtilsKt.getSurfaceId(this.reactContext), getId(), height));
        }
    }

    private final void sendHiddenEvent(int height) {
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new AvoidSoftInputHiddenEvent(AvoidSoftInputUtilsKt.getSurfaceId(this.reactContext), getId(), height));
        }
    }

    private final void sendShownEvent(int height) {
        EventDispatcher eventDispatcher = getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new AvoidSoftInputShownEvent(AvoidSoftInputUtilsKt.getSurfaceId(this.reactContext), getId(), height));
        }
    }
}
