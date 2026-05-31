package expo.modules.devmenu.modules;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.tracing.Trace;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.interfaces.devmenu.DevMenuPreferencesInterface;
import expo.interfaces.devmenu.ReactHostWrapper;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.devmenu.DevMenuManager;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.exception.UnexpectedException;
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
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: DevMenuInternalModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/devmenu/modules/DevMenuInternalModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuInternalModule extends Module {
    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
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
        AsyncFunctionComponent asyncFunctionComponent5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent6;
        AsyncFunctionComponent asyncFunctionComponent7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        AsyncFunctionComponent asyncFunctionComponent8;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        AsyncFunctionComponent asyncFunctionComponent9;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        DevMenuInternalModule devMenuInternalModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (devMenuInternalModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(devMenuInternalModule);
            moduleDefinitionBuilder.Name("ExpoDevMenuInternal");
            moduleDefinitionBuilder.Constants(TuplesKt.to("doesDeviceSupportKeyCommands", Boolean.valueOf(EmulatorUtilities.INSTANCE.isRunningOnEmulator())));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] it) {
                    Context context;
                    Intrinsics.checkNotNullParameter(it, "it");
                    DevMenuManager devMenuManager = DevMenuManager.INSTANCE;
                    context = DevMenuInternalModule.this.getContext();
                    devMenuManager.loadFonts(context);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("loadFontsAsync", anyTypeArr, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("loadFontsAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("loadFontsAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("loadFontsAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("loadFontsAsync", anyTypeArr, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("loadFontsAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("loadFontsAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableMap.class), true, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableMap.class);
                }
            }))};
            Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    ReadableMap readableMap = (ReadableMap) objArr[1];
                    DevMenuManager.INSTANCE.dispatchCallable((String) obj, readableMap);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent2 = new StringAsyncFunctionComponent("dispatchCallableAsync", anyTypeArr2, function12);
                            } else {
                                asyncFunctionComponent2 = new AsyncFunctionComponent("dispatchCallableAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new FloatAsyncFunctionComponent("dispatchCallableAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("dispatchCallableAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("dispatchCallableAsync", anyTypeArr2, function12);
                }
            } else {
                asyncFunctionComponent2 = new IntAsyncFunctionComponent("dispatchCallableAsync", anyTypeArr2, function12);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("dispatchCallableAsync", asyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], Unit> function13 = new Function1<Object[], Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    DevMenuManager.INSTANCE.hideMenu();
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent3 = new StringAsyncFunctionComponent("hideMenu", anyTypeArr3, function13);
                            } else {
                                asyncFunctionComponent3 = new AsyncFunctionComponent("hideMenu", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new FloatAsyncFunctionComponent("hideMenu", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("hideMenu", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new BoolAsyncFunctionComponent("hideMenu", anyTypeArr3, function13);
                }
            } else {
                asyncFunctionComponent3 = new IntAsyncFunctionComponent("hideMenu", anyTypeArr3, function13);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("hideMenu", asyncFunctionComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1<Object[], Unit> function14 = new Function1<Object[], Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    DevMenuManager.INSTANCE.closeMenu();
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent4 = new StringAsyncFunctionComponent("closeMenu", anyTypeArr4, function14);
                            } else {
                                asyncFunctionComponent4 = new AsyncFunctionComponent("closeMenu", anyTypeArr4, function14);
                            }
                        } else {
                            asyncFunctionComponent4 = new FloatAsyncFunctionComponent("closeMenu", anyTypeArr4, function14);
                        }
                    } else {
                        asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("closeMenu", anyTypeArr4, function14);
                    }
                } else {
                    asyncFunctionComponent4 = new BoolAsyncFunctionComponent("closeMenu", anyTypeArr4, function14);
                }
            } else {
                asyncFunctionComponent4 = new IntAsyncFunctionComponent("closeMenu", anyTypeArr4, function14);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("closeMenu", asyncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Boolean.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setOnboardingFinished", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$7
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        boolean booleanValue = ((Boolean) promise).booleanValue();
                        DevMenuPreferencesInterface settings = DevMenuManager.INSTANCE.getSettings();
                        if (settings == null) {
                            return;
                        }
                        settings.setOnboardingFinished(booleanValue);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr5 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }))};
                Function1<Object[], Unit> function15 = new Function1<Object[], Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
                        DevMenuPreferencesInterface settings = DevMenuManager.INSTANCE.getSettings();
                        if (settings != null) {
                            settings.setOnboardingFinished(booleanValue);
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent5 = new StringAsyncFunctionComponent("setOnboardingFinished", anyTypeArr5, function15);
                                } else {
                                    asyncFunctionComponent5 = new AsyncFunctionComponent("setOnboardingFinished", anyTypeArr5, function15);
                                }
                            } else {
                                asyncFunctionComponent5 = new FloatAsyncFunctionComponent("setOnboardingFinished", anyTypeArr5, function15);
                            }
                        } else {
                            asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("setOnboardingFinished", anyTypeArr5, function15);
                        }
                    } else {
                        asyncFunctionComponent5 = new BoolAsyncFunctionComponent("setOnboardingFinished", anyTypeArr5, function15);
                    }
                } else {
                    asyncFunctionComponent5 = new IntAsyncFunctionComponent("setOnboardingFinished", anyTypeArr5, function15);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent5;
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("setOnboardingFinished", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr6 = new AnyType[0];
            Function1<Object[], Unit> function16 = new Function1<Object[], Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] it) {
                    final DevSupportManager devSupportManager;
                    ReactHostWrapper reactHost;
                    ReactContext currentReactContext;
                    Activity currentActivity;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ReactHostWrapper reactHost2 = DevMenuManager.INSTANCE.getReactHost();
                    if (reactHost2 != null && (devSupportManager = reactHost2.getDevSupportManager()) != null && (reactHost = DevMenuManager.INSTANCE.getReactHost()) != null && (currentReactContext = reactHost.getCurrentReactContext()) != null && (currentActivity = currentReactContext.getCurrentActivity()) != null) {
                        Intrinsics.checkNotNull(currentActivity);
                        currentActivity.runOnUiThread(new Runnable() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$1$6$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                DevMenuManager.INSTANCE.closeMenu();
                                DevSupportManager.this.setDevSupportEnabled(true);
                                DevSupportManager.this.showDevOptionsDialog();
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent6 = new StringAsyncFunctionComponent("openDevMenuFromReactNative", anyTypeArr6, function16);
                            } else {
                                asyncFunctionComponent6 = new AsyncFunctionComponent("openDevMenuFromReactNative", anyTypeArr6, function16);
                            }
                        } else {
                            asyncFunctionComponent6 = new FloatAsyncFunctionComponent("openDevMenuFromReactNative", anyTypeArr6, function16);
                        }
                    } else {
                        asyncFunctionComponent6 = new DoubleAsyncFunctionComponent("openDevMenuFromReactNative", anyTypeArr6, function16);
                    }
                } else {
                    asyncFunctionComponent6 = new BoolAsyncFunctionComponent("openDevMenuFromReactNative", anyTypeArr6, function16);
                }
            } else {
                asyncFunctionComponent6 = new IntAsyncFunctionComponent("openDevMenuFromReactNative", anyTypeArr6, function16);
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("openDevMenuFromReactNative", asyncFunctionComponent6);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("onScreenChangeAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$11
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        DevMenuManager.INSTANCE.setCurrentScreen((String) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr7 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$12
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }))};
                Function1<Object[], Unit> function17 = new Function1<Object[], Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$13
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        DevMenuManager.INSTANCE.setCurrentScreen((String) objArr[0]);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent7 = new StringAsyncFunctionComponent("onScreenChangeAsync", anyTypeArr7, function17);
                                } else {
                                    asyncFunctionComponent7 = new AsyncFunctionComponent("onScreenChangeAsync", anyTypeArr7, function17);
                                }
                            } else {
                                asyncFunctionComponent7 = new FloatAsyncFunctionComponent("onScreenChangeAsync", anyTypeArr7, function17);
                            }
                        } else {
                            asyncFunctionComponent7 = new DoubleAsyncFunctionComponent("onScreenChangeAsync", anyTypeArr7, function17);
                        }
                    } else {
                        asyncFunctionComponent7 = new BoolAsyncFunctionComponent("onScreenChangeAsync", anyTypeArr7, function17);
                    }
                } else {
                    asyncFunctionComponent7 = new IntAsyncFunctionComponent("onScreenChangeAsync", anyTypeArr7, function17);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent7;
            }
            moduleDefinitionBuilder8.getAsyncFunctions().put("onScreenChangeAsync", asyncFunctionWithPromiseComponent2);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("fetchDataSourceAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunctionWithPromise$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunctionWithPromise$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    BuildersKt__Builders_commonKt.launch$default(DevMenuManager.INSTANCE.getCoroutineScope(), null, null, new DevMenuInternalModule$definition$1$8$1((String) objArr[0], promise, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("fetchDataSourceAsync", asyncFunctionWithPromiseComponent5);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6 = asyncFunctionWithPromiseComponent5;
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("copyToClipboardAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$14
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Context context;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        context = DevMenuInternalModule.this.getContext();
                        Object systemService = context.getSystemService("clipboard");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, (String) promise));
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr8 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$15
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }))};
                Function1<Object[], Unit> function18 = new Function1<Object[], Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$16
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Context context;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        String str = (String) objArr[0];
                        context = DevMenuInternalModule.this.getContext();
                        Object systemService = context.getSystemService("clipboard");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, str));
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent8 = new StringAsyncFunctionComponent("copyToClipboardAsync", anyTypeArr8, function18);
                                } else {
                                    asyncFunctionComponent8 = new AsyncFunctionComponent("copyToClipboardAsync", anyTypeArr8, function18);
                                }
                            } else {
                                asyncFunctionComponent8 = new FloatAsyncFunctionComponent("copyToClipboardAsync", anyTypeArr8, function18);
                            }
                        } else {
                            asyncFunctionComponent8 = new DoubleAsyncFunctionComponent("copyToClipboardAsync", anyTypeArr8, function18);
                        }
                    } else {
                        asyncFunctionComponent8 = new BoolAsyncFunctionComponent("copyToClipboardAsync", anyTypeArr8, function18);
                    }
                } else {
                    asyncFunctionComponent8 = new IntAsyncFunctionComponent("copyToClipboardAsync", anyTypeArr8, function18);
                }
                asyncFunctionWithPromiseComponent3 = asyncFunctionComponent8;
            }
            moduleDefinitionBuilder9.getAsyncFunctions().put("copyToClipboardAsync", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("fireCallback", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$17
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Object obj;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String str = (String) promise;
                        Iterator<T> it = DevMenuManager.INSTANCE.getRegisteredCallbacks().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            } else {
                                obj = it.next();
                                if (Intrinsics.areEqual(((DevMenuManager.Callback) obj).getName(), str)) {
                                    break;
                                }
                            }
                        }
                        DevMenuManager.Callback callback = (DevMenuManager.Callback) obj;
                        if (callback == null) {
                            throw new UnexpectedException("Callback with name: " + str + " is not registered");
                        }
                        DevMenuManager.INSTANCE.sendEventToDelegateBridge("registeredCallbackFired", str);
                        if (callback.getShouldCollapse()) {
                            DevMenuManager.INSTANCE.closeMenu();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr9 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$18
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }))};
                Function1<Object[], Unit> function19 = new Function1<Object[], Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$19
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Object obj;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        String str = (String) objArr[0];
                        Iterator<T> it = DevMenuManager.INSTANCE.getRegisteredCallbacks().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (Intrinsics.areEqual(((DevMenuManager.Callback) obj).getName(), str)) {
                                break;
                            }
                        }
                        DevMenuManager.Callback callback = (DevMenuManager.Callback) obj;
                        if (callback == null) {
                            throw new UnexpectedException("Callback with name: " + str + " is not registered");
                        }
                        DevMenuManager.INSTANCE.sendEventToDelegateBridge("registeredCallbackFired", str);
                        if (callback.getShouldCollapse()) {
                            DevMenuManager.INSTANCE.closeMenu();
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent9 = new StringAsyncFunctionComponent("fireCallback", anyTypeArr9, function19);
                                } else {
                                    asyncFunctionComponent9 = new AsyncFunctionComponent("fireCallback", anyTypeArr9, function19);
                                }
                            } else {
                                asyncFunctionComponent9 = new FloatAsyncFunctionComponent("fireCallback", anyTypeArr9, function19);
                            }
                        } else {
                            asyncFunctionComponent9 = new DoubleAsyncFunctionComponent("fireCallback", anyTypeArr9, function19);
                        }
                    } else {
                        asyncFunctionComponent9 = new BoolAsyncFunctionComponent("fireCallback", anyTypeArr9, function19);
                    }
                } else {
                    asyncFunctionComponent9 = new IntAsyncFunctionComponent("fireCallback", anyTypeArr9, function19);
                }
                asyncFunctionWithPromiseComponent4 = asyncFunctionComponent9;
            }
            moduleDefinitionBuilder10.getAsyncFunctions().put("fireCallback", asyncFunctionWithPromiseComponent4);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
