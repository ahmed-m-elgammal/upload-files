package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzfg implements zzgi {
    private static final zzfm zza = new zzfe();
    private final zzfm zzb;

    public zzfg() {
        zzfm zzfmVar;
        zzfm[] zzfmVarArr = new zzfm[2];
        zzfmVarArr[0] = zzdw.zza();
        try {
            zzfmVar = (zzfm) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzfmVar = zza;
        }
        zzfmVarArr[1] = zzfmVar;
        zzff zzffVar = new zzff(zzfmVarArr);
        byte[] bArr = zzem.zzd;
        this.zzb = zzffVar;
    }

    private static boolean zzb(zzfl zzflVar) {
        return zzflVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgi
    public final zzgh zza(Class cls) {
        zzgj.zzD(cls);
        zzfl zzb = this.zzb.zzb(cls);
        return zzb.zzb() ? zzed.class.isAssignableFrom(cls) ? zzfs.zzc(zzgj.zzz(), zzdr.zzb(), zzb.zza()) : zzfs.zzc(zzgj.zzy(), zzdr.zza(), zzb.zza()) : zzed.class.isAssignableFrom(cls) ? zzb(zzb) ? zzfr.zzl(cls, zzb, zzfv.zzb(), zzfc.zzd(), zzgj.zzz(), zzdr.zzb(), zzfk.zzb()) : zzfr.zzl(cls, zzb, zzfv.zzb(), zzfc.zzd(), zzgj.zzz(), null, zzfk.zzb()) : zzb(zzb) ? zzfr.zzl(cls, zzb, zzfv.zza(), zzfc.zzc(), zzgj.zzy(), zzdr.zza(), zzfk.zza()) : zzfr.zzl(cls, zzb, zzfv.zza(), zzfc.zzc(), zzgj.zzy(), null, zzfk.zza());
    }
}
