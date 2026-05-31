package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes4.dex */
final class zzdo extends zzdq {
    private zzdo() {
        throw null;
    }

    /* synthetic */ zzdo(zzdn zzdnVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    final void zza(Object obj, long j) {
        ((zzcz) zzfp.zzf(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    final void zzb(Object obj, Object obj2, long j) {
        zzcz zzczVar = (zzcz) zzfp.zzf(obj, j);
        zzcz zzczVar2 = (zzcz) zzfp.zzf(obj2, j);
        int size = zzczVar.size();
        int size2 = zzczVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzczVar.zzc()) {
                zzczVar = zzczVar.zzd(size2 + size);
            }
            zzczVar.addAll(zzczVar2);
        }
        if (size > 0) {
            zzczVar2 = zzczVar;
        }
        zzfp.zzs(obj, j, zzczVar2);
    }
}
