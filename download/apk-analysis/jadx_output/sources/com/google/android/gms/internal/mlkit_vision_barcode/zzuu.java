package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public abstract class zzuu {
    public static final zzuu zza = zzm().zzm();
    public static final zzuu zzb;

    static {
        zzut zzm = zzm();
        zzm.zzi(false);
        zzb = zzm.zzm();
    }

    public static zzut zzm() {
        zzul zzulVar = new zzul();
        zzulVar.zzg(10);
        zzulVar.zze(5);
        zzulVar.zzf(0.25f);
        zzulVar.zzd(0.8f);
        zzulVar.zzi(true);
        zzulVar.zzc(0.5f);
        zzulVar.zzb(0.8f);
        zzulVar.zzk(1500L);
        zzulVar.zzh(3000L);
        zzulVar.zza(true);
        zzulVar.zzj(0.1f);
        zzulVar.zzl(0.05f);
        return zzulVar;
    }

    abstract float zza();

    abstract float zzb();

    abstract float zzc();

    abstract float zzd();

    abstract float zze();

    abstract float zzf();

    abstract int zzg();

    abstract int zzh();

    abstract long zzi();

    abstract long zzj();

    abstract boolean zzk();

    abstract boolean zzl();
}
