package org.koin.core.instance;

import io.sentry.SentryEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

/* compiled from: InstanceContext.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lorg/koin/core/instance/InstanceContext;", "", SentryEvent.JsonKeys.LOGGER, "Lorg/koin/core/logger/Logger;", "scope", "Lorg/koin/core/scope/Scope;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "(Lorg/koin/core/logger/Logger;Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)V", "getLogger", "()Lorg/koin/core/logger/Logger;", "getParameters", "()Lorg/koin/core/parameter/ParametersHolder;", "getScope", "()Lorg/koin/core/scope/Scope;", "koin-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InstanceContext {
    private final Logger logger;
    private final ParametersHolder parameters;
    private final Scope scope;

    public InstanceContext(Logger logger, Scope scope, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.logger = logger;
        this.scope = scope;
        this.parameters = parametersHolder;
    }

    public /* synthetic */ InstanceContext(Logger logger, Scope scope, ParametersHolder parametersHolder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger, scope, (i & 4) != 0 ? null : parametersHolder);
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final Scope getScope() {
        return this.scope;
    }

    public final ParametersHolder getParameters() {
        return this.parameters;
    }
}
