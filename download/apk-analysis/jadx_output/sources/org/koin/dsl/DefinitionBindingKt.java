package org.koin.dsl;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Callbacks;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.module.OptionDslMarker;

/* compiled from: DefinitionBinding.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001H\u0087\b\u001a5\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\u0004\u001a,\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u00012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\bH\u0087\u0004¢\u0006\u0002\u0010\t\u001a?\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00012\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u0002H\u000b`\u000eH\u0087\u0004¨\u0006\u000f"}, d2 = {"bind", "Lorg/koin/core/definition/KoinDefinition;", ExifInterface.LATITUDE_SOUTH, "", "clazz", "Lkotlin/reflect/KClass;", "binds", "classes", "", "(Lorg/koin/core/definition/KoinDefinition;[Lkotlin/reflect/KClass;)Lorg/koin/core/definition/KoinDefinition;", "onClose", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "", "Lorg/koin/core/definition/OnCloseCallback;", "koin-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DefinitionBindingKt {
    @OptionDslMarker
    public static final <S> KoinDefinition<? extends S> bind(KoinDefinition<? extends S> koinDefinition, KClass<S> clazz) {
        Intrinsics.checkNotNullParameter(koinDefinition, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        koinDefinition.getFactory().getBeanDefinition().setSecondaryTypes(CollectionsKt.plus((Collection<? extends KClass<S>>) koinDefinition.getFactory().getBeanDefinition().getSecondaryTypes(), clazz));
        koinDefinition.getModule().saveMapping(BeanDefinitionKt.indexKey(clazz, koinDefinition.getFactory().getBeanDefinition().getQualifier(), koinDefinition.getFactory().getBeanDefinition().getScopeQualifier()), koinDefinition.getFactory());
        return koinDefinition;
    }

    @OptionDslMarker
    public static final /* synthetic */ <S> KoinDefinition<? extends S> bind(KoinDefinition<? extends S> koinDefinition) {
        Intrinsics.checkNotNullParameter(koinDefinition, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        bind(koinDefinition, Reflection.getOrCreateKotlinClass(Object.class));
        return koinDefinition;
    }

    @OptionDslMarker
    public static final KoinDefinition<?> binds(KoinDefinition<?> koinDefinition, KClass<?>[] classes) {
        Intrinsics.checkNotNullParameter(koinDefinition, "<this>");
        Intrinsics.checkNotNullParameter(classes, "classes");
        BeanDefinition<?> beanDefinition = koinDefinition.getFactory().getBeanDefinition();
        beanDefinition.setSecondaryTypes(CollectionsKt.plus((Collection) beanDefinition.getSecondaryTypes(), (Object[]) classes));
        for (KClass<?> kClass : classes) {
            koinDefinition.getModule().saveMapping(BeanDefinitionKt.indexKey(kClass, koinDefinition.getFactory().getBeanDefinition().getQualifier(), koinDefinition.getFactory().getBeanDefinition().getScopeQualifier()), koinDefinition.getFactory());
        }
        return koinDefinition;
    }

    @OptionDslMarker
    public static final <T> KoinDefinition<T> onClose(KoinDefinition<T> koinDefinition, Function1<? super T, Unit> onClose) {
        Intrinsics.checkNotNullParameter(koinDefinition, "<this>");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        koinDefinition.getFactory().getBeanDefinition().setCallbacks(new Callbacks<>(onClose));
        return koinDefinition;
    }
}
