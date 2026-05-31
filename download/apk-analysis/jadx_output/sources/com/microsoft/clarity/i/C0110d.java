package com.microsoft.clarity.i;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.i.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0110d {

    /* renamed from: a, reason: collision with root package name */
    public final List f172a;
    public final ArrayList b;
    public final ArrayList c;
    public final ArrayList d;
    public final ArrayList e;
    public final ArrayList f;
    public final ArrayList g;
    public final ArrayList h;

    public C0110d(List commands, ArrayList typefaces, ArrayList images, ArrayList textBlobs, ArrayList vertices, ArrayList paints, ArrayList paths, ArrayList subDisplayFrameParseResults) {
        Intrinsics.checkNotNullParameter(commands, "commands");
        Intrinsics.checkNotNullParameter(typefaces, "typefaces");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(textBlobs, "textBlobs");
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(subDisplayFrameParseResults, "subDisplayFrameParseResults");
        this.f172a = commands;
        this.b = typefaces;
        this.c = images;
        this.d = textBlobs;
        this.e = vertices;
        this.f = paints;
        this.g = paths;
        this.h = subDisplayFrameParseResults;
    }
}
