package expo.modules.sqlite;

import com.facebook.jni.HybridData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SQLite3Wrapper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086 J\t\u0010\f\u001a\u00020\u0004H\u0082 J\t\u0010\r\u001a\u00020\u000eH\u0086 J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0086 R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/sqlite/SQLite3Wrapper;", "", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "executeSql", "", "sql", "", "args", "readOnly", "", "initHybrid", "sqlite3_close", "", "sqlite3_open", "dbPath", "Companion", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SQLite3Wrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int SQLITE_OK = 0;
    private final HybridData mHybridData;

    public /* synthetic */ SQLite3Wrapper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final native HybridData initHybrid();

    @JvmStatic
    public static final SQLite3Wrapper open(String str) {
        return INSTANCE.open(str);
    }

    public final native List<Object> executeSql(String sql, List<? extends Object> args, boolean readOnly);

    public final native int sqlite3_close();

    public final native int sqlite3_open(String dbPath);

    private SQLite3Wrapper() {
        this.mHybridData = initHybrid();
    }

    /* compiled from: SQLite3Wrapper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lexpo/modules/sqlite/SQLite3Wrapper$Companion;", "", "()V", "SQLITE_OK", "", "open", "Lexpo/modules/sqlite/SQLite3Wrapper;", "dbPath", "", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SQLite3Wrapper open(String dbPath) {
            Intrinsics.checkNotNullParameter(dbPath, "dbPath");
            SQLite3Wrapper sQLite3Wrapper = new SQLite3Wrapper(null);
            if (sQLite3Wrapper.sqlite3_open(dbPath) != 0) {
                return null;
            }
            return sQLite3Wrapper;
        }
    }

    static {
        System.loadLibrary("expo-sqlite");
    }
}
