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
public final class MutationPayload$DisplayFrame extends GeneratedMessageLite<MutationPayload$DisplayFrame, C0122k> implements InterfaceC0123l {
    public static final int ACTIVITY_ID_FIELD_NUMBER = 12;
    public static final int ACTIVITY_NAME_FIELD_NUMBER = 11;
    public static final int COMMANDS_FIELD_NUMBER = 1;
    private static final MutationPayload$DisplayFrame DEFAULT_INSTANCE;
    public static final int DENSITY_FIELD_NUMBER = 15;
    public static final int IMAGES_FIELD_NUMBER = 3;
    public static final int KEYBOARD_HEIGHT_FIELD_NUMBER = 16;
    public static final int PAINTS_FIELD_NUMBER = 6;
    private static volatile Parser<MutationPayload$DisplayFrame> PARSER = null;
    public static final int PATHS_FIELD_NUMBER = 7;
    public static final int SCREEN_HEIGHT_FIELD_NUMBER = 14;
    public static final int SCREEN_WIDTH_FIELD_NUMBER = 13;
    public static final int SUB_PICTURES_FIELD_NUMBER = 8;
    public static final int SYSTEM_BACKGROUND_COLOR_FIELD_NUMBER = 17;
    public static final int TEXT_BLOBS_FIELD_NUMBER = 4;
    public static final int TIMESTAMP_FIELD_NUMBER = 10;
    public static final int TYPEFACES_FIELD_NUMBER = 2;
    public static final int VERTICES_FIELD_NUMBER = 5;
    public static final int VIEW_HIERARCHY_FIELD_NUMBER = 9;
    private int activityId_;
    private int bitField0_;
    private float density_;
    private int keyboardHeight_;
    private int screenHeight_;
    private int screenWidth_;
    private int systemBackgroundColor_;
    private double timestamp_;
    private MutationPayload$ViewHierarchy viewHierarchy_;
    private Internal.ProtobufList<MutationPayload$DisplayCommand> commands_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Typeface> typefaces_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Image> images_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$TextBlob> textBlobs_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Vertices> vertices_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Paint> paints_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$Path> paths_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<MutationPayload$DisplayFrame> subPictures_ = GeneratedMessageLite.emptyProtobufList();
    private String activityName_ = "";

