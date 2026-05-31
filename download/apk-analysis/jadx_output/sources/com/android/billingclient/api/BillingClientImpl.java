package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.play_billing.zzfz;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzgd;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgk;
import com.google.android.gms.internal.play_billing.zzgt;
import com.google.android.gms.internal.play_billing.zzgu;
import com.google.android.gms.internal.play_billing.zzgz;
import com.google.android.gms.internal.play_billing.zzhb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes3.dex */
class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private ExecutorService zzB;
    private volatile int zza;
    private final String zzb;
    private final Handler zzc;
    private volatile zzo zzd;
    private Context zze;
    private zzcc zzf;
    private volatile com.google.android.gms.internal.play_billing.zzs zzg;
    private volatile zzbc zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private PendingPurchasesParams zzz;

    private BillingClientImpl(Activity activity, PendingPurchasesParams pendingPurchasesParams, String str) {
        this(activity.getApplicationContext(), pendingPurchasesParams, new zzbu(), str, null, null, null, null);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzc zzcVar, String str, zzcc zzccVar) {
        this.zze = context.getApplicationContext();
        zzgt zzy = zzgu.zzy();
        zzy.zzn(str);
        zzy.zzm(this.zze.getPackageName());
        if (zzccVar != null) {
            this.zzf = zzccVar;
        } else {
            this.zzf = new zzch(this.zze, (zzgu) zzy.zzf());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzo(this.zze, purchasesUpdatedListener, null, zzcVar, null, this.zzf);
        this.zzz = pendingPurchasesParams;
        this.zzA = zzcVar != null;
        this.zze.getPackageName();
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void startConnection(long j) {
        zzbu zzbuVar = new zzbu(j);
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            zzaq(zzcb.zzc(6));
            zzbuVar.onBillingSetupFinished(zzce.zzl);
            return;
        }
        int i = 1;
        if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            zzap(zzcb.zza(37, 6, zzce.zzd));
            zzbuVar.onBillingSetupFinished(zzce.zzd);
            return;
        }
        if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            zzap(zzcb.zza(38, 6, zzce.zzm));
            zzbuVar.onBillingSetupFinished(zzce.zzm);
            return;
        }
        this.zza = 1;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Starting in-app billing setup.");
        this.zzh = new zzbc(this, zzbuVar, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            i = 41;
        } else {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                String str2 = resolveInfo.serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                    i = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzh, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                        i = 39;
                    }
                }
            }
        }
        this.zza = 0;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing service unavailable on device.");
        zzap(zzcb.zza(i, 6, zzce.zzc));
        zzbuVar.onBillingSetupFinished(zzce.zzc);
    }

    static /* bridge */ /* synthetic */ zzcz zzag(BillingClientImpl billingClientImpl, String str, int i) {
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzc = com.google.android.gms.internal.play_billing.zzb.zzc(billingClientImpl.zzn, billingClientImpl.zzv, billingClientImpl.zzz.isEnabledForOneTimeProducts(), billingClientImpl.zzz.isEnabledForPrepaidPlans(), billingClientImpl.zzb);
        List list = null;
        String str2 = null;
        while (true) {
            try {
                Bundle zzj = billingClientImpl.zzn ? billingClientImpl.zzg.zzj(true != billingClientImpl.zzv ? 9 : 19, billingClientImpl.zze.getPackageName(), str, str2, zzc) : billingClientImpl.zzg.zzi(3, billingClientImpl.zze.getPackageName(), str, str2);
                zzda zza = zzdb.zza(zzj, "BillingClient", "getPurchase()");
                BillingResult zza2 = zza.zza();
                if (zza2 != zzce.zzl) {
                    billingClientImpl.zzap(zzcb.zza(zza.zzb(), 9, zza2));
                    return new zzcz(zza2, list);
                }
                ArrayList<String> stringArrayList = zzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z = false;
                for (int i2 = 0; i2 < stringArrayList2.size(); i2++) {
                    String str3 = stringArrayList2.get(i2);
                    String str4 = stringArrayList3.get(i2);
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i2))));
                    try {
                        Purchase purchase = new Purchase(str3, str4);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "BUG: empty/null token!");
                            z = true;
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e) {
                        com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e);
                        billingClientImpl.zzap(zzcb.zza(51, 9, zzce.zzj));
                        return new zzcz(zzce.zzj, null);
                    }
                }
                if (z) {
                    billingClientImpl.zzap(zzcb.zza(26, 9, zzce.zzj));
                }
                str2 = zzj.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    return new zzcz(zzce.zzl, arrayList);
                }
                list = null;
            } catch (Exception e2) {
                billingClientImpl.zzap(zzcb.zza(52, 9, zzce.zzm));
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got exception trying to get purchasesm try to reconnect", e2);
                return new zzcz(zzce.zzm, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzaj() {
        return Looper.myLooper() == null ? this.zzc : new Handler(Looper.myLooper());
    }

    private final BillingResult zzak(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzc.post(new Runnable() { // from class: com.android.billingclient.api.zzq
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzS(billingResult);
            }
        });
        return billingResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzal() {
        return (this.zza == 0 || this.zza == 3) ? zzce.zzm : zzce.zzj;
    }

    private final String zzam(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.zze.getPackageName();
        }
        return null;
    }

    private static String zzan() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Future zzao(Callable callable, long j, final Runnable runnable, Handler handler) {
        if (this.zzB == null) {
            this.zzB = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzb.zza, new zzat(this));
        }
        try {
            final Future submit = this.zzB.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzy
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = submit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return submit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzap(zzga zzgaVar) {
        this.zzf.zzb(zzgaVar, this.zzk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaq(zzge zzgeVar) {
        this.zzf.zzd(zzgeVar, this.zzk);
    }

    private final void zzar(String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            zzap(zzcb.zza(2, 11, zzce.zzm));
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzce.zzm, null);
        } else if (zzao(new zzav(this, str, purchaseHistoryResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzam
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzaa(purchaseHistoryResponseListener);
            }
        }, zzaj()) == null) {
            BillingResult zzal = zzal();
            zzap(zzcb.zza(25, 11, zzal));
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzal, null);
        }
    }

    private final void zzas(String str, final PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            zzap(zzcb.zza(2, 9, zzce.zzm));
            purchasesResponseListener.onQueryPurchasesResponse(zzce.zzm, com.google.android.gms.internal.play_billing.zzai.zzk());
        } else if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please provide a valid product type.");
            zzap(zzcb.zza(50, 9, zzce.zzg));
            purchasesResponseListener.onQueryPurchasesResponse(zzce.zzg, com.google.android.gms.internal.play_billing.zzai.zzk());
        } else if (zzao(new zzau(this, str, purchasesResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzab(purchasesResponseListener);
            }
        }, zzaj()) == null) {
            BillingResult zzal = zzal();
            zzap(zzcb.zza(25, 9, zzal));
            purchasesResponseListener.onQueryPurchasesResponse(zzal, com.google.android.gms.internal.play_billing.zzai.zzk());
        }
    }

    private final boolean zzat() {
        return this.zzv && this.zzz.isEnabledForPrepaidPlans();
    }

    private final void zzau(BillingResult billingResult, int i, int i2) {
        zzge zzgeVar = null;
        zzga zzgaVar = null;
        if (billingResult.getResponseCode() == 0) {
            int i3 = zzcb.zza;
            try {
                zzgd zzy = zzge.zzy();
                zzy.zzm(5);
                zzgz zzy2 = zzhb.zzy();
                zzy2.zzl(i2);
                zzy.zzl((zzhb) zzy2.zzf());
                zzgeVar = (zzge) zzy.zzf();
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e);
            }
            zzaq(zzgeVar);
            return;
        }
        int i4 = zzcb.zza;
        try {
            zzfz zzy3 = zzga.zzy();
            zzgg zzy4 = zzgk.zzy();
            zzy4.zzn(billingResult.getResponseCode());
            zzy4.zzm(billingResult.getDebugMessage());
            zzy4.zzo(i);
            zzy3.zzl(zzy4);
            zzy3.zzn(5);
            zzgz zzy5 = zzhb.zzy();
            zzy5.zzl(i2);
            zzy3.zzm((zzhb) zzy5.zzf());
            zzgaVar = (zzga) zzy3.zzf();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e2);
        }
        zzap(zzgaVar);
    }

    static /* bridge */ /* synthetic */ zzbt zzg(BillingClientImpl billingClientImpl, String str) {
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzc = com.google.android.gms.internal.play_billing.zzb.zzc(billingClientImpl.zzn, billingClientImpl.zzv, billingClientImpl.zzz.isEnabledForOneTimeProducts(), billingClientImpl.zzz.isEnabledForPrepaidPlans(), billingClientImpl.zzb);
        String str2 = null;
        while (billingClientImpl.zzl) {
            try {
                Bundle zzh = billingClientImpl.zzg.zzh(6, billingClientImpl.zze.getPackageName(), str, str2, zzc);
                zzda zza = zzdb.zza(zzh, "BillingClient", "getPurchaseHistory()");
                BillingResult zza2 = zza.zza();
                if (zza2 != zzce.zzl) {
                    billingClientImpl.zzap(zzcb.zza(zza.zzb(), 11, zza2));
                    return new zzbt(zza2, null);
                }
                ArrayList<String> stringArrayList = zzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z = false;
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str3 = stringArrayList2.get(i);
                    String str4 = stringArrayList3.get(i);
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str3, str4);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "BUG: empty/null token!");
                            z = true;
                        }
                        arrayList.add(purchaseHistoryRecord);
                    } catch (JSONException e) {
                        com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e);
                        billingClientImpl.zzap(zzcb.zza(51, 11, zzce.zzj));
                        return new zzbt(zzce.zzj, null);
                    }
                }
                if (z) {
                    billingClientImpl.zzap(zzcb.zza(26, 11, zzce.zzj));
                }
                str2 = zzh.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    return new zzbt(zzce.zzl, arrayList);
                }
            } catch (RemoteException e2) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got exception trying to get purchase history, try to reconnect", e2);
                billingClientImpl.zzap(zzcb.zza(59, 11, zzce.zzm));
                return new zzbt(zzce.zzm, null);
            }
        }
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzbt(zzce.zzq, null);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            zzap(zzcb.zza(2, 3, zzce.zzm));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzce.zzm);
            return;
        }
        if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please provide a valid purchase token.");
            zzap(zzcb.zza(26, 3, zzce.zzi));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzce.zzi);
        } else if (!this.zzn) {
            zzap(zzcb.zza(27, 3, zzce.zzb));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzce.zzb);
        } else if (zzao(new Callable() { // from class: com.android.billingclient.api.zzu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzk(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzv
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzR(acknowledgePurchaseResponseListener);
            }
        }, zzaj()) == null) {
            BillingResult zzal = zzal();
            zzap(zzcb.zza(25, 3, zzal));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzal);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            zzap(zzcb.zza(2, 4, zzce.zzm));
            consumeResponseListener.onConsumeResponse(zzce.zzm, consumeParams.getPurchaseToken());
        } else if (zzao(new Callable() { // from class: com.android.billingclient.api.zzah
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzl(consumeParams, consumeResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzai
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzT(consumeResponseListener, consumeParams);
            }
        }, zzaj()) == null) {
            BillingResult zzal = zzal();
            zzap(zzcb.zza(25, 4, zzal));
            consumeResponseListener.onConsumeResponse(zzal, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (!isReady()) {
            zzap(zzcb.zza(2, 15, zzce.zzm));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzce.zzm, null);
        } else if (!this.zzx) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support alternative billing only.");
            zzap(zzcb.zza(66, 15, zzce.zzE));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzce.zzE, null);
        } else if (zzao(new Callable() { // from class: com.android.billingclient.api.zzz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzq(alternativeBillingOnlyReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaa
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzU(alternativeBillingOnlyReportingDetailsListener);
            }
        }, zzaj()) == null) {
            BillingResult zzal = zzal();
            zzap(zzcb.zza(25, 15, zzal));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzal, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createExternalOfferReportingDetailsAsync(final ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        if (!isReady()) {
            zzap(zzcb.zza(2, 24, zzce.zzm));
            externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(zzce.zzm, null);
        } else if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support external offer.");
            zzap(zzcb.zza(103, 24, zzce.zzy));
            externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(zzce.zzy, null);
        } else if (zzao(new Callable() { // from class: com.android.billingclient.api.zzab
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzr(externalOfferReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzak
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzV(externalOfferReportingDetailsListener);
            }
        }, zzaj()) == null) {
            BillingResult zzal = zzal();
            zzap(zzcb.zza(25, 24, zzal));
            externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(zzal, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void endConnection() {
        zzaq(zzcb.zzc(12));
        try {
            try {
                if (this.zzd != null) {
                    this.zzd.zzf();
                }
                if (this.zzh != null) {
                    this.zzh.zzc();
                }
                if (this.zzh != null && this.zzg != null) {
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Unbinding from service.");
                    this.zze.unbindService(this.zzh);
                    this.zzh = null;
                }
                this.zzg = null;
                ExecutorService executorService = this.zzB;
                if (executorService != null) {
                    executorService.shutdownNow();
                    this.zzB = null;
                }
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "There was an exception while ending connection!", e);
            }
        } finally {
            this.zza = 3;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Service disconnected.");
            zzap(zzcb.zza(2, 13, zzce.zzm));
            billingConfigResponseListener.onBillingConfigResponse(zzce.zzm, null);
        } else {
            if (!this.zzu) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support get billing config.");
                zzap(zzcb.zza(32, 13, zzce.zzA));
                billingConfigResponseListener.onBillingConfigResponse(zzce.zzA, null);
                return;
            }
            String str = this.zzb;
            final Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            if (zzao(new Callable() { // from class: com.android.billingclient.api.zzw
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.this.zzm(bundle, billingConfigResponseListener);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzx
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientImpl.this.zzW(billingConfigResponseListener);
                }
            }, zzaj()) == null) {
                BillingResult zzal = zzal();
                zzap(zzcb.zza(25, 13, zzal));
                billingConfigResponseListener.onBillingConfigResponse(zzal, null);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        return this.zza;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (!isReady()) {
            zzap(zzcb.zza(2, 14, zzce.zzm));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzce.zzm);
        } else if (!this.zzx) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support alternative billing only.");
            zzap(zzcb.zza(66, 14, zzce.zzE));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzce.zzE);
        } else if (zzao(new Callable() { // from class: com.android.billingclient.api.zzaf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzs(alternativeBillingOnlyAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzag
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzX(alternativeBillingOnlyAvailabilityListener);
            }
        }, zzaj()) == null) {
            BillingResult zzal = zzal();
            zzap(zzcb.zza(25, 14, zzal));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzal);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isExternalOfferAvailableAsync(final ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        if (!isReady()) {
            zzap(zzcb.zza(2, 23, zzce.zzm));
            externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(zzce.zzm);
        } else if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support external offer.");
            zzap(zzcb.zza(103, 23, zzce.zzy));
            externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(zzce.zzy);
        } else if (zzao(new Callable() { // from class: com.android.billingclient.api.zzaq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzt(externalOfferAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzar
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzY(externalOfferAvailabilityListener);
            }
        }, zzaj()) == null) {
            BillingResult zzal = zzal();
            zzap(zzcb.zza(25, 23, zzal));
            externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(zzal);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        char c;
        if (!isReady()) {
            BillingResult billingResult = zzce.zzm;
            if (billingResult.getResponseCode() != 0) {
                zzap(zzcb.zza(2, 5, billingResult));
            } else {
                zzaq(zzcb.zzc(5));
            }
            return zzce.zzm;
        }
        int i = zzce.zzG;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 96321:
                if (str.equals("aaa")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 97314:
                if (str.equals(BillingClient.FeatureType.IN_APP_MESSAGING)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 98307:
                if (str.equals("ccc")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 99300:
                if (str.equals("ddd")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 100293:
                if (str.equals("eee")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 101286:
                if (str.equals(BillingClient.FeatureType.PRODUCT_DETAILS)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 102279:
                if (str.equals(BillingClient.FeatureType.BILLING_CONFIG)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 103272:
                if (str.equals("hhh")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 104265:
                if (str.equals("iii")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 105258:
                if (str.equals(BillingClient.FeatureType.ALTERNATIVE_BILLING_ONLY)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 106251:
                if (str.equals(BillingClient.FeatureType.EXTERNAL_OFFER)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                BillingResult billingResult2 = this.zzi ? zzce.zzl : zzce.zzo;
                zzau(billingResult2, 9, 2);
                return billingResult2;
            case 1:
                BillingResult billingResult3 = this.zzj ? zzce.zzl : zzce.zzp;
                zzau(billingResult3, 10, 3);
                return billingResult3;
            case 2:
                BillingResult billingResult4 = this.zzm ? zzce.zzl : zzce.zzr;
                zzau(billingResult4, 35, 4);
                return billingResult4;
            case 3:
                BillingResult billingResult5 = this.zzp ? zzce.zzl : zzce.zzw;
                zzau(billingResult5, 30, 5);
                return billingResult5;
            case 4:
                BillingResult billingResult6 = this.zzr ? zzce.zzl : zzce.zzs;
                zzau(billingResult6, 31, 6);
                return billingResult6;
            case 5:
                BillingResult billingResult7 = this.zzq ? zzce.zzl : zzce.zzu;
                zzau(billingResult7, 21, 7);
                return billingResult7;
            case 6:
                BillingResult billingResult8 = this.zzs ? zzce.zzl : zzce.zzt;
                zzau(billingResult8, 19, 8);
                return billingResult8;
            case 7:
                BillingResult billingResult9 = this.zzs ? zzce.zzl : zzce.zzt;
                zzau(billingResult9, 61, 9);
                return billingResult9;
            case '\b':
                BillingResult billingResult10 = this.zzt ? zzce.zzl : zzce.zzv;
                zzau(billingResult10, 20, 10);
                return billingResult10;
            case '\t':
                BillingResult billingResult11 = this.zzu ? zzce.zzl : zzce.zzA;
                zzau(billingResult11, 32, 11);
                return billingResult11;
            case '\n':
                BillingResult billingResult12 = this.zzu ? zzce.zzl : zzce.zzB;
                zzau(billingResult12, 33, 12);
                return billingResult12;
            case 11:
                BillingResult billingResult13 = this.zzw ? zzce.zzl : zzce.zzD;
                zzau(billingResult13, 60, 13);
                return billingResult13;
            case '\f':
                BillingResult billingResult14 = this.zzx ? zzce.zzl : zzce.zzE;
                zzau(billingResult14, 66, 14);
                return billingResult14;
            case '\r':
                BillingResult billingResult15 = this.zzy ? zzce.zzl : zzce.zzy;
                zzau(billingResult15, 103, 18);
                return billingResult15;
            default:
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
                zzau(zzce.zzz, 34, 1);
                return zzce.zzz;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        return (this.zza != 2 || this.zzg == null || this.zzh == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0438 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03f5  */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.android.billingclient.api.BillingResult launchBillingFlow(android.app.Activity r33, final com.android.billingclient.api.BillingFlowParams r34) {
        /*
            Method dump skipped, instructions count: 1318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.launchBillingFlow(android.app.Activity, com.android.billingclient.api.BillingFlowParams):com.android.billingclient.api.BillingResult");
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (!isReady()) {
            zzap(zzcb.zza(2, 7, zzce.zzm));
            productDetailsResponseListener.onProductDetailsResponse(zzce.zzm, new ArrayList());
        } else if (!this.zzt) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Querying product details is not supported.");
            zzap(zzcb.zza(20, 7, zzce.zzv));
            productDetailsResponseListener.onProductDetailsResponse(zzce.zzv, new ArrayList());
        } else if (zzao(new Callable() { // from class: com.android.billingclient.api.zzan
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzn(queryProductDetailsParams, productDetailsResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzao
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzZ(productDetailsResponseListener);
            }
        }, zzaj()) == null) {
            BillingResult zzal = zzal();
            zzap(zzcb.zza(25, 7, zzal));
            productDetailsResponseListener.onProductDetailsResponse(zzal, new ArrayList());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzar(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzas(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            zzap(zzcb.zza(2, 8, zzce.zzm));
            skuDetailsResponseListener.onSkuDetailsResponse(zzce.zzm, null);
            return;
        }
        final String skuType = skuDetailsParams.getSkuType();
        final List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please fix the input params. SKU type can't be empty.");
            zzap(zzcb.zza(49, 8, zzce.zzf));
            skuDetailsResponseListener.onSkuDetailsResponse(zzce.zzf, null);
        } else if (skusList == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            zzap(zzcb.zza(48, 8, zzce.zze));
            skuDetailsResponseListener.onSkuDetailsResponse(zzce.zze, null);
        } else {
            final String str = null;
            if (zzao(new Callable(skuType, skusList, str, skuDetailsResponseListener) { // from class: com.android.billingclient.api.zzac
                public final /* synthetic */ String zzb;
                public final /* synthetic */ List zzc;
                public final /* synthetic */ SkuDetailsResponseListener zzd;

                {
                    this.zzd = skuDetailsResponseListener;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.this.zzo(this.zzb, this.zzc, null, this.zzd);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzad
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientImpl.this.zzac(skuDetailsResponseListener);
                }
            }, zzaj()) == null) {
                BillingResult zzal = zzal();
                zzap(zzcb.zza(25, 8, zzal));
                skuDetailsResponseListener.onSkuDetailsResponse(zzal, null);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Service disconnected.");
            return zzce.zzm;
        }
        if (!this.zzp) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzce.zzw;
        }
        View findViewById = activity.findViewById(R.id.content);
        IBinder windowToken = findViewById.getWindowToken();
        Rect rect = new Rect();
        findViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzb);
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        final zzaw zzawVar = new zzaw(this, this.zzc, inAppMessageResponseListener);
        zzao(new Callable() { // from class: com.android.billingclient.api.zzap
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzp(bundle, activity, zzawVar);
                return null;
            }
        }, 5000L, null, this.zzc);
        return zzce.zzl;
    }

    final /* synthetic */ void zzR(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzap(zzcb.zza(24, 3, zzce.zzn));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzce.zzn);
    }

    final /* synthetic */ void zzS(BillingResult billingResult) {
        if (this.zzd.zzd() != null) {
            this.zzd.zzd().onPurchasesUpdated(billingResult, null);
        } else {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    final /* synthetic */ void zzT(ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzap(zzcb.zza(24, 4, zzce.zzn));
        consumeResponseListener.onConsumeResponse(zzce.zzn, consumeParams.getPurchaseToken());
    }

    final /* synthetic */ void zzU(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        zzap(zzcb.zza(24, 15, zzce.zzn));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzce.zzn, null);
    }

    final /* synthetic */ void zzV(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        zzap(zzcb.zza(24, 24, zzce.zzn));
        externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(zzce.zzn, null);
    }

    final /* synthetic */ void zzW(BillingConfigResponseListener billingConfigResponseListener) {
        zzap(zzcb.zza(24, 13, zzce.zzn));
        billingConfigResponseListener.onBillingConfigResponse(zzce.zzn, null);
    }

    final /* synthetic */ void zzX(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        zzap(zzcb.zza(24, 14, zzce.zzn));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzce.zzn);
    }

    final /* synthetic */ void zzY(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        zzap(zzcb.zza(24, 23, zzce.zzn));
        externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(zzce.zzn);
    }

    final /* synthetic */ void zzZ(ProductDetailsResponseListener productDetailsResponseListener) {
        zzap(zzcb.zza(24, 7, zzce.zzn));
        productDetailsResponseListener.onProductDetailsResponse(zzce.zzn, new ArrayList());
    }

    final /* synthetic */ void zzaa(PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzap(zzcb.zza(24, 11, zzce.zzn));
        purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzce.zzn, null);
    }

    final /* synthetic */ void zzab(PurchasesResponseListener purchasesResponseListener) {
        zzap(zzcb.zza(24, 9, zzce.zzn));
        purchasesResponseListener.onQueryPurchasesResponse(zzce.zzn, com.google.android.gms.internal.play_billing.zzai.zzk());
    }

    final /* synthetic */ void zzac(SkuDetailsResponseListener skuDetailsResponseListener) {
        zzap(zzcb.zza(24, 8, zzce.zzn));
        skuDetailsResponseListener.onSkuDetailsResponse(zzce.zzn, null);
    }

    final /* synthetic */ void zzad(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        zzap(zzcb.zza(24, 16, zzce.zzn));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(zzce.zzn);
    }

    final /* synthetic */ void zzae(ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        zzap(zzcb.zza(24, 25, zzce.zzn));
        externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(zzce.zzn);
    }

    final /* synthetic */ Bundle zzc(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        return this.zzg.zzg(i, this.zze.getPackageName(), str, str2, null, bundle);
    }

    final /* synthetic */ Bundle zzd(String str, String str2) throws Exception {
        return this.zzg.zzf(3, this.zze.getPackageName(), str, str2, null);
    }

    final /* synthetic */ Object zzk(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) throws Exception {
        try {
            com.google.android.gms.internal.play_billing.zzs zzsVar = this.zzg;
            String packageName = this.zze.getPackageName();
            String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
            String str = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            Bundle zzd = zzsVar.zzd(9, packageName, purchaseToken, bundle);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzce.zza(com.google.android.gms.internal.play_billing.zzb.zzb(zzd, "BillingClient"), com.google.android.gms.internal.play_billing.zzb.zzg(zzd, "BillingClient")));
            return null;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Error acknowledge purchase!", e);
            zzap(zzcb.zza(28, 3, zzce.zzm));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzce.zzm);
            return null;
        }
    }

    final /* synthetic */ Object zzl(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Exception {
        int zza;
        String str;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Consuming purchase with token: " + purchaseToken);
            if (this.zzn) {
                com.google.android.gms.internal.play_billing.zzs zzsVar = this.zzg;
                String packageName = this.zze.getPackageName();
                boolean z = this.zzn;
                String str2 = this.zzb;
                Bundle bundle = new Bundle();
                if (z) {
                    bundle.putString("playBillingLibraryVersion", str2);
                }
                Bundle zze = zzsVar.zze(9, packageName, purchaseToken, bundle);
                zza = zze.getInt("RESPONSE_CODE");
                str = com.google.android.gms.internal.play_billing.zzb.zzg(zze, "BillingClient");
            } else {
                zza = this.zzg.zza(3, this.zze.getPackageName(), purchaseToken);
                str = "";
            }
            BillingResult zza2 = zzce.zza(zza, str);
            if (zza == 0) {
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.onConsumeResponse(zza2, purchaseToken);
                return null;
            }
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Error consuming purchase with token. Response code: " + zza);
            zzap(zzcb.zza(23, 4, zza2));
            consumeResponseListener.onConsumeResponse(zza2, purchaseToken);
            return null;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Error consuming purchase!", e);
            zzap(zzcb.zza(29, 4, zzce.zzm));
            consumeResponseListener.onConsumeResponse(zzce.zzm, purchaseToken);
            return null;
        }
    }

    final /* synthetic */ Object zzm(Bundle bundle, BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        try {
            this.zzg.zzp(18, this.zze.getPackageName(), bundle, new zzbk(billingConfigResponseListener, this.zzf, this.zzk, null));
        } catch (DeadObjectException e) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "getBillingConfig got a dead object exception (try to reconnect).", e);
            zzap(zzcb.zza(62, 13, zzce.zzm));
            billingConfigResponseListener.onBillingConfigResponse(zzce.zzm, null);
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "getBillingConfig got an exception.", e2);
            zzap(zzcb.zza(62, 13, zzce.zzj));
            billingConfigResponseListener.onBillingConfigResponse(zzce.zzj, null);
        }
        return null;
    }

    final /* synthetic */ Object zzn(QueryProductDetailsParams queryProductDetailsParams, ProductDetailsResponseListener productDetailsResponseListener) throws Exception {
        String str;
        int i;
        int i2;
        int i3;
        ArrayList arrayList = new ArrayList();
        String zzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzai zza = queryProductDetailsParams.zza();
        int size = zza.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                str = "";
                i = 0;
                break;
            }
            int i5 = i4 + 20;
            ArrayList arrayList2 = new ArrayList(zza.subList(i4, i5 > size ? size : i5));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                arrayList3.add(((QueryProductDetailsParams.Product) arrayList2.get(i6)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            try {
                com.google.android.gms.internal.play_billing.zzs zzsVar = this.zzg;
                int i7 = true != this.zzw ? 17 : 20;
                String packageName = this.zze.getPackageName();
                boolean zzat = zzat();
                String str2 = this.zzb;
                zzam(queryProductDetailsParams);
                zzam(queryProductDetailsParams);
                zzam(queryProductDetailsParams);
                Bundle bundle2 = new Bundle();
                bundle2.putString("playBillingLibraryVersion", str2);
                bundle2.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
                bundle2.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                if (zzat) {
                    bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                }
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                int size3 = arrayList2.size();
                com.google.android.gms.internal.play_billing.zzai zzaiVar = zza;
                int i8 = 0;
                boolean z = false;
                boolean z2 = false;
                while (i8 < size3) {
                    QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) arrayList2.get(i8);
                    ArrayList arrayList6 = arrayList2;
                    arrayList4.add(null);
                    z |= !TextUtils.isEmpty(null);
                    String zzb2 = product.zzb();
                    int i9 = size3;
                    if (zzb2.equals("first_party")) {
                        com.google.android.gms.internal.play_billing.zzaa.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList5.add(null);
                        z2 = true;
                    }
                    i8++;
                    size3 = i9;
                    arrayList2 = arrayList6;
                }
                if (z) {
                    bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                }
                if (!arrayList5.isEmpty()) {
                    bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (z2 && !TextUtils.isEmpty(null)) {
                    bundle2.putString("accountName", null);
                }
                i3 = 7;
                try {
                    Bundle zzl = zzsVar.zzl(i7, packageName, zzb, bundle, bundle2);
                    str = "Item is unavailable for purchase.";
                    if (zzl == null) {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "queryProductDetailsAsync got empty product details response.");
                        zzap(zzcb.zza(44, 7, zzce.zzC));
                        break;
                    }
                    if (zzl.containsKey("DETAILS_LIST")) {
                        ArrayList<String> stringArrayList = zzl.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList == null) {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "queryProductDetailsAsync got null response list");
                            zzap(zzcb.zza(46, 7, zzce.zzC));
                            break;
                        }
                        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                            try {
                                ProductDetails productDetails = new ProductDetails(stringArrayList.get(i10));
                                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Got product details: ".concat(productDetails.toString()));
                                arrayList.add(productDetails);
                            } catch (JSONException e) {
                                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                                str = "Error trying to decode SkuDetails.";
                                i2 = 6;
                                zzap(zzcb.zza(47, 7, zzce.zza(6, "Error trying to decode SkuDetails.")));
                                i = i2;
                                productDetailsResponseListener.onProductDetailsResponse(zzce.zza(i, str), arrayList);
                                return null;
                            }
                        }
                        i4 = i5;
                        zza = zzaiVar;
                    } else {
                        i = com.google.android.gms.internal.play_billing.zzb.zzb(zzl, "BillingClient");
                        str = com.google.android.gms.internal.play_billing.zzb.zzg(zzl, "BillingClient");
                        if (i != 0) {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + i);
                            zzap(zzcb.zza(23, 7, zzce.zza(i, str)));
                        } else {
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                            zzap(zzcb.zza(45, 7, zzce.zza(6, str)));
                            i = 6;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    i2 = 6;
                    com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                    zzap(zzcb.zza(43, i3, zzce.zzj));
                    str = "An internal error occurred.";
                    i = i2;
                    productDetailsResponseListener.onProductDetailsResponse(zzce.zza(i, str), arrayList);
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                i2 = 6;
                i3 = 7;
            }
        }
        i = 4;
        productDetailsResponseListener.onProductDetailsResponse(zzce.zza(i, str), arrayList);
        return null;
    }

    final /* synthetic */ Object zzo(String str, List list, String str2, SkuDetailsResponseListener skuDetailsResponseListener) throws Exception {
        String str3;
        int i;
        Bundle zzk;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                str3 = "";
                i = 0;
                break;
            }
            int i3 = i2 + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i2, i3 > size ? size : i3));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            try {
                if (this.zzo) {
                    com.google.android.gms.internal.play_billing.zzs zzsVar = this.zzg;
                    String packageName = this.zze.getPackageName();
                    int i4 = this.zzk;
                    boolean isEnabledForOneTimeProducts = this.zzz.isEnabledForOneTimeProducts();
                    boolean zzat = zzat();
                    String str4 = this.zzb;
                    Bundle bundle2 = new Bundle();
                    if (i4 >= 9) {
                        bundle2.putString("playBillingLibraryVersion", str4);
                    }
                    if (i4 >= 9 && isEnabledForOneTimeProducts) {
                        bundle2.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
                    }
                    if (zzat) {
                        bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                    }
                    zzk = zzsVar.zzl(10, packageName, str, bundle, bundle2);
                } else {
                    zzk = this.zzg.zzk(3, this.zze.getPackageName(), str, bundle);
                }
                str3 = "Item is unavailable for purchase.";
                if (zzk == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "querySkuDetailsAsync got null sku details list");
                    zzap(zzcb.zza(44, 8, zzce.zzC));
                    break;
                }
                if (zzk.containsKey("DETAILS_LIST")) {
                    ArrayList<String> stringArrayList = zzk.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "querySkuDetailsAsync got null response list");
                        zzap(zzcb.zza(46, 8, zzce.zzC));
                        break;
                    }
                    for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
                        try {
                            SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i5));
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                            arrayList.add(skuDetails);
                        } catch (JSONException e) {
                            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Got a JSON exception trying to decode SkuDetails.", e);
                            str3 = "Error trying to decode SkuDetails.";
                            zzap(zzcb.zza(47, 8, zzce.zza(6, "Error trying to decode SkuDetails.")));
                            i = 6;
                        }
                    }
                    i2 = i3;
                } else {
                    int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(zzk, "BillingClient");
                    str3 = com.google.android.gms.internal.play_billing.zzb.zzg(zzk, "BillingClient");
                    if (zzb != 0) {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getSkuDetails() failed. Response code: " + zzb);
                        zzap(zzcb.zza(23, 8, zzce.zza(zzb, str3)));
                        i = zzb;
                    } else {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                        zzap(zzcb.zza(45, 8, zzce.zza(6, str3)));
                        i = 6;
                    }
                }
            } catch (Exception e2) {
                com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", e2);
                zzap(zzcb.zza(43, 8, zzce.zzm));
                str3 = "Service connection is disconnected.";
                i = -1;
            }
        }
        i = 4;
        arrayList = null;
        skuDetailsResponseListener.onSkuDetailsResponse(zzce.zza(i, str3), arrayList);
        return null;
    }

    final /* synthetic */ Object zzp(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        this.zzg.zzt(12, this.zze.getPackageName(), bundle, new zzbs(new WeakReference(activity), resultReceiver, null));
        return null;
    }

    final /* synthetic */ Void zzq(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        try {
            this.zzg.zzm(21, this.zze.getPackageName(), com.google.android.gms.internal.play_billing.zzb.zzd(this.zzb), new zzbe(alternativeBillingOnlyReportingDetailsListener, this.zzf, this.zzk, null));
        } catch (Exception unused) {
            zzap(zzcb.zza(70, 15, zzce.zzj));
            alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(zzce.zzj, null);
        }
        return null;
    }

    final /* synthetic */ Void zzr(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) throws Exception {
        try {
            this.zzg.zzn(22, this.zze.getPackageName(), com.google.android.gms.internal.play_billing.zzb.zzd(this.zzb), new zzbg(externalOfferReportingDetailsListener, this.zzf, this.zzk, null));
        } catch (Exception e) {
            zzap(zzcb.zzb(94, 24, zzce.zzj, String.format("%s: %s", e.getClass().getName(), com.google.android.gms.internal.play_billing.zzab.zzb(e.getMessage()))));
            externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(zzce.zzj, null);
        }
        return null;
    }

    final /* synthetic */ Void zzs(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        try {
            this.zzg.zzr(21, this.zze.getPackageName(), com.google.android.gms.internal.play_billing.zzb.zzd(this.zzb), new zzbo(alternativeBillingOnlyAvailabilityListener, this.zzf, this.zzk, null));
        } catch (Exception unused) {
            zzap(zzcb.zza(69, 14, zzce.zzj));
            alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(zzce.zzj);
        }
        return null;
    }

    final /* synthetic */ Void zzt(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        try {
            this.zzg.zzs(22, this.zze.getPackageName(), com.google.android.gms.internal.play_billing.zzb.zzd(this.zzb), new zzbq(externalOfferAvailabilityListener, this.zzf, this.zzk, null));
        } catch (Exception e) {
            zzap(zzcb.zzb(91, 23, zzce.zzj, String.format("%s: %s", e.getClass().getName(), com.google.android.gms.internal.play_billing.zzab.zzb(e.getMessage()))));
            externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(zzce.zzj);
        }
        return null;
    }

    final /* synthetic */ Void zzu(Activity activity, ResultReceiver resultReceiver, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) throws Exception {
        try {
            this.zzg.zzo(21, this.zze.getPackageName(), com.google.android.gms.internal.play_billing.zzb.zzd(this.zzb), new zzbi(new WeakReference(activity), resultReceiver, null));
        } catch (Exception unused) {
            zzap(zzcb.zza(74, 16, zzce.zzj));
            alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(zzce.zzj);
        }
        return null;
    }

    final /* synthetic */ Void zzv(Activity activity, ResultReceiver resultReceiver, ExternalOfferInformationDialogListener externalOfferInformationDialogListener) throws Exception {
        try {
            this.zzg.zzq(22, this.zze.getPackageName(), com.google.android.gms.internal.play_billing.zzb.zzd(this.zzb), new zzbm(new WeakReference(activity), resultReceiver, null));
        } catch (Exception e) {
            zzap(zzcb.zzb(98, 25, zzce.zzj, String.format("%s: %s", e.getClass().getName(), com.google.android.gms.internal.play_billing.zzab.zzb(e.getMessage()))));
            externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(zzce.zzj);
        }
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzar(str, purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) {
        zzas(str, purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!isReady()) {
            zzap(zzcb.zza(2, 16, zzce.zzm));
            return zzce.zzm;
        }
        if (!this.zzx) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzap(zzcb.zza(66, 16, zzce.zzE));
            return zzce.zzE;
        }
        final zzax zzaxVar = new zzax(this, this.zzc, alternativeBillingOnlyInformationDialogListener);
        if (zzao(new Callable() { // from class: com.android.billingclient.api.zzs
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzu(activity, zzaxVar, alternativeBillingOnlyInformationDialogListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzt
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzad(alternativeBillingOnlyInformationDialogListener);
            }
        }, this.zzc) != null) {
            return zzce.zzl;
        }
        BillingResult zzal = zzal();
        zzap(zzcb.zza(25, 16, zzal));
        return zzal;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showExternalOfferInformationDialog(final Activity activity, final ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!isReady()) {
            zzap(zzcb.zza(2, 25, zzce.zzm));
            return zzce.zzm;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Current Play Store version doesn't support external offer.");
            zzap(zzcb.zza(103, 25, zzce.zzy));
            return zzce.zzy;
        }
        final zzay zzayVar = new zzay(this, this.zzc, externalOfferInformationDialogListener);
        if (zzao(new Callable() { // from class: com.android.billingclient.api.zzaj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzv(activity, zzayVar, externalOfferInformationDialogListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzal
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzae(externalOfferInformationDialogListener);
            }
        }, this.zzc) != null) {
            return zzce.zzl;
        }
        BillingResult zzal = zzal();
        zzap(zzcb.zza(25, 25, zzal));
        return zzal;
    }

    private BillingClientImpl(Context context, PendingPurchasesParams pendingPurchasesParams, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, zzcc zzccVar, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, userChoiceBillingListener, str, (zzcc) null);
    }

    private BillingClientImpl(String str) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
    }

    BillingClientImpl(String str, Context context, zzcc zzccVar, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        String zzan = zzan();
        this.zzb = zzan;
        this.zze = context.getApplicationContext();
        zzgt zzy = zzgu.zzy();
        zzy.zzn(zzan);
        zzy.zzm(this.zze.getPackageName());
        this.zzf = new zzch(this.zze, (zzgu) zzy.zzf());
        this.zze.getPackageName();
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, UserChoiceBillingListener userChoiceBillingListener, String str, zzcc zzccVar) {
        this.zze = context.getApplicationContext();
        zzgt zzy = zzgu.zzy();
        zzy.zzn(str);
        zzy.zzm(this.zze.getPackageName());
        if (zzccVar != null) {
            this.zzf = zzccVar;
        } else {
            this.zzf = new zzch(this.zze, (zzgu) zzy.zzf());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzo(this.zze, purchasesUpdatedListener, null, null, userChoiceBillingListener, this.zzf);
        this.zzz = pendingPurchasesParams;
        this.zzA = userChoiceBillingListener != null;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzck zzckVar, zzcc zzccVar, ExecutorService executorService) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = zzan();
        this.zze = context.getApplicationContext();
        zzgt zzy = zzgu.zzy();
        zzy.zzn(zzan());
        zzy.zzm(this.zze.getPackageName());
        this.zzf = new zzch(this.zze, (zzgu) zzy.zzf());
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzd = new zzo(this.zze, null, null, null, null, this.zzf);
        this.zzz = pendingPurchasesParams;
        this.zze.getPackageName();
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzc zzcVar, zzcc zzccVar, ExecutorService executorService) {
        String zzan = zzan();
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = zzan;
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, (zzc) null, zzan, (zzcc) null);
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzcc zzccVar, ExecutorService executorService) {
        this(context, pendingPurchasesParams, purchasesUpdatedListener, zzan(), null, userChoiceBillingListener, null, null);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void startConnection(BillingClientStateListener billingClientStateListener) {
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            zzaq(zzcb.zzc(6));
            billingClientStateListener.onBillingSetupFinished(zzce.zzl);
            return;
        }
        int i = 1;
        if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            zzap(zzcb.zza(37, 6, zzce.zzd));
            billingClientStateListener.onBillingSetupFinished(zzce.zzd);
            return;
        }
        if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            zzap(zzcb.zza(38, 6, zzce.zzm));
            billingClientStateListener.onBillingSetupFinished(zzce.zzm);
            return;
        }
        this.zza = 1;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Starting in-app billing setup.");
        this.zzh = new zzbc(this, billingClientStateListener, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            i = 41;
        } else {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                String str2 = resolveInfo.serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                    i = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzh, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                        i = 39;
                    }
                }
            }
        }
        this.zza = 0;
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing service unavailable on device.");
        zzap(zzcb.zza(i, 6, zzce.zzc));
        billingClientStateListener.onBillingSetupFinished(zzce.zzc);
    }
}
