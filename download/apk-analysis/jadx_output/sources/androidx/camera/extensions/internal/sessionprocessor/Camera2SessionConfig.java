package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureRequest;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
interface Camera2SessionConfig {

    /* renamed from: androidx.camera.extensions.internal.sessionprocessor.Camera2SessionConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getSessionType(Camera2SessionConfig _this) {
            return 0;
        }
    }

    List<Camera2OutputConfig> getOutputConfigs();

    Map<CaptureRequest.Key<?>, Object> getSessionParameters();

    int getSessionTemplateId();

    int getSessionType();
}
