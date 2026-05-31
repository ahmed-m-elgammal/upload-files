package fr.greweb.reactnativeviewshot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.PixelCopy;
import android.view.PixelCopy$OnPixelCopyFinishedListener;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class ViewShot implements UIBlock {
    private static final int ARGB_SIZE = 4;
    public static final String ERROR_UNABLE_TO_SNAPSHOT = "E_UNABLE_TO_SNAPSHOT";
    private static final int PREALLOCATE_SIZE = 65536;
    private static final int SURFACE_VIEW_READ_PIXELS_TIMEOUT = 5;
    private static final String TAG = "ViewShot";
    private final Activity currentActivity;
    private final Executor executor;
    private final String extension;
    private final int format;
    private final boolean handleGLSurfaceView;
    private final Integer height;
    private final File output;
    private final Promise promise;
    private final double quality;
    private final ReactApplicationContext reactContext;
    private final String result;
    private final Boolean snapshotContentContainer;
    private final int tag;
    private final Integer width;
    private static byte[] outputBuffer = new byte[65536];
    private static final Object guardBitmaps = new Object();
    private static final Set<Bitmap> weakBitmaps = Collections.newSetFromMap(new WeakHashMap());

    public @interface Formats {
        public static final int JPEG = 0;
        public static final int PNG = 1;
        public static final int RAW = -1;
        public static final int WEBP = 2;
        public static final Bitmap.CompressFormat[] mapping = {Bitmap.CompressFormat.JPEG, Bitmap.CompressFormat.PNG, Bitmap.CompressFormat.WEBP};
    }

    public @interface Results {
        public static final String BASE_64 = "base64";
        public static final String DATA_URI = "data-uri";
        public static final String TEMP_FILE = "tmpfile";
        public static final String ZIP_BASE_64 = "zip-base64";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends A, A> T cast(A a2) {
        return a2;
    }

    public ViewShot(int i, String str, int i2, double d, @Nullable Integer num, @Nullable Integer num2, File file, String str2, Boolean bool, ReactApplicationContext reactApplicationContext, Activity activity, boolean z, Promise promise, Executor executor) {
        this.tag = i;
        this.extension = str;
        this.format = i2;
        this.quality = d;
        this.width = num;
        this.height = num2;
        this.output = file;
        this.result = str2;
        this.snapshotContentContainer = bool;
        this.reactContext = reactApplicationContext;
        this.currentActivity = activity;
        this.handleGLSurfaceView = z;
        this.promise = promise;
        this.executor = executor;
    }

    @Override // com.facebook.react.uimanager.UIBlock
    public void execute(final NativeViewHierarchyManager nativeViewHierarchyManager) {
        this.executor.execute(new Runnable() { // from class: fr.greweb.reactnativeviewshot.ViewShot.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    View findViewById = ViewShot.this.tag == -1 ? ViewShot.this.currentActivity.getWindow().getDecorView().findViewById(android.R.id.content) : nativeViewHierarchyManager.resolveView(ViewShot.this.tag);
                    if (findViewById == null) {
                        Log.e(ViewShot.TAG, "No view found with reactTag: " + ViewShot.this.tag, new AssertionError());
                        ViewShot.this.promise.reject(ViewShot.ERROR_UNABLE_TO_SNAPSHOT, "No view found with reactTag: " + ViewShot.this.tag);
                        return;
                    }
                    ReusableByteArrayOutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(ViewShot.outputBuffer);
                    reusableByteArrayOutputStream.setSize(ViewShot.proposeSize(findViewById));
                    ViewShot.outputBuffer = reusableByteArrayOutputStream.innerBuffer();
                    if (Results.TEMP_FILE.equals(ViewShot.this.result) && -1 == ViewShot.this.format) {
                        ViewShot.this.saveToRawFileOnDevice(findViewById);
                        return;
                    }
                    if (Results.TEMP_FILE.equals(ViewShot.this.result) && -1 != ViewShot.this.format) {
                        ViewShot.this.saveToTempFileOnDevice(findViewById);
                        return;
                    }
                    if (!"base64".equals(ViewShot.this.result) && !Results.ZIP_BASE_64.equals(ViewShot.this.result)) {
                        if (Results.DATA_URI.equals(ViewShot.this.result)) {
                            ViewShot.this.saveToDataUriString(findViewById);
                            return;
                        }
                        return;
                    }
                    ViewShot.this.saveToBase64String(findViewById);
                } catch (Throwable th) {
                    Log.e(ViewShot.TAG, "Failed to capture view snapshot", th);
                    ViewShot.this.promise.reject(ViewShot.ERROR_UNABLE_TO_SNAPSHOT, "Failed to capture view snapshot");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToTempFileOnDevice(View view) throws IOException {
        captureView(view, new FileOutputStream(this.output));
        this.promise.resolve(Uri.fromFile(this.output).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToRawFileOnDevice(View view) throws IOException {
        String uri = Uri.fromFile(this.output).toString();
        FileOutputStream fileOutputStream = new FileOutputStream(this.output);
        ReusableByteArrayOutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(outputBuffer);
        Point captureView = captureView(view, reusableByteArrayOutputStream);
        outputBuffer = reusableByteArrayOutputStream.innerBuffer();
        int size = reusableByteArrayOutputStream.size();
        fileOutputStream.write(String.format(Locale.US, "%d:%d|", Integer.valueOf(captureView.x), Integer.valueOf(captureView.y)).getBytes(Charset.forName("US-ASCII")));
        fileOutputStream.write(outputBuffer, 0, size);
        fileOutputStream.close();
        this.promise.resolve(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToDataUriString(View view) throws IOException {
        ReusableByteArrayOutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(outputBuffer);
        captureView(view, reusableByteArrayOutputStream);
        outputBuffer = reusableByteArrayOutputStream.innerBuffer();
        String encodeToString = Base64.encodeToString(outputBuffer, 0, reusableByteArrayOutputStream.size(), 2);
        String str = "jpg".equals(this.extension) ? "jpeg" : this.extension;
        this.promise.resolve("data:image/" + str + ";base64," + encodeToString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToBase64String(View view) throws IOException {
        String str;
        boolean z = -1 == this.format;
        boolean equals = Results.ZIP_BASE_64.equals(this.result);
        ReusableByteArrayOutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(outputBuffer);
        Point captureView = captureView(view, reusableByteArrayOutputStream);
        outputBuffer = reusableByteArrayOutputStream.innerBuffer();
        int size = reusableByteArrayOutputStream.size();
        String format = String.format(Locale.US, "%d:%d|", Integer.valueOf(captureView.x), Integer.valueOf(captureView.y));
        if (!z) {
            format = "";
        }
        if (equals) {
            Deflater deflater = new Deflater();
            deflater.setInput(outputBuffer, 0, size);
            deflater.finish();
            ReusableByteArrayOutputStream reusableByteArrayOutputStream2 = new ReusableByteArrayOutputStream(new byte[32]);
            byte[] bArr = new byte[1024];
            while (!deflater.finished()) {
                reusableByteArrayOutputStream2.write(bArr, 0, deflater.deflate(bArr));
            }
            str = format + Base64.encodeToString(reusableByteArrayOutputStream2.innerBuffer(), 0, reusableByteArrayOutputStream2.size(), 2);
        } else {
            str = format + Base64.encodeToString(outputBuffer, 0, size, 2);
        }
        this.promise.resolve(str);
    }

    private List<View> getAllChildren(View view) {
        if (!(view instanceof ViewGroup)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            arrayList2.addAll(getAllChildren(viewGroup.getChildAt(i)));
        }
        return arrayList2;
    }

    private Point captureView(View view, OutputStream outputStream) throws IOException {
        try {
            return captureViewImpl(view, outputStream);
        } finally {
            outputStream.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Point captureViewImpl(final View view, OutputStream outputStream) {
        int i;
        Bitmap bitmap;
        OutputStream outputStream2;
        Paint paint;
        Bitmap bitmap2;
        Point point;
        int i2;
        Canvas canvas;
        Paint paint2;
        SurfaceView surfaceView;
        View view2 = view;
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Impossible to snapshot the view: view is invalid");
        }
        boolean z = false;
        if (this.snapshotContentContainer.booleanValue()) {
            ScrollView scrollView = (ScrollView) view2;
            int i3 = 0;
            for (int i4 = 0; i4 < scrollView.getChildCount(); i4++) {
                i3 += scrollView.getChildAt(i4).getHeight();
            }
            i = i3;
        } else {
            i = height;
        }
        Point point2 = new Point(width, i);
        Bitmap bitmapForScreenshot = getBitmapForScreenshot(width, i);
        final Paint paint3 = new Paint();
        int i5 = 1;
        paint3.setAntiAlias(true);
        paint3.setFilterBitmap(true);
        paint3.setDither(true);
        Canvas canvas2 = new Canvas(bitmapForScreenshot);
        view2.draw(canvas2);
        for (final View view3 : getAllChildren(view)) {
            if (view3 instanceof TextureView) {
                if (view3.getVisibility() == 0) {
                    TextureView textureView = (TextureView) view3;
                    textureView.setOpaque(z);
                    Bitmap bitmap3 = textureView.getBitmap(getExactBitmapForScreenshot(view3.getWidth(), view3.getHeight()));
                    int save = canvas2.save();
                    applyTransformations(canvas2, view2, view3);
                    canvas2.drawBitmap(bitmap3, 0.0f, 0.0f, paint3);
                    canvas2.restoreToCount(save);
                    recycleBitmap(bitmap3);
                }
            } else if ((view3 instanceof SurfaceView) && this.handleGLSurfaceView) {
                SurfaceView surfaceView2 = (SurfaceView) view3;
                final CountDownLatch countDownLatch = new CountDownLatch(i5);
                if (Build.VERSION.SDK_INT >= 24) {
                    final Bitmap exactBitmapForScreenshot = getExactBitmapForScreenshot(view3.getWidth(), view3.getHeight());
                    try {
                        final Canvas canvas3 = canvas2;
                        surfaceView = surfaceView2;
                        point = point2;
                        canvas = canvas2;
                        i2 = 1;
                        paint = paint3;
                        bitmap2 = bitmapForScreenshot;
                        try {
                            PixelCopy.request(surfaceView, exactBitmapForScreenshot, new PixelCopy$OnPixelCopyFinishedListener() { // from class: fr.greweb.reactnativeviewshot.ViewShot.2
                                public void onPixelCopyFinished(int i6) {
                                    int save2 = canvas3.save();
                                    ViewShot.this.applyTransformations(canvas3, view, view3);
                                    canvas3.drawBitmap(exactBitmapForScreenshot, 0.0f, 0.0f, paint3);
                                    canvas3.restoreToCount(save2);
                                    ViewShot.recycleBitmap(exactBitmapForScreenshot);
                                    countDownLatch.countDown();
                                }
                            }, new Handler(Looper.getMainLooper()));
                            countDownLatch.await(5L, TimeUnit.SECONDS);
                        } catch (Exception e) {
                            e = e;
                            Log.e(TAG, "Cannot PixelCopy for " + surfaceView, e);
                            paint2 = paint;
                            view2 = view;
                            paint3 = paint2;
                            i5 = i2;
                            canvas2 = canvas;
                            point2 = point;
                            bitmapForScreenshot = bitmap2;
                            z = false;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        surfaceView = surfaceView2;
                        paint = paint3;
                        bitmap2 = bitmapForScreenshot;
                        point = point2;
                        i2 = 1;
                        canvas = canvas2;
                    }
                } else {
                    paint = paint3;
                    bitmap2 = bitmapForScreenshot;
                    point = point2;
                    i2 = 1;
                    canvas = canvas2;
                    if (surfaceView2.getDrawingCache() != null) {
                        paint2 = paint;
                        canvas.drawBitmap(surfaceView2.getDrawingCache(), 0.0f, 0.0f, paint2);
                        view2 = view;
                        paint3 = paint2;
                        i5 = i2;
                        canvas2 = canvas;
                        point2 = point;
                        bitmapForScreenshot = bitmap2;
                        z = false;
                    }
                }
                paint2 = paint;
                view2 = view;
                paint3 = paint2;
                i5 = i2;
                canvas2 = canvas;
                point2 = point;
                bitmapForScreenshot = bitmap2;
                z = false;
            }
            i2 = i5;
            paint2 = paint3;
            bitmap2 = bitmapForScreenshot;
            point = point2;
            canvas = canvas2;
            view2 = view;
            paint3 = paint2;
            i5 = i2;
            canvas2 = canvas;
            point2 = point;
            bitmapForScreenshot = bitmap2;
            z = false;
        }
        boolean z2 = i5;
        Bitmap bitmap4 = bitmapForScreenshot;
        Point point3 = point2;
        Integer num = this.width;
        if (num == null || this.height == null || (num.intValue() == width && this.height.intValue() == i)) {
            bitmap = bitmap4;
        } else {
            bitmap = Bitmap.createScaledBitmap(bitmap4, this.width.intValue(), this.height.intValue(), z2);
            recycleBitmap(bitmap4);
        }
        if (-1 == this.format) {
            outputStream2 = outputStream;
            if (outputStream2 instanceof ReusableByteArrayOutputStream) {
                int i6 = width * i * 4;
                ReusableByteArrayOutputStream reusableByteArrayOutputStream = (ReusableByteArrayOutputStream) cast(outputStream);
                bitmap.copyPixelsToBuffer(reusableByteArrayOutputStream.asBuffer(i6));
                reusableByteArrayOutputStream.setSize(i6);
                recycleBitmap(bitmap);
                return point3;
            }
        } else {
            outputStream2 = outputStream;
        }
        bitmap.compress(Formats.mapping[this.format], (int) (this.quality * 100.0d), outputStream2);
        recycleBitmap(bitmap);
        return point3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Matrix applyTransformations(Canvas canvas, View view, View view2) {
        Matrix matrix = new Matrix();
        LinkedList linkedList = new LinkedList();
        View view3 = view2;
        do {
            linkedList.add(view3);
            view3 = (View) view3.getParent();
        } while (view3 != view);
        Collections.reverse(linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            View view4 = (View) it.next();
            canvas.save();
            int i = 0;
            float left = view4.getLeft() + (view4 != view2 ? view4.getPaddingLeft() : 0) + view4.getTranslationX();
            int top = view4.getTop();
            if (view4 != view2) {
                i = view4.getPaddingTop();
            }
            float translationY = top + i + view4.getTranslationY();
            canvas.translate(left, translationY);
            canvas.rotate(view4.getRotation(), view4.getPivotX(), view4.getPivotY());
            canvas.scale(view4.getScaleX(), view4.getScaleY());
            matrix.postTranslate(left, translationY);
            matrix.postRotate(view4.getRotation(), view4.getPivotX(), view4.getPivotY());
            matrix.postScale(view4.getScaleX(), view4.getScaleY());
        }
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int proposeSize(View view) {
        return Math.min(view.getWidth() * view.getHeight() * 4, 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recycleBitmap(Bitmap bitmap) {
        synchronized (guardBitmaps) {
            weakBitmaps.add(bitmap);
        }
    }

    private static Bitmap getBitmapForScreenshot(int i, int i2) {
        synchronized (guardBitmaps) {
            for (Bitmap bitmap : weakBitmaps) {
                if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
                    weakBitmaps.remove(bitmap);
                    bitmap.eraseColor(0);
                    return bitmap;
                }
            }
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }

    private static Bitmap getExactBitmapForScreenshot(int i, int i2) {
        synchronized (guardBitmaps) {
            for (Bitmap bitmap : weakBitmaps) {
                if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
                    weakBitmaps.remove(bitmap);
                    bitmap.eraseColor(0);
                    return bitmap;
                }
            }
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }

    public static class ReusableByteArrayOutputStream extends ByteArrayOutputStream {
        private static final int MAX_ARRAY_SIZE = 2147483639;

        public ReusableByteArrayOutputStream(byte[] bArr) {
            super(0);
            this.buf = bArr;
        }

        public byte[] innerBuffer() {
            return this.buf;
        }

        public ByteBuffer asBuffer(int i) {
            if (this.buf.length < i) {
                grow(i);
            }
            return ByteBuffer.wrap(this.buf);
        }

        public void setSize(int i) {
            this.count = i;
        }

        protected void grow(int i) {
            int length = this.buf.length << 1;
            if (length - i < 0) {
                length = i;
            }
            if (length - MAX_ARRAY_SIZE > 0) {
                length = hugeCapacity(i);
            }
            this.buf = Arrays.copyOf(this.buf, length);
        }

        protected static int hugeCapacity(int i) {
            if (i < 0) {
                throw new OutOfMemoryError();
            }
            if (i > MAX_ARRAY_SIZE) {
                return Integer.MAX_VALUE;
            }
            return MAX_ARRAY_SIZE;
        }
    }
}
