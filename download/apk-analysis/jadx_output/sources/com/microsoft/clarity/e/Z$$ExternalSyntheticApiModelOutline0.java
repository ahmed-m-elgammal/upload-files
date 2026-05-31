package com.microsoft.clarity.e;

import android.content.res.loader.ResourcesLoader;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.drawable.AdaptiveIconDrawable;
import dalvik.system.DelegateLastClassLoader;
import java.nio.file.Path;
import java.nio.file.attribute.AclEntryPermission;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes5.dex */
public final /* synthetic */ class Z$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ ResourcesLoader m() {
        return new ResourcesLoader();
    }

    public static /* synthetic */ BlendModeColorFilter m(int i, BlendMode blendMode) {
        return new BlendModeColorFilter(i, blendMode);
    }

    public static /* synthetic */ DelegateLastClassLoader m(String str, ClassLoader classLoader) {
        return new DelegateLastClassLoader(str, classLoader);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m1811m() {
        return Path.class;
    }

    public static /* bridge */ /* synthetic */ Path m(Object obj) {
        return (Path) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m1824m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m1825m(Object obj) {
        return obj instanceof AdaptiveIconDrawable;
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return AclEntryPermission.class;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m1829m$1() {
    }

    public static /* synthetic */ void m$2() {
    }
}
