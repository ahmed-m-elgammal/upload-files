package androidx.media3.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import androidx.media3.session.IMediaController;

/* loaded from: classes.dex */
public interface IMediaSession extends IInterface {

    public static class Default implements IMediaSession {
        @Override // androidx.media3.session.IMediaSession
        public void addMediaItem(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void addMediaItemWithIndex(IMediaController iMediaController, int i, int i2, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void addMediaItems(IMediaController iMediaController, int i, IBinder iBinder) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void addMediaItemsWithIndex(IMediaController iMediaController, int i, int i2, IBinder iBinder) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.media3.session.IMediaSession
        public void clearMediaItems(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void connect(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void decreaseDeviceVolume(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void decreaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void flushCommandQueue(IMediaController iMediaController) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void getItem(IMediaController iMediaController, int i, String str) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void getLibraryRoot(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void increaseDeviceVolume(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void increaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void moveMediaItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void moveMediaItems(IMediaController iMediaController, int i, int i2, int i3, int i4) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void onControllerResult(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void onCustomCommand(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void pause(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void play(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void prepare(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void release(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void removeMediaItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void removeMediaItems(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void replaceMediaItem(IMediaController iMediaController, int i, int i2, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void replaceMediaItems(IMediaController iMediaController, int i, int i2, int i3, IBinder iBinder) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void search(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekBack(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekForward(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToDefaultPosition(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToNext(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToNextMediaItem(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToPrevious(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToPreviousMediaItem(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToWithMediaItemIndex(IMediaController iMediaController, int i, int i2, long j) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setAudioAttributes(IMediaController iMediaController, int i, Bundle bundle, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setDeviceMuted(IMediaController iMediaController, int i, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setDeviceMutedWithFlags(IMediaController iMediaController, int i, boolean z, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setDeviceVolume(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItem(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItemWithResetPosition(IMediaController iMediaController, int i, Bundle bundle, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItemWithStartPosition(IMediaController iMediaController, int i, Bundle bundle, long j) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItems(IMediaController iMediaController, int i, IBinder iBinder) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItemsWithResetPosition(IMediaController iMediaController, int i, IBinder iBinder, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItemsWithStartIndex(IMediaController iMediaController, int i, IBinder iBinder, int i2, long j) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setPlayWhenReady(IMediaController iMediaController, int i, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setPlaybackParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setPlaylistMetadata(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setRating(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setRatingWithMediaId(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setShuffleModeEnabled(IMediaController iMediaController, int i, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setTrackSelectionParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setVideoSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setVolume(IMediaController iMediaController, int i, float f) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void stop(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void subscribe(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException {
        }
    }

    void addMediaItem(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void addMediaItemWithIndex(IMediaController iMediaController, int i, int i2, Bundle bundle) throws RemoteException;

    void addMediaItems(IMediaController iMediaController, int i, IBinder iBinder) throws RemoteException;

    void addMediaItemsWithIndex(IMediaController iMediaController, int i, int i2, IBinder iBinder) throws RemoteException;

    void clearMediaItems(IMediaController iMediaController, int i) throws RemoteException;

    void connect(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void decreaseDeviceVolume(IMediaController iMediaController, int i) throws RemoteException;

    void decreaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void flushCommandQueue(IMediaController iMediaController) throws RemoteException;

    void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) throws RemoteException;

    void getItem(IMediaController iMediaController, int i, String str) throws RemoteException;

    void getLibraryRoot(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) throws RemoteException;

    void increaseDeviceVolume(IMediaController iMediaController, int i) throws RemoteException;

    void increaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void moveMediaItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void moveMediaItems(IMediaController iMediaController, int i, int i2, int i3, int i4) throws RemoteException;

    void onControllerResult(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void onCustomCommand(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2) throws RemoteException;

    void pause(IMediaController iMediaController, int i) throws RemoteException;

    void play(IMediaController iMediaController, int i) throws RemoteException;

    void prepare(IMediaController iMediaController, int i) throws RemoteException;

    void release(IMediaController iMediaController, int i) throws RemoteException;

    void removeMediaItem(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void removeMediaItems(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void replaceMediaItem(IMediaController iMediaController, int i, int i2, Bundle bundle) throws RemoteException;

    void replaceMediaItems(IMediaController iMediaController, int i, int i2, int i3, IBinder iBinder) throws RemoteException;

    void search(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException;

    void seekBack(IMediaController iMediaController, int i) throws RemoteException;

    void seekForward(IMediaController iMediaController, int i) throws RemoteException;

    void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException;

    void seekToDefaultPosition(IMediaController iMediaController, int i) throws RemoteException;

    void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void seekToNext(IMediaController iMediaController, int i) throws RemoteException;

    void seekToNextMediaItem(IMediaController iMediaController, int i) throws RemoteException;

    void seekToPrevious(IMediaController iMediaController, int i) throws RemoteException;

    void seekToPreviousMediaItem(IMediaController iMediaController, int i) throws RemoteException;

    void seekToWithMediaItemIndex(IMediaController iMediaController, int i, int i2, long j) throws RemoteException;

    void setAudioAttributes(IMediaController iMediaController, int i, Bundle bundle, boolean z) throws RemoteException;

    void setDeviceMuted(IMediaController iMediaController, int i, boolean z) throws RemoteException;

    void setDeviceMutedWithFlags(IMediaController iMediaController, int i, boolean z, int i2) throws RemoteException;

    void setDeviceVolume(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void setDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void setMediaItem(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void setMediaItemWithResetPosition(IMediaController iMediaController, int i, Bundle bundle, boolean z) throws RemoteException;

    void setMediaItemWithStartPosition(IMediaController iMediaController, int i, Bundle bundle, long j) throws RemoteException;

    void setMediaItems(IMediaController iMediaController, int i, IBinder iBinder) throws RemoteException;

    void setMediaItemsWithResetPosition(IMediaController iMediaController, int i, IBinder iBinder, boolean z) throws RemoteException;

    void setMediaItemsWithStartIndex(IMediaController iMediaController, int i, IBinder iBinder, int i2, long j) throws RemoteException;

    void setPlayWhenReady(IMediaController iMediaController, int i, boolean z) throws RemoteException;

    void setPlaybackParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException;

    void setPlaylistMetadata(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void setRating(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void setRatingWithMediaId(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException;

    void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void setShuffleModeEnabled(IMediaController iMediaController, int i, boolean z) throws RemoteException;

    void setTrackSelectionParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void setVideoSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException;

    void setVolume(IMediaController iMediaController, int i, float f) throws RemoteException;

    void stop(IMediaController iMediaController, int i) throws RemoteException;

    void subscribe(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException;

    void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IMediaSession {
        private static final String DESCRIPTOR = "androidx.media3.session.IMediaSession";
        static final int TRANSACTION_addMediaItem = 3029;
        static final int TRANSACTION_addMediaItemWithIndex = 3030;
        static final int TRANSACTION_addMediaItems = 3031;
        static final int TRANSACTION_addMediaItemsWithIndex = 3032;
        static final int TRANSACTION_clearMediaItems = 3021;
        static final int TRANSACTION_connect = 3015;
        static final int TRANSACTION_decreaseDeviceVolume = 3005;
        static final int TRANSACTION_decreaseDeviceVolumeWithFlags = 3053;
        static final int TRANSACTION_flushCommandQueue = 3045;
        static final int TRANSACTION_getChildren = 4003;
        static final int TRANSACTION_getItem = 4002;
        static final int TRANSACTION_getLibraryRoot = 4001;
        static final int TRANSACTION_getSearchResult = 4005;
        static final int TRANSACTION_increaseDeviceVolume = 3004;
        static final int TRANSACTION_increaseDeviceVolumeWithFlags = 3052;
        static final int TRANSACTION_moveMediaItem = 3022;
        static final int TRANSACTION_moveMediaItems = 3023;
        static final int TRANSACTION_onControllerResult = 3014;
        static final int TRANSACTION_onCustomCommand = 3016;
        static final int TRANSACTION_pause = 3025;
        static final int TRANSACTION_play = 3024;
        static final int TRANSACTION_prepare = 3026;
        static final int TRANSACTION_release = 3035;
        static final int TRANSACTION_removeMediaItem = 3019;
        static final int TRANSACTION_removeMediaItems = 3020;
        static final int TRANSACTION_replaceMediaItem = 3055;
        static final int TRANSACTION_replaceMediaItems = 3056;
        static final int TRANSACTION_search = 4004;
        static final int TRANSACTION_seekBack = 3040;
        static final int TRANSACTION_seekForward = 3041;
        static final int TRANSACTION_seekTo = 3038;
        static final int TRANSACTION_seekToDefaultPosition = 3036;
        static final int TRANSACTION_seekToDefaultPositionWithMediaItemIndex = 3037;
        static final int TRANSACTION_seekToNext = 3047;
        static final int TRANSACTION_seekToNextMediaItem = 3043;
        static final int TRANSACTION_seekToPrevious = 3046;
        static final int TRANSACTION_seekToPreviousMediaItem = 3042;
        static final int TRANSACTION_seekToWithMediaItemIndex = 3039;
        static final int TRANSACTION_setAudioAttributes = 3057;
        static final int TRANSACTION_setDeviceMuted = 3006;
        static final int TRANSACTION_setDeviceMutedWithFlags = 3054;
        static final int TRANSACTION_setDeviceVolume = 3003;
        static final int TRANSACTION_setDeviceVolumeWithFlags = 3051;
        static final int TRANSACTION_setMediaItem = 3007;
        static final int TRANSACTION_setMediaItemWithResetPosition = 3009;
        static final int TRANSACTION_setMediaItemWithStartPosition = 3008;
        static final int TRANSACTION_setMediaItems = 3010;
        static final int TRANSACTION_setMediaItemsWithResetPosition = 3011;
        static final int TRANSACTION_setMediaItemsWithStartIndex = 3012;
        static final int TRANSACTION_setPlayWhenReady = 3013;
        static final int TRANSACTION_setPlaybackParameters = 3027;
        static final int TRANSACTION_setPlaybackSpeed = 3028;
        static final int TRANSACTION_setPlaylistMetadata = 3033;
        static final int TRANSACTION_setRating = 3050;
        static final int TRANSACTION_setRatingWithMediaId = 3049;
        static final int TRANSACTION_setRepeatMode = 3017;
        static final int TRANSACTION_setShuffleModeEnabled = 3018;
        static final int TRANSACTION_setTrackSelectionParameters = 3048;
        static final int TRANSACTION_setVideoSurface = 3044;
        static final int TRANSACTION_setVolume = 3002;
        static final int TRANSACTION_stop = 3034;
        static final int TRANSACTION_subscribe = 4006;
        static final int TRANSACTION_unsubscribe = 4007;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaSession)) {
                return (IMediaSession) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 3002:
                    parcel.enforceInterface(DESCRIPTOR);
                    setVolume(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readFloat());
                    return true;
                case 3003:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDeviceVolume(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3004:
                    parcel.enforceInterface(DESCRIPTOR);
                    increaseDeviceVolume(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3005:
                    parcel.enforceInterface(DESCRIPTOR);
                    decreaseDeviceVolume(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3006:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDeviceMuted(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case TRANSACTION_setMediaItem /* 3007 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_setMediaItemWithStartPosition /* 3008 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMediaItemWithStartPosition(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readLong());
                    return true;
                case TRANSACTION_setMediaItemWithResetPosition /* 3009 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMediaItemWithResetPosition(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    return true;
                case TRANSACTION_setMediaItems /* 3010 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case TRANSACTION_setMediaItemsWithResetPosition /* 3011 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMediaItemsWithResetPosition(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt() != 0);
                    return true;
                case TRANSACTION_setMediaItemsWithStartIndex /* 3012 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMediaItemsWithStartIndex(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt(), parcel.readLong());
                    return true;
                case TRANSACTION_setPlayWhenReady /* 3013 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPlayWhenReady(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case TRANSACTION_onControllerResult /* 3014 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onControllerResult(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_connect /* 3015 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    connect(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_onCustomCommand /* 3016 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCustomCommand(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_setRepeatMode /* 3017 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setRepeatMode(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case TRANSACTION_setShuffleModeEnabled /* 3018 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setShuffleModeEnabled(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case TRANSACTION_removeMediaItem /* 3019 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case TRANSACTION_removeMediaItems /* 3020 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case TRANSACTION_clearMediaItems /* 3021 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_moveMediaItem /* 3022 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    moveMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case TRANSACTION_moveMediaItems /* 3023 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    moveMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case TRANSACTION_play /* 3024 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    play(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_pause /* 3025 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    pause(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_prepare /* 3026 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    prepare(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_setPlaybackParameters /* 3027 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPlaybackParameters(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_setPlaybackSpeed /* 3028 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPlaybackSpeed(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readFloat());
                    return true;
                case TRANSACTION_addMediaItem /* 3029 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    addMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_addMediaItemWithIndex /* 3030 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    addMediaItemWithIndex(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_addMediaItems /* 3031 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    addMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case TRANSACTION_addMediaItemsWithIndex /* 3032 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    addMediaItemsWithIndex(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case TRANSACTION_setPlaylistMetadata /* 3033 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPlaylistMetadata(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_stop /* 3034 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    stop(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_release /* 3035 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    release(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_seekToDefaultPosition /* 3036 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekToDefaultPosition(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_seekToDefaultPositionWithMediaItemIndex /* 3037 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekToDefaultPositionWithMediaItemIndex(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case TRANSACTION_seekTo /* 3038 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekTo(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readLong());
                    return true;
                case TRANSACTION_seekToWithMediaItemIndex /* 3039 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekToWithMediaItemIndex(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    return true;
                case TRANSACTION_seekBack /* 3040 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekBack(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_seekForward /* 3041 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekForward(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_seekToPreviousMediaItem /* 3042 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekToPreviousMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_seekToNextMediaItem /* 3043 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekToNextMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_setVideoSurface /* 3044 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setVideoSurface(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Surface) Surface.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_flushCommandQueue /* 3045 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    flushCommandQueue(IMediaController.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case TRANSACTION_seekToPrevious /* 3046 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekToPrevious(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_seekToNext /* 3047 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekToNext(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case TRANSACTION_setTrackSelectionParameters /* 3048 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setTrackSelectionParameters(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_setRatingWithMediaId /* 3049 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setRatingWithMediaId(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_setRating /* 3050 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setRating(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_setDeviceVolumeWithFlags /* 3051 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDeviceVolumeWithFlags(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case TRANSACTION_increaseDeviceVolumeWithFlags /* 3052 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    increaseDeviceVolumeWithFlags(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case TRANSACTION_decreaseDeviceVolumeWithFlags /* 3053 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    decreaseDeviceVolumeWithFlags(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case TRANSACTION_setDeviceMutedWithFlags /* 3054 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDeviceMutedWithFlags(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
                    return true;
                case TRANSACTION_replaceMediaItem /* 3055 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    replaceMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case TRANSACTION_replaceMediaItems /* 3056 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    replaceMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case TRANSACTION_setAudioAttributes /* 3057 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setAudioAttributes(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    return true;
                default:
                    switch (i) {
                        case 4001:
                            parcel.enforceInterface(DESCRIPTOR);
                            getLibraryRoot(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 4002:
                            parcel.enforceInterface(DESCRIPTOR);
                            getItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                            return true;
                        case 4003:
                            parcel.enforceInterface(DESCRIPTOR);
                            getChildren(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 4004:
                            parcel.enforceInterface(DESCRIPTOR);
                            search(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 4005:
                            parcel.enforceInterface(DESCRIPTOR);
                            getSearchResult(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case TRANSACTION_subscribe /* 4006 */:
                            parcel.enforceInterface(DESCRIPTOR);
                            subscribe(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case TRANSACTION_unsubscribe /* 4007 */:
                            parcel.enforceInterface(DESCRIPTOR);
                            unsubscribe(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                            return true;
                        default:
                            return super.onTransact(i, parcel, parcel2, i2);
                    }
            }
        }

        private static class Proxy implements IMediaSession {
            public static IMediaSession sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // androidx.media3.session.IMediaSession
            public void setVolume(IMediaController iMediaController, int i, float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeFloat(f);
                    if (this.mRemote.transact(3002, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setVolume(iMediaController, i, f);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setDeviceVolume(IMediaController iMediaController, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(3003, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setDeviceVolume(iMediaController, i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(Stub.TRANSACTION_setDeviceVolumeWithFlags, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setDeviceVolumeWithFlags(iMediaController, i, i2, i3);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void increaseDeviceVolume(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(3004, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().increaseDeviceVolume(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void increaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(Stub.TRANSACTION_increaseDeviceVolumeWithFlags, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().increaseDeviceVolumeWithFlags(iMediaController, i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void decreaseDeviceVolume(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(3005, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().decreaseDeviceVolume(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void decreaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(Stub.TRANSACTION_decreaseDeviceVolumeWithFlags, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().decreaseDeviceVolumeWithFlags(iMediaController, i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setDeviceMuted(IMediaController iMediaController, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(3006, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setDeviceMuted(iMediaController, i, z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setDeviceMutedWithFlags(IMediaController iMediaController, int i, boolean z, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(Stub.TRANSACTION_setDeviceMutedWithFlags, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setDeviceMutedWithFlags(iMediaController, i, z, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setAudioAttributes(IMediaController iMediaController, int i, Bundle bundle, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(Stub.TRANSACTION_setAudioAttributes, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setAudioAttributes(iMediaController, i, bundle, z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItem(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_setMediaItem, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setMediaItem(iMediaController, i, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItemWithStartPosition(IMediaController iMediaController, int i, Bundle bundle, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    if (this.mRemote.transact(Stub.TRANSACTION_setMediaItemWithStartPosition, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setMediaItemWithStartPosition(iMediaController, i, bundle, j);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItemWithResetPosition(IMediaController iMediaController, int i, Bundle bundle, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(Stub.TRANSACTION_setMediaItemWithResetPosition, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setMediaItemWithResetPosition(iMediaController, i, bundle, z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItems(IMediaController iMediaController, int i, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(Stub.TRANSACTION_setMediaItems, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setMediaItems(iMediaController, i, iBinder);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItemsWithResetPosition(IMediaController iMediaController, int i, IBinder iBinder, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(Stub.TRANSACTION_setMediaItemsWithResetPosition, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setMediaItemsWithResetPosition(iMediaController, i, iBinder, z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItemsWithStartIndex(IMediaController iMediaController, int i, IBinder iBinder, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(Stub.TRANSACTION_setMediaItemsWithStartIndex, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setMediaItemsWithStartIndex(iMediaController, i, iBinder, i2, j);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setPlayWhenReady(IMediaController iMediaController, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(Stub.TRANSACTION_setPlayWhenReady, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setPlayWhenReady(iMediaController, i, z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void onControllerResult(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onControllerResult, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onControllerResult(iMediaController, i, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void connect(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_connect, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().connect(iMediaController, i, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void onCustomCommand(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_onCustomCommand, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onCustomCommand(iMediaController, i, bundle, bundle2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(Stub.TRANSACTION_setRepeatMode, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setRepeatMode(iMediaController, i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setShuffleModeEnabled(IMediaController iMediaController, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(Stub.TRANSACTION_setShuffleModeEnabled, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setShuffleModeEnabled(iMediaController, i, z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void removeMediaItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(Stub.TRANSACTION_removeMediaItem, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().removeMediaItem(iMediaController, i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void removeMediaItems(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(Stub.TRANSACTION_removeMediaItems, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().removeMediaItems(iMediaController, i, i2, i3);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void clearMediaItems(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_clearMediaItems, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().clearMediaItems(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void moveMediaItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(Stub.TRANSACTION_moveMediaItem, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().moveMediaItem(iMediaController, i, i2, i3);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void moveMediaItems(IMediaController iMediaController, int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (this.mRemote.transact(Stub.TRANSACTION_moveMediaItems, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().moveMediaItems(iMediaController, i, i2, i3, i4);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void replaceMediaItem(IMediaController iMediaController, int i, int i2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_replaceMediaItem, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().replaceMediaItem(iMediaController, i, i2, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void replaceMediaItems(IMediaController iMediaController, int i, int i2, int i3, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(Stub.TRANSACTION_replaceMediaItems, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().replaceMediaItems(iMediaController, i, i2, i3, iBinder);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void play(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_play, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().play(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void pause(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_pause, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().pause(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void prepare(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_prepare, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().prepare(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setPlaybackParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_setPlaybackParameters, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setPlaybackParameters(iMediaController, i, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeFloat(f);
                    if (this.mRemote.transact(Stub.TRANSACTION_setPlaybackSpeed, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setPlaybackSpeed(iMediaController, i, f);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void addMediaItem(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_addMediaItem, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().addMediaItem(iMediaController, i, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void addMediaItemWithIndex(IMediaController iMediaController, int i, int i2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_addMediaItemWithIndex, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().addMediaItemWithIndex(iMediaController, i, i2, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void addMediaItems(IMediaController iMediaController, int i, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(Stub.TRANSACTION_addMediaItems, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().addMediaItems(iMediaController, i, iBinder);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void addMediaItemsWithIndex(IMediaController iMediaController, int i, int i2, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(Stub.TRANSACTION_addMediaItemsWithIndex, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().addMediaItemsWithIndex(iMediaController, i, i2, iBinder);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setPlaylistMetadata(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_setPlaylistMetadata, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setPlaylistMetadata(iMediaController, i, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void stop(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_stop, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().stop(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void release(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_release, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().release(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToDefaultPosition(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_seekToDefaultPosition, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekToDefaultPosition(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(Stub.TRANSACTION_seekToDefaultPositionWithMediaItemIndex, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekToDefaultPositionWithMediaItemIndex(iMediaController, i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(Stub.TRANSACTION_seekTo, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekTo(iMediaController, i, j);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToWithMediaItemIndex(IMediaController iMediaController, int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(Stub.TRANSACTION_seekToWithMediaItemIndex, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekToWithMediaItemIndex(iMediaController, i, i2, j);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekBack(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_seekBack, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekBack(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekForward(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_seekForward, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekForward(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToPreviousMediaItem(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_seekToPreviousMediaItem, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekToPreviousMediaItem(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToNextMediaItem(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_seekToNextMediaItem, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekToNextMediaItem(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setVideoSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_setVideoSurface, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setVideoSurface(iMediaController, i, surface);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void flushCommandQueue(IMediaController iMediaController) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    if (this.mRemote.transact(Stub.TRANSACTION_flushCommandQueue, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().flushCommandQueue(iMediaController);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToPrevious(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_seekToPrevious, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekToPrevious(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToNext(IMediaController iMediaController, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(Stub.TRANSACTION_seekToNext, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().seekToNext(iMediaController, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setTrackSelectionParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_setTrackSelectionParameters, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setTrackSelectionParameters(iMediaController, i, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setRatingWithMediaId(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_setRatingWithMediaId, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setRatingWithMediaId(iMediaController, i, str, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setRating(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_setRating, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setRating(iMediaController, i, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void getLibraryRoot(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4001, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().getLibraryRoot(iMediaController, i, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void getItem(IMediaController iMediaController, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (this.mRemote.transact(4002, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().getItem(iMediaController, i, str);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4003, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().getChildren(iMediaController, i, str, i2, i3, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void search(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4004, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().search(iMediaController, i, str, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4005, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().getSearchResult(iMediaController, i, str, i2, i3, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void subscribe(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(Stub.TRANSACTION_subscribe, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().subscribe(iMediaController, i, str, bundle);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (this.mRemote.transact(Stub.TRANSACTION_unsubscribe, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().unsubscribe(iMediaController, i, str);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMediaSession iMediaSession) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMediaSession == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMediaSession;
            return true;
        }

        public static IMediaSession getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
