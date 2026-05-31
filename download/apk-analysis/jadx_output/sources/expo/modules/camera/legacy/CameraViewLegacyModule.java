package expo.modules.camera.legacy;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.Size;
import expo.modules.camera.legacy.CameraExceptions;
import expo.modules.camera.legacy.tasks.ResolveTakenPictureAsyncTask;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.interfaces.barcodescanner.BarCodeScannerSettings;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.DebugKt;

/* compiled from: CameraViewLegacyModule.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lexpo/modules/camera/legacy/CameraViewLegacyModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "permissionsManager", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissionsManager", "()Lexpo/modules/interfaces/permissions/Permissions;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "findView", "Lexpo/modules/camera/legacy/ExpoCameraView;", "viewTag", "", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraViewLegacyModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        AsyncFunctionComponent asyncFunctionComponent4;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        AsyncFunctionComponent asyncFunctionComponent5;
        AsyncFunctionComponent asyncFunctionComponent6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5;
        AsyncFunctionComponent asyncFunctionComponent7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6;
        AsyncFunctionComponent asyncFunctionComponent8;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7;
        AsyncFunctionComponent asyncFunctionComponent9;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent8;
        AsyncFunctionComponent asyncFunctionComponent10;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent9;
        AsyncFunctionComponent asyncFunctionComponent11;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent10;
        CameraViewLegacyModule cameraViewLegacyModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (cameraViewLegacyModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(cameraViewLegacyModule);
            moduleDefinitionBuilder.Name("ExpoCameraLegacy");
            moduleDefinitionBuilder.Constants(TuplesKt.to("Type", MapsKt.mapOf(TuplesKt.to("front", 1), TuplesKt.to("back", 0))), TuplesKt.to("FlashMode", MapsKt.mapOf(TuplesKt.to(DebugKt.DEBUG_PROPERTY_VALUE_OFF, 0), TuplesKt.to("on", 1), TuplesKt.to("auto", 3), TuplesKt.to("torch", 2))), TuplesKt.to("AutoFocus", MapsKt.mapOf(TuplesKt.to("on", true), TuplesKt.to(DebugKt.DEBUG_PROPERTY_VALUE_OFF, false))), TuplesKt.to(ExifInterface.TAG_WHITE_BALANCE, MapsKt.mapOf(TuplesKt.to("auto", 0), TuplesKt.to("cloudy", 1), TuplesKt.to("sunny", 2), TuplesKt.to("shadow", 3), TuplesKt.to("fluorescent", 4), TuplesKt.to("incandescent", 5))), TuplesKt.to("VideoQuality", MapsKt.mapOf(TuplesKt.to("2160p", 0), TuplesKt.to("1080p", 1), TuplesKt.to("720p", 2), TuplesKt.to("480p", 3), TuplesKt.to("4:3", 4))));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("pausePreview", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        ExpoCameraView findView;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        findView = CameraViewLegacyModule.this.findView(((Integer) promise).intValue());
                        if (findView.getCameraView().isCameraOpened()) {
                            findView.getCameraView().pausePreview();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }))};
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        ExpoCameraView findView;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        findView = CameraViewLegacyModule.this.findView(((Number) objArr[0]).intValue());
                        if (findView.getCameraView().isCameraOpened()) {
                            findView.getCameraView().pausePreview();
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("pausePreview", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("pausePreview", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("pausePreview", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("pausePreview", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("pausePreview", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("pausePreview", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("pausePreview", asyncFunctionWithPromiseComponent);
            asyncFunctionWithPromiseComponent.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("resumePreview", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        ExpoCameraView findView;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        findView = CameraViewLegacyModule.this.findView(((Integer) promise).intValue());
                        if (findView.getCameraView().isCameraOpened()) {
                            findView.getCameraView().resumePreview();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }))};
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        ExpoCameraView findView;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        findView = CameraViewLegacyModule.this.findView(((Number) objArr[0]).intValue());
                        if (findView.getCameraView().isCameraOpened()) {
                            findView.getCameraView().resumePreview();
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("resumePreview", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("resumePreview", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("resumePreview", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("resumePreview", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("resumePreview", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("resumePreview", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("resumePreview", asyncFunctionWithPromiseComponent2);
            asyncFunctionWithPromiseComponent2.runOnQueue(Queues.MAIN);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent11 = new AsyncFunctionWithPromiseComponent("takePicture", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(PictureOptions.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunctionWithPromise$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(PictureOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunctionWithPromise$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunctionWithPromise$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    ExpoCameraView findView;
                    File cacheDirectory;
                    File cacheDirectory2;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    PictureOptions pictureOptions = (PictureOptions) obj;
                    findView = CameraViewLegacyModule.this.findView(((Number) objArr[1]).intValue());
                    if (!EmulatorUtilities.INSTANCE.isRunningOnEmulator()) {
                        if (findView.getCameraView().isCameraOpened()) {
                            cacheDirectory2 = CameraViewLegacyModule.this.getCacheDirectory();
                            findView.takePicture(pictureOptions, promise, cacheDirectory2);
                            return;
                        }
                        throw new CameraExceptions.CameraIsNotRunning();
                    }
                    byte[] generateSimulatorPhoto = CameraViewHelper.INSTANCE.generateSimulatorPhoto(findView.getWidth(), findView.getHeight());
                    cacheDirectory = CameraViewLegacyModule.this.getCacheDirectory();
                    new ResolveTakenPictureAsyncTask(generateSimulatorPhoto, promise, pictureOptions, cacheDirectory, findView).execute(new Void[0]);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("takePicture", asyncFunctionWithPromiseComponent11);
            asyncFunctionWithPromiseComponent11.runOnQueue(Queues.MAIN);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent12 = new AsyncFunctionWithPromiseComponent("record", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(RecordingOptions.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunctionWithPromise$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(RecordingOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunctionWithPromise$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunctionWithPromise$6
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    ExpoCameraView findView;
                    File cacheDirectory;
                    Permissions permissionsManager;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    int intValue = ((Number) objArr[1]).intValue();
                    RecordingOptions recordingOptions = (RecordingOptions) obj;
                    if (!recordingOptions.getMute()) {
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        if (!permissionsManager.hasGrantedPermissions("android.permission.RECORD_AUDIO")) {
                            throw new Exceptions.MissingPermissions("android.permission.RECORD_AUDIO");
                        }
                    }
                    findView = CameraViewLegacyModule.this.findView(intValue);
                    if (findView.getCameraView().isCameraOpened()) {
                        cacheDirectory = CameraViewLegacyModule.this.getCacheDirectory();
                        findView.record(recordingOptions, promise, cacheDirectory);
                        return;
                    }
                    throw new CameraExceptions.CameraIsNotRunning();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("record", asyncFunctionWithPromiseComponent12);
            asyncFunctionWithPromiseComponent12.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("stopRecording", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$7
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        ExpoCameraView findView;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        findView = CameraViewLegacyModule.this.findView(((Integer) promise).intValue());
                        if (findView.getCameraView().isCameraOpened()) {
                            findView.getCameraView().stopRecording();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr3 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }))};
                Function1<Object[], Unit> function13 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        ExpoCameraView findView;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        findView = CameraViewLegacyModule.this.findView(((Number) objArr[0]).intValue());
                        if (findView.getCameraView().isCameraOpened()) {
                            findView.getCameraView().stopRecording();
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("stopRecording", anyTypeArr3, function13);
                                } else {
                                    asyncFunctionComponent3 = new AsyncFunctionComponent("stopRecording", anyTypeArr3, function13);
                                }
                            } else {
                                asyncFunctionComponent3 = new FloatAsyncFunctionComponent("stopRecording", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("stopRecording", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new BoolAsyncFunctionComponent("stopRecording", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("stopRecording", anyTypeArr3, function13);
                }
                asyncFunctionWithPromiseComponent3 = asyncFunctionComponent3;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("stopRecording", asyncFunctionWithPromiseComponent3);
            asyncFunctionWithPromiseComponent3.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("getSupportedRatios", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$10
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        ExpoCameraView findView;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        findView = CameraViewLegacyModule.this.findView(((Integer) promise).intValue());
                        if (!findView.getCameraView().isCameraOpened()) {
                            throw new CameraExceptions.CameraIsNotRunning();
                        }
                        Set<AspectRatio> supportedAspectRatios = findView.getCameraView().getSupportedAspectRatios();
                        Intrinsics.checkNotNullExpressionValue(supportedAspectRatios, "getSupportedAspectRatios(...)");
                        Set<AspectRatio> set = supportedAspectRatios;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                        Iterator<T> it = set.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((AspectRatio) it.next()).toString());
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }))};
                Function1<Object[], List<? extends String>> function14 = new Function1<Object[], List<? extends String>>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$12
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final List<? extends String> invoke(Object[] objArr) {
                        ExpoCameraView findView;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        findView = CameraViewLegacyModule.this.findView(((Number) objArr[0]).intValue());
                        if (!findView.getCameraView().isCameraOpened()) {
                            throw new CameraExceptions.CameraIsNotRunning();
                        }
                        Set<AspectRatio> supportedAspectRatios = findView.getCameraView().getSupportedAspectRatios();
                        Intrinsics.checkNotNullExpressionValue(supportedAspectRatios, "getSupportedAspectRatios(...)");
                        Set<AspectRatio> set = supportedAspectRatios;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                        Iterator<T> it = set.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((AspectRatio) it.next()).toString());
                        }
                        return arrayList;
                    }
                };
                if (!Intrinsics.areEqual(List.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(List.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(List.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(List.class, String.class)) {
                                    asyncFunctionComponent4 = new StringAsyncFunctionComponent("getSupportedRatios", anyTypeArr4, function14);
                                } else {
                                    asyncFunctionComponent4 = new AsyncFunctionComponent("getSupportedRatios", anyTypeArr4, function14);
                                }
                            } else {
                                asyncFunctionComponent4 = new FloatAsyncFunctionComponent("getSupportedRatios", anyTypeArr4, function14);
                            }
                        } else {
                            asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("getSupportedRatios", anyTypeArr4, function14);
                        }
                    } else {
                        asyncFunctionComponent4 = new BoolAsyncFunctionComponent("getSupportedRatios", anyTypeArr4, function14);
                    }
                } else {
                    asyncFunctionComponent4 = new IntAsyncFunctionComponent("getSupportedRatios", anyTypeArr4, function14);
                }
                asyncFunctionWithPromiseComponent4 = asyncFunctionComponent4;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getSupportedRatios", asyncFunctionWithPromiseComponent4);
            asyncFunctionWithPromiseComponent4.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }))};
            Function1<Object[], List<? extends String>> function15 = new Function1<Object[], List<? extends String>>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$15
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List<? extends String> invoke(Object[] objArr) {
                    ExpoCameraView findView;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    String str = (String) obj;
                    findView = CameraViewLegacyModule.this.findView(((Number) objArr[1]).intValue());
                    if (!findView.getCameraView().isCameraOpened()) {
                        throw new CameraExceptions.CameraIsNotRunning();
                    }
                    SortedSet<Size> availablePictureSizes = findView.getCameraView().getAvailablePictureSizes(AspectRatio.parse(str));
                    Intrinsics.checkNotNull(availablePictureSizes);
                    SortedSet<Size> sortedSet = availablePictureSizes;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedSet, 10));
                    Iterator<T> it = sortedSet.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((Size) it.next()).toString());
                    }
                    return arrayList;
                }
            };
            if (!Intrinsics.areEqual(List.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(List.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(List.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(List.class, String.class)) {
                                asyncFunctionComponent5 = new StringAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr5, function15);
                            } else {
                                asyncFunctionComponent5 = new AsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr5, function15);
                            }
                        } else {
                            asyncFunctionComponent5 = new FloatAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr5, function15);
                        }
                    } else {
                        asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr5, function15);
                    }
                } else {
                    asyncFunctionComponent5 = new BoolAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr5, function15);
                }
            } else {
                asyncFunctionComponent5 = new IntAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr5, function15);
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("getAvailablePictureSizes", asyncFunctionComponent5);
            asyncFunctionComponent5.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$16
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.askForPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.CAMERA");
                    }
                });
            } else {
                AnyType[] anyTypeArr6 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$17
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function16 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$18
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.askForPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent6 = new StringAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr6, function16);
                                } else {
                                    asyncFunctionComponent6 = new AsyncFunctionComponent("requestPermissionsAsync", anyTypeArr6, function16);
                                }
                            } else {
                                asyncFunctionComponent6 = new FloatAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr6, function16);
                            }
                        } else {
                            asyncFunctionComponent6 = new DoubleAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr6, function16);
                        }
                    } else {
                        asyncFunctionComponent6 = new BoolAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr6, function16);
                    }
                } else {
                    asyncFunctionComponent6 = new IntAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr6, function16);
                }
                asyncFunctionWithPromiseComponent5 = asyncFunctionComponent6;
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("requestPermissionsAsync", asyncFunctionWithPromiseComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("requestCameraPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$19
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.askForPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.CAMERA");
                    }
                });
            } else {
                AnyType[] anyTypeArr7 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$20
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function17 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$21
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.askForPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent7 = new StringAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr7, function17);
                                } else {
                                    asyncFunctionComponent7 = new AsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr7, function17);
                                }
                            } else {
                                asyncFunctionComponent7 = new FloatAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr7, function17);
                            }
                        } else {
                            asyncFunctionComponent7 = new DoubleAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr7, function17);
                        }
                    } else {
                        asyncFunctionComponent7 = new BoolAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr7, function17);
                    }
                } else {
                    asyncFunctionComponent7 = new IntAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr7, function17);
                }
                asyncFunctionWithPromiseComponent6 = asyncFunctionComponent7;
            }
            moduleDefinitionBuilder8.getAsyncFunctions().put("requestCameraPermissionsAsync", asyncFunctionWithPromiseComponent6);
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("requestMicrophonePermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$22
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.askForPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.RECORD_AUDIO");
                    }
                });
            } else {
                AnyType[] anyTypeArr8 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$23
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function18 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$24
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.askForPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.RECORD_AUDIO");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent8 = new StringAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr8, function18);
                                } else {
                                    asyncFunctionComponent8 = new AsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr8, function18);
                                }
                            } else {
                                asyncFunctionComponent8 = new FloatAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr8, function18);
                            }
                        } else {
                            asyncFunctionComponent8 = new DoubleAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr8, function18);
                        }
                    } else {
                        asyncFunctionComponent8 = new BoolAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr8, function18);
                    }
                } else {
                    asyncFunctionComponent8 = new IntAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr8, function18);
                }
                asyncFunctionWithPromiseComponent7 = asyncFunctionComponent8;
            }
            moduleDefinitionBuilder9.getAsyncFunctions().put("requestMicrophonePermissionsAsync", asyncFunctionWithPromiseComponent7);
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent8 = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$25
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.getPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.CAMERA");
                    }
                });
            } else {
                AnyType[] anyTypeArr9 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$26
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function19 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$27
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.getPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent9 = new StringAsyncFunctionComponent("getPermissionsAsync", anyTypeArr9, function19);
                                } else {
                                    asyncFunctionComponent9 = new AsyncFunctionComponent("getPermissionsAsync", anyTypeArr9, function19);
                                }
                            } else {
                                asyncFunctionComponent9 = new FloatAsyncFunctionComponent("getPermissionsAsync", anyTypeArr9, function19);
                            }
                        } else {
                            asyncFunctionComponent9 = new DoubleAsyncFunctionComponent("getPermissionsAsync", anyTypeArr9, function19);
                        }
                    } else {
                        asyncFunctionComponent9 = new BoolAsyncFunctionComponent("getPermissionsAsync", anyTypeArr9, function19);
                    }
                } else {
                    asyncFunctionComponent9 = new IntAsyncFunctionComponent("getPermissionsAsync", anyTypeArr9, function19);
                }
                asyncFunctionWithPromiseComponent8 = asyncFunctionComponent9;
            }
            moduleDefinitionBuilder10.getAsyncFunctions().put("getPermissionsAsync", asyncFunctionWithPromiseComponent8);
            ModuleDefinitionBuilder moduleDefinitionBuilder11 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent9 = new AsyncFunctionWithPromiseComponent("getCameraPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$28
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.getPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.CAMERA");
                    }
                });
            } else {
                AnyType[] anyTypeArr10 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$29
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function110 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$30
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.getPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent10 = new StringAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr10, function110);
                                } else {
                                    asyncFunctionComponent10 = new AsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr10, function110);
                                }
                            } else {
                                asyncFunctionComponent10 = new FloatAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr10, function110);
                            }
                        } else {
                            asyncFunctionComponent10 = new DoubleAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr10, function110);
                        }
                    } else {
                        asyncFunctionComponent10 = new BoolAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr10, function110);
                    }
                } else {
                    asyncFunctionComponent10 = new IntAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr10, function110);
                }
                asyncFunctionWithPromiseComponent9 = asyncFunctionComponent10;
            }
            moduleDefinitionBuilder11.getAsyncFunctions().put("getCameraPermissionsAsync", asyncFunctionWithPromiseComponent9);
            ModuleDefinitionBuilder moduleDefinitionBuilder12 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent10 = new AsyncFunctionWithPromiseComponent("getMicrophonePermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$31
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.getPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.RECORD_AUDIO");
                    }
                });
            } else {
                AnyType[] anyTypeArr11 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$32
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function111 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$AsyncFunction$33
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Permissions permissionsManager;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        permissionsManager = CameraViewLegacyModule.this.getPermissionsManager();
                        Permissions.CC.getPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.RECORD_AUDIO");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent11 = new StringAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr11, function111);
                                } else {
                                    asyncFunctionComponent11 = new AsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr11, function111);
                                }
                            } else {
                                asyncFunctionComponent11 = new FloatAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr11, function111);
                            }
                        } else {
                            asyncFunctionComponent11 = new DoubleAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr11, function111);
                        }
                    } else {
                        asyncFunctionComponent11 = new BoolAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr11, function111);
                    }
                } else {
                    asyncFunctionComponent11 = new IntAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr11, function111);
                }
                asyncFunctionWithPromiseComponent10 = asyncFunctionComponent11;
            }
            moduleDefinitionBuilder12.getAsyncFunctions().put("getMicrophonePermissionsAsync", asyncFunctionWithPromiseComponent10);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ExpoCameraView.class);
            if (moduleDefinitionBuilder.getViewManagerDefinition() != null) {
                throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
            }
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass, new LazyKType(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$$inlined$View$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ExpoCameraView.class);
                }
            }, 2, null));
            viewDefinitionBuilder.Events("onCameraReady", "onMountError", "onBarCodeScanned", "onFacesDetected", "onFaceDetectionError", "onPictureSaved");
            final Function1<ExpoCameraView, Unit> function112 = new Function1<ExpoCameraView, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView) {
                    invoke2(expoCameraView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view) {
                    Object obj;
                    Intrinsics.checkNotNullParameter(view, "view");
                    try {
                        obj = CameraViewLegacyModule.this.getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
                    } catch (Exception unused) {
                        obj = null;
                    }
                    UIManager uIManager = (UIManager) obj;
                    if (uIManager != null) {
                        uIManager.unregisterLifecycleEventListener(view);
                    }
                    view.getCameraView().stop();
                }
            };
            viewDefinitionBuilder.setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$OnViewDestroysGeneric$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Function1.this.invoke((ExpoCameraView) it);
                }
            });
            viewDefinitionBuilder.getProps().put("type", new ConcreteViewProp("type", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new Function2<ExpoCameraView, Integer, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Integer num) {
                    invoke(expoCameraView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoCameraView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getCameraView().setFacing(i);
                }
            }));
            viewDefinitionBuilder.getProps().put("ratio", new ConcreteViewProp("ratio", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new Function2<ExpoCameraView, String, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, String str) {
                    invoke2(expoCameraView, str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, String str) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (str == null) {
                        return;
                    }
                    view.getCameraView().setAspectRatio(AspectRatio.parse(str));
                }
            }));
            viewDefinitionBuilder.getProps().put("flashMode", new ConcreteViewProp("flashMode", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new Function2<ExpoCameraView, Integer, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Integer num) {
                    invoke(expoCameraView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoCameraView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getCameraView().setFlash(i);
                }
            }));
            viewDefinitionBuilder.getProps().put("autoFocus", new ConcreteViewProp("autoFocus", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            })), new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke(expoCameraView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoCameraView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getCameraView().setAutoFocus(z);
                }
            }));
            viewDefinitionBuilder.getProps().put("focusDepth", new ConcreteViewProp("focusDepth", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Float.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Float.TYPE);
                }
            })), new Function2<ExpoCameraView, Float, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Float f) {
                    invoke(expoCameraView, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoCameraView view, float f) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getCameraView().setFocusDepth(f);
                }
            }));
            viewDefinitionBuilder.getProps().put("zoom", new ConcreteViewProp("zoom", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Float.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Float.TYPE);
                }
            })), new Function2<ExpoCameraView, Float, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Float f) {
                    invoke(expoCameraView, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoCameraView view, float f) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getCameraView().setZoom(f);
                }
            }));
            viewDefinitionBuilder.getProps().put("whiteBalance", new ConcreteViewProp("whiteBalance", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new Function2<ExpoCameraView, Integer, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Integer num) {
                    invoke(expoCameraView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoCameraView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getCameraView().setWhiteBalance(i);
                }
            }));
            viewDefinitionBuilder.getProps().put("pictureSize", new ConcreteViewProp("pictureSize", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new Function2<ExpoCameraView, String, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, String str) {
                    invoke2(expoCameraView, str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, String str) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (str == null) {
                        return;
                    }
                    view.getCameraView().setPictureSize(Size.parse(str));
                }
            }));
            viewDefinitionBuilder.getProps().put("barCodeScannerSettings", new ConcreteViewProp("barCodeScannerSettings", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                }
            })), new Function2<ExpoCameraView, Map<String, ? extends Object>, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$10
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Map<String, ? extends Object> map) {
                    invoke2(expoCameraView, map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Map<String, ? extends Object> map) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (map == null) {
                        return;
                    }
                    view.setBarCodeScannerSettings(new BarCodeScannerSettings(map));
                }
            }));
            viewDefinitionBuilder.getProps().put("useCamera2Api", new ConcreteViewProp("useCamera2Api", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            })), new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$11
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke(expoCameraView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoCameraView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getCameraView().setUsingCamera2Api(z);
                }
            }));
            viewDefinitionBuilder.getProps().put("barCodeScannerEnabled", new ConcreteViewProp("barCodeScannerEnabled", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), true, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Boolean.class);
                }
            })), new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$12
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setShouldScanBarCodes(bool != null ? bool.booleanValue() : false);
                }
            }));
            viewDefinitionBuilder.getProps().put("faceDetectorEnabled", new ConcreteViewProp("faceDetectorEnabled", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), true, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Boolean.class);
                }
            })), new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$13
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setShouldDetectFaces(bool != null ? bool.booleanValue() : false);
                }
            }));
            viewDefinitionBuilder.getProps().put("faceDetectorSettings", new ConcreteViewProp("faceDetectorSettings", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$lambda$16$lambda$15$$inlined$Prop$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Object.class)));
                }
            })), new Function2<ExpoCameraView, Map<String, ? extends Object>, Unit>() { // from class: expo.modules.camera.legacy.CameraViewLegacyModule$definition$1$14$14
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Map<String, ? extends Object> map) {
                    invoke2(expoCameraView, map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Map<String, ? extends Object> map) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setFaceDetectorSettings(map);
                }
            }));
            moduleDefinitionBuilder.setViewManagerDefinition(viewDefinitionBuilder.build());
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Permissions getPermissionsManager() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return permissions;
        }
        throw new Exceptions.PermissionsModuleNotFound();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExpoCameraView findView(int viewTag) {
        ExpoCameraView expoCameraView = (ExpoCameraView) getAppContext().findView(viewTag);
        if (expoCameraView != null) {
            return expoCameraView;
        }
        throw new Exceptions.ViewNotFound(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), viewTag);
    }
}
