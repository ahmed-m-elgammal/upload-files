package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes5.dex */
public final class Y extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Y() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Shader r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Shader.m2030$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.Y.<init>():void");
    }

    public final Y a(boolean z) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setRaw(z);
        return this;
    }

    public final Y b(double d) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setTX(d);
        return this;
    }

    public final Y c(double d) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setTY(d);
        return this;
    }

    public final Y d(double d) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setTileMode(d);
        return this;
    }

    public final void a(MutationPayload$Sampling mutationPayload$Sampling) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setSampling(mutationPayload$Sampling);
    }

    public final Y b(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).addAllMatrix(iterable);
        return this;
    }

    public final void c(int i) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setMaskedWidth(i);
    }

    public final void a(int i) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setImageIndex(i);
    }

    public final void b(int i) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setMaskedHeight(i);
    }

    public final Y c(MutationPayload$Point mutationPayload$Point) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setStart(mutationPayload$Point);
        return this;
    }

    public final Y a(double d) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setGradFlags(d);
        return this;
    }

    public final void b(MutationPayload$Color4f mutationPayload$Color4f) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setMaskedColor(mutationPayload$Color4f);
    }

    public final void c(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).addAllPos(iterable);
    }

    public final Y a(List list) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).addAllColors(list);
        return this;
    }

    public final Y b(MutationPayload$Point mutationPayload$Point) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setEnd(mutationPayload$Point);
        return this;
    }

    public final Y c(float f) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setStartAngle(f);
        return this;
    }

    public final void a(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).addAllLocalMatrix(iterable);
    }

    public final Y b(float f) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setRadius(f);
        return this;
    }

    public final Y a(MutationPayload$Point mutationPayload$Point) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setCenter(mutationPayload$Point);
        return this;
    }

    public final Y a(float f) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setEndAngle(f);
        return this;
    }

    public final void a(MutationPayload$Shader mutationPayload$Shader) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setShader(mutationPayload$Shader);
    }

    public final Y a(MutationPayload$Color4f mutationPayload$Color4f) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setColor4F(mutationPayload$Color4f);
        return this;
    }

    public final void a(MutationPayload$IntList mutationPayload$IntList) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setColor4FSpaceData(mutationPayload$IntList);
    }

    public final Y a(a0 a0Var) {
        copyOnWrite();
        ((MutationPayload$Shader) this.instance).setTypeEnum(a0Var);
        return this;
    }
}
