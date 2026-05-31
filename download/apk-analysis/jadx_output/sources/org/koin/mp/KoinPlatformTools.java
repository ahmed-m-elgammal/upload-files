package org.koin.mp;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.context.KoinContext;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.logger.PrintLogger;

/* compiled from: KoinPlatformTools.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fJ\u0012\u0010\u0010\u001a\u00020\f2\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013J\u001e\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00170\u0015\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u0017J+\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\n\u0010\u001a\u001a\u00060\u0001j\u0002`\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001d¢\u0006\u0002\u0010\u001e¨\u0006\u001f"}, d2 = {"Lorg/koin/mp/KoinPlatformTools;", "", "()V", "defaultContext", "Lorg/koin/core/context/KoinContext;", "defaultLazyMode", "Lkotlin/LazyThreadSafetyMode;", "defaultLogger", "Lorg/koin/core/logger/Logger;", "level", "Lorg/koin/core/logger/Level;", "generateId", "", "getClassName", "kClass", "Lkotlin/reflect/KClass;", "getStackTrace", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "safeHashMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "synchronized", "R", SentryStackFrame.JsonKeys.LOCK, "Lorg/koin/mp/Lockable;", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "koin-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class KoinPlatformTools {
    public static final KoinPlatformTools INSTANCE = new KoinPlatformTools();

    private KoinPlatformTools() {
    }

    public final String getStackTrace(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        StringBuilder sb = new StringBuilder();
        sb.append(e);
        sb.append(InstanceFactory.ERROR_SEPARATOR);
        StackTraceElement[] stackTrace = e.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "it.className");
            if (StringsKt.contains$default((CharSequence) className, (CharSequence) "sun.reflect", false, 2, (Object) null)) {
                break;
            }
            arrayList.add(stackTraceElement);
        }
        sb.append(CollectionsKt.joinToString$default(arrayList, InstanceFactory.ERROR_SEPARATOR, null, null, 0, null, null, 62, null));
        return sb.toString();
    }

    public final String getClassName(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        String name = JvmClassMappingKt.getJavaClass((KClass) kClass).getName();
        Intrinsics.checkNotNullExpressionValue(name, "kClass.java.name");
        return name;
    }

    public final String generateId() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    public final LazyThreadSafetyMode defaultLazyMode() {
        return LazyThreadSafetyMode.SYNCHRONIZED;
    }

    public final Logger defaultLogger(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        return new PrintLogger(level);
    }

    public final KoinContext defaultContext() {
        return GlobalContext.INSTANCE;
    }

    public static /* synthetic */ Logger defaultLogger$default(KoinPlatformTools koinPlatformTools, Level level, int i, Object obj) {
        if ((i & 1) != 0) {
            level = Level.INFO;
        }
        return koinPlatformTools.defaultLogger(level);
    }

    /* renamed from: synchronized, reason: not valid java name */
    public final <R> R m4379synchronized(Object lock, Function0<? extends R> block) {
        R invoke;
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (lock) {
            invoke = block.invoke();
        }
        return invoke;
    }

    public final <K, V> Map<K, V> safeHashMap() {
        return new ConcurrentHashMap();
    }
}
