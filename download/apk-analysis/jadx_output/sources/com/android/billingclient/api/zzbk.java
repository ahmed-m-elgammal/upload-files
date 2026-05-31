package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.android.billingclient.api.BillingResult;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes3.dex */
final class zzbk extends com.google.android.gms.internal.play_billing.zzi {
    final BillingConfigResponseListener zza;
    final zzcc zzb;
    final int zzc;

    /* synthetic */ zzbk(BillingConfigResponseListener billingConfigResponseListener, zzcc zzccVar, int i, zzbj zzbjVar) {
        this.zza = billingConfigResponseListener;
        this.zzb = zzccVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzj
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zzb(zzcb.zza(63, 13, zzce.zzj), this.zzc);
            this.zza.onBillingConfigResponse(zzce.zzj, null);
            return;
        }
        int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient");
        String zzg = com.google.android.gms.internal.play_billing.zzb.zzg(bundle, "BillingClient");
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(zzb);
        newBuilder.setDebugMessage(zzg);
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getBillingConfig() failed. Response code: " + zzb);
            BillingResult build = newBuilder.build();
            this.zzb.zzb(zzcb.zza(23, 13, build), this.zzc);
            this.zza.onBillingConfigResponse(build, null);
            return;
        }
        if (!bundle.containsKey("BILLING_CONFIG")) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            newBuilder.setResponseCode(6);
            BillingResult build2 = newBuilder.build();
            this.zzb.zzb(zzcb.zza(64, 13, build2), this.zzc);
            this.zza.onBillingConfigResponse(build2, null);
            return;
        }
        try {
            this.zza.onBillingConfigResponse(newBuilder.build(), new BillingConfig(bundle.getString("BILLING_CONFIG")));
        } catch (JSONException e) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e);
            this.zzb.zzb(zzcb.zza(65, 13, zzce.zzj), this.zzc);
            this.zza.onBillingConfigResponse(zzce.zzj, null);
        }
    }
}
