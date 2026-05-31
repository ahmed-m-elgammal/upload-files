package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public final class D extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public D() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$MaskFilter r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$MaskFilter.m1948$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.D.<init>():void");
    }

    public final D a(float f) {
        copyOnWrite();
        ((MutationPayload$MaskFilter) this.instance).setSigma(f);
        return this;
    }

    public final D a(int i) {
        copyOnWrite();
        ((MutationPayload$MaskFilter) this.instance).setStyle(i);
        return this;
    }

    public final D a(boolean z) {
        copyOnWrite();
        ((MutationPayload$MaskFilter) this.instance).setRespectCTM(z);
        return this;
    }

    public final D a(F f) {
        copyOnWrite();
        ((MutationPayload$MaskFilter) this.instance).setTypeEnum(f);
        return this;
    }
}
