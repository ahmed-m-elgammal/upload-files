package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0126o extends GeneratedMessageLite.Builder implements InterfaceC0127p {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0126o() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FloatList r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FloatList.m1913$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0126o.<init>():void");
    }

    public final C0126o a(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$FloatList) this.instance).addAllValue(iterable);
        return this;
    }
}
