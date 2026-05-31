package com.microsoft.clarity.k;

import android.content.Context;
import android.net.Uri;
import android.os.Trace;
import com.microsoft.clarity.e.C0064g;
import com.microsoft.clarity.e.Q;
import com.microsoft.clarity.l.d;
import com.microsoft.clarity.m.g;
import com.microsoft.clarity.m.h;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.ingest.AssetCheck;
import com.microsoft.clarity.models.ingest.AssetMetadata;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f182a;
    public final com.microsoft.clarity.l.c b;
    public final Q c;
    public final C0064g d;

    public b(Context context, com.microsoft.clarity.l.c faultyCollectRequestsStore, Q telemetryTracker, C0064g networkUsageTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(faultyCollectRequestsStore, "faultyCollectRequestsStore");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        Intrinsics.checkNotNullParameter(networkUsageTracker, "networkUsageTracker");
        this.f182a = context;
        this.b = faultyCollectRequestsStore;
        this.c = telemetryTracker;
        this.d = networkUsageTracker;
    }

    public final boolean a(SessionMetadata sessionMetadata, String hash, byte[] asset, AssetMetadata assetMetadata) {
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(assetMetadata, "assetMetadata");
        Uri.Builder appendPath = Uri.parse(sessionMetadata.getIngestUrl()).buildUpon().appendPath(sessionMetadata.getProjectId()).appendPath("upload-asset").appendPath(hash).appendPath(String.valueOf(assetMetadata.getAssetType().ordinal()));
        if (assetMetadata.getAssetType() == AssetType.Image) {
            appendPath.appendQueryParameter("width", String.valueOf(assetMetadata.getWidth())).appendQueryParameter("height", String.valueOf(assetMetadata.getHeight()));
        }
        String uri = appendPath.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uri\n            .build()\n            .toString()");
        HttpURLConnection a2 = g.a(uri, "POST", MapsKt.mapOf(TuplesKt.to("Content-Type", "application/octet-stream"), TuplesKt.to("Content-Hash", hash)));
        try {
            g.a(a2, asset);
            a2.connect();
            boolean b = g.b(a2);
            if (b) {
                a("Clarity_UploadAssetBytes", asset.length);
                this.d.a(asset.length);
            }
            return b;
        } finally {
            a2.disconnect();
        }
    }

    public final Map a(String ingestUrl, String projectId, ArrayList assets) {
        Intrinsics.checkNotNullParameter(ingestUrl, "ingestUrl");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(assets, "assets");
        if (assets.isEmpty()) {
            return MapsKt.emptyMap();
        }
        String uri = Uri.parse(ingestUrl).buildUpon().appendPath(projectId).appendPath("check-asset").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "parse(ingestUrl)\n       …)\n            .toString()");
        HttpURLConnection a2 = g.a(uri, "POST", MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")));
        try {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(assets, 10));
            Iterator it = assets.iterator();
            while (it.hasNext()) {
                arrayList.add(((AssetCheck) it.next()).toJsonObject());
            }
            String jSONArray = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(assets.map { i…sonObject() }).toString()");
            byte[] bytes = jSONArray.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            long length = bytes.length;
            g.a(a2, bytes);
            a2.connect();
            String a3 = g.a(a2);
            long length2 = length + a3.length();
            if (g.b(a2)) {
                a("Clarity_CheckAssetBytes", length2);
                this.d.a(length2);
            }
            JSONObject jsonObject = new JSONObject(a3);
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> keys = jsonObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String key = keys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Object obj = jsonObject.get(key);
                Intrinsics.checkNotNullExpressionValue(obj, "jsonObject.get(key)");
                linkedHashMap.put(key, obj);
            }
            Intrinsics.checkNotNull(linkedHashMap, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Boolean>");
            return linkedHashMap;
        } finally {
            a2.disconnect();
        }
    }

    public final void a(String str, SessionMetadata sessionMetadata) {
        String str2 = sessionMetadata.getSessionId() + '_' + System.currentTimeMillis() + ".json";
        h.c("Bad collect request for session " + sessionMetadata.getSessionId() + ". Saved at " + str2 + '.');
        this.b.a(str2, str, d.OVERWRITE);
    }

    public final void a(String str, double d) {
        try {
            Trace.setCounter(str, (long) d);
            this.c.a(str, d);
        } catch (Exception unused) {
        }
    }
}
