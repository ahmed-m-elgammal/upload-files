package expo.modules.sqlite;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.imagepicker.Utils$$ExternalSyntheticBackport0;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SQLiteOptions.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lexpo/modules/sqlite/OpenDatabaseOptions;", "Lexpo/modules/kotlin/records/Record;", "enableCRSQLite", "", "enableChangeListener", "useNewConnection", "finalizeUnusedStatementsBeforeClosing", "(ZZZZ)V", "getEnableCRSQLite$annotations", "()V", "getEnableCRSQLite", "()Z", "getEnableChangeListener$annotations", "getEnableChangeListener", "getFinalizeUnusedStatementsBeforeClosing$annotations", "getFinalizeUnusedStatementsBeforeClosing", "getUseNewConnection$annotations", "getUseNewConnection", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-sqlite_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class OpenDatabaseOptions implements Record {
    private final boolean enableCRSQLite;
    private final boolean enableChangeListener;
    private final boolean finalizeUnusedStatementsBeforeClosing;
    private final boolean useNewConnection;

    public OpenDatabaseOptions() {
        this(false, false, false, false, 15, null);
    }

    public static /* synthetic */ OpenDatabaseOptions copy$default(OpenDatabaseOptions openDatabaseOptions, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = openDatabaseOptions.enableCRSQLite;
        }
        if ((i & 2) != 0) {
            z2 = openDatabaseOptions.enableChangeListener;
        }
        if ((i & 4) != 0) {
            z3 = openDatabaseOptions.useNewConnection;
        }
        if ((i & 8) != 0) {
            z4 = openDatabaseOptions.finalizeUnusedStatementsBeforeClosing;
        }
        return openDatabaseOptions.copy(z, z2, z3, z4);
    }

    @Field
    public static /* synthetic */ void getEnableCRSQLite$annotations() {
    }

    @Field
    public static /* synthetic */ void getEnableChangeListener$annotations() {
    }

    @Field
    public static /* synthetic */ void getFinalizeUnusedStatementsBeforeClosing$annotations() {
    }

    @Field
    public static /* synthetic */ void getUseNewConnection$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableCRSQLite() {
        return this.enableCRSQLite;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnableChangeListener() {
        return this.enableChangeListener;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getUseNewConnection() {
        return this.useNewConnection;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getFinalizeUnusedStatementsBeforeClosing() {
        return this.finalizeUnusedStatementsBeforeClosing;
    }

    public final OpenDatabaseOptions copy(boolean enableCRSQLite, boolean enableChangeListener, boolean useNewConnection, boolean finalizeUnusedStatementsBeforeClosing) {
        return new OpenDatabaseOptions(enableCRSQLite, enableChangeListener, useNewConnection, finalizeUnusedStatementsBeforeClosing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenDatabaseOptions)) {
            return false;
        }
        OpenDatabaseOptions openDatabaseOptions = (OpenDatabaseOptions) other;
        return this.enableCRSQLite == openDatabaseOptions.enableCRSQLite && this.enableChangeListener == openDatabaseOptions.enableChangeListener && this.useNewConnection == openDatabaseOptions.useNewConnection && this.finalizeUnusedStatementsBeforeClosing == openDatabaseOptions.finalizeUnusedStatementsBeforeClosing;
    }

    public int hashCode() {
        return (((((Utils$$ExternalSyntheticBackport0.m(this.enableCRSQLite) * 31) + Utils$$ExternalSyntheticBackport0.m(this.enableChangeListener)) * 31) + Utils$$ExternalSyntheticBackport0.m(this.useNewConnection)) * 31) + Utils$$ExternalSyntheticBackport0.m(this.finalizeUnusedStatementsBeforeClosing);
    }

    public String toString() {
        return "OpenDatabaseOptions(enableCRSQLite=" + this.enableCRSQLite + ", enableChangeListener=" + this.enableChangeListener + ", useNewConnection=" + this.useNewConnection + ", finalizeUnusedStatementsBeforeClosing=" + this.finalizeUnusedStatementsBeforeClosing + ")";
    }

    public OpenDatabaseOptions(boolean z, boolean z2, boolean z3, boolean z4) {
        this.enableCRSQLite = z;
        this.enableChangeListener = z2;
        this.useNewConnection = z3;
        this.finalizeUnusedStatementsBeforeClosing = z4;
    }

    public /* synthetic */ OpenDatabaseOptions(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? true : z4);
    }

    public final boolean getEnableCRSQLite() {
        return this.enableCRSQLite;
    }

    public final boolean getEnableChangeListener() {
        return this.enableChangeListener;
    }

    public final boolean getUseNewConnection() {
        return this.useNewConnection;
    }

    public final boolean getFinalizeUnusedStatementsBeforeClosing() {
        return this.finalizeUnusedStatementsBeforeClosing;
    }
}
