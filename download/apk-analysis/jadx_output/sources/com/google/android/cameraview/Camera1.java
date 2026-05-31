package com.google.android.cameraview;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.SurfaceHolder;
import androidx.collection.SparseArrayCompat;
import com.canhub.cropper.CropImageOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.cameraview.CameraViewImpl;
import com.google.android.cameraview.PreviewImpl;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes.dex */
class Camera1 extends CameraViewImpl implements MediaRecorder.OnInfoListener, MediaRecorder.OnErrorListener, Camera.PreviewCallback {
    private static final SparseArrayCompat<String> FLASH_MODES;
    private static final int INVALID_CAMERA_ID = -1;
    private static final SparseArrayCompat<String> WB_MODES;
    private final AtomicBoolean isPictureCaptureInProgress;
    private AspectRatio mAspectRatio;
    private boolean mAutoFocus;
    Camera mCamera;
    private int mCameraId;
    private final Camera.CameraInfo mCameraInfo;
    private Camera.Parameters mCameraParameters;
    private int mDisplayOrientation;
    private int mFacing;
    private int mFlash;
    private boolean mIsPreviewActive;
    private boolean mIsRecording;
    private boolean mIsScanning;
    private MediaRecorder mMediaRecorder;
    private Size mPictureSize;
    private final SizeMap mPictureSizes;
    private final SizeMap mPreviewSizes;
    private SurfaceTexture mPreviewTexture;
    private boolean mShowingPreview;
    private String mVideoPath;
    private int mWhiteBalance;
    private float mZoom;

