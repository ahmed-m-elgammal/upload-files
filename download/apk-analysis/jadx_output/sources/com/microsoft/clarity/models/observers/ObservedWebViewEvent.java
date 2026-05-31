package com.microsoft.clarity.models.observers;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0006H&J\b\u0010\u0012\u001a\u00020\u000eH&R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/microsoft/clarity/models/observers/ObservedWebViewEvent;", "Lcom/microsoft/clarity/models/observers/ObservedEvent;", "timestamp", "", "(J)V", "data", "", "getData", "()Ljava/lang/String;", "screenMetadata", "Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "getScreenMetadata", "()Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "webViewHashCode", "", "getWebViewHashCode", "()I", "getPageUrl", "getType", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ObservedWebViewEvent extends ObservedEvent {
    public ObservedWebViewEvent(long j) {
        super(j);
    }

    public abstract String getData();

    public abstract String getPageUrl();

    public abstract ScreenMetadata getScreenMetadata();

    public abstract int getType();

    public abstract int getWebViewHashCode();
}
