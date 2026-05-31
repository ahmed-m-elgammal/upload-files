package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Status;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface ManagedClientTransport extends ClientTransport {

    public interface Listener {

        /* renamed from: io.grpc.internal.ManagedClientTransport$Listener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Attributes $default$filterTransport(Listener _this, Attributes attributes) {
                return attributes;
            }
        }

        Attributes filterTransport(Attributes attributes);

        void transportInUse(boolean z);

        void transportReady();

        void transportShutdown(Status status);

        void transportTerminated();
    }

    void shutdown(Status status);

    void shutdownNow(Status status);

    @CheckReturnValue
    @Nullable
    Runnable start(Listener listener);
}
