package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.Internal;

/* loaded from: classes5.dex */
public enum C implements Internal.EnumLite {
    LayerDrawLooper(0),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f200a;

    C(int i) {
        this.f200a = i;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f200a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
