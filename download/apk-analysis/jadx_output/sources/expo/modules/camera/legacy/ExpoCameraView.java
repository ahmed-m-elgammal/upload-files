package expo.modules.camera.legacy;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.cameraview.CameraView;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import expo.modules.camera.common.BarcodeScannedEvent;
import expo.modules.camera.common.CameraMountErrorEvent;
import expo.modules.camera.common.PictureSavedEvent;
import expo.modules.camera.legacy.tasks.BarCodeScannerAsyncTask;
import expo.modules.camera.legacy.tasks.BarCodeScannerAsyncTaskDelegate;
import expo.modules.camera.legacy.tasks.FaceDetectorAsyncTaskDelegate;
import expo.modules.camera.legacy.tasks.FaceDetectorTask;
import expo.modules.camera.legacy.tasks.PictureSavedDelegate;
import expo.modules.camera.legacy.tasks.ResolveTakenPictureAsyncTask;
import expo.modules.camera.legacy.utils.FileSystemUtils;
import expo.modules.camera.legacy.utils.ImageDimensions;
import expo.modules.camera.records.BarcodeType;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerProviderInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import expo.modules.interfaces.barcodescanner.BarCodeScannerSettings;
import expo.modules.interfaces.camera.CameraViewInterface;
import expo.modules.interfaces.facedetector.FaceDetectorInterface;
import expo.modules.interfaces.facedetector.FaceDetectorProviderInterface;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import io.sentry.protocol.Response;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* compiled from: ExpoCameraView.kt */
@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ0\u0010I\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0K\u0012\u0004\u0012\u00020L0J2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020O0N2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020OH\u0002J\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020\u000fH\u0002J\b\u0010V\u001a\u00020(H\u0002J\u0010\u0010 \u001a\u00020(2\u0006\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020(H\u0016J\b\u0010Z\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010/\u001a\u00020(2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020L0NH\u0016J\b\u0010\\\u001a\u00020(H\u0016J\b\u0010]\u001a\u00020(H\u0016J\b\u0010^\u001a\u00020(H\u0016J0\u0010_\u001a\u00020(2\u0006\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020O2\u0006\u0010b\u001a\u00020O2\u0006\u0010c\u001a\u00020O2\u0006\u0010d\u001a\u00020OH\u0014J\u0010\u00107\u001a\u00020(2\u0006\u0010e\u001a\u00020LH\u0016J\u0010\u0010f\u001a\u00020(2\u0006\u0010g\u001a\u00020hH\u0016J\u001e\u0010i\u001a\u00020(2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020A2\u0006\u0010m\u001a\u00020BJ\u000e\u0010n\u001a\u00020(2\u0006\u0010o\u001a\u00020pJ\u001c\u0010q\u001a\u00020(2\u0014\u0010o\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0018\u00010<J\u0012\u0010r\u001a\u00020(2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u000e\u0010u\u001a\u00020(2\u0006\u0010G\u001a\u00020\u000fJ\u000e\u0010v\u001a\u00020(2\u0006\u0010w\u001a\u00020\u000fJ\u001e\u0010x\u001a\u00020(2\u0006\u0010j\u001a\u00020D2\u0006\u0010l\u001a\u00020A2\u0006\u0010m\u001a\u00020BJ\u0010\u0010y\u001a\u00020(2\u0006\u0010W\u001a\u00020XH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R!\u0010'\u001a\b\u0012\u0004\u0012\u00020(0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b)\u0010$R!\u0010+\u001a\b\u0012\u0004\u0012\u00020,0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010&\u001a\u0004\b-\u0010$R!\u0010/\u001a\b\u0012\u0004\u0012\u0002000!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b1\u0010$R!\u00103\u001a\b\u0012\u0004\u0012\u0002040!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b5\u0010$R!\u00107\u001a\b\u0012\u0004\u0012\u0002080!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010&\u001a\u0004\b9\u0010$R\u001c\u0010;\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020D0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020A0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lexpo/modules/camera/legacy/ExpoCameraView;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "Lexpo/modules/camera/legacy/tasks/BarCodeScannerAsyncTaskDelegate;", "Lexpo/modules/camera/legacy/tasks/FaceDetectorAsyncTaskDelegate;", "Lexpo/modules/camera/legacy/tasks/PictureSavedDelegate;", "Lexpo/modules/interfaces/camera/CameraViewInterface;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "barCodeScanner", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "barCodeScannerTaskLock", "", "getBarCodeScannerTaskLock", "()Z", "setBarCodeScannerTaskLock", "(Z)V", "cameraView", "Lcom/google/android/cameraview/CameraView;", "getCameraView$expo_camera_release", "()Lcom/google/android/cameraview/CameraView;", "faceDetector", "Lexpo/modules/interfaces/facedetector/FaceDetectorInterface;", "faceDetectorTaskLock", "getFaceDetectorTaskLock", "setFaceDetectorTaskLock", "isNew", "isPaused", "mShouldScanBarCodes", "onBarCodeScanned", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/camera/common/BarcodeScannedEvent;", "getOnBarCodeScanned", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onBarCodeScanned$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onCameraReady", "", "getOnCameraReady", "onCameraReady$delegate", "onFaceDetectionError", "Lexpo/modules/camera/legacy/FaceDetectionErrorEvent;", "getOnFaceDetectionError", "onFaceDetectionError$delegate", "onFacesDetected", "Lexpo/modules/camera/legacy/FacesDetectedEvent;", "getOnFacesDetected", "onFacesDetected$delegate", "onMountError", "Lexpo/modules/camera/common/CameraMountErrorEvent;", "getOnMountError", "onMountError$delegate", "onPictureSaved", "Lexpo/modules/camera/common/PictureSavedEvent;", "getOnPictureSaved", "onPictureSaved$delegate", "pendingFaceDetectorSettings", "", "", "", "pictureTakenDirectories", "", "Lexpo/modules/kotlin/Promise;", "Ljava/io/File;", "pictureTakenOptions", "Lexpo/modules/camera/legacy/PictureOptions;", "pictureTakenPromises", "Ljava/util/Queue;", "shouldDetectFaces", "videoRecordedPromise", "getCornerPointsAndBoundingBox", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "cornerPoints", "", "", "boundingBox", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult$BoundingBox;", "getDeviceOrientation", "getPreviewSizeAsArray", "", "hasCameraPermissions", "initBarCodeScanner", "barCode", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "onBarCodeScanningTaskCompleted", "onFaceDetectingTaskCompleted", "faces", "onHostDestroy", "onHostPause", "onHostResume", ViewProps.ON_LAYOUT, "changed", "left", "top", "right", ViewProps.BOTTOM, Response.TYPE, "onViewAdded", "child", "Landroid/view/View;", "record", "options", "Lexpo/modules/camera/legacy/RecordingOptions;", BaseJavaModule.METHOD_TYPE_PROMISE, "cacheDirectory", "setBarCodeScannerSettings", "settings", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerSettings;", "setFaceDetectorSettings", "setPreviewTexture", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "setShouldDetectFaces", "setShouldScanBarCodes", "shouldScanBarCodes", "takePicture", "transformBarCodeScannerResultToViewCoordinates", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpoCameraView extends ExpoView implements LifecycleEventListener, BarCodeScannerAsyncTaskDelegate, FaceDetectorAsyncTaskDelegate, PictureSavedDelegate, CameraViewInterface {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onCameraReady", "getOnCameraReady()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onMountError", "getOnMountError()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onBarCodeScanned", "getOnBarCodeScanned()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onFacesDetected", "getOnFacesDetected()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onFaceDetectionError", "getOnFaceDetectionError()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onPictureSaved", "getOnPictureSaved()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    private BarCodeScannerInterface barCodeScanner;
    private volatile boolean barCodeScannerTaskLock;
    private final CameraView cameraView;
    private FaceDetectorInterface faceDetector;
    private volatile boolean faceDetectorTaskLock;
    private boolean isNew;
    private boolean isPaused;
    private boolean mShouldScanBarCodes;

    /* renamed from: onBarCodeScanned$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onBarCodeScanned;

    /* renamed from: onCameraReady$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onCameraReady;

    /* renamed from: onFaceDetectionError$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onFaceDetectionError;

    /* renamed from: onFacesDetected$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onFacesDetected;

    /* renamed from: onMountError$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMountError;

    /* renamed from: onPictureSaved$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onPictureSaved;
    private Map<String, ? extends Object> pendingFaceDetectorSettings;
    private final Map<Promise, File> pictureTakenDirectories;
    private final Map<Promise, PictureOptions> pictureTakenOptions;
    private final Queue<Promise> pictureTakenPromises;
    private boolean shouldDetectFaces;
    private Promise videoRecordedPromise;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoCameraView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.cameraView = new CameraView(context, true);
        this.pictureTakenPromises = new ConcurrentLinkedQueue();
        this.pictureTakenOptions = new ConcurrentHashMap();
        this.pictureTakenDirectories = new ConcurrentHashMap();
        this.isNew = true;
        ExpoCameraView expoCameraView = this;
        Object obj = null;
        this.onCameraReady = new ViewEventDelegate(expoCameraView, null);
        this.onMountError = new ViewEventDelegate(expoCameraView, null);
        this.onBarCodeScanned = new ViewEventDelegate(expoCameraView, new Function1<BarcodeScannedEvent, Short>() { // from class: expo.modules.camera.legacy.ExpoCameraView$onBarCodeScanned$2
            @Override // kotlin.jvm.functions.Function1
            public final Short invoke(BarcodeScannedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                return Short.valueOf((short) (event.getData().hashCode() % 32767));
            }
        });
        this.onFacesDetected = new ViewEventDelegate(expoCameraView, new Function1<FacesDetectedEvent, Short>() { // from class: expo.modules.camera.legacy.ExpoCameraView$onFacesDetected$2
            @Override // kotlin.jvm.functions.Function1
            public final Short invoke(FacesDetectedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                return Short.valueOf((short) (event.getFaces().size() % 32767));
            }
        });
        this.onFaceDetectionError = new ViewEventDelegate(expoCameraView, null);
        this.onPictureSaved = new ViewEventDelegate(expoCameraView, new Function1<PictureSavedEvent, Short>() { // from class: expo.modules.camera.legacy.ExpoCameraView$onPictureSaved$2
            @Override // kotlin.jvm.functions.Function1
            public final Short invoke(PictureSavedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                String string = event.getData().getString("uri");
                return Short.valueOf((short) ((string != null ? string.hashCode() : -1) % 32767));
            }
        });
        initBarCodeScanner();
        setChildrenDrawingOrderEnabled(true);
        try {
            obj = appContext.getLegacyModuleRegistry().getModule(UIManager.class);
        } catch (Exception unused) {
        }
        UIManager uIManager = (UIManager) obj;
        Intrinsics.checkNotNull(uIManager);
        uIManager.registerLifecycleEventListener(this);
        this.cameraView.addCallback(new CameraView.Callback() { // from class: expo.modules.camera.legacy.ExpoCameraView.1
            @Override // com.google.android.cameraview.CameraView.Callback
            public void onCameraOpened(CameraView cameraView) {
                Intrinsics.checkNotNullParameter(cameraView, "cameraView");
                ExpoCameraView.this.getOnCameraReady().invoke(Unit.INSTANCE);
            }

            @Override // com.google.android.cameraview.CameraView.Callback
            public void onMountError(CameraView cameraView) {
                Intrinsics.checkNotNullParameter(cameraView, "cameraView");
                ExpoCameraView.this.getOnMountError().invoke(new CameraMountErrorEvent("Camera component could not be rendered - is there any other instance running?"));
            }

            @Override // com.google.android.cameraview.CameraView.Callback
            public void onPictureTaken(CameraView cameraView, byte[] data) {
                Intrinsics.checkNotNullParameter(cameraView, "cameraView");
                Intrinsics.checkNotNullParameter(data, "data");
                Promise promise = (Promise) ExpoCameraView.this.pictureTakenPromises.poll();
                if (promise == null) {
                    return;
                }
                File file = (File) ExpoCameraView.this.pictureTakenDirectories.remove(promise);
                Object remove = ExpoCameraView.this.pictureTakenOptions.remove(promise);
                Intrinsics.checkNotNull(remove);
                PictureOptions pictureOptions = (PictureOptions) remove;
                if (pictureOptions.getFastMode()) {
                    promise.resolve((Object) null);
                }
                if (file != null) {
                    new ResolveTakenPictureAsyncTask(data, promise, pictureOptions, file, ExpoCameraView.this).execute(new Void[0]);
                }
            }

            @Override // com.google.android.cameraview.CameraView.Callback
            public void onVideoRecorded(CameraView cameraView, String path) {
                Intrinsics.checkNotNullParameter(cameraView, "cameraView");
                Intrinsics.checkNotNullParameter(path, "path");
                Promise promise = ExpoCameraView.this.videoRecordedPromise;
                if (promise != null) {
                    ExpoCameraView expoCameraView2 = ExpoCameraView.this;
                    Bundle bundle = new Bundle();
                    bundle.putString("uri", Uri.fromFile(new File(path)).toString());
                    promise.resolve(bundle);
                    expoCameraView2.videoRecordedPromise = null;
                }
            }

            @Override // com.google.android.cameraview.CameraView.Callback
            public void onFramePreview(CameraView cameraView, byte[] data, int width, int height, int rotation) {
                FaceDetectorTask faceDetectorTask;
                Intrinsics.checkNotNullParameter(cameraView, "cameraView");
                Intrinsics.checkNotNullParameter(data, "data");
                int correctCameraRotation = CameraViewHelper.getCorrectCameraRotation(rotation, cameraView.getFacing());
                if (ExpoCameraView.this.mShouldScanBarCodes && !ExpoCameraView.this.getBarCodeScannerTaskLock()) {
                    ExpoCameraView.this.setBarCodeScannerTaskLock(true);
                    BarCodeScannerInterface barCodeScannerInterface = ExpoCameraView.this.barCodeScanner;
                    if (barCodeScannerInterface != null) {
                        new BarCodeScannerAsyncTask(ExpoCameraView.this, barCodeScannerInterface, data, width, height, rotation).execute(new Void[0]);
                    }
                }
                if (!ExpoCameraView.this.shouldDetectFaces || ExpoCameraView.this.getFaceDetectorTaskLock()) {
                    return;
                }
                ExpoCameraView.this.setFaceDetectorTaskLock(true);
                float f = cameraView.getResources().getDisplayMetrics().density;
                ImageDimensions imageDimensions = new ImageDimensions(width, height, correctCameraRotation, cameraView.getFacing());
                double width2 = cameraView.getWidth() / (imageDimensions.getWidth() * f);
                double height2 = cameraView.getHeight() / (imageDimensions.getHeight() * f);
                FaceDetectorInterface faceDetectorInterface = ExpoCameraView.this.faceDetector;
                if (faceDetectorInterface != null) {
                    faceDetectorTask = new FaceDetectorTask(ExpoCameraView.this, faceDetectorInterface, data, width, height, correctCameraRotation, cameraView.getFacing() == 1, width2, height2);
                } else {
                    faceDetectorTask = null;
                }
                if (faceDetectorTask != null) {
                    faceDetectorTask.execute();
                }
            }
        });
        addView(this.cameraView);
    }

    /* renamed from: getCameraView$expo_camera_release, reason: from getter */
    public final CameraView getCameraView() {
        return this.cameraView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewEventCallback<Unit> getOnCameraReady() {
        return this.onCameraReady.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewEventCallback<CameraMountErrorEvent> getOnMountError() {
        return this.onMountError.getValue(this, $$delegatedProperties[1]);
    }

    private final ViewEventCallback<BarcodeScannedEvent> getOnBarCodeScanned() {
        return this.onBarCodeScanned.getValue(this, $$delegatedProperties[2]);
    }

    private final ViewEventCallback<FacesDetectedEvent> getOnFacesDetected() {
        return this.onFacesDetected.getValue(this, $$delegatedProperties[3]);
    }

    private final ViewEventCallback<FaceDetectionErrorEvent> getOnFaceDetectionError() {
        return this.onFaceDetectionError.getValue(this, $$delegatedProperties[4]);
    }

    private final ViewEventCallback<PictureSavedEvent> getOnPictureSaved() {
        return this.onPictureSaved.getValue(this, $$delegatedProperties[5]);
    }

    public final boolean getBarCodeScannerTaskLock() {
        return this.barCodeScannerTaskLock;
    }

    public final void setBarCodeScannerTaskLock(boolean z) {
        this.barCodeScannerTaskLock = z;
    }

    public final boolean getFaceDetectorTaskLock() {
        return this.faceDetectorTaskLock;
    }

    public final void setFaceDetectorTaskLock(boolean z) {
        this.faceDetectorTaskLock = z;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = right - left;
        int i2 = bottom - top;
        this.cameraView.layout(0, 0, i, i2);
        this.cameraView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        View view = this.cameraView.getView();
        if (view == null) {
            return;
        }
        view.layout(0, 0, i, i2);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.cameraView == child) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (i == 0 && childAt == this.cameraView) {
                return;
            }
            if (childAt != this.cameraView) {
                Intrinsics.checkNotNull(childAt);
                arrayList.add(childAt);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bringChildToFront((View) it.next());
        }
        this.cameraView.requestLayout();
        this.cameraView.invalidate();
    }

    public final void takePicture(PictureOptions options, Promise promise, File cacheDirectory) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(cacheDirectory, "cacheDirectory");
        this.pictureTakenPromises.add(promise);
        this.pictureTakenOptions.put(promise, options);
        this.pictureTakenDirectories.put(promise, cacheDirectory);
        try {
            this.cameraView.takePicture();
        } catch (Exception e) {
            this.pictureTakenPromises.remove(promise);
            this.pictureTakenOptions.remove(promise);
            this.pictureTakenDirectories.remove(promise);
            throw e;
        }
    }

    @Override // expo.modules.camera.legacy.tasks.PictureSavedDelegate
    public void onPictureSaved(Bundle response) {
        Intrinsics.checkNotNullParameter(response, "response");
        ViewEventCallback<PictureSavedEvent> onPictureSaved = getOnPictureSaved();
        int i = response.getInt("id");
        Bundle bundle = response.getBundle("data");
        Intrinsics.checkNotNull(bundle);
        onPictureSaved.invoke(new PictureSavedEvent(i, bundle));
    }

    public final void record(RecordingOptions options, Promise promise, File cacheDirectory) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(cacheDirectory, "cacheDirectory");
        try {
            String generateOutputPath = FileSystemUtils.INSTANCE.generateOutputPath(cacheDirectory, "Camera", ".mp4");
            CamcorderProfile camcorderProfile = CameraViewHelper.getCamcorderProfile(this.cameraView.getCameraId(), options.getQuality());
            Integer videoBitrate = options.getVideoBitrate();
            if (videoBitrate != null) {
                camcorderProfile.videoBitRate = videoBitrate.intValue();
            }
            if (this.cameraView.record(generateOutputPath, options.getMaxDuration() * 1000, options.getMaxFileSize(), !options.getMute(), camcorderProfile)) {
                this.videoRecordedPromise = promise;
            } else {
                promise.reject("E_RECORDING_FAILED", "Starting video recording failed. Another recording might be in progress.", null);
            }
        } catch (IOException unused) {
            promise.reject("E_RECORDING_FAILED", "Starting video recording failed - could not create video file.", null);
        }
    }

    private final void initBarCodeScanner() {
        Object obj;
        try {
            obj = getAppContext().getLegacyModuleRegistry().getModule(BarCodeScannerProviderInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        BarCodeScannerProviderInterface barCodeScannerProviderInterface = (BarCodeScannerProviderInterface) obj;
        this.barCodeScanner = barCodeScannerProviderInterface != null ? barCodeScannerProviderInterface.createBarCodeDetectorWithContext(getContext()) : null;
    }

    public final void setShouldScanBarCodes(boolean shouldScanBarCodes) {
        this.mShouldScanBarCodes = shouldScanBarCodes;
        this.cameraView.setScanning(shouldScanBarCodes || this.shouldDetectFaces);
    }

    public final void setBarCodeScannerSettings(BarCodeScannerSettings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        BarCodeScannerInterface barCodeScannerInterface = this.barCodeScanner;
        if (barCodeScannerInterface != null) {
            barCodeScannerInterface.setSettings(settings);
        }
    }

    private final int getDeviceOrientation() {
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return ((WindowManager) systemService).getDefaultDisplay().getRotation();
    }

    private final void transformBarCodeScannerResultToViewCoordinates(BarCodeScannerResult barCode) {
        List<Integer> cornerPoints = barCode.getCornerPoints();
        int referenceImageHeight = barCode.getReferenceImageHeight();
        int referenceImageWidth = barCode.getReferenceImageWidth();
        boolean z = this.cameraView.getFacing() == 0;
        boolean z2 = this.cameraView.getFacing() == 1;
        boolean z3 = getDeviceOrientation() % 2 == 0;
        boolean z4 = getDeviceOrientation() % 2 == 1;
        if (z && z3) {
            Intrinsics.checkNotNull(cornerPoints);
            IntProgression step = RangesKt.step(RangesKt.until(1, cornerPoints.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    Integer num = cornerPoints.get(first);
                    Intrinsics.checkNotNullExpressionValue(num, "get(...)");
                    cornerPoints.set(first, Integer.valueOf(referenceImageHeight - num.intValue()));
                    if (first == last) {
                        break;
                    } else {
                        first += step2;
                    }
                }
            }
        }
        if (z && z4) {
            Intrinsics.checkNotNull(cornerPoints);
            IntProgression step3 = RangesKt.step(RangesKt.until(0, cornerPoints.size()), 2);
            int first2 = step3.getFirst();
            int last2 = step3.getLast();
            int step4 = step3.getStep();
            if ((step4 > 0 && first2 <= last2) || (step4 < 0 && last2 <= first2)) {
                while (true) {
                    Integer num2 = cornerPoints.get(first2);
                    Intrinsics.checkNotNullExpressionValue(num2, "get(...)");
                    cornerPoints.set(first2, Integer.valueOf(referenceImageWidth - num2.intValue()));
                    if (first2 == last2) {
                        break;
                    } else {
                        first2 += step4;
                    }
                }
            }
        }
        if (z2) {
            Intrinsics.checkNotNull(cornerPoints);
            IntProgression step5 = RangesKt.step(RangesKt.until(1, cornerPoints.size()), 2);
            int first3 = step5.getFirst();
            int last3 = step5.getLast();
            int step6 = step5.getStep();
            if ((step6 > 0 && first3 <= last3) || (step6 < 0 && last3 <= first3)) {
                while (true) {
                    Integer num3 = cornerPoints.get(first3);
                    Intrinsics.checkNotNullExpressionValue(num3, "get(...)");
                    cornerPoints.set(first3, Integer.valueOf(referenceImageHeight - num3.intValue()));
                    if (first3 == last3) {
                        break;
                    } else {
                        first3 += step6;
                    }
                }
            }
            IntProgression step7 = RangesKt.step(RangesKt.until(0, cornerPoints.size()), 2);
            int first4 = step7.getFirst();
            int last4 = step7.getLast();
            int step8 = step7.getStep();
            if ((step8 > 0 && first4 <= last4) || (step8 < 0 && last4 <= first4)) {
                while (true) {
                    Integer num4 = cornerPoints.get(first4);
                    Intrinsics.checkNotNullExpressionValue(num4, "get(...)");
                    cornerPoints.set(first4, Integer.valueOf(referenceImageWidth - num4.intValue()));
                    if (first4 == last4) {
                        break;
                    } else {
                        first4 += step8;
                    }
                }
            }
        }
        double width = getWidth() / referenceImageHeight;
        double height = getHeight() / referenceImageWidth;
        Intrinsics.checkNotNull(cornerPoints);
        IntProgression step9 = RangesKt.step(RangesKt.until(1, cornerPoints.size()), 2);
        int first5 = step9.getFirst();
        int last5 = step9.getLast();
        int step10 = step9.getStep();
        if ((step10 > 0 && first5 <= last5) || (step10 < 0 && last5 <= first5)) {
            while (true) {
                cornerPoints.set(first5, Integer.valueOf(MathKt.roundToInt(cornerPoints.get(first5).doubleValue() * width)));
                if (first5 == last5) {
                    break;
                } else {
                    first5 += step10;
                }
            }
        }
        IntProgression step11 = RangesKt.step(RangesKt.until(0, cornerPoints.size()), 2);
        int first6 = step11.getFirst();
        int last6 = step11.getLast();
        int step12 = step11.getStep();
        if ((step12 > 0 && first6 <= last6) || (step12 < 0 && last6 <= first6)) {
            while (true) {
                cornerPoints.set(first6, Integer.valueOf(MathKt.roundToInt(cornerPoints.get(first6).doubleValue() * height)));
                if (first6 == last6) {
                    break;
                } else {
                    first6 += step12;
                }
            }
        }
        barCode.setCornerPoints(cornerPoints);
    }

    private final Pair<ArrayList<Bundle>, Bundle> getCornerPointsAndBoundingBox(List<Integer> cornerPoints, BarCodeScannerResult.BoundingBox boundingBox) {
        float f = this.cameraView.getResources().getDisplayMetrics().density;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, cornerPoints.size() - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                Bundle bundle = new Bundle();
                bundle.putFloat("x", cornerPoints.get(i + 1).intValue() / f);
                bundle.putFloat("y", cornerPoints.get(i).intValue() / f);
                arrayList.add(bundle);
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle3.putFloat("x", boundingBox.getX() / f);
        bundle3.putFloat("y", boundingBox.getY() / f);
        Unit unit = Unit.INSTANCE;
        bundle2.putParcelable("origin", bundle3);
        Bundle bundle4 = new Bundle();
        bundle4.putFloat("width", boundingBox.getWidth() / f);
        bundle4.putFloat("height", boundingBox.getHeight() / f);
        Unit unit2 = Unit.INSTANCE;
        bundle2.putParcelable(RRWebVideoEvent.JsonKeys.SIZE, bundle4);
        return TuplesKt.to(arrayList, bundle2);
    }

    @Override // expo.modules.camera.legacy.tasks.BarCodeScannerAsyncTaskDelegate
    public void onBarCodeScanned(BarCodeScannerResult barCode) {
        Intrinsics.checkNotNullParameter(barCode, "barCode");
        if (this.mShouldScanBarCodes) {
            transformBarCodeScannerResultToViewCoordinates(barCode);
            List<Integer> cornerPoints = barCode.getCornerPoints();
            Intrinsics.checkNotNullExpressionValue(cornerPoints, "getCornerPoints(...)");
            BarCodeScannerResult.BoundingBox boundingBox = barCode.getBoundingBox();
            Intrinsics.checkNotNullExpressionValue(boundingBox, "getBoundingBox(...)");
            Pair<ArrayList<Bundle>, Bundle> cornerPointsAndBoundingBox = getCornerPointsAndBoundingBox(cornerPoints, boundingBox);
            ArrayList<Bundle> component1 = cornerPointsAndBoundingBox.component1();
            Bundle component2 = cornerPointsAndBoundingBox.component2();
            ViewEventCallback<BarcodeScannedEvent> onBarCodeScanned = getOnBarCodeScanned();
            int id = getId();
            String value = barCode.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            String raw = barCode.getRaw();
            Intrinsics.checkNotNullExpressionValue(raw, "getRaw(...)");
            onBarCodeScanned.invoke(new BarcodeScannedEvent(id, value, raw, BarcodeType.INSTANCE.mapFormatToString(barCode.getType()), component1, component2));
        }
    }

    @Override // expo.modules.camera.legacy.tasks.BarCodeScannerAsyncTaskDelegate
    public void onBarCodeScanningTaskCompleted() {
        this.barCodeScannerTaskLock = false;
    }

    @Override // expo.modules.interfaces.camera.CameraViewInterface
    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
        this.cameraView.setPreviewTexture(surfaceTexture);
    }

    @Override // expo.modules.interfaces.camera.CameraViewInterface
    public int[] getPreviewSizeAsArray() {
        return new int[]{this.cameraView.getPreviewSize().getWidth(), this.cameraView.getPreviewSize().getHeight()};
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        Object obj;
        if (hasCameraPermissions()) {
            if ((!this.isPaused || this.cameraView.isCameraOpened()) && !this.isNew) {
                return;
            }
            this.isPaused = false;
            this.isNew = false;
            if (EmulatorUtilities.INSTANCE.isRunningOnEmulator()) {
                return;
            }
            this.cameraView.start();
            try {
                obj = getAppContext().getLegacyModuleRegistry().getModule(FaceDetectorProviderInterface.class);
            } catch (Exception unused) {
                obj = null;
            }
            FaceDetectorProviderInterface faceDetectorProviderInterface = (FaceDetectorProviderInterface) obj;
            FaceDetectorInterface createFaceDetectorWithContext = faceDetectorProviderInterface != null ? faceDetectorProviderInterface.createFaceDetectorWithContext(getContext()) : null;
            this.faceDetector = createFaceDetectorWithContext;
            Map<String, ? extends Object> map = this.pendingFaceDetectorSettings;
            if (map != null) {
                if (createFaceDetectorWithContext != null) {
                    createFaceDetectorWithContext.setSettings(map);
                }
                this.pendingFaceDetectorSettings = null;
                return;
            }
            return;
        }
        getOnMountError().invoke(new CameraMountErrorEvent("Camera permissions not granted - component could not be rendered."));
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
        if (this.isPaused || !this.cameraView.isCameraOpened()) {
            return;
        }
        FaceDetectorInterface faceDetectorInterface = this.faceDetector;
        if (faceDetectorInterface != null) {
            faceDetectorInterface.release();
        }
        this.isPaused = true;
        this.cameraView.stop();
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
        FaceDetectorInterface faceDetectorInterface = this.faceDetector;
        if (faceDetectorInterface != null) {
            faceDetectorInterface.release();
        }
        this.cameraView.stop();
    }

    private final boolean hasCameraPermissions() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions == null) {
            return false;
        }
        return permissions.hasGrantedPermissions("android.permission.CAMERA");
    }

    public final void setShouldDetectFaces(boolean shouldDetectFaces) {
        this.shouldDetectFaces = shouldDetectFaces;
        this.cameraView.setScanning(this.mShouldScanBarCodes || shouldDetectFaces);
    }

    public final void setFaceDetectorSettings(Map<String, ? extends Object> settings) {
        Unit unit;
        FaceDetectorInterface faceDetectorInterface = this.faceDetector;
        if (faceDetectorInterface != null) {
            faceDetectorInterface.setSettings(settings);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.pendingFaceDetectorSettings = settings;
        }
    }

    @Override // expo.modules.camera.legacy.tasks.FaceDetectorAsyncTaskDelegate
    public void onFacesDetected(List<Bundle> faces) {
        Intrinsics.checkNotNullParameter(faces, "faces");
        if (this.shouldDetectFaces) {
            getOnFacesDetected().invoke(new FacesDetectedEvent(OptionalModuleUtils.FACE, faces, getId()));
        }
    }

    @Override // expo.modules.camera.legacy.tasks.FaceDetectorAsyncTaskDelegate
    public void onFaceDetectionError(FaceDetectorInterface faceDetector) {
        Intrinsics.checkNotNullParameter(faceDetector, "faceDetector");
        this.faceDetectorTaskLock = false;
        if (this.shouldDetectFaces) {
            getOnFaceDetectionError().invoke(new FaceDetectionErrorEvent(true));
        }
    }

    @Override // expo.modules.camera.legacy.tasks.FaceDetectorAsyncTaskDelegate
    public void onFaceDetectingTaskCompleted() {
        this.faceDetectorTaskLock = false;
    }
}
