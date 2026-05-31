package expo.modules.sqlite;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.camera.video.AudioStats;
import androidx.core.net.UriKt;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
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
import io.sentry.protocol.SentryThread;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;

/* compiled from: SQLiteModuleNext.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 A2\u00020\u0001:\u0001AB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0018H\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u001e\u0010\"\u001a\u0004\u0018\u00010\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0$H\u0002J(\u0010%\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020(0'j\u0002`)0&2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J \u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u000eH\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0018\u00100\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0002J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\b0&2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0018\u00102\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0002J\u0010\u00103\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u00104\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\bH\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0018H\u0002J \u00107\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0018H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050&H\u0002J\u0012\u00109\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0018\u0010:\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002JT\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020(0<2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00052\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020(0<2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b0<2\u0006\u0010-\u001a\u00020\u000eH\u0002J\u0018\u0010?\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J&\u0010@\u001a\u0010\u0012\u0004\u0012\u00020(\u0018\u00010'j\u0004\u0018\u0001`)2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lexpo/modules/sqlite/SQLiteModuleNext;", "Lexpo/modules/kotlin/modules/Module;", "()V", "cachedDatabases", "", "Lexpo/modules/sqlite/NativeDatabase;", "cachedStatements", "", "Lexpo/modules/sqlite/NativeStatement;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "hasListeners", "", "addCachedDatabase", "", "database", "addUpdateHook", "closeDatabase", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "deleteDatabase", "databaseName", "", "deserializeDatabase", "serializedData", "", "options", "Lexpo/modules/sqlite/OpenDatabaseOptions;", "exec", "source", "finalize", "statement", "findCachedDatabase", "predicate", "Lkotlin/Function1;", "getAll", "", "Ljava/util/ArrayList;", "", "Lexpo/modules/sqlite/SQLiteColumnValues;", "getBindParamIndex", "", SDKConstants.PARAM_KEY, "shouldPassAsArray", "initDb", "loadCRSQLiteExtension", "maybeAddCachedStatement", "maybeRemoveAllCachedStatements", "maybeRemoveCachedStatement", "maybeThrowForClosedDatabase", "maybeThrowForFinalizedStatement", "pathForDatabaseName", "name", "prepareStatement", "removeAllCachedDatabases", "removeCachedDatabase", "reset", "run", "", "bindParams", "bindBlobParams", "serialize", "step", "Companion", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SQLiteModuleNext extends Module {
    private static final String TAG = "SQLiteModuleNext";
    private final List<NativeDatabase> cachedDatabases = new ArrayList();
    private final Map<NativeDatabase, List<NativeStatement>> cachedStatements = new LinkedHashMap();
    private boolean hasListeners;

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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        AsyncFunctionComponent asyncFunctionComponent4;
        AsyncFunctionComponent asyncFunctionComponent5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        AsyncFunctionComponent asyncFunctionComponent6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5;
        AsyncFunctionComponent asyncFunctionComponent7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6;
        AsyncFunctionComponent asyncFunctionComponent8;
        AsyncFunctionComponent asyncFunctionComponent9;
        AsyncFunctionComponent asyncFunctionComponent10;
        AsyncFunctionComponent asyncFunctionComponent11;
        AsyncFunctionComponent asyncFunctionComponent12;
        AsyncFunctionComponent asyncFunctionComponent13;
        AsyncFunctionComponent asyncFunctionComponent14;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7;
        AsyncFunctionComponent asyncFunctionComponent15;
        SQLiteModuleNext sQLiteModuleNext = this;
        Trace.beginSection("[ExpoModulesCore] " + (sQLiteModuleNext.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(sQLiteModuleNext);
            moduleDefinitionBuilder.Name("ExpoSQLiteNext");
            moduleDefinitionBuilder.Events("onDatabaseChange");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("startObserving", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$OnStartObserving$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        SQLiteModuleNext.this.hasListeners = true;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$OnStartObserving$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }))};
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$OnStartObserving$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        SQLiteModuleNext.this.hasListeners = true;
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("startObserving", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("startObserving", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("startObserving", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("startObserving", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("startObserving", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("startObserving", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("startObserving", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("stopObserving", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$OnStopObserving$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        SQLiteModuleNext.this.hasListeners = false;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$OnStopObserving$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }))};
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$OnStopObserving$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        SQLiteModuleNext.this.hasListeners = false;
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("stopObserving", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("stopObserving", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("stopObserving", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("stopObserving", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("stopObserving", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("stopObserving", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("stopObserving", asyncFunctionWithPromiseComponent2);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$OnDestroy$1
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
                    List removeAllCachedDatabases;
                    try {
                        removeAllCachedDatabases = SQLiteModuleNext.this.removeAllCachedDatabases();
                        Iterator it = removeAllCachedDatabases.iterator();
                        while (it.hasNext()) {
                            SQLiteModuleNext.this.closeDatabase((NativeDatabase) it.next());
                        }
                    } catch (Throwable unused) {
                    }
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("deleteDatabaseAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        SQLiteModuleNext.this.deleteDatabase((String) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr3 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }))};
                Function1<Object[], Unit> function13 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        SQLiteModuleNext.this.deleteDatabase((String) objArr[0]);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("deleteDatabaseAsync", anyTypeArr3, function13);
                                } else {
                                    asyncFunctionComponent3 = new AsyncFunctionComponent("deleteDatabaseAsync", anyTypeArr3, function13);
                                }
                            } else {
                                asyncFunctionComponent3 = new FloatAsyncFunctionComponent("deleteDatabaseAsync", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("deleteDatabaseAsync", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new BoolAsyncFunctionComponent("deleteDatabaseAsync", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("deleteDatabaseAsync", anyTypeArr3, function13);
                }
                asyncFunctionWithPromiseComponent3 = asyncFunctionComponent3;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("deleteDatabaseAsync", asyncFunctionWithPromiseComponent3);
            moduleDefinitionBuilder.getSyncFunctions().put("deleteDatabaseSync", new SyncFunctionComponent("deleteDatabaseSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$Function$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$Function$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    SQLiteModuleNext.this.deleteDatabase((String) objArr[0]);
                    return Unit.INSTANCE;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))};
            Function1<Object[], Unit> function14 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$$inlined$AsyncFunction$7
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    String pathForDatabaseName;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                    String str = (String) obj2;
                    pathForDatabaseName = SQLiteModuleNext.this.pathForDatabaseName((String) obj);
                    File file = new File(pathForDatabaseName);
                    if (!file.exists() || booleanValue) {
                        Uri parse = Uri.parse(str);
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                        File file2 = UriKt.toFile(parse);
                        if (!file2.isFile()) {
                            throw new OpenDatabaseException(str);
                        }
                        FilesKt.copyTo$default(file2, file, booleanValue, 0, 4, null);
                    }
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent4 = new StringAsyncFunctionComponent("importAssetDatabaseAsync", anyTypeArr4, function14);
                            } else {
                                asyncFunctionComponent4 = new AsyncFunctionComponent("importAssetDatabaseAsync", anyTypeArr4, function14);
                            }
                        } else {
                            asyncFunctionComponent4 = new FloatAsyncFunctionComponent("importAssetDatabaseAsync", anyTypeArr4, function14);
                        }
                    } else {
                        asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("importAssetDatabaseAsync", anyTypeArr4, function14);
                    }
                } else {
                    asyncFunctionComponent4 = new BoolAsyncFunctionComponent("importAssetDatabaseAsync", anyTypeArr4, function14);
                }
            } else {
                asyncFunctionComponent4 = new IntAsyncFunctionComponent("importAssetDatabaseAsync", anyTypeArr4, function14);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("importAssetDatabaseAsync", asyncFunctionComponent4);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NativeDatabase.class);
            String simpleName = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(simpleName, orCreateKotlinClass, Reflection.typeOf(NativeDatabase.class));
            classComponentBuilder.setConstructor(new SyncFunctionComponent("constructor", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Constructor$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(OpenDatabaseOptions.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(OpenDatabaseOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(byte[].class), true, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Constructor$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(byte[].class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Constructor$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    String pathForDatabaseName;
                    NativeDatabase findCachedDatabase;
                    NativeDatabase nativeDatabase;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    byte[] bArr = (byte[]) objArr[2];
                    final OpenDatabaseOptions openDatabaseOptions = (OpenDatabaseOptions) obj2;
                    final String str = (String) obj;
                    if (bArr != null) {
                        nativeDatabase = SQLiteModuleNext.this.deserializeDatabase(bArr, openDatabaseOptions);
                    } else {
                        pathForDatabaseName = SQLiteModuleNext.this.pathForDatabaseName(str);
                        findCachedDatabase = SQLiteModuleNext.this.findCachedDatabase(new Function1<NativeDatabase, Boolean>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$1$7$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(NativeDatabase it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return Boolean.valueOf(Intrinsics.areEqual(it.getDatabaseName(), str) && Intrinsics.areEqual(it.getOpenOptions(), openDatabaseOptions) && !openDatabaseOptions.getUseNewConnection());
                            }
                        });
                        if (findCachedDatabase != null) {
                            findCachedDatabase.addRef$expo_sqlite_release();
                            return findCachedDatabase;
                        }
                        NativeDatabase nativeDatabase2 = new NativeDatabase(str, openDatabaseOptions);
                        if (nativeDatabase2.getRef().sqlite3_open(pathForDatabaseName) != 0) {
                            throw new OpenDatabaseException(str);
                        }
                        nativeDatabase = nativeDatabase2;
                    }
                    SQLiteModuleNext.this.addCachedDatabase(nativeDatabase);
                    return nativeDatabase;
                }
            }));
            ClassComponentBuilder classComponentBuilder2 = classComponentBuilder;
            if (Intrinsics.areEqual(NativeDatabase.class, Promise.class)) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("initAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        SQLiteModuleNext.this.initDb((NativeDatabase) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr5 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeDatabase.class);
                    }
                }))};
                Function1<Object[], Unit> function15 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        SQLiteModuleNext.this.initDb((NativeDatabase) objArr[0]);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent5 = new StringAsyncFunctionComponent("initAsync", anyTypeArr5, function15);
                                } else {
                                    asyncFunctionComponent5 = new AsyncFunctionComponent("initAsync", anyTypeArr5, function15);
                                }
                            } else {
                                asyncFunctionComponent5 = new FloatAsyncFunctionComponent("initAsync", anyTypeArr5, function15);
                            }
                        } else {
                            asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("initAsync", anyTypeArr5, function15);
                        }
                    } else {
                        asyncFunctionComponent5 = new BoolAsyncFunctionComponent("initAsync", anyTypeArr5, function15);
                    }
                } else {
                    asyncFunctionComponent5 = new IntAsyncFunctionComponent("initAsync", anyTypeArr5, function15);
                }
                asyncFunctionWithPromiseComponent4 = asyncFunctionComponent5;
            }
            classComponentBuilder2.getAsyncFunctions().put("initAsync", asyncFunctionWithPromiseComponent4);
            classComponentBuilder.getSyncFunctions().put("initSync", new SyncFunctionComponent("initSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    SQLiteModuleNext.this.initDb((NativeDatabase) objArr[0]);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder3 = classComponentBuilder;
            if (Intrinsics.areEqual(NativeDatabase.class, Promise.class)) {
                asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("isInTransactionAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        NativeDatabase nativeDatabase = (NativeDatabase) promise;
                        SQLiteModuleNext.this.maybeThrowForClosedDatabase(nativeDatabase);
                        nativeDatabase.getRef().sqlite3_get_autocommit();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr6 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeDatabase.class);
                    }
                }))};
                Function1<Object[], Boolean> function16 = new Function1<Object[], Boolean>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        NativeDatabase nativeDatabase = (NativeDatabase) objArr[0];
                        SQLiteModuleNext.this.maybeThrowForClosedDatabase(nativeDatabase);
                        return Boolean.valueOf(nativeDatabase.getRef().sqlite3_get_autocommit() == 0);
                    }
                };
                if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                    asyncFunctionComponent6 = new StringAsyncFunctionComponent("isInTransactionAsync", anyTypeArr6, function16);
                                } else {
                                    asyncFunctionComponent6 = new AsyncFunctionComponent("isInTransactionAsync", anyTypeArr6, function16);
                                }
                            } else {
                                asyncFunctionComponent6 = new FloatAsyncFunctionComponent("isInTransactionAsync", anyTypeArr6, function16);
                            }
                        } else {
                            asyncFunctionComponent6 = new DoubleAsyncFunctionComponent("isInTransactionAsync", anyTypeArr6, function16);
                        }
                    } else {
                        asyncFunctionComponent6 = new BoolAsyncFunctionComponent("isInTransactionAsync", anyTypeArr6, function16);
                    }
                } else {
                    asyncFunctionComponent6 = new IntAsyncFunctionComponent("isInTransactionAsync", anyTypeArr6, function16);
                }
                asyncFunctionWithPromiseComponent5 = asyncFunctionComponent6;
            }
            classComponentBuilder3.getAsyncFunctions().put("isInTransactionAsync", asyncFunctionWithPromiseComponent5);
            classComponentBuilder.getSyncFunctions().put("isInTransactionSync", new SyncFunctionComponent("isInTransactionSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    NativeDatabase nativeDatabase = (NativeDatabase) objArr[0];
                    SQLiteModuleNext.this.maybeThrowForClosedDatabase(nativeDatabase);
                    return Boolean.valueOf(nativeDatabase.getRef().sqlite3_get_autocommit() == 0);
                }
            }));
            ClassComponentBuilder classComponentBuilder4 = classComponentBuilder;
            if (Intrinsics.areEqual(NativeDatabase.class, Promise.class)) {
                asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("closeAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$7
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        NativeDatabase nativeDatabase = (NativeDatabase) promise;
                        SQLiteModuleNext.this.removeCachedDatabase(nativeDatabase);
                        SQLiteModuleNext.this.closeDatabase(nativeDatabase);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr7 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeDatabase.class);
                    }
                }))};
                Function1<Object[], Unit> function17 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        NativeDatabase nativeDatabase = (NativeDatabase) objArr[0];
                        SQLiteModuleNext.this.removeCachedDatabase(nativeDatabase);
                        SQLiteModuleNext.this.closeDatabase(nativeDatabase);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent7 = new StringAsyncFunctionComponent("closeAsync", anyTypeArr7, function17);
                                } else {
                                    asyncFunctionComponent7 = new AsyncFunctionComponent("closeAsync", anyTypeArr7, function17);
                                }
                            } else {
                                asyncFunctionComponent7 = new FloatAsyncFunctionComponent("closeAsync", anyTypeArr7, function17);
                            }
                        } else {
                            asyncFunctionComponent7 = new DoubleAsyncFunctionComponent("closeAsync", anyTypeArr7, function17);
                        }
                    } else {
                        asyncFunctionComponent7 = new BoolAsyncFunctionComponent("closeAsync", anyTypeArr7, function17);
                    }
                } else {
                    asyncFunctionComponent7 = new IntAsyncFunctionComponent("closeAsync", anyTypeArr7, function17);
                }
                asyncFunctionWithPromiseComponent6 = asyncFunctionComponent7;
            }
            classComponentBuilder4.getAsyncFunctions().put("closeAsync", asyncFunctionWithPromiseComponent6);
            classComponentBuilder.getSyncFunctions().put("closeSync", new SyncFunctionComponent("closeSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    NativeDatabase nativeDatabase = (NativeDatabase) objArr[0];
                    SQLiteModuleNext.this.removeCachedDatabase(nativeDatabase);
                    SQLiteModuleNext.this.closeDatabase(nativeDatabase);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder5 = classComponentBuilder;
            AnyType[] anyTypeArr8 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))};
            Function1<Object[], Unit> function18 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$12
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    SQLiteModuleNext.this.exec((NativeDatabase) obj, str);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent8 = new StringAsyncFunctionComponent("execAsync", anyTypeArr8, function18);
                            } else {
                                asyncFunctionComponent8 = new AsyncFunctionComponent("execAsync", anyTypeArr8, function18);
                            }
                        } else {
                            asyncFunctionComponent8 = new FloatAsyncFunctionComponent("execAsync", anyTypeArr8, function18);
                        }
                    } else {
                        asyncFunctionComponent8 = new DoubleAsyncFunctionComponent("execAsync", anyTypeArr8, function18);
                    }
                } else {
                    asyncFunctionComponent8 = new BoolAsyncFunctionComponent("execAsync", anyTypeArr8, function18);
                }
            } else {
                asyncFunctionComponent8 = new IntAsyncFunctionComponent("execAsync", anyTypeArr8, function18);
            }
            classComponentBuilder5.getAsyncFunctions().put("execAsync", asyncFunctionComponent8);
            classComponentBuilder.getSyncFunctions().put("execSync", new SyncFunctionComponent("execSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$9
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    SQLiteModuleNext.this.exec((NativeDatabase) obj, str);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder6 = classComponentBuilder;
            AnyType[] anyTypeArr9 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))};
            Function1<Object[], byte[]> function19 = new Function1<Object[], byte[]>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$15
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final byte[] invoke(Object[] objArr) {
                    byte[] serialize;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    serialize = SQLiteModuleNext.this.serialize((NativeDatabase) obj, str);
                    return serialize;
                }
            };
            if (!Intrinsics.areEqual(byte[].class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(byte[].class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(byte[].class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(byte[].class, Float.TYPE)) {
                            if (Intrinsics.areEqual(byte[].class, String.class)) {
                                asyncFunctionComponent9 = new StringAsyncFunctionComponent("serializeAsync", anyTypeArr9, function19);
                            } else {
                                asyncFunctionComponent9 = new AsyncFunctionComponent("serializeAsync", anyTypeArr9, function19);
                            }
                        } else {
                            asyncFunctionComponent9 = new FloatAsyncFunctionComponent("serializeAsync", anyTypeArr9, function19);
                        }
                    } else {
                        asyncFunctionComponent9 = new DoubleAsyncFunctionComponent("serializeAsync", anyTypeArr9, function19);
                    }
                } else {
                    asyncFunctionComponent9 = new BoolAsyncFunctionComponent("serializeAsync", anyTypeArr9, function19);
                }
            } else {
                asyncFunctionComponent9 = new IntAsyncFunctionComponent("serializeAsync", anyTypeArr9, function19);
            }
            classComponentBuilder6.getAsyncFunctions().put("serializeAsync", asyncFunctionComponent9);
            classComponentBuilder.getSyncFunctions().put("serializeSync", new SyncFunctionComponent("serializeSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$12
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    byte[] serialize;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    serialize = SQLiteModuleNext.this.serialize((NativeDatabase) obj, str);
                    return serialize;
                }
            }));
            ClassComponentBuilder classComponentBuilder7 = classComponentBuilder;
            AnyType[] anyTypeArr10 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))};
            Function1<Object[], Unit> function110 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$AsyncFunction$19
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    String str = (String) objArr[2];
                    SQLiteModuleNext sQLiteModuleNext2 = SQLiteModuleNext.this;
                    sQLiteModuleNext2.prepareStatement((NativeDatabase) obj, (NativeStatement) obj2, str);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent10 = new StringAsyncFunctionComponent("prepareAsync", anyTypeArr10, function110);
                            } else {
                                asyncFunctionComponent10 = new AsyncFunctionComponent("prepareAsync", anyTypeArr10, function110);
                            }
                        } else {
                            asyncFunctionComponent10 = new FloatAsyncFunctionComponent("prepareAsync", anyTypeArr10, function110);
                        }
                    } else {
                        asyncFunctionComponent10 = new DoubleAsyncFunctionComponent("prepareAsync", anyTypeArr10, function110);
                    }
                } else {
                    asyncFunctionComponent10 = new BoolAsyncFunctionComponent("prepareAsync", anyTypeArr10, function110);
                }
            } else {
                asyncFunctionComponent10 = new IntAsyncFunctionComponent("prepareAsync", anyTypeArr10, function110);
            }
            classComponentBuilder7.getAsyncFunctions().put("prepareAsync", asyncFunctionComponent10);
            classComponentBuilder.getSyncFunctions().put("prepareSync", new SyncFunctionComponent("prepareSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$21$$inlined$Function$16
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    String str = (String) objArr[2];
                    SQLiteModuleNext sQLiteModuleNext2 = SQLiteModuleNext.this;
                    sQLiteModuleNext2.prepareStatement((NativeDatabase) obj, (NativeStatement) obj2, str);
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getClassData().add(classComponentBuilder.buildClass());
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(NativeStatement.class);
            String simpleName2 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass2).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
            ClassComponentBuilder classComponentBuilder8 = new ClassComponentBuilder(simpleName2, orCreateKotlinClass2, Reflection.typeOf(NativeStatement.class));
            classComponentBuilder8.setConstructor(new SyncFunctionComponent("constructor", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Constructor$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new NativeStatement();
                }
            }));
            ClassComponentBuilder classComponentBuilder9 = classComponentBuilder8;
            AnyType[] anyTypeArr11 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Object.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))};
            Function1<Object[], Map<String, ? extends Object>> function111 = new Function1<Object[], Map<String, ? extends Object>>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Map<String, ? extends Object> invoke(Object[] objArr) {
                    Map<String, ? extends Object> run;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    Object obj3 = objArr[2];
                    Object obj4 = objArr[3];
                    boolean booleanValue = ((Boolean) objArr[4]).booleanValue();
                    NativeDatabase nativeDatabase = (NativeDatabase) obj2;
                    NativeStatement nativeStatement = (NativeStatement) obj;
                    SQLiteModuleNext sQLiteModuleNext2 = SQLiteModuleNext.this;
                    run = sQLiteModuleNext2.run(nativeStatement, nativeDatabase, (Map) obj3, (Map) obj4, booleanValue);
                    return run;
                }
            };
            if (!Intrinsics.areEqual(Map.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Map.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Map.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Map.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Map.class, String.class)) {
                                asyncFunctionComponent11 = new StringAsyncFunctionComponent("runAsync", anyTypeArr11, function111);
                            } else {
                                asyncFunctionComponent11 = new AsyncFunctionComponent("runAsync", anyTypeArr11, function111);
                            }
                        } else {
                            asyncFunctionComponent11 = new FloatAsyncFunctionComponent("runAsync", anyTypeArr11, function111);
                        }
                    } else {
                        asyncFunctionComponent11 = new DoubleAsyncFunctionComponent("runAsync", anyTypeArr11, function111);
                    }
                } else {
                    asyncFunctionComponent11 = new BoolAsyncFunctionComponent("runAsync", anyTypeArr11, function111);
                }
            } else {
                asyncFunctionComponent11 = new IntAsyncFunctionComponent("runAsync", anyTypeArr11, function111);
            }
            classComponentBuilder9.getAsyncFunctions().put("runAsync", asyncFunctionComponent11);
            classComponentBuilder8.getSyncFunctions().put("runSync", new SyncFunctionComponent("runSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Object.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Map run;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    Object obj3 = objArr[2];
                    Object obj4 = objArr[3];
                    boolean booleanValue = ((Boolean) objArr[4]).booleanValue();
                    NativeDatabase nativeDatabase = (NativeDatabase) obj2;
                    NativeStatement nativeStatement = (NativeStatement) obj;
                    SQLiteModuleNext sQLiteModuleNext2 = SQLiteModuleNext.this;
                    run = sQLiteModuleNext2.run(nativeStatement, nativeDatabase, (Map) obj3, (Map) obj4, booleanValue);
                    return run;
                }
            }));
            classComponentBuilder8.getAsyncFunctions().put("stepAsync", new AsyncFunctionComponent("stepAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))}, new Function1<Object[], ArrayList<Object>>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$9
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ArrayList<Object> invoke(Object[] objArr) {
                    ArrayList<Object> step;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    NativeDatabase nativeDatabase = (NativeDatabase) objArr[1];
                    step = SQLiteModuleNext.this.step((NativeStatement) obj, nativeDatabase);
                    return step;
                }
            }));
            classComponentBuilder8.getSyncFunctions().put("stepSync", new SyncFunctionComponent("stepSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$9
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    ArrayList step;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    NativeDatabase nativeDatabase = (NativeDatabase) objArr[1];
                    step = SQLiteModuleNext.this.step((NativeStatement) obj, nativeDatabase);
                    return step;
                }
            }));
            ClassComponentBuilder classComponentBuilder10 = classComponentBuilder8;
            AnyType[] anyTypeArr12 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))};
            Function1<Object[], List<? extends ArrayList<Object>>> function112 = new Function1<Object[], List<? extends ArrayList<Object>>>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$12
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List<? extends ArrayList<Object>> invoke(Object[] objArr) {
                    List<? extends ArrayList<Object>> all;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    NativeDatabase nativeDatabase = (NativeDatabase) objArr[1];
                    all = SQLiteModuleNext.this.getAll((NativeStatement) obj, nativeDatabase);
                    return all;
                }
            };
            if (!Intrinsics.areEqual(List.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(List.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(List.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(List.class, String.class)) {
                                asyncFunctionComponent12 = new StringAsyncFunctionComponent("getAllAsync", anyTypeArr12, function112);
                            } else {
                                asyncFunctionComponent12 = new AsyncFunctionComponent("getAllAsync", anyTypeArr12, function112);
                            }
                        } else {
                            asyncFunctionComponent12 = new FloatAsyncFunctionComponent("getAllAsync", anyTypeArr12, function112);
                        }
                    } else {
                        asyncFunctionComponent12 = new DoubleAsyncFunctionComponent("getAllAsync", anyTypeArr12, function112);
                    }
                } else {
                    asyncFunctionComponent12 = new BoolAsyncFunctionComponent("getAllAsync", anyTypeArr12, function112);
                }
            } else {
                asyncFunctionComponent12 = new IntAsyncFunctionComponent("getAllAsync", anyTypeArr12, function112);
            }
            classComponentBuilder10.getAsyncFunctions().put("getAllAsync", asyncFunctionComponent12);
            classComponentBuilder8.getSyncFunctions().put("getAllSync", new SyncFunctionComponent("getAllSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$12
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    List all;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    NativeDatabase nativeDatabase = (NativeDatabase) objArr[1];
                    all = SQLiteModuleNext.this.getAll((NativeStatement) obj, nativeDatabase);
                    return all;
                }
            }));
            ClassComponentBuilder classComponentBuilder11 = classComponentBuilder8;
            AnyType[] anyTypeArr13 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))};
            Function1<Object[], Unit> function113 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$15
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    NativeDatabase nativeDatabase = (NativeDatabase) objArr[1];
                    SQLiteModuleNext.this.reset((NativeStatement) obj, nativeDatabase);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent13 = new StringAsyncFunctionComponent("resetAsync", anyTypeArr13, function113);
                            } else {
                                asyncFunctionComponent13 = new AsyncFunctionComponent("resetAsync", anyTypeArr13, function113);
                            }
                        } else {
                            asyncFunctionComponent13 = new FloatAsyncFunctionComponent("resetAsync", anyTypeArr13, function113);
                        }
                    } else {
                        asyncFunctionComponent13 = new DoubleAsyncFunctionComponent("resetAsync", anyTypeArr13, function113);
                    }
                } else {
                    asyncFunctionComponent13 = new BoolAsyncFunctionComponent("resetAsync", anyTypeArr13, function113);
                }
            } else {
                asyncFunctionComponent13 = new IntAsyncFunctionComponent("resetAsync", anyTypeArr13, function113);
            }
            classComponentBuilder11.getAsyncFunctions().put("resetAsync", asyncFunctionComponent13);
            classComponentBuilder8.getSyncFunctions().put("resetSync", new SyncFunctionComponent("resetSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$15
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    NativeDatabase nativeDatabase = (NativeDatabase) objArr[1];
                    SQLiteModuleNext.this.reset((NativeStatement) obj, nativeDatabase);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder12 = classComponentBuilder8;
            if (Intrinsics.areEqual(NativeStatement.class, Promise.class)) {
                asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("getColumnNamesAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$16
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        NativeStatement nativeStatement = (NativeStatement) promise;
                        SQLiteModuleNext.this.maybeThrowForFinalizedStatement(nativeStatement);
                        nativeStatement.getRef().getColumnNames();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr14 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$17
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeStatement.class);
                    }
                }))};
                Function1<Object[], ArrayList<String>> function114 = new Function1<Object[], ArrayList<String>>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$18
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final ArrayList<String> invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        NativeStatement nativeStatement = (NativeStatement) objArr[0];
                        SQLiteModuleNext.this.maybeThrowForFinalizedStatement(nativeStatement);
                        return nativeStatement.getRef().getColumnNames();
                    }
                };
                if (!Intrinsics.areEqual(ArrayList.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(ArrayList.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(ArrayList.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(ArrayList.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(ArrayList.class, String.class)) {
                                    asyncFunctionComponent14 = new StringAsyncFunctionComponent("getColumnNamesAsync", anyTypeArr14, function114);
                                } else {
                                    asyncFunctionComponent14 = new AsyncFunctionComponent("getColumnNamesAsync", anyTypeArr14, function114);
                                }
                            } else {
                                asyncFunctionComponent14 = new FloatAsyncFunctionComponent("getColumnNamesAsync", anyTypeArr14, function114);
                            }
                        } else {
                            asyncFunctionComponent14 = new DoubleAsyncFunctionComponent("getColumnNamesAsync", anyTypeArr14, function114);
                        }
                    } else {
                        asyncFunctionComponent14 = new BoolAsyncFunctionComponent("getColumnNamesAsync", anyTypeArr14, function114);
                    }
                } else {
                    asyncFunctionComponent14 = new IntAsyncFunctionComponent("getColumnNamesAsync", anyTypeArr14, function114);
                }
                asyncFunctionWithPromiseComponent7 = asyncFunctionComponent14;
            }
            classComponentBuilder12.getAsyncFunctions().put("getColumnNamesAsync", asyncFunctionWithPromiseComponent7);
            classComponentBuilder8.getSyncFunctions().put("getColumnNamesSync", new SyncFunctionComponent("getColumnNamesSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$17
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    NativeStatement nativeStatement = (NativeStatement) objArr[0];
                    SQLiteModuleNext.this.maybeThrowForFinalizedStatement(nativeStatement);
                    return nativeStatement.getRef().getColumnNames();
                }
            }));
            ClassComponentBuilder classComponentBuilder13 = classComponentBuilder8;
            AnyType[] anyTypeArr15 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))};
            Function1<Object[], Unit> function115 = new Function1<Object[], Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$AsyncFunction$21
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    NativeDatabase nativeDatabase = (NativeDatabase) objArr[1];
                    SQLiteModuleNext.this.finalize((NativeStatement) obj, nativeDatabase);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent15 = new StringAsyncFunctionComponent("finalizeAsync", anyTypeArr15, function115);
                            } else {
                                asyncFunctionComponent15 = new AsyncFunctionComponent("finalizeAsync", anyTypeArr15, function115);
                            }
                        } else {
                            asyncFunctionComponent15 = new FloatAsyncFunctionComponent("finalizeAsync", anyTypeArr15, function115);
                        }
                    } else {
                        asyncFunctionComponent15 = new DoubleAsyncFunctionComponent("finalizeAsync", anyTypeArr15, function115);
                    }
                } else {
                    asyncFunctionComponent15 = new BoolAsyncFunctionComponent("finalizeAsync", anyTypeArr15, function115);
                }
            } else {
                asyncFunctionComponent15 = new IntAsyncFunctionComponent("finalizeAsync", anyTypeArr15, function115);
            }
            classComponentBuilder13.getAsyncFunctions().put("finalizeAsync", asyncFunctionComponent15);
            classComponentBuilder8.getSyncFunctions().put("finalizeSync", new SyncFunctionComponent("finalizeSync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeStatement.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeStatement.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeDatabase.class), false, new Function0<KType>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeDatabase.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sqlite.SQLiteModuleNext$definition$lambda$36$lambda$35$$inlined$Function$20
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    NativeDatabase nativeDatabase = (NativeDatabase) objArr[1];
                    SQLiteModuleNext.this.finalize((NativeStatement) obj, nativeDatabase);
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getClassData().add(classComponentBuilder8.buildClass());
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String pathForDatabaseName(String name) throws OpenDatabaseException {
        if (Intrinsics.areEqual(name, ":memory:")) {
            return name;
        }
        try {
            File file = new File(getContext().getFilesDir() + File.separator + "SQLite");
            SQLiteHelpersKt.ensureDirExists(file);
            return file + File.separator + name;
        } catch (IOException unused) {
            throw new OpenDatabaseException(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NativeDatabase deserializeDatabase(byte[] serializedData, OpenDatabaseOptions options) {
        NativeDatabase nativeDatabase = new NativeDatabase(":memory:", options);
        if (nativeDatabase.getRef().sqlite3_open(":memory:") != 0) {
            throw new OpenDatabaseException(":memory:");
        }
        if (nativeDatabase.getRef().sqlite3_deserialize(SentryThread.JsonKeys.MAIN, serializedData) == 0) {
            return nativeDatabase;
        }
        throw new SQLiteErrorException(nativeDatabase.getRef().convertSqlLiteErrorToString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initDb(NativeDatabase database) throws AccessClosedResourceException {
        maybeThrowForClosedDatabase(database);
        if (database.getOpenOptions().getEnableCRSQLite()) {
            loadCRSQLiteExtension(database);
        }
        if (database.getOpenOptions().getEnableChangeListener()) {
            addUpdateHook(database);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exec(NativeDatabase database, String source) throws AccessClosedResourceException, SQLiteErrorException {
        maybeThrowForClosedDatabase(database);
        database.getRef().sqlite3_exec(source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] serialize(NativeDatabase database, String databaseName) throws AccessClosedResourceException, SQLiteErrorException {
        maybeThrowForClosedDatabase(database);
        return database.getRef().sqlite3_serialize(databaseName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareStatement(NativeDatabase database, NativeStatement statement, String source) throws AccessClosedResourceException, SQLiteErrorException {
        maybeThrowForClosedDatabase(database);
        maybeThrowForFinalizedStatement(statement);
        if (database.getRef().sqlite3_prepare_v2(source, statement.getRef()) != 0) {
            throw new SQLiteErrorException(database.getRef().convertSqlLiteErrorToString());
        }
        maybeAddCachedStatement(database, statement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> run(NativeStatement statement, NativeDatabase database, Map<String, ? extends Object> bindParams, Map<String, byte[]> bindBlobParams, boolean shouldPassAsArray) throws AccessClosedResourceException, SQLiteErrorException {
        ArrayList<Object> arrayList;
        maybeThrowForClosedDatabase(database);
        maybeThrowForFinalizedStatement(statement);
        statement.getRef().sqlite3_reset();
        statement.getRef().sqlite3_clear_bindings();
        for (Map.Entry<String, ? extends Object> entry : bindParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            int bindParamIndex = getBindParamIndex(statement, key, shouldPassAsArray);
            if (bindParamIndex > 0) {
                if (value instanceof Double) {
                    Number number = (Number) value;
                    if (number.doubleValue() % 1.0d == AudioStats.AUDIO_AMPLITUDE_NONE) {
                        value = Long.valueOf((long) number.doubleValue());
                    }
                }
                statement.getRef().bindStatementParam(bindParamIndex, value);
            }
        }
        for (Map.Entry<String, byte[]> entry2 : bindBlobParams.entrySet()) {
            String key2 = entry2.getKey();
            byte[] value2 = entry2.getValue();
            int bindParamIndex2 = getBindParamIndex(statement, key2, shouldPassAsArray);
            if (bindParamIndex2 > 0) {
                statement.getRef().bindStatementParam(bindParamIndex2, value2);
            }
        }
        int sqlite3_step = statement.getRef().sqlite3_step();
        if (sqlite3_step != 100 && sqlite3_step != 101) {
            throw new SQLiteErrorException(database.getRef().convertSqlLiteErrorToString());
        }
        if (sqlite3_step == 100) {
            arrayList = statement.getRef().getColumnValues();
        } else {
            arrayList = new ArrayList<>();
        }
        return MapsKt.mapOf(TuplesKt.to("lastInsertRowId", Integer.valueOf((int) database.getRef().sqlite3_last_insert_rowid())), TuplesKt.to("changes", Integer.valueOf(database.getRef().sqlite3_changes())), TuplesKt.to("firstRowValues", arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Object> step(NativeStatement statement, NativeDatabase database) throws AccessClosedResourceException, InvalidConvertibleException, SQLiteErrorException {
        maybeThrowForClosedDatabase(database);
        maybeThrowForFinalizedStatement(statement);
        int sqlite3_step = statement.getRef().sqlite3_step();
        if (sqlite3_step == 100) {
            return statement.getRef().getColumnValues();
        }
        if (sqlite3_step == 101) {
            return null;
        }
        throw new SQLiteErrorException(database.getRef().convertSqlLiteErrorToString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ArrayList<Object>> getAll(NativeStatement statement, NativeDatabase database) throws AccessClosedResourceException, InvalidConvertibleException, SQLiteErrorException {
        int sqlite3_step;
        maybeThrowForClosedDatabase(database);
        maybeThrowForFinalizedStatement(statement);
        ArrayList arrayList = new ArrayList();
        while (true) {
            sqlite3_step = statement.getRef().sqlite3_step();
            if (sqlite3_step != 100) {
                break;
            }
            arrayList.add(statement.getRef().getColumnValues());
        }
        if (sqlite3_step == 101) {
            return arrayList;
        }
        throw new SQLiteErrorException(database.getRef().convertSqlLiteErrorToString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reset(NativeStatement statement, NativeDatabase database) throws AccessClosedResourceException, SQLiteErrorException {
        maybeThrowForClosedDatabase(database);
        maybeThrowForFinalizedStatement(statement);
        if (statement.getRef().sqlite3_reset() != 0) {
            throw new SQLiteErrorException(database.getRef().convertSqlLiteErrorToString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finalize(NativeStatement statement, NativeDatabase database) throws AccessClosedResourceException, SQLiteErrorException {
        maybeThrowForClosedDatabase(database);
        maybeThrowForFinalizedStatement(statement);
        maybeRemoveCachedStatement(database, statement);
        if (statement.getRef().sqlite3_finalize() != 0) {
            throw new SQLiteErrorException(database.getRef().convertSqlLiteErrorToString());
        }
        statement.setFinalized(true);
    }

    private final void loadCRSQLiteExtension(NativeDatabase database) {
        int sqlite3_enable_load_extension = database.getRef().sqlite3_enable_load_extension(1);
        if (sqlite3_enable_load_extension != 0) {
            Log.e(TAG, "Failed to enable sqlite3 extensions - errCode[" + sqlite3_enable_load_extension + "]");
            return;
        }
        int sqlite3_load_extension = database.getRef().sqlite3_load_extension("libcrsqlite", "sqlite3_crsqlite_init");
        if (sqlite3_load_extension != 0) {
            Log.e(TAG, "Failed to load crsqlite extension - errCode[" + sqlite3_load_extension + "]");
        }
    }

    private final void addUpdateHook(final NativeDatabase database) {
        database.getRef().enableUpdateHook(new Function4<String, String, Integer, Long, Unit>() { // from class: expo.modules.sqlite.SQLiteModuleNext$addUpdateHook$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, Integer num, Long l) {
                invoke(str, str2, num.intValue(), l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(String databaseName, String tableName, int i, long j) {
                boolean z;
                Intrinsics.checkNotNullParameter(databaseName, "databaseName");
                Intrinsics.checkNotNullParameter(tableName, "tableName");
                z = SQLiteModuleNext.this.hasListeners;
                if (z) {
                    SQLiteModuleNext.this.sendEvent("onDatabaseChange", BundleKt.bundleOf(TuplesKt.to("databaseName", databaseName), TuplesKt.to("databaseFilePath", database.getRef().sqlite3_db_filename(databaseName)), TuplesKt.to("tableName", tableName), TuplesKt.to("rowId", Long.valueOf(j)), TuplesKt.to("typeId", SQLAction.INSTANCE.fromCode(i).getValue())));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeDatabase(NativeDatabase database) throws AccessClosedResourceException, SQLiteErrorException {
        maybeThrowForClosedDatabase(database);
        Iterator<T> it = maybeRemoveAllCachedStatements(database).iterator();
        while (it.hasNext()) {
            ((NativeStatement) it.next()).getRef().sqlite3_finalize();
        }
        if (database.getOpenOptions().getEnableCRSQLite()) {
            database.getRef().sqlite3_exec("SELECT crsql_finalize()");
        }
        if (database.getRef().sqlite3_close() != 0) {
            throw new SQLiteErrorException(database.getRef().convertSqlLiteErrorToString());
        }
        database.setClosed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteDatabase(final String databaseName) {
        if (findCachedDatabase(new Function1<NativeDatabase, Boolean>() { // from class: expo.modules.sqlite.SQLiteModuleNext$deleteDatabase$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(NativeDatabase it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.getDatabaseName(), databaseName));
            }
        }) != null) {
            throw new DeleteDatabaseException(databaseName);
        }
        if (Intrinsics.areEqual(databaseName, ":memory:")) {
            return;
        }
        File file = new File(pathForDatabaseName(databaseName));
        if (!file.exists()) {
            throw new DatabaseNotFoundException(databaseName);
        }
        if (!file.delete()) {
            throw new DeleteDatabaseFileException(databaseName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeThrowForClosedDatabase(NativeDatabase database) throws AccessClosedResourceException {
        if (database.getIsClosed()) {
            throw new AccessClosedResourceException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeThrowForFinalizedStatement(NativeStatement statement) throws AccessClosedResourceException {
        if (statement.getIsFinalized()) {
            throw new AccessClosedResourceException();
        }
    }

    private final int getBindParamIndex(NativeStatement statement, String key, boolean shouldPassAsArray) throws InvalidBindParameterException {
        if (shouldPassAsArray) {
            Integer intOrNull = StringsKt.toIntOrNull(key);
            if (intOrNull != null) {
                return intOrNull.intValue() + 1;
            }
            throw new InvalidBindParameterException();
        }
        return statement.getRef().sqlite3_bind_parameter_index(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void addCachedDatabase(NativeDatabase database) {
        this.cachedDatabases.add(database);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized NativeDatabase removeCachedDatabase(NativeDatabase database) {
        if (!this.cachedDatabases.remove(database)) {
            database = null;
        }
        return database;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized NativeDatabase findCachedDatabase(Function1<? super NativeDatabase, Boolean> predicate) {
        Object obj;
        Iterator<T> it = this.cachedDatabases.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (predicate.invoke(obj).booleanValue()) {
                break;
            }
        }
        return (NativeDatabase) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized List<NativeDatabase> removeAllCachedDatabases() {
        List<NativeDatabase> list;
        list = this.cachedDatabases;
        list.clear();
        return list;
    }

    private final synchronized void maybeAddCachedStatement(NativeDatabase database, NativeStatement statement) {
        if (database.getOpenOptions().getFinalizeUnusedStatementsBeforeClosing()) {
            List<NativeStatement> list = this.cachedStatements.get(database);
            if (list != null) {
                list.add(statement);
            } else {
                this.cachedStatements.put(database, CollectionsKt.mutableListOf(statement));
            }
        }
    }

    private final synchronized void maybeRemoveCachedStatement(NativeDatabase database, NativeStatement statement) {
        if (database.getOpenOptions().getFinalizeUnusedStatementsBeforeClosing()) {
            List<NativeStatement> list = this.cachedStatements.get(database);
            if (list != null) {
                list.remove(statement);
            }
        }
    }

    private final synchronized List<NativeStatement> maybeRemoveAllCachedStatements(NativeDatabase database) {
        if (!database.getOpenOptions().getFinalizeUnusedStatementsBeforeClosing()) {
            return CollectionsKt.emptyList();
        }
        List<NativeStatement> remove = this.cachedStatements.remove(database);
        if (remove == null) {
            remove = CollectionsKt.emptyList();
        }
        return remove;
    }
}
