package com.microsoft.clarity.protomodels.mutationpayload;

import androidx.camera.video.AudioStats;
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
public final class MutationPayload$Vertices extends GeneratedMessageLite<MutationPayload$Vertices, h0> implements i0 {
    public static final int BONE_INDICES_FIELD_NUMBER = 6;
    public static final int BONE_WEIGHTS_FIELD_NUMBER = 7;
    public static final int COLORS_FIELD_NUMBER = 5;
    private static final MutationPayload$Vertices DEFAULT_INSTANCE;
    public static final int INDICES_FIELD_NUMBER = 8;
    public static final int IS_VOLATILE_FIELD_NUMBER = 2;
    public static final int MODE_FIELD_NUMBER = 1;
    private static volatile Parser<MutationPayload$Vertices> PARSER = null;
    public static final int POSITIONS_FIELD_NUMBER = 3;
    public static final int TEX_COORDS_FIELD_NUMBER = 4;
    private int bitField0_;
    private boolean isVolatile_;
    private double mode_;
    private int colorsMemoizedSerializedSize = -1;
    private int indicesMemoizedSerializedSize = -1;
    private Internal.ProtobufList<MutationPayload$Point> positions_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Point> texCoords_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.DoubleList colors_ = GeneratedMessageLite.emptyDoubleList();
    private Internal.ProtobufList<MutationPayload$DoubleList> boneIndices_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$FloatList> boneWeights_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.DoubleList indices_ = GeneratedMessageLite.emptyDoubleList();

