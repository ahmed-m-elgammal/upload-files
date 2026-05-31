package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class f0 extends GeneratedMessageLite.Builder implements g0 {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f0() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Typeface r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Typeface.m2056$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.f0.<init>():void");
    }

    public final f0 a(MutationPayload$FontStyle mutationPayload$FontStyle) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setStyle(mutationPayload$FontStyle);
        return this;
    }

    public final void b(String str) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setFamilyName(str);
    }

    public final void c(String str) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setFullName(str);
    }

    public final void d(String str) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setPostscriptName(str);
    }

    public final void a(double d) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setCollectionIndex(d);
    }

    public final void b(float f) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setSlantValue(f);
    }

    public final void c(float f) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setWeightValue(f);
    }

    public final void d(float f) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setWidthValue(f);
    }

    public final void a(ArrayList arrayList) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).addAllCoordinates(arrayList);
    }

    public final void b(double d) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setPalleteIndex(d);
    }

    public final void a(String str) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setDataHash(str);
    }

    public final void a(float f) {
        copyOnWrite();
        ((MutationPayload$Typeface) this.instance).setItalicValue(f);
    }
}
