package com.microsoft.clarity.e;

import com.microsoft.clarity.models.viewhierarchy.ViewNode;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.e.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0058a {

    /* renamed from: a, reason: collision with root package name */
    public final ViewNode f81a;
    public final boolean b;
    public final ArrayList c;
    public final int d;

    public C0058a(ViewNode node, int i, boolean z) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.f81a = node;
        this.b = z;
        this.c = new ArrayList();
        this.d = node.getWidth() * node.getHeight();
        a(node.getType(), node.getId(), i);
    }

    public final void a(String type, int i, int i2) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (i == -1) {
            this.c.add(0, "/" + type + '[' + i2 + ']');
            return;
        }
        this.c.add(0, "/" + type + '#' + i + '[' + i2 + ']');
    }
}
