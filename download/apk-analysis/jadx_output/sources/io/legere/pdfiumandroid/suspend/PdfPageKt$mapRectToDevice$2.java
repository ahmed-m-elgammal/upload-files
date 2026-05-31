package io.legere.pdfiumandroid.suspend;

import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PdfPageKt.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/Rect;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToDevice$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class PdfPageKt$mapRectToDevice$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Rect>, Object> {
    final /* synthetic */ RectF $coords;
    final /* synthetic */ int $rotate;
    final /* synthetic */ int $sizeX;
    final /* synthetic */ int $sizeY;
    final /* synthetic */ int $startX;
    final /* synthetic */ int $startY;
    int label;
    final /* synthetic */ PdfPageKt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PdfPageKt$mapRectToDevice$2(PdfPageKt pdfPageKt, int i, int i2, int i3, int i4, int i5, RectF rectF, Continuation<? super PdfPageKt$mapRectToDevice$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfPageKt;
        this.$startX = i;
        this.$startY = i2;
        this.$sizeX = i3;
        this.$sizeY = i4;
        this.$rotate = i5;
        this.$coords = rectF;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfPageKt$mapRectToDevice$2(this.this$0, this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Rect> continuation) {
        return ((PdfPageKt$mapRectToDevice$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.this$0.getPage().mapRectToDevice(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords);
    }
}
