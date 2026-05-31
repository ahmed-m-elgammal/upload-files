package org.apache.commons.lang3.concurrent;

/* loaded from: classes7.dex */
public interface ConcurrentInitializer<T> {
    T get() throws ConcurrentException;
}
