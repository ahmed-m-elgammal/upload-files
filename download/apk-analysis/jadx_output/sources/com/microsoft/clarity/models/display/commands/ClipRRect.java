package com.microsoft.clarity.models.display.commands;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.display.common.RRect;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/ClipRRect;", "Lcom/microsoft/clarity/models/display/commands/ClipCommand;", "rrect", "Lcom/microsoft/clarity/models/display/common/RRect;", "op", "", "antiAlias", "", "(Lcom/microsoft/clarity/models/display/common/RRect;IZ)V", "getRrect", "()Lcom/microsoft/clarity/models/display/common/RRect;", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "copy", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClipRRect extends ClipCommand {
    private final RRect rrect;
    private final DisplayCommandType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipRRect(RRect rrect, int i, boolean z) {
        super(i, z);
        Intrinsics.checkNotNullParameter(rrect, "rrect");
        this.rrect = rrect;
        this.type = DisplayCommandType.ClipRRect;
    }

    public final RRect getRrect() {
        return this.rrect;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public DisplayCommand copy2() {
        return new ClipRRect(this.rrect.copy2(), getOp(), getAntiAlias());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.display.commands.ClipCommand, com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$DisplayCommand.newBuilder().a(getType().toProtobufType()).g(this.rrect.toProtobufInstance()).i(getOp()).a(getAntiAlias()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …ias)\n            .build()");
        return (MutationPayload$DisplayCommand) build;
    }
}
