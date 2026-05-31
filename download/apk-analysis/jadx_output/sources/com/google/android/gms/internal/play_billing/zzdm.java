package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes4.dex */
final class zzdm extends zzdq {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzdm() {
        throw null;
    }

    /* synthetic */ zzdm(zzdl zzdlVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    final void zza(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzfp.zzf(obj, j);
        if (list instanceof zzdk) {
            unmodifiableList = ((zzdk) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzek) && (list instanceof zzcz)) {
                zzcz zzczVar = (zzcz) list;
                if (zzczVar.zzc()) {
                    zzczVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzfp.zzs(obj, j, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzdq
    final void zzb(Object obj, Object obj2, long j) {
        zzdj zzdjVar;
        List list = (List) zzfp.zzf(obj2, j);
        int size = list.size();
        List list2 = (List) zzfp.zzf(obj, j);
        if (list2.isEmpty()) {
            list2 = list2 instanceof zzdk ? new zzdj(size) : ((list2 instanceof zzek) && (list2 instanceof zzcz)) ? ((zzcz) list2).zzd(size) : new ArrayList(size);
            zzfp.zzs(obj, j, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                zzfp.zzs(obj, j, arrayList);
                zzdjVar = arrayList;
            } else if (list2 instanceof zzfk) {
                zzdj zzdjVar2 = new zzdj(list2.size() + size);
                zzdjVar2.addAll(zzdjVar2.size(), (zzfk) list2);
                zzfp.zzs(obj, j, zzdjVar2);
                zzdjVar = zzdjVar2;
            } else if ((list2 instanceof zzek) && (list2 instanceof zzcz)) {
                zzcz zzczVar = (zzcz) list2;
                if (!zzczVar.zzc()) {
                    list2 = zzczVar.zzd(list2.size() + size);
                    zzfp.zzs(obj, j, list2);
                }
            }
            list2 = zzdjVar;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzfp.zzs(obj, j, list);
    }
}
