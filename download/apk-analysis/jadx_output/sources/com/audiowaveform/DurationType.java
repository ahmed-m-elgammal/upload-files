package com.audiowaveform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/audiowaveform/DurationType;", "", "(Ljava/lang/String;I)V", "Current", "Max", "simform_solutions_react-native-audio-waveform_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DurationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DurationType[] $VALUES;
    public static final DurationType Current = new DurationType("Current", 0);
    public static final DurationType Max = new DurationType("Max", 1);

    private static final /* synthetic */ DurationType[] $values() {
        return new DurationType[]{Current, Max};
    }

    public static EnumEntries<DurationType> getEntries() {
        return $ENTRIES;
    }

    public static DurationType valueOf(String str) {
        return (DurationType) Enum.valueOf(DurationType.class, str);
    }

    public static DurationType[] values() {
        return (DurationType[]) $VALUES.clone();
    }

    static {
        DurationType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private DurationType(String str, int i) {
    }
}
