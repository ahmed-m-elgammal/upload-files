package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class MutationPayload$Sampling extends GeneratedMessageLite<MutationPayload$Sampling, V> implements MessageLiteOrBuilder {
    private static final MutationPayload$Sampling DEFAULT_INSTANCE;
    public static final int FILTER_FIELD_NUMBER = 4;
    public static final int MAX_ANISO_FIELD_NUMBER = 6;
    public static final int MIPMAP_FIELD_NUMBER = 5;
    private static volatile Parser<MutationPayload$Sampling> PARSER = null;
    public static final int TYPEENUM_FIELD_NUMBER = 7;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int _B_FIELD_NUMBER = 2;
    public static final int _C_FIELD_NUMBER = 3;
    private float B_;
    private float C_;
    private int bitField0_;
    private int filter_;
    private int maxAniso_;
    private int mipmap_;
    private int typeOneOfCase_ = 0;
    private Object typeOneOf_;

    static {
        MutationPayload$Sampling mutationPayload$Sampling = new MutationPayload$Sampling();
        DEFAULT_INSTANCE = mutationPayload$Sampling;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Sampling.class, mutationPayload$Sampling);
    }

    private MutationPayload$Sampling() {
    }

    private void clearB() {
        this.bitField0_ &= -2;
        this.B_ = 0.0f;
    }

    private void clearC() {
        this.bitField0_ &= -3;
        this.C_ = 0.0f;
    }

    private void clearFilter() {
        this.bitField0_ &= -5;
        this.filter_ = 0;
    }

    private void clearMaxAniso() {
        this.bitField0_ &= -17;
        this.maxAniso_ = 0;
    }

    private void clearMipmap() {
        this.bitField0_ &= -9;
        this.mipmap_ = 0;
    }

    private void clearType() {
        if (this.typeOneOfCase_ == 1) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeEnum() {
        if (this.typeOneOfCase_ == 7) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeOneOf() {
        this.typeOneOfCase_ = 0;
        this.typeOneOf_ = null;
    }

    public static MutationPayload$Sampling getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static V newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$Sampling parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Sampling parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$Sampling> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setB(float f) {
        this.bitField0_ |= 1;
        this.B_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setC(float f) {
        this.bitField0_ |= 2;
        this.C_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilter(int i) {
        this.bitField0_ |= 4;
        this.filter_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxAniso(int i) {
        this.bitField0_ |= 16;
        this.maxAniso_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMipmap(int i) {
        this.bitField0_ |= 8;
        this.mipmap_ = i;
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
    public void setTypeEnum(X x) {
        this.typeOneOf_ = Integer.valueOf(x.getNumber());
        this.typeOneOfCase_ = 7;
    }

    private void setTypeEnumValue(int i) {
        this.typeOneOfCase_ = 7;
        this.typeOneOf_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Sampling();
            case 2:
                return new V();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȼ\u0000\u0002ခ\u0000\u0003ခ\u0001\u0004င\u0002\u0005င\u0003\u0006င\u0004\u0007?\u0000", new Object[]{"typeOneOf_", "typeOneOfCase_", "bitField0_", "B_", "C_", "filter_", "mipmap_", "maxAniso_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Sampling> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$Sampling.class) {
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

    public float getB() {
        return this.B_;
    }

    public float getC() {
        return this.C_;
    }

    public int getFilter() {
        return this.filter_;
    }

    public int getMaxAniso() {
        return this.maxAniso_;
    }

    public int getMipmap() {
        return this.mipmap_;
    }

    public X getTypeEnum() {
        if (this.typeOneOfCase_ != 7) {
            return X.CubicSampling;
        }
        int intValue = ((Integer) this.typeOneOf_).intValue();
        X x = intValue != 0 ? intValue != 1 ? intValue != 2 ? null : X.AnisoSampling : X.NonCubicSampling : X.CubicSampling;
        return x == null ? X.UNRECOGNIZED : x;
    }

    public int getTypeEnumValue() {
        if (this.typeOneOfCase_ == 7) {
            return ((Integer) this.typeOneOf_).intValue();
        }
        return 0;
    }

    public W getTypeOneOfCase() {
        int i = this.typeOneOfCase_;
        if (i == 0) {
            return W.TYPEONEOF_NOT_SET;
        }
        if (i == 1) {
            return W.TYPE;
        }
        if (i != 7) {
            return null;
        }
        return W.TYPEENUM;
    }

    public boolean hasB() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasC() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasFilter() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMaxAniso() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasMipmap() {
        return (this.bitField0_ & 8) != 0;
    }

    @Deprecated
    public boolean hasType() {
        return this.typeOneOfCase_ == 1;
    }

    public boolean hasTypeEnum() {
        return this.typeOneOfCase_ == 7;
    }

    public static V newBuilder(MutationPayload$Sampling mutationPayload$Sampling) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Sampling);
    }

    public static MutationPayload$Sampling parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Sampling parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    @Deprecated
    public String getType() {
        return this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "";
    }

    @Deprecated
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "");
    }

    public static MutationPayload$Sampling parseFrom(ByteString byteString) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Sampling parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Sampling parseFrom(byte[] bArr) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Sampling parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$Sampling parseFrom(InputStream inputStream) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Sampling parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Sampling parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Sampling parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Sampling) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