    static {
        MutationPayload$DisplayFrame mutationPayload$DisplayFrame = new MutationPayload$DisplayFrame();
        DEFAULT_INSTANCE = mutationPayload$DisplayFrame;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$DisplayFrame.class, mutationPayload$DisplayFrame);
    }

    private MutationPayload$DisplayFrame() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCommands(Iterable<? extends MutationPayload$DisplayCommand> iterable) {
        ensureCommandsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.commands_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllImages(Iterable<? extends MutationPayload$Image> iterable) {
        ensureImagesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.images_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPaints(Iterable<? extends MutationPayload$Paint> iterable) {
        ensurePaintsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.paints_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPaths(Iterable<? extends MutationPayload$Path> iterable) {
        ensurePathsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.paths_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSubPictures(Iterable<? extends MutationPayload$DisplayFrame> iterable) {
        ensureSubPicturesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.subPictures_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTextBlobs(Iterable<? extends MutationPayload$TextBlob> iterable) {
        ensureTextBlobsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.textBlobs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTypefaces(Iterable<? extends MutationPayload$Typeface> iterable) {
        ensureTypefacesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.typefaces_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllVertices(Iterable<? extends MutationPayload$Vertices> iterable) {
        ensureVerticesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.vertices_);
    }

    private void addCommands(MutationPayload$DisplayCommand mutationPayload$DisplayCommand) {
        mutationPayload$DisplayCommand.getClass();
        ensureCommandsIsMutable();
        this.commands_.add(mutationPayload$DisplayCommand);
    }

    private void addImages(MutationPayload$Image mutationPayload$Image) {
        mutationPayload$Image.getClass();
        ensureImagesIsMutable();
        this.images_.add(mutationPayload$Image);
    }

    private void addPaints(MutationPayload$Paint mutationPayload$Paint) {
        mutationPayload$Paint.getClass();
        ensurePaintsIsMutable();
        this.paints_.add(mutationPayload$Paint);
    }

    private void addPaths(MutationPayload$Path mutationPayload$Path) {
        mutationPayload$Path.getClass();
        ensurePathsIsMutable();
        this.paths_.add(mutationPayload$Path);
    }

    private void addSubPictures(MutationPayload$DisplayFrame mutationPayload$DisplayFrame) {
        mutationPayload$DisplayFrame.getClass();
        ensureSubPicturesIsMutable();
        this.subPictures_.add(mutationPayload$DisplayFrame);
    }

    private void addTextBlobs(MutationPayload$TextBlob mutationPayload$TextBlob) {
        mutationPayload$TextBlob.getClass();
        ensureTextBlobsIsMutable();
        this.textBlobs_.add(mutationPayload$TextBlob);
    }

    private void addTypefaces(MutationPayload$Typeface mutationPayload$Typeface) {
        mutationPayload$Typeface.getClass();
        ensureTypefacesIsMutable();
        this.typefaces_.add(mutationPayload$Typeface);
    }

    private void addVertices(MutationPayload$Vertices mutationPayload$Vertices) {
        mutationPayload$Vertices.getClass();
        ensureVerticesIsMutable();
        this.vertices_.add(mutationPayload$Vertices);
    }

    private void clearActivityId() {
        this.bitField0_ &= -9;
        this.activityId_ = 0;
    }

    private void clearActivityName() {
        this.bitField0_ &= -5;
        this.activityName_ = getDefaultInstance().getActivityName();
    }

    private void clearCommands() {
        this.commands_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearDensity() {
        this.bitField0_ &= -65;
        this.density_ = 0.0f;
    }

    private void clearImages() {
        this.images_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearKeyboardHeight() {
        this.bitField0_ &= -129;
        this.keyboardHeight_ = 0;
    }

    private void clearPaints() {
        this.paints_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPaths() {
        this.paths_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearScreenHeight() {
        this.bitField0_ &= -33;
        this.screenHeight_ = 0;
    }

    private void clearScreenWidth() {
        this.bitField0_ &= -17;
        this.screenWidth_ = 0;
    }

    private void clearSubPictures() {
        this.subPictures_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSystemBackgroundColor() {
        this.bitField0_ &= -257;
        this.systemBackgroundColor_ = 0;
    }

    private void clearTextBlobs() {
        this.textBlobs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTimestamp() {
        this.bitField0_ &= -3;
        this.timestamp_ = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void clearTypefaces() {
        this.typefaces_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearVertices() {
        this.vertices_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearViewHierarchy() {
        this.viewHierarchy_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureCommandsIsMutable() {
        Internal.ProtobufList<MutationPayload$DisplayCommand> protobufList = this.commands_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.commands_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureImagesIsMutable() {
        Internal.ProtobufList<MutationPayload$Image> protobufList = this.images_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.images_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensurePaintsIsMutable() {
        Internal.ProtobufList<MutationPayload$Paint> protobufList = this.paints_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.paints_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensurePathsIsMutable() {
        Internal.ProtobufList<MutationPayload$Path> protobufList = this.paths_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.paths_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureSubPicturesIsMutable() {
        Internal.ProtobufList<MutationPayload$DisplayFrame> protobufList = this.subPictures_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.subPictures_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureTextBlobsIsMutable() {
        Internal.ProtobufList<MutationPayload$TextBlob> protobufList = this.textBlobs_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.textBlobs_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureTypefacesIsMutable() {
        Internal.ProtobufList<MutationPayload$Typeface> protobufList = this.typefaces_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.typefaces_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureVerticesIsMutable() {
        Internal.ProtobufList<MutationPayload$Vertices> protobufList = this.vertices_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.vertices_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$DisplayFrame getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeViewHierarchy(MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy) {
        mutationPayload$ViewHierarchy.getClass();
        MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy2 = this.viewHierarchy_;
        if (mutationPayload$ViewHierarchy2 == null || mutationPayload$ViewHierarchy2 == MutationPayload$ViewHierarchy.getDefaultInstance()) {
            this.viewHierarchy_ = mutationPayload$ViewHierarchy;
        } else {
            this.viewHierarchy_ = (MutationPayload$ViewHierarchy) ((j0) MutationPayload$ViewHierarchy.newBuilder(this.viewHierarchy_).mergeFrom((j0) mutationPayload$ViewHierarchy)).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static C0122k newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MutationPayload$DisplayFrame parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$DisplayFrame parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MutationPayload$DisplayFrame> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCommands(int i) {
        ensureCommandsIsMutable();
        this.commands_.remove(i);
    }

    private void removeImages(int i) {
        ensureImagesIsMutable();
        this.images_.remove(i);
    }

    private void removePaints(int i) {
        ensurePaintsIsMutable();
        this.paints_.remove(i);
    }

    private void removePaths(int i) {
        ensurePathsIsMutable();
        this.paths_.remove(i);
    }

    private void removeSubPictures(int i) {
        ensureSubPicturesIsMutable();
        this.subPictures_.remove(i);
    }

    private void removeTextBlobs(int i) {
        ensureTextBlobsIsMutable();
        this.textBlobs_.remove(i);
    }

    private void removeTypefaces(int i) {
        ensureTypefacesIsMutable();
        this.typefaces_.remove(i);
    }

    private void removeVertices(int i) {
        ensureVerticesIsMutable();
        this.vertices_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActivityId(int i) {
        this.bitField0_ |= 8;
        this.activityId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActivityName(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.activityName_ = str;
    }

    private void setActivityNameBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.activityName_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    private void setCommands(int i, MutationPayload$DisplayCommand mutationPayload$DisplayCommand) {
        mutationPayload$DisplayCommand.getClass();
        ensureCommandsIsMutable();
        this.commands_.set(i, mutationPayload$DisplayCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDensity(float f) {
        this.bitField0_ |= 64;
        this.density_ = f;
    }

    private void setImages(int i, MutationPayload$Image mutationPayload$Image) {
        mutationPayload$Image.getClass();
        ensureImagesIsMutable();
        this.images_.set(i, mutationPayload$Image);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyboardHeight(int i) {
        this.bitField0_ |= 128;
        this.keyboardHeight_ = i;
    }

    private void setPaints(int i, MutationPayload$Paint mutationPayload$Paint) {
        mutationPayload$Paint.getClass();
        ensurePaintsIsMutable();
        this.paints_.set(i, mutationPayload$Paint);
    }

    private void setPaths(int i, MutationPayload$Path mutationPayload$Path) {
        mutationPayload$Path.getClass();
        ensurePathsIsMutable();
        this.paths_.set(i, mutationPayload$Path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreenHeight(int i) {
        this.bitField0_ |= 32;
        this.screenHeight_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreenWidth(int i) {
        this.bitField0_ |= 16;
        this.screenWidth_ = i;
    }

    private void setSubPictures(int i, MutationPayload$DisplayFrame mutationPayload$DisplayFrame) {
        mutationPayload$DisplayFrame.getClass();
        ensureSubPicturesIsMutable();
        this.subPictures_.set(i, mutationPayload$DisplayFrame);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemBackgroundColor(int i) {
        this.bitField0_ |= 256;
        this.systemBackgroundColor_ = i;
    }

    private void setTextBlobs(int i, MutationPayload$TextBlob mutationPayload$TextBlob) {
        mutationPayload$TextBlob.getClass();
        ensureTextBlobsIsMutable();
        this.textBlobs_.set(i, mutationPayload$TextBlob);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(double d) {
        this.bitField0_ |= 2;
        this.timestamp_ = d;
    }

    private void setTypefaces(int i, MutationPayload$Typeface mutationPayload$Typeface) {
        mutationPayload$Typeface.getClass();
        ensureTypefacesIsMutable();
        this.typefaces_.set(i, mutationPayload$Typeface);
    }

    private void setVertices(int i, MutationPayload$Vertices mutationPayload$Vertices) {
        mutationPayload$Vertices.getClass();
        ensureVerticesIsMutable();
        this.vertices_.set(i, mutationPayload$Vertices);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewHierarchy(MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy) {
        mutationPayload$ViewHierarchy.getClass();
        this.viewHierarchy_ = mutationPayload$ViewHierarchy;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AbstractC0112a.f210a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$DisplayFrame();
            case 2:
                return new C0122k();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0011\u0000\u0001\u0001\u0011\u0011\u0000\b\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b\u0005\u001b\u0006\u001b\u0007\u001b\b\u001b\tဉ\u0000\nက\u0001\u000bለ\u0002\fင\u0003\rင\u0004\u000eင\u0005\u000fခ\u0006\u0010င\u0007\u0011င\b", new Object[]{"bitField0_", "commands_", MutationPayload$DisplayCommand.class, "typefaces_", MutationPayload$Typeface.class, "images_", MutationPayload$Image.class, "textBlobs_", MutationPayload$TextBlob.class, "vertices_", MutationPayload$Vertices.class, "paints_", MutationPayload$Paint.class, "paths_", MutationPayload$Path.class, "subPictures_", MutationPayload$DisplayFrame.class, "viewHierarchy_", "timestamp_", "activityName_", "activityId_", "screenWidth_", "screenHeight_", "density_", "keyboardHeight_", "systemBackgroundColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$DisplayFrame> parser = PARSER;
                if (parser == null) {
                    synchronized (MutationPayload$DisplayFrame.class) {
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

    public int getActivityId() {
        return this.activityId_;
    }

    public String getActivityName() {
        return this.activityName_;
    }

    public ByteString getActivityNameBytes() {
        return ByteString.copyFromUtf8(this.activityName_);
    }

    public MutationPayload$DisplayCommand getCommands(int i) {
        return this.commands_.get(i);
    }

    public int getCommandsCount() {
        return this.commands_.size();
    }

    public List<MutationPayload$DisplayCommand> getCommandsList() {
        return this.commands_;
    }

    public InterfaceC0120i getCommandsOrBuilder(int i) {
        return this.commands_.get(i);
    }

    public List<? extends InterfaceC0120i> getCommandsOrBuilderList() {
        return this.commands_;
    }

    public float getDensity() {
        return this.density_;
    }

    public MutationPayload$Image getImages(int i) {
        return this.images_.get(i);
    }

    public int getImagesCount() {
        return this.images_.size();
    }

    public List<MutationPayload$Image> getImagesList() {
        return this.images_;
    }

    public InterfaceC0131u getImagesOrBuilder(int i) {
        return this.images_.get(i);
    }

    public List<? extends InterfaceC0131u> getImagesOrBuilderList() {
        return this.images_;
    }

    public int getKeyboardHeight() {
        return this.keyboardHeight_;
    }

    public MutationPayload$Paint getPaints(int i) {
        return this.paints_.get(i);
    }

    public int getPaintsCount() {
        return this.paints_.size();
    }

    public List<MutationPayload$Paint> getPaintsList() {
        return this.paints_;
    }

    public H getPaintsOrBuilder(int i) {
        return this.paints_.get(i);
    }

    public List<? extends H> getPaintsOrBuilderList() {
        return this.paints_;
    }

    public MutationPayload$Path getPaths(int i) {
        return this.paths_.get(i);
    }

    public int getPathsCount() {
        return this.paths_.size();
    }

    public List<MutationPayload$Path> getPathsList() {
        return this.paths_;
    }

    public M getPathsOrBuilder(int i) {
        return this.paths_.get(i);
    }

    public List<? extends M> getPathsOrBuilderList() {
        return this.paths_;
    }

    public int getScreenHeight() {
        return this.screenHeight_;
    }

    public int getScreenWidth() {
        return this.screenWidth_;
    }

    public MutationPayload$DisplayFrame getSubPictures(int i) {
        return this.subPictures_.get(i);
    }

    public int getSubPicturesCount() {
        return this.subPictures_.size();
    }

    public List<MutationPayload$DisplayFrame> getSubPicturesList() {
        return this.subPictures_;
    }

    public InterfaceC0123l getSubPicturesOrBuilder(int i) {
        return this.subPictures_.get(i);
    }

    public List<? extends InterfaceC0123l> getSubPicturesOrBuilderList() {
        return this.subPictures_;
    }

    public int getSystemBackgroundColor() {
        return this.systemBackgroundColor_;
    }

    public MutationPayload$TextBlob getTextBlobs(int i) {
        return this.textBlobs_.get(i);
    }

    public int getTextBlobsCount() {
        return this.textBlobs_.size();
    }

    public List<MutationPayload$TextBlob> getTextBlobsList() {
        return this.textBlobs_;
    }

    public c0 getTextBlobsOrBuilder(int i) {
        return this.textBlobs_.get(i);
    }

    public List<? extends c0> getTextBlobsOrBuilderList() {
        return this.textBlobs_;
    }

    public double getTimestamp() {
        return this.timestamp_;
    }

    public MutationPayload$Typeface getTypefaces(int i) {
        return this.typefaces_.get(i);
    }

    public int getTypefacesCount() {
        return this.typefaces_.size();
    }

    public List<MutationPayload$Typeface> getTypefacesList() {
        return this.typefaces_;
    }

    public g0 getTypefacesOrBuilder(int i) {
        return this.typefaces_.get(i);
    }

    public List<? extends g0> getTypefacesOrBuilderList() {
        return this.typefaces_;
    }

    public MutationPayload$Vertices getVertices(int i) {
        return this.vertices_.get(i);
    }

    public int getVerticesCount() {
        return this.vertices_.size();
    }

    public List<MutationPayload$Vertices> getVerticesList() {
        return this.vertices_;
    }

    public i0 getVerticesOrBuilder(int i) {
        return this.vertices_.get(i);
    }

    public List<? extends i0> getVerticesOrBuilderList() {
        return this.vertices_;
    }

    public MutationPayload$ViewHierarchy getViewHierarchy() {
        MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy = this.viewHierarchy_;
        return mutationPayload$ViewHierarchy == null ? MutationPayload$ViewHierarchy.getDefaultInstance() : mutationPayload$ViewHierarchy;
    }

    public boolean hasActivityId() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasActivityName() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasDensity() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasKeyboardHeight() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasScreenHeight() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasScreenWidth() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasSystemBackgroundColor() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasTimestamp() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasViewHierarchy() {
        return (this.bitField0_ & 1) != 0;
    }

    public static C0122k newBuilder(MutationPayload$DisplayFrame mutationPayload$DisplayFrame) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$DisplayFrame);
    }

    public static MutationPayload$DisplayFrame parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$DisplayFrame parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$DisplayFrame parseFrom(ByteString byteString) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    private void addCommands(int i, MutationPayload$DisplayCommand mutationPayload$DisplayCommand) {
        mutationPayload$DisplayCommand.getClass();
        ensureCommandsIsMutable();
        this.commands_.add(i, mutationPayload$DisplayCommand);
    }

    private void addImages(int i, MutationPayload$Image mutationPayload$Image) {
        mutationPayload$Image.getClass();
        ensureImagesIsMutable();
        this.images_.add(i, mutationPayload$Image);
    }

    private void addPaints(int i, MutationPayload$Paint mutationPayload$Paint) {
        mutationPayload$Paint.getClass();
        ensurePaintsIsMutable();
        this.paints_.add(i, mutationPayload$Paint);
    }

    private void addPaths(int i, MutationPayload$Path mutationPayload$Path) {
        mutationPayload$Path.getClass();
        ensurePathsIsMutable();
        this.paths_.add(i, mutationPayload$Path);
    }

    private void addSubPictures(int i, MutationPayload$DisplayFrame mutationPayload$DisplayFrame) {
        mutationPayload$DisplayFrame.getClass();
        ensureSubPicturesIsMutable();
        this.subPictures_.add(i, mutationPayload$DisplayFrame);
    }

    private void addTextBlobs(int i, MutationPayload$TextBlob mutationPayload$TextBlob) {
        mutationPayload$TextBlob.getClass();
        ensureTextBlobsIsMutable();
        this.textBlobs_.add(i, mutationPayload$TextBlob);
    }

    private void addTypefaces(int i, MutationPayload$Typeface mutationPayload$Typeface) {
        mutationPayload$Typeface.getClass();
        ensureTypefacesIsMutable();
        this.typefaces_.add(i, mutationPayload$Typeface);
    }

    private void addVertices(int i, MutationPayload$Vertices mutationPayload$Vertices) {
        mutationPayload$Vertices.getClass();
        ensureVerticesIsMutable();
        this.vertices_.add(i, mutationPayload$Vertices);
    }

    public static MutationPayload$DisplayFrame parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$DisplayFrame parseFrom(byte[] bArr) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$DisplayFrame parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MutationPayload$DisplayFrame parseFrom(InputStream inputStream) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$DisplayFrame parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$DisplayFrame parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$DisplayFrame parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$DisplayFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
