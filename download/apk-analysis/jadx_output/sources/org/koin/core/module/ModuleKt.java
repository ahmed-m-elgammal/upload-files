package org.koin.core.module;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.SentryEvent;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;

/* compiled from: Module.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a[\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042)\b\b\u0010\u0005\u001a#\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00020\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0087\bø\u0001\u0000\u001aY\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0006\b\u0000\u0010\u0002\u0018\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042)\b\b\u0010\u0005\u001a#\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00020\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0087\bø\u0001\u0000\u001a[\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000f\"\u0006\b\u0000\u0010\u0002\u0018\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042)\b\b\u0010\u0005\u001a#\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00020\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0087\bø\u0001\u0000\u001a-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0086\u0010\u001a \u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001cH\u0001\u001a!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014*\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u001e\u001a\u00020\u0012H\u0086\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"_factoryInstanceFactory", "Lorg/koin/core/instance/FactoryInstanceFactory;", ExifInterface.GPS_DIRECTION_TRUE, "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "scopeQualifier", "_scopedInstanceFactory", "Lorg/koin/core/instance/ScopedInstanceFactory;", "_singleInstanceFactory", "Lorg/koin/core/instance/SingleInstanceFactory;", "flatten", "", "Lorg/koin/core/module/Module;", SentryEvent.JsonKeys.MODULES, "", "newModules", "overrideError", "", "factory", "Lorg/koin/core/instance/InstanceFactory;", "mapping", "", "Lorg/koin/core/definition/IndexKey;", "plus", "module", "koin-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ModuleKt {
    public static final void overrideError(InstanceFactory<?> factory, String mapping) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        throw new DefinitionOverrideException("Already existing definition for " + factory.getBeanDefinition() + " at " + mapping);
    }

    public static /* synthetic */ SingleInstanceFactory _singleInstanceFactory$default(Qualifier qualifier, Function2 definition, Qualifier qualifier2, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier3 = qualifier;
        if ((i & 4) != 0) {
            qualifier2 = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        }
        Qualifier scopeQualifier = qualifier2;
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new SingleInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier3, definition, kind, emptyList));
    }

    public static final /* synthetic */ <T> SingleInstanceFactory<T> _singleInstanceFactory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new SingleInstanceFactory<>(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, emptyList));
    }

    public static /* synthetic */ FactoryInstanceFactory _factoryInstanceFactory$default(Qualifier qualifier, Function2 definition, Qualifier qualifier2, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier3 = qualifier;
        if ((i & 4) != 0) {
            qualifier2 = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        }
        Qualifier scopeQualifier = qualifier2;
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier3, definition, kind, emptyList));
    }

    public static final /* synthetic */ <T> FactoryInstanceFactory<T> _factoryInstanceFactory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new FactoryInstanceFactory<>(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, emptyList));
    }

    public static /* synthetic */ ScopedInstanceFactory _scopedInstanceFactory$default(Qualifier qualifier, Function2 definition, Qualifier scopeQualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, emptyList));
    }

    public static final /* synthetic */ <T> ScopedInstanceFactory<T> _scopedInstanceFactory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new ScopedInstanceFactory<>(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, emptyList));
    }

    public static final List<Module> plus(List<Module> list, Module module) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        return CollectionsKt.plus((Collection) list, (Iterable) CollectionsKt.listOf(module));
    }

    public static /* synthetic */ Set flatten$default(List list, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        return flatten(list, set);
    }

    public static final Set<Module> flatten(List<Module> modules, Set<Module> newModules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Intrinsics.checkNotNullParameter(newModules, "newModules");
        while (!modules.isEmpty()) {
            Module module = (Module) CollectionsKt.first((List) modules);
            if (module == null) {
                throw new IllegalStateException("Flatten - No head element in list".toString());
            }
            modules = modules.subList(1, modules.size());
            if (module.getIncludedModules().isEmpty()) {
                newModules = SetsKt.plus(newModules, module);
            } else {
                modules = CollectionsKt.plus((Collection) module.getIncludedModules(), (Iterable) modules);
                newModules = SetsKt.plus(newModules, module);
            }
        }
        return newModules;
    }
}
