package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes4.dex */
final class zzdy {
    private static final zzdx zza;
    private static final zzdx zzb;

    static {
        zzdx zzdxVar = null;
        try {
            zzdxVar = (zzdx) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzdxVar;
        zzb = new zzdx();
    }

    static zzdx zza() {
        return zza;
    }

    static zzdx zzb() {
        return zzb;
    }
}
