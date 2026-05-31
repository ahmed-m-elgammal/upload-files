package com.microsoft.clarity.e;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    public final String f79a;
    public final boolean b;
    public final String c;
    public final String d;
    public final Long e;
    public final List f;

    public X(String path, boolean z, String hash, String pathWithHash, String absolutePathWithHash, Long l, List dependencies) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(pathWithHash, "pathWithHash");
        Intrinsics.checkNotNullParameter(absolutePathWithHash, "absolutePathWithHash");
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        this.f79a = path;
        this.b = z;
        this.c = pathWithHash;
        this.d = absolutePathWithHash;
        this.e = l;
        this.f = dependencies;
    }
}
