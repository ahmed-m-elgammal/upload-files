package com.microsoft.clarity.models.display.paints.patheffects;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/patheffects/DashPathEffect;", "Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffect;", "phase", "", "intervals", "", "(FLjava/util/List;)V", "getIntervals", "()Ljava/util/List;", "getPhase", "()F", "type", "Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffectType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffectType;", "copy", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$PathEffect;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DashPathEffect extends PathEffect {
    private final List<Float> intervals;
    private final float phase;
    private final PathEffectType type;

    public DashPathEffect(float f, List<Float> intervals) {
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        this.phase = f;
        this.intervals = intervals;
        this.type = PathEffectType.DashPathEffect;
    }

    public final List<Float> getIntervals() {
        return this.intervals;
    }

    public final float getPhase() {
        return this.phase;
    }

    @Override // com.microsoft.clarity.models.display.paints.patheffects.PathEffect
    public PathEffectType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public PathEffect copy2() {
        float f = this.phase;
        List<Float> list = this.intervals;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((Number) it.next()).floatValue()));
        }
        return new DashPathEffect(f, arrayList);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$PathEffect toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$PathEffect.newBuilder().a(getType().toProtobufType()).b(this.phase).a(this.intervals).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …als)\n            .build()");
        return (MutationPayload$PathEffect) build;
    }
}
