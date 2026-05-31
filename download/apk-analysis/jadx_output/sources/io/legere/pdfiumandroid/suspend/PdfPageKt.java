package io.legere.pdfiumandroid.suspend;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Surface;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfPage;
import io.legere.pdfiumandroid.util.Size;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: PdfPageKt.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000f\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u0010\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\rJ\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u0019\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001c\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u0016\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001e\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\rJF\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010(JF\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0086@¢\u0006\u0002\u0010.J>\u0010/\u001a\u0002002\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u00101\u001a\u00020\fH\u0086@¢\u0006\u0002\u00102J>\u00103\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u00101\u001a\u000200H\u0086@¢\u0006\u0002\u00104J\u000e\u00105\u001a\u000206H\u0086@¢\u0006\u0002\u0010\rJ8\u00107\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010<JJ\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020?2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\b\b\u0002\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020AH\u0086@¢\u0006\u0002\u0010CJ<\u0010=\u001a\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\f2\b\b\u0002\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020AH\u0086@¢\u0006\u0002\u0010GJ\u0006\u0010H\u001a\u00020AR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006I"}, d2 = {"Lio/legere/pdfiumandroid/suspend/PdfPageKt;", "Ljava/io/Closeable;", "page", "Lio/legere/pdfiumandroid/PdfPage;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lio/legere/pdfiumandroid/PdfPage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPage", "()Lio/legere/pdfiumandroid/PdfPage;", "close", "", "getPageArtBox", "Landroid/graphics/RectF;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageBleedBox", "getPageBoundingBox", "getPageCropBox", "getPageHeight", "", "screenDpi", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageHeightPoint", "getPageLinks", "", "Lio/legere/pdfiumandroid/PdfDocument$Link;", "getPageMediaBox", "getPageSize", "Lio/legere/pdfiumandroid/util/Size;", "getPageTrimBox", "getPageWidth", "getPageWidthPoint", "mapDeviceCoordsToPage", "Landroid/graphics/PointF;", "startX", "startY", "sizeX", "sizeY", "rotate", "deviceX", "deviceY", "(IIIIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapPageCoordsToDevice", "Landroid/graphics/Point;", "pageX", "", "pageY", "(IIIIIDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapRectToDevice", "Landroid/graphics/Rect;", "coords", "(IIIIILandroid/graphics/RectF;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapRectToPage", "(IIIIILandroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openTextPage", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "renderPage", "surface", "Landroid/view/Surface;", "drawSizeX", "drawSizeY", "(Landroid/view/Surface;IIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderPageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "renderAnnot", "", "textMask", "(Landroid/graphics/Bitmap;IIIIZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "matrix", "Landroid/graphics/Matrix;", "clipRect", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/RectF;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeClose", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PdfPageKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final PdfPage page;

    public PdfPageKt(PdfPage page, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.page = page;
        this.dispatcher = dispatcher;
    }

    public final PdfPage getPage() {
        return this.page;
    }

    public final Object openTextPage(Continuation<? super PdfTextPageKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$openTextPage$2(this, null), continuation);
    }

    public final Object getPageWidth(int i, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageWidth$2(this, i, null), continuation);
    }

    public final Object getPageHeight(int i, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageHeight$2(this, i, null), continuation);
    }

    public final Object getPageWidthPoint(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageWidthPoint$2(this, null), continuation);
    }

    public final Object getPageHeightPoint(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageHeightPoint$2(this, null), continuation);
    }

    public final Object getPageCropBox(Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageCropBox$2(this, null), continuation);
    }

    public final Object getPageMediaBox(Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageMediaBox$2(this, null), continuation);
    }

    public final Object getPageBleedBox(Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageBleedBox$2(this, null), continuation);
    }

    public final Object getPageTrimBox(Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageTrimBox$2(this, null), continuation);
    }

    public final Object getPageArtBox(Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageArtBox$2(this, null), continuation);
    }

    public final Object getPageBoundingBox(Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageBoundingBox$2(this, null), continuation);
    }

    public final Object getPageSize(int i, Continuation<? super Size> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageSize$2(this, i, null), continuation);
    }

    public final Object renderPage(Surface surface, int i, int i2, int i3, int i4, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatcher, new PdfPageKt$renderPage$2(this, surface, i, i2, i3, i4, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object renderPageBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatcher, new PdfPageKt$renderPageBitmap$2(this, bitmap, i, i2, i3, i4, z, z2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object renderPageBitmap(Bitmap bitmap, Matrix matrix, RectF rectF, boolean z, boolean z2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatcher, new PdfPageKt$renderPageBitmap$4(this, bitmap, matrix, rectF, z, z2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getPageLinks(Continuation<? super List<PdfDocument.Link>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$getPageLinks$2(this, null), continuation);
    }

    public final Object mapPageCoordsToDevice(int i, int i2, int i3, int i4, int i5, double d, double d2, Continuation<? super Point> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$mapPageCoordsToDevice$2(this, i, i2, i3, i4, i5, d, d2, null), continuation);
    }

    public final Object mapDeviceCoordsToPage(int i, int i2, int i3, int i4, int i5, int i6, int i7, Continuation<? super PointF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$mapDeviceCoordsToPage$2(this, i, i2, i3, i4, i5, i6, i7, null), continuation);
    }

    public final Object mapRectToDevice(int i, int i2, int i3, int i4, int i5, RectF rectF, Continuation<? super Rect> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$mapRectToDevice$2(this, i, i2, i3, i4, i5, rectF, null), continuation);
    }

    public final Object mapRectToPage(int i, int i2, int i3, int i4, int i5, Rect rect, Continuation<? super RectF> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfPageKt$mapRectToPage$2(this, i, i2, i3, i4, i5, rect, null), continuation);
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
            Logger.INSTANCE.e("PdfPageKt", e, "PdfPageKt.safeClose");
            return false;
        }
    }
}
