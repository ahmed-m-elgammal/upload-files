package com.microsoft.clarity.models.display.commands;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.display.images.Sampling;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.protomodels.mutationpayload.C0118g;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawImage;", "Lcom/microsoft/clarity/models/display/commands/DrawImageBase;", "x", "", "y", "imageIndex", "", "sampling", "Lcom/microsoft/clarity/models/display/images/Sampling;", "paintIndex", "(FFLjava/lang/Integer;Lcom/microsoft/clarity/models/display/images/Sampling;I)V", "getSampling", "()Lcom/microsoft/clarity/models/display/images/Sampling;", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getX", "()F", "getY", "copy", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DrawImage extends DrawImageBase {
    private final Sampling sampling;
    private final DisplayCommandType type;
    private final float x;
    private final float y;

    public DrawImage(float f, float f2, Integer num, Sampling sampling, int i) {
        super(num, i);
        this.x = f;
        this.y = f2;
        this.sampling = sampling;
        this.type = DisplayCommandType.DrawImage;
    }

    public final Sampling getSampling() {
        return this.sampling;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public DisplayCommand copy2() {
        float f = this.x;
        float f2 = this.y;
        Integer imageIndex = getImageIndex();
        Sampling sampling = this.sampling;
        DrawImage drawImage = new DrawImage(f, f2, imageIndex, sampling != null ? sampling.copy2() : null, getPaintIndex());
        Color4f maskedColor = getMaskedColor();
        drawImage.setMaskedColor(maskedColor != null ? maskedColor.copy2() : null);
        drawImage.setMaskedWidth(getMaskedWidth());
        drawImage.setMaskedHeight(getMaskedHeight());
        return drawImage;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        C0118g j = MutationPayload$DisplayCommand.newBuilder().a(getType().toProtobufType()).g(this.x).h(this.y).j(getPaintIndex());
        Sampling sampling = this.sampling;
        if (sampling != null) {
            j.a(sampling.toProtobufInstance());
        }
        if (getImageIndex() != null) {
            Integer imageIndex = getImageIndex();
            j.f(imageIndex != null ? imageIndex.intValue() : 0);
        }
        if (getMaskedWidth() != null) {
            Integer maskedWidth = getMaskedWidth();
            j.h(maskedWidth != null ? maskedWidth.intValue() : 0);
        }
        if (getMaskedHeight() != null) {
            Integer maskedWidth2 = getMaskedWidth();
            j.g(maskedWidth2 != null ? maskedWidth2.intValue() : 0);
        }
        if (getMaskedColor() != null) {
            Color4f maskedColor = getMaskedColor();
            j.a(maskedColor != null ? maskedColor.toProtobufInstance() : null);
        }
        GeneratedMessageLite build = j.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$DisplayCommand) build;
    }
}
