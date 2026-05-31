package org.koin.core.instance;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.annotation.KoinReflectAPI;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;
import org.koin.mp.KoinPlatformTimeTools;

/* compiled from: InstanceBuilder.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0006\u001a/\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\f\u001a1\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u0001*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0012\u001a(\u0010\r\u001a\u0002H\u000e\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u0001*\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\u0087\b¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"createInstance", "", "args", "", "constructor", "Ljava/lang/reflect/Constructor;", "([Ljava/lang/Object;Ljava/lang/reflect/Constructor;)Ljava/lang/Object;", "getArguments", "scope", "Lorg/koin/core/scope/Scope;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "(Ljava/lang/reflect/Constructor;Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)[Ljava/lang/Object;", "newInstance", ExifInterface.GPS_DIRECTION_TRUE, "kClass", "Lkotlin/reflect/KClass;", "params", "(Lorg/koin/core/scope/Scope;Lkotlin/reflect/KClass;Lorg/koin/core/parameter/ParametersHolder;)Ljava/lang/Object;", "defParams", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Ljava/lang/Object;", "koin-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InstanceBuilderKt {
    public static /* synthetic */ Object newInstance$default(Scope scope, ParametersHolder defParams, int i, Object obj) {
        if ((i & 1) != 0) {
            defParams = ParametersHolderKt.emptyParametersHolder();
        }
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(defParams, "defParams");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return newInstance(scope, Reflection.getOrCreateKotlinClass(Object.class), defParams);
    }

    @Deprecated(message = "Koin Reflection API is deprecated")
    @KoinReflectAPI
    public static final /* synthetic */ <T> T newInstance(Scope scope, ParametersHolder defParams) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(defParams, "defParams");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) newInstance(scope, Reflection.getOrCreateKotlinClass(Object.class), defParams);
    }

    @Deprecated(message = "Koin Reflection API is deprecated")
    @KoinReflectAPI
    public static final <T> T newInstance(Scope scope, KClass<T> kClass, ParametersHolder params) {
        Object[] arguments;
        T t;
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(params, "params");
        if (scope.getLogger().getLevel() == Level.DEBUG) {
            Logger logger = scope.getLogger();
            String str = "|- creating new instance - " + KClassExtKt.getFullName(kClass);
            Level level = Level.DEBUG;
            if (logger.isAt(level)) {
                logger.display(level, str);
            }
        }
        Constructor<?>[] constructors = JvmClassMappingKt.getJavaClass((KClass) kClass).getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "kClass.java.constructors");
        Constructor constructor = (Constructor) ArraysKt.firstOrNull(constructors);
        if (constructor == null) {
            throw new IllegalStateException(("No constructor found for class '" + KClassExtKt.getFullName(kClass) + '\'').toString());
        }
        if (scope.getLogger().getLevel() != Level.DEBUG) {
            arguments = getArguments(constructor, scope, params);
        } else {
            Pair pair = new Pair(getArguments(constructor, scope, params), Double.valueOf((KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds() - KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds()) / 1000000.0d));
            Pair pair2 = new Pair(pair.component1(), Double.valueOf(((Number) pair.component2()).doubleValue()));
            arguments = (Object[]) pair2.component1();
            double doubleValue = ((Number) pair2.component2()).doubleValue();
            Logger logger2 = scope.getLogger();
            String str2 = "|- got arguments in " + doubleValue + " ms";
            Level level2 = Level.DEBUG;
            if (logger2.isAt(level2)) {
                logger2.display(level2, str2);
            }
        }
        if (scope.getLogger().getLevel() != Level.DEBUG) {
            t = (T) createInstance(arguments, constructor);
        } else {
            Pair pair3 = new Pair(createInstance(arguments, constructor), Double.valueOf((KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds() - KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds()) / 1000000.0d));
            Pair pair4 = new Pair(pair3.component1(), Double.valueOf(((Number) pair3.component2()).doubleValue()));
            t = (T) pair4.component1();
            double doubleValue2 = ((Number) pair4.component2()).doubleValue();
            Logger logger3 = scope.getLogger();
            String str3 = "|- created instance in " + doubleValue2 + " ms";
            Level level3 = Level.DEBUG;
            if (logger3.isAt(level3)) {
                logger3.display(level3, str3);
            }
        }
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of org.koin.core.instance.InstanceBuilderKt.newInstance");
        return t;
    }

    private static final Object createInstance(Object[] objArr, Constructor<? extends Object> constructor) {
        Object newInstance;
        if (objArr.length == 0) {
            newInstance = constructor.newInstance(null);
        } else {
            newInstance = constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        }
        Intrinsics.checkNotNullExpressionValue(newInstance, "if (args.isEmpty()) {\n  ….newInstance(*args)\n    }");
        return newInstance;
    }

    private static final Object[] getArguments(Constructor<?> constructor, Scope scope, final ParametersHolder parametersHolder) {
        int length = constructor.getParameterTypes().length;
        if (length != 0) {
            Object[] objArr = new Object[length];
            for (int i = 0; i < length; i++) {
                objArr[i] = Unit.INSTANCE;
            }
            for (int i2 = 0; i2 < length; i2++) {
                Class<?> p = constructor.getParameterTypes()[i2];
                Intrinsics.checkNotNullExpressionValue(p, "p");
                KClass<?> kotlinClass = JvmClassMappingKt.getKotlinClass(p);
                Object orNull = scope.getOrNull(kotlinClass, null, new Function0<ParametersHolder>() { // from class: org.koin.core.instance.InstanceBuilderKt$getArguments$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final ParametersHolder invoke() {
                        return ParametersHolder.this;
                    }
                });
                if (orNull == null && (orNull = parametersHolder.getOrNull(kotlinClass)) == null) {
                    throw new NoBeanDefFoundException("No definition found for class '" + kotlinClass + '\'');
                }
                objArr[i2] = orNull;
            }
            return objArr;
        }
        return new Object[0];
    }
}
