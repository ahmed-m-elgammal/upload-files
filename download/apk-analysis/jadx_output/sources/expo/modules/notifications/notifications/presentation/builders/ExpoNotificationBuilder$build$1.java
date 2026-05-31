package expo.modules.notifications.notifications.presentation.builders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ExpoNotificationBuilder.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder", f = "ExpoNotificationBuilder.kt", i = {0}, l = {105}, m = "build$suspendImpl", n = {"builder"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class ExpoNotificationBuilder$build$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExpoNotificationBuilder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpoNotificationBuilder$build$1(ExpoNotificationBuilder expoNotificationBuilder, Continuation<? super ExpoNotificationBuilder$build$1> continuation) {
        super(continuation);
        this.this$0 = expoNotificationBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ExpoNotificationBuilder.build$suspendImpl(this.this$0, this);
    }
}
