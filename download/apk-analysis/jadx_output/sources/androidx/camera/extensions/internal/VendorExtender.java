package androidx.camera.extensions.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface VendorExtender {
    SessionProcessor createSessionProcessor(Context context);

    Range<Long> getEstimatedCaptureLatencyRange(Size size);

    List<Pair<Integer, Size[]>> getSupportedCaptureOutputResolutions();

    Map<Integer, List<Size>> getSupportedPostviewResolutions(Size size);

    List<Pair<Integer, Size[]>> getSupportedPreviewOutputResolutions();

    Size[] getSupportedYuvAnalysisResolutions();

    void init(CameraInfo cameraInfo);

    boolean isCaptureProcessProgressAvailable();

    boolean isCurrentExtensionModeAvailable();

    boolean isExtensionAvailable(String str, Map<String, CameraCharacteristics> map);

    boolean isExtensionStrengthAvailable();

    boolean isPostviewAvailable();

    /* renamed from: androidx.camera.extensions.internal.VendorExtender$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static SessionProcessor $default$createSessionProcessor(VendorExtender _this, Context context) {
            return null;
        }

        public static Range $default$getEstimatedCaptureLatencyRange(VendorExtender _this, Size size) {
            return null;
        }

        public static void $default$init(VendorExtender _this, CameraInfo cameraInfo) {
        }

        public static boolean $default$isCaptureProcessProgressAvailable(VendorExtender _this) {
            return false;
        }

        public static boolean $default$isCurrentExtensionModeAvailable(VendorExtender _this) {
            return false;
        }

        public static boolean $default$isExtensionAvailable(VendorExtender _this, String str, Map map) {
            return false;
        }

        public static boolean $default$isExtensionStrengthAvailable(VendorExtender _this) {
            return false;
        }

        public static boolean $default$isPostviewAvailable(VendorExtender _this) {
            return false;
        }

        public static Size[] $default$getSupportedYuvAnalysisResolutions(VendorExtender _this) {
            return new Size[0];
        }
    }
}
