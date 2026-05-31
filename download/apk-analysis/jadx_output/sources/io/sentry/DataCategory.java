package io.sentry;

import com.google.android.gms.common.Scopes;
import io.sentry.cache.EnvelopeCache;
import org.apache.commons.fileupload.FileUploadBase;

/* loaded from: classes6.dex */
public enum DataCategory {
    All("__all__"),
    Default("default"),
    Error("error"),
    Session(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE),
    Attachment(FileUploadBase.ATTACHMENT),
    Monitor("monitor"),
    Profile(Scopes.PROFILE),
    MetricBucket("metric_bucket"),
    Transaction("transaction"),
    Replay("replay"),
    Span("span"),
    Security("security"),
    UserReport("user_report"),
    Unknown("unknown");

    private final String category;

    DataCategory(String str) {
        this.category = str;
    }

    public String getCategory() {
        return this.category;
    }
}
