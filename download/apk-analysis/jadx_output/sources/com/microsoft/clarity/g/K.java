package com.microsoft.clarity.g;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.webkit.ValueCallback;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import androidx.webkit.ProxyConfig;
import com.microsoft.clarity.f.C0084b;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.MaskingMode;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.models.observers.WebViewStatus;
import com.microsoft.clarity.models.observers.WebViewStatusEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Predicate;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    public final DynamicConfig f144a;
    public final ArrayList b;
    public final ArrayList c;
    public final ArrayList d;
    public final LinkedHashMap e;
    public final ArrayList f;
    public final LinkedHashSet g;
    public final LinkedHashSet h;
    public final LinkedHashSet i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public boolean o;

    public K(Context context, DynamicConfig dynamicConfig) {
        BufferedReader bufferedReader;
        String readText;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
        this.f144a = dynamicConfig;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
        this.f = new ArrayList();
        this.g = new LinkedHashSet();
        this.h = new LinkedHashSet();
        this.i = new LinkedHashSet();
        if (com.microsoft.clarity.m.a.b || com.microsoft.clarity.m.a.f188a) {
            try {
                InputStream open = context.getAssets().open("clarity.js");
                Intrinsics.checkNotNullExpressionValue(open, "context.assets.open(\"clarity.js\")");
                Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
                bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String readText2 = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    readText = readText2;
                } finally {
                }
            } catch (FileNotFoundException unused) {
                File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                Intrinsics.checkNotNull(externalFilesDir);
                File[] listFiles = externalFilesDir.listFiles();
                Intrinsics.checkNotNull(listFiles);
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    if (Intrinsics.areEqual(file.getName(), "clarity.js")) {
                        arrayList.add(file);
                    }
                }
                Object obj = arrayList.get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "context.getExternalFiles…name == \"clarity.js\" }[0]");
                Reader inputStreamReader2 = new InputStreamReader(new FileInputStream((File) obj), Charsets.UTF_8);
                bufferedReader = inputStreamReader2 instanceof BufferedReader ? (BufferedReader) inputStreamReader2 : new BufferedReader(inputStreamReader2, 8192);
                try {
                    readText = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
        } else {
            InputStream open2 = context.getAssets().open("clarity.js");
            Intrinsics.checkNotNullExpressionValue(open2, "context.assets.open(\"clarity.js\")");
            Reader inputStreamReader3 = new InputStreamReader(open2, Charsets.UTF_8);
            bufferedReader = inputStreamReader3 instanceof BufferedReader ? (BufferedReader) inputStreamReader3 : new BufferedReader(inputStreamReader3, 8192);
            try {
                readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
            } finally {
            }
        }
        this.j = readText;
        this.k = "[[START_PARAMS]]";
        this.l = "startClarity([[START_PARAMS]]);";
        this.m = "clearClarity();";
        this.n = "(function() {if(typeof window[\"clarity\"] != \"undefined\" && window[\"clarity\"][\"v\"] != \"-1\" ) return \"4\";else if(typeof window[\"clarityhybrid\"] === \"undefined\") return \"0\";else return window[\"clarityhybrid\"](\"state\");})();";
    }

    public static final String a(WebView webView, K k) {
        long uniqueDrawingId;
        String jSONArray;
        k.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(webView.getId());
        sb.append(',');
        uniqueDrawingId = webView.getUniqueDrawingId();
        sb.append(uniqueDrawingId);
        sb.append(",\"");
        String jSONArray2 = new JSONArray((Collection) k.f144a.getWebMaskSelectors()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "JSONArray(set).toString()");
        sb.append(com.microsoft.clarity.m.k.a(jSONArray2));
        sb.append("\",\"");
        if (k.f144a.getMaskingMode() != MaskingMode.Relaxed || k.f144a.getWebUnmaskSelectors().contains("body") || k.c(webView)) {
            jSONArray = new JSONArray((Collection) k.f144a.getWebUnmaskSelectors()).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(set).toString()");
        } else {
            jSONArray = new JSONArray((Collection) SetsKt.plus(k.f144a.getWebUnmaskSelectors(), "body")).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(set).toString()");
        }
        sb.append(com.microsoft.clarity.m.k.a(jSONArray));
        sb.append("\",");
        sb.append(!k.c(webView));
        return sb.toString();
    }

    public static final void b(WebView webView, K this$0) {
        Intrinsics.checkNotNullParameter(webView, "$webView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        webView.evaluateJavascript(this$0.m, null);
    }

    public final boolean c(WebView webView) {
        LinkedHashSet linkedHashSet = this.g;
        if (!(linkedHashSet instanceof Collection) || !linkedHashSet.isEmpty()) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((WeakReference) it.next()).get(), webView)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final y b(WebView webView) {
        Object obj;
        Iterator it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((y) obj).f167a.get(), webView)) {
                break;
            }
        }
        return (y) obj;
    }

    public static final void a(K k, y yVar) {
        k.getClass();
        WebView webView = (WebView) yVar.f167a.get();
        if (webView == null) {
            return;
        }
        WebMessagePort webMessagePort = (WebMessagePort) k.e.get(Integer.valueOf(yVar.hashCode()));
        if (webMessagePort != null) {
            webMessagePort.close();
        }
        WebMessagePort[] createWebMessageChannel = webView.createWebMessageChannel();
        Intrinsics.checkNotNullExpressionValue(createWebMessageChannel, "webView.createWebMessageChannel()");
        WebMessagePort nativePort = createWebMessageChannel[0];
        WebMessagePort webMessagePort2 = createWebMessageChannel[1];
        nativePort.setWebMessageCallback(new H(k, yVar, webView));
        webView.postWebMessage(new WebMessage("clarityNativePort", new WebMessagePort[]{webMessagePort2}), Uri.parse(ProxyConfig.MATCH_ALL_SCHEMES));
        LinkedHashMap linkedHashMap = k.e;
        Integer valueOf = Integer.valueOf(webView.hashCode());
        Intrinsics.checkNotNullExpressionValue(nativePort, "nativePort");
        linkedHashMap.put(valueOf, nativePort);
    }

    public static final void a(K k, y yVar, WebViewStatus webViewStatus) {
        k.getClass();
        WebView webView = (WebView) yVar.f167a.get();
        if (webView == null || yVar.c == webViewStatus) {
            return;
        }
        Iterator it = k.b.iterator();
        while (it.hasNext()) {
            C0084b c0084b = (C0084b) it.next();
            long currentTimeMillis = System.currentTimeMillis();
            ScreenMetadata screenMetadata = yVar.b;
            String url = webView.getUrl();
            if (url == null) {
                url = "";
            }
            WebViewStatusEvent events = new WebViewStatusEvent(webView, currentTimeMillis, screenMetadata, url, webViewStatus);
            c0084b.getClass();
            Intrinsics.checkNotNullParameter(events, "events");
            c0084b.f113a.o.add(events);
        }
        yVar.c = webViewStatus;
    }

    public final void a(ArrayList arrayList) {
        Long l;
        long uniqueDrawingId;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            y yVar = (y) it.next();
            WebView webView = (WebView) yVar.f167a.get();
            if (webView != null) {
                a(webView);
            }
            linkedHashSet.add(yVar);
            LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
            StringBuilder sb = new StringBuilder("WebView ");
            WebView webView2 = (WebView) yVar.f167a.get();
            if (webView2 != null) {
                uniqueDrawingId = webView2.getUniqueDrawingId();
                l = Long.valueOf(uniqueDrawingId);
            } else {
                l = null;
            }
            sb.append(l);
            sb.append(" in screen ");
            sb.append(yVar.b);
            sb.append(" will be cleared");
            com.microsoft.clarity.m.h.b(sb.toString());
        }
        ArrayList arrayList2 = this.d;
        final J j = new J(linkedHashSet);
        arrayList2.removeIf(new Predicate() { // from class: com.microsoft.clarity.g.K$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return K.a(Function1.this, obj);
            }
        });
    }

    public static final boolean a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final void a(WebView webView, K this$0, y trackedWebViewData, String str) {
        Intrinsics.checkNotNullParameter(webView, "$webView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(trackedWebViewData, "$trackedWebViewData");
        com.microsoft.clarity.m.f.a(new z(webView, this$0, trackedWebViewData, str), new A(this$0, trackedWebViewData), new C(webView, this$0), 2);
    }

    public final void a(final WebView webView) {
        webView.post(new Runnable() { // from class: com.microsoft.clarity.g.K$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                K.b(webView, this);
            }
        });
    }

    public final void a(final y yVar) {
        final WebView webView = (WebView) yVar.f167a.get();
        if (webView == null) {
            return;
        }
        ArrayList arrayList = this.c;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((WeakReference) it.next()).get(), webView)) {
                    return;
                }
            }
        }
        this.c.add(yVar.f167a);
        webView.evaluateJavascript(this.n, new ValueCallback() { // from class: com.microsoft.clarity.g.K$$ExternalSyntheticLambda1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                K.a(webView, this, yVar, (String) obj);
            }
        });
    }

    public final void b(y yVar) {
        long uniqueDrawingId;
        WebView webView = (WebView) yVar.f167a.get();
        if (webView == null) {
            return;
        }
        LogLevel logLevel = com.microsoft.clarity.m.h.f192a;
        StringBuilder sb = new StringBuilder("Restarting Clarity JS for webview #");
        uniqueDrawingId = webView.getUniqueDrawingId();
        sb.append(uniqueDrawingId);
        sb.append('.');
        com.microsoft.clarity.m.h.b(sb.toString());
        a(webView);
        a(yVar);
        CollectionsKt.removeAll((List) this.f, (Function1) new E(webView));
    }
}
