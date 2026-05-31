package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;

/* loaded from: classes5.dex */
public final class S extends GeneratedMessageLite.Builder implements T {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public S() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Point r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Point.m1992$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.S.<init>():void");
    }

    public final S a(float f) {
        copyOnWrite();
        ((MutationPayload$Point) this.instance).setX(f);
        return this;
    }

    public final S b(float f) {
        copyOnWrite();
        ((MutationPayload$Point) this.instance).setY(f);
        return this;
    }
}
