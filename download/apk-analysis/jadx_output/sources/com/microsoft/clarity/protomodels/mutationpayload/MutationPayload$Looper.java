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
public final class MutationPayload$Looper extends GeneratedMessageLite<MutationPayload$Looper, A> implements MessageLiteOrBuilder {
    private static final MutationPayload$Looper DEFAULT_INSTANCE;
    public static final int LAYERS_FIELD_NUMBER = 2;
    private static volatile Parser<MutationPayload$Looper> PARSER = null;
    public static final int TYPEENUM_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    private Object typeOneOf_;
    private int typeOneOfCase_ = 0;
    private Internal.ProtobufList<MutationPayload$Layer> layers_ = GeneratedMessageLite.emptyProtobufList();

    static {
        MutationPayload$Looper mutationPayload$Looper = new MutationPayload$Looper();
        DEFAULT_INSTANCE = mutationPayload$Looper;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Looper.class, mutationPayload$Looper);
    }

    private MutationPayload$Looper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLayers(Iterable<? extends MutationPayload$Layer> iterable) {
        ensureLayersIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.layers_);
    }

    private void addLayers(MutationPayload$Layer mutationPayload$Layer) {
        mutationPayload$Layer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(mutationPayload$Layer);
    }

    private void clearLayers() {
        this.layers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearType() {
        if (this.typeOneOfCase_ == 1) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeEnum() {
        if (this.typeOneOfCase_ == 3) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeOneOf() {
        this.typeOneOfCase_ = 0;
        this.typeOneOf_ = null;
    }

    private void ensureLayersIsMutable() {
        Internal.ProtobufList<MutationPayload$Layer> protobufList = this.layers_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.layers_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$Looper getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static A newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$Looper parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Looper parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$Looper> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeLayers(int i) {
        ensureLayersIsMutable();
        this.layers_.remove(i);
    }

    private void setLayers(int i, MutationPayload$Layer mutationPayload$Layer) {
        mutationPayload$Layer.getClass();
        ensureLayersIsMutable();
        this.layers_.set(i, mutationPayload$Layer);
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
    public void setTypeEnum(C c) {
        this.typeOneOf_ = Integer.valueOf(c.getNumber());
        this.typeOneOfCase_ = 3;
    }

    private void setTypeEnumValue(int i) {
        this.typeOneOfCase_ = 3;
        this.typeOneOf_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Looper();
            case 2:
                return new A();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȼ\u0000\u0002\u001b\u0003?\u0000", new Object[]{"typeOneOf_", "typeOneOfCase_", "layers_", MutationPayload$Layer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Looper> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$Looper.class) {
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

    public MutationPayload$Layer getLayers(int i) {
        return this.layers_.get(i);
    }

    public int getLayersCount() {
        return this.layers_.size();
    }

    public List<MutationPayload$Layer> getLayersList() {
        return this.layers_;
    }

    public InterfaceC0136z getLayersOrBuilder(int i) {
        return this.layers_.get(i);
    }

    public List<? extends InterfaceC0136z> getLayersOrBuilderList() {
        return this.layers_;
    }

    public C getTypeEnum() {
        if (this.typeOneOfCase_ != 3) {
            return C.LayerDrawLooper;
        }
        C c = ((Integer) this.typeOneOf_).intValue() != 0 ? null : C.LayerDrawLooper;
        return c == null ? C.UNRECOGNIZED : c;
    }

    public int getTypeEnumValue() {
        if (this.typeOneOfCase_ == 3) {
            return ((Integer) this.typeOneOf_).intValue();
        }
        return 0;
    }

    public B getTypeOneOfCase() {
        int i = this.typeOneOfCase_;
        if (i == 0) {
            return B.TYPEONEOF_NOT_SET;
        }
        if (i == 1) {
            return B.TYPE;
        }
        if (i != 3) {
            return null;
        }
        return B.TYPEENUM;
    }

    @Deprecated
    public boolean hasType() {
        return this.typeOneOfCase_ == 1;
    }

    public boolean hasTypeEnum() {
        return this.typeOneOfCase_ == 3;
    }

    public static A newBuilder(MutationPayload$Looper mutationPayload$Looper) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Looper);
    }

    public static MutationPayload$Looper parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Looper parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    @Deprecated
    public String getType() {
        return this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "";
    }

    @Deprecated
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "");
    }

    public static MutationPayload$Looper parseFrom(ByteString byteString) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    private void addLayers(int i, MutationPayload$Layer mutationPayload$Layer) {
        mutationPayload$Layer.getClass();
        ensureLayersIsMutable();
        this.layers_.add(i, mutationPayload$Layer);
    }

    public static MutationPayload$Looper parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Looper parseFrom(byte[] bArr) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Looper parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$Looper parseFrom(InputStream inputStream) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Looper parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Looper parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Looper parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Looper) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
