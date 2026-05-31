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
public final class MutationPayload$PathEffect extends GeneratedMessageLite<MutationPayload$PathEffect, J> implements MessageLiteOrBuilder {
    public static final int ADVANCE_FIELD_NUMBER = 6;
    private static final MutationPayload$PathEffect DEFAULT_INSTANCE;
    public static final int INTERVALS_FIELD_NUMBER = 3;
    private static volatile Parser<MutationPayload$PathEffect> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 8;
    public static final int PHASE_FIELD_NUMBER = 2;
    public static final int RADIUS_FIELD_NUMBER = 5;
    public static final int STYLE_FIELD_NUMBER = 7;
    public static final int TYPEENUM_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 1;
    private float advance_;
    private int bitField0_;
    private MutationPayload$Path path_;
    private float phase_;
    private float radius_;
    private long style_;
    private Object typeOneOf_;
    private int typeOneOfCase_ = 0;
    private int intervalsMemoizedSerializedSize = -1;
    private Internal.FloatList intervals_ = GeneratedMessageLite.emptyFloatList();

    static {
        MutationPayload$PathEffect mutationPayload$PathEffect = new MutationPayload$PathEffect();
        DEFAULT_INSTANCE = mutationPayload$PathEffect;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$PathEffect.class, mutationPayload$PathEffect);
    }

    private MutationPayload$PathEffect() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllIntervals(Iterable<? extends Float> iterable) {
        ensureIntervalsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.intervals_);
    }

    private void addIntervals(float f) {
        ensureIntervalsIsMutable();
        this.intervals_.addFloat(f);
    }

    private void clearAdvance() {
        this.bitField0_ &= -5;
        this.advance_ = 0.0f;
    }

    private void clearIntervals() {
        this.intervals_ = GeneratedMessageLite.emptyFloatList();
    }

    private void clearPath() {
        this.path_ = null;
        this.bitField0_ &= -17;
    }

    private void clearPhase() {
        this.bitField0_ &= -2;
        this.phase_ = 0.0f;
    }

    private void clearRadius() {
        this.bitField0_ &= -3;
        this.radius_ = 0.0f;
    }

    private void clearStyle() {
        this.bitField0_ &= -9;
        this.style_ = 0L;
    }

    private void clearType() {
        if (this.typeOneOfCase_ == 1) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeEnum() {
        if (this.typeOneOfCase_ == 4) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeOneOf() {
        this.typeOneOfCase_ = 0;
        this.typeOneOf_ = null;
    }

    private void ensureIntervalsIsMutable() {
        Internal.FloatList floatList = this.intervals_;
        if (floatList.isModifiable()) {
            return;
        }
        this.intervals_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    public static MutationPayload$PathEffect getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePath(MutationPayload$Path mutationPayload$Path) {
        mutationPayload$Path.getClass();
        MutationPayload$Path mutationPayload$Path2 = this.path_;
        if (mutationPayload$Path2 == null || mutationPayload$Path2 == MutationPayload$Path.getDefaultInstance()) {
            this.path_ = mutationPayload$Path;
        } else {
            this.path_ = (MutationPayload$Path) ((I) MutationPayload$Path.newBuilder(this.path_).mergeFrom((I) mutationPayload$Path)).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    public static J newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$PathEffect parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$PathEffect parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$PathEffect> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdvance(float f) {
        this.bitField0_ |= 4;
        this.advance_ = f;
    }

    private void setIntervals(int i, float f) {
        ensureIntervalsIsMutable();
        this.intervals_.setFloat(i, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPath(MutationPayload$Path mutationPayload$Path) {
        mutationPayload$Path.getClass();
        this.path_ = mutationPayload$Path;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhase(float f) {
        this.bitField0_ |= 1;
        this.phase_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadius(float f) {
        this.bitField0_ |= 2;
        this.radius_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStyle(long j) {
        this.bitField0_ |= 8;
        this.style_ = j;
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
    public void setTypeEnum(L l) {
        this.typeOneOf_ = Integer.valueOf(l.getNumber());
        this.typeOneOfCase_ = 4;
    }

    private void setTypeEnumValue(int i) {
        this.typeOneOfCase_ = 4;
        this.typeOneOf_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$PathEffect();
            case 2:
                return new J();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0001\u0001\u0001\b\b\u0000\u0001\u0000\u0001Ȼ\u0000\u0002ခ\u0000\u0003$\u0004?\u0000\u0005ခ\u0001\u0006ခ\u0002\u0007ဂ\u0003\bဉ\u0004", new Object[]{"typeOneOf_", "typeOneOfCase_", "bitField0_", "phase_", "intervals_", "radius_", "advance_", "style_", "path_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$PathEffect> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$PathEffect.class) {
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

    public float getAdvance() {
        return this.advance_;
    }

    public float getIntervals(int i) {
        return this.intervals_.getFloat(i);
    }

    public int getIntervalsCount() {
        return this.intervals_.size();
    }

    public List<Float> getIntervalsList() {
        return this.intervals_;
    }

    public MutationPayload$Path getPath() {
        MutationPayload$Path mutationPayload$Path = this.path_;
        return mutationPayload$Path == null ? MutationPayload$Path.getDefaultInstance() : mutationPayload$Path;
    }

    public float getPhase() {
        return this.phase_;
    }

    public float getRadius() {
        return this.radius_;
    }

    public long getStyle() {
        return this.style_;
    }

    public L getTypeEnum() {
        if (this.typeOneOfCase_ != 4) {
            return L.DashPathEffect;
        }
        int intValue = ((Integer) this.typeOneOf_).intValue();
        L l = intValue != 0 ? intValue != 1 ? intValue != 2 ? null : L.Path1DPathEffect : L.CornerPathEffect : L.DashPathEffect;
        return l == null ? L.UNRECOGNIZED : l;
    }

    public int getTypeEnumValue() {
        if (this.typeOneOfCase_ == 4) {
            return ((Integer) this.typeOneOf_).intValue();
        }
        return 0;
    }

    public K getTypeOneOfCase() {
        int i = this.typeOneOfCase_;
        if (i == 0) {
            return K.TYPEONEOF_NOT_SET;
        }
        if (i == 1) {
            return K.TYPE;
        }
        if (i != 4) {
            return null;
        }
        return K.TYPEENUM;
    }

    public boolean hasAdvance() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPath() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasPhase() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRadius() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStyle() {
        return (this.bitField0_ & 8) != 0;
    }

    @Deprecated
    public boolean hasType() {
        return this.typeOneOfCase_ == 1;
    }

    public boolean hasTypeEnum() {
        return this.typeOneOfCase_ == 4;
    }

    public static J newBuilder(MutationPayload$PathEffect mutationPayload$PathEffect) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$PathEffect);
    }

    public static MutationPayload$PathEffect parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$PathEffect parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    @Deprecated
    public String getType() {
        return this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "";
    }

    @Deprecated
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "");
    }

    public static MutationPayload$PathEffect parseFrom(ByteString byteString) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$PathEffect parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$PathEffect parseFrom(byte[] bArr) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$PathEffect parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$PathEffect parseFrom(InputStream inputStream) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$PathEffect parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$PathEffect parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$PathEffect parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$PathEffect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
