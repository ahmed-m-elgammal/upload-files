package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzga;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes3.dex */
final class zzn extends BroadcastReceiver {
    final /* synthetic */ zzo zza;
    private boolean zzb;
    private final boolean zzc;

    zzn(zzo zzoVar, boolean z) {
        this.zza = zzoVar;
        this.zzc = z;
    }

    private final void zzd(Bundle bundle, BillingResult billingResult, int i) {
        zzcc zzccVar;
        zzcc zzccVar2;
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") == null) {
            zzccVar2 = this.zza.zze;
            zzccVar2.zza(zzcb.zza(23, i, billingResult));
        } else {
            try {
                zzccVar = this.zza.zze;
                zzccVar.zza(zzga.zzA(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), com.google.android.gms.internal.play_billing.zzcd.zza()));
            } catch (Throwable unused) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        PurchasesUpdatedListener purchasesUpdatedListener;
        zzcc zzccVar;
        zzc zzcVar;
        zzcc zzccVar2;
        PurchasesUpdatedListener purchasesUpdatedListener2;
        zzcc zzccVar3;
        PurchasesUpdatedListener purchasesUpdatedListener3;
        UserChoiceBillingListener userChoiceBillingListener;
        zzc zzcVar2;
        zzcc zzccVar4;
        UserChoiceBillingListener userChoiceBillingListener2;
        UserChoiceBillingListener userChoiceBillingListener3;
        zzcc zzccVar5;
        PurchasesUpdatedListener purchasesUpdatedListener4;
        PurchasesUpdatedListener purchasesUpdatedListener5;
        zzcc zzccVar6;
        PurchasesUpdatedListener purchasesUpdatedListener6;
        PurchasesUpdatedListener purchasesUpdatedListener7;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", "Bundle is null.");
            zzccVar6 = this.zza.zze;
            zzccVar6.zza(zzcb.zza(11, 1, zzce.zzj));
            zzo zzoVar = this.zza;
            purchasesUpdatedListener6 = zzoVar.zzb;
            if (purchasesUpdatedListener6 != null) {
                purchasesUpdatedListener7 = zzoVar.zzb;
                purchasesUpdatedListener7.onPurchasesUpdated(zzce.zzj, null);
                return;
            }
            return;
        }
        BillingResult zze = com.google.android.gms.internal.play_billing.zzb.zze(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        int i = true != Objects.equals(extras.getString("INTENT_SOURCE"), "LAUNCH_BILLING_FLOW") ? 1 : 2;
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED") || action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            List<Purchase> zzi = com.google.android.gms.internal.play_billing.zzb.zzi(extras);
            if (zze.getResponseCode() == 0) {
                zzccVar = this.zza.zze;
                zzccVar.zzc(zzcb.zzc(i));
            } else {
                zzd(extras, zze, i);
            }
            purchasesUpdatedListener = this.zza.zzb;
            purchasesUpdatedListener.onPurchasesUpdated(zze, zzi);
            return;
        }
        if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            if (zze.getResponseCode() != 0) {
                zzd(extras, zze, i);
                purchasesUpdatedListener5 = this.zza.zzb;
                purchasesUpdatedListener5.onPurchasesUpdated(zze, com.google.android.gms.internal.play_billing.zzai.zzk());
                return;
            }
            zzo zzoVar2 = this.zza;
            zzcVar = zzoVar2.zzc;
            if (zzcVar == null) {
                userChoiceBillingListener3 = zzoVar2.zzd;
                if (userChoiceBillingListener3 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
                    zzccVar5 = this.zza.zze;
                    zzccVar5.zza(zzcb.zza(77, i, zzce.zzj));
                    purchasesUpdatedListener4 = this.zza.zzb;
                    purchasesUpdatedListener4.onPurchasesUpdated(zzce.zzj, com.google.android.gms.internal.play_billing.zzai.zzk());
                    return;
                }
            }
            String string = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
            if (string == null) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                zzccVar2 = this.zza.zze;
                zzccVar2.zza(zzcb.zza(16, i, zzce.zzj));
                purchasesUpdatedListener2 = this.zza.zzb;
                purchasesUpdatedListener2.onPurchasesUpdated(zzce.zzj, com.google.android.gms.internal.play_billing.zzai.zzk());
                return;
            }
            try {
                userChoiceBillingListener = this.zza.zzd;
                if (userChoiceBillingListener != null) {
                    UserChoiceDetails userChoiceDetails = new UserChoiceDetails(string);
                    userChoiceBillingListener2 = this.zza.zzd;
                    userChoiceBillingListener2.userSelectedAlternativeBilling(userChoiceDetails);
                } else {
                    JSONArray optJSONArray = new JSONObject(string).optJSONArray("products");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null) {
                                arrayList.add(new zze(optJSONObject, null));
                            }
                        }
                    }
                    zzcVar2 = this.zza.zzc;
                    zzcVar2.zza();
                }
                zzccVar4 = this.zza.zze;
                zzccVar4.zzc(zzcb.zzc(i));
            } catch (JSONException unused) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", String.format("Error when parsing invalid user choice data: [%s]", string));
                zzccVar3 = this.zza.zze;
                zzccVar3.zza(zzcb.zza(17, i, zzce.zzj));
                purchasesUpdatedListener3 = this.zza.zzb;
                purchasesUpdatedListener3.onPurchasesUpdated(zzce.zzj, com.google.android.gms.internal.play_billing.zzai.zzk());
            }
        }
    }

    public final synchronized void zza(Context context, IntentFilter intentFilter) {
        if (this.zzb) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, true != this.zzc ? 4 : 2);
        } else {
            context.registerReceiver(this, intentFilter);
        }
        this.zzb = true;
    }

    public final synchronized void zzb(Context context, IntentFilter intentFilter, String str) {
        if (this.zzb) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.zzc ? 4 : 2);
        } else {
            context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
        }
        this.zzb = true;
    }

    public final synchronized void zzc(Context context) {
        if (!this.zzb) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.zzb = false;
        }
    }
}
