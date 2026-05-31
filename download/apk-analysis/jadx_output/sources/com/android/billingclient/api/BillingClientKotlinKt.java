package com.android.billingclient.api;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\t\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\f\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\f\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\f\u001a\u0012\u0010\u0010\u001a\u00020\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\f\u001a\u001a\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0087@¢\u0006\u0002\u0010\u001b\u001a\u001a\u0010\u001c\u001a\u00020\u001d*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010\u001f\u001a\u001a\u0010\u001c\u001a\u00020\u001d*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0087@¢\u0006\u0002\u0010\u001b\u001a\u001a\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\"H\u0087@¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"acknowledgePurchase", "Lcom/android/billingclient/api/BillingResult;", "Lcom/android/billingclient/api/BillingClient;", "params", "Lcom/android/billingclient/api/AcknowledgePurchaseParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePurchase", "Lcom/android/billingclient/api/ConsumeResult;", "Lcom/android/billingclient/api/ConsumeParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/ConsumeParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAlternativeBillingOnlyReportingDetails", "Lcom/android/billingclient/api/CreateAlternativeBillingOnlyReportingDetailsResult;", "(Lcom/android/billingclient/api/BillingClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createExternalOfferReportingDetails", "Lcom/android/billingclient/api/CreateExternalOfferReportingDetailsResult;", "isAlternativeBillingOnlyAvailable", "isExternalOfferAvailable", "queryProductDetails", "Lcom/android/billingclient/api/ProductDetailsResult;", "Lcom/android/billingclient/api/QueryProductDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryProductDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchaseHistory", "Lcom/android/billingclient/api/PurchaseHistoryResult;", "Lcom/android/billingclient/api/QueryPurchaseHistoryParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchaseHistoryParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skuType", "", "(Lcom/android/billingclient/api/BillingClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", InAppPurchaseConstants.METHOD_QUERY_PURCHASES_ASYNC, "Lcom/android/billingclient/api/PurchasesResult;", "Lcom/android/billingclient/api/QueryPurchasesParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchasesParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySkuDetails", "Lcom/android/billingclient/api/SkuDetailsResult;", "Lcom/android/billingclient/api/SkuDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/SkuDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BillingClientKotlinKt {
    public static /* synthetic */ void $r8$lambda$1JhcD_0Y_gWWNKF2aNTk2toOOyY(CompletableDeferred deferred, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        deferred.complete(billingResult);
    }

    public static /* synthetic */ void $r8$lambda$9SKPFUMhNCJ3v0PMCwGqle8zR10(CompletableDeferred deferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        deferred.complete(new SkuDetailsResult(billingResult, list));
    }

    /* renamed from: $r8$lambda$BC2cAL2vk_I3dV-pkSAsSywRIek, reason: not valid java name */
    public static /* synthetic */ void m911$r8$lambda$BC2cAL2vk_I3dVpkSAsSywRIek(CompletableDeferred deferred, BillingResult billingResult, String str) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        deferred.complete(new ConsumeResult(billingResult, str));
    }

    public static /* synthetic */ void $r8$lambda$Bt5YvFTOU7XGqhy1u2vanp4Jc20(CompletableDeferred deferred, BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        deferred.complete(new CreateExternalOfferReportingDetailsResult(billingResult, externalOfferReportingDetails));
    }

    /* renamed from: $r8$lambda$Iy_vpeZ_JH-NmajeE6ZBdUlqJKA, reason: not valid java name */
    public static /* synthetic */ void m912$r8$lambda$Iy_vpeZ_JHNmajeE6ZBdUlqJKA(CompletableDeferred deferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        Intrinsics.checkNotNull(list);
        deferred.complete(new PurchasesResult(billingResult, list));
    }

    /* renamed from: $r8$lambda$Jmx2bDJUe-jQbQfqNR-Rv-qVuz0, reason: not valid java name */
    public static /* synthetic */ void m913$r8$lambda$Jmx2bDJUejQbQfqNRRvqVuz0(CompletableDeferred deferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        deferred.complete(new PurchaseHistoryResult(billingResult, list));
    }

    /* renamed from: $r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25-w, reason: not valid java name */
    public static /* synthetic */ void m914$r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25w(CompletableDeferred deferred, BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        deferred.complete(new CreateAlternativeBillingOnlyReportingDetailsResult(billingResult, alternativeBillingOnlyReportingDetails));
    }

    /* renamed from: $r8$lambda$OmYoMPMU8NG-G-TTJRupXijq_ag, reason: not valid java name */
    public static /* synthetic */ void m915$r8$lambda$OmYoMPMU8NGGTTJRupXijq_ag(CompletableDeferred deferred, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        deferred.complete(billingResult);
    }

    public static /* synthetic */ void $r8$lambda$ZzkEujuP9GqFND2FbZB_kuqycGM(CompletableDeferred deferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        deferred.complete(new PurchaseHistoryResult(billingResult, list));
    }

    /* renamed from: $r8$lambda$_HjOTKlijnqR-5v_YY-SPcvW1bw, reason: not valid java name */
    public static /* synthetic */ void m916$r8$lambda$_HjOTKlijnqR5v_YYSPcvW1bw(CompletableDeferred deferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        deferred.complete(new ProductDetailsResult(billingResult, list));
    }

    public static /* synthetic */ void $r8$lambda$mNiIov37EcRv6CLKJbxie9rmtK8(CompletableDeferred deferred, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        deferred.complete(billingResult);
    }

    public static /* synthetic */ void $r8$lambda$wzezm1LgRtzooDMmMf2vgdwDzEw(CompletableDeferred deferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        Intrinsics.checkNotNull(list);
        deferred.complete(new PurchasesResult(billingResult, list));
    }

    public static final Object acknowledgePurchase(BillingClient billingClient, AcknowledgePurchaseParams acknowledgePurchaseParams, Continuation<? super BillingResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda4
            @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
            public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                BillingClientKotlinKt.$r8$lambda$mNiIov37EcRv6CLKJbxie9rmtK8(CompletableDeferred.this, billingResult);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object consumePurchase(BillingClient billingClient, ConsumeParams consumeParams, Continuation<? super ConsumeResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.consumeAsync(consumeParams, new ConsumeResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda1
            @Override // com.android.billingclient.api.ConsumeResponseListener
            public final void onConsumeResponse(BillingResult billingResult, String str) {
                BillingClientKotlinKt.m911$r8$lambda$BC2cAL2vk_I3dVpkSAsSywRIek(CompletableDeferred.this, billingResult, str);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object createAlternativeBillingOnlyReportingDetails(BillingClient billingClient, Continuation<? super CreateAlternativeBillingOnlyReportingDetailsResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.createAlternativeBillingOnlyReportingDetailsAsync(new AlternativeBillingOnlyReportingDetailsListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda9
            @Override // com.android.billingclient.api.AlternativeBillingOnlyReportingDetailsListener
            public final void onAlternativeBillingOnlyTokenResponse(BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
                BillingClientKotlinKt.m914$r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25w(CompletableDeferred.this, billingResult, alternativeBillingOnlyReportingDetails);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object createExternalOfferReportingDetails(BillingClient billingClient, Continuation<? super CreateExternalOfferReportingDetailsResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.createExternalOfferReportingDetailsAsync(new ExternalOfferReportingDetailsListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda5
            @Override // com.android.billingclient.api.ExternalOfferReportingDetailsListener
            public final void onExternalOfferReportingDetailsResponse(BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails) {
                BillingClientKotlinKt.$r8$lambda$Bt5YvFTOU7XGqhy1u2vanp4Jc20(CompletableDeferred.this, billingResult, externalOfferReportingDetails);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object isAlternativeBillingOnlyAvailable(BillingClient billingClient, Continuation<? super BillingResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.isAlternativeBillingOnlyAvailableAsync(new AlternativeBillingOnlyAvailabilityListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda7
            @Override // com.android.billingclient.api.AlternativeBillingOnlyAvailabilityListener
            public final void onAlternativeBillingOnlyAvailabilityResponse(BillingResult billingResult) {
                BillingClientKotlinKt.$r8$lambda$1JhcD_0Y_gWWNKF2aNTk2toOOyY(CompletableDeferred.this, billingResult);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object isExternalOfferAvailable(BillingClient billingClient, Continuation<? super BillingResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.isExternalOfferAvailableAsync(new ExternalOfferAvailabilityListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda2
            @Override // com.android.billingclient.api.ExternalOfferAvailabilityListener
            public final void onExternalOfferAvailabilityResponse(BillingResult billingResult) {
                BillingClientKotlinKt.m915$r8$lambda$OmYoMPMU8NGGTTJRupXijq_ag(CompletableDeferred.this, billingResult);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object queryProductDetails(BillingClient billingClient, QueryProductDetailsParams queryProductDetailsParams, Continuation<? super ProductDetailsResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryProductDetailsAsync(queryProductDetailsParams, new ProductDetailsResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda3
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void onProductDetailsResponse(BillingResult billingResult, List list) {
                BillingClientKotlinKt.m916$r8$lambda$_HjOTKlijnqR5v_YYSPcvW1bw(CompletableDeferred.this, billingResult, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object queryPurchaseHistory(BillingClient billingClient, QueryPurchaseHistoryParams queryPurchaseHistoryParams, Continuation<? super PurchaseHistoryResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchaseHistoryAsync(queryPurchaseHistoryParams, new PurchaseHistoryResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda6
            @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
            public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
                BillingClientKotlinKt.m913$r8$lambda$Jmx2bDJUejQbQfqNRRvqVuz0(CompletableDeferred.this, billingResult, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object queryPurchasesAsync(BillingClient billingClient, QueryPurchasesParams queryPurchasesParams, Continuation<? super PurchasesResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchasesAsync(queryPurchasesParams, new PurchasesResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda10
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                BillingClientKotlinKt.m912$r8$lambda$Iy_vpeZ_JHNmajeE6ZBdUlqJKA(CompletableDeferred.this, billingResult, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @Deprecated(message = "Use [BillingClient.queryProductDetails] instead")
    public static final Object querySkuDetails(BillingClient billingClient, SkuDetailsParams skuDetailsParams, Continuation<? super SkuDetailsResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.querySkuDetailsAsync(skuDetailsParams, new SkuDetailsResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda11
            @Override // com.android.billingclient.api.SkuDetailsResponseListener
            public final void onSkuDetailsResponse(BillingResult billingResult, List list) {
                BillingClientKotlinKt.$r8$lambda$9SKPFUMhNCJ3v0PMCwGqle8zR10(CompletableDeferred.this, billingResult, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @Deprecated(message = "Use [BillingClient.queryPurchaseHistory(QueryPurchaseHistoryParams)] instead")
    public static final Object queryPurchaseHistory(BillingClient billingClient, String str, Continuation<? super PurchaseHistoryResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchaseHistoryAsync(str, new PurchaseHistoryResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda8
            @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
            public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
                BillingClientKotlinKt.$r8$lambda$ZzkEujuP9GqFND2FbZB_kuqycGM(CompletableDeferred.this, billingResult, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @Deprecated(message = "Use [BillingClient.queryPurchasesAsync(QueryPurchasesParams)] instead")
    public static final Object queryPurchasesAsync(BillingClient billingClient, String str, Continuation<? super PurchasesResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchasesAsync(str, new PurchasesResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                BillingClientKotlinKt.$r8$lambda$wzezm1LgRtzooDMmMf2vgdwDzEw(CompletableDeferred.this, billingResult, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }
}
