package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class MutationPayload$PathVerb extends GeneratedMessageLite<MutationPayload$PathVerb, N> implements P {
    public static final int CPX1_FIELD_NUMBER = 9;
    public static final int CPX2_FIELD_NUMBER = 11;
    public static final int CPY1_FIELD_NUMBER = 10;
    public static final int CPY2_FIELD_NUMBER = 12;
    private static final MutationPayload$PathVerb DEFAULT_INSTANCE;
    public static final int IS_C_C_W_FIELD_NUMBER = 3;
    private static volatile Parser<MutationPayload$PathVerb> PARSER = null;
    public static final int R_RECT_FIELD_NUMBER = 2;
    public static final int TYPEENUM_FIELD_NUMBER = 15;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int WEIGHT_FIELD_NUMBER = 8;
    public static final int X1_FIELD_NUMBER = 4;
    public static final int X2_FIELD_NUMBER = 6;
    public static final int X_FIELD_NUMBER = 13;
    public static final int Y1_FIELD_NUMBER = 5;
    public static final int Y2_FIELD_NUMBER = 7;
    public static final int Y_FIELD_NUMBER = 14;
    private int bitField0_;
    private float cpx1_;
    private float cpx2_;
    private float cpy1_;
    private float cpy2_;
    private boolean isCCW_;
    private MutationPayload$Rect rRect_;
    private int typeOneOfCase_ = 0;
    private Object typeOneOf_;
    private float weight_;
    private float x1_;
    private float x2_;
    private float x_;
    private float y1_;
    private float y2_;
    private float y_;

    static {
        MutationPayload$PathVerb mutationPayload$PathVerb = new MutationPayload$PathVerb();
        DEFAULT_INSTANCE = mutationPayload$PathVerb;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$PathVerb.class, mutationPayload$PathVerb);
    }

    private MutationPayload$PathVerb() {
    }

    private void clearCpx1() {
        this.bitField0_ &= -129;
        this.cpx1_ = 0.0f;
    }

    private void clearCpx2() {
        this.bitField0_ &= -513;
        this.cpx2_ = 0.0f;
    }

    private void clearCpy1() {
        this.bitField0_ &= -257;
        this.cpy1_ = 0.0f;
    }

    private void clearCpy2() {
        this.bitField0_ &= -1025;
        this.cpy2_ = 0.0f;
    }

    private void clearIsCCW() {
        this.bitField0_ &= -3;
        this.isCCW_ = false;
    }

    private void clearRRect() {
        this.rRect_ = null;
        this.bitField0_ &= -2;
    }

    private void clearType() {
        if (this.typeOneOfCase_ == 1) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeEnum() {
        if (this.typeOneOfCase_ == 15) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeOneOf() {
        this.typeOneOfCase_ = 0;
        this.typeOneOf_ = null;
    }

    private void clearWeight() {
        this.bitField0_ &= -65;
        this.weight_ = 0.0f;
    }

    private void clearX() {
        this.bitField0_ &= -2049;
        this.x_ = 0.0f;
    }

    private void clearX1() {
        this.bitField0_ &= -5;
        this.x1_ = 0.0f;
    }

    private void clearX2() {
        this.bitField0_ &= -17;
        this.x2_ = 0.0f;
    }

    private void clearY() {
        this.bitField0_ &= -4097;
        this.y_ = 0.0f;
    }

    private void clearY1() {
        this.bitField0_ &= -9;
        this.y1_ = 0.0f;
    }

    private void clearY2() {
        this.bitField0_ &= -33;
        this.y2_ = 0.0f;
    }

    public static MutationPayload$PathVerb getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRRect(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.rRect_;
        if (mutationPayload$Rect2 == null || mutationPayload$Rect2 == MutationPayload$Rect.getDefaultInstance()) {
            this.rRect_ = mutationPayload$Rect;
        } else {
            this.rRect_ = (MutationPayload$Rect) ((U) MutationPayload$Rect.newBuilder(this.rRect_).mergeFrom((U) mutationPayload$Rect)).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static N newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$PathVerb parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$PathVerb parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$PathVerb> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpx1(float f) {
        this.bitField0_ |= 128;
        this.cpx1_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpx2(float f) {
        this.bitField0_ |= 512;
        this.cpx2_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpy1(float f) {
        this.bitField0_ |= 256;
        this.cpy1_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpy2(float f) {
        this.bitField0_ |= 1024;
        this.cpy2_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsCCW(boolean z) {
        this.bitField0_ |= 2;
        this.isCCW_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRRect(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.rRect_ = mutationPayload$Rect;
        this.bitField0_ |= 1;
    }

    private void setType(String str) {
        str.getClass();
        this.typeOneOfCase_ = 1;
        this.typeOneOf_ = str;
    }

    private void setTypeBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.typeOneOf_ = byteString.toStringUtf8();
        this.typeOneOfCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeEnum(Q q) {
        this.typeOneOf_ = Integer.valueOf(q.getNumber());
        this.typeOneOfCase_ = 15;
    }

    private void setTypeEnumValue(int i) {
        this.typeOneOfCase_ = 15;
        this.typeOneOf_ = Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWeight(float f) {
        this.bitField0_ |= 64;
        this.weight_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX(float f) {
        this.bitField0_ |= 2048;
        this.x_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX1(float f) {
        this.bitField0_ |= 4;
        this.x1_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX2(float f) {
        this.bitField0_ |= 16;
        this.x2_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY(float f) {
        this.bitField0_ |= 4096;
        this.y_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY1(float f) {
        this.bitField0_ |= 8;
        this.y1_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY2(float f) {
        this.bitField0_ |= 32;
        this.y2_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$PathVerb();
            case 2:
                return new N();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0001\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001Ȼ\u0000\u0002ဉ\u0000\u0003ဇ\u0001\u0004ခ\u0002\u0005ခ\u0003\u0006ခ\u0004\u0007ခ\u0005\bခ\u0006\tခ\u0007\nခ\b\u000bခ\t\fခ\n\rခ\u000b\u000eခ\f\u000f?\u0000", new Object[]{"typeOneOf_", "typeOneOfCase_", "bitField0_", "rRect_", "isCCW_", "x1_", "y1_", "x2_", "y2_", "weight_", "cpx1_", "cpy1_", "cpx2_", "cpy2_", "x_", "y_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$PathVerb> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$PathVerb.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public float getCpx1() {
        return this.cpx1_;
    }

    public float getCpx2() {
        return this.cpx2_;
    }

    public float getCpy1() {
        return this.cpy1_;
    }

    public float getCpy2() {
        return this.cpy2_;
    }

    public boolean getIsCCW() {
        return this.isCCW_;
    }

    public MutationPayload$Rect getRRect() {
        MutationPayload$Rect mutationPayload$Rect = this.rRect_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public Q getTypeEnum() {
        if (this.typeOneOfCase_ != 15) {
            return Q.AddRRectPathVerb;
        }
        Q a2 = Q.a(((Integer) this.typeOneOf_).intValue());
        return a2 == null ? Q.UNRECOGNIZED : a2;
    }

    public int getTypeEnumValue() {
        if (this.typeOneOfCase_ == 15) {
            return ((Integer) this.typeOneOf_).intValue();
        }
        return 0;
    }

    public O getTypeOneOfCase() {
        int i = this.typeOneOfCase_;
        if (i == 0) {
            return O.TYPEONEOF_NOT_SET;
        }
        if (i == 1) {
            return O.TYPE;
        }
        if (i != 15) {
            return null;
        }
        return O.TYPEENUM;
    }

    public float getWeight() {
        return this.weight_;
    }

    public float getX() {
        return this.x_;
    }

    public float getX1() {
        return this.x1_;
    }

    public float getX2() {
        return this.x2_;
    }

    public float getY() {
        return this.y_;
    }

    public float getY1() {
        return this.y1_;
    }

    public float getY2() {
        return this.y2_;
    }

    public boolean hasCpx1() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasCpx2() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasCpy1() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasCpy2() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasIsCCW() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRRect() {
        return (this.bitField0_ & 1) != 0;
    }

    @Deprecated
    public boolean hasType() {
        return this.typeOneOfCase_ == 1;
    }

    public boolean hasTypeEnum() {
        return this.typeOneOfCase_ == 15;
    }

    public boolean hasWeight() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasX() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasX1() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasX2() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasY() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasY1() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasY2() {
        return (this.bitField0_ & 32) != 0;
    }

    public static N newBuilder(MutationPayload$PathVerb mutationPayload$PathVerb) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$PathVerb);
    }

    public static MutationPayload$PathVerb parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$PathVerb parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    @Deprecated
    public String getType() {
        return this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "";
    }

    @Deprecated
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "");
    }

    public static MutationPayload$PathVerb parseFrom(ByteString byteString) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$PathVerb parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$PathVerb parseFrom(byte[] bArr) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$PathVerb parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$PathVerb parseFrom(InputStream inputStream) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$PathVerb parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$PathVerb parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$PathVerb parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathVerb) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
