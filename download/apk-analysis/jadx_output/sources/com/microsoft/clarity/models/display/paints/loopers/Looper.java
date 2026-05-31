package com.microsoft.clarity.models.display.paints.loopers;

import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.common.Flattenable;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Looper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00000\u0004B\u0005¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/loopers/Looper;", "Lcom/microsoft/clarity/models/display/common/Flattenable;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Looper;", "Lcom/microsoft/clarity/models/ICopyable;", "()V", "type", "Lcom/microsoft/clarity/models/display/paints/loopers/LooperType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/loopers/LooperType;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Looper extends Flattenable implements IProtoModel<MutationPayload$Looper>, ICopyable<Looper> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public Looper copyWithNullData() {
        return (Looper) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public abstract LooperType getType();
}
