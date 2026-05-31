package expo.modules.devmenu.modules;

import android.content.Context;
import androidx.tracing.Trace;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: DevMenuPreferences.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lexpo/modules/devmenu/modules/DevMenuPreferences;", "Lexpo/modules/kotlin/modules/Module;", "()V", "preferencesHandel", "Lexpo/modules/devmenu/modules/DevMenuPreferencesHandle;", "getPreferencesHandel", "()Lexpo/modules/devmenu/modules/DevMenuPreferencesHandle;", "preferencesHandel$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuPreferences extends Module {

    /* renamed from: preferencesHandel$delegate, reason: from kotlin metadata */
    private final Lazy preferencesHandel = LazyKt.lazy(new Function0<DevMenuPreferencesHandle>() { // from class: expo.modules.devmenu.modules.DevMenuPreferences$preferencesHandel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DevMenuPreferencesHandle invoke() {
            Context reactContext = DevMenuPreferences.this.getAppContext().getReactContext();
            if (reactContext != null) {
                return new DevMenuPreferencesHandle(reactContext);
            }
            throw new Exceptions.ReactContextLost();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final DevMenuPreferencesHandle getPreferencesHandel() {
        return (DevMenuPreferencesHandle) this.preferencesHandel.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        DevMenuPreferences devMenuPreferences = this;
        Trace.beginSection("[ExpoModulesCore] " + (devMenuPreferences.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(devMenuPreferences);
            moduleDefinitionBuilder.Name("DevMenuPreferences");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1<Object[], WritableMap> function1 = new Function1<Object[], WritableMap>() { // from class: expo.modules.devmenu.modules.DevMenuPreferences$definition$lambda$2$$inlined$AsyncFunction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final WritableMap invoke(Object[] it) {
                    DevMenuPreferencesHandle preferencesHandel;
                    Intrinsics.checkNotNullParameter(it, "it");
                    preferencesHandel = DevMenuPreferences.this.getPreferencesHandel();
                    return preferencesHandel.serialize();
                }
            };
            if (!Intrinsics.areEqual(WritableMap.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(WritableMap.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(WritableMap.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(WritableMap.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(WritableMap.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("getPreferencesAsync", anyTypeArr, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("getPreferencesAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("getPreferencesAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("getPreferencesAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("getPreferencesAsync", anyTypeArr, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("getPreferencesAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getPreferencesAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(ReadableMap.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setPreferencesAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuPreferences$definition$lambda$2$$inlined$AsyncFunction$2
                    {
                        super(2);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        DevMenuPreferencesHandle preferencesHandel;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        preferencesHandel = DevMenuPreferences.this.getPreferencesHandel();
                        preferencesHandel.setPreferences((ReadableMap) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableMap.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuPreferences$definition$lambda$2$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ReadableMap.class);
                    }
                }))};
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.devmenu.modules.DevMenuPreferences$definition$lambda$2$$inlined$AsyncFunction$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        DevMenuPreferencesHandle preferencesHandel;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        ReadableMap readableMap = (ReadableMap) objArr[0];
                        preferencesHandel = DevMenuPreferences.this.getPreferencesHandel();
                        preferencesHandel.setPreferences(readableMap);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("setPreferencesAsync", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("setPreferencesAsync", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("setPreferencesAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("setPreferencesAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("setPreferencesAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("setPreferencesAsync", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("setPreferencesAsync", asyncFunctionWithPromiseComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
