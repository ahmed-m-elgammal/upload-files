package com.reactnativeavoidsoftinput.listeners;

import com.facebook.react.uimanager.DisplayMetricsHolder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: WindowInsetsListenerImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.reactnativeavoidsoftinput.listeners.WindowInsetsListenerImpl$onHeightChange$1", f = "WindowInsetsListenerImpl.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class WindowInsetsListenerImpl$onHeightChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $from;
    final /* synthetic */ int $to;
    int label;
    final /* synthetic */ WindowInsetsListenerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInsetsListenerImpl$onHeightChange$1(WindowInsetsListenerImpl windowInsetsListenerImpl, int i, int i2, Continuation<? super WindowInsetsListenerImpl$onHeightChange$1> continuation) {
        super(2, continuation);
        this.this$0 = windowInsetsListenerImpl;
        this.$from = i;
        this.$to = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WindowInsetsListenerImpl$onHeightChange$1(this.this$0, this.$from, this.$to, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowInsetsListenerImpl$onHeightChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SoftInputListener softInputListener;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(250L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        int i3 = DisplayMetricsHolder.getScreenDisplayMetrics().heightPixels;
        softInputListener = this.this$0.mListener;
        if (softInputListener != null) {
            int i4 = this.$from;
            int i5 = this.$to;
            i = this.this$0.mPreviousScreenHeight;
            softInputListener.onSoftInputHeightChange(i4, i5, i3 != i);
        }
        this.this$0.mPreviousScreenHeight = i3;
        this.this$0.mPersistedFrom = null;
        this.this$0.mPreviousHeight = this.$to;
        this.this$0.mDebounceHeightChangeJob = null;
        return Unit.INSTANCE;
    }
}
