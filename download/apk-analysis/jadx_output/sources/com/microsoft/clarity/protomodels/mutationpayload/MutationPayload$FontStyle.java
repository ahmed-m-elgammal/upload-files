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
public final class MutationPayload$FontStyle extends GeneratedMessageLite<MutationPayload$FontStyle, C0129s> implements MessageLiteOrBuilder {
    private static final MutationPayload$FontStyle DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$FontStyle> PARSER = null;
    public static final int SLANT_FIELD_NUMBER = 3;
    public static final int WEIGHT_FIELD_NUMBER = 2;
    public static final int WIDTH_FIELD_NUMBER = 1;
    private int bitField0_;
    private double slant_;
    private double weight_;
    private double width_;

    static {
        MutationPayload$FontStyle mutationPayload$FontStyle = new MutationPayload$FontStyle();
        DEFAULT_INSTANCE = mutationPayload$FontStyle;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$FontStyle.class, mutationPayload$FontStyle);
    }

    private MutationPayload$FontStyle() {
    }

    private void clearSlant() {
        this.bitField0_ &= -5;
        this.slant_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void clearWeight() {
        this.bitField0_ &= -3;
        this.weight_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void clearWidth() {
        this.bitField0_ &= -2;
        this.width_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static MutationPayload$FontStyle getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C0129s newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$FontStyle parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$FontStyle parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$FontStyle> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSlant(double d) {
        this.bitField0_ |= 4;
        this.slant_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWeight(double d) {
        this.bitField0_ |= 2;
        this.weight_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidth(double d) {
        this.bitField0_ |= 1;
        this.width_ = d;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$FontStyle();
            case 2:
                return new C0129s();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001\u0003က\u0002", new Object[]{"bitField0_", "width_", "weight_", "slant_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$FontStyle> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$FontStyle.class) {
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

    public double getSlant() {
        return this.slant_;
    }

    public double getWeight() {
        return this.weight_;
    }

    public double getWidth() {
        return this.width_;
    }

    public boolean hasSlant() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasWeight() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasWidth() {
        return (this.bitField0_ & 1) != 0;
    }

    public static C0129s newBuilder(MutationPayload$FontStyle mutationPayload$FontStyle) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$FontStyle);
    }

    public static MutationPayload$FontStyle parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$FontStyle parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$FontStyle parseFrom(ByteString byteString) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$FontStyle parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$FontStyle parseFrom(byte[] bArr) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$FontStyle parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$FontStyle parseFrom(InputStream inputStream) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$FontStyle parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$FontStyle parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$FontStyle parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FontStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
