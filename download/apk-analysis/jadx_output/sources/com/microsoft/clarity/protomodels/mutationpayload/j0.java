package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public final class j0 extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j0() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$ViewHierarchy r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$ViewHierarchy.m2069$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.j0.<init>():void");
    }

    public final j0 a(double d) {
        copyOnWrite();
        ((MutationPayload$ViewHierarchy) this.instance).setTimestamp(d);
        return this;
    }

    public final j0 a(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$ViewHierarchy) this.instance).addAllVisibleFragments(iterable);
        return this;
    }

    public final j0 a(MutationPayload$ViewNodeDelta mutationPayload$ViewNodeDelta) {
        copyOnWrite();
        ((MutationPayload$ViewHierarchy) this.instance).setRootDelta(mutationPayload$ViewNodeDelta);
        return this;
    }
}
