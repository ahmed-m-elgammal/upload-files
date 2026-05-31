package com.microsoft.clarity.g;

import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.models.observers.WebViewStatus;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f167a;
    public final ScreenMetadata b;
    public WebViewStatus c;

    public y(WeakReference webViewRef, ScreenMetadata screenMetadata) {
        Intrinsics.checkNotNullParameter(webViewRef, "webViewRef");
        Intrinsics.checkNotNullParameter(screenMetadata, "screenMetadata");
        this.f167a = webViewRef;
        this.b = screenMetadata;
    }
}
