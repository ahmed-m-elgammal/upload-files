package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import androidx.camera.extensions.impl.ProcessResultImpl;
import androidx.camera.extensions.internal.Camera2CameraCaptureResult;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.Version;
import androidx.camera.extensions.internal.sessionprocessor.CaptureResultImageMatcher;
import androidx.camera.extensions.internal.sessionprocessor.YuvToJpegConverter;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class StillCaptureProcessor {
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "StillCaptureProcessor";
    final CaptureProcessorImpl mCaptureProcessorImpl;
    final CaptureResultImageMatcher mCaptureResultImageMatcher;
    HashMap<Integer, Pair<ImageReference, TotalCaptureResult>> mCaptureResults;
    boolean mIsClosed;
    private boolean mIsPostviewConfigured;
    final Object mLock;
    OnCaptureResultCallback mOnCaptureResultCallback;
    final ImageReaderProxy mProcessedYuvImageReader;
    TotalCaptureResult mSourceCaptureResult;
    YuvToJpegConverter mYuvToJpegConverter;

    interface OnCaptureResultCallback {
        void onCaptureProcessProgressed(int i);

        void onCaptureResult(long j, List<Pair<CaptureResult.Key, Object>> list);

        void onCompleted();

        void onError(Exception exc);
    }

    StillCaptureProcessor(CaptureProcessorImpl captureProcessorImpl, Surface surface, Size size, OutputSurface outputSurface) {
        this.mCaptureResultImageMatcher = new CaptureResultImageMatcher();
        this.mLock = new Object();
        this.mCaptureResults = new HashMap<>();
        this.mOnCaptureResultCallback = null;
        this.mSourceCaptureResult = null;
        this.mIsClosed = false;
        this.mCaptureProcessorImpl = captureProcessorImpl;
        ImageReaderProxy createIsolatedReader = ImageReaderProxys.createIsolatedReader(size.getWidth(), size.getHeight(), 35, 2);
        this.mProcessedYuvImageReader = createIsolatedReader;
        this.mYuvToJpegConverter = new YuvToJpegConverter(100, surface);
        createIsolatedReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$$ExternalSyntheticLambda1
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                StillCaptureProcessor.this.m242xba518613(imageReaderProxy);
            }
        }, CameraXExecutors.ioExecutor());
        captureProcessorImpl.onOutputSurface(createIsolatedReader.getSurface(), 35);
        captureProcessorImpl.onImageFormatUpdate(35);
        this.mIsPostviewConfigured = outputSurface != null;
        if (outputSurface != null && ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) && ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_4)) {
            Preconditions.checkArgument(outputSurface.getImageFormat() == 35);
            captureProcessorImpl.onResolutionUpdate(size, outputSurface.getSize());
            captureProcessorImpl.onPostviewOutputSurface(outputSurface.getSurface());
            return;
        }
        captureProcessorImpl.onResolutionUpdate(size);
    }

    /* renamed from: lambda$new$0$androidx-camera-extensions-internal-sessionprocessor-StillCaptureProcessor, reason: not valid java name */
    /* synthetic */ void m242xba518613(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            if (this.mIsClosed) {
                Logger.d(TAG, "Ignore JPEG processing in closed state");
                return;
            }
            ImageProxy acquireNextImage = imageReaderProxy.acquireNextImage();
            OnCaptureResultCallback onCaptureResultCallback = null;
            if (this.mSourceCaptureResult != null) {
                SettableImageProxy settableImageProxy = new SettableImageProxy(acquireNextImage, null, new CameraCaptureResultImageInfo(new Camera2CameraCaptureResult(this.mSourceCaptureResult)));
                this.mSourceCaptureResult = null;
                acquireNextImage = settableImageProxy;
            }
            Logger.d(TAG, "Start converting YUV to JPEG");
            if (acquireNextImage != null) {
                try {
                    this.mYuvToJpegConverter.writeYuvImage(acquireNextImage);
                    e = null;
                } catch (YuvToJpegConverter.ConversionFailedException e) {
                    e = e;
                }
                OnCaptureResultCallback onCaptureResultCallback2 = this.mOnCaptureResultCallback;
                if (onCaptureResultCallback2 != null) {
                    this.mOnCaptureResultCallback = null;
                    onCaptureResultCallback = onCaptureResultCallback2;
                }
            } else {
                e = null;
            }
            if (onCaptureResultCallback != null) {
                if (e != null) {
                    onCaptureResultCallback.onError(e);
                } else {
                    onCaptureResultCallback.onCompleted();
                }
            }
        }
    }

    StillCaptureProcessor(CaptureProcessorImpl captureProcessorImpl, Surface surface, Size size, OutputSurface outputSurface, YuvToJpegConverter yuvToJpegConverter) {
        this(captureProcessorImpl, surface, size, outputSurface);
        this.mYuvToJpegConverter = yuvToJpegConverter;
    }

    void clearCaptureResults() {
        synchronized (this.mLock) {
            Iterator<Pair<ImageReference, TotalCaptureResult>> it = this.mCaptureResults.values().iterator();
            while (it.hasNext()) {
                ((ImageReference) it.next().first).decrement();
            }
            this.mCaptureResults.clear();
        }
    }

    void startCapture(final boolean z, final List<Integer> list, final OnCaptureResultCallback onCaptureResultCallback) {
        Logger.d(TAG, "Start the capture: enablePostview=" + z);
        synchronized (this.mLock) {
            Preconditions.checkState(!this.mIsClosed, "StillCaptureProcessor is closed. Can't invoke startCapture()");
            this.mOnCaptureResultCallback = onCaptureResultCallback;
            clearCaptureResults();
        }
        this.mCaptureResultImageMatcher.clear();
        this.mCaptureResultImageMatcher.setImageReferenceListener(new CaptureResultImageMatcher.ImageReferenceListener() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$$ExternalSyntheticLambda2
            @Override // androidx.camera.extensions.internal.sessionprocessor.CaptureResultImageMatcher.ImageReferenceListener
            public final void onImageReferenceIncoming(ImageReference imageReference, TotalCaptureResult totalCaptureResult, int i) {
                StillCaptureProcessor.this.m244xfcf99534(list, onCaptureResultCallback, z, imageReference, totalCaptureResult, i);
            }
        });
    }

    /* renamed from: lambda$startCapture$1$androidx-camera-extensions-internal-sessionprocessor-StillCaptureProcessor, reason: not valid java name */
    /* synthetic */ void m244xfcf99534(List list, OnCaptureResultCallback onCaptureResultCallback, boolean z, ImageReference imageReference, TotalCaptureResult totalCaptureResult, int i) {
        synchronized (this.mLock) {
            if (this.mIsClosed) {
                imageReference.decrement();
                Logger.d(TAG, "Ignore image in closed state");
                return;
            }
            Logger.d(TAG, "onImageReferenceIncoming  captureStageId=" + i);
            this.mCaptureResults.put(Integer.valueOf(i), new Pair<>(imageReference, totalCaptureResult));
            Logger.d(TAG, "mCaptureResult has capture stage Id: " + this.mCaptureResults.keySet());
            if (this.mCaptureResults.keySet().containsAll(list)) {
                process(this.mCaptureResults, onCaptureResultCallback, z);
            }
        }
    }

    void process(Map<Integer, Pair<ImageReference, TotalCaptureResult>> map, final OnCaptureResultCallback onCaptureResultCallback, final boolean z) {
        final HashMap hashMap = new HashMap();
        synchronized (this.mLock) {
            for (Integer num : map.keySet()) {
                Pair<ImageReference, TotalCaptureResult> pair = map.get(num);
                hashMap.put(num, new Pair(((ImageReference) pair.first).get(), (TotalCaptureResult) pair.second));
            }
        }
        CameraXExecutors.ioExecutor().execute(new Runnable() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StillCaptureProcessor.this.m243x1a3405e2(z, hashMap, onCaptureResultCallback);
            }
        });
    }

    /* renamed from: lambda$process$2$androidx-camera-extensions-internal-sessionprocessor-StillCaptureProcessor, reason: not valid java name */
    /* synthetic */ void m243x1a3405e2(boolean z, HashMap hashMap, final OnCaptureResultCallback onCaptureResultCallback) {
        synchronized (this.mLock) {
            try {
                try {
                } catch (Exception e) {
                    Logger.e(TAG, "mCaptureProcessorImpl.process exception ", e);
                    this.mOnCaptureResultCallback = null;
                    if (onCaptureResultCallback != null) {
                        onCaptureResultCallback.onError(e);
                    }
                    Logger.d(TAG, "CaptureProcessorImpl.process() finish");
                }
                if (this.mIsClosed) {
                    Logger.d(TAG, "Ignore process() in closed state.");
                    return;
                }
                Logger.d(TAG, "CaptureProcessorImpl.process() begin");
                if (ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) && ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) && z && this.mIsPostviewConfigured) {
                    this.mCaptureProcessorImpl.processWithPostview(hashMap, new ProcessResultImpl() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.1
                        public void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list) {
                            onCaptureResultCallback.onCaptureResult(j, list);
                        }

                        public void onCaptureProcessProgressed(int i) {
                            onCaptureResultCallback.onCaptureProcessProgressed(i);
                        }
                    }, CameraXExecutors.directExecutor());
                } else if (ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_3) && ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_3)) {
                    this.mCaptureProcessorImpl.process(hashMap, new ProcessResultImpl() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.2
                        public void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list) {
                            onCaptureResultCallback.onCaptureResult(j, list);
                        }

                        public void onCaptureProcessProgressed(int i) {
                            onCaptureResultCallback.onCaptureProcessProgressed(i);
                        }
                    }, CameraXExecutors.directExecutor());
                } else {
                    this.mCaptureProcessorImpl.process(hashMap);
                }
                Logger.d(TAG, "CaptureProcessorImpl.process() finish");
                clearCaptureResults();
            } finally {
                Logger.d(TAG, "CaptureProcessorImpl.process() finish");
                clearCaptureResults();
            }
        }
    }

    void notifyCaptureResult(TotalCaptureResult totalCaptureResult, int i) {
        this.mCaptureResultImageMatcher.captureResultIncoming(totalCaptureResult, i);
        synchronized (this.mLock) {
            if (this.mSourceCaptureResult == null) {
                this.mSourceCaptureResult = totalCaptureResult;
            }
        }
    }

    void notifyImage(ImageReference imageReference) {
        this.mCaptureResultImageMatcher.imageIncoming(imageReference);
    }

    void setJpegQuality(int i) {
        this.mYuvToJpegConverter.setJpegQuality(i);
    }

    void setRotationDegrees(int i) {
        this.mYuvToJpegConverter.setRotationDegrees(i);
    }

    void close() {
        synchronized (this.mLock) {
            Logger.d(TAG, "Close the StillCaptureProcessor");
            this.mIsClosed = true;
            clearCaptureResults();
            this.mProcessedYuvImageReader.clearOnImageAvailableListener();
            this.mCaptureResultImageMatcher.clearImageReferenceListener();
            this.mCaptureResultImageMatcher.clear();
            this.mProcessedYuvImageReader.close();
        }
    }
}
