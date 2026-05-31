package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import java.util.List;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0118g extends GeneratedMessageLite.Builder implements InterfaceC0120i {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0118g() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand.m1891$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0118g.<init>():void");
    }

    public final C0118g a(boolean z) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setAntiAlias(z);
        return this;
    }

    public final C0118g b(float f) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setStartAngle(f);
        return this;
    }

    public final C0118g c(float f) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setSweepAngle(f);
        return this;
    }

    public final C0118g d(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setInner(mutationPayload$Rect);
        return this;
    }

    public final C0118g e(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setOuter(mutationPayload$Rect);
        return this;
    }

    public final C0118g f(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setRect(mutationPayload$Rect);
        return this;
    }

    public final C0118g g(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setRrect(mutationPayload$Rect);
        return this;
    }

    public final C0118g h(float f) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setY(f);
        return this;
    }

    public final C0118g i(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setOp(i);
        return this;
    }

    public final C0118g j(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setPaintIndex(i);
        return this;
    }

    public final C0118g k(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setPathIndex(i);
        return this;
    }

    public final C0118g l(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setPointMode(i);
        return this;
    }

    public final C0118g m(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setVerticesIndex(i);
        return this;
    }

    public final C0118g a(Iterable iterable) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).addAllMatrix(iterable);
        return this;
    }

    public final C0118g b(boolean z) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setUseCenter(z);
        return this;
    }

    public final C0118g c(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setDst(mutationPayload$Rect);
        return this;
    }

    public final C0118g d(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setId(i);
        return this;
    }

    public final void e(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setImageFilterPaint(i);
    }

    public final void f(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setImageIndex(i);
    }

    public final C0118g g(float f) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setX(f);
        return this;
    }

    public final void h(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setMaskedWidth(i);
    }

    public final void i(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setSubset(mutationPayload$Rect);
    }

    public final void a(MutationPayload$Sampling mutationPayload$Sampling) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setSampling(mutationPayload$Sampling);
    }

    public final C0118g b(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setCenter(mutationPayload$Rect);
        return this;
    }

    public final C0118g c(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setFlags(i);
        return this;
    }

    public final C0118g d(float f) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setSx(f);
        return this;
    }

    public final C0118g e(float f) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setSy(f);
        return this;
    }

    public final C0118g f(float f) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setTop(f);
        return this;
    }

    public final void g(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setMaskedHeight(i);
    }

    public final void h(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setSrc(mutationPayload$Rect);
    }

    public final void a(MutationPayload$Color4f mutationPayload$Color4f) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setMaskedColor(mutationPayload$Color4f);
    }

    public final C0118g b(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setConstraint(i);
        return this;
    }

    public final C0118g a(MutationPayload$Lattice mutationPayload$Lattice) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setLattice(mutationPayload$Lattice);
        return this;
    }

    public final C0118g b(double d) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setMode(d);
        return this;
    }

    public final void a(double d) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setFilterMode(d);
    }

    public final C0118g a(List list) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).addAllPoints(list);
        return this;
    }

    public final C0118g a(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setBlobIndex(i);
        return this;
    }

    public final void a(MutationPayload$FloatList mutationPayload$FloatList) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).addBones(mutationPayload$FloatList);
    }

    public final C0118g a(String str) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setName(str);
        return this;
    }

    public final void a(MutationPayload$Rect mutationPayload$Rect) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setBounds(mutationPayload$Rect);
    }

    public final C0118g a(float f) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setLeft(f);
        return this;
    }

    public final C0118g a(EnumC0121j enumC0121j) {
        copyOnWrite();
        ((MutationPayload$DisplayCommand) this.instance).setTypeEnum(enumC0121j);
        return this;
    }
}
