package com.microsoft.clarity.e;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.microsoft.clarity.e.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0075s {
    public C0075s(Context context, com.microsoft.clarity.m.d deviceUtils) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceUtils, "deviceUtils");
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter("frame_snapshots", "directory");
        String[] paths = {"microsoft_clarity", "frame_snapshots"};
        Intrinsics.checkNotNullParameter(paths, "paths");
        char c = File.separatorChar;
        String joinToString$default = ArraysKt.joinToString$default(paths, String.valueOf(c), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (path == null) {
            path = context.getCacheDir().toString();
            Intrinsics.checkNotNullExpressionValue(path, "context.cacheDir.toString()");
        }
        String[] paths2 = {path, joinToString$default};
        Intrinsics.checkNotNullParameter(paths2, "paths");
        ArraysKt.joinToString$default(paths2, String.valueOf(c), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
