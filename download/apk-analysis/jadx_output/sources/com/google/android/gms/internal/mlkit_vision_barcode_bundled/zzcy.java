package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
class zzcy extends zzcx {
    protected final byte[] zza;

    zzcy(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdb) || zzd() != ((zzdb) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzcy)) {
            return obj.equals(this);
        }
        zzcy zzcyVar = (zzcy) obj;
        int zzp = zzp();
        int zzp2 = zzcyVar.zzp();
        if (zzp == 0 || zzp2 == 0 || zzp == zzp2) {
            return zzg(zzcyVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcx
    final boolean zzg(zzdb zzdbVar, int i, int i2) {
        if (i2 > zzdbVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzd());
        }
        int i3 = i + i2;
        if (i3 > zzdbVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzdbVar.zzd());
        }
        if (!(zzdbVar instanceof zzcy)) {
            return zzdbVar.zzk(i, i3).equals(zzk(0, i2));
        }
        zzcy zzcyVar = (zzcy) zzdbVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzcyVar.zza;
        int zzc = zzc() + i2;
        int zzc2 = zzc();
        int zzc3 = zzcyVar.zzc() + i;
        while (zzc2 < zzc) {
            if (bArr[zzc2] != bArr2[zzc3]) {
                return false;
            }
            zzc2++;
            zzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    protected final int zzi(int i, int i2, int i3) {
        return zzem.zzb(i, this.zza, zzc() + i2, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    protected final int zzj(int i, int i2, int i3) {
        int zzc = zzc() + i2;
        return zzhn.zzf(i, this.zza, zzc, i3 + zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final zzdb zzk(int i, int i2) {
        int zzo = zzo(i, i2, zzd());
        return zzo == 0 ? zzdb.zzb : new zzcv(this.zza, zzc() + i, zzo);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    protected final String zzl(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    final void zzm(zzcr zzcrVar) throws IOException {
        ((zzdg) zzcrVar).zzc(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final boolean zzn() {
        int zzc = zzc();
        return zzhn.zzh(this.zza, zzc, zzd() + zzc);
    }
}
