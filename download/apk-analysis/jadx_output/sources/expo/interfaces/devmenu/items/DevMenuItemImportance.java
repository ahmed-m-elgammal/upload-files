package expo.interfaces.devmenu.items;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DevMenuItemImportance.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lexpo/interfaces/devmenu/items/DevMenuItemImportance;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOWEST", "LOW", "MEDIUM", "HIGH", "HIGHEST", "expo-dev-menu-interface_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuItemImportance {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DevMenuItemImportance[] $VALUES;
    private final int value;
    public static final DevMenuItemImportance LOWEST = new DevMenuItemImportance("LOWEST", 0, -200);
    public static final DevMenuItemImportance LOW = new DevMenuItemImportance("LOW", 1, -100);
    public static final DevMenuItemImportance MEDIUM = new DevMenuItemImportance("MEDIUM", 2, 0);
    public static final DevMenuItemImportance HIGH = new DevMenuItemImportance("HIGH", 3, 100);
    public static final DevMenuItemImportance HIGHEST = new DevMenuItemImportance("HIGHEST", 4, 200);

    private static final /* synthetic */ DevMenuItemImportance[] $values() {
        return new DevMenuItemImportance[]{LOWEST, LOW, MEDIUM, HIGH, HIGHEST};
    }

    public static EnumEntries<DevMenuItemImportance> getEntries() {
        return $ENTRIES;
    }

    public static DevMenuItemImportance valueOf(String str) {
        return (DevMenuItemImportance) Enum.valueOf(DevMenuItemImportance.class, str);
    }

    public static DevMenuItemImportance[] values() {
        return (DevMenuItemImportance[]) $VALUES.clone();
    }

    private DevMenuItemImportance(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        DevMenuItemImportance[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
