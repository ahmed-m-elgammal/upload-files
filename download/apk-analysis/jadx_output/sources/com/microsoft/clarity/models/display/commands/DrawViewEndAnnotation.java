package com.microsoft.clarity.models.display.commands;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0000H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawViewEndAnnotation;", "Lcom/microsoft/clarity/models/display/commands/DrawViewAnnotation;", "id", "", "name", "", "isClipRectSource", "", "(ILjava/lang/String;Z)V", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "copy", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DrawViewEndAnnotation extends DrawViewAnnotation {
    private final DisplayCommandType type;

    public /* synthetic */ DrawViewEndAnnotation(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? true : z);
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawViewEndAnnotation(int i, String name, boolean z) {
        super(i, name, z);
        Intrinsics.checkNotNullParameter(name, "name");
        this.type = DisplayCommandType.DrawViewEndAnnotation;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public DisplayCommand copy2() {
        return new DrawViewEndAnnotation(getId(), getName(), false, 4, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$DisplayCommand.newBuilder().a(getType().toProtobufType()).d(getId()).a(getName()).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$DisplayCommand) build;
    }
}
