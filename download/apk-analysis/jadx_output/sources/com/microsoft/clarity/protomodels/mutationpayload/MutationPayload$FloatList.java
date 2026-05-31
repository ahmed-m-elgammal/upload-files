package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes5.dex */
public final class MutationPayload$FloatList extends GeneratedMessageLite<MutationPayload$FloatList, C0126o> implements InterfaceC0127p {
    private static final MutationPayload$FloatList DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$FloatList> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int valueMemoizedSerializedSize = -1;
    private Internal.FloatList value_ = GeneratedMessageLite.emptyFloatList();

    static {
        MutationPayload$FloatList mutationPayload$FloatList = new MutationPayload$FloatList();
        DEFAULT_INSTANCE = mutationPayload$FloatList;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$FloatList.class, mutationPayload$FloatList);
    }

    private MutationPayload$FloatList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllValue(Iterable<? extends Float> iterable) {
        ensureValueIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.value_);
    }

    private void addValue(float f) {
        ensureValueIsMutable();
        this.value_.addFloat(f);
    }

    private void clearValue() {
        this.value_ = GeneratedMessageLite.emptyFloatList();
    }

    private void ensureValueIsMutable() {
        Internal.FloatList floatList = this.value_;
        if (floatList.isModifiable()) {
            return;
        }
        this.value_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    public static MutationPayload$FloatList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C0126o newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$FloatList parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$FloatList parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$FloatList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(int i, float f) {
        ensureValueIsMutable();
        this.value_.setFloat(i, f);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$FloatList();
            case 2:
                return new C0126o();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001$", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$FloatList> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$FloatList.class) {
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

    public float getValue(int i) {
        return this.value_.getFloat(i);
    }

    public int getValueCount() {
        return this.value_.size();
    }

    public List<Float> getValueList() {
        return this.value_;
    }

    public static C0126o newBuilder(MutationPayload$FloatList mutationPayload$FloatList) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$FloatList);
    }

    public static MutationPayload$FloatList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$FloatList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$FloatList parseFrom(ByteString byteString) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$FloatList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$FloatList parseFrom(byte[] bArr) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$FloatList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$FloatList parseFrom(InputStream inputStream) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$FloatList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$FloatList parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$FloatList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$FloatList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
