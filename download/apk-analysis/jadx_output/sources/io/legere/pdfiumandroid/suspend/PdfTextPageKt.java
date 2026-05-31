package io.legere.pdfiumandroid.suspend;

import android.graphics.RectF;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfTextPage;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: PdfTextPageKt.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\f\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ.\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u0004\u0018\u00010\u001b2\u0006\u0010'\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ \u0010(\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006+"}, d2 = {"Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "Ljava/io/Closeable;", "page", "Lio/legere/pdfiumandroid/PdfTextPage;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lio/legere/pdfiumandroid/PdfTextPage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPage", "()Lio/legere/pdfiumandroid/PdfTextPage;", "close", "", "getFontSize", "", "charIndex", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeClose", "", "textPageCountChars", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textPageCountRects", "startIndex", "count", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textPageGetBoundedText", "", "rect", "Landroid/graphics/RectF;", "length", "(Landroid/graphics/RectF;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textPageGetCharBox", "index", "textPageGetCharIndexAtPos", "x", "y", "xTolerance", "yTolerance", "(DDDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textPageGetRect", "rectIndex", "textPageGetText", "textPageGetUnicode", "", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PdfTextPageKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfTextPage page;

    public PdfTextPageKt(PdfTextPage page, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.page = page;
        this.dispatcher = dispatcher;
    }

    public final PdfTextPage getPage() {
        return this.page;
    }

    public final Object textPageCountChars(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfTextPageKt$textPageCountChars$2(this, null), continuation);
    }

    public final Object textPageGetText(int i, int i2, Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfTextPageKt$textPageGetText$2(this, i, i2, null), continuation);
    }

    public final Object textPageGetUnicode(int i, Continuation<? super Character> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfTextPageKt$textPageGetUnicode$2(this, i, null), continuation);
    }

    public final Object textPageGetCharBox(int i, Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfTextPageKt$textPageGetCharBox$2(this, i, null), continuation);
    }

    public final Object textPageGetCharIndexAtPos(double d, double d2, double d3, double d4, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfTextPageKt$textPageGetCharIndexAtPos$2(this, d, d2, d3, d4, null), continuation);
    }

    public final Object textPageCountRects(int i, int i2, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfTextPageKt$textPageCountRects$2(this, i, i2, null), continuation);
    }

    public final Object textPageGetRect(int i, Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfTextPageKt$textPageGetRect$2(this, i, null), continuation);
    }

    public final Object textPageGetBoundedText(RectF rectF, int i, Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfTextPageKt$textPageGetBoundedText$2(this, rectF, i, null), continuation);
    }

    public final Object getFontSize(int i, Continuation<? super Double> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfTextPageKt$getFontSize$2(this, i, null), continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.page.close();
    }

    public final boolean safeClose() {
        try {
            this.page.close();
            return true;
        } catch (IllegalStateException e) {
            Logger.INSTANCE.e("PdfTextPageKt", e, "PdfTextPageKt.safeClose");
            return false;
        }
    }
}
