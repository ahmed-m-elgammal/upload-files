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
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;

/* compiled from: SingleOf.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a]\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001ak\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001*\u00020\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00020\u00072-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001ay\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001*\u00020\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020\u000e2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0087\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001*\u00020\u00032 \b\u0004\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00020\u00102-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0095\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001*\u00020\u00032&\b\u0004\u0010\u0004\u001a \u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00020\u00122-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a£\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001*\u00020\u00032,\b\u0004\u0010\u0004\u001a&\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00020\u00142-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a±\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001*\u00020\u000322\b\u0004\u0010\u0004\u001a,\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00020\u00162-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a¿\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001*\u00020\u000328\b\u0004\u0010\u0004\u001a2\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00020\u00182-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aÍ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001*\u00020\u00032>\b\u0004\u0010\u0004\u001a8\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00020\u001a2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aÛ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001*\u00020\u00032D\b\u0004\u0010\u0004\u001a>\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u00020\u001c2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aé\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001*\u00020\u00032J\b\u0004\u0010\u0004\u001aD\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u00020\u001e2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a÷\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001*\u00020\u00032P\b\u0004\u0010\u0004\u001aJ\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\u00020 2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0085\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001*\u00020\u00032V\b\u0004\u0010\u0004\u001aP\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\u00020\"2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0093\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001*\u00020\u00032\\\b\u0004\u0010\u0004\u001aV\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H\u00020$2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a¡\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001*\u00020\u00032b\b\u0004\u0010\u0004\u001a\\\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H\u00020&2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a¯\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001*\u00020\u00032h\b\u0004\u0010\u0004\u001ab\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H\u00020(2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a½\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001*\u00020\u00032n\b\u0004\u0010\u0004\u001ah\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H\u00020*2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aË\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001*\u00020\u00032t\b\u0004\u0010\u0004\u001an\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H\u00020,2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aÙ\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001\"\u0006\b\u0012\u0010-\u0018\u0001*\u00020\u00032z\b\u0004\u0010\u0004\u001at\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H\u00020.2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aè\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001\"\u0006\b\u0012\u0010-\u0018\u0001\"\u0006\b\u0013\u0010/\u0018\u0001*\u00020\u00032\u0080\u0001\b\u0004\u0010\u0004\u001az\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H\u0002002-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a÷\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001\"\u0006\b\u0012\u0010-\u0018\u0001\"\u0006\b\u0013\u0010/\u0018\u0001\"\u0006\b\u0014\u00101\u0018\u0001*\u00020\u00032\u0087\u0001\b\u0004\u0010\u0004\u001a\u0080\u0001\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u0002H\u0002022-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0085\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001\"\u0006\b\u0012\u0010-\u0018\u0001\"\u0006\b\u0013\u0010/\u0018\u0001\"\u0006\b\u0014\u00101\u0018\u0001\"\u0006\b\u0015\u00103\u0018\u0001*\u00020\u00032\u008d\u0001\b\u0004\u0010\u0004\u001a\u0086\u0001\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H\u0002042-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001a\u0093\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001\"\u0006\b\u0012\u0010-\u0018\u0001\"\u0006\b\u0013\u0010/\u0018\u0001\"\u0006\b\u0014\u00101\u0018\u0001\"\u0006\b\u0015\u00103\u0018\u0001\"\u0006\b\u0016\u00105\u0018\u0001*\u00020\u00032\u0093\u0001\b\u0004\u0010\u0004\u001a\u008c\u0001\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u0002H\u0002062-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, d2 = {"singleOf", "Lorg/koin/core/definition/KoinDefinition;", "R", "Lorg/koin/core/module/Module;", "constructor", "Lkotlin/Function0;", "options", "Lkotlin/Function1;", "Lorg/koin/core/definition/BeanDefinition;", "", "Lorg/koin/core/module/dsl/DefinitionOptions;", "Lkotlin/ExtensionFunctionType;", "T1", "T2", "Lkotlin/Function2;", "T3", "Lkotlin/Function3;", "T4", "Lkotlin/Function4;", "T5", "Lkotlin/Function5;", "T6", "Lkotlin/Function6;", "T7", "Lkotlin/Function7;", "T8", "Lkotlin/Function8;", "T9", "Lkotlin/Function9;", "T10", "Lkotlin/Function10;", "T11", "Lkotlin/Function11;", "T12", "Lkotlin/Function12;", "T13", "Lkotlin/Function13;", "T14", "Lkotlin/Function14;", "T15", "Lkotlin/Function15;", "T16", "Lkotlin/Function16;", "T17", "Lkotlin/Function17;", "T18", "Lkotlin/Function18;", "T19", "Lkotlin/Function19;", "T20", "Lkotlin/Function20;", "T21", "Lkotlin/Function21;", "T22", "Lkotlin/Function22;", "koin-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SingleOfKt {
    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function0 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$1 singleOfKt$singleOf$1 = new SingleOfKt$singleOf$1(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$1, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R> KoinDefinition<R> singleOf(Module module, Function0<? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$1 singleOfKt$singleOf$1 = new SingleOfKt$singleOf$1(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$1, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function1 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$2 singleOfKt$singleOf$2 = new SingleOfKt$singleOf$2(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$2, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1> KoinDefinition<R> singleOf(Module module, Function1<? super T1, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$2 singleOfKt$singleOf$2 = new SingleOfKt$singleOf$2(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$2, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function2 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$3 singleOfKt$singleOf$3 = new SingleOfKt$singleOf$3(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$3, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2> KoinDefinition<R> singleOf(Module module, Function2<? super T1, ? super T2, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$3 singleOfKt$singleOf$3 = new SingleOfKt$singleOf$3(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$3, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function3 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$4 singleOfKt$singleOf$4 = new SingleOfKt$singleOf$4(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$4, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3> KoinDefinition<R> singleOf(Module module, Function3<? super T1, ? super T2, ? super T3, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$4 singleOfKt$singleOf$4 = new SingleOfKt$singleOf$4(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$4, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function4 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$5 singleOfKt$singleOf$5 = new SingleOfKt$singleOf$5(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$5, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4> KoinDefinition<R> singleOf(Module module, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$5 singleOfKt$singleOf$5 = new SingleOfKt$singleOf$5(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$5, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function5 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$6 singleOfKt$singleOf$6 = new SingleOfKt$singleOf$6(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$6, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5> KoinDefinition<R> singleOf(Module module, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$6 singleOfKt$singleOf$6 = new SingleOfKt$singleOf$6(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$6, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function6 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$7 singleOfKt$singleOf$7 = new SingleOfKt$singleOf$7(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$7, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6> KoinDefinition<R> singleOf(Module module, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$7 singleOfKt$singleOf$7 = new SingleOfKt$singleOf$7(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$7, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function7 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$8 singleOfKt$singleOf$8 = new SingleOfKt$singleOf$8(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$8, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7> KoinDefinition<R> singleOf(Module module, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$8 singleOfKt$singleOf$8 = new SingleOfKt$singleOf$8(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$8, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function8 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$9 singleOfKt$singleOf$9 = new SingleOfKt$singleOf$9(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$9, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8> KoinDefinition<R> singleOf(Module module, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$9 singleOfKt$singleOf$9 = new SingleOfKt$singleOf$9(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$9, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function9 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$10 singleOfKt$singleOf$10 = new SingleOfKt$singleOf$10(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$10, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9> KoinDefinition<R> singleOf(Module module, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$10 singleOfKt$singleOf$10 = new SingleOfKt$singleOf$10(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$10, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function10 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$11 singleOfKt$singleOf$11 = new SingleOfKt$singleOf$11(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$11, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> KoinDefinition<R> singleOf(Module module, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$11 singleOfKt$singleOf$11 = new SingleOfKt$singleOf$11(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$11, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function11 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$12 singleOfKt$singleOf$12 = new SingleOfKt$singleOf$12(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$12, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> KoinDefinition<R> singleOf(Module module, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$12 singleOfKt$singleOf$12 = new SingleOfKt$singleOf$12(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$12, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function12 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$13 singleOfKt$singleOf$13 = new SingleOfKt$singleOf$13(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$13, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> KoinDefinition<R> singleOf(Module module, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$13 singleOfKt$singleOf$13 = new SingleOfKt$singleOf$13(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$13, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function13 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$14 singleOfKt$singleOf$14 = new SingleOfKt$singleOf$14(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$14, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> KoinDefinition<R> singleOf(Module module, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$14 singleOfKt$singleOf$14 = new SingleOfKt$singleOf$14(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$14, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function14 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$15 singleOfKt$singleOf$15 = new SingleOfKt$singleOf$15(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$15, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> KoinDefinition<R> singleOf(Module module, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$15 singleOfKt$singleOf$15 = new SingleOfKt$singleOf$15(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$15, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function15 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$16 singleOfKt$singleOf$16 = new SingleOfKt$singleOf$16(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$16, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> KoinDefinition<R> singleOf(Module module, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$16 singleOfKt$singleOf$16 = new SingleOfKt$singleOf$16(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$16, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function16 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$17 singleOfKt$singleOf$17 = new SingleOfKt$singleOf$17(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$17, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> KoinDefinition<R> singleOf(Module module, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$17 singleOfKt$singleOf$17 = new SingleOfKt$singleOf$17(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$17, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function17 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$18 singleOfKt$singleOf$18 = new SingleOfKt$singleOf$18(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$18, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> KoinDefinition<R> singleOf(Module module, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$18 singleOfKt$singleOf$18 = new SingleOfKt$singleOf$18(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$18, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function18 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$19 singleOfKt$singleOf$19 = new SingleOfKt$singleOf$19(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$19, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> KoinDefinition<R> singleOf(Module module, Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$19 singleOfKt$singleOf$19 = new SingleOfKt$singleOf$19(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$19, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function19 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$20 singleOfKt$singleOf$20 = new SingleOfKt$singleOf$20(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$20, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> KoinDefinition<R> singleOf(Module module, Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$20 singleOfKt$singleOf$20 = new SingleOfKt$singleOf$20(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$20, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function20 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$21 singleOfKt$singleOf$21 = new SingleOfKt$singleOf$21(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$21, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> KoinDefinition<R> singleOf(Module module, Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$21 singleOfKt$singleOf$21 = new SingleOfKt$singleOf$21(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$21, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function21 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$22 singleOfKt$singleOf$22 = new SingleOfKt$singleOf$22(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$22, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> KoinDefinition<R> singleOf(Module module, Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$22 singleOfKt$singleOf$22 = new SingleOfKt$singleOf$22(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$22, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static /* synthetic */ KoinDefinition singleOf$default(Module module, Function22 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$23 singleOfKt$singleOf$23 = new SingleOfKt$singleOf$23(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$23, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> singleOf(Module module, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        SingleOfKt$singleOf$23 singleOfKt$singleOf$23 = new SingleOfKt$singleOf$23(constructor);
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, singleOfKt$singleOf$23, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory2), function1);
    }
}
