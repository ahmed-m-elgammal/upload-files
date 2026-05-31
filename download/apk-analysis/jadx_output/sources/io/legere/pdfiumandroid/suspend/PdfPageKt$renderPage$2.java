package io.legere.pdfiumandroid.suspend;

import android.view.Surface;
import io.legere.pdfiumandroid.PdfPage;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPage$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class PdfPageKt$renderPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $drawSizeX;
    final /* synthetic */ int $drawSizeY;
    final /* synthetic */ int $startX;
    final /* synthetic */ int $startY;
    final /* synthetic */ Surface $surface;
    int label;
    final /* synthetic */ PdfPageKt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PdfPageKt$renderPage$2(PdfPageKt pdfPageKt, Surface surface, int i, int i2, int i3, int i4, Continuation<? super PdfPageKt$renderPage$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfPageKt;
        this.$surface = surface;
        this.$startX = i;
        this.$startY = i2;
        this.$drawSizeX = i3;
        this.$drawSizeY = i4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfPageKt$renderPage$2(this.this$0, this.$surface, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PdfPageKt$renderPage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PdfPage.renderPage$default(this.this$0.getPage(), this.$surface, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, false, 32, null);
        return Unit.INSTANCE;
    }
}
