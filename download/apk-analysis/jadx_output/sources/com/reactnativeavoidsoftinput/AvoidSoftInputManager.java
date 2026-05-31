package com.reactnativeavoidsoftinput;

import android.app.Activity;
import android.view.View;
import android.widget.ScrollView;
import androidx.core.view.WindowCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.RootView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.reactnativeavoidsoftinput.animations.AnimationHandler;
import com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl;
import com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener;
import com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListenerImpl;
import com.reactnativeavoidsoftinput.listeners.SoftInputListener;
import com.reactnativeavoidsoftinput.listeners.WindowInsetsListener;
import com.reactnativeavoidsoftinput.listeners.WindowInsetsListenerImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvoidSoftInputManager.kt */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0015\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J/\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0%H\u0096\u0001J/\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0%H\u0096\u0001J\u0006\u0010)\u001a\u00020 J\t\u0010*\u001a\u00020 H\u0096\u0001J!\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\bH\u0096\u0001J)\u0010-\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\bH\u0096\u0001J\u0018\u0010.\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000fH\u0002J!\u0010/\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\bH\u0096\u0001J)\u00100\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0006\u00101\u001a\u00020 J\u001c\u00102\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u00010\b2\b\u00104\u001a\u0004\u0018\u00010\bH\u0002J\u0011\u00105\u001a\u00020 2\u0006\u0010\"\u001a\u00020\bH\u0096\u0001J\u0011\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\bH\u0096\u0001J\u001f\u00108\u001a\u00020 2\u0006\u0010\"\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0%H\u0096\u0001J'\u00109\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u000f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0%H\u0096\u0001J\u0011\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020=H\u0096\u0001J\u0013\u0010>\u001a\u00020 2\b\u0010?\u001a\u0004\u0018\u00010@H\u0096\u0001J\u0018\u0010A\u001a\u00020 2\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0002\u0010CJ\u0018\u0010D\u001a\u00020 2\b\u0010E\u001a\u0004\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0002\u0010CJ\u000e\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020\fJ(\u0010H\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J(\u0010I\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J(\u0010J\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0019H\u0002JG\u0010K\u001a\u00020 2<\u0010L\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(3\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020 \u0018\u00010MH\u0096\u0001J.\u0010P\u001a\u00020 2#\u0010L\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020 \u0018\u00010QH\u0096\u0001J\u0010\u0010S\u001a\u00020 2\b\u0010L\u001a\u0004\u0018\u00010\u0013J\u0010\u0010T\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\bJ\u0010\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\fH\u0002J\u000e\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020\fJ\u0018\u0010Y\u001a\u00020 2\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0002\u0010CJ\u0018\u0010Z\u001a\u00020 2\b\u0010E\u001a\u0004\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0002\u0010CJ\u0013\u0010[\u001a\u00020 2\b\u0010L\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u0011\u0010\\\u001a\u00020 2\u0006\u0010\"\u001a\u00020\bH\u0096\u0001J\u0011\u0010]\u001a\u00020 2\u0006\u00107\u001a\u00020\bH\u0096\u0001R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/reactnativeavoidsoftinput/AvoidSoftInputManager;", "Lcom/reactnativeavoidsoftinput/listeners/WindowInsetsListener;", "Lcom/reactnativeavoidsoftinput/listeners/FocusedViewChangeListener;", "Lcom/reactnativeavoidsoftinput/animations/AnimationHandler;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "currentFocusedView", "Landroid/view/View;", "getCurrentFocusedView", "()Landroid/view/View;", "isCustomRootView", "", "()Z", "mCompleteSoftInputHeight", "", "mIsEnabled", "mIsInitialized", "mOnSoftInputEventsListener", "Lcom/reactnativeavoidsoftinput/listeners/SoftInputListener;", "mOnSoftInputListener", "com/reactnativeavoidsoftinput/AvoidSoftInputManager$mOnSoftInputListener$1", "Lcom/reactnativeavoidsoftinput/AvoidSoftInputManager$mOnSoftInputListener$1;", "mPreviousRootView", "mPreviousScrollView", "Landroid/widget/ScrollView;", "mRootView", "mScrollY", "mSoftInputVisible", "previousFocusedView", "getPreviousFocusedView", "addOffsetInRootView", "", "to", "rootView", "focusedView", "onOffsetAnimationEnd", "Lkotlin/Function0;", "addOffsetInScrollView", AvoidSoftInputModuleImpl.SOFT_INPUT_HEIGHT_KEY, "scrollView", "cleanupHandlers", "clearOffsets", "decreaseOffsetInRootView", Constants.MessagePayloadKeys.FROM, "decreaseOffsetInScrollView", "handleSoftInputHeightChange", "increaseOffsetInRootView", "increaseOffsetInScrollView", "initializeHandlers", "onFocus", "oldView", "newView", "registerFocusedViewChangeListener", "registerWindowInsetsListener", ViewHierarchyConstants.VIEW_KEY, "removeOffsetInRootView", "removeOffsetInScrollView", "initialScrollValue", "setAvoidOffset", "avoidOffset", "", "setEasing", "easing", "", "setHideAnimationDelay", "delay", "(Ljava/lang/Integer;)V", "setHideAnimationDuration", "duration", "setIsEnabled", "isEnabled", "setOffset", "setOffsetInRootView", "setOffsetInScrollView", "setOnFocusListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "setOnOffsetChangedListener", "Lkotlin/Function1;", "offset", "setOnSoftInputEventsListener", "setRootView", "setShouldHandleInsets", "shouldHandle", "setShouldMimicIOSBehavior", "shouldMimic", "setShowAnimationDelay", "setShowAnimationDuration", "setSoftInputListener", "unregisterFocusedViewChangeListener", "unregisterWindowInsetsListener", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvoidSoftInputManager implements WindowInsetsListener, FocusedViewChangeListener, AnimationHandler {
    private final /* synthetic */ WindowInsetsListenerImpl $$delegate_0;
    private final /* synthetic */ FocusedViewChangeListenerImpl $$delegate_1;
    private final /* synthetic */ AnimationHandlerImpl $$delegate_2;
    private int mCompleteSoftInputHeight;
    private boolean mIsEnabled;
    private boolean mIsInitialized;
    private SoftInputListener mOnSoftInputEventsListener;
    private final AvoidSoftInputManager$mOnSoftInputListener$1 mOnSoftInputListener;
    private View mPreviousRootView;
    private ScrollView mPreviousScrollView;
    private View mRootView;
    private int mScrollY;
    private boolean mSoftInputVisible;
    private final ReactApplicationContext reactContext;

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void addOffsetInRootView(int to, View rootView, View focusedView, Function0<Unit> onOffsetAnimationEnd) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(focusedView, "focusedView");
        Intrinsics.checkNotNullParameter(onOffsetAnimationEnd, "onOffsetAnimationEnd");
        this.$$delegate_2.addOffsetInRootView(to, rootView, focusedView, onOffsetAnimationEnd);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void addOffsetInScrollView(int softInputHeight, ScrollView scrollView, View currentFocusedView, Function0<Unit> onOffsetAnimationEnd) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(currentFocusedView, "currentFocusedView");
        Intrinsics.checkNotNullParameter(onOffsetAnimationEnd, "onOffsetAnimationEnd");
        this.$$delegate_2.addOffsetInScrollView(softInputHeight, scrollView, currentFocusedView, onOffsetAnimationEnd);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void clearOffsets() {
        this.$$delegate_2.clearOffsets();
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void decreaseOffsetInRootView(int from, int to, View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.$$delegate_2.decreaseOffsetInRootView(from, to, rootView);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void decreaseOffsetInScrollView(int from, int to, ScrollView scrollView, View focusedView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(focusedView, "focusedView");
        this.$$delegate_2.decreaseOffsetInScrollView(from, to, scrollView, focusedView);
    }

    @Override // com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener
    /* renamed from: getCurrentFocusedView */
    public View getMCurrentFocusedView() {
        return this.$$delegate_1.getMCurrentFocusedView();
    }

    @Override // com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener
    /* renamed from: getPreviousFocusedView */
    public View getMPreviousFocusedView() {
        return this.$$delegate_1.getMPreviousFocusedView();
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void increaseOffsetInRootView(int from, int to, View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.$$delegate_2.increaseOffsetInRootView(from, to, rootView);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void increaseOffsetInScrollView(int from, int to, ScrollView scrollView, View currentFocusedView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(currentFocusedView, "currentFocusedView");
        this.$$delegate_2.increaseOffsetInScrollView(from, to, scrollView, currentFocusedView);
    }

    @Override // com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener
    public void registerFocusedViewChangeListener(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.$$delegate_1.registerFocusedViewChangeListener(rootView);
    }

    @Override // com.reactnativeavoidsoftinput.listeners.WindowInsetsListener
    public void registerWindowInsetsListener(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.registerWindowInsetsListener(view);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void removeOffsetInRootView(View rootView, Function0<Unit> onOffsetAnimationEnd) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(onOffsetAnimationEnd, "onOffsetAnimationEnd");
        this.$$delegate_2.removeOffsetInRootView(rootView, onOffsetAnimationEnd);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void removeOffsetInScrollView(ScrollView scrollView, int initialScrollValue, Function0<Unit> onOffsetAnimationEnd) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(onOffsetAnimationEnd, "onOffsetAnimationEnd");
        this.$$delegate_2.removeOffsetInScrollView(scrollView, initialScrollValue, onOffsetAnimationEnd);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setAvoidOffset(float avoidOffset) {
        this.$$delegate_2.setAvoidOffset(avoidOffset);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setEasing(String easing) {
        this.$$delegate_2.setEasing(easing);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setHideAnimationDelay(Integer delay) {
        this.$$delegate_2.setHideAnimationDelay(delay);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setHideAnimationDuration(Integer duration) {
        this.$$delegate_2.setHideAnimationDuration(duration);
    }

    @Override // com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener
    public void setOnFocusListener(Function2<? super View, ? super View, Unit> listener) {
        this.$$delegate_1.setOnFocusListener(listener);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setOnOffsetChangedListener(Function1<? super Integer, Unit> listener) {
        this.$$delegate_2.setOnOffsetChangedListener(listener);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setShowAnimationDelay(Integer delay) {
        this.$$delegate_2.setShowAnimationDelay(delay);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setShowAnimationDuration(Integer duration) {
        this.$$delegate_2.setShowAnimationDuration(duration);
    }

    @Override // com.reactnativeavoidsoftinput.listeners.WindowInsetsListener
    public void setSoftInputListener(SoftInputListener listener) {
        this.$$delegate_0.setSoftInputListener(listener);
    }

    @Override // com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener
    public void unregisterFocusedViewChangeListener(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.$$delegate_1.unregisterFocusedViewChangeListener(rootView);
    }

    @Override // com.reactnativeavoidsoftinput.listeners.WindowInsetsListener
    public void unregisterWindowInsetsListener(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.unregisterWindowInsetsListener(view);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.reactnativeavoidsoftinput.AvoidSoftInputManager$mOnSoftInputListener$1] */
    public AvoidSoftInputManager(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.$$delegate_0 = new WindowInsetsListenerImpl();
        this.$$delegate_1 = new FocusedViewChangeListenerImpl();
        this.$$delegate_2 = new AnimationHandlerImpl();
        this.mIsEnabled = true;
        this.mOnSoftInputListener = new SoftInputListener() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputManager$mOnSoftInputListener$1
            @Override // com.reactnativeavoidsoftinput.listeners.SoftInputListener
            public void onSoftInputHeightChange(int from, int to, boolean isOrientationChanged) {
                SoftInputListener softInputListener;
                softInputListener = AvoidSoftInputManager.this.mOnSoftInputEventsListener;
                if (softInputListener != null) {
                    softInputListener.onSoftInputHeightChange(from, to, isOrientationChanged);
                }
                AvoidSoftInputManager.this.handleSoftInputHeightChange(from, to);
            }

            @Override // com.reactnativeavoidsoftinput.listeners.SoftInputListener
            public void onSoftInputHidden(int from, int to) {
                SoftInputListener softInputListener;
                softInputListener = AvoidSoftInputManager.this.mOnSoftInputEventsListener;
                if (softInputListener != null) {
                    softInputListener.onSoftInputHidden(from, to);
                }
            }

            @Override // com.reactnativeavoidsoftinput.listeners.SoftInputListener
            public void onSoftInputShown(int from, int to) {
                SoftInputListener softInputListener;
                softInputListener = AvoidSoftInputManager.this.mOnSoftInputEventsListener;
                if (softInputListener != null) {
                    softInputListener.onSoftInputShown(from, to);
                }
            }
        };
    }

    private final boolean isCustomRootView() {
        return this.mRootView instanceof AvoidSoftInputView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFocus(View oldView, View newView) {
        ScrollView scrollViewParent;
        if (this.mIsEnabled) {
            Object nearestParentReactRootView = AvoidSoftInputUtilsKt.getNearestParentReactRootView(newView);
            if (!(nearestParentReactRootView instanceof View) || newView == null || (scrollViewParent = AvoidSoftInputUtilsKt.getScrollViewParent(newView, (View) nearestParentReactRootView)) == null) {
                return;
            }
            this.mScrollY = scrollViewParent.getScrollY();
            if (this.mSoftInputVisible) {
                AvoidSoftInputUtilsKt.setScrollListenerCompat(scrollViewParent, new Function1<Integer, Unit>() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputManager$onFocus$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i) {
                        if (AvoidSoftInputManager.this.getMCurrentFocusedView() != null) {
                            AvoidSoftInputManager.this.mScrollY = i;
                        }
                    }
                });
                scrollViewParent.smoothScrollTo(0, scrollViewParent.getScrollY() + Math.max(this.mCompleteSoftInputHeight - AvoidSoftInputUtilsKt.getViewDistanceToBottomEdge(newView), 0));
            }
        }
    }

    private final void setShouldHandleInsets(boolean shouldHandle) {
        final Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        final boolean z = !shouldHandle;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AvoidSoftInputManager.setShouldHandleInsets$lambda$0(currentActivity, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setShouldHandleInsets$lambda$0(Activity activity, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), z);
    }

    public final void cleanupHandlers() {
        if (this.mIsInitialized) {
            setSoftInputListener(null);
            View view = this.mRootView;
            if (view != null) {
                unregisterWindowInsetsListener(view);
            }
            setOnFocusListener(null);
            View view2 = this.mRootView;
            if (view2 != null) {
                unregisterFocusedViewChangeListener(view2);
            }
            this.mIsInitialized = false;
        }
    }

    public final void initializeHandlers() {
        if (this.mIsInitialized) {
            return;
        }
        setSoftInputListener(this.mOnSoftInputListener);
        View view = this.mRootView;
        if (view != null) {
            registerWindowInsetsListener(view);
        }
        setOnFocusListener(new AvoidSoftInputManager$initializeHandlers$2(this));
        View view2 = this.mRootView;
        if (view2 != null) {
            registerFocusedViewChangeListener(view2);
        }
        this.mIsInitialized = true;
    }

    public final void setRootView(View rootView) {
        this.mRootView = rootView;
    }

    public final void setIsEnabled(boolean isEnabled) {
        this.mIsEnabled = isEnabled;
    }

    public final void setShouldMimicIOSBehavior(boolean shouldMimic) {
        setShouldHandleInsets(shouldMimic);
    }

    public final void setOnSoftInputEventsListener(SoftInputListener listener) {
        this.mOnSoftInputEventsListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void handleSoftInputHeightChange(int from, int to) {
        this.mCompleteSoftInputHeight = to;
        View mCurrentFocusedView = getMCurrentFocusedView();
        if (mCurrentFocusedView == null) {
            mCurrentFocusedView = getMPreviousFocusedView();
        }
        if (mCurrentFocusedView == null) {
            if (this.mSoftInputVisible && to == 0) {
                clearOffsets();
                this.mScrollY = 0;
                this.mPreviousRootView = null;
                this.mPreviousScrollView = null;
                this.mSoftInputVisible = false;
                return;
            }
            return;
        }
        if (isCustomRootView()) {
            View view = this.mRootView;
            Intrinsics.checkNotNull(view);
            setOffset(from, to, mCurrentFocusedView, view);
            return;
        }
        RootView nearestParentReactRootView = AvoidSoftInputUtilsKt.getNearestParentReactRootView(mCurrentFocusedView);
        RootView rootView = nearestParentReactRootView;
        if (nearestParentReactRootView == null) {
            rootView = (RootView) this.mPreviousRootView;
        }
        if (!(rootView instanceof View) || AvoidSoftInputUtilsKt.checkIfNestedInAvoidSoftInputView(mCurrentFocusedView, rootView)) {
            return;
        }
        setOffset(from, to, mCurrentFocusedView, (View) rootView);
    }

    private final void setOffset(int from, int to, View focusedView, View rootView) {
        ScrollView scrollViewParent = AvoidSoftInputUtilsKt.getScrollViewParent(focusedView, rootView);
        if (scrollViewParent == null) {
            scrollViewParent = this.mPreviousScrollView;
        }
        if (scrollViewParent != null) {
            AvoidSoftInputUtilsKt.setScrollListenerCompat(scrollViewParent, new Function1<Integer, Unit>() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputManager$setOffset$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    if (AvoidSoftInputManager.this.getMCurrentFocusedView() != null) {
                        AvoidSoftInputManager.this.mScrollY = i;
                    }
                }
            });
            setOffsetInScrollView(from, to, focusedView, scrollViewParent);
        } else {
            setOffsetInRootView(from, to, focusedView, rootView);
        }
    }

    private final void setOffsetInRootView(int from, int to, View focusedView, final View rootView) {
        if (to == from) {
            return;
        }
        if (to == 0) {
            removeOffsetInRootView(rootView, new Function0<Unit>() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputManager$setOffsetInRootView$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AvoidSoftInputManager.this.mPreviousRootView = null;
                    AvoidSoftInputManager.this.mSoftInputVisible = false;
                }
            });
            return;
        }
        int i = to - from;
        if (i > 0 && (!this.mSoftInputVisible || from == 0)) {
            if (this.mIsEnabled) {
                addOffsetInRootView(to, rootView, focusedView, new Function0<Unit>() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputManager$setOffsetInRootView$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        AvoidSoftInputManager.this.mPreviousRootView = rootView;
                        AvoidSoftInputManager.this.mSoftInputVisible = true;
                    }
                });
            }
        } else if (i > 0) {
            if (this.mIsEnabled) {
                increaseOffsetInRootView(from, to, rootView);
            }
        } else {
            if (i >= 0 || !this.mIsEnabled) {
                return;
            }
            decreaseOffsetInRootView(from, to, rootView);
        }
    }

    private final void setOffsetInScrollView(int from, int to, View focusedView, final ScrollView scrollView) {
        if (to == from) {
            return;
        }
        if (to == 0) {
            removeOffsetInScrollView(scrollView, this.mScrollY, new Function0<Unit>() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputManager$setOffsetInScrollView$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AvoidSoftInputManager.this.mScrollY = 0;
                    AvoidSoftInputManager.this.mPreviousScrollView = null;
                    AvoidSoftInputManager.this.mSoftInputVisible = false;
                }
            });
            return;
        }
        int i = to - from;
        if (i > 0 && (!this.mSoftInputVisible || from == 0)) {
            if (this.mIsEnabled) {
                addOffsetInScrollView(to, scrollView, focusedView, new Function0<Unit>() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputManager$setOffsetInScrollView$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        AvoidSoftInputManager.this.mScrollY = scrollView.getScrollY();
                        AvoidSoftInputManager.this.mPreviousScrollView = scrollView;
                        AvoidSoftInputManager.this.mSoftInputVisible = true;
                    }
                });
            }
        } else if (i > 0) {
            if (this.mIsEnabled) {
                increaseOffsetInScrollView(from, to, scrollView, focusedView);
            }
        } else {
            if (i >= 0 || !this.mIsEnabled) {
                return;
            }
            decreaseOffsetInScrollView(from, to, scrollView, focusedView);
        }
    }
}
