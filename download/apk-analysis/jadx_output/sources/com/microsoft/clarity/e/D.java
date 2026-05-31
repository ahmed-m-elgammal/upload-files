package com.microsoft.clarity.e;

import android.content.Context;
import com.microsoft.clarity.f.C0093k;
import com.microsoft.clarity.models.MaskingMode;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.commands.ClipRect;
import com.microsoft.clarity.models.display.commands.DisplayCommand;
import com.microsoft.clarity.models.observers.FramePicture;
import com.microsoft.clarity.models.viewhierarchy.WebViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final B f60a;
    public final A b;
    public final com.microsoft.clarity.l.c c;
    public final com.microsoft.clarity.i.y d;
    public String e;
    public final U f;
    public long g;
    public long h;

    public D(Context context, MaskingMode maskingMode, com.microsoft.clarity.i.v skiaParserFactory, C0093k errorCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(maskingMode, "maskingMode");
        Intrinsics.checkNotNullParameter(skiaParserFactory, "skiaParserFactory");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        this.f60a = new B(maskingMode);
        this.b = new A();
        this.c = com.microsoft.clarity.b.a.a(context, "faulty_pictures");
        this.d = new com.microsoft.clarity.i.y(skiaParserFactory, new C(errorCallback));
        this.f = new U(context, maskingMode);
    }

    public static void a(DisplayFrame displayFrame) {
        List<DisplayCommand> commands = displayFrame.getCommands();
        ArrayList arrayList = new ArrayList();
        for (Object obj : commands) {
            if (obj instanceof ClipRect) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            ClipRect clipRect = (ClipRect) next;
            Intrinsics.checkNotNullParameter(clipRect, "clipRect");
            if (((int) clipRect.getRect().getRight()) == 999997 && ((int) clipRect.getRect().getBottom()) == 999997) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Long.valueOf((long) ((ClipRect) it2.next()).getRect().getLeft()));
        }
        for (WebViewData webViewData : displayFrame.getViewHierarchy().getWebViewsData()) {
            if (arrayList3.contains(Long.valueOf(webViewData.getRenderNodeId()))) {
                webViewData.setFoundInDisplayList(true);
            }
        }
    }

    public final void a(FramePicture framePicture, com.microsoft.clarity.i.z skiaPictureStream) {
        int i;
        if (this.h > 50 || framePicture.getTimestamp() - this.g < 60000) {
            return;
        }
        String filename = framePicture.getScreenMetadata().getName() + '_' + framePicture.getTimestamp() + ".bin";
        com.microsoft.clarity.l.c cVar = this.c;
        com.microsoft.clarity.l.d mode = com.microsoft.clarity.l.d.OVERWRITE;
        cVar.getClass();
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(skiaPictureStream, "skiaPictureStream");
        Intrinsics.checkNotNullParameter(mode, "mode");
        byte[] bArr = skiaPictureStream.f177a;
        synchronized (skiaPictureStream) {
            i = skiaPictureStream.b;
        }
        cVar.a(filename, bArr, 0, i, mode);
        this.g = framePicture.getTimestamp();
        this.h += (skiaPictureStream.b() / 1024) / 1024;
    }
}
