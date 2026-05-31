package com.microsoft.clarity.models.display.common;

import com.microsoft.clarity.i.C0107a;
import com.microsoft.clarity.models.AssetType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0010\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/microsoft/clarity/models/display/common/Asset;", "", "Lcom/microsoft/clarity/models/AssetType;", "type", "Lcom/microsoft/clarity/i/a;", "data", "", "dataHash", "<init>", "(Lcom/microsoft/clarity/models/AssetType;Lcom/microsoft/clarity/i/a;Ljava/lang/String;)V", "Lcom/microsoft/clarity/models/AssetType;", "getType", "()Lcom/microsoft/clarity/models/AssetType;", "setType", "(Lcom/microsoft/clarity/models/AssetType;)V", "Lcom/microsoft/clarity/i/a;", "getData", "()Lcom/microsoft/clarity/i/a;", "Ljava/lang/String;", "getDataHash", "()Ljava/lang/String;", "setDataHash", "(Ljava/lang/String;)V", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class Asset {
    private final transient C0107a data;
    private String dataHash;
    private transient AssetType type;

    public Asset(AssetType type, C0107a c0107a, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.data = c0107a;
        this.dataHash = str;
    }

    public final C0107a getData() {
        return this.data;
    }

    public final String getDataHash() {
        return this.dataHash;
    }

    public final AssetType getType() {
        return this.type;
    }

    public final void setDataHash(String str) {
        this.dataHash = str;
    }

    public final void setType(AssetType assetType) {
        Intrinsics.checkNotNullParameter(assetType, "<set-?>");
        this.type = assetType;
    }
}
