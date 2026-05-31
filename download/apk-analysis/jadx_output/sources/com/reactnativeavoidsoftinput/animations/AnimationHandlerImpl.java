package com.reactnativeavoidsoftinput.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ScrollView;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.reactnativeavoidsoftinput.AvoidSoftInputModuleImpl;
import com.reactnativeavoidsoftinput.AvoidSoftInputUtilsKt;
import com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl;
import com.reactnativeavoidsoftinput.animations.AnimationInterpolator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationHandlerImpl.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 K2\u00020\u0001:\u0002KLB\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190#H\u0016J.\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190#H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J \u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0016J(\u0010,\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020 H\u0016J \u0010-\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020 H\u0002J \u0010.\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0016J(\u0010/\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020 H\u0016J\u0010\u00100\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0018\u00101\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u00102\u001a\u00020\u0006H\u0002J\u0018\u00103\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u00102\u001a\u00020\u0006H\u0002J\u001e\u00104\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190#H\u0016J&\u00105\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u00106\u001a\u00020\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190#H\u0016J(\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u0006H\u0016J\u0012\u0010?\u001a\u00020\u00192\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0017\u0010B\u001a\u00020\u00192\b\u0010C\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010DJ\u0017\u0010E\u001a\u00020\u00192\b\u0010F\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010DJ-\u0010G\u001a\u00020\u00192#\u0010H\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015H\u0016J\u0017\u0010I\u001a\u00020\u00192\b\u0010C\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010DJ\u0017\u0010J\u001a\u00020\u00192\b\u0010F\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010DR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/reactnativeavoidsoftinput/animations/AnimationHandlerImpl;", "Lcom/reactnativeavoidsoftinput/animations/AnimationHandler;", "()V", "mAnimationInterpolator", "Lcom/reactnativeavoidsoftinput/animations/AnimationInterpolator;", "mAvoidOffset", "", "mBottomOffset", "mHideAnimationDelay", "", "mHideAnimationDuration", "mHideValueAnimator", "Landroid/animation/ValueAnimator;", "mInitialScrollViewBottomPadding", "", "mIsHideAnimationCancelled", "", "mIsHideAnimationRunning", "mIsShowAnimationCancelled", "mIsShowAnimationRunning", "mOnOffsetChangedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offset", "", "mShowAnimationDelay", "mShowAnimationDuration", "mShowValueAnimator", "addOffsetInRootView", "to", "rootView", "Landroid/view/View;", "focusedView", "onOffsetAnimationEnd", "Lkotlin/Function0;", "addOffsetInScrollView", AvoidSoftInputModuleImpl.SOFT_INPUT_HEIGHT_KEY, "scrollView", "Landroid/widget/ScrollView;", "currentFocusedView", "clearOffsets", "decreaseOffsetInRootView", Constants.MessagePayloadKeys.FROM, "decreaseOffsetInScrollView", "getScrollToOffset", "increaseOffsetInRootView", "increaseOffsetInScrollView", "onOffsetChanged", "onRootViewAnimationUpdate", "animatedOffset", "onScrollViewAnimationUpdate", "removeOffsetInRootView", "removeOffsetInScrollView", "initialScrollValue", "runAnimator", "isShowAnimation", "animationStart", "animationEnd", "onAnimatorEventListener", "Lcom/reactnativeavoidsoftinput/animations/AnimationHandlerImpl$OnAnimatorEventListener;", "setAvoidOffset", "avoidOffset", "setEasing", "easing", "", "setHideAnimationDelay", "delay", "(Ljava/lang/Integer;)V", "setHideAnimationDuration", "duration", "setOnOffsetChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setShowAnimationDelay", "setShowAnimationDuration", "Companion", "OnAnimatorEventListener", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnimationHandlerImpl implements AnimationHandler {
    private static final long DECREASE_PADDING_DURATION_IN_MS = 220;
    private static final long INCREASE_PADDING_DURATION_IN_MS = 660;
    private float mAvoidOffset;
    private float mBottomOffset;
    private long mHideAnimationDelay;
    private ValueAnimator mHideValueAnimator;
    private int mInitialScrollViewBottomPadding;
    private boolean mIsHideAnimationCancelled;
    private boolean mIsHideAnimationRunning;
    private boolean mIsShowAnimationCancelled;
    private boolean mIsShowAnimationRunning;
    private Function1<? super Integer, Unit> mOnOffsetChangedListener;
    private long mShowAnimationDelay;
    private ValueAnimator mShowValueAnimator;
    private AnimationInterpolator mAnimationInterpolator = new AnimationInterpolator();
    private long mHideAnimationDuration = DECREASE_PADDING_DURATION_IN_MS;
    private long mShowAnimationDuration = INCREASE_PADDING_DURATION_IN_MS;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimationHandlerImpl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/reactnativeavoidsoftinput/animations/AnimationHandlerImpl$OnAnimatorEventListener;", "", "onBeforeStart", "", "onCancel", "onEnd", "onUpdate", "animatedValue", "", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    interface OnAnimatorEventListener {

        /* compiled from: AnimationHandlerImpl.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onBeforeStart(OnAnimatorEventListener onAnimatorEventListener) {
            }

            public static void onCancel(OnAnimatorEventListener onAnimatorEventListener) {
            }

            public static void onEnd(OnAnimatorEventListener onAnimatorEventListener) {
            }

            public static void onUpdate(OnAnimatorEventListener onAnimatorEventListener, float f) {
            }
        }

        void onBeforeStart();

        void onCancel();

        void onEnd();

        void onUpdate(float animatedValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onOffsetChanged(int offset) {
        Function1<? super Integer, Unit> function1 = this.mOnOffsetChangedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(offset));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRootViewAnimationUpdate(View rootView, float animatedOffset) {
        onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP((int) animatedOffset));
        rootView.setTranslationY(-animatedOffset);
    }

    private final int getScrollToOffset(int softInputHeight, ScrollView scrollView, View currentFocusedView) {
        int[] iArr = new int[2];
        scrollView.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        currentFocusedView.getLocationOnScreen(iArr2);
        return Math.min(Math.max(softInputHeight - AvoidSoftInputUtilsKt.getViewDistanceToBottomEdge(currentFocusedView), 0), Math.max(iArr2[1] - iArr[1], 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScrollViewAnimationUpdate(ScrollView scrollView, float animatedOffset) {
        int i = (int) animatedOffset;
        onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP(i));
        scrollView.setPadding(scrollView.getPaddingLeft(), scrollView.getPaddingTop(), scrollView.getPaddingRight(), this.mInitialScrollViewBottomPadding + i);
    }

    private final void runAnimator(final boolean isShowAnimation, final float animationStart, final float animationEnd, final OnAnimatorEventListener onAnimatorEventListener) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AnimationHandlerImpl.runAnimator$lambda$3(AnimationHandlerImpl.this, isShowAnimation, onAnimatorEventListener, animationStart, animationEnd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runAnimator$lambda$3(final AnimationHandlerImpl this$0, final boolean z, final OnAnimatorEventListener onAnimatorEventListener, float f, float f2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onAnimatorEventListener, "$onAnimatorEventListener");
        this$0.mIsHideAnimationCancelled = z;
        this$0.mIsShowAnimationCancelled = !z;
        if (z) {
            ValueAnimator valueAnimator = this$0.mHideValueAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        } else {
            ValueAnimator valueAnimator2 = this$0.mShowValueAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
        }
        onAnimatorEventListener.onBeforeStart();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(z ? this$0.mShowAnimationDuration : this$0.mHideAnimationDuration);
        ofFloat.setStartDelay(z ? this$0.mShowAnimationDelay : this$0.mHideAnimationDelay);
        ofFloat.setInterpolator(this$0.mAnimationInterpolator);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$runAnimator$1$animator$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                boolean z2;
                boolean z3;
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                if (z) {
                    this$0.mIsShowAnimationRunning = false;
                    this$0.mShowValueAnimator = null;
                    z3 = this$0.mIsShowAnimationCancelled;
                    if (z3) {
                        onAnimatorEventListener.onCancel();
                        return;
                    } else {
                        onAnimatorEventListener.onEnd();
                        return;
                    }
                }
                this$0.mIsHideAnimationRunning = false;
                this$0.mHideValueAnimator = null;
                z2 = this$0.mIsHideAnimationCancelled;
                if (z2) {
                    onAnimatorEventListener.onCancel();
                } else {
                    onAnimatorEventListener.onEnd();
                }
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                AnimationHandlerImpl.runAnimator$lambda$3$lambda$2$lambda$1(AnimationHandlerImpl.OnAnimatorEventListener.this, valueAnimator3);
            }
        });
        ofFloat.start();
        if (z) {
            this$0.mShowValueAnimator = ofFloat;
        } else {
            this$0.mHideValueAnimator = ofFloat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runAnimator$lambda$3$lambda$2$lambda$1(OnAnimatorEventListener onAnimatorEventListener, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(onAnimatorEventListener, "$onAnimatorEventListener");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        onAnimatorEventListener.onUpdate(((Float) animatedValue).floatValue());
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void decreaseOffsetInRootView(int from, int to, final View rootView) {
        final float f;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mIsHideAnimationRunning = true;
        float f2 = to - from;
        if (this.mIsShowAnimationRunning) {
            f = this.mBottomOffset;
        } else {
            f = f2 + this.mBottomOffset;
        }
        runAnimator(false, this.mBottomOffset, f, new OnAnimatorEventListener() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$decreaseOffsetInRootView$1
            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onBeforeStart() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onBeforeStart(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onCancel() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onCancel(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onEnd() {
                AnimationHandlerImpl.this.onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP((int) f));
                AnimationHandlerImpl.this.mBottomOffset = f;
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onUpdate(float animatedValue) {
                AnimationHandlerImpl.this.onRootViewAnimationUpdate(rootView, animatedValue);
            }
        });
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void increaseOffsetInRootView(int from, int to, final View rootView) {
        final float f;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mIsShowAnimationRunning = true;
        float f2 = to - from;
        if (this.mIsHideAnimationRunning) {
            f = this.mBottomOffset;
        } else {
            f = f2 + this.mBottomOffset;
        }
        runAnimator(true, this.mBottomOffset, f, new OnAnimatorEventListener() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$increaseOffsetInRootView$1
            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onBeforeStart() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onBeforeStart(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onCancel() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onCancel(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onEnd() {
                AnimationHandlerImpl.this.onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP((int) f));
                AnimationHandlerImpl.this.mBottomOffset = f;
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onUpdate(float animatedValue) {
                AnimationHandlerImpl.this.onRootViewAnimationUpdate(rootView, animatedValue);
            }
        });
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void removeOffsetInRootView(final View rootView, final Function0<Unit> onOffsetAnimationEnd) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(onOffsetAnimationEnd, "onOffsetAnimationEnd");
        this.mIsHideAnimationRunning = true;
        runAnimator(false, this.mBottomOffset, 0.0f, new OnAnimatorEventListener() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$removeOffsetInRootView$1
            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onCancel() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onCancel(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onBeforeStart() {
                float f;
                AnimationHandlerImpl animationHandlerImpl = AnimationHandlerImpl.this;
                f = animationHandlerImpl.mBottomOffset;
                animationHandlerImpl.onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP((int) f));
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onEnd() {
                AnimationHandlerImpl.this.onOffsetChanged(0);
                AnimationHandlerImpl.this.mBottomOffset = 0.0f;
                onOffsetAnimationEnd.invoke();
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onUpdate(float animatedValue) {
                AnimationHandlerImpl.this.onRootViewAnimationUpdate(rootView, animatedValue);
            }
        });
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void addOffsetInRootView(int to, final View rootView, View focusedView, final Function0<Unit> onOffsetAnimationEnd) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(focusedView, "focusedView");
        Intrinsics.checkNotNullParameter(onOffsetAnimationEnd, "onOffsetAnimationEnd");
        this.mIsShowAnimationRunning = true;
        float max = Math.max(to - AvoidSoftInputUtilsKt.getViewDistanceToBottomEdge(focusedView), 0) + this.mAvoidOffset;
        this.mBottomOffset = max;
        if (max <= 0.0f) {
            return;
        }
        runAnimator(true, 0.0f, max, new OnAnimatorEventListener() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$addOffsetInRootView$1
            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onCancel() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onCancel(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onBeforeStart() {
                AnimationHandlerImpl.this.onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP(0));
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onEnd() {
                float f;
                AnimationHandlerImpl animationHandlerImpl = AnimationHandlerImpl.this;
                f = animationHandlerImpl.mBottomOffset;
                animationHandlerImpl.onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP((int) f));
                onOffsetAnimationEnd.invoke();
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onUpdate(float animatedValue) {
                AnimationHandlerImpl.this.onRootViewAnimationUpdate(rootView, animatedValue);
            }
        });
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void decreaseOffsetInScrollView(int from, int to, final ScrollView scrollView, View focusedView) {
        final float f;
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(focusedView, "focusedView");
        this.mIsHideAnimationRunning = true;
        float f2 = to - from;
        if (this.mIsShowAnimationRunning) {
            f = this.mBottomOffset;
        } else {
            f = f2 + this.mBottomOffset;
        }
        final int scrollToOffset = getScrollToOffset(to, scrollView, focusedView);
        runAnimator(false, this.mBottomOffset, f, new OnAnimatorEventListener() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$decreaseOffsetInScrollView$1
            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onBeforeStart() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onBeforeStart(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onCancel() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onCancel(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onEnd() {
                AnimationHandlerImpl.this.onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP((int) f));
                ScrollView scrollView2 = scrollView;
                scrollView2.smoothScrollTo(0, scrollView2.getScrollY() + scrollToOffset);
                AnimationHandlerImpl.this.mBottomOffset = f;
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onUpdate(float animatedValue) {
                AnimationHandlerImpl.this.onScrollViewAnimationUpdate(scrollView, animatedValue);
            }
        });
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void increaseOffsetInScrollView(int from, int to, final ScrollView scrollView, View currentFocusedView) {
        final float f;
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(currentFocusedView, "currentFocusedView");
        this.mIsShowAnimationRunning = true;
        float f2 = to - from;
        if (this.mIsHideAnimationRunning) {
            f = this.mBottomOffset;
        } else {
            f = f2 + this.mBottomOffset;
        }
        final int scrollToOffset = getScrollToOffset(to, scrollView, currentFocusedView);
        runAnimator(true, this.mBottomOffset, f, new OnAnimatorEventListener() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$increaseOffsetInScrollView$1
            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onBeforeStart() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onBeforeStart(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onCancel() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onCancel(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onEnd() {
                AnimationHandlerImpl.this.onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP((int) f));
                ScrollView scrollView2 = scrollView;
                scrollView2.smoothScrollTo(0, scrollView2.getScrollY() + scrollToOffset);
                AnimationHandlerImpl.this.mBottomOffset = f;
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onUpdate(float animatedValue) {
                AnimationHandlerImpl.this.onScrollViewAnimationUpdate(scrollView, animatedValue);
            }
        });
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void removeOffsetInScrollView(final ScrollView scrollView, final int initialScrollValue, final Function0<Unit> onOffsetAnimationEnd) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(onOffsetAnimationEnd, "onOffsetAnimationEnd");
        this.mIsHideAnimationRunning = true;
        runAnimator(false, this.mBottomOffset, 0.0f, new OnAnimatorEventListener() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$removeOffsetInScrollView$1
            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onBeforeStart() {
                float f;
                AnimationHandlerImpl animationHandlerImpl = AnimationHandlerImpl.this;
                f = animationHandlerImpl.mBottomOffset;
                animationHandlerImpl.onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP((int) f));
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onCancel() {
                AnimationHandlerImpl.this.onScrollViewAnimationUpdate(scrollView, 0.0f);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onEnd() {
                AnimationHandlerImpl.this.onOffsetChanged(0);
                AnimationHandlerImpl.this.mInitialScrollViewBottomPadding = 0;
                AnimationHandlerImpl.this.mBottomOffset = 0.0f;
                scrollView.smoothScrollTo(0, initialScrollValue);
                onOffsetAnimationEnd.invoke();
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onUpdate(float animatedValue) {
                AnimationHandlerImpl.this.onScrollViewAnimationUpdate(scrollView, animatedValue);
            }
        });
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void addOffsetInScrollView(int softInputHeight, final ScrollView scrollView, View currentFocusedView, final Function0<Unit> onOffsetAnimationEnd) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(currentFocusedView, "currentFocusedView");
        Intrinsics.checkNotNullParameter(onOffsetAnimationEnd, "onOffsetAnimationEnd");
        this.mIsShowAnimationRunning = true;
        this.mBottomOffset = Math.max(softInputHeight - AvoidSoftInputUtilsKt.getViewDistanceToBottomEdge(scrollView), 0) + this.mAvoidOffset;
        final int scrollToOffset = getScrollToOffset(softInputHeight, scrollView, currentFocusedView);
        float f = this.mBottomOffset;
        if (f <= 0.0f) {
            return;
        }
        runAnimator(true, 0.0f, f, new OnAnimatorEventListener() { // from class: com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl$addOffsetInScrollView$1
            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onCancel() {
                AnimationHandlerImpl.OnAnimatorEventListener.DefaultImpls.onCancel(this);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onBeforeStart() {
                AnimationHandlerImpl.this.onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP(0));
                AnimationHandlerImpl.this.mInitialScrollViewBottomPadding = scrollView.getPaddingBottom();
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onEnd() {
                float f2;
                AnimationHandlerImpl animationHandlerImpl = AnimationHandlerImpl.this;
                f2 = animationHandlerImpl.mBottomOffset;
                animationHandlerImpl.onOffsetChanged(AvoidSoftInputUtilsKt.convertFromPixelToDIP((int) f2));
                onOffsetAnimationEnd.invoke();
                ScrollView scrollView2 = scrollView;
                scrollView2.smoothScrollTo(0, scrollView2.getScrollY() + scrollToOffset);
            }

            @Override // com.reactnativeavoidsoftinput.animations.AnimationHandlerImpl.OnAnimatorEventListener
            public void onUpdate(float animatedValue) {
                AnimationHandlerImpl.this.onScrollViewAnimationUpdate(scrollView, animatedValue);
            }
        });
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setAvoidOffset(float avoidOffset) {
        this.mAvoidOffset = PixelUtil.toPixelFromDIP(avoidOffset);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setEasing(String easing) {
        AnimationInterpolator.Companion.MODE mode;
        AnimationInterpolator animationInterpolator = this.mAnimationInterpolator;
        if (easing != null) {
            int hashCode = easing.hashCode();
            if (hashCode != -1965087616) {
                if (hashCode != -1310316109) {
                    if (hashCode == 1330629787 && easing.equals("easeInOut")) {
                        mode = AnimationInterpolator.Companion.MODE.EASE_IN_OUT;
                    }
                } else if (easing.equals("easeIn")) {
                    mode = AnimationInterpolator.Companion.MODE.EASE_IN;
                }
            } else if (easing.equals("easeOut")) {
                mode = AnimationInterpolator.Companion.MODE.EASE_OUT;
            }
            animationInterpolator.setMode(mode);
        }
        mode = AnimationInterpolator.Companion.MODE.LINEAR;
        animationInterpolator.setMode(mode);
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setHideAnimationDelay(Integer delay) {
        this.mHideAnimationDelay = delay != null ? delay.intValue() : 0L;
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setHideAnimationDuration(Integer duration) {
        this.mHideAnimationDuration = duration != null ? duration.intValue() : DECREASE_PADDING_DURATION_IN_MS;
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setOnOffsetChangedListener(Function1<? super Integer, Unit> listener) {
        this.mOnOffsetChangedListener = listener;
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setShowAnimationDelay(Integer delay) {
        this.mShowAnimationDelay = delay != null ? delay.intValue() : 0L;
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void setShowAnimationDuration(Integer duration) {
        this.mShowAnimationDuration = duration != null ? duration.intValue() : INCREASE_PADDING_DURATION_IN_MS;
    }

    @Override // com.reactnativeavoidsoftinput.animations.AnimationHandler
    public void clearOffsets() {
        this.mBottomOffset = 0.0f;
        this.mInitialScrollViewBottomPadding = 0;
    }
}
