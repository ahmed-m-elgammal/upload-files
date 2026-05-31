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
public final class MutationPayload$Lattice extends GeneratedMessageLite<MutationPayload$Lattice, C0133w> implements MessageLiteOrBuilder {
    public static final int BOUNDS_FIELD_NUMBER = 1;
    public static final int COLORS_FIELD_NUMBER = 2;
    private static final MutationPayload$Lattice DEFAULT_INSTANCE;
    private static volatile Parser<MutationPayload$Lattice> PARSER = null;
    public static final int RECT_TYPE_FIELD_NUMBER = 3;
    public static final int X_DIVS_FIELD_NUMBER = 4;
    public static final int Y_DIVS_FIELD_NUMBER = 5;
    private int bitField0_;
    private MutationPayload$Rect bounds_;
    private int colorsMemoizedSerializedSize = -1;
    private int rectTypeMemoizedSerializedSize = -1;
    private int xDivsMemoizedSerializedSize = -1;
    private int yDivsMemoizedSerializedSize = -1;
    private Internal.DoubleList colors_ = GeneratedMessageLite.emptyDoubleList();
    private Internal.IntList rectType_ = GeneratedMessageLite.emptyIntList();
    private Internal.IntList xDivs_ = GeneratedMessageLite.emptyIntList();
    private Internal.IntList yDivs_ = GeneratedMessageLite.emptyIntList();

    static {
        MutationPayload$Lattice mutationPayload$Lattice = new MutationPayload$Lattice();
        DEFAULT_INSTANCE = mutationPayload$Lattice;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Lattice.class, mutationPayload$Lattice);
    }

    private MutationPayload$Lattice() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllColors(Iterable<? extends Double> iterable) {
        ensureColorsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.colors_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRectType(Iterable<? extends Integer> iterable) {
        ensureRectTypeIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.rectType_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllXDivs(Iterable<? extends Integer> iterable) {
        ensureXDivsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.xDivs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllYDivs(Iterable<? extends Integer> iterable) {
        ensureYDivsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.yDivs_);
    }

    private void addColors(double d) {
        ensureColorsIsMutable();
        this.colors_.addDouble(d);
    }

    private void addRectType(int i) {
        ensureRectTypeIsMutable();
        this.rectType_.addInt(i);
    }

    private void addXDivs(int i) {
        ensureXDivsIsMutable();
        this.xDivs_.addInt(i);
    }

    private void addYDivs(int i) {
        ensureYDivsIsMutable();
        this.yDivs_.addInt(i);
    }

    private void clearBounds() {
        this.bounds_ = null;
        this.bitField0_ &= -2;
    }

    private void clearColors() {
        this.colors_ = GeneratedMessageLite.emptyDoubleList();
    }

    private void clearRectType() {
        this.rectType_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearXDivs() {
        this.xDivs_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearYDivs() {
        this.yDivs_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureColorsIsMutable() {
        Internal.DoubleList doubleList = this.colors_;
        if (doubleList.isModifiable()) {
            return;
        }
        this.colors_ = GeneratedMessageLite.mutableCopy(doubleList);
    }

    private void ensureRectTypeIsMutable() {
        Internal.IntList intList = this.rectType_;
        if (intList.isModifiable()) {
            return;
        }
        this.rectType_ = GeneratedMessageLite.mutableCopy(intList);
    }

    private void ensureXDivsIsMutable() {
        Internal.IntList intList = this.xDivs_;
        if (intList.isModifiable()) {
            return;
        }
        this.xDivs_ = GeneratedMessageLite.mutableCopy(intList);
    }

    private void ensureYDivsIsMutable() {
        Internal.IntList intList = this.yDivs_;
        if (intList.isModifiable()) {
            return;
        }
        this.yDivs_ = GeneratedMessageLite.mutableCopy(intList);
    }

    public static MutationPayload$Lattice getDefaultInstance() {
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

    public static C0133w newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$Lattice parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Lattice parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$Lattice> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBounds(MutationPayload$Rect mutationPayload$Rect) {
        mutationPayload$Rect.getClass();
        this.bounds_ = mutationPayload$Rect;
        this.bitField0_ |= 1;
    }

    private void setColors(int i, double d) {
        ensureColorsIsMutable();
        this.colors_.setDouble(i, d);
    }

    private void setRectType(int i, int i2) {
        ensureRectTypeIsMutable();
        this.rectType_.setInt(i, i2);
    }

    private void setXDivs(int i, int i2) {
        ensureXDivsIsMutable();
        this.xDivs_.setInt(i, i2);
    }

    private void setYDivs(int i, int i2) {
        ensureYDivsIsMutable();
        this.yDivs_.setInt(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Lattice();
            case 2:
                return new C0133w();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001ဉ\u0000\u0002#\u0003'\u0004'\u0005'", new Object[]{"bitField0_", "bounds_", "colors_", "rectType_", "xDivs_", "yDivs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Lattice> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$Lattice.class) {
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

    public double getColors(int i) {
        return this.colors_.getDouble(i);
    }

    public int getColorsCount() {
        return this.colors_.size();
    }

    public List<Double> getColorsList() {
        return this.colors_;
    }

    public int getRectType(int i) {
        return this.rectType_.getInt(i);
    }

    public int getRectTypeCount() {
        return this.rectType_.size();
    }

    public List<Integer> getRectTypeList() {
        return this.rectType_;
    }

    public int getXDivs(int i) {
        return this.xDivs_.getInt(i);
    }

    public int getXDivsCount() {
        return this.xDivs_.size();
    }

    public List<Integer> getXDivsList() {
        return this.xDivs_;
    }

    public int getYDivs(int i) {
        return this.yDivs_.getInt(i);
    }

    public int getYDivsCount() {
        return this.yDivs_.size();
    }

    public List<Integer> getYDivsList() {
        return this.yDivs_;
    }

    public boolean hasBounds() {
        return (this.bitField0_ & 1) != 0;
    }

    public static C0133w newBuilder(MutationPayload$Lattice mutationPayload$Lattice) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Lattice);
    }

    public static MutationPayload$Lattice parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Lattice parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Lattice parseFrom(ByteString byteString) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Lattice parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Lattice parseFrom(byte[] bArr) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Lattice parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$Lattice parseFrom(InputStream inputStream) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Lattice parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Lattice parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Lattice parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Lattice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
