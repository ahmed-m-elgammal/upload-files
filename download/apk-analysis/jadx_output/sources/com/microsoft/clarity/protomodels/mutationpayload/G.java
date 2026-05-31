package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;

/* loaded from: classes5.dex */
public final class G extends GeneratedMessageLite.Builder implements H {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public G() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Paint r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Paint.m1963$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.G.<init>():void");
    }

    public final G a(MutationPayload$Color4f mutationPayload$Color4f) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setColor(mutationPayload$Color4f);
        return this;
    }

    public final G b(double d) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setStrokeCap(d);
        return this;
    }

    public final G c(double d) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setStrokeJoin(d);
        return this;
    }

    public final G d(double d) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setStyle(d);
        return this;
    }

    public final G a(double d) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setBlendMode(d);
        return this;
    }

    public final G b(float f) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setStrokeWidth(f);
        return this;
    }

    public final G a(float f) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setStrokeMiter(f);
        return this;
    }

    public final G b(boolean z) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setDither(z);
        return this;
    }

    public final G a(boolean z) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setAntiAlias(z);
        return this;
    }

    public final void a(MutationPayload$ColorFilter mutationPayload$ColorFilter) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setColorFilter(mutationPayload$ColorFilter);
    }

    public final void a(MutationPayload$MaskFilter mutationPayload$MaskFilter) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setMaskFilter(mutationPayload$MaskFilter);
    }

    public final void a(MutationPayload$Shader mutationPayload$Shader) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setShader(mutationPayload$Shader);
    }

    public final void a(MutationPayload$Looper mutationPayload$Looper) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setLooper(mutationPayload$Looper);
    }

    public final void a(MutationPayload$PathEffect mutationPayload$PathEffect) {
        copyOnWrite();
        ((MutationPayload$Paint) this.instance).setPathEffect(mutationPayload$PathEffect);
    }
}
