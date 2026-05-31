package expo.modules.sqlite;

import com.facebook.jni.HybridData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeDatabaseBinding.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\t\u0010\u0013\u001a\u00020\u0007H\u0086 J\u0006\u0010\u0014\u001a\u00020\u0010Jl\u0010\u0015\u001a\u00020\u00102d\u0010\u0016\u001a`\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0006j\u0002`\u0011J\t\u0010\u0017\u001a\u00020\u0004H\u0082 J(\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000eH\u0003J\t\u0010\u001b\u001a\u00020\fH\u0086 J\t\u0010\u001c\u001a\u00020\fH\u0086 J\u0011\u0010\u001d\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0086 J\u0019\u0010\u001e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0086 J\u0011\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0086 J\u0011\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0007H\u0086 J\t\u0010%\u001a\u00020\fH\u0086 J\t\u0010&\u001a\u00020\u000eH\u0086 J\u0019\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0086 J\u0011\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\u0086 J\u0019\u0010,\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.H\u0086 J\u0011\u0010/\u001a\u00020 2\u0006\u0010\n\u001a\u00020\u0007H\u0086 J\u0011\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u000202H\u0082 R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000Rp\u0010\u0005\u001ad\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006j\u0004\u0018\u0001`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lexpo/modules/sqlite/NativeDatabaseBinding;", "Ljava/io/Closeable;", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "mUpdateListener", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "databaseName", "tableName", "", "operationType", "", "rowID", "", "Lexpo/modules/sqlite/UpdateListener;", "close", "convertSqlLiteErrorToString", "disableUpdateHook", "enableUpdateHook", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initHybrid", "onUpdate", "action", "rowId", "sqlite3_changes", "sqlite3_close", "sqlite3_db_filename", "sqlite3_deserialize", "serializedData", "", "sqlite3_enable_load_extension", "onoff", "sqlite3_exec", "source", "sqlite3_get_autocommit", "sqlite3_last_insert_rowid", "sqlite3_load_extension", "libPath", "entryProc", "sqlite3_open", "dbPath", "sqlite3_prepare_v2", "statement", "Lexpo/modules/sqlite/NativeStatementBinding;", "sqlite3_serialize", "sqlite3_update_hook", "enabled", "", "Companion", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeDatabaseBinding implements Closeable {
    public static final int SQLITE_DONE = 101;
    public static final int SQLITE_OK = 0;
    public static final int SQLITE_ROW = 100;
    private final HybridData mHybridData = initHybrid();
    private Function4<? super String, ? super String, ? super Integer, ? super Long, Unit> mUpdateListener;

    private final native HybridData initHybrid();

    private final native void sqlite3_update_hook(boolean enabled);

    public final native String convertSqlLiteErrorToString();

    public final native int sqlite3_changes();

    public final native int sqlite3_close();

    public final native String sqlite3_db_filename(String databaseName);

    public final native int sqlite3_deserialize(String databaseName, byte[] serializedData);

    public final native int sqlite3_enable_load_extension(int onoff);

    public final native int sqlite3_exec(String source);

    public final native int sqlite3_get_autocommit();

    public final native long sqlite3_last_insert_rowid();

    public final native int sqlite3_load_extension(String libPath, String entryProc);

    public final native int sqlite3_open(String dbPath);

    public final native int sqlite3_prepare_v2(String source, NativeStatementBinding statement);

    public final native byte[] sqlite3_serialize(String databaseName);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mHybridData.resetNative();
    }

    public final void enableUpdateHook(Function4<? super String, ? super String, ? super Integer, ? super Long, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        sqlite3_update_hook(true);
        this.mUpdateListener = listener;
    }

    public final void disableUpdateHook() {
        this.mUpdateListener = null;
        sqlite3_update_hook(false);
    }

    private final void onUpdate(int action, String databaseName, String tableName, long rowId) {
        Function4<? super String, ? super String, ? super Integer, ? super Long, Unit> function4 = this.mUpdateListener;
        if (function4 != null) {
            function4.invoke(databaseName, tableName, Integer.valueOf(action), Long.valueOf(rowId));
        }
    }

    static {
        System.loadLibrary("expo-sqlite");
    }
}
