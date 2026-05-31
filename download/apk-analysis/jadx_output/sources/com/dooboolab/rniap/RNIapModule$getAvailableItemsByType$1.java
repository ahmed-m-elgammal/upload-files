package com.dooboolab.rniap;

import com.android.billingclient.api.AccountIdentifiers;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
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
final class RNIapModule$getAvailableItemsByType$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $type;
    final /* synthetic */ RNIapModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNIapModule$getAvailableItemsByType$1(String str, RNIapModule rNIapModule, Promise promise) {
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
        final WritableNativeArray writableNativeArray = new WritableNativeArray();
        QueryPurchasesParams build = QueryPurchasesParams.newBuilder().setProductType(Intrinsics.areEqual(this.$type, "subs") ? "subs" : "inapp").build();
        final RNIapModule rNIapModule = this.this$0;
        final Promise promise = this.$promise;
        final String str = this.$type;
        billingClient.queryPurchasesAsync(build, new PurchasesResponseListener() { // from class: com.dooboolab.rniap.RNIapModule$getAvailableItemsByType$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                RNIapModule$getAvailableItemsByType$1.invoke$lambda$2(RNIapModule.this, promise, writableNativeArray, str, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(RNIapModule this$0, Promise promise, WritableNativeArray items, String type, BillingResult billingResult, List list) {
        boolean isValidResult;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(items, "$items");
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        isValidResult = this$0.isValidResult(billingResult, promise);
        if (isValidResult) {
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Purchase purchase = (Purchase) it.next();
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putString("productId", purchase.getProducts().get(0));
                    WritableArray createArray = Arguments.createArray();
                    List<String> products = purchase.getProducts();
                    Intrinsics.checkNotNullExpressionValue(products, "getProducts(...)");
                    Iterator<T> it2 = products.iterator();
                    while (it2.hasNext()) {
                        createArray.pushString((String) it2.next());
                    }
                    writableNativeMap.putArray("productIds", createArray);
                    writableNativeMap.putString("transactionId", purchase.getOrderId());
                    writableNativeMap.putDouble("transactionDate", purchase.getPurchaseTime());
                    writableNativeMap.putString("transactionReceipt", purchase.getOriginalJson());
                    writableNativeMap.putString("orderId", purchase.getOrderId());
                    writableNativeMap.putString("purchaseToken", purchase.getPurchaseToken());
                    writableNativeMap.putString("developerPayloadAndroid", purchase.getDeveloperPayload());
                    writableNativeMap.putString("signatureAndroid", purchase.getSignature());
                    writableNativeMap.putInt("purchaseStateAndroid", purchase.getPurchaseState());
                    writableNativeMap.putBoolean("isAcknowledgedAndroid", purchase.isAcknowledged());
                    writableNativeMap.putString("packageNameAndroid", purchase.getPackageName());
                    AccountIdentifiers accountIdentifiers = purchase.getAccountIdentifiers();
                    writableNativeMap.putString("obfuscatedAccountIdAndroid", accountIdentifiers != null ? accountIdentifiers.getObfuscatedAccountId() : null);
                    AccountIdentifiers accountIdentifiers2 = purchase.getAccountIdentifiers();
                    writableNativeMap.putString("obfuscatedProfileIdAndroid", accountIdentifiers2 != null ? accountIdentifiers2.getObfuscatedProfileId() : null);
                    if (Intrinsics.areEqual(type, "subs")) {
                        writableNativeMap.putBoolean("autoRenewingAndroid", purchase.isAutoRenewing());
                    }
                    items.pushMap(writableNativeMap);
                }
            }
            PromiseUtlisKt.safeResolve(promise, items);
        }
    }
}
