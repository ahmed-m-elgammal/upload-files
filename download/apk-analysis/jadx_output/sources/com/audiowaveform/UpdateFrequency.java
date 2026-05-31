package com.audiowaveform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/audiowaveform/UpdateFrequency;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "High", "Medium", "Low", "simform_solutions_react-native-audio-waveform_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateFrequency {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UpdateFrequency[] $VALUES;
    private final long value;
    public static final UpdateFrequency High = new UpdateFrequency("High", 0, 50);
    public static final UpdateFrequency Medium = new UpdateFrequency("Medium", 1, 100);
    public static final UpdateFrequency Low = new UpdateFrequency("Low", 2, 200);

    private static final /* synthetic */ UpdateFrequency[] $values() {
        return new UpdateFrequency[]{High, Medium, Low};
    }

    public static EnumEntries<UpdateFrequency> getEntries() {
        return $ENTRIES;
    }

    public static UpdateFrequency valueOf(String str) {
        return (UpdateFrequency) Enum.valueOf(UpdateFrequency.class, str);
    }

    public static UpdateFrequency[] values() {
        return (UpdateFrequency[]) $VALUES.clone();
    }

    private UpdateFrequency(String str, int i, long j) {
        this.value = j;
    }

    public final long getValue() {
        return this.value;
    }

    static {
        UpdateFrequency[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
