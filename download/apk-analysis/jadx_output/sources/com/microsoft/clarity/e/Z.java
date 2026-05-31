package com.microsoft.clarity.e;

import android.content.Context;
import android.net.Uri;
import androidx.webkit.WebViewAssetLoader;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.microsoft.clarity.ClarityConfig;
import io.sentry.protocol.App;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.io.IOUtils;

/* loaded from: classes5.dex */
public final class Z {

    /* renamed from: a, reason: collision with root package name */
    public final Context f80a;
    public final ClarityConfig b;
    public final FunctionReferenceImpl c;
    public final Regex d;
    public final Regex e;
    public final Regex f;
    public final Regex g;
    public final Regex h;
    public final LinkedHashMap i;

    /* JADX WARN: Multi-variable type inference failed */
    public Z(Context context, ClarityConfig config, Function2 webAssetCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(webAssetCallback, "webAssetCallback");
        this.f80a = context;
        this.b = config;
        this.c = (FunctionReferenceImpl) webAssetCallback;
        this.d = new Regex("\\[ClarityStyleContent]|\\[/ClarityStyleContent]|\\[ClarityLocalURL]|\\[/ClarityLocalURL]");
        this.e = new Regex("\\[ClarityLocalURL](.*?)\\[/ClarityLocalURL]");
        this.f = new Regex("\\[ClarityStyleContent](.*?)\\[/ClarityStyleContent]");
        this.g = new Regex("url\\((?:'|\\\\\"|\")?(.*?)(?:'|\\\\\"|\")?\\)");
        this.h = new Regex("@import\\s(?:'|\\\\\"|\")(.*?)(?:'|\\\\\"|\");");
        this.i = new LinkedHashMap();
    }

