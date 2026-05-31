package com.audiowaveform;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import androidx.camera.video.AudioStats;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelGroupSerializer;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WaveformExtractor.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010&\u001a\u00020'J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0005H\u0016J\u0018\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u00100\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u000eH\u0002J\u0006\u00103\u001a\u00020'J\b\u00104\u001a\u00020'H\u0002R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/audiowaveform/WaveformExtractor;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "path", "", "expectedPoints", "", SDKConstants.PARAM_KEY, "extractorCallBack", "Lcom/audiowaveform/ExtractorCallBack;", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;ILjava/lang/String;Lcom/audiowaveform/ExtractorCallBack;)V", NotificationsChannelGroupSerializer.CHANNELS_KEY, "currentProgress", "", "decoder", "Landroid/media/MediaCodec;", "duration", "", "extractor", "Landroid/media/MediaExtractor;", "inProgress", "", "inputEof", "pcmEncodingBit", "perSamplePoints", "progress", "sampleCount", "sampleData", "", "getSampleData", "()Ljava/util/List;", "setSampleData", "(Ljava/util/List;)V", Constants.sampleRate, "sampleSum", "", "totalSamples", "forceStop", "", "getFormat", "Landroid/media/MediaFormat;", "getName", "handle16bit", RRWebVideoEvent.JsonKeys.SIZE, "buf", "Ljava/nio/ByteBuffer;", "handle32bit", "handle8bit", "rms", "value", "startDecode", "stop", "simform_solutions_react-native-audio-waveform_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WaveformExtractor extends ReactContextBaseJavaModule {
    private int channels;
    private float currentProgress;
    private MediaCodec decoder;
    private long duration;
    private final int expectedPoints;
    private MediaExtractor extractor;
    private final ExtractorCallBack extractorCallBack;
    private volatile boolean inProgress;
    private boolean inputEof;
    private final String key;
    private final String path;
    private int pcmEncodingBit;
    private long perSamplePoints;
    private float progress;
    private long sampleCount;
    private List<Float> sampleData;
    private int sampleRate;
    private double sampleSum;
    private long totalSamples;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaveformExtractor(ReactApplicationContext context, String path, int i, String key, ExtractorCallBack extractorCallBack) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(extractorCallBack, "extractorCallBack");
        this.path = path;
        this.expectedPoints = i;
        this.key = key;
        this.extractorCallBack = extractorCallBack;
        this.channels = 1;
        this.pcmEncodingBit = 16;
        this.sampleData = new ArrayList();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "WaveformExtractor";
    }

    private final MediaFormat getFormat(String path) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.extractor = mediaExtractor;
        mediaExtractor.setDataSource(getReactApplicationContext(), Uri.parse(path), (Map<String, String>) null);
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            Intrinsics.checkNotNullExpressionValue(trackFormat, "getTrackFormat(...)");
            String string = trackFormat.getString("mime");
            if (string == null) {
                string = "";
            }
            Intrinsics.checkNotNull(string);
            if (StringsKt.contains$default((CharSequence) string, (CharSequence) "audio", false, 2, (Object) null)) {
                this.duration = trackFormat.getLong("durationUs") / 1000000;
                mediaExtractor.selectTrack(i);
                return trackFormat;
            }
        }
        return null;
    }

    public final void startDecode() {
        try {
            if (!new File(this.path).exists()) {
                this.extractorCallBack.onReject("File Error", "File does not exist at the given path.");
                return;
            }
            MediaFormat format = getFormat(this.path);
            if (format == null) {
                throw new IllegalStateException("No audio format found".toString());
            }
            String string = format.getString("mime");
            if (string == null) {
                throw new IllegalStateException("No MIME type found".toString());
            }
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
            createDecoderByType.configure(format, (Surface) null, (MediaCrypto) null, 0);
            createDecoderByType.setCallback(new MediaCodec.Callback() { // from class: com.audiowaveform.WaveformExtractor$startDecode$1$1
                /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
                
                    r0 = r9.this$0.extractor;
                 */
                @Override // android.media.MediaCodec.Callback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onInputBufferAvailable(android.media.MediaCodec r10, int r11) {
                    /*
                        r9 = this;
                        java.lang.String r0 = "codec"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                        com.audiowaveform.WaveformExtractor r0 = com.audiowaveform.WaveformExtractor.this
                        boolean r0 = com.audiowaveform.WaveformExtractor.access$getInputEof$p(r0)
                        if (r0 != 0) goto L4b
                        com.audiowaveform.WaveformExtractor r0 = com.audiowaveform.WaveformExtractor.this
                        boolean r0 = com.audiowaveform.WaveformExtractor.access$getInProgress$p(r0)
                        if (r0 != 0) goto L16
                        goto L4b
                    L16:
                        com.audiowaveform.WaveformExtractor r0 = com.audiowaveform.WaveformExtractor.this
                        android.media.MediaExtractor r0 = com.audiowaveform.WaveformExtractor.access$getExtractor$p(r0)
                        if (r0 != 0) goto L1f
                        return
                    L1f:
                        java.nio.ByteBuffer r2 = r10.getInputBuffer(r11)
                        if (r2 == 0) goto L4b
                        com.audiowaveform.WaveformExtractor r8 = com.audiowaveform.WaveformExtractor.this
                        r3 = 0
                        int r4 = r0.readSampleData(r2, r3)
                        if (r4 <= 0) goto L3d
                        long r5 = r0.getSampleTime()
                        r7 = 0
                        r3 = 0
                        r1 = r10
                        r2 = r11
                        r1.queueInputBuffer(r2, r3, r4, r5, r7)
                        r0.advance()
                        goto L4b
                    L3d:
                        r5 = 0
                        r7 = 4
                        r3 = 0
                        r4 = 0
                        r1 = r10
                        r2 = r11
                        r1.queueInputBuffer(r2, r3, r4, r5, r7)
                        r0 = 1
                        com.audiowaveform.WaveformExtractor.access$setInputEof$p(r8, r0)
                    L4b:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.audiowaveform.WaveformExtractor$startDecode$1$1.onInputBufferAvailable(android.media.MediaCodec, int):void");
                }

                @Override // android.media.MediaCodec.Callback
                public void onOutputFormatChanged(MediaCodec codec, MediaFormat format2) {
                    boolean z;
                    int i;
                    long j;
                    long j2;
                    int i2;
                    int integer;
                    Intrinsics.checkNotNullParameter(codec, "codec");
                    Intrinsics.checkNotNullParameter(format2, "format");
                    z = WaveformExtractor.this.inProgress;
                    if (z) {
                        WaveformExtractor.this.sampleRate = format2.getInteger("sample-rate");
                        WaveformExtractor.this.channels = format2.getInteger("channel-count");
                        WaveformExtractor waveformExtractor = WaveformExtractor.this;
                        int i3 = 16;
                        if (Build.VERSION.SDK_INT >= 24 && format2.containsKey("pcm-encoding") && (integer = format2.getInteger("pcm-encoding")) != 2) {
                            if (integer == 3) {
                                i3 = 8;
                            } else if (integer == 4) {
                                i3 = 32;
                            }
                        }
                        waveformExtractor.pcmEncodingBit = i3;
                        WaveformExtractor waveformExtractor2 = WaveformExtractor.this;
                        i = waveformExtractor2.sampleRate;
                        j = WaveformExtractor.this.duration;
                        waveformExtractor2.totalSamples = i * j;
                        WaveformExtractor waveformExtractor3 = WaveformExtractor.this;
                        j2 = waveformExtractor3.totalSamples;
                        i2 = WaveformExtractor.this.expectedPoints;
                        waveformExtractor3.perSamplePoints = j2 / i2;
                    }
                }

                @Override // android.media.MediaCodec.Callback
                public void onError(MediaCodec codec, MediaCodec.CodecException e) {
                    ExtractorCallBack extractorCallBack;
                    Intrinsics.checkNotNullParameter(codec, "codec");
                    Intrinsics.checkNotNullParameter(e, "e");
                    extractorCallBack = WaveformExtractor.this.extractorCallBack;
                    extractorCallBack.onReject("AudioWaveforms " + e.getMessage(), "An error is thrown while decoding the audio file");
                }

                @Override // android.media.MediaCodec.Callback
                public void onOutputBufferAvailable(MediaCodec codec, int index, MediaCodec.BufferInfo info) {
                    boolean z;
                    ExtractorCallBack extractorCallBack;
                    ByteBuffer outputBuffer;
                    int i;
                    boolean z2;
                    Intrinsics.checkNotNullParameter(codec, "codec");
                    Intrinsics.checkNotNullParameter(info, "info");
                    z = WaveformExtractor.this.inProgress;
                    if (z && info.size > 0 && (outputBuffer = codec.getOutputBuffer(index)) != null) {
                        WaveformExtractor waveformExtractor = WaveformExtractor.this;
                        int i2 = info.size;
                        outputBuffer.position(info.offset);
                        i = waveformExtractor.pcmEncodingBit;
                        if (i == 8) {
                            waveformExtractor.handle8bit(i2, outputBuffer);
                        } else if (i == 16) {
                            waveformExtractor.handle16bit(i2, outputBuffer);
                        } else if (i == 32) {
                            waveformExtractor.handle32bit(i2, outputBuffer);
                        }
                        z2 = waveformExtractor.inProgress;
                        if (z2) {
                            codec.releaseOutputBuffer(index, false);
                        }
                    }
                    if (WaveformExtractorKt.isEof(info)) {
                        WaveformExtractor.this.stop();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(WaveformExtractor.this.getSampleData());
                        extractorCallBack = WaveformExtractor.this.extractorCallBack;
                        extractorCallBack.onResolve(arrayList);
                    }
                }
            });
            this.inProgress = true;
            createDecoderByType.start();
            this.decoder = createDecoderByType;
        } catch (Exception e) {
            stop();
            this.extractorCallBack.onReject(e.getMessage(), "An error is thrown before decoding the audio file");
        }
    }

    public final List<Float> getSampleData() {
        return this.sampleData;
    }

    public final void setSampleData(List<Float> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sampleData = list;
    }

    private final boolean rms(float value) {
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
        try {
            long j = this.sampleCount;
            long j2 = this.perSamplePoints;
            if (j == j2) {
                float f = this.currentProgress + 1.0f;
                this.currentProgress = f;
                this.progress = f / this.expectedPoints;
                this.sampleData.add(Float.valueOf((float) Math.sqrt(this.sampleSum / j2)));
                this.extractorCallBack.onProgress(this.progress);
                this.sampleCount = 0L;
                this.sampleSum = AudioStats.AUDIO_AMPLITUDE_NONE;
                WritableMap createMap = Arguments.createMap();
                Intrinsics.checkNotNullExpressionValue(createMap, "createMap(...)");
                createMap.putArray(Constants.waveformData, Arguments.fromList(this.sampleData));
                createMap.putString("progress", String.valueOf(this.progress));
                createMap.putString(Constants.playerKey, this.key);
                ReactApplicationContext reactApplicationContext = getReactApplicationContext();
                if (reactApplicationContext != null && (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) != null) {
                    rCTDeviceEventEmitter.emit(Constants.onCurrentExtractedWaveformData, createMap);
                }
                if (this.progress >= 1.0f) {
                    stop();
                    return true;
                }
            }
            this.sampleCount++;
            this.sampleSum += Math.pow(value, 2.0d);
            return false;
        } catch (Exception e) {
            stop();
            this.extractorCallBack.onReject("RMS ERROR", e.getMessage());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handle8bit(int size, ByteBuffer buf) {
        int i = size / (this.channels == 2 ? 2 : 1);
        for (int i2 = 0; i2 < i; i2++) {
            float f = buf.get() / 128.0f;
            if (this.channels == 2) {
                buf.get();
            }
            if (rms(f)) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handle16bit(int size, ByteBuffer buf) {
        int i = size / (this.channels == 2 ? 4 : 2);
        for (int i2 = 0; i2 < i; i2++) {
            float f = (buf.get() | (buf.get() << 8)) / 32767.0f;
            if (this.channels == 2) {
                buf.get();
                buf.get();
            }
            if (rms(f)) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handle32bit(int size, ByteBuffer buf) {
        int i = size / (this.channels == 2 ? 8 : 4);
        for (int i2 = 0; i2 < i; i2++) {
            float parseFloat = (((buf.get() | (buf.get() << 8)) | (buf.get() << 16)) | (buf.get() << 24)) / Float.parseFloat("2147483648f");
            if (this.channels == 2) {
                buf.get();
                buf.get();
                buf.get();
                buf.get();
            }
            if (rms(parseFloat)) {
                return;
            }
        }
    }

    public final void forceStop() {
        stop();
        this.extractorCallBack.onForceStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stop() {
        if (this.inProgress) {
            this.inProgress = false;
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
            }
            MediaCodec mediaCodec2 = this.decoder;
            if (mediaCodec2 != null) {
                mediaCodec2.release();
            }
            MediaExtractor mediaExtractor = this.extractor;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
        }
    }
}
