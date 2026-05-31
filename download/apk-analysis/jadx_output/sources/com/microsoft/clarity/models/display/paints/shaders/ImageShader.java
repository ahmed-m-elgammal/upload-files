package com.microsoft.clarity.models.display.paints.shaders;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.display.images.Image;
import com.microsoft.clarity.models.display.images.Sampling;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Shader;
import com.microsoft.clarity.protomodels.mutationpayload.Y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003J\b\u00107\u001a\u00020\u0000H\u0016JO\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u00108\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0012HÖ\u0001J\b\u0010<\u001a\u00020=H\u0016J\t\u0010>\u001a\u00020?HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001e\u0010!\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006@"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/shaders/ImageShader;", "Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "tX", "", "tY", "matrix", "", "", "raw", "", "image", "Lcom/microsoft/clarity/models/display/images/Image;", "sampling", "Lcom/microsoft/clarity/models/display/images/Sampling;", "(JJLjava/util/List;ZLcom/microsoft/clarity/models/display/images/Image;Lcom/microsoft/clarity/models/display/images/Sampling;)V", "getImage", "()Lcom/microsoft/clarity/models/display/images/Image;", "imageIndex", "", "getImageIndex", "()Ljava/lang/Integer;", "setImageIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "maskedColor", "Lcom/microsoft/clarity/models/display/paints/Color4f;", "getMaskedColor", "()Lcom/microsoft/clarity/models/display/paints/Color4f;", "setMaskedColor", "(Lcom/microsoft/clarity/models/display/paints/Color4f;)V", "maskedHeight", "getMaskedHeight", "setMaskedHeight", "maskedWidth", "getMaskedWidth", "setMaskedWidth", "getMatrix", "()Ljava/util/List;", "getRaw", "()Z", "getSampling", "()Lcom/microsoft/clarity/models/display/images/Sampling;", "getTX", "()J", "getTY", "type", "Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Shader;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ImageShader extends Shader {
    private final transient Image image;
    private Integer imageIndex;
    private Color4f maskedColor;
    private Integer maskedHeight;
    private Integer maskedWidth;
    private final List<Float> matrix;
    private final boolean raw;
    private final Sampling sampling;
    private final long tX;
    private final long tY;
    private final ShaderType type;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ImageShader(long r14, long r16, java.util.List r18, boolean r19, com.microsoft.clarity.models.display.images.Image r20, com.microsoft.clarity.models.display.images.Sampling r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r13 = this;
            r0 = r22 & 16
            if (r0 == 0) goto L19
            com.microsoft.clarity.models.display.images.Image r0 = new com.microsoft.clarity.models.display.images.Image
            r1 = 0
            byte[] r2 = new byte[r1]
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            com.microsoft.clarity.i.a r3 = new com.microsoft.clarity.i.a
            r3.<init>(r2, r1, r1)
            r1 = 0
            r0.<init>(r1, r3, r1, r1)
            r11 = r0
            goto L1b
        L19:
            r11 = r20
        L1b:
            r4 = r13
            r5 = r14
            r7 = r16
            r9 = r18
            r10 = r19
            r12 = r21
            r4.<init>(r5, r7, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.models.display.paints.shaders.ImageShader.<init>(long, long, java.util.List, boolean, com.microsoft.clarity.models.display.images.Image, com.microsoft.clarity.models.display.images.Sampling, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: component1, reason: from getter */
    public final long getTX() {
        return this.tX;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTY() {
        return this.tY;
    }

    public final List<Float> component3() {
        return this.matrix;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getRaw() {
        return this.raw;
    }

    /* renamed from: component5, reason: from getter */
    public final Image getImage() {
        return this.image;
    }

    /* renamed from: component6, reason: from getter */
    public final Sampling getSampling() {
        return this.sampling;
    }

    public final ImageShader copy(long tX, long tY, List<Float> matrix, boolean raw, Image image, Sampling sampling) {
        Intrinsics.checkNotNullParameter(image, "image");
        return new ImageShader(tX, tY, matrix, raw, image, sampling);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageShader)) {
            return false;
        }
        ImageShader imageShader = (ImageShader) other;
        return this.tX == imageShader.tX && this.tY == imageShader.tY && Intrinsics.areEqual(this.matrix, imageShader.matrix) && this.raw == imageShader.raw && Intrinsics.areEqual(this.image, imageShader.image) && Intrinsics.areEqual(this.sampling, imageShader.sampling);
    }

    public final Image getImage() {
        return this.image;
    }

    public final Integer getImageIndex() {
        return this.imageIndex;
    }

    public final Color4f getMaskedColor() {
        return this.maskedColor;
    }

    public final Integer getMaskedHeight() {
        return this.maskedHeight;
    }

    public final Integer getMaskedWidth() {
        return this.maskedWidth;
    }

    public final List<Float> getMatrix() {
        return this.matrix;
    }

    public final boolean getRaw() {
        return this.raw;
    }

    public final Sampling getSampling() {
        return this.sampling;
    }

    public final long getTX() {
        return this.tX;
    }

    public final long getTY() {
        return this.tY;
    }

    @Override // com.microsoft.clarity.models.display.paints.shaders.Shader
    public ShaderType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int m = (UByte$$ExternalSyntheticBackport0.m(this.tY) + (UByte$$ExternalSyntheticBackport0.m(this.tX) * 31)) * 31;
        List<Float> list = this.matrix;
        int hashCode = (m + (list == null ? 0 : list.hashCode())) * 31;
        boolean z = this.raw;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (this.image.hashCode() + ((hashCode + i) * 31)) * 31;
        Sampling sampling = this.sampling;
        return hashCode2 + (sampling != null ? sampling.hashCode() : 0);
    }

    public final void setImageIndex(Integer num) {
        this.imageIndex = num;
    }

    public final void setMaskedColor(Color4f color4f) {
        this.maskedColor = color4f;
    }

    public final void setMaskedHeight(Integer num) {
        this.maskedHeight = num;
    }

    public final void setMaskedWidth(Integer num) {
        this.maskedWidth = num;
    }

    public String toString() {
        return "ImageShader(tX=" + this.tX + ", tY=" + this.tY + ", matrix=" + this.matrix + ", raw=" + this.raw + ", image=" + this.image + ", sampling=" + this.sampling + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Shader toProtobufInstance() {
        Y a2 = MutationPayload$Shader.newBuilder().a(getType().toProtobufType()).b(this.tX).c(this.tY).a(this.raw);
        List<Float> list = this.matrix;
        if (list != null) {
            a2.b(list);
        }
        Sampling sampling = this.sampling;
        if (sampling != null) {
            a2.a(sampling.toProtobufInstance());
        }
        Integer num = this.imageIndex;
        if (num != null) {
            a2.a(num.intValue());
        }
        Integer num2 = this.maskedWidth;
        if (num2 != null) {
            a2.c(num2.intValue());
        }
        if (this.maskedHeight != null) {
            Integer num3 = this.maskedWidth;
            a2.b(num3 != null ? num3.intValue() : 0);
        }
        Color4f color4f = this.maskedColor;
        if (color4f != null) {
            a2.b(color4f.toProtobufInstance());
        }
        GeneratedMessageLite build = a2.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$Shader) build;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Shader copy2() {
        ArrayList arrayList;
        long j = this.tX;
        long j2 = this.tY;
        List<Float> list = this.matrix;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Float.valueOf(((Number) it.next()).floatValue()));
            }
        } else {
            arrayList = null;
        }
        boolean z = this.raw;
        Image copy2 = this.image.copy2();
        Sampling sampling = this.sampling;
        ImageShader imageShader = new ImageShader(j, j2, arrayList, z, copy2, sampling != null ? sampling.copy2() : null);
        imageShader.imageIndex = this.imageIndex;
        Color4f color4f = this.maskedColor;
        imageShader.maskedColor = color4f != null ? color4f.copy2() : null;
        imageShader.maskedWidth = this.maskedWidth;
        imageShader.maskedHeight = this.maskedHeight;
        return imageShader;
    }

    public ImageShader(long j, long j2, List<Float> list, boolean z, Image image, Sampling sampling) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.tX = j;
        this.tY = j2;
        this.matrix = list;
        this.raw = z;
        this.image = image;
        this.sampling = sampling;
        this.type = ShaderType.ImageShader;
    }
}
