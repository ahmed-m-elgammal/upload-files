package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0113b extends GeneratedMessageLite.Builder implements InterfaceC0114c {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0113b() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Color4f r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Color4f.m1840$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0113b.<init>():void");
    }

    public final C0113b a(float f) {
        copyOnWrite();
        ((MutationPayload$Color4f) this.instance).setA(f);
        return this;
    }

    public final C0113b b(float f) {
        copyOnWrite();
        ((MutationPayload$Color4f) this.instance).setB(f);
        return this;
    }

    public final C0113b c(float f) {
        copyOnWrite();
        ((MutationPayload$Color4f) this.instance).setG(f);
        return this;
    }

    public final C0113b d(float f) {
        copyOnWrite();
        ((MutationPayload$Color4f) this.instance).setR(f);
        return this;
    }
}
