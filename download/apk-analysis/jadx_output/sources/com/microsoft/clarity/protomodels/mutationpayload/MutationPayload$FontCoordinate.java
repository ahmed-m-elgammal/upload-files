package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class MutationPayload$FontCoordinate extends GeneratedMessageLite<MutationPayload$FontCoordinate, C0128q> implements r {
    public static final int AXIS_FIELD_NUMBER = 1;
    private static final MutationPayload$FontCoordinate DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$FontCoordinate> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String axis_ = "";
    private int bitField0_;
    private float value_;

    static {
        MutationPayload$FontCoordinate mutationPayload$FontCoordinate = new MutationPayload$FontCoordinate();
        DEFAULT_INSTANCE = mutationPayload$FontCoordinate;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$FontCoordinate.class, mutationPayload$FontCoordinate);
    }

    private MutationPayload$FontCoordinate() {
    }

    private void clearAxis() {
        this.bitField0_ &= -2;
        this.axis_ = getDefaultInstance().getAxis();
    }

    private void clearValue() {
        this.bitField0_ &= -3;
        this.value_ = 0.0f;
    }

    public static MutationPayload$FontCoordinate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C0128q newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$FontCoordinate parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$FontCoordinate parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$FontCoordinate> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAxis(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.axis_ = str;
    }

    private void setAxisBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.axis_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(float f) {
        this.bitField0_ |= 2;
        this.value_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$FontCoordinate();
            case 2:
                return new C0128q();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ခ\u0001", new Object[]{"bitField0_", "axis_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$FontCoordinate> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$FontCoordinate.class) {
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

    public String getAxis() {
        return this.axis_;
    }

    public ByteString getAxisBytes() {
        return ByteString.copyFromUtf8(this.axis_);
    }

    public float getValue() {
        return this.value_;
    }

    public boolean hasAxis() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 2) != 0;
    }

    public static C0128q newBuilder(MutationPayload$FontCoordinate mutationPayload$FontCoordinate) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$FontCoordinate);
    }

    public static MutationPayload$FontCoordinate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$FontCoordinate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$FontCoordinate parseFrom(ByteString byteString) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$FontCoordinate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$FontCoordinate parseFrom(byte[] bArr) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$FontCoordinate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$FontCoordinate parseFrom(InputStream inputStream) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$FontCoordinate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$FontCoordinate parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$FontCoordinate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontCoordinate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
