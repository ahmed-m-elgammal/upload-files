package expo.modules.notifications.notifications.interfaces;

import android.app.Notification;
import expo.modules.notifications.notifications.model.NotificationBehavior;
import expo.modules.notifications.service.NotificationsService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: NotificationBuilder.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lexpo/modules/notifications/notifications/interfaces/NotificationBuilder;", "", "build", "Landroid/app/Notification;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAllowedBehavior", "behavior", "Lexpo/modules/notifications/notifications/model/NotificationBehavior;", "setNotification", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface NotificationBuilder {
    Object build(Continuation<? super Notification> continuation);

    NotificationBuilder setAllowedBehavior(NotificationBehavior behavior);

    NotificationBuilder setNotification(expo.modules.notifications.notifications.model.Notification notification);
}
