package expo.modules.notifications.service.delegates;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import expo.modules.notifications.notifications.SoundResolver;
import expo.modules.notifications.notifications.enums.NotificationPriority;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationBehavior;
import expo.modules.notifications.notifications.model.NotificationContent;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.notifications.service.interfaces.PresentationDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ExpoPresentationDelegate.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u001a\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lexpo/modules/notifications/service/delegates/ExpoPresentationDelegate;", "Lexpo/modules/notifications/service/interfaces/PresentationDelegate;", "context", "Landroid/content/Context;", "notificationManager", "Landroidx/core/app/NotificationManagerCompat;", "(Landroid/content/Context;Landroidx/core/app/NotificationManagerCompat;)V", "getContext", "()Landroid/content/Context;", "dismissAllNotifications", "", "dismissNotifications", NotificationsService.IDENTIFIERS_KEY, "", "", "fromBundle", "Lorg/json/JSONObject;", "bundle", "Landroid/os/Bundle;", "getAllPresentedNotifications", "Lexpo/modules/notifications/notifications/model/Notification;", "getNotification", "statusBarNotification", "Landroid/service/notification/StatusBarNotification;", "getNotificationSoundUri", "Landroid/net/Uri;", NotificationsService.NOTIFICATION_KEY, "getNotifyId", "", "request", "Lexpo/modules/notifications/notifications/model/NotificationRequest;", "presentNotification", "behavior", "Lexpo/modules/notifications/notifications/model/NotificationBehavior;", "Companion", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public class ExpoPresentationDelegate implements PresentationDelegate {
    protected static final int ANDROID_NOTIFICATION_ID = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    protected static final String INTERNAL_IDENTIFIER_AUTHORITY = "foreign_notifications";
    protected static final String INTERNAL_IDENTIFIER_ID_KEY = "id";
    protected static final String INTERNAL_IDENTIFIER_SCHEME = "expo-notifications";
    protected static final String INTERNAL_IDENTIFIER_TAG_KEY = "tag";
    private final Context context;
    private final NotificationManagerCompat notificationManager;

    protected int getNotifyId(NotificationRequest request) {
        return 0;
    }

    public ExpoPresentationDelegate(Context context, NotificationManagerCompat notificationManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        this.context = context;
        this.notificationManager = notificationManager;
    }

    protected final Context getContext() {
        return this.context;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ExpoPresentationDelegate(android.content.Context r1, androidx.core.app.NotificationManagerCompat r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto Ld
            androidx.core.app.NotificationManagerCompat r2 = androidx.core.app.NotificationManagerCompat.from(r1)
            java.lang.String r3 = "from(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        Ld:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.service.delegates.ExpoPresentationDelegate.<init>(android.content.Context, androidx.core.app.NotificationManagerCompat, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* compiled from: ExpoPresentationDelegate.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0004J\u001e\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0084T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/notifications/service/delegates/ExpoPresentationDelegate$Companion;", "", "()V", "ANDROID_NOTIFICATION_ID", "", "INTERNAL_IDENTIFIER_AUTHORITY", "", "INTERNAL_IDENTIFIER_ID_KEY", "INTERNAL_IDENTIFIER_SCHEME", "INTERNAL_IDENTIFIER_TAG_KEY", "getInternalIdentifierKey", NotificationsService.NOTIFICATION_KEY, "Landroid/service/notification/StatusBarNotification;", "parseNotificationIdentifier", "Landroid/util/Pair;", "identifier", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Pair<String, Integer> parseNotificationIdentifier(String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            try {
                Uri parse = Uri.parse(identifier);
                if (!Intrinsics.areEqual(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, parse.getScheme()) || !Intrinsics.areEqual(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_AUTHORITY, parse.getAuthority())) {
                    return null;
                }
                String queryParameter = parse.getQueryParameter("tag");
                String queryParameter2 = parse.getQueryParameter("id");
                Intrinsics.checkNotNull(queryParameter2);
                return new Pair<>(queryParameter, Integer.valueOf(Integer.parseInt(queryParameter2)));
            } catch (NullPointerException e) {
                Log.e(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, "Malformed foreign notification identifier: " + identifier, e);
                return null;
            } catch (NumberFormatException e2) {
                Log.e(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, "Malformed foreign notification identifier: " + identifier, e2);
                return null;
            } catch (UnsupportedOperationException e3) {
                Log.e(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, "Malformed foreign notification identifier: " + identifier, e3);
                return null;
            }
        }

        protected final String getInternalIdentifierKey(StatusBarNotification notification) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            Uri.Builder buildUpon = Uri.parse("expo-notifications://foreign_notifications").buildUpon();
            String tag = notification.getTag();
            if (tag != null) {
                Intrinsics.checkNotNull(tag);
                buildUpon.appendQueryParameter("tag", tag);
            }
            buildUpon.appendQueryParameter("id", String.valueOf(notification.getId()));
            String builder = buildUpon.toString();
            Intrinsics.checkNotNullExpressionValue(builder, "with(...)");
            return builder;
        }
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public void presentNotification(Notification notification, NotificationBehavior behavior) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        if (behavior == null || behavior.shouldShowAlert()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ExpoPresentationDelegate$presentNotification$1(this, notification, behavior, null), 3, null);
        } else if (behavior.shouldPlaySound()) {
            Uri notificationSoundUri = getNotificationSoundUri(notification);
            if (notificationSoundUri == null) {
                notificationSoundUri = Settings.System.DEFAULT_NOTIFICATION_URI;
            }
            RingtoneManager.getRingtone(this.context, notificationSoundUri).play();
        }
    }

    private final Uri getNotificationSoundUri(Notification notification) {
        NotificationChannel notificationChannel;
        Uri sound;
        if (Build.VERSION.SDK_INT >= 26) {
            String notificationChannel2 = notification.getNotificationRequest().getTrigger().getNotificationChannel();
            if (notificationChannel2 == null || (notificationChannel = this.notificationManager.getNotificationChannel(notificationChannel2)) == null) {
                return null;
            }
            sound = notificationChannel.getSound();
            return sound;
        }
        return new SoundResolver(this.context).resolve(notification.getNotificationRequest().getContent().getSoundName());
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public Collection<Notification> getAllPresentedNotifications() {
        Object systemService = this.context.getSystemService(NotificationsService.NOTIFICATION_KEY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        StatusBarNotification[] activeNotifications = ((NotificationManager) systemService).getActiveNotifications();
        Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            Intrinsics.checkNotNull(statusBarNotification);
            Notification notification = getNotification(statusBarNotification);
            if (notification != null) {
                arrayList.add(notification);
            }
        }
        return arrayList;
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public void dismissNotifications(Collection<String> identifiers) {
        Object obj;
        Intrinsics.checkNotNullParameter(identifiers, "identifiers");
        for (String str : identifiers) {
            Pair<String, Integer> parseNotificationIdentifier = INSTANCE.parseNotificationIdentifier(str);
            if (parseNotificationIdentifier != null) {
                NotificationManagerCompat from = NotificationManagerCompat.from(this.context);
                String str2 = (String) parseNotificationIdentifier.first;
                Object second = parseNotificationIdentifier.second;
                Intrinsics.checkNotNullExpressionValue(second, "second");
                from.cancel(str2, ((Number) second).intValue());
            } else {
                Iterator<T> it = getAllPresentedNotifications().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((Notification) obj).getNotificationRequest().getIdentifier(), str)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                Notification notification = (Notification) obj;
                NotificationManagerCompat.from(this.context).cancel(str, getNotifyId(notification != null ? notification.getNotificationRequest() : null));
            }
        }
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public void dismissAllNotifications() {
        NotificationManagerCompat.from(this.context).cancelAll();
    }

    protected Notification getNotification(StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "statusBarNotification");
        android.app.Notification notification = statusBarNotification.getNotification();
        byte[] byteArray = notification.extras.getByteArray(ExpoNotificationBuilder.EXTRAS_MARSHALLED_NOTIFICATION_REQUEST_KEY);
        if (byteArray != null) {
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                NotificationRequest createFromParcel = NotificationRequest.CREATOR.createFromParcel(obtain);
                Intrinsics.checkNotNullExpressionValue(createFromParcel, "createFromParcel(...)");
                obtain.recycle();
                return new Notification(createFromParcel, new Date(statusBarNotification.getPostTime()));
            } catch (Exception unused) {
                Log.e(INTERNAL_IDENTIFIER_SCHEME, "Could not have unmarshalled NotificationRequest from (" + statusBarNotification.getTag() + ", " + statusBarNotification.getId() + ").");
            }
        }
        NotificationContent.Builder sticky = new NotificationContent.Builder().setTitle(notification.extras.getString(NotificationCompat.EXTRA_TITLE)).setText(notification.extras.getString(NotificationCompat.EXTRA_TEXT)).setSubtitle(notification.extras.getString(NotificationCompat.EXTRA_SUB_TEXT)).setPriority(NotificationPriority.fromNativeValue(notification.priority)).setVibrationPattern(notification.vibrate).setSound(notification.sound).setAutoDismiss((notification.flags & 16) != 0).setSticky((notification.flags & 2) != 0);
        Bundle extras = notification.extras;
        Intrinsics.checkNotNullExpressionValue(extras, "extras");
        return new Notification(new NotificationRequest(INSTANCE.getInternalIdentifierKey(statusBarNotification), sticky.setBody(fromBundle(extras)).build(), null), new Date(statusBarNotification.getPostTime()));
    }

    protected JSONObject fromBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, JSONObject.wrap(bundle.get(str)));
            } catch (JSONException e) {
                Log.d(INTERNAL_IDENTIFIER_SCHEME, "Error encountered while serializing Android notification extras: " + str + " -> " + bundle.get(str), e);
            }
        }
        return jSONObject;
    }
}
