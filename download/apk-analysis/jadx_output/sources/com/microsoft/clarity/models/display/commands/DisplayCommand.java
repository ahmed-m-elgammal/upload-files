package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0005¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "Lcom/microsoft/clarity/models/ICopyable;", "()V", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DisplayCommand implements IProtoModel<MutationPayload$DisplayCommand>, ICopyable<DisplayCommand> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public DisplayCommand copyWithNullData() {
        return (DisplayCommand) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public abstract DisplayCommandType getType();
}
