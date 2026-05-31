package com.microsoft.clarity.models.display.paints.shaders;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.display.common.Point;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003J\b\u0010%\u001a\u00020\u0000H\u0016Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\b\u0010,\u001a\u00020-H\u0016J\t\u0010.\u001a\u00020/HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00060"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/shaders/RadialGradientShader;", "Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "center", "Lcom/microsoft/clarity/models/display/common/Point;", "radius", "", "tileMode", "", "gradFlags", "colors", "", "Lcom/microsoft/clarity/models/display/paints/Color4f;", "pos", "localMatrix", "(Lcom/microsoft/clarity/models/display/common/Point;FJJLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCenter", "()Lcom/microsoft/clarity/models/display/common/Point;", "getColors", "()Ljava/util/List;", "getGradFlags", "()J", "getLocalMatrix", "getPos", "getRadius", "()F", "getTileMode", "type", "Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Shader;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RadialGradientShader extends Shader {
    private final Point center;
    private final List<Color4f> colors;
    private final long gradFlags;
    private final List<Float> localMatrix;
    private final List<Float> pos;
    private final float radius;
    private final long tileMode;
    private final ShaderType type;

    public RadialGradientShader(Point center, float f, long j, long j2, List<Color4f> colors, List<Float> list, List<Float> list2) {
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.center = center;
        this.radius = f;
        this.tileMode = j;
        this.gradFlags = j2;
        this.colors = colors;
        this.pos = list;
        this.localMatrix = list2;
        this.type = ShaderType.RadialGradientShader;
    }

    /* renamed from: component1, reason: from getter */
    public final Point getCenter() {
        return this.center;
    }

    /* renamed from: component2, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTileMode() {
        return this.tileMode;
    }

    /* renamed from: component4, reason: from getter */
    public final long getGradFlags() {
        return this.gradFlags;
    }

    public final List<Color4f> component5() {
        return this.colors;
    }

    public final List<Float> component6() {
        return this.pos;
    }

    public final List<Float> component7() {
        return this.localMatrix;
    }

    public final RadialGradientShader copy(Point center, float radius, long tileMode, long gradFlags, List<Color4f> colors, List<Float> pos, List<Float> localMatrix) {
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new RadialGradientShader(center, radius, tileMode, gradFlags, colors, pos, localMatrix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadialGradientShader)) {
            return false;
        }
        RadialGradientShader radialGradientShader = (RadialGradientShader) other;
        return Intrinsics.areEqual(this.center, radialGradientShader.center) && Float.compare(this.radius, radialGradientShader.radius) == 0 && this.tileMode == radialGradientShader.tileMode && this.gradFlags == radialGradientShader.gradFlags && Intrinsics.areEqual(this.colors, radialGradientShader.colors) && Intrinsics.areEqual(this.pos, radialGradientShader.pos) && Intrinsics.areEqual(this.localMatrix, radialGradientShader.localMatrix);
    }

    public final Point getCenter() {
        return this.center;
    }

    public final List<Color4f> getColors() {
        return this.colors;
    }

    public final long getGradFlags() {
        return this.gradFlags;
    }

    public final List<Float> getLocalMatrix() {
        return this.localMatrix;
    }

    public final List<Float> getPos() {
        return this.pos;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final long getTileMode() {
        return this.tileMode;
    }

    @Override // com.microsoft.clarity.models.display.paints.shaders.Shader
    public ShaderType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = (this.colors.hashCode() + ((UByte$$ExternalSyntheticBackport0.m(this.gradFlags) + ((UByte$$ExternalSyntheticBackport0.m(this.tileMode) + ((Float.floatToIntBits(this.radius) + (this.center.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        List<Float> list = this.pos;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Float> list2 = this.localMatrix;
        return hashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "RadialGradientShader(center=" + this.center + ", radius=" + this.radius + ", tileMode=" + this.tileMode + ", gradFlags=" + this.gradFlags + ", colors=" + this.colors + ", pos=" + this.pos + ", localMatrix=" + this.localMatrix + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Shader toProtobufInstance() {
        Y a2 = MutationPayload$Shader.newBuilder().a(getType().toProtobufType()).a(this.center.toProtobufInstance()).b(this.radius).d(this.tileMode).a(this.gradFlags);
        List<Color4f> list = this.colors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Color4f) it.next()).toProtobufInstance());
        }
        Y a3 = a2.a(CollectionsKt.toList(arrayList));
        List<Float> list2 = this.pos;
        if (list2 != null) {
            a3.c(list2);
        }
        List<Float> list3 = this.localMatrix;
        if (list3 != null) {
            a3.a((Iterable) list3);
        }
        GeneratedMessageLite build = a3.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$Shader) build;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Shader copy2() {
        ArrayList arrayList;
        Point copy2 = this.center.copy2();
        float f = this.radius;
        long j = this.tileMode;
        long j2 = this.gradFlags;
        List<Color4f> list = this.colors;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Color4f) it.next()).copy2());
        }
        List<Float> list2 = this.pos;
        ArrayList arrayList3 = null;
        if (list2 != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(Float.valueOf(((Number) it2.next()).floatValue()));
            }
        } else {
            arrayList = null;
        }
        List<Float> list3 = this.localMatrix;
        if (list3 != null) {
            arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList3.add(Float.valueOf(((Number) it3.next()).floatValue()));
            }
        }
        return new RadialGradientShader(copy2, f, j, j2, arrayList2, arrayList, arrayList3);
    }
}
