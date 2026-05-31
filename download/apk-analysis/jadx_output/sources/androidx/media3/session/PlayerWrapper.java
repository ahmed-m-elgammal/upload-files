package androidx.media3.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media.VolumeProviderCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.ForwardingPlayer;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.session.PlayerWrapper;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: classes.dex */
class PlayerWrapper extends ForwardingPlayer {
    private static final int STATUS_CODE_SUCCESS_COMPAT = -1;
    private Player.Commands availablePlayerCommands;
    private SessionCommands availableSessionCommands;
    private ImmutableList<CommandButton> customLayout;
    private Bundle legacyErrorExtras;
    private String legacyErrorMessage;
    private int legacyStatusCode;
    private final boolean playIfSuppressed;

    private static long convertCommandToPlaybackStateActions(int i) {
        if (i == 1) {
            return 518L;
        }
        if (i == 2) {
            return 16384L;
        }
        if (i == 3) {
            return 1L;
        }
        if (i == 31) {
            return 240640L;
        }
        switch (i) {
            case 5:
                return 256L;
            case 6:
            case 7:
                return 16L;
            case 8:
            case 9:
                return 32L;
            case 10:
                return PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            case 11:
                return 8L;
            case 12:
                return 64L;
            case 13:
                return PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
            case 14:
                return 2621440L;
            case 15:
                return PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            default:
                return 0L;
        }
    }

    public PlayerWrapper(Player player, boolean z, ImmutableList<CommandButton> immutableList, SessionCommands sessionCommands, Player.Commands commands) {
        super(player);
        this.playIfSuppressed = z;
        this.customLayout = immutableList;
        this.availableSessionCommands = sessionCommands;
        this.availablePlayerCommands = commands;
        this.legacyStatusCode = -1;
    }

    public void setAvailableCommands(SessionCommands sessionCommands, Player.Commands commands) {
        this.availableSessionCommands = sessionCommands;
        this.availablePlayerCommands = commands;
    }

    public SessionCommands getAvailableSessionCommands() {
        return this.availableSessionCommands;
    }

    public Player.Commands getAvailablePlayerCommands() {
        return this.availablePlayerCommands;
    }

    public void setCustomLayout(ImmutableList<CommandButton> immutableList) {
        this.customLayout = immutableList;
    }

    ImmutableList<CommandButton> getCustomLayout() {
        return this.customLayout;
    }

    public void setLegacyErrorStatus(int i, String str, Bundle bundle) {
        Assertions.checkState(i != -1);
        this.legacyStatusCode = i;
        this.legacyErrorMessage = str;
        this.legacyErrorExtras = bundle;
    }

    public int getLegacyStatusCode() {
        return this.legacyStatusCode;
    }

