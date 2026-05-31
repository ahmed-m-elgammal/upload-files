package io.grpc;

/* loaded from: classes6.dex */
public abstract class ClientTransportFilter {
    public Attributes transportReady(Attributes attributes) {
        return attributes;
    }

    public void transportTerminated(Attributes attributes) {
    }
}
