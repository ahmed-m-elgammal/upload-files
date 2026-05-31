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

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\b\u0010(\u001a\u00020\u0000H\u0016Jo\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\b\u0010/\u001a\u000200H\u0016J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00063"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/shaders/SweepGradientShader;", "Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "center", "Lcom/microsoft/clarity/models/display/common/Point;", "startAngle", "", "endAngle", "tileMode", "", "gradFlags", "colors", "", "Lcom/microsoft/clarity/models/display/paints/Color4f;", "pos", "localMatrix", "(Lcom/microsoft/clarity/models/display/common/Point;FFJJLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCenter", "()Lcom/microsoft/clarity/models/display/common/Point;", "getColors", "()Ljava/util/List;", "getEndAngle", "()F", "getGradFlags", "()J", "getLocalMatrix", "getPos", "getStartAngle", "getTileMode", "type", "Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Shader;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SweepGradientShader extends Shader {
    private final Point center;
    private final List<Color4f> colors;
    private final float endAngle;
    private final long gradFlags;
    private final List<Float> localMatrix;
    private final List<Float> pos;
    private final float startAngle;
    private final long tileMode;
    private final ShaderType type;

    public SweepGradientShader(Point center, float f, float f2, long j, long j2, List<Color4f> colors, List<Float> list, List<Float> list2) {
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.center = center;
        this.startAngle = f;
        this.endAngle = f2;
        this.tileMode = j;
        this.gradFlags = j2;
        this.colors = colors;
        this.pos = list;
        this.localMatrix = list2;
        this.type = ShaderType.SweepGradientShader;
    }

    /* renamed from: component1, reason: from getter */
    public final Point getCenter() {
        return this.center;
    }

    /* renamed from: component2, reason: from getter */
    public final float getStartAngle() {
        return this.startAngle;
    }

    /* renamed from: component3, reason: from getter */
    public final float getEndAngle() {
        return this.endAngle;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTileMode() {
        return this.tileMode;
    }

    /* renamed from: component5, reason: from getter */
    public final long getGradFlags() {
        return this.gradFlags;
    }

    public final List<Color4f> component6() {
        return this.colors;
    }

    public final List<Float> component7() {
        return this.pos;
    }

    public final List<Float> component8() {
        return this.localMatrix;
    }

    public final SweepGradientShader copy(Point center, float startAngle, float endAngle, long tileMode, long gradFlags, List<Color4f> colors, List<Float> pos, List<Float> localMatrix) {
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new SweepGradientShader(center, startAngle, endAngle, tileMode, gradFlags, colors, pos, localMatrix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SweepGradientShader)) {
            return false;
        }
        SweepGradientShader sweepGradientShader = (SweepGradientShader) other;
        return Intrinsics.areEqual(this.center, sweepGradientShader.center) && Float.compare(this.startAngle, sweepGradientShader.startAngle) == 0 && Float.compare(this.endAngle, sweepGradientShader.endAngle) == 0 && this.tileMode == sweepGradientShader.tileMode && this.gradFlags == sweepGradientShader.gradFlags && Intrinsics.areEqual(this.colors, sweepGradientShader.colors) && Intrinsics.areEqual(this.pos, sweepGradientShader.pos) && Intrinsics.areEqual(this.localMatrix, sweepGradientShader.localMatrix);
    }

    public final Point getCenter() {
        return this.center;
    }

    public final List<Color4f> getColors() {
        return this.colors;
    }

    public final float getEndAngle() {
        return this.endAngle;
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

    public final float getStartAngle() {
        return this.startAngle;
    }

    public final long getTileMode() {
        return this.tileMode;
    }

    @Override // com.microsoft.clarity.models.display.paints.shaders.Shader
    public ShaderType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = (this.colors.hashCode() + ((UByte$$ExternalSyntheticBackport0.m(this.gradFlags) + ((UByte$$ExternalSyntheticBackport0.m(this.tileMode) + ((Float.floatToIntBits(this.endAngle) + ((Float.floatToIntBits(this.startAngle) + (this.center.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        List<Float> list = this.pos;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Float> list2 = this.localMatrix;
        return hashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "SweepGradientShader(center=" + this.center + ", startAngle=" + this.startAngle + ", endAngle=" + this.endAngle + ", tileMode=" + this.tileMode + ", gradFlags=" + this.gradFlags + ", colors=" + this.colors + ", pos=" + this.pos + ", localMatrix=" + this.localMatrix + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Shader toProtobufInstance() {
        Y a2 = MutationPayload$Shader.newBuilder().a(getType().toProtobufType()).a(this.center.toProtobufInstance()).c(this.startAngle).a(this.endAngle).d(this.tileMode).a(this.gradFlags);
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
        float f = this.startAngle;
        float f2 = this.endAngle;
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
        return new SweepGradientShader(copy2, f, f2, j, j2, arrayList2, arrayList, arrayList3);
    }
}
