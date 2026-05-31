package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public final class U extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public U() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Rect r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Rect.m1998$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.U.<init>():void");
    }

    public final U a(float f) {
        copyOnWrite();
        ((MutationPayload$Rect) this.instance).setBottom(f);
        return this;
    }

    public final U b(float f) {
        copyOnWrite();
        ((MutationPayload$Rect) this.instance).setLeft(f);
        return this;
    }

    public final U c(float f) {
        copyOnWrite();
        ((MutationPayload$Rect) this.instance).setRight(f);
        return this;
    }

    public final U d(float f) {
        copyOnWrite();
        ((MutationPayload$Rect) this.instance).setTop(f);
        return this;
    }

    public final void a(MutationPayload$FloatList mutationPayload$FloatList) {
        copyOnWrite();
        ((MutationPayload$Rect) this.instance).addRadii(mutationPayload$FloatList);
    }
}
