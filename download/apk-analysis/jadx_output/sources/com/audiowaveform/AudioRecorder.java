package com.audiowaveform;

import android.app.Activity;
import android.media.MediaMetadataRetriever;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioRecorder.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ@\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eJ\u0019\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\"J\u001a\u0010#\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010$\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0007J \u0010%\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ \u0010'\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/audiowaveform/AudioRecorder;", "", "()V", "isRecording", "", "permissions", "", "", "[Ljava/lang/String;", "useLegacyNormalization", "checkPermission", "activity", "Landroid/app/Activity;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "getDecibel", "", "recorder", "Landroid/media/MediaRecorder;", "(Landroid/media/MediaRecorder;)Ljava/lang/Double;", "getDuration", "path", "getEncoder", "", "encoder", "getOutputFormat", "format", "getPermission", "initRecorder", "", "outputFormat", Constants.sampleRate, Constants.bitRate, "isPermissionGranted", "(Landroid/app/Activity;)Ljava/lang/Integer;", "pauseRecording", "resumeRecording", "startRecorder", "useLegacy", "stopRecording", "simform_solutions_react-native-audio-waveform_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioRecorder {
    private boolean isRecording;
    private String[] permissions = {"android.permission.RECORD_AUDIO"};
    private boolean useLegacyNormalization;

    private final Integer isPermissionGranted(Activity activity) {
        if (activity != null) {
            return Integer.valueOf(ActivityCompat.checkSelfPermission(activity, this.permissions[0]));
        }
        return null;
    }

    public final String checkPermission(Activity activity, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (isPermissionGranted(activity) == 0) {
            promise.resolve(PermissionsResponse.GRANTED_KEY);
            return PermissionsResponse.GRANTED_KEY;
        }
        promise.resolve("denied");
        return "denied";
    }

    public final String getPermission(Activity activity, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (isPermissionGranted(activity) == 0) {
            promise.resolve(PermissionsResponse.GRANTED_KEY);
            return PermissionsResponse.GRANTED_KEY;
        }
        if (activity != null) {
            ActivityCompat.requestPermissions(activity, this.permissions, 1001);
            return "denied";
        }
        return "denied";
    }

    public final Double getDecibel(MediaRecorder recorder) {
        if (!this.useLegacyNormalization) {
            if (recorder != null) {
                try {
                    return Double.valueOf(recorder.getMaxAmplitude());
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        if (recorder != null) {
            try {
                double log10 = 20 * Math.log10(recorder.getMaxAmplitude());
                if (log10 == Double.NEGATIVE_INFINITY) {
                    Log.e(Constants.LOG_TAG, "Microphone might be turned off");
                    return Double.valueOf(log10);
                }
                return Double.valueOf(log10);
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public final void initRecorder(String path, MediaRecorder recorder, int encoder, int outputFormat, int sampleRate, int bitRate, Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (recorder == null) {
            promise.reject("RECORDER_NULL", "MediaRecorder instance is null");
            return;
        }
        try {
            recorder.setAudioSource(1);
            recorder.setOutputFormat(getOutputFormat(outputFormat));
            recorder.setAudioEncoder(getEncoder(encoder));
            recorder.setAudioSamplingRate(sampleRate);
            recorder.setAudioEncodingBitRate(bitRate);
            recorder.setOutputFile(path);
            recorder.prepare();
            promise.resolve(true);
        } catch (IOException unused) {
            Log.e(Constants.LOG_TAG, "Failed to stop initialize recorder");
        } catch (IllegalArgumentException e) {
            Log.e(Constants.LOG_TAG, "Invalid MediaRecorder configuration", e);
            promise.reject("CONFIGURATION_ERROR", "Invalid MediaRecorder configuration: " + e.getMessage());
        }
    }

    public final void stopRecording(MediaRecorder recorder, String path, Promise promise) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            if (this.isRecording) {
                if (recorder != null) {
                    recorder.stop();
                    recorder.reset();
                    recorder.release();
                }
                this.isRecording = false;
                ArrayList arrayList = new ArrayList();
                String duration = getDuration(path);
                arrayList.add(path);
                arrayList.add(duration.toString());
                promise.resolve(Arguments.fromList(arrayList));
                return;
            }
            promise.reject("Error", "Recorder is not recording or has already been stopped");
        } catch (IllegalStateException e) {
            Log.e(Constants.LOG_TAG, "Failed to stop recording", e);
        } catch (RuntimeException e2) {
            Log.e(Constants.LOG_TAG, "Runtime exception when stopping recording", e2);
            promise.reject("Error", "Runtime exception: " + e2.getMessage());
        }
    }

    private final String getDuration(String path) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(path);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            return extractMetadata != null ? extractMetadata : "-1";
        } catch (Exception unused) {
            Log.e(Constants.LOG_TAG, "Failed to get recording duration");
            return "-1";
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public final void startRecorder(MediaRecorder recorder, boolean useLegacy, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            this.useLegacyNormalization = useLegacy;
            if (recorder != null) {
                recorder.start();
                this.isRecording = true;
            }
            promise.resolve(true);
        } catch (IllegalStateException unused) {
            Log.e(Constants.LOG_TAG, "Failed to start recording");
            this.isRecording = false;
        }
    }

    public final void pauseRecording(MediaRecorder recorder, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (recorder != null) {
            try {
                recorder.pause();
            } catch (IllegalStateException unused) {
                Log.e(Constants.LOG_TAG, "Failed to pause recording");
                promise.resolve(false);
                return;
            }
        }
        promise.resolve(true);
    }

    public final void resumeRecording(MediaRecorder recorder, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (recorder != null) {
            try {
                recorder.resume();
            } catch (IllegalStateException unused) {
                Log.e(Constants.LOG_TAG, "Failed to resume recording");
                return;
            }
        }
        promise.resolve(true);
    }

    private final int getEncoder(int encoder) {
        switch (encoder) {
            case 6:
                if (Build.VERSION.SDK_INT < 29) {
                    Log.e(Constants.LOG_TAG, "Minimum android Q is required, Setting Acc encoder.");
                    break;
                }
                break;
        }
        return 3;
    }

    private final int getOutputFormat(int format) {
        switch (format) {
            case 3:
                if (Build.VERSION.SDK_INT < 29) {
                    Log.e(Constants.LOG_TAG, "Minimum android Q is required, Setting Acc encoder.");
                    break;
                }
                break;
            case 7:
                if (Build.VERSION.SDK_INT < 26) {
                    Log.e(Constants.LOG_TAG, "Minimum android Q is required, Setting MPEG_4 output format.");
                    break;
                }
                break;
        }
        return 2;
    }
}
