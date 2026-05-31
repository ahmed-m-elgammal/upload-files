package com.microsoft.clarity.e;

import android.graphics.Canvas;
import android.graphics.Point;
import com.microsoft.clarity.models.viewhierarchy.EditTextInfo;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.e.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0065h {

    /* renamed from: a, reason: collision with root package name */
    public final Canvas f84a;
    public final boolean b;
    public final Point c;
    public final LinkedHashSet d;
    public final LinkedHashSet e;
    public final ArrayList f;
    public final LinkedHashSet g;
    public EditTextInfo h;

    public C0065h(Canvas canvas, boolean z) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.f84a = canvas;
        this.b = z;
        this.c = new Point();
        this.d = new LinkedHashSet();
        this.e = new LinkedHashSet();
        this.f = new ArrayList();
        this.g = new LinkedHashSet();
    }
}
