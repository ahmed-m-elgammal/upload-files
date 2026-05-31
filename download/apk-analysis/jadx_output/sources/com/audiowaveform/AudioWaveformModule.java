package com.audiowaveform;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioWaveformModule.kt */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0014*\u0001\u000e\u0018\u0000 J2\u00020\u0001:\u0001JB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J:\u0010 \u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J*\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010&\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010)\u001a\u00020\u0007H\u0016J\"\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0007H\u0002J\"\u0010-\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0017\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0007H\u0002J\u001a\u00103\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u00104\u001a\u00020\u001dH\u0007J0\u00105\u001a\b\u0012\u0004\u0012\u000207062\f\u00108\u001a\b\u0012\u0004\u0012\u000207062\b\b\u0002\u00109\u001a\u0002072\b\b\u0002\u0010:\u001a\u000207H\u0002J\u0018\u0010;\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010<\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010=\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010?\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010@\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010A\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010B\u001a\u00020\u001dH\u0002J\u0018\u0010C\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u001a\u0010D\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010E\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010F\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010G\u001a\u00020\u001dH\u0002J\u0018\u0010H\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010I\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/audiowaveform/AudioWaveformModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "audioPlayers", "", "", "Lcom/audiowaveform/AudioPlayer;", "audioRecorder", "Lcom/audiowaveform/AudioRecorder;", Constants.bitRate, "", "emitLiveRecordValue", "com/audiowaveform/AudioWaveformModule$emitLiveRecordValue$1", "Lcom/audiowaveform/AudioWaveformModule$emitLiveRecordValue$1;", "encoder", "extractors", "Lcom/audiowaveform/WaveformExtractor;", "handler", "Landroid/os/Handler;", "outputFormat", "path", "recorder", "Landroid/media/MediaRecorder;", Constants.sampleRate, "startTime", "", "checkHasAudioRecorderPermission", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "checkPathAndInitialiseRecorder", "obj", "Lcom/facebook/react/bridge/ReadableMap;", "createOrUpdateExtractor", Constants.playerKey, Constants.noOfSamples, "extractWaveformData", "getAudioRecorderPermission", "getDuration", "getName", "getPlayerKeyOrReject", "arguments", "errorCode", "getPlayerOrReject", "getUpdateFrequency", "Lcom/audiowaveform/UpdateFrequency;", "frequency", "(Ljava/lang/Integer;)Lcom/audiowaveform/UpdateFrequency;", "initPlayer", "initRecorder", "markPlayerAsUnmounted", "normalizeWaveformData", "", "", "data", "scale", "threshold", "pausePlayer", "pauseRecording", "preparePlayer", "resumeRecording", "seekToPlayer", "setPlaybackSpeed", "setVolume", "startEmittingRecorderValue", "startPlayer", "startRecording", "stopAllPlayers", "stopAllWaveFormExtractors", "stopEmittingRecorderValue", "stopPlayer", "stopRecording", "Companion", "simform_solutions_react-native-audio-waveform_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioWaveformModule extends ReactContextBaseJavaModule {
    public static final int MAX_NUMBER_OF_AUDIO_PLAYER = 30;
    public static final String NAME = "AudioWaveform";
    private Map<String, AudioPlayer> audioPlayers;
    private AudioRecorder audioRecorder;
    private int bitRate;
    private final AudioWaveformModule$emitLiveRecordValue$1 emitLiveRecordValue;
    private int encoder;
    private Map<String, WaveformExtractor> extractors;
    private final Handler handler;
    private int outputFormat;
    private String path;
    private MediaRecorder recorder;
    private int sampleRate;
    private long startTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.audiowaveform.AudioWaveformModule$emitLiveRecordValue$1] */
    public AudioWaveformModule(ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.extractors = new LinkedHashMap();
        this.audioPlayers = new LinkedHashMap();
        this.audioRecorder = new AudioRecorder();
        this.sampleRate = 44100;
        this.bitRate = 128000;
        this.handler = new Handler(Looper.getMainLooper());
        this.emitLiveRecordValue = new Runnable() { // from class: com.audiowaveform.AudioWaveformModule$emitLiveRecordValue$1
            @Override // java.lang.Runnable
            public void run() {
                AudioRecorder audioRecorder;
                MediaRecorder mediaRecorder;
                Handler handler;
                ReactApplicationContext reactApplicationContext;
                audioRecorder = AudioWaveformModule.this.audioRecorder;
                mediaRecorder = AudioWaveformModule.this.recorder;
                Double decibel = audioRecorder.getDecibel(mediaRecorder);
                WritableMap createMap = Arguments.createMap();
                Intrinsics.checkNotNullExpressionValue(createMap, "createMap(...)");
                if (Intrinsics.areEqual(decibel, Double.NEGATIVE_INFINITY)) {
                    createMap.putDouble(Constants.currentDecibel, AudioStats.AUDIO_AMPLITUDE_NONE);
                } else if (decibel != null) {
                    createMap.putDouble(Constants.currentDecibel, decibel.doubleValue() / 1000);
                }
                handler = AudioWaveformModule.this.handler;
                handler.postDelayed(this, UpdateFrequency.Low.getValue());
                reactApplicationContext = AudioWaveformModule.this.getReactApplicationContext();
                DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
                if (rCTDeviceEventEmitter != null) {
                    rCTDeviceEventEmitter.emit(Constants.onCurrentRecordingWaveformData, createMap);
                }
            }
        };
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public final void markPlayerAsUnmounted() {
        if (this.audioPlayers.isEmpty()) {
            return;
        }
        for (AudioPlayer audioPlayer : this.audioPlayers.values()) {
            if (audioPlayer != null) {
                audioPlayer.markPlayerAsUnmounted();
            }
        }
    }

    @ReactMethod
    public final void checkHasAudioRecorderPermission(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.audioRecorder.checkPermission(getReactApplicationContext().getCurrentActivity(), promise);
    }

    @ReactMethod
    public final void getAudioRecorderPermission(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.audioRecorder.getPermission(getReactApplicationContext().getCurrentActivity(), promise);
    }

    @ReactMethod
    public final void initRecorder(ReadableMap obj, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        checkPathAndInitialiseRecorder(this.encoder, this.outputFormat, this.sampleRate, this.bitRate, promise, obj);
    }

    @ReactMethod
    public final void startRecording(ReadableMap obj, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        initRecorder(obj, promise);
        this.audioRecorder.startRecorder(this.recorder, true, promise);
        this.startTime = System.currentTimeMillis();
        startEmittingRecorderValue();
    }

    @ReactMethod
    public final void pauseRecording(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.audioRecorder.pauseRecording(this.recorder, promise);
        stopEmittingRecorderValue();
    }

    @ReactMethod
    public final void resumeRecording(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.audioRecorder.resumeRecording(this.recorder, promise);
        startEmittingRecorderValue();
    }

    @ReactMethod
    public final void stopRecording(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (this.audioRecorder == null || this.recorder == null || this.path == null) {
            promise.reject("STOP_RECORDING_ERROR", "Recording resources not properly initialized");
            return;
        }
        try {
            if (System.currentTimeMillis() - this.startTime < 500) {
                promise.reject("SHORT_RECORDING", "Recording is too short");
                return;
            }
            stopEmittingRecorderValue();
            AudioRecorder audioRecorder = this.audioRecorder;
            MediaRecorder mediaRecorder = this.recorder;
            String str = this.path;
            Intrinsics.checkNotNull(str);
            audioRecorder.stopRecording(mediaRecorder, str, promise);
            this.recorder = null;
            this.path = null;
        } catch (Exception e) {
            Log.e(Constants.LOG_TAG, "Failed to stop recording", e);
            promise.reject("Error", "Failed to stop recording: " + e.getMessage());
        }
    }

    @ReactMethod
    public final void preparePlayer(ReadableMap obj, Promise promise) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Map<String, AudioPlayer> map = this.audioPlayers;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, AudioPlayer> entry : map.entrySet()) {
            AudioPlayer value = entry.getValue();
            if (value != null && value.isHoldingAudioTrack()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.size() >= 30) {
            promise.reject(Constants.LOG_TAG, "Too many players have been initialized. Please stop some players before continuing");
            return;
        }
        String string = obj.getString("path");
        String string2 = obj.getString(Constants.playerKey);
        int i = obj.getInt(Constants.updateFrequency);
        int i2 = obj.getInt(Constants.volume);
        long j = (!obj.hasKey("progress") || obj.isNull("progress")) ? 0L : obj.getInt("progress");
        if (string2 != null) {
            initPlayer(string2);
            AudioPlayer audioPlayer = this.audioPlayers.get(string2);
            if (audioPlayer != null) {
                audioPlayer.preparePlayer(string, Integer.valueOf(i2), getUpdateFrequency(Integer.valueOf(i)), j, promise);
                return;
            }
            return;
        }
        promise.reject(Constants.LOG_TAG, "Player key can't be null");
    }

    @ReactMethod
    public final void startPlayer(ReadableMap obj, Promise promise) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(promise, "promise");
        int i = obj.getInt(Constants.finishMode);
        double d = obj.getDouble(Constants.speed);
        AudioPlayer playerOrReject = getPlayerOrReject(obj, promise, "startPlayer Error");
        if (playerOrReject != null) {
            playerOrReject.start(Integer.valueOf(i), Float.valueOf((float) d), promise);
        }
    }

    @ReactMethod
    public final void stopPlayer(ReadableMap obj, Promise promise) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(promise, "promise");
        String string = obj.getString(Constants.playerKey);
        if (string != null) {
            AudioPlayer audioPlayer = this.audioPlayers.get(string);
            if (audioPlayer != null) {
                audioPlayer.stop();
            }
            this.audioPlayers.put(string, null);
            promise.resolve(true);
            return;
        }
        promise.reject("stopPlayer Error", "Player key can't be null");
    }

    @ReactMethod
    public final void pausePlayer(ReadableMap obj, Promise promise) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(promise, "promise");
        AudioPlayer playerOrReject = getPlayerOrReject(obj, promise, "pausePlayer Error");
        if (playerOrReject != null) {
            playerOrReject.pause(promise);
        }
    }

    @ReactMethod
    public final void seekToPlayer(ReadableMap obj, Promise promise) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                int i = obj.getInt("progress");
                AudioPlayer playerOrReject = getPlayerOrReject(obj, promise, "seekTo Error");
                if (playerOrReject != null) {
                    playerOrReject.seekToPosition(Long.valueOf(i), promise);
                }
            } else {
                Log.e(Constants.LOG_TAG, "Minimum android O is required for seekTo function to works");
                promise.resolve(false);
            }
        } catch (Exception e) {
            promise.reject("seekTo Error", e.toString());
        }
    }

    @ReactMethod
    public final void setVolume(ReadableMap obj, Promise promise) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(promise, "promise");
        int i = obj.getInt(Constants.volume);
        AudioPlayer playerOrReject = getPlayerOrReject(obj, promise, "setVolume Error");
        if (playerOrReject != null) {
            playerOrReject.setVolume(Float.valueOf(i), promise);
        }
    }

    @ReactMethod
    public final void getDuration(ReadableMap obj, Promise promise) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(promise, "promise");
        DurationType durationType = obj.getInt(Constants.durationType) == 0 ? DurationType.Current : DurationType.Max;
        AudioPlayer playerOrReject = getPlayerOrReject(obj, promise, "getDuration Error");
        if (playerOrReject != null) {
            playerOrReject.getDuration(durationType, promise);
        }
    }

    @ReactMethod
    public final void extractWaveformData(ReadableMap obj, Promise promise) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(promise, "promise");
        String string = obj.getString(Constants.playerKey);
        String string2 = obj.getString("path");
        int i = obj.getInt(Constants.noOfSamples);
        if (string != null) {
            createOrUpdateExtractor(string, i, string2, promise);
        } else {
            Log.e(Constants.LOG_TAG, "Can not get waveform data Player key is null");
        }
    }

    @ReactMethod
    public final void stopAllPlayers(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            for (AudioPlayer audioPlayer : this.audioPlayers.values()) {
                if (audioPlayer != null) {
                    audioPlayer.stop();
                }
            }
            this.audioPlayers.clear();
            promise.resolve(true);
        } catch (Exception unused) {
            promise.reject("stopAllPlayers Error", "Error while stopping all players");
        }
    }

    @ReactMethod
    public final void stopAllWaveFormExtractors(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            for (WaveformExtractor waveformExtractor : this.extractors.values()) {
                if (waveformExtractor != null) {
                    waveformExtractor.forceStop();
                }
            }
            this.extractors.clear();
            promise.resolve(true);
        } catch (Exception unused) {
            promise.reject("stopAllExtractors Error", "Error while stopping all extractors");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:3:0x000e, B:5:0x0014, B:8:0x001b, B:9:0x0023, B:11:0x002b, B:13:0x0035, B:15:0x0045, B:16:0x004b, B:21:0x0053), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053 A[Catch: Exception -> 0x0059, TRY_LEAVE, TryCatch #0 {Exception -> 0x0059, blocks: (B:3:0x000e, B:5:0x0014, B:8:0x001b, B:9:0x0023, B:11:0x002b, B:13:0x0035, B:15:0x0045, B:16:0x004b, B:21:0x0053), top: B:2:0x000e }] */
    @com.facebook.react.bridge.ReactMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setPlaybackSpeed(com.facebook.react.bridge.ReadableMap r4, com.facebook.react.bridge.Promise r5) {
        /*
            r3 = this;
            java.lang.String r0 = "setPlaybackSpeed Error"
            java.lang.String r1 = "speed"
            java.lang.String r2 = "obj"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            java.lang.String r2 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            boolean r2 = r4.hasKey(r1)     // Catch: java.lang.Exception -> L59
            if (r2 == 0) goto L21
            boolean r2 = r4.isNull(r1)     // Catch: java.lang.Exception -> L59
            if (r2 == 0) goto L1b
            goto L21
        L1b:
            double r1 = r4.getDouble(r1)     // Catch: java.lang.Exception -> L59
            float r1 = (float) r1     // Catch: java.lang.Exception -> L59
            goto L23
        L21:
            r1 = 1065353216(0x3f800000, float:1.0)
        L23:
            java.lang.String r2 = "playerKey"
            java.lang.String r4 = r4.getString(r2)     // Catch: java.lang.Exception -> L59
            if (r4 == 0) goto L53
            java.util.Map<java.lang.String, com.audiowaveform.AudioPlayer> r2 = r3.audioPlayers     // Catch: java.lang.Exception -> L59
            java.lang.Object r4 = r2.get(r4)     // Catch: java.lang.Exception -> L59
            com.audiowaveform.AudioPlayer r4 = (com.audiowaveform.AudioPlayer) r4     // Catch: java.lang.Exception -> L59
            if (r4 == 0) goto L42
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch: java.lang.Exception -> L59
            boolean r4 = r4.setPlaybackSpeed(r1)     // Catch: java.lang.Exception -> L59
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Exception -> L59
            goto L43
        L42:
            r4 = 0
        L43:
            if (r4 == 0) goto L4a
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Exception -> L59
            goto L4b
        L4a:
            r4 = 0
        L4b:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Exception -> L59
            r5.resolve(r4)     // Catch: java.lang.Exception -> L59
            goto L61
        L53:
            java.lang.String r4 = "Player key can't be null"
            r5.reject(r0, r4)     // Catch: java.lang.Exception -> L59
            goto L61
        L59:
            r4 = move-exception
            java.lang.String r4 = r4.toString()
            r5.reject(r0, r4)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.audiowaveform.AudioWaveformModule.setPlaybackSpeed(com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    private final void initPlayer(String playerKey) {
        if (this.audioPlayers.get(playerKey) == null) {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            this.audioPlayers.put(playerKey, new AudioPlayer(reactApplicationContext, playerKey));
        }
    }

    private final void createOrUpdateExtractor(final String playerKey, int noOfSamples, String path, final Promise promise) {
        if (path == null) {
            promise.reject("createOrUpdateExtractor Error", "No Path Provided");
            return;
        }
        Map<String, WaveformExtractor> map = this.extractors;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        map.put(playerKey, new WaveformExtractor(reactApplicationContext, path, noOfSamples, playerKey, new ExtractorCallBack() { // from class: com.audiowaveform.AudioWaveformModule$createOrUpdateExtractor$1
            @Override // com.audiowaveform.ExtractorCallBack
            public void onProgress(float value) {
                Map map2;
                List<Float> sampleData;
                if (value == 1.0f) {
                    map2 = AudioWaveformModule.this.extractors;
                    WaveformExtractor waveformExtractor = (WaveformExtractor) map2.get(playerKey);
                    if (waveformExtractor == null || (sampleData = waveformExtractor.getSampleData()) == null) {
                        return;
                    }
                    promise.resolve(Arguments.fromList(CollectionsKt.mutableListOf(AudioWaveformModule.normalizeWaveformData$default(AudioWaveformModule.this, sampleData, 0.12f, 0.0f, 4, null))));
                }
            }

            @Override // com.audiowaveform.ExtractorCallBack
            public void onReject(String error, String message) {
                Promise promise2 = promise;
                if (error == null) {
                    error = "Error";
                }
                if (message == null) {
                    message = "An error is thrown while decoding the audio file";
                }
                promise2.reject(error, message);
            }

            @Override // com.audiowaveform.ExtractorCallBack
            public void onResolve(List<List<Float>> value) {
                Intrinsics.checkNotNullParameter(value, "value");
                promise.resolve(Arguments.fromList(value));
            }

            @Override // com.audiowaveform.ExtractorCallBack
            public void onForceStop() {
                promise.resolve(Arguments.fromList(CollectionsKt.mutableListOf(CollectionsKt.emptyList())));
            }
        }));
        WaveformExtractor waveformExtractor = this.extractors.get(playerKey);
        if (waveformExtractor != null) {
            waveformExtractor.startDecode();
        }
    }

    static /* synthetic */ List normalizeWaveformData$default(AudioWaveformModule audioWaveformModule, List list, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.25f;
        }
        if ((i & 4) != 0) {
            f2 = 0.01f;
        }
        return audioWaveformModule.normalizeWaveformData(list, f, f2);
    }

    private final List<Float> normalizeWaveformData(List<Float> data, float scale, float threshold) {
        List<Float> list = data;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Math.abs(((Number) obj).floatValue()) >= threshold) {
                arrayList.add(obj);
            }
        }
        Float maxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) arrayList);
        float floatValue = maxOrNull != null ? maxOrNull.floatValue() : 1.0f;
        if (floatValue <= 0.0f) {
            return data;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            float floatValue2 = ((Number) it.next()).floatValue();
            arrayList2.add(Float.valueOf(Math.abs(floatValue2) < threshold ? 0.0f : (floatValue2 / floatValue) * scale));
        }
        return CollectionsKt.toMutableList((Collection) arrayList2);
    }

    private final UpdateFrequency getUpdateFrequency(Integer frequency) {
        if (frequency != null && frequency.intValue() == 2) {
            return UpdateFrequency.High;
        }
        if (frequency != null && frequency.intValue() == 1) {
            return UpdateFrequency.Medium;
        }
        return UpdateFrequency.Low;
    }

    private final void checkPathAndInitialiseRecorder(int encoder, int outputFormat, int sampleRate, int bitRate, Promise promise, ReadableMap obj) {
        if (obj != null) {
            if (obj.hasKey(Constants.bitRate)) {
                bitRate = obj.getInt(Constants.bitRate);
            }
            if (obj.hasKey(Constants.sampleRate)) {
                sampleRate = obj.getInt(Constants.sampleRate);
            }
        }
        int i = sampleRate;
        int i2 = bitRate;
        try {
            this.recorder = new MediaRecorder();
        } catch (Exception unused) {
            Log.e(Constants.LOG_TAG, "Failed to initialise Recorder");
        }
        String str = this.path;
        if (str == null) {
            Activity currentActivity = getReactApplicationContext().getCurrentActivity();
            try {
                String path = File.createTempFile(new SimpleDateFormat(Constants.fileNameFormat, Locale.US).format(new Date()), ".m4a", currentActivity != null ? currentActivity.getCacheDir() : null).getPath();
                this.path = path;
                AudioRecorder audioRecorder = this.audioRecorder;
                Intrinsics.checkNotNull(path);
                audioRecorder.initRecorder(path, this.recorder, encoder, outputFormat, i, i2, promise);
                return;
            } catch (IOException unused2) {
                Log.e(Constants.LOG_TAG, "Failed to create file");
                return;
            }
        }
        AudioRecorder audioRecorder2 = this.audioRecorder;
        Intrinsics.checkNotNull(str);
        audioRecorder2.initRecorder(str, this.recorder, encoder, outputFormat, i, i2, promise);
    }

    private final void startEmittingRecorderValue() {
        this.handler.postDelayed(this.emitLiveRecordValue, UpdateFrequency.Low.getValue());
    }

    private final void stopEmittingRecorderValue() {
        this.handler.removeCallbacks(this.emitLiveRecordValue);
    }

    private final AudioPlayer getPlayerOrReject(ReadableMap arguments, Promise promise, String errorCode) {
        AudioPlayer audioPlayer = this.audioPlayers.get(getPlayerKeyOrReject(arguments, promise, errorCode));
        if (audioPlayer != null) {
            return audioPlayer;
        }
        promise.reject(errorCode, errorCode + ": Player not in the list");
        return null;
    }

    private final String getPlayerKeyOrReject(ReadableMap arguments, Promise promise, String errorCode) {
        String string = arguments.getString(Constants.playerKey);
        if (string != null) {
            return string;
        }
        promise.reject(errorCode, errorCode + ": Player key can't be null");
        return null;
    }
}
