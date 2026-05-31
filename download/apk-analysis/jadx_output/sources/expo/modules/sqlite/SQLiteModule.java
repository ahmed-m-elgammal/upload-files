package expo.modules.sqlite;

import android.content.Context;
import androidx.collection.ArrayMap;
import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: SQLiteModule.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lexpo/modules/sqlite/SQLiteModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "cachedDatabase", "Landroidx/collection/ArrayMap;", "", "Lexpo/modules/sqlite/SQLite3Wrapper;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "execute", "", "", "databaseName", "queries", "Lexpo/modules/sqlite/Query;", "readOnly", "", "openDatabase", "pathForDatabaseName", "name", "SQLitePluginResult", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SQLiteModule extends Module {
    private final ArrayMap<String, SQLite3Wrapper> cachedDatabase = new ArrayMap<>();

    private final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionComponent asyncFunctionComponent4;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        SQLiteModule sQLiteModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (sQLiteModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(sQLiteModule);
            moduleDefinitionBuilder.Name("ExpoSQLite");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Query.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))};
            Function1<Object[], List<? extends Object>> function1 = new Function1<Object[], List<? extends Object>>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List<? extends Object> invoke(Object[] objArr) {
                    List<? extends Object> execute;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                    SQLiteModule sQLiteModule2 = SQLiteModule.this;
                    execute = sQLiteModule2.execute((String) obj, (List) obj2, booleanValue);
                    return execute;
                }
            };
            if (!Intrinsics.areEqual(List.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(List.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(List.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(List.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("exec", anyTypeArr, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("exec", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("exec", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("exec", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("exec", anyTypeArr, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("exec", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("exec", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Query.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))};
            Function1<Object[], List<? extends Object>> function12 = new Function1<Object[], List<? extends Object>>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$8
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List<? extends Object> invoke(Object[] objArr) {
                    List<? extends Object> execute;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                    SQLiteModule sQLiteModule2 = SQLiteModule.this;
                    execute = sQLiteModule2.execute((String) obj, (List) obj2, booleanValue);
                    return execute;
                }
            };
            if (!Intrinsics.areEqual(List.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(List.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(List.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(List.class, String.class)) {
                                asyncFunctionComponent2 = new StringAsyncFunctionComponent("execRawQuery", anyTypeArr2, function12);
                            } else {
                                asyncFunctionComponent2 = new AsyncFunctionComponent("execRawQuery", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new FloatAsyncFunctionComponent("execRawQuery", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("execRawQuery", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("execRawQuery", anyTypeArr2, function12);
                }
            } else {
                asyncFunctionComponent2 = new IntAsyncFunctionComponent("execRawQuery", anyTypeArr2, function12);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("execRawQuery", asyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionComponent3 = new AsyncFunctionWithPromiseComponent("close", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$9
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        ArrayMap arrayMap;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        arrayMap = SQLiteModule.this.cachedDatabase;
                        SQLite3Wrapper sQLite3Wrapper = (SQLite3Wrapper) arrayMap.remove((String) promise);
                        if (sQLite3Wrapper != null) {
                            sQLite3Wrapper.sqlite3_close();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent3 = new AsyncFunctionComponent("close", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$10
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }))}, new Function1<Object[], Integer>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$11
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public final Integer invoke(Object[] objArr) {
                        ArrayMap arrayMap;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        String str = (String) objArr[0];
                        arrayMap = SQLiteModule.this.cachedDatabase;
                        SQLite3Wrapper sQLite3Wrapper = (SQLite3Wrapper) arrayMap.remove(str);
                        if (sQLite3Wrapper != null) {
                            return Integer.valueOf(sQLite3Wrapper.sqlite3_close());
                        }
                        return null;
                    }
                });
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("close", asyncFunctionComponent3);
            moduleDefinitionBuilder.getSyncFunctions().put("closeSync", new SyncFunctionComponent("closeSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$Function$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$Function$2
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    ArrayMap arrayMap;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    String str = (String) objArr[0];
                    arrayMap = SQLiteModule.this.cachedDatabase;
                    SQLite3Wrapper sQLite3Wrapper = (SQLite3Wrapper) arrayMap.remove(str);
                    if (sQLite3Wrapper != null) {
                        return Integer.valueOf(sQLite3Wrapper.sqlite3_close());
                    }
                    return null;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("deleteAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$12
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        ArrayMap arrayMap;
                        String pathForDatabaseName;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String str = (String) promise;
                        arrayMap = SQLiteModule.this.cachedDatabase;
                        if (arrayMap.get(str) == 0) {
                            pathForDatabaseName = SQLiteModule.this.pathForDatabaseName(str);
                            File file = new File(pathForDatabaseName);
                            if (!file.exists()) {
                                throw new DatabaseNotFoundException(str);
                            }
                            if (!file.delete()) {
                                throw new DeleteDatabaseFileException(str);
                            }
                            return;
                        }
                        throw new DeleteDatabaseException(str);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr3 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$13
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }))};
                Function1<Object[], Unit> function13 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$AsyncFunction$14
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        ArrayMap arrayMap;
                        String pathForDatabaseName;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        String str = (String) objArr[0];
                        arrayMap = SQLiteModule.this.cachedDatabase;
                        if (arrayMap.get(str) == 0) {
                            pathForDatabaseName = SQLiteModule.this.pathForDatabaseName(str);
                            File file = new File(pathForDatabaseName);
                            if (!file.exists()) {
                                throw new DatabaseNotFoundException(str);
                            }
                            if (!file.delete()) {
                                throw new DeleteDatabaseFileException(str);
                            }
                            return Unit.INSTANCE;
                        }
                        throw new DeleteDatabaseException(str);
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent4 = new StringAsyncFunctionComponent("deleteAsync", anyTypeArr3, function13);
                                } else {
                                    asyncFunctionComponent4 = new AsyncFunctionComponent("deleteAsync", anyTypeArr3, function13);
                                }
                            } else {
                                asyncFunctionComponent4 = new FloatAsyncFunctionComponent("deleteAsync", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("deleteAsync", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent4 = new BoolAsyncFunctionComponent("deleteAsync", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent4 = new IntAsyncFunctionComponent("deleteAsync", anyTypeArr3, function13);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent4;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("deleteAsync", asyncFunctionWithPromiseComponent);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.sqlite.SQLiteModule$definition$lambda$7$$inlined$OnDestroy$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ArrayMap arrayMap;
                    arrayMap = SQLiteModule.this.cachedDatabase;
                    Collection values = arrayMap.values();
                    Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
                    Iterator it = values.iterator();
                    while (it.hasNext()) {
                        ((SQLite3Wrapper) it.next()).sqlite3_close();
                    }
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String pathForDatabaseName(String name) throws IOException {
        File file = new File(getContext().getFilesDir() + File.separator + "SQLite");
        SQLiteHelpersKt.ensureDirExists(file);
        return file + File.separator + name;
    }

    private final SQLite3Wrapper openDatabase(String databaseName) {
        SQLite3Wrapper sQLite3Wrapper;
        try {
            String pathForDatabaseName = pathForDatabaseName(databaseName);
            if (new File(pathForDatabaseName).exists() && (sQLite3Wrapper = this.cachedDatabase.get(databaseName)) != null) {
                return sQLite3Wrapper;
            }
            this.cachedDatabase.remove(databaseName);
            SQLite3Wrapper open = SQLite3Wrapper.INSTANCE.open(pathForDatabaseName);
            if (open == null) {
                return null;
            }
            this.cachedDatabase.put(databaseName, open);
            return open;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Object> execute(String databaseName, List<Query> queries, boolean readOnly) {
        SQLite3Wrapper openDatabase = openDatabase(databaseName);
        if (openDatabase == null) {
            throw new OpenDatabaseException(databaseName);
        }
        List<Query> list = queries;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Query query : list) {
            arrayList.add(openDatabase.executeSql(query.getSql(), query.getArgs(), readOnly));
        }
        return arrayList;
    }

    /* compiled from: SQLiteModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00030\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lexpo/modules/sqlite/SQLiteModule$SQLitePluginResult;", "", "rows", "", "columns", "", "rowsAffected", "", "insertId", "", "error", "", "([[Ljava/lang/Object;[Ljava/lang/String;IJLjava/lang/Throwable;)V", "getColumns", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getError", "()Ljava/lang/Throwable;", "getInsertId", "()J", "getRows", "()[[Ljava/lang/Object;", "[[Ljava/lang/Object;", "getRowsAffected", "()I", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SQLitePluginResult {
        private final String[] columns;
        private final Throwable error;
        private final long insertId;
        private final Object[][] rows;
        private final int rowsAffected;

        public SQLitePluginResult(Object[][] rows, String[] columns, int i, long j, Throwable th) {
            Intrinsics.checkNotNullParameter(rows, "rows");
            Intrinsics.checkNotNullParameter(columns, "columns");
            this.rows = rows;
            this.columns = columns;
            this.rowsAffected = i;
            this.insertId = j;
            this.error = th;
        }

        public final Object[][] getRows() {
            return this.rows;
        }

        public final String[] getColumns() {
            return this.columns;
        }

        public final int getRowsAffected() {
            return this.rowsAffected;
        }

        public final long getInsertId() {
            return this.insertId;
        }

        public final Throwable getError() {
            return this.error;
        }
    }
}
