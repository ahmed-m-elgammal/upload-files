package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public final class V extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public V() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Sampling r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Sampling.m2005$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.V.<init>():void");
    }

    public final V a(float f) {
        copyOnWrite();
        ((MutationPayload$Sampling) this.instance).setB(f);
        return this;
    }

    public final V b(float f) {
        copyOnWrite();
        ((MutationPayload$Sampling) this.instance).setC(f);
        return this;
    }

    public final V c(int i) {
        copyOnWrite();
        ((MutationPayload$Sampling) this.instance).setMipmap(i);
        return this;
    }

    public final V a(int i) {
        copyOnWrite();
        ((MutationPayload$Sampling) this.instance).setFilter(i);
        return this;
    }

    public final V b(int i) {
        copyOnWrite();
        ((MutationPayload$Sampling) this.instance).setMaxAniso(i);
        return this;
    }

    public final V a(X x) {
        copyOnWrite();
        ((MutationPayload$Sampling) this.instance).setTypeEnum(x);
        return this;
    }
}
