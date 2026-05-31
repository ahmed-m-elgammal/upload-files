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

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003J\b\u0010$\u001a\u00020\u0000H\u0016Je\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\b\u0010+\u001a\u00020,H\u0016J\t\u0010-\u001a\u00020.HÖ\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/shaders/LinearGradientShader;", "Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "start", "Lcom/microsoft/clarity/models/display/common/Point;", "end", "tileMode", "", "gradFlags", "colors", "", "Lcom/microsoft/clarity/models/display/paints/Color4f;", "pos", "", "localMatrix", "(Lcom/microsoft/clarity/models/display/common/Point;Lcom/microsoft/clarity/models/display/common/Point;JJLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getColors", "()Ljava/util/List;", "getEnd", "()Lcom/microsoft/clarity/models/display/common/Point;", "getGradFlags", "()J", "getLocalMatrix", "getPos", "getStart", "getTileMode", "type", "Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Shader;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LinearGradientShader extends Shader {
    private final List<Color4f> colors;
    private final Point end;
    private final long gradFlags;
    private final List<Float> localMatrix;
    private final List<Float> pos;
    private final Point start;
    private final long tileMode;
    private final ShaderType type;

    public LinearGradientShader(Point start, Point end, long j, long j2, List<Color4f> colors, List<Float> list, List<Float> list2) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.start = start;
        this.end = end;
        this.tileMode = j;
        this.gradFlags = j2;
        this.colors = colors;
        this.pos = list;
        this.localMatrix = list2;
        this.type = ShaderType.LinearGradientShader;
    }

    /* renamed from: component1, reason: from getter */
    public final Point getStart() {
        return this.start;
    }

    /* renamed from: component2, reason: from getter */
    public final Point getEnd() {
        return this.end;
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

    public final LinearGradientShader copy(Point start, Point end, long tileMode, long gradFlags, List<Color4f> colors, List<Float> pos, List<Float> localMatrix) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new LinearGradientShader(start, end, tileMode, gradFlags, colors, pos, localMatrix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinearGradientShader)) {
            return false;
        }
        LinearGradientShader linearGradientShader = (LinearGradientShader) other;
        return Intrinsics.areEqual(this.start, linearGradientShader.start) && Intrinsics.areEqual(this.end, linearGradientShader.end) && this.tileMode == linearGradientShader.tileMode && this.gradFlags == linearGradientShader.gradFlags && Intrinsics.areEqual(this.colors, linearGradientShader.colors) && Intrinsics.areEqual(this.pos, linearGradientShader.pos) && Intrinsics.areEqual(this.localMatrix, linearGradientShader.localMatrix);
    }

    public final List<Color4f> getColors() {
        return this.colors;
    }

    public final Point getEnd() {
        return this.end;
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

    public final Point getStart() {
        return this.start;
    }

    public final long getTileMode() {
        return this.tileMode;
    }

    @Override // com.microsoft.clarity.models.display.paints.shaders.Shader
    public ShaderType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = (this.colors.hashCode() + ((UByte$$ExternalSyntheticBackport0.m(this.gradFlags) + ((UByte$$ExternalSyntheticBackport0.m(this.tileMode) + ((this.end.hashCode() + (this.start.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        List<Float> list = this.pos;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Float> list2 = this.localMatrix;
        return hashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "LinearGradientShader(start=" + this.start + ", end=" + this.end + ", tileMode=" + this.tileMode + ", gradFlags=" + this.gradFlags + ", colors=" + this.colors + ", pos=" + this.pos + ", localMatrix=" + this.localMatrix + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Shader toProtobufInstance() {
        Y a2 = MutationPayload$Shader.newBuilder().a(getType().toProtobufType()).c(this.start.toProtobufInstance()).b(this.end.toProtobufInstance()).d(this.tileMode).a(this.gradFlags);
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
        Point copy2 = this.start.copy2();
        Point copy22 = this.end.copy2();
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
        return new LinearGradientShader(copy2, copy22, j, j2, arrayList2, arrayList, arrayList3);
    }
}
