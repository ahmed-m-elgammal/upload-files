package com.microsoft.clarity.models.display.commands;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.display.common.RRect;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawDRRect;", "Lcom/microsoft/clarity/models/display/commands/PaintableCommand;", "outer", "Lcom/microsoft/clarity/models/display/common/RRect;", "inner", "paintIndex", "", "(Lcom/microsoft/clarity/models/display/common/RRect;Lcom/microsoft/clarity/models/display/common/RRect;I)V", "getInner", "()Lcom/microsoft/clarity/models/display/common/RRect;", "getOuter", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "copy", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DrawDRRect extends PaintableCommand {
    private final RRect inner;
    private final RRect outer;
    private final DisplayCommandType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawDRRect(RRect outer, RRect inner, int i) {
        super(i);
        Intrinsics.checkNotNullParameter(outer, "outer");
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.outer = outer;
        this.inner = inner;
        this.type = DisplayCommandType.DrawDRRect;
    }

    public final RRect getInner() {
        return this.inner;
    }

    public final RRect getOuter() {
        return this.outer;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public DisplayCommand copy2() {
        return new DrawDRRect(this.outer.copy2(), this.inner.copy2(), getPaintIndex());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$DisplayCommand.newBuilder().a(getType().toProtobufType()).e(this.outer.toProtobufInstance()).d(this.inner.toProtobufInstance()).j(getPaintIndex()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …dex)\n            .build()");
        return (MutationPayload$DisplayCommand) build;
    }
}
