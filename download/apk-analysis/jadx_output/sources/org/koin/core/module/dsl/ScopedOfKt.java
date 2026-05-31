package org.koin.core.module.dsl;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.qualifier.Qualifier;
import org.koin.dsl.ScopeDSL;

/* compiled from: ScopedOf.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a]\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001ak\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001*\u00020\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00020\u00072-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001ay\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001*\u00020\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020\u000e2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0087\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001*\u00020\u00032 \b\u0004\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00020\u00102-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0095\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001*\u00020\u00032&\b\u0004\u0010\u0004\u001a \u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00020\u00122-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a£\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001*\u00020\u00032,\b\u0004\u0010\u0004\u001a&\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00020\u00142-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a±\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001*\u00020\u000322\b\u0004\u0010\u0004\u001a,\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00020\u00162-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a¿\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001*\u00020\u000328\b\u0004\u0010\u0004\u001a2\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00020\u00182-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aÍ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001*\u00020\u00032>\b\u0004\u0010\u0004\u001a8\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00020\u001a2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aÛ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001*\u00020\u00032D\b\u0004\u0010\u0004\u001a>\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u00020\u001c2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aé\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001*\u00020\u00032J\b\u0004\u0010\u0004\u001aD\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u00020\u001e2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aÏ\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032P\b\u0004\u0010\u0004\u001aJ\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\u00020+2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aÕ\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032V\b\u0004\u0010\u0004\u001aP\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\u00020,2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aÛ\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032\\\b\u0004\u0010\u0004\u001aV\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\u00020-2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aá\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032b\b\u0004\u0010\u0004\u001a\\\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H\u00020.2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aç\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032h\b\u0004\u0010\u0004\u001ab\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H\u00020/2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aí\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032n\b\u0004\u0010\u0004\u001ah\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H\u0002002-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aó\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032t\b\u0004\u0010\u0004\u001an\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H\u0002012-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aù\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032z\b\u0004\u0010\u0004\u001at\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H\u0002022-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0080\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032\u0080\u0001\b\u0004\u0010\u0004\u001az\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H\u0002032-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0087\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032\u0087\u0001\b\u0004\u0010\u0004\u001a\u0080\u0001\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H\u0002042-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u008d\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032\u008d\u0001\b\u0004\u0010\u0004\u001a\u0086\u0001\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H\u0002052-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0093\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010 \u0018\u0001\"\u0006\b\r\u0010!\u0018\u0001\"\u0006\b\u000e\u0010\"\u0018\u0001\"\u0006\b\u000f\u0010#\u0018\u0001\"\u0006\b\u0010\u0010$\u0018\u0001\"\u0006\b\u0011\u0010%\u0018\u0001\"\u0006\b\u0012\u0010&\u0018\u0001\"\u0006\b\u0013\u0010'\u0018\u0001\"\u0006\b\u0014\u0010(\u0018\u0001\"\u0006\b\u0015\u0010)\u0018\u0001\"\u0006\b\u0016\u0010*\u0018\u0001*\u00020\u00032\u0093\u0001\b\u0004\u0010\u0004\u001a\u008c\u0001\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H\u0002062-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, d2 = {"scopedOf", "Lorg/koin/core/definition/KoinDefinition;", "R", "Lorg/koin/dsl/ScopeDSL;", "constructor", "Lkotlin/Function0;", "options", "Lkotlin/Function1;", "Lorg/koin/core/definition/BeanDefinition;", "", "Lorg/koin/core/module/dsl/DefinitionOptions;", "Lkotlin/ExtensionFunctionType;", "T1", "T2", "Lkotlin/Function2;", "T3", "Lkotlin/Function3;", "T4", "Lkotlin/Function4;", "T5", "Lkotlin/Function5;", "T6", "Lkotlin/Function6;", "T7", "Lkotlin/Function7;", "T8", "Lkotlin/Function8;", "T9", "Lkotlin/Function9;", "T10", "Lkotlin/Function10;", "T11", "T12", "T13", "T14", "T15", "T16", "T17", "T18", "T19", "T20", "T21", "T22", "Lkotlin/Function11;", "Lkotlin/Function12;", "Lkotlin/Function13;", "Lkotlin/Function14;", "Lkotlin/Function15;", "Lkotlin/Function16;", "Lkotlin/Function17;", "Lkotlin/Function18;", "Lkotlin/Function19;", "Lkotlin/Function20;", "Lkotlin/Function21;", "Lkotlin/Function22;", "koin-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ScopedOfKt {
    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function0 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$1 scopedOfKt$scopedOf$1 = new ScopedOfKt$scopedOf$1(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$1, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function0<? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$1 scopedOfKt$scopedOf$1 = new ScopedOfKt$scopedOf$1(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$1, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function1 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$2 scopedOfKt$scopedOf$2 = new ScopedOfKt$scopedOf$2(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$2, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function1<? super T1, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$2 scopedOfKt$scopedOf$2 = new ScopedOfKt$scopedOf$2(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$2, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function2 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$3 scopedOfKt$scopedOf$3 = new ScopedOfKt$scopedOf$3(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$3, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function2<? super T1, ? super T2, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$3 scopedOfKt$scopedOf$3 = new ScopedOfKt$scopedOf$3(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$3, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function3 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$4 scopedOfKt$scopedOf$4 = new ScopedOfKt$scopedOf$4(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$4, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function3<? super T1, ? super T2, ? super T3, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$4 scopedOfKt$scopedOf$4 = new ScopedOfKt$scopedOf$4(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$4, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function4 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$5 scopedOfKt$scopedOf$5 = new ScopedOfKt$scopedOf$5(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$5, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$5 scopedOfKt$scopedOf$5 = new ScopedOfKt$scopedOf$5(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$5, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function5 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$6 scopedOfKt$scopedOf$6 = new ScopedOfKt$scopedOf$6(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$6, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$6 scopedOfKt$scopedOf$6 = new ScopedOfKt$scopedOf$6(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$6, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function6 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$7 scopedOfKt$scopedOf$7 = new ScopedOfKt$scopedOf$7(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$7, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$7 scopedOfKt$scopedOf$7 = new ScopedOfKt$scopedOf$7(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$7, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function7 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$8 scopedOfKt$scopedOf$8 = new ScopedOfKt$scopedOf$8(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$8, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$8 scopedOfKt$scopedOf$8 = new ScopedOfKt$scopedOf$8(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$8, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function8 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$9 scopedOfKt$scopedOf$9 = new ScopedOfKt$scopedOf$9(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$9, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$9 scopedOfKt$scopedOf$9 = new ScopedOfKt$scopedOf$9(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$9, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function9 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$10 scopedOfKt$scopedOf$10 = new ScopedOfKt$scopedOf$10(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$10, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$10 scopedOfKt$scopedOf$10 = new ScopedOfKt$scopedOf$10(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$10, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function10 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$11 scopedOfKt$scopedOf$11 = new ScopedOfKt$scopedOf$11(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$11, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$11 scopedOfKt$scopedOf$11 = new ScopedOfKt$scopedOf$11(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$11, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function11 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$12 scopedOfKt$scopedOf$12 = new ScopedOfKt$scopedOf$12(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$12, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$12 scopedOfKt$scopedOf$12 = new ScopedOfKt$scopedOf$12(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$12, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function12 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$13 scopedOfKt$scopedOf$13 = new ScopedOfKt$scopedOf$13(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$13, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$13 scopedOfKt$scopedOf$13 = new ScopedOfKt$scopedOf$13(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$13, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function13 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$14 scopedOfKt$scopedOf$14 = new ScopedOfKt$scopedOf$14(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$14, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$14 scopedOfKt$scopedOf$14 = new ScopedOfKt$scopedOf$14(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$14, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function14 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$15 scopedOfKt$scopedOf$15 = new ScopedOfKt$scopedOf$15(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$15, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$15 scopedOfKt$scopedOf$15 = new ScopedOfKt$scopedOf$15(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$15, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function15 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$16 scopedOfKt$scopedOf$16 = new ScopedOfKt$scopedOf$16(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$16, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$16 scopedOfKt$scopedOf$16 = new ScopedOfKt$scopedOf$16(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$16, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function16 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$17 scopedOfKt$scopedOf$17 = new ScopedOfKt$scopedOf$17(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$17, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$17 scopedOfKt$scopedOf$17 = new ScopedOfKt$scopedOf$17(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$17, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function17 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$18 scopedOfKt$scopedOf$18 = new ScopedOfKt$scopedOf$18(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$18, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$18 scopedOfKt$scopedOf$18 = new ScopedOfKt$scopedOf$18(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$18, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function18 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$19 scopedOfKt$scopedOf$19 = new ScopedOfKt$scopedOf$19(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$19, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$19 scopedOfKt$scopedOf$19 = new ScopedOfKt$scopedOf$19(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$19, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function19 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$20 scopedOfKt$scopedOf$20 = new ScopedOfKt$scopedOf$20(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$20, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$20 scopedOfKt$scopedOf$20 = new ScopedOfKt$scopedOf$20(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$20, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function20 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$21 scopedOfKt$scopedOf$21 = new ScopedOfKt$scopedOf$21(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$21, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$21 scopedOfKt$scopedOf$21 = new ScopedOfKt$scopedOf$21(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$21, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function21 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$22 scopedOfKt$scopedOf$22 = new ScopedOfKt$scopedOf$22(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$22, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$22 scopedOfKt$scopedOf$22 = new ScopedOfKt$scopedOf$22(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$22, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function22 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$23 scopedOfKt$scopedOf$23 = new ScopedOfKt$scopedOf$23(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$23, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        ScopedOfKt$scopedOf$23 scopedOfKt$scopedOf$23 = new ScopedOfKt$scopedOf$23(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, scopedOfKt$scopedOf$23, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }
}
