package com.microsoft.clarity.m;

import com.microsoft.clarity.i.C0107a;
import com.microsoft.clarity.i.C0108b;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final MessageDigest f189a = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);

    public static C0108b a(byte[] bytes, int i, int i2) {
        Base64.Encoder urlEncoder;
        String md5HashString;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        MessageDigest messageDigest = f189a;
        messageDigest.reset();
        messageDigest.update(bytes, i, i2);
        byte[] digest = messageDigest.digest();
        urlEncoder = Base64.getUrlEncoder();
        md5HashString = urlEncoder.encodeToString(messageDigest.digest(digest));
        C0107a c0107a = new C0107a(bytes, i, i2);
        Intrinsics.checkNotNullExpressionValue(md5HashString, "md5HashString");
        return new C0108b(c0107a, md5HashString);
    }

    public static byte[] a(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        Writer outputStreamWriter = new OutputStreamWriter(gZIPOutputStream, UTF_8);
        BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
        try {
            bufferedWriter.write(content);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "bos.toByteArray()");
            return byteArray;
        } finally {
        }
    }
}
