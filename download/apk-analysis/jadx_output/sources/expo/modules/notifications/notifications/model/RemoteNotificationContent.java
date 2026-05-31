package expo.modules.notifications.notifications.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.RemoteMessage;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.enums.NotificationPriority;
import expo.modules.notifications.notifications.interfaces.INotificationContent;
import expo.modules.notifications.notifications.presentation.builders.DownloadImageKt;
import io.sentry.protocol.SentryThread;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: RemoteNotificationContent.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u00104\u001a\u00020\u001aH\u0016J\b\u00105\u001a\u00020\tH\u0016J\u0018\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u000209H\u0096@¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\tH\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001eX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0014\u0010&\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001bR\u0016\u0010(\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0014R\u0016\u0010*\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0014R\u0016\u0010,\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0014R\u0016\u0010.\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0014R\u0016\u00100\u001a\u0004\u0018\u000101X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Lexpo/modules/notifications/notifications/model/RemoteNotificationContent;", "Lexpo/modules/notifications/notifications/interfaces/INotificationContent;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "(Lcom/google/firebase/messaging/RemoteMessage;)V", "badgeCount", "", "getBadgeCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "body", "Lorg/json/JSONObject;", "getBody", "()Lorg/json/JSONObject;", "categoryId", "", "getCategoryId", "()Ljava/lang/String;", "color", "", "getColor", "()Ljava/lang/Number;", "isAutoDismiss", "", "()Z", "isSticky", "notificationData", "Lexpo/modules/notifications/notifications/model/NotificationData;", "Ljava/util/Map;", SentryThread.JsonKeys.PRIORITY, "Lexpo/modules/notifications/notifications/enums/NotificationPriority;", "getPriority", "()Lexpo/modules/notifications/notifications/enums/NotificationPriority;", "shouldPlayDefaultSound", "getShouldPlayDefaultSound", "shouldUseDefaultVibrationPattern", "getShouldUseDefaultVibrationPattern", "soundName", "getSoundName", "subtitle", "getSubtitle", "text", "getText", "title", "getTitle", NotificationsChannelSerializer.VIBRATION_PATTERN_KEY, "", "getVibrationPattern", "()[J", "containsImage", "describeContents", "getImage", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeToParcel", "", "dest", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "CREATOR", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RemoteNotificationContent implements INotificationContent {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer badgeCount;
    private final JSONObject body;
    private final String categoryId;
    private final boolean isAutoDismiss;
    private final boolean isSticky;
    private final Map<String, ? extends String> notificationData;
    private final RemoteMessage remoteMessage;
    private final boolean shouldPlayDefaultSound;
    private final String soundName;
    private final String subtitle;
    private final String text;
    private final String title;
    private final long[] vibrationPattern;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RemoteNotificationContent(RemoteMessage remoteMessage) {
        long[] vibrateTimings;
        String sound;
        String body;
        String title;
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        this.remoteMessage = remoteMessage;
        Map<String, String> data = remoteMessage.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        Map<String, ? extends String> m2327constructorimpl = NotificationData.m2327constructorimpl(data);
        this.notificationData = m2327constructorimpl;
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        this.title = (notification == null || (title = notification.getTitle()) == null) ? NotificationData.m2341getTitleimpl(m2327constructorimpl) : title;
        RemoteMessage.Notification notification2 = remoteMessage.getNotification();
        this.text = (notification2 == null || (body = notification2.getBody()) == null) ? NotificationData.m2335getMessageimpl(m2327constructorimpl) : body;
        RemoteMessage.Notification notification3 = remoteMessage.getNotification();
        this.shouldPlayDefaultSound = (notification3 != null ? notification3.getSound() : null) == null && NotificationData.m2336getShouldPlayDefaultSoundimpl(m2327constructorimpl);
        RemoteMessage.Notification notification4 = remoteMessage.getNotification();
        this.soundName = (notification4 == null || (sound = notification4.getSound()) == null) ? NotificationData.m2338getSoundimpl(m2327constructorimpl) : sound;
        RemoteMessage.Notification notification5 = remoteMessage.getNotification();
        this.vibrationPattern = (notification5 == null || (vibrateTimings = notification5.getVibrateTimings()) == null) ? NotificationData.m2342getVibrationPatternimpl(m2327constructorimpl) : vibrateTimings;
        this.body = NotificationData.m2332getBodyimpl(m2327constructorimpl);
        this.isAutoDismiss = NotificationData.m2330getAutoDismissimpl(m2327constructorimpl);
        this.categoryId = NotificationData.m2333getCategoryIdimpl(m2327constructorimpl);
        this.isSticky = NotificationData.m2344isStickyimpl(m2327constructorimpl);
        this.subtitle = NotificationData.m2340getSubTextimpl(m2327constructorimpl);
        this.badgeCount = NotificationData.m2331getBadgeimpl(m2327constructorimpl);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public RemoteNotificationContent(android.os.Parcel r2) {
        /*
            r1 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.Class<com.google.firebase.messaging.RemoteMessage> r0 = com.google.firebase.messaging.RemoteMessage.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r2 = r2.readParcelable(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.google.firebase.messaging.RemoteMessage r2 = (com.google.firebase.messaging.RemoteMessage) r2
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.notifications.model.RemoteNotificationContent.<init>(android.os.Parcel):void");
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public Object getImage(Context context, Continuation<? super Bitmap> continuation) {
        Object downloadImage;
        RemoteMessage.Notification notification = this.remoteMessage.getNotification();
        Uri imageUrl = notification != null ? notification.getImageUrl() : null;
        if (imageUrl == null) {
            return null;
        }
        downloadImage = DownloadImageKt.downloadImage(imageUrl, (r14 & 2) != 0 ? 8000L : 0L, (r14 & 4) != 0 ? 8000L : 0L, continuation);
        return downloadImage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? downloadImage : (Bitmap) downloadImage;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public boolean containsImage() {
        RemoteMessage.Notification notification = this.remoteMessage.getNotification();
        return (notification != null ? notification.getImageUrl() : null) != null;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public String getTitle() {
        return this.title;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public String getText() {
        return this.text;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public boolean getShouldPlayDefaultSound() {
        return this.shouldPlayDefaultSound;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public String getSoundName() {
        return this.soundName;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public boolean getShouldUseDefaultVibrationPattern() {
        RemoteMessage.Notification notification = this.remoteMessage.getNotification();
        return notification != null ? notification.getDefaultVibrateSettings() : NotificationData.m2337getShouldUseDefaultVibrationPatternimpl(this.notificationData);
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public long[] getVibrationPattern() {
        return this.vibrationPattern;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public JSONObject getBody() {
        return this.body;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public NotificationPriority getPriority() {
        if (this.remoteMessage.getPriority() == 1) {
            return NotificationPriority.HIGH;
        }
        return NotificationPriority.DEFAULT;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public Number getColor() {
        String m2334getColorimpl;
        RemoteMessage.Notification notification = this.remoteMessage.getNotification();
        if (notification == null || (m2334getColorimpl = notification.getColor()) == null) {
            m2334getColorimpl = NotificationData.m2334getColorimpl(this.notificationData);
        }
        return m2334getColorimpl != null ? Integer.valueOf(Color.parseColor(m2334getColorimpl)) : null;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    /* renamed from: isAutoDismiss, reason: from getter */
    public boolean getIsAutoDismiss() {
        return this.isAutoDismiss;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public String getCategoryId() {
        return this.categoryId;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    /* renamed from: isSticky, reason: from getter */
    public boolean getIsSticky() {
        return this.isSticky;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public String getSubtitle() {
        return this.subtitle;
    }

    @Override // expo.modules.notifications.notifications.interfaces.INotificationContent
    public Integer getBadgeCount() {
        return this.badgeCount;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.remoteMessage, flags);
    }

    /* compiled from: RemoteNotificationContent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/notifications/notifications/model/RemoteNotificationContent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lexpo/modules/notifications/notifications/model/RemoteNotificationContent;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", RRWebVideoEvent.JsonKeys.SIZE, "", "(I)[Lexpo/modules/notifications/notifications/model/RemoteNotificationContent;", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: expo.modules.notifications.notifications.model.RemoteNotificationContent$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<RemoteNotificationContent> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteNotificationContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RemoteNotificationContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteNotificationContent[] newArray(int size) {
            return new RemoteNotificationContent[size];
        }
    }
}
