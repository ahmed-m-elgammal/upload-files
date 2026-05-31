package com.reactnativeavoidsoftinput.listeners;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusedViewChangeListenerImpl.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016JF\u0010\u0016\u001a\u00020\u000e2<\u0010\u0017\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000RD\u0010\b\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/reactnativeavoidsoftinput/listeners/FocusedViewChangeListenerImpl;", "Lcom/reactnativeavoidsoftinput/listeners/FocusedViewChangeListener;", "()V", "currentFocusedView", "Landroid/view/View;", "getCurrentFocusedView", "()Landroid/view/View;", "mCurrentFocusedView", "mOnFocusListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "oldView", "newView", "", "mOnGlobalFocusChangeListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "mPreviousFocusedView", "previousFocusedView", "getPreviousFocusedView", "registerFocusedViewChangeListener", "rootView", "setOnFocusListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterFocusedViewChangeListener", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FocusedViewChangeListenerImpl implements FocusedViewChangeListener {
    private View mCurrentFocusedView;
    private Function2<? super View, ? super View, Unit> mOnFocusListener;
    private final ViewTreeObserver.OnGlobalFocusChangeListener mOnGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListenerImpl$$ExternalSyntheticLambda0
        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View view, View view2) {
            FocusedViewChangeListenerImpl.mOnGlobalFocusChangeListener$lambda$0(FocusedViewChangeListenerImpl.this, view, view2);
        }
    };
    private View mPreviousFocusedView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnGlobalFocusChangeListener$lambda$0(FocusedViewChangeListenerImpl this$0, View view, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCurrentFocusedView = view2;
        this$0.mPreviousFocusedView = view;
        Function2<? super View, ? super View, Unit> function2 = this$0.mOnFocusListener;
        if (function2 != null) {
            function2.invoke(view, view2);
        }
    }

    @Override // com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener
    /* renamed from: getCurrentFocusedView, reason: from getter */
    public View getMCurrentFocusedView() {
        return this.mCurrentFocusedView;
    }

    @Override // com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener
    /* renamed from: getPreviousFocusedView, reason: from getter */
    public View getMPreviousFocusedView() {
        return this.mPreviousFocusedView;
    }

    @Override // com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener
    public void setOnFocusListener(Function2<? super View, ? super View, Unit> listener) {
        this.mOnFocusListener = listener;
    }

    @Override // com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener
    public void registerFocusedViewChangeListener(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        rootView.getViewTreeObserver().addOnGlobalFocusChangeListener(this.mOnGlobalFocusChangeListener);
    }

    @Override // com.reactnativeavoidsoftinput.listeners.FocusedViewChangeListener
    public void unregisterFocusedViewChangeListener(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        rootView.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.mOnGlobalFocusChangeListener);
    }
}
