package expo.modules.notifications.notifications.presentation.builders;

import android.content.Context;
import expo.modules.notifications.notifications.interfaces.INotificationContent;
import expo.modules.notifications.notifications.interfaces.NotificationBuilder;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationBehavior;

/* loaded from: classes6.dex */
public abstract class BaseNotificationBuilder implements NotificationBuilder {
    private Context mContext;
    private Notification mNotification;
    private NotificationBehavior mNotificationBehavior;

    protected BaseNotificationBuilder(Context context) {
        this.mContext = context;
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationBuilder
    public NotificationBuilder setNotification(Notification notification) {
        this.mNotification = notification;
        return this;
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationBuilder
    public NotificationBuilder setAllowedBehavior(NotificationBehavior notificationBehavior) {
        this.mNotificationBehavior = notificationBehavior;
        return this;
    }

    protected Context getContext() {
        return this.mContext;
    }

    protected Notification getNotification() {
        return this.mNotification;
    }

    protected INotificationContent getNotificationContent() {
        return getNotification().getNotificationRequest().getContent();
    }

    protected NotificationBehavior getNotificationBehavior() {
        return this.mNotificationBehavior;
    }
}
