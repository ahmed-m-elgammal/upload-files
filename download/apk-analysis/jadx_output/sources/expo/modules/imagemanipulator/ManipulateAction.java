package expo.modules.imagemanipulator;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManipulationArguments.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lexpo/modules/imagemanipulator/ManipulateAction;", "Lexpo/modules/kotlin/records/Record;", "resize", "Lexpo/modules/imagemanipulator/ResizeOptions;", "rotate", "", "flip", "Lexpo/modules/imagemanipulator/FlipType;", "crop", "Lexpo/modules/imagemanipulator/CropRect;", "(Lexpo/modules/imagemanipulator/ResizeOptions;Ljava/lang/Double;Lexpo/modules/imagemanipulator/FlipType;Lexpo/modules/imagemanipulator/CropRect;)V", "getCrop$annotations", "()V", "getCrop", "()Lexpo/modules/imagemanipulator/CropRect;", "getFlip$annotations", "getFlip", "()Lexpo/modules/imagemanipulator/FlipType;", "getResize$annotations", "getResize", "()Lexpo/modules/imagemanipulator/ResizeOptions;", "setResize", "(Lexpo/modules/imagemanipulator/ResizeOptions;)V", "getRotate$annotations", "getRotate", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "copy", "(Lexpo/modules/imagemanipulator/ResizeOptions;Ljava/lang/Double;Lexpo/modules/imagemanipulator/FlipType;Lexpo/modules/imagemanipulator/CropRect;)Lexpo/modules/imagemanipulator/ManipulateAction;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ManipulateAction implements Record {
    private final CropRect crop;
    private final FlipType flip;
    private ResizeOptions resize;
    private final Double rotate;

    public static /* synthetic */ ManipulateAction copy$default(ManipulateAction manipulateAction, ResizeOptions resizeOptions, Double d, FlipType flipType, CropRect cropRect, int i, Object obj) {
        if ((i & 1) != 0) {
            resizeOptions = manipulateAction.resize;
        }
        if ((i & 2) != 0) {
            d = manipulateAction.rotate;
        }
        if ((i & 4) != 0) {
            flipType = manipulateAction.flip;
        }
        if ((i & 8) != 0) {
            cropRect = manipulateAction.crop;
        }
        return manipulateAction.copy(resizeOptions, d, flipType, cropRect);
    }

    @Field
    public static /* synthetic */ void getCrop$annotations() {
    }

    @Field
    public static /* synthetic */ void getFlip$annotations() {
    }

    @Field
    public static /* synthetic */ void getResize$annotations() {
    }

    @Field
    public static /* synthetic */ void getRotate$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final ResizeOptions getResize() {
        return this.resize;
    }

    /* renamed from: component2, reason: from getter */
    public final Double getRotate() {
        return this.rotate;
    }

    /* renamed from: component3, reason: from getter */
    public final FlipType getFlip() {
        return this.flip;
    }

    /* renamed from: component4, reason: from getter */
    public final CropRect getCrop() {
        return this.crop;
    }

    public final ManipulateAction copy(ResizeOptions resize, Double rotate, FlipType flip, CropRect crop) {
        return new ManipulateAction(resize, rotate, flip, crop);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManipulateAction)) {
            return false;
        }
        ManipulateAction manipulateAction = (ManipulateAction) other;
        return Intrinsics.areEqual(this.resize, manipulateAction.resize) && Intrinsics.areEqual((Object) this.rotate, (Object) manipulateAction.rotate) && this.flip == manipulateAction.flip && Intrinsics.areEqual(this.crop, manipulateAction.crop);
    }

    public int hashCode() {
        ResizeOptions resizeOptions = this.resize;
        int hashCode = (resizeOptions == null ? 0 : resizeOptions.hashCode()) * 31;
        Double d = this.rotate;
        int hashCode2 = (hashCode + (d == null ? 0 : d.hashCode())) * 31;
        FlipType flipType = this.flip;
        int hashCode3 = (hashCode2 + (flipType == null ? 0 : flipType.hashCode())) * 31;
        CropRect cropRect = this.crop;
        return hashCode3 + (cropRect != null ? cropRect.hashCode() : 0);
    }

    public String toString() {
        return "ManipulateAction(resize=" + this.resize + ", rotate=" + this.rotate + ", flip=" + this.flip + ", crop=" + this.crop + ")";
    }

    public ManipulateAction(ResizeOptions resizeOptions, Double d, FlipType flipType, CropRect cropRect) {
        this.resize = resizeOptions;
        this.rotate = d;
        this.flip = flipType;
        this.crop = cropRect;
    }

    public final ResizeOptions getResize() {
        return this.resize;
    }

    public final void setResize(ResizeOptions resizeOptions) {
        this.resize = resizeOptions;
    }

    public final Double getRotate() {
        return this.rotate;
    }

    public final FlipType getFlip() {
        return this.flip;
    }

    public final CropRect getCrop() {
        return this.crop;
    }
}
