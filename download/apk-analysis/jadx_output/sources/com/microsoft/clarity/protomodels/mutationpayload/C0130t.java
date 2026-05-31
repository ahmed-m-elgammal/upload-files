package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0130t extends GeneratedMessageLite.Builder implements InterfaceC0131u {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0130t() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Image r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Image.m1924$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0130t.<init>():void");
    }

    public final void a(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$Image) this.instance).setSubset(mutationPayload$Rect);
    }

    public final void a(String str) {
        copyOnWrite();
        ((MutationPayload$Image) this.instance).setDataHash(str);
    }

    public final void a(ByteString byteString) {
        copyOnWrite();
        ((MutationPayload$Image) this.instance).setMipmap(byteString);
    }
}
