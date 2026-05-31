package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.camera.video.AudioStats;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.imagepicker.Utils$$ExternalSyntheticBackport0;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManipulationArguments.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lexpo/modules/imagemanipulator/SaveOptions;", "Lexpo/modules/kotlin/records/Record;", "base64", "", "compress", "", "format", "Lexpo/modules/imagemanipulator/ImageFormat;", "(ZDLexpo/modules/imagemanipulator/ImageFormat;)V", "getBase64$annotations", "()V", "getBase64", "()Z", "getCompress$annotations", "getCompress", "()D", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "getCompressFormat", "()Landroid/graphics/Bitmap$CompressFormat;", "getFormat$annotations", "getFormat", "()Lexpo/modules/imagemanipulator/ImageFormat;", "setFormat", "(Lexpo/modules/imagemanipulator/ImageFormat;)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SaveOptions implements Record {
    private final boolean base64;
    private final double compress;
    private ImageFormat format;

    /* compiled from: ManipulationArguments.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            try {
                iArr[ImageFormat.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageFormat.JPG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageFormat.PNG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageFormat.WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SaveOptions() {
        this(false, AudioStats.AUDIO_AMPLITUDE_NONE, null, 7, null);
    }

    public static /* synthetic */ SaveOptions copy$default(SaveOptions saveOptions, boolean z, double d, ImageFormat imageFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            z = saveOptions.base64;
        }
        if ((i & 2) != 0) {
            d = saveOptions.compress;
        }
        if ((i & 4) != 0) {
            imageFormat = saveOptions.format;
        }
        return saveOptions.copy(z, d, imageFormat);
    }

    @Field
    public static /* synthetic */ void getBase64$annotations() {
    }

    @Field
    public static /* synthetic */ void getCompress$annotations() {
    }

    @Field
    public static /* synthetic */ void getFormat$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getBase64() {
        return this.base64;
    }

    /* renamed from: component2, reason: from getter */
    public final double getCompress() {
        return this.compress;
    }

    /* renamed from: component3, reason: from getter */
    public final ImageFormat getFormat() {
        return this.format;
    }

    public final SaveOptions copy(boolean base64, double compress, ImageFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return new SaveOptions(base64, compress, format);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaveOptions)) {
            return false;
        }
        SaveOptions saveOptions = (SaveOptions) other;
        return this.base64 == saveOptions.base64 && Double.compare(this.compress, saveOptions.compress) == 0 && this.format == saveOptions.format;
    }

    public int hashCode() {
        return (((Utils$$ExternalSyntheticBackport0.m(this.base64) * 31) + Utils$$ExternalSyntheticBackport0.m(this.compress)) * 31) + this.format.hashCode();
    }

    public String toString() {
        return "SaveOptions(base64=" + this.base64 + ", compress=" + this.compress + ", format=" + this.format + ")";
    }

    public SaveOptions(boolean z, double d, ImageFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.base64 = z;
        this.compress = d;
        this.format = format;
    }

    public final boolean getBase64() {
        return this.base64;
    }

    public final double getCompress() {
        return this.compress;
    }

    public /* synthetic */ SaveOptions(boolean z, double d, ImageFormat imageFormat, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 1.0d : d, (i & 4) != 0 ? ImageFormat.JPEG : imageFormat);
    }

    public final ImageFormat getFormat() {
        return this.format;
    }

    public final void setFormat(ImageFormat imageFormat) {
        Intrinsics.checkNotNullParameter(imageFormat, "<set-?>");
        this.format = imageFormat;
    }

    public final Bitmap.CompressFormat getCompressFormat() {
        Bitmap.CompressFormat compressFormat;
        int i = WhenMappings.$EnumSwitchMapping$0[this.format.ordinal()];
        if (i == 1 || i == 2) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (i == 3) {
            return Bitmap.CompressFormat.PNG;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (Build.VERSION.SDK_INT >= 30) {
            compressFormat = Bitmap.CompressFormat.WEBP_LOSSY;
            return compressFormat;
        }
        return Bitmap.CompressFormat.WEBP;
    }
}
