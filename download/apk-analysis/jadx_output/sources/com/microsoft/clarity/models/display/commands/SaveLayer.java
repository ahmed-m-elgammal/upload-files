package com.microsoft.clarity.models.display.commands;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.display.common.Rect;
import com.microsoft.clarity.protomodels.mutationpayload.C0118g;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/SaveLayer;", "Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", "bounds", "Lcom/microsoft/clarity/models/display/common/Rect;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "", "imageFilterPaint", "paintIndex", "(Lcom/microsoft/clarity/models/display/common/Rect;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBounds", "()Lcom/microsoft/clarity/models/display/common/Rect;", "getFlags", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageFilterPaint", "getPaintIndex", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "copy", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SaveLayer extends DisplayCommand {
    private final Rect bounds;
    private final Integer flags;
    private final Integer imageFilterPaint;
    private final Integer paintIndex;
    private final DisplayCommandType type = DisplayCommandType.SaveLayer;

    public SaveLayer(Rect rect, Integer num, Integer num2, Integer num3) {
        this.bounds = rect;
        this.flags = num;
        this.imageFilterPaint = num2;
        this.paintIndex = num3;
    }

    public final Rect getBounds() {
        return this.bounds;
    }

    public final Integer getFlags() {
        return this.flags;
    }

    public final Integer getImageFilterPaint() {
        return this.imageFilterPaint;
    }

    public final Integer getPaintIndex() {
        return this.paintIndex;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public DisplayCommand copy2() {
        Rect rect = this.bounds;
        return new SaveLayer(rect != null ? rect.copy2() : null, this.flags, this.imageFilterPaint, this.paintIndex);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        C0118g a2 = MutationPayload$DisplayCommand.newBuilder().a(getType().toProtobufType());
        Rect rect = this.bounds;
        if (rect != null) {
            a2.a(rect.toProtobufInstance());
        }
        Integer num = this.flags;
        if (num != null) {
            a2.c(num.intValue());
        }
        Integer num2 = this.imageFilterPaint;
        if (num2 != null) {
            a2.e(num2.intValue());
        }
        Integer num3 = this.paintIndex;
        if (num3 != null) {
            a2.j(num3.intValue());
        }
        GeneratedMessageLite build = a2.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$DisplayCommand) build;
    }
}
