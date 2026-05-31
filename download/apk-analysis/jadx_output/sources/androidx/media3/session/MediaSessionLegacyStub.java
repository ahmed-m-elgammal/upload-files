package androidx.media3.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.util.ObjectsCompat;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda0;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class MediaSessionLegacyStub extends MediaSessionCompat.Callback {
    private static final int DEFAULT_CONNECTION_TIMEOUT_MS = 300000;
    private static final String DEFAULT_MEDIA_SESSION_TAG_DELIM = ".";
    private static final String DEFAULT_MEDIA_SESSION_TAG_PREFIX = "androidx.media3.session.id";
    private static final int PENDING_INTENT_FLAG_MUTABLE;
    private static final String TAG = "MediaSessionLegacyStub";
    private final ComponentName broadcastReceiverComponentName;
    private final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager;
    private final ConnectionTimeoutHandler connectionTimeoutHandler;
    private volatile long connectionTimeoutMs;
    private final ControllerLegacyCbForBroadcast controllerLegacyCbForBroadcast;
    private FutureCallback<Bitmap> pendingBitmapLoadCallback;
    private final MediaButtonReceiver runtimeBroadcastReceiver;
    private final MediaSessionCompat sessionCompat;
    private int sessionFlags;
    private final MediaSessionImpl sessionImpl;
    private final MediaSessionManager sessionManager;
    private VolumeProviderCompat volumeProviderCompat;

    /* JADX INFO: Access modifiers changed from: private */
    interface SessionTask {
        void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException;
    }

    private static <T> void ignoreFuture(Future<T> future) {
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetCaptioningEnabled(boolean z) {
    }

    static {
        PENDING_INTENT_FLAG_MUTABLE = Util.SDK_INT >= 31 ? 33554432 : 0;
    }

    public MediaSessionLegacyStub(MediaSessionImpl mediaSessionImpl, Uri uri, Handler handler) {
        ComponentName serviceComponentByAction;
        boolean z;
        PendingIntent broadcast;
        this.sessionImpl = mediaSessionImpl;
        Context context = mediaSessionImpl.getContext();
        this.sessionManager = MediaSessionManager.getSessionManager(context);
        this.controllerLegacyCbForBroadcast = new ControllerLegacyCbForBroadcast();
        ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
        this.connectedControllersManager = connectedControllersManager;
        this.connectionTimeoutMs = 300000L;
        this.connectionTimeoutHandler = new ConnectionTimeoutHandler(mediaSessionImpl.getApplicationHandler().getLooper(), connectedControllersManager);
        ComponentName queryPackageManagerForMediaButtonReceiver = queryPackageManagerForMediaButtonReceiver(context);
        this.broadcastReceiverComponentName = queryPackageManagerForMediaButtonReceiver;
        if (queryPackageManagerForMediaButtonReceiver == null || Util.SDK_INT < 31) {
            serviceComponentByAction = getServiceComponentByAction(context, MediaLibraryService.SERVICE_INTERFACE);
            serviceComponentByAction = serviceComponentByAction == null ? getServiceComponentByAction(context, MediaSessionService.SERVICE_INTERFACE) : serviceComponentByAction;
            z = (serviceComponentByAction == null || Objects.equals(serviceComponentByAction, queryPackageManagerForMediaButtonReceiver)) ? false : true;
        } else {
            z = false;
            serviceComponentByAction = queryPackageManagerForMediaButtonReceiver;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", uri);
        AnonymousClass1 anonymousClass1 = null;
        if (serviceComponentByAction == null) {
            MediaButtonReceiver mediaButtonReceiver = new MediaButtonReceiver(this, anonymousClass1);
            this.runtimeBroadcastReceiver = mediaButtonReceiver;
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            intentFilter.addDataScheme((String) Util.castNonNull(uri.getScheme()));
            Util.registerReceiverNotExported(context, mediaButtonReceiver, intentFilter);
            intent.setPackage(context.getPackageName());
            broadcast = PendingIntent.getBroadcast(context, 0, intent, PENDING_INTENT_FLAG_MUTABLE);
            serviceComponentByAction = new ComponentName(context, context.getClass());
        } else {
            intent.setComponent(serviceComponentByAction);
            if (z) {
                if (Util.SDK_INT >= 26) {
                    broadcast = PendingIntent.getForegroundService(context, 0, intent, PENDING_INTENT_FLAG_MUTABLE);
                } else {
                    broadcast = PendingIntent.getService(context, 0, intent, PENDING_INTENT_FLAG_MUTABLE);
                }
            } else {
                broadcast = PendingIntent.getBroadcast(context, 0, intent, PENDING_INTENT_FLAG_MUTABLE);
            }
            this.runtimeBroadcastReceiver = null;
        }
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context, TextUtils.join(DEFAULT_MEDIA_SESSION_TAG_DELIM, new String[]{DEFAULT_MEDIA_SESSION_TAG_PREFIX, mediaSessionImpl.getId()}), Util.SDK_INT < 31 ? serviceComponentByAction : null, Util.SDK_INT >= 31 ? null : broadcast, mediaSessionImpl.getToken().getExtras());
        this.sessionCompat = mediaSessionCompat;
        if (Util.SDK_INT >= 31 && queryPackageManagerForMediaButtonReceiver != null) {
            Api31.setMediaButtonBroadcastReceiver(mediaSessionCompat, queryPackageManagerForMediaButtonReceiver);
        }
        PendingIntent sessionActivity = mediaSessionImpl.getSessionActivity();
        if (sessionActivity != null) {
            mediaSessionCompat.setSessionActivity(sessionActivity);
        }
        mediaSessionCompat.setCallback(this, handler);
    }

    private static ComponentName queryPackageManagerForMediaButtonReceiver(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ResolveInfo resolveInfo = queryBroadcastReceivers.get(0);
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }
        if (queryBroadcastReceivers.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 broadcast receiver that handles android.intent.action.MEDIA_BUTTON, found " + queryBroadcastReceivers.size());
    }

    public void start() {
        this.sessionCompat.setActive(true);
    }

    public void release() {
        if (Util.SDK_INT < 31) {
            if (this.broadcastReceiverComponentName == null) {
                setMediaButtonReceiver(this.sessionCompat, null);
            } else {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", this.sessionImpl.getUri());
                intent.setComponent(this.broadcastReceiverComponentName);
                setMediaButtonReceiver(this.sessionCompat, PendingIntent.getBroadcast(this.sessionImpl.getContext(), 0, intent, PENDING_INTENT_FLAG_MUTABLE));
            }
        }
        if (this.runtimeBroadcastReceiver != null) {
            this.sessionImpl.getContext().unregisterReceiver(this.runtimeBroadcastReceiver);
        }
        this.sessionCompat.release();
    }

    public MediaSessionCompat getSessionCompat() {
        return this.sessionCompat;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCommand(String str, final Bundle bundle, final ResultReceiver resultReceiver) {
        Assertions.checkStateNotNull(str);
        if (TextUtils.equals("androidx.media3.session.SESSION_COMMAND_REQUEST_SESSION3_TOKEN", str) && resultReceiver != null) {
            resultReceiver.send(0, this.sessionImpl.getToken().toBundle());
        } else {
            final SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
            dispatchSessionTaskWithSessionCommand(sessionCommand, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda14
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.m773xec90a203(sessionCommand, bundle, resultReceiver, controllerInfo);
                }
            });
        }
    }

    /* renamed from: lambda$onCommand$0$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m773xec90a203(SessionCommand sessionCommand, Bundle bundle, ResultReceiver resultReceiver, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        MediaSessionImpl mediaSessionImpl = this.sessionImpl;
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        ListenableFuture<SessionResult> onCustomCommandOnHandler = mediaSessionImpl.onCustomCommandOnHandler(controllerInfo, sessionCommand, bundle);
        if (resultReceiver != null) {
            sendCustomCommandResultWhenReady(resultReceiver, onCustomCommandOnHandler);
        } else {
            ignoreFuture(onCustomCommandOnHandler);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCustomAction(String str, final Bundle bundle) {
        final SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
        dispatchSessionTaskWithSessionCommand(sessionCommand, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda4
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m774x6dc3132e(sessionCommand, bundle, controllerInfo);
            }
        });
    }

    /* renamed from: lambda$onCustomAction$1$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m774x6dc3132e(SessionCommand sessionCommand, Bundle bundle, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        MediaSessionImpl mediaSessionImpl = this.sessionImpl;
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        ignoreFuture(mediaSessionImpl.onCustomCommandOnHandler(controllerInfo, sessionCommand, bundle));
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public boolean onMediaButtonEvent(Intent intent) {
        return this.sessionImpl.onMediaButtonEvent(new MediaSession.ControllerInfo(this.sessionCompat.getCurrentControllerInfo(), 0, 0, false, null, Bundle.EMPTY), intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeUpdateFlags(PlayerWrapper playerWrapper) {
        int i = playerWrapper.isCommandAvailable(20) ? 4 : 0;
        if (this.sessionFlags != i) {
            this.sessionFlags = i;
            this.sessionCompat.setFlags(i);
        }
    }

    void handleMediaPlayPauseOnHandler(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        dispatchSessionTaskWithPlayerCommand(1, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda27
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m770x31f4e7a8(controllerInfo);
            }
        }, remoteUserInfo);
    }

    /* renamed from: lambda$handleMediaPlayPauseOnHandler$2$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m770x31f4e7a8(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        Util.handlePlayPauseButtonAction(this.sessionImpl.getPlayerWrapper(), this.sessionImpl.shouldPlayIfSuppressed());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepare() {
        dispatchSessionTaskWithPlayerCommand(2, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda15
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m777xfc59f964(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onPrepare$3$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m777xfc59f964(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().prepare();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromMediaId(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(str, null, null, bundle), false);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromSearch(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, null, str, bundle), false);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, uri, null, bundle), false);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlay() {
        final MediaSessionImpl mediaSessionImpl = this.sessionImpl;
        Objects.requireNonNull(mediaSessionImpl);
        dispatchSessionTaskWithPlayerCommand(1, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda25
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionImpl.this.handleMediaControllerPlayRequest(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromMediaId(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(str, null, null, bundle), true);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromSearch(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, null, str, bundle), true);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromUri(Uri uri, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, uri, null, bundle), true);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPause() {
        dispatchSessionTaskWithPlayerCommand(1, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda0
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m776lambda$onPause$4$androidxmedia3sessionMediaSessionLegacyStub(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onPause$4$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m776lambda$onPause$4$androidxmedia3sessionMediaSessionLegacyStub(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        Util.handlePauseButtonAction(this.sessionImpl.getPlayerWrapper());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onStop() {
        dispatchSessionTaskWithPlayerCommand(3, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda18
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m790lambda$onStop$5$androidxmedia3sessionMediaSessionLegacyStub(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onStop$5$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m790lambda$onStop$5$androidxmedia3sessionMediaSessionLegacyStub(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().stop();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSeekTo(final long j) {
        dispatchSessionTaskWithPlayerCommand(5, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda24
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m780lambda$onSeekTo$6$androidxmedia3sessionMediaSessionLegacyStub(j, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onSeekTo$6$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m780lambda$onSeekTo$6$androidxmedia3sessionMediaSessionLegacyStub(long j, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekTo(j);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToNext() {
        if (this.sessionImpl.getPlayerWrapper().isCommandAvailable(9)) {
            dispatchSessionTaskWithPlayerCommand(9, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda22
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.m785xf713cec2(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        } else {
            dispatchSessionTaskWithPlayerCommand(8, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda23
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.m786x30de70a1(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        }
    }

    /* renamed from: lambda$onSkipToNext$7$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m785xf713cec2(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToNext();
    }

    /* renamed from: lambda$onSkipToNext$8$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m786x30de70a1(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToNextMediaItem();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToPrevious() {
        if (this.sessionImpl.getPlayerWrapper().isCommandAvailable(7)) {
            dispatchSessionTaskWithPlayerCommand(7, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda7
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.m788x42d945fc(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        } else {
            dispatchSessionTaskWithPlayerCommand(6, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda8
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub.this.m787x6478fb88(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        }
    }

    /* renamed from: lambda$onSkipToPrevious$9$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m788x42d945fc(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToPrevious();
    }

    /* renamed from: lambda$onSkipToPrevious$10$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m787x6478fb88(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToPreviousMediaItem();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetPlaybackSpeed(final float f) {
        if (f <= 0.0f) {
            return;
        }
        dispatchSessionTaskWithPlayerCommand(13, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda1
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m781x43347260(f, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onSetPlaybackSpeed$11$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m781x43347260(float f, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().setPlaybackSpeed(f);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToQueueItem(final long j) {
        if (j < 0) {
            return;
        }
        dispatchSessionTaskWithPlayerCommand(10, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda3
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m789x5172da7(j, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onSkipToQueueItem$12$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m789x5172da7(long j, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToDefaultPosition((int) j);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onFastForward() {
        dispatchSessionTaskWithPlayerCommand(12, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda10
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m775xe2a98605(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onFastForward$13$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m775xe2a98605(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekForward();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRewind() {
        dispatchSessionTaskWithPlayerCommand(11, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda13
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m779x58ead3ce(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onRewind$14$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m779x58ead3ce(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekBack();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat) {
        onSetRating(ratingCompat, null);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        final Rating convertToRating = LegacyConversions.convertToRating(ratingCompat);
        if (convertToRating == null) {
            Log.w(TAG, "Ignoring invalid RatingCompat " + ratingCompat);
            return;
        }
        dispatchSessionTaskWithSessionCommand(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda9
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m782xc54a8f19(convertToRating, controllerInfo);
            }
        });
    }

    /* renamed from: lambda$onSetRating$15$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m782xc54a8f19(Rating rating, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        MediaItem currentMediaItemWithCommandCheck = this.sessionImpl.getPlayerWrapper().getCurrentMediaItemWithCommandCheck();
        if (currentMediaItemWithCommandCheck == null) {
            return;
        }
        ignoreFuture(this.sessionImpl.onSetRatingOnHandler(controllerInfo, currentMediaItemWithCommandCheck.mediaId, rating));
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRepeatMode(final int i) {
        dispatchSessionTaskWithPlayerCommand(15, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda11
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m783xd6b3aff9(i, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onSetRepeatMode$16$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m783xd6b3aff9(int i, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().setRepeatMode(LegacyConversions.convertToRepeatMode(i));
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetShuffleMode(final int i) {
        dispatchSessionTaskWithPlayerCommand(14, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda26
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m784x6ae30d6a(i, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onSetShuffleMode$17$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m784x6ae30d6a(int i, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().setShuffleModeEnabled(LegacyConversions.convertToShuffleModeEnabled(i));
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        handleOnAddQueueItem(mediaDescriptionCompat, -1);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        handleOnAddQueueItem(mediaDescriptionCompat, i);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTaskWithPlayerCommand(20, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda5
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m778xdd4a6a77(mediaDescriptionCompat, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$onRemoveQueueItem$18$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m778xdd4a6a77(MediaDescriptionCompat mediaDescriptionCompat, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        String mediaId = mediaDescriptionCompat.getMediaId();
        if (TextUtils.isEmpty(mediaId)) {
            Log.w(TAG, "onRemoveQueueItem(): Media ID shouldn't be null");
            return;
        }
        PlayerWrapper playerWrapper = this.sessionImpl.getPlayerWrapper();
        if (!playerWrapper.isCommandAvailable(17)) {
            Log.w(TAG, "Can't remove item by ID without COMMAND_GET_TIMELINE being available");
            return;
        }
        Timeline currentTimeline = playerWrapper.getCurrentTimeline();
        Timeline.Window window = new Timeline.Window();
        for (int i = 0; i < currentTimeline.getWindowCount(); i++) {
            if (TextUtils.equals(currentTimeline.getWindow(i, window).mediaItem.mediaId, mediaId)) {
                playerWrapper.removeMediaItem(i);
                return;
            }
        }
    }

    public MediaSession.ControllerCb getControllerLegacyCbForBroadcast() {
        return this.controllerLegacyCbForBroadcast;
    }

    public ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> getConnectedControllersManager() {
        return this.connectedControllersManager;
    }

    boolean canResumePlaybackOnStart() {
        return this.broadcastReceiverComponentName != null;
    }

    private void dispatchSessionTaskWithPlayerCommand(final int i, final SessionTask sessionTask, final MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        if (this.sessionImpl.isReleased()) {
            return;
        }
        if (remoteUserInfo == null) {
            Log.d(TAG, "RemoteUserInfo is null, ignoring command=" + i);
            return;
        }
        Util.postOrRun(this.sessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionLegacyStub.this.m768xa9f680bc(i, remoteUserInfo, sessionTask);
            }
        });
    }

    /* renamed from: lambda$dispatchSessionTaskWithPlayerCommand$20$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m768xa9f680bc(int i, MediaSessionManager.RemoteUserInfo remoteUserInfo, final SessionTask sessionTask) {
        if (this.sessionImpl.isReleased()) {
            return;
        }
        if (!this.sessionCompat.isActive()) {
            Log.w(TAG, "Ignore incoming player command before initialization. command=" + i + ", pid=" + remoteUserInfo.getPid());
            return;
        }
        final MediaSession.ControllerInfo tryGetController = tryGetController(remoteUserInfo);
        if (tryGetController == null) {
            return;
        }
        if (!this.connectedControllersManager.isPlayerCommandAvailable(tryGetController, i)) {
            if (i != 1 || this.sessionImpl.getPlayerWrapper().getPlayWhenReady()) {
                return;
            }
            Log.w(TAG, "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
            return;
        }
        if (this.sessionImpl.onPlayerCommandRequestOnHandler(tryGetController, i) != 0) {
            return;
        }
        this.sessionImpl.callWithControllerForCurrentRequestSet(tryGetController, new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionLegacyStub.lambda$dispatchSessionTaskWithPlayerCommand$19(MediaSessionLegacyStub.SessionTask.this, tryGetController);
            }
        }).run();
    }

    static /* synthetic */ void lambda$dispatchSessionTaskWithPlayerCommand$19(SessionTask sessionTask, MediaSession.ControllerInfo controllerInfo) {
        try {
            sessionTask.run(controllerInfo);
        } catch (RemoteException e) {
            Log.w(TAG, "Exception in " + controllerInfo, e);
        }
    }

    private void dispatchSessionTaskWithSessionCommand(int i, SessionTask sessionTask) {
        dispatchSessionTaskWithSessionCommandInternal(null, i, sessionTask, this.sessionCompat.getCurrentControllerInfo());
    }

    private void dispatchSessionTaskWithSessionCommand(SessionCommand sessionCommand, SessionTask sessionTask) {
        dispatchSessionTaskWithSessionCommandInternal(sessionCommand, 0, sessionTask, this.sessionCompat.getCurrentControllerInfo());
    }

    private void dispatchSessionTaskWithSessionCommandInternal(final SessionCommand sessionCommand, final int i, final SessionTask sessionTask, final MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo == null) {
            StringBuilder sb = new StringBuilder("RemoteUserInfo is null, ignoring command=");
            Object obj = sessionCommand;
            if (sessionCommand == null) {
                obj = Integer.valueOf(i);
            }
            sb.append(obj);
            Log.d(TAG, sb.toString());
            return;
        }
        Util.postOrRun(this.sessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionLegacyStub.this.m769x8f819e77(sessionCommand, i, remoteUserInfo, sessionTask);
            }
        });
    }

    /* renamed from: lambda$dispatchSessionTaskWithSessionCommandInternal$21$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m769x8f819e77(SessionCommand sessionCommand, int i, MediaSessionManager.RemoteUserInfo remoteUserInfo, SessionTask sessionTask) {
        if (this.sessionImpl.isReleased()) {
            return;
        }
        if (!this.sessionCompat.isActive()) {
            StringBuilder sb = new StringBuilder("Ignore incoming session command before initialization. command=");
            sb.append(sessionCommand == null ? Integer.valueOf(i) : sessionCommand.customAction);
            sb.append(", pid=");
            sb.append(remoteUserInfo.getPid());
            Log.w(TAG, sb.toString());
            return;
        }
        MediaSession.ControllerInfo tryGetController = tryGetController(remoteUserInfo);
        if (tryGetController == null) {
            return;
        }
        if (sessionCommand != null) {
            if (!this.connectedControllersManager.isSessionCommandAvailable(tryGetController, sessionCommand)) {
                return;
            }
        } else if (!this.connectedControllersManager.isSessionCommandAvailable(tryGetController, i)) {
            return;
        }
        try {
            sessionTask.run(tryGetController);
        } catch (RemoteException e) {
            Log.w(TAG, "Exception in " + tryGetController, e);
        }
    }

    private MediaSession.ControllerInfo tryGetController(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        MediaSession.ControllerInfo controller = this.connectedControllersManager.getController(remoteUserInfo);
        if (controller == null) {
            ControllerLegacyCb controllerLegacyCb = new ControllerLegacyCb(remoteUserInfo);
            MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, 0, 0, this.sessionManager.isTrustedForMediaControl(remoteUserInfo), controllerLegacyCb, Bundle.EMPTY);
            MediaSession.ConnectionResult onConnectOnHandler = this.sessionImpl.onConnectOnHandler(controllerInfo);
            if (!onConnectOnHandler.isAccepted) {
                try {
                    controllerLegacyCb.onDisconnected(0);
                    return null;
                } catch (RemoteException unused) {
                    return null;
                }
            }
            this.connectedControllersManager.addController(controllerInfo.getRemoteUserInfo(), controllerInfo, onConnectOnHandler.availableSessionCommands, onConnectOnHandler.availablePlayerCommands);
            controller = controllerInfo;
        }
        this.connectionTimeoutHandler.disconnectControllerAfterTimeout(controller, this.connectionTimeoutMs);
        return controller;
    }

    public void setLegacyControllerDisconnectTimeoutMs(long j) {
        this.connectionTimeoutMs = j;
    }

    public void updateLegacySessionPlaybackState(final PlayerWrapper playerWrapper) {
        Util.postOrRun(this.sessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionLegacyStub.this.m791xf4f5e6e9(playerWrapper);
            }
        });
    }

    /* renamed from: lambda$updateLegacySessionPlaybackState$22$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m791xf4f5e6e9(PlayerWrapper playerWrapper) {
        this.sessionCompat.setPlaybackState(playerWrapper.createPlaybackStateCompat());
    }

    public void updateLegacySessionPlaybackStateAndQueue(final PlayerWrapper playerWrapper) {
        Util.postOrRun(this.sessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionLegacyStub.this.m792xea8a90e2(playerWrapper);
            }
        });
    }

    /* renamed from: lambda$updateLegacySessionPlaybackStateAndQueue$23$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m792xea8a90e2(PlayerWrapper playerWrapper) {
        Timeline timeline;
        this.sessionCompat.setPlaybackState(playerWrapper.createPlaybackStateCompat());
        ControllerLegacyCbForBroadcast controllerLegacyCbForBroadcast = this.controllerLegacyCbForBroadcast;
        if (playerWrapper.getAvailableCommands().contains(17)) {
            timeline = playerWrapper.getCurrentTimeline();
        } else {
            timeline = Timeline.EMPTY;
        }
        controllerLegacyCbForBroadcast.updateQueue(timeline);
    }

    private void handleMediaRequest(final MediaItem mediaItem, final boolean z) {
        dispatchSessionTaskWithPlayerCommand(31, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda19
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) {
                MediaSessionLegacyStub.this.m771xe9158228(mediaItem, z, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* renamed from: lambda$handleMediaRequest$24$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m771xe9158228(MediaItem mediaItem, boolean z, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        Futures.addCallback(this.sessionImpl.onSetMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem), -1, -9223372036854775807L), new AnonymousClass1(controllerInfo, z), MoreExecutors.directExecutor());
    }

    /* renamed from: androidx.media3.session.MediaSessionLegacyStub$1, reason: invalid class name */
    class AnonymousClass1 implements FutureCallback<MediaSession.MediaItemsWithStartPosition> {
        final /* synthetic */ MediaSession.ControllerInfo val$controller;
        final /* synthetic */ boolean val$play;

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
        }

        AnonymousClass1(MediaSession.ControllerInfo controllerInfo, boolean z) {
            this.val$controller = controllerInfo;
            this.val$play = z;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(final MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
            Handler applicationHandler = MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler();
            MediaSessionImpl mediaSessionImpl = MediaSessionLegacyStub.this.sessionImpl;
            MediaSession.ControllerInfo controllerInfo = this.val$controller;
            final boolean z = this.val$play;
            Util.postOrRun(applicationHandler, mediaSessionImpl.callWithControllerForCurrentRequestSet(controllerInfo, new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.AnonymousClass1.this.m793xec13c618(mediaItemsWithStartPosition, z);
                }
            }));
        }

        /* renamed from: lambda$onSuccess$0$androidx-media3-session-MediaSessionLegacyStub$1, reason: not valid java name */
        /* synthetic */ void m793xec13c618(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition, boolean z) {
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaUtils.setMediaItemsWithStartIndexAndPosition(playerWrapper, mediaItemsWithStartPosition);
            int playbackState = playerWrapper.getPlaybackState();
            if (playbackState == 1) {
                playerWrapper.prepareIfCommandAvailable();
            } else if (playbackState == 4) {
                playerWrapper.seekToDefaultPositionIfCommandAvailable();
            }
            if (z) {
                playerWrapper.playIfCommandAvailable();
            }
        }
    }

    private void handleOnAddQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int i) {
        if (mediaDescriptionCompat != null) {
            if (i == -1 || i >= 0) {
                dispatchSessionTaskWithPlayerCommand(20, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda2
                    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                    public final void run(MediaSession.ControllerInfo controllerInfo) {
                        MediaSessionLegacyStub.this.m772xabb1009e(mediaDescriptionCompat, i, controllerInfo);
                    }
                }, this.sessionCompat.getCurrentControllerInfo());
            }
        }
    }

    /* renamed from: lambda$handleOnAddQueueItem$25$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m772xabb1009e(MediaDescriptionCompat mediaDescriptionCompat, int i, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
            Log.w(TAG, "onAddQueueItem(): Media ID shouldn't be empty");
        } else {
            Futures.addCallback(this.sessionImpl.onAddMediaItemsOnHandler(controllerInfo, ImmutableList.of(LegacyConversions.convertToMediaItem(mediaDescriptionCompat))), new AnonymousClass2(controllerInfo, i), MoreExecutors.directExecutor());
        }
    }

    /* renamed from: androidx.media3.session.MediaSessionLegacyStub$2, reason: invalid class name */
    class AnonymousClass2 implements FutureCallback<List<MediaItem>> {
        final /* synthetic */ MediaSession.ControllerInfo val$controller;
        final /* synthetic */ int val$index;

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
        }

        AnonymousClass2(MediaSession.ControllerInfo controllerInfo, int i) {
            this.val$controller = controllerInfo;
            this.val$index = i;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(final List<MediaItem> list) {
            Handler applicationHandler = MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler();
            MediaSessionImpl mediaSessionImpl = MediaSessionLegacyStub.this.sessionImpl;
            MediaSession.ControllerInfo controllerInfo = this.val$controller;
            final int i = this.val$index;
            Util.postOrRun(applicationHandler, mediaSessionImpl.callWithControllerForCurrentRequestSet(controllerInfo, new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.AnonymousClass2.this.m794xec13c619(i, list);
                }
            }));
        }

        /* renamed from: lambda$onSuccess$0$androidx-media3-session-MediaSessionLegacyStub$2, reason: not valid java name */
        /* synthetic */ void m794xec13c619(int i, List list) {
            if (i == -1) {
                MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().addMediaItems(list);
            } else {
                MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().addMediaItems(i, list);
            }
        }
    }

    private static void sendCustomCommandResultWhenReady(final ResultReceiver resultReceiver, final ListenableFuture<SessionResult> listenableFuture) {
        listenableFuture.addListener(new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionLegacyStub.lambda$sendCustomCommandResultWhenReady$26(ListenableFuture.this, resultReceiver);
            }
        }, MoreExecutors.directExecutor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$sendCustomCommandResultWhenReady$26(ListenableFuture listenableFuture, ResultReceiver resultReceiver) {
        SessionResult sessionResult;
        try {
            sessionResult = (SessionResult) Assertions.checkNotNull((SessionResult) listenableFuture.get(), "SessionResult must not be null");
        } catch (InterruptedException e) {
            e = e;
            Log.w(TAG, "Custom command failed", e);
            sessionResult = new SessionResult(-1);
        } catch (CancellationException e2) {
            Log.w(TAG, "Custom command cancelled", e2);
            sessionResult = new SessionResult(1);
        } catch (ExecutionException e3) {
            e = e3;
            Log.w(TAG, "Custom command failed", e);
            sessionResult = new SessionResult(-1);
        }
        resultReceiver.send(sessionResult.resultCode, sessionResult.extras);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setMetadata(MediaSessionCompat mediaSessionCompat, MediaMetadataCompat mediaMetadataCompat) {
        mediaSessionCompat.setMetadata(mediaMetadataCompat);
    }

    private static void setMediaButtonReceiver(MediaSessionCompat mediaSessionCompat, PendingIntent pendingIntent) {
        mediaSessionCompat.setMediaButtonReceiver(pendingIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setQueue(MediaSessionCompat mediaSessionCompat, List<MediaSessionCompat.QueueItem> list) {
        mediaSessionCompat.setQueue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQueueTitle(MediaSessionCompat mediaSessionCompat, CharSequence charSequence) {
        if (!isQueueEnabled()) {
            charSequence = null;
        }
        mediaSessionCompat.setQueueTitle(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isQueueEnabled() {
        PlayerWrapper playerWrapper = this.sessionImpl.getPlayerWrapper();
        return playerWrapper.getAvailablePlayerCommands().contains(17) && playerWrapper.getAvailableCommands().contains(17);
    }

    private static MediaItem createMediaItemForMediaRequest(String str, Uri uri, String str2, Bundle bundle) {
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str == null) {
            str = "";
        }
        return builder.setMediaId(str).setRequestMetadata(new MediaItem.RequestMetadata.Builder().setMediaUri(uri).setSearchQuery(str2).setExtras(bundle).build()).build();
    }

    private static final class ControllerLegacyCb implements MediaSession.ControllerCb {
        private final MediaSessionManager.RemoteUserInfo remoteUserInfo;

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onAudioAttributesChanged(int i, AudioAttributes audioAttributes) {
            MediaSession.ControllerCb.CC.$default$onAudioAttributesChanged(this, i, audioAttributes);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onAvailableCommandsChangedFromPlayer(int i, Player.Commands commands) {
            MediaSession.ControllerCb.CC.$default$onAvailableCommandsChangedFromPlayer(this, i, commands);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onAvailableCommandsChangedFromSession(int i, SessionCommands sessionCommands, Player.Commands commands) {
            MediaSession.ControllerCb.CC.$default$onAvailableCommandsChangedFromSession(this, i, sessionCommands, commands);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onChildrenChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) {
            MediaSession.ControllerCb.CC.$default$onChildrenChanged(this, i, str, i2, libraryParams);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onDeviceInfoChanged(int i, DeviceInfo deviceInfo) {
            MediaSession.ControllerCb.CC.$default$onDeviceInfoChanged(this, i, deviceInfo);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onDeviceVolumeChanged(int i, int i2, boolean z) {
            MediaSession.ControllerCb.CC.$default$onDeviceVolumeChanged(this, i, i2, z);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onDisconnected(int i) {
            MediaSession.ControllerCb.CC.$default$onDisconnected(this, i);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onIsLoadingChanged(int i, boolean z) {
            MediaSession.ControllerCb.CC.$default$onIsLoadingChanged(this, i, z);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onIsPlayingChanged(int i, boolean z) {
            MediaSession.ControllerCb.CC.$default$onIsPlayingChanged(this, i, z);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onLibraryResult(int i, LibraryResult libraryResult) {
            MediaSession.ControllerCb.CC.$default$onLibraryResult(this, i, libraryResult);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onMediaItemTransition(int i, MediaItem mediaItem, int i2) {
            MediaSession.ControllerCb.CC.$default$onMediaItemTransition(this, i, mediaItem, i2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onMediaMetadataChanged(int i, MediaMetadata mediaMetadata) {
            MediaSession.ControllerCb.CC.$default$onMediaMetadataChanged(this, i, mediaMetadata);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPeriodicSessionPositionInfoChanged(int i, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, int i2) {
            MediaSession.ControllerCb.CC.$default$onPeriodicSessionPositionInfoChanged(this, i, sessionPositionInfo, z, z2, i2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlayWhenReadyChanged(int i, boolean z, int i2) {
            MediaSession.ControllerCb.CC.$default$onPlayWhenReadyChanged(this, i, z, i2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlaybackParametersChanged(int i, PlaybackParameters playbackParameters) {
            MediaSession.ControllerCb.CC.$default$onPlaybackParametersChanged(this, i, playbackParameters);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlaybackStateChanged(int i, int i2, PlaybackException playbackException) {
            MediaSession.ControllerCb.CC.$default$onPlaybackStateChanged(this, i, i2, playbackException);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i, int i2) {
            MediaSession.ControllerCb.CC.$default$onPlaybackSuppressionReasonChanged(this, i, i2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlayerChanged(int i, PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) {
            MediaSession.ControllerCb.CC.$default$onPlayerChanged(this, i, playerWrapper, playerWrapper2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlayerError(int i, PlaybackException playbackException) {
            MediaSession.ControllerCb.CC.$default$onPlayerError(this, i, playbackException);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlayerInfoChanged(int i, PlayerInfo playerInfo, Player.Commands commands, boolean z, boolean z2, int i2) {
            MediaSession.ControllerCb.CC.$default$onPlayerInfoChanged(this, i, playerInfo, commands, z, z2, i2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) {
            MediaSession.ControllerCb.CC.$default$onPlaylistMetadataChanged(this, i, mediaMetadata);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            MediaSession.ControllerCb.CC.$default$onPositionDiscontinuity(this, i, positionInfo, positionInfo2, i2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onRenderedFirstFrame(int i) {
            MediaSession.ControllerCb.CC.$default$onRenderedFirstFrame(this, i);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onRepeatModeChanged(int i, int i2) {
            MediaSession.ControllerCb.CC.$default$onRepeatModeChanged(this, i, i2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSearchResultChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) {
            MediaSession.ControllerCb.CC.$default$onSearchResultChanged(this, i, str, i2, libraryParams);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSeekBackIncrementChanged(int i, long j) {
            MediaSession.ControllerCb.CC.$default$onSeekBackIncrementChanged(this, i, j);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSeekForwardIncrementChanged(int i, long j) {
            MediaSession.ControllerCb.CC.$default$onSeekForwardIncrementChanged(this, i, j);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSessionActivityChanged(int i, PendingIntent pendingIntent) {
            MediaSession.ControllerCb.CC.$default$onSessionActivityChanged(this, i, pendingIntent);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSessionExtrasChanged(int i, Bundle bundle) {
            MediaSession.ControllerCb.CC.$default$onSessionExtrasChanged(this, i, bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSessionResult(int i, SessionResult sessionResult) {
            MediaSession.ControllerCb.CC.$default$onSessionResult(this, i, sessionResult);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onShuffleModeEnabledChanged(int i, boolean z) {
            MediaSession.ControllerCb.CC.$default$onShuffleModeEnabledChanged(this, i, z);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onTimelineChanged(int i, Timeline timeline, int i2) {
            MediaSession.ControllerCb.CC.$default$onTimelineChanged(this, i, timeline, i2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onTrackSelectionParametersChanged(int i, TrackSelectionParameters trackSelectionParameters) {
            MediaSession.ControllerCb.CC.$default$onTrackSelectionParametersChanged(this, i, trackSelectionParameters);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onTracksChanged(int i, Tracks tracks) {
            MediaSession.ControllerCb.CC.$default$onTracksChanged(this, i, tracks);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onVideoSizeChanged(int i, VideoSize videoSize) {
            MediaSession.ControllerCb.CC.$default$onVideoSizeChanged(this, i, videoSize);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onVolumeChanged(int i, float f) {
            MediaSession.ControllerCb.CC.$default$onVolumeChanged(this, i, f);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void sendCustomCommand(int i, SessionCommand sessionCommand, Bundle bundle) {
            MediaSession.ControllerCb.CC.$default$sendCustomCommand(this, i, sessionCommand, bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void setCustomLayout(int i, List list) {
            MediaSession.ControllerCb.CC.$default$setCustomLayout(this, i, list);
        }

        public ControllerLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.remoteUserInfo = remoteUserInfo;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.remoteUserInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ControllerLegacyCb.class) {
                return false;
            }
            return Util.areEqual(this.remoteUserInfo, ((ControllerLegacyCb) obj).remoteUserInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ControllerLegacyCbForBroadcast implements MediaSession.ControllerCb {
        private Uri lastMediaUri;
        private MediaMetadata lastMediaMetadata = MediaMetadata.EMPTY;
        private String lastMediaId = "";
        private long lastDurationMs = -9223372036854775807L;

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onAvailableCommandsChangedFromSession(int i, SessionCommands sessionCommands, Player.Commands commands) {
            MediaSession.ControllerCb.CC.$default$onAvailableCommandsChangedFromSession(this, i, sessionCommands, commands);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onChildrenChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) {
            MediaSession.ControllerCb.CC.$default$onChildrenChanged(this, i, str, i2, libraryParams);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDisconnected(int i) throws RemoteException {
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onIsLoadingChanged(int i, boolean z) {
            MediaSession.ControllerCb.CC.$default$onIsLoadingChanged(this, i, z);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onLibraryResult(int i, LibraryResult libraryResult) {
            MediaSession.ControllerCb.CC.$default$onLibraryResult(this, i, libraryResult);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onPlayerInfoChanged(int i, PlayerInfo playerInfo, Player.Commands commands, boolean z, boolean z2, int i2) {
            MediaSession.ControllerCb.CC.$default$onPlayerInfoChanged(this, i, playerInfo, commands, z, z2, i2);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onRenderedFirstFrame(int i) {
            MediaSession.ControllerCb.CC.$default$onRenderedFirstFrame(this, i);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSearchResultChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) {
            MediaSession.ControllerCb.CC.$default$onSearchResultChanged(this, i, str, i2, libraryParams);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSeekBackIncrementChanged(int i, long j) {
            MediaSession.ControllerCb.CC.$default$onSeekBackIncrementChanged(this, i, j);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSeekForwardIncrementChanged(int i, long j) {
            MediaSession.ControllerCb.CC.$default$onSeekForwardIncrementChanged(this, i, j);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSessionActivityChanged(int i, PendingIntent pendingIntent) {
            MediaSession.ControllerCb.CC.$default$onSessionActivityChanged(this, i, pendingIntent);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onSessionResult(int i, SessionResult sessionResult) {
            MediaSession.ControllerCb.CC.$default$onSessionResult(this, i, sessionResult);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onTrackSelectionParametersChanged(int i, TrackSelectionParameters trackSelectionParameters) {
            MediaSession.ControllerCb.CC.$default$onTrackSelectionParametersChanged(this, i, trackSelectionParameters);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onTracksChanged(int i, Tracks tracks) {
            MediaSession.ControllerCb.CC.$default$onTracksChanged(this, i, tracks);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onVideoSizeChanged(int i, VideoSize videoSize) {
            MediaSession.ControllerCb.CC.$default$onVideoSizeChanged(this, i, videoSize);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public /* synthetic */ void onVolumeChanged(int i, float f) {
            MediaSession.ControllerCb.CC.$default$onVolumeChanged(this, i, f);
        }

        public ControllerLegacyCbForBroadcast() {
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onAvailableCommandsChangedFromPlayer(int i, Player.Commands commands) {
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaSessionLegacyStub.this.maybeUpdateFlags(playerWrapper);
            MediaSessionLegacyStub.this.updateLegacySessionPlaybackState(playerWrapper);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayerChanged(int i, PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) throws RemoteException {
            Timeline currentTimelineWithCommandCheck = playerWrapper2.getCurrentTimelineWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getCurrentTimelineWithCommandCheck(), currentTimelineWithCommandCheck)) {
                onTimelineChanged(i, currentTimelineWithCommandCheck, 0);
            }
            MediaMetadata playlistMetadataWithCommandCheck = playerWrapper2.getPlaylistMetadataWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getPlaylistMetadataWithCommandCheck(), playlistMetadataWithCommandCheck)) {
                onPlaylistMetadataChanged(i, playlistMetadataWithCommandCheck);
            }
            MediaMetadata mediaMetadataWithCommandCheck = playerWrapper2.getMediaMetadataWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getMediaMetadataWithCommandCheck(), mediaMetadataWithCommandCheck)) {
                onMediaMetadataChanged(i, mediaMetadataWithCommandCheck);
            }
            if (playerWrapper == null || playerWrapper.getShuffleModeEnabled() != playerWrapper2.getShuffleModeEnabled()) {
                onShuffleModeEnabledChanged(i, playerWrapper2.getShuffleModeEnabled());
            }
            if (playerWrapper == null || playerWrapper.getRepeatMode() != playerWrapper2.getRepeatMode()) {
                onRepeatModeChanged(i, playerWrapper2.getRepeatMode());
            }
            onDeviceInfoChanged(i, playerWrapper2.getDeviceInfo());
            MediaSessionLegacyStub.this.maybeUpdateFlags(playerWrapper2);
            MediaItem currentMediaItemWithCommandCheck = playerWrapper2.getCurrentMediaItemWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getCurrentMediaItemWithCommandCheck(), currentMediaItemWithCommandCheck)) {
                onMediaItemTransition(i, currentMediaItemWithCommandCheck, 3);
            } else {
                MediaSessionLegacyStub.this.updateLegacySessionPlaybackState(playerWrapper2);
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayerError(int i, PlaybackException playbackException) {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.getPlayerWrapper());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void setCustomLayout(int i, List<CommandButton> list) {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.getPlayerWrapper());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSessionExtrasChanged(int i, Bundle bundle) {
            MediaSessionLegacyStub.this.sessionCompat.setExtras(bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i, SessionCommand sessionCommand, Bundle bundle) {
            MediaSessionLegacyStub.this.sessionCompat.sendSessionEvent(sessionCommand.customAction, bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayWhenReadyChanged(int i, boolean z, int i2) throws RemoteException {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.getPlayerWrapper());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaybackSuppressionReasonChanged(int i, int i2) throws RemoteException {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.getPlayerWrapper());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaybackStateChanged(int i, int i2, PlaybackException playbackException) throws RemoteException {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.getPlayerWrapper());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onIsPlayingChanged(int i, boolean z) throws RemoteException {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.getPlayerWrapper());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) throws RemoteException {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.getPlayerWrapper());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaybackParametersChanged(int i, PlaybackParameters playbackParameters) throws RemoteException {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.getPlayerWrapper());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onMediaItemTransition(int i, MediaItem mediaItem, int i2) throws RemoteException {
            updateMetadataIfChanged();
            if (mediaItem == null) {
                MediaSessionLegacyStub.this.sessionCompat.setRatingType(0);
            } else {
                MediaSessionLegacyStub.this.sessionCompat.setRatingType(LegacyConversions.getRatingCompatStyle(mediaItem.mediaMetadata.userRating));
            }
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.getPlayerWrapper());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onMediaMetadataChanged(int i, MediaMetadata mediaMetadata) {
            updateMetadataIfChanged();
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onTimelineChanged(int i, Timeline timeline, int i2) throws RemoteException {
            updateQueue(timeline);
            updateMetadataIfChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateQueue(final Timeline timeline) {
            if (!MediaSessionLegacyStub.this.isQueueEnabled() || timeline.isEmpty()) {
                MediaSessionLegacyStub.setQueue(MediaSessionLegacyStub.this.sessionCompat, null);
                return;
            }
            final List<MediaItem> convertToMediaItemList = LegacyConversions.convertToMediaItemList(timeline);
            final ArrayList arrayList = new ArrayList();
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            Runnable runnable = new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$ControllerLegacyCbForBroadcast$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.ControllerLegacyCbForBroadcast.this.m795x58a50959(atomicInteger, convertToMediaItemList, arrayList, timeline);
                }
            };
            for (int i = 0; i < convertToMediaItemList.size(); i++) {
                MediaMetadata mediaMetadata = convertToMediaItemList.get(i).mediaMetadata;
                if (mediaMetadata.artworkData != null) {
                    ListenableFuture<Bitmap> decodeBitmap = MediaSessionLegacyStub.this.sessionImpl.getBitmapLoader().decodeBitmap(mediaMetadata.artworkData);
                    arrayList.add(decodeBitmap);
                    Handler applicationHandler = MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler();
                    Objects.requireNonNull(applicationHandler);
                    decodeBitmap.addListener(runnable, new ConcurrencyHelpers$$ExternalSyntheticLambda0(applicationHandler));
                } else {
                    arrayList.add(null);
                    runnable.run();
                }
            }
        }

        /* renamed from: lambda$updateQueue$0$androidx-media3-session-MediaSessionLegacyStub$ControllerLegacyCbForBroadcast, reason: not valid java name */
        /* synthetic */ void m795x58a50959(AtomicInteger atomicInteger, List list, List list2, Timeline timeline) {
            if (atomicInteger.incrementAndGet() == list.size()) {
                handleBitmapFuturesAllCompletedAndSetQueue(list2, timeline, list);
            }
        }

        private void handleBitmapFuturesAllCompletedAndSetQueue(List<ListenableFuture<Bitmap>> list, Timeline timeline, List<MediaItem> list2) {
            Bitmap bitmap;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                ListenableFuture<Bitmap> listenableFuture = list.get(i);
                if (listenableFuture != null) {
                    try {
                        bitmap = (Bitmap) Futures.getDone(listenableFuture);
                    } catch (CancellationException | ExecutionException e) {
                        Log.d(MediaSessionLegacyStub.TAG, "Failed to get bitmap", e);
                    }
                    arrayList.add(LegacyConversions.convertToQueueItem(list2.get(i), i, bitmap));
                }
                bitmap = null;
                arrayList.add(LegacyConversions.convertToQueueItem(list2.get(i), i, bitmap));
            }
            if (Util.SDK_INT >= 21) {
                MediaSessionLegacyStub.setQueue(MediaSessionLegacyStub.this.sessionCompat, arrayList);
                return;
            }
            List truncateListBySize = MediaUtils.truncateListBySize(arrayList, 262144);
            if (truncateListBySize.size() != timeline.getWindowCount()) {
                Log.i(MediaSessionLegacyStub.TAG, "Sending " + truncateListBySize.size() + " items out of " + timeline.getWindowCount());
            }
            MediaSessionLegacyStub.setQueue(MediaSessionLegacyStub.this.sessionCompat, truncateListBySize);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
            CharSequence queueTitle = MediaSessionLegacyStub.this.sessionCompat.getController().getQueueTitle();
            CharSequence charSequence = mediaMetadata.title;
            if (TextUtils.equals(queueTitle, charSequence)) {
                return;
            }
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.setQueueTitle(mediaSessionLegacyStub.sessionCompat, charSequence);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onShuffleModeEnabledChanged(int i, boolean z) throws RemoteException {
            MediaSessionLegacyStub.this.sessionCompat.setShuffleMode(LegacyConversions.convertToPlaybackStateCompatShuffleMode(z));
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i, int i2) throws RemoteException {
            MediaSessionLegacyStub.this.sessionCompat.setRepeatMode(LegacyConversions.convertToPlaybackStateCompatRepeatMode(i2));
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onAudioAttributesChanged(int i, AudioAttributes audioAttributes) {
            if (MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().getDeviceInfo().playbackType == 0) {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackToLocal(LegacyConversions.getLegacyStreamType(audioAttributes));
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDeviceInfoChanged(int i, DeviceInfo deviceInfo) {
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaSessionLegacyStub.this.volumeProviderCompat = playerWrapper.createVolumeProviderCompat();
            if (MediaSessionLegacyStub.this.volumeProviderCompat != null) {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackToRemote(MediaSessionLegacyStub.this.volumeProviderCompat);
            } else {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackToLocal(LegacyConversions.getLegacyStreamType(playerWrapper.getAudioAttributesWithCommandCheck()));
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDeviceVolumeChanged(int i, int i2, boolean z) {
            if (MediaSessionLegacyStub.this.volumeProviderCompat != null) {
                VolumeProviderCompat volumeProviderCompat = MediaSessionLegacyStub.this.volumeProviderCompat;
                if (z) {
                    i2 = 0;
                }
                volumeProviderCompat.setCurrentVolume(i2);
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPeriodicSessionPositionInfoChanged(int i, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, int i2) throws RemoteException {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.updateLegacySessionPlaybackState(mediaSessionLegacyStub.sessionImpl.getPlayerWrapper());
        }

        private void updateMetadataIfChanged() {
            Bitmap bitmap;
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaItem currentMediaItemWithCommandCheck = playerWrapper.getCurrentMediaItemWithCommandCheck();
            final MediaMetadata mediaMetadataWithCommandCheck = playerWrapper.getMediaMetadataWithCommandCheck();
            final long durationWithCommandCheck = playerWrapper.getDurationWithCommandCheck();
            final String str = currentMediaItemWithCommandCheck != null ? currentMediaItemWithCommandCheck.mediaId : "";
            Uri uri = (currentMediaItemWithCommandCheck == null || currentMediaItemWithCommandCheck.localConfiguration == null) ? null : currentMediaItemWithCommandCheck.localConfiguration.uri;
            if (Objects.equals(this.lastMediaMetadata, mediaMetadataWithCommandCheck) && Objects.equals(this.lastMediaId, str) && Objects.equals(this.lastMediaUri, uri) && this.lastDurationMs == durationWithCommandCheck) {
                return;
            }
            this.lastMediaId = str;
            this.lastMediaUri = uri;
            this.lastMediaMetadata = mediaMetadataWithCommandCheck;
            this.lastDurationMs = durationWithCommandCheck;
            ListenableFuture<Bitmap> loadBitmapFromMetadata = MediaSessionLegacyStub.this.sessionImpl.getBitmapLoader().loadBitmapFromMetadata(mediaMetadataWithCommandCheck);
            if (loadBitmapFromMetadata != null) {
                MediaSessionLegacyStub.this.pendingBitmapLoadCallback = null;
                if (!loadBitmapFromMetadata.isDone()) {
                    final Uri uri2 = uri;
                    MediaSessionLegacyStub.this.pendingBitmapLoadCallback = new FutureCallback<Bitmap>() { // from class: androidx.media3.session.MediaSessionLegacyStub.ControllerLegacyCbForBroadcast.1
                        @Override // com.google.common.util.concurrent.FutureCallback
                        public void onSuccess(Bitmap bitmap2) {
                            if (this != MediaSessionLegacyStub.this.pendingBitmapLoadCallback) {
                                return;
                            }
                            MediaSessionLegacyStub.setMetadata(MediaSessionLegacyStub.this.sessionCompat, LegacyConversions.convertToMediaMetadataCompat(mediaMetadataWithCommandCheck, str, uri2, durationWithCommandCheck, bitmap2));
                            MediaSessionLegacyStub.this.sessionImpl.onNotificationRefreshRequired();
                        }

                        @Override // com.google.common.util.concurrent.FutureCallback
                        public void onFailure(Throwable th) {
                            if (this != MediaSessionLegacyStub.this.pendingBitmapLoadCallback) {
                                return;
                            }
                            Log.w(MediaSessionLegacyStub.TAG, MediaSessionLegacyStub.getBitmapLoadErrorMessage(th));
                        }
                    };
                    FutureCallback futureCallback = MediaSessionLegacyStub.this.pendingBitmapLoadCallback;
                    Handler applicationHandler = MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler();
                    Objects.requireNonNull(applicationHandler);
                    Futures.addCallback(loadBitmapFromMetadata, futureCallback, new ConcurrencyHelpers$$ExternalSyntheticLambda0(applicationHandler));
                } else {
                    try {
                        bitmap = (Bitmap) Futures.getDone(loadBitmapFromMetadata);
                    } catch (CancellationException | ExecutionException e) {
                        Log.w(MediaSessionLegacyStub.TAG, MediaSessionLegacyStub.getBitmapLoadErrorMessage(e));
                    }
                    MediaSessionLegacyStub.setMetadata(MediaSessionLegacyStub.this.sessionCompat, LegacyConversions.convertToMediaMetadataCompat(mediaMetadataWithCommandCheck, str, uri, durationWithCommandCheck, bitmap));
                }
            }
            bitmap = null;
            MediaSessionLegacyStub.setMetadata(MediaSessionLegacyStub.this.sessionCompat, LegacyConversions.convertToMediaMetadataCompat(mediaMetadataWithCommandCheck, str, uri, durationWithCommandCheck, bitmap));
        }
    }

    private static class ConnectionTimeoutHandler extends Handler {
        private static final int MSG_CONNECTION_TIMED_OUT = 1001;
        private final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager;

        public ConnectionTimeoutHandler(Looper looper, ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager) {
            super(looper);
            this.connectedControllersManager = connectedControllersManager;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) message.obj;
            if (this.connectedControllersManager.isConnected(controllerInfo)) {
                try {
                    ((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).onDisconnected(0);
                } catch (RemoteException unused) {
                }
                this.connectedControllersManager.removeController(controllerInfo);
            }
        }

        public void disconnectControllerAfterTimeout(MediaSession.ControllerInfo controllerInfo, long j) {
            removeMessages(1001, controllerInfo);
            sendMessageDelayed(obtainMessage(1001, controllerInfo), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBitmapLoadErrorMessage(Throwable th) {
        return "Failed to load bitmap: " + th.getMessage();
    }

    private static ComponentName getServiceComponentByAction(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
    }

    private final class MediaButtonReceiver extends BroadcastReceiver {
        private MediaButtonReceiver() {
        }

        /* synthetic */ MediaButtonReceiver(MediaSessionLegacyStub mediaSessionLegacyStub, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            if (Util.areEqual(intent.getAction(), "android.intent.action.MEDIA_BUTTON")) {
                Uri data = intent.getData();
                if (Util.areEqual(data, data) && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                    MediaSessionLegacyStub.this.sessionCompat.getController().dispatchMediaButtonEvent(keyEvent);
                }
            }
        }
    }

    private static final class Api31 {
        private Api31() {
        }

        public static void setMediaButtonBroadcastReceiver(MediaSessionCompat mediaSessionCompat, ComponentName componentName) {
            ((android.media.session.MediaSession) mediaSessionCompat.getMediaSession()).setMediaButtonBroadcastReceiver(componentName);
        }
    }
}
