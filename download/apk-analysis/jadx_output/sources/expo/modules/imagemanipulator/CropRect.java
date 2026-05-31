package expo.modules.imagemanipulator;

import androidx.camera.video.AudioStats;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.imagepicker.Utils$$ExternalSyntheticBackport0;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ManipulationArguments.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lexpo/modules/imagemanipulator/CropRect;", "Lexpo/modules/kotlin/records/Record;", Snapshot.ORIGIN_X, "", Snapshot.ORIGIN_Y, "width", "height", "(DDDD)V", "getHeight$annotations", "()V", "getHeight", "()D", "getOriginX$annotations", "getOriginX", "getOriginY$annotations", "getOriginY", "getWidth$annotations", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CropRect implements Record {
    private final double height;
    private final double originX;
    private final double originY;
    private final double width;

    public CropRect() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 15, null);
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getOriginX$annotations() {
    }

    @Field
    public static /* synthetic */ void getOriginY$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final double getOriginX() {
        return this.originX;
    }

    /* renamed from: component2, reason: from getter */
    public final double getOriginY() {
        return this.originY;
    }

    /* renamed from: component3, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    public final CropRect copy(double originX, double originY, double width, double height) {
        return new CropRect(originX, originY, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropRect)) {
            return false;
        }
        CropRect cropRect = (CropRect) other;
        return Double.compare(this.originX, cropRect.originX) == 0 && Double.compare(this.originY, cropRect.originY) == 0 && Double.compare(this.width, cropRect.width) == 0 && Double.compare(this.height, cropRect.height) == 0;
    }

    public int hashCode() {
        return (((((Utils$$ExternalSyntheticBackport0.m(this.originX) * 31) + Utils$$ExternalSyntheticBackport0.m(this.originY)) * 31) + Utils$$ExternalSyntheticBackport0.m(this.width)) * 31) + Utils$$ExternalSyntheticBackport0.m(this.height);
    }

    public String toString() {
        return "CropRect(originX=" + this.originX + ", originY=" + this.originY + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public CropRect(double d, double d2, double d3, double d4) {
        this.originX = d;
        this.originY = d2;
        this.width = d3;
        this.height = d4;
    }

    public /* synthetic */ CropRect(double d, double d2, double d3, double d4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? 0.0d : d3, (i & 8) == 0 ? d4 : AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public final double getOriginX() {
        return this.originX;
    }

    public final double getOriginY() {
        return this.originY;
    }

    public final double getWidth() {
        return this.width;
    }

    public final double getHeight() {
        return this.height;
    }
}
