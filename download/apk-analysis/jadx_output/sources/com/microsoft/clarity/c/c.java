package com.microsoft.clarity.c;

/* loaded from: classes5.dex */
public final class c extends Exception {
    public c(int i) {
        super("Picture size exceeds available memory limit with attempt of " + i + " bytes.");
    }
}
