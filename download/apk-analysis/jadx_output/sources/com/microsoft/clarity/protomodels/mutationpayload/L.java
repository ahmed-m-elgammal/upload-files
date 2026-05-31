package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.Internal;

/* loaded from: classes5.dex */
public enum L implements Internal.EnumLite {
    DashPathEffect(0),
    CornerPathEffect(1),
    Path1DPathEffect(2),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f204a;

    L(int i) {
        this.f204a = i;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f204a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
