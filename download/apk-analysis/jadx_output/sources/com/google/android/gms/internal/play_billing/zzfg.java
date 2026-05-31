package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes4.dex */
public final class zzfg {
    private static final zzfg zza = new zzfg(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzfg() {
        this(0, new int[8], new Object[8], true);
    }

    private zzfg(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzfg zzc() {
        return zza;
    }

    static zzfg zze(zzfg zzfgVar, zzfg zzfgVar2) {
        int i = zzfgVar.zzb + zzfgVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzfgVar.zzc, i);
        System.arraycopy(zzfgVar2.zzc, 0, copyOf, zzfgVar.zzb, zzfgVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzfgVar.zzd, i);
        System.arraycopy(zzfgVar2.zzd, 0, copyOf2, zzfgVar.zzb, zzfgVar2.zzb);
        return new zzfg(i, copyOf, copyOf2, true);
    }

    static zzfg zzf() {
        return new zzfg(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzfg)) {
            return false;
        }
        zzfg zzfgVar = (zzfg) obj;
        int i = this.zzb;
        if (i == zzfgVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzfgVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzfgVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int zzw;
        int zzx;
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 0) {
                if (i7 == 1) {
                    ((Long) this.zzd[i4]).longValue();
                    i = zzby.zzw(i6 << 3) + 8;
                } else if (i7 == 2) {
                    int i8 = i6 << 3;
                    zzbq zzbqVar = (zzbq) this.zzd[i4];
                    int zzw2 = zzby.zzw(i8);
                    int zzd = zzbqVar.zzd();
                    i = zzw2 + zzby.zzw(zzd) + zzd;
                } else if (i7 == 3) {
                    int zzw3 = zzby.zzw(i6 << 3);
                    zzw = zzw3 + zzw3;
                    zzx = ((zzfg) this.zzd[i4]).zza();
                } else {
                    if (i7 != 5) {
                        throw new IllegalStateException(zzdc.zza());
                    }
                    ((Integer) this.zzd[i4]).intValue();
                    i = zzby.zzw(i6 << 3) + 4;
                }
                i3 += i;
            } else {
                int i9 = i6 << 3;
                long longValue = ((Long) this.zzd[i4]).longValue();
                zzw = zzby.zzw(i9);
                zzx = zzby.zzx(longValue);
            }
            i = zzw + zzx;
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3] >>> 3;
            zzbq zzbqVar = (zzbq) this.zzd[i3];
            int zzw = zzby.zzw(8);
            int zzw2 = zzby.zzw(16) + zzby.zzw(i4);
            int zzw3 = zzby.zzw(24);
            int zzd = zzbqVar.zzd();
            i2 += zzw + zzw + zzw2 + zzw3 + zzby.zzw(zzd) + zzd;
        }
        this.zze = i2;
        return i2;
    }

    final zzfg zzd(zzfg zzfgVar) {
        if (zzfgVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzfgVar.zzb;
        zzm(i);
        System.arraycopy(zzfgVar.zzc, 0, this.zzc, this.zzb, zzfgVar.zzb);
        System.arraycopy(zzfgVar.zzd, 0, this.zzd, this.zzb, zzfgVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzee.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    final void zzk(zzfx zzfxVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzfxVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzfx zzfxVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzfxVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzfxVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzfxVar.zzd(i4, (zzbq) obj);
                } else if (i3 == 3) {
                    zzfxVar.zzF(i4);
                    ((zzfg) obj).zzl(zzfxVar);
                    zzfxVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(zzdc.zza());
                    }
                    zzfxVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }
}
