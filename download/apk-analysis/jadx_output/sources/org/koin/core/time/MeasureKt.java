package org.koin.core.time;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.koin.mp.KoinPlatformTimeTools;

/* compiled from: Measure.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a0\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u0002H\b\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004H\u0086\bø\u0001\u0000\u001a0\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\b\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004H\u0086\bø\u0001\u0000*\n\u0010\n\"\u00020\u00012\u00020\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"measureDuration", "", "Lorg/koin/core/time/TimeInMillis;", "code", "Lkotlin/Function0;", "", "measureDurationForResult", "Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "measureTimedValue", "TimeInMillis", "koin-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MeasureKt {
    public static final <T> Pair<T, Double> measureTimedValue(Function0<? extends T> code) {
        Intrinsics.checkNotNullParameter(code, "code");
        return new Pair<>(code.invoke(), Double.valueOf((KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds() - KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds()) / 1000000.0d));
    }

    public static final double measureDuration(Function0<Unit> code) {
        Intrinsics.checkNotNullParameter(code, "code");
        return ((Number) new Pair(code.invoke(), Double.valueOf((KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds() - KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds()) / 1000000.0d)).getSecond()).doubleValue();
    }

    public static final <T> Pair<T, Double> measureDurationForResult(Function0<? extends T> code) {
        Intrinsics.checkNotNullParameter(code, "code");
        Pair pair = new Pair(code.invoke(), Double.valueOf((KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds() - KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds()) / 1000000.0d));
        return new Pair<>(pair.component1(), Double.valueOf(((Number) pair.component2()).doubleValue()));
    }
}
