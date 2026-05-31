package com.dooboolab.rniap;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.facebook.react.bridge.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RNIapModule.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RNIapModule$consumeItems$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ int $expectedResponseCode;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ Purchase $purchase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNIapModule$consumeItems$1(Purchase purchase, int i, Promise promise) {
        super(1);
        this.$purchase = purchase;
        this.$expectedResponseCode = i;
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
        ConsumeParams build = ConsumeParams.newBuilder().setPurchaseToken(this.$purchase.getPurchaseToken()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        final int i = this.$expectedResponseCode;
        final Promise promise = this.$promise;
        billingClient.consumeAsync(build, new ConsumeResponseListener() { // from class: com.dooboolab.rniap.RNIapModule$consumeItems$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.ConsumeResponseListener
            public final void onConsumeResponse(BillingResult billingResult, String str) {
                RNIapModule$consumeItems$1.invoke$lambda$0(i, promise, billingResult, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(int i, Promise promise, BillingResult billingResult, String str) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.getResponseCode() != i) {
            PlayUtils.INSTANCE.rejectPromiseWithBillingError(promise, billingResult.getResponseCode());
        } else {
            PromiseUtlisKt.safeResolve(promise, true);
        }
    }
}
