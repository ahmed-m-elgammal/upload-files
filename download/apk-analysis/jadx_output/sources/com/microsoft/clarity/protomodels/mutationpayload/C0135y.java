package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0135y extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0135y() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$LayerInfo r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$LayerInfo.m1940$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0135y.<init>():void");
    }

    public final C0135y a(int i) {
        copyOnWrite();
        ((MutationPayload$LayerInfo) this.instance).setColorMode(i);
        return this;
    }

    public final C0135y b(int i) {
        copyOnWrite();
        ((MutationPayload$LayerInfo) this.instance).setPaintBits(i);
        return this;
    }

    public final C0135y a(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$LayerInfo) this.instance).addAllOffset(iterable);
        return this;
    }

    public final C0135y a(boolean z) {
        copyOnWrite();
        ((MutationPayload$LayerInfo) this.instance).setPostTranslate(z);
        return this;
    }
}
