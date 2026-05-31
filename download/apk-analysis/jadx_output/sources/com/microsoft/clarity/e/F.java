package com.microsoft.clarity.e;

import com.microsoft.clarity.models.AssetType;

/* loaded from: classes5.dex */
public abstract /* synthetic */ class F {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f62a;

    static {
        int[] iArr = new int[AssetType.values().length];
        try {
            iArr[AssetType.Web.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[AssetType.Image.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[AssetType.Typeface.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f62a = iArr;
    }
}
