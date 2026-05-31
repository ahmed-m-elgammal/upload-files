package io.sentry.metrics;

import androidx.media3.exoplayer.upstream.CmcdData;

/* loaded from: classes6.dex */
public enum MetricType {
    Counter("c"),
    Gauge("g"),
    Distribution("d"),
    Set(CmcdData.Factory.STREAMING_FORMAT_SS);

    final String statsdCode;

    MetricType(String str) {
        this.statsdCode = str;
    }
}
