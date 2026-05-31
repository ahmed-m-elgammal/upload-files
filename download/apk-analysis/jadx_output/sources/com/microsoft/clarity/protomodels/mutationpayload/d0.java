package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class d0 extends GeneratedMessageLite.Builder implements e0 {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d0() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$TextBlobRun r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$TextBlobRun.m2043$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.d0.<init>():void");
    }

    public final d0 a(MutationPayload$Point mutationPayload$Point) {
        copyOnWrite();
        ((MutationPayload$TextBlobRun) this.instance).setPoint(mutationPayload$Point);
        return this;
    }

    public final d0 b(float f) {
        copyOnWrite();
        ((MutationPayload$TextBlobRun) this.instance).setFontSize(f);
        return this;
    }

    public final void c(float f) {
        copyOnWrite();
        ((MutationPayload$TextBlobRun) this.instance).setFontSkewX(f);
    }

    public final void a(float f) {
        copyOnWrite();
        ((MutationPayload$TextBlobRun) this.instance).setFontScaleX(f);
    }

    public final void b(ArrayList arrayList) {
        copyOnWrite();
        ((MutationPayload$TextBlobRun) this.instance).addAllGlyphs(arrayList);
    }

    public final void a(int i) {
        copyOnWrite();
        ((MutationPayload$TextBlobRun) this.instance).setTypefaceIndex(i);
    }

    public final void a(MutationPayload$FloatList mutationPayload$FloatList) {
        copyOnWrite();
        ((MutationPayload$TextBlobRun) this.instance).addPositions(mutationPayload$FloatList);
    }

    public final void a(ArrayList arrayList) {
        copyOnWrite();
        ((MutationPayload$TextBlobRun) this.instance).addAllClusters(arrayList);
    }

    public final void a(String str) {
        copyOnWrite();
        ((MutationPayload$TextBlobRun) this.instance).setText(str);
    }
}
