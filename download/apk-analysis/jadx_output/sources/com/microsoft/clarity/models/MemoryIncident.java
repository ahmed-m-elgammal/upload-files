package com.microsoft.clarity.models;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/microsoft/clarity/models/MemoryIncident;", "", "errorType", "", "metricPrefix", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getErrorType", "()Ljava/lang/String;", "getMetricPrefix", "LowDeviceMemory", "PictureSizeExceededMemory", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum MemoryIncident {
    LowDeviceMemory("LowDeviceMemory", "Clarity_LowDeviceMemory_"),
    PictureSizeExceededMemory("PictureSizeExceededMemory", "Clarity_PictureSizeExceededMemory_");

    private final String errorType;
    private final String metricPrefix;

    MemoryIncident(String str, String str2) {
        this.errorType = str;
        this.metricPrefix = str2;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getMetricPrefix() {
        return this.metricPrefix;
    }
}
