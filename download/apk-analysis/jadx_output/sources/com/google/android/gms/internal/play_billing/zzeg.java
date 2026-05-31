package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes4.dex */
final class zzeg implements zzeo {
    private final zzec zza;
    private final zzff zzb;
    private final boolean zzc;
    private final zzce zzd;

    private zzeg(zzff zzffVar, zzce zzceVar, zzec zzecVar) {
        this.zzb = zzffVar;
        this.zzc = zzceVar.zzf(zzecVar);
        this.zzd = zzceVar;
        this.zza = zzecVar;
    }

    static zzeg zzc(zzff zzffVar, zzce zzceVar, zzec zzecVar) {
        return new zzeg(zzffVar, zzceVar, zzecVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final int zza(Object obj) {
        zzff zzffVar = this.zzb;
        int zzb = zzffVar.zzb(zzffVar.zzd(obj));
        return this.zzc ? zzb + this.zzd.zzb(obj).zzc() : zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final Object zze() {
        zzec zzecVar = this.zza;
        return zzecVar instanceof zzcs ? ((zzcs) zzecVar).zzl() : zzecVar.zzE().zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzd(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzg(Object obj, Object obj2) {
        zzeq.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzeq.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzbc zzbcVar) throws IOException {
        zzcs zzcsVar = (zzcs) obj;
        if (zzcsVar.zzc == zzfg.zzc()) {
            zzcsVar.zzc = zzfg.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzi(Object obj, zzfx zzfxVar) throws IOException {
        Iterator zzf = this.zzd.zzb(obj).zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzch zzchVar = (zzch) entry.getKey();
            if (zzchVar.zze() != zzfw.MESSAGE || zzchVar.zzg() || zzchVar.zzf()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzdf) {
                zzfxVar.zzw(zzchVar.zza(), ((zzdf) entry).zza().zzb());
            } else {
                zzfxVar.zzw(zzchVar.zza(), entry.getValue());
            }
        }
        zzff zzffVar = this.zzb;
        zzffVar.zzi(zzffVar.zzd(obj), zzfxVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final boolean zzj(Object obj, Object obj2) {
        zzff zzffVar = this.zzb;
        if (!zzffVar.zzd(obj).equals(zzffVar.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final boolean zzk(Object obj) {
        return this.zzd.zzb(obj).zzj();
    }
}
