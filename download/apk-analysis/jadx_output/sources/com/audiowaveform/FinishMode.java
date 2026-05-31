package com.audiowaveform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/audiowaveform/FinishMode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Loop", "Pause", "Stop", "simform_solutions_react-native-audio-waveform_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FinishMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FinishMode[] $VALUES;
    public static final FinishMode Loop = new FinishMode("Loop", 0, 0);
    public static final FinishMode Pause = new FinishMode("Pause", 1, 1);
    public static final FinishMode Stop = new FinishMode("Stop", 2, 2);
    private final int value;

    private static final /* synthetic */ FinishMode[] $values() {
        return new FinishMode[]{Loop, Pause, Stop};
    }

    public static EnumEntries<FinishMode> getEntries() {
        return $ENTRIES;
    }

    public static FinishMode valueOf(String str) {
        return (FinishMode) Enum.valueOf(FinishMode.class, str);
    }

    public static FinishMode[] values() {
        return (FinishMode[]) $VALUES.clone();
    }

    private FinishMode(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        FinishMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
