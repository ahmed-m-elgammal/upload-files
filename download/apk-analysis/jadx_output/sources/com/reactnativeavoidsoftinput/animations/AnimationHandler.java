package com.reactnativeavoidsoftinput.animations;

import android.view.View;
import android.widget.ScrollView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.reactnativeavoidsoftinput.AvoidSoftInputModuleImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: AnimationHandler.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J.\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J\b\u0010\u0010\u001a\u00020\u0003H&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H&J\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J&\u0010\u0017\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0017\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010!J-\u0010$\u001a\u00020\u00032#\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0003\u0018\u00010&H&J\u0017\u0010*\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010!J\u0017\u0010+\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010!¨\u0006,"}, d2 = {"Lcom/reactnativeavoidsoftinput/animations/AnimationHandler;", "", "addOffsetInRootView", "", "to", "", "rootView", "Landroid/view/View;", "focusedView", "onOffsetAnimationEnd", "Lkotlin/Function0;", "addOffsetInScrollView", AvoidSoftInputModuleImpl.SOFT_INPUT_HEIGHT_KEY, "scrollView", "Landroid/widget/ScrollView;", "currentFocusedView", "clearOffsets", "decreaseOffsetInRootView", Constants.MessagePayloadKeys.FROM, "decreaseOffsetInScrollView", "increaseOffsetInRootView", "increaseOffsetInScrollView", "removeOffsetInRootView", "removeOffsetInScrollView", "initialScrollValue", "setAvoidOffset", "avoidOffset", "", "setEasing", "easing", "", "setHideAnimationDelay", "delay", "(Ljava/lang/Integer;)V", "setHideAnimationDuration", "duration", "setOnOffsetChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offset", "setShowAnimationDelay", "setShowAnimationDuration", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AnimationHandler {
    void addOffsetInRootView(int to, View rootView, View focusedView, Function0<Unit> onOffsetAnimationEnd);

    void addOffsetInScrollView(int softInputHeight, ScrollView scrollView, View currentFocusedView, Function0<Unit> onOffsetAnimationEnd);

    void clearOffsets();

    void decreaseOffsetInRootView(int from, int to, View rootView);

    void decreaseOffsetInScrollView(int from, int to, ScrollView scrollView, View focusedView);

    void increaseOffsetInRootView(int from, int to, View rootView);

    void increaseOffsetInScrollView(int from, int to, ScrollView scrollView, View currentFocusedView);

    void removeOffsetInRootView(View rootView, Function0<Unit> onOffsetAnimationEnd);

    void removeOffsetInScrollView(ScrollView scrollView, int initialScrollValue, Function0<Unit> onOffsetAnimationEnd);

    void setAvoidOffset(float avoidOffset);

    void setEasing(String easing);

    void setHideAnimationDelay(Integer delay);

    void setHideAnimationDuration(Integer duration);

    void setOnOffsetChangedListener(Function1<? super Integer, Unit> listener);

    void setShowAnimationDelay(Integer delay);

    void setShowAnimationDuration(Integer duration);
}
