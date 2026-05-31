package expo.modules.camera.analyzers;

import android.graphics.Matrix;
import android.media.Image;
import android.util.Log;
import android.util.Size;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import expo.modules.camera.CameraViewHelper;
import expo.modules.camera.records.BarcodeType;
import expo.modules.camera.records.CameraType;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BarcodeAnalyzer.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lexpo/modules/camera/analyzers/BarcodeAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "lensFacing", "Lexpo/modules/camera/records/CameraType;", "formats", "", "Lexpo/modules/camera/records/BarcodeType;", "onComplete", "Lkotlin/Function1;", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "", "(Lexpo/modules/camera/records/CameraType;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "barcodeFormats", "", "barcodeScanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "barcodeScannerOptions", "Lcom/google/mlkit/vision/barcode/BarcodeScannerOptions;", "getOnComplete", "()Lkotlin/jvm/functions/Function1;", "analyze", "imageProxy", "Landroidx/camera/core/ImageProxy;", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BarcodeAnalyzer implements ImageAnalysis.Analyzer {
    private final int barcodeFormats;
    private BarcodeScanner barcodeScanner;
    private BarcodeScannerOptions barcodeScannerOptions;
    private final CameraType lensFacing;
    private final Function1<BarCodeScannerResult, Unit> onComplete;

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public /* synthetic */ Size getDefaultTargetResolution() {
        return ImageAnalysis.Analyzer.CC.$default$getDefaultTargetResolution(this);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public /* synthetic */ int getTargetCoordinateSystem() {
        return ImageAnalysis.Analyzer.CC.$default$getTargetCoordinateSystem(this);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public /* synthetic */ void updateTransform(Matrix matrix) {
        ImageAnalysis.Analyzer.CC.$default$updateTransform(this, matrix);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BarcodeAnalyzer(CameraType lensFacing, List<? extends BarcodeType> formats, Function1<? super BarCodeScannerResult, Unit> onComplete) {
        int intValue;
        Intrinsics.checkNotNullParameter(lensFacing, "lensFacing");
        Intrinsics.checkNotNullParameter(formats, "formats");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        this.lensFacing = lensFacing;
        this.onComplete = onComplete;
        if (formats.isEmpty()) {
            intValue = 0;
        } else {
            List<? extends BarcodeType> list = formats;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((BarcodeType) it.next()).mapToBarcode()));
            }
            Iterator it2 = arrayList.iterator();
            if (!it2.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it2.next();
            while (it2.hasNext()) {
                next = Integer.valueOf(((Number) next).intValue() | ((Number) it2.next()).intValue());
            }
            intValue = ((Number) next).intValue();
        }
        this.barcodeFormats = intValue;
        BarcodeScannerOptions build = new BarcodeScannerOptions.Builder().setBarcodeFormats(intValue, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.barcodeScannerOptions = build;
        BarcodeScanner client = BarcodeScanning.getClient(build);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.barcodeScanner = client;
    }

    public final Function1<BarCodeScannerResult, Unit> getOnComplete() {
        return this.onComplete;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(final ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Image image = imageProxy.getImage();
        if (image != null) {
            final InputImage fromMediaImage = InputImage.fromMediaImage(image, CameraViewHelper.getCorrectCameraRotation(imageProxy.getImageInfo().getRotationDegrees(), this.lensFacing));
            Intrinsics.checkNotNullExpressionValue(fromMediaImage, "fromMediaImage(...)");
            Task<List<Barcode>> process = this.barcodeScanner.process(fromMediaImage);
            final Function1<List<Barcode>, Unit> function1 = new Function1<List<Barcode>, Unit>() { // from class: expo.modules.camera.analyzers.BarcodeAnalyzer$analyze$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<Barcode> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke2(java.util.List<com.google.mlkit.vision.barcode.common.Barcode> r10) {
                    /*
                        r9 = this;
                        boolean r0 = r10.isEmpty()
                        if (r0 == 0) goto L7
                        return
                    L7:
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
                        java.lang.Object r10 = kotlin.collections.CollectionsKt.first(r10)
                        com.google.mlkit.vision.barcode.common.Barcode r10 = (com.google.mlkit.vision.barcode.common.Barcode) r10
                        java.lang.String r0 = r10.getRawValue()
                        if (r0 != 0) goto L26
                        byte[] r0 = r10.getRawBytes()
                        if (r0 == 0) goto L25
                        java.lang.String r1 = new java.lang.String
                        java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
                        r1.<init>(r0, r2)
                        r4 = r1
                        goto L27
                    L25:
                        r0 = 0
                    L26:
                        r4 = r0
                    L27:
                        java.util.ArrayList r0 = new java.util.ArrayList
                        r0.<init>()
                        r5 = r0
                        java.util.List r5 = (java.util.List) r5
                        android.graphics.Point[] r0 = r10.getCornerPoints()
                        if (r0 == 0) goto L5c
                        int r1 = r0.length
                        r2 = 0
                        r3 = r2
                    L38:
                        if (r3 >= r1) goto L5c
                        r6 = r0[r3]
                        int r7 = r6.x
                        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                        int r6 = r6.y
                        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                        r8 = 2
                        java.lang.Integer[] r8 = new java.lang.Integer[r8]
                        r8[r2] = r7
                        r7 = 1
                        r8[r7] = r6
                        java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r8)
                        java.util.Collection r6 = (java.util.Collection) r6
                        r5.addAll(r6)
                        int r3 = r3 + 1
                        goto L38
                    L5c:
                        expo.modules.camera.analyzers.BarcodeAnalyzer r0 = expo.modules.camera.analyzers.BarcodeAnalyzer.this
                        kotlin.jvm.functions.Function1 r0 = r0.getOnComplete()
                        expo.modules.interfaces.barcodescanner.BarCodeScannerResult r8 = new expo.modules.interfaces.barcodescanner.BarCodeScannerResult
                        int r2 = r10.getFormat()
                        java.lang.String r3 = r10.getDisplayValue()
                        com.google.mlkit.vision.common.InputImage r10 = r2
                        int r6 = r10.getWidth()
                        com.google.mlkit.vision.common.InputImage r10 = r2
                        int r7 = r10.getHeight()
                        r1 = r8
                        r1.<init>(r2, r3, r4, r5, r6, r7)
                        r0.invoke(r8)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: expo.modules.camera.analyzers.BarcodeAnalyzer$analyze$1.invoke2(java.util.List):void");
                }
            };
            process.addOnSuccessListener(new OnSuccessListener() { // from class: expo.modules.camera.analyzers.BarcodeAnalyzer$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    BarcodeAnalyzer.analyze$lambda$2(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: expo.modules.camera.analyzers.BarcodeAnalyzer$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    BarcodeAnalyzer.analyze$lambda$3(exc);
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: expo.modules.camera.analyzers.BarcodeAnalyzer$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    BarcodeAnalyzer.analyze$lambda$4(ImageProxy.this, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$3(Exception it) {
        String str;
        Intrinsics.checkNotNullParameter(it, "it");
        Throwable cause = it.getCause();
        if (cause == null || (str = cause.getMessage()) == null) {
            str = "Barcode scanning failed";
        }
        Log.d("SCANNER", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$4(ImageProxy imageProxy, Task it) {
        Intrinsics.checkNotNullParameter(imageProxy, "$imageProxy");
        Intrinsics.checkNotNullParameter(it, "it");
        imageProxy.close();
    }
}