    public void clearLegacyErrorStatus() {
        this.legacyStatusCode = -1;
        this.legacyErrorMessage = null;
        this.legacyErrorExtras = null;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void addListener(Player.Listener listener) {
        verifyApplicationThread();
        super.addListener(listener);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void removeListener(Player.Listener listener) {
        verifyApplicationThread();
        super.removeListener(listener);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public PlaybackException getPlayerError() {
        verifyApplicationThread();
        return super.getPlayerError();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void play() {
        verifyApplicationThread();
        super.play();
    }

    public void playIfCommandAvailable() {
        if (isCommandAvailable(1)) {
            play();
        }
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void pause() {
        verifyApplicationThread();
        super.pause();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void prepare() {
        verifyApplicationThread();
        super.prepare();
    }

    public void prepareIfCommandAvailable() {
        if (isCommandAvailable(2)) {
            prepare();
        }
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void stop() {
        verifyApplicationThread();
        super.stop();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void release() {
        verifyApplicationThread();
        super.release();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToDefaultPosition(int i) {
        verifyApplicationThread();
        super.seekToDefaultPosition(i);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToDefaultPosition() {
        verifyApplicationThread();
        super.seekToDefaultPosition();
    }

    public void seekToDefaultPositionIfCommandAvailable() {
        if (isCommandAvailable(4)) {
            seekToDefaultPosition();
        }
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekTo(long j) {
        verifyApplicationThread();
        super.seekTo(j);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekTo(int i, long j) {
        verifyApplicationThread();
        super.seekTo(i, j);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getSeekBackIncrement() {
        verifyApplicationThread();
        return super.getSeekBackIncrement();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekBack() {
        verifyApplicationThread();
        super.seekBack();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getSeekForwardIncrement() {
        verifyApplicationThread();
        return super.getSeekForwardIncrement();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekForward() {
        verifyApplicationThread();
        super.seekForward();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        super.setPlaybackParameters(playbackParameters);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setPlaybackSpeed(float f) {
        verifyApplicationThread();
        super.setPlaybackSpeed(f);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getCurrentPosition() {
        verifyApplicationThread();
        return super.getCurrentPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getDuration() {
        verifyApplicationThread();
        return super.getDuration();
    }

    public long getDurationWithCommandCheck() {
        if (isCommandAvailable(16)) {
            return getDuration();
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getBufferedPosition() {
        verifyApplicationThread();
        return super.getBufferedPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getBufferedPercentage() {
        verifyApplicationThread();
        return super.getBufferedPercentage();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getTotalBufferedDuration() {
        verifyApplicationThread();
        return super.getTotalBufferedDuration();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getCurrentLiveOffset() {
        verifyApplicationThread();
        return super.getCurrentLiveOffset();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getContentDuration() {
        verifyApplicationThread();
        return super.getContentDuration();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getContentPosition() {
        verifyApplicationThread();
        return super.getContentPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getContentBufferedPosition() {
        verifyApplicationThread();
        return super.getContentBufferedPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isPlayingAd() {
        verifyApplicationThread();
        return super.isPlayingAd();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        return super.getCurrentAdGroupIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        return super.getCurrentAdIndexInAdGroup();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return super.getPlaybackParameters();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public VideoSize getVideoSize() {
        verifyApplicationThread();
        return super.getVideoSize();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearVideoSurface() {
        verifyApplicationThread();
        super.clearVideoSurface();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearVideoSurface(Surface surface) {
        verifyApplicationThread();
        super.clearVideoSurface(surface);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setVideoSurface(Surface surface) {
        verifyApplicationThread();
        super.setVideoSurface(surface);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        super.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        super.clearVideoSurfaceHolder(surfaceHolder);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        verifyApplicationThread();
        super.setVideoSurfaceView(surfaceView);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        verifyApplicationThread();
        super.clearVideoSurfaceView(surfaceView);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setVideoTextureView(TextureView textureView) {
        verifyApplicationThread();
        super.setVideoTextureView(textureView);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearVideoTextureView(TextureView textureView) {
        verifyApplicationThread();
        super.clearVideoTextureView(textureView);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public AudioAttributes getAudioAttributes() {
        verifyApplicationThread();
        return super.getAudioAttributes();
    }

    public AudioAttributes getAudioAttributesWithCommandCheck() {
        if (isCommandAvailable(21)) {
            return getAudioAttributes();
        }
        return AudioAttributes.DEFAULT;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        super.setMediaItem(mediaItem);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItem(MediaItem mediaItem, long j) {
        verifyApplicationThread();
        super.setMediaItem(mediaItem, j);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItem(MediaItem mediaItem, boolean z) {
        verifyApplicationThread();
        super.setMediaItem(mediaItem, z);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        super.setMediaItems(list);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItems(List<MediaItem> list, boolean z) {
        verifyApplicationThread();
        super.setMediaItems(list, z);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setMediaItems(List<MediaItem> list, int i, long j) {
        verifyApplicationThread();
        super.setMediaItems(list, i, j);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void addMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        super.addMediaItem(mediaItem);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void addMediaItem(int i, MediaItem mediaItem) {
        verifyApplicationThread();
        super.addMediaItem(i, mediaItem);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void addMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        super.addMediaItems(list);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void addMediaItems(int i, List<MediaItem> list) {
        verifyApplicationThread();
        super.addMediaItems(i, list);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void clearMediaItems() {
        verifyApplicationThread();
        super.clearMediaItems();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void removeMediaItem(int i) {
        verifyApplicationThread();
        super.removeMediaItem(i);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void removeMediaItems(int i, int i2) {
        verifyApplicationThread();
        super.removeMediaItems(i, i2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void moveMediaItem(int i, int i2) {
        verifyApplicationThread();
        super.moveMediaItem(i, i2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void moveMediaItems(int i, int i2, int i3) {
        verifyApplicationThread();
        super.moveMediaItems(i, i2, i3);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void replaceMediaItem(int i, MediaItem mediaItem) {
        verifyApplicationThread();
        super.replaceMediaItem(i, mediaItem);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void replaceMediaItems(int i, int i2, List<MediaItem> list) {
        verifyApplicationThread();
        super.replaceMediaItems(i, i2, list);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public boolean hasPrevious() {
        verifyApplicationThread();
        return super.hasPrevious();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public boolean hasNext() {
        verifyApplicationThread();
        return super.hasNext();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public boolean hasPreviousWindow() {
        verifyApplicationThread();
        return super.hasPreviousWindow();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public boolean hasNextWindow() {
        verifyApplicationThread();
        return super.hasNextWindow();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean hasPreviousMediaItem() {
        verifyApplicationThread();
        return super.hasPreviousMediaItem();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean hasNextMediaItem() {
        verifyApplicationThread();
        return super.hasNextMediaItem();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void previous() {
        verifyApplicationThread();
        super.previous();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void next() {
        verifyApplicationThread();
        super.next();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void seekToPreviousWindow() {
        verifyApplicationThread();
        super.seekToPreviousWindow();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void seekToNextWindow() {
        verifyApplicationThread();
        super.seekToNextWindow();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToPreviousMediaItem() {
        verifyApplicationThread();
        super.seekToPreviousMediaItem();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToNextMediaItem() {
        verifyApplicationThread();
        super.seekToNextMediaItem();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        verifyApplicationThread();
        super.setPlaylistMetadata(mediaMetadata);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setRepeatMode(int i) {
        verifyApplicationThread();
        super.setRepeatMode(i);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setShuffleModeEnabled(boolean z) {
        verifyApplicationThread();
        super.setShuffleModeEnabled(z);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return super.getCurrentTimeline();
    }

    public Timeline getCurrentTimelineWithCommandCheck() {
        if (isCommandAvailable(17)) {
            return getCurrentTimeline();
        }
        if (isCommandAvailable(16)) {
            return new CurrentMediaItemOnlyTimeline(this);
        }
        return Timeline.EMPTY;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public MediaMetadata getPlaylistMetadata() {
        verifyApplicationThread();
        return super.getPlaylistMetadata();
    }

    public MediaMetadata getPlaylistMetadataWithCommandCheck() {
        if (isCommandAvailable(18)) {
            return getPlaylistMetadata();
        }
        return MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getRepeatMode() {
        verifyApplicationThread();
        return super.getRepeatMode();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return super.getShuffleModeEnabled();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public MediaItem getCurrentMediaItem() {
        verifyApplicationThread();
        return super.getCurrentMediaItem();
    }

    public MediaItem getCurrentMediaItemWithCommandCheck() {
        if (isCommandAvailable(16)) {
            return getCurrentMediaItem();
        }
        return null;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getMediaItemCount() {
        verifyApplicationThread();
        return super.getMediaItemCount();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public MediaItem getMediaItemAt(int i) {
        verifyApplicationThread();
        return super.getMediaItemAt(i);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public int getCurrentWindowIndex() {
        verifyApplicationThread();
        return super.getCurrentWindowIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getCurrentMediaItemIndex() {
        verifyApplicationThread();
        return super.getCurrentMediaItemIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public int getPreviousWindowIndex() {
        verifyApplicationThread();
        return super.getPreviousWindowIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getPreviousMediaItemIndex() {
        verifyApplicationThread();
        return super.getPreviousMediaItemIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public int getNextWindowIndex() {
        verifyApplicationThread();
        return super.getNextWindowIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getNextMediaItemIndex() {
        verifyApplicationThread();
        return super.getNextMediaItemIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public float getVolume() {
        verifyApplicationThread();
        return super.getVolume();
    }

    public float getVolumeWithCommandCheck() {
        if (isCommandAvailable(22)) {
            return getVolume();
        }
        return 0.0f;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setVolume(float f) {
        verifyApplicationThread();
        super.setVolume(f);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public CueGroup getCurrentCues() {
        verifyApplicationThread();
        return super.getCurrentCues();
    }

    public CueGroup getCurrentCuesWithCommandCheck() {
        return isCommandAvailable(28) ? getCurrentCues() : CueGroup.EMPTY_TIME_ZERO;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        return super.getDeviceInfo();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getDeviceVolume() {
        verifyApplicationThread();
        return super.getDeviceVolume();
    }

    public int getDeviceVolumeWithCommandCheck() {
        if (isCommandAvailable(23)) {
            return getDeviceVolume();
        }
        return 0;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isDeviceMuted() {
        verifyApplicationThread();
        return super.isDeviceMuted();
    }

    public boolean isDeviceMutedWithCommandCheck() {
        return isCommandAvailable(23) && isDeviceMuted();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void setDeviceVolume(int i) {
        verifyApplicationThread();
        super.setDeviceVolume(i);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setDeviceVolume(int i, int i2) {
        verifyApplicationThread();
        super.setDeviceVolume(i, i2);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void increaseDeviceVolume() {
        verifyApplicationThread();
        super.increaseDeviceVolume();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void increaseDeviceVolume(int i) {
        verifyApplicationThread();
        super.increaseDeviceVolume(i);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void decreaseDeviceVolume() {
        verifyApplicationThread();
        super.decreaseDeviceVolume();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void decreaseDeviceVolume(int i) {
        verifyApplicationThread();
        super.decreaseDeviceVolume(i);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    @Deprecated
    public void setDeviceMuted(boolean z) {
        verifyApplicationThread();
        super.setDeviceMuted(z);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setDeviceMuted(boolean z, int i) {
        verifyApplicationThread();
        super.setDeviceMuted(z, i);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setPlayWhenReady(boolean z) {
        verifyApplicationThread();
        super.setPlayWhenReady(z);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean getPlayWhenReady() {
        verifyApplicationThread();
        return super.getPlayWhenReady();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        return super.getPlaybackSuppressionReason();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getPlaybackState() {
        verifyApplicationThread();
        return super.getPlaybackState();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isPlaying() {
        verifyApplicationThread();
        return super.isPlaying();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isLoading() {
        verifyApplicationThread();
        return super.isLoading();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public MediaMetadata getMediaMetadata() {
        verifyApplicationThread();
        return super.getMediaMetadata();
    }

    public MediaMetadata getMediaMetadataWithCommandCheck() {
        return isCommandAvailable(18) ? getMediaMetadata() : MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isCommandAvailable(int i) {
        verifyApplicationThread();
        return super.isCommandAvailable(i);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public Player.Commands getAvailableCommands() {
        verifyApplicationThread();
        return super.getAvailableCommands();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThread();
        return super.getTrackSelectionParameters();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        verifyApplicationThread();
        super.setTrackSelectionParameters(trackSelectionParameters);
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToPrevious() {
        verifyApplicationThread();
        super.seekToPrevious();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public long getMaxSeekToPreviousPosition() {
        verifyApplicationThread();
        return super.getMaxSeekToPreviousPosition();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public void seekToNext() {
        verifyApplicationThread();
        super.seekToNext();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public Tracks getCurrentTracks() {
        verifyApplicationThread();
        return super.getCurrentTracks();
    }

    public Tracks getCurrentTracksWithCommandCheck() {
        return isCommandAvailable(30) ? getCurrentTracks() : Tracks.EMPTY;
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public Object getCurrentManifest() {
        verifyApplicationThread();
        return super.getCurrentManifest();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public int getCurrentPeriodIndex() {
        verifyApplicationThread();
        return super.getCurrentPeriodIndex();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isCurrentMediaItemDynamic() {
        verifyApplicationThread();
        return super.isCurrentMediaItemDynamic();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isCurrentMediaItemLive() {
        verifyApplicationThread();
        return super.isCurrentMediaItemLive();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public boolean isCurrentMediaItemSeekable() {
        verifyApplicationThread();
        return super.isCurrentMediaItemSeekable();
    }

    @Override // androidx.media3.common.ForwardingPlayer, androidx.media3.common.Player
    public Size getSurfaceSize() {
        verifyApplicationThread();
        return super.getSurfaceSize();
    }

    public PlaybackStateCompat createPlaybackStateCompat() {
        if (this.legacyStatusCode != -1) {
            return new PlaybackStateCompat.Builder().setState(7, -1L, 0.0f, SystemClock.elapsedRealtime()).setActions(0L).setBufferedPosition(0L).setErrorMessage(this.legacyStatusCode, (CharSequence) Assertions.checkNotNull(this.legacyErrorMessage)).setExtras((Bundle) Assertions.checkNotNull(this.legacyErrorExtras)).build();
        }
        PlaybackException playerError = getPlayerError();
        int convertToPlaybackStateCompatState = LegacyConversions.convertToPlaybackStateCompatState(this, this.playIfSuppressed);
        Player.Commands intersect = MediaUtils.intersect(this.availablePlayerCommands, getAvailableCommands());
        long j = 128;
        for (int i = 0; i < intersect.size(); i++) {
            j |= convertCommandToPlaybackStateActions(intersect.get(i));
        }
        long convertToQueueItemId = isCommandAvailable(17) ? LegacyConversions.convertToQueueItemId(getCurrentMediaItemIndex()) : -1L;
        float f = getPlaybackParameters().speed;
        float f2 = isPlaying() ? f : 0.0f;
        Bundle bundle = new Bundle();
        bundle.putFloat(MediaConstants.EXTRAS_KEY_PLAYBACK_SPEED_COMPAT, f);
        MediaItem currentMediaItemWithCommandCheck = getCurrentMediaItemWithCommandCheck();
        if (currentMediaItemWithCommandCheck != null && !"".equals(currentMediaItemWithCommandCheck.mediaId)) {
            bundle.putString("androidx.media.PlaybackStateCompat.Extras.KEY_MEDIA_ID", currentMediaItemWithCommandCheck.mediaId);
        }
        boolean isCommandAvailable = isCommandAvailable(16);
        PlaybackStateCompat.Builder extras = new PlaybackStateCompat.Builder().setState(convertToPlaybackStateCompatState, isCommandAvailable ? getCurrentPosition() : -1L, f2, SystemClock.elapsedRealtime()).setActions(j).setActiveQueueItemId(convertToQueueItemId).setBufferedPosition(isCommandAvailable ? getBufferedPosition() : 0L).setExtras(bundle);
        for (int i2 = 0; i2 < this.customLayout.size(); i2++) {
            CommandButton commandButton = this.customLayout.get(i2);
            if (commandButton.sessionCommand != null) {
                SessionCommand sessionCommand = commandButton.sessionCommand;
                if (sessionCommand.commandCode == 0 && CommandButton.isEnabled(commandButton, this.availableSessionCommands, this.availablePlayerCommands)) {
                    extras.addCustomAction(new PlaybackStateCompat.CustomAction.Builder(sessionCommand.customAction, commandButton.displayName, commandButton.iconResId).setExtras(sessionCommand.customExtras).build());
                }
            }
        }
        if (playerError != null) {
            extras.setErrorMessage(0, (CharSequence) Util.castNonNull(playerError.getMessage()));
        }
        return extras.build();
    }

    public VolumeProviderCompat createVolumeProviderCompat() {
        int i;
        if (getDeviceInfo().playbackType == 0) {
            return null;
        }
        Player.Commands availableCommands = getAvailableCommands();
        if (availableCommands.containsAny(26, 34)) {
            i = availableCommands.containsAny(25, 33) ? 2 : 1;
        } else {
            i = 0;
        }
        int i2 = i;
        Handler handler = new Handler(getApplicationLooper());
        int deviceVolumeWithCommandCheck = getDeviceVolumeWithCommandCheck();
        DeviceInfo deviceInfo = getDeviceInfo();
        return new AnonymousClass1(i2, deviceInfo.maxVolume, deviceVolumeWithCommandCheck, deviceInfo.routingControllerId, handler, 1);
    }

    /* renamed from: androidx.media3.session.PlayerWrapper$1, reason: invalid class name */
    class AnonymousClass1 extends VolumeProviderCompat {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ int val$legacyVolumeFlag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, int i2, int i3, String str, Handler handler, int i4) {
            super(i, i2, i3, str);
            this.val$handler = handler;
            this.val$legacyVolumeFlag = i4;
        }

        @Override // androidx.media.VolumeProviderCompat
        public void onSetVolumeTo(final int i) {
            Handler handler = this.val$handler;
            final int i2 = this.val$legacyVolumeFlag;
            Util.postOrRun(handler, new Runnable() { // from class: androidx.media3.session.PlayerWrapper$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerWrapper.AnonymousClass1.this.m816lambda$onSetVolumeTo$0$androidxmedia3sessionPlayerWrapper$1(i, i2);
                }
            });
        }

        /* renamed from: lambda$onSetVolumeTo$0$androidx-media3-session-PlayerWrapper$1, reason: not valid java name */
        /* synthetic */ void m816lambda$onSetVolumeTo$0$androidxmedia3sessionPlayerWrapper$1(int i, int i2) {
            if (PlayerWrapper.this.isCommandAvailable(25) || PlayerWrapper.this.isCommandAvailable(33)) {
                if (PlayerWrapper.this.isCommandAvailable(33)) {
                    PlayerWrapper.this.setDeviceVolume(i, i2);
                } else {
                    PlayerWrapper.this.setDeviceVolume(i);
                }
            }
        }

        @Override // androidx.media.VolumeProviderCompat
        public void onAdjustVolume(final int i) {
            Handler handler = this.val$handler;
            final int i2 = this.val$legacyVolumeFlag;
            Util.postOrRun(handler, new Runnable() { // from class: androidx.media3.session.PlayerWrapper$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerWrapper.AnonymousClass1.this.m815lambda$onAdjustVolume$1$androidxmedia3sessionPlayerWrapper$1(i, i2);
                }
            });
        }

        /* renamed from: lambda$onAdjustVolume$1$androidx-media3-session-PlayerWrapper$1, reason: not valid java name */
        /* synthetic */ void m815lambda$onAdjustVolume$1$androidxmedia3sessionPlayerWrapper$1(int i, int i2) {
            if (PlayerWrapper.this.isCommandAvailable(26) || PlayerWrapper.this.isCommandAvailable(34)) {
                if (i == -100) {
                    if (PlayerWrapper.this.isCommandAvailable(34)) {
                        PlayerWrapper.this.setDeviceMuted(true, i2);
                        return;
                    } else {
                        PlayerWrapper.this.setDeviceMuted(true);
                        return;
                    }
                }
                if (i == -1) {
                    if (PlayerWrapper.this.isCommandAvailable(34)) {
                        PlayerWrapper.this.decreaseDeviceVolume(i2);
                        return;
                    } else {
                        PlayerWrapper.this.decreaseDeviceVolume();
                        return;
                    }
                }
                if (i == 1) {
                    if (PlayerWrapper.this.isCommandAvailable(34)) {
                        PlayerWrapper.this.increaseDeviceVolume(i2);
                        return;
                    } else {
                        PlayerWrapper.this.increaseDeviceVolume();
                        return;
                    }
                }
                if (i == 100) {
                    if (PlayerWrapper.this.isCommandAvailable(34)) {
                        PlayerWrapper.this.setDeviceMuted(false, i2);
                        return;
                    } else {
                        PlayerWrapper.this.setDeviceMuted(false);
                        return;
                    }
                }
                if (i == 101) {
                    if (PlayerWrapper.this.isCommandAvailable(34)) {
                        PlayerWrapper.this.setDeviceMuted(!r4.isDeviceMutedWithCommandCheck(), i2);
                        return;
                    } else {
                        PlayerWrapper.this.setDeviceMuted(!r4.isDeviceMutedWithCommandCheck());
                        return;
                    }
                }
                Log.w("VolumeProviderCompat", "onAdjustVolume: Ignoring unknown direction: " + i);
            }
        }
    }

    public Player.PositionInfo createPositionInfoForBundling() {
        boolean isCommandAvailable = isCommandAvailable(16);
        boolean isCommandAvailable2 = isCommandAvailable(17);
        return new Player.PositionInfo(null, isCommandAvailable2 ? getCurrentMediaItemIndex() : 0, isCommandAvailable ? getCurrentMediaItem() : null, null, isCommandAvailable2 ? getCurrentPeriodIndex() : 0, isCommandAvailable ? getCurrentPosition() : 0L, isCommandAvailable ? getContentPosition() : 0L, isCommandAvailable ? getCurrentAdGroupIndex() : -1, isCommandAvailable ? getCurrentAdIndexInAdGroup() : -1);
    }

    public SessionPositionInfo createSessionPositionInfoForBundling() {
        boolean isCommandAvailable = isCommandAvailable(16);
        return new SessionPositionInfo(createPositionInfoForBundling(), isCommandAvailable && isPlayingAd(), SystemClock.elapsedRealtime(), isCommandAvailable ? getDuration() : -9223372036854775807L, isCommandAvailable ? getBufferedPosition() : 0L, isCommandAvailable ? getBufferedPercentage() : 0, isCommandAvailable ? getTotalBufferedDuration() : 0L, isCommandAvailable ? getCurrentLiveOffset() : -9223372036854775807L, isCommandAvailable ? getContentDuration() : -9223372036854775807L, isCommandAvailable ? getContentBufferedPosition() : 0L);
    }

    public PlayerInfo createPlayerInfoForBundling() {
        return new PlayerInfo(getPlayerError(), 0, createSessionPositionInfoForBundling(), createPositionInfoForBundling(), createPositionInfoForBundling(), 0, getPlaybackParameters(), getRepeatMode(), getShuffleModeEnabled(), getVideoSize(), getCurrentTimelineWithCommandCheck(), 0, getPlaylistMetadataWithCommandCheck(), getVolumeWithCommandCheck(), getAudioAttributesWithCommandCheck(), getCurrentCuesWithCommandCheck(), getDeviceInfo(), getDeviceVolumeWithCommandCheck(), isDeviceMutedWithCommandCheck(), getPlayWhenReady(), 1, getPlaybackSuppressionReason(), getPlaybackState(), isPlaying(), isLoading(), getMediaMetadataWithCommandCheck(), getSeekBackIncrement(), getSeekForwardIncrement(), getMaxSeekToPreviousPosition(), getCurrentTracksWithCommandCheck(), getTrackSelectionParameters());
    }

    private void verifyApplicationThread() {
        Assertions.checkState(Looper.myLooper() == getApplicationLooper());
    }

    private static final class CurrentMediaItemOnlyTimeline extends Timeline {
        private static final Object UID = new Object();
        private final long durationUs;
        private final boolean isDynamic;
        private final boolean isSeekable;
        private final MediaItem.LiveConfiguration liveConfiguration;
        private final MediaItem mediaItem;

        @Override // androidx.media3.common.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override // androidx.media3.common.Timeline
        public int getWindowCount() {
            return 1;
        }

        public CurrentMediaItemOnlyTimeline(PlayerWrapper playerWrapper) {
            this.mediaItem = playerWrapper.getCurrentMediaItem();
            this.isSeekable = playerWrapper.isCurrentMediaItemSeekable();
            this.isDynamic = playerWrapper.isCurrentMediaItemDynamic();
            this.liveConfiguration = playerWrapper.isCurrentMediaItemLive() ? MediaItem.LiveConfiguration.UNSET : null;
            this.durationUs = Util.msToUs(playerWrapper.getContentDuration());
        }

        @Override // androidx.media3.common.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            window.set(UID, this.mediaItem, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.isSeekable, this.isDynamic, this.liveConfiguration, 0L, this.durationUs, 0, 0, 0L);
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            Object obj = UID;
            period.set(obj, obj, 0, this.durationUs, 0L);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public int getIndexOfPeriod(Object obj) {
            return UID.equals(obj) ? 0 : -1;
        }

        @Override // androidx.media3.common.Timeline
        public Object getUidOfPeriod(int i) {
            return UID;
        }
    }
}
