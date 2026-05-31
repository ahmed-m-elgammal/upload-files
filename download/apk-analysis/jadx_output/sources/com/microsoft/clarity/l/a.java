package com.microsoft.clarity.l;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f184a = new a();

    public a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        Path path;
        Stream list;
        Optional findFirst;
        boolean isPresent;
        File f = (File) obj;
        Intrinsics.checkNotNullParameter(f, "f");
        if (f.isDirectory()) {
            path = f.toPath();
            list = Files.list(path);
            findFirst = list.findFirst();
            isPresent = findFirst.isPresent();
            if (!isPresent) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
