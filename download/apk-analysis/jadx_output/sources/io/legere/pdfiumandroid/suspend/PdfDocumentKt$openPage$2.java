package io.legere.pdfiumandroid.suspend;

import io.legere.pdfiumandroid.PdfPage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PdfDocumentKt.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/suspend/PdfPageKt;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openPage$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class PdfDocumentKt$openPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfPageKt>, Object> {
    final /* synthetic */ int $pageIndex;
    int label;
    final /* synthetic */ PdfDocumentKt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PdfDocumentKt$openPage$2(PdfDocumentKt pdfDocumentKt, int i, Continuation<? super PdfDocumentKt$openPage$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfDocumentKt;
        this.$pageIndex = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfDocumentKt$openPage$2(this.this$0, this.$pageIndex, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfPageKt> continuation) {
        return ((PdfDocumentKt$openPage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineDispatcher coroutineDispatcher;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PdfPage openPage = this.this$0.getDocument().openPage(this.$pageIndex);
            coroutineDispatcher = this.this$0.dispatcher;
            return new PdfPageKt(openPage, coroutineDispatcher);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
