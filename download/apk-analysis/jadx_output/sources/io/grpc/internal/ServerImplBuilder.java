package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.BinaryLog;
import io.grpc.BindableService;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalChannelz;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCallExecutorSupplier;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerStreamTracer;
import io.grpc.ServerTransportFilter;
import io.grpc.internal.CallTracer;
import io.grpc.internal.InternalHandlerRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class ServerImplBuilder extends ServerBuilder<ServerImplBuilder> {

    @Nullable
    BinaryLog binlog;
    private final ClientTransportServersBuilder clientTransportServersBuilder;

    @Nullable
    ServerCallExecutorSupplier executorSupplier;
    private static final Logger log = Logger.getLogger(ServerImplBuilder.class.getName());
    private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    private static final HandlerRegistry DEFAULT_FALLBACK_REGISTRY = new DefaultFallbackRegistry();
    private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();
    private static final long DEFAULT_HANDSHAKE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(120);
    final InternalHandlerRegistry.Builder registryBuilder = new InternalHandlerRegistry.Builder();
    final List<ServerTransportFilter> transportFilters = new ArrayList();
    final List<ServerInterceptor> interceptors = new ArrayList();
    private final List<ServerStreamTracer.Factory> streamTracerFactories = new ArrayList();
    HandlerRegistry fallbackRegistry = DEFAULT_FALLBACK_REGISTRY;
    ObjectPool<? extends Executor> executorPool = DEFAULT_EXECUTOR_POOL;
    DecompressorRegistry decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
    CompressorRegistry compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
    long handshakeTimeoutMillis = DEFAULT_HANDSHAKE_TIMEOUT_MILLIS;
    Deadline.Ticker ticker = Deadline.getSystemTicker();
    private boolean statsEnabled = true;
    private boolean recordStartedRpcs = true;
    private boolean recordFinishedRpcs = true;
    private boolean recordRealTimeMetrics = false;
    private boolean tracingEnabled = true;
    InternalChannelz channelz = InternalChannelz.instance();
    CallTracer.Factory callTracerFactory = CallTracer.getDefaultFactory();

    public interface ClientTransportServersBuilder {
        InternalServer buildClientTransportServers(List<? extends ServerStreamTracer.Factory> list);
    }

    public static ServerBuilder<?> forPort(int i) {
        throw new UnsupportedOperationException("ClientTransportServersBuilder is required, use a constructor");
    }

    public ServerImplBuilder(ClientTransportServersBuilder clientTransportServersBuilder) {
        this.clientTransportServersBuilder = (ClientTransportServersBuilder) Preconditions.checkNotNull(clientTransportServersBuilder, "clientTransportServersBuilder");
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder directExecutor() {
        return executor(MoreExecutors.directExecutor());
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder executor(@Nullable Executor executor) {
        this.executorPool = executor != null ? new FixedObjectPool<>(executor) : DEFAULT_EXECUTOR_POOL;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder callExecutor(ServerCallExecutorSupplier serverCallExecutorSupplier) {
        this.executorSupplier = (ServerCallExecutorSupplier) Preconditions.checkNotNull(serverCallExecutorSupplier);
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addService(ServerServiceDefinition serverServiceDefinition) {
        this.registryBuilder.addService((ServerServiceDefinition) Preconditions.checkNotNull(serverServiceDefinition, NotificationCompat.CATEGORY_SERVICE));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addService(BindableService bindableService) {
        return addService(((BindableService) Preconditions.checkNotNull(bindableService, "bindableService")).bindService());
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addTransportFilter(ServerTransportFilter serverTransportFilter) {
        this.transportFilters.add((ServerTransportFilter) Preconditions.checkNotNull(serverTransportFilter, "filter"));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder intercept(ServerInterceptor serverInterceptor) {
        this.interceptors.add((ServerInterceptor) Preconditions.checkNotNull(serverInterceptor, "interceptor"));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder addStreamTracerFactory(ServerStreamTracer.Factory factory) {
        this.streamTracerFactories.add((ServerStreamTracer.Factory) Preconditions.checkNotNull(factory, "factory"));
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder fallbackHandlerRegistry(@Nullable HandlerRegistry handlerRegistry) {
        if (handlerRegistry == null) {
            handlerRegistry = DEFAULT_FALLBACK_REGISTRY;
        }
        this.fallbackRegistry = handlerRegistry;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder decompressorRegistry(@Nullable DecompressorRegistry decompressorRegistry) {
        if (decompressorRegistry == null) {
            decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        }
        this.decompressorRegistry = decompressorRegistry;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder compressorRegistry(@Nullable CompressorRegistry compressorRegistry) {
        if (compressorRegistry == null) {
            compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        }
        this.compressorRegistry = compressorRegistry;
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder handshakeTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "handshake timeout is %s, but must be positive", j);
        this.handshakeTimeoutMillis = ((TimeUnit) Preconditions.checkNotNull(timeUnit, "unit")).toMillis(j);
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder setBinaryLog(@Nullable BinaryLog binaryLog) {
        this.binlog = binaryLog;
        return this;
    }

    public void setStatsEnabled(boolean z) {
        this.statsEnabled = z;
    }

    public void setStatsRecordStartedRpcs(boolean z) {
        this.recordStartedRpcs = z;
    }

    public void setStatsRecordFinishedRpcs(boolean z) {
        this.recordFinishedRpcs = z;
    }

    public void setStatsRecordRealTimeMetrics(boolean z) {
        this.recordRealTimeMetrics = z;
    }

    public void setTracingEnabled(boolean z) {
        this.tracingEnabled = z;
    }

    public void setDeadlineTicker(Deadline.Ticker ticker) {
        this.ticker = (Deadline.Ticker) Preconditions.checkNotNull(ticker, "ticker");
    }

    @Override // io.grpc.ServerBuilder
    public Server build() {
        return new ServerImpl(this, this.clientTransportServersBuilder.buildClientTransportServers(getTracerFactories()), Context.ROOT);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.util.List<? extends io.grpc.ServerStreamTracer.Factory> getTracerFactories() {
        /*
            r13 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r1 = io.grpc.InternalGlobalInterceptors.getServerInterceptors()
            java.util.List r2 = io.grpc.InternalGlobalInterceptors.getServerStreamTracerFactories()
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L1b
            r0.addAll(r2)
            java.util.List<io.grpc.ServerInterceptor> r2 = r13.interceptors
            r2.addAll(r1)
            r1 = r3
            goto L1c
        L1b:
            r1 = r4
        L1c:
            java.lang.String r2 = "getServerStreamTracerFactory"
            r5 = 0
            java.lang.String r6 = "Unable to apply census stats"
            if (r1 != 0) goto L87
            boolean r7 = r13.statsEnabled
            if (r7 == 0) goto L87
            java.lang.String r7 = "io.grpc.census.InternalCensusStatsAccessor"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            r8 = 3
            java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            r9[r4] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            r9[r3] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            r11 = 2
            r9[r11] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r2, r9)     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            boolean r9 = r13.recordStartedRpcs     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            boolean r10 = r13.recordFinishedRpcs     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            boolean r12 = r13.recordRealTimeMetrics     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            r8[r4] = r9     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            r8[r3] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            r8[r11] = r12     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            java.lang.Object r3 = r7.invoke(r5, r8)     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            io.grpc.ServerStreamTracer$Factory r3 = (io.grpc.ServerStreamTracer.Factory) r3     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L67 java.lang.NoSuchMethodException -> L70 java.lang.ClassNotFoundException -> L79
            goto L82
        L5e:
            r3 = move-exception
            java.util.logging.Logger r4 = io.grpc.internal.ServerImplBuilder.log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r4.log(r7, r6, r3)
            goto L81
        L67:
            r3 = move-exception
            java.util.logging.Logger r4 = io.grpc.internal.ServerImplBuilder.log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r4.log(r7, r6, r3)
            goto L81
        L70:
            r3 = move-exception
            java.util.logging.Logger r4 = io.grpc.internal.ServerImplBuilder.log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r4.log(r7, r6, r3)
            goto L81
        L79:
            r3 = move-exception
            java.util.logging.Logger r4 = io.grpc.internal.ServerImplBuilder.log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r4.log(r7, r6, r3)
        L81:
            r3 = r5
        L82:
            if (r3 == 0) goto L87
            r0.add(r3)
        L87:
            if (r1 != 0) goto Lc7
            boolean r1 = r13.tracingEnabled
            if (r1 == 0) goto Lc7
            java.lang.String r1 = "io.grpc.census.InternalCensusTracingAccessor"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L9f java.lang.IllegalAccessException -> La8 java.lang.NoSuchMethodException -> Lb1 java.lang.ClassNotFoundException -> Lba
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L9f java.lang.IllegalAccessException -> La8 java.lang.NoSuchMethodException -> Lb1 java.lang.ClassNotFoundException -> Lba
            java.lang.Object r1 = r1.invoke(r5, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L9f java.lang.IllegalAccessException -> La8 java.lang.NoSuchMethodException -> Lb1 java.lang.ClassNotFoundException -> Lba
            io.grpc.ServerStreamTracer$Factory r1 = (io.grpc.ServerStreamTracer.Factory) r1     // Catch: java.lang.reflect.InvocationTargetException -> L9f java.lang.IllegalAccessException -> La8 java.lang.NoSuchMethodException -> Lb1 java.lang.ClassNotFoundException -> Lba
            r5 = r1
            goto Lc2
        L9f:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ServerImplBuilder.log
            java.util.logging.Level r3 = java.util.logging.Level.FINE
            r2.log(r3, r6, r1)
            goto Lc2
        La8:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ServerImplBuilder.log
            java.util.logging.Level r3 = java.util.logging.Level.FINE
            r2.log(r3, r6, r1)
            goto Lc2
        Lb1:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ServerImplBuilder.log
            java.util.logging.Level r3 = java.util.logging.Level.FINE
            r2.log(r3, r6, r1)
            goto Lc2
        Lba:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ServerImplBuilder.log
            java.util.logging.Level r3 = java.util.logging.Level.FINE
            r2.log(r3, r6, r1)
        Lc2:
            if (r5 == 0) goto Lc7
            r0.add(r5)
        Lc7:
            java.util.List<io.grpc.ServerStreamTracer$Factory> r1 = r13.streamTracerFactories
            r0.addAll(r1)
            r0.trimToSize()
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ServerImplBuilder.getTracerFactories():java.util.List");
    }

    public InternalChannelz getChannelz() {
        return this.channelz;
    }

    private static final class DefaultFallbackRegistry extends HandlerRegistry {
        @Override // io.grpc.HandlerRegistry
        @Nullable
        public ServerMethodDefinition<?, ?> lookupMethod(String str, @Nullable String str2) {
            return null;
        }

        private DefaultFallbackRegistry() {
        }

        @Override // io.grpc.HandlerRegistry
        public List<ServerServiceDefinition> getServices() {
            return Collections.emptyList();
        }
    }

    public ObjectPool<? extends Executor> getExecutorPool() {
        return this.executorPool;
    }

    @Override // io.grpc.ServerBuilder
    public ServerImplBuilder useTransportSecurity(File file, File file2) {
        throw new UnsupportedOperationException("TLS not supported in ServerImplBuilder");
    }
}
