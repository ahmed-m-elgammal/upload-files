package org.koin.core.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.koin.mp.KoinPlatformTimeTools;

/* compiled from: Timer.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0011R)\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lorg/koin/core/time/Timer;", "", "()V", "<set-?>", "Lkotlin/time/Duration;", "end", "getEnd-UwyO8pc", "()J", "J", "start", "getStart-UwyO8pc", "time", "getTimeInMillis", "", "getTimeInNanos", "getTimeInSeconds", "stop", "", "Companion", "koin-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class Timer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final double NANO_TO_MILLI = 1000000.0d;
    private final long start = DurationKt.toDuration(KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds(), DurationUnit.NANOSECONDS);
    private long end = Duration.INSTANCE.m4012getZEROUwyO8pc();
    private long time = Duration.INSTANCE.m4012getZEROUwyO8pc();

    /* renamed from: getStart-UwyO8pc, reason: not valid java name and from getter */
    public final long getStart() {
        return this.start;
    }

    /* renamed from: getEnd-UwyO8pc, reason: not valid java name and from getter */
    public final long getEnd() {
        return this.end;
    }

    public final void stop() {
        if (Duration.m3914equalsimpl0(this.end, Duration.INSTANCE.m4012getZEROUwyO8pc())) {
            long duration = DurationKt.toDuration(KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds(), DurationUnit.NANOSECONDS);
            this.end = duration;
            this.time = Duration.m3944minusLRDsOJo(duration, this.start);
        }
    }

    public final double getTimeInSeconds() {
        return Duration.m3952toDoubleimpl(this.time, DurationUnit.SECONDS);
    }

    public final double getTimeInMillis() {
        return Duration.m3952toDoubleimpl(this.time, DurationUnit.MILLISECONDS);
    }

    public final double getTimeInNanos() {
        return Duration.m3952toDoubleimpl(this.time, DurationUnit.NANOSECONDS);
    }

    /* compiled from: Timer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lorg/koin/core/time/Timer$Companion;", "", "()V", "NANO_TO_MILLI", "", "start", "Lorg/koin/core/time/Timer;", "koin-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Timer start() {
            return new Timer();
        }
    }
}
