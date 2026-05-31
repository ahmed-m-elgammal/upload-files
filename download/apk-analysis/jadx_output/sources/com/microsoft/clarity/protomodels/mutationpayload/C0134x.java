package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.x, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0134x extends GeneratedMessageLite.Builder implements InterfaceC0136z {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0134x() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Layer r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Layer.m1935$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0134x.<init>():void");
    }

    public final C0134x a(MutationPayload$LayerInfo mutationPayload$LayerInfo) {
        copyOnWrite();
        ((MutationPayload$Layer) this.instance).setLayerInfo(mutationPayload$LayerInfo);
        return this;
    }

    public final C0134x a(MutationPayload$Paint mutationPayload$Paint) {
        copyOnWrite();
        ((MutationPayload$Layer) this.instance).setPaint(mutationPayload$Paint);
        return this;
    }
}
