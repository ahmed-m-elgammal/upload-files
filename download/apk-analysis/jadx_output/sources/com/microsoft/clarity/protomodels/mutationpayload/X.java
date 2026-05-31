package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.Internal;

/* loaded from: classes5.dex */
public enum X implements Internal.EnumLite {
    CubicSampling(0),
    NonCubicSampling(1),
    AnisoSampling(2),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f208a;

    X(int i) {
        this.f208a = i;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f208a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
