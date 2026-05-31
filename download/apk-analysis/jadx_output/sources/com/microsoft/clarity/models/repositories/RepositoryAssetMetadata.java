package com.microsoft.clarity.models.repositories;

import com.microsoft.clarity.models.AssetType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/microsoft/clarity/models/repositories/RepositoryAssetMetadata;", "", "type", "Lcom/microsoft/clarity/models/AssetType;", "id", "", "(Lcom/microsoft/clarity/models/AssetType;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/microsoft/clarity/models/AssetType;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RepositoryAssetMetadata {
    private final String id;
    private final AssetType type;

    public RepositoryAssetMetadata(AssetType type, String id) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        this.type = type;
        this.id = id;
    }

    public final String getId() {
        return this.id;
    }

    public final AssetType getType() {
        return this.type;
    }
}
