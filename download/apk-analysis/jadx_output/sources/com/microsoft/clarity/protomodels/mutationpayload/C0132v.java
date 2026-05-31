package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0132v extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0132v() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$IntList r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$IntList.m1926$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0132v.<init>():void");
    }

    public final C0132v a(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$IntList) this.instance).addAllValue(iterable);
        return this;
    }
}
