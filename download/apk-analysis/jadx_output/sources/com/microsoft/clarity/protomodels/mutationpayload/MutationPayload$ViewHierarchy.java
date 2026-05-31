package com.microsoft.clarity.protomodels.mutationpayload;

import androidx.camera.video.AudioStats;
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
public final class MutationPayload$ViewHierarchy extends GeneratedMessageLite<MutationPayload$ViewHierarchy, j0> implements MessageLiteOrBuilder {
    private static final MutationPayload$ViewHierarchy DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$ViewHierarchy> PARSER = null;
    public static final int ROOTDELTA_FIELD_NUMBER = 4;
    public static final int ROOT_FIELD_NUMBER = 2;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    public static final int VISIBLE_FRAGMENTS_FIELD_NUMBER = 3;
    private int bitField0_;
    private MutationPayload$ViewNodeDelta rootDelta_;
    private MutationPayload$ViewNode root_;
    private double timestamp_;
    private Internal.ProtobufList<String> visibleFragments_ = GeneratedMessageLite.emptyProtobufList();

    static {
        MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy = new MutationPayload$ViewHierarchy();
        DEFAULT_INSTANCE = mutationPayload$ViewHierarchy;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$ViewHierarchy.class, mutationPayload$ViewHierarchy);
    }

    private MutationPayload$ViewHierarchy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllVisibleFragments(Iterable<String> iterable) {
        ensureVisibleFragmentsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.visibleFragments_);
    }

    private void addVisibleFragments(String str) {
        str.getClass();
        ensureVisibleFragmentsIsMutable();
        this.visibleFragments_.add(str);
    }

    private void addVisibleFragmentsBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        ensureVisibleFragmentsIsMutable();
        this.visibleFragments_.add(byteString.toStringUtf8());
    }

    private void clearRoot() {
        this.root_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRootDelta() {
        this.rootDelta_ = null;
        this.bitField0_ &= -5;
    }

    private void clearTimestamp() {
        this.bitField0_ &= -2;
        this.timestamp_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void clearVisibleFragments() {
        this.visibleFragments_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureVisibleFragmentsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.visibleFragments_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.visibleFragments_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$ViewHierarchy getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRoot(MutationPayload$ViewNode mutationPayload$ViewNode) {
        mutationPayload$ViewNode.getClass();
        MutationPayload$ViewNode mutationPayload$ViewNode2 = this.root_;
        if (mutationPayload$ViewNode2 == null || mutationPayload$ViewNode2 == MutationPayload$ViewNode.getDefaultInstance()) {
            this.root_ = mutationPayload$ViewNode;
        } else {
            this.root_ = (MutationPayload$ViewNode) ((k0) MutationPayload$ViewNode.newBuilder(this.root_).mergeFrom((k0) mutationPayload$ViewNode)).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeRootDelta(MutationPayload$ViewNodeDelta mutationPayload$ViewNodeDelta) {
        mutationPayload$ViewNodeDelta.getClass();
        MutationPayload$ViewNodeDelta mutationPayload$ViewNodeDelta2 = this.rootDelta_;
        if (mutationPayload$ViewNodeDelta2 == null || mutationPayload$ViewNodeDelta2 == MutationPayload$ViewNodeDelta.getDefaultInstance()) {
            this.rootDelta_ = mutationPayload$ViewNodeDelta;
        } else {
            this.rootDelta_ = (MutationPayload$ViewNodeDelta) ((l0) MutationPayload$ViewNodeDelta.newBuilder(this.rootDelta_).mergeFrom((l0) mutationPayload$ViewNodeDelta)).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static j0 newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$ViewHierarchy parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$ViewHierarchy parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$ViewHierarchy> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRoot(MutationPayload$ViewNode mutationPayload$ViewNode) {
        mutationPayload$ViewNode.getClass();
        this.root_ = mutationPayload$ViewNode;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRootDelta(MutationPayload$ViewNodeDelta mutationPayload$ViewNodeDelta) {
        mutationPayload$ViewNodeDelta.getClass();
        this.rootDelta_ = mutationPayload$ViewNodeDelta;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(double d) {
        this.bitField0_ |= 1;
        this.timestamp_ = d;
    }

    private void setVisibleFragments(int i, String str) {
        str.getClass();
        ensureVisibleFragmentsIsMutable();
        this.visibleFragments_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$ViewHierarchy();
            case 2:
                return new j0();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001က\u0000\u0002ဉ\u0001\u0003Ț\u0004ဉ\u0002", new Object[]{"bitField0_", "timestamp_", "root_", "visibleFragments_", "rootDelta_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$ViewHierarchy> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$ViewHierarchy.class) {
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

    public MutationPayload$ViewNode getRoot() {
        MutationPayload$ViewNode mutationPayload$ViewNode = this.root_;
        return mutationPayload$ViewNode == null ? MutationPayload$ViewNode.getDefaultInstance() : mutationPayload$ViewNode;
    }

    public MutationPayload$ViewNodeDelta getRootDelta() {
        MutationPayload$ViewNodeDelta mutationPayload$ViewNodeDelta = this.rootDelta_;
        return mutationPayload$ViewNodeDelta == null ? MutationPayload$ViewNodeDelta.getDefaultInstance() : mutationPayload$ViewNodeDelta;
    }

    public double getTimestamp() {
        return this.timestamp_;
    }

    public String getVisibleFragments(int i) {
        return this.visibleFragments_.get(i);
    }

    public ByteString getVisibleFragmentsBytes(int i) {
        return ByteString.copyFromUtf8(this.visibleFragments_.get(i));
    }

    public int getVisibleFragmentsCount() {
        return this.visibleFragments_.size();
    }

    public List<String> getVisibleFragmentsList() {
        return this.visibleFragments_;
    }

    public boolean hasRoot() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRootDelta() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }

    public static j0 newBuilder(MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$ViewHierarchy);
    }

    public static MutationPayload$ViewHierarchy parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$ViewHierarchy parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$ViewHierarchy parseFrom(ByteString byteString) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$ViewHierarchy parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$ViewHierarchy parseFrom(byte[] bArr) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$ViewHierarchy parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$ViewHierarchy parseFrom(InputStream inputStream) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$ViewHierarchy parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$ViewHierarchy parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$ViewHierarchy parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewHierarchy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
