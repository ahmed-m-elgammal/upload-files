package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public final class J extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public J() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathEffect r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathEffect.m1974$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.J.<init>():void");
    }

    public final J a(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$PathEffect) this.instance).addAllIntervals(iterable);
        return this;
    }

    public final J b(float f) {
        copyOnWrite();
        ((MutationPayload$PathEffect) this.instance).setPhase(f);
        return this;
    }

    public final J c(float f) {
        copyOnWrite();
        ((MutationPayload$PathEffect) this.instance).setRadius(f);
        return this;
    }

    public final J a(float f) {
        copyOnWrite();
        ((MutationPayload$PathEffect) this.instance).setAdvance(f);
        return this;
    }

    public final J a(long j) {
        copyOnWrite();
        ((MutationPayload$PathEffect) this.instance).setStyle(j);
        return this;
    }

    public final J a(MutationPayload$Path mutationPayload$Path) {
        copyOnWrite();
        ((MutationPayload$PathEffect) this.instance).setPath(mutationPayload$Path);
        return this;
    }

    public final J a(L l) {
        copyOnWrite();
        ((MutationPayload$PathEffect) this.instance).setTypeEnum(l);
        return this;
    }
}
