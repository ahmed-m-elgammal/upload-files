package com.microsoft.clarity.models.display.images;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Sampling;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\b\u0010\f\u001a\u00020\u0001H\u0016J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/microsoft/clarity/models/display/images/AnisoSampling;", "Lcom/microsoft/clarity/models/display/images/Sampling;", "maxAniso", "", "(I)V", "getMaxAniso", "()I", "type", "Lcom/microsoft/clarity/models/display/images/SamplingType;", "getType", "()Lcom/microsoft/clarity/models/display/images/SamplingType;", "component1", "copy", "equals", "", "other", "", "hashCode", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Sampling;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AnisoSampling extends Sampling {
    private final int maxAniso;
    private final SamplingType type = SamplingType.AnisoSampling;

    public AnisoSampling(int i) {
        this.maxAniso = i;
    }

    public static /* synthetic */ AnisoSampling copy$default(AnisoSampling anisoSampling, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = anisoSampling.maxAniso;
        }
        return anisoSampling.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMaxAniso() {
        return this.maxAniso;
    }

    public final AnisoSampling copy(int maxAniso) {
        return new AnisoSampling(maxAniso);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnisoSampling) && this.maxAniso == ((AnisoSampling) other).maxAniso;
    }

    public final int getMaxAniso() {
        return this.maxAniso;
    }

    @Override // com.microsoft.clarity.models.display.images.Sampling
    public SamplingType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.maxAniso;
    }

    public String toString() {
        return "AnisoSampling(maxAniso=" + this.maxAniso + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Sampling toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$Sampling.newBuilder().a(getType().toProtobufType()).b(this.maxAniso).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …iso)\n            .build()");
        return (MutationPayload$Sampling) build;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Sampling copy2() {
        return new AnisoSampling(this.maxAniso);
    }
}
