package net.time4j.engine;

/* loaded from: classes7.dex */
public interface Normalizer<U> {
    TimeSpan<U> normalize(TimeSpan<? extends U> timeSpan);
}
