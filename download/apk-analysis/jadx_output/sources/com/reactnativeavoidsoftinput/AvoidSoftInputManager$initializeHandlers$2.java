package com.reactnativeavoidsoftinput;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: AvoidSoftInputManager.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class AvoidSoftInputManager$initializeHandlers$2 extends FunctionReferenceImpl implements Function2<View, View, Unit> {
    AvoidSoftInputManager$initializeHandlers$2(Object obj) {
        super(2, obj, AvoidSoftInputManager.class, "onFocus", "onFocus(Landroid/view/View;Landroid/view/View;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, View view2) {
        invoke2(view, view2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, View view2) {
        ((AvoidSoftInputManager) this.receiver).onFocus(view, view2);
    }
}
