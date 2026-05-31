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
public final class MutationPayload$TextBlob extends GeneratedMessageLite<MutationPayload$TextBlob, b0> implements c0 {
    public static final int BOUNDS_FIELD_NUMBER = 1;
    private static final MutationPayload$TextBlob DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$TextBlob> PARSER = null;
    public static final int RUNS_FIELD_NUMBER = 2;
    private int bitField0_;
    private MutationPayload$Rect bounds_;
    private Internal.ProtobufList<MutationPayload$TextBlobRun> runs_ = GeneratedMessageLite.emptyProtobufList();

    static {
        MutationPayload$TextBlob mutationPayload$TextBlob = new MutationPayload$TextBlob();
        DEFAULT_INSTANCE = mutationPayload$TextBlob;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$TextBlob.class, mutationPayload$TextBlob);
    }

    private MutationPayload$TextBlob() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRuns(Iterable<? extends MutationPayload$TextBlobRun> iterable) {
        ensureRunsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.runs_);
    }

    private void addRuns(MutationPayload$TextBlobRun mutationPayload$TextBlobRun) {
        mutationPayload$TextBlobRun.getClass();
        ensureRunsIsMutable();
        this.runs_.add(mutationPayload$TextBlobRun);
    }

    private void clearBounds() {
        this.bounds_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRuns() {
        this.runs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRunsIsMutable() {
        Internal.ProtobufList<MutationPayload$TextBlobRun> protobufList = this.runs_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.runs_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$TextBlob getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBounds(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        MutationPayload$Rect mutationPayload$Rect2 = this.bounds_;
        if (mutationPayload$Rect2 == null || mutationPayload$Rect2 == MutationPayload$Rect.getDefaultInstance()) {
            this.bounds_ = mutationPayload$Rect;
        } else {
            this.bounds_ = (MutationPayload$Rect) ((U) MutationPayload$Rect.newBuilder(this.bounds_).mergeFrom((U) mutationPayload$Rect)).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static b0 newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$TextBlob parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$TextBlob parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$TextBlob> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRuns(int i) {
        ensureRunsIsMutable();
        this.runs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBounds(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.bounds_ = mutationPayload$Rect;
        this.bitField0_ |= 1;
    }

    private void setRuns(int i, MutationPayload$TextBlobRun mutationPayload$TextBlobRun) {
        mutationPayload$TextBlobRun.getClass();
        ensureRunsIsMutable();
        this.runs_.set(i, mutationPayload$TextBlobRun);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$TextBlob();
            case 2:
                return new b0();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "bounds_", "runs_", MutationPayload$TextBlobRun.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$TextBlob> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$TextBlob.class) {
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

    public MutationPayload$Rect getBounds() {
        MutationPayload$Rect mutationPayload$Rect = this.bounds_;
        return mutationPayload$Rect == null ? MutationPayload$Rect.getDefaultInstance() : mutationPayload$Rect;
    }

    public MutationPayload$TextBlobRun getRuns(int i) {
        return this.runs_.get(i);
    }

    public int getRunsCount() {
        return this.runs_.size();
    }

    public List<MutationPayload$TextBlobRun> getRunsList() {
        return this.runs_;
    }

    public e0 getRunsOrBuilder(int i) {
        return this.runs_.get(i);
    }

    public List<? extends e0> getRunsOrBuilderList() {
        return this.runs_;
    }

    public boolean hasBounds() {
        return (this.bitField0_ & 1) != 0;
    }

    public static b0 newBuilder(MutationPayload$TextBlob mutationPayload$TextBlob) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$TextBlob);
    }

    public static MutationPayload$TextBlob parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$TextBlob parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$TextBlob parseFrom(ByteString byteString) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    private void addRuns(int i, MutationPayload$TextBlobRun mutationPayload$TextBlobRun) {
        mutationPayload$TextBlobRun.getClass();
        ensureRunsIsMutable();
        this.runs_.add(i, mutationPayload$TextBlobRun);
    }

    public static MutationPayload$TextBlob parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$TextBlob parseFrom(byte[] bArr) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$TextBlob parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$TextBlob parseFrom(InputStream inputStream) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$TextBlob parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$TextBlob parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$TextBlob parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$TextBlob) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
