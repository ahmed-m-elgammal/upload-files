package com.microsoft.clarity.j;

import com.microsoft.clarity.models.AssetType;

/* loaded from: classes5.dex */
public abstract /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f180a;

    static {
        int[] iArr = new int[AssetType.values().length];
        try {
            iArr[AssetType.Image.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[AssetType.Typeface.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[AssetType.Web.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[AssetType.Unsupported.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f180a = iArr;
    }
}
