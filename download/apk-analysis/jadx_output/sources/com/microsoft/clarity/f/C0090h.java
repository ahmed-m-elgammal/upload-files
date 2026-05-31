package com.microsoft.clarity.f;

import com.microsoft.clarity.e.C0075s;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.display.DisallowedScreenDisplayFrame;
import com.microsoft.clarity.models.display.IDisplayFrame;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import com.microsoft.clarity.models.ingest.WebViewMutationEvent;
import com.microsoft.clarity.models.observers.ErrorDisplayFrame;
import com.microsoft.clarity.models.observers.FramePicture;
import com.microsoft.clarity.models.observers.NetworkDisconnectedEvent;
import com.microsoft.clarity.models.observers.ObservedEvent;
import com.microsoft.clarity.models.observers.ObservedWebViewEvent;
import com.microsoft.clarity.models.observers.SerializedWebViewEvent;
import com.microsoft.clarity.models.observers.UserInteraction;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* renamed from: com.microsoft.clarity.f.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0090h extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f118a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ C0075s d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0090h(q qVar, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, C0075s c0075s) {
        super(0);
        this.f118a = qVar;
        this.b = objectRef;
        this.c = objectRef2;
        this.d = c0075s;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.microsoft.clarity.models.observers.ObservedEvent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16, types: [T, com.microsoft.clarity.models.telemetry.ErrorType] */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, com.microsoft.clarity.models.telemetry.ErrorType] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ?? event = (ObservedEvent) this.f118a.o.take();
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Queue size: " + this.f118a.o.size() + '.');
        if (event instanceof FramePicture) {
            this.b.element = ErrorType.PictureProcessing;
            Ref.ObjectRef objectRef = this.c;
            Intrinsics.checkNotNullExpressionValue(event, "event");
            objectRef.element = event;
            q qVar = this.f118a;
            com.microsoft.clarity.m.m.a("Clarity_ProcessPicture", qVar.i, new C0089g(qVar, (FramePicture) event, this.d));
        } else if (event instanceof UserInteraction) {
            this.b.element = ErrorType.UserInteractionProcessing;
            q.a(this.f118a, ((UserInteraction) event).getAnalyticsEvent());
        } else if (event instanceof ObservedWebViewEvent) {
            q qVar2 = this.f118a;
            Intrinsics.checkNotNullExpressionValue(event, "event");
            ObservedWebViewEvent observedWebViewEvent = (ObservedWebViewEvent) event;
            qVar2.getClass();
            if ((observedWebViewEvent instanceof SerializedWebViewEvent) && ((SerializedWebViewEvent) observedWebViewEvent).isAnalyticsEvent()) {
                WebViewAnalyticsEvent event2 = new WebViewAnalyticsEvent(observedWebViewEvent.getTimestamp(), observedWebViewEvent.getData(), observedWebViewEvent.getWebViewHashCode(), observedWebViewEvent.getScreenMetadata(), observedWebViewEvent.getType());
                ArrayList arrayList = qVar2.m;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    r rVar = (r) it.next();
                    rVar.getClass();
                    Intrinsics.checkNotNullParameter(event2, "event");
                    rVar.f126a.b.a(event2);
                    arrayList2.add(Unit.INSTANCE);
                }
            } else {
                WebViewMutationEvent event3 = new WebViewMutationEvent(observedWebViewEvent.getTimestamp(), observedWebViewEvent.getData(), observedWebViewEvent.getWebViewHashCode(), observedWebViewEvent.getScreenMetadata(), observedWebViewEvent.getType(), observedWebViewEvent.getUrl());
                ArrayList arrayList3 = qVar2.m;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    r rVar2 = (r) it2.next();
                    rVar2.getClass();
                    Intrinsics.checkNotNullParameter(event3, "event");
                    rVar2.f126a.b.a(event3);
                    arrayList4.add(Unit.INSTANCE);
                }
            }
        } else if (event instanceof ErrorDisplayFrame) {
            q qVar3 = this.f118a;
            Intrinsics.checkNotNullExpressionValue(event, "event");
            ErrorDisplayFrame errorDisplayFrame = (ErrorDisplayFrame) event;
            Iterator it3 = qVar3.m.iterator();
            while (it3.hasNext()) {
                r rVar3 = (r) it3.next();
                rVar3.getClass();
                Intrinsics.checkNotNullParameter(errorDisplayFrame, "errorDisplayFrame");
                rVar3.f126a.b.a(errorDisplayFrame);
            }
        } else if (event instanceof DisallowedScreenDisplayFrame) {
            q qVar4 = this.f118a;
            Intrinsics.checkNotNullExpressionValue(event, "event");
            IDisplayFrame frame = (IDisplayFrame) event;
            Iterator it4 = qVar4.m.iterator();
            while (it4.hasNext()) {
                r rVar4 = (r) it4.next();
                rVar4.getClass();
                Intrinsics.checkNotNullParameter(frame, "frame");
                rVar4.f126a.b.a(frame);
            }
        } else if (event instanceof NetworkDisconnectedEvent) {
            Iterator it5 = this.f118a.m.iterator();
            while (it5.hasNext()) {
                ((r) it5.next()).f126a.b.d();
            }
        }
        return Unit.INSTANCE;
    }
}
