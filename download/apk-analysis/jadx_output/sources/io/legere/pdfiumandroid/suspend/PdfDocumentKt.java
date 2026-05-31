package io.legere.pdfiumandroid.suspend;

import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfWriteCallback;
import java.io.Closeable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: PdfDocumentKt.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\rJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0086@¢\u0006\u0002\u0010\rJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0018J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0087@¢\u0006\u0002\u0010 J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00132\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001cJ\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0086@¢\u0006\u0002\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006("}, d2 = {"Lio/legere/pdfiumandroid/suspend/PdfDocumentKt;", "Ljava/io/Closeable;", "document", "Lio/legere/pdfiumandroid/PdfDocument;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lio/legere/pdfiumandroid/PdfDocument;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getDocument", "()Lio/legere/pdfiumandroid/PdfDocument;", "close", "", "getDocumentMeta", "Lio/legere/pdfiumandroid/PdfDocument$Meta;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageCharCounts", "", "getPageCount", "", "getTableOfContents", "", "Lio/legere/pdfiumandroid/PdfDocument$Bookmark;", "openPage", "Lio/legere/pdfiumandroid/suspend/PdfPageKt;", "pageIndex", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openPages", "fromIndex", "toIndex", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openTextPage", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "page", "(Lio/legere/pdfiumandroid/suspend/PdfPageKt;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openTextPages", "safeClose", "", "saveAsCopy", "callback", "Lio/legere/pdfiumandroid/PdfWriteCallback;", "(Lio/legere/pdfiumandroid/PdfWriteCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PdfDocumentKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfDocument document;

    public PdfDocumentKt(PdfDocument document, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(document, "document");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.document = document;
        this.dispatcher = dispatcher;
    }

    public final PdfDocument getDocument() {
        return this.document;
    }

    public final Object getPageCount(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfDocumentKt$getPageCount$2(this, null), continuation);
    }

    public final Object getPageCharCounts(Continuation<? super int[]> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfDocumentKt$getPageCharCounts$2(this, null), continuation);
    }

    public final Object openPage(int i, Continuation<? super PdfPageKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfDocumentKt$openPage$2(this, i, null), continuation);
    }

    public final Object openPages(int i, int i2, Continuation<? super List<PdfPageKt>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfDocumentKt$openPages$2(this, i, i2, null), continuation);
    }

    public final Object getDocumentMeta(Continuation<? super PdfDocument.Meta> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfDocumentKt$getDocumentMeta$2(this, null), continuation);
    }

    public final Object getTableOfContents(Continuation<? super List<PdfDocument.Bookmark>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfDocumentKt$getTableOfContents$2(this, null), continuation);
    }

    @Deprecated(message = "use PdfPageKt.openTextPage", replaceWith = @ReplaceWith(expression = "page.openTextPage()", imports = {}))
    public final Object openTextPage(PdfPageKt pdfPageKt, Continuation<? super PdfTextPageKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfDocumentKt$openTextPage$2(this, pdfPageKt, null), continuation);
    }

    public final Object openTextPages(int i, int i2, Continuation<? super List<PdfTextPageKt>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfDocumentKt$openTextPages$2(this, i, i2, null), continuation);
    }

    public final Object saveAsCopy(PdfWriteCallback pdfWriteCallback, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfDocumentKt$saveAsCopy$2(this, pdfWriteCallback, null), continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.document.close();
    }

    public final boolean safeClose() {
        try {
            this.document.close();
            return true;
        } catch (IllegalStateException e) {
            Logger.INSTANCE.e("PdfDocumentKt", e, "PdfDocumentKt.safeClose");
            return false;
        }
    }
}
