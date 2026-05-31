package androidx.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.internal.ScreenFlashUiInfo;

/* loaded from: classes.dex */
public final class ScreenFlashView extends View {
    private static final String TAG = "ScreenFlashView";
    private CameraController mCameraController;
    private ImageCapture.ScreenFlash mScreenFlash;
    private Window mScreenFlashWindow;

    public ScreenFlashView(Context context) {
        this(context, null);
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setBackgroundColor(-1);
        setAlpha(0.0f);
        setElevation(Float.MAX_VALUE);
    }

    public void setController(CameraController cameraController) {
        Threads.checkMainThread();
        CameraController cameraController2 = this.mCameraController;
        if (cameraController2 != null && cameraController2 != cameraController) {
            setScreenFlashUiInfo(null);
        }
        this.mCameraController = cameraController;
        if (cameraController == null) {
            return;
        }
        if (cameraController.getImageCaptureFlashMode() == 3 && this.mScreenFlashWindow == null) {
            throw new IllegalStateException("No window set despite setting FLASH_MODE_SCREEN in CameraController");
        }
        setScreenFlashUiInfo(getScreenFlash());
    }

    private void setScreenFlashUiInfo(ImageCapture.ScreenFlash screenFlash) {
        CameraController cameraController = this.mCameraController;
        if (cameraController == null) {
            Logger.d(TAG, "setScreenFlashUiInfo: mCameraController is null!");
        } else {
            cameraController.setScreenFlashUiInfo(new ScreenFlashUiInfo(ScreenFlashUiInfo.ProviderType.SCREEN_FLASH_VIEW, screenFlash));
        }
    }

    public void setScreenFlashWindow(Window window) {
        Threads.checkMainThread();
        updateScreenFlash(window);
        this.mScreenFlashWindow = window;
        setScreenFlashUiInfo(getScreenFlash());
    }

    private void updateScreenFlash(Window window) {
        if (this.mScreenFlashWindow != window) {
            this.mScreenFlash = window == null ? null : new ImageCapture.ScreenFlash() { // from class: androidx.camera.view.ScreenFlashView.1
                private float mPreviousBrightness;

                @Override // androidx.camera.core.ImageCapture.ScreenFlash
                public void apply(long j, ImageCapture.ScreenFlashListener screenFlashListener) {
                    Logger.d(ScreenFlashView.TAG, "ScreenFlash#apply");
                    ScreenFlashView.this.setAlpha(1.0f);
                    WindowManager.LayoutParams attributes = ScreenFlashView.this.mScreenFlashWindow.getAttributes();
                    this.mPreviousBrightness = attributes.screenBrightness;
                    attributes.screenBrightness = 1.0f;
                    ScreenFlashView.this.mScreenFlashWindow.setAttributes(attributes);
                    screenFlashListener.onCompleted();
                }

                @Override // androidx.camera.core.ImageCapture.ScreenFlash
                public void clear() {
                    Logger.d(ScreenFlashView.TAG, "ScreenFlash#clearScreenFlashUi");
                    ScreenFlashView.this.setAlpha(0.0f);
                    WindowManager.LayoutParams attributes = ScreenFlashView.this.mScreenFlashWindow.getAttributes();
                    attributes.screenBrightness = this.mPreviousBrightness;
                    ScreenFlashView.this.mScreenFlashWindow.setAttributes(attributes);
                }
            };
        }
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return this.mScreenFlash;
    }
}
