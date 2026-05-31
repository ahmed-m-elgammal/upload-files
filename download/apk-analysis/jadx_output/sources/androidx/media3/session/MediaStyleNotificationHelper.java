package androidx.media3.session;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* loaded from: classes.dex */
public class MediaStyleNotificationHelper {
    public static final String EXTRA_MEDIA3_SESSION = "androidx.media3.session";

    private MediaStyleNotificationHelper() {
    }

    public static class MediaStyle extends NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] actionsToShowInCompact;
        PendingIntent cancelButtonIntent;
        int remoteDeviceIconRes;
        PendingIntent remoteDeviceIntent;
        CharSequence remoteDeviceName;
        final MediaSession session;
        private boolean showCancelButton;

        public MediaStyle setShowCancelButton(boolean z) {
            return this;
        }

        public static SessionToken getSessionToken(Notification notification) {
            Bundle bundle;
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras == null || (bundle = extras.getBundle("androidx.media3.session")) == null) {
                return null;
            }
            return SessionToken.fromBundle(bundle);
        }

        public MediaStyle(MediaSession mediaSession) {
            this.session = mediaSession;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.actionsToShowInCompact = iArr;
            return this;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.cancelButtonIntent = pendingIntent;
            return this;
        }

        public MediaStyle setRemotePlaybackInfo(CharSequence charSequence, int i, PendingIntent pendingIntent) {
            Assertions.checkArgument(charSequence != null);
            this.remoteDeviceName = charSequence;
            this.remoteDeviceIconRes = i;
            this.remoteDeviceIntent = pendingIntent;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Util.SDK_INT >= 34 && this.remoteDeviceName != null) {
                Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), Api21Impl.fillInMediaStyle(Api34Impl.setRemotePlaybackInfo(Api21Impl.createMediaStyle(), this.remoteDeviceName, this.remoteDeviceIconRes, this.remoteDeviceIntent), this.actionsToShowInCompact, this.session));
                return;
            }
            if (Util.SDK_INT >= 21) {
                Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), Api21Impl.fillInMediaStyle(Api21Impl.createMediaStyle(), this.actionsToShowInCompact, this.session));
                Bundle bundle = new Bundle();
                bundle.putBundle("androidx.media3.session", this.session.getToken().toBundle());
                notificationBuilderWithBuilderAccessor.getBuilder().addExtras(bundle);
                return;
            }
            if (this.showCancelButton) {
                notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Util.SDK_INT >= 21) {
                return null;
            }
            return generateContentView();
        }

        RemoteViews generateContentView() {
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.actionsToShowInCompact;
            if (iArr != null) {
                int min = Math.min(iArr.length, 3);
                applyStandardTemplate.removeAllViews(androidx.media.R.id.media_actions);
                if (min > 0) {
                    for (int i = 0; i < min; i++) {
                        if (i >= size) {
                            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i), Integer.valueOf(size - 1)));
                        }
                        applyStandardTemplate.addView(androidx.media.R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(iArr[i])));
                    }
                }
            }
            if (this.showCancelButton) {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.end_padder, 8);
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.cancel_action, 0);
                applyStandardTemplate.setOnClickPendingIntent(androidx.media.R.id.cancel_action, this.cancelButtonIntent);
                applyStandardTemplate.setInt(androidx.media.R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(androidx.media.R.integer.cancel_button_image_alpha));
            } else {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.end_padder, 0);
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
            boolean z = action.getActionIntent() == null;
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), androidx.media.R.layout.notification_media_action);
            IconCompat iconCompat = action.getIconCompat();
            if (iconCompat != null) {
                remoteViews.setImageViewResource(androidx.media.R.id.action0, iconCompat.getResId());
            }
            if (!z) {
                remoteViews.setOnClickPendingIntent(androidx.media.R.id.action0, action.getActionIntent());
            }
            remoteViews.setContentDescription(androidx.media.R.id.action0, action.getTitle());
            return remoteViews;
        }

        int getContentViewLayoutResource() {
            return androidx.media.R.layout.notification_template_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Util.SDK_INT >= 21) {
                return null;
            }
            return generateBigContentView();
        }

        RemoteViews generateBigContentView() {
            int min = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(min), false);
            applyStandardTemplate.removeAllViews(androidx.media.R.id.media_actions);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    applyStandardTemplate.addView(androidx.media.R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i)));
                }
            }
            if (this.showCancelButton) {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.cancel_action, 0);
                applyStandardTemplate.setInt(androidx.media.R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(androidx.media.R.integer.cancel_button_image_alpha));
                applyStandardTemplate.setOnClickPendingIntent(androidx.media.R.id.cancel_action, this.cancelButtonIntent);
            } else {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        int getBigContentViewLayoutResource(int i) {
            if (i <= 3) {
                return androidx.media.R.layout.notification_template_big_media_narrow;
            }
            return androidx.media.R.layout.notification_template_big_media;
        }
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        public DecoratedMediaCustomViewStyle(MediaSession mediaSession) {
            super(mediaSession);
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle, androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Util.SDK_INT >= 34 && this.remoteDeviceName != null) {
                Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), Api21Impl.fillInMediaStyle(Api34Impl.setRemotePlaybackInfo(Api24Impl.createDecoratedMediaCustomViewStyle(), this.remoteDeviceName, this.remoteDeviceIconRes, this.remoteDeviceIntent), this.actionsToShowInCompact, this.session));
                return;
            }
            if (Util.SDK_INT >= 24) {
                Api21Impl.setMediaStyle(notificationBuilderWithBuilderAccessor.getBuilder(), Api21Impl.fillInMediaStyle(Api24Impl.createDecoratedMediaCustomViewStyle(), this.actionsToShowInCompact, this.session));
                Bundle bundle = new Bundle();
                bundle.putBundle("androidx.media3.session", this.session.getToken().toBundle());
                notificationBuilderWithBuilderAccessor.getBuilder().addExtras(bundle);
                return;
            }
            super.apply(notificationBuilderWithBuilderAccessor);
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Util.SDK_INT >= 24) {
                return null;
            }
            boolean z = this.mBuilder.getContentView() != null;
            if (Util.SDK_INT >= 21) {
                if (z || this.mBuilder.getBigContentView() != null) {
                    RemoteViews generateContentView = generateContentView();
                    if (z) {
                        buildIntoRemoteViews(generateContentView, this.mBuilder.getContentView());
                    }
                    setBackgroundColor(generateContentView);
                    return generateContentView;
                }
            } else {
                RemoteViews generateContentView2 = generateContentView();
                if (z) {
                    buildIntoRemoteViews(generateContentView2, this.mBuilder.getContentView());
                    return generateContentView2;
                }
            }
            return null;
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle
        int getContentViewLayoutResource() {
            if (this.mBuilder.getContentView() != null) {
                return androidx.media.R.layout.notification_template_media_custom;
            }
            return super.getContentViewLayoutResource();
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
            if (Util.SDK_INT >= 24) {
                return null;
            }
            if (this.mBuilder.getBigContentView() != null) {
                contentView = this.mBuilder.getBigContentView();
            } else {
                contentView = this.mBuilder.getContentView();
            }
            if (contentView == null) {
                return null;
            }
            RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, contentView);
            if (Util.SDK_INT >= 21) {
                setBackgroundColor(generateBigContentView);
            }
            return generateBigContentView;
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle
        int getBigContentViewLayoutResource(int i) {
            if (i <= 3) {
                return androidx.media.R.layout.notification_template_big_media_narrow_custom;
            }
            return androidx.media.R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
            if (Util.SDK_INT >= 24) {
                return null;
            }
            if (this.mBuilder.getHeadsUpContentView() != null) {
                contentView = this.mBuilder.getHeadsUpContentView();
            } else {
                contentView = this.mBuilder.getContentView();
            }
            if (contentView == null) {
                return null;
            }
            RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, contentView);
            if (Util.SDK_INT >= 21) {
                setBackgroundColor(generateBigContentView);
            }
            return generateBigContentView;
        }

        private void setBackgroundColor(RemoteViews remoteViews) {
            int color;
            if (this.mBuilder.getColor() != 0) {
                color = this.mBuilder.getColor();
            } else {
                color = this.mBuilder.mContext.getResources().getColor(androidx.media.R.color.notification_material_background_media_default_color);
            }
            remoteViews.setInt(androidx.media.R.id.status_bar_latest_event_content, "setBackgroundColor", color);
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void setMediaStyle(Notification.Builder builder, Notification.MediaStyle mediaStyle) {
            builder.setStyle(mediaStyle);
        }

        public static Notification.MediaStyle createMediaStyle() {
            return new Notification.MediaStyle();
        }

        public static Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle, int[] iArr, MediaSession mediaSession) {
            Assertions.checkNotNull(mediaStyle);
            Assertions.checkNotNull(mediaSession);
            if (iArr != null) {
                setShowActionsInCompactView(mediaStyle, iArr);
            }
            mediaStyle.setMediaSession((MediaSession.Token) mediaSession.getSessionCompatToken().getToken());
            return mediaStyle;
        }

        public static void setShowActionsInCompactView(Notification.MediaStyle mediaStyle, int... iArr) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
    }

    private static class Api24Impl {
        private Api24Impl() {
        }

        public static Notification.DecoratedMediaCustomViewStyle createDecoratedMediaCustomViewStyle() {
            return new Notification.DecoratedMediaCustomViewStyle();
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        public static Notification.MediaStyle setRemotePlaybackInfo(Notification.MediaStyle mediaStyle, CharSequence charSequence, int i, PendingIntent pendingIntent) {
            mediaStyle.setRemotePlaybackInfo(charSequence, i, pendingIntent);
            return mediaStyle;
        }
    }
}
