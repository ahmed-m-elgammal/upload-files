package com.microsoft.clarity.models.display.paints;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.paints.colorfilters.ColorFilter;
import com.microsoft.clarity.models.display.paints.loopers.Looper;
import com.microsoft.clarity.models.display.paints.maskfilters.MaskFilter;
import com.microsoft.clarity.models.display.paints.patheffects.PathEffect;
import com.microsoft.clarity.models.display.paints.shaders.Shader;
import com.microsoft.clarity.protomodels.mutationpayload.G;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Paint;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u007f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bJ\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\t\u0010?\u001a\u00020\u000fHÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\b\u0010A\u001a\u00020\u0000H\u0016J\u009f\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÆ\u0001J\u0013\u0010B\u001a\u00020\u000f2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\b\u0010G\u001a\u00020\u0002H\u0016J\t\u0010H\u001a\u00020IHÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001f¨\u0006J"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/Paint;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Paint;", "Lcom/microsoft/clarity/models/ICopyable;", "color", "Lcom/microsoft/clarity/models/display/paints/Color4f;", "style", "", "blendMode", "strokeCap", "strokeJoin", "strokeWidth", "", "strokeMiter", "antiAlias", "", "dither", "colorFilter", "Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilter;", "maskFilter", "Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilter;", "shader", "Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "looper", "Lcom/microsoft/clarity/models/display/paints/loopers/Looper;", "pathEffect", "Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffect;", "(Lcom/microsoft/clarity/models/display/paints/Color4f;JJJJFFZZLcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilter;Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilter;Lcom/microsoft/clarity/models/display/paints/shaders/Shader;Lcom/microsoft/clarity/models/display/paints/loopers/Looper;Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffect;)V", "getAntiAlias", "()Z", "getBlendMode", "()J", "getColor", "()Lcom/microsoft/clarity/models/display/paints/Color4f;", "getColorFilter", "()Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilter;", "getDither", "getLooper", "()Lcom/microsoft/clarity/models/display/paints/loopers/Looper;", "getMaskFilter", "()Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilter;", "getPathEffect", "()Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffect;", "getShader", "()Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "getStrokeCap", "getStrokeJoin", "getStrokeMiter", "()F", "getStrokeWidth", "getStyle", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Paint implements IProtoModel<MutationPayload$Paint>, ICopyable<Paint> {
    private final boolean antiAlias;
    private final long blendMode;
    private final Color4f color;
    private final ColorFilter colorFilter;
    private final boolean dither;
    private final Looper looper;
    private final MaskFilter maskFilter;
    private final PathEffect pathEffect;
    private final Shader shader;
    private final long strokeCap;
    private final long strokeJoin;
    private final float strokeMiter;
    private final float strokeWidth;
    private final long style;

    public Paint(Color4f color, long j, long j2, long j3, long j4, float f, float f2, boolean z, boolean z2, ColorFilter colorFilter, MaskFilter maskFilter, Shader shader, Looper looper, PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.style = j;
        this.blendMode = j2;
        this.strokeCap = j3;
        this.strokeJoin = j4;
        this.strokeWidth = f;
        this.strokeMiter = f2;
        this.antiAlias = z;
        this.dither = z2;
        this.colorFilter = colorFilter;
        this.maskFilter = maskFilter;
        this.shader = shader;
        this.looper = looper;
        this.pathEffect = pathEffect;
    }

    /* renamed from: component1, reason: from getter */
    public final Color4f getColor() {
        return this.color;
    }

    /* renamed from: component10, reason: from getter */
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* renamed from: component11, reason: from getter */
    public final MaskFilter getMaskFilter() {
        return this.maskFilter;
    }

    /* renamed from: component12, reason: from getter */
    public final Shader getShader() {
        return this.shader;
    }

    /* renamed from: component13, reason: from getter */
    public final Looper getLooper() {
        return this.looper;
    }

    /* renamed from: component14, reason: from getter */
    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStyle() {
        return this.style;
    }

    /* renamed from: component3, reason: from getter */
    public final long getBlendMode() {
        return this.blendMode;
    }

    /* renamed from: component4, reason: from getter */
    public final long getStrokeCap() {
        return this.strokeCap;
    }

    /* renamed from: component5, reason: from getter */
    public final long getStrokeJoin() {
        return this.strokeJoin;
    }

    /* renamed from: component6, reason: from getter */
    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    /* renamed from: component7, reason: from getter */
    public final float getStrokeMiter() {
        return this.strokeMiter;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAntiAlias() {
        return this.antiAlias;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getDither() {
        return this.dither;
    }

    public final Paint copy(Color4f color, long style, long blendMode, long strokeCap, long strokeJoin, float strokeWidth, float strokeMiter, boolean antiAlias, boolean dither, ColorFilter colorFilter, MaskFilter maskFilter, Shader shader, Looper looper, PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new Paint(color, style, blendMode, strokeCap, strokeJoin, strokeWidth, strokeMiter, antiAlias, dither, colorFilter, maskFilter, shader, looper, pathEffect);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public Paint copyWithNullData() {
        return (Paint) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Paint)) {
            return false;
        }
        Paint paint = (Paint) other;
        return Intrinsics.areEqual(this.color, paint.color) && this.style == paint.style && this.blendMode == paint.blendMode && this.strokeCap == paint.strokeCap && this.strokeJoin == paint.strokeJoin && Float.compare(this.strokeWidth, paint.strokeWidth) == 0 && Float.compare(this.strokeMiter, paint.strokeMiter) == 0 && this.antiAlias == paint.antiAlias && this.dither == paint.dither && Intrinsics.areEqual(this.colorFilter, paint.colorFilter) && Intrinsics.areEqual(this.maskFilter, paint.maskFilter) && Intrinsics.areEqual(this.shader, paint.shader) && Intrinsics.areEqual(this.looper, paint.looper) && Intrinsics.areEqual(this.pathEffect, paint.pathEffect);
    }

    public final boolean getAntiAlias() {
        return this.antiAlias;
    }

    public final long getBlendMode() {
        return this.blendMode;
    }

    public final Color4f getColor() {
        return this.color;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final boolean getDither() {
        return this.dither;
    }

    public final Looper getLooper() {
        return this.looper;
    }

    public final MaskFilter getMaskFilter() {
        return this.maskFilter;
    }

    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    public final Shader getShader() {
        return this.shader;
    }

    public final long getStrokeCap() {
        return this.strokeCap;
    }

    public final long getStrokeJoin() {
        return this.strokeJoin;
    }

    public final float getStrokeMiter() {
        return this.strokeMiter;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final long getStyle() {
        return this.style;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = (Float.floatToIntBits(this.strokeMiter) + ((Float.floatToIntBits(this.strokeWidth) + ((UByte$$ExternalSyntheticBackport0.m(this.strokeJoin) + ((UByte$$ExternalSyntheticBackport0.m(this.strokeCap) + ((UByte$$ExternalSyntheticBackport0.m(this.blendMode) + ((UByte$$ExternalSyntheticBackport0.m(this.style) + (this.color.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.antiAlias;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (floatToIntBits + i) * 31;
        boolean z2 = this.dither;
        int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        int hashCode = (i3 + (colorFilter == null ? 0 : colorFilter.hashCode())) * 31;
        MaskFilter maskFilter = this.maskFilter;
        int hashCode2 = (hashCode + (maskFilter == null ? 0 : maskFilter.hashCode())) * 31;
        Shader shader = this.shader;
        int hashCode3 = (hashCode2 + (shader == null ? 0 : shader.hashCode())) * 31;
        Looper looper = this.looper;
        int hashCode4 = (hashCode3 + (looper == null ? 0 : looper.hashCode())) * 31;
        PathEffect pathEffect = this.pathEffect;
        return hashCode4 + (pathEffect != null ? pathEffect.hashCode() : 0);
    }

    public String toString() {
        return "Paint(color=" + this.color + ", style=" + this.style + ", blendMode=" + this.blendMode + ", strokeCap=" + this.strokeCap + ", strokeJoin=" + this.strokeJoin + ", strokeWidth=" + this.strokeWidth + ", strokeMiter=" + this.strokeMiter + ", antiAlias=" + this.antiAlias + ", dither=" + this.dither + ", colorFilter=" + this.colorFilter + ", maskFilter=" + this.maskFilter + ", shader=" + this.shader + ", looper=" + this.looper + ", pathEffect=" + this.pathEffect + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Paint toProtobufInstance() {
        G b = MutationPayload$Paint.newBuilder().a(this.color.toProtobufInstance()).d(this.style).a(this.blendMode).b(this.strokeCap).c(this.strokeJoin).b(this.strokeWidth).a(this.strokeMiter).a(this.antiAlias).b(this.dither);
        ColorFilter colorFilter = this.colorFilter;
        if (colorFilter != null) {
            b.a(colorFilter.toProtobufInstance());
        }
        MaskFilter maskFilter = this.maskFilter;
        if (maskFilter != null) {
            b.a(maskFilter.toProtobufInstance());
        }
        Shader shader = this.shader;
        if (shader != null) {
            b.a(shader.toProtobufInstance());
        }
        Looper looper = this.looper;
        if (looper != null) {
            b.a(looper.toProtobufInstance());
        }
        PathEffect pathEffect = this.pathEffect;
        if (pathEffect != null) {
            b.a(pathEffect.toProtobufInstance());
        }
        GeneratedMessageLite build = b.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$Paint) build;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Paint copy2() {
        Color4f copy2 = this.color.copy2();
        long j = this.style;
        long j2 = this.blendMode;
        long j3 = this.strokeCap;
        long j4 = this.strokeJoin;
        float f = this.strokeWidth;
        float f2 = this.strokeMiter;
        boolean z = this.antiAlias;
        boolean z2 = this.dither;
        ColorFilter colorFilter = this.colorFilter;
        ColorFilter copy22 = colorFilter != null ? colorFilter.copy2() : null;
        MaskFilter maskFilter = this.maskFilter;
        MaskFilter copy23 = maskFilter != null ? maskFilter.copy2() : null;
        Shader shader = this.shader;
        Shader copy24 = shader != null ? shader.copy2() : null;
        Looper looper = this.looper;
        Looper copy25 = looper != null ? looper.copy2() : null;
        PathEffect pathEffect = this.pathEffect;
        return new Paint(copy2, j, j2, j3, j4, f, f2, z, z2, copy22, copy23, copy24, copy25, pathEffect != null ? pathEffect.copy2() : null);
    }
}
