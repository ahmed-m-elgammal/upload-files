package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0128q extends GeneratedMessageLite.Builder implements r {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0128q() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FontCoordinate r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FontCoordinate.m1916$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0128q.<init>():void");
    }

    public final C0128q a(String str) {
        copyOnWrite();
        ((MutationPayload$FontCoordinate) this.instance).setAxis(str);
        return this;
    }

    public final C0128q a(float f) {
        copyOnWrite();
        ((MutationPayload$FontCoordinate) this.instance).setValue(f);
        return this;
    }
}
