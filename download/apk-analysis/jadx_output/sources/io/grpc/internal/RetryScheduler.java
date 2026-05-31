package io.grpc.internal;

/* loaded from: classes6.dex */
public interface RetryScheduler {
    void reset();

    void schedule(Runnable runnable);
}
