package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
/* loaded from: classes4.dex */
public final class zzfv {
    private final zzpj zza;
    private final Boolean zzb;
    private final Boolean zzc;
    private final zzos zzd;
    private final zzth zze;
    private final zzcv zzf;
    private final zzcv zzg;

    /* synthetic */ zzfv(zzft zzftVar, zzfu zzfuVar) {
        zzpj zzpjVar;
        Boolean bool;
        zzth zzthVar;
        zzcv zzcvVar;
        zzcv zzcvVar2;
        zzpjVar = zzftVar.zza;
        this.zza = zzpjVar;
        this.zzb = null;
        bool = zzftVar.zzb;
        this.zzc = bool;
        this.zzd = null;
        zzthVar = zzftVar.zzc;
        this.zze = zzthVar;
        zzcvVar = zzftVar.zzd;
        this.zzf = zzcvVar;
        zzcvVar2 = zzftVar.zze;
        this.zzg = zzcvVar2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfv)) {
            return false;
        }
        zzfv zzfvVar = (zzfv) obj;
        if (Objects.equal(this.zza, zzfvVar.zza)) {
            Boolean bool = zzfvVar.zzb;
            if (Objects.equal(null, null) && Objects.equal(this.zzc, zzfvVar.zzc)) {
                zzos zzosVar = zzfvVar.zzd;
                if (Objects.equal(null, null) && Objects.equal(this.zze, zzfvVar.zze) && Objects.equal(this.zzf, zzfvVar.zzf) && Objects.equal(this.zzg, zzfvVar.zzg)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, this.zzg);
    }

    public final zzcv zza() {
        return this.zzf;
    }

    public final zzcv zzb() {
        return this.zzg;
    }

    public final zzpj zzc() {
        return this.zza;
    }

    public final zzth zzd() {
        return this.zze;
    }

    public final Boolean zze() {
        return this.zzc;
    }
}
