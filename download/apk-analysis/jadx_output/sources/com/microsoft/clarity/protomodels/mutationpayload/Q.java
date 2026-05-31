package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.Internal;

/* loaded from: classes5.dex */
public enum Q implements Internal.EnumLite {
    AddRRectPathVerb(0),
    ClosePathVerb(1),
    ConicPathVerb(2),
    CubicPathVerb(3),
    DonePathVerb(4),
    LinePathVerb(5),
    MovePathVerb(6),
    QuadPathVerb(7),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f206a;

    Q(int i) {
        this.f206a = i;
    }

    public static Q a(int i) {
        switch (i) {
            case 0:
                return AddRRectPathVerb;
            case 1:
                return ClosePathVerb;
            case 2:
                return ConicPathVerb;
            case 3:
                return CubicPathVerb;
            case 4:
                return DonePathVerb;
            case 5:
                return LinePathVerb;
            case 6:
                return MovePathVerb;
            case 7:
                return QuadPathVerb;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f206a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
