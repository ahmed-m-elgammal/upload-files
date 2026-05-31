package io.legere.pdfiumandroid.suspend;

import io.legere.pdfiumandroid.PdfPage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PdfDocumentKt.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/legere/pdfiumandroid/suspend/PdfPageKt;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openPages$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class PdfDocumentKt$openPages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PdfPageKt>>, Object> {
    final /* synthetic */ int $fromIndex;
    final /* synthetic */ int $toIndex;
    int label;
    final /* synthetic */ PdfDocumentKt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PdfDocumentKt$openPages$2(PdfDocumentKt pdfDocumentKt, int i, int i2, Continuation<? super PdfDocumentKt$openPages$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfDocumentKt;
        this.$fromIndex = i;
        this.$toIndex = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfDocumentKt$openPages$2(this.this$0, this.$fromIndex, this.$toIndex, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PdfPageKt>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<PdfPageKt>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<PdfPageKt>> continuation) {
        return ((PdfDocumentKt$openPages$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineDispatcher coroutineDispatcher;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<PdfPage> openPages = this.this$0.getDocument().openPages(this.$fromIndex, this.$toIndex);
        PdfDocumentKt pdfDocumentKt = this.this$0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(openPages, 10));
        for (PdfPage pdfPage : openPages) {
            coroutineDispatcher = pdfDocumentKt.dispatcher;
            arrayList.add(new PdfPageKt(pdfPage, coroutineDispatcher));
        }
        return arrayList;
    }
}
