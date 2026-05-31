package androidx.media3.session;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda0;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.CommandButton;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.MediaNotification;
import androidx.media3.session.MediaStyleNotificationHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import expo.modules.notifications.service.NotificationsService;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class DefaultMediaNotificationProvider implements MediaNotification.Provider {
    public static final String COMMAND_KEY_COMPACT_VIEW_INDEX = "androidx.media3.session.command.COMPACT_VIEW_INDEX";
    public static final String DEFAULT_CHANNEL_ID = "default_channel_id";
    public static final int DEFAULT_CHANNEL_NAME_RESOURCE_ID = R.string.default_notification_channel_name;
    public static final int DEFAULT_NOTIFICATION_ID = 1001;
    public static final String GROUP_KEY = "media3_group_key";
    private static final String TAG = "NotificationProvider";
    private final String channelId;
    private final int channelNameResourceId;
    private final Context context;
    private final NotificationIdProvider notificationIdProvider;
    private final NotificationManager notificationManager;
    private OnBitmapLoadedFutureCallback pendingOnBitmapLoadedFutureCallback;
    private int smallIconResourceId;

    public interface NotificationIdProvider {
        int getNotificationId(MediaSession mediaSession);
    }

    static /* synthetic */ int lambda$new$0(MediaSession mediaSession) {
        return 1001;
    }

    @Override // androidx.media3.session.MediaNotification.Provider
    public final boolean handleCustomCommand(MediaSession mediaSession, String str, Bundle bundle) {
        return false;
    }

    public static final class Builder {
        private boolean built;
        private final Context context;
        private NotificationIdProvider notificationIdProvider = new NotificationIdProvider() { // from class: androidx.media3.session.DefaultMediaNotificationProvider$Builder$$ExternalSyntheticLambda0
            @Override // androidx.media3.session.DefaultMediaNotificationProvider.NotificationIdProvider
            public final int getNotificationId(MediaSession mediaSession) {
                return DefaultMediaNotificationProvider.Builder.lambda$new$0(mediaSession);
            }
        };
        private String channelId = DefaultMediaNotificationProvider.DEFAULT_CHANNEL_ID;
        private int channelNameResourceId = DefaultMediaNotificationProvider.DEFAULT_CHANNEL_NAME_RESOURCE_ID;

        static /* synthetic */ int lambda$new$0(MediaSession mediaSession) {
            return 1001;
        }

        static /* synthetic */ int lambda$setNotificationId$1(int i, MediaSession mediaSession) {
            return i;
        }

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setNotificationId(final int i) {
            this.notificationIdProvider = new NotificationIdProvider() { // from class: androidx.media3.session.DefaultMediaNotificationProvider$Builder$$ExternalSyntheticLambda1
                @Override // androidx.media3.session.DefaultMediaNotificationProvider.NotificationIdProvider
                public final int getNotificationId(MediaSession mediaSession) {
                    return DefaultMediaNotificationProvider.Builder.lambda$setNotificationId$1(i, mediaSession);
                }
            };
            return this;
        }

        public Builder setNotificationIdProvider(NotificationIdProvider notificationIdProvider) {
            this.notificationIdProvider = notificationIdProvider;
            return this;
        }

        public Builder setChannelId(String str) {
            this.channelId = str;
            return this;
        }

        public Builder setChannelName(int i) {
            this.channelNameResourceId = i;
            return this;
        }

        public DefaultMediaNotificationProvider build() {
            Assertions.checkState(!this.built);
            DefaultMediaNotificationProvider defaultMediaNotificationProvider = new DefaultMediaNotificationProvider(this);
            this.built = true;
            return defaultMediaNotificationProvider;
        }
    }

    public DefaultMediaNotificationProvider(Context context) {
        this(context, new NotificationIdProvider() { // from class: androidx.media3.session.DefaultMediaNotificationProvider$$ExternalSyntheticLambda0
            @Override // androidx.media3.session.DefaultMediaNotificationProvider.NotificationIdProvider
            public final int getNotificationId(MediaSession mediaSession) {
                return DefaultMediaNotificationProvider.lambda$new$0(mediaSession);
            }
        }, DEFAULT_CHANNEL_ID, DEFAULT_CHANNEL_NAME_RESOURCE_ID);
    }

    public DefaultMediaNotificationProvider(Context context, NotificationIdProvider notificationIdProvider, String str, int i) {
        this.context = context;
        this.notificationIdProvider = notificationIdProvider;
        this.channelId = str;
        this.channelNameResourceId = i;
        this.notificationManager = (NotificationManager) Assertions.checkStateNotNull((NotificationManager) context.getSystemService(NotificationsService.NOTIFICATION_KEY));
        this.smallIconResourceId = R.drawable.media3_notification_small_icon;
    }

    private DefaultMediaNotificationProvider(Builder builder) {
        this(builder.context, builder.notificationIdProvider, builder.channelId, builder.channelNameResourceId);
    }

    @Override // androidx.media3.session.MediaNotification.Provider
    public final MediaNotification createNotification(MediaSession mediaSession, ImmutableList<CommandButton> immutableList, MediaNotification.ActionFactory actionFactory, MediaNotification.Provider.Callback callback) {
        ensureNotificationChannel();
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < immutableList.size(); i++) {
            CommandButton commandButton = immutableList.get(i);
            if (commandButton.sessionCommand != null && commandButton.sessionCommand.commandCode == 0 && commandButton.isEnabled) {
                builder.add((ImmutableList.Builder) immutableList.get(i));
            }
        }
        Player player = mediaSession.getPlayer();
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this.context, this.channelId);
        int notificationId = this.notificationIdProvider.getNotificationId(mediaSession);
        MediaStyleNotificationHelper.MediaStyle mediaStyle = new MediaStyleNotificationHelper.MediaStyle(mediaSession);
        mediaStyle.setShowActionsInCompactView(addNotificationActions(mediaSession, getMediaButtons(mediaSession, player.getAvailableCommands(), builder.build(), !Util.shouldShowPlayButton(player, mediaSession.getShowPlayButtonIfPlaybackIsSuppressed())), builder2, actionFactory));
        if (player.isCommandAvailable(18)) {
            MediaMetadata mediaMetadata = player.getMediaMetadata();
            builder2.setContentTitle(getNotificationContentTitle(mediaMetadata)).setContentText(getNotificationContentText(mediaMetadata));
            ListenableFuture<Bitmap> loadBitmapFromMetadata = mediaSession.getBitmapLoader().loadBitmapFromMetadata(mediaMetadata);
            if (loadBitmapFromMetadata != null) {
                OnBitmapLoadedFutureCallback onBitmapLoadedFutureCallback = this.pendingOnBitmapLoadedFutureCallback;
                if (onBitmapLoadedFutureCallback != null) {
                    onBitmapLoadedFutureCallback.discardIfPending();
                }
                if (loadBitmapFromMetadata.isDone()) {
                    try {
                        builder2.setLargeIcon((Bitmap) Futures.getDone(loadBitmapFromMetadata));
                    } catch (CancellationException | ExecutionException e) {
                        Log.w(TAG, getBitmapLoadErrorMessage(e));
                    }
                } else {
                    OnBitmapLoadedFutureCallback onBitmapLoadedFutureCallback2 = new OnBitmapLoadedFutureCallback(notificationId, builder2, callback);
                    this.pendingOnBitmapLoadedFutureCallback = onBitmapLoadedFutureCallback2;
                    Handler applicationHandler = mediaSession.getImpl().getApplicationHandler();
                    Objects.requireNonNull(applicationHandler);
                    Futures.addCallback(loadBitmapFromMetadata, onBitmapLoadedFutureCallback2, new ConcurrencyHelpers$$ExternalSyntheticLambda0(applicationHandler));
                }
            }
        }
        if (player.isCommandAvailable(3) || Util.SDK_INT < 21) {
            mediaStyle.setCancelButtonIntent(actionFactory.createMediaActionPendingIntent(mediaSession, 3L));
        }
        long playbackStartTimeEpochMs = getPlaybackStartTimeEpochMs(player);
        boolean z = playbackStartTimeEpochMs != -9223372036854775807L;
        if (!z) {
            playbackStartTimeEpochMs = 0;
        }
        builder2.setWhen(playbackStartTimeEpochMs).setShowWhen(z).setUsesChronometer(z);
        if (Util.SDK_INT >= 31) {
            Api31.setForegroundServiceBehavior(builder2);
        }
        return new MediaNotification(notificationId, builder2.setContentIntent(mediaSession.getSessionActivity()).setDeleteIntent(actionFactory.createMediaActionPendingIntent(mediaSession, 3L)).setOnlyAlertOnce(true).setSmallIcon(this.smallIconResourceId).setStyle(mediaStyle).setVisibility(1).setOngoing(false).setGroup(GROUP_KEY).build());
    }

    public final void setSmallIcon(int i) {
        this.smallIconResourceId = i;
    }

    protected ImmutableList<CommandButton> getMediaButtons(MediaSession mediaSession, Player.Commands commands, ImmutableList<CommandButton> immutableList, boolean z) {
        int i;
        String string;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        if (commands.containsAny(7, 6)) {
            Bundle bundle = new Bundle();
            bundle.putInt(COMMAND_KEY_COMPACT_VIEW_INDEX, -1);
            builder.add((ImmutableList.Builder) new CommandButton.Builder().setPlayerCommand(6).setIconResId(R.drawable.media3_notification_seek_to_previous).setDisplayName(this.context.getString(R.string.media3_controls_seek_to_previous_description)).setExtras(bundle).build());
        }
        if (commands.contains(1)) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(COMMAND_KEY_COMPACT_VIEW_INDEX, -1);
            CommandButton.Builder playerCommand = new CommandButton.Builder().setPlayerCommand(1);
            if (z) {
                i = R.drawable.media3_notification_pause;
            } else {
                i = R.drawable.media3_notification_play;
            }
            CommandButton.Builder extras = playerCommand.setIconResId(i).setExtras(bundle2);
            if (z) {
                string = this.context.getString(R.string.media3_controls_pause_description);
            } else {
                string = this.context.getString(R.string.media3_controls_play_description);
            }
            builder.add((ImmutableList.Builder) extras.setDisplayName(string).build());
        }
        if (commands.containsAny(9, 8)) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(COMMAND_KEY_COMPACT_VIEW_INDEX, -1);
            builder.add((ImmutableList.Builder) new CommandButton.Builder().setPlayerCommand(8).setIconResId(R.drawable.media3_notification_seek_to_next).setExtras(bundle3).setDisplayName(this.context.getString(R.string.media3_controls_seek_to_next_description)).build());
        }
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            CommandButton commandButton = immutableList.get(i2);
            if (commandButton.sessionCommand != null && commandButton.sessionCommand.commandCode == 0) {
                builder.add((ImmutableList.Builder) commandButton);
            }
        }
        return builder.build();
    }

    protected int[] addNotificationActions(MediaSession mediaSession, ImmutableList<CommandButton> immutableList, NotificationCompat.Builder builder, MediaNotification.ActionFactory actionFactory) {
        int[] iArr = new int[3];
        int[] iArr2 = new int[3];
        Arrays.fill(iArr, -1);
        Arrays.fill(iArr2, -1);
        int i = 0;
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            CommandButton commandButton = immutableList.get(i2);
            if (commandButton.sessionCommand != null) {
                builder.addAction(actionFactory.createCustomActionFromCustomCommandButton(mediaSession, commandButton));
            } else {
                Assertions.checkState(commandButton.playerCommand != -1);
                builder.addAction(actionFactory.createMediaAction(mediaSession, IconCompat.createWithResource(this.context, commandButton.iconResId), commandButton.displayName, commandButton.playerCommand));
            }
            if (i != 3) {
                int i3 = commandButton.extras.getInt(COMMAND_KEY_COMPACT_VIEW_INDEX, -1);
                if (i3 >= 0 && i3 < 3) {
                    i++;
                    iArr[i3] = i2;
                } else if (commandButton.playerCommand == 7 || commandButton.playerCommand == 6) {
                    iArr2[0] = i2;
                } else if (commandButton.playerCommand == 1) {
                    iArr2[1] = i2;
                } else if (commandButton.playerCommand == 9 || commandButton.playerCommand == 8) {
                    iArr2[2] = i2;
                }
            }
        }
        if (i == 0) {
            int i4 = 0;
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = iArr2[i5];
                if (i6 != -1) {
                    iArr[i4] = i6;
                    i4++;
                }
            }
        }
        for (int i7 = 0; i7 < 3; i7++) {
            if (iArr[i7] == -1) {
                return Arrays.copyOf(iArr, i7);
            }
        }
        return iArr;
    }

    protected CharSequence getNotificationContentTitle(MediaMetadata mediaMetadata) {
        return mediaMetadata.title;
    }

    protected CharSequence getNotificationContentText(MediaMetadata mediaMetadata) {
        return mediaMetadata.artist;
    }

    private void ensureNotificationChannel() {
        NotificationChannel notificationChannel;
        if (Util.SDK_INT >= 26) {
            notificationChannel = this.notificationManager.getNotificationChannel(this.channelId);
            if (notificationChannel != null) {
                return;
            }
            Api26.createNotificationChannel(this.notificationManager, this.channelId, this.context.getString(this.channelNameResourceId));
        }
    }

    private static long getPlaybackStartTimeEpochMs(Player player) {
        if (Util.SDK_INT < 21 || !player.isPlaying() || player.isPlayingAd() || player.isCurrentMediaItemDynamic() || player.getPlaybackParameters().speed != 1.0f) {
            return -9223372036854775807L;
        }
        return System.currentTimeMillis() - player.getContentPosition();
    }

    private static class OnBitmapLoadedFutureCallback implements FutureCallback<Bitmap> {
        private final NotificationCompat.Builder builder;
        private boolean discarded;
        private final int notificationId;
        private final MediaNotification.Provider.Callback onNotificationChangedCallback;

        public OnBitmapLoadedFutureCallback(int i, NotificationCompat.Builder builder, MediaNotification.Provider.Callback callback) {
            this.notificationId = i;
            this.builder = builder;
            this.onNotificationChangedCallback = callback;
        }

        public void discardIfPending() {
            this.discarded = true;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(Bitmap bitmap) {
            if (this.discarded) {
                return;
            }
            this.builder.setLargeIcon(bitmap);
            this.onNotificationChangedCallback.onNotificationChanged(new MediaNotification(this.notificationId, this.builder.build()));
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
            if (this.discarded) {
                return;
            }
            Log.w(DefaultMediaNotificationProvider.TAG, DefaultMediaNotificationProvider.getBitmapLoadErrorMessage(th));
        }
    }

    private static class Api26 {
        private Api26() {
        }

        public static void createNotificationChannel(NotificationManager notificationManager, String str, String str2) {
            NotificationChannel m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(str, str2, 2);
            if (Util.SDK_INT <= 27) {
                m.setShowBadge(false);
            }
            notificationManager.createNotificationChannel(m);
        }
    }

    private static class Api31 {
        private Api31() {
        }

        public static void setForegroundServiceBehavior(NotificationCompat.Builder builder) {
            builder.setForegroundServiceBehavior(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBitmapLoadErrorMessage(Throwable th) {
        return "Failed to load bitmap: " + th.getMessage();
    }
}
