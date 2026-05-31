package com.microsoft.clarity.models.display.typefaces;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FontStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0000H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/microsoft/clarity/models/display/typefaces/FontStyle;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$FontStyle;", "Lcom/microsoft/clarity/models/ICopyable;", "weight", "", "width", "slant", "(JJJ)V", "getSlant", "()J", "getWeight", "getWidth", "copy", "toProtobufInstance", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FontStyle implements IProtoModel<MutationPayload$FontStyle>, ICopyable<FontStyle> {
    private final long slant;
    private final long weight;
    private final long width;

    public FontStyle(long j, long j2, long j3) {
        this.weight = j;
        this.width = j2;
        this.slant = j3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public FontStyle copyWithNullData() {
        return (FontStyle) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public final long getSlant() {
        return this.slant;
    }

    public final long getWeight() {
        return this.weight;
    }

    public final long getWidth() {
        return this.width;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public FontStyle copy2() {
        return new FontStyle(this.weight, this.width, this.slant);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$FontStyle toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$FontStyle.newBuilder().a(this.slant).b(this.weight).c(this.width).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …e())\n            .build()");
        return (MutationPayload$FontStyle) build;
    }
}
