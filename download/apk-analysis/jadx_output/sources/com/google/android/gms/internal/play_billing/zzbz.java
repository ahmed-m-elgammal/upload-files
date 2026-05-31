package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes4.dex */
final class zzbz implements zzfx {
    private final zzby zza;

    private zzbz(zzby zzbyVar) {
        byte[] bArr = zzda.zzd;
        this.zza = zzbyVar;
        zzbyVar.zza = this;
    }

    public static zzbz zza(zzby zzbyVar) {
        zzbz zzbzVar = zzbyVar.zza;
        return zzbzVar != null ? zzbzVar : new zzbz(zzbyVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzp(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzD(int i, long j) throws IOException {
        this.zza.zzr(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzo(i, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzG(int i, String str) throws IOException {
        this.zza.zzm(i, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzp(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzK(int i, long j) throws IOException {
        this.zza.zzr(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzd(int i, zzbq zzbqVar) throws IOException {
        this.zza.zze(i, zzbqVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, (zzbq) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzo(i, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzo(int i, float f) throws IOException {
        this.zza.zzf(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzq(int i, Object obj, zzeo zzeoVar) throws IOException {
        zzby zzbyVar = this.zza;
        zzbyVar.zzo(i, 3);
        zzeoVar.zzi((zzec) obj, zzbyVar.zza);
        zzbyVar.zzo(i, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzr(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzv(int i, Object obj, zzeo zzeoVar) throws IOException {
        zzec zzecVar = (zzec) obj;
        zzbv zzbvVar = (zzbv) this.zza;
        zzbvVar.zzq((i << 3) | 2);
        zzbvVar.zzq(((zzay) zzecVar).zza(zzeoVar));
        zzeoVar.zzi(zzecVar, zzbvVar.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzbq) {
            zzbv zzbvVar = (zzbv) this.zza;
            zzbvVar.zzq(11);
            zzbvVar.zzp(2, i);
            zzbvVar.zze(3, (zzbq) obj);
            zzbvVar.zzq(12);
            return;
        }
        zzby zzbyVar = this.zza;
        zzec zzecVar = (zzec) obj;
        zzbv zzbvVar2 = (zzbv) zzbyVar;
        zzbvVar2.zzq(11);
        zzbvVar2.zzp(2, i);
        zzbvVar2.zzq(26);
        zzbvVar2.zzq(zzecVar.zzf());
        zzecVar.zze(zzbyVar);
        zzbvVar2.zzq(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzz(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzdk)) {
            while (i2 < list.size()) {
                this.zza.zzm(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzdk zzdkVar = (zzdk) list;
        while (i2 < list.size()) {
            Object zzf = zzdkVar.zzf(i2);
            if (zzf instanceof String) {
                this.zza.zzm(i, (String) zzf);
            } else {
                this.zza.zze(i, (zzbq) zzf);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzct)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzp(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzby.zzw(((Integer) list.get(i4)).intValue());
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z) {
            while (i2 < zzctVar.size()) {
                this.zza.zzp(i, zzctVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzctVar.size(); i6++) {
            i5 += zzby.zzw(zzctVar.zze(i6));
        }
        this.zza.zzq(i5);
        while (i2 < zzctVar.size()) {
            this.zza.zzq(zzctVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzdr)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzr(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzby.zzx(((Long) list.get(i4)).longValue());
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzs(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzdr zzdrVar = (zzdr) list;
        if (!z) {
            while (i2 < zzdrVar.size()) {
                this.zza.zzr(i, zzdrVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzdrVar.size(); i6++) {
            i5 += zzby.zzx(zzdrVar.zze(i6));
        }
        this.zza.zzq(i5);
        while (i2 < zzdrVar.size()) {
            this.zza.zzs(zzdrVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzct)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z) {
            while (i2 < zzctVar.size()) {
                this.zza.zzf(i, zzctVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzctVar.size(); i6++) {
            zzctVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzq(i5);
        while (i2 < zzctVar.size()) {
            this.zza.zzg(zzctVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzdr)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzdr zzdrVar = (zzdr) list;
        if (!z) {
            while (i2 < zzdrVar.size()) {
                this.zza.zzh(i, zzdrVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzdrVar.size(); i6++) {
            zzdrVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzq(i5);
        while (i2 < zzdrVar.size()) {
            this.zza.zzi(zzdrVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbe)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzbe zzbeVar = (zzbe) list;
        if (!z) {
            while (i2 < zzbeVar.size()) {
                this.zza.zzd(i, zzbeVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzbeVar.size(); i6++) {
            zzbeVar.zzf(i6);
            i5++;
        }
        this.zza.zzq(i5);
        while (i2 < zzbeVar.size()) {
            this.zza.zzb(zzbeVar.zzf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzct)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzby.zzx(((Integer) list.get(i4)).intValue());
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z) {
            while (i2 < zzctVar.size()) {
                this.zza.zzj(i, zzctVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzctVar.size(); i6++) {
            i5 += zzby.zzx(zzctVar.zze(i6));
        }
        this.zza.zzq(i5);
        while (i2 < zzctVar.size()) {
            this.zza.zzk(zzctVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzdr)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzdr zzdrVar = (zzdr) list;
        if (!z) {
            while (i2 < zzdrVar.size()) {
                this.zza.zzh(i, zzdrVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzdrVar.size(); i6++) {
            zzdrVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzq(i5);
        while (i2 < zzdrVar.size()) {
            this.zza.zzi(zzdrVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzca)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzca zzcaVar = (zzca) list;
        if (!z) {
            while (i2 < zzcaVar.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(zzcaVar.zze(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzcaVar.size(); i6++) {
            zzcaVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzq(i5);
        while (i2 < zzcaVar.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(zzcaVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzck)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzck zzckVar = (zzck) list;
        if (!z) {
            while (i2 < zzckVar.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(zzckVar.zze(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzckVar.size(); i6++) {
            zzckVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzq(i5);
        while (i2 < zzckVar.size()) {
            this.zza.zzg(Float.floatToRawIntBits(zzckVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzct)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z) {
            while (i2 < zzctVar.size()) {
                this.zza.zzf(i, zzctVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzctVar.size(); i6++) {
            zzctVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzq(i5);
        while (i2 < zzctVar.size()) {
            this.zza.zzg(zzctVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzct)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzby zzbyVar = this.zza;
                    int intValue = ((Integer) list.get(i2)).intValue();
                    zzbyVar.zzp(i, (intValue >> 31) ^ (intValue + intValue));
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int intValue2 = ((Integer) list.get(i4)).intValue();
                i3 += zzby.zzw((intValue2 >> 31) ^ (intValue2 + intValue2));
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                zzby zzbyVar2 = this.zza;
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzbyVar2.zzq((intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z) {
            while (i2 < zzctVar.size()) {
                zzby zzbyVar3 = this.zza;
                int zze = zzctVar.zze(i2);
                zzbyVar3.zzp(i, (zze >> 31) ^ (zze + zze));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzctVar.size(); i6++) {
            int zze2 = zzctVar.zze(i6);
            i5 += zzby.zzw((zze2 >> 31) ^ (zze2 + zze2));
        }
        this.zza.zzq(i5);
        while (i2 < zzctVar.size()) {
            zzby zzbyVar4 = this.zza;
            int zze3 = zzctVar.zze(i2);
            zzbyVar4.zzq((zze3 >> 31) ^ (zze3 + zze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzdr)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzby zzbyVar = this.zza;
                    long longValue = ((Long) list.get(i2)).longValue();
                    zzbyVar.zzr(i, (longValue >> 63) ^ (longValue + longValue));
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long longValue2 = ((Long) list.get(i4)).longValue();
                i3 += zzby.zzx((longValue2 >> 63) ^ (longValue2 + longValue2));
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                zzby zzbyVar2 = this.zza;
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzbyVar2.zzs((longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
            return;
        }
        zzdr zzdrVar = (zzdr) list;
        if (!z) {
            while (i2 < zzdrVar.size()) {
                zzby zzbyVar3 = this.zza;
                long zze = zzdrVar.zze(i2);
                zzbyVar3.zzr(i, (zze >> 63) ^ (zze + zze));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzdrVar.size(); i6++) {
            long zze2 = zzdrVar.zze(i6);
            i5 += zzby.zzx((zze2 >> 63) ^ (zze2 + zze2));
        }
        this.zza.zzq(i5);
        while (i2 < zzdrVar.size()) {
            zzby zzbyVar4 = this.zza;
            long zze3 = zzdrVar.zze(i2);
            zzbyVar4.zzs((zze3 >> 63) ^ (zze3 + zze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzct)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzby.zzx(((Integer) list.get(i4)).intValue());
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzct zzctVar = (zzct) list;
        if (!z) {
            while (i2 < zzctVar.size()) {
                this.zza.zzj(i, zzctVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzctVar.size(); i6++) {
            i5 += zzby.zzx(zzctVar.zze(i6));
        }
        this.zza.zzq(i5);
        while (i2 < zzctVar.size()) {
            this.zza.zzk(zzctVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzdr)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzr(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzo(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzby.zzx(((Long) list.get(i4)).longValue());
            }
            this.zza.zzq(i3);
            while (i2 < list.size()) {
                this.zza.zzs(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzdr zzdrVar = (zzdr) list;
        if (!z) {
            while (i2 < zzdrVar.size()) {
                this.zza.zzr(i, zzdrVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzdrVar.size(); i6++) {
            i5 += zzby.zzx(zzdrVar.zze(i6));
        }
        this.zza.zzq(i5);
        while (i2 < zzdrVar.size()) {
            this.zza.zzs(zzdrVar.zze(i2));
            i2++;
        }
    }
}
