package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class h0 extends GeneratedMessageLite.Builder implements i0 {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h0() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Vertices r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Vertices.m2065$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.h0.<init>():void");
    }

    public final h0 a(double d) {
        copyOnWrite();
        ((MutationPayload$Vertices) this.instance).setMode(d);
        return this;
    }

    public final void b(List list) {
        copyOnWrite();
        ((MutationPayload$Vertices) this.instance).addAllTexCoords(list);
    }

    public final h0 a(boolean z) {
        copyOnWrite();
        ((MutationPayload$Vertices) this.instance).setIsVolatile(z);
        return this;
    }

    public final h0 b(ArrayList arrayList) {
        copyOnWrite();
        ((MutationPayload$Vertices) this.instance).addAllIndices(arrayList);
        return this;
    }

    public final h0 a(List list) {
        copyOnWrite();
        ((MutationPayload$Vertices) this.instance).addAllPositions(list);
        return this;
    }

    public final void a(ArrayList arrayList) {
        copyOnWrite();
        ((MutationPayload$Vertices) this.instance).addAllColors(arrayList);
    }

    public final void a(MutationPayload$DoubleList mutationPayload$DoubleList) {
        copyOnWrite();
        ((MutationPayload$Vertices) this.instance).addBoneIndices(mutationPayload$DoubleList);
    }

    public final void a(MutationPayload$FloatList mutationPayload$FloatList) {
        copyOnWrite();
        ((MutationPayload$Vertices) this.instance).addBoneWeights(mutationPayload$FloatList);
    }
}
