package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.Internal;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC0121j implements Internal.EnumLite {
    ClipRect(0),
    Concat(1),
    Concat44(2),
    DrawArc(3),
    DrawBehindPaint(4),
    DrawDRRect(5),
    DrawImage(6),
    DrawImageLattice(7),
    DrawImageNine(8),
    DrawImageRect(9),
    DrawPaint(10),
    DrawPath(11),
    DrawRect(12),
    Translate(13),
    DrawOval(14),
    DrawPoints(15),
    DrawRRect(16),
    DrawTextBlob(17),
    DrawVertices(18),
    DrawViewEndAnnotation(19),
    DrawViewStartAnnotation(20),
    Restore(21),
    Save(22),
    SaveBehind(23),
    SaveLayer(24),
    Scale(25),
    SetMatrix(26),
    SetMatrix44(27),
    ClipPath(28),
    ClipRRect(29),
    DrawViewContentEndAnnotation(30),
    DrawViewContentStartAnnotation(31),
    FillViewCommandsAnnotation(32),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f215a;

    EnumC0121j(int i) {
        this.f215a = i;
    }

    public static EnumC0121j a(int i) {
        switch (i) {
            case 0:
                return ClipRect;
            case 1:
                return Concat;
            case 2:
                return Concat44;
            case 3:
                return DrawArc;
            case 4:
                return DrawBehindPaint;
            case 5:
                return DrawDRRect;
            case 6:
                return DrawImage;
            case 7:
                return DrawImageLattice;
            case 8:
                return DrawImageNine;
            case 9:
                return DrawImageRect;
            case 10:
                return DrawPaint;
            case 11:
                return DrawPath;
            case 12:
                return DrawRect;
            case 13:
                return Translate;
            case 14:
                return DrawOval;
            case 15:
                return DrawPoints;
            case 16:
                return DrawRRect;
            case 17:
                return DrawTextBlob;
            case 18:
                return DrawVertices;
            case 19:
                return DrawViewEndAnnotation;
            case 20:
                return DrawViewStartAnnotation;
            case 21:
                return Restore;
            case 22:
                return Save;
            case 23:
                return SaveBehind;
            case 24:
                return SaveLayer;
            case 25:
                return Scale;
            case 26:
                return SetMatrix;
            case 27:
                return SetMatrix44;
            case 28:
                return ClipPath;
            case 29:
                return ClipRRect;
            case 30:
                return DrawViewContentEndAnnotation;
            case 31:
                return DrawViewContentStartAnnotation;
            case 32:
                return FillViewCommandsAnnotation;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f215a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
