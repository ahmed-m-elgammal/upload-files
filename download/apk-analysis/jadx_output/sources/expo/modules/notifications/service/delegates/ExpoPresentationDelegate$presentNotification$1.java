package expo.modules.notifications.service.delegates;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationManagerCompat;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationBehavior;
import expo.modules.notifications.notifications.presentation.builders.CategoryAwareNotificationBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ExpoPresentationDelegate.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.notifications.service.delegates.ExpoPresentationDelegate$presentNotification$1", f = "ExpoPresentationDelegate.kt", i = {}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class ExpoPresentationDelegate$presentNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NotificationBehavior $behavior;
    final /* synthetic */ Notification $notification;
    int label;
    final /* synthetic */ ExpoPresentationDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpoPresentationDelegate$presentNotification$1(ExpoPresentationDelegate expoPresentationDelegate, Notification notification, NotificationBehavior notificationBehavior, Continuation<? super ExpoPresentationDelegate$presentNotification$1> continuation) {
        super(2, continuation);
        this.this$0 = expoPresentationDelegate;
        this.$notification = notification;
        this.$behavior = notificationBehavior;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpoPresentationDelegate$presentNotification$1(this.this$0, this.$notification, this.$behavior, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExpoPresentationDelegate$presentNotification$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CategoryAwareNotificationBuilder categoryAwareNotificationBuilder = new CategoryAwareNotificationBuilder(this.this$0.getContext(), new SharedPreferencesNotificationCategoriesStore(this.this$0.getContext()));
            Notification notification = this.$notification;
            NotificationBehavior notificationBehavior = this.$behavior;
            categoryAwareNotificationBuilder.setNotification(notification);
            categoryAwareNotificationBuilder.setAllowedBehavior(notificationBehavior);
            this.label = 1;
            obj = categoryAwareNotificationBuilder.build(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        NotificationManagerCompat.from(this.this$0.getContext()).notify(this.$notification.getNotificationRequest().getIdentifier(), this.this$0.getNotifyId(this.$notification.getNotificationRequest()), (android.app.Notification) obj);
        return Unit.INSTANCE;
    }
}
