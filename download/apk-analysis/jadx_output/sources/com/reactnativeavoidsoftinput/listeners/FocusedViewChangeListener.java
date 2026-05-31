package com.reactnativeavoidsoftinput.listeners;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: FocusedViewChangeListener.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&JF\u0010\u000b\u001a\u00020\t2<\u0010\f\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\rH&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/reactnativeavoidsoftinput/listeners/FocusedViewChangeListener;", "", "currentFocusedView", "Landroid/view/View;", "getCurrentFocusedView", "()Landroid/view/View;", "previousFocusedView", "getPreviousFocusedView", "registerFocusedViewChangeListener", "", "rootView", "setOnFocusListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "oldView", "newView", "unregisterFocusedViewChangeListener", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FocusedViewChangeListener {
    View getCurrentFocusedView();

    View getPreviousFocusedView();

    void registerFocusedViewChangeListener(View rootView);

    void setOnFocusListener(Function2<? super View, ? super View, Unit> listener);

    void unregisterFocusedViewChangeListener(View rootView);
}
