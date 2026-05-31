package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TemplateParamsOverride {
    private final Quirks mQuirks;

    public TemplateParamsOverride(Quirks quirks) {
        this.mQuirks = quirks;
    }

    public Map<CaptureRequest.Key<?>, Object> getOverrideParams(int i) {
        if (i == 3 && CaptureIntentPreviewQuirk.CC.workaroundByCaptureIntentPreview(this.mQuirks)) {
            HashMap hashMap = new HashMap();
            hashMap.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 1);
            return Collections.unmodifiableMap(hashMap);
        }
        return Collections.emptyMap();
    }
}
