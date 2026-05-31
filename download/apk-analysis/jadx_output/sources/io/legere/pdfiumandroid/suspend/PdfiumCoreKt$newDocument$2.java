package io.legere.pdfiumandroid.suspend;

import android.os.ParcelFileDescriptor;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfiumCore;
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

/* compiled from: PdfiumCoreKt.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lio/legere/pdfiumandroid/suspend/PdfDocumentKt;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfiumCoreKt$newDocument$2", f = "PdfiumCoreKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class PdfiumCoreKt$newDocument$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfDocumentKt>, Object> {
    final /* synthetic */ ParcelFileDescriptor $fd;
    int label;
    final /* synthetic */ PdfiumCoreKt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PdfiumCoreKt$newDocument$2(PdfiumCoreKt pdfiumCoreKt, ParcelFileDescriptor parcelFileDescriptor, Continuation<? super PdfiumCoreKt$newDocument$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfiumCoreKt;
        this.$fd = parcelFileDescriptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfiumCoreKt$newDocument$2(this.this$0, this.$fd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfDocumentKt> continuation) {
        return ((PdfiumCoreKt$newDocument$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PdfiumCore pdfiumCore;
        CoroutineDispatcher coroutineDispatcher;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            pdfiumCore = this.this$0.coreInternal;
            PdfDocument newDocument = pdfiumCore.newDocument(this.$fd);
            coroutineDispatcher = this.this$0.dispatcher;
            return new PdfDocumentKt(newDocument, coroutineDispatcher);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
