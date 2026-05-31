package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.Internal;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC0117f implements Internal.EnumLite {
    ModeColorFilter(0),
    MatrixColorFilter(1),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f213a;

    EnumC0117f(int i) {
        this.f213a = i;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f213a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
