package expo.modules.sqlite;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SQLRecords.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lexpo/modules/sqlite/SQLAction;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INSERT", "UPDATE", "DELETE", "UNKNOWN", "Companion", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SQLAction implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SQLAction[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final SQLAction INSERT = new SQLAction("INSERT", 0, "insert");
    public static final SQLAction UPDATE = new SQLAction("UPDATE", 1, "update");
    public static final SQLAction DELETE = new SQLAction("DELETE", 2, "delete");
    public static final SQLAction UNKNOWN = new SQLAction("UNKNOWN", 3, "unknown");

    private static final /* synthetic */ SQLAction[] $values() {
        return new SQLAction[]{INSERT, UPDATE, DELETE, UNKNOWN};
    }

    public static EnumEntries<SQLAction> getEntries() {
        return $ENTRIES;
    }

    public static SQLAction valueOf(String str) {
        return (SQLAction) Enum.valueOf(SQLAction.class, str);
    }

    public static SQLAction[] values() {
        return (SQLAction[]) $VALUES.clone();
    }

    private SQLAction(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        SQLAction[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: SQLRecords.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/sqlite/SQLAction$Companion;", "", "()V", "fromCode", "Lexpo/modules/sqlite/SQLAction;", "value", "", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SQLAction fromCode(int value) {
            if (value == 9) {
                return SQLAction.DELETE;
            }
            if (value == 18) {
                return SQLAction.INSERT;
            }
            if (value == 23) {
                return SQLAction.UPDATE;
            }
            return SQLAction.UNKNOWN;
        }
    }
}