    private boolean isLandscape(int i) {
        return i == 90 || i == 270;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    float getFocusDepth() {
        return 0.0f;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void setFocusDepth(float f) {
    }

    static {
        SparseArrayCompat<String> sparseArrayCompat = new SparseArrayCompat<>();
        FLASH_MODES = sparseArrayCompat;
        sparseArrayCompat.put(0, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        sparseArrayCompat.put(1, "on");
        sparseArrayCompat.put(2, "torch");
        sparseArrayCompat.put(3, "auto");
        sparseArrayCompat.put(4, "red-eye");
        SparseArrayCompat<String> sparseArrayCompat2 = new SparseArrayCompat<>();
        WB_MODES = sparseArrayCompat2;
        sparseArrayCompat2.put(0, "auto");
        sparseArrayCompat2.put(1, "cloudy-daylight");
        sparseArrayCompat2.put(2, "daylight");
        sparseArrayCompat2.put(3, "shade");
        sparseArrayCompat2.put(4, "fluorescent");
        sparseArrayCompat2.put(5, "incandescent");
    }

    Camera1(CameraViewImpl.Callback callback, PreviewImpl previewImpl) {
        super(callback, previewImpl);
        this.isPictureCaptureInProgress = new AtomicBoolean(false);
        this.mCameraInfo = new Camera.CameraInfo();
        this.mPreviewSizes = new SizeMap();
        this.mIsPreviewActive = false;
        this.mPictureSizes = new SizeMap();
        previewImpl.setCallback(new PreviewImpl.Callback() { // from class: com.google.android.cameraview.Camera1.1
            @Override // com.google.android.cameraview.PreviewImpl.Callback
            public void onSurfaceChanged() {
                if (Camera1.this.mCamera != null) {
                    Camera1.this.setUpPreview();
                    Camera1.this.adjustCameraParameters();
                }
            }

            @Override // com.google.android.cameraview.PreviewImpl.Callback
            public void onSurfaceDestroyed() {
                Camera1.this.stop();
            }
        });
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    boolean start() {
        chooseCamera();
        if (!openCamera()) {
            this.mCallback.onMountError();
            return true;
        }
        if (this.mPreview.isReady()) {
            setUpPreview();
        }
        this.mShowingPreview = true;
        startCameraPreview();
        return true;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    void stop() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.stopPreview();
            this.mIsPreviewActive = false;
            this.mCamera.setPreviewCallback(null);
        }
        this.mShowingPreview = false;
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
            if (this.mIsRecording) {
                this.mCallback.onVideoRecorded(this.mVideoPath);
                this.mIsRecording = false;
            }
        }
        releaseCamera();
    }

    void setUpPreview() {
        try {
            SurfaceTexture surfaceTexture = this.mPreviewTexture;
            if (surfaceTexture != null) {
                this.mCamera.setPreviewTexture(surfaceTexture);
            } else if (this.mPreview.getOutputClass() == SurfaceHolder.class) {
                this.mCamera.setPreviewDisplay(this.mPreview.getSurfaceHolder());
            } else {
                this.mCamera.setPreviewTexture((SurfaceTexture) this.mPreview.getSurfaceTexture());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void startCameraPreview() {
        this.mCamera.startPreview();
        this.mIsPreviewActive = true;
        if (this.mIsScanning) {
            this.mCamera.setPreviewCallback(this);
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void resumePreview() {
        startCameraPreview();
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void pausePreview() {
        this.mCamera.stopPreview();
        this.mIsPreviewActive = false;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    boolean isCameraOpened() {
        return this.mCamera != null;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    void setFacing(int i) {
        if (this.mFacing == i) {
            return;
        }
        this.mFacing = i;
        if (isCameraOpened()) {
            stop();
            start();
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    int getFacing() {
        return this.mFacing;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    int getCameraId() {
        return this.mCameraId;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    Set<AspectRatio> getSupportedAspectRatios() {
        SizeMap sizeMap = this.mPreviewSizes;
        for (AspectRatio aspectRatio : sizeMap.ratios()) {
            if (this.mPictureSizes.sizes(aspectRatio) == null) {
                sizeMap.remove(aspectRatio);
            }
        }
        return sizeMap.ratios();
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    SortedSet<Size> getAvailablePictureSizes(AspectRatio aspectRatio) {
        return this.mPictureSizes.sizes(aspectRatio);
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    void setPictureSize(Size size) {
        if (size == null) {
            return;
        }
        this.mPictureSize = size;
        Camera.Parameters parameters = this.mCameraParameters;
        if (parameters == null || this.mCamera == null) {
            return;
        }
        parameters.setPictureSize(size.getWidth(), size.getHeight());
        this.mCamera.setParameters(this.mCameraParameters);
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    Size getPictureSize() {
        return this.mPictureSize;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    boolean setAspectRatio(AspectRatio aspectRatio) {
        if (this.mAspectRatio == null || !isCameraOpened()) {
            this.mAspectRatio = aspectRatio;
            return true;
        }
        if (this.mAspectRatio.equals(aspectRatio)) {
            return false;
        }
        if (this.mPreviewSizes.sizes(aspectRatio) == null) {
            throw new UnsupportedOperationException(aspectRatio + " is not supported");
        }
        this.mAspectRatio = aspectRatio;
        this.mPictureSize = this.mPictureSizes.sizes(aspectRatio).last();
        adjustCameraParameters();
        return true;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    AspectRatio getAspectRatio() {
        return this.mAspectRatio;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    void setAutoFocus(boolean z) {
        if (this.mAutoFocus != z && setAutoFocusInternal(z)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    boolean getAutoFocus() {
        if (!isCameraOpened()) {
            return this.mAutoFocus;
        }
        String focusMode = this.mCameraParameters.getFocusMode();
        return focusMode != null && focusMode.contains("continuous");
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    void setFlash(int i) {
        if (i != this.mFlash && setFlashInternal(i)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    int getFlash() {
        return this.mFlash;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    void setZoom(float f) {
        if (f != this.mZoom && setZoomInternal(f)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    float getZoom() {
        return this.mZoom;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void setWhiteBalance(int i) {
        if (i != this.mWhiteBalance && setWhiteBalanceInternal(i)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public int getWhiteBalance() {
        return this.mWhiteBalance;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    void setScanning(boolean z) {
        if (z == this.mIsScanning) {
            return;
        }
        setScanningInternal(z);
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    boolean getScanning() {
        return this.mIsScanning;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    void takePicture() {
        if (!isCameraOpened()) {
            throw new IllegalStateException("Camera is not ready. Call start() before takePicture().");
        }
        if (!this.mIsPreviewActive) {
            throw new IllegalStateException("Preview is paused - resume it before taking a picture.");
        }
        if (getAutoFocus()) {
            this.mCamera.cancelAutoFocus();
            this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.google.android.cameraview.Camera1.2
                @Override // android.hardware.Camera.AutoFocusCallback
                public void onAutoFocus(boolean z, Camera camera) {
                    Camera1.this.takePictureInternal();
                }
            });
        } else {
            takePictureInternal();
        }
    }

    void takePictureInternal() {
        if (this.isPictureCaptureInProgress.getAndSet(true)) {
            return;
        }
        this.mCamera.takePicture(null, null, null, new Camera.PictureCallback() { // from class: com.google.android.cameraview.Camera1.3
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                Camera1.this.isPictureCaptureInProgress.set(false);
                camera.cancelAutoFocus();
                camera.startPreview();
                Camera1.this.mIsPreviewActive = true;
                if (Camera1.this.mIsScanning) {
                    camera.setPreviewCallback(Camera1.this);
                }
                Camera1.this.mCallback.onPictureTaken(bArr);
            }
        });
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    boolean record(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        if (!this.mIsRecording) {
            setUpMediaRecorder(str, i, i2, z, camcorderProfile);
            try {
                this.mMediaRecorder.prepare();
                this.mMediaRecorder.start();
                this.mIsRecording = true;
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    void stopRecording() {
        if (this.mIsRecording) {
            stopMediaRecorder();
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.lock();
            }
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    void setDisplayOrientation(int i) {
        if (this.mDisplayOrientation == i) {
            return;
        }
        this.mDisplayOrientation = i;
        if (isCameraOpened()) {
            this.mCameraParameters.setRotation(calcCameraRotation(i));
            this.mCamera.setParameters(this.mCameraParameters);
            this.mCamera.setDisplayOrientation(calcDisplayOrientation(i));
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
        try {
            Camera camera = this.mCamera;
            if (camera == null) {
                this.mPreviewTexture = surfaceTexture;
                return;
            }
            camera.stopPreview();
            this.mIsPreviewActive = false;
            if (surfaceTexture == null) {
                this.mCamera.setPreviewTexture((SurfaceTexture) this.mPreview.getSurfaceTexture());
            } else {
                this.mCamera.setPreviewTexture(surfaceTexture);
            }
            this.mPreviewTexture = surfaceTexture;
            startCameraPreview();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.android.cameraview.CameraViewImpl
    public Size getPreviewSize() {
        Camera.Size previewSize = this.mCameraParameters.getPreviewSize();
        return new Size(previewSize.width, previewSize.height);
    }

    private void chooseCamera() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, this.mCameraInfo);
            if (this.mCameraInfo.facing == this.mFacing) {
                this.mCameraId = i;
                return;
            }
        }
        this.mCameraId = -1;
    }

    private boolean openCamera() {
        if (this.mCamera != null) {
            releaseCamera();
        }
        try {
            Camera open = Camera.open(this.mCameraId);
            this.mCamera = open;
            this.mCameraParameters = open.getParameters();
            this.mPreviewSizes.clear();
            for (Camera.Size size : this.mCameraParameters.getSupportedPreviewSizes()) {
                this.mPreviewSizes.add(new Size(size.width, size.height));
            }
            this.mPictureSizes.clear();
            for (Camera.Size size2 : this.mCameraParameters.getSupportedPictureSizes()) {
                this.mPictureSizes.add(new Size(size2.width, size2.height));
            }
            if (this.mAspectRatio == null) {
                this.mAspectRatio = Constants.DEFAULT_ASPECT_RATIO;
            }
            adjustCameraParameters();
            this.mCamera.setDisplayOrientation(calcDisplayOrientation(this.mDisplayOrientation));
            this.mCallback.onCameraOpened();
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    private AspectRatio chooseAspectRatio() {
        Iterator<AspectRatio> it = this.mPreviewSizes.ratios().iterator();
        AspectRatio aspectRatio = null;
        while (it.hasNext()) {
            aspectRatio = it.next();
            if (aspectRatio.equals(Constants.DEFAULT_ASPECT_RATIO)) {
                break;
            }
        }
        return aspectRatio;
    }

    void adjustCameraParameters() {
        SortedSet<Size> sizes = this.mPreviewSizes.sizes(this.mAspectRatio);
        if (sizes == null) {
            AspectRatio chooseAspectRatio = chooseAspectRatio();
            this.mAspectRatio = chooseAspectRatio;
            sizes = this.mPreviewSizes.sizes(chooseAspectRatio);
        }
        Size chooseOptimalSize = chooseOptimalSize(sizes);
        if (this.mPictureSize == null) {
            this.mPictureSize = this.mPictureSizes.sizes(this.mAspectRatio).last();
        }
        if (this.mShowingPreview) {
            this.mCamera.stopPreview();
            this.mIsPreviewActive = false;
        }
        this.mCameraParameters.setPreviewSize(chooseOptimalSize.getWidth(), chooseOptimalSize.getHeight());
        this.mCameraParameters.setPictureSize(this.mPictureSize.getWidth(), this.mPictureSize.getHeight());
        this.mCameraParameters.setRotation(calcCameraRotation(this.mDisplayOrientation));
        setAutoFocusInternal(this.mAutoFocus);
        setFlashInternal(this.mFlash);
        setAspectRatio(this.mAspectRatio);
        setZoomInternal(this.mZoom);
        setWhiteBalanceInternal(this.mWhiteBalance);
        setScanningInternal(this.mIsScanning);
        this.mCamera.setParameters(this.mCameraParameters);
        if (this.mShowingPreview) {
            startCameraPreview();
        }
    }

    private Size chooseOptimalSize(SortedSet<Size> sortedSet) {
        if (!this.mPreview.isReady()) {
            return sortedSet.first();
        }
        int width = this.mPreview.getWidth();
        int height = this.mPreview.getHeight();
        if (isLandscape(this.mDisplayOrientation)) {
            height = width;
            width = height;
        }
        Iterator<Size> it = sortedSet.iterator();
        Size size = null;
        while (it.hasNext()) {
            size = it.next();
            if (width <= size.getWidth() && height <= size.getHeight()) {
                break;
            }
        }
        return size;
    }

    private void releaseCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.release();
            this.mCamera = null;
            this.mPictureSize = null;
            this.mCallback.onCameraClosed();
        }
    }

    private int calcDisplayOrientation(int i) {
        if (this.mCameraInfo.facing == 1) {
            return (360 - ((this.mCameraInfo.orientation + i) % CropImageOptions.DEGREES_360)) % CropImageOptions.DEGREES_360;
        }
        return ((this.mCameraInfo.orientation - i) + CropImageOptions.DEGREES_360) % CropImageOptions.DEGREES_360;
    }

    private int calcCameraRotation(int i) {
        if (this.mCameraInfo.facing == 1) {
            return (this.mCameraInfo.orientation + i) % CropImageOptions.DEGREES_360;
        }
        return ((this.mCameraInfo.orientation + i) + (isLandscape(i) ? RotationOptions.ROTATE_180 : 0)) % CropImageOptions.DEGREES_360;
    }

    private boolean setAutoFocusInternal(boolean z) {
        this.mAutoFocus = z;
        if (!isCameraOpened()) {
            return false;
        }
        List<String> supportedFocusModes = this.mCameraParameters.getSupportedFocusModes();
        if (z && supportedFocusModes.contains("continuous-picture")) {
            this.mCameraParameters.setFocusMode("continuous-picture");
            return true;
        }
        if (supportedFocusModes.contains("fixed")) {
            this.mCameraParameters.setFocusMode("fixed");
            return true;
        }
        if (supportedFocusModes.contains("infinity")) {
            this.mCameraParameters.setFocusMode("infinity");
            return true;
        }
        this.mCameraParameters.setFocusMode(supportedFocusModes.get(0));
        return true;
    }

    private boolean setFlashInternal(int i) {
        if (isCameraOpened()) {
            List<String> supportedFlashModes = this.mCameraParameters.getSupportedFlashModes();
            SparseArrayCompat<String> sparseArrayCompat = FLASH_MODES;
            String str = sparseArrayCompat.get(i);
            if (supportedFlashModes != null && supportedFlashModes.contains(str)) {
                this.mCameraParameters.setFlashMode(str);
                this.mFlash = i;
                return true;
            }
            String str2 = sparseArrayCompat.get(this.mFlash);
            if (supportedFlashModes != null && supportedFlashModes.contains(str2)) {
                return false;
            }
            this.mCameraParameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            return true;
        }
        this.mFlash = i;
        return false;
    }

    private boolean setZoomInternal(float f) {
        if (isCameraOpened() && this.mCameraParameters.isZoomSupported()) {
            this.mCameraParameters.setZoom((int) (this.mCameraParameters.getMaxZoom() * f));
            this.mZoom = f;
            return true;
        }
        this.mZoom = f;
        return false;
    }

    private boolean setWhiteBalanceInternal(int i) {
        this.mWhiteBalance = i;
        if (!isCameraOpened()) {
            return false;
        }
        List<String> supportedWhiteBalance = this.mCameraParameters.getSupportedWhiteBalance();
        SparseArrayCompat<String> sparseArrayCompat = WB_MODES;
        String str = sparseArrayCompat.get(i);
        if (supportedWhiteBalance != null && supportedWhiteBalance.contains(str)) {
            this.mCameraParameters.setWhiteBalance(str);
            return true;
        }
        String str2 = sparseArrayCompat.get(this.mWhiteBalance);
        if (supportedWhiteBalance != null && supportedWhiteBalance.contains(str2)) {
            return false;
        }
        this.mCameraParameters.setWhiteBalance("auto");
        return true;
    }

    private void setScanningInternal(boolean z) {
        this.mIsScanning = z;
        if (isCameraOpened()) {
            if (this.mIsScanning) {
                this.mCamera.setPreviewCallback(this);
            } else {
                this.mCamera.setPreviewCallback(null);
            }
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Camera.Size previewSize = this.mCameraParameters.getPreviewSize();
        this.mCallback.onFramePreview(bArr, previewSize.width, previewSize.height, this.mDisplayOrientation);
    }

    private void setUpMediaRecorder(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        this.mMediaRecorder = new MediaRecorder();
        this.mCamera.unlock();
        this.mMediaRecorder.setCamera(this.mCamera);
        this.mMediaRecorder.setVideoSource(1);
        if (z) {
            this.mMediaRecorder.setAudioSource(5);
        }
        this.mMediaRecorder.setOutputFile(str);
        this.mVideoPath = str;
        if (CamcorderProfile.hasProfile(this.mCameraId, camcorderProfile.quality)) {
            setCamcorderProfile(CamcorderProfile.get(this.mCameraId, camcorderProfile.quality), z);
        } else {
            setCamcorderProfile(CamcorderProfile.get(this.mCameraId, 1), z);
        }
        this.mMediaRecorder.setOrientationHint(calcCameraRotation(this.mDisplayOrientation));
        if (i != -1) {
            this.mMediaRecorder.setMaxDuration(i);
        }
        if (i2 != -1) {
            this.mMediaRecorder.setMaxFileSize(i2);
        }
        this.mMediaRecorder.setOnInfoListener(this);
        this.mMediaRecorder.setOnErrorListener(this);
    }

    private void stopMediaRecorder() {
        this.mIsRecording = false;
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            this.mMediaRecorder.reset();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
        }
        if (this.mVideoPath == null || !new File(this.mVideoPath).exists()) {
            this.mCallback.onVideoRecorded(null);
        } else {
            this.mCallback.onVideoRecorded(this.mVideoPath);
            this.mVideoPath = null;
        }
    }

    private void setCamcorderProfile(CamcorderProfile camcorderProfile, boolean z) {
        this.mMediaRecorder.setOutputFormat(camcorderProfile.fileFormat);
        this.mMediaRecorder.setVideoFrameRate(camcorderProfile.videoFrameRate);
        this.mMediaRecorder.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        this.mMediaRecorder.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        this.mMediaRecorder.setVideoEncoder(camcorderProfile.videoCodec);
        if (z) {
            this.mMediaRecorder.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.mMediaRecorder.setAudioChannels(camcorderProfile.audioChannels);
            this.mMediaRecorder.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.mMediaRecorder.setAudioEncoder(camcorderProfile.audioCodec);
        }
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i == 800 || i == 801) {
            stopRecording();
        }
    }

    @Override // android.media.MediaRecorder.OnErrorListener
    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        stopRecording();
    }
}
