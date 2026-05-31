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
public final class MutationPayload$IntList extends GeneratedMessageLite<MutationPayload$IntList, C0132v> implements MessageLiteOrBuilder {
    private static final MutationPayload$IntList DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$IntList> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int valueMemoizedSerializedSize = -1;
    private Internal.IntList value_ = GeneratedMessageLite.emptyIntList();

    static {
        MutationPayload$IntList mutationPayload$IntList = new MutationPayload$IntList();
        DEFAULT_INSTANCE = mutationPayload$IntList;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$IntList.class, mutationPayload$IntList);
    }

    private MutationPayload$IntList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllValue(Iterable<? extends Integer> iterable) {
        ensureValueIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.value_);
    }

    private void addValue(int i) {
        ensureValueIsMutable();
        this.value_.addInt(i);
    }

    private void clearValue() {
        this.value_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureValueIsMutable() {
        Internal.IntList intList = this.value_;
        if (intList.isModifiable()) {
            return;
        }
        this.value_ = GeneratedMessageLite.mutableCopy(intList);
    }

    public static MutationPayload$IntList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C0132v newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$IntList parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$IntList parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$IntList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(int i, int i2) {
        ensureValueIsMutable();
        this.value_.setInt(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$IntList();
            case 2:
                return new C0132v();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$IntList> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$IntList.class) {
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

    public int getValue(int i) {
        return this.value_.getInt(i);
    }

    public int getValueCount() {
        return this.value_.size();
    }

    public List<Integer> getValueList() {
        return this.value_;
    }

    public static C0132v newBuilder(MutationPayload$IntList mutationPayload$IntList) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$IntList);
    }

    public static MutationPayload$IntList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$IntList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$IntList parseFrom(ByteString byteString) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$IntList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$IntList parseFrom(byte[] bArr) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$IntList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$IntList parseFrom(InputStream inputStream) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$IntList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$IntList parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$IntList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$IntList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