    static {
        MutationPayload$Vertices mutationPayload$Vertices = new MutationPayload$Vertices();
        DEFAULT_INSTANCE = mutationPayload$Vertices;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Vertices.class, mutationPayload$Vertices);
    }

    private MutationPayload$Vertices() {
    }

    private void addAllBoneIndices(Iterable<? extends MutationPayload$DoubleList> iterable) {
        ensureBoneIndicesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.boneIndices_);
    }

    private void addAllBoneWeights(Iterable<? extends MutationPayload$FloatList> iterable) {
        ensureBoneWeightsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.boneWeights_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllColors(Iterable<? extends Double> iterable) {
        ensureColorsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.colors_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllIndices(Iterable<? extends Double> iterable) {
        ensureIndicesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.indices_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPositions(Iterable<? extends MutationPayload$Point> iterable) {
        ensurePositionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.positions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTexCoords(Iterable<? extends MutationPayload$Point> iterable) {
        ensureTexCoordsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.texCoords_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBoneIndices(MutationPayload$DoubleList mutationPayload$DoubleList) {
        mutationPayload$DoubleList.getClass();
        ensureBoneIndicesIsMutable();
        this.boneIndices_.add(mutationPayload$DoubleList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBoneWeights(MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureBoneWeightsIsMutable();
        this.boneWeights_.add(mutationPayload$FloatList);
    }

    private void addColors(double d) {
        ensureColorsIsMutable();
        this.colors_.addDouble(d);
    }

    private void addIndices(double d) {
        ensureIndicesIsMutable();
        this.indices_.addDouble(d);
    }

    private void addPositions(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensurePositionsIsMutable();
        this.positions_.add(mutationPayload$Point);
    }

    private void addTexCoords(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensureTexCoordsIsMutable();
        this.texCoords_.add(mutationPayload$Point);
    }

    private void clearBoneIndices() {
        this.boneIndices_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearBoneWeights() {
        this.boneWeights_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearColors() {
        this.colors_ = GeneratedMessageLite.emptyDoubleList();
    }

    private void clearIndices() {
        this.indices_ = GeneratedMessageLite.emptyDoubleList();
    }

    private void clearIsVolatile() {
        this.bitField0_ &= -3;
        this.isVolatile_ = false;
    }

    private void clearMode() {
        this.bitField0_ &= -2;
        this.mode_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void clearPositions() {
        this.positions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTexCoords() {
        this.texCoords_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBoneIndicesIsMutable() {
        Internal.ProtobufList<MutationPayload$DoubleList> protobufList = this.boneIndices_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.boneIndices_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureBoneWeightsIsMutable() {
        Internal.ProtobufList<MutationPayload$FloatList> protobufList = this.boneWeights_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.boneWeights_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureColorsIsMutable() {
        Internal.DoubleList doubleList = this.colors_;
        if (doubleList.isModifiable()) {
            return;
        }
        this.colors_ = GeneratedMessageLite.mutableCopy(doubleList);
    }

    private void ensureIndicesIsMutable() {
        Internal.DoubleList doubleList = this.indices_;
        if (doubleList.isModifiable()) {
            return;
        }
        this.indices_ = GeneratedMessageLite.mutableCopy(doubleList);
    }

    private void ensurePositionsIsMutable() {
        Internal.ProtobufList<MutationPayload$Point> protobufList = this.positions_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.positions_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureTexCoordsIsMutable() {
        Internal.ProtobufList<MutationPayload$Point> protobufList = this.texCoords_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.texCoords_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$Vertices getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static h0 newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$Vertices parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Vertices parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$Vertices> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBoneIndices(int i) {
        ensureBoneIndicesIsMutable();
        this.boneIndices_.remove(i);
    }

    private void removeBoneWeights(int i) {
        ensureBoneWeightsIsMutable();
        this.boneWeights_.remove(i);
    }

    private void removePositions(int i) {
        ensurePositionsIsMutable();
        this.positions_.remove(i);
    }

    private void removeTexCoords(int i) {
        ensureTexCoordsIsMutable();
        this.texCoords_.remove(i);
    }

    private void setBoneIndices(int i, MutationPayload$DoubleList mutationPayload$DoubleList) {
        mutationPayload$DoubleList.getClass();
        ensureBoneIndicesIsMutable();
        this.boneIndices_.set(i, mutationPayload$DoubleList);
    }

    private void setBoneWeights(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureBoneWeightsIsMutable();
        this.boneWeights_.set(i, mutationPayload$FloatList);
    }

    private void setColors(int i, double d) {
        ensureColorsIsMutable();
        this.colors_.setDouble(i, d);
    }

    private void setIndices(int i, double d) {
        ensureIndicesIsMutable();
        this.indices_.setDouble(i, d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsVolatile(boolean z) {
        this.bitField0_ |= 2;
        this.isVolatile_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMode(double d) {
        this.bitField0_ |= 1;
        this.mode_ = d;
    }

    private void setPositions(int i, MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensurePositionsIsMutable();
        this.positions_.set(i, mutationPayload$Point);
    }

    private void setTexCoords(int i, MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensureTexCoordsIsMutable();
        this.texCoords_.set(i, mutationPayload$Point);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Vertices();
            case 2:
                return new h0();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0006\u0000\u0001က\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005#\u0006\u001b\u0007\u001b\b#", new Object[]{"bitField0_", "mode_", "isVolatile_", "positions_", MutationPayload$Point.class, "texCoords_", MutationPayload$Point.class, "colors_", "boneIndices_", MutationPayload$DoubleList.class, "boneWeights_", MutationPayload$FloatList.class, "indices_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Vertices> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$Vertices.class) {
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

    public MutationPayload$DoubleList getBoneIndices(int i) {
        return this.boneIndices_.get(i);
    }

    public int getBoneIndicesCount() {
        return this.boneIndices_.size();
    }

    public List<MutationPayload$DoubleList> getBoneIndicesList() {
        return this.boneIndices_;
    }

    public InterfaceC0125n getBoneIndicesOrBuilder(int i) {
        return this.boneIndices_.get(i);
    }

    public List<? extends InterfaceC0125n> getBoneIndicesOrBuilderList() {
        return this.boneIndices_;
    }

    public MutationPayload$FloatList getBoneWeights(int i) {
        return this.boneWeights_.get(i);
    }

    public int getBoneWeightsCount() {
        return this.boneWeights_.size();
    }

    public List<MutationPayload$FloatList> getBoneWeightsList() {
        return this.boneWeights_;
    }

    public InterfaceC0127p getBoneWeightsOrBuilder(int i) {
        return this.boneWeights_.get(i);
    }

    public List<? extends InterfaceC0127p> getBoneWeightsOrBuilderList() {
        return this.boneWeights_;
    }

    public double getColors(int i) {
        return this.colors_.getDouble(i);
    }

    public int getColorsCount() {
        return this.colors_.size();
    }

    public List<Double> getColorsList() {
        return this.colors_;
    }

    public double getIndices(int i) {
        return this.indices_.getDouble(i);
    }

    public int getIndicesCount() {
        return this.indices_.size();
    }

    public List<Double> getIndicesList() {
        return this.indices_;
    }

    public boolean getIsVolatile() {
        return this.isVolatile_;
    }

    public double getMode() {
        return this.mode_;
    }

    public MutationPayload$Point getPositions(int i) {
        return this.positions_.get(i);
    }

    public int getPositionsCount() {
        return this.positions_.size();
    }

    public List<MutationPayload$Point> getPositionsList() {
        return this.positions_;
    }

    public T getPositionsOrBuilder(int i) {
        return this.positions_.get(i);
    }

    public List<? extends T> getPositionsOrBuilderList() {
        return this.positions_;
    }

    public MutationPayload$Point getTexCoords(int i) {
        return this.texCoords_.get(i);
    }

    public int getTexCoordsCount() {
        return this.texCoords_.size();
    }

    public List<MutationPayload$Point> getTexCoordsList() {
        return this.texCoords_;
    }

    public T getTexCoordsOrBuilder(int i) {
        return this.texCoords_.get(i);
    }

    public List<? extends T> getTexCoordsOrBuilderList() {
        return this.texCoords_;
    }

    public boolean hasIsVolatile() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMode() {
        return (this.bitField0_ & 1) != 0;
    }

    public static h0 newBuilder(MutationPayload$Vertices mutationPayload$Vertices) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Vertices);
    }

    public static MutationPayload$Vertices parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Vertices parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Vertices parseFrom(ByteString byteString) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    private void addBoneIndices(int i, MutationPayload$DoubleList mutationPayload$DoubleList) {
        mutationPayload$DoubleList.getClass();
        ensureBoneIndicesIsMutable();
        this.boneIndices_.add(i, mutationPayload$DoubleList);
    }

    private void addBoneWeights(int i, MutationPayload$FloatList mutationPayload$FloatList) {
        mutationPayload$FloatList.getClass();
        ensureBoneWeightsIsMutable();
        this.boneWeights_.add(i, mutationPayload$FloatList);
    }

    private void addPositions(int i, MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensurePositionsIsMutable();
        this.positions_.add(i, mutationPayload$Point);
    }

    private void addTexCoords(int i, MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        ensureTexCoordsIsMutable();
        this.texCoords_.add(i, mutationPayload$Point);
    }

    public static MutationPayload$Vertices parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Vertices parseFrom(byte[] bArr) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Vertices parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$Vertices parseFrom(InputStream inputStream) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Vertices parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Vertices parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Vertices parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Vertices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
