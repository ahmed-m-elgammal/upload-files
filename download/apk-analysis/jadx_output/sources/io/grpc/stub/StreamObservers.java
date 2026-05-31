package io.grpc.stub;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.common.base.Preconditions;
import java.util.Iterator;

@Deprecated
/* loaded from: classes6.dex */
public final class StreamObservers {
    public static <V> void copyWithFlowControl(final Iterator<V> it, final CallStreamObserver<V> callStreamObserver) {
        Preconditions.checkNotNull(it, "source");
        Preconditions.checkNotNull(callStreamObserver, TouchesHelper.TARGET_KEY);
        callStreamObserver.setOnReadyHandler(new Runnable() { // from class: io.grpc.stub.StreamObservers.1FlowControllingOnReadyHandler
            private boolean completed;

            @Override // java.lang.Runnable
            public void run() {
                if (this.completed) {
                    return;
                }
                while (CallStreamObserver.this.isReady() && it.hasNext()) {
                    CallStreamObserver.this.onNext(it.next());
                }
                if (it.hasNext()) {
                    return;
                }
                this.completed = true;
                CallStreamObserver.this.onCompleted();
            }
        });
    }

    public static <V> void copyWithFlowControl(Iterable<V> iterable, CallStreamObserver<V> callStreamObserver) {
        Preconditions.checkNotNull(iterable, "source");
        copyWithFlowControl(iterable.iterator(), callStreamObserver);
    }
}
