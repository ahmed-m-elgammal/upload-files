package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.Internal;

/* loaded from: classes5.dex */
public enum a0 implements Internal.EnumLite {
    ImageShader(0),
    LinearGradientShader(1),
    RadialGradientShader(2),
    SweepGradientShader(3),
    LocalMatrixShader(4),
    Color4Shader(5),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f211a;

    a0(int i2) {
        this.f211a = i2;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f211a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
