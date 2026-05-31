package org.koin.core.scope;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.henninghall.date_picker.props.ModeProp;
import io.sentry.SentryEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.MissingPropertyException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.instance.InstanceContext;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.KoinDslMarker;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.ext.KClassExtKt;
import org.koin.mp.KoinPlatformTools;

/* compiled from: Scope.kt */
@KoinDslMarker
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00060\u0001j\u0002`\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010.\u001a\u00020/J\t\u00100\u001a\u00020\u0004HÆ\u0003J\r\u00101\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\u000e\u00103\u001a\u00020\u000bHÀ\u0003¢\u0006\u0002\b4J5\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\b\u0002\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u001b\u00106\u001a\u00020/2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000008H\u0000¢\u0006\u0002\b9JH\u0010:\u001a\u00020/\"\u0006\b\u0000\u0010;\u0018\u00012\u0006\u0010<\u001a\u0002H;2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?082\b\b\u0002\u0010@\u001a\u00020\tH\u0086\b¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003JA\u0010D\u001a\u0004\u0018\u0001H;\"\u0004\b\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\b\u0010=\u001a\u0004\u0018\u00010\u00042\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010Gj\u0004\u0018\u0001`HH\u0002¢\u0006\u0002\u0010IJA\u0010J\u001a\u0002H;\"\u0004\b\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010Gj\u0004\u0018\u0001`H¢\u0006\u0002\u0010IJA\u0010J\u001a\u0002H;\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\u0016\b\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010Gj\u0004\u0018\u0001`HH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010KJ\u001b\u0010L\u001a\b\u0012\u0004\u0012\u0002H;08\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u0001H\u0086\bJ\u001e\u0010L\u001a\b\u0012\u0004\u0012\u0002H;08\"\u0004\b\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?J!\u0010M\u001a\u0004\u0018\u0001H;\"\u0004\b\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?H\u0002¢\u0006\u0002\u0010NJ\u0006\u0010O\u001a\u00020\u000bJC\u0010P\u001a\u0004\u0018\u0001H;\"\u0004\b\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010Gj\u0004\u0018\u0001`H¢\u0006\u0002\u0010IJC\u0010P\u001a\u0004\u0018\u0001H;\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\u0016\b\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010Gj\u0004\u0018\u0001`HH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010KJ\u001d\u0010Q\u001a\u0002H;\"\b\b\u0000\u0010;*\u00020\u00012\u0006\u0010R\u001a\u00020\u0006¢\u0006\u0002\u0010SJ%\u0010Q\u001a\u0002H;\"\b\b\u0000\u0010;*\u00020\u00012\u0006\u0010R\u001a\u00020\u00062\u0006\u0010T\u001a\u0002H;¢\u0006\u0002\u0010UJ\u001f\u0010V\u001a\u0004\u0018\u0001H;\"\b\b\u0000\u0010;*\u00020\u00012\u0006\u0010R\u001a\u00020\u0006¢\u0006\u0002\u0010SJ\u0012\u0010W\u001a\u00020\u00002\n\u0010X\u001a\u00060\u0006j\u0002`\u0007J\u001c\u0010Y\u001a\u0004\u0018\u0001H;\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u001fJ\t\u0010Z\u001a\u00020[HÖ\u0001JL\u0010\\\u001a\b\u0012\u0004\u0012\u0002H;0]\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010^\u001a\u00020_2\u0016\b\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010Gj\u0004\u0018\u0001`HH\u0086\bø\u0001\u0000JN\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H;0]\"\n\b\u0000\u0010;\u0018\u0001*\u00020\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010^\u001a\u00020_2\u0016\b\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010Gj\u0004\u0018\u0001`HH\u0086\bø\u0001\u0000J\u0006\u0010a\u001a\u00020\tJ\u001f\u0010b\u001a\u00020/2\u0012\u0010c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000d\"\u00020\u0000¢\u0006\u0002\u0010eJ\u000e\u0010f\u001a\u00020/2\u0006\u0010g\u001a\u00020\u000fJ?\u0010h\u001a\u0002H;\"\u0004\b\u0000\u0010;2\b\u0010=\u001a\u0004\u0018\u00010\u00042\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\u0014\u0010i\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010Gj\u0004\u0018\u0001`HH\u0002¢\u0006\u0002\u0010jJL\u0010k\u001a\u0004\b\u0002H;\"\u0004\b\u0000\u0010;2\b\u0010=\u001a\u0004\u0018\u00010\u00042\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?2\u0006\u0010l\u001a\u00020m2\u0014\u0010i\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010Gj\u0004\u0018\u0001`HH\u0002ø\u0001\u0001¢\u0006\u0002\u0010nJ\u001e\u0010o\u001a\u00020p2\b\u0010=\u001a\u0004\u0018\u00010\u00042\n\u0010E\u001a\u0006\u0012\u0002\b\u00030?H\u0002J\b\u0010q\u001a\u00020\u0006H\u0016J\u001f\u0010r\u001a\u00020/2\u0012\u0010c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000d\"\u00020\u0000¢\u0006\u0002\u0010eR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001bR&\u0010\u001c\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0015\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010$R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u000ej\b\u0012\u0004\u0012\u00020\u0000`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b9¨\u0006s"}, d2 = {"Lorg/koin/core/scope/Scope;", "", "Lorg/koin/mp/Lockable;", "scopeQualifier", "Lorg/koin/core/qualifier/Qualifier;", "id", "", "Lorg/koin/core/scope/ScopeID;", "isRoot", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/qualifier/Qualifier;Ljava/lang/String;ZLorg/koin/core/Koin;)V", "_callbacks", "Ljava/util/ArrayList;", "Lorg/koin/core/scope/ScopeCallback;", "Lkotlin/collections/ArrayList;", "_closed", "get_koin$annotations", "()V", "get_koin", "()Lorg/koin/core/Koin;", "_parameterStack", "Lkotlin/collections/ArrayDeque;", "Lorg/koin/core/parameter/ParametersHolder;", "get_parameterStack$annotations", "get_parameterStack", "()Lkotlin/collections/ArrayDeque;", "_source", "get_source$annotations", "get_source", "()Ljava/lang/Object;", "set_source", "(Ljava/lang/Object;)V", "closed", "getClosed", "()Z", "getId", "()Ljava/lang/String;", "linkedScopes", SentryEvent.JsonKeys.LOGGER, "Lorg/koin/core/logger/Logger;", "getLogger", "()Lorg/koin/core/logger/Logger;", "getScopeQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "close", "", "component1", "component2", "component3", "component4", "component4$koin_core", "copy", "create", "links", "", "create$koin_core", "declare", ExifInterface.GPS_DIRECTION_TRUE, "instance", "qualifier", "secondaryTypes", "Lkotlin/reflect/KClass;", "allowOverride", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "equals", "other", "findInOtherScope", "clazz", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "get", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getFromSource", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getKoin", "getOrNull", "getProperty", SDKConstants.PARAM_KEY, "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getPropertyOrNull", "getScope", "scopeID", "getSource", "hashCode", "", "inject", "Lkotlin/Lazy;", ModeProp.name, "Lkotlin/LazyThreadSafetyMode;", "injectOrNull", "isNotClosed", "linkTo", "scopes", "", "([Lorg/koin/core/scope/Scope;)V", "registerCallback", "callback", "resolveInstance", "parameterDef", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "resolveValue", "instanceContext", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/instance/InstanceContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwDefinitionNotFound", "", InAppPurchaseConstants.METHOD_TO_STRING, "unlink", "koin-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class Scope {
    private final ArrayList<ScopeCallback> _callbacks;
    private boolean _closed;
    private final Koin _koin;
    private final ArrayDeque<ParametersHolder> _parameterStack;
    private Object _source;
    private final String id;
    private final boolean isRoot;
    private final ArrayList<Scope> linkedScopes;
    private final Qualifier scopeQualifier;

    public static /* synthetic */ Scope copy$default(Scope scope, Qualifier qualifier, String str, boolean z, Koin koin, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = scope.scopeQualifier;
        }
        if ((i & 2) != 0) {
            str = scope.id;
        }
        if ((i & 4) != 0) {
            z = scope.isRoot;
        }
        if ((i & 8) != 0) {
            koin = scope._koin;
        }
        return scope.copy(qualifier, str, z, koin);
    }

    public static /* synthetic */ void get_koin$annotations() {
    }

    public static /* synthetic */ void get_parameterStack$annotations() {
    }

    public static /* synthetic */ void get_source$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Qualifier getScopeQualifier() {
        return this.scopeQualifier;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    /* renamed from: component4$koin_core, reason: from getter */
    public final Koin get_koin() {
        return this._koin;
    }

    public final Scope copy(Qualifier scopeQualifier, String id, boolean isRoot, Koin _koin) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        return new Scope(scopeQualifier, id, isRoot, _koin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Scope)) {
            return false;
        }
        Scope scope = (Scope) other;
        return Intrinsics.areEqual(this.scopeQualifier, scope.scopeQualifier) && Intrinsics.areEqual(this.id, scope.id) && this.isRoot == scope.isRoot && Intrinsics.areEqual(this._koin, scope._koin);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.scopeQualifier.hashCode() * 31) + this.id.hashCode()) * 31;
        boolean z = this.isRoot;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this._koin.hashCode();
    }

    public /* synthetic */ Scope(Qualifier qualifier, String str, boolean z, Koin koin, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(qualifier, str, (i & 4) != 0 ? false : z, koin);
    }

    public final Qualifier getScopeQualifier() {
        return this.scopeQualifier;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    public final Koin get_koin() {
        return this._koin;
    }

    public Scope(Qualifier scopeQualifier, String id, boolean z, Koin _koin) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.scopeQualifier = scopeQualifier;
        this.id = id;
        this.isRoot = z;
        this._koin = _koin;
        this.linkedScopes = new ArrayList<>();
        this._callbacks = new ArrayList<>();
        this._parameterStack = new ArrayDeque<>();
    }

    public final Object get_source() {
        return this._source;
    }

    public final void set_source(Object obj) {
        this._source = obj;
    }

    /* renamed from: getClosed, reason: from getter */
    public final boolean get_closed() {
        return this._closed;
    }

    public final boolean isNotClosed() {
        return !get_closed();
    }

    public final ArrayDeque<ParametersHolder> get_parameterStack() {
        return this._parameterStack;
    }

    public final Logger getLogger() {
        return this._koin.getLogger();
    }

    public final void create$koin_core(List<Scope> links) {
        Intrinsics.checkNotNullParameter(links, "links");
        this.linkedScopes.addAll(links);
    }

    public final void linkTo(Scope... scopes) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        if (!this.isRoot) {
            CollectionsKt.addAll(this.linkedScopes, scopes);
            return;
        }
        throw new IllegalStateException("Can't add scope link to a root scope".toString());
    }

    public final void unlink(Scope... scopes) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        if (!this.isRoot) {
            CollectionsKt.removeAll(this.linkedScopes, scopes);
            return;
        }
        throw new IllegalStateException("Can't remove scope link to a root scope".toString());
    }

    public static /* synthetic */ Lazy inject$default(Scope scope, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            mode = LazyThreadSafetyMode.SYNCHRONIZED;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Scope$inject$1(scope, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Scope$inject$1(this, qualifier, parameters));
    }

    public static /* synthetic */ Lazy injectOrNull$default(Scope scope, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            mode = LazyThreadSafetyMode.SYNCHRONIZED;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Scope$injectOrNull$1(scope, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Scope$injectOrNull$1(this, qualifier, parameters));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return scope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    @Deprecated(message = "No need to use getSource(). You can an use get() directly.", replaceWith = @ReplaceWith(expression = "get()", imports = {}))
    public final /* synthetic */ <T> T getSource() {
        T t = (T) get_source();
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T getOrNull(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return (T) get(clazz, qualifier, parameters);
        } catch (ClosedScopeException unused) {
            Logger logger = this._koin.getLogger();
            String str = "* Scope closed - no instance found for " + KClassExtKt.getFullName(clazz) + " on scope " + this;
            Level level = Level.DEBUG;
            if (!logger.isAt(level)) {
                return null;
            }
            logger.display(level, str);
            return null;
        } catch (NoBeanDefFoundException unused2) {
            Logger logger2 = this._koin.getLogger();
            String str2 = "* No instance found for " + KClassExtKt.getFullName(clazz) + " on scope " + this;
            Level level2 = Level.DEBUG;
            if (!logger2.isAt(level2)) {
                return null;
            }
            logger2.display(level2, str2);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.get(kClass, qualifier, function0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (r1 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> T get(kotlin.reflect.KClass<?> r8, org.koin.core.qualifier.Qualifier r9, kotlin.jvm.functions.Function0<? extends org.koin.core.parameter.ParametersHolder> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            org.koin.core.Koin r0 = r7._koin
            org.koin.core.logger.Logger r0 = r0.getLogger()
            org.koin.core.logger.Level r1 = org.koin.core.logger.Level.DEBUG
            boolean r0 = r0.isAt(r1)
            if (r0 == 0) goto L95
            r0 = 39
            if (r9 == 0) goto L2a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " with qualifier '"
            r1.<init>(r2)
            r1.append(r9)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L2c
        L2a:
            java.lang.String r1 = ""
        L2c:
            org.koin.core.Koin r2 = r7._koin
            org.koin.core.logger.Logger r2 = r2.getLogger()
            org.koin.core.logger.Level r3 = org.koin.core.logger.Level.DEBUG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "|- '"
            r4.<init>(r5)
            java.lang.String r6 = org.koin.ext.KClassExtKt.getFullName(r8)
            r4.append(r6)
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = " ..."
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.display(r3, r0)
            org.koin.mp.KoinPlatformTimeTools r0 = org.koin.mp.KoinPlatformTimeTools.INSTANCE
            long r0 = r0.getTimeInNanoSeconds()
            java.lang.Object r9 = r7.resolveInstance(r9, r8, r10)
            org.koin.mp.KoinPlatformTimeTools r10 = org.koin.mp.KoinPlatformTimeTools.INSTANCE
            long r2 = r10.getTimeInNanoSeconds()
            long r2 = r2 - r0
            double r0 = (double) r2
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r0 = r0 / r2
            org.koin.core.Koin r10 = r7._koin
            org.koin.core.logger.Logger r10 = r10.getLogger()
            org.koin.core.logger.Level r2 = org.koin.core.logger.Level.DEBUG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r5)
            java.lang.String r8 = org.koin.ext.KClassExtKt.getFullName(r8)
            r3.append(r8)
            java.lang.String r8 = "' in "
            r3.append(r8)
            r3.append(r0)
            java.lang.String r8 = " ms"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r10.display(r2, r8)
            goto L99
        L95:
            java.lang.Object r9 = r7.resolveInstance(r9, r8, r10)
        L99:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.get(kotlin.reflect.KClass, org.koin.core.qualifier.Qualifier, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    private final <T> T resolveInstance(Qualifier qualifier, KClass<?> clazz, Function0<? extends ParametersHolder> parameterDef) {
        if (this._closed) {
            throw new ClosedScopeException("Scope '" + this.id + "' is closed");
        }
        final ParametersHolder invoke = parameterDef != null ? parameterDef.invoke() : null;
        if (invoke != null) {
            Logger logger = this._koin.getLogger();
            Level level = Level.DEBUG;
            if (logger.isAt(level)) {
                logger.display(level, "| >> parameters " + invoke + ' ');
            }
            KoinPlatformTools.INSTANCE.m4379synchronized(this, new Function0<Unit>() { // from class: org.koin.core.scope.Scope$resolveInstance$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Scope.this.get_parameterStack().addFirst(invoke);
                }
            });
        }
        T t = (T) resolveValue(qualifier, clazz, new InstanceContext(this._koin.getLogger(), this, invoke), parameterDef);
        if (invoke != null) {
            Logger logger2 = this._koin.getLogger();
            Level level2 = Level.DEBUG;
            if (logger2.isAt(level2)) {
                logger2.display(level2, "| << parameters");
            }
            KoinPlatformTools.INSTANCE.m4379synchronized(this, new Function0<ParametersHolder>() { // from class: org.koin.core.scope.Scope$resolveInstance$3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ParametersHolder invoke() {
                    return Scope.this.get_parameterStack().removeFirstOrNull();
                }
            });
        }
        return t;
    }

    private final <T> T resolveValue(Qualifier qualifier, KClass<?> clazz, InstanceContext instanceContext, Function0<? extends ParametersHolder> parameterDef) {
        Object obj;
        T t = (T) this._koin.getInstanceRegistry().resolveInstance$koin_core(qualifier, clazz, this.scopeQualifier, instanceContext);
        if (t == null) {
            Logger logger = this._koin.getLogger();
            String str = "|- ? t:'" + KClassExtKt.getFullName(clazz) + "' - q:'" + qualifier + "' look in injected parameters";
            Level level = Level.DEBUG;
            if (logger.isAt(level)) {
                logger.display(level, str);
            }
            ParametersHolder firstOrNull = this._parameterStack.firstOrNull();
            Object obj2 = null;
            t = firstOrNull != null ? (T) firstOrNull.getOrNull(clazz) : null;
            if (t == null) {
                Logger logger2 = this._koin.getLogger();
                String str2 = "|- ? t:'" + KClassExtKt.getFullName(clazz) + "' - q:'" + qualifier + "' look at scope source";
                Level level2 = Level.DEBUG;
                if (logger2.isAt(level2)) {
                    logger2.display(level2, str2);
                }
                Object obj3 = this._source;
                if (obj3 != null && Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(obj3.getClass()), clazz) && qualifier == null && (obj = this._source) != null) {
                    obj2 = obj;
                }
                t = (T) obj2;
                if (t == null) {
                    Logger logger3 = this._koin.getLogger();
                    String str3 = "|- ? t:'" + KClassExtKt.getFullName(clazz) + "' - q:'" + qualifier + "' look in other scopes";
                    Level level3 = Level.DEBUG;
                    if (logger3.isAt(level3)) {
                        logger3.display(level3, str3);
                    }
                    t = (T) findInOtherScope(clazz, qualifier, parameterDef);
                    if (t == null) {
                        KoinPlatformTools.INSTANCE.m4379synchronized(this, new Function0<Unit>() { // from class: org.koin.core.scope.Scope$resolveValue$4$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Scope.this.get_parameterStack().clear();
                            }
                        });
                        Logger logger4 = this._koin.getLogger();
                        Level level4 = Level.DEBUG;
                        if (logger4.isAt(level4)) {
                            logger4.display(level4, "|- << parameters");
                        }
                        throwDefinitionNotFound(qualifier, clazz);
                        throw new KotlinNothingValueException();
                    }
                }
            }
        }
        return t;
    }

    private final <T> T getFromSource(KClass<?> clazz) {
        T t;
        if (!clazz.isInstance(this._source) || (t = (T) this._source) == null) {
            return null;
        }
        return t;
    }

    private final <T> T findInOtherScope(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Iterator<Scope> it = this.linkedScopes.iterator();
        T t = null;
        while (it.hasNext() && (t = (T) it.next().getOrNull(clazz, qualifier, parameters)) == null) {
        }
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0015, code lost:
    
        if (r4 == null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Void throwDefinitionNotFound(org.koin.core.qualifier.Qualifier r4, kotlin.reflect.KClass<?> r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L17
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = " & qualifier:'"
            r0.<init>(r1)
            r0.append(r4)
            r4 = 39
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            if (r4 != 0) goto L19
        L17:
            java.lang.String r4 = ""
        L19:
            org.koin.core.error.NoBeanDefFoundException r0 = new org.koin.core.error.NoBeanDefFoundException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "No definition found for class:'"
            r1.<init>(r2)
            java.lang.String r5 = org.koin.ext.KClassExtKt.getFullName(r5)
            r1.append(r5)
            java.lang.String r5 = "' q:'"
            r1.append(r5)
            r1.append(r4)
            java.lang.String r4 = "'. Check your definitions!"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.throwDefinitionNotFound(org.koin.core.qualifier.Qualifier, kotlin.reflect.KClass):java.lang.Void");
    }

    public static /* synthetic */ void declare$default(Scope scope, Object obj, Qualifier qualifier, List list, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        List secondaryTypes = list;
        if ((i & 8) != 0) {
            z = true;
        }
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.INSTANCE;
        Intrinsics.needClassReification();
        koinPlatformTools.m4379synchronized(scope, new Scope$declare$1(scope, obj, qualifier2, secondaryTypes, z));
    }

    public final /* synthetic */ <T> void declare(T instance, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean allowOverride) {
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.INSTANCE;
        Intrinsics.needClassReification();
        koinPlatformTools.m4379synchronized(this, new Scope$declare$1(this, instance, qualifier, secondaryTypes, allowOverride));
    }

    public final Koin getKoin() {
        return this._koin;
    }

    public final Scope getScope(String scopeID) {
        Intrinsics.checkNotNullParameter(scopeID, "scopeID");
        return getKoin().getScope(scopeID);
    }

    public final void registerCallback(ScopeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this._callbacks.add(callback);
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> List<T> getAll(KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        List<T> all$koin_core = this._koin.getInstanceRegistry().getAll$koin_core(clazz, new InstanceContext(this._koin.getLogger(), this, null, 4, null));
        ArrayList<Scope> arrayList = this.linkedScopes;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList2, ((Scope) it.next()).getAll(clazz));
        }
        return CollectionsKt.plus((Collection) all$koin_core, (Iterable) arrayList2);
    }

    public final <T> T getProperty(String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (T) this._koin.getProperty(key, defaultValue);
    }

    public final <T> T getPropertyOrNull(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this._koin.getProperty(key);
    }

    public final <T> T getProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) this._koin.getProperty(key);
        if (t != null) {
            return t;
        }
        throw new MissingPropertyException("Property '" + key + "' not found");
    }

    public final void close() {
        KoinPlatformTools.INSTANCE.m4379synchronized(this, new Function0<Unit>() { // from class: org.koin.core.scope.Scope$close$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList arrayList;
                ArrayList arrayList2;
                Logger logger = Scope.this.get_koin().getLogger();
                String str = "|- (-) Scope - id:'" + Scope.this.getId() + '\'';
                Level level = Level.DEBUG;
                if (logger.isAt(level)) {
                    logger.display(level, str);
                }
                arrayList = Scope.this._callbacks;
                Scope scope = Scope.this;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ScopeCallback) it.next()).onScopeClose(scope);
                }
                arrayList2 = Scope.this._callbacks;
                arrayList2.clear();
                Scope.this.set_source(null);
                Scope.this._closed = true;
                Scope.this.get_koin().getScopeRegistry().deleteScope$koin_core(Scope.this);
            }
        });
    }

    public String toString() {
        return "['" + this.id + "']";
    }
}
