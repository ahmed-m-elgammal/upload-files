package expo.modules.devlauncher.koin;

import expo.modules.devlauncher.helpers.DevLauncherInstallationIDHelper;
import expo.modules.devlauncher.launcher.DevLauncherIntentRegistry;
import expo.modules.devlauncher.launcher.DevLauncherIntentRegistryInterface;
import expo.modules.devlauncher.launcher.DevLauncherLifecycle;
import expo.modules.devlauncher.launcher.loaders.DevLauncherAppLoaderFactory;
import expo.modules.devlauncher.launcher.loaders.DevLauncherAppLoaderFactoryInterface;
import expo.modules.devlauncher.tests.DevLauncherDisabledTestInterceptor;
import expo.modules.devlauncher.tests.DevLauncherTestInterceptor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.OkHttpClient;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.KoinApplicationKt;
import org.koin.dsl.ModuleDSLKt;

/* compiled from: DevLauncherKoinApp.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\t\u001a\u00020\n\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"DevLauncherBaseModule", "Lorg/koin/core/module/Module;", "getDevLauncherBaseModule", "()Lorg/koin/core/module/Module;", "DevLauncherTestModule", "getDevLauncherTestModule", "koinAppFactory", "Lkotlin/Function0;", "Lorg/koin/core/KoinApplication;", "devLauncherKoin", "Lorg/koin/core/Koin;", "expo-dev-launcher_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherKoinAppKt {
    private static final Module DevLauncherTestModule = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: expo.modules.devlauncher.koin.DevLauncherKoinAppKt$DevLauncherTestModule$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            invoke2(module);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, DevLauncherTestInterceptor>() { // from class: expo.modules.devlauncher.koin.DevLauncherKoinAppKt$DevLauncherTestModule$1.1
                @Override // kotlin.jvm.functions.Function2
                public final DevLauncherTestInterceptor invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new DevLauncherDisabledTestInterceptor();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DevLauncherTestInterceptor.class), null, anonymousClass1, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
            module.indexPrimaryType(singleInstanceFactory2);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory2);
        }
    }, 1, null);
    private static final Module DevLauncherBaseModule = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: expo.modules.devlauncher.koin.DevLauncherKoinAppKt$DevLauncherBaseModule$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            invoke2(module);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, DevLauncherIntentRegistryInterface>() { // from class: expo.modules.devlauncher.koin.DevLauncherKoinAppKt$DevLauncherBaseModule$1.1
                @Override // kotlin.jvm.functions.Function2
                public final DevLauncherIntentRegistryInterface invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new DevLauncherIntentRegistry();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DevLauncherIntentRegistryInterface.class), null, anonymousClass1, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
            module.indexPrimaryType(singleInstanceFactory2);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory2);
            AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, OkHttpClient>() { // from class: expo.modules.devlauncher.koin.DevLauncherKoinAppKt$DevLauncherBaseModule$1.2
                @Override // kotlin.jvm.functions.Function2
                public final OkHttpClient invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new OkHttpClient();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(OkHttpClient.class), null, anonymousClass2, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory4 = singleInstanceFactory3;
            module.indexPrimaryType(singleInstanceFactory4);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory3);
            }
            new KoinDefinition(module, singleInstanceFactory4);
            AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, DevLauncherLifecycle>() { // from class: expo.modules.devlauncher.koin.DevLauncherKoinAppKt$DevLauncherBaseModule$1.3
                @Override // kotlin.jvm.functions.Function2
                public final DevLauncherLifecycle invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new DevLauncherLifecycle();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory5 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DevLauncherLifecycle.class), null, anonymousClass3, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory6 = singleInstanceFactory5;
            module.indexPrimaryType(singleInstanceFactory6);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory5);
            }
            new KoinDefinition(module, singleInstanceFactory6);
            AnonymousClass4 anonymousClass4 = new Function2<Scope, ParametersHolder, DevLauncherInstallationIDHelper>() { // from class: expo.modules.devlauncher.koin.DevLauncherKoinAppKt$DevLauncherBaseModule$1.4
                @Override // kotlin.jvm.functions.Function2
                public final DevLauncherInstallationIDHelper invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new DevLauncherInstallationIDHelper();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory7 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DevLauncherInstallationIDHelper.class), null, anonymousClass4, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory8 = singleInstanceFactory7;
            module.indexPrimaryType(singleInstanceFactory8);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory7);
            }
            new KoinDefinition(module, singleInstanceFactory8);
            AnonymousClass5 anonymousClass5 = new Function2<Scope, ParametersHolder, DevLauncherAppLoaderFactoryInterface>() { // from class: expo.modules.devlauncher.koin.DevLauncherKoinAppKt$DevLauncherBaseModule$1.5
                @Override // kotlin.jvm.functions.Function2
                public final DevLauncherAppLoaderFactoryInterface invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new DevLauncherAppLoaderFactory();
                }
            };
            FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DevLauncherAppLoaderFactoryInterface.class), null, anonymousClass5, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory);
            new KoinDefinition(module, factoryInstanceFactory);
        }
    }, 1, null);
    private static final Function0<KoinApplication> koinAppFactory = new Function0<KoinApplication>() { // from class: expo.modules.devlauncher.koin.DevLauncherKoinAppKt$koinAppFactory$1
        @Override // kotlin.jvm.functions.Function0
        public final KoinApplication invoke() {
            return KoinApplicationKt.koinApplication(new Function1<KoinApplication, Unit>() { // from class: expo.modules.devlauncher.koin.DevLauncherKoinAppKt$koinAppFactory$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KoinApplication koinApplication) {
                    invoke2(koinApplication);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KoinApplication koinApplication) {
                    Intrinsics.checkNotNullParameter(koinApplication, "$this$koinApplication");
                    koinApplication.modules(DevLauncherKoinAppKt.getDevLauncherBaseModule(), DevLauncherKoinAppKt.getDevLauncherTestModule());
                }
            });
        }
    };

    public static final Module getDevLauncherTestModule() {
        return DevLauncherTestModule;
    }

    public static final Module getDevLauncherBaseModule() {
        return DevLauncherBaseModule;
    }

    public static final Koin devLauncherKoin() {
        return DevLauncherKoinContext.INSTANCE.getApp().getKoin();
    }
}
