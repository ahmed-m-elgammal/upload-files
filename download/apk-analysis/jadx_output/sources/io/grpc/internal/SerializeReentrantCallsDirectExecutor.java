package io.grpc.internal;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
class SerializeReentrantCallsDirectExecutor implements Executor {
    private static final Logger log = Logger.getLogger(SerializeReentrantCallsDirectExecutor.class.getName());
    private boolean executing;
    private ArrayDeque<Runnable> taskQueue;

    SerializeReentrantCallsDirectExecutor() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r6.taskQueue == null) goto L9;
     */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(java.lang.Runnable r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Exception while executing runnable "
            java.lang.String r1 = "'task' must not be null."
            com.google.common.base.Preconditions.checkNotNull(r7, r1)
            boolean r1 = r6.executing
            if (r1 != 0) goto L40
            r1 = 1
            r6.executing = r1
            r1 = 0
            r7.run()     // Catch: java.lang.Throwable -> L1c
            java.util.ArrayDeque<java.lang.Runnable> r7 = r6.taskQueue
            if (r7 == 0) goto L19
        L16:
            r6.completeQueuedTasks()
        L19:
            r6.executing = r1
            goto L43
        L1c:
            r2 = move-exception
            java.util.logging.Logger r3 = io.grpc.internal.SerializeReentrantCallsDirectExecutor.log     // Catch: java.lang.Throwable -> L35
            java.util.logging.Level r4 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L35
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L35
            r5.append(r7)     // Catch: java.lang.Throwable -> L35
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L35
            r3.log(r4, r7, r2)     // Catch: java.lang.Throwable -> L35
            java.util.ArrayDeque<java.lang.Runnable> r7 = r6.taskQueue
            if (r7 == 0) goto L19
            goto L16
        L35:
            r7 = move-exception
            java.util.ArrayDeque<java.lang.Runnable> r0 = r6.taskQueue
            if (r0 == 0) goto L3d
            r6.completeQueuedTasks()
        L3d:
            r6.executing = r1
            throw r7
        L40:
            r6.enqueue(r7)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.SerializeReentrantCallsDirectExecutor.execute(java.lang.Runnable):void");
    }

    private void completeQueuedTasks() {
        while (true) {
            Runnable poll = this.taskQueue.poll();
            if (poll == null) {
                return;
            }
            try {
                poll.run();
            } catch (Throwable th) {
                log.log(Level.SEVERE, "Exception while executing runnable " + poll, th);
            }
        }
    }

    private void enqueue(Runnable runnable) {
        if (this.taskQueue == null) {
            this.taskQueue = new ArrayDeque<>(4);
        }
        this.taskQueue.add(runnable);
    }
}
