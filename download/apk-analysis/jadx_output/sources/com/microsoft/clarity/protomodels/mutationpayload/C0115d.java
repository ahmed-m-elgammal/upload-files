package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0115d extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0115d() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$ColorFilter r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$ColorFilter.m1848$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0115d.<init>():void");
    }

    public final void a(double d) {
        copyOnWrite();
        ((MutationPayload$ColorFilter) this.instance).setColor(d);
    }

    public final C0115d b(double d) {
        copyOnWrite();
        ((MutationPayload$ColorFilter) this.instance).setMode(d);
        return this;
    }

    public final void a(MutationPayload$Color4f mutationPayload$Color4f) {
        copyOnWrite();
        ((MutationPayload$ColorFilter) this.instance).setColor4F(mutationPayload$Color4f);
    }

    public final void b(boolean z) {
        copyOnWrite();
        ((MutationPayload$ColorFilter) this.instance).setIsRowMajor(z);
    }

    public final C0115d a(MutationPayload$FloatList mutationPayload$FloatList) {
        copyOnWrite();
        ((MutationPayload$ColorFilter) this.instance).setMatrix(mutationPayload$FloatList);
        return this;
    }

    public final void a(boolean z) {
        copyOnWrite();
        ((MutationPayload$ColorFilter) this.instance).setIsRgba(z);
    }

    public final C0115d a(EnumC0117f enumC0117f) {
        copyOnWrite();
        ((MutationPayload$ColorFilter) this.instance).setTypeEnum(enumC0117f);
        return this;
    }
}
