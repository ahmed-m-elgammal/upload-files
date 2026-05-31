package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes3.dex */
final class zzbq extends com.google.android.gms.internal.play_billing.zzo {
    final ExternalOfferAvailabilityListener zza;
    final zzcc zzb;
    final int zzc;

    /* synthetic */ zzbq(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, zzcc zzccVar, int i, zzbp zzbpVar) {
        this.zza = externalOfferAvailabilityListener;
        this.zzb = zzccVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzp
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zzb(zzcb.zza(92, 23, zzce.zzj), this.zzc);
            this.zza.onExternalOfferAvailabilityResponse(zzce.zzj);
            return;
        }
        int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient");
        BillingResult zza = zzce.zza(zzb, com.google.android.gms.internal.play_billing.zzb.zzg(bundle, "BillingClient"));
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "isExternalOfferAvailableAsync() failed. Response code: " + zzb);
            this.zzb.zzb(zzcb.zza(23, 23, zza), this.zzc);
        }
        this.zza.onExternalOfferAvailabilityResponse(zza);
    }
}
