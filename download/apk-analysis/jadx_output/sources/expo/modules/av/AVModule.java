package expo.modules.av;

import android.os.Bundle;
import androidx.tracing.Trace;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
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
import java.lang.ref.WeakReference;
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

/* compiled from: AVModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lexpo/modules/av/AVModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "_avManager", "Lexpo/modules/av/AVManagerInterface;", "get_avManager", "()Lexpo/modules/av/AVManagerInterface;", "_avManager$delegate", "Lkotlin/Lazy;", "avManager", "getAvManager", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-av_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AVModule extends Module {

    /* renamed from: _avManager$delegate, reason: from kotlin metadata */
    private final Lazy _avManager = LazyKt.lazy(new Function0<AVManagerInterface>() { // from class: expo.modules.av.AVModule$_avManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AVManagerInterface invoke() {
            Object obj;
            try {
                obj = AVModule.this.getAppContext().getLegacyModuleRegistry().getModule(AVManagerInterface.class);
            } catch (Exception unused) {
                obj = null;
            }
            return (AVManagerInterface) obj;
        }
    });

    private final AVManagerInterface get_avManager() {
        return (AVManagerInterface) this._avManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AVManagerInterface getAvManager() {
        AVManagerInterface aVManagerInterface = get_avManager();
        if (aVManagerInterface != null) {
            return aVManagerInterface;
        }
        throw new AVManagerModuleNotFound();
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        AsyncFunctionComponent asyncFunctionComponent5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5;
        AsyncFunctionComponent asyncFunctionComponent6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6;
        AsyncFunctionComponent asyncFunctionComponent7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7;
        AsyncFunctionComponent asyncFunctionComponent8;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent8;
        AsyncFunctionComponent asyncFunctionComponent9;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent9;
        AsyncFunctionComponent asyncFunctionComponent10;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent10;
        AsyncFunctionComponent asyncFunctionComponent11;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent11;
        AVModule aVModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (aVModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(aVModule);
            moduleDefinitionBuilder.Name("ExponentAV");
            moduleDefinitionBuilder.Events("didUpdatePlaybackStatus", "ExponentAV.onError", "Expo.Recording.recorderUnloaded");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$OnCreate$1
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
                    Object obj;
                    final WeakReference weakReference = new WeakReference(AVModule.this);
                    final Function2<String, Bundle, Unit> function2 = new Function2<String, Bundle, Unit>() { // from class: expo.modules.av.AVModule$definition$1$1$emitEvent$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                            invoke2(str, bundle);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String name, Bundle body) {
                            Intrinsics.checkNotNullParameter(name, "name");
                            Intrinsics.checkNotNullParameter(body, "body");
                            try {
                                AVModule aVModule2 = weakReference.get();
                                if (aVModule2 != null) {
                                    aVModule2.sendEvent(name, body);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    };
                    try {
                        obj = AVModule.this.getAppContext().getLegacyModuleRegistry().getModule(AVManagerInterface.class);
                    } catch (Exception unused) {
                        obj = null;
                    }
                    AVManagerInterface aVManagerInterface = (AVManagerInterface) obj;
                    if (aVManagerInterface != null) {
                        aVManagerInterface.setEmitEventWrapper(new EmitEventWrapper(function2) { // from class: expo.modules.av.AVModuleKt$sam$expo_modules_av_EmitEventWrapper$0
                            private final /* synthetic */ Function2 function;

                            {
                                Intrinsics.checkNotNullParameter(function2, "function");
                                this.function = function2;
                            }

                            @Override // expo.modules.av.EmitEventWrapper
                            public final /* synthetic */ void emit(String str, Bundle bundle) {
                                this.function.invoke(str, bundle);
                            }
                        });
                    }
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Boolean.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setAudioIsEnabled", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        AVManagerInterface avManager;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Boolean bool = (Boolean) promise;
                        bool.booleanValue();
                        avManager = AVModule.this.getAvManager();
                        avManager.setAudioIsEnabled(bool);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }))};
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        AVManagerInterface avManager;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Boolean bool = (Boolean) objArr[0];
                        bool.booleanValue();
                        avManager = AVModule.this.getAvManager();
                        avManager.setAudioIsEnabled(bool);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("setAudioIsEnabled", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("setAudioIsEnabled", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(ReadableArguments.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("setAudioMode", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        AVManagerInterface avManager;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        avManager = AVModule.this.getAvManager();
                        avManager.setAudioMode((ReadableArguments) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ReadableArguments.class);
                    }
                }))};
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        AVManagerInterface avManager;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        ReadableArguments readableArguments = (ReadableArguments) objArr[0];
                        avManager = AVModule.this.getAvManager();
                        avManager.setAudioMode(readableArguments);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("setAudioMode", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("setAudioMode", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("setAudioMode", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("setAudioMode", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("setAudioMode", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("setAudioMode", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("setAudioMode", asyncFunctionWithPromiseComponent2);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent12 = new AsyncFunctionWithPromiseComponent("loadForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    ReadableArguments readableArguments = (ReadableArguments) objArr[1];
                    avManager = AVModule.this.getAvManager();
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.loadForSound((ReadableArguments) obj, readableArguments, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("loadForSound", asyncFunctionWithPromiseComponent12);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent13 = asyncFunctionWithPromiseComponent12;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent14 = new AsyncFunctionWithPromiseComponent("unloadForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$5
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    int intValue = ((Number) objArr[0]).intValue();
                    avManager = AVModule.this.getAvManager();
                    Integer valueOf = Integer.valueOf(intValue);
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.unloadForSound(valueOf, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("unloadForSound", asyncFunctionWithPromiseComponent14);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent15 = asyncFunctionWithPromiseComponent14;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent16 = new AsyncFunctionWithPromiseComponent("setStatusForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$8
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    ReadableArguments readableArguments = (ReadableArguments) objArr[1];
                    int intValue = ((Number) obj).intValue();
                    avManager = AVModule.this.getAvManager();
                    Integer valueOf = Integer.valueOf(intValue);
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.setStatusForSound(valueOf, readableArguments, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("setStatusForSound", asyncFunctionWithPromiseComponent16);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent17 = asyncFunctionWithPromiseComponent16;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent18 = new AsyncFunctionWithPromiseComponent("replaySound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$11
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    ReadableArguments readableArguments = (ReadableArguments) objArr[1];
                    int intValue = ((Number) obj).intValue();
                    avManager = AVModule.this.getAvManager();
                    Integer valueOf = Integer.valueOf(intValue);
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.replaySound(valueOf, readableArguments, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("replaySound", asyncFunctionWithPromiseComponent18);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent19 = asyncFunctionWithPromiseComponent18;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent20 = new AsyncFunctionWithPromiseComponent("getStatusForSound", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$13
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    int intValue = ((Number) objArr[0]).intValue();
                    avManager = AVModule.this.getAvManager();
                    Integer valueOf = Integer.valueOf(intValue);
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.getStatusForSound(valueOf, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getStatusForSound", asyncFunctionWithPromiseComponent20);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent21 = asyncFunctionWithPromiseComponent20;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent22 = new AsyncFunctionWithPromiseComponent("loadForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$17
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    ReadableArguments readableArguments = (ReadableArguments) objArr[2];
                    int intValue = ((Number) obj).intValue();
                    avManager = AVModule.this.getAvManager();
                    Integer valueOf = Integer.valueOf(intValue);
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.loadForVideo(valueOf, (ReadableArguments) obj2, readableArguments, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("loadForVideo", asyncFunctionWithPromiseComponent22);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent23 = asyncFunctionWithPromiseComponent22;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent24 = new AsyncFunctionWithPromiseComponent("unloadForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$19
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    int intValue = ((Number) objArr[0]).intValue();
                    avManager = AVModule.this.getAvManager();
                    Integer valueOf = Integer.valueOf(intValue);
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.unloadForVideo(valueOf, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("unloadForVideo", asyncFunctionWithPromiseComponent24);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent25 = asyncFunctionWithPromiseComponent24;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent26 = new AsyncFunctionWithPromiseComponent("setStatusForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$22
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    ReadableArguments readableArguments = (ReadableArguments) objArr[1];
                    int intValue = ((Number) obj).intValue();
                    avManager = AVModule.this.getAvManager();
                    Integer valueOf = Integer.valueOf(intValue);
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.setStatusForVideo(valueOf, readableArguments, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("setStatusForVideo", asyncFunctionWithPromiseComponent26);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent27 = asyncFunctionWithPromiseComponent26;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent28 = new AsyncFunctionWithPromiseComponent("replayVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$25
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    ReadableArguments readableArguments = (ReadableArguments) objArr[1];
                    int intValue = ((Number) obj).intValue();
                    avManager = AVModule.this.getAvManager();
                    Integer valueOf = Integer.valueOf(intValue);
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.replayVideo(valueOf, readableArguments, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("replayVideo", asyncFunctionWithPromiseComponent28);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent29 = asyncFunctionWithPromiseComponent28;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent30 = new AsyncFunctionWithPromiseComponent("getStatusForVideo", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$27
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    int intValue = ((Number) objArr[0]).intValue();
                    avManager = AVModule.this.getAvManager();
                    Integer valueOf = Integer.valueOf(intValue);
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.getStatusForVideo(valueOf, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getStatusForVideo", asyncFunctionWithPromiseComponent30);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent31 = asyncFunctionWithPromiseComponent30;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent32 = new AsyncFunctionWithPromiseComponent("prepareAudioRecorder", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$29
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    ReadableArguments readableArguments = (ReadableArguments) objArr[0];
                    avManager = AVModule.this.getAvManager();
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.prepareAudioRecorder(readableArguments, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("prepareAudioRecorder", asyncFunctionWithPromiseComponent32);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent33 = asyncFunctionWithPromiseComponent32;
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("getAvailableInputs", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$7
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.getAvailableInputs(legacyPromise);
                    }
                });
            } else {
                AnyType[] anyTypeArr3 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function13 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.getAvailableInputs(legacyPromise);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("getAvailableInputs", anyTypeArr3, function13);
                                } else {
                                    asyncFunctionComponent3 = new AsyncFunctionComponent("getAvailableInputs", anyTypeArr3, function13);
                                }
                            } else {
                                asyncFunctionComponent3 = new FloatAsyncFunctionComponent("getAvailableInputs", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("getAvailableInputs", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new BoolAsyncFunctionComponent("getAvailableInputs", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("getAvailableInputs", anyTypeArr3, function13);
                }
                asyncFunctionWithPromiseComponent3 = asyncFunctionComponent3;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("getAvailableInputs", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("getCurrentInput", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$10
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.getCurrentInput(legacyPromise);
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function14 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$12
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.getCurrentInput(legacyPromise);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent4 = new StringAsyncFunctionComponent("getCurrentInput", anyTypeArr4, function14);
                                } else {
                                    asyncFunctionComponent4 = new AsyncFunctionComponent("getCurrentInput", anyTypeArr4, function14);
                                }
                            } else {
                                asyncFunctionComponent4 = new FloatAsyncFunctionComponent("getCurrentInput", anyTypeArr4, function14);
                            }
                        } else {
                            asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("getCurrentInput", anyTypeArr4, function14);
                        }
                    } else {
                        asyncFunctionComponent4 = new BoolAsyncFunctionComponent("getCurrentInput", anyTypeArr4, function14);
                    }
                } else {
                    asyncFunctionComponent4 = new IntAsyncFunctionComponent("getCurrentInput", anyTypeArr4, function14);
                }
                asyncFunctionWithPromiseComponent4 = asyncFunctionComponent4;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getCurrentInput", asyncFunctionWithPromiseComponent4);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent34 = new AsyncFunctionWithPromiseComponent("setInput", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$31
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    AVManagerInterface avManager;
                    expo.modules.core.Promise legacyPromise;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    avManager = AVModule.this.getAvManager();
                    legacyPromise = AVModuleKt.toLegacyPromise(promise);
                    avManager.setInput(str, legacyPromise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("setInput", asyncFunctionWithPromiseComponent34);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent35 = asyncFunctionWithPromiseComponent34;
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("startAudioRecording", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$13
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.startAudioRecording(legacyPromise);
                    }
                });
            } else {
                AnyType[] anyTypeArr5 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$14
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function15 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$15
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.startAudioRecording(legacyPromise);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent5 = new StringAsyncFunctionComponent("startAudioRecording", anyTypeArr5, function15);
                                } else {
                                    asyncFunctionComponent5 = new AsyncFunctionComponent("startAudioRecording", anyTypeArr5, function15);
                                }
                            } else {
                                asyncFunctionComponent5 = new FloatAsyncFunctionComponent("startAudioRecording", anyTypeArr5, function15);
                            }
                        } else {
                            asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("startAudioRecording", anyTypeArr5, function15);
                        }
                    } else {
                        asyncFunctionComponent5 = new BoolAsyncFunctionComponent("startAudioRecording", anyTypeArr5, function15);
                    }
                } else {
                    asyncFunctionComponent5 = new IntAsyncFunctionComponent("startAudioRecording", anyTypeArr5, function15);
                }
                asyncFunctionWithPromiseComponent5 = asyncFunctionComponent5;
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("startAudioRecording", asyncFunctionWithPromiseComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("pauseAudioRecording", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$16
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.pauseAudioRecording(legacyPromise);
                    }
                });
            } else {
                AnyType[] anyTypeArr6 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$17
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function16 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$18
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.pauseAudioRecording(legacyPromise);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent6 = new StringAsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, function16);
                                } else {
                                    asyncFunctionComponent6 = new AsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, function16);
                                }
                            } else {
                                asyncFunctionComponent6 = new FloatAsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, function16);
                            }
                        } else {
                            asyncFunctionComponent6 = new DoubleAsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, function16);
                        }
                    } else {
                        asyncFunctionComponent6 = new BoolAsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, function16);
                    }
                } else {
                    asyncFunctionComponent6 = new IntAsyncFunctionComponent("pauseAudioRecording", anyTypeArr6, function16);
                }
                asyncFunctionWithPromiseComponent6 = asyncFunctionComponent6;
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("pauseAudioRecording", asyncFunctionWithPromiseComponent6);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("stopAudioRecording", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$19
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.stopAudioRecording(legacyPromise);
                    }
                });
            } else {
                AnyType[] anyTypeArr7 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$20
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function17 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$21
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.stopAudioRecording(legacyPromise);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent7 = new StringAsyncFunctionComponent("stopAudioRecording", anyTypeArr7, function17);
                                } else {
                                    asyncFunctionComponent7 = new AsyncFunctionComponent("stopAudioRecording", anyTypeArr7, function17);
                                }
                            } else {
                                asyncFunctionComponent7 = new FloatAsyncFunctionComponent("stopAudioRecording", anyTypeArr7, function17);
                            }
                        } else {
                            asyncFunctionComponent7 = new DoubleAsyncFunctionComponent("stopAudioRecording", anyTypeArr7, function17);
                        }
                    } else {
                        asyncFunctionComponent7 = new BoolAsyncFunctionComponent("stopAudioRecording", anyTypeArr7, function17);
                    }
                } else {
                    asyncFunctionComponent7 = new IntAsyncFunctionComponent("stopAudioRecording", anyTypeArr7, function17);
                }
                asyncFunctionWithPromiseComponent7 = asyncFunctionComponent7;
            }
            moduleDefinitionBuilder8.getAsyncFunctions().put("stopAudioRecording", asyncFunctionWithPromiseComponent7);
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent8 = new AsyncFunctionWithPromiseComponent("getAudioRecordingStatus", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$22
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.getAudioRecordingStatus(legacyPromise);
                    }
                });
            } else {
                AnyType[] anyTypeArr8 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$23
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function18 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$24
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.getAudioRecordingStatus(legacyPromise);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent8 = new StringAsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, function18);
                                } else {
                                    asyncFunctionComponent8 = new AsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, function18);
                                }
                            } else {
                                asyncFunctionComponent8 = new FloatAsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, function18);
                            }
                        } else {
                            asyncFunctionComponent8 = new DoubleAsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, function18);
                        }
                    } else {
                        asyncFunctionComponent8 = new BoolAsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, function18);
                    }
                } else {
                    asyncFunctionComponent8 = new IntAsyncFunctionComponent("getAudioRecordingStatus", anyTypeArr8, function18);
                }
                asyncFunctionWithPromiseComponent8 = asyncFunctionComponent8;
            }
            moduleDefinitionBuilder9.getAsyncFunctions().put("getAudioRecordingStatus", asyncFunctionWithPromiseComponent8);
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent9 = new AsyncFunctionWithPromiseComponent("unloadAudioRecorder", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$25
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.unloadAudioRecorder(legacyPromise);
                    }
                });
            } else {
                AnyType[] anyTypeArr9 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$26
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function19 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$27
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        AVManagerInterface avManager;
                        expo.modules.core.Promise legacyPromise;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        avManager = AVModule.this.getAvManager();
                        legacyPromise = AVModuleKt.toLegacyPromise(promise);
                        avManager.unloadAudioRecorder(legacyPromise);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent9 = new StringAsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, function19);
                                } else {
                                    asyncFunctionComponent9 = new AsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, function19);
                                }
                            } else {
                                asyncFunctionComponent9 = new FloatAsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, function19);
                            }
                        } else {
                            asyncFunctionComponent9 = new DoubleAsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, function19);
                        }
                    } else {
                        asyncFunctionComponent9 = new BoolAsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, function19);
                    }
                } else {
                    asyncFunctionComponent9 = new IntAsyncFunctionComponent("unloadAudioRecorder", anyTypeArr9, function19);
                }
                asyncFunctionWithPromiseComponent9 = asyncFunctionComponent9;
            }
            moduleDefinitionBuilder10.getAsyncFunctions().put("unloadAudioRecorder", asyncFunctionWithPromiseComponent9);
            ModuleDefinitionBuilder moduleDefinitionBuilder11 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent10 = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$28
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.CC.askForPermissionsWithPermissionsManager(AVModule.this.getAppContext().getPermissions(), promise, "android.permission.RECORD_AUDIO");
                    }
                });
            } else {
                AnyType[] anyTypeArr10 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$29
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function110 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$30
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.CC.askForPermissionsWithPermissionsManager(AVModule.this.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.RECORD_AUDIO");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent10 = new StringAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, function110);
                                } else {
                                    asyncFunctionComponent10 = new AsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, function110);
                                }
                            } else {
                                asyncFunctionComponent10 = new FloatAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, function110);
                            }
                        } else {
                            asyncFunctionComponent10 = new DoubleAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, function110);
                        }
                    } else {
                        asyncFunctionComponent10 = new BoolAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, function110);
                    }
                } else {
                    asyncFunctionComponent10 = new IntAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr10, function110);
                }
                asyncFunctionWithPromiseComponent10 = asyncFunctionComponent10;
            }
            moduleDefinitionBuilder11.getAsyncFunctions().put("requestPermissionsAsync", asyncFunctionWithPromiseComponent10);
            ModuleDefinitionBuilder moduleDefinitionBuilder12 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent11 = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$31
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.CC.getPermissionsWithPermissionsManager(AVModule.this.getAppContext().getPermissions(), promise, "android.permission.RECORD_AUDIO");
                    }
                });
            } else {
                AnyType[] anyTypeArr11 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$32
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function111 = new Function1<Object[], Unit>() { // from class: expo.modules.av.AVModule$definition$lambda$24$$inlined$AsyncFunction$33
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.CC.getPermissionsWithPermissionsManager(AVModule.this.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.RECORD_AUDIO");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent11 = new StringAsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, function111);
                                } else {
                                    asyncFunctionComponent11 = new AsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, function111);
                                }
                            } else {
                                asyncFunctionComponent11 = new FloatAsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, function111);
                            }
                        } else {
                            asyncFunctionComponent11 = new DoubleAsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, function111);
                        }
                    } else {
                        asyncFunctionComponent11 = new BoolAsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, function111);
                    }
                } else {
                    asyncFunctionComponent11 = new IntAsyncFunctionComponent("getPermissionsAsync", anyTypeArr11, function111);
                }
                asyncFunctionWithPromiseComponent11 = asyncFunctionComponent11;
            }
            moduleDefinitionBuilder12.getAsyncFunctions().put("getPermissionsAsync", asyncFunctionWithPromiseComponent11);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
