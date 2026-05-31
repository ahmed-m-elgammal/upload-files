package com.rnfs;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.media.AudioFocusRequest;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes5.dex */
public final /* synthetic */ class Downloader$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ Notification.Builder m(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static /* bridge */ /* synthetic */ NotificationChannel m(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* synthetic */ NotificationChannel m(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ NotificationChannelGroup m2146m(Object obj) {
        return (NotificationChannelGroup) obj;
    }

    public static /* synthetic */ NotificationChannelGroup m(String str, CharSequence charSequence) {
        return new NotificationChannelGroup(str, charSequence);
    }

    public static /* synthetic */ SurfaceTexture m(boolean z) {
        return new SurfaceTexture(z);
    }

    public static /* synthetic */ Typeface.Builder m(AssetManager assetManager, String str) {
        return new Typeface.Builder(assetManager, str);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ AudioFocusRequest.Builder m2150m(int i) {
        return new AudioFocusRequest.Builder(i);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m2151m() {
        return BasicFileAttributes.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m2156m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m2158m(Object obj) {
        return obj instanceof NotificationChannelGroup;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m2161m$1() {
        return Path.class;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m2162m$1() {
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m2165m$2() {
        return LocalDate.class;
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m2166m$2() {
    }
}
