package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.ArrayList;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0133w extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0133w() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Lattice r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Lattice.m1932$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0133w.<init>():void");
    }

    public final C0133w a(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$Lattice) this.instance).setBounds(mutationPayload$Rect);
        return this;
    }

    public final C0133w b(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$Lattice) this.instance).addAllXDivs(iterable);
        return this;
    }

    public final C0133w c(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$Lattice) this.instance).addAllYDivs(iterable);
        return this;
    }

    public final C0133w a(ArrayList arrayList) {
        copyOnWrite();
        ((MutationPayload$Lattice) this.instance).addAllColors(arrayList);
        return this;
    }

    public final C0133w a(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$Lattice) this.instance).addAllRectType(iterable);
        return this;
    }
}
