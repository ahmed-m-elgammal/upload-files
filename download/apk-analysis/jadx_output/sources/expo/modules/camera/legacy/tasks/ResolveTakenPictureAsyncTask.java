package expo.modules.camera.legacy.tasks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.camera.legacy.CameraViewHelper;
import expo.modules.camera.legacy.PictureOptions;
import expo.modules.camera.legacy.utils.FileSystemUtils;
import expo.modules.kotlin.Promise;
import io.sentry.protocol.Device;
import io.sentry.protocol.Response;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: ResolveTakenPictureAsyncTask.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0016H\u0002J(\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J'\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u001e\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\n\u0010!\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0014J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lexpo/modules/camera/legacy/tasks/ResolveTakenPictureAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Landroid/os/Bundle;", "imageData", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "options", "Lexpo/modules/camera/legacy/PictureOptions;", "directory", "Ljava/io/File;", "pictureSavedDelegate", "Lexpo/modules/camera/legacy/tasks/PictureSavedDelegate;", "([BLexpo/modules/kotlin/Promise;Lexpo/modules/camera/legacy/PictureOptions;Ljava/io/File;Lexpo/modules/camera/legacy/tasks/PictureSavedDelegate;)V", "quality", "", "getQuality", "()I", "decodeAndRotateBitmap", "Landroid/graphics/Bitmap;", "angle", "Landroid/graphics/BitmapFactory$Options;", "decodeBitmap", Device.JsonKeys.ORIENTATION, "exif", "", "bitmapOptions", "doInBackground", "params", "", "([Ljava/lang/Void;)Landroid/os/Bundle;", "getImageRotation", "handleSkipProcessing", "onPostExecute", "", Response.TYPE, "writeStreamToFile", "", "inputStream", "Ljava/io/ByteArrayOutputStream;", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResolveTakenPictureAsyncTask extends AsyncTask<Void, Void, Bundle> {
    private final File directory;
    private byte[] imageData;
    private PictureOptions options;
    private PictureSavedDelegate pictureSavedDelegate;
    private Promise promise;

    private final int getImageRotation(int orientation) {
        if (orientation == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (orientation != 6) {
            return orientation != 8 ? 0 : 270;
        }
        return 90;
    }

    public ResolveTakenPictureAsyncTask(byte[] imageData, Promise promise, PictureOptions options, File directory, PictureSavedDelegate pictureSavedDelegate) {
        Intrinsics.checkNotNullParameter(imageData, "imageData");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(pictureSavedDelegate, "pictureSavedDelegate");
        this.imageData = imageData;
        this.promise = promise;
        this.options = options;
        this.directory = directory;
        this.pictureSavedDelegate = pictureSavedDelegate;
    }

    private final int getQuality() {
        return (int) (this.options.getQuality() * 100);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [T, android.graphics.Bitmap] */
    @Override // android.os.AsyncTask
    public Bundle doInBackground(Void... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.options.getSkipProcessing()) {
            return handleSkipProcessing();
        }
        try {
            ByteArrayOutputStream byteArrayInputStream = new ByteArrayInputStream(this.imageData);
            try {
                Bundle bundle = new Bundle();
                ExifInterface exifInterface = new ExifInterface(byteArrayInputStream);
                Map<String, Object> additionalExif = this.options.getAdditionalExif();
                if (additionalExif != null) {
                    CameraViewHelper.setExifData(exifInterface, additionalExif);
                }
                int attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                OutOfMemoryError outOfMemoryError = null;
                while (options.inSampleSize <= this.options.getMaxDownsampling()) {
                    try {
                        objectRef.element = decodeBitmap(this.imageData, attributeInt, this.options.getExif(), options);
                        break;
                    } catch (OutOfMemoryError e) {
                        options.inSampleSize *= 2;
                        outOfMemoryError = e;
                    }
                }
                if (objectRef.element == 0) {
                    this.promise.reject("ERR_CAMERA_OUT_OF_MEMORY", "Cannot allocate enough space to process the taken picture.", outOfMemoryError);
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                    return null;
                }
                if (this.options.getExif()) {
                    bundle.putBundle("exif", CameraViewHelper.getExifData(exifInterface));
                }
                bundle.putInt("width", ((Bitmap) objectRef.element).getWidth());
                bundle.putInt("height", ((Bitmap) objectRef.element).getHeight());
                byteArrayInputStream = new ByteArrayOutputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = byteArrayInputStream;
                    ((Bitmap) objectRef.element).compress(Bitmap.CompressFormat.JPEG, getQuality(), byteArrayOutputStream);
                    String writeStreamToFile = writeStreamToFile(byteArrayOutputStream);
                    if (this.options.getExif()) {
                        Intrinsics.checkNotNull(writeStreamToFile);
                        CameraViewHelper.addExifData(new ExifInterface(writeStreamToFile), exifInterface);
                    }
                    String uri = Uri.fromFile(new File(writeStreamToFile)).toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                    bundle.putString("uri", uri);
                    if (this.options.getBase64()) {
                        bundle.putString("base64", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                    return bundle;
                } finally {
                }
            } finally {
            }
        } catch (Exception e2) {
            if (e2 instanceof Resources.NotFoundException) {
                this.promise.reject("E_TAKING_PICTURE_FAILED", "Documents directory of the app could not be found.", e2);
            } else if (e2 instanceof IOException) {
                this.promise.reject("E_TAKING_PICTURE_FAILED", "An unknown I/O exception has occurred.", e2);
            } else if (e2 instanceof IllegalArgumentException) {
                this.promise.reject("E_TAKING_PICTURE_FAILED", "An incompatible parameter has been passed in. ", e2);
            } else {
                this.promise.reject("E_TAKING_PICTURE_FAILED", "An unknown exception has occurred.", e2);
            }
            e2.printStackTrace();
            return null;
        }
    }

    private final Bundle handleSkipProcessing() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                byteArrayOutputStream2.write(this.imageData);
                String writeStreamToFile = writeStreamToFile(byteArrayOutputStream2);
                String uri = Uri.fromFile(new File(writeStreamToFile)).toString();
                Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                Intrinsics.checkNotNull(writeStreamToFile);
                ExifInterface exifInterface = new ExifInterface(writeStreamToFile);
                Bundle bundle = new Bundle();
                bundle.putString("uri", uri);
                bundle.putInt("width", exifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, -1));
                bundle.putInt("height", exifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, -1));
                if (this.options.getExif()) {
                    bundle.putBundle("exif", CameraViewHelper.getExifData(exifInterface));
                }
                if (this.options.getBase64()) {
                    bundle.putString("base64", Base64.encodeToString(this.imageData, 2));
                }
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                return bundle;
            } finally {
            }
        } catch (Exception e) {
            if (e instanceof IOException) {
                this.promise.reject("E_TAKING_PICTURE_FAILED", "An unknown I/O exception has occurred.", e);
            } else {
                this.promise.reject("E_TAKING_PICTURE_FAILED", "An unknown exception has occurred.", e);
            }
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Bundle response) {
        super.onPostExecute((ResolveTakenPictureAsyncTask) response);
        if (response != null) {
            if (this.options.getFastMode()) {
                Bundle bundle = new Bundle();
                Integer id = this.options.getId();
                if (id == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                bundle.putInt("id", id.intValue());
                bundle.putBundle("data", response);
                this.pictureSavedDelegate.onPictureSaved(bundle);
                return;
            }
            this.promise.resolve(response);
        }
    }

    private final String writeStreamToFile(ByteArrayOutputStream inputStream) throws Exception {
        try {
            String generateOutputPath = FileSystemUtils.INSTANCE.generateOutputPath(this.directory, "Camera", ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(generateOutputPath);
            try {
                inputStream.writeTo(fileOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                return generateOutputPath;
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private final Bitmap decodeBitmap(byte[] imageData, int orientation, boolean exif, BitmapFactory.Options bitmapOptions) {
        if (!exif) {
            return decodeAndRotateBitmap(imageData, getImageRotation(orientation), bitmapOptions);
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(imageData, 0, imageData.length, bitmapOptions);
        Intrinsics.checkNotNull(decodeByteArray);
        return decodeByteArray;
    }

    private final Bitmap decodeAndRotateBitmap(byte[] imageData, int angle, BitmapFactory.Options options) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(imageData, 0, imageData.length, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }
}
