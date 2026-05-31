package com.microsoft.clarity.f;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.work.WorkRequest;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.e.C0058a;
import com.microsoft.clarity.e.C0062e;
import com.microsoft.clarity.e.C0069l;
import com.microsoft.clarity.e.C0070m;
import com.microsoft.clarity.e.C0075s;
import com.microsoft.clarity.e.ComponentCallbacks2C0081y;
import com.microsoft.clarity.e.Q;
import com.microsoft.clarity.g.C0097b;
import com.microsoft.clarity.g.C0098c;
import com.microsoft.clarity.g.C0099d;
import com.microsoft.clarity.g.InterfaceC0100e;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.ingest.analytics.ClickEvent;
import com.microsoft.clarity.models.ingest.analytics.VisibilityEvent;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.models.observers.UserInteraction;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import com.microsoft.clarity.models.viewhierarchy.ViewNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class q implements com.microsoft.clarity.h.b {
    public String A;
    public final Object B;
    public boolean C;
    public boolean D;
    public Function1 E;

    /* renamed from: a, reason: collision with root package name */
    public final Context f125a;
    public final ClarityConfig b;
    public final DynamicConfig c;
    public final InterfaceC0100e d;
    public final com.microsoft.clarity.g.w e;
    public final C0099d f;
    public final com.microsoft.clarity.g.K g;
    public final C0098c h;
    public final Q i;
    public final ComponentCallbacks2C0081y j;
    public final C0075s k;
    public Integer l;
    public final ArrayList m;
    public final com.microsoft.clarity.e.r n;
    public final LinkedBlockingQueue o;
    public final com.microsoft.clarity.e.D p;
    public final C0062e q;
    public ViewHierarchy r;
    public final Handler s;
    public final LinkedHashMap t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public ScreenMetadata z;

    public q(Context context, ClarityConfig config, DynamicConfig dynamicConfig, com.microsoft.clarity.i.v skiaParserFactory, InterfaceC0100e lifecycleObserver, com.microsoft.clarity.g.w userInteractionObserver, C0099d crashObserver, com.microsoft.clarity.g.K k, C0098c callback, Q telemetryTracker, ComponentCallbacks2C0081y memoryTracker, C0075s e2ETestHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
        Intrinsics.checkNotNullParameter(skiaParserFactory, "skiaParserFactory");
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        Intrinsics.checkNotNullParameter(userInteractionObserver, "userInteractionObserver");
        Intrinsics.checkNotNullParameter(crashObserver, "crashObserver");
        Intrinsics.checkNotNullParameter(callback, "connectivityChangeObserver");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        Intrinsics.checkNotNullParameter(memoryTracker, "memoryTracker");
        Intrinsics.checkNotNullParameter(e2ETestHelper, "e2ETestHelper");
        this.f125a = context;
        this.b = config;
        this.c = dynamicConfig;
        this.d = lifecycleObserver;
        this.e = userInteractionObserver;
        this.f = crashObserver;
        this.g = k;
        this.h = callback;
        this.i = telemetryTracker;
        this.j = memoryTracker;
        this.k = e2ETestHelper;
        Intrinsics.checkNotNullParameter(this, "callback");
        com.microsoft.clarity.m.h.d("Register callback.");
        ((com.microsoft.clarity.g.m) lifecycleObserver).b.add(this);
        C0083a callback2 = new C0083a(this);
        Intrinsics.checkNotNullParameter(callback2, "callback");
        com.microsoft.clarity.m.h.d("Register callback.");
        userInteractionObserver.f166a.add(callback2);
        if (k != null) {
            C0084b callback3 = new C0084b(this);
            Intrinsics.checkNotNullParameter(callback3, "callback");
            k.b.add(callback3);
        }
        C0085c callback4 = new C0085c(this);
        callback.getClass();
        Intrinsics.checkNotNullParameter(callback4, "callback");
        com.microsoft.clarity.m.h.d("Register callback.");
        com.microsoft.clarity.g.m mVar = (com.microsoft.clarity.g.m) callback.f147a;
        mVar.getClass();
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.microsoft.clarity.m.h.d("Register callback.");
        mVar.b.add(callback);
        callback.b.add(callback4);
        C0086d callback5 = new C0086d(this);
        Intrinsics.checkNotNullParameter(callback5, "callback");
        com.microsoft.clarity.m.h.d("Register callback.");
        crashObserver.f148a.add(callback5);
        this.m = new ArrayList();
        this.n = new com.microsoft.clarity.e.r(context, config, dynamicConfig, new C0092j(this));
        this.o = new LinkedBlockingQueue();
        this.p = new com.microsoft.clarity.e.D(context, dynamicConfig.getMaskingMode(), skiaParserFactory, new C0093k(this));
        this.q = new C0062e(new C0088f(this));
        a();
        this.s = new Handler(Looper.getMainLooper());
        this.t = new LinkedHashMap();
        this.B = new Object();
        this.C = true;
    }

    @Override // com.microsoft.clarity.h.a
    public final void a(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
    }

    public final void b() {
        if (this.v) {
            return;
        }
        this.e.d = true;
        com.microsoft.clarity.g.K k = this.g;
        if (k != null) {
            k.o = true;
            k.a(k.d);
        }
        this.f.c = true;
        C0098c c0098c = this.h;
        synchronized (c0098c.i) {
            c0098c.c = true;
            Unit unit = Unit.INSTANCE;
        }
        this.v = true;
        com.microsoft.clarity.m.h.e("Capturing events is paused!");
    }

    public final void c() {
        if (this.u || this.w || this.x || !this.v) {
            return;
        }
        this.e.d = false;
        com.microsoft.clarity.g.K k = this.g;
        if (k != null) {
            k.o = false;
        }
        this.f.c = false;
        C0098c c0098c = this.h;
        synchronized (c0098c.i) {
            if (!c0098c.g) {
                c0098c.e = new Timer();
                C0097b c0097b = new C0097b(c0098c);
                c0098c.h = c0097b;
                c0098c.e.schedule(c0097b, 0L, WorkRequest.MIN_BACKOFF_MILLIS);
                c0098c.f = null;
                c0098c.g = true;
            }
            c0098c.c = false;
            Unit unit = Unit.INSTANCE;
        }
        this.v = false;
        com.microsoft.clarity.m.h.d("Capturing events is resumed!");
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.e.r rVar = this.n;
        CollectionsKt.removeAll(rVar.f, C0069l.f88a);
        CollectionsKt.removeAll(rVar.g, C0070m.f89a);
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(activity, "activity");
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Unregister frame capture task for " + activity + '.');
        int hashCode = activity.hashCode();
        if (this.t.containsKey(Integer.valueOf(hashCode))) {
            Handler handler = this.s;
            Object obj = this.t.get(Integer.valueOf(hashCode));
            Intrinsics.checkNotNull(obj);
            handler.removeCallbacks((Runnable) obj);
            this.t.remove(Integer.valueOf(hashCode));
        }
        ScreenMetadata screenMetadata = this.z;
        if (screenMetadata == null) {
            return;
        }
        this.o.add(new UserInteraction(new VisibilityEvent(System.currentTimeMillis(), ScreenMetadata.INSTANCE.create(activity, screenMetadata.getName()), ViewProps.HIDDEN)));
    }

    @Override // com.microsoft.clarity.h.b
    public final void onActivityResumed(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.l = Integer.valueOf(activity.hashCode());
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Register frame capture task for " + activity + '.');
        int hashCode = activity.hashCode();
        LinkedHashMap linkedHashMap = this.t;
        Integer valueOf = Integer.valueOf(hashCode);
        p pVar = new p(this, hashCode, activity);
        pVar.run();
        linkedHashMap.put(valueOf, pVar);
        this.s.post(new Runnable() { // from class: com.microsoft.clarity.f.q$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                q.a(q.this, activity);
            }
        });
    }

    public static final void a(q qVar, AnalyticsEvent event) {
        qVar.getClass();
        if (event instanceof ClickEvent) {
            C0062e c0062e = qVar.q;
            ClickEvent event2 = (ClickEvent) event;
            ViewHierarchy viewHierarchy = qVar.r;
            c0062e.getClass();
            Intrinsics.checkNotNullParameter(event2, "event");
            try {
                if (viewHierarchy == null) {
                    com.microsoft.clarity.m.h.e("Null view hierarchy for click correlation (" + event2 + ").");
                } else {
                    ViewNode root = viewHierarchy.getRoot();
                    if (root.getRenderNodeId() != event2.getRootViewUniqueDrawingId()) {
                        root = null;
                    }
                    if (root == null) {
                        List<ViewNode> children = viewHierarchy.getRoot().getChildren();
                        ListIterator<ViewNode> listIterator = children.listIterator(children.size());
                        while (listIterator.hasPrevious()) {
                            ViewNode previous = listIterator.previous();
                            ViewNode viewNode = previous;
                            if (viewNode.isRoot() && viewNode.getRenderNodeId() == event2.getRootViewUniqueDrawingId()) {
                                root = previous;
                            }
                        }
                        throw new NoSuchElementException("List contains no element matching the predicate.");
                    }
                    C0058a a2 = C0062e.a(root, event2, 0);
                    if (!Intrinsics.areEqual(root, viewHierarchy.getRoot())) {
                        a2.a(viewHierarchy.getRoot().getType(), viewHierarchy.getRoot().getId(), 0);
                    }
                    if (a2.f81a.getIgnoreClicks()) {
                        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
                        com.microsoft.clarity.m.h.b("Click event has been ignored (" + event2 + ").");
                        return;
                    }
                    event2.setViewId(a2.f81a.getId());
                    event2.setNodeSelector(CollectionsKt.joinToString$default(a2.c, "", null, null, 0, null, null, 62, null));
                    String text = a2.f81a.getText();
                    if (text.length() == 0) {
                        text = C0062e.a(a2.f81a);
                    }
                    if (text.length() == 0) {
                        text = a2.f81a.getContentDescription();
                    }
                    event2.setText(text);
                    event2.setReaction(!a2.b);
                    float absX = event2.getAbsX() - a2.f81a.getX();
                    float f = 32767;
                    event2.setRelativeX((int) Math.max((float) Math.floor((absX / a2.f81a.getWidth()) * f), 0.0f));
                    event2.setRelativeY((int) Math.max((float) Math.floor(((event2.getAbsY() - a2.f81a.getY()) / a2.f81a.getHeight()) * f), 0.0f));
                    LogLevel logLevel2 = com.microsoft.clarity.m.h.f192a;
                    com.microsoft.clarity.m.h.b("Click event has been correlated (" + event2 + ").");
                }
            } catch (Exception e) {
                c0062e.f82a.invoke(e, ErrorType.ViewHierarchyClickCorrelation);
            }
        }
        Iterator it = qVar.m.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            rVar.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            rVar.f126a.b.a(event);
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.microsoft.clarity.models.telemetry.ErrorType] */
    public static final void b(q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        while (true) {
            C0075s c0075s = this$0.k;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = ErrorType.EventProcessing;
            com.microsoft.clarity.m.f.a(new C0090h(this$0, objectRef2, objectRef, c0075s), new C0091i(this$0, objectRef2, objectRef), (com.microsoft.clarity.g.C) null, 10);
        }
    }

    public final void a(boolean z) {
        synchronized (this.B) {
            this.C = z;
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final boolean a(q qVar) {
        boolean z;
        synchronized (qVar.B) {
            z = qVar.C;
        }
        return z;
    }

    public final void a(final Function1 function1) {
        this.s.post(new Runnable() { // from class: com.microsoft.clarity.f.q$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                q.a(q.this, function1);
            }
        });
    }

    public static final void a(q this$0, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D = true;
        this$0.E = function1;
    }

    public static final void a(q qVar, Exception exc, ErrorType errorType) {
        Iterator it = qVar.m.iterator();
        while (it.hasNext()) {
            ((r) it.next()).a(exc, errorType);
        }
    }

    public final void a() {
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.q$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                q.b(q.this);
            }
        }).start();
    }

    public static final void a(q this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.o.add(new UserInteraction(new VisibilityEvent(System.currentTimeMillis(), ScreenMetadata.INSTANCE.create(activity, this$0.A), ViewProps.VISIBLE)));
    }
}
