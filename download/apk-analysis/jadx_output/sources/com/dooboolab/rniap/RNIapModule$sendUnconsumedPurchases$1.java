package com.dooboolab.rniap;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.facebook.react.bridge.Promise;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RNIapModule.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RNIapModule$sendUnconsumedPurchases$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ RNIapModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNIapModule$sendUnconsumedPurchases$1(Promise promise, RNIapModule rNIapModule) {
        super(1);
        this.$promise = promise;
        this.this$0 = rNIapModule;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
        invoke2(billingClient);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BillingClient billingClient) {
        Intrinsics.checkNotNullParameter(billingClient, "billingClient");
        String[] strArr = {"inapp", "subs"};
        for (int i = 0; i < 2; i++) {
            QueryPurchasesParams build = QueryPurchasesParams.newBuilder().setProductType(strArr[i]).build();
            final RNIapModule rNIapModule = this.this$0;
            final Promise promise = this.$promise;
            billingClient.queryPurchasesAsync(build, new PurchasesResponseListener() { // from class: com.dooboolab.rniap.RNIapModule$sendUnconsumedPurchases$1$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.PurchasesResponseListener
                public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                    RNIapModule$sendUnconsumedPurchases$1.invoke$lambda$1(RNIapModule.this, promise, billingResult, list);
                }
            });
        }
        PromiseUtlisKt.safeResolve(this.$promise, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(RNIapModule this$0, Promise promise, BillingResult billingResult, List list) {
        boolean isValidResult;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(list, "list");
        isValidResult = this$0.isValidResult(billingResult, promise);
        if (isValidResult) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!((Purchase) obj).isAcknowledged()) {
                    arrayList.add(obj);
                }
            }
            this$0.onPurchasesUpdated(billingResult, arrayList);
        }
    }
}
