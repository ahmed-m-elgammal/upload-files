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
public final class MutationPayload$Shader extends GeneratedMessageLite<MutationPayload$Shader, Y> implements MessageLiteOrBuilder {
    public static final int CENTER_FIELD_NUMBER = 18;
    public static final int COLOR4F_FIELD_NUMBER = 24;
    public static final int COLOR4F_SPACE_DATA_FIELD_NUMBER = 25;
    public static final int COLORS_FIELD_NUMBER = 15;
    private static final MutationPayload$Shader DEFAULT_INSTANCE;
    public static final int END_ANGLE_FIELD_NUMBER = 21;
    public static final int END_FIELD_NUMBER = 12;
    public static final int GRAD_FLAGS_FIELD_NUMBER = 14;
    public static final int IMAGE_INDEX_FIELD_NUMBER = 7;
    public static final int LOCAL_MATRIX_FIELD_NUMBER = 17;
    public static final int MASKED_COLOR_FIELD_NUMBER = 10;
    public static final int MASKED_HEIGHT_FIELD_NUMBER = 9;
    public static final int MASKED_WIDTH_FIELD_NUMBER = 8;
    public static final int MATRIX_FIELD_NUMBER = 4;
    private static volatile Parser<MutationPayload$Shader> PARSER = null;
    public static final int POS_FIELD_NUMBER = 16;
    public static final int RADIUS_FIELD_NUMBER = 19;
    public static final int RAW_FIELD_NUMBER = 5;
    public static final int SAMPLING_FIELD_NUMBER = 6;
    public static final int SHADER_FIELD_NUMBER = 22;
    public static final int START_ANGLE_FIELD_NUMBER = 20;
    public static final int START_FIELD_NUMBER = 11;
    public static final int TILE_MODE_FIELD_NUMBER = 13;
    public static final int TYPEENUM_FIELD_NUMBER = 23;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int T_X_FIELD_NUMBER = 2;
    public static final int T_Y_FIELD_NUMBER = 3;
    private int bitField0_;
    private MutationPayload$Point center_;
    private MutationPayload$IntList color4FSpaceData_;
    private MutationPayload$Color4f color4F_;
    private float endAngle_;
    private MutationPayload$Point end_;
    private double gradFlags_;
    private int imageIndex_;
    private MutationPayload$Color4f maskedColor_;
    private int maskedHeight_;
    private int maskedWidth_;
    private float radius_;
    private boolean raw_;
    private MutationPayload$Sampling sampling_;
    private MutationPayload$Shader shader_;
    private float startAngle_;
    private MutationPayload$Point start_;
    private double tX_;
    private double tY_;
    private double tileMode_;
    private Object typeOneOf_;
    private int typeOneOfCase_ = 0;
    private int matrixMemoizedSerializedSize = -1;
    private int posMemoizedSerializedSize = -1;
    private int localMatrixMemoizedSerializedSize = -1;
    private Internal.FloatList matrix_ = GeneratedMessageLite.emptyFloatList();
    private Internal.ProtobufList<MutationPayload$Color4f> colors_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.FloatList pos_ = GeneratedMessageLite.emptyFloatList();
    private Internal.FloatList localMatrix_ = GeneratedMessageLite.emptyFloatList();

