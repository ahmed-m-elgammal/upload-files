package androidx.media3.common;

import android.os.Bundle;

@Deprecated
/* loaded from: classes.dex */
public interface Bundleable {

    @Deprecated
    public interface Creator<T extends Bundleable> {
        T fromBundle(Bundle bundle);
    }

    Bundle toBundle();
}
