package com.microsoft.clarity.models.display.paints.colorfilters;

import com.microsoft.clarity.protomodels.mutationpayload.EnumC0117f;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilterType;", "", "<init>", "(Ljava/lang/String;I)V", "Lcom/microsoft/clarity/protomodels/mutationpayload/f;", "toProtobufType", "()Lcom/microsoft/clarity/protomodels/mutationpayload/f;", "ModeColorFilter", "MatrixColorFilter", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum ColorFilterType {
    ModeColorFilter,
    MatrixColorFilter;

    public final EnumC0117f toProtobufType() {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return EnumC0117f.ModeColorFilter;
        }
        if (ordinal != 1) {
            return null;
        }
        return EnumC0117f.MatrixColorFilter;
    }
}
