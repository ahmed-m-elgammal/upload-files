package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0129s extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0129s() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FontStyle r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FontStyle.m1920$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0129s.<init>():void");
    }

    public final C0129s a(double d) {
        copyOnWrite();
        ((MutationPayload$FontStyle) this.instance).setSlant(d);
        return this;
    }

    public final C0129s b(double d) {
        copyOnWrite();
        ((MutationPayload$FontStyle) this.instance).setWeight(d);
        return this;
    }

    public final C0129s c(double d) {
        copyOnWrite();
        ((MutationPayload$FontStyle) this.instance).setWidth(d);
        return this;
    }
}
