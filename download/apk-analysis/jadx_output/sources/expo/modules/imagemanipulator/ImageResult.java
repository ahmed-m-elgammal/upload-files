package expo.modules.imagemanipulator;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManipulationArguments.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lexpo/modules/imagemanipulator/ImageResult;", "Lexpo/modules/kotlin/records/Record;", "uri", "", "width", "", "height", "base64", "(Ljava/lang/String;IILjava/lang/String;)V", "getBase64$annotations", "()V", "getBase64", "()Ljava/lang/String;", "getHeight$annotations", "getHeight", "()I", "getUri$annotations", "getUri", "getWidth$annotations", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ImageResult implements Record {
    private final String base64;
    private final int height;
    private final String uri;
    private final int width;

    public static /* synthetic */ ImageResult copy$default(ImageResult imageResult, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = imageResult.uri;
        }
        if ((i3 & 2) != 0) {
            i = imageResult.width;
        }
        if ((i3 & 4) != 0) {
            i2 = imageResult.height;
        }
        if ((i3 & 8) != 0) {
            str2 = imageResult.base64;
        }
        return imageResult.copy(str, i, i2, str2);
    }

    @Field
    public static /* synthetic */ void getBase64$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBase64() {
        return this.base64;
    }

    public final ImageResult copy(String uri, int width, int height, String base64) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new ImageResult(uri, width, height, base64);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageResult)) {
            return false;
        }
        ImageResult imageResult = (ImageResult) other;
        return Intrinsics.areEqual(this.uri, imageResult.uri) && this.width == imageResult.width && this.height == imageResult.height && Intrinsics.areEqual(this.base64, imageResult.base64);
    }

    public int hashCode() {
        int hashCode = ((((this.uri.hashCode() * 31) + this.width) * 31) + this.height) * 31;
        String str = this.base64;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ImageResult(uri=" + this.uri + ", width=" + this.width + ", height=" + this.height + ", base64=" + this.base64 + ")";
    }

    public ImageResult(String uri, int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.width = i;
        this.height = i2;
        this.base64 = str;
    }

    public final String getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getBase64() {
        return this.base64;
    }
}
