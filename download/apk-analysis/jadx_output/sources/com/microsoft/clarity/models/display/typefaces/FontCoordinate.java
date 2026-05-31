package com.microsoft.clarity.models.display.typefaces;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FontCoordinate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0000H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/microsoft/clarity/models/display/typefaces/FontCoordinate;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$FontCoordinate;", "Lcom/microsoft/clarity/models/ICopyable;", "axis", "", "value", "", "(Ljava/lang/String;F)V", "getAxis", "()Ljava/lang/String;", "getValue", "()F", "copy", "toProtobufInstance", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FontCoordinate implements IProtoModel<MutationPayload$FontCoordinate>, ICopyable<FontCoordinate> {
    private final String axis;
    private final float value;

    public FontCoordinate(String axis, float f) {
        Intrinsics.checkNotNullParameter(axis, "axis");
        this.axis = axis;
        this.value = f;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public FontCoordinate copyWithNullData() {
        return (FontCoordinate) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public final String getAxis() {
        return this.axis;
    }

    public final float getValue() {
        return this.value;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public FontCoordinate copy2() {
        return new FontCoordinate(this.axis, this.value);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$FontCoordinate toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$FontCoordinate.newBuilder().a(this.axis).a(this.value).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …lue)\n            .build()");
        return (MutationPayload$FontCoordinate) build;
    }
}
