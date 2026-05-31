package com.microsoft.clarity.f;

import com.microsoft.clarity.models.MaskingMode;

/* renamed from: com.microsoft.clarity.f.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC0087e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f116a;

    static {
        int[] iArr = new int[MaskingMode.values().length];
        try {
            iArr[MaskingMode.Strict.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[MaskingMode.Balanced.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[MaskingMode.Relaxed.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f116a = iArr;
    }
}
