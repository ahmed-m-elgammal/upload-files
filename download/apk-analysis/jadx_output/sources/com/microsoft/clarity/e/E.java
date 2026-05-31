package com.microsoft.clarity.e;

import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    public final String f61a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final String g;

    public E(String url, long j, long j2, long j3, long j4, boolean z, String installVersion) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(installVersion, "installVersion");
        this.f61a = url;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z;
        this.g = installVersion;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E)) {
            return false;
        }
        E e = (E) obj;
        return Intrinsics.areEqual(this.f61a, e.f61a) && this.b == e.b && this.c == e.c && this.d == e.d && this.e == e.e && this.f == e.f && Intrinsics.areEqual(this.g, e.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m = (UByte$$ExternalSyntheticBackport0.m(this.e) + ((UByte$$ExternalSyntheticBackport0.m(this.d) + ((UByte$$ExternalSyntheticBackport0.m(this.c) + ((UByte$$ExternalSyntheticBackport0.m(this.b) + (this.f61a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.f;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return this.g.hashCode() + ((m + i) * 31);
    }

    public final String toString() {
        return "ReferrerDetails(url=" + this.f61a + ", clickTime=" + this.b + ", appInstallTime=" + this.c + ", serverClickTime=" + this.d + ", serverAppInstallTime=" + this.e + ", instantExperienceLaunched=" + this.f + ", installVersion=" + this.g + ')';
    }
}
