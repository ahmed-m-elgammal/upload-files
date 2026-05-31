package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes4.dex */
final class zzci {
    private static final zzci zzb = new zzci(true);
    final zzfb zza = new zzer(16);
    private boolean zzc;
    private boolean zzd;

    private zzci() {
    }

    static int zza(zzfv zzfvVar, int i, Object obj) {
        zzby.zzw(i << 3);
        if (zzfv.GROUP == null) {
            zzec zzecVar = (zzec) obj;
            byte[] bArr = zzda.zzd;
            if (zzecVar instanceof zzaz) {
                throw null;
            }
        }
        zzfw zzfwVar = zzfw.INT;
        throw null;
    }

    public static int zzb(zzch zzchVar, Object obj) {
        zzfv zzd = zzchVar.zzd();
        int zza = zzchVar.zza();
        if (!zzchVar.zzg()) {
            return zza(zzd, zza, obj);
        }
        List list = (List) obj;
        int i = 0;
        if (!zzchVar.zzf()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i += zza(zzd, zza, it.next());
            }
            return i;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        if (!it2.hasNext()) {
            return zzby.zzw(zza << 3) + zzby.zzw(0);
        }
        it2.next();
        zzfv zzfvVar = zzfv.DOUBLE;
        zzfw zzfwVar = zzfw.INT;
        throw null;
    }

    public static zzci zzd() {
        return zzb;
    }

    private static Object zzk(Object obj) {
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzd();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzl(Map.Entry entry) {
        zzch zzchVar = (zzch) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzdh;
        if (zzchVar.zzg()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object zze = zze(zzchVar);
            if (zze == null) {
                zze = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) zze).add(zzk(it.next()));
            }
            this.zza.put(zzchVar, zze);
            return;
        }
        if (zzchVar.zze() != zzfw.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(zzchVar, zzk(value));
            return;
        }
        Object zze2 = zze(zzchVar);
        if (zze2 == null) {
            this.zza.put(zzchVar, zzk(value));
            if (z) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (z) {
            throw null;
        }
        this.zza.put(zzchVar, zze2 instanceof zzeh ? zzchVar.zzc((zzeh) zze2, (zzeh) value) : zzchVar.zzb(((zzec) zze2).zzF(), (zzec) value).zzf());
    }

    private static boolean zzm(Map.Entry entry) {
        zzch zzchVar = (zzch) entry.getKey();
        if (zzchVar.zze() != zzfw.MESSAGE) {
            return true;
        }
        if (!zzchVar.zzg()) {
            return zzn(entry.getValue());
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!zzn(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzn(Object obj) {
        if (obj instanceof zzed) {
            return ((zzed) obj).zzk();
        }
        if (obj instanceof zzdh) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        int i;
        int zzw;
        int zzw2;
        int zzf;
        int zzw3;
        zzch zzchVar = (zzch) entry.getKey();
        Object value = entry.getValue();
        if (zzchVar.zze() != zzfw.MESSAGE || zzchVar.zzg() || zzchVar.zzf()) {
            return zzb(zzchVar, value);
        }
        if (value instanceof zzdh) {
            int zza = ((zzch) entry.getKey()).zza();
            int zzw4 = zzby.zzw(8);
            i = zzw4 + zzw4;
            zzw = zzby.zzw(16) + zzby.zzw(zza);
            zzw2 = zzby.zzw(24);
            zzf = ((zzdh) value).zza();
            zzw3 = zzby.zzw(zzf);
        } else {
            int zza2 = ((zzch) entry.getKey()).zza();
            int zzw5 = zzby.zzw(8);
            i = zzw5 + zzw5;
            zzw = zzby.zzw(16) + zzby.zzw(zza2);
            zzw2 = zzby.zzw(24);
            zzf = ((zzec) value).zzf();
            zzw3 = zzby.zzw(zzf);
        }
        return i + zzw + zzw2 + zzw3 + zzf;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzp(com.google.android.gms.internal.play_billing.zzch r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.play_billing.zzfv r0 = r4.zzd()
            byte[] r1 = com.google.android.gms.internal.play_billing.zzda.zzd
            r5.getClass()
            com.google.android.gms.internal.play_billing.zzfv r1 = com.google.android.gms.internal.play_billing.zzfv.DOUBLE
            com.google.android.gms.internal.play_billing.zzfw r1 = com.google.android.gms.internal.play_billing.zzfw.INT
            com.google.android.gms.internal.play_billing.zzfw r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzec
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzdh
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzcu
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzbq
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r5 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r5 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r5 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r5 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r5 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r4.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.play_billing.zzfv r4 = r4.zzd()
            com.google.android.gms.internal.play_billing.zzfw r4 = r4.zza()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            r1 = 1
            r2[r1] = r4
            r4 = 2
            r2[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r2)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzci.zzp(com.google.android.gms.internal.play_billing.zzch, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzci zzciVar = new zzci();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzciVar.zzi((zzch) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzciVar.zzi((zzch) entry.getKey(), entry.getValue());
        }
        zzciVar.zzd = this.zzd;
        return zzciVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzci) {
            return this.zza.equals(((zzci) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            i += zzo(this.zza.zzg(i2));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            i += zzo((Map.Entry) it.next());
        }
        return i;
    }

    public final Object zze(zzch zzchVar) {
        Object obj = this.zza.get(zzchVar);
        if (!(obj instanceof zzdh)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzf() {
        return this.zzd ? new zzdg(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            if (zzg.getValue() instanceof zzcs) {
                ((zzcs) zzg.getValue()).zzr();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzci zzciVar) {
        for (int i = 0; i < zzciVar.zza.zzb(); i++) {
            zzl(zzciVar.zza.zzg(i));
        }
        Iterator it = zzciVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzl((Map.Entry) it.next());
        }
    }

    public final void zzi(zzch zzchVar, Object obj) {
        if (!zzchVar.zzg()) {
            zzp(zzchVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzp(zzchVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzdh) {
            this.zzd = true;
        }
        this.zza.put(zzchVar, obj);
    }

    public final boolean zzj() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzm(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzm((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzci(boolean z) {
        zzg();
        zzg();
    }
}
