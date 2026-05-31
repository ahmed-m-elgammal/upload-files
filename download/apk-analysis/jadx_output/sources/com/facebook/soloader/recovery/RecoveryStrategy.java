package com.facebook.soloader.recovery;

import com.facebook.soloader.SoSource;

/* loaded from: classes3.dex */
public interface RecoveryStrategy {
    boolean recover(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr);
}
