package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
class MediaLibrarySessionImpl extends MediaSessionImpl {
    private static final String RECENT_LIBRARY_ROOT_MEDIA_ID = "androidx.media3.session.recent.root";
    private final MediaLibraryService.MediaLibrarySession.Callback callback;
    private final HashMultimap<MediaSession.ControllerCb, String> controllerToSubscribedParentIds;
    private final MediaLibraryService.MediaLibrarySession instance;
    private final HashMultimap<String, MediaSession.ControllerInfo> parentIdToSubscribedControllers;

    public MediaLibrarySessionImpl(MediaLibraryService.MediaLibrarySession mediaLibrarySession, Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList<CommandButton> immutableList, MediaLibraryService.MediaLibrarySession.Callback callback, Bundle bundle, Bundle bundle2, androidx.media3.common.util.BitmapLoader bitmapLoader, boolean z, boolean z2) {
        super(mediaLibrarySession, context, str, player, pendingIntent, immutableList, callback, bundle, bundle2, bitmapLoader, z, z2);
        this.instance = mediaLibrarySession;
        this.callback = callback;
        this.parentIdToSubscribedControllers = HashMultimap.create();
        this.controllerToSubscribedParentIds = HashMultimap.create();
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        List<MediaSession.ControllerInfo> connectedControllers = super.getConnectedControllers();
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            connectedControllers.addAll(legacyBrowserService.getConnectedControllersManager().getConnectedControllers());
        }
        return connectedControllers;
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        if (super.isConnected(controllerInfo)) {
            return true;
        }
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        return legacyBrowserService != null && legacyBrowserService.getConnectedControllersManager().isConnected(controllerInfo);
    }

    public ListenableFuture<LibraryResult<MediaItem>> onGetLibraryRootOnHandler(MediaSession.ControllerInfo controllerInfo, MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams != null && libraryParams.isRecent && isSystemUiController(controllerInfo)) {
            if (!canResumePlaybackOnStart()) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }
            return Futures.immediateFuture(LibraryResult.ofItem(new MediaItem.Builder().setMediaId(RECENT_LIBRARY_ROOT_MEDIA_ID).setMediaMetadata(new MediaMetadata.Builder().setIsBrowsable(true).setIsPlayable(false).build()).build(), libraryParams));
        }
        final ListenableFuture<LibraryResult<MediaItem>> onGetLibraryRoot = this.callback.onGetLibraryRoot(this.instance, resolveControllerInfoForCallback(controllerInfo), libraryParams);
        onGetLibraryRoot.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.m739xc79f97be(onGetLibraryRoot);
            }
        }, new MediaLibrarySessionImpl$$ExternalSyntheticLambda1(this));
        return onGetLibraryRoot;
    }

    /* renamed from: lambda$onGetLibraryRootOnHandler$0$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m739xc79f97be(ListenableFuture listenableFuture) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
        }
    }

    public ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> onGetChildrenOnHandler(MediaSession.ControllerInfo controllerInfo, String str, int i, final int i2, MediaLibraryService.LibraryParams libraryParams) {
        if (Objects.equals(str, RECENT_LIBRARY_ROOT_MEDIA_ID)) {
            if (!canResumePlaybackOnStart()) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }
            if (getPlayerWrapper().getPlaybackState() == 1) {
                return getRecentMediaItemAtDeviceBootTime(controllerInfo, libraryParams);
            }
            return Futures.immediateFuture(LibraryResult.ofItemList(ImmutableList.of(new MediaItem.Builder().setMediaId("androidx.media3.session.recent.item").setMediaMetadata(new MediaMetadata.Builder().setIsBrowsable(false).setIsPlayable(true).build()).build()), libraryParams));
        }
        final ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> onGetChildren = this.callback.onGetChildren(this.instance, resolveControllerInfoForCallback(controllerInfo), str, i, i2, libraryParams);
        onGetChildren.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.m737x80f5d409(onGetChildren, i2);
            }
        }, new MediaLibrarySessionImpl$$ExternalSyntheticLambda1(this));
        return onGetChildren;
    }

    /* renamed from: lambda$onGetChildrenOnHandler$1$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m737x80f5d409(ListenableFuture listenableFuture, int i) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
            verifyResultItems(libraryResult, i);
        }
    }

    public ListenableFuture<LibraryResult<MediaItem>> onGetItemOnHandler(MediaSession.ControllerInfo controllerInfo, String str) {
        final ListenableFuture<LibraryResult<MediaItem>> onGetItem = this.callback.onGetItem(this.instance, resolveControllerInfoForCallback(controllerInfo), str);
        onGetItem.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.m738x19f8e776(onGetItem);
            }
        }, new MediaLibrarySessionImpl$$ExternalSyntheticLambda1(this));
        return onGetItem;
    }

    /* renamed from: lambda$onGetItemOnHandler$2$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m738x19f8e776(ListenableFuture listenableFuture) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
        }
    }

    public ListenableFuture<LibraryResult<Void>> onSubscribeOnHandler(final MediaSession.ControllerInfo controllerInfo, final String str, MediaLibraryService.LibraryParams libraryParams) {
        this.controllerToSubscribedParentIds.put((MediaSession.ControllerCb) Assertions.checkNotNull(controllerInfo.getControllerCb()), str);
        this.parentIdToSubscribedControllers.put(str, controllerInfo);
        final ListenableFuture<LibraryResult<Void>> listenableFuture = (ListenableFuture) Assertions.checkNotNull(this.callback.onSubscribe(this.instance, resolveControllerInfoForCallback(controllerInfo), str, libraryParams), "onSubscribe must return non-null future");
        listenableFuture.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.m742x93d8ec16(listenableFuture, controllerInfo, str);
            }
        }, new MediaLibrarySessionImpl$$ExternalSyntheticLambda1(this));
        return listenableFuture;
    }

    /* renamed from: lambda$onSubscribeOnHandler$3$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m742x93d8ec16(ListenableFuture listenableFuture, MediaSession.ControllerInfo controllerInfo, String str) {
        LibraryResult libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult == null || libraryResult.resultCode != 0) {
            m743x382ac930(controllerInfo, str);
        }
    }

    public ImmutableList<MediaSession.ControllerInfo> getSubscribedControllers(String str) {
        return ImmutableList.copyOf((Collection) this.parentIdToSubscribedControllers.get((Object) str));
    }

    private boolean isSubscribed(MediaSession.ControllerCb controllerCb, String str) {
        return this.controllerToSubscribedParentIds.containsEntry(controllerCb, str);
    }

    public ListenableFuture<LibraryResult<Void>> onUnsubscribeOnHandler(final MediaSession.ControllerInfo controllerInfo, final String str) {
        ListenableFuture<LibraryResult<Void>> onUnsubscribe = this.callback.onUnsubscribe(this.instance, resolveControllerInfoForCallback(controllerInfo), str);
        onUnsubscribe.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.m743x382ac930(controllerInfo, str);
            }
        }, new MediaLibrarySessionImpl$$ExternalSyntheticLambda1(this));
        return onUnsubscribe;
    }

    public void notifyChildrenChanged(String str, int i, MediaLibraryService.LibraryParams libraryParams) {
        List<MediaSession.ControllerInfo> connectedControllers = this.instance.getConnectedControllers();
        for (int i2 = 0; i2 < connectedControllers.size(); i2++) {
            notifyChildrenChanged(connectedControllers.get(i2), str, i, libraryParams);
        }
    }

    public void notifyChildrenChanged(MediaSession.ControllerInfo controllerInfo, final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        if (isMediaNotificationControllerConnected() && isMediaNotificationController(controllerInfo) && (controllerInfo = getSystemUiControllerInfo()) == null) {
            return;
        }
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImpl.RemoteControllerTask() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda6
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i2) {
                MediaLibrarySessionImpl.this.m736x41206c6a(str, i, libraryParams, controllerCb, i2);
            }
        });
    }

    /* renamed from: lambda$notifyChildrenChanged$5$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m736x41206c6a(String str, int i, MediaLibraryService.LibraryParams libraryParams, MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
        if (isSubscribed(controllerCb, str)) {
            controllerCb.onChildrenChanged(i2, str, i, libraryParams);
        }
    }

    public ListenableFuture<LibraryResult<Void>> onSearchOnHandler(MediaSession.ControllerInfo controllerInfo, String str, MediaLibraryService.LibraryParams libraryParams) {
        final ListenableFuture<LibraryResult<Void>> onSearch = this.callback.onSearch(this.instance, resolveControllerInfoForCallback(controllerInfo), str, libraryParams);
        onSearch.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.m741x8679c483(onSearch);
            }
        }, new MediaLibrarySessionImpl$$ExternalSyntheticLambda1(this));
        return onSearch;
    }

    /* renamed from: lambda$onSearchOnHandler$6$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m741x8679c483(ListenableFuture listenableFuture) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
        }
    }

    public ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> onGetSearchResultOnHandler(MediaSession.ControllerInfo controllerInfo, String str, int i, final int i2, MediaLibraryService.LibraryParams libraryParams) {
        final ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> onGetSearchResult = this.callback.onGetSearchResult(this.instance, resolveControllerInfoForCallback(controllerInfo), str, i, i2, libraryParams);
        onGetSearchResult.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibrarySessionImpl.this.m740xb1a6d769(onGetSearchResult, i2);
            }
        }, new MediaLibrarySessionImpl$$ExternalSyntheticLambda1(this));
        return onGetSearchResult;
    }

    /* renamed from: lambda$onGetSearchResultOnHandler$7$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m740xb1a6d769(ListenableFuture listenableFuture, int i) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
            verifyResultItems(libraryResult, i);
        }
    }

    public void notifySearchResultChanged(MediaSession.ControllerInfo controllerInfo, final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        if (isMediaNotificationControllerConnected() && isMediaNotificationController(controllerInfo) && (controllerInfo = getSystemUiControllerInfo()) == null) {
            return;
        }
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImpl.RemoteControllerTask() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda4
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i2) {
                controllerCb.onSearchResultChanged(i2, str, i, libraryParams);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.session.MediaSessionImpl
    public void onDisconnectedOnHandler(MediaSession.ControllerInfo controllerInfo) {
        UnmodifiableIterator it = ImmutableSet.copyOf((Collection) this.controllerToSubscribedParentIds.get(Assertions.checkNotNull(controllerInfo.getControllerCb()))).iterator();
        while (it.hasNext()) {
            m743x382ac930(controllerInfo, (String) it.next());
        }
        super.onDisconnectedOnHandler(controllerInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.session.MediaSessionImpl
    public MediaLibraryServiceLegacyStub getLegacyBrowserService() {
        return (MediaLibraryServiceLegacyStub) super.getLegacyBrowserService();
    }

    @Override // androidx.media3.session.MediaSessionImpl
    protected MediaSessionServiceLegacyStub createLegacyBrowserService(MediaSessionCompat.Token token) {
        MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = new MediaLibraryServiceLegacyStub(this);
        mediaLibraryServiceLegacyStub.initialize(token);
        return mediaLibraryServiceLegacyStub;
    }

    @Override // androidx.media3.session.MediaSessionImpl
    protected void dispatchRemoteControllerTaskWithoutReturn(MediaSessionImpl.RemoteControllerTask remoteControllerTask) {
        super.dispatchRemoteControllerTaskWithoutReturn(remoteControllerTask);
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            try {
                remoteControllerTask.run(legacyBrowserService.getBrowserLegacyCbForBroadcast(), 0);
            } catch (RemoteException e) {
                Log.e(MediaSessionImpl.TAG, "Exception in using media1 API", e);
            }
        }
    }

    private void maybeUpdateLegacyErrorState(LibraryResult<?> libraryResult) {
        PlayerWrapper playerWrapper = getPlayerWrapper();
        if (libraryResult.resultCode == -102 && libraryResult.params != null && libraryResult.params.extras.containsKey("android.media.extras.ERROR_RESOLUTION_ACTION_INTENT")) {
            MediaSessionCompat sessionCompat = getSessionCompat();
            if (playerWrapper.getLegacyStatusCode() != -102) {
                playerWrapper.setLegacyErrorStatus(3, getContext().getString(R.string.authentication_required), libraryResult.params.extras);
                sessionCompat.setPlaybackState(playerWrapper.createPlaybackStateCompat());
                return;
            }
            return;
        }
        if (playerWrapper.getLegacyStatusCode() != 0) {
            playerWrapper.clearLegacyErrorStatus();
            getSessionCompat().setPlaybackState(playerWrapper.createPlaybackStateCompat());
        }
    }

    private static <T> T tryGetFutureResult(Future<T> future) {
        Assertions.checkState(future.isDone());
        try {
            return future.get();
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            Log.w(MediaSessionImpl.TAG, "Library operation failed", e);
            return null;
        }
    }

    private static void verifyResultItems(LibraryResult<ImmutableList<MediaItem>> libraryResult, int i) {
        if (libraryResult.resultCode == 0) {
            List list = (List) Assertions.checkNotNull(libraryResult.value);
            if (list.size() <= i) {
                return;
            }
            throw new IllegalStateException("Invalid size=" + list.size() + ", pageSize=" + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeSubscription, reason: merged with bridge method [inline-methods] */
    public void m743x382ac930(MediaSession.ControllerInfo controllerInfo, String str) {
        MediaSession.ControllerCb controllerCb = (MediaSession.ControllerCb) Assertions.checkNotNull(controllerInfo.getControllerCb());
        this.parentIdToSubscribedControllers.remove(str, controllerInfo);
        this.controllerToSubscribedParentIds.remove(controllerCb, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOrRunOnApplicationHandler(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    private ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> getRecentMediaItemAtDeviceBootTime(MediaSession.ControllerInfo controllerInfo, final MediaLibraryService.LibraryParams libraryParams) {
        final SettableFuture create = SettableFuture.create();
        if (isMediaNotificationControllerConnected()) {
            controllerInfo = (MediaSession.ControllerInfo) Assertions.checkNotNull(getMediaNotificationControllerInfo());
        }
        Futures.addCallback(this.callback.onPlaybackResumption(this.instance, controllerInfo), new FutureCallback<MediaSession.MediaItemsWithStartPosition>() { // from class: androidx.media3.session.MediaLibrarySessionImpl.1
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
                if (mediaItemsWithStartPosition.mediaItems.isEmpty()) {
                    create.set(LibraryResult.ofError(-2, libraryParams));
                } else {
                    create.set(LibraryResult.ofItemList(ImmutableList.of(mediaItemsWithStartPosition.mediaItems.get(Math.max(0, Math.min(mediaItemsWithStartPosition.startIndex, mediaItemsWithStartPosition.mediaItems.size() - 1)))), libraryParams));
                }
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                create.set(LibraryResult.ofError(-1, libraryParams));
                Log.e(MediaSessionImpl.TAG, "Failed fetching recent media item at boot time: " + th.getMessage(), th);
            }
        }, MoreExecutors.directExecutor());
        return create;
    }
}
