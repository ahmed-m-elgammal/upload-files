package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzgc {
    private final ArrayDeque zza = new ArrayDeque();

    private zzgc() {
    }

    static /* bridge */ /* synthetic */ zzdb zza(zzgc zzgcVar, zzdb zzdbVar, zzdb zzdbVar2) {
        zzgcVar.zzb(zzdbVar);
        zzgcVar.zzb(zzdbVar2);
        zzdb zzdbVar3 = (zzdb) zzgcVar.zza.pop();
        while (!zzgcVar.zza.isEmpty()) {
            zzdbVar3 = new zzgg((zzdb) zzgcVar.zza.pop(), zzdbVar3);
        }
        return zzdbVar3;
    }

    private final void zzb(zzdb zzdbVar) {
        zzgf zzgfVar;
        if (!zzdbVar.zzh()) {
            if (!(zzdbVar instanceof zzgg)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzdbVar.getClass()))));
            }
            zzgg zzggVar = (zzgg) zzdbVar;
            zzb(zzggVar.zzd);
            zzb(zzggVar.zze);
            return;
        }
        int zzc = zzc(zzdbVar.zzd());
        int zzc2 = zzgg.zzc(zzc + 1);
        if (this.zza.isEmpty() || ((zzdb) this.zza.peek()).zzd() >= zzc2) {
            this.zza.push(zzdbVar);
            return;
        }
        int zzc3 = zzgg.zzc(zzc);
        zzdb zzdbVar2 = (zzdb) this.zza.pop();
        while (true) {
            zzgfVar = null;
            if (this.zza.isEmpty() || ((zzdb) this.zza.peek()).zzd() >= zzc3) {
                break;
            } else {
                zzdbVar2 = new zzgg((zzdb) this.zza.pop(), zzdbVar2);
            }
        }
        zzgg zzggVar2 = new zzgg(zzdbVar2, zzdbVar);
        while (!this.zza.isEmpty()) {
            if (((zzdb) this.zza.peek()).zzd() >= zzgg.zzc(zzc(zzggVar2.zzd()) + 1)) {
                break;
            } else {
                zzggVar2 = new zzgg((zzdb) this.zza.pop(), zzggVar2);
            }
        }
        this.zza.push(zzggVar2);
    }

    private static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzgg.zza, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzgc(zzgb zzgbVar) {
    }
}
