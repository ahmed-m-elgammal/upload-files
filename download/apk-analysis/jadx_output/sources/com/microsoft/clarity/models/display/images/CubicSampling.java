package com.microsoft.clarity.models.display.images;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Sampling;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/microsoft/clarity/models/display/images/CubicSampling;", "Lcom/microsoft/clarity/models/display/images/Sampling;", "B", "", "C", "(FF)V", "getB", "()F", "getC", "type", "Lcom/microsoft/clarity/models/display/images/SamplingType;", "getType", "()Lcom/microsoft/clarity/models/display/images/SamplingType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Sampling;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CubicSampling extends Sampling {
    private final float B;
    private final float C;
    private final SamplingType type = SamplingType.CubicSampling;

    public CubicSampling(float f, float f2) {
        this.B = f;
        this.C = f2;
    }

    public static /* synthetic */ CubicSampling copy$default(CubicSampling cubicSampling, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = cubicSampling.B;
        }
        if ((i & 2) != 0) {
            f2 = cubicSampling.C;
        }
        return cubicSampling.copy(f, f2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getB() {
        return this.B;
    }

    /* renamed from: component2, reason: from getter */
    public final float getC() {
        return this.C;
    }

    public final CubicSampling copy(float B, float C) {
        return new CubicSampling(B, C);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CubicSampling)) {
            return false;
        }
        CubicSampling cubicSampling = (CubicSampling) other;
        return Float.compare(this.B, cubicSampling.B) == 0 && Float.compare(this.C, cubicSampling.C) == 0;
    }

    public final float getB() {
        return this.B;
    }

    public final float getC() {
        return this.C;
    }

    @Override // com.microsoft.clarity.models.display.images.Sampling
    public SamplingType getType() {
        return this.type;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.C) + (Float.floatToIntBits(this.B) * 31);
    }

    public String toString() {
        return "CubicSampling(B=" + this.B + ", C=" + this.C + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Sampling toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$Sampling.newBuilder().a(getType().toProtobufType()).a(this.B).b(this.C).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …C(C)\n            .build()");
        return (MutationPayload$Sampling) build;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy, reason: merged with bridge method [inline-methods] */
    public Sampling copy2() {
        return new CubicSampling(this.B, this.C);
    }
}
