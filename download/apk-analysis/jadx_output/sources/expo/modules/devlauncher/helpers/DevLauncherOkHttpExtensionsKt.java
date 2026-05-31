package expo.modules.devlauncher.helpers;

import android.net.Uri;
import io.sentry.protocol.Request;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* compiled from: DevLauncherOkHttpExtensions.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001aG\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f0\u000b\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0002\u0010\r\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0086H¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"fetch", "Lokhttp3/Request;", "url", "Landroid/net/Uri;", Request.JsonKeys.METHOD, "", "headers", "Lokhttp3/Headers;", "post", "requestBody", "Lokhttp3/RequestBody;", "", "Lkotlin/Pair;", "(Landroid/net/Uri;Lokhttp3/RequestBody;[Lkotlin/Pair;)Lokhttp3/Request;", "await", "Lokhttp3/Response;", "okHttpClient", "Lokhttp3/OkHttpClient;", "(Lokhttp3/Request;Lokhttp3/OkHttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-dev-launcher_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherOkHttpExtensionsKt {
    public static final okhttp3.Request fetch(Uri url, String method, Headers headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Request.Builder method2 = new Request.Builder().method(method, null);
        String uri = url.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return method2.url(uri).headers(headers).build();
    }

    public static final okhttp3.Request post(Uri url, RequestBody requestBody, Pair<String, String>... headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Request.Builder method = new Request.Builder().method("POST", requestBody);
        String uri = url.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        Request.Builder url2 = method.url(uri);
        for (Pair<String, String> pair : headers) {
            url2.addHeader(pair.getFirst(), pair.getSecond());
        }
        return url2.build();
    }

    private static final Object await$$forInline(okhttp3.Request request, OkHttpClient okHttpClient, Continuation<? super Response> continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        okHttpClient.newCall(request).enqueue(new DevLauncherOkHttpExtensionsKt$await$2$1(cancellableContinuationImpl));
        Unit unit = Unit.INSTANCE;
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final Object await(okhttp3.Request request, OkHttpClient okHttpClient, Continuation<? super Response> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        okHttpClient.newCall(request).enqueue(new DevLauncherOkHttpExtensionsKt$await$2$1(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