    public final ArrayList a(String str, String str2, boolean z, int i, int i2) {
        boolean z2;
        Sequence<MatchResult> plus = SequencesKt.plus(Regex.findAll$default(this.g, str, 0, 2, null), Regex.findAll$default(this.h, str, 0, 2, null));
        ArrayList arrayList = new ArrayList();
        for (MatchResult matchResult : plus) {
            String str3 = matchResult.getGroupValues().get(1);
            if (StringsKt.indexOf$default((CharSequence) str3, "://", 0, false, 6, (Object) null) > 0 || StringsKt.indexOf$default((CharSequence) str3, "//", 0, false, 6, (Object) null) == 0 || StringsKt.startsWith$default(str3, "data:", false, 2, (Object) null)) {
                try {
                    z2 = a(new URL(str3));
                } catch (Exception unused) {
                    z2 = false;
                }
                if (!z2) {
                }
            }
            String path = Uri.parse(str3).getPath();
            if (path != null) {
                MatchGroup matchGroup = matchResult.getGroups().get(1);
                Intrinsics.checkNotNull(matchGroup);
                V a2 = a(path, str2, z, matchGroup.getRange().getFirst() + i, (path.length() + r4) - 1, i2 + 1);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    public final boolean b(String str) {
        Long l;
        X x = (X) this.i.get(str);
        if (Intrinsics.areEqual(x != null ? Boolean.valueOf(x.b) : null, Boolean.TRUE)) {
            return false;
        }
        X x2 = (X) this.i.get(str);
        return new File(str).lastModified() > ((x2 == null || (l = x2.e) == null) ? 0L : l.longValue());
    }

    public final String c(String str) {
        String uri = Uri.parse("https://clarity.microsoft.com/").buildUpon().appendPath(App.TYPE).appendPath("webasset").appendPath("v1").appendPath(this.b.getProjectId()).appendPath("*clarity-playback-token-placeholder*").appendPath("all").appendEncodedPath(str).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "parse(BuildConfig.WEB_AS…)\n            .toString()");
        return uri;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001e, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r0, "/android_asset", false, 2, (java.lang.Object) null) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.net.URL r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getProtocol()
            java.lang.String r1 = "file"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r1 = 0
            if (r0 == 0) goto L20
            java.lang.String r0 = r6.getPath()
            java.lang.String r2 = "url.path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r2 = 2
            r3 = 0
            java.lang.String r4 = "/android_asset"
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r4, r1, r2, r3)
            if (r0 != 0) goto L48
        L20:
            java.lang.String r0 = r6.getHost()
            java.lang.String r2 = "appassets.androidplatform.net"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 != 0) goto L48
            com.microsoft.clarity.ClarityConfig r0 = r5.b
            boolean r0 = r0.isIonic$sdk_prodRelease()
            if (r0 != 0) goto L3c
            com.microsoft.clarity.ClarityConfig r0 = r5.b
            boolean r0 = r0.isCordova$sdk_prodRelease()
            if (r0 == 0) goto L49
        L3c:
            java.lang.String r6 = r6.getHost()
            java.lang.String r0 = "localhost"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
            if (r6 == 0) goto L49
        L48:
            r1 = 1
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.e.Z.b(java.net.URL):boolean");
    }

    public final boolean a(String str) {
        List<String> emptyList;
        X x = (X) this.i.get(str);
        if (x == null || (emptyList = x.f) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        for (String str2 : emptyList) {
            if (b(str2) || a(str2)) {
                return true;
            }
        }
        return false;
    }

    public final String a(URL url, boolean z) {
        String path = url.getPath();
        if (Intrinsics.areEqual(url.getProtocol(), "file")) {
            Intrinsics.checkNotNullExpressionValue(path, "path");
            path = StringsKt.removePrefix(path, (CharSequence) "/android_asset");
        } else if (Intrinsics.areEqual(url.getHost(), WebViewAssetLoader.DEFAULT_DOMAIN)) {
            Intrinsics.checkNotNullExpressionValue(path, "path");
            path = StringsKt.removePrefix(path, (CharSequence) "assets");
        } else if (this.b.isIonic$sdk_prodRelease() && Intrinsics.areEqual(url.getHost(), AndroidInfoHelpers.DEVICE_LOCALHOST) && z) {
            path = "/";
        }
        Intrinsics.checkNotNullExpressionValue(path, "path");
        return path;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        r3 = r8.f80a.getAssets().open(r10);
        r2 = null;
     */
    /* JADX WARN: Type inference failed for: r11v6, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.FunctionReferenceImpl] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.microsoft.clarity.e.V a(java.lang.String r9, java.lang.String r10, boolean r11, int r12, int r13, int r14) {
        /*
            r8 = this;
            r0 = 6
            r1 = 0
            if (r14 <= r0) goto L5
            return r1
        L5:
            r0 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Exception -> L10
            r2.<init>(r9)     // Catch: java.lang.Exception -> L10
            boolean r2 = r8.a(r2)     // Catch: java.lang.Exception -> L10
            goto L11
        L10:
            r2 = r0
        L11:
            if (r2 == 0) goto L1c
            java.net.URL r11 = new java.net.URL     // Catch: java.lang.Exception -> Laf
            r11.<init>(r9)     // Catch: java.lang.Exception -> Laf
            boolean r11 = r8.b(r11)     // Catch: java.lang.Exception -> Laf
        L1c:
            java.lang.String r10 = r8.a(r10, r9, r2)     // Catch: java.lang.Exception -> Laf
            java.util.LinkedHashMap r2 = r8.i     // Catch: java.lang.Exception -> Laf
            boolean r2 = r2.containsKey(r10)     // Catch: java.lang.Exception -> Laf
            if (r2 == 0) goto L48
            boolean r2 = r8.b(r10)     // Catch: java.lang.Exception -> Laf
            if (r2 != 0) goto L48
            boolean r2 = r8.a(r10)     // Catch: java.lang.Exception -> Laf
            if (r2 == 0) goto L35
            goto L48
        L35:
            com.microsoft.clarity.e.V r11 = new com.microsoft.clarity.e.V     // Catch: java.lang.Exception -> Laf
            java.util.LinkedHashMap r14 = r8.i     // Catch: java.lang.Exception -> Laf
            java.lang.Object r14 = r14.get(r10)     // Catch: java.lang.Exception -> Laf
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)     // Catch: java.lang.Exception -> Laf
            com.microsoft.clarity.e.X r14 = (com.microsoft.clarity.e.X) r14     // Catch: java.lang.Exception -> Laf
            java.lang.String r14 = r14.d     // Catch: java.lang.Exception -> Laf
            r11.<init>(r12, r13, r10, r14)     // Catch: java.lang.Exception -> Laf
            return r11
        L48:
            if (r11 == 0) goto L57
            android.content.Context r2 = r8.f80a     // Catch: java.lang.Exception -> Laf
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Exception -> Laf
            java.io.InputStream r2 = r2.open(r10)     // Catch: java.lang.Exception -> Laf
            r3 = r2
            r2 = r1
            goto L61
        L57:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> Laf
            r2.<init>(r10)     // Catch: java.lang.Exception -> Laf
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Exception -> Laf
            r3.<init>(r2)     // Catch: java.lang.Exception -> Laf
        L61:
            java.lang.String r4 = "if (isContextAsset) {\n  …e.inputStream()\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch: java.lang.Exception -> Laf
            if (r2 == 0) goto L72
            long r4 = r2.lastModified()     // Catch: java.lang.Exception -> Laf
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Exception -> Laf
            r5 = r2
            goto L73
        L72:
            r5 = r1
        L73:
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()     // Catch: java.lang.Exception -> Laf
            r2 = r8
            r4 = r10
            r6 = r11
            com.microsoft.clarity.e.W r2 = r2.a(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> Laf
            com.microsoft.clarity.e.X r3 = r2.f78a     // Catch: java.lang.Exception -> Laf
            java.lang.String r3 = r3.f79a     // Catch: java.lang.Exception -> Laf
            java.lang.String r4 = ".css"
            r5 = 2
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r3, r4, r0, r5, r1)     // Catch: java.lang.Exception -> Laf
            if (r0 == 0) goto L91
            int r14 = r14 + 1
            com.microsoft.clarity.e.W r2 = r8.a(r2, r11, r14)     // Catch: java.lang.Exception -> Laf
        L91:
            java.util.LinkedHashMap r11 = r8.i     // Catch: java.lang.Exception -> Laf
            com.microsoft.clarity.e.X r14 = r2.f78a     // Catch: java.lang.Exception -> Laf
            java.lang.String r0 = r14.f79a     // Catch: java.lang.Exception -> Laf
            r11.put(r0, r14)     // Catch: java.lang.Exception -> Laf
            kotlin.jvm.internal.FunctionReferenceImpl r11 = r8.c     // Catch: java.lang.Exception -> Laf
            com.microsoft.clarity.e.X r14 = r2.f78a     // Catch: java.lang.Exception -> Laf
            java.lang.String r14 = r14.c     // Catch: java.lang.Exception -> Laf
            byte[] r0 = r2.b     // Catch: java.lang.Exception -> Laf
            r11.invoke(r14, r0)     // Catch: java.lang.Exception -> Laf
            com.microsoft.clarity.e.V r11 = new com.microsoft.clarity.e.V     // Catch: java.lang.Exception -> Laf
            com.microsoft.clarity.e.X r14 = r2.f78a     // Catch: java.lang.Exception -> Laf
            java.lang.String r14 = r14.d     // Catch: java.lang.Exception -> Laf
            r11.<init>(r12, r13, r10, r14)     // Catch: java.lang.Exception -> Laf
            return r11
        Laf:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Failed to process local URL "
            r11.<init>(r12)
            r11.append(r9)
            java.lang.String r9 = ", "
            r11.append(r9)
            java.lang.String r9 = r10.getMessage()
            r11.append(r9)
            r9 = 33
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            com.microsoft.clarity.m.h.c(r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.e.Z.a(java.lang.String, java.lang.String, boolean, int, int, int):com.microsoft.clarity.e.V");
    }

    public final boolean a(URL url) {
        return Intrinsics.areEqual(url.getProtocol(), "file") || Intrinsics.areEqual(url.getHost(), WebViewAssetLoader.DEFAULT_DOMAIN) || ((this.b.isIonic$sdk_prodRelease() || this.b.isCordova$sdk_prodRelease()) && Intrinsics.areEqual(url.getHost(), AndroidInfoHelpers.DEVICE_LOCALHOST));
    }

    public final String a(String str, String str2, boolean z) {
        String str3;
        if (z) {
            return StringsKt.trimStart(a(new URL(str2), false), IOUtils.DIR_SEPARATOR_UNIX);
        }
        String canonicalPath = FilesKt.resolve(new File(str), StringsKt.trimStart(str2, IOUtils.DIR_SEPARATOR_UNIX)).getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue(canonicalPath, "File(pageFolderPath)\n   …           .canonicalPath");
        String trimStart = StringsKt.trimStart(canonicalPath, IOUtils.DIR_SEPARATOR_UNIX);
        if (this.b.isCordova$sdk_prodRelease()) {
            str3 = "www";
        } else {
            str3 = this.b.isIonic$sdk_prodRelease() ? "public" : null;
        }
        if (str3 == null || StringsKt.startsWith$default(trimStart, str3, false, 2, (Object) null)) {
            return trimStart;
        }
        return str3 + IOUtils.DIR_SEPARATOR_UNIX + trimStart;
    }

    public final W a(InputStream inputStream, String path, Long l, boolean z, List list) {
        Base64.Encoder urlEncoder;
        String contentHash;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] readBytes = ByteStreamsKt.readBytes(new DigestInputStream(inputStream, messageDigest));
            urlEncoder = Base64.getUrlEncoder();
            contentHash = urlEncoder.encodeToString(messageDigest.digest());
            Intrinsics.checkNotNullExpressionValue(contentHash, "contentHash");
            Intrinsics.checkNotNullParameter(path, "path");
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) path, "/", 0, false, 6, (Object) null) + 1;
            int lastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence) path, ".", 0, false, 6, (Object) null) - 1;
            if (lastIndexOf$default2 < lastIndexOf$default) {
                lastIndexOf$default2 = path.length() - 1;
            }
            String obj = StringsKt.replaceRange((CharSequence) path, new IntRange(lastIndexOf$default, lastIndexOf$default2), (CharSequence) contentHash).toString();
            try {
                W w = new W(new X(path, z, contentHash, obj, c(obj), l, list), readBytes);
                CloseableKt.closeFinally(inputStream, null);
                return w;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(inputStream, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final W a(W w, boolean z, int i) {
        byte[] bArr = w.b;
        Charset charset = Charsets.UTF_8;
        String str = new String(bArr, charset);
        ArrayList a2 = a(str, StringsKt.substringBeforeLast(w.f78a.f79a, IOUtils.DIR_SEPARATOR_UNIX, ""), z, 0, i);
        if (a2.isEmpty()) {
            return w;
        }
        StringBuilder sb = new StringBuilder(str);
        if (a2.size() > 1) {
            CollectionsKt.sortWith(a2, new Y());
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            V v = (V) it.next();
            sb.replace(v.f77a, v.b + 1, v.d);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "newDataBuilder.toString()");
        byte[] bytes = sb2.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        InputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        X x = w.f78a;
        String str2 = x.f79a;
        Long l = x.e;
        boolean z2 = x.b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        Iterator it2 = a2.iterator();
        while (it2.hasNext()) {
            arrayList.add(((V) it2.next()).c);
        }
        return a(byteArrayInputStream, str2, l, z2, arrayList);
    }
}
