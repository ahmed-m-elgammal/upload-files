package com.microsoft.clarity.models.display.images;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.protomodels.mutationpayload.C0133w;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Lattice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003BE\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/microsoft/clarity/models/display/images/Lattice;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Lattice;", "Lcom/microsoft/clarity/models/ICopyable;", "xDivs", "", "", "yDivs", "rectType", "bounds", "Lcom/microsoft/clarity/models/display/common/IRect;", "colors", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/microsoft/clarity/models/display/common/IRect;Ljava/util/List;)V", "getBounds", "()Lcom/microsoft/clarity/models/display/common/IRect;", "getColors", "()Ljava/util/List;", "getRectType", "copy", "toProtobufInstance", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Lattice implements IProtoModel<MutationPayload$Lattice>, ICopyable<Lattice> {
    private final IRect bounds;
    private final List<Long> colors;
    private final List<Integer> rectType;
    private final List<Integer> xDivs;
    private final List<Integer> yDivs;

    public Lattice(List<Integer> xDivs, List<Integer> yDivs, List<Integer> rectType, IRect bounds, List<Long> colors) {
        Intrinsics.checkNotNullParameter(xDivs, "xDivs");
        Intrinsics.checkNotNullParameter(yDivs, "yDivs");
        Intrinsics.checkNotNullParameter(rectType, "rectType");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.xDivs = xDivs;
        this.yDivs = yDivs;
        this.rectType = rectType;
        this.bounds = bounds;
        this.colors = colors;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public Lattice copyWithNullData() {
        return (Lattice) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public final IRect getBounds() {
        return this.bounds;
    }

    public final List<Long> getColors() {
        return this.colors;
    }

    public final List<Integer> getRectType() {
        return this.rectType;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Lattice copy2() {
        List<Integer> list = this.xDivs;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((Number) it.next()).intValue()));
        }
        List<Integer> list2 = this.yDivs;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(((Number) it2.next()).intValue()));
        }
        List<Integer> list3 = this.rectType;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Integer.valueOf(((Number) it3.next()).intValue()));
        }
        IRect copy2 = this.bounds.copy2();
        List<Long> list4 = this.colors;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it4 = list4.iterator();
        while (it4.hasNext()) {
            arrayList4.add(Long.valueOf(((Number) it4.next()).longValue()));
        }
        return new Lattice(arrayList, arrayList2, arrayList3, copy2, arrayList4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Lattice toProtobufInstance() {
        C0133w a2 = MutationPayload$Lattice.newBuilder().a(this.bounds.toProtobufInstance());
        List<Long> list = this.colors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(((Number) it.next()).longValue()));
        }
        GeneratedMessageLite build = a2.a(arrayList).a(this.rectType).c(this.yDivs).b(this.xDivs).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …ivs)\n            .build()");
        return (MutationPayload$Lattice) build;
    }
}
