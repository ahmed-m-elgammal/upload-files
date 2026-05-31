package expo.modules.sqlite;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SQLRecords.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J%\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R$\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lexpo/modules/sqlite/Query;", "Lexpo/modules/kotlin/records/Record;", "sql", "", "args", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "getArgs$annotations", "()V", "getArgs", "()Ljava/util/List;", "getSql$annotations", "getSql", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class Query implements Record {
    private final List<Object> args;
    private final String sql;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Query copy$default(Query query, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = query.sql;
        }
        if ((i & 2) != 0) {
            list = query.args;
        }
        return query.copy(str, list);
    }

    @Field
    public static /* synthetic */ void getArgs$annotations() {
    }

    @Field
    public static /* synthetic */ void getSql$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getSql() {
        return this.sql;
    }

    public final List<Object> component2() {
        return this.args;
    }

    public final Query copy(String sql, List<? extends Object> args) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(args, "args");
        return new Query(sql, args);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Query)) {
            return false;
        }
        Query query = (Query) other;
        return Intrinsics.areEqual(this.sql, query.sql) && Intrinsics.areEqual(this.args, query.args);
    }

    public int hashCode() {
        return (this.sql.hashCode() * 31) + this.args.hashCode();
    }

    public String toString() {
        return "Query(sql=" + this.sql + ", args=" + this.args + ")";
    }

    public Query(String sql, List<? extends Object> args) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(args, "args");
        this.sql = sql;
        this.args = args;
    }

    public final String getSql() {
        return this.sql;
    }

    public final List<Object> getArgs() {
        return this.args;
    }
}
