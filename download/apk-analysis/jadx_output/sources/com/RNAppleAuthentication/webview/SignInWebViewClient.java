package com.RNAppleAuthentication.webview;

import android.os.Handler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.RNAppleAuthentication.SignInWithAppleService;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SignInWebViewClient.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/RNAppleAuthentication/webview/SignInWebViewClient;", "Landroid/webkit/WebViewClient;", "attempt", "Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "javascriptToInject", "", "(Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;Ljava/lang/String;)V", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "setMainHandler", "(Landroid/os/Handler;)V", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SignInWebViewClient extends WebViewClient {
    private final SignInWithAppleService.AuthenticationAttempt attempt;
    private final String javascriptToInject;
    private Handler mainHandler;

    public SignInWebViewClient(SignInWithAppleService.AuthenticationAttempt attempt, String javascriptToInject) {
        Intrinsics.checkNotNullParameter(attempt, "attempt");
        Intrinsics.checkNotNullParameter(javascriptToInject, "javascriptToInject");
        this.attempt = attempt;
        this.javascriptToInject = javascriptToInject;
        this.mainHandler = new Handler();
    }

    public final Handler getMainHandler() {
        return this.mainHandler;
    }

    public final void setMainHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.mainHandler = handler;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(final WebView view, WebResourceRequest request) {
        if (Intrinsics.areEqual(request != null ? request.getMethod() : null, "POST")) {
            String uri = request.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            if (StringsKt.contains$default((CharSequence) uri, (CharSequence) this.attempt.getRedirectUri(), false, 2, (Object) null)) {
                try {
                    Thread.currentThread().interrupt();
                } catch (Exception unused) {
                }
                this.mainHandler.post(new Runnable() { // from class: com.RNAppleAuthentication.webview.SignInWebViewClient$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SignInWebViewClient.shouldInterceptRequest$lambda$0(view, this);
                    }
                });
            }
        }
        return super.shouldInterceptRequest(view, request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shouldInterceptRequest$lambda$0(WebView webView, SignInWebViewClient this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (webView != null) {
            webView.stopLoading();
        }
        if (webView != null) {
            webView.loadUrl("javascript:" + this$0.javascriptToInject);
        }
    }
}
