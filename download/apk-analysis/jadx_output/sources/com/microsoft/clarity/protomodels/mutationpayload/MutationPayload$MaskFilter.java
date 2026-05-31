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
public final class MutationPayload$MaskFilter extends GeneratedMessageLite<MutationPayload$MaskFilter, D> implements MessageLiteOrBuilder {
    private static final MutationPayload$MaskFilter DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$MaskFilter> PARSER = null;
    public static final int RESPECT_C_T_M_FIELD_NUMBER = 4;
    public static final int SIGMA_FIELD_NUMBER = 2;
    public static final int STYLE_FIELD_NUMBER = 3;
    public static final int TYPEENUM_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean respectCTM_;
    private float sigma_;
    private int style_;
    private int typeOneOfCase_ = 0;
    private Object typeOneOf_;

    static {
        MutationPayload$MaskFilter mutationPayload$MaskFilter = new MutationPayload$MaskFilter();
        DEFAULT_INSTANCE = mutationPayload$MaskFilter;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$MaskFilter.class, mutationPayload$MaskFilter);
    }

    private MutationPayload$MaskFilter() {
    }

    private void clearRespectCTM() {
        this.bitField0_ &= -5;
        this.respectCTM_ = false;
    }

    private void clearSigma() {
        this.bitField0_ &= -2;
        this.sigma_ = 0.0f;
    }

    private void clearStyle() {
        this.bitField0_ &= -3;
        this.style_ = 0;
    }

    private void clearType() {
        if (this.typeOneOfCase_ == 1) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeEnum() {
        if (this.typeOneOfCase_ == 5) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeOneOf() {
        this.typeOneOfCase_ = 0;
        this.typeOneOf_ = null;
    }

    public static MutationPayload$MaskFilter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static D newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$MaskFilter parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$MaskFilter parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$MaskFilter> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRespectCTM(boolean z) {
        this.bitField0_ |= 4;
        this.respectCTM_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSigma(float f) {
        this.bitField0_ |= 1;
        this.sigma_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStyle(int i) {
        this.bitField0_ |= 2;
        this.style_ = i;
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
    public void setTypeEnum(F f) {
        this.typeOneOf_ = Integer.valueOf(f.getNumber());
        this.typeOneOfCase_ = 5;
    }

    private void setTypeEnumValue(int i) {
        this.typeOneOfCase_ = 5;
        this.typeOneOf_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$MaskFilter();
            case 2:
                return new D();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȼ\u0000\u0002ခ\u0000\u0003င\u0001\u0004ဇ\u0002\u0005?\u0000", new Object[]{"typeOneOf_", "typeOneOfCase_", "bitField0_", "sigma_", "style_", "respectCTM_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$MaskFilter> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$MaskFilter.class) {
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

    public boolean getRespectCTM() {
        return this.respectCTM_;
    }

    public float getSigma() {
        return this.sigma_;
    }

    public int getStyle() {
        return this.style_;
    }

    public F getTypeEnum() {
        if (this.typeOneOfCase_ != 5) {
            return F.BlurMaskFilter;
        }
        F f = ((Integer) this.typeOneOf_).intValue() != 0 ? null : F.BlurMaskFilter;
        return f == null ? F.UNRECOGNIZED : f;
    }

    public int getTypeEnumValue() {
        if (this.typeOneOfCase_ == 5) {
            return ((Integer) this.typeOneOf_).intValue();
        }
        return 0;
    }

    public E getTypeOneOfCase() {
        int i = this.typeOneOfCase_;
        if (i == 0) {
            return E.TYPEONEOF_NOT_SET;
        }
        if (i == 1) {
            return E.TYPE;
        }
        if (i != 5) {
            return null;
        }
        return E.TYPEENUM;
    }

    public boolean hasRespectCTM() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasSigma() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasStyle() {
        return (this.bitField0_ & 2) != 0;
    }

    @Deprecated
    public boolean hasType() {
        return this.typeOneOfCase_ == 1;
    }

    public boolean hasTypeEnum() {
        return this.typeOneOfCase_ == 5;
    }

    public static D newBuilder(MutationPayload$MaskFilter mutationPayload$MaskFilter) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$MaskFilter);
    }

    public static MutationPayload$MaskFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$MaskFilter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    @Deprecated
    public String getType() {
        return this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "";
    }

    @Deprecated
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "");
    }

    public static MutationPayload$MaskFilter parseFrom(ByteString byteString) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$MaskFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$MaskFilter parseFrom(byte[] bArr) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$MaskFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$MaskFilter parseFrom(InputStream inputStream) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$MaskFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$MaskFilter parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$MaskFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$MaskFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
