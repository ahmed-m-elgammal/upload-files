package com.microsoft.clarity.models.display.paths;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathVerb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\b\u0010\u001b\u001a\u00020\u0000H\u0016JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020#H\u0016J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b¨\u0006&"}, d2 = {"Lcom/microsoft/clarity/models/display/paths/CubicPathVerb;", "Lcom/microsoft/clarity/models/display/paths/PathVerb;", "cpx1", "", "cpy1", "cpx2", "cpy2", "x", "y", "(FFFFFF)V", "getCpx1", "()F", "getCpx2", "getCpy1", "getCpy2", "type", "Lcom/microsoft/clarity/models/display/paths/PathVerbType;", "getType", "()Lcom/microsoft/clarity/models/display/paths/PathVerbType;", "getX", "getY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$PathVerb;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CubicPathVerb extends PathVerb {
    private final float cpx1;
    private final float cpx2;
    private final float cpy1;
    private final float cpy2;
    private final PathVerbType type = PathVerbType.CubicPathVerb;
    private final float x;
    private final float y;

    public CubicPathVerb(float f, float f2, float f3, float f4, float f5, float f6) {
        this.cpx1 = f;
        this.cpy1 = f2;
        this.cpx2 = f3;
        this.cpy2 = f4;
        this.x = f5;
        this.y = f6;
    }

    public static /* synthetic */ CubicPathVerb copy$default(CubicPathVerb cubicPathVerb, float f, float f2, float f3, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = cubicPathVerb.cpx1;
        }
        if ((i & 2) != 0) {
            f2 = cubicPathVerb.cpy1;
        }
        float f7 = f2;
        if ((i & 4) != 0) {
            f3 = cubicPathVerb.cpx2;
        }
        float f8 = f3;
        if ((i & 8) != 0) {
            f4 = cubicPathVerb.cpy2;
        }
        float f9 = f4;
        if ((i & 16) != 0) {
            f5 = cubicPathVerb.x;
        }
        float f10 = f5;
        if ((i & 32) != 0) {
            f6 = cubicPathVerb.y;
        }
        return cubicPathVerb.copy(f, f7, f8, f9, f10, f6);
    }

    /* renamed from: component1, reason: from getter */
    public final float getCpx1() {
        return this.cpx1;
    }

    /* renamed from: component2, reason: from getter */
    public final float getCpy1() {
        return this.cpy1;
    }

    /* renamed from: component3, reason: from getter */
    public final float getCpx2() {
        return this.cpx2;
    }

    /* renamed from: component4, reason: from getter */
    public final float getCpy2() {
        return this.cpy2;
    }

    /* renamed from: component5, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: component6, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public final CubicPathVerb copy(float cpx1, float cpy1, float cpx2, float cpy2, float x, float y) {
        return new CubicPathVerb(cpx1, cpy1, cpx2, cpy2, x, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CubicPathVerb)) {
            return false;
        }
        CubicPathVerb cubicPathVerb = (CubicPathVerb) other;
        return Float.compare(this.cpx1, cubicPathVerb.cpx1) == 0 && Float.compare(this.cpy1, cubicPathVerb.cpy1) == 0 && Float.compare(this.cpx2, cubicPathVerb.cpx2) == 0 && Float.compare(this.cpy2, cubicPathVerb.cpy2) == 0 && Float.compare(this.x, cubicPathVerb.x) == 0 && Float.compare(this.y, cubicPathVerb.y) == 0;
    }

    public final float getCpx1() {
        return this.cpx1;
    }

    public final float getCpx2() {
        return this.cpx2;
    }

    public final float getCpy1() {
        return this.cpy1;
    }

    public final float getCpy2() {
        return this.cpy2;
    }

    @Override // com.microsoft.clarity.models.display.paths.PathVerb
    public PathVerbType getType() {
        return this.type;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.y) + ((Float.floatToIntBits(this.x) + ((Float.floatToIntBits(this.cpy2) + ((Float.floatToIntBits(this.cpx2) + ((Float.floatToIntBits(this.cpy1) + (Float.floatToIntBits(this.cpx1) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "CubicPathVerb(cpx1=" + this.cpx1 + ", cpy1=" + this.cpy1 + ", cpx2=" + this.cpx2 + ", cpy2=" + this.cpy2 + ", x=" + this.x + ", y=" + this.y + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$PathVerb toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$PathVerb.newBuilder().a(getType().toProtobufType()).a(this.cpx1).c(this.cpy1).b(this.cpx2).d(this.cpy2).f(this.x).i(this.y).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …Y(y)\n            .build()");
        return (MutationPayload$PathVerb) build;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public PathVerb copy2() {
        return new CubicPathVerb(this.cpx1, this.cpy1, this.cpx2, this.cpy2, this.x, this.y);
    }
}
