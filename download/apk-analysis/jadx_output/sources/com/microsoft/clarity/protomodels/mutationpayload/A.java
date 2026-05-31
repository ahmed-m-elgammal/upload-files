package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes5.dex */
public final class A extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public A() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Looper r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Looper.m1943$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.A.<init>():void");
    }

    public final A a(List list) {
        copyOnWrite();
        ((MutationPayload$Looper) this.instance).addAllLayers(list);
        return this;
    }

    public final A a(C c) {
        copyOnWrite();
        ((MutationPayload$Looper) this.instance).setTypeEnum(c);
        return this;
    }
}
