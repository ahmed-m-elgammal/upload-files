package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class MutationPayload$Point extends GeneratedMessageLite<MutationPayload$Point, S> implements T {
    private static final MutationPayload$Point DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$Point> PARSER = null;
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    private int bitField0_;
    private float x_;
    private float y_;

    static {
        MutationPayload$Point mutationPayload$Point = new MutationPayload$Point();
        DEFAULT_INSTANCE = mutationPayload$Point;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Point.class, mutationPayload$Point);
    }

    private MutationPayload$Point() {
    }

    private void clearX() {
        this.bitField0_ &= -2;
        this.x_ = 0.0f;
    }

    private void clearY() {
        this.bitField0_ &= -3;
        this.y_ = 0.0f;
    }

    public static MutationPayload$Point getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static S newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$Point parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Point) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Point parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$Point> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX(float f) {
        this.bitField0_ |= 1;
        this.x_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY(float f) {
        this.bitField0_ |= 2;
        this.y_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Point();
            case 2:
                return new S();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001", new Object[]{"bitField0_", "x_", "y_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Point> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$Point.class) {
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

    public float getX() {
        return this.x_;
    }

    public float getY() {
        return this.y_;
    }

    public boolean hasX() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasY() {
        return (this.bitField0_ & 2) != 0;
    }

    public static S newBuilder(MutationPayload$Point mutationPayload$Point) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Point);
    }

    public static MutationPayload$Point parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Point) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Point parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Point parseFrom(ByteString byteString) {
        return (MutationPayload$Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Point parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Point parseFrom(byte[] bArr) {
        return (MutationPayload$Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Point parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$Point parseFrom(InputStream inputStream) {
        return (MutationPayload$Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Point parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Point parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Point parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
