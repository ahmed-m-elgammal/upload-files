package expo.modules.sqlite;

import com.facebook.jni.HybridData;
import java.io.Closeable;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: NativeStatementBinding.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0086 J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000fH\u0086 J\u0013\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\t0\rj\u0002`\u0011H\u0086 J\t\u0010\u0012\u001a\u00020\u0004H\u0082 J\u0011\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000eH\u0086 J\t\u0010\u0015\u001a\u00020\u0006H\u0086 J\t\u0010\u0016\u001a\u00020\u0006H\u0086 J\u0011\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086 J\t\u0010\u0018\u001a\u00020\u0006H\u0086 J\t\u0010\u0019\u001a\u00020\u0006H\u0086 J\t\u0010\u001a\u001a\u00020\u0006H\u0086 R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lexpo/modules/sqlite/NativeStatementBinding;", "Ljava/io/Closeable;", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "bindStatementParam", "", "index", "param", "", "close", "", "getColumnNames", "Ljava/util/ArrayList;", "", "Lexpo/modules/sqlite/SQLiteColumnNames;", "getColumnValues", "Lexpo/modules/sqlite/SQLiteColumnValues;", "initHybrid", "sqlite3_bind_parameter_index", "name", "sqlite3_clear_bindings", "sqlite3_column_count", "sqlite3_column_name", "sqlite3_finalize", "sqlite3_reset", "sqlite3_step", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeStatementBinding implements Closeable {
    private final HybridData mHybridData = initHybrid();

    private final native HybridData initHybrid();

    public final native int bindStatementParam(int index, Object param);

    public final native ArrayList<String> getColumnNames();

    public final native ArrayList<Object> getColumnValues();

    public final native int sqlite3_bind_parameter_index(String name);

    public final native int sqlite3_clear_bindings();

    public final native int sqlite3_column_count();

    public final native String sqlite3_column_name(int index);

    public final native int sqlite3_finalize();

    public final native int sqlite3_reset();

    public final native int sqlite3_step();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mHybridData.resetNative();
    }
}
