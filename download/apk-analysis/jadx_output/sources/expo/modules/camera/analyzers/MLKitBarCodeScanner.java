package expo.modules.camera.analyzers;

import android.graphics.Bitmap;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: MLKitBarcodeAnalyzer.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/camera/analyzers/MLKitBarCodeScanner;", "", "()V", "barCodeTypes", "", "", "barcodeScanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "barcodeScannerOptions", "Lcom/google/mlkit/vision/barcode/BarcodeScannerOptions;", "areNewAndOldBarCodeTypesEqual", "", "newBarCodeTypes", "scan", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSettings", "", "formats", "Companion", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MLKitBarCodeScanner {
    private static final String TAG = "MLKitBarCodeScanner";
    private List<Integer> barCodeTypes;
    private BarcodeScanner barcodeScanner;
    private BarcodeScannerOptions barcodeScannerOptions;

    public MLKitBarCodeScanner() {
        BarcodeScannerOptions build = new BarcodeScannerOptions.Builder().setBarcodeFormats(0, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.barcodeScannerOptions = build;
        BarcodeScanner client = BarcodeScanning.getClient(build);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.barcodeScanner = client;
    }

    public final Object scan(Bitmap bitmap, Continuation<? super List<? extends BarCodeScannerResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MLKitBarCodeScanner$scan$2(bitmap, this, null), continuation);
    }

    public final void setSettings(List<Integer> formats) {
        Intrinsics.checkNotNullParameter(formats, "formats");
        if (areNewAndOldBarCodeTypesEqual(formats)) {
            return;
        }
        Iterator<T> it = formats.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = Integer.valueOf(((Number) next).intValue() | ((Number) it.next()).intValue());
        }
        int intValue = ((Number) next).intValue();
        this.barCodeTypes = formats;
        BarcodeScannerOptions build = new BarcodeScannerOptions.Builder().setBarcodeFormats(intValue, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.barcodeScannerOptions = build;
        BarcodeScanner client = BarcodeScanning.getClient(build);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.barcodeScanner = client;
    }

    private final boolean areNewAndOldBarCodeTypesEqual(List<Integer> newBarCodeTypes) {
        List<Integer> list = this.barCodeTypes;
        if (list == null) {
            return false;
        }
        HashSet hashSet = CollectionsKt.toHashSet(list);
        HashSet hashSet2 = CollectionsKt.toHashSet(newBarCodeTypes);
        if (hashSet.size() != hashSet2.size()) {
            return false;
        }
        hashSet.removeAll(hashSet2);
        return hashSet.isEmpty();
    }
}
