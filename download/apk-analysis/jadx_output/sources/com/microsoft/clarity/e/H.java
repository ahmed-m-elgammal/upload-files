package com.microsoft.clarity.e;

import android.content.Context;
import android.net.Uri;
import com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0;
import com.google.common.net.HttpHeaders;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.PayloadMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.ingest.AssetCheck;
import com.microsoft.clarity.models.ingest.CollectRequest;
import com.microsoft.clarity.models.ingest.CollectResponse;
import com.microsoft.clarity.models.ingest.Envelope;
import com.microsoft.clarity.models.ingest.SerializedSessionPayload;
import com.microsoft.clarity.models.ingest.analytics.Metric;
import com.microsoft.clarity.models.ingest.analytics.MetricEvent;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.models.repositories.RepositoryAsset;
import com.microsoft.clarity.models.repositories.RepositoryAssetMetadata;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;
import java.util.function.Supplier;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    public final Context f64a;
    public final Long b;
    public final C0064g c;
    public final Q d;
    public final com.microsoft.clarity.k.a e;
    public final com.microsoft.clarity.j.a f;

    public H(Context context, Long l, String projectId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        this.f64a = context;
        this.b = l;
        C0064g b = com.microsoft.clarity.b.a.b(context);
        this.c = b;
        Q b2 = com.microsoft.clarity.b.a.b(context, projectId);
        this.d = b2;
        this.e = com.microsoft.clarity.b.a.a(context, b, b2);
        this.f = com.microsoft.clarity.b.a.c(context);
    }

    public final boolean a(com.microsoft.clarity.j.b sessionRepository, final SessionMetadata sessionMetadata) {
        Object obj;
        CompletableFuture supplyAsync;
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        try {
            final com.microsoft.clarity.j.f fVar = (com.microsoft.clarity.j.f) sessionRepository;
            List a2 = fVar.a(sessionMetadata.getSessionId());
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : a2) {
                if (hashSet.add(((RepositoryAssetMetadata) obj2).getId())) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                RepositoryAssetMetadata repositoryAssetMetadata = (RepositoryAssetMetadata) it.next();
                arrayList2.add(repositoryAssetMetadata.getType() == AssetType.Web ? new AssetCheck(null, repositoryAssetMetadata.getId(), "all", repositoryAssetMetadata.getType().ordinal()) : new AssetCheck(repositoryAssetMetadata.getId(), null, null, repositoryAssetMetadata.getType().ordinal()));
            }
            Map a3 = ((com.microsoft.clarity.k.b) this.e).a(sessionMetadata.getIngestUrl(), sessionMetadata.getProjectId(), arrayList2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : a3.entrySet()) {
                if (!((Boolean) entry.getValue()).booleanValue()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : a2) {
                if (!linkedHashMap.containsKey(((RepositoryAssetMetadata) obj3).getId())) {
                    arrayList3.add(obj3);
                }
            }
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                RepositoryAssetMetadata repositoryAssetMetadata2 = (RepositoryAssetMetadata) it2.next();
                String sessionId = sessionMetadata.getSessionId();
                AssetType type = repositoryAssetMetadata2.getType();
                String identifier = repositoryAssetMetadata2.getId();
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                com.microsoft.clarity.l.c a4 = fVar.a(type);
                String filename = com.microsoft.clarity.j.f.a(sessionId, identifier);
                LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
                com.microsoft.clarity.m.h.b("Deleting Asset " + filename + " from session " + sessionId + " repository");
                a4.getClass();
                Intrinsics.checkNotNullParameter(filename, "filename");
                new File(a4.a(filename)).delete();
                arrayList4.add(Unit.INSTANCE);
            }
            final Semaphore semaphore = new Semaphore(5);
            ArrayList arrayList5 = new ArrayList();
            for (Object obj4 : a2) {
                if (linkedHashMap.containsKey(((RepositoryAssetMetadata) obj4).getId())) {
                    arrayList5.add(obj4);
                }
            }
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
            Iterator it3 = arrayList5.iterator();
            while (it3.hasNext()) {
                final RepositoryAssetMetadata repositoryAssetMetadata3 = (RepositoryAssetMetadata) it3.next();
                supplyAsync = CompletableFuture.supplyAsync(new Supplier() { // from class: com.microsoft.clarity.e.H$$ExternalSyntheticLambda0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return H.a(semaphore, fVar, sessionMetadata, repositoryAssetMetadata3, this);
                    }
                });
                arrayList6.add(supplyAsync);
            }
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
            Iterator it4 = arrayList6.iterator();
            while (it4.hasNext()) {
                obj = Intl$$ExternalSyntheticApiModelOutline0.m$1(it4.next()).get();
                arrayList7.add((Boolean) obj);
            }
            if (!arrayList7.isEmpty()) {
                Iterator it5 = arrayList7.iterator();
                while (it5.hasNext()) {
                    Boolean it6 = (Boolean) it5.next();
                    Intrinsics.checkNotNullExpressionValue(it6, "it");
                    if (!it6.booleanValue()) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            com.microsoft.clarity.m.h.c("Assets upload failed for session " + sessionMetadata.getSessionId() + " with Error: " + e + '.');
            return false;
        }
    }

    public final CollectResponse b(com.microsoft.clarity.j.b sessionRepository, PayloadMetadata payloadMetadata, SessionMetadata sessionMetadata) {
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        boolean leanSession = sessionMetadata.getLeanSession();
        com.microsoft.clarity.j.f fVar = (com.microsoft.clarity.j.f) sessionRepository;
        fVar.getClass();
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        List a2 = !leanSession ? com.microsoft.clarity.j.f.a(fVar.b, payloadMetadata) : new ArrayList();
        List a3 = com.microsoft.clarity.j.f.a(fVar.c, payloadMetadata);
        if (payloadMetadata.getSequence() == 1) {
            a3.add(new MetricEvent(payloadMetadata.getPageTimestamp(), new ScreenMetadata("", "", 0), MapsKt.hashMapOf(TuplesKt.to(Metric.Playback, Long.valueOf(!leanSession ? 1L : 0L)))).serialize(payloadMetadata.getPageTimestamp()));
        }
        SerializedSessionPayload serializedSessionPayload = new SerializedSessionPayload(a2, a3, payloadMetadata.getPageNum(), payloadMetadata.getSequence(), payloadMetadata.getStart());
        com.microsoft.clarity.k.b bVar = (com.microsoft.clarity.k.b) this.e;
        bVar.getClass();
        Intrinsics.checkNotNullParameter(serializedSessionPayload, "serializedSessionPayload");
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        String uri = Uri.parse(sessionMetadata.getIngestUrl()).buildUpon().appendPath("collect").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "parse(ingestUrl)\n       …)\n            .toString()");
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("Content-Type", "application/json"));
        mutableMapOf.put("Accept", "application/x-clarity-gzip");
        mutableMapOf.put(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");
        String packageName = bVar.f182a.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        mutableMapOf.put("ApplicationPackage", packageName);
        HttpURLConnection a4 = com.microsoft.clarity.m.g.a(uri, "POST", mutableMapOf);
        try {
            String serialize = new CollectRequest(new Envelope(sessionMetadata, serializedSessionPayload.getPageNum(), serializedSessionPayload.getSequence(), serializedSessionPayload.getStart(), serializedSessionPayload.getDuration()), serializedSessionPayload.getEvents(), serializedSessionPayload.getFrames()).serialize();
            com.microsoft.clarity.m.g.a(a4, com.microsoft.clarity.m.b.a(serialize));
            a4.connect();
            CollectResponse create = CollectResponse.INSTANCE.create(a4.getResponseCode(), com.microsoft.clarity.m.g.a(a4));
            if (create.getSuccessful()) {
                bVar.a("Clarity_UploadSessionSegmentBytes", r1.length);
                bVar.d.a(r1.length);
            } else {
                bVar.a(serialize, sessionMetadata);
            }
            return create;
        } finally {
            a4.disconnect();
        }
    }

    public static final Boolean a(Semaphore semaphore, com.microsoft.clarity.j.b sessionRepository, SessionMetadata sessionMetadata, RepositoryAssetMetadata it, H this$0) {
        Intrinsics.checkNotNullParameter(semaphore, "$semaphore");
        Intrinsics.checkNotNullParameter(sessionRepository, "$sessionRepository");
        Intrinsics.checkNotNullParameter(sessionMetadata, "$sessionMetadata");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            semaphore.acquire();
            String sessionId = sessionMetadata.getSessionId();
            String identifier = it.getId();
            AssetType type = it.getType();
            com.microsoft.clarity.j.f fVar = (com.microsoft.clarity.j.f) sessionRepository;
            fVar.getClass();
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(type, "type");
            com.microsoft.clarity.l.c a2 = fVar.a(type);
            String filename = com.microsoft.clarity.j.f.a(sessionId, identifier);
            a2.getClass();
            Intrinsics.checkNotNullParameter(filename, "filename");
            FileInputStream fileInputStream = new FileInputStream(new File(a2.a(filename)));
            try {
                byte[] readBytes = ByteStreamsKt.readBytes(fileInputStream);
                CloseableKt.closeFinally(fileInputStream, null);
                G code = new G(this$0, sessionMetadata, new RepositoryAsset(type, readBytes, identifier));
                Intrinsics.checkNotNullParameter(code, "code");
                int i = 0;
                while (i < 3) {
                    try {
                        Boolean bool = (Boolean) code.invoke();
                        if (bool.booleanValue()) {
                            String sessionId2 = sessionMetadata.getSessionId();
                            AssetType type2 = it.getType();
                            String identifier2 = it.getId();
                            com.microsoft.clarity.j.f fVar2 = (com.microsoft.clarity.j.f) sessionRepository;
                            fVar2.getClass();
                            Intrinsics.checkNotNullParameter(sessionId2, "sessionId");
                            Intrinsics.checkNotNullParameter(type2, "type");
                            Intrinsics.checkNotNullParameter(identifier2, "identifier");
                            com.microsoft.clarity.l.c a3 = fVar2.a(type2);
                            String filename2 = com.microsoft.clarity.j.f.a(sessionId2, identifier2);
                            LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
                            com.microsoft.clarity.m.h.b("Deleting Asset " + filename2 + " from session " + sessionId2 + " repository");
                            a3.getClass();
                            Intrinsics.checkNotNullParameter(filename2, "filename");
                            new File(a3.a(filename2)).delete();
                        }
                        return bool;
                    } catch (Exception e) {
                        i++;
                        if (i >= 3) {
                            throw e;
                        }
                    }
                }
                throw new com.microsoft.clarity.c.d(3);
            } finally {
            }
        } finally {
            semaphore.release();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0061, code lost:
    
        if (((kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) ? r0.f83a.getLong("NETWORK_USAGE_TRACKING_SIZE", 0) : 0) / 1048576) >= r8.b.longValue()) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(com.microsoft.clarity.j.b r9, com.microsoft.clarity.models.PayloadMetadata r10, com.microsoft.clarity.models.SessionMetadata r11) {
        /*
            r8 = this;
            boolean r0 = r11.getLeanSession()
            r1 = 1
            if (r0 != 0) goto Lc4
            java.lang.Long r0 = r8.b
            if (r0 != 0) goto Ld
            goto Lc4
        Ld:
            long r2 = r11.getTimestamp()
            r0 = 86400000(0x5265c00, float:7.82218E-36)
            long r4 = (long) r0
            long r2 = r2 / r4
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 / r4
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 != 0) goto L63
            java.lang.Long r0 = r8.b
            if (r0 == 0) goto Lc4
            com.microsoft.clarity.e.g r0 = r8.c
            android.content.SharedPreferences r2 = r0.f83a
            java.lang.String r3 = "NETWORK_USAGE_TRACKING_DATE"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.getString(r3, r4)
            java.util.Locale r3 = java.util.Locale.UK
            r4 = 3
            java.text.DateFormat r3 = java.text.DateFormat.getDateInstance(r4, r3)
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            java.lang.String r3 = r3.format(r4)
            java.lang.String r4 = "getDateInstance(DateForm…Locale.UK).format(Date())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            r3 = 0
            if (r2 != 0) goto L4d
            goto L55
        L4d:
            android.content.SharedPreferences r0 = r0.f83a
            java.lang.String r2 = "NETWORK_USAGE_TRACKING_SIZE"
            long r3 = r0.getLong(r2, r3)
        L55:
            r0 = 1048576(0x100000, float:1.469368E-39)
            long r5 = (long) r0
            long r3 = r3 / r5
            java.lang.Long r0 = r8.b
            long r5 = r0.longValue()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto Lc4
        L63:
            int r0 = r10.getPageNum()
            if (r0 > r1) goto La8
            int r0 = r10.getSequence()
            if (r0 <= r1) goto L70
            goto La8
        L70:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Convert session "
            r0.<init>(r2)
            java.lang.String r2 = r10.getSessionId()
            r0.append(r2)
            java.lang.String r2 = " into lean as either maximum daily network usage limit has been reached or session did not get captured today."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.microsoft.clarity.m.h.e(r0)
            r11.setLeanSession(r1)
            java.lang.String r10 = r10.getSessionId()
            com.microsoft.clarity.j.f r9 = (com.microsoft.clarity.j.f) r9
            r9.getClass()
            java.lang.String r0 = "sessionId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "metadata"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.microsoft.clarity.j.a r9 = r9.f181a
            com.microsoft.clarity.j.c r9 = (com.microsoft.clarity.j.c) r9
            r9.a(r10, r11)
            return r1
        La8:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "Rest of session "
            r9.<init>(r11)
            java.lang.String r10 = r10.getSessionId()
            r9.append(r10)
            java.lang.String r10 = " should be dropped as it is not lean and either maximum daily network usage limit has been reached or session did not get captured today."
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.microsoft.clarity.m.h.e(r9)
            r9 = 0
            return r9
        Lc4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.e.H.a(com.microsoft.clarity.j.b, com.microsoft.clarity.models.PayloadMetadata, com.microsoft.clarity.models.SessionMetadata):boolean");
    }
}
