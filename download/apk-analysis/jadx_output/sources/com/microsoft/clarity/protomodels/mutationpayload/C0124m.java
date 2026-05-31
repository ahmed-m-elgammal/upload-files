package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import java.util.ArrayList;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0124m extends GeneratedMessageLite.Builder implements InterfaceC0125n {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0124m() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DoubleList r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DoubleList.m1911$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0124m.<init>():void");
    }

    public final C0124m a(ArrayList arrayList) {
        copyOnWrite();
        ((MutationPayload$DoubleList) this.instance).addAllValue(arrayList);
        return this;
    }
}
