package com.microsoft.clarity.models.display.common;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FloatList;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Rect;
import com.microsoft.clarity.protomodels.mutationpayload.U;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\u0000H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/microsoft/clarity/models/display/common/RRect;", "Lcom/microsoft/clarity/models/display/common/Rect;", "left", "", "top", "right", ViewProps.BOTTOM, "radii", "", "(FFFFLjava/util/List;)V", "getRadii", "()Ljava/util/List;", "copy", "equals", "", "other", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Rect;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RRect extends Rect {
    private final List<List<Float>> radii;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RRect(float f, float f2, float f3, float f4, List<? extends List<Float>> radii) {
        super(f, f2, f3, f4);
        Intrinsics.checkNotNullParameter(radii, "radii");
        this.radii = radii;
    }

    @Override // com.microsoft.clarity.models.display.common.Rect
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(RRect.class, other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(toString(), other.toString());
    }

    public final List<List<Float>> getRadii() {
        return this.radii;
    }

    @Override // com.microsoft.clarity.models.display.common.Rect
    public String toString() {
        String str = "RRect(" + getLeft() + "F, " + getTop() + "F, " + getRight() + "F, " + getBottom() + "F, arrayListOf(";
        Iterator<List<Float>> it = this.radii.iterator();
        while (it.hasNext()) {
            String str2 = str + "arrayListOf(";
            Iterator<Float> it2 = it.next().iterator();
            while (it2.hasNext()) {
                str2 = str2 + it2.next().floatValue() + "F, ";
            }
            str = str2 + "), ";
        }
        return str + "))";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.display.common.Rect, com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Rect toProtobufInstance() {
        U c = MutationPayload$Rect.newBuilder().a(getBottom()).d(getTop()).b(getLeft()).c(getRight());
        Iterator<List<Float>> it = this.radii.iterator();
        while (it.hasNext()) {
            c.a((MutationPayload$FloatList) MutationPayload$FloatList.newBuilder().a(it.next()).build());
        }
        GeneratedMessageLite build = c.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$Rect) build;
    }

    @Override // com.microsoft.clarity.models.display.common.Rect, com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public RRect copy2() {
        float left = getLeft();
        float top = getTop();
        float right = getRight();
        float bottom = getBottom();
        List<List<Float>> list = this.radii;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf(((Number) it2.next()).floatValue()));
            }
            arrayList.add(arrayList2);
        }
        return new RRect(left, top, right, bottom, arrayList);
    }
}
