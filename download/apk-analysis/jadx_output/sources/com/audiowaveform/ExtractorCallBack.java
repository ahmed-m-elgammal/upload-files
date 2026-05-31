package com.audiowaveform;

import java.util.List;
import kotlin.Metadata;

/* compiled from: WaveformExtractor.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\fH&¨\u0006\r"}, d2 = {"Lcom/audiowaveform/ExtractorCallBack;", "", "onForceStop", "", "onProgress", "value", "", "onReject", "error", "", "message", "onResolve", "", "simform_solutions_react-native-audio-waveform_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ExtractorCallBack {
    void onForceStop();

    void onProgress(float value);

    void onReject(String error, String message);

    void onResolve(List<List<Float>> value);
}
