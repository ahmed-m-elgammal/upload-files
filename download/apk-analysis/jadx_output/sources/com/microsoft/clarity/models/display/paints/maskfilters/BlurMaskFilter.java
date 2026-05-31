package com.microsoft.clarity.models.display.paints.maskfilters;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$MaskFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\b\u0010\u0016\u001a\u00020\u0000H\u0016J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/maskfilters/BlurMaskFilter;", "Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilter;", "sigma", "", "style", "", "respectCTM", "", "(FIZ)V", "getRespectCTM", "()Z", "getSigma", "()F", "getStyle", "()I", "type", "Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilterType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilterType;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$MaskFilter;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BlurMaskFilter extends MaskFilter {
    private final boolean respectCTM;
    private final float sigma;
    private final int style;
    private final MaskFilterType type = MaskFilterType.BlurMaskFilter;

    public BlurMaskFilter(float f, int i, boolean z) {
        this.sigma = f;
        this.style = i;
        this.respectCTM = z;
    }

    public static /* synthetic */ BlurMaskFilter copy$default(BlurMaskFilter blurMaskFilter, float f, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = blurMaskFilter.sigma;
        }
        if ((i2 & 2) != 0) {
            i = blurMaskFilter.style;
        }
        if ((i2 & 4) != 0) {
            z = blurMaskFilter.respectCTM;
        }
        return blurMaskFilter.copy(f, i, z);
    }

    /* renamed from: component1, reason: from getter */
    public final float getSigma() {
        return this.sigma;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStyle() {
        return this.style;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getRespectCTM() {
        return this.respectCTM;
    }

    public final BlurMaskFilter copy(float sigma, int style, boolean respectCTM) {
        return new BlurMaskFilter(sigma, style, respectCTM);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlurMaskFilter)) {
            return false;
        }
        BlurMaskFilter blurMaskFilter = (BlurMaskFilter) other;
        return Float.compare(this.sigma, blurMaskFilter.sigma) == 0 && this.style == blurMaskFilter.style && this.respectCTM == blurMaskFilter.respectCTM;
    }

    public final boolean getRespectCTM() {
        return this.respectCTM;
    }

    public final float getSigma() {
        return this.sigma;
    }

    public final int getStyle() {
        return this.style;
    }

    @Override // com.microsoft.clarity.models.display.paints.maskfilters.MaskFilter
    public MaskFilterType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = (this.style + (Float.floatToIntBits(this.sigma) * 31)) * 31;
        boolean z = this.respectCTM;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return floatToIntBits + i;
    }

    public String toString() {
        return "BlurMaskFilter(sigma=" + this.sigma + ", style=" + this.style + ", respectCTM=" + this.respectCTM + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$MaskFilter toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$MaskFilter.newBuilder().a(getType().toProtobufType()).a(this.sigma).a(this.style).a(this.respectCTM).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …CTM)\n            .build()");
        return (MutationPayload$MaskFilter) build;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public MaskFilter copy2() {
        return new BlurMaskFilter(this.sigma, this.style, this.respectCTM);
    }
}
