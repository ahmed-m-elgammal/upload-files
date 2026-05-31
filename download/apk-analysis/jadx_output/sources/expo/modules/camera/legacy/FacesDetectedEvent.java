package expo.modules.camera.legacy;

import android.os.Bundle;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.events.TouchesHelper;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Events.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lexpo/modules/camera/legacy/FacesDetectedEvent;", "Lexpo/modules/kotlin/records/Record;", "type", "", "faces", "", "Landroid/os/Bundle;", TouchesHelper.TARGET_KEY, "", "(Ljava/lang/String;Ljava/util/List;I)V", "getFaces$annotations", "()V", "getFaces", "()Ljava/util/List;", "getTarget$annotations", "getTarget", "()I", "getType$annotations", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FacesDetectedEvent implements Record {
    private final List<Bundle> faces;
    private final int target;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FacesDetectedEvent copy$default(FacesDetectedEvent facesDetectedEvent, String str, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = facesDetectedEvent.type;
        }
        if ((i2 & 2) != 0) {
            list = facesDetectedEvent.faces;
        }
        if ((i2 & 4) != 0) {
            i = facesDetectedEvent.target;
        }
        return facesDetectedEvent.copy(str, list, i);
    }

    @Field
    public static /* synthetic */ void getFaces$annotations() {
    }

    @Field
    public static /* synthetic */ void getTarget$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<Bundle> component2() {
        return this.faces;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTarget() {
        return this.target;
    }

    public final FacesDetectedEvent copy(String type, List<Bundle> faces, int target) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(faces, "faces");
        return new FacesDetectedEvent(type, faces, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FacesDetectedEvent)) {
            return false;
        }
        FacesDetectedEvent facesDetectedEvent = (FacesDetectedEvent) other;
        return Intrinsics.areEqual(this.type, facesDetectedEvent.type) && Intrinsics.areEqual(this.faces, facesDetectedEvent.faces) && this.target == facesDetectedEvent.target;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.faces.hashCode()) * 31) + this.target;
    }

    public String toString() {
        return "FacesDetectedEvent(type=" + this.type + ", faces=" + this.faces + ", target=" + this.target + ")";
    }

    public FacesDetectedEvent(String type, List<Bundle> faces, int i) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(faces, "faces");
        this.type = type;
        this.faces = faces;
        this.target = i;
    }

    public final String getType() {
        return this.type;
    }

    public final List<Bundle> getFaces() {
        return this.faces;
    }

    public final int getTarget() {
        return this.target;
    }
}
