package com.microsoft.clarity.models.display.paints.patheffects;

import com.microsoft.clarity.protomodels.mutationpayload.L;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffectType;", "", "<init>", "(Ljava/lang/String;I)V", "Lcom/microsoft/clarity/protomodels/mutationpayload/L;", "toProtobufType", "()Lcom/microsoft/clarity/protomodels/mutationpayload/L;", "DashPathEffect", "CornerPathEffect", "Path1DPathEffect", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum PathEffectType {
    DashPathEffect,
    CornerPathEffect,
    Path1DPathEffect;

    public final L toProtobufType() {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return L.DashPathEffect;
        }
        if (ordinal == 1) {
            return L.CornerPathEffect;
        }
        if (ordinal != 2) {
            return null;
        }
        return L.Path1DPathEffect;
    }
}
