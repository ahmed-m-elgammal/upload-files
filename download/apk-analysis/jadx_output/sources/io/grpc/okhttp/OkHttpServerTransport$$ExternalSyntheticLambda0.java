package io.grpc.okhttp;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes6.dex */
public final /* synthetic */ class OkHttpServerTransport$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ OkHttpServerTransport f$0;

    public /* synthetic */ OkHttpServerTransport$$ExternalSyntheticLambda0(OkHttpServerTransport okHttpServerTransport) {
        this.f$0 = okHttpServerTransport;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.triggerForcefulClose();
    }
}
