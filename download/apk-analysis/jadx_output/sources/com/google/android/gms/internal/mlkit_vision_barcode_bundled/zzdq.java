package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzdq extends zzdp {
    zzdq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    final int zza(Map.Entry entry) {
        return ((zzea) entry.getKey()).zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    final zzdt zzb(Object obj) {
        return ((zzdz) obj).zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    final zzdt zzc(Object obj) {
        return ((zzdz) obj).zzc();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    final Object zzd(zzdo zzdoVar, zzfo zzfoVar, int i) {
        return zzdoVar.zzb(zzfoVar, i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    final void zze(Object obj) {
        ((zzdz) obj).zza.zzg();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    final void zzf(zzhq zzhqVar, Map.Entry entry) throws IOException {
        zzea zzeaVar = (zzea) entry.getKey();
        zzho zzhoVar = zzho.DOUBLE;
        switch (zzeaVar.zzb) {
            case DOUBLE:
                zzhqVar.zzf(zzeaVar.zza, ((Double) entry.getValue()).doubleValue());
                break;
            case FLOAT:
                zzhqVar.zzo(zzeaVar.zza, ((Float) entry.getValue()).floatValue());
                break;
            case INT64:
                zzhqVar.zzt(zzeaVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case UINT64:
                zzhqVar.zzK(zzeaVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case INT32:
                zzhqVar.zzr(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case FIXED64:
                zzhqVar.zzm(zzeaVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case FIXED32:
                zzhqVar.zzk(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case BOOL:
                zzhqVar.zzb(zzeaVar.zza, ((Boolean) entry.getValue()).booleanValue());
                break;
            case STRING:
                zzhqVar.zzG(zzeaVar.zza, (String) entry.getValue());
                break;
            case GROUP:
                zzhqVar.zzq(zzeaVar.zza, entry.getValue(), zzfx.zza().zzb(entry.getValue().getClass()));
                break;
            case MESSAGE:
                zzhqVar.zzv(zzeaVar.zza, entry.getValue(), zzfx.zza().zzb(entry.getValue().getClass()));
                break;
            case BYTES:
                zzhqVar.zzd(zzeaVar.zza, (zzdb) entry.getValue());
                break;
            case UINT32:
                zzhqVar.zzI(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case ENUM:
                zzhqVar.zzr(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case SFIXED32:
                zzhqVar.zzx(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case SFIXED64:
                zzhqVar.zzz(zzeaVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case SINT32:
                zzhqVar.zzB(zzeaVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case SINT64:
                zzhqVar.zzD(zzeaVar.zza, ((Long) entry.getValue()).longValue());
                break;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    final boolean zzg(zzfo zzfoVar) {
        return zzfoVar instanceof zzdz;
    }
}
