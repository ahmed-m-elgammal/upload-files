package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.LongSparseArray;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class CaptureResultImageMatcher {
    private static final int INVALID_TIMESTAMP = -1;
    ImageReferenceListener mImageReferenceListener;
    private final Object mLock = new Object();
    private final LongSparseArray<List<TotalCaptureResult>> mPendingCaptureResults = new LongSparseArray<>();
    Map<TotalCaptureResult, Integer> mCaptureStageIdMap = new HashMap();
    private final LongSparseArray<List<ImageReference>> mPendingImages = new LongSparseArray<>();

    interface ImageReferenceListener {
        void onImageReferenceIncoming(ImageReference imageReference, TotalCaptureResult totalCaptureResult, int i);
    }

    CaptureResultImageMatcher() {
    }

    void clear() {
        synchronized (this.mLock) {
            this.mPendingCaptureResults.clear();
            for (int i = 0; i < this.mPendingImages.size(); i++) {
                Iterator<ImageReference> it = this.mPendingImages.get(this.mPendingImages.keyAt(i)).iterator();
                while (it.hasNext()) {
                    it.next().decrement();
                }
            }
            this.mPendingImages.clear();
            this.mCaptureStageIdMap.clear();
        }
    }

    void setImageReferenceListener(ImageReferenceListener imageReferenceListener) {
        synchronized (this.mLock) {
            this.mImageReferenceListener = imageReferenceListener;
        }
    }

    void clearImageReferenceListener() {
        synchronized (this.mLock) {
            this.mImageReferenceListener = null;
        }
    }

    void imageIncoming(ImageReference imageReference) {
        synchronized (this.mLock) {
            addToList(this.mPendingImages, imageReference.get().getTimestamp(), imageReference);
        }
        matchImages();
    }

    private <T> void addToList(LongSparseArray<List<T>> longSparseArray, long j, T t) {
        List<T> list = longSparseArray.get(j);
        if (list == null) {
            list = new ArrayList<>();
            longSparseArray.put(j, list);
        }
        list.add(t);
    }

    private <T> void removeFromList(LongSparseArray<List<T>> longSparseArray, long j, T t) {
        List<T> list = longSparseArray.get(j);
        if (list != null) {
            list.remove(t);
            if (list.isEmpty()) {
                longSparseArray.remove(j);
            }
        }
    }

    void captureResultIncoming(TotalCaptureResult totalCaptureResult) {
        captureResultIncoming(totalCaptureResult, 0);
    }

    void captureResultIncoming(TotalCaptureResult totalCaptureResult, int i) {
        synchronized (this.mLock) {
            long timeStampFromCaptureResult = getTimeStampFromCaptureResult(totalCaptureResult);
            if (timeStampFromCaptureResult == -1) {
                return;
            }
            addToList(this.mPendingCaptureResults, timeStampFromCaptureResult, totalCaptureResult);
            this.mCaptureStageIdMap.put(totalCaptureResult, Integer.valueOf(i));
            matchImages();
        }
    }

    private long getTimeStampFromCaptureResult(TotalCaptureResult totalCaptureResult) {
        Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l != null) {
            return l.longValue();
        }
        return -1L;
    }

    private void notifyImage(ImageReference imageReference, TotalCaptureResult totalCaptureResult) {
        ImageReferenceListener imageReferenceListener;
        Integer num;
        synchronized (this.mLock) {
            imageReferenceListener = this.mImageReferenceListener;
            if (imageReferenceListener != null) {
                num = this.mCaptureStageIdMap.get(totalCaptureResult);
            } else {
                imageReference.decrement();
                imageReferenceListener = null;
                num = null;
            }
        }
        if (imageReferenceListener != null) {
            imageReferenceListener.onImageReferenceIncoming(imageReference, totalCaptureResult, num.intValue());
        }
    }

    private void removeStaleData() {
        synchronized (this.mLock) {
            if (this.mPendingImages.size() != 0 && this.mPendingCaptureResults.size() != 0) {
                long keyAt = this.mPendingImages.keyAt(0);
                Long valueOf = Long.valueOf(keyAt);
                long keyAt2 = this.mPendingCaptureResults.keyAt(0);
                Long valueOf2 = Long.valueOf(keyAt2);
                Preconditions.checkArgument(!valueOf2.equals(valueOf));
                valueOf2.getClass();
                valueOf.getClass();
                if (keyAt2 > keyAt) {
                    for (int size = this.mPendingImages.size() - 1; size >= 0; size--) {
                        long keyAt3 = this.mPendingImages.keyAt(size);
                        valueOf2.getClass();
                        if (keyAt3 < keyAt2) {
                            Iterator<ImageReference> it = this.mPendingImages.valueAt(size).iterator();
                            while (it.hasNext()) {
                                it.next().decrement();
                            }
                            this.mPendingImages.removeAt(size);
                        }
                    }
                } else {
                    for (int size2 = this.mPendingCaptureResults.size() - 1; size2 >= 0; size2--) {
                        long keyAt4 = this.mPendingCaptureResults.keyAt(size2);
                        valueOf.getClass();
                        if (keyAt4 < keyAt) {
                            this.mPendingCaptureResults.removeAt(size2);
                        }
                    }
                }
            }
        }
    }

    private void matchImages() {
        TotalCaptureResult totalCaptureResult;
        ImageReference imageReference;
        synchronized (this.mLock) {
            int size = this.mPendingCaptureResults.size() - 1;
            while (true) {
                if (size < 0) {
                    totalCaptureResult = null;
                    imageReference = null;
                    break;
                }
                List<TotalCaptureResult> valueAt = this.mPendingCaptureResults.valueAt(size);
                if (!valueAt.isEmpty()) {
                    totalCaptureResult = valueAt.get(0);
                    long timeStampFromCaptureResult = getTimeStampFromCaptureResult(totalCaptureResult);
                    Preconditions.checkState(timeStampFromCaptureResult == this.mPendingCaptureResults.keyAt(size));
                    List<ImageReference> list = this.mPendingImages.get(timeStampFromCaptureResult);
                    if (list != null && !list.isEmpty()) {
                        imageReference = list.get(0);
                        removeFromList(this.mPendingImages, timeStampFromCaptureResult, imageReference);
                        valueAt.remove(totalCaptureResult);
                        if (valueAt.isEmpty()) {
                            this.mPendingCaptureResults.removeAt(size);
                        }
                    }
                }
                size--;
            }
            removeStaleData();
        }
        if (imageReference == null || totalCaptureResult == null) {
            return;
        }
        notifyImage(imageReference, totalCaptureResult);
    }
}
