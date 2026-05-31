package com.microsoft.clarity.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.e.C0079w;
import com.microsoft.clarity.e.Q;
import com.microsoft.clarity.e.Z;
import com.microsoft.clarity.i.C0107a;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.PayloadMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.IDisplayFrame;
import com.microsoft.clarity.models.display.common.Asset;
import com.microsoft.clarity.models.ingest.BaseWebViewEvent;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import com.microsoft.clarity.models.ingest.WebViewMutationEvent;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.ingest.analytics.BaselineEvent;
import com.microsoft.clarity.models.ingest.analytics.FragmentVisibilityEvent;
import com.microsoft.clarity.models.ingest.analytics.ScriptErrorEvent;
import com.microsoft.clarity.models.ingest.analytics.VisibilityEvent;
import com.microsoft.clarity.models.ingest.mutation.MutationEvent;
import com.microsoft.clarity.models.observers.ErrorDisplayFrame;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class M {
    public final ArrayList A;
    public final LinkedBlockingDeque B;

    /* renamed from: a, reason: collision with root package name */
    public final Context f111a;
    public final ClarityConfig b;
    public final DynamicConfig c;
    public final com.microsoft.clarity.j.b d;
    public final com.microsoft.clarity.e.H e;
    public final C0079w f;
    public final Q g;
    public final long h;
    public final long i;
    public Function1 j;
    public String k;
    public String l;
    public String m;
    public SessionMetadata n;
    public int o;
    public long p;
    public PayloadMetadata q;
    public boolean r;
    public LinkedHashSet s;
    public DisplayFrame t;
    public final LinkedHashMap u;
    public final List v;
    public final Z w;
    public final com.microsoft.clarity.j.d x;
    public VisibilityEvent y;
    public final LinkedHashMap z;

    public M(Context context, ClarityConfig config, DynamicConfig dynamicConfig, com.microsoft.clarity.j.b sessionRepository, com.microsoft.clarity.e.H sessionUploader, C0079w installReferrerHelper, Q telemetryTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(sessionUploader, "sessionUploader");
        Intrinsics.checkNotNullParameter(installReferrerHelper, "installReferrerHelper");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        this.f111a = context;
        this.b = config;
        this.c = dynamicConfig;
        this.d = sessionRepository;
        this.e = sessionUploader;
        this.f = installReferrerHelper;
        this.g = telemetryTracker;
        this.h = com.microsoft.clarity.m.c.f190a.availableProcessors();
        this.i = com.microsoft.clarity.m.c.a(context);
        this.k = "";
        this.r = true;
        this.s = new LinkedHashSet();
        this.u = new LinkedHashMap();
        this.v = Collections.synchronizedList(new ArrayList());
        this.w = new Z(context, config, new L(this));
        this.x = new com.microsoft.clarity.j.d(context);
        this.z = new LinkedHashMap();
        this.A = new ArrayList();
        this.B = new LinkedBlockingDeque();
        b();
    }

    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.B.addFirst(new F(this, key, value));
    }

    public final boolean b(String customSessionId) {
        Intrinsics.checkNotNullParameter(customSessionId, "customSessionId");
        this.B.addFirst(new E(this, customSessionId));
        return true;
    }

    public final boolean c(String customUserId) {
        Intrinsics.checkNotNullParameter(customUserId, "customUserId");
        this.B.addFirst(new G(this, customUserId));
        return true;
    }

    public final void d() {
        this.B.add(new H(this));
    }

    public final boolean e() {
        if (this.r) {
            PayloadMetadata payloadMetadata = this.q;
            Intrinsics.checkNotNull(payloadMetadata);
            boolean z = payloadMetadata.getSequence() <= 100;
            this.r = z;
            if (!z) {
                LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
                com.microsoft.clarity.m.h.b("Stopping page tracking as tracking payload sequence limit has been exceeded. PageNum: " + this.o + " at Timestamp:" + this.p);
            }
        }
        return !this.r;
    }

    public final void a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.B.add(new D(this, value));
    }

    public final void b(AnalyticsEvent event) {
        if ((event instanceof VisibilityEvent) && !(event instanceof FragmentVisibilityEvent)) {
            ScreenMetadata screenMetadata = event.getScreenMetadata();
            VisibilityEvent visibilityEvent = this.y;
            if (Intrinsics.areEqual(screenMetadata, visibilityEvent != null ? visibilityEvent.getScreenMetadata() : null)) {
                String state = ((VisibilityEvent) event).getState();
                VisibilityEvent visibilityEvent2 = this.y;
                if (Intrinsics.areEqual(state, visibilityEvent2 != null ? visibilityEvent2.getState() : null)) {
                    com.microsoft.clarity.m.h.b("Skipping duplicate visibility event.");
                    return;
                }
            }
            this.y = (VisibilityEvent) event;
        }
        a(event.getTimestamp(), event.getScreenMetadata());
        PayloadMetadata payloadMetadata = this.q;
        Intrinsics.checkNotNull(payloadMetadata);
        payloadMetadata.updateDuration(event.getTimestamp());
        com.microsoft.clarity.j.b bVar = this.d;
        PayloadMetadata payloadMetadata2 = this.q;
        Intrinsics.checkNotNull(payloadMetadata2);
        com.microsoft.clarity.j.f fVar = (com.microsoft.clarity.j.f) bVar;
        fVar.getClass();
        Intrinsics.checkNotNullParameter(payloadMetadata2, "payloadMetadata");
        Intrinsics.checkNotNullParameter(event, "event");
        com.microsoft.clarity.j.f.a(fVar.c, payloadMetadata2, event.serialize(payloadMetadata2.getPageTimestamp()));
    }

    public final PageMetadata c() {
        if (this.n == null) {
            return null;
        }
        SessionMetadata sessionMetadata = this.n;
        Intrinsics.checkNotNull(sessionMetadata);
        return new PageMetadata(sessionMetadata, this.o);
    }

    public final void a(IDisplayFrame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Enqueuing display frame task for screen " + frame.getScreenMetadata().getName() + '#' + frame.getScreenMetadata().getActivityHashCode() + '.');
        this.B.add(new x(frame, this));
    }

    public final void a(AnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ScriptErrorEvent) {
            PayloadMetadata payloadMetadata = this.q;
            Intrinsics.checkNotNull(payloadMetadata);
            payloadMetadata.updateDuration(event.getTimestamp());
            com.microsoft.clarity.j.b bVar = this.d;
            PayloadMetadata payloadMetadata2 = this.q;
            Intrinsics.checkNotNull(payloadMetadata2);
            com.microsoft.clarity.j.f fVar = (com.microsoft.clarity.j.f) bVar;
            fVar.getClass();
            Intrinsics.checkNotNullParameter(payloadMetadata2, "payloadMetadata");
            Intrinsics.checkNotNullParameter(event, "event");
            com.microsoft.clarity.j.f.a(fVar.c, payloadMetadata2, event.serialize(payloadMetadata2.getPageTimestamp()));
            return;
        }
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Enqueuing analytics event " + event.getType() + " task received for screen " + event.getScreenMetadata().getName() + '#' + event.getScreenMetadata().getActivityHashCode() + '.');
        this.B.add(new w(event, this));
    }

    public final void a(ErrorDisplayFrame errorDisplayFrame) {
        Intrinsics.checkNotNullParameter(errorDisplayFrame, "errorDisplayFrame");
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Enqueuing error frame task for screen " + errorDisplayFrame.getScreenMetadata().getName() + '#' + errorDisplayFrame.getScreenMetadata().getActivityHashCode() + '.');
        this.B.add(new y(this, errorDisplayFrame));
    }

    public final void a(WebViewMutationEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Enqueuing webview mutation task for screen " + event.getScreenMetadata().getName() + '#' + event.getScreenMetadata().getName() + '.');
        this.B.add(new A(event, this));
    }

    public final void a(WebViewAnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Enqueuing webview analytics task for screen " + event.getScreenMetadata().getName() + '#' + event.getScreenMetadata().getActivityHashCode() + '.');
        this.B.add(new z(event, this));
    }

    public final void a() {
        this.g.a("Clarity_LowDeviceMemory_WebViewEventQueueSize", this.v.size());
        this.g.a("Clarity_LowDeviceMemory_SessionManagerTaskQueueSize", this.B.size());
        this.v.clear();
        this.B.clear();
        this.A.clear();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:10|(4:12|(1:31)(9:15|16|17|18|(1:20)(1:27)|21|(1:23)(1:26)|24|25)|30|25)|32|(4:34|(1:36)|37|(31:39|40|(6:42|(3:44|(1:46)(1:49)|47)|50|(1:52)(1:99)|53|(2:57|(4:59|(1:61)(1:98)|62|(19:(1:65)|67|68|(1:70)|71|(1:73)|74|75|76|77|78|(1:82)|83|(1:87)|88|(2:91|89)|92|93|94))))|100|(1:137)|104|(2:132|(1:134)(1:(1:136)))(1:108)|109|(1:131)(1:112)|113|(2:115|(1:117))|118|(3:124|125|126)|130|68|(0)|71|(0)|74|75|76|77|78|(2:80|82)|83|(2:85|87)|88|(1:89)|92|93|94))|138|40|(0)|100|(1:102)|137|104|(1:106)|132|(0)(0)|109|(0)|131|113|(0)|118|(5:120|122|124|125|126)|130|68|(0)|71|(0)|74|75|76|77|78|(0)|83|(0)|88|(1:89)|92|93|94) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0150, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6, r14 != null ? r14.getUserId() : null) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ae, code lost:
    
        if (r5.getLeanSession() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0493, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0494, code lost:
    
        com.microsoft.clarity.m.h.c("Retrieving user agent failed: " + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x063c A[LOOP:0: B:89:0x0636->B:91:0x063c, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.microsoft.clarity.models.display.DisplayFrame r33) {
        /*
            Method dump skipped, instructions count: 1680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.f.M.b(com.microsoft.clarity.models.display.DisplayFrame):void");
    }

    public final void a(long j, ScreenMetadata screenMetadata) {
        PayloadMetadata payloadMetadata = this.q;
        Intrinsics.checkNotNull(payloadMetadata);
        if (payloadMetadata.canIncludeEvent(j)) {
            return;
        }
        PayloadMetadata payloadMetadata2 = this.q;
        Intrinsics.checkNotNull(payloadMetadata2);
        int sequence = payloadMetadata2.getSequence() + 1;
        PayloadMetadata payloadMetadata3 = this.q;
        Intrinsics.checkNotNull(payloadMetadata3);
        long start = payloadMetadata3.getStart();
        PayloadMetadata payloadMetadata4 = this.q;
        Intrinsics.checkNotNull(payloadMetadata4);
        Long duration = payloadMetadata4.getDuration();
        Intrinsics.checkNotNull(duration);
        a(sequence, duration.longValue() + start, j, screenMetadata);
    }

    public final void a(int i, long j, long j2, ScreenMetadata screenMetadata) {
        Boolean USE_WORKERS = Boolean.TRUE;
        Intrinsics.checkNotNullExpressionValue(USE_WORKERS, "USE_WORKERS");
        PayloadMetadata payloadMetadata = this.q;
        if (payloadMetadata != null) {
            Intrinsics.checkNotNull(payloadMetadata);
            PayloadMetadata payloadMetadata2 = this.q;
            Intrinsics.checkNotNull(payloadMetadata2);
            a(payloadMetadata, payloadMetadata2.getSessionId(), 0L);
        }
        SessionMetadata sessionMetadata = this.n;
        Intrinsics.checkNotNull(sessionMetadata);
        this.q = new PayloadMetadata(sessionMetadata.getSessionId(), this.o, i, j, this.p, Long.valueOf(j2));
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        StringBuilder sb = new StringBuilder("Starting new payload with sequence ");
        PayloadMetadata payloadMetadata3 = this.q;
        Intrinsics.checkNotNull(payloadMetadata3);
        sb.append(payloadMetadata3.getSequence());
        sb.append(", start ");
        PayloadMetadata payloadMetadata4 = this.q;
        Intrinsics.checkNotNull(payloadMetadata4);
        sb.append(payloadMetadata4.getStart());
        sb.append(", first event timestamp ");
        PayloadMetadata payloadMetadata5 = this.q;
        Intrinsics.checkNotNull(payloadMetadata5);
        sb.append(payloadMetadata5.getFirstNonBaselineEventTimestamp());
        sb.append(" and max duration ");
        PayloadMetadata payloadMetadata6 = this.q;
        Intrinsics.checkNotNull(payloadMetadata6);
        sb.append(payloadMetadata6.getMaxPayloadDuration());
        com.microsoft.clarity.m.h.b(sb.toString());
        com.microsoft.clarity.j.b bVar = this.d;
        SessionMetadata sessionMetadata2 = this.n;
        Intrinsics.checkNotNull(sessionMetadata2);
        String sessionId = sessionMetadata2.getSessionId();
        PayloadMetadata payloadMetadata7 = this.q;
        Intrinsics.checkNotNull(payloadMetadata7);
        com.microsoft.clarity.j.f fVar = (com.microsoft.clarity.j.f) bVar;
        fVar.getClass();
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(payloadMetadata7, "payloadMetadata");
        com.microsoft.clarity.m.h.b("Create session " + sessionId + ", page " + payloadMetadata7.getPageNum() + ", sequence " + payloadMetadata7.getSequence() + ", start " + payloadMetadata7.getStart() + '.');
        String b = com.microsoft.clarity.j.f.b(payloadMetadata7);
        com.microsoft.clarity.l.c cVar = fVar.b;
        com.microsoft.clarity.l.d dVar = com.microsoft.clarity.l.d.OVERWRITE;
        cVar.a(b, "", dVar);
        fVar.c.a(b, "", dVar);
        long j3 = j + this.p;
        VisibilityEvent visibilityEvent = this.y;
        b(new BaselineEvent(j3, screenMetadata, Intrinsics.areEqual(visibilityEvent != null ? visibilityEvent.getState() : null, ViewProps.VISIBLE)));
        Intrinsics.checkNotNullExpressionValue(USE_WORKERS, "USE_WORKERS");
        PayloadMetadata payloadMetadata8 = this.q;
        Intrinsics.checkNotNull(payloadMetadata8);
        PayloadMetadata payloadMetadata9 = this.q;
        Intrinsics.checkNotNull(payloadMetadata9);
        int maxPayloadDuration = payloadMetadata9.getMaxPayloadDuration() + 600000;
        StringBuilder sb2 = new StringBuilder();
        PayloadMetadata payloadMetadata10 = this.q;
        Intrinsics.checkNotNull(payloadMetadata10);
        sb2.append(payloadMetadata10.getSessionId());
        sb2.append('_');
        PayloadMetadata payloadMetadata11 = this.q;
        Intrinsics.checkNotNull(payloadMetadata11);
        sb2.append(payloadMetadata11.getPageNum());
        sb2.append('_');
        PayloadMetadata payloadMetadata12 = this.q;
        Intrinsics.checkNotNull(payloadMetadata12);
        sb2.append(payloadMetadata12.getSequence());
        sb2.append("_fallback");
        String sb3 = sb2.toString();
        PayloadMetadata payloadMetadata13 = this.q;
        Intrinsics.checkNotNull(payloadMetadata13);
        long j4 = maxPayloadDuration;
        payloadMetadata13.setFallbackWorkerStartTime(Long.valueOf(System.currentTimeMillis() + j4));
        PayloadMetadata payloadMetadata14 = this.q;
        Intrinsics.checkNotNull(payloadMetadata14);
        payloadMetadata14.setFallbackWorkerId(a(payloadMetadata8, sb3, j4));
    }

    public final MutationEvent a(DisplayFrame frame) {
        Base64.Encoder encoder;
        String encodeToString;
        Intrinsics.checkNotNullParameter(frame, "frame");
        byte[] byteArray = frame.toProtobufInstance(this.p).toByteArray();
        long timestamp = frame.getTimestamp();
        encoder = Base64.getEncoder();
        encodeToString = encoder.encodeToString(byteArray);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "getEncoder().encodeToString(data)");
        return new MutationEvent(timestamp, true, encodeToString);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005f, code lost:
    
        if (r0.isFinished() == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.UUID a(com.microsoft.clarity.models.PayloadMetadata r9, java.lang.String r10, long r11) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.f.M.a(com.microsoft.clarity.models.PayloadMetadata, java.lang.String, long):java.util.UUID");
    }

    public final void a(UUID uuid) {
        if (this.b.getCustomSignalsCallback() == null) {
            return;
        }
        final LiveData<WorkInfo> workInfoByIdLiveData = WorkManager.getInstance(this.f111a).getWorkInfoByIdLiveData(uuid);
        Intrinsics.checkNotNullExpressionValue(workInfoByIdLiveData, "getInstance(context)\n   …IdLiveData(workRequestId)");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.microsoft.clarity.f.M$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                M.a(LiveData.this, this);
            }
        });
    }

    public static final void a(LiveData liveData, M this$0) {
        Intrinsics.checkNotNullParameter(liveData, "$liveData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.microsoft.clarity.m.f.a(new K(liveData, this$0), (Function1) null, (o) null, 30);
    }

    public static final void a(M m, BaseWebViewEvent baseWebViewEvent) {
        if (m.n != null) {
            DisplayFrame displayFrame = m.t;
            if (Intrinsics.areEqual(displayFrame != null ? displayFrame.getScreenMetadata() : null, baseWebViewEvent.getScreenMetadata())) {
                if (m.e()) {
                    com.microsoft.clarity.m.h.b("Dropping WebView Event because current page payload count has been exceeded");
                    return;
                }
                if (m.u.containsKey(Integer.valueOf(baseWebViewEvent.getWebViewHashCode()))) {
                    Object obj = m.u.get(Integer.valueOf(baseWebViewEvent.getWebViewHashCode()));
                    Intrinsics.checkNotNull(obj);
                    long longValue = ((Number) obj).longValue();
                    if (baseWebViewEvent.getTimestamp() < m.p || baseWebViewEvent.getTimestamp() < longValue) {
                        baseWebViewEvent = baseWebViewEvent.copyWithNewTimestamp(longValue + 1);
                    }
                    m.a(baseWebViewEvent);
                    return;
                }
                LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
                com.microsoft.clarity.m.h.b("Enqueuing web view event " + baseWebViewEvent.getType() + '.');
                m.v.add(baseWebViewEvent);
                return;
            }
        }
        com.microsoft.clarity.m.h.b("Skipping residual webview event from another page.");
    }

    public static final void a(M m, Asset asset) {
        String dataHash;
        if (asset.getData() == null || (dataHash = asset.getDataHash()) == null || dataHash.length() == 0 || CollectionsKt.contains(m.s, asset.getDataHash())) {
            return;
        }
        com.microsoft.clarity.j.b bVar = m.d;
        SessionMetadata sessionMetadata = m.n;
        Intrinsics.checkNotNull(sessionMetadata);
        String sessionId = sessionMetadata.getSessionId();
        String identifier = asset.getDataHash();
        Intrinsics.checkNotNull(identifier);
        AssetType type = asset.getType();
        C0107a byteArrayWindow = asset.getData();
        com.microsoft.clarity.j.f fVar = (com.microsoft.clarity.j.f) bVar;
        fVar.getClass();
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(byteArrayWindow, "data");
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        com.microsoft.clarity.m.h.b("Save session " + sessionId + " asset " + identifier);
        com.microsoft.clarity.l.c a2 = fVar.a(type);
        String filename = com.microsoft.clarity.j.f.a(sessionId, identifier);
        a2.getClass();
        Intrinsics.checkNotNullParameter(filename, "filename");
        if (!new File(a2.a(filename)).exists()) {
            com.microsoft.clarity.l.d mode = com.microsoft.clarity.l.d.OVERWRITE;
            Intrinsics.checkNotNullParameter(filename, "filename");
            Intrinsics.checkNotNullParameter(byteArrayWindow, "byteArrayWindow");
            Intrinsics.checkNotNullParameter(mode, "mode");
            a2.a(filename, byteArrayWindow.f169a, byteArrayWindow.b, byteArrayWindow.c, mode);
        }
        LinkedHashSet linkedHashSet = m.s;
        String dataHash2 = asset.getDataHash();
        Intrinsics.checkNotNull(dataHash2);
        linkedHashSet.add(dataHash2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x01d1, code lost:
    
        if (r0 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0190, code lost:
    
        if (r0 == null) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.microsoft.clarity.models.ingest.BaseWebViewEvent r24) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.f.M.a(com.microsoft.clarity.models.ingest.BaseWebViewEvent):void");
    }

    public static final void a(M this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        while (true) {
            com.microsoft.clarity.m.f.a(new u(this$0), new v(this$0), (com.microsoft.clarity.g.C) null, 10);
        }
    }

    public static final void b(M m) {
        SessionMetadata sessionMetadata;
        String sessionId;
        synchronized (m.k) {
            if (m.j != null) {
                SessionMetadata sessionMetadata2 = m.n;
                if (!Intrinsics.areEqual(sessionMetadata2 != null ? sessionMetadata2.getSessionId() : null, m.k) && (sessionMetadata = m.n) != null && (sessionId = sessionMetadata.getSessionId()) != null) {
                    Function1 function1 = m.j;
                    if (function1 != null) {
                        function1.invoke(sessionId);
                    }
                    m.k = sessionId;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b() {
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.M$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                M.a(M.this);
            }
        }).start();
    }
}
