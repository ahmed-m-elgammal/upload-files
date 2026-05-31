package expo.modules.camera.analyzers;

import android.graphics.Bitmap;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MLKitBarcodeAnalyzer.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.camera.analyzers.MLKitBarCodeScanner$scan$2", f = "MLKitBarcodeAnalyzer.kt", i = {0}, l = {28}, m = "invokeSuspend", n = {"inputImage"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class MLKitBarCodeScanner$scan$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends BarCodeScannerResult>>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    Object L$0;
    int label;
    final /* synthetic */ MLKitBarCodeScanner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MLKitBarCodeScanner$scan$2(Bitmap bitmap, MLKitBarCodeScanner mLKitBarCodeScanner, Continuation<? super MLKitBarCodeScanner$scan$2> continuation) {
        super(2, continuation);
        this.$bitmap = bitmap;
        this.this$0 = mLKitBarCodeScanner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MLKitBarCodeScanner$scan$2(this.$bitmap, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends BarCodeScannerResult>> continuation) {
        return ((MLKitBarCodeScanner$scan$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a0 A[Catch: Exception -> 0x00dc, TryCatch #0 {Exception -> 0x00dc, blocks: (B:6:0x0010, B:7:0x0049, B:11:0x005e, B:12:0x0062, B:14:0x0068, B:16:0x0074, B:18:0x007a, B:19:0x0085, B:22:0x0092, B:24:0x00a0, B:26:0x00a4, B:28:0x00c5, B:30:0x008d, B:39:0x002a), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d A[Catch: Exception -> 0x00dc, TryCatch #0 {Exception -> 0x00dc, blocks: (B:6:0x0010, B:7:0x0049, B:11:0x005e, B:12:0x0062, B:14:0x0068, B:16:0x0074, B:18:0x007a, B:19:0x0085, B:22:0x0092, B:24:0x00a0, B:26:0x00a4, B:28:0x00c5, B:30:0x008d, B:39:0x002a), top: B:2:0x0008 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.camera.analyzers.MLKitBarCodeScanner$scan$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
