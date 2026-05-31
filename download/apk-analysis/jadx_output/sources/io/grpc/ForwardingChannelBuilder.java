package io.grpc;

import io.grpc.ForwardingChannelBuilder;
import io.grpc.NameResolver;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public abstract class ForwardingChannelBuilder<T extends ForwardingChannelBuilder<T>> extends ForwardingChannelBuilder2<T> {
    private T thisT() {
        return this;
    }

    @Override // io.grpc.ForwardingChannelBuilder2
    @Deprecated
    protected abstract ManagedChannelBuilder<?> delegate();

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder defaultServiceConfig(@Nullable Map map) {
        return defaultServiceConfig((Map<String, ?>) map);
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder intercept(List list) {
        return intercept((List<ClientInterceptor>) list);
    }

    protected ForwardingChannelBuilder() {
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T directExecutor() {
        delegate().directExecutor();
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T executor(Executor executor) {
        delegate().executor(executor);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T offloadExecutor(Executor executor) {
        delegate().offloadExecutor(executor);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T intercept(List<ClientInterceptor> list) {
        delegate().intercept(list);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T intercept(ClientInterceptor... clientInterceptorArr) {
        delegate().intercept(clientInterceptorArr);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T userAgent(String str) {
        delegate().userAgent(str);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T overrideAuthority(String str) {
        delegate().overrideAuthority(str);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T usePlaintext() {
        delegate().usePlaintext();
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T useTransportSecurity() {
        delegate().useTransportSecurity();
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    @Deprecated
    public T nameResolverFactory(NameResolver.Factory factory) {
        delegate().nameResolverFactory(factory);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T defaultLoadBalancingPolicy(String str) {
        delegate().defaultLoadBalancingPolicy(str);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T decompressorRegistry(DecompressorRegistry decompressorRegistry) {
        delegate().decompressorRegistry(decompressorRegistry);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T compressorRegistry(CompressorRegistry compressorRegistry) {
        delegate().compressorRegistry(compressorRegistry);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T idleTimeout(long j, TimeUnit timeUnit) {
        delegate().idleTimeout(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T maxInboundMessageSize(int i) {
        delegate().maxInboundMessageSize(i);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T maxInboundMetadataSize(int i) {
        delegate().maxInboundMetadataSize(i);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T keepAliveTime(long j, TimeUnit timeUnit) {
        delegate().keepAliveTime(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T keepAliveTimeout(long j, TimeUnit timeUnit) {
        delegate().keepAliveTimeout(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T keepAliveWithoutCalls(boolean z) {
        delegate().keepAliveWithoutCalls(z);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T maxRetryAttempts(int i) {
        delegate().maxRetryAttempts(i);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T maxHedgedAttempts(int i) {
        delegate().maxHedgedAttempts(i);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T retryBufferSize(long j) {
        delegate().retryBufferSize(j);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T perRpcBufferLimit(long j) {
        delegate().perRpcBufferLimit(j);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T disableRetry() {
        delegate().disableRetry();
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T enableRetry() {
        delegate().enableRetry();
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T setBinaryLog(BinaryLog binaryLog) {
        delegate().setBinaryLog(binaryLog);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T maxTraceEvents(int i) {
        delegate().maxTraceEvents(i);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T proxyDetector(ProxyDetector proxyDetector) {
        delegate().proxyDetector(proxyDetector);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T defaultServiceConfig(@Nullable Map<String, ?> map) {
        delegate().defaultServiceConfig(map);
        return thisT();
    }

    @Override // io.grpc.ForwardingChannelBuilder2, io.grpc.ManagedChannelBuilder
    public T disableServiceConfigLookUp() {
        delegate().disableServiceConfigLookUp();
        return thisT();
    }
}
