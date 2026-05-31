package com.audiowaveform;

import android.media.MediaCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaveformExtractor.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isEof", "", "Landroid/media/MediaCodec$BufferInfo;", "simform_solutions_react-native-audio-waveform_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WaveformExtractorKt {
    public static final boolean isEof(MediaCodec.BufferInfo bufferInfo) {
        Intrinsics.checkNotNullParameter(bufferInfo, "<this>");
        return (bufferInfo.flags & 4) != 0;
    }
}
