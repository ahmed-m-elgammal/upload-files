package com.dooboolab.rniap;

import android.util.Log;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RNIapModule.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RNIapModule$getPurchaseHistoryByType$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $type;
    final /* synthetic */ RNIapModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNIapModule$getPurchaseHistoryByType$1(String str, RNIapModule rNIapModule, Promise promise) {
        super(1);
        this.$type = str;
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
        QueryPurchaseHistoryParams build = QueryPurchaseHistoryParams.newBuilder().setProductType(Intrinsics.areEqual(this.$type, "subs") ? "subs" : "inapp").build();
        final RNIapModule rNIapModule = this.this$0;
        final Promise promise = this.$promise;
        billingClient.queryPurchaseHistoryAsync(build, new PurchaseHistoryResponseListener() { // from class: com.dooboolab.rniap.RNIapModule$getPurchaseHistoryByType$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
            public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
                RNIapModule$getPurchaseHistoryByType$1.invoke$lambda$2(RNIapModule.this, promise, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(RNIapModule this$0, Promise promise, BillingResult billingResult, List list) {
        boolean isValidResult;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        isValidResult = this$0.isValidResult(billingResult, promise);
        if (isValidResult) {
            Log.d(RNIapModule.TAG, String.valueOf(list));
            WritableArray createArray = Arguments.createArray();
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) it.next();
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("productId", purchaseHistoryRecord.getProducts().get(0));
                    WritableArray createArray2 = Arguments.createArray();
                    List<String> products = purchaseHistoryRecord.getProducts();
                    Intrinsics.checkNotNullExpressionValue(products, "getProducts(...)");
                    Iterator<T> it2 = products.iterator();
                    while (it2.hasNext()) {
                        createArray2.pushString((String) it2.next());
                    }
                    createMap.putArray("productIds", createArray2);
                    createMap.putDouble("transactionDate", purchaseHistoryRecord.getPurchaseTime());
                    createMap.putString("transactionReceipt", purchaseHistoryRecord.getOriginalJson());
                    createMap.putString("purchaseToken", purchaseHistoryRecord.getPurchaseToken());
                    createMap.putString("dataAndroid", purchaseHistoryRecord.getOriginalJson());
                    createMap.putString("signatureAndroid", purchaseHistoryRecord.getSignature());
                    String developerPayload = purchaseHistoryRecord.getDeveloperPayload();
                    if (developerPayload == null) {
                        developerPayload = "";
                    }
                    createMap.putString(SDKConstants.PARAM_DEVELOPER_PAYLOAD, developerPayload);
                    createArray.pushMap(createMap);
                }
            }
            PromiseUtlisKt.safeResolve(promise, createArray);
        }
    }
}
