package com.google.common.base;

import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes3.dex */
public final class Objects extends ExtraObjectsMethodsForWeb {
    private Objects() {
    }

    public static boolean equal(@CheckForNull Object a2, @CheckForNull Object b) {
        return a2 == b || (a2 != null && a2.equals(b));
    }

    public static int hashCode(@CheckForNull Object... objects) {
        return Arrays.hashCode(objects);
    }
}
