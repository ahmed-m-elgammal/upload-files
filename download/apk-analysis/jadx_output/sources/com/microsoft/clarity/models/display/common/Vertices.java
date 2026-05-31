package com.microsoft.clarity.models.display.common;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.henninghall.date_picker.props.ModeProp;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.C0124m;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DoubleList;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FloatList;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Vertices;
import com.microsoft.clarity.protomodels.mutationpayload.h0;
import io.sentry.rrweb.RRWebInteractionMoveEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B}\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\t\u0012\u0014\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t\u0018\u00010\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\tHÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t\u0018\u00010\tHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\b\u0010$\u001a\u00020\u0000H\u0016J\u0091\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t\u0018\u00010\t2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\b\u0010*\u001a\u00020\u0002H\u0016J\t\u0010+\u001a\u00020,HÖ\u0001R\u001f\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006-"}, d2 = {"Lcom/microsoft/clarity/models/display/common/Vertices;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Vertices;", "Lcom/microsoft/clarity/models/ICopyable;", ModeProp.name, "", "isVolatile", "", RRWebInteractionMoveEvent.JsonKeys.POSITIONS, "", "Lcom/microsoft/clarity/models/display/common/Point;", "texCoords", "colors", "boneIndices", "boneWeights", "", "indices", "(JZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBoneIndices", "()Ljava/util/List;", "getBoneWeights", "getColors", "getIndices", "()Z", "getMode", "()J", "getPositions", "getTexCoords", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Vertices implements IProtoModel<MutationPayload$Vertices>, ICopyable<Vertices> {
    private final List<List<Long>> boneIndices;
    private final List<List<Float>> boneWeights;
    private final List<Long> colors;
    private final List<Long> indices;
    private final boolean isVolatile;
    private final long mode;
    private final List<Point> positions;
    private final List<Point> texCoords;

    /* JADX WARN: Multi-variable type inference failed */
    public Vertices(long j, boolean z, List<Point> positions, List<Point> list, List<Long> list2, List<? extends List<Long>> list3, List<? extends List<Float>> list4, List<Long> indices) {
        Intrinsics.checkNotNullParameter(positions, "positions");
        Intrinsics.checkNotNullParameter(indices, "indices");
        this.mode = j;
        this.isVolatile = z;
        this.positions = positions;
        this.texCoords = list;
        this.colors = list2;
        this.boneIndices = list3;
        this.boneWeights = list4;
        this.indices = indices;
    }

    /* renamed from: component1, reason: from getter */
    public final long getMode() {
        return this.mode;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsVolatile() {
        return this.isVolatile;
    }

    public final List<Point> component3() {
        return this.positions;
    }

    public final List<Point> component4() {
        return this.texCoords;
    }

    public final List<Long> component5() {
        return this.colors;
    }

    public final List<List<Long>> component6() {
        return this.boneIndices;
    }

    public final List<List<Float>> component7() {
        return this.boneWeights;
    }

    public final List<Long> component8() {
        return this.indices;
    }

    public final Vertices copy(long mode, boolean isVolatile, List<Point> positions, List<Point> texCoords, List<Long> colors, List<? extends List<Long>> boneIndices, List<? extends List<Float>> boneWeights, List<Long> indices) {
        Intrinsics.checkNotNullParameter(positions, "positions");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return new Vertices(mode, isVolatile, positions, texCoords, colors, boneIndices, boneWeights, indices);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public Vertices copyWithNullData() {
        return (Vertices) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vertices)) {
            return false;
        }
        Vertices vertices = (Vertices) other;
        return this.mode == vertices.mode && this.isVolatile == vertices.isVolatile && Intrinsics.areEqual(this.positions, vertices.positions) && Intrinsics.areEqual(this.texCoords, vertices.texCoords) && Intrinsics.areEqual(this.colors, vertices.colors) && Intrinsics.areEqual(this.boneIndices, vertices.boneIndices) && Intrinsics.areEqual(this.boneWeights, vertices.boneWeights) && Intrinsics.areEqual(this.indices, vertices.indices);
    }

    public final List<List<Long>> getBoneIndices() {
        return this.boneIndices;
    }

    public final List<List<Float>> getBoneWeights() {
        return this.boneWeights;
    }

    public final List<Long> getColors() {
        return this.colors;
    }

    public final List<Long> getIndices() {
        return this.indices;
    }

    public final long getMode() {
        return this.mode;
    }

    public final List<Point> getPositions() {
        return this.positions;
    }

    public final List<Point> getTexCoords() {
        return this.texCoords;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int m = UByte$$ExternalSyntheticBackport0.m(this.mode) * 31;
        boolean z = this.isVolatile;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode = (this.positions.hashCode() + ((m + i) * 31)) * 31;
        List<Point> list = this.texCoords;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Long> list2 = this.colors;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<List<Long>> list3 = this.boneIndices;
        int hashCode4 = (hashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<List<Float>> list4 = this.boneWeights;
        return this.indices.hashCode() + ((hashCode4 + (list4 != null ? list4.hashCode() : 0)) * 31);
    }

    public final boolean isVolatile() {
        return this.isVolatile;
    }

    public String toString() {
        return "Vertices(mode=" + this.mode + ", isVolatile=" + this.isVolatile + ", positions=" + this.positions + ", texCoords=" + this.texCoords + ", colors=" + this.colors + ", boneIndices=" + this.boneIndices + ", boneWeights=" + this.boneWeights + ", indices=" + this.indices + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Vertices toProtobufInstance() {
        h0 a2 = MutationPayload$Vertices.newBuilder().a(this.mode).a(this.isVolatile);
        List<Point> list = this.positions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Point) it.next()).toProtobufInstance());
        }
        h0 a3 = a2.a(CollectionsKt.toList(arrayList));
        List<Long> list2 = this.indices;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Double.valueOf(((Number) it2.next()).longValue()));
        }
        h0 b = a3.b(arrayList2);
        List<Point> list3 = this.texCoords;
        if (list3 != null) {
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList3.add(((Point) it3.next()).toProtobufInstance());
            }
            b.b(CollectionsKt.toList(arrayList3));
        }
        List<Long> list4 = this.colors;
        if (list4 != null) {
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it4 = list4.iterator();
            while (it4.hasNext()) {
                arrayList4.add(Double.valueOf(((Number) it4.next()).longValue()));
            }
            b.a(arrayList4);
        }
        List<List> list5 = this.boneIndices;
        if (list5 == null) {
            list5 = new ArrayList();
        }
        for (List list6 : list5) {
            C0124m newBuilder = MutationPayload$DoubleList.newBuilder();
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
            Iterator it5 = list6.iterator();
            while (it5.hasNext()) {
                arrayList5.add(Double.valueOf(((Number) it5.next()).longValue()));
            }
            b.a((MutationPayload$DoubleList) newBuilder.a(arrayList5).build());
        }
        List list7 = this.boneWeights;
        if (list7 == null) {
            list7 = new ArrayList();
        }
        Iterator it6 = list7.iterator();
        while (it6.hasNext()) {
            b.a((MutationPayload$FloatList) MutationPayload$FloatList.newBuilder().a((List) it6.next()).build());
        }
        GeneratedMessageLite build = b.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$Vertices) build;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Vertices copy2() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        long j = this.mode;
        boolean z = this.isVolatile;
        List<Point> list = this.positions;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList4.add(((Point) it.next()).copy2());
        }
        List<Point> list2 = this.texCoords;
        ArrayList arrayList5 = null;
        if (list2 != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(((Point) it2.next()).copy2());
            }
        } else {
            arrayList = null;
        }
        List<Long> list3 = this.colors;
        if (list3 != null) {
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList2.add(Long.valueOf(((Number) it3.next()).longValue()));
            }
        } else {
            arrayList2 = null;
        }
        List<List<Long>> list4 = this.boneIndices;
        if (list4 != null) {
            arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it4 = list4.iterator();
            while (it4.hasNext()) {
                List list5 = (List) it4.next();
                ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                Iterator it5 = list5.iterator();
                while (it5.hasNext()) {
                    arrayList6.add(Long.valueOf(((Number) it5.next()).longValue()));
                }
                arrayList3.add(arrayList6);
            }
        } else {
            arrayList3 = null;
        }
        List<List<Float>> list6 = this.boneWeights;
        if (list6 != null) {
            arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
            Iterator<T> it6 = list6.iterator();
            while (it6.hasNext()) {
                List list7 = (List) it6.next();
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                Iterator it7 = list7.iterator();
                while (it7.hasNext()) {
                    arrayList7.add(Float.valueOf(((Number) it7.next()).floatValue()));
                }
                arrayList5.add(arrayList7);
            }
        }
        ArrayList arrayList8 = arrayList5;
        List<Long> list8 = this.indices;
        ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
        Iterator<T> it8 = list8.iterator();
        while (it8.hasNext()) {
            arrayList9.add(Long.valueOf(((Number) it8.next()).longValue()));
        }
        return new Vertices(j, z, arrayList4, arrayList, arrayList2, arrayList3, arrayList8, arrayList9);
    }
}
