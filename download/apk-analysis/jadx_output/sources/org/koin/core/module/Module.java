package org.koin.core.module;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.SentryEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ScopeDSL;
import org.koin.mp.KoinPlatformTools;

/* compiled from: Module.kt */
@KoinDslMarker
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002JQ\u0010*\u001a\b\u0012\u0004\u0012\u0002H,0+\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010%2)\b\b\u0010.\u001a#\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002H,0/j\b\u0012\u0004\u0012\u0002H,`2¢\u0006\u0002\b3H\u0086\bø\u0001\u0000JY\u0010*\u001a\b\u0012\u0004\u0012\u0002H,0+\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010%2)\b\b\u0010.\u001a#\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002H,0/j\b\u0012\u0004\u0012\u0002H,`2¢\u0006\u0002\b32\u0006\u00104\u001a\u00020%H\u0081\bø\u0001\u0000J\b\u00105\u001a\u000206H\u0016J\u001f\u00107\u001a\u0002082\u0012\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000:\"\u00020\u0000¢\u0006\u0002\u0010;J\u0014\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00000<J\u0014\u0010=\u001a\u0002082\n\u0010>\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0007J\u0014\u0010?\u001a\u0002082\n\u0010>\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0007J\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00000<2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00000<H\u0086\u0002J\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00000<2\u0006\u00109\u001a\u00020\u0000H\u0086\u0002J\u0014\u0010B\u001a\u0002082\n\u0010>\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0007J \u0010C\u001a\u0002082\n\u0010D\u001a\u00060\u0013j\u0002`\u001e2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0001J)\u0010E\u001a\u0002082\u0006\u0010-\u001a\u00020%2\u0017\u0010F\u001a\u0013\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u0002080G¢\u0006\u0002\b3H\u0007J-\u0010E\u001a\u000208\"\u0006\b\u0000\u0010,\u0018\u00012\u0017\u0010F\u001a\u0013\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u0002080G¢\u0006\u0002\b3H\u0087\bø\u0001\u0000J[\u0010I\u001a\b\u0012\u0004\u0012\u0002H,0+\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010J\u001a\u00020\u00032)\b\b\u0010.\u001a#\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002H,0/j\b\u0012\u0004\u0012\u0002H,`2¢\u0006\u0002\b3H\u0086\bø\u0001\u0000R\u001c\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bRT\u0010\r\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b`\f2\u001e\u0010\t\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b`\f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\bRH\u0010\u001c\u001a.\u0012\b\u0012\u00060\u0013j\u0002`\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001dj\u0016\u0012\b\u0012\u00060\u0013j\u0002`\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f` 8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010#R,\u0010$\u001a\u0012\u0012\u0004\u0012\u00020%0\nj\b\u0012\u0004\u0012\u00020%`\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006K"}, d2 = {"Lorg/koin/core/module/Module;", "", "_createdAtStart", "", "(Z)V", "get_createdAtStart$annotations", "()V", "get_createdAtStart", "()Z", "<set-?>", "Ljava/util/HashSet;", "Lorg/koin/core/instance/SingleInstanceFactory;", "Lkotlin/collections/HashSet;", "eagerInstances", "getEagerInstances", "()Ljava/util/HashSet;", "setEagerInstances$koin_core", "(Ljava/util/HashSet;)V", "id", "", "getId", "()Ljava/lang/String;", "includedModules", "", "getIncludedModules$annotations", "getIncludedModules", "()Ljava/util/List;", "isLoaded", "mappings", "Ljava/util/HashMap;", "Lorg/koin/core/definition/IndexKey;", "Lorg/koin/core/instance/InstanceFactory;", "Lkotlin/collections/HashMap;", "getMappings$annotations", "getMappings", "()Ljava/util/HashMap;", "scopes", "Lorg/koin/core/qualifier/Qualifier;", "getScopes$annotations", "getScopes", "equals", "other", "factory", "Lorg/koin/core/definition/KoinDefinition;", ExifInterface.GPS_DIRECTION_TRUE, "qualifier", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "scopeQualifier", "hashCode", "", "includes", "", "module", "", "([Lorg/koin/core/module/Module;)V", "", "indexPrimaryType", "instanceFactory", "indexSecondaryTypes", "plus", SentryEvent.JsonKeys.MODULES, "prepareForCreationAtStart", "saveMapping", "mapping", "scope", "scopeSet", "Lkotlin/Function1;", "Lorg/koin/dsl/ScopeDSL;", "single", "createdAtStart", "koin-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class Module {
    private final boolean _createdAtStart;
    private HashSet<SingleInstanceFactory<?>> eagerInstances;
    private final String id;
    private final List<Module> includedModules;
    private final HashMap<String, InstanceFactory<?>> mappings;
    private final HashSet<Qualifier> scopes;

    public Module() {
        this(false, 1, null);
    }

    public static /* synthetic */ void getIncludedModules$annotations() {
    }

    public static /* synthetic */ void getMappings$annotations() {
    }

    public static /* synthetic */ void getScopes$annotations() {
    }

    public static /* synthetic */ void get_createdAtStart$annotations() {
    }

    public Module(boolean z) {
        this._createdAtStart = z;
        this.id = KoinPlatformTools.INSTANCE.generateId();
        this.eagerInstances = new HashSet<>();
        this.mappings = new HashMap<>();
        this.scopes = new HashSet<>();
        this.includedModules = new ArrayList();
    }

    public /* synthetic */ Module(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean get_createdAtStart() {
        return this._createdAtStart;
    }

    public final String getId() {
        return this.id;
    }

    public final HashSet<SingleInstanceFactory<?>> getEagerInstances() {
        return this.eagerInstances;
    }

    public final void setEagerInstances$koin_core(HashSet<SingleInstanceFactory<?>> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.eagerInstances = hashSet;
    }

    public final HashMap<String, InstanceFactory<?>> getMappings() {
        return this.mappings;
    }

    public final boolean isLoaded() {
        return this.mappings.size() > 0;
    }

    public final HashSet<Qualifier> getScopes() {
        return this.scopes;
    }

    public final List<Module> getIncludedModules() {
        return this.includedModules;
    }

    public final void includes(Module... module) {
        Intrinsics.checkNotNullParameter(module, "module");
        CollectionsKt.addAll(this.includedModules, module);
    }

    public final void includes(List<Module> module) {
        Intrinsics.checkNotNullParameter(module, "module");
        CollectionsKt.addAll(this.includedModules, module);
    }

    @KoinDslMarker
    public final void scope(Qualifier qualifier, Function1<? super ScopeDSL, Unit> scopeSet) {
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Intrinsics.checkNotNullParameter(scopeSet, "scopeSet");
        scopeSet.invoke(new ScopeDSL(qualifier, this));
        this.scopes.add(qualifier);
    }

    @KoinDslMarker
    public final /* synthetic */ <T> void scope(Function1<? super ScopeDSL, Unit> scopeSet) {
        Intrinsics.checkNotNullParameter(scopeSet, "scopeSet");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        scopeSet.invoke(new ScopeDSL(typeQualifier, this));
        getScopes().add(typeQualifier);
    }

    public static /* synthetic */ KoinDefinition single$default(Module module, Qualifier qualifier, boolean z, Function2 definition, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, definition, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (z || module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return new KoinDefinition(module, singleInstanceFactory2);
    }

    public final void indexPrimaryType(InstanceFactory<?> instanceFactory) {
        Intrinsics.checkNotNullParameter(instanceFactory, "instanceFactory");
        BeanDefinition<?> beanDefinition = instanceFactory.getBeanDefinition();
        saveMapping(BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), instanceFactory);
    }

    public final void indexSecondaryTypes(InstanceFactory<?> instanceFactory) {
        Intrinsics.checkNotNullParameter(instanceFactory, "instanceFactory");
        BeanDefinition<?> beanDefinition = instanceFactory.getBeanDefinition();
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            saveMapping(BeanDefinitionKt.indexKey((KClass) it.next(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), instanceFactory);
        }
    }

    public final void prepareForCreationAtStart(SingleInstanceFactory<?> instanceFactory) {
        Intrinsics.checkNotNullParameter(instanceFactory, "instanceFactory");
        this.eagerInstances.add(instanceFactory);
    }

    public final void saveMapping(String mapping, InstanceFactory<?> factory) {
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.mappings.put(mapping, factory);
    }

    public static /* synthetic */ KoinDefinition factory$default(Module module, Qualifier qualifier, Function2 definition, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition(module, factoryInstanceFactory);
    }

    public final /* synthetic */ <T> KoinDefinition<T> factory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, emptyList));
        indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition<>(this, factoryInstanceFactory);
    }

    public static /* synthetic */ KoinDefinition factory$default(Module module, Qualifier qualifier, Function2 definition, Qualifier scopeQualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition(module, factoryInstanceFactory);
    }

    public final List<Module> plus(Module module) {
        Intrinsics.checkNotNullParameter(module, "module");
        return CollectionsKt.listOf((Object[]) new Module[]{this, module});
    }

    public final List<Module> plus(List<Module> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this), (Iterable) modules);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other != null && getClass() == other.getClass() && Intrinsics.areEqual(this.id, ((Module) other).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public final /* synthetic */ <T> KoinDefinition<T> single(Qualifier qualifier, boolean createdAtStart, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        indexPrimaryType(singleInstanceFactory2);
        if (createdAtStart || get_createdAtStart()) {
            prepareForCreationAtStart(singleInstanceFactory);
        }
        return new KoinDefinition<>(this, singleInstanceFactory2);
    }

    public final /* synthetic */ <T> KoinDefinition<T> factory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, emptyList));
        indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition<>(this, factoryInstanceFactory);
    }
}
