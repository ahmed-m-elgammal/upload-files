package com.microsoft.clarity.models.display.commands;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.display.common.Rect;
import com.microsoft.clarity.protomodels.mutationpayload.C0118g;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/SaveBehind;", "Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "", "subset", "Lcom/microsoft/clarity/models/display/common/Rect;", "(ILcom/microsoft/clarity/models/display/common/Rect;)V", "getFlags", "()I", "getSubset", "()Lcom/microsoft/clarity/models/display/common/Rect;", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "copy", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SaveBehind extends DisplayCommand {
    private final int flags;
    private final Rect subset;
    private final DisplayCommandType type = DisplayCommandType.SaveBehind;

    public SaveBehind(int i, Rect rect) {
        this.flags = i;
        this.subset = rect;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final Rect getSubset() {
        return this.subset;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public DisplayCommand copy2() {
        int i = this.flags;
        Rect rect = this.subset;
        return new SaveBehind(i, rect != null ? rect.copy2() : null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        C0118g c = MutationPayload$DisplayCommand.newBuilder().a(getType().toProtobufType()).c(this.flags);
        Rect rect = this.subset;
        if (rect != null) {
            c.i(rect.toProtobufInstance());
        }
        GeneratedMessageLite build = c.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$DisplayCommand) build;
    }
}
