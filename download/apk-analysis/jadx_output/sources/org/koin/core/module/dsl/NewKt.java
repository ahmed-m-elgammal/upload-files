package org.koin.core.module.dsl;

import android.R;
import kotlin.Metadata;
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
import org.koin.core.scope.Scope;

/* compiled from: New.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001*\u00020\u00022\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00010\nH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aU\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001*\u00020\u00022\u001e\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00010\rH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001ac\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001*\u00020\u00022$\u0010\u0003\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00010\u0010H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001aq\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001*\u00020\u00022*\u0010\u0003\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00010\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u007f\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001*\u00020\u000220\u0010\u0003\u001a,\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00010\u0016H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u008d\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001*\u00020\u000226\u0010\u0003\u001a2\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00010\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u009b\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001*\u00020\u00022<\u0010\u0003\u001a8\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u00010\u001cH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a©\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001*\u00020\u00022B\u0010\u0003\u001a>\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u00010\u001fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010 \u001a·\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001*\u00020\u00022H\u0010\u0003\u001aD\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\u00010\"H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010#\u001aÅ\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001*\u00020\u00022N\u0010\u0003\u001aJ\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H\u00010%H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010&\u001aÓ\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001*\u00020\u00022T\u0010\u0003\u001aP\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H\u00010(H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010)\u001aá\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001\"\u0006\b\r\u0010*\u0018\u0001*\u00020\u00022Z\u0010\u0003\u001aV\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H\u00010+H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010,\u001aï\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001\"\u0006\b\r\u0010*\u0018\u0001\"\u0006\b\u000e\u0010-\u0018\u0001*\u00020\u00022`\u0010\u0003\u001a\\\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H\u00010.H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010/\u001aý\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001\"\u0006\b\r\u0010*\u0018\u0001\"\u0006\b\u000e\u0010-\u0018\u0001\"\u0006\b\u000f\u00100\u0018\u0001*\u00020\u00022f\u0010\u0003\u001ab\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H\u000101H\u0086\bø\u0001\u0000¢\u0006\u0002\u00102\u001a\u008b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001\"\u0006\b\r\u0010*\u0018\u0001\"\u0006\b\u000e\u0010-\u0018\u0001\"\u0006\b\u000f\u00100\u0018\u0001\"\u0006\b\u0010\u00103\u0018\u0001*\u00020\u00022l\u0010\u0003\u001ah\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H\u000104H\u0086\bø\u0001\u0000¢\u0006\u0002\u00105\u001a\u0099\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001\"\u0006\b\r\u0010*\u0018\u0001\"\u0006\b\u000e\u0010-\u0018\u0001\"\u0006\b\u000f\u00100\u0018\u0001\"\u0006\b\u0010\u00103\u0018\u0001\"\u0006\b\u0011\u00106\u0018\u0001*\u00020\u00022r\u0010\u0003\u001an\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H\u000107H\u0086\bø\u0001\u0000¢\u0006\u0002\u00108\u001a§\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001\"\u0006\b\r\u0010*\u0018\u0001\"\u0006\b\u000e\u0010-\u0018\u0001\"\u0006\b\u000f\u00100\u0018\u0001\"\u0006\b\u0010\u00103\u0018\u0001\"\u0006\b\u0011\u00106\u0018\u0001\"\u0006\b\u0012\u00109\u0018\u0001*\u00020\u00022x\u0010\u0003\u001at\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H\u00010:H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010;\u001aµ\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001\"\u0006\b\r\u0010*\u0018\u0001\"\u0006\b\u000e\u0010-\u0018\u0001\"\u0006\b\u000f\u00100\u0018\u0001\"\u0006\b\u0010\u00103\u0018\u0001\"\u0006\b\u0011\u00106\u0018\u0001\"\u0006\b\u0012\u00109\u0018\u0001\"\u0006\b\u0013\u0010<\u0018\u0001*\u00020\u00022~\u0010\u0003\u001az\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H\u00010=H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010>\u001aÅ\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001\"\u0006\b\r\u0010*\u0018\u0001\"\u0006\b\u000e\u0010-\u0018\u0001\"\u0006\b\u000f\u00100\u0018\u0001\"\u0006\b\u0010\u00103\u0018\u0001\"\u0006\b\u0011\u00106\u0018\u0001\"\u0006\b\u0012\u00109\u0018\u0001\"\u0006\b\u0013\u0010<\u0018\u0001\"\u0006\b\u0014\u0010?\u0018\u0001*\u00020\u00022\u0085\u0001\u0010\u0003\u001a\u0080\u0001\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u0002H\u00010@H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010A\u001aÓ\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001\"\u0006\b\r\u0010*\u0018\u0001\"\u0006\b\u000e\u0010-\u0018\u0001\"\u0006\b\u000f\u00100\u0018\u0001\"\u0006\b\u0010\u00103\u0018\u0001\"\u0006\b\u0011\u00106\u0018\u0001\"\u0006\b\u0012\u00109\u0018\u0001\"\u0006\b\u0013\u0010<\u0018\u0001\"\u0006\b\u0014\u0010?\u0018\u0001\"\u0006\b\u0015\u0010B\u0018\u0001*\u00020\u00022\u008b\u0001\u0010\u0003\u001a\u0086\u0001\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002H\u00010CH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010D\u001aá\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0006\u0018\u0001\"\u0006\b\u0002\u0010\t\u0018\u0001\"\u0006\b\u0003\u0010\f\u0018\u0001\"\u0006\b\u0004\u0010\u000f\u0018\u0001\"\u0006\b\u0005\u0010\u0012\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0018\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010!\u0018\u0001\"\u0006\b\u000b\u0010$\u0018\u0001\"\u0006\b\f\u0010'\u0018\u0001\"\u0006\b\r\u0010*\u0018\u0001\"\u0006\b\u000e\u0010-\u0018\u0001\"\u0006\b\u000f\u00100\u0018\u0001\"\u0006\b\u0010\u00103\u0018\u0001\"\u0006\b\u0011\u00106\u0018\u0001\"\u0006\b\u0012\u00109\u0018\u0001\"\u0006\b\u0013\u0010<\u0018\u0001\"\u0006\b\u0014\u0010?\u0018\u0001\"\u0006\b\u0015\u0010B\u0018\u0001\"\u0006\b\u0016\u0010E\u0018\u0001*\u00020\u00022\u0091\u0001\u0010\u0003\u001a\u008c\u0001\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002HE\u0012\u0004\u0012\u0002H\u00010FH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010G\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006H"}, d2 = {"new", "R", "Lorg/koin/core/scope/Scope;", "constructor", "Lkotlin/Function0;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "T1", "Lkotlin/Function1;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "T2", "Lkotlin/Function2;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "Lkotlin/Function3;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "Lkotlin/Function4;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "Lkotlin/Function5;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "T6", "Lkotlin/Function6;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function6;)Ljava/lang/Object;", "T7", "Lkotlin/Function7;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function7;)Ljava/lang/Object;", "T8", "Lkotlin/Function8;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function8;)Ljava/lang/Object;", "T9", "Lkotlin/Function9;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function9;)Ljava/lang/Object;", "T10", "Lkotlin/Function10;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function10;)Ljava/lang/Object;", "T11", "Lkotlin/Function11;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function11;)Ljava/lang/Object;", "T12", "Lkotlin/Function12;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function12;)Ljava/lang/Object;", "T13", "Lkotlin/Function13;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function13;)Ljava/lang/Object;", "T14", "Lkotlin/Function14;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function14;)Ljava/lang/Object;", "T15", "Lkotlin/Function15;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function15;)Ljava/lang/Object;", "T16", "Lkotlin/Function16;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function16;)Ljava/lang/Object;", "T17", "Lkotlin/Function17;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function17;)Ljava/lang/Object;", "T18", "Lkotlin/Function18;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function18;)Ljava/lang/Object;", "T19", "Lkotlin/Function19;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function19;)Ljava/lang/Object;", "T20", "Lkotlin/Function20;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function20;)Ljava/lang/Object;", "T21", "Lkotlin/Function21;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function21;)Ljava/lang/Object;", "T22", "Lkotlin/Function22;", "(Lorg/koin/core/scope/Scope;Lkotlin/jvm/functions/Function22;)Ljava/lang/Object;", "koin-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NewKt {
    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R> R m4354new(Scope scope, Function0<? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        return constructor.invoke();
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1> R m4365new(Scope scope, Function1<? super T1, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        return constructor.invoke((Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2> R m4369new(Scope scope, Function2<? super T1, ? super T2, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        return constructor.invoke(animVar, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3> R m4370new(Scope scope, Function3<? super T1, ? super T2, ? super T3, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        return constructor.invoke(animVar, animVar2, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4> R m4371new(Scope scope, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        return constructor.invoke(animVar, animVar2, animVar3, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5> R m4372new(Scope scope, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6> R m4373new(Scope scope, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7> R m4374new(Scope scope, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8> R m4375new(Scope scope, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9> R m4376new(Scope scope, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> R m4355new(Scope scope, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> R m4356new(Scope scope, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> R m4357new(Scope scope, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> R m4358new(Scope scope, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        R.anim animVar12 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, animVar12, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> R m4359new(Scope scope, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        R.anim animVar12 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        R.anim animVar13 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, animVar12, animVar13, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> R m4360new(Scope scope, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        R.anim animVar12 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        R.anim animVar13 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        R.anim animVar14 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T15");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, animVar12, animVar13, animVar14, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> R m4361new(Scope scope, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        R.anim animVar12 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        R.anim animVar13 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        R.anim animVar14 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T15");
        R.anim animVar15 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T16");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, animVar12, animVar13, animVar14, animVar15, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> R m4362new(Scope scope, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        R.anim animVar12 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        R.anim animVar13 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        R.anim animVar14 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T15");
        R.anim animVar15 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T16");
        R.anim animVar16 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T17");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, animVar12, animVar13, animVar14, animVar15, animVar16, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> R m4363new(Scope scope, Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        R.anim animVar12 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        R.anim animVar13 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        R.anim animVar14 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T15");
        R.anim animVar15 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T16");
        R.anim animVar16 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T17");
        R.anim animVar17 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T18");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, animVar12, animVar13, animVar14, animVar15, animVar16, animVar17, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> R m4364new(Scope scope, Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        R.anim animVar12 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        R.anim animVar13 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        R.anim animVar14 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T15");
        R.anim animVar15 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T16");
        R.anim animVar16 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T17");
        R.anim animVar17 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T18");
        R.anim animVar18 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T19");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, animVar12, animVar13, animVar14, animVar15, animVar16, animVar17, animVar18, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> R m4366new(Scope scope, Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        R.anim animVar12 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        R.anim animVar13 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        R.anim animVar14 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T15");
        R.anim animVar15 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T16");
        R.anim animVar16 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T17");
        R.anim animVar17 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T18");
        R.anim animVar18 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T19");
        R.anim animVar19 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T20");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, animVar12, animVar13, animVar14, animVar15, animVar16, animVar17, animVar18, animVar19, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> R m4367new(Scope scope, Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        R.anim animVar12 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        R.anim animVar13 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        R.anim animVar14 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T15");
        R.anim animVar15 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T16");
        R.anim animVar16 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T17");
        R.anim animVar17 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T18");
        R.anim animVar18 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T19");
        R.anim animVar19 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T20");
        R.anim animVar20 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T21");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, animVar12, animVar13, animVar14, animVar15, animVar16, animVar17, animVar18, animVar19, animVar20, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }

    /* renamed from: new, reason: not valid java name */
    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> R m4368new(Scope scope, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> constructor) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.reifiedOperationMarker(4, "T1");
        R.anim animVar = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        R.anim animVar2 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        R.anim animVar3 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        R.anim animVar4 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        R.anim animVar5 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        R.anim animVar6 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        R.anim animVar7 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        R.anim animVar8 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        R.anim animVar9 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        R.anim animVar10 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        R.anim animVar11 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        R.anim animVar12 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        R.anim animVar13 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        R.anim animVar14 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T15");
        R.anim animVar15 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T16");
        R.anim animVar16 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T17");
        R.anim animVar17 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T18");
        R.anim animVar18 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T19");
        R.anim animVar19 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T20");
        R.anim animVar20 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T21");
        R.anim animVar21 = (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T22");
        return constructor.invoke(animVar, animVar2, animVar3, animVar4, animVar5, animVar6, animVar7, animVar8, animVar9, animVar10, animVar11, animVar12, animVar13, animVar14, animVar15, animVar16, animVar17, animVar18, animVar19, animVar20, animVar21, (Object) scope.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
    }
}
