package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class MutationPayload$Layer extends GeneratedMessageLite<MutationPayload$Layer, C0134x> implements InterfaceC0136z {
    private static final MutationPayload$Layer DEFAULT_INSTANCE;
    public static final int LAYER_INFO_FIELD_NUMBER = 1;
    public static final int PAINT_FIELD_NUMBER = 2;
    private static volatile Parser<MutationPayload$Layer> PARSER;
    private int bitField0_;
    private MutationPayload$LayerInfo layerInfo_;
    private MutationPayload$Paint paint_;

    static {
        MutationPayload$Layer mutationPayload$Layer = new MutationPayload$Layer();
        DEFAULT_INSTANCE = mutationPayload$Layer;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Layer.class, mutationPayload$Layer);
    }

    private MutationPayload$Layer() {
    }

    private void clearLayerInfo() {
        this.layerInfo_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPaint() {
        this.paint_ = null;
        this.bitField0_ &= -3;
    }

    public static MutationPayload$Layer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLayerInfo(MutationPayload$LayerInfo mutationPayload$LayerInfo) {
        mutationPayload$LayerInfo.getClass();
        MutationPayload$LayerInfo mutationPayload$LayerInfo2 = this.layerInfo_;
        if (mutationPayload$LayerInfo2 == null || mutationPayload$LayerInfo2 == MutationPayload$LayerInfo.getDefaultInstance()) {
            this.layerInfo_ = mutationPayload$LayerInfo;
        } else {
            this.layerInfo_ = (MutationPayload$LayerInfo) ((C0135y) MutationPayload$LayerInfo.newBuilder(this.layerInfo_).mergeFrom((C0135y) mutationPayload$LayerInfo)).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    private void mergePaint(MutationPayload$Paint mutationPayload$Paint) {
        mutationPayload$Paint.getClass();
        MutationPayload$Paint mutationPayload$Paint2 = this.paint_;
        if (mutationPayload$Paint2 == null || mutationPayload$Paint2 == MutationPayload$Paint.getDefaultInstance()) {
            this.paint_ = mutationPayload$Paint;
        } else {
            this.paint_ = (MutationPayload$Paint) ((G) MutationPayload$Paint.newBuilder(this.paint_).mergeFrom((G) mutationPayload$Paint)).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static C0134x newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$Layer parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Layer parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$Layer> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayerInfo(MutationPayload$LayerInfo mutationPayload$LayerInfo) {
        mutationPayload$LayerInfo.getClass();
        this.layerInfo_ = mutationPayload$LayerInfo;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPaint(MutationPayload$Paint mutationPayload$Paint) {
        mutationPayload$Paint.getClass();
        this.paint_ = mutationPayload$Paint;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Layer();
            case 2:
                return new C0134x();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "layerInfo_", "paint_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Layer> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$Layer.class) {
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

    public MutationPayload$LayerInfo getLayerInfo() {
        MutationPayload$LayerInfo mutationPayload$LayerInfo = this.layerInfo_;
        return mutationPayload$LayerInfo == null ? MutationPayload$LayerInfo.getDefaultInstance() : mutationPayload$LayerInfo;
    }

    public MutationPayload$Paint getPaint() {
        MutationPayload$Paint mutationPayload$Paint = this.paint_;
        return mutationPayload$Paint == null ? MutationPayload$Paint.getDefaultInstance() : mutationPayload$Paint;
    }

    public boolean hasLayerInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPaint() {
        return (this.bitField0_ & 2) != 0;
    }

    public static C0134x newBuilder(MutationPayload$Layer mutationPayload$Layer) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Layer);
    }

    public static MutationPayload$Layer parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Layer parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Layer parseFrom(ByteString byteString) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Layer parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Layer parseFrom(byte[] bArr) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Layer parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$Layer parseFrom(InputStream inputStream) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Layer parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Layer parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Layer parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Layer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
