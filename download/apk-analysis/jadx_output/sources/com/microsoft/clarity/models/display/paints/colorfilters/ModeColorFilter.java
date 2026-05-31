package com.microsoft.clarity.models.display.paints.colorfilters;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.henninghall.date_picker.props.ModeProp;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.protomodels.mutationpayload.C0115d;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$ColorFilter;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\b\u0010\u0016\u001a\u00020\u0000H\u0016J0\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\t\u0010 \u001a\u00020!HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/microsoft/clarity/models/display/paints/colorfilters/ModeColorFilter;", "Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilter;", "color", "", "color4f", "Lcom/microsoft/clarity/models/display/paints/Color4f;", ModeProp.name, "(Ljava/lang/Long;Lcom/microsoft/clarity/models/display/paints/Color4f;J)V", "getColor", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getColor4f", "()Lcom/microsoft/clarity/models/display/paints/Color4f;", "getMode", "()J", "type", "Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilterType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilterType;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Lcom/microsoft/clarity/models/display/paints/Color4f;J)Lcom/microsoft/clarity/models/display/paints/colorfilters/ModeColorFilter;", "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$ColorFilter;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModeColorFilter extends ColorFilter {
    private final Long color;
    private final Color4f color4f;
    private final long mode;
    private final ColorFilterType type = ColorFilterType.ModeColorFilter;

    public ModeColorFilter(Long l, Color4f color4f, long j) {
        this.color = l;
        this.color4f = color4f;
        this.mode = j;
    }

    public static /* synthetic */ ModeColorFilter copy$default(ModeColorFilter modeColorFilter, Long l, Color4f color4f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            l = modeColorFilter.color;
        }
        if ((i & 2) != 0) {
            color4f = modeColorFilter.color4f;
        }
        if ((i & 4) != 0) {
            j = modeColorFilter.mode;
        }
        return modeColorFilter.copy(l, color4f, j);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getColor() {
        return this.color;
    }

    /* renamed from: component2, reason: from getter */
    public final Color4f getColor4f() {
        return this.color4f;
    }

    /* renamed from: component3, reason: from getter */
    public final long getMode() {
        return this.mode;
    }

    public final ModeColorFilter copy(Long color, Color4f color4f, long mode) {
        return new ModeColorFilter(color, color4f, mode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModeColorFilter)) {
            return false;
        }
        ModeColorFilter modeColorFilter = (ModeColorFilter) other;
        return Intrinsics.areEqual(this.color, modeColorFilter.color) && Intrinsics.areEqual(this.color4f, modeColorFilter.color4f) && this.mode == modeColorFilter.mode;
    }

    public final Long getColor() {
        return this.color;
    }

    public final Color4f getColor4f() {
        return this.color4f;
    }

    public final long getMode() {
        return this.mode;
    }

    @Override // com.microsoft.clarity.models.display.paints.colorfilters.ColorFilter
    public ColorFilterType getType() {
        return this.type;
    }

    public int hashCode() {
        Long l = this.color;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Color4f color4f = this.color4f;
        return UByte$$ExternalSyntheticBackport0.m(this.mode) + ((hashCode + (color4f != null ? color4f.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "ModeColorFilter(color=" + this.color + ", color4f=" + this.color4f + ", mode=" + this.mode + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$ColorFilter toProtobufInstance() {
        C0115d b = MutationPayload$ColorFilter.newBuilder().a(getType().toProtobufType()).b(this.mode);
        if (this.color != null) {
            b.a(r1.longValue());
        }
        Color4f color4f = this.color4f;
        if (color4f != null) {
            b.a(color4f.toProtobufInstance());
        }
        GeneratedMessageLite build = b.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$ColorFilter) build;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public ColorFilter copy2() {
        Long l = this.color;
        Color4f color4f = this.color4f;
        return new ModeColorFilter(l, color4f != null ? color4f.copy2() : null, this.mode);
    }
}
