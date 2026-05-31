package org.koin.core.registry;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.SentryEvent;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.instance.InstanceContext;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.module.ModuleKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: InstanceRegistry.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\r\u0010\u0019\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u001aJ\r\u0010\u001b\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u001cJ\u001a\u0010\u001d\u001a\u00020\u00162\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u001eH\u0002JH\u0010\u001f\u001a\u00020\u0016\"\u0006\b\u0000\u0010 \u0018\u00012\u0006\u0010!\u001a\u0002H 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\u0012\b\u0002\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0%2\b\b\u0002\u0010'\u001a\u00020(H\u0081\b¢\u0006\u0002\u0010)J\\\u0010*\u001a\u00020\u0016\"\u0006\b\u0000\u0010 \u0018\u00012\u0006\u0010!\u001a\u0002H 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\u0012\b\u0002\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0%2\b\b\u0002\u0010'\u001a\u00020(2\u0006\u0010+\u001a\u00020#2\n\u0010,\u001a\u00060\u0007j\u0002`-H\u0081\b¢\u0006\u0002\u0010.J\u0015\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b2J-\u00103\u001a\b\u0012\u0004\u0012\u0002H 0%\"\u0004\b\u0000\u0010 2\n\u00104\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7J\u0018\u00108\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0002J#\u00109\u001a\u00020\u00162\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00180;2\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b<J1\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\n\u00104\u001a\u0006\u0012\u0002\b\u00030&2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010+\u001a\u00020#H\u0000¢\u0006\u0002\b>J=\u0010?\u001a\u0004\u0018\u0001H \"\u0004\b\u0000\u0010 2\b\u0010\"\u001a\u0004\u0018\u00010#2\n\u00104\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u0010+\u001a\u00020#2\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0004\b@\u0010AJ2\u0010B\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\n\u0010C\u001a\u00060\u0007j\u0002`\b2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030\t2\b\b\u0002\u0010E\u001a\u00020(H\u0007J\u0006\u0010F\u001a\u00020\u000eJ\u0010\u0010G\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001b\u0010H\u001a\u00020\u00162\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00180;H\u0000¢\u0006\u0002\bIR\"\u0010\u0005\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR2\u0010\f\u001a&\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\rj\u0012\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u0011\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006J"}, d2 = {"Lorg/koin/core/registry/InstanceRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/Koin;)V", "_instances", "", "", "Lorg/koin/core/definition/IndexKey;", "Lorg/koin/core/instance/InstanceFactory;", "get_koin", "()Lorg/koin/core/Koin;", "eagerInstances", "Ljava/util/HashMap;", "", "Lorg/koin/core/instance/SingleInstanceFactory;", "Lkotlin/collections/HashMap;", "instances", "", "getInstances", "()Ljava/util/Map;", "addAllEagerInstances", "", "module", "Lorg/koin/core/module/Module;", "close", "close$koin_core", "createAllEagerInstances", "createAllEagerInstances$koin_core", "createEagerInstances", "", "declareRootInstance", ExifInterface.GPS_DIRECTION_TRUE, "instance", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "allowOverride", "", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "declareScopedInstance", "scopeQualifier", "scopeID", "Lorg/koin/core/scope/ScopeID;", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;ZLorg/koin/core/qualifier/Qualifier;Ljava/lang/String;)V", "dropScopeInstances", "scope", "Lorg/koin/core/scope/Scope;", "dropScopeInstances$koin_core", "getAll", "clazz", "instanceContext", "Lorg/koin/core/instance/InstanceContext;", "getAll$koin_core", "loadModule", "loadModules", SentryEvent.JsonKeys.MODULES, "", "loadModules$koin_core", "resolveDefinition", "resolveDefinition$koin_core", "resolveInstance", "resolveInstance$koin_core", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "saveMapping", "mapping", "factory", "logWarning", RRWebVideoEvent.JsonKeys.SIZE, "unloadModule", "unloadModules", "unloadModules$koin_core", "koin-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InstanceRegistry {
    private final Map<String, InstanceFactory<?>> _instances;
    private final Koin _koin;
    private final HashMap<Integer, SingleInstanceFactory<?>> eagerInstances;

    public InstanceRegistry(Koin _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this._koin = _koin;
        this._instances = KoinPlatformTools.INSTANCE.safeHashMap();
        this.eagerInstances = new HashMap<>();
    }

    public final Koin get_koin() {
        return this._koin;
    }

    public final Map<String, InstanceFactory<?>> getInstances() {
        return this._instances;
    }

    public final void loadModules$koin_core(Set<Module> modules, boolean allowOverride) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        for (Module module : modules) {
            loadModule(module, allowOverride);
            addAllEagerInstances(module);
        }
    }

    private final void addAllEagerInstances(Module module) {
        for (SingleInstanceFactory<?> singleInstanceFactory : module.getEagerInstances()) {
            this.eagerInstances.put(Integer.valueOf(singleInstanceFactory.hashCode()), singleInstanceFactory);
        }
    }

    public final void createAllEagerInstances$koin_core() {
        Collection<SingleInstanceFactory<?>> values = this.eagerInstances.values();
        Intrinsics.checkNotNullExpressionValue(values, "eagerInstances.values");
        createEagerInstances(values);
        this.eagerInstances.clear();
    }

    private final void loadModule(Module module, boolean allowOverride) {
        for (Map.Entry<String, InstanceFactory<?>> entry : module.getMappings().entrySet()) {
            saveMapping$default(this, allowOverride, entry.getKey(), entry.getValue(), false, 8, null);
        }
    }

    public static /* synthetic */ void saveMapping$default(InstanceRegistry instanceRegistry, boolean z, String str, InstanceFactory instanceFactory, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        instanceRegistry.saveMapping(z, str, instanceFactory, z2);
    }

    public final void saveMapping(boolean allowOverride, String mapping, InstanceFactory<?> factory, boolean logWarning) {
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (this._instances.containsKey(mapping)) {
            if (!allowOverride) {
                ModuleKt.overrideError(factory, mapping);
            } else if (logWarning) {
                Logger logger = this._koin.getLogger();
                String str = "(+) override index '" + mapping + "' -> '" + factory.getBeanDefinition() + '\'';
                Level level = Level.WARNING;
                if (logger.isAt(level)) {
                    logger.display(level, str);
                }
            }
        }
        Logger logger2 = this._koin.getLogger();
        String str2 = "(+) index '" + mapping + "' -> '" + factory.getBeanDefinition() + '\'';
        Level level2 = Level.DEBUG;
        if (logger2.isAt(level2)) {
            logger2.display(level2, str2);
        }
        this._instances.put(mapping, factory);
    }

    private final void createEagerInstances(Collection<? extends SingleInstanceFactory<?>> eagerInstances) {
        if (eagerInstances.isEmpty()) {
            return;
        }
        InstanceContext instanceContext = new InstanceContext(this._koin.getLogger(), this._koin.getScopeRegistry().getRootScope(), null, 4, null);
        Iterator<T> it = eagerInstances.iterator();
        while (it.hasNext()) {
            ((SingleInstanceFactory) it.next()).get(instanceContext);
        }
    }

    public final InstanceFactory<?> resolveDefinition$koin_core(KClass<?> clazz, Qualifier qualifier, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        return this._instances.get(BeanDefinitionKt.indexKey(clazz, qualifier, scopeQualifier));
    }

    public final <T> T resolveInstance$koin_core(Qualifier qualifier, KClass<?> clazz, Qualifier scopeQualifier, InstanceContext instanceContext) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(instanceContext, "instanceContext");
        InstanceFactory<?> resolveDefinition$koin_core = resolveDefinition$koin_core(clazz, qualifier, scopeQualifier);
        Object obj = resolveDefinition$koin_core != null ? resolveDefinition$koin_core.get(instanceContext) : null;
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }

    public static /* synthetic */ void declareScopedInstance$default(InstanceRegistry instanceRegistry, Object obj, Qualifier qualifier, List list, boolean z, Qualifier scopeQualifier, String scopeID, int i, Object obj2) {
        Qualifier qualifier2 = (i & 2) != 0 ? null : qualifier;
        List secondaryTypes = (i & 4) != 0 ? CollectionsKt.emptyList() : list;
        boolean z2 = (i & 8) != 0 ? true : z;
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(scopeID, "scopeID");
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        InstanceRegistry$declareScopedInstance$def$1 instanceRegistry$declareScopedInstance$def$1 = new InstanceRegistry$declareScopedInstance$def$1(obj);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, instanceRegistry$declareScopedInstance$def$1, kind, secondaryTypes);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier());
        InstanceFactory<?> instanceFactory = instanceRegistry.getInstances().get(indexKey);
        ScopedInstanceFactory scopedInstanceFactory = instanceFactory instanceof ScopedInstanceFactory ? (ScopedInstanceFactory) instanceFactory : null;
        if (scopedInstanceFactory != null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            scopedInstanceFactory.refreshInstance(scopeID, obj);
            return;
        }
        ScopedInstanceFactory scopedInstanceFactory2 = new ScopedInstanceFactory(beanDefinition);
        saveMapping$default(instanceRegistry, z2, indexKey, scopedInstanceFactory2, false, 8, null);
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            saveMapping$default(instanceRegistry, z2, BeanDefinitionKt.indexKey((KClass) it.next(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), scopedInstanceFactory2, false, 8, null);
        }
    }

    public final /* synthetic */ <T> void declareScopedInstance(T instance, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean allowOverride, Qualifier scopeQualifier, String scopeID) {
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(scopeID, "scopeID");
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        InstanceRegistry$declareScopedInstance$def$1 instanceRegistry$declareScopedInstance$def$1 = new InstanceRegistry$declareScopedInstance$def$1(instance);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, instanceRegistry$declareScopedInstance$def$1, kind, secondaryTypes);
        String indexKey = BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier());
        InstanceFactory<?> instanceFactory = getInstances().get(indexKey);
        ScopedInstanceFactory scopedInstanceFactory = instanceFactory instanceof ScopedInstanceFactory ? (ScopedInstanceFactory) instanceFactory : null;
        if (scopedInstanceFactory != null) {
            Intrinsics.checkNotNull(instance, "null cannot be cast to non-null type kotlin.Any");
            scopedInstanceFactory.refreshInstance(scopeID, instance);
            return;
        }
        ScopedInstanceFactory scopedInstanceFactory2 = new ScopedInstanceFactory(beanDefinition);
        saveMapping$default(this, allowOverride, indexKey, scopedInstanceFactory2, false, 8, null);
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            saveMapping$default(this, allowOverride, BeanDefinitionKt.indexKey((KClass) it.next(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), scopedInstanceFactory2, false, 8, null);
        }
    }

    public static /* synthetic */ void declareRootInstance$default(InstanceRegistry instanceRegistry, Object obj, Qualifier qualifier, List list, boolean z, int i, Object obj2) {
        Qualifier qualifier2 = (i & 2) != 0 ? null : qualifier;
        List secondaryTypes = (i & 4) != 0 ? CollectionsKt.emptyList() : list;
        boolean z2 = (i & 8) != 0 ? true : z;
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Qualifier scopeQualifier = instanceRegistry.get_koin().getScopeRegistry().getRootScope().getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        InstanceRegistry$declareRootInstance$def$1 instanceRegistry$declareRootInstance$def$1 = new InstanceRegistry$declareRootInstance$def$1(obj);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, instanceRegistry$declareRootInstance$def$1, kind, secondaryTypes);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        saveMapping$default(instanceRegistry, z2, BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), singleInstanceFactory, false, 8, null);
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            saveMapping$default(instanceRegistry, z2, BeanDefinitionKt.indexKey((KClass) it.next(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), singleInstanceFactory, false, 8, null);
        }
    }

    public final /* synthetic */ <T> void declareRootInstance(T instance, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean allowOverride) {
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Qualifier scopeQualifier = get_koin().getScopeRegistry().getRootScope().getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        InstanceRegistry$declareRootInstance$def$1 instanceRegistry$declareRootInstance$def$1 = new InstanceRegistry$declareRootInstance$def$1(instance);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, instanceRegistry$declareRootInstance$def$1, kind, secondaryTypes);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        saveMapping$default(this, allowOverride, BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), singleInstanceFactory, false, 8, null);
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            saveMapping$default(this, allowOverride, BeanDefinitionKt.indexKey((KClass) it.next(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), singleInstanceFactory, false, 8, null);
        }
    }

    public final void dropScopeInstances$koin_core(Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Collection<InstanceFactory<?>> values = this._instances.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (obj instanceof ScopedInstanceFactory) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ScopedInstanceFactory) it.next()).drop(scope);
        }
    }

    public final void close$koin_core() {
        for (Map.Entry<String, InstanceFactory<?>> entry : this._instances.entrySet()) {
            entry.getKey();
            entry.getValue().dropAll();
        }
        this._instances.clear();
    }

    public final <T> List<T> getAll$koin_core(KClass<?> clazz, InstanceContext instanceContext) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(instanceContext, "instanceContext");
        Collection<InstanceFactory<?>> values = this._instances.values();
        ArrayList arrayList = new ArrayList();
        for (T t : values) {
            if (Intrinsics.areEqual(((InstanceFactory) t).getBeanDefinition().getScopeQualifier(), instanceContext.getScope().getScopeQualifier())) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : arrayList) {
            InstanceFactory instanceFactory = (InstanceFactory) t2;
            if (Intrinsics.areEqual(instanceFactory.getBeanDefinition().getPrimaryType(), clazz) || instanceFactory.getBeanDefinition().getSecondaryTypes().contains(clazz)) {
                arrayList2.add(t2);
            }
        }
        List distinct = CollectionsKt.distinct(arrayList2);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(distinct, 10));
        Iterator<T> it = distinct.iterator();
        while (it.hasNext()) {
            arrayList3.add(((InstanceFactory) it.next()).get(instanceContext));
        }
        return arrayList3;
    }

    public final void unloadModules$koin_core(Set<Module> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Iterator<T> it = modules.iterator();
        while (it.hasNext()) {
            unloadModule((Module) it.next());
        }
    }

    private final void unloadModule(Module module) {
        Set<String> keySet = module.getMappings().keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "module.mappings.keys");
        for (String str : keySet) {
            if (this._instances.containsKey(str)) {
                InstanceFactory<?> instanceFactory = this._instances.get(str);
                if (instanceFactory != null) {
                    instanceFactory.dropAll();
                }
                this._instances.remove(str);
            }
        }
    }

    public final int size() {
        return this._instances.size();
    }
}
