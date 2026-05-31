package expo.modules.sqlite;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SQLExceptions.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/sqlite/DeleteDatabaseException;", "Lexpo/modules/kotlin/exception/CodedException;", "name", "", "(Ljava/lang/String;)V", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DeleteDatabaseException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteDatabaseException(String name) {
        super("Unable to delete database '" + name + "' that is currently open. Close it prior to deletion.", null, 2, null);
        Intrinsics.checkNotNullParameter(name, "name");
    }
}
