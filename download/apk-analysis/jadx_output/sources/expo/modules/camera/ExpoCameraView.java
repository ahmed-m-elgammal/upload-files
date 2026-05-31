package expo.modules.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.DisplayOrientedMeteringPointFactory;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.FallbackStrategy;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.henninghall.date_picker.props.ModeProp;
import expo.modules.camera.CameraExceptions;
import expo.modules.camera.ExpoCameraView$orientationEventListener$2;
import expo.modules.camera.analyzers.BarcodeAnalyzer;
import expo.modules.camera.common.BarcodeScannedEvent;
import expo.modules.camera.common.CameraMountErrorEvent;
import expo.modules.camera.common.PictureSavedEvent;
import expo.modules.camera.records.BarcodeSettings;
import expo.modules.camera.records.BarcodeType;
import expo.modules.camera.records.CameraMode;
import expo.modules.camera.records.CameraRatio;
import expo.modules.camera.records.CameraType;
import expo.modules.camera.records.FlashMode;
import expo.modules.camera.records.FocusMode;
import expo.modules.camera.records.VideoQuality;
import expo.modules.camera.utils.FileSystemUtils;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import expo.modules.interfaces.camera.CameraViewInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import io.sentry.protocol.Response;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: ExpoCameraView.kt */
@Metadata(d1 = {"\u0000Ø\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010|\u001a\u00020}H\u0002J\u0006\u0010~\u001a\u00020\u007fJ\t\u0010\u0080\u0001\u001a\u00020NH\u0007J\t\u0010\u0081\u0001\u001a\u000207H\u0002J\u0010\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u00020q0\u0083\u0001H\u0002J\u000f\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020_0\u001cH\u0007JE\u0010\u0085\u0001\u001a$\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030\u0088\u00010\u0087\u0001j\n\u0012\u0005\u0012\u00030\u0088\u0001`\u0089\u0001\u0012\u0005\u0012\u00030\u0088\u00010\u0086\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010\u001c2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002J\n\u0010\u008e\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016J\u0013\u0010\u0091\u0001\u001a\u00020N2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0002J\u0012\u0010F\u001a\u00020N2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0002J:\u0010\u0096\u0001\u001a\u00020N2\u0007\u0010\u0097\u0001\u001a\u00020\u000f2\b\u0010\u0098\u0001\u001a\u00030\u008b\u00012\b\u0010\u0099\u0001\u001a\u00030\u008b\u00012\b\u0010\u009a\u0001\u001a\u00030\u008b\u00012\b\u0010\u009b\u0001\u001a\u00030\u008b\u0001H\u0014J\u001d\u0010\u009c\u0001\u001a\u00020N2\b\u0010\u009d\u0001\u001a\u00030\u008b\u00012\b\u0010\u009e\u0001\u001a\u00030\u008b\u0001H\u0014J\u0010\u0010U\u001a\u00020N2\b\u0010\u009f\u0001\u001a\u00030\u0088\u0001J\u0015\u0010 \u0001\u001a\u00020N2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0016J\u0007\u0010£\u0001\u001a\u00020NJ%\u0010¤\u0001\u001a\u00020N2\b\u0010¥\u0001\u001a\u00030¦\u00012\b\u0010§\u0001\u001a\u00030¨\u00012\b\u0010©\u0001\u001a\u00030ª\u0001J\b\u0010«\u0001\u001a\u00030¬\u0001J\u0007\u0010\u00ad\u0001\u001a\u00020NJ\u0013\u0010®\u0001\u001a\u00020N2\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001J\u0011\u0010±\u0001\u001a\u00020N2\b\u0010²\u0001\u001a\u00030³\u0001J\u0015\u0010´\u0001\u001a\u00020N2\n\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0016J\u000f\u0010·\u0001\u001a\u00020N2\u0006\u0010u\u001a\u00020\u000fJ\u0012\u0010¸\u0001\u001a\u00020N2\u0007\u0010¹\u0001\u001a\u00020\u000fH\u0002J\t\u0010º\u0001\u001a\u00020NH\u0002J%\u0010»\u0001\u001a\u00020N2\b\u0010¥\u0001\u001a\u00030¼\u00012\b\u0010§\u0001\u001a\u00030¨\u00012\b\u0010©\u0001\u001a\u00030ª\u0001J\u0013\u0010½\u0001\u001a\u00020N2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020$@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020-8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R+\u00101\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b2\u0010\u0011\"\u0004\b3\u0010\u0013R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010;\u001a\u00020:2\u0006\u0010\u0014\u001a\u00020:@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010@\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0011\"\u0004\bB\u0010\u0013R\u001a\u0010C\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0011\"\u0004\bE\u0010\u0013R!\u0010F\u001a\b\u0012\u0004\u0012\u00020H0G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bI\u0010JR!\u0010M\u001a\b\u0012\u0004\u0012\u00020N0G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010L\u001a\u0004\bO\u0010JR!\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010L\u001a\u0004\bS\u0010JR!\u0010U\u001a\b\u0012\u0004\u0012\u00020V0G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010L\u001a\u0004\bW\u0010JR\u001b\u0010Y\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b[\u0010\\R$\u0010`\u001a\u00020_2\u0006\u0010\u0014\u001a\u00020_@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u000e\u0010e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020+0iX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010k\u001a\u0004\u0018\u00010j2\b\u0010\u0014\u001a\u0004\u0018\u00010j@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0010\u0010p\u001a\u0004\u0018\u00010qX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020sX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010w\u001a\u00020v2\u0006\u0010\u0014\u001a\u00020v@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{¨\u0006¾\u0001"}, d2 = {"Lexpo/modules/camera/ExpoCameraView;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/interfaces/camera/CameraViewInterface;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "activeRecording", "Landroidx/camera/video/Recording;", "getActiveRecording", "()Landroidx/camera/video/Recording;", "setActiveRecording", "(Landroidx/camera/video/Recording;)V", "animateShutter", "", "getAnimateShutter", "()Z", "setAnimateShutter", "(Z)V", "value", "Lexpo/modules/camera/records/FocusMode;", "autoFocus", "getAutoFocus", "()Lexpo/modules/camera/records/FocusMode;", "setAutoFocus", "(Lexpo/modules/camera/records/FocusMode;)V", "barcodeFormats", "", "Lexpo/modules/camera/records/BarcodeType;", "camera", "Landroidx/camera/core/Camera;", "getCamera", "()Landroidx/camera/core/Camera;", "setCamera", "(Landroidx/camera/core/Camera;)V", "Lexpo/modules/camera/records/CameraMode;", "cameraMode", "getCameraMode", "()Lexpo/modules/camera/records/CameraMode;", "setCameraMode", "(Lexpo/modules/camera/records/CameraMode;)V", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "currentActivity", "Landroidx/appcompat/app/AppCompatActivity;", "getCurrentActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "<set-?>", "enableTorch", "getEnableTorch", "setEnableTorch", "enableTorch$delegate", "Lkotlin/properties/ReadWriteProperty;", "imageAnalysisUseCase", "Landroidx/camera/core/ImageAnalysis;", "imageCaptureUseCase", "Landroidx/camera/core/ImageCapture;", "Lexpo/modules/camera/records/CameraType;", "lensFacing", "getLensFacing", "()Lexpo/modules/camera/records/CameraType;", "setLensFacing", "(Lexpo/modules/camera/records/CameraType;)V", "mirror", "getMirror", "setMirror", "mute", "getMute", "setMute", "onBarcodeScanned", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/camera/common/BarcodeScannedEvent;", "getOnBarcodeScanned", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onBarcodeScanned$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onCameraReady", "", "getOnCameraReady", "onCameraReady$delegate", "onMountError", "Lexpo/modules/camera/common/CameraMountErrorEvent;", "getOnMountError", "onMountError$delegate", "onPictureSaved", "Lexpo/modules/camera/common/PictureSavedEvent;", "getOnPictureSaved", "onPictureSaved$delegate", "orientationEventListener", "Landroid/view/OrientationEventListener;", "getOrientationEventListener", "()Landroid/view/OrientationEventListener;", "orientationEventListener$delegate", "Lkotlin/Lazy;", "", "pictureSize", "getPictureSize", "()Ljava/lang/String;", "setPictureSize", "(Ljava/lang/String;)V", "previewPaused", "previewView", "Landroidx/camera/view/PreviewView;", "providerFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lexpo/modules/camera/records/CameraRatio;", "ratio", "getRatio", "()Lexpo/modules/camera/records/CameraRatio;", "setRatio", "(Lexpo/modules/camera/records/CameraRatio;)V", "recorder", "Landroidx/camera/video/Recorder;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "shouldCreateCamera", "shouldScanBarcodes", "Lexpo/modules/camera/records/VideoQuality;", "videoQuality", "getVideoQuality", "()Lexpo/modules/camera/records/VideoQuality;", "setVideoQuality", "(Lexpo/modules/camera/records/VideoQuality;)V", "buildResolutionSelector", "Landroidx/camera/core/resolutionselector/ResolutionSelector;", "cancelCoroutineScope", "", "createCamera", "createImageAnalyzer", "createVideoCapture", "Landroidx/camera/video/VideoCapture;", "getAvailablePictureSizes", "getCornerPointsAndBoundingBox", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "cornerPoints", "", "boundingBox", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult$BoundingBox;", "getDeviceOrientation", "getPreviewSizeAsArray", "", "observeCameraState", "cameraInfo", "Landroidx/camera/core/CameraInfo;", OptionalModuleUtils.BARCODE, "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", ViewProps.ON_LAYOUT, "changed", "left", "top", "right", ViewProps.BOTTOM, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", Response.TYPE, "onViewAdded", "child", "Landroid/view/View;", "pausePreview", "record", "options", "Lexpo/modules/camera/RecordingOptions;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "cacheDirectory", "Ljava/io/File;", "releaseCamera", "Lkotlinx/coroutines/Job;", "resumePreview", "setBarcodeScannerSettings", "settings", "Lexpo/modules/camera/records/BarcodeSettings;", "setCameraFlashMode", ModeProp.name, "Lexpo/modules/camera/records/FlashMode;", "setPreviewTexture", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "setShouldScanBarcodes", "setTorchEnabled", "enabled", "startFocusMetering", "takePicture", "Lexpo/modules/camera/PictureOptions;", "transformBarcodeScannerResultToViewCoordinates", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpoCameraView extends ExpoView implements CameraViewInterface {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ExpoCameraView.class, "enableTorch", "getEnableTorch()Z", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onCameraReady", "getOnCameraReady()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onMountError", "getOnMountError()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onBarcodeScanned", "getOnBarcodeScanned()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoCameraView.class, "onPictureSaved", "getOnPictureSaved()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    private Recording activeRecording;
    private boolean animateShutter;
    private FocusMode autoFocus;
    private List<? extends BarcodeType> barcodeFormats;
    private Camera camera;
    private CameraMode cameraMode;
    private ProcessCameraProvider cameraProvider;

    /* renamed from: enableTorch$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty enableTorch;
    private ImageAnalysis imageAnalysisUseCase;
    private ImageCapture imageCaptureUseCase;
    private CameraType lensFacing;
    private boolean mirror;
    private boolean mute;

    /* renamed from: onBarcodeScanned$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onBarcodeScanned;

    /* renamed from: onCameraReady$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onCameraReady;

    /* renamed from: onMountError$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMountError;

    /* renamed from: onPictureSaved$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onPictureSaved;

    /* renamed from: orientationEventListener$delegate, reason: from kotlin metadata */
    private final Lazy orientationEventListener;
    private String pictureSize;
    private boolean previewPaused;
    private PreviewView previewView;
    private final ListenableFuture<ProcessCameraProvider> providerFuture;
    private CameraRatio ratio;
    private Recorder recorder;
    private final CoroutineScope scope;
    private boolean shouldCreateCamera;
    private boolean shouldScanBarcodes;
    private VideoQuality videoQuality;

    @Override // expo.modules.interfaces.camera.CameraViewInterface
    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoCameraView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.orientationEventListener = LazyKt.lazy(new Function0<ExpoCameraView$orientationEventListener$2.AnonymousClass1>() { // from class: expo.modules.camera.ExpoCameraView$orientationEventListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r1v0, types: [expo.modules.camera.ExpoCameraView$orientationEventListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                AppCompatActivity currentActivity;
                currentActivity = ExpoCameraView.this.getCurrentActivity();
                return new OrientationEventListener(currentActivity) { // from class: expo.modules.camera.ExpoCameraView$orientationEventListener$2.1
                    {
                        super(currentActivity);
                    }

                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int orientation) {
                        ImageAnalysis imageAnalysis;
                        ImageCapture imageCapture;
                        if (orientation == -1) {
                            return;
                        }
                        int i = (45 > orientation || orientation >= 135) ? (135 > orientation || orientation >= 225) ? (225 > orientation || orientation >= 315) ? 0 : 1 : 2 : 3;
                        imageAnalysis = ExpoCameraView.this.imageAnalysisUseCase;
                        if (imageAnalysis != null) {
                            imageAnalysis.setTargetRotation(i);
                        }
                        imageCapture = ExpoCameraView.this.imageCaptureUseCase;
                        if (imageCapture == null) {
                            return;
                        }
                        imageCapture.setTargetRotation(i);
                    }
                };
            }
        });
        this.providerFuture = ProcessCameraProvider.INSTANCE.getInstance(context);
        this.barcodeFormats = CollectionsKt.emptyList();
        PreviewView previewView = new PreviewView(context);
        previewView.setElevation(0.0f);
        this.previewView = previewView;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.lensFacing = CameraType.BACK;
        this.cameraMode = CameraMode.PICTURE;
        this.autoFocus = FocusMode.OFF;
        this.videoQuality = VideoQuality.VIDEO1080P;
        this.pictureSize = "";
        this.animateShutter = true;
        Delegates delegates = Delegates.INSTANCE;
        final boolean z = false;
        this.enableTorch = new ObservableProperty<Boolean>(z) { // from class: expo.modules.camera.ExpoCameraView$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                boolean booleanValue = newValue.booleanValue();
                oldValue.booleanValue();
                this.setTorchEnabled(booleanValue);
            }
        };
        ExpoCameraView expoCameraView = this;
        this.onCameraReady = new ViewEventDelegate(expoCameraView, null);
        this.onMountError = new ViewEventDelegate(expoCameraView, null);
        this.onBarcodeScanned = new ViewEventDelegate(expoCameraView, new Function1<BarcodeScannedEvent, Short>() { // from class: expo.modules.camera.ExpoCameraView$onBarcodeScanned$2
            @Override // kotlin.jvm.functions.Function1
            public final Short invoke(BarcodeScannedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                return Short.valueOf((short) (event.getData().hashCode() % 32767));
            }
        });
        this.onPictureSaved = new ViewEventDelegate(expoCameraView, new Function1<PictureSavedEvent, Short>() { // from class: expo.modules.camera.ExpoCameraView$onPictureSaved$2
            @Override // kotlin.jvm.functions.Function1
            public final Short invoke(PictureSavedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                String string = event.getData().getString("uri");
                return Short.valueOf((short) ((string != null ? string.hashCode() : -1) % 32767));
            }
        });
        getOrientationEventListener().enable();
        this.previewView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: expo.modules.camera.ExpoCameraView.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View parent, View child) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View parent, View child) {
                if (parent != null) {
                    parent.measure(View.MeasureSpec.makeMeasureSpec(ExpoCameraView.this.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ExpoCameraView.this.getMeasuredHeight(), 1073741824));
                }
                if (parent != null) {
                    parent.layout(0, 0, parent.getMeasuredWidth(), parent.getMeasuredHeight());
                }
            }
        });
        addView(this.previewView, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatActivity getCurrentActivity() {
        Activity currentActivity = getAppContext().getCurrentActivity();
        AppCompatActivity appCompatActivity = currentActivity instanceof AppCompatActivity ? (AppCompatActivity) currentActivity : null;
        if (appCompatActivity != null) {
            return appCompatActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    public final OrientationEventListener getOrientationEventListener() {
        return (OrientationEventListener) this.orientationEventListener.getValue();
    }

    public final Camera getCamera() {
        return this.camera;
    }

    public final void setCamera(Camera camera) {
        this.camera = camera;
    }

    public final Recording getActiveRecording() {
        return this.activeRecording;
    }

    public final void setActiveRecording(Recording recording) {
        this.activeRecording = recording;
    }

    public final CameraType getLensFacing() {
        return this.lensFacing;
    }

    public final void setLensFacing(CameraType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.lensFacing = value;
        this.shouldCreateCamera = true;
    }

    public final CameraMode getCameraMode() {
        return this.cameraMode;
    }

    public final void setCameraMode(CameraMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.cameraMode = value;
        this.shouldCreateCamera = true;
    }

    public final FocusMode getAutoFocus() {
        return this.autoFocus;
    }

    public final void setAutoFocus(FocusMode value) {
        CameraControl cameraControl;
        Intrinsics.checkNotNullParameter(value, "value");
        this.autoFocus = value;
        Camera camera = this.camera;
        if (camera == null || (cameraControl = camera.getCameraControl()) == null) {
            return;
        }
        if (this.autoFocus == FocusMode.OFF) {
            Intrinsics.checkNotNull(cameraControl.cancelFocusAndMetering());
        } else {
            startFocusMetering();
        }
    }

    public final VideoQuality getVideoQuality() {
        return this.videoQuality;
    }

    public final void setVideoQuality(VideoQuality value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.videoQuality = value;
        this.shouldCreateCamera = true;
    }

    public final CameraRatio getRatio() {
        return this.ratio;
    }

    public final void setRatio(CameraRatio cameraRatio) {
        this.ratio = cameraRatio;
        this.shouldCreateCamera = true;
    }

    public final String getPictureSize() {
        return this.pictureSize;
    }

    public final void setPictureSize(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.pictureSize = value;
        this.shouldCreateCamera = true;
    }

    public final boolean getMirror() {
        return this.mirror;
    }

    public final void setMirror(boolean z) {
        this.mirror = z;
        this.shouldCreateCamera = true;
    }

    public final boolean getMute() {
        return this.mute;
    }

    public final void setMute(boolean z) {
        this.mute = z;
    }

    public final boolean getAnimateShutter() {
        return this.animateShutter;
    }

    public final void setAnimateShutter(boolean z) {
        this.animateShutter = z;
    }

    public final boolean getEnableTorch() {
        return ((Boolean) this.enableTorch.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setEnableTorch(boolean z) {
        this.enableTorch.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewEventCallback<Unit> getOnCameraReady() {
        return this.onCameraReady.getValue(this, $$delegatedProperties[1]);
    }

    private final ViewEventCallback<CameraMountErrorEvent> getOnMountError() {
        return this.onMountError.getValue(this, $$delegatedProperties[2]);
    }

    private final ViewEventCallback<BarcodeScannedEvent> getOnBarcodeScanned() {
        return this.onBarcodeScanned.getValue(this, $$delegatedProperties[3]);
    }

    private final ViewEventCallback<PictureSavedEvent> getOnPictureSaved() {
        return this.onPictureSaved.getValue(this, $$delegatedProperties[4]);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChild(this.previewView, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(ViewGroup.resolveSize(this.previewView.getMeasuredWidth(), widthMeasureSpec), ViewGroup.resolveSize(this.previewView.getMeasuredHeight(), heightMeasureSpec));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            this.previewView.layout(0, 0, right - left, bottom - top);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        if (Intrinsics.areEqual(child, this.previewView)) {
            return;
        }
        if (child != null) {
            child.bringToFront();
        }
        removeView(this.previewView);
        addView(this.previewView, 0);
    }

    public final void takePicture(PictureOptions options, Promise promise, File cacheDirectory) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(cacheDirectory, "cacheDirectory");
        Object systemService = getContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        int streamVolume = ((AudioManager) systemService).getStreamVolume(3);
        ImageCapture imageCapture = this.imageCaptureUseCase;
        if (imageCapture != null) {
            imageCapture.m170lambda$takePicture$1$androidxcameracoreImageCapture(ContextCompat.getMainExecutor(getContext()), new ExpoCameraView$takePicture$1(streamVolume, this, options, promise, cacheDirectory));
        }
    }

    public final void setCameraFlashMode(FlashMode mode) {
        ImageCapture imageCapture;
        Intrinsics.checkNotNullParameter(mode, "mode");
        ImageCapture imageCapture2 = this.imageCaptureUseCase;
        if ((imageCapture2 == null || imageCapture2.getFlashMode() != mode.mapToLens()) && (imageCapture = this.imageCaptureUseCase) != null) {
            imageCapture.setFlashMode(mode.mapToLens());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTorchEnabled(boolean enabled) {
        CameraInfo cameraInfo;
        Camera camera;
        CameraControl cameraControl;
        Camera camera2 = this.camera;
        if (camera2 == null || (cameraInfo = camera2.getCameraInfo()) == null || !cameraInfo.hasFlashUnit() || (camera = this.camera) == null || (cameraControl = camera.getCameraControl()) == null) {
            return;
        }
        cameraControl.enableTorch(enabled);
    }

    public final void record(RecordingOptions options, final Promise promise, File cacheDirectory) {
        Unit unit;
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(cacheDirectory, "cacheDirectory");
        FileOutputOptions build = ((FileOutputOptions.Builder) ((FileOutputOptions.Builder) new FileOutputOptions.Builder(FileSystemUtils.INSTANCE.generateOutputFile(cacheDirectory, "Camera", ".mp4")).setFileSizeLimit(options.getMaxFileSize())).setDurationLimitMillis(options.getMaxDuration() * 1000)).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        Recorder recorder = this.recorder;
        if (recorder == null) {
            unit = null;
        } else {
            if (!this.mute && ActivityCompat.checkSelfPermission(getContext(), "android.permission.RECORD_AUDIO") != 0) {
                promise.reject(new Exceptions.MissingPermissions("android.permission.RECORD_AUDIO"));
                return;
            }
            PendingRecording prepareRecording = recorder.prepareRecording(getContext(), build);
            if (!this.mute) {
                prepareRecording.withAudioEnabled();
            }
            this.activeRecording = prepareRecording.start(ContextCompat.getMainExecutor(getContext()), new Consumer() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda4
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ExpoCameraView.record$lambda$6$lambda$5(Promise.this, (VideoRecordEvent) obj);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            promise.reject("E_RECORDING_FAILED", "Starting video recording failed - could not create video file.", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void record$lambda$6$lambda$5(Promise promise, VideoRecordEvent videoRecordEvent) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(promise, "$promise");
        if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
            VideoRecordEvent.Finalize finalize = (VideoRecordEvent.Finalize) videoRecordEvent;
            int error = finalize.getError();
            if (error == 0 || error == 2 || error == 9) {
                Bundle bundle = new Bundle();
                bundle.putString("uri", finalize.getOutputResults().getOutputUri().toString());
                promise.resolve(bundle);
                return;
            }
            Throwable cause = finalize.getCause();
            if (cause == null || (str2 = cause.getMessage()) == null) {
                Throwable cause2 = finalize.getCause();
                if (cause2 == null || (str = cause2.getMessage()) == null) {
                    str = "Unknown error";
                }
                str2 = "Video recording Failed: " + str;
            }
            promise.reject(new CameraExceptions.VideoRecordingFailed(str2));
        }
    }

    public final void createCamera() {
        if (!this.shouldCreateCamera || this.previewPaused) {
            return;
        }
        this.shouldCreateCamera = false;
        this.providerFuture.addListener(new Runnable() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ExpoCameraView.createCamera$lambda$12(ExpoCameraView.this);
            }
        }, ContextCompat.getMainExecutor(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCamera$lambda$12(ExpoCameraView this$0) {
        PreviewView.ScaleType scaleType;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProcessCameraProvider processCameraProvider = this$0.providerFuture.get();
        Intrinsics.checkNotNullExpressionValue(processCameraProvider, "get(...)");
        ProcessCameraProvider processCameraProvider2 = processCameraProvider;
        PreviewView previewView = this$0.previewView;
        if (this$0.ratio == CameraRatio.FOUR_THREE || this$0.ratio == CameraRatio.SIXTEEN_NINE) {
            scaleType = PreviewView.ScaleType.FIT_CENTER;
        } else {
            scaleType = PreviewView.ScaleType.FILL_CENTER;
        }
        previewView.setScaleType(scaleType);
        ResolutionSelector buildResolutionSelector = this$0.buildResolutionSelector();
        Preview build = new Preview.Builder().setResolutionSelector(buildResolutionSelector).build();
        build.setSurfaceProvider(this$0.previewView.getSurfaceProvider());
        Intrinsics.checkNotNullExpressionValue(build, "also(...)");
        CameraSelector build2 = new CameraSelector.Builder().requireLensFacing(this$0.lensFacing.mapToCharacteristic()).build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        this$0.imageCaptureUseCase = new ImageCapture.Builder().setResolutionSelector(buildResolutionSelector).build();
        VideoCapture<Recorder> createVideoCapture = this$0.createVideoCapture();
        this$0.imageAnalysisUseCase = this$0.createImageAnalyzer();
        UseCaseGroup.Builder builder = new UseCaseGroup.Builder();
        builder.addUseCase(build);
        if (this$0.cameraMode == CameraMode.PICTURE) {
            ImageCapture imageCapture = this$0.imageCaptureUseCase;
            if (imageCapture != null) {
                builder.addUseCase(imageCapture);
            }
            ImageAnalysis imageAnalysis = this$0.imageAnalysisUseCase;
            if (imageAnalysis != null) {
                builder.addUseCase(imageAnalysis);
            }
        } else {
            builder.addUseCase(createVideoCapture);
        }
        UseCaseGroup build3 = builder.build();
        Intrinsics.checkNotNullExpressionValue(build3, "build(...)");
        try {
            processCameraProvider2.unbindAll();
            Camera bindToLifecycle = processCameraProvider2.bindToLifecycle(this$0.getCurrentActivity(), build2, build3);
            this$0.camera = bindToLifecycle;
            if (bindToLifecycle != null) {
                CameraInfo cameraInfo = bindToLifecycle.getCameraInfo();
                Intrinsics.checkNotNullExpressionValue(cameraInfo, "getCameraInfo(...)");
                this$0.observeCameraState(cameraInfo);
            }
            this$0.cameraProvider = processCameraProvider2;
        } catch (Exception unused) {
            this$0.getOnMountError().invoke(new CameraMountErrorEvent("Camera component could not be rendered - is there any other instance running?"));
        }
    }

    private final ImageAnalysis createImageAnalyzer() {
        ImageAnalysis build = new ImageAnalysis.Builder().setResolutionSelector(new ResolutionSelector.Builder().setResolutionStrategy(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY).build()).setBackpressureStrategy(0).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        if (this.shouldScanBarcodes) {
            build.setAnalyzer(ContextCompat.getMainExecutor(getContext()), new BarcodeAnalyzer(this.lensFacing, this.barcodeFormats, new Function1<BarCodeScannerResult, Unit>() { // from class: expo.modules.camera.ExpoCameraView$createImageAnalyzer$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BarCodeScannerResult barCodeScannerResult) {
                    invoke2(barCodeScannerResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BarCodeScannerResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ExpoCameraView.this.onBarcodeScanned(it);
                }
            }));
        }
        return build;
    }

    private final ResolutionSelector buildResolutionSelector() {
        ResolutionStrategy resolutionStrategy;
        if (this.pictureSize.length() > 0) {
            resolutionStrategy = new ResolutionStrategy(Size.parseSize(this.pictureSize), 3);
        } else {
            resolutionStrategy = ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY;
            Intrinsics.checkNotNull(resolutionStrategy);
        }
        if (this.ratio == CameraRatio.ONE_ONE) {
            ResolutionSelector build = new ResolutionSelector.Builder().setResolutionFilter(new ResolutionFilter() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda2
                @Override // androidx.camera.core.resolutionselector.ResolutionFilter
                public final List filter(List list, int i) {
                    List buildResolutionSelector$lambda$15;
                    buildResolutionSelector$lambda$15 = ExpoCameraView.buildResolutionSelector$lambda$15(list, i);
                    return buildResolutionSelector$lambda$15;
                }
            }).setResolutionStrategy(resolutionStrategy).build();
            Intrinsics.checkNotNull(build);
            return build;
        }
        ResolutionSelector.Builder builder = new ResolutionSelector.Builder();
        CameraRatio cameraRatio = this.ratio;
        if (cameraRatio != null) {
            builder.setAspectRatioStrategy(cameraRatio.mapToStrategy());
        }
        builder.setResolutionStrategy(resolutionStrategy);
        ResolutionSelector build2 = builder.build();
        Intrinsics.checkNotNull(build2);
        return build2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List buildResolutionSelector$lambda$15(List supportedSizes, int i) {
        Intrinsics.checkNotNullParameter(supportedSizes, "supportedSizes");
        ArrayList arrayList = new ArrayList();
        for (Object obj : supportedSizes) {
            Size size = (Size) obj;
            if (size.getWidth() == size.getHeight()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final VideoCapture<Recorder> createVideoCapture() {
        Quality mapToQuality = this.videoQuality.mapToQuality();
        FallbackStrategy higherQualityOrLowerThan = FallbackStrategy.higherQualityOrLowerThan(mapToQuality);
        Intrinsics.checkNotNullExpressionValue(higherQualityOrLowerThan, "higherQualityOrLowerThan(...)");
        QualitySelector from = QualitySelector.from(mapToQuality, higherQualityOrLowerThan);
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        Recorder build = new Recorder.Builder().setExecutor(ContextCompat.getMainExecutor(getContext())).setQualitySelector(from).build();
        this.recorder = build;
        Intrinsics.checkNotNullExpressionValue(build, "also(...)");
        VideoCapture.Builder builder = new VideoCapture.Builder(build);
        if (this.mirror) {
            builder.setMirrorMode(2);
        }
        builder.setVideoStabilizationEnabled(true);
        VideoCapture<Recorder> build2 = builder.build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        return build2;
    }

    private final void startFocusMetering() {
        Camera camera = this.camera;
        if (camera != null) {
            FocusMeteringAction build = new FocusMeteringAction.Builder(new DisplayOrientedMeteringPointFactory(this.previewView.getDisplay(), camera.getCameraInfo(), this.previewView.getWidth(), this.previewView.getHeight()).createPoint(1.0f, 1.0f), 1).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            camera.getCameraControl().startFocusAndMetering(build);
        }
    }

    private final void observeCameraState(CameraInfo cameraInfo) {
        LiveData<CameraState> cameraState = cameraInfo.getCameraState();
        AppCompatActivity currentActivity = getCurrentActivity();
        final Function1<CameraState, Unit> function1 = new Function1<CameraState, Unit>() { // from class: expo.modules.camera.ExpoCameraView$observeCameraState$1

            /* compiled from: ExpoCameraView.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[CameraState.Type.values().length];
                    try {
                        iArr[CameraState.Type.OPEN.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CameraState cameraState2) {
                invoke2(cameraState2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CameraState cameraState2) {
                ViewEventCallback onCameraReady;
                if (WhenMappings.$EnumSwitchMapping$0[cameraState2.getType().ordinal()] == 1) {
                    onCameraReady = ExpoCameraView.this.getOnCameraReady();
                    onCameraReady.invoke(Unit.INSTANCE);
                    ExpoCameraView expoCameraView = ExpoCameraView.this;
                    expoCameraView.setTorchEnabled(expoCameraView.getEnableTorch());
                }
            }
        };
        cameraState.observe(currentActivity, new Observer() { // from class: expo.modules.camera.ExpoCameraView$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExpoCameraView.observeCameraState$lambda$21(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeCameraState$lambda$21(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final List<String> getAvailablePictureSizes() {
        CameraInfo cameraInfo;
        ArrayList arrayList;
        Size[] outputSizes;
        Camera camera = this.camera;
        if (camera != null && (cameraInfo = camera.getCameraInfo()) != null) {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) Camera2CameraInfo.from(cameraInfo).getCameraCharacteristic(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null || (outputSizes = streamConfigurationMap.getOutputSizes(256)) == null) {
                arrayList = null;
            } else {
                Intrinsics.checkNotNull(outputSizes);
                ArrayList arrayList2 = new ArrayList(outputSizes.length);
                for (Size size : outputSizes) {
                    String size2 = size.toString();
                    Intrinsics.checkNotNullExpressionValue(size2, "toString(...)");
                    arrayList2.add(size2);
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                return arrayList;
            }
        }
        return CollectionsKt.emptyList();
    }

    public final void resumePreview() {
        this.shouldCreateCamera = true;
        this.previewPaused = false;
        createCamera();
    }

    public final void pausePreview() {
        this.previewPaused = true;
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
    }

    public final void setShouldScanBarcodes(boolean shouldScanBarcodes) {
        this.shouldScanBarcodes = shouldScanBarcodes;
        this.shouldCreateCamera = true;
    }

    public final void setBarcodeScannerSettings(BarcodeSettings settings) {
        List<BarcodeType> emptyList;
        if (settings == null || (emptyList = settings.getBarcodeTypes()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        this.barcodeFormats = emptyList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        r0 = r0.getDisplay();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int getDeviceOrientation() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L1d
            expo.modules.kotlin.AppContext r0 = r2.getAppContext()
            android.app.Activity r0 = r0.getCurrentActivity()
            if (r0 == 0) goto L1b
            android.view.Display r0 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m(r0)
            if (r0 == 0) goto L1b
            int r0 = r0.getRotation()
            goto L36
        L1b:
            r0 = 0
            goto L36
        L1d:
            android.content.Context r0 = r2.getContext()
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            java.lang.String r1 = "null cannot be cast to non-null type android.view.WindowManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            int r0 = r0.getRotation()
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.camera.ExpoCameraView.getDeviceOrientation():int");
    }

    public final Job releaseCamera() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(getAppContext().getMainQueue(), null, null, new ExpoCameraView$releaseCamera$1(this, null), 3, null);
        return launch$default;
    }

    private final void transformBarcodeScannerResultToViewCoordinates(BarCodeScannerResult barcode) {
        List<Integer> cornerPoints = barcode.getCornerPoints();
        int width = this.previewView.getWidth();
        int height = this.previewView.getHeight();
        boolean z = this.lensFacing == CameraType.FRONT;
        boolean z2 = getDeviceOrientation() % 2 == 0;
        boolean z3 = getDeviceOrientation() % 2 != 0;
        if (z && z2) {
            Intrinsics.checkNotNull(cornerPoints);
            IntProgression step = RangesKt.step(RangesKt.until(0, cornerPoints.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    int referenceImageHeight = barcode.getReferenceImageHeight();
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
        if (z && z3) {
            Intrinsics.checkNotNull(cornerPoints);
            IntProgression step3 = RangesKt.step(RangesKt.until(1, cornerPoints.size()), 2);
            int first2 = step3.getFirst();
            int last2 = step3.getLast();
            int step4 = step3.getStep();
            if ((step4 > 0 && first2 <= last2) || (step4 < 0 && last2 <= first2)) {
                while (true) {
                    int referenceImageWidth = barcode.getReferenceImageWidth();
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
        Intrinsics.checkNotNull(cornerPoints);
        IntProgression step5 = RangesKt.step(RangesKt.until(1, cornerPoints.size()), 2);
        int first3 = step5.getFirst();
        int last3 = step5.getLast();
        int step6 = step5.getStep();
        if ((step6 > 0 && first3 <= last3) || (step6 < 0 && last3 <= first3)) {
            while (true) {
                cornerPoints.set(first3, Integer.valueOf(MathKt.roundToInt((cornerPoints.get(first3).intValue() * width) / barcode.getReferenceImageWidth())));
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
                cornerPoints.set(first4, Integer.valueOf(MathKt.roundToInt((cornerPoints.get(first4).intValue() * height) / barcode.getReferenceImageHeight())));
                if (first4 == last4) {
                    break;
                } else {
                    first4 += step8;
                }
            }
        }
        barcode.setCornerPoints(cornerPoints);
        barcode.setReferenceImageHeight(getHeight());
        barcode.setReferenceImageWidth(getWidth());
    }

    private final Pair<ArrayList<Bundle>, Bundle> getCornerPointsAndBoundingBox(List<Integer> cornerPoints, BarCodeScannerResult.BoundingBox boundingBox) {
        float f = this.previewView.getResources().getDisplayMetrics().density;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBarcodeScanned(BarCodeScannerResult barcode) {
        if (this.shouldScanBarcodes) {
            transformBarcodeScannerResultToViewCoordinates(barcode);
            List<Integer> cornerPoints = barcode.getCornerPoints();
            Intrinsics.checkNotNullExpressionValue(cornerPoints, "getCornerPoints(...)");
            BarCodeScannerResult.BoundingBox boundingBox = barcode.getBoundingBox();
            Intrinsics.checkNotNullExpressionValue(boundingBox, "getBoundingBox(...)");
            Pair<ArrayList<Bundle>, Bundle> cornerPointsAndBoundingBox = getCornerPointsAndBoundingBox(cornerPoints, boundingBox);
            ArrayList<Bundle> component1 = cornerPointsAndBoundingBox.component1();
            Bundle component2 = cornerPointsAndBoundingBox.component2();
            ViewEventCallback<BarcodeScannedEvent> onBarcodeScanned = getOnBarcodeScanned();
            int id = getId();
            String value = barcode.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            String raw = barcode.getRaw();
            Intrinsics.checkNotNullExpressionValue(raw, "getRaw(...)");
            onBarcodeScanned.invoke(new BarcodeScannedEvent(id, value, raw, BarcodeType.INSTANCE.mapFormatToString(barcode.getType()), component1, component2));
        }
    }

    @Override // expo.modules.interfaces.camera.CameraViewInterface
    public int[] getPreviewSizeAsArray() {
        return new int[]{this.previewView.getWidth(), this.previewView.getHeight()};
    }

    public final void onPictureSaved(Bundle response) {
        Intrinsics.checkNotNullParameter(response, "response");
        ViewEventCallback<PictureSavedEvent> onPictureSaved = getOnPictureSaved();
        int i = response.getInt("id");
        Bundle bundle = response.getBundle("data");
        Intrinsics.checkNotNull(bundle);
        onPictureSaved.invoke(new PictureSavedEvent(i, bundle));
    }

    public final Object cancelCoroutineScope() {
        try {
            CoroutineScopeKt.cancel(this.scope, new ModuleDestroyedException(null, 1, null));
            return Unit.INSTANCE;
        } catch (Exception unused) {
            return Integer.valueOf(Log.e(CameraViewModule.INSTANCE.getTAG$expo_camera_release(), "The scope does not have a job in it"));
        }
    }
}
