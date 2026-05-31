package com.microsoft.clarity.m;

import com.microsoft.clarity.models.LogLevel;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class g {
    public static HttpURLConnection a(String url, String requestMethod, Map requestProperties) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestMethod, "requestMethod");
        Intrinsics.checkNotNullParameter(requestProperties, "requestProperties");
        URLConnection openConnection = new URL(url).openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestMethod(requestMethod);
        httpURLConnection.setRequestProperty("SDK-Version", StringsKt.substringBefore$default("3.1.3", '-', (String) null, 2, (Object) null));
        for (Map.Entry entry : requestProperties.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        LogLevel logLevel = h.f192a;
        h.b("--> " + httpURLConnection.getRequestMethod() + ' ' + httpURLConnection.getURL() + '.');
        return httpURLConnection;
    }

    public static boolean b(HttpURLConnection urlConnection) {
        String str;
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        int responseCode = urlConnection.getResponseCode();
        boolean z = 200 <= responseCode && responseCode < 300;
        String str2 = "<-- " + urlConnection.getURL() + ": " + urlConnection.getResponseCode() + ' ' + urlConnection.getResponseMessage() + '.';
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(' ');
            InputStream errorStream = urlConnection.getErrorStream();
            if (errorStream != null) {
                Reader inputStreamReader = new InputStreamReader(errorStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    str = StringsKt.substringBefore$default(StringsKt.substringAfter$default(TextStreamsKt.readText(bufferedReader), "\"detail\":\"", (String) null, 2, (Object) null), "\"", (String) null, 2, (Object) null);
                    CloseableKt.closeFinally(bufferedReader, null);
                } finally {
                }
            } else {
                str = "";
            }
            sb.append(str);
            str2 = sb.toString();
        }
        h.b(str2);
        return z;
    }

    public static void a(HttpURLConnection urlConnection, byte[] requestData) {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        urlConnection.setDoOutput(true);
        urlConnection.setFixedLengthStreamingMode(requestData.length);
        OutputStream outputStream = urlConnection.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "urlConnection.outputStream");
        BufferedOutputStream bufferedOutputStream = outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, 8192);
        try {
            bufferedOutputStream.write(requestData);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedOutputStream, null);
        } finally {
        }
    }

    public static void a(HttpURLConnection urlConnection, String serializedRequestData) {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        Intrinsics.checkNotNullParameter(serializedRequestData, "serializedRequestData");
        LogLevel logLevel = h.f192a;
        h.b("--> " + urlConnection.getURL() + ": " + serializedRequestData + '.');
        byte[] bytes = serializedRequestData.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        a(urlConnection, bytes);
    }

    public static String a(HttpURLConnection urlConnection) {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        if (b(urlConnection)) {
            InputStream inputStream = urlConnection.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "urlConnection.inputStream");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                LogLevel logLevel = h.f192a;
                h.b("<-- " + urlConnection.getURL() + ": " + readText + '.');
                CloseableKt.closeFinally(bufferedReader, null);
                return readText;
            } finally {
            }
        } else {
            throw new com.microsoft.clarity.c.b("Unsuccessful request: " + urlConnection.getResponseMessage());
        }
    }
}
