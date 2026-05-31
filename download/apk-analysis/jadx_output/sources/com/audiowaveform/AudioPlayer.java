package com.audiowaveform;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import androidx.media3.common.DeviceInfo;
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
import androidx.media3.exoplayer.ExoPlayer;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioPlayer.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u001cJ\u0016\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0002J\u0006\u0010&\u001a\u00020\u0011J\u0006\u0010'\u001a\u00020\u001cJ\u0010\u0010(\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"J7\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010%2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.2\u0006\u0010!\u001a\u00020\"¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u0011H\u0002J\u001d\u00101\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010!\u001a\u00020\"¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u000105¢\u0006\u0002\u00106J\u001d\u00107\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u0001052\u0006\u0010!\u001a\u00020\"¢\u0006\u0002\u00108J'\u00109\u001a\u00020\u001c2\b\u0010\u000e\u001a\u0004\u0018\u00010%2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010!\u001a\u00020\"¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010<\u001a\u00020\u001cJ\b\u0010=\u001a\u00020\u001cH\u0002J\u001f\u0010>\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020?2\b\u00104\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0002\u0010@R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/audiowaveform/AudioPlayer;", "", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", Constants.playerKey, "", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;)V", "appContext", "audioFocusRequest", "Landroid/media/AudioFocusRequest;", "audioManager", "Landroid/media/AudioManager;", "audioPlaybackListener", "Landroid/os/CountDownTimer;", Constants.finishMode, "Lcom/audiowaveform/FinishMode;", "isAudioFocusGranted", "", "isComponentMounted", "isPlayerPrepared", SDKConstants.PARAM_KEY, "player", "Landroidx/media3/exoplayer/ExoPlayer;", "playerListener", "Landroidx/media3/common/Player$Listener;", Constants.updateFrequency, "Lcom/audiowaveform/UpdateFrequency;", "abandonAudioFocus", "", "emitCurrentDuration", "getDuration", Constants.durationType, "Lcom/audiowaveform/DurationType;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "handleAudioFocusChange", "focusChange", "", "isHoldingAudioTrack", "markPlayerAsUnmounted", "pause", "preparePlayer", "path", Constants.volume, "frequency", "progress", "", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/audiowaveform/UpdateFrequency;JLcom/facebook/react/bridge/Promise;)V", "requestAudioFocus", "seekToPosition", "(Ljava/lang/Long;Lcom/facebook/react/bridge/Promise;)V", "setPlaybackSpeed", Constants.speed, "", "(Ljava/lang/Float;)Z", "setVolume", "(Ljava/lang/Float;Lcom/facebook/react/bridge/Promise;)V", "start", "(Ljava/lang/Integer;Ljava/lang/Float;Lcom/facebook/react/bridge/Promise;)V", "startListening", "stop", "stopListening", "validateAndSetPlaybackSpeed", "Landroidx/media3/common/Player;", "(Landroidx/media3/common/Player;Ljava/lang/Float;)Z", "simform_solutions_react-native-audio-waveform_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioPlayer {
    private final ReactApplicationContext appContext;
    private AudioFocusRequest audioFocusRequest;
    private AudioManager audioManager;
    private CountDownTimer audioPlaybackListener;
    private FinishMode finishMode;
    private boolean isAudioFocusGranted;
    private boolean isComponentMounted;
    private boolean isPlayerPrepared;
    private final String key;
    private ExoPlayer player;
    private Player.Listener playerListener;
    private UpdateFrequency updateFrequency;

    public AudioPlayer(ReactApplicationContext context, String playerKey) {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder acceptsDelayedFocusGain;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playerKey, "playerKey");
        this.appContext = context;
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        this.finishMode = FinishMode.Stop;
        this.key = playerKey;
        this.updateFrequency = UpdateFrequency.Low;
        this.isComponentMounted = true;
        if (Build.VERSION.SDK_INT >= 26) {
            audioAttributes = Downloader$$ExternalSyntheticApiModelOutline0.m2150m(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build());
            acceptsDelayedFocusGain = audioAttributes.setAcceptsDelayedFocusGain(true);
            onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(new AudioManager.OnAudioFocusChangeListener() { // from class: com.audiowaveform.AudioPlayer$$ExternalSyntheticLambda9
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final void onAudioFocusChange(int i) {
                    AudioPlayer._init_$lambda$0(AudioPlayer.this, i);
                }
            });
            build = onAudioFocusChangeListener.build();
            this.audioFocusRequest = build;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(AudioPlayer this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleAudioFocusChange(i);
    }

    private final void handleAudioFocusChange(int focusChange) {
        ExoPlayer exoPlayer = null;
        if (focusChange == -3) {
            ExoPlayer exoPlayer2 = this.player;
            if (exoPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            } else {
                exoPlayer = exoPlayer2;
            }
            new Handler(exoPlayer.getApplicationLooper()).post(new Runnable() { // from class: com.audiowaveform.AudioPlayer$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    AudioPlayer.handleAudioFocusChange$lambda$8$lambda$7(AudioPlayer.this);
                }
            });
            return;
        }
        if (focusChange == -2) {
            ExoPlayer exoPlayer3 = this.player;
            if (exoPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            } else {
                exoPlayer = exoPlayer3;
            }
            new Handler(exoPlayer.getApplicationLooper()).post(new Runnable() { // from class: com.audiowaveform.AudioPlayer$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    AudioPlayer.handleAudioFocusChange$lambda$6$lambda$5(AudioPlayer.this);
                }
            });
            return;
        }
        if (focusChange == -1) {
            ExoPlayer exoPlayer4 = this.player;
            if (exoPlayer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            } else {
                exoPlayer = exoPlayer4;
            }
            new Handler(exoPlayer.getApplicationLooper()).post(new Runnable() { // from class: com.audiowaveform.AudioPlayer$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    AudioPlayer.handleAudioFocusChange$lambda$4$lambda$3(AudioPlayer.this);
                }
            });
            return;
        }
        if (focusChange != 1) {
            return;
        }
        ExoPlayer exoPlayer5 = this.player;
        if (exoPlayer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        } else {
            exoPlayer = exoPlayer5;
        }
        new Handler(exoPlayer.getApplicationLooper()).post(new Runnable() { // from class: com.audiowaveform.AudioPlayer$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                AudioPlayer.handleAudioFocusChange$lambda$2$lambda$1(AudioPlayer.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleAudioFocusChange$lambda$2$lambda$1(AudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExoPlayer exoPlayer = this$0.player;
        ExoPlayer exoPlayer2 = null;
        if (exoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
            exoPlayer = null;
        }
        if (!exoPlayer.isPlaying()) {
            ExoPlayer exoPlayer3 = this$0.player;
            if (exoPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                exoPlayer3 = null;
            }
            exoPlayer3.play();
        }
        ExoPlayer exoPlayer4 = this$0.player;
        if (exoPlayer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        } else {
            exoPlayer2 = exoPlayer4;
        }
        exoPlayer2.setVolume(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleAudioFocusChange$lambda$4$lambda$3(AudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExoPlayer exoPlayer = this$0.player;
        ExoPlayer exoPlayer2 = null;
        if (exoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
            exoPlayer = null;
        }
        if (exoPlayer.isPlaying()) {
            WritableMap createMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(createMap, "createMap(...)");
            this$0.stopListening();
            ExoPlayer exoPlayer3 = this$0.player;
            if (exoPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            } else {
                exoPlayer2 = exoPlayer3;
            }
            exoPlayer2.pause();
            this$0.abandonAudioFocus();
            createMap.putInt(Constants.finishType, 1);
            createMap.putString(Constants.playerKey, this$0.key);
            DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) this$0.appContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
            if (rCTDeviceEventEmitter != null) {
                rCTDeviceEventEmitter.emit("onDidFinishPlayingAudio", createMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleAudioFocusChange$lambda$6$lambda$5(AudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExoPlayer exoPlayer = this$0.player;
        ExoPlayer exoPlayer2 = null;
        if (exoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
            exoPlayer = null;
        }
        if (exoPlayer.isPlaying()) {
            ExoPlayer exoPlayer3 = this$0.player;
            if (exoPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            } else {
                exoPlayer2 = exoPlayer3;
            }
            exoPlayer2.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleAudioFocusChange$lambda$8$lambda$7(AudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExoPlayer exoPlayer = this$0.player;
        if (exoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
            exoPlayer = null;
        }
        exoPlayer.setVolume(0.2f);
    }

    private final boolean requestAudioFocus() {
        int requestAudioFocus;
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
            if (audioFocusRequest != null) {
                requestAudioFocus = this.audioManager.requestAudioFocus(audioFocusRequest);
                r2 = requestAudioFocus == 1;
                this.isAudioFocusGranted = r2;
            }
            return r2;
        }
        r2 = this.audioManager.requestAudioFocus(new AudioManager.OnAudioFocusChangeListener() { // from class: com.audiowaveform.AudioPlayer$$ExternalSyntheticLambda8
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i) {
                AudioPlayer.requestAudioFocus$lambda$10(AudioPlayer.this, i);
            }
        }, 3, 1) == 1;
        this.isAudioFocusGranted = r2;
        return r2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestAudioFocus$lambda$10(AudioPlayer this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleAudioFocusChange(i);
    }

    private final void abandonAudioFocus() {
        if (Build.VERSION.SDK_INT >= 26) {
            AudioManager audioManager = this.audioManager;
            AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
            Intrinsics.checkNotNull(audioFocusRequest);
            audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
        this.isAudioFocusGranted = false;
    }

    public final void markPlayerAsUnmounted() {
        this.isComponentMounted = false;
    }

    public final void preparePlayer(String path, final Integer volume, UpdateFrequency frequency, final long progress, final Promise promise) {
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (path != null) {
            this.isPlayerPrepared = false;
            this.isComponentMounted = true;
            this.updateFrequency = frequency;
            MediaItem fromUri = MediaItem.fromUri(Uri.parse(path));
            Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri(...)");
            ExoPlayer build = new ExoPlayer.Builder(this.appContext).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            this.player = build;
            ExoPlayer exoPlayer = null;
            if (build == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                build = null;
            }
            build.addMediaItem(fromUri);
            ExoPlayer exoPlayer2 = this.player;
            if (exoPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                exoPlayer2 = null;
            }
            exoPlayer2.prepare();
            this.playerListener = new Player.Listener() { // from class: com.audiowaveform.AudioPlayer$preparePlayer$1

                /* compiled from: AudioPlayer.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[FinishMode.values().length];
                        try {
                            iArr[FinishMode.Loop.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[FinishMode.Pause.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onAudioAttributesChanged(androidx.media3.common.AudioAttributes audioAttributes) {
                    Player.Listener.CC.$default$onAudioAttributesChanged(this, audioAttributes);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onAudioSessionIdChanged(int i) {
                    Player.Listener.CC.$default$onAudioSessionIdChanged(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
                    Player.Listener.CC.$default$onAvailableCommandsChanged(this, commands);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onCues(CueGroup cueGroup) {
                    Player.Listener.CC.$default$onCues(this, cueGroup);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onCues(List list) {
                    Player.Listener.CC.$default$onCues(this, list);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                    Player.Listener.CC.$default$onDeviceInfoChanged(this, deviceInfo);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
                    Player.Listener.CC.$default$onDeviceVolumeChanged(this, i, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onEvents(Player player, Player.Events events) {
                    Player.Listener.CC.$default$onEvents(this, player, events);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onIsLoadingChanged(boolean z) {
                    Player.Listener.CC.$default$onIsLoadingChanged(this, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onIsPlayingChanged(boolean z) {
                    Player.Listener.CC.$default$onIsPlayingChanged(this, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onLoadingChanged(boolean z) {
                    Player.Listener.CC.$default$onLoadingChanged(this, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
                    Player.Listener.CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
                    Player.Listener.CC.$default$onMediaItemTransition(this, mediaItem, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                    Player.Listener.CC.$default$onMediaMetadataChanged(this, mediaMetadata);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onMetadata(androidx.media3.common.Metadata metadata) {
                    Player.Listener.CC.$default$onMetadata(this, metadata);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                    Player.Listener.CC.$default$onPlayWhenReadyChanged(this, z, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                    Player.Listener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlaybackStateChanged(int i) {
                    Player.Listener.CC.$default$onPlaybackStateChanged(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                    Player.Listener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
                    Player.Listener.CC.$default$onPlayerError(this, playbackException);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
                    Player.Listener.CC.$default$onPlayerErrorChanged(this, playbackException);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                    Player.Listener.CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPositionDiscontinuity(int i) {
                    Player.Listener.CC.$default$onPositionDiscontinuity(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
                    Player.Listener.CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onRenderedFirstFrame() {
                    Player.Listener.CC.$default$onRenderedFirstFrame(this);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onRepeatModeChanged(int i) {
                    Player.Listener.CC.$default$onRepeatModeChanged(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onSeekBackIncrementChanged(long j) {
                    Player.Listener.CC.$default$onSeekBackIncrementChanged(this, j);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
                    Player.Listener.CC.$default$onSeekForwardIncrementChanged(this, j);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                    Player.Listener.CC.$default$onShuffleModeEnabledChanged(this, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
                    Player.Listener.CC.$default$onSkipSilenceEnabledChanged(this, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
                    Player.Listener.CC.$default$onSurfaceSizeChanged(this, i, i2);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                    Player.Listener.CC.$default$onTimelineChanged(this, timeline, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                    Player.Listener.CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onTracksChanged(Tracks tracks) {
                    Player.Listener.CC.$default$onTracksChanged(this, tracks);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                    Player.Listener.CC.$default$onVideoSizeChanged(this, videoSize);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onVolumeChanged(float f) {
                    Player.Listener.CC.$default$onVolumeChanged(this, f);
                }

                @Override // androidx.media3.common.Player.Listener
                @Deprecated(message = "Deprecated in Java")
                public void onPlayerStateChanged(boolean isReady, int state) {
                    boolean z;
                    FinishMode finishMode;
                    ExoPlayer exoPlayer3;
                    ExoPlayer exoPlayer4;
                    String str;
                    boolean z2;
                    ReactApplicationContext reactApplicationContext;
                    ExoPlayer exoPlayer5;
                    ExoPlayer exoPlayer6;
                    ExoPlayer exoPlayer7;
                    ExoPlayer exoPlayer8;
                    ExoPlayer exoPlayer9;
                    ExoPlayer exoPlayer10;
                    ExoPlayer exoPlayer11;
                    z = AudioPlayer.this.isPlayerPrepared;
                    ExoPlayer exoPlayer12 = null;
                    if (!z && state == 3) {
                        exoPlayer9 = AudioPlayer.this.player;
                        if (exoPlayer9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("player");
                            exoPlayer9 = null;
                        }
                        exoPlayer9.setVolume(volume != null ? r3.intValue() : 1);
                        exoPlayer10 = AudioPlayer.this.player;
                        if (exoPlayer10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("player");
                            exoPlayer10 = null;
                        }
                        exoPlayer10.seekTo(progress);
                        AudioPlayer.this.isPlayerPrepared = true;
                        exoPlayer11 = AudioPlayer.this.player;
                        if (exoPlayer11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("player");
                            exoPlayer11 = null;
                        }
                        promise.resolve(String.valueOf(exoPlayer11.getDuration()));
                    }
                    if (state == 4) {
                        WritableMap createMap = Arguments.createMap();
                        Intrinsics.checkNotNullExpressionValue(createMap, "createMap(...)");
                        finishMode = AudioPlayer.this.finishMode;
                        int i = WhenMappings.$EnumSwitchMapping$0[finishMode.ordinal()];
                        if (i == 1) {
                            exoPlayer3 = AudioPlayer.this.player;
                            if (exoPlayer3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("player");
                                exoPlayer3 = null;
                            }
                            exoPlayer3.seekTo(0L);
                            exoPlayer4 = AudioPlayer.this.player;
                            if (exoPlayer4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("player");
                            } else {
                                exoPlayer12 = exoPlayer4;
                            }
                            exoPlayer12.play();
                            createMap.putInt(Constants.finishType, 0);
                        } else if (i != 2) {
                            exoPlayer7 = AudioPlayer.this.player;
                            if (exoPlayer7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("player");
                                exoPlayer7 = null;
                            }
                            exoPlayer7.stop();
                            exoPlayer8 = AudioPlayer.this.player;
                            if (exoPlayer8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("player");
                            } else {
                                exoPlayer12 = exoPlayer8;
                            }
                            exoPlayer12.release();
                            AudioPlayer.this.stopListening();
                            createMap.putInt(Constants.finishType, 2);
                        } else {
                            exoPlayer5 = AudioPlayer.this.player;
                            if (exoPlayer5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("player");
                                exoPlayer5 = null;
                            }
                            exoPlayer5.seekTo(0L);
                            exoPlayer6 = AudioPlayer.this.player;
                            if (exoPlayer6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("player");
                            } else {
                                exoPlayer12 = exoPlayer6;
                            }
                            exoPlayer12.setPlayWhenReady(false);
                            AudioPlayer.this.stopListening();
                            createMap.putInt(Constants.finishType, 1);
                        }
                        str = AudioPlayer.this.key;
                        createMap.putString(Constants.playerKey, str);
                        z2 = AudioPlayer.this.isComponentMounted;
                        if (z2) {
                            reactApplicationContext = AudioPlayer.this.appContext;
                            DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
                            if (rCTDeviceEventEmitter != null) {
                                rCTDeviceEventEmitter.emit("onDidFinishPlayingAudio", createMap);
                            }
                        }
                    }
                }
            };
            ExoPlayer exoPlayer3 = this.player;
            if (exoPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            } else {
                exoPlayer = exoPlayer3;
            }
            Player.Listener listener = this.playerListener;
            Intrinsics.checkNotNull(listener);
            exoPlayer.addListener(listener);
            return;
        }
        promise.reject("preparePlayer Error", "path to audio file or unique key can't be null");
    }

    public final void seekToPosition(Long progress, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (progress != null) {
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                exoPlayer = null;
            }
            exoPlayer.seekTo(progress.longValue());
            promise.resolve(true);
            return;
        }
        promise.resolve(false);
    }

    public final void getDuration(DurationType durationType, Promise promise) {
        Intrinsics.checkNotNullParameter(durationType, "durationType");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ExoPlayer exoPlayer = null;
        if (durationType == DurationType.Current) {
            ExoPlayer exoPlayer2 = this.player;
            if (exoPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            } else {
                exoPlayer = exoPlayer2;
            }
            promise.resolve(String.valueOf(exoPlayer.getCurrentPosition()));
            return;
        }
        ExoPlayer exoPlayer3 = this.player;
        if (exoPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        } else {
            exoPlayer = exoPlayer3;
        }
        promise.resolve(String.valueOf(exoPlayer.getDuration()));
    }

    private final boolean validateAndSetPlaybackSpeed(Player player, Float speed) {
        PlaybackParameters withSpeed = player.getPlaybackParameters().withSpeed((speed == null || speed.floatValue() <= 0.0f) ? 1.0f : speed.floatValue());
        Intrinsics.checkNotNullExpressionValue(withSpeed, "withSpeed(...)");
        player.setPlaybackParameters(withSpeed);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d A[Catch: Exception -> 0x0013, TRY_ENTER, TryCatch #0 {Exception -> 0x0013, blocks: (B:27:0x0008, B:29:0x000e, B:7:0x0026, B:10:0x002d, B:11:0x0031, B:13:0x003c, B:15:0x0040, B:16:0x0044, B:18:0x004b, B:19:0x0050, B:23:0x0061, B:4:0x0017, B:6:0x001d, B:25:0x0022), top: B:26:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c A[Catch: Exception -> 0x0013, TryCatch #0 {Exception -> 0x0013, blocks: (B:27:0x0008, B:29:0x000e, B:7:0x0026, B:10:0x002d, B:11:0x0031, B:13:0x003c, B:15:0x0040, B:16:0x0044, B:18:0x004b, B:19:0x0050, B:23:0x0061, B:4:0x0017, B:6:0x001d, B:25:0x0022), top: B:26:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061 A[Catch: Exception -> 0x0013, TRY_LEAVE, TryCatch #0 {Exception -> 0x0013, blocks: (B:27:0x0008, B:29:0x000e, B:7:0x0026, B:10:0x002d, B:11:0x0031, B:13:0x003c, B:15:0x0040, B:16:0x0044, B:18:0x004b, B:19:0x0050, B:23:0x0061, B:4:0x0017, B:6:0x001d, B:25:0x0022), top: B:26:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void start(java.lang.Integer r4, java.lang.Float r5, com.facebook.react.bridge.Promise r6) {
        /*
            r3 = this;
            java.lang.String r0 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 1
            if (r4 == 0) goto L15
            int r1 = r4.intValue()     // Catch: java.lang.Exception -> L13
            if (r1 != 0) goto L15
            com.audiowaveform.FinishMode r4 = com.audiowaveform.FinishMode.Loop     // Catch: java.lang.Exception -> L13
            r3.finishMode = r4     // Catch: java.lang.Exception -> L13
            goto L26
        L13:
            r4 = move-exception
            goto L69
        L15:
            if (r4 == 0) goto L22
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> L13
            if (r4 != r0) goto L22
            com.audiowaveform.FinishMode r4 = com.audiowaveform.FinishMode.Pause     // Catch: java.lang.Exception -> L13
            r3.finishMode = r4     // Catch: java.lang.Exception -> L13
            goto L26
        L22:
            com.audiowaveform.FinishMode r4 = com.audiowaveform.FinishMode.Stop     // Catch: java.lang.Exception -> L13
            r3.finishMode = r4     // Catch: java.lang.Exception -> L13
        L26:
            androidx.media3.exoplayer.ExoPlayer r4 = r3.player     // Catch: java.lang.Exception -> L13
            r1 = 0
            java.lang.String r2 = "player"
            if (r4 != 0) goto L31
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch: java.lang.Exception -> L13
            r4 = r1
        L31:
            androidx.media3.common.Player r4 = (androidx.media3.common.Player) r4     // Catch: java.lang.Exception -> L13
            r3.validateAndSetPlaybackSpeed(r4, r5)     // Catch: java.lang.Exception -> L13
            boolean r4 = r3.requestAudioFocus()     // Catch: java.lang.Exception -> L13
            if (r4 == 0) goto L61
            androidx.media3.exoplayer.ExoPlayer r4 = r3.player     // Catch: java.lang.Exception -> L13
            if (r4 != 0) goto L44
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch: java.lang.Exception -> L13
            r4 = r1
        L44:
            r4.setPlayWhenReady(r0)     // Catch: java.lang.Exception -> L13
            androidx.media3.exoplayer.ExoPlayer r4 = r3.player     // Catch: java.lang.Exception -> L13
            if (r4 != 0) goto L4f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch: java.lang.Exception -> L13
            goto L50
        L4f:
            r1 = r4
        L50:
            r1.play()     // Catch: java.lang.Exception -> L13
            r3.emitCurrentDuration()     // Catch: java.lang.Exception -> L13
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Exception -> L13
            r6.resolve(r4)     // Catch: java.lang.Exception -> L13
            r3.startListening(r6)     // Catch: java.lang.Exception -> L13
            goto L72
        L61:
            java.lang.String r4 = "AudioFocusError"
            java.lang.String r5 = "Failed to gain audio focus"
            r6.reject(r4, r5)     // Catch: java.lang.Exception -> L13
            goto L72
        L69:
            java.lang.String r5 = "Can not start the player"
            java.lang.String r4 = r4.toString()
            r6.reject(r5, r4)
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.audiowaveform.AudioPlayer.start(java.lang.Integer, java.lang.Float, com.facebook.react.bridge.Promise):void");
    }

    public final void stop() {
        stopListening();
        emitCurrentDuration();
        ExoPlayer exoPlayer = null;
        if (this.playerListener != null) {
            ExoPlayer exoPlayer2 = this.player;
            if (exoPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                exoPlayer2 = null;
            }
            Player.Listener listener = this.playerListener;
            Intrinsics.checkNotNull(listener);
            exoPlayer2.removeListener(listener);
        }
        this.isPlayerPrepared = false;
        ExoPlayer exoPlayer3 = this.player;
        if (exoPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
            exoPlayer3 = null;
        }
        exoPlayer3.stop();
        ExoPlayer exoPlayer4 = this.player;
        if (exoPlayer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        } else {
            exoPlayer = exoPlayer4;
        }
        exoPlayer.release();
        abandonAudioFocus();
    }

    public final void pause(Promise promise) {
        try {
            stopListening();
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                exoPlayer = null;
            }
            exoPlayer.pause();
            emitCurrentDuration();
            abandonAudioFocus();
            if (promise != null) {
                promise.resolve(true);
            }
        } catch (Exception e) {
            if (promise != null) {
                promise.reject("Failed to pause the player", e.toString());
            }
        }
    }

    public final void setVolume(Float volume, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            if (volume != null) {
                ExoPlayer exoPlayer = this.player;
                if (exoPlayer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                    exoPlayer = null;
                }
                exoPlayer.setVolume(volume.floatValue());
                promise.resolve(true);
                return;
            }
            promise.resolve(false);
        } catch (Exception unused) {
            promise.resolve(false);
        }
    }

    public final boolean setPlaybackSpeed(Float speed) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
            exoPlayer = null;
        }
        return validateAndSetPlaybackSpeed(exoPlayer, speed);
    }

    public final void emitCurrentDuration() {
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
            exoPlayer = null;
        }
        String valueOf = String.valueOf(exoPlayer.getCurrentPosition());
        WritableMap createMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(createMap, "createMap(...)");
        createMap.putString(Constants.currentDuration, valueOf);
        createMap.putString(Constants.playerKey, this.key);
        if (!this.isComponentMounted || (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) this.appContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) == null) {
            return;
        }
        rCTDeviceEventEmitter.emit("onCurrentDuration", createMap);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.audiowaveform.AudioPlayer$startListening$1] */
    private final void startListening(Promise promise) {
        try {
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
                exoPlayer = null;
            }
            final long duration = exoPlayer.getDuration();
            final long value = UpdateFrequency.Low.getValue();
            CountDownTimer start = new CountDownTimer(duration, value) { // from class: com.audiowaveform.AudioPlayer$startListening$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                }

                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    AudioPlayer.this.emitCurrentDuration();
                }
            }.start();
            Intrinsics.checkNotNullExpressionValue(start, "start(...)");
            this.audioPlaybackListener = start;
        } catch (JavascriptException e) {
            promise.reject("startListening Error", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopListening() {
        CountDownTimer countDownTimer = this.audioPlaybackListener;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audioPlaybackListener");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
    }

    public final boolean isHoldingAudioTrack() {
        return this.audioPlaybackListener != null;
    }
}
