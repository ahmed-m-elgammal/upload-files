package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;

/* loaded from: classes5.dex */
public final class N extends GeneratedMessageLite.Builder implements P {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public N() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathVerb r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathVerb.m1989$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.N.<init>():void");
    }

    public final N a(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setRRect(mutationPayload$Rect);
        return this;
    }

    public final N b(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setCpx2(f);
        return this;
    }

    public final N c(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setCpy1(f);
        return this;
    }

    public final N d(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setCpy2(f);
        return this;
    }

    public final N e(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setWeight(f);
        return this;
    }

    public final N f(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setX(f);
        return this;
    }

    public final N g(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setX1(f);
        return this;
    }

    public final N h(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setX2(f);
        return this;
    }

    public final N i(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setY(f);
        return this;
    }

    public final N j(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setY1(f);
        return this;
    }

    public final N k(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setY2(f);
        return this;
    }

    public final N a(boolean z) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setIsCCW(z);
        return this;
    }

    public final N a(float f) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setCpx1(f);
        return this;
    }

    public final N a(Q q) {
        copyOnWrite();
        ((MutationPayload$PathVerb) this.instance).setTypeEnum(q);
        return this;
    }
}
