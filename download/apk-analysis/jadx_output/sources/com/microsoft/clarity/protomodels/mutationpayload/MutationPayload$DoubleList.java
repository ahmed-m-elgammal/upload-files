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
public final class MutationPayload$DoubleList extends GeneratedMessageLite<MutationPayload$DoubleList, C0124m> implements InterfaceC0125n {
    private static final MutationPayload$DoubleList DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$DoubleList> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int valueMemoizedSerializedSize = -1;
    private Internal.DoubleList value_ = GeneratedMessageLite.emptyDoubleList();

    static {
        MutationPayload$DoubleList mutationPayload$DoubleList = new MutationPayload$DoubleList();
        DEFAULT_INSTANCE = mutationPayload$DoubleList;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$DoubleList.class, mutationPayload$DoubleList);
    }

    private MutationPayload$DoubleList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllValue(Iterable<? extends Double> iterable) {
        ensureValueIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.value_);
    }

    private void addValue(double d) {
        ensureValueIsMutable();
        this.value_.addDouble(d);
    }

    private void clearValue() {
        this.value_ = GeneratedMessageLite.emptyDoubleList();
    }

    private void ensureValueIsMutable() {
        Internal.DoubleList doubleList = this.value_;
        if (doubleList.isModifiable()) {
            return;
        }
        this.value_ = GeneratedMessageLite.mutableCopy(doubleList);
    }

    public static MutationPayload$DoubleList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C0124m newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$DoubleList parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$DoubleList parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$DoubleList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(int i, double d) {
        ensureValueIsMutable();
        this.value_.setDouble(i, d);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$DoubleList();
            case 2:
                return new C0124m();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001#", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$DoubleList> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$DoubleList.class) {
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

    public double getValue(int i) {
        return this.value_.getDouble(i);
    }

    public int getValueCount() {
        return this.value_.size();
    }

    public List<Double> getValueList() {
        return this.value_;
    }

    public static C0124m newBuilder(MutationPayload$DoubleList mutationPayload$DoubleList) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$DoubleList);
    }

    public static MutationPayload$DoubleList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$DoubleList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$DoubleList parseFrom(ByteString byteString) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$DoubleList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$DoubleList parseFrom(byte[] bArr) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$DoubleList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$DoubleList parseFrom(InputStream inputStream) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$DoubleList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$DoubleList parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$DoubleList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DoubleList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
