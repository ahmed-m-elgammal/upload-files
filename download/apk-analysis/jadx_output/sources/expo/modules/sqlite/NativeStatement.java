package expo.modules.sqlite;

import expo.modules.kotlin.sharedobjects.SharedRef;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeStatement.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lexpo/modules/sqlite/NativeStatement;", "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "Lexpo/modules/sqlite/NativeStatementBinding;", "()V", "isFinalized", "", "()Z", "setFinalized", "(Z)V", "deallocate", "", "equals", "other", "", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeStatement extends SharedRef<NativeStatementBinding> {
    private boolean isFinalized;

    public NativeStatement() {
        super(new NativeStatementBinding(), null, 2, null);
    }

    /* renamed from: isFinalized, reason: from getter */
    public final boolean getIsFinalized() {
        return this.isFinalized;
    }

    public final void setFinalized(boolean z) {
        this.isFinalized = z;
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void deallocate() {
        super.deallocate();
        getRef().close();
    }

    public boolean equals(Object other) {
        return (other instanceof NativeStatement) && Intrinsics.areEqual(getRef(), ((NativeStatement) other).getRef());
    }
}
