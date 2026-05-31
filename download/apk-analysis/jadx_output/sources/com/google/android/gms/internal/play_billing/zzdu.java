package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes4.dex */
final class zzdu implements zzep {
    private static final zzea zza = new zzds();
    private final zzea zzb;

    public zzdu() {
        zzea zzeaVar;
        zzea[] zzeaVarArr = new zzea[2];
        zzeaVarArr[0] = zzcm.zza();
        try {
            zzeaVar = (zzea) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzeaVar = zza;
        }
        zzeaVarArr[1] = zzeaVar;
        zzdt zzdtVar = new zzdt(zzeaVarArr);
        byte[] bArr = zzda.zzd;
        this.zzb = zzdtVar;
    }

    private static boolean zzb(zzdz zzdzVar) {
        return zzdzVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final zzeo zza(Class cls) {
        zzeq.zzr(cls);
        zzdz zzb = this.zzb.zzb(cls);
        return zzb.zzb() ? zzcs.class.isAssignableFrom(cls) ? zzeg.zzc(zzeq.zzn(), zzcg.zzb(), zzb.zza()) : zzeg.zzc(zzeq.zzm(), zzcg.zza(), zzb.zza()) : zzcs.class.isAssignableFrom(cls) ? zzb(zzb) ? zzef.zzl(cls, zzb, zzej.zzb(), zzdq.zzd(), zzeq.zzn(), zzcg.zzb(), zzdy.zzb()) : zzef.zzl(cls, zzb, zzej.zzb(), zzdq.zzd(), zzeq.zzn(), null, zzdy.zzb()) : zzb(zzb) ? zzef.zzl(cls, zzb, zzej.zza(), zzdq.zzc(), zzeq.zzm(), zzcg.zza(), zzdy.zza()) : zzef.zzl(cls, zzb, zzej.zza(), zzdq.zzc(), zzeq.zzm(), null, zzdy.zza());
    }
}
