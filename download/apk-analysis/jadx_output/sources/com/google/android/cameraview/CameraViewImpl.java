package com.google.android.cameraview;

import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.view.View;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
abstract class CameraViewImpl {
    protected final Callback mCallback;
    protected final PreviewImpl mPreview;

    interface Callback {
        void onCameraClosed();

        void onCameraOpened();

        void onFramePreview(byte[] bArr, int i, int i2, int i3);

        void onMountError();

        void onPictureTaken(byte[] bArr);

        void onVideoRecorded(String str);
    }

    abstract AspectRatio getAspectRatio();

    abstract boolean getAutoFocus();

    abstract SortedSet<Size> getAvailablePictureSizes(AspectRatio aspectRatio);

    abstract int getCameraId();

    abstract int getFacing();

    abstract int getFlash();

    abstract float getFocusDepth();

    abstract Size getPictureSize();

    public abstract Size getPreviewSize();

    abstract boolean getScanning();

    abstract Set<AspectRatio> getSupportedAspectRatios();

    abstract int getWhiteBalance();

    abstract float getZoom();

    abstract boolean isCameraOpened();

    public abstract void pausePreview();

    abstract boolean record(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile);

    public abstract void resumePreview();

    abstract boolean setAspectRatio(AspectRatio aspectRatio);

    abstract void setAutoFocus(boolean z);

    abstract void setDisplayOrientation(int i);

    abstract void setFacing(int i);

    abstract void setFlash(int i);

    abstract void setFocusDepth(float f);

    abstract void setPictureSize(Size size);

    public abstract void setPreviewTexture(SurfaceTexture surfaceTexture);

    abstract void setScanning(boolean z);

    abstract void setWhiteBalance(int i);

    abstract void setZoom(float f);

    abstract boolean start();

    abstract void stop();

    abstract void stopRecording();

    abstract void takePicture();

    CameraViewImpl(Callback callback, PreviewImpl previewImpl) {
        this.mCallback = callback;
        this.mPreview = previewImpl;
    }

    View getView() {
        return this.mPreview.getView();
    }
}
