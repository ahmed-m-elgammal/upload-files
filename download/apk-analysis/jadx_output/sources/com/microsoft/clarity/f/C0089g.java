package com.microsoft.clarity.f;

import com.microsoft.clarity.e.C0075s;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.IDisplayFrame;
import com.microsoft.clarity.models.observers.FramePicture;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.microsoft.clarity.f.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0089g extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f117a;
    public final /* synthetic */ FramePicture b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0089g(q qVar, FramePicture framePicture, C0075s c0075s) {
        super(0);
        this.f117a = qVar;
        this.b = framePicture;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        DisplayFrame frame;
        int i;
        com.microsoft.clarity.e.D d = this.f117a.p;
        FramePicture framePicture = this.b;
        Intrinsics.checkNotNullExpressionValue(framePicture, "event");
        d.getClass();
        Intrinsics.checkNotNullParameter(framePicture, "framePicture");
        framePicture.getPicture().endRecording();
        com.microsoft.clarity.i.z zVar = new com.microsoft.clarity.i.z();
        try {
            HashMap hashMap = com.microsoft.clarity.m.j.f193a;
            Method a2 = com.microsoft.clarity.m.i.a("android.graphics.Picture", "writeToStream", OutputStream.class);
            if (a2 != null) {
                a2.invoke(framePicture.getPicture(), zVar);
            }
            zVar.flush();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zVar, null);
            if (zVar.e != zVar.f177a.length) {
                throw new com.microsoft.clarity.c.c(zVar.e);
            }
            if (framePicture.getIsFullFrame() || !Intrinsics.areEqual(d.e, zVar.a())) {
                d.e = zVar.a();
                try {
                    long timestamp = framePicture.getTimestamp();
                    ViewHierarchy viewHierarchy = framePicture.getViewHierarchy();
                    ScreenMetadata screenMetadata = framePicture.getScreenMetadata();
                    int screenWidth = framePicture.getScreenWidth();
                    int screenHeight = framePicture.getScreenHeight();
                    int keyboardHeight = framePicture.getKeyboardHeight();
                    int systemBackgroundColor = framePicture.getSystemBackgroundColor();
                    float density = framePicture.getDensity();
                    boolean isForceStartNewSessionFirstFrame = framePicture.getIsForceStartNewSessionFirstFrame();
                    Function1<String, Unit> forceStartNewSessionCallback = framePicture.getForceStartNewSessionCallback();
                    boolean isNewPageFirstFrame = framePicture.getIsNewPageFirstFrame();
                    com.microsoft.clarity.i.y yVar = d.d;
                    byte[] byteArray = zVar.f177a;
                    synchronized (zVar) {
                        i = zVar.b;
                    }
                    yVar.getClass();
                    Intrinsics.checkNotNullParameter(byteArray, "byteArray");
                    frame = new DisplayFrame(timestamp, viewHierarchy, screenMetadata, screenWidth, screenHeight, keyboardHeight, systemBackgroundColor, density, isForceStartNewSessionFirstFrame, forceStartNewSessionCallback, isNewPageFirstFrame, yVar.a(new com.microsoft.clarity.i.g(byteArray, 0, i)));
                    d.f60a.a(framePicture, frame);
                    d.b.a(frame, framePicture.getIsFullFrame());
                    com.microsoft.clarity.e.D.a(frame);
                    d.f.a(framePicture);
                } catch (Exception e) {
                    d.a(framePicture, zVar);
                    throw e;
                }
            } else {
                frame = null;
            }
            if (frame == null) {
                return null;
            }
            FramePicture frame2 = this.b;
            q qVar = this.f117a;
            Intrinsics.checkNotNullExpressionValue(frame2, "event");
            Intrinsics.checkNotNullParameter(frame2, "frame");
            Boolean SHOULD_RUN_FRAME_SNAPSHOT_TASK = Boolean.FALSE;
            Intrinsics.checkNotNullExpressionValue(SHOULD_RUN_FRAME_SNAPSHOT_TASK, "SHOULD_RUN_FRAME_SNAPSHOT_TASK");
            Iterator it = qVar.m.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                rVar.getClass();
                Intrinsics.checkNotNullParameter(frame, "frame");
                rVar.f126a.b.a((IDisplayFrame) frame);
            }
            qVar.r = frame2.getViewHierarchy();
            return unit;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(zVar, th);
                throw th2;
            }
        }
    }
}
