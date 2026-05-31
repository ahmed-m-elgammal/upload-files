package com.facebook.react.devsupport;

import android.content.Context;
import android.net.Uri;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.devlauncher.launcher.DevLauncherControllerInterface;
import expo.modules.manifests.core.Manifest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: DevLauncherDevServerHelper.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/facebook/react/devsupport/DevLauncherDevServerHelper;", "Lcom/facebook/react/devsupport/DevServerHelper;", "context", "Landroid/content/Context;", "controller", "Lexpo/modules/devlauncher/launcher/DevLauncherControllerInterface;", "devSettings", "Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;", "packagerConnection", "Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;", "(Landroid/content/Context;Lexpo/modules/devlauncher/launcher/DevLauncherControllerInterface;Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;)V", "httpClient", "Lokhttp3/OkHttpClient;", "getHttpClient", "()Lokhttp3/OkHttpClient;", "httpClient$delegate", "Lkotlin/Lazy;", "getDevServerBundleURL", "", "jsModulePath", "getDevServerSplitBundleURL", "getSourceMapUrl", "mainModuleName", "getSourceUrl", "isPackagerRunning", "", "callback", "Lcom/facebook/react/devsupport/interfaces/PackagerStatusCallback;", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevLauncherDevServerHelper extends DevServerHelper {
    private final DevLauncherControllerInterface controller;

    /* renamed from: httpClient$delegate, reason: from kotlin metadata */
    private final Lazy httpClient;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevLauncherDevServerHelper(Context context, DevLauncherControllerInterface devLauncherControllerInterface, DeveloperSettings devSettings, PackagerConnectionSettings packagerConnection) {
        super(devSettings, context.getPackageName(), packagerConnection);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(devSettings, "devSettings");
        Intrinsics.checkNotNullParameter(packagerConnection, "packagerConnection");
        this.controller = devLauncherControllerInterface;
        this.httpClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.facebook.react.devsupport.DevLauncherDevServerHelper$httpClient$2
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                return new OkHttpClient.Builder().connectTimeout(5000L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MILLISECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).build();
            }
        });
    }

    private final OkHttpClient getHttpClient() {
        return (OkHttpClient) this.httpClient.getValue();
    }

    @Override // com.facebook.react.devsupport.DevServerHelper
    public String getDevServerBundleURL(String jsModulePath) {
        Manifest manifest;
        String bundleURL;
        DevLauncherControllerInterface devLauncherControllerInterface = this.controller;
        if (devLauncherControllerInterface != null && (manifest = devLauncherControllerInterface.getManifest()) != null && (bundleURL = manifest.getBundleURL()) != null) {
            return bundleURL;
        }
        String devServerBundleURL = super.getDevServerBundleURL(jsModulePath);
        Intrinsics.checkNotNullExpressionValue(devServerBundleURL, "getDevServerBundleURL(...)");
        return devServerBundleURL;
    }

    @Override // com.facebook.react.devsupport.DevServerHelper
    public String getDevServerSplitBundleURL(String jsModulePath) {
        Manifest manifest;
        String bundleURL;
        DevLauncherControllerInterface devLauncherControllerInterface = this.controller;
        if (devLauncherControllerInterface != null && (manifest = devLauncherControllerInterface.getManifest()) != null && (bundleURL = manifest.getBundleURL()) != null) {
            return bundleURL;
        }
        String devServerSplitBundleURL = super.getDevServerSplitBundleURL(jsModulePath);
        Intrinsics.checkNotNullExpressionValue(devServerSplitBundleURL, "getDevServerSplitBundleURL(...)");
        return devServerSplitBundleURL;
    }

    @Override // com.facebook.react.devsupport.DevServerHelper
    public String getSourceUrl(String mainModuleName) {
        Manifest manifest;
        String bundleURL;
        DevLauncherControllerInterface devLauncherControllerInterface = this.controller;
        if (devLauncherControllerInterface != null && (manifest = devLauncherControllerInterface.getManifest()) != null && (bundleURL = manifest.getBundleURL()) != null) {
            return bundleURL;
        }
        String sourceUrl = super.getSourceUrl(mainModuleName);
        Intrinsics.checkNotNullExpressionValue(sourceUrl, "getSourceUrl(...)");
        return sourceUrl;
    }

    @Override // com.facebook.react.devsupport.DevServerHelper
    public String getSourceMapUrl(String mainModuleName) {
        Manifest manifest;
        String bundleURL;
        String sourceMapUrl = super.getSourceMapUrl(mainModuleName);
        DevLauncherControllerInterface devLauncherControllerInterface = this.controller;
        if (devLauncherControllerInterface == null || (manifest = devLauncherControllerInterface.getManifest()) == null || (bundleURL = manifest.getBundleURL()) == null) {
            Intrinsics.checkNotNull(sourceMapUrl);
            return sourceMapUrl;
        }
        Uri parse = Uri.parse(bundleURL);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "getQueryParameterNames(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : queryParameterNames) {
            Intrinsics.checkNotNull(str);
            Pair pair = null;
            if (StringsKt.startsWith$default(str, ViewProps.TRANSFORM, false, 2, (Object) null)) {
                String queryParameter = parse.getQueryParameter(str);
                if (queryParameter == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                pair = TuplesKt.to(str, queryParameter);
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            Intrinsics.checkNotNull(sourceMapUrl);
            return sourceMapUrl;
        }
        return sourceMapUrl + "&" + CollectionsKt.joinToString$default(arrayList2, "&", null, null, 0, null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: com.facebook.react.devsupport.DevLauncherDevServerHelper$getSourceMapUrl$customOptionsString$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Pair<String, String> pair2) {
                Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
                return pair2.component1() + "=" + pair2.component2();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends String> pair2) {
                return invoke2((Pair<String, String>) pair2);
            }
        }, 30, null);
    }

    @Override // com.facebook.react.devsupport.DevServerHelper
    public void isPackagerRunning(final PackagerStatusCallback callback) {
        Manifest manifest;
        String bundleURL;
        Intrinsics.checkNotNullParameter(callback, "callback");
        DevLauncherControllerInterface devLauncherControllerInterface = this.controller;
        if (devLauncherControllerInterface == null || (manifest = devLauncherControllerInterface.getManifest()) == null || (bundleURL = manifest.getBundleURL()) == null) {
            super.isPackagerRunning(callback);
            return;
        }
        String uri = Uri.parse(bundleURL).buildUpon().path("status").clearQuery().build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        getHttpClient().newCall(new Request.Builder().url(uri).build()).enqueue(new Callback() { // from class: com.facebook.react.devsupport.DevLauncherDevServerHelper$isPackagerRunning$1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                PackagerStatusCallback.this.onPackagerStatusFetched(false);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String str;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    PackagerStatusCallback.this.onPackagerStatusFetched(false);
                    return;
                }
                ResponseBody body = response.body();
                if (body == null || (str = body.string()) == null) {
                    str = "";
                }
                PackagerStatusCallback.this.onPackagerStatusFetched(Intrinsics.areEqual(str, "packager-status:running"));
            }
        });
    }
}
