package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes4.dex */
final class zzej {
    private static final zzei zza;
    private static final zzei zzb;

    static {
        zzei zzeiVar = null;
        try {
            zzeiVar = (zzei) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzeiVar;
        zzb = new zzei();
    }

    static zzei zza() {
        return zza;
    }

    static zzei zzb() {
        return zzb;
    }
}
