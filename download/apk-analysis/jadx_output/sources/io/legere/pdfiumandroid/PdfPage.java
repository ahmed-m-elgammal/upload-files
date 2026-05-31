package io.legere.pdfiumandroid;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Surface;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.util.ConfigKt;
import io.legere.pdfiumandroid.util.Size;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PdfPage.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 h2\u00020\u0001:\u0001hB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0006\u0010!\u001a\u00020\u0017J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0017J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J>\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005J>\u00100\u001a\u0002012\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203J6\u00105\u001a\u0002062\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0017J6\u00108\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00107\u001a\u000206J\u0011\u00109\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0011\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0082 JI\u0010=\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0082 J \u0010>\u001a\u0004\u0018\u00010\u00052\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0082 ¢\u0006\u0002\u0010AJ\u001b\u0010B\u001a\u0004\u0018\u00010\u00172\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0082 J\u001b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0082 J\u0011\u0010E\u001a\u00020F2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0011\u0010G\u001a\u00020F2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0011\u0010H\u001a\u00020F2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0011\u0010I\u001a\u00020F2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0019\u0010J\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0005H\u0082 J\u0011\u0010L\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0011\u0010M\u001a\u00020<2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0011\u0010N\u001a\u00020F2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J!\u0010O\u001a\u00020#2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0005H\u0082 J\u0011\u0010P\u001a\u00020F2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0019\u0010Q\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0005H\u0082 J\u0011\u0010R\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 JI\u0010S\u001a\u0002012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0082 JC\u0010T\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u000fH\u0082 JK\u0010Z\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\u000fH\u0082 J?\u0010^\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010_\u001a\u00020F2\u0006\u0010`\u001a\u00020\u00172\b\b\u0002\u0010Y\u001a\u00020\u000f2\b\b\u0002\u0010]\u001a\u00020\u000fH\u0082 J\u0006\u0010a\u001a\u00020bJ:\u0010c\u001a\u00020\u00152\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020\u000fJ4\u0010f\u001a\u00020\u00152\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010_\u001a\u00020g2\u0006\u0010`\u001a\u00020\u00172\b\b\u0002\u0010Y\u001a\u00020\u000f2\b\b\u0002\u0010]\u001a\u00020\u000fJD\u0010f\u001a\u00020\u00152\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020\u000f2\b\b\u0002\u0010]\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006i"}, d2 = {"Lio/legere/pdfiumandroid/PdfPage;", "Ljava/io/Closeable;", "doc", "Lio/legere/pdfiumandroid/PdfDocument;", "pageIndex", "", "pagePtr", "", "pageMap", "", "Lio/legere/pdfiumandroid/PdfDocument$PageCount;", "(Lio/legere/pdfiumandroid/PdfDocument;IJLjava/util/Map;)V", "getDoc", "()Lio/legere/pdfiumandroid/PdfDocument;", "isClosed", "", "getPageIndex", "()I", "getPagePtr", "()J", "close", "", "getPageArtBox", "Landroid/graphics/RectF;", "getPageBleedBox", "getPageBoundingBox", "getPageCropBox", "getPageHeight", "screenDpi", "getPageHeightPoint", "getPageLinks", "", "Lio/legere/pdfiumandroid/PdfDocument$Link;", "getPageMediaBox", "getPageSize", "Lio/legere/pdfiumandroid/util/Size;", "getPageTrimBox", "getPageWidth", "getPageWidthPoint", "mapDeviceCoordsToPage", "Landroid/graphics/PointF;", "startX", "startY", "sizeX", "sizeY", "rotate", "deviceX", "deviceY", "mapPageCoordsToDevice", "Landroid/graphics/Point;", "pageX", "", "pageY", "mapRectToDevice", "Landroid/graphics/Rect;", "coords", "mapRectToPage", "nativeClosePage", "nativeClosePages", "pagesPtr", "", "nativeDeviceCoordsToPage", "nativeGetDestPageIndex", "docPtr", "linkPtr", "(JJ)Ljava/lang/Integer;", "nativeGetLinkRect", "nativeGetLinkURI", "", "nativeGetPageArtBox", "", "nativeGetPageBleedBox", "nativeGetPageBoundingBox", "nativeGetPageCropBox", "nativeGetPageHeightPixel", "dpi", "nativeGetPageHeightPoint", "nativeGetPageLinks", "nativeGetPageMediaBox", "nativeGetPageSizeByIndex", "nativeGetPageTrimBox", "nativeGetPageWidthPixel", "nativeGetPageWidthPoint", "nativePageCoordsToDevice", "nativeRenderPage", "surface", "Landroid/view/Surface;", "drawSizeHor", "drawSizeVer", "renderAnnot", "nativeRenderPageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "textMask", "nativeRenderPageBitmapWithMatrix", "matrix", "clipRect", "openTextPage", "Lio/legere/pdfiumandroid/PdfTextPage;", "renderPage", "drawSizeX", "drawSizeY", "renderPageBitmap", "Landroid/graphics/Matrix;", "Companion", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PdfPage implements Closeable {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    private static final String TAG = "PdfPage";
    public static final int TOP = 1;
    private final PdfDocument doc;
    private boolean isClosed;
    private final int pageIndex;
    private final Map<Integer, PdfDocument.PageCount> pageMap;
    private final long pagePtr;

    private final native void nativeClosePage(long pagePtr);

    private final native void nativeClosePages(long[] pagesPtr);

    private final native PointF nativeDeviceCoordsToPage(long pagePtr, int startX, int startY, int sizeX, int sizeY, int rotate, int deviceX, int deviceY);

    private final native Integer nativeGetDestPageIndex(long docPtr, long linkPtr);

    private final native RectF nativeGetLinkRect(long docPtr, long linkPtr);

    private final native String nativeGetLinkURI(long docPtr, long linkPtr);

    private final native float[] nativeGetPageArtBox(long pagePtr);

    private final native float[] nativeGetPageBleedBox(long pagePtr);

    private final native float[] nativeGetPageBoundingBox(long pagePtr);

    private final native float[] nativeGetPageCropBox(long pagePtr);

    private final native int nativeGetPageHeightPixel(long pagePtr, int dpi);

    private final native int nativeGetPageHeightPoint(long pagePtr);

    private final native long[] nativeGetPageLinks(long pagePtr);

    private final native float[] nativeGetPageMediaBox(long pagePtr);

    private final native Size nativeGetPageSizeByIndex(long docPtr, int pageIndex, int dpi);

    private final native float[] nativeGetPageTrimBox(long pagePtr);

    private final native int nativeGetPageWidthPixel(long pagePtr, int dpi);

    private final native int nativeGetPageWidthPoint(long pagePtr);

    private final native Point nativePageCoordsToDevice(long pagePtr, int startX, int startY, int sizeX, int sizeY, int rotate, double pageX, double pageY);

    private final native void nativeRenderPage(long pagePtr, Surface surface, int startX, int startY, int drawSizeHor, int drawSizeVer, boolean renderAnnot);

    private final native void nativeRenderPageBitmap(long pagePtr, Bitmap bitmap, int startX, int startY, int drawSizeHor, int drawSizeVer, boolean renderAnnot, boolean textMask);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeRenderPageBitmapWithMatrix(long pagePtr, Bitmap bitmap, float[] matrix, RectF clipRect, boolean renderAnnot, boolean textMask);

    public PdfPage(PdfDocument doc, int i, long j, Map<Integer, PdfDocument.PageCount> pageMap) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        Intrinsics.checkNotNullParameter(pageMap, "pageMap");
        this.doc = doc;
        this.pageIndex = i;
        this.pagePtr = j;
        this.pageMap = pageMap;
    }

    public final PdfDocument getDoc() {
        return this.doc;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final long getPagePtr() {
        return this.pagePtr;
    }

    public final PdfTextPage openTextPage() {
        return this.doc.openTextPage(this);
    }

    public final int getPageWidth(int screenDpi) {
        int nativeGetPageWidthPixel;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            nativeGetPageWidthPixel = nativeGetPageWidthPixel(this.pagePtr, screenDpi);
        }
        return nativeGetPageWidthPixel;
    }

    public final int getPageHeight(int screenDpi) {
        int nativeGetPageHeightPixel;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            nativeGetPageHeightPixel = nativeGetPageHeightPixel(this.pagePtr, screenDpi);
        }
        return nativeGetPageHeightPixel;
    }

    public final int getPageWidthPoint() {
        int nativeGetPageWidthPoint;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            nativeGetPageWidthPoint = nativeGetPageWidthPoint(this.pagePtr);
        }
        return nativeGetPageWidthPoint;
    }

    public final int getPageHeightPoint() {
        int nativeGetPageHeightPoint;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            nativeGetPageHeightPoint = nativeGetPageHeightPoint(this.pagePtr);
        }
        return nativeGetPageHeightPoint;
    }

    public final RectF getPageCropBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] nativeGetPageCropBox = nativeGetPageCropBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = nativeGetPageCropBox[0];
            rectF.top = nativeGetPageCropBox[1];
            rectF.right = nativeGetPageCropBox[2];
            rectF.bottom = nativeGetPageCropBox[3];
        }
        return rectF;
    }

    public final RectF getPageMediaBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] nativeGetPageMediaBox = nativeGetPageMediaBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = nativeGetPageMediaBox[0];
            rectF.top = nativeGetPageMediaBox[1];
            rectF.right = nativeGetPageMediaBox[2];
            rectF.bottom = nativeGetPageMediaBox[3];
        }
        return rectF;
    }

    public final RectF getPageBleedBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] nativeGetPageBleedBox = nativeGetPageBleedBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = nativeGetPageBleedBox[0];
            rectF.top = nativeGetPageBleedBox[1];
            rectF.right = nativeGetPageBleedBox[2];
            rectF.bottom = nativeGetPageBleedBox[3];
        }
        return rectF;
    }

    public final RectF getPageTrimBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] nativeGetPageTrimBox = nativeGetPageTrimBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = nativeGetPageTrimBox[0];
            rectF.top = nativeGetPageTrimBox[1];
            rectF.right = nativeGetPageTrimBox[2];
            rectF.bottom = nativeGetPageTrimBox[3];
        }
        return rectF;
    }

    public final RectF getPageArtBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] nativeGetPageArtBox = nativeGetPageArtBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = nativeGetPageArtBox[0];
            rectF.top = nativeGetPageArtBox[1];
            rectF.right = nativeGetPageArtBox[2];
            rectF.bottom = nativeGetPageArtBox[3];
        }
        return rectF;
    }

    public final RectF getPageBoundingBox() {
        RectF rectF;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            float[] nativeGetPageBoundingBox = nativeGetPageBoundingBox(this.pagePtr);
            rectF = new RectF();
            rectF.left = nativeGetPageBoundingBox[0];
            rectF.top = nativeGetPageBoundingBox[1];
            rectF.right = nativeGetPageBoundingBox[2];
            rectF.bottom = nativeGetPageBoundingBox[3];
        }
        return rectF;
    }

    public final Size getPageSize(int screenDpi) {
        Size nativeGetPageSizeByIndex;
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            nativeGetPageSizeByIndex = nativeGetPageSizeByIndex(this.doc.getMNativeDocPtr(), this.pageIndex, screenDpi);
        }
        return nativeGetPageSizeByIndex;
    }

    public static /* synthetic */ void renderPage$default(PdfPage pdfPage, Surface surface, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 32) != 0) {
            z = false;
        }
        pdfPage.renderPage(surface, i, i2, i3, i4, z);
    }

    public final void renderPage(Surface surface, int startX, int startY, int drawSizeX, int drawSizeY, boolean renderAnnot) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            try {
                nativeRenderPage(this.pagePtr, surface, startX, startY, drawSizeX, drawSizeY, renderAnnot);
            } catch (NullPointerException e) {
                Logger.INSTANCE.e(TAG, e, "mContext may be null");
            } catch (Exception e2) {
                Logger.INSTANCE.e(TAG, e2, "Exception throw from native");
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void renderPageBitmap(Bitmap bitmap, int startX, int startY, int drawSizeX, int drawSizeY, boolean renderAnnot, boolean textMask) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            nativeRenderPageBitmap(this.pagePtr, bitmap, startX, startY, drawSizeX, drawSizeY, renderAnnot, textMask);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void renderPageBitmap(Bitmap bitmap, Matrix matrix, RectF clipRect, boolean renderAnnot, boolean textMask) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            nativeRenderPageBitmapWithMatrix(this.pagePtr, bitmap, new float[]{fArr[0], fArr[4], fArr[2], fArr[5]}, clipRect, renderAnnot, textMask);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final List<PdfDocument.Link> getPageLinks() {
        ArrayList arrayList;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            arrayList = new ArrayList();
            for (long j : nativeGetPageLinks(this.pagePtr)) {
                Integer nativeGetDestPageIndex = nativeGetDestPageIndex(this.doc.getMNativeDocPtr(), j);
                String nativeGetLinkURI = nativeGetLinkURI(this.doc.getMNativeDocPtr(), j);
                RectF nativeGetLinkRect = nativeGetLinkRect(this.doc.getMNativeDocPtr(), j);
                if (nativeGetLinkRect != null && (nativeGetDestPageIndex != null || nativeGetLinkURI != null)) {
                    arrayList.add(new PdfDocument.Link(nativeGetLinkRect, nativeGetDestPageIndex, nativeGetLinkURI));
                }
            }
        }
        return arrayList;
    }

    public final Point mapPageCoordsToDevice(int startX, int startY, int sizeX, int sizeY, int rotate, double pageX, double pageY) {
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        return nativePageCoordsToDevice(this.pagePtr, startX, startY, sizeX, sizeY, rotate, pageX, pageY);
    }

    public final PointF mapDeviceCoordsToPage(int startX, int startY, int sizeX, int sizeY, int rotate, int deviceX, int deviceY) {
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        return nativeDeviceCoordsToPage(this.pagePtr, startX, startY, sizeX, sizeY, rotate, deviceX, deviceY);
    }

    public final Rect mapRectToDevice(int startX, int startY, int sizeX, int sizeY, int rotate, RectF coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        Point mapPageCoordsToDevice = mapPageCoordsToDevice(startX, startY, sizeX, sizeY, rotate, coords.left, coords.top);
        Point mapPageCoordsToDevice2 = mapPageCoordsToDevice(startX, startY, sizeX, sizeY, rotate, coords.right, coords.bottom);
        return new Rect(mapPageCoordsToDevice.x, mapPageCoordsToDevice.y, mapPageCoordsToDevice2.x, mapPageCoordsToDevice2.y);
    }

    public final RectF mapRectToPage(int startX, int startY, int sizeX, int sizeY, int rotate, Rect coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        if (this.isClosed || this.doc.getIsClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        PointF mapDeviceCoordsToPage = mapDeviceCoordsToPage(startX, startY, sizeX, sizeY, rotate, coords.left, coords.top);
        PointF mapDeviceCoordsToPage2 = mapDeviceCoordsToPage(startX, startY, sizeX, sizeY, rotate, coords.right, coords.bottom);
        return new RectF(mapDeviceCoordsToPage.x, mapDeviceCoordsToPage.y, mapDeviceCoordsToPage2.x, mapDeviceCoordsToPage2.y);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.getIsClosed())) {
            return;
        }
        synchronized (PdfiumCore.INSTANCE.getLock()) {
            PdfDocument.PageCount pageCount = this.pageMap.get(Integer.valueOf(this.pageIndex));
            if (pageCount != null && pageCount.getCount() > 1) {
                pageCount.setCount(pageCount.getCount() - 1);
                return;
            }
            this.pageMap.remove(Integer.valueOf(this.pageIndex));
            this.isClosed = true;
            nativeClosePage(this.pagePtr);
            Unit unit = Unit.INSTANCE;
        }
    }
}
