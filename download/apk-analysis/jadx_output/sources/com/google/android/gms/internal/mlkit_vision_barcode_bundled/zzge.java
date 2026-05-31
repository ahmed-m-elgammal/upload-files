package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:barcode-scanning@@17.2.0 */
/* loaded from: classes4.dex */
final class zzge implements Iterator {
    private final ArrayDeque zza;
    private zzcx zzb;

    /* synthetic */ zzge(zzdb zzdbVar, zzgd zzgdVar) {
        if (!(zzdbVar instanceof zzgg)) {
            this.zza = null;
            this.zzb = (zzcx) zzdbVar;
            return;
        }
        zzgg zzggVar = (zzgg) zzdbVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzggVar.zzf());
        this.zza = arrayDeque;
        arrayDeque.push(zzggVar);
        this.zzb = zzb(zzggVar.zzd);
    }

    private final zzcx zzb(zzdb zzdbVar) {
        while (zzdbVar instanceof zzgg) {
            zzgg zzggVar = (zzgg) zzdbVar;
            this.zza.push(zzggVar);
            zzdbVar = zzggVar.zzd;
        }
        return (zzcx) zzdbVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcx next() {
        zzcx zzcxVar;
        zzcx zzcxVar2 = this.zzb;
        if (zzcxVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzcxVar = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzcxVar = zzb(((zzgg) this.zza.pop()).zze);
        } while (zzcxVar.zzd() == 0);
        this.zzb = zzcxVar;
        return zzcxVar2;
    }
}
