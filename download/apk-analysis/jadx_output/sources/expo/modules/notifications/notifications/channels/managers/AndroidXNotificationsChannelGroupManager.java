package expo.modules.notifications.notifications.channels.managers;

import android.app.NotificationChannelGroup;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import expo.modules.core.arguments.ReadableArguments;
import java.util.List;

/* loaded from: classes6.dex */
public class AndroidXNotificationsChannelGroupManager implements NotificationsChannelGroupManager {
    private final NotificationManagerCompat mNotificationManager;

    public AndroidXNotificationsChannelGroupManager(Context context) {
        this.mNotificationManager = NotificationManagerCompat.from(context);
    }

    @Override // expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager
    public NotificationChannelGroup getNotificationChannelGroup(String str) {
        return this.mNotificationManager.getNotificationChannelGroup(str);
    }

    @Override // expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        return this.mNotificationManager.getNotificationChannelGroups();
    }

    @Override // expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager
    public NotificationChannelGroup createNotificationChannelGroup(String str, CharSequence charSequence, ReadableArguments readableArguments) {
        NotificationChannelGroup m = Downloader$$ExternalSyntheticApiModelOutline0.m(str, charSequence);
        configureGroupWithOptions(m, readableArguments);
        this.mNotificationManager.createNotificationChannelGroup(m);
        return m;
    }

    @Override // expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager
    public void deleteNotificationChannelGroup(String str) {
        this.mNotificationManager.deleteNotificationChannelGroup(str);
    }

    protected void configureGroupWithOptions(Object obj, ReadableArguments readableArguments) {
        if (Downloader$$ExternalSyntheticApiModelOutline0.m2158m(obj)) {
            NotificationChannelGroup m2146m = Downloader$$ExternalSyntheticApiModelOutline0.m2146m(obj);
            if (Build.VERSION.SDK_INT < 28 || !readableArguments.containsKey("description")) {
                return;
            }
            m2146m.setDescription(readableArguments.getString("description"));
        }
    }
}
