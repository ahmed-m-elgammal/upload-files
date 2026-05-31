package androidx.camera.video.internal.compat.quirk;

import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Quirk;
import androidx.camera.video.Quality;

/* loaded from: classes.dex */
public interface VideoQualityQuirk extends Quirk {

    /* renamed from: androidx.camera.video.internal.compat.quirk.VideoQualityQuirk$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$workaroundBySurfaceProcessing(VideoQualityQuirk _this) {
            return false;
        }
    }

    boolean isProblematicVideoQuality(CameraInfoInternal cameraInfoInternal, Quality quality);

    boolean workaroundBySurfaceProcessing();
}
