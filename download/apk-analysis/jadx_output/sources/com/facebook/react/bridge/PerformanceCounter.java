package com.facebook.react.bridge;

import java.util.Map;

/* loaded from: classes3.dex */
interface PerformanceCounter {
    Map<String, Long> getPerformanceCounters();

    void profileNextBatch();
}
