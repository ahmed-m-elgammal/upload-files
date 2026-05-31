package com.microsoft.clarity.models.display.paints.patheffects;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.display.paths.Path;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u0000H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/patheffects/Path1DPathEffect;", "Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffect;", "advance", "", "path", "Lcom/microsoft/clarity/models/display/paths/Path;", "phase", "style", "Lkotlin/UInt;", "(FLcom/microsoft/clarity/models/display/paths/Path;FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdvance", "()F", "getPath", "()Lcom/microsoft/clarity/models/display/paths/Path;", "getPhase", "getStyle-pVg5ArA", "()I", "I", "type", "Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffectType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffectType;", "copy", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$PathEffect;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Path1DPathEffect extends PathEffect {
    private final float advance;
    private final Path path;
    private final float phase;
    private final int style;
    private final PathEffectType type;

    public /* synthetic */ Path1DPathEffect(float f, Path path, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, path, f2, i);
    }

    public final float getAdvance() {
        return this.advance;
    }

    public final Path getPath() {
        return this.path;
    }

    public final float getPhase() {
        return this.phase;
    }

    /* renamed from: getStyle-pVg5ArA, reason: not valid java name and from getter */
    public final int getStyle() {
        return this.style;
    }

    @Override // com.microsoft.clarity.models.display.paints.patheffects.PathEffect
    public PathEffectType getType() {
        return this.type;
    }

    private Path1DPathEffect(float f, Path path, float f2, int i) {
        this.advance = f;
        this.path = path;
        this.phase = f2;
        this.style = i;
        this.type = PathEffectType.Path1DPathEffect;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public PathEffect copy2() {
        return new Path1DPathEffect(this.advance, this.path.copy2(), this.phase, this.style, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$PathEffect toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$PathEffect.newBuilder().a(getType().toProtobufType()).a(this.advance).a(this.path.toProtobufInstance()).b(this.phase).a(this.style & BodyPartID.bodyIdMax).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …g())\n            .build()");
        return (MutationPayload$PathEffect) build;
    }
}
