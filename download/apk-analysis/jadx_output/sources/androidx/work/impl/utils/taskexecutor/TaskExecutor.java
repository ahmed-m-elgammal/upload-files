package androidx.work.impl.utils.taskexecutor;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public interface TaskExecutor {
    void executeOnTaskThread(Runnable runnable);

    Executor getMainThreadExecutor();

    SerialExecutor getSerialTaskExecutor();

    /* renamed from: androidx.work.impl.utils.taskexecutor.TaskExecutor$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
    }
}
