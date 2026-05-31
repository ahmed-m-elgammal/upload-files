package com.microsoft.clarity.models.display.paints.patheffects;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0000H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/patheffects/CornerPathEffect;", "Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffect;", "radius", "", "(F)V", "getRadius", "()F", "type", "Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffectType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffectType;", "copy", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$PathEffect;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CornerPathEffect extends PathEffect {
    private final float radius;
    private final PathEffectType type = PathEffectType.CornerPathEffect;

    public CornerPathEffect(float f) {
        this.radius = f;
    }

    public final float getRadius() {
        return this.radius;
    }

    @Override // com.microsoft.clarity.models.display.paints.patheffects.PathEffect
    public PathEffectType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public PathEffect copy2() {
        return new CornerPathEffect(this.radius);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$PathEffect toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$PathEffect.newBuilder().a(getType().toProtobufType()).c(this.radius).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …ius)\n            .build()");
        return (MutationPayload$PathEffect) build;
    }
}
