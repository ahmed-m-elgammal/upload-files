package com.microsoft.clarity.models.repositories;

import com.microsoft.clarity.models.AssetType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0015\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/microsoft/clarity/models/repositories/RepositoryAsset;", "", "type", "Lcom/microsoft/clarity/models/AssetType;", "data", "", "id", "", "(Lcom/microsoft/clarity/models/AssetType;[BLjava/lang/String;)V", "metadata", "Lcom/microsoft/clarity/models/repositories/RepositoryAssetMetadata;", "(Lcom/microsoft/clarity/models/repositories/RepositoryAssetMetadata;[B)V", "getData", "()[B", "getId", "()Ljava/lang/String;", "getMetadata", "()Lcom/microsoft/clarity/models/repositories/RepositoryAssetMetadata;", "getType", "()Lcom/microsoft/clarity/models/AssetType;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RepositoryAsset {
    private final byte[] data;
    private final RepositoryAssetMetadata metadata;

    public RepositoryAsset(RepositoryAssetMetadata metadata, byte[] data) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(data, "data");
        this.metadata = metadata;
        this.data = data;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getId() {
        return this.metadata.getId();
    }

    public final RepositoryAssetMetadata getMetadata() {
        return this.metadata;
    }

    public final AssetType getType() {
        return this.metadata.getType();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RepositoryAsset(AssetType type, byte[] data, String id) {
        this(new RepositoryAssetMetadata(type, id), data);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(id, "id");
    }
}
