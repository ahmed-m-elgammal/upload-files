package androidx.media3.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.MediaBrowserCompat;
import android.text.TextUtils;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaBrowser;
import androidx.media3.session.MediaBrowserImplLegacy;
import androidx.media3.session.MediaLibraryService;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class MediaBrowserImplLegacy extends MediaControllerImplLegacy implements MediaBrowser.MediaBrowserImpl {
    private static final String TAG = "MB2ImplLegacy";
    private final HashMap<MediaLibraryService.LibraryParams, MediaBrowserCompat> browserCompats;
    private final MediaBrowser instance;
    private final HashMap<String, List<SubscribeCallback>> subscribeCallbacks;

    MediaBrowserImplLegacy(Context context, MediaBrowser mediaBrowser, SessionToken sessionToken, Looper looper, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        super(context, mediaBrowser, sessionToken, looper, bitmapLoader);
        this.browserCompats = new HashMap<>();
        this.subscribeCallbacks = new HashMap<>();
        this.instance = mediaBrowser;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media3.session.MediaControllerImplLegacy
    public MediaBrowser getInstance() {
        return this.instance;
    }

    @Override // androidx.media3.session.MediaControllerImplLegacy, androidx.media3.session.MediaController.MediaControllerImpl
    public void release() {
        Iterator<MediaBrowserCompat> it = this.browserCompats.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect();
        }
        this.browserCompats.clear();
        super.release();
    }

    @Override // androidx.media3.session.MediaControllerImplLegacy, androidx.media3.session.MediaController.MediaControllerImpl
    public SessionCommands getAvailableSessionCommands() {
        if (getBrowserCompat() != null) {
            return super.getAvailableSessionCommands().buildUpon().addAllLibraryCommands().build();
        }
        return super.getAvailableSessionCommands();
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult<MediaItem>> getLibraryRoot(MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(50000)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        SettableFuture create = SettableFuture.create();
        MediaBrowserCompat browserCompat = getBrowserCompat(libraryParams);
        if (browserCompat != null) {
            create.set(LibraryResult.ofItem(createRootMediaItem(browserCompat), null));
        } else {
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(getContext(), getConnectedToken().getComponentName(), new GetLibraryRootCallback(create, libraryParams), LegacyConversions.convertToRootHints(libraryParams));
            this.browserCompats.put(libraryParams, mediaBrowserCompat);
            mediaBrowserCompat.connect();
        }
        return create;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult<Void>> subscribe(String str, MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        SettableFuture create = SettableFuture.create();
        SubscribeCallback subscribeCallback = new SubscribeCallback(create);
        List<SubscribeCallback> list = this.subscribeCallbacks.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.subscribeCallbacks.put(str, list);
        }
        list.add(subscribeCallback);
        browserCompat.subscribe(str, createOptions(libraryParams), subscribeCallback);
        return create;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult<Void>> unsubscribe(String str) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        List<SubscribeCallback> list = this.subscribeCallbacks.get(str);
        if (list == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-3));
        }
        for (int i = 0; i < list.size(); i++) {
            browserCompat.unsubscribe(str, list.get(i));
        }
        return Futures.immediateFuture(LibraryResult.ofVoid());
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> getChildren(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        SettableFuture create = SettableFuture.create();
        browserCompat.subscribe(str, createOptions(libraryParams, i, i2), new GetChildrenCallback(create, str));
        return create;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult<MediaItem>> getItem(String str) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        final SettableFuture create = SettableFuture.create();
        browserCompat.getItem(str, new MediaBrowserCompat.ItemCallback() { // from class: androidx.media3.session.MediaBrowserImplLegacy.1
            @Override // android.support.v4.media.MediaBrowserCompat.ItemCallback
            public void onItemLoaded(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem != null) {
                    create.set(LibraryResult.ofItem(LegacyConversions.convertToMediaItem(mediaItem), null));
                } else {
                    create.set(LibraryResult.ofError(-3));
                }
            }

            @Override // android.support.v4.media.MediaBrowserCompat.ItemCallback
            public void onError(String str2) {
                create.set(LibraryResult.ofError(-1));
            }
        });
        return create;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult<Void>> search(String str, MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        browserCompat.search(str, getExtras(libraryParams), new AnonymousClass2());
        return Futures.immediateFuture(LibraryResult.ofVoid());
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplLegacy$2, reason: invalid class name */
    class AnonymousClass2 extends MediaBrowserCompat.SearchCallback {
        AnonymousClass2() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
        public void onSearchResult(final String str, Bundle bundle, final List<MediaBrowserCompat.MediaItem> list) {
            MediaBrowserImplLegacy.this.getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.MediaBrowserImplLegacy$2$$ExternalSyntheticLambda0
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaBrowserImplLegacy.AnonymousClass2.this.m623x87f18d83(str, list, (MediaBrowser.Listener) obj);
                }
            });
        }

        /* renamed from: lambda$onSearchResult$0$androidx-media3-session-MediaBrowserImplLegacy$2, reason: not valid java name */
        /* synthetic */ void m623x87f18d83(String str, List list, MediaBrowser.Listener listener) {
            listener.onSearchResultChanged(MediaBrowserImplLegacy.this.getInstance(), str, list.size(), null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
        public void onError(final String str, Bundle bundle) {
            MediaBrowserImplLegacy.this.getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.MediaBrowserImplLegacy$2$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaBrowserImplLegacy.AnonymousClass2.this.m622x841a1c17(str, (MediaBrowser.Listener) obj);
                }
            });
        }

        /* renamed from: lambda$onError$1$androidx-media3-session-MediaBrowserImplLegacy$2, reason: not valid java name */
        /* synthetic */ void m622x841a1c17(String str, MediaBrowser.Listener listener) {
            listener.onSearchResultChanged(MediaBrowserImplLegacy.this.getInstance(), str, 0, null);
        }
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> getSearchResult(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        final SettableFuture create = SettableFuture.create();
        Bundle createOptions = createOptions(libraryParams, i, i2);
        createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE, i);
        createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, i2);
        browserCompat.search(str, createOptions, new MediaBrowserCompat.SearchCallback() { // from class: androidx.media3.session.MediaBrowserImplLegacy.3
            @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
            public void onSearchResult(String str2, Bundle bundle, List<MediaBrowserCompat.MediaItem> list) {
                create.set(LibraryResult.ofItemList(LegacyConversions.convertBrowserItemListToMediaItemList(list), null));
            }

            @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
            public void onError(String str2, Bundle bundle) {
                create.set(LibraryResult.ofError(-1));
            }
        });
        return create;
    }

    private MediaBrowserCompat getBrowserCompat(MediaLibraryService.LibraryParams libraryParams) {
        return this.browserCompats.get(libraryParams);
    }

    private static Bundle createOptions(MediaLibraryService.LibraryParams libraryParams) {
        return libraryParams == null ? new Bundle() : new Bundle(libraryParams.extras);
    }

    private static Bundle createOptions(MediaLibraryService.LibraryParams libraryParams, int i, int i2) {
        Bundle createOptions = createOptions(libraryParams);
        createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE, i);
        createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, i2);
        return createOptions;
    }

    private static Bundle getExtras(MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams != null) {
            return libraryParams.extras;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaItem createRootMediaItem(MediaBrowserCompat mediaBrowserCompat) {
        String root = mediaBrowserCompat.getRoot();
        return new MediaItem.Builder().setMediaId(root).setMediaMetadata(new MediaMetadata.Builder().setIsBrowsable(true).setMediaType(20).setIsPlayable(false).setExtras(mediaBrowserCompat.getExtras()).build()).build();
    }

    private class GetLibraryRootCallback extends MediaBrowserCompat.ConnectionCallback {
        private final MediaLibraryService.LibraryParams params;
        private final SettableFuture<LibraryResult<MediaItem>> result;

        public GetLibraryRootCallback(SettableFuture<LibraryResult<MediaItem>> settableFuture, MediaLibraryService.LibraryParams libraryParams) {
            this.result = settableFuture;
            this.params = libraryParams;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat mediaBrowserCompat = (MediaBrowserCompat) MediaBrowserImplLegacy.this.browserCompats.get(this.params);
            if (mediaBrowserCompat == null) {
                this.result.set(LibraryResult.ofError(-1));
            } else {
                this.result.set(LibraryResult.ofItem(MediaBrowserImplLegacy.this.createRootMediaItem(mediaBrowserCompat), LegacyConversions.convertToLibraryParams(MediaBrowserImplLegacy.this.context, mediaBrowserCompat.getExtras())));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            onConnectionFailed();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            this.result.set(LibraryResult.ofError(-3));
            MediaBrowserImplLegacy.this.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SubscribeCallback extends MediaBrowserCompat.SubscriptionCallback {
        private final SettableFuture<LibraryResult<Void>> future;

        public SubscribeCallback(SettableFuture<LibraryResult<Void>> settableFuture) {
            this.future = settableFuture;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str) {
            onErrorInternal();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            onErrorInternal();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowserCompat.MediaItem> list) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
            onChildrenLoadedInternal(str, list);
        }

        private void onErrorInternal() {
            this.future.set(LibraryResult.ofError(-1));
        }

        private void onChildrenLoadedInternal(final String str, List<MediaBrowserCompat.MediaItem> list) {
            if (TextUtils.isEmpty(str)) {
                Log.w(MediaBrowserImplLegacy.TAG, "SubscribeCallback.onChildrenLoaded(): Ignoring empty parentId");
                return;
            }
            MediaBrowserCompat browserCompat = MediaBrowserImplLegacy.this.getBrowserCompat();
            if (browserCompat == null || list == null) {
                return;
            }
            final int size = list.size();
            final MediaLibraryService.LibraryParams convertToLibraryParams = LegacyConversions.convertToLibraryParams(MediaBrowserImplLegacy.this.context, browserCompat.getNotifyChildrenChangedOptions());
            MediaBrowserImplLegacy.this.getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.MediaBrowserImplLegacy$SubscribeCallback$$ExternalSyntheticLambda0
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaBrowserImplLegacy.SubscribeCallback.this.m624xaa936684(str, size, convertToLibraryParams, (MediaBrowser.Listener) obj);
                }
            });
            this.future.set(LibraryResult.ofVoid());
        }

        /* renamed from: lambda$onChildrenLoadedInternal$0$androidx-media3-session-MediaBrowserImplLegacy$SubscribeCallback, reason: not valid java name */
        /* synthetic */ void m624xaa936684(String str, int i, MediaLibraryService.LibraryParams libraryParams, MediaBrowser.Listener listener) {
            listener.onChildrenChanged(MediaBrowserImplLegacy.this.getInstance(), str, i, libraryParams);
        }
    }

    private class GetChildrenCallback extends MediaBrowserCompat.SubscriptionCallback {
        private final SettableFuture<LibraryResult<ImmutableList<MediaItem>>> future;
        private final String parentId;

        public GetChildrenCallback(SettableFuture<LibraryResult<ImmutableList<MediaItem>>> settableFuture, String str) {
            this.future = settableFuture;
            this.parentId = str;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str) {
            onErrorInternal();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            onErrorInternal();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowserCompat.MediaItem> list) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
            onChildrenLoadedInternal(str, list);
        }

        private void onErrorInternal() {
            this.future.set(LibraryResult.ofError(-1));
        }

        private void onChildrenLoadedInternal(String str, List<MediaBrowserCompat.MediaItem> list) {
            if (TextUtils.isEmpty(str)) {
                Log.w(MediaBrowserImplLegacy.TAG, "GetChildrenCallback.onChildrenLoaded(): Ignoring empty parentId");
                return;
            }
            MediaBrowserCompat browserCompat = MediaBrowserImplLegacy.this.getBrowserCompat();
            if (browserCompat == null) {
                this.future.set(LibraryResult.ofError(-100));
                return;
            }
            browserCompat.unsubscribe(this.parentId, this);
            if (list == null) {
                this.future.set(LibraryResult.ofError(-1));
            } else {
                this.future.set(LibraryResult.ofItemList(LegacyConversions.convertBrowserItemListToMediaItemList(list), null));
            }
        }
    }
}
