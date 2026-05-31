package expo.modules.camera;

import android.graphics.drawable.ColorDrawable;
import android.media.MediaActionSound;
import android.view.View;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import expo.modules.camera.CameraExceptions;
import expo.modules.camera.analyzers.BarcodeAnalyzerKt;
import expo.modules.kotlin.Promise;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ExpoCameraView.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"expo/modules/camera/ExpoCameraView$takePicture$1", "Landroidx/camera/core/ImageCapture$OnImageCapturedCallback;", "onCaptureStarted", "", "onCaptureSuccess", "image", "Landroidx/camera/core/ImageProxy;", "onError", "exception", "Landroidx/camera/core/ImageCaptureException;", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpoCameraView$takePicture$1 extends ImageCapture.OnImageCapturedCallback {
    final /* synthetic */ File $cacheDirectory;
    final /* synthetic */ PictureOptions $options;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ int $volume;
    final /* synthetic */ ExpoCameraView this$0;

    ExpoCameraView$takePicture$1(int i, ExpoCameraView expoCameraView, PictureOptions pictureOptions, Promise promise, File file) {
        this.$volume = i;
        this.this$0 = expoCameraView;
        this.$options = pictureOptions;
        this.$promise = promise;
        this.$cacheDirectory = file;
    }

    @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
    public void onCaptureStarted() {
        if (this.$volume != 0) {
            new MediaActionSound().play(0);
        }
        if (this.this$0.getAnimateShutter()) {
            View rootView = this.this$0.getRootView();
            final ExpoCameraView expoCameraView = this.this$0;
            rootView.postDelayed(new Runnable() { // from class: expo.modules.camera.ExpoCameraView$takePicture$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ExpoCameraView$takePicture$1.onCaptureStarted$lambda$1(ExpoCameraView.this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCaptureStarted$lambda$1(final ExpoCameraView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getRootView().setForeground(new ColorDrawable(-1));
        this$0.getRootView().postDelayed(new Runnable() { // from class: expo.modules.camera.ExpoCameraView$takePicture$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ExpoCameraView$takePicture$1.onCaptureStarted$lambda$1$lambda$0(ExpoCameraView.this);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCaptureStarted$lambda$1$lambda$0(ExpoCameraView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getRootView().setForeground(null);
    }

    @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
    public void onCaptureSuccess(ImageProxy image) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(image, "image");
        ImageProxy.PlaneProxy[] planes = image.getPlanes();
        Intrinsics.checkNotNullExpressionValue(planes, "getPlanes(...)");
        byte[] byteArray = BarcodeAnalyzerKt.toByteArray(planes);
        if (this.$options.getFastMode()) {
            this.$promise.resolve((Object) null);
        }
        File file = this.$cacheDirectory;
        ExpoCameraView expoCameraView = this.this$0;
        Promise promise = this.$promise;
        PictureOptions pictureOptions = this.$options;
        coroutineScope = expoCameraView.scope;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ExpoCameraView$takePicture$1$onCaptureSuccess$1$1(expoCameraView, byteArray, promise, pictureOptions, file, null), 3, null);
        image.close();
    }

    @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
    public void onError(ImageCaptureException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.$promise.reject(new CameraExceptions.ImageCaptureFailed());
    }
}
