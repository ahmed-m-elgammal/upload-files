package androidx.camera.extensions;

import androidx.lifecycle.LiveData;

/* loaded from: classes.dex */
public interface CameraExtensionsInfo {

    /* renamed from: androidx.camera.extensions.CameraExtensionsInfo$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static LiveData $default$getCurrentExtensionMode(CameraExtensionsInfo _this) {
            return null;
        }

        public static LiveData $default$getExtensionStrength(CameraExtensionsInfo _this) {
            return null;
        }

        public static boolean $default$isCurrentExtensionModeAvailable(CameraExtensionsInfo _this) {
            return false;
        }

        public static boolean $default$isExtensionStrengthAvailable(CameraExtensionsInfo _this) {
            return false;
        }
    }

    LiveData<Integer> getCurrentExtensionMode();

    LiveData<Integer> getExtensionStrength();

    boolean isCurrentExtensionModeAvailable();

    boolean isExtensionStrengthAvailable();
}
