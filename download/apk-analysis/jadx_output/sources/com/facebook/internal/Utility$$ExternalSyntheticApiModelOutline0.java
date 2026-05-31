package com.facebook.internal;

import android.icu.text.DecimalFormat;
import android.icu.text.MeasureFormat;
import android.icu.util.Measure;
import android.icu.util.MeasureUnit;
import android.media.ExifInterface;
import android.view.autofill.AutofillManager;
import java.io.FileDescriptor;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class Utility$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ DecimalFormat m(Object obj) {
        return (DecimalFormat) obj;
    }

    public static /* synthetic */ Measure m(Number number, MeasureUnit measureUnit) {
        return new Measure(number, measureUnit);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ MeasureUnit m1026m(Object obj) {
        return (MeasureUnit) obj;
    }

    public static /* synthetic */ ExifInterface m(FileDescriptor fileDescriptor) {
        return new ExifInterface(fileDescriptor);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AutofillManager m1030m(Object obj) {
        return (AutofillManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m1031m() {
        return AutofillManager.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m1036m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m1038m(Object obj) {
        return obj instanceof MeasureFormat;
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof DecimalFormat;
    }
}
