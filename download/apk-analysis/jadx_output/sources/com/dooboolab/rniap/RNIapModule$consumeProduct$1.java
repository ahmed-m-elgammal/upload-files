package com.dooboolab.rniap;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
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
final class RNIapModule$consumeProduct$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ ConsumeParams $params;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ RNIapModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNIapModule$consumeProduct$1(ConsumeParams consumeParams, RNIapModule rNIapModule, Promise promise) {
        super(1);
        this.$params = consumeParams;
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
        ConsumeParams consumeParams = this.$params;
        final RNIapModule rNIapModule = this.this$0;
        final Promise promise = this.$promise;
        billingClient.consumeAsync(consumeParams, new ConsumeResponseListener() { // from class: com.dooboolab.rniap.RNIapModule$consumeProduct$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.ConsumeResponseListener
            public final void onConsumeResponse(BillingResult billingResult, String str) {
                RNIapModule$consumeProduct$1.invoke$lambda$0(RNIapModule.this, promise, billingResult, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(RNIapModule this$0, Promise promise, BillingResult billingResult, String str) {
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
            createMap.putString("purchaseToken", str);
            PromiseUtlisKt.safeResolve(promise, createMap);
        }
    }
}
