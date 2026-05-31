package com.microsoft.clarity.models.display.paints;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Color4f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\b\u0010\u0013\u001a\u00020\u0000H\u0016J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/Color4f;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Color4f;", "Lcom/microsoft/clarity/models/ICopyable;", "r", "", "g", "b", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "(FFFF)V", "getA", "()F", "getB", "getG", "getR", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Color4f implements IProtoModel<MutationPayload$Color4f>, ICopyable<Color4f> {
    private final float a;
    private final float b;
    private final float g;
    private final float r;

    public Color4f(float f, float f2, float f3, float f4) {
        this.r = f;
        this.g = f2;
        this.b = f3;
        this.a = f4;
    }

    public static /* synthetic */ Color4f copy$default(Color4f color4f, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = color4f.r;
        }
        if ((i & 2) != 0) {
            f2 = color4f.g;
        }
        if ((i & 4) != 0) {
            f3 = color4f.b;
        }
        if ((i & 8) != 0) {
            f4 = color4f.a;
        }
        return color4f.copy(f, f2, f3, f4);
    }

    /* renamed from: component1, reason: from getter */
    public final float getR() {
        return this.r;
    }

    /* renamed from: component2, reason: from getter */
    public final float getG() {
        return this.g;
    }

    /* renamed from: component3, reason: from getter */
    public final float getB() {
        return this.b;
    }

    /* renamed from: component4, reason: from getter */
    public final float getA() {
        return this.a;
    }

    public final Color4f copy(float r, float g, float b, float a2) {
        return new Color4f(r, g, b, a2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public Color4f copyWithNullData() {
        return (Color4f) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Color4f)) {
            return false;
        }
        Color4f color4f = (Color4f) other;
        return Float.compare(this.r, color4f.r) == 0 && Float.compare(this.g, color4f.g) == 0 && Float.compare(this.b, color4f.b) == 0 && Float.compare(this.a, color4f.a) == 0;
    }

    public final float getA() {
        return this.a;
    }

    public final float getB() {
        return this.b;
    }

    public final float getG() {
        return this.g;
    }

    public final float getR() {
        return this.r;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.a) + ((Float.floatToIntBits(this.b) + ((Float.floatToIntBits(this.g) + (Float.floatToIntBits(this.r) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "Color4f(r=" + this.r + ", g=" + this.g + ", b=" + this.b + ", a=" + this.a + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Color4f toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$Color4f.newBuilder().a(this.a).b(this.b).c(this.g).d(this.r).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …R(r)\n            .build()");
        return (MutationPayload$Color4f) build;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public Color4f copy() {
        return new Color4f(this.r, this.g, this.b, this.a);
    }
}
