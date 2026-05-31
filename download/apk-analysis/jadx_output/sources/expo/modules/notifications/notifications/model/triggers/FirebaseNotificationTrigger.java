package expo.modules.notifications.notifications.model.triggers;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.RemoteMessage;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.interfaces.NotificationTrigger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseNotificationTrigger.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J\u0006\u0010\f\u001a\u00020\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/notifications/notifications/model/triggers/FirebaseNotificationTrigger;", "Lexpo/modules/notifications/notifications/interfaces/NotificationTrigger;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "(Lcom/google/firebase/messaging/RemoteMessage;)V", "describeContents", "", "getNotificationChannel", "", "getRemoteMessage", "writeToParcel", "", "dest", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "Companion", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FirebaseNotificationTrigger implements NotificationTrigger {
    private final RemoteMessage remoteMessage;
    public static final Parcelable.Creator<FirebaseNotificationTrigger> CREATOR = new Parcelable.Creator<FirebaseNotificationTrigger>() { // from class: expo.modules.notifications.notifications.model.triggers.FirebaseNotificationTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FirebaseNotificationTrigger createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FirebaseNotificationTrigger(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FirebaseNotificationTrigger[] newArray(int size) {
            return new FirebaseNotificationTrigger[size];
        }
    };

    public /* synthetic */ FirebaseNotificationTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FirebaseNotificationTrigger(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        this.remoteMessage = remoteMessage;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private FirebaseNotificationTrigger(android.os.Parcel r2) {
        /*
            r1 = this;
            java.lang.Class<expo.modules.notifications.notifications.model.triggers.FirebaseNotificationTrigger> r0 = expo.modules.notifications.notifications.model.triggers.FirebaseNotificationTrigger.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r2 = r2.readParcelable(r0)
            com.google.firebase.messaging.RemoteMessage r2 = (com.google.firebase.messaging.RemoteMessage) r2
            if (r2 == 0) goto L12
            r1.<init>(r2)
            return
        L12:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "RemoteMessage from readParcelable must not be null"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.notifications.model.triggers.FirebaseNotificationTrigger.<init>(android.os.Parcel):void");
    }

    public final RemoteMessage getRemoteMessage() {
        return this.remoteMessage;
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public String getNotificationChannel() {
        String str;
        RemoteMessage.Notification notification = this.remoteMessage.getNotification();
        if (notification == null || (str = notification.getChannelId()) == null) {
            str = this.remoteMessage.getData().get("channelId");
        }
        return str == null ? NotificationTrigger.CC.$default$getNotificationChannel(this) : str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.remoteMessage, 0);
    }
}
