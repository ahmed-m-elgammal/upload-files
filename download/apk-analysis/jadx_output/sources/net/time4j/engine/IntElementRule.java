package net.time4j.engine;

/* loaded from: classes7.dex */
public interface IntElementRule<T> extends ElementRule<T, Integer> {
    int getInt(T t);

    boolean isValid(T t, int i);

    T withValue(T t, int i, boolean z);
}
