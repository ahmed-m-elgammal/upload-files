package com.google.android.cameraview;

import android.content.Context;
import android.hardware.camera2.params.StreamConfigurationMap;
import com.google.android.cameraview.CameraViewImpl;

/* loaded from: classes.dex */
class Camera2Api23 extends Camera2 {
    Camera2Api23(CameraViewImpl.Callback callback, PreviewImpl previewImpl, Context context) {
        super(callback, previewImpl, context);
    }

    @Override // com.google.android.cameraview.Camera2
    protected void collectPictureSizes(SizeMap sizeMap, StreamConfigurationMap streamConfigurationMap) {
        if (streamConfigurationMap.getHighResolutionOutputSizes(256) != null) {
            for (android.util.Size size : streamConfigurationMap.getHighResolutionOutputSizes(256)) {
                sizeMap.add(new Size(size.getWidth(), size.getHeight()));
            }
        }
        if (sizeMap.isEmpty()) {
            super.collectPictureSizes(sizeMap, streamConfigurationMap);
        }
    }
}
