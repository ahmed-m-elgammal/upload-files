package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes5.dex */
public final class MutationPayload$Rect extends GeneratedMessageLite<MutationPayload$Rect, U> implements MessageLiteOrBuilder {
    public static final int BOTTOM_FIELD_NUMBER = 3;
    private static final MutationPayload$Rect DEFAULT_INSTANCE;
    public static final int LEFT_FIELD_NUMBER = 2;
    private static volatile Parser<MutationPayload$Rect> PARSER = null;
    public static final int RADII_FIELD_NUMBER = 5;
    public static final int RIGHT_FIELD_NUMBER = 4;
    public static final int TOP_FIELD_NUMBER = 1;
    private int bitField0_;
    private float bottom_;
    private float left_;
    private Internal.ProtobufList<MutationPayload$FloatList> radii_ = GeneratedMessageLite.emptyProtobufList();
    private float right_;
    private float top_;

    static {
        MutationPayload$Rect mutationPayload$Rect = new MutationPayload$Rect();
        DEFAULT_INSTANCE = mutationPayload$Rect;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Rect.class, mutationPayload$Rect);
    }

    private MutationPayload$Rect() {
    }

    private void addAllRadii(Iterable<? extends MutationPayload$FloatList> iterable) {
        ensureRadiiIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.radii_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRadii(MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureRadiiIsMutable();
        this.radii_.add(mutationPayload$FloatList);
    }

    private void clearBottom() {
        this.bitField0_ &= -5;
        this.bottom_ = 0.0f;
    }

    private void clearLeft() {
        this.bitField0_ &= -3;
        this.left_ = 0.0f;
    }

    private void clearRadii() {
        this.radii_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearRight() {
        this.bitField0_ &= -9;
        this.right_ = 0.0f;
    }

    private void clearTop() {
        this.bitField0_ &= -2;
        this.top_ = 0.0f;
    }

    private void ensureRadiiIsMutable() {
        Internal.ProtobufList<MutationPayload$FloatList> protobufList = this.radii_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.radii_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$Rect getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static U newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$Rect parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Rect parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$Rect> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRadii(int i) {
        ensureRadiiIsMutable();
        this.radii_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBottom(float f) {
        this.bitField0_ |= 4;
        this.bottom_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeft(float f) {
        this.bitField0_ |= 2;
        this.left_ = f;
    }

    private void setRadii(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureRadiiIsMutable();
        this.radii_.set(i, mutationPayload$FloatList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRight(float f) {
        this.bitField0_ |= 8;
        this.right_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTop(float f) {
        this.bitField0_ |= 1;
        this.top_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Rect();
            case 2:
                return new U();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005\u001b", new Object[]{"bitField0_", "top_", "left_", "bottom_", "right_", "radii_", MutationPayload$FloatList.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Rect> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$Rect.class) {
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

    public float getBottom() {
        return this.bottom_;
    }

    public float getLeft() {
        return this.left_;
    }

    public MutationPayload$FloatList getRadii(int i) {
        return this.radii_.get(i);
    }

    public int getRadiiCount() {
        return this.radii_.size();
    }

    public List<MutationPayload$FloatList> getRadiiList() {
        return this.radii_;
    }

    public InterfaceC0127p getRadiiOrBuilder(int i) {
        return this.radii_.get(i);
    }

    public List<? extends InterfaceC0127p> getRadiiOrBuilderList() {
        return this.radii_;
    }

    public float getRight() {
        return this.right_;
    }

    public float getTop() {
        return this.top_;
    }

    public boolean hasBottom() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLeft() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRight() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasTop() {
        return (this.bitField0_ & 1) != 0;
    }

    public static U newBuilder(MutationPayload$Rect mutationPayload$Rect) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Rect);
    }

    public static MutationPayload$Rect parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Rect parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Rect parseFrom(ByteString byteString) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    private void addRadii(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureRadiiIsMutable();
        this.radii_.add(i, mutationPayload$FloatList);
    }

    public static MutationPayload$Rect parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Rect parseFrom(byte[] bArr) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Rect parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$Rect parseFrom(InputStream inputStream) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Rect parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Rect parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Rect parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
