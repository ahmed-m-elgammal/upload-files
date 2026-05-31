package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import java.util.List;

/* loaded from: classes5.dex */
public final class I extends GeneratedMessageLite.Builder implements M {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public I() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Path r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Path.m1966$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.I.<init>():void");
    }

    public final I a(int i) {
        copyOnWrite();
        ((MutationPayload$Path) this.instance).setFillType(i);
        return this;
    }

    public final I a(List list) {
        copyOnWrite();
        ((MutationPayload$Path) this.instance).addAllVerbs(list);
        return this;
    }
}
