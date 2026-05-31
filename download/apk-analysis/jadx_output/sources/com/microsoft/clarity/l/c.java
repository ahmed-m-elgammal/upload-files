package com.microsoft.clarity.l;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f186a;

    public c(Context context, String directory, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(directory, "directory");
        String[] paths = {"microsoft_clarity", directory};
        Intrinsics.checkNotNullParameter(paths, "paths");
        char c = File.separatorChar;
        String joinToString$default = ArraysKt.joinToString$default(paths, String.valueOf(c), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (str == null) {
            str = context.getCacheDir().toString();
            Intrinsics.checkNotNullExpressionValue(str, "context.cacheDir.toString()");
        }
        String[] paths2 = {str, joinToString$default};
        Intrinsics.checkNotNullParameter(paths2, "paths");
        this.f186a = ArraysKt.joinToString$default(paths2, String.valueOf(c), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static List a(c cVar, String prefix, boolean z, int i) {
        if ((i & 1) != 0) {
            prefix = "";
        }
        if ((i & 2) != 0) {
            z = false;
        }
        cVar.getClass();
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        String[] paths = {cVar.f186a, prefix};
        Intrinsics.checkNotNullParameter(paths, "paths");
        return SequencesKt.toList(SequencesKt.filter(FilesKt.walkTopDown(new File(ArraysKt.joinToString$default(paths, String.valueOf(File.separatorChar), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null))), new b(z)));
    }

    public final String b(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(filename, "filename");
        FileInputStream fileInputStream = new FileInputStream(new File(a(filename)));
        try {
            byte[] readBytes = ByteStreamsKt.readBytes(fileInputStream);
            CloseableKt.closeFinally(fileInputStream, null);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return new String(readBytes, UTF_8);
        } finally {
        }
    }

    public final void a(String filename, String content, d mode) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(mode, "mode");
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        a(filename, bytes, 0, bytes.length, mode);
    }

    public final void a(String str, byte[] bArr, int i, int i2, d dVar) {
        File file = new File(a(str));
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, dVar == d.APPEND);
        try {
            fileOutputStream.write(bArr, i, i2);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public final String a(String str) {
        String[] paths = {this.f186a, str};
        Intrinsics.checkNotNullParameter(paths, "paths");
        return ArraysKt.joinToString$default(paths, String.valueOf(File.separatorChar), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