    static {
        MutationPayload$Shader mutationPayload$Shader = new MutationPayload$Shader();
        DEFAULT_INSTANCE = mutationPayload$Shader;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Shader.class, mutationPayload$Shader);
    }

    private MutationPayload$Shader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllColors(Iterable<? extends MutationPayload$Color4f> iterable) {
        ensureColorsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.colors_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLocalMatrix(Iterable<? extends Float> iterable) {
        ensureLocalMatrixIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.localMatrix_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMatrix(Iterable<? extends Float> iterable) {
        ensureMatrixIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.matrix_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPos(Iterable<? extends Float> iterable) {
        ensurePosIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.pos_);
    }

    private void addColors(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        ensureColorsIsMutable();
        this.colors_.add(mutationPayload$Color4f);
    }

    private void addLocalMatrix(float f) {
        ensureLocalMatrixIsMutable();
        this.localMatrix_.addFloat(f);
    }

    private void addMatrix(float f) {
        ensureMatrixIsMutable();
        this.matrix_.addFloat(f);
    }

    private void addPos(float f) {
        ensurePosIsMutable();
        this.pos_.addFloat(f);
    }

    private void clearCenter() {
        this.center_ = null;
        this.bitField0_ &= -4097;
    }

    private void clearColor4F() {
        this.color4F_ = null;
        this.bitField0_ &= -131073;
    }

    private void clearColor4FSpaceData() {
        this.color4FSpaceData_ = null;
        this.bitField0_ &= -262145;
    }

    private void clearColors() {
        this.colors_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearEnd() {
        this.end_ = null;
        this.bitField0_ &= -513;
    }

    private void clearEndAngle() {
        this.bitField0_ &= -32769;
        this.endAngle_ = 0.0f;
    }

    private void clearGradFlags() {
        this.bitField0_ &= -2049;
        this.gradFlags_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void clearImageIndex() {
        this.bitField0_ &= -17;
        this.imageIndex_ = 0;
    }

    private void clearLocalMatrix() {
        this.localMatrix_ = GeneratedMessageLite.emptyFloatList();
    }

    private void clearMaskedColor() {
        this.maskedColor_ = null;
        this.bitField0_ &= -129;
    }

    private void clearMaskedHeight() {
        this.bitField0_ &= -65;
        this.maskedHeight_ = 0;
    }

    private void clearMaskedWidth() {
        this.bitField0_ &= -33;
        this.maskedWidth_ = 0;
    }

    private void clearMatrix() {
        this.matrix_ = GeneratedMessageLite.emptyFloatList();
    }

    private void clearPos() {
        this.pos_ = GeneratedMessageLite.emptyFloatList();
    }

    private void clearRadius() {
        this.bitField0_ &= -8193;
        this.radius_ = 0.0f;
    }

    private void clearRaw() {
        this.bitField0_ &= -5;
        this.raw_ = false;
    }

    private void clearSampling() {
        this.sampling_ = null;
        this.bitField0_ &= -9;
    }

    private void clearShader() {
        this.shader_ = null;
        this.bitField0_ &= -65537;
    }

    private void clearStart() {
        this.start_ = null;
        this.bitField0_ &= -257;
    }

    private void clearStartAngle() {
        this.bitField0_ &= -16385;
        this.startAngle_ = 0.0f;
    }

    private void clearTX() {
        this.bitField0_ &= -2;
        this.tX_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void clearTY() {
        this.bitField0_ &= -3;
        this.tY_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void clearTileMode() {
        this.bitField0_ &= -1025;
        this.tileMode_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void clearType() {
        if (this.typeOneOfCase_ == 1) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeEnum() {
        if (this.typeOneOfCase_ == 23) {
            this.typeOneOfCase_ = 0;
            this.typeOneOf_ = null;
        }
    }

    private void clearTypeOneOf() {
        this.typeOneOfCase_ = 0;
        this.typeOneOf_ = null;
    }

    private void ensureColorsIsMutable() {
        Internal.ProtobufList<MutationPayload$Color4f> protobufList = this.colors_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.colors_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureLocalMatrixIsMutable() {
        Internal.FloatList floatList = this.localMatrix_;
        if (floatList.isModifiable()) {
            return;
        }
        this.localMatrix_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    private void ensureMatrixIsMutable() {
        Internal.FloatList floatList = this.matrix_;
        if (floatList.isModifiable()) {
            return;
        }
        this.matrix_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    private void ensurePosIsMutable() {
        Internal.FloatList floatList = this.pos_;
        if (floatList.isModifiable()) {
            return;
        }
        this.pos_ = GeneratedMessageLite.mutableCopy(floatList);
    }

    public static MutationPayload$Shader getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCenter(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        MutationPayload$Point mutationPayload$Point2 = this.center_;
        if (mutationPayload$Point2 == null || mutationPayload$Point2 == MutationPayload$Point.getDefaultInstance()) {
            this.center_ = mutationPayload$Point;
        } else {
            this.center_ = (MutationPayload$Point) ((S) MutationPayload$Point.newBuilder(this.center_).mergeFrom((S) mutationPayload$Point)).buildPartial();
        }
        this.bitField0_ |= 4096;
    }

    private void mergeColor4F(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        MutationPayload$Color4f mutationPayload$Color4f2 = this.color4F_;
        if (mutationPayload$Color4f2 == null || mutationPayload$Color4f2 == MutationPayload$Color4f.getDefaultInstance()) {
            this.color4F_ = mutationPayload$Color4f;
        } else {
            this.color4F_ = (MutationPayload$Color4f) ((C0113b) MutationPayload$Color4f.newBuilder(this.color4F_).mergeFrom((C0113b) mutationPayload$Color4f)).buildPartial();
        }
        this.bitField0_ |= 131072;
    }

    private void mergeColor4FSpaceData(MutationPayload$IntList mutationPayload$IntList) {
        mutationPayload$IntList.getClass();
        MutationPayload$IntList mutationPayload$IntList2 = this.color4FSpaceData_;
        if (mutationPayload$IntList2 == null || mutationPayload$IntList2 == MutationPayload$IntList.getDefaultInstance()) {
            this.color4FSpaceData_ = mutationPayload$IntList;
        } else {
            this.color4FSpaceData_ = (MutationPayload$IntList) ((C0132v) MutationPayload$IntList.newBuilder(this.color4FSpaceData_).mergeFrom((C0132v) mutationPayload$IntList)).buildPartial();
        }
        this.bitField0_ |= 262144;
    }

    private void mergeEnd(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        MutationPayload$Point mutationPayload$Point2 = this.end_;
        if (mutationPayload$Point2 == null || mutationPayload$Point2 == MutationPayload$Point.getDefaultInstance()) {
            this.end_ = mutationPayload$Point;
        } else {
            this.end_ = (MutationPayload$Point) ((S) MutationPayload$Point.newBuilder(this.end_).mergeFrom((S) mutationPayload$Point)).buildPartial();
        }
        this.bitField0_ |= 512;
    }

    private void mergeMaskedColor(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        MutationPayload$Color4f mutationPayload$Color4f2 = this.maskedColor_;
        if (mutationPayload$Color4f2 == null || mutationPayload$Color4f2 == MutationPayload$Color4f.getDefaultInstance()) {
            this.maskedColor_ = mutationPayload$Color4f;
        } else {
            this.maskedColor_ = (MutationPayload$Color4f) ((C0113b) MutationPayload$Color4f.newBuilder(this.maskedColor_).mergeFrom((C0113b) mutationPayload$Color4f)).buildPartial();
        }
        this.bitField0_ |= 128;
    }

    private void mergeSampling(MutationPayload$Sampling mutationPayload$Sampling) {
        mutationPayload$Sampling.getClass();
        MutationPayload$Sampling mutationPayload$Sampling2 = this.sampling_;
        if (mutationPayload$Sampling2 == null || mutationPayload$Sampling2 == MutationPayload$Sampling.getDefaultInstance()) {
            this.sampling_ = mutationPayload$Sampling;
        } else {
            this.sampling_ = (MutationPayload$Sampling) ((V) MutationPayload$Sampling.newBuilder(this.sampling_).mergeFrom((V) mutationPayload$Sampling)).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    private void mergeShader(MutationPayload$Shader mutationPayload$Shader) {
        mutationPayload$Shader.getClass();
        MutationPayload$Shader mutationPayload$Shader2 = this.shader_;
        if (mutationPayload$Shader2 == null || mutationPayload$Shader2 == getDefaultInstance()) {
            this.shader_ = mutationPayload$Shader;
        } else {
            this.shader_ = (MutationPayload$Shader) ((Y) newBuilder(this.shader_).mergeFrom((Y) mutationPayload$Shader)).buildPartial();
        }
        this.bitField0_ |= 65536;
    }

    private void mergeStart(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        MutationPayload$Point mutationPayload$Point2 = this.start_;
        if (mutationPayload$Point2 == null || mutationPayload$Point2 == MutationPayload$Point.getDefaultInstance()) {
            this.start_ = mutationPayload$Point;
        } else {
            this.start_ = (MutationPayload$Point) ((S) MutationPayload$Point.newBuilder(this.start_).mergeFrom((S) mutationPayload$Point)).buildPartial();
        }
        this.bitField0_ |= 256;
    }

    public static Y newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$Shader parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Shader parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$Shader> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeColors(int i) {
        ensureColorsIsMutable();
        this.colors_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCenter(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        this.center_ = mutationPayload$Point;
        this.bitField0_ |= 4096;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColor4F(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        this.color4F_ = mutationPayload$Color4f;
        this.bitField0_ |= 131072;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColor4FSpaceData(MutationPayload$IntList mutationPayload$IntList) {
        mutationPayload$IntList.getClass();
        this.color4FSpaceData_ = mutationPayload$IntList;
        this.bitField0_ |= 262144;
    }

    private void setColors(int i, MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        ensureColorsIsMutable();
        this.colors_.set(i, mutationPayload$Color4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnd(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        this.end_ = mutationPayload$Point;
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndAngle(float f) {
        this.bitField0_ |= 32768;
        this.endAngle_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGradFlags(double d) {
        this.bitField0_ |= 2048;
        this.gradFlags_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageIndex(int i) {
        this.bitField0_ |= 16;
        this.imageIndex_ = i;
    }

    private void setLocalMatrix(int i, float f) {
        ensureLocalMatrixIsMutable();
        this.localMatrix_.setFloat(i, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskedColor(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        this.maskedColor_ = mutationPayload$Color4f;
        this.bitField0_ |= 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskedHeight(int i) {
        this.bitField0_ |= 64;
        this.maskedHeight_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskedWidth(int i) {
        this.bitField0_ |= 32;
        this.maskedWidth_ = i;
    }

    private void setMatrix(int i, float f) {
        ensureMatrixIsMutable();
        this.matrix_.setFloat(i, f);
    }

    private void setPos(int i, float f) {
        ensurePosIsMutable();
        this.pos_.setFloat(i, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadius(float f) {
        this.bitField0_ |= 8192;
        this.radius_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRaw(boolean z) {
        this.bitField0_ |= 4;
        this.raw_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSampling(MutationPayload$Sampling mutationPayload$Sampling) {
        mutationPayload$Sampling.getClass();
        this.sampling_ = mutationPayload$Sampling;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShader(MutationPayload$Shader mutationPayload$Shader) {
        mutationPayload$Shader.getClass();
        this.shader_ = mutationPayload$Shader;
        this.bitField0_ |= 65536;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStart(MutationPayload$Point mutationPayload$Point) {
        mutationPayload$Point.getClass();
        this.start_ = mutationPayload$Point;
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartAngle(float f) {
        this.bitField0_ |= 16384;
        this.startAngle_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTX(double d) {
        this.bitField0_ |= 1;
        this.tX_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTY(double d) {
        this.bitField0_ |= 2;
        this.tY_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTileMode(double d) {
        this.bitField0_ |= 1024;
        this.tileMode_ = d;
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
    public void setTypeEnum(a0 a0Var) {
        this.typeOneOf_ = Integer.valueOf(a0Var.getNumber());
        this.typeOneOfCase_ = 23;
    }

    private void setTypeEnumValue(int i) {
        this.typeOneOfCase_ = 23;
        this.typeOneOf_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Shader();
            case 2:
                return new Y();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0019\u0001\u0001\u0001\u0019\u0019\u0000\u0004\u0000\u0001Ȼ\u0000\u0002က\u0000\u0003က\u0001\u0004$\u0005ဇ\u0002\u0006ဉ\u0003\u0007င\u0004\bင\u0005\tင\u0006\nဉ\u0007\u000bဉ\b\fဉ\t\rက\n\u000eက\u000b\u000f\u001b\u0010$\u0011$\u0012ဉ\f\u0013ခ\r\u0014ခ\u000e\u0015ခ\u000f\u0016ဉ\u0010\u0017?\u0000\u0018ဉ\u0011\u0019ဉ\u0012", new Object[]{"typeOneOf_", "typeOneOfCase_", "bitField0_", "tX_", "tY_", "matrix_", "raw_", "sampling_", "imageIndex_", "maskedWidth_", "maskedHeight_", "maskedColor_", "start_", "end_", "tileMode_", "gradFlags_", "colors_", MutationPayload$Color4f.class, "pos_", "localMatrix_", "center_", "radius_", "startAngle_", "endAngle_", "shader_", "color4F_", "color4FSpaceData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Shader> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$Shader.class) {
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

    public MutationPayload$Point getCenter() {
        MutationPayload$Point mutationPayload$Point = this.center_;
        return mutationPayload$Point == null ? MutationPayload$Point.getDefaultInstance() : mutationPayload$Point;
    }

    public MutationPayload$Color4f getColor4F() {
        MutationPayload$Color4f mutationPayload$Color4f = this.color4F_;
        return mutationPayload$Color4f == null ? MutationPayload$Color4f.getDefaultInstance() : mutationPayload$Color4f;
    }

    public MutationPayload$IntList getColor4FSpaceData() {
        MutationPayload$IntList mutationPayload$IntList = this.color4FSpaceData_;
        return mutationPayload$IntList == null ? MutationPayload$IntList.getDefaultInstance() : mutationPayload$IntList;
    }

    public MutationPayload$Color4f getColors(int i) {
        return this.colors_.get(i);
    }

    public int getColorsCount() {
        return this.colors_.size();
    }

    public List<MutationPayload$Color4f> getColorsList() {
        return this.colors_;
    }

    public InterfaceC0114c getColorsOrBuilder(int i) {
        return this.colors_.get(i);
    }

    public List<? extends InterfaceC0114c> getColorsOrBuilderList() {
        return this.colors_;
    }

    public MutationPayload$Point getEnd() {
        MutationPayload$Point mutationPayload$Point = this.end_;
        return mutationPayload$Point == null ? MutationPayload$Point.getDefaultInstance() : mutationPayload$Point;
    }

    public float getEndAngle() {
        return this.endAngle_;
    }

    public double getGradFlags() {
        return this.gradFlags_;
    }

    public int getImageIndex() {
        return this.imageIndex_;
    }

    public float getLocalMatrix(int i) {
        return this.localMatrix_.getFloat(i);
    }

    public int getLocalMatrixCount() {
        return this.localMatrix_.size();
    }

    public List<Float> getLocalMatrixList() {
        return this.localMatrix_;
    }

    public MutationPayload$Color4f getMaskedColor() {
        MutationPayload$Color4f mutationPayload$Color4f = this.maskedColor_;
        return mutationPayload$Color4f == null ? MutationPayload$Color4f.getDefaultInstance() : mutationPayload$Color4f;
    }

    public int getMaskedHeight() {
        return this.maskedHeight_;
    }

    public int getMaskedWidth() {
        return this.maskedWidth_;
    }

    public float getMatrix(int i) {
        return this.matrix_.getFloat(i);
    }

    public int getMatrixCount() {
        return this.matrix_.size();
    }

    public List<Float> getMatrixList() {
        return this.matrix_;
    }

    public float getPos(int i) {
        return this.pos_.getFloat(i);
    }

    public int getPosCount() {
        return this.pos_.size();
    }

    public List<Float> getPosList() {
        return this.pos_;
    }

    public float getRadius() {
        return this.radius_;
    }

    public boolean getRaw() {
        return this.raw_;
    }

    public MutationPayload$Sampling getSampling() {
        MutationPayload$Sampling mutationPayload$Sampling = this.sampling_;
        return mutationPayload$Sampling == null ? MutationPayload$Sampling.getDefaultInstance() : mutationPayload$Sampling;
    }

    public MutationPayload$Shader getShader() {
        MutationPayload$Shader mutationPayload$Shader = this.shader_;
        return mutationPayload$Shader == null ? getDefaultInstance() : mutationPayload$Shader;
    }

    public MutationPayload$Point getStart() {
        MutationPayload$Point mutationPayload$Point = this.start_;
        return mutationPayload$Point == null ? MutationPayload$Point.getDefaultInstance() : mutationPayload$Point;
    }

    public float getStartAngle() {
        return this.startAngle_;
    }

    public double getTX() {
        return this.tX_;
    }

    public double getTY() {
        return this.tY_;
    }

    public double getTileMode() {
        return this.tileMode_;
    }

    public a0 getTypeEnum() {
        if (this.typeOneOfCase_ != 23) {
            return a0.ImageShader;
        }
        int intValue = ((Integer) this.typeOneOf_).intValue();
        a0 a0Var = intValue != 0 ? intValue != 1 ? intValue != 2 ? intValue != 3 ? intValue != 4 ? intValue != 5 ? null : a0.Color4Shader : a0.LocalMatrixShader : a0.SweepGradientShader : a0.RadialGradientShader : a0.LinearGradientShader : a0.ImageShader;
        return a0Var == null ? a0.UNRECOGNIZED : a0Var;
    }

    public int getTypeEnumValue() {
        if (this.typeOneOfCase_ == 23) {
            return ((Integer) this.typeOneOf_).intValue();
        }
        return 0;
    }

    public Z getTypeOneOfCase() {
        int i = this.typeOneOfCase_;
        if (i == 0) {
            return Z.TYPEONEOF_NOT_SET;
        }
        if (i == 1) {
            return Z.TYPE;
        }
        if (i != 23) {
            return null;
        }
        return Z.TYPEENUM;
    }

    public boolean hasCenter() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasColor4F() {
        return (this.bitField0_ & 131072) != 0;
    }

    public boolean hasColor4FSpaceData() {
        return (this.bitField0_ & 262144) != 0;
    }

    public boolean hasEnd() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasEndAngle() {
        return (this.bitField0_ & 32768) != 0;
    }

    public boolean hasGradFlags() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasImageIndex() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasMaskedColor() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasMaskedHeight() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasMaskedWidth() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasRadius() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasRaw() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasSampling() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasShader() {
        return (this.bitField0_ & 65536) != 0;
    }

    public boolean hasStart() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasStartAngle() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasTX() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTY() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTileMode() {
        return (this.bitField0_ & 1024) != 0;
    }

    @Deprecated
    public boolean hasType() {
        return this.typeOneOfCase_ == 1;
    }

    public boolean hasTypeEnum() {
        return this.typeOneOfCase_ == 23;
    }

    public static Y newBuilder(MutationPayload$Shader mutationPayload$Shader) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Shader);
    }

    public static MutationPayload$Shader parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Shader parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    @Deprecated
    public String getType() {
        return this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "";
    }

    @Deprecated
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.typeOneOfCase_ == 1 ? (String) this.typeOneOf_ : "");
    }

    public static MutationPayload$Shader parseFrom(ByteString byteString) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    private void addColors(int i, MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        ensureColorsIsMutable();
        this.colors_.add(i, mutationPayload$Color4f);
    }

    public static MutationPayload$Shader parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Shader parseFrom(byte[] bArr) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Shader parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$Shader parseFrom(InputStream inputStream) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Shader parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Shader parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Shader parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Shader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
