package com.dooboolab.rniap;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RNIapModule.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RNIapModule$acknowledgePurchase$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $token;
    final /* synthetic */ RNIapModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNIapModule$acknowledgePurchase$1(String str, RNIapModule rNIapModule, Promise promise) {
        super(1);
        this.$token = str;
        this.this$0 = rNIapModule;
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
        AcknowledgePurchaseParams build = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(this.$token).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        final RNIapModule rNIapModule = this.this$0;
        final Promise promise = this.$promise;
        billingClient.acknowledgePurchase(build, new AcknowledgePurchaseResponseListener() { // from class: com.dooboolab.rniap.RNIapModule$acknowledgePurchase$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
            public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                RNIapModule$acknowledgePurchase$1.invoke$lambda$0(RNIapModule.this, promise, billingResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(RNIapModule this$0, Promise promise, BillingResult billingResult) {
        boolean isValidResult;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        isValidResult = this$0.isValidResult(billingResult, promise);
        if (isValidResult) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("responseCode", billingResult.getResponseCode());
            createMap.putString("debugMessage", billingResult.getDebugMessage());
            BillingResponse billingResponseData = PlayUtils.INSTANCE.getBillingResponseData(billingResult.getResponseCode());
            createMap.putString("code", billingResponseData.getCode());
            createMap.putString("message", billingResponseData.getMessage());
            PromiseUtlisKt.safeResolve(promise, createMap);
        }
    }
}
