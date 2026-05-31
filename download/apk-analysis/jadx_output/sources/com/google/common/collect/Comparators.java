package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Comparators {
    private Comparators() {
    }

    public static <T, S extends T> Comparator<Iterable<S>> lexicographical(Comparator<T> comparator) {
        return new LexicographicalOrdering((Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <T> boolean isInOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> boolean isInStrictOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T extends Comparable<? super T>> T min(T a2, T b) {
        return a2.compareTo(b) <= 0 ? a2 : b;
    }

    @ParametricNullness
    public static <T> T min(@ParametricNullness T a2, @ParametricNullness T b, Comparator<T> comparator) {
        return comparator.compare(a2, b) <= 0 ? a2 : b;
    }

    public static <T extends Comparable<? super T>> T max(T a2, T b) {
        return a2.compareTo(b) >= 0 ? a2 : b;
    }

    @ParametricNullness
    public static <T> T max(@ParametricNullness T a2, @ParametricNullness T b, Comparator<T> comparator) {
        return comparator.compare(a2, b) >= 0 ? a2 : b;
    }
}
