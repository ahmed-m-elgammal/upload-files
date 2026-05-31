package com.dooboolab.rniap;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingConfigResponseListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.GetBillingConfigParams;
import com.facebook.react.bridge.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RNIapModule.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RNIapModule$getStorefront$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ Promise $promise;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNIapModule$getStorefront$1(Promise promise) {
        super(1);
        this.$promise = promise;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
        invoke2(billingClient);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BillingClient billingClient) {
        Intrinsics.checkNotNullParameter(billingClient, "billingClient");
        GetBillingConfigParams build = GetBillingConfigParams.newBuilder().build();
        final Promise promise = this.$promise;
        billingClient.getBillingConfigAsync(build, new BillingConfigResponseListener() { // from class: com.dooboolab.rniap.RNIapModule$getStorefront$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.BillingConfigResponseListener
            public final void onBillingConfigResponse(BillingResult billingResult, BillingConfig billingConfig) {
                RNIapModule$getStorefront$1.invoke$lambda$0(Promise.this, billingResult, billingConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Promise promise, BillingResult result, BillingConfig billingConfig) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResponseCode() == 0) {
            String countryCode = billingConfig != null ? billingConfig.getCountryCode() : null;
            PromiseUtlisKt.safeResolve(promise, countryCode != null ? countryCode : "");
        } else {
            String debugMessage = result.getDebugMessage();
            PromiseUtlisKt.safeReject(promise, String.valueOf(result.getResponseCode()), debugMessage != null ? debugMessage : "");
        }
    }
}
