package expo.modules.sqlite;

import expo.modules.kotlin.sharedobjects.SharedRef;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeDatabase.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0013\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lexpo/modules/sqlite/NativeDatabase;", "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "Lexpo/modules/sqlite/NativeDatabaseBinding;", "databaseName", "", "openOptions", "Lexpo/modules/sqlite/OpenDatabaseOptions;", "(Ljava/lang/String;Lexpo/modules/sqlite/OpenDatabaseOptions;)V", "getDatabaseName", "()Ljava/lang/String;", "isClosed", "", "()Z", "setClosed", "(Z)V", "getOpenOptions", "()Lexpo/modules/sqlite/OpenDatabaseOptions;", "refCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "addRef", "", "addRef$expo_sqlite_release", "deallocate", "equals", "other", "", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeDatabase extends SharedRef<NativeDatabaseBinding> {
    private final String databaseName;
    private boolean isClosed;
    private final OpenDatabaseOptions openOptions;
    private final AtomicInteger refCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeDatabase(String databaseName, OpenDatabaseOptions openOptions) {
        super(new NativeDatabaseBinding(), null, 2, null);
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        Intrinsics.checkNotNullParameter(openOptions, "openOptions");
        this.databaseName = databaseName;
        this.openOptions = openOptions;
        this.refCount = new AtomicInteger(1);
    }

    public final String getDatabaseName() {
        return this.databaseName;
    }

    public final OpenDatabaseOptions getOpenOptions() {
        return this.openOptions;
    }

    /* renamed from: isClosed, reason: from getter */
    public final boolean getIsClosed() {
        return this.isClosed;
    }

    public final void setClosed(boolean z) {
        this.isClosed = z;
    }

    public final void addRef$expo_sqlite_release() {
        this.refCount.incrementAndGet();
    }

    public boolean equals(Object other) {
        return (other instanceof NativeDatabase) && Intrinsics.areEqual(getRef(), ((NativeDatabase) other).getRef());
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void deallocate() {
        super.deallocate();
        if (this.refCount.decrementAndGet() <= 0) {
            getRef().close();
        }
    }
}
