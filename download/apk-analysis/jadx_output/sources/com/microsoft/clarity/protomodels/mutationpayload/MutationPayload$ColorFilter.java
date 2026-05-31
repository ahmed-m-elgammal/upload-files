package com.microsoft.clarity.protomodels.mutationpayload;

import androidx.camera.video.AudioStats;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class MutationPayload$ColorFilter extends GeneratedMessageLite<MutationPayload$ColorFilter, C0115d> implements MessageLiteOrBuilder {
    public static final int COLOR4F_FIELD_NUMBER = 4;
    public static final int COLOR_FIELD_NUMBER = 2;
    private static final MutationPayload$ColorFilter DEFAULT_INSTANCE;
    public static final int IS_RGBA_FIELD_NUMBER = 7;
    public static final int IS_ROW_MAJOR_FIELD_NUMBER = 8;
    public static final int MATRIX_FIELD_NUMBER = 6;
    public static final int MODE_FIELD_NUMBER = 3;
    private static volatile Parser<MutationPayload$ColorFilter> PARSER = null;
    public static final int TYPEENUM_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private MutationPayload$Color4f color4F_;
    private double color_;
    private boolean isRgba_;
    private boolean isRowMajor_;
    private MutationPayload$FloatList matrix_;
    private double mode_;
    private int typeOneOfCase_ = 0;
    private Object typeOneOf_;

    static {
        MutationPayload$ColorFilter mutationPayload$ColorFilter = new MutationPayload$ColorFilter();
        DEFAULT_INSTANCE = mutationPayload$ColorFilter;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$ColorFilter.class, mutationPayload$ColorFilter);
    }

    private MutationPayload$ColorFilter() {
    }

    private void clearColor() {
        this.bitField0_ &= -2;
        this.color_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void clearColor4F() {
        this.color4F_ = null;
        this.bitField0_ &= -5;
    }

    private void clearIsRgba() {
        this.bitField0_ &= -17;
        this.isRgba_ = false;
    }

    private void clearIsRowMajor() {
        this.bitField0_ &= -33;
        this.isRowMajor_ = false;
    }

    private void clearMatrix() {
        this.matrix_ = null;
        this.bitField0_ &= -9;
    }

    private void clearMode() {
        this.bitField0_ &= -3;
        this.mode_ = AudioStats.AUDIO_AMPLITUDE_NONE;
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

    public static MutationPayload$ColorFilter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeColor4F(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        MutationPayload$Color4f mutationPayload$Color4f2 = this.color4F_;
        if (mutationPayload$Color4f2 == null || mutationPayload$Color4f2 == MutationPayload$Color4f.getDefaultInstance()) {
            this.color4F_ = mutationPayload$Color4f;
        } else {
            this.color4F_ = (MutationPayload$Color4f) ((C0113b) MutationPayload$Color4f.newBuilder(this.color4F_).mergeFrom((C0113b) mutationPayload$Color4f)).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    private void mergeMatrix(MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        MutationPayload$FloatList mutationPayload$FloatList2 = this.matrix_;
        if (mutationPayload$FloatList2 == null || mutationPayload$FloatList2 == MutationPayload$FloatList.getDefaultInstance()) {
            this.matrix_ = mutationPayload$FloatList;
        } else {
            this.matrix_ = (MutationPayload$FloatList) ((C0126o) MutationPayload$FloatList.newBuilder(this.matrix_).mergeFrom((C0126o) mutationPayload$FloatList)).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    public static C0115d newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$ColorFilter parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$ColorFilter parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$ColorFilter> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColor(double d) {
        this.bitField0_ |= 1;
        this.color_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColor4F(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        this.color4F_ = mutationPayload$Color4f;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsRgba(boolean z) {
        this.bitField0_ |= 16;
        this.isRgba_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsRowMajor(boolean z) {
        this.bitField0_ |= 32;
        this.isRowMajor_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMatrix(MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        this.matrix_ = mutationPayload$FloatList;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMode(double d) {
        this.bitField0_ |= 2;
        this.mode_ = d;
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
    public void setTypeEnum(EnumC0117f enumC0117f) {
        this.typeOneOf_ = Integer.valueOf(enumC0117f.getNumber());
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
                return new MutationPayload$ColorFilter();
            case 2:
                return new C0115d();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001Ȼ\u0000\u0002က\u0000\u0003က\u0001\u0004ဉ\u0002\u0005?\u0000\u0006ဉ\u0003\u0007ဇ\u0004\bဇ\u0005", new Object[]{"typeOneOf_", "typeOneOfCase_", "bitField0_", "color_", "mode_", "color4F_", "matrix_", "isRgba_", "isRowMajor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$ColorFilter> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$ColorFilter.class) {
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

    public double getColor() {
        return this.color_;
    }

    public MutationPayload$Color4f getColor4F() {
        MutationPayload$Color4f mutationPayload$Color4f = this.color4F_;
        return mutationPayload$Color4f == null ? MutationPayload$Color4f.getDefaultInstance() : mutationPayload$Color4f;
    }

    public boolean getIsRgba() {
        return this.isRgba_;
    }

    public boolean getIsRowMajor() {
        return this.isRowMajor_;
    }

    public MutationPayload$FloatList getMatrix() {
        MutationPayload$FloatList mutationPayload$FloatList = this.matrix_;
        return mutationPayload$FloatList == null ? MutationPayload$FloatList.getDefaultInstance() : mutationPayload$FloatList;
    }

    public double getMode() {
        return this.mode_;
    }

    public EnumC0117f getTypeEnum() {
        if (this.typeOneOfCase_ != 5) {
            return EnumC0117f.ModeColorFilter;
        }
        int intValue = ((Integer) this.typeOneOf_).intValue();
        EnumC0117f enumC0117f = intValue != 0 ? intValue != 1 ? null : EnumC0117f.MatrixColorFilter : EnumC0117f.ModeColorFilter;
        return enumC0117f == null ? EnumC0117f.UNRECOGNIZED : enumC0117f;
    }

    public int getTypeEnumValue() {
        if (this.typeOneOfCase_ == 5) {
            return ((Integer) this.typeOneOf_).intValue();
        }
        return 0;
    }

    public EnumC0116e getTypeOneOfCase() {
        int i = this.typeOneOfCase_;
        if (i == 0) {
            return EnumC0116e.TYPEONEOF_NOT_SET;
        }
        if (i == 1) {
            return EnumC0116e.TYPE;
        }
        if (i != 5) {
            return null;
        }
        return EnumC0116e.TYPEENUM;
    }

    public boolean hasColor() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasColor4F() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasIsRgba() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasIsRowMajor() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasMatrix() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMode() {
        return (this.bitField0_ & 2) != 0;
    }

    @Deprecated
    public boolean hasType() {
        return this.typeOneOfCase_ == 1;
    }

    public boolean hasTypeEnum() {
        return this.typeOneOfCase_ == 5;
    }

    public static C0115d newBuilder(MutationPayload$ColorFilter mutationPayload$ColorFilter) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$ColorFilter);
    }

    public static MutationPayload$ColorFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$ColorFilter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    @Deprecated
    public String getType() {
        return this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "";
    }

    @Deprecated
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "");
    }

    public static MutationPayload$ColorFilter parseFrom(ByteString byteString) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$ColorFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$ColorFilter parseFrom(byte[] bArr) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$ColorFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$ColorFilter parseFrom(InputStream inputStream) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$ColorFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$ColorFilter parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$ColorFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ColorFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
