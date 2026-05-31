package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class MutationPayload$Color4f extends GeneratedMessageLite<MutationPayload$Color4f, C0113b> implements InterfaceC0114c {
    public static final int A_FIELD_NUMBER = 4;
    public static final int B_FIELD_NUMBER = 3;
    private static final MutationPayload$Color4f DEFAULT_INSTANCE;
    public static final int G_FIELD_NUMBER = 2;
    private static volatile Parser<MutationPayload$Color4f> PARSER = null;
    public static final int R_FIELD_NUMBER = 1;
    private float a_;
    private float b_;
    private int bitField0_;
    private float g_;
    private float r_;

    static {
        MutationPayload$Color4f mutationPayload$Color4f = new MutationPayload$Color4f();
        DEFAULT_INSTANCE = mutationPayload$Color4f;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Color4f.class, mutationPayload$Color4f);
    }

    private MutationPayload$Color4f() {
    }

    private void clearA() {
        this.bitField0_ &= -9;
        this.a_ = 0.0f;
    }

    private void clearB() {
        this.bitField0_ &= -5;
        this.b_ = 0.0f;
    }

    private void clearG() {
        this.bitField0_ &= -3;
        this.g_ = 0.0f;
    }

    private void clearR() {
        this.bitField0_ &= -2;
        this.r_ = 0.0f;
    }

    public static MutationPayload$Color4f getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C0113b newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$Color4f parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Color4f parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$Color4f> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setA(float f) {
        this.bitField0_ |= 8;
        this.a_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setB(float f) {
        this.bitField0_ |= 4;
        this.b_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setG(float f) {
        this.bitField0_ |= 2;
        this.g_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setR(float f) {
        this.bitField0_ |= 1;
        this.r_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Color4f();
            case 2:
                return new C0113b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"bitField0_", "r_", "g_", "b_", "a_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Color4f> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$Color4f.class) {
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

    public float getA() {
        return this.a_;
    }

    public float getB() {
        return this.b_;
    }

    public float getG() {
        return this.g_;
    }

    public float getR() {
        return this.r_;
    }

    public boolean hasA() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasB() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasG() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasR() {
        return (this.bitField0_ & 1) != 0;
    }

    public static C0113b newBuilder(MutationPayload$Color4f mutationPayload$Color4f) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Color4f);
    }

    public static MutationPayload$Color4f parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Color4f parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Color4f parseFrom(ByteString byteString) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Color4f parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Color4f parseFrom(byte[] bArr) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Color4f parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$Color4f parseFrom(InputStream inputStream) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Color4f parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Color4f parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Color4f parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Color4f) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
