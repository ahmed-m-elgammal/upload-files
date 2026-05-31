package expo.modules.notifications.notifications.presentation.builders;

import android.app.Notification;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.util.Log;
import androidx.camera.video.AudioStats;
import expo.modules.notifications.notifications.enums.NotificationPriority;
import expo.modules.notifications.notifications.model.NotificationRequest;
import io.sentry.protocol.SentryThread;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpoNotificationBuilder.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lexpo/modules/notifications/notifications/presentation/builders/ExpoNotificationBuilder;", "Lexpo/modules/notifications/notifications/presentation/builders/ChannelAwareNotificationBuilder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "color", "", "getColor", "()Ljava/lang/Number;", "icon", "", "getIcon", "()I", "largeIcon", "Landroid/graphics/Bitmap;", "getLargeIcon", "()Landroid/graphics/Bitmap;", SentryThread.JsonKeys.PRIORITY, "getPriority", "build", "Landroid/app/Notification;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "marshallNotificationRequest", "", "request", "Lexpo/modules/notifications/notifications/model/NotificationRequest;", "shouldPlaySound", "", "shouldVibrate", "Companion", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public class ExpoNotificationBuilder extends ChannelAwareNotificationBuilder {
    public static final String EXTRAS_BODY_KEY = "body";
    public static final String EXTRAS_MARSHALLED_NOTIFICATION_REQUEST_KEY = "expo.notification_request";
    public static final String META_DATA_DEFAULT_COLOR_KEY = "expo.modules.notifications.default_notification_color";
    public static final String META_DATA_DEFAULT_ICON_KEY = "expo.modules.notifications.default_notification_icon";
    public static final String META_DATA_LARGE_ICON_KEY = "expo.modules.notifications.large_notification_icon";

    @Override // expo.modules.notifications.notifications.interfaces.NotificationBuilder
    public Object build(Continuation<? super Notification> continuation) {
        return build$suspendImpl(this, continuation);
    }

    public ExpoNotificationBuilder(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object build$suspendImpl(expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder r10, kotlin.coroutines.Continuation<? super android.app.Notification> r11) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder.build$suspendImpl(expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    protected final byte[] marshallNotificationRequest(NotificationRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain(...)");
            request.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Exception e) {
            Log.e("expo-notifications", "Could not marshalled notification request: " + request.getIdentifier() + ".", e);
            return null;
        }
    }

    private final boolean shouldPlaySound() {
        return (getNotificationBehavior() == null || getNotificationBehavior().shouldPlaySound()) && (getNotificationContent().getShouldPlayDefaultSound() || getNotificationContent().getSoundName() != null);
    }

    private final boolean shouldVibrate() {
        return (getNotificationBehavior() == null || getNotificationBehavior().shouldPlaySound()) && (getNotificationContent().getShouldUseDefaultVibrationPattern() || getNotificationContent().getVibrationPattern() != null);
    }

    private final int getPriority() {
        double min;
        NotificationPriority priority = getNotificationContent().getPriority();
        if (getNotificationBehavior() == null) {
            if (priority != null) {
                return priority.getNativeValue();
            }
            return 1;
        }
        NotificationPriority priorityOverride = getNotificationBehavior().getPriorityOverride();
        if (priorityOverride != null) {
            return priorityOverride.getNativeValue();
        }
        if (priority == null) {
            priority = NotificationPriority.DEFAULT;
        }
        int nativeValue = priority.getNativeValue();
        if (getNotificationBehavior().shouldShowAlert()) {
            min = Math.max(1.0d, nativeValue);
        } else {
            min = Math.min(AudioStats.AUDIO_AMPLITUDE_NONE, nativeValue);
        }
        return (int) min;
    }

    protected final Bitmap getLargeIcon() {
        try {
            ApplicationInfo applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            if (!applicationInfo.metaData.containsKey(META_DATA_LARGE_ICON_KEY)) {
                return null;
            }
            return BitmapFactory.decodeResource(getContext().getResources(), applicationInfo.metaData.getInt(META_DATA_LARGE_ICON_KEY));
        } catch (Exception e) {
            Log.e("expo-notifications", "Could not have fetched large notification icon.", e);
            return null;
        }
    }

    protected final int getIcon() {
        try {
            ApplicationInfo applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            if (applicationInfo.metaData.containsKey(META_DATA_DEFAULT_ICON_KEY)) {
                return applicationInfo.metaData.getInt(META_DATA_DEFAULT_ICON_KEY);
            }
        } catch (Exception e) {
            Log.e("expo-notifications", "Could not have fetched default notification icon.", e);
        }
        return getContext().getApplicationInfo().icon;
    }

    protected final Number getColor() {
        if (getNotificationContent().getColor() != null) {
            return getNotificationContent().getColor();
        }
        try {
            ApplicationInfo applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            if (applicationInfo.metaData.containsKey(META_DATA_DEFAULT_COLOR_KEY)) {
                return Integer.valueOf(getContext().getResources().getColor(applicationInfo.metaData.getInt(META_DATA_DEFAULT_COLOR_KEY), null));
            }
        } catch (Exception e) {
            Log.e("expo-notifications", "Could not have fetched default notification color.", e);
        }
        return null;
    }
}
