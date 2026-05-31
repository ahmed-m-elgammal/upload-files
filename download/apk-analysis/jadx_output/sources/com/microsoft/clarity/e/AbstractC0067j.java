package com.microsoft.clarity.e;

import com.microsoft.clarity.models.ApplicationFramework;

/* renamed from: com.microsoft.clarity.e.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC0067j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f86a;

    static {
        int[] iArr = new int[ApplicationFramework.values().length];
        try {
            iArr[ApplicationFramework.Native.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[ApplicationFramework.ReactNative.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f86a = iArr;
    }
}
