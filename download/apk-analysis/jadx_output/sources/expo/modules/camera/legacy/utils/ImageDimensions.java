package expo.modules.camera.legacy.utils;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageDimensions.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\t¨\u0006\u001c"}, d2 = {"Lexpo/modules/camera/legacy/utils/ImageDimensions;", "", "mWidth", "", "mHeight", ViewProps.ROTATION, "facing", "(IIII)V", "getFacing", "()I", "height", "getHeight", "isLandscape", "", "()Z", "getRotation", "width", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ImageDimensions {
    private final int facing;
    private final int mHeight;
    private final int mWidth;
    private final int rotation;

    public ImageDimensions(int i, int i2) {
        this(i, i2, 0, 0, 12, null);
    }

    public ImageDimensions(int i, int i2, int i3) {
        this(i, i2, i3, 0, 8, null);
    }

    /* renamed from: component1, reason: from getter */
    private final int getMWidth() {
        return this.mWidth;
    }

    /* renamed from: component2, reason: from getter */
    private final int getMHeight() {
        return this.mHeight;
    }

    public static /* synthetic */ ImageDimensions copy$default(ImageDimensions imageDimensions, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = imageDimensions.mWidth;
        }
        if ((i5 & 2) != 0) {
            i2 = imageDimensions.mHeight;
        }
        if ((i5 & 4) != 0) {
            i3 = imageDimensions.rotation;
        }
        if ((i5 & 8) != 0) {
            i4 = imageDimensions.facing;
        }
        return imageDimensions.copy(i, i2, i3, i4);
    }

    /* renamed from: component3, reason: from getter */
    public final int getRotation() {
        return this.rotation;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFacing() {
        return this.facing;
    }

    public final ImageDimensions copy(int mWidth, int mHeight, int rotation, int facing) {
        return new ImageDimensions(mWidth, mHeight, rotation, facing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageDimensions)) {
            return false;
        }
        ImageDimensions imageDimensions = (ImageDimensions) other;
        return this.mWidth == imageDimensions.mWidth && this.mHeight == imageDimensions.mHeight && this.rotation == imageDimensions.rotation && this.facing == imageDimensions.facing;
    }

    public int hashCode() {
        return (((((this.mWidth * 31) + this.mHeight) * 31) + this.rotation) * 31) + this.facing;
    }

    public String toString() {
        return "ImageDimensions(mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", rotation=" + this.rotation + ", facing=" + this.facing + ")";
    }

    public ImageDimensions(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mHeight = i2;
        this.rotation = i3;
        this.facing = i4;
    }

    public /* synthetic */ ImageDimensions(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? -1 : i4);
    }

    public final int getFacing() {
        return this.facing;
    }

    public final int getRotation() {
        return this.rotation;
    }

    private final boolean isLandscape() {
        return this.rotation % RotationOptions.ROTATE_180 == 90;
    }

    public final int getWidth() {
        if (isLandscape()) {
            return this.mHeight;
        }
        return this.mWidth;
    }

    public final int getHeight() {
        if (isLandscape()) {
            return this.mWidth;
        }
        return this.mHeight;
    }
}
