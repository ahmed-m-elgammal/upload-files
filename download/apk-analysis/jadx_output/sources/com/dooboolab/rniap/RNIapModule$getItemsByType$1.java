package com.dooboolab.rniap;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.facebook.appevents.internal.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RNIapModule.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RNIapModule$getItemsByType$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ ReadableArray $skuArr;
    final /* synthetic */ String $type;
    final /* synthetic */ RNIapModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNIapModule$getItemsByType$1(ReadableArray readableArray, Promise promise, String str, RNIapModule rNIapModule) {
        super(1);
        this.$skuArr = readableArray;
        this.$promise = promise;
        this.$type = str;
        this.this$0 = rNIapModule;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
        invoke2(billingClient);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BillingClient billingClient) {
        String string;
        Intrinsics.checkNotNullParameter(billingClient, "billingClient");
        ArrayList arrayList = new ArrayList();
        int size = this.$skuArr.size();
        for (int i = 0; i < size; i++) {
            if (this.$skuArr.getType(i) == ReadableType.String && (string = this.$skuArr.getString(i)) != null) {
                QueryProductDetailsParams.Product build = QueryProductDetailsParams.Product.newBuilder().setProductId(string).setProductType(this.$type).build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                arrayList.add(build);
            }
        }
        if (arrayList.isEmpty()) {
            PromiseUtlisKt.safeReject(this.$promise, "EMPTY_SKU_LIST", "The SKU list is empty.");
            return;
        }
        QueryProductDetailsParams build2 = QueryProductDetailsParams.newBuilder().setProductList(arrayList).build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        final RNIapModule rNIapModule = this.this$0;
        final Promise promise = this.$promise;
        billingClient.queryProductDetailsAsync(build2, new ProductDetailsResponseListener() { // from class: com.dooboolab.rniap.RNIapModule$getItemsByType$1$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void onProductDetailsResponse(BillingResult billingResult, List list) {
                RNIapModule$getItemsByType$1.invoke$lambda$10(RNIapModule.this, promise, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$10(RNIapModule this$0, Promise promise, BillingResult billingResult, List skuDetailsList) {
        boolean isValidResult;
        Map map;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(skuDetailsList, "skuDetailsList");
        isValidResult = this$0.isValidResult(billingResult, promise);
        if (isValidResult) {
            WritableArray createArray = Arguments.createArray();
            Iterator it = skuDetailsList.iterator();
            while (it.hasNext()) {
                ProductDetails productDetails = (ProductDetails) it.next();
                map = this$0.skus;
                String productId = productDetails.getProductId();
                Intrinsics.checkNotNullExpressionValue(productId, "getProductId(...)");
                Intrinsics.checkNotNull(productDetails);
                map.put(productId, productDetails);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("productId", productDetails.getProductId());
                createMap.putString("title", productDetails.getTitle());
                createMap.putString("description", productDetails.getDescription());
                createMap.putString("productType", productDetails.getProductType());
                createMap.putString("name", productDetails.getName());
                ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                if (oneTimePurchaseOfferDetails != null) {
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7, oneTimePurchaseOfferDetails.getPriceCurrencyCode());
                    createMap2.putString("formattedPrice", oneTimePurchaseOfferDetails.getFormattedPrice());
                    createMap2.putString(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7, String.valueOf(oneTimePurchaseOfferDetails.getPriceAmountMicros()));
                    createMap.putMap(Constants.GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS, createMap2);
                }
                List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails = productDetails.getSubscriptionOfferDetails();
                if (subscriptionOfferDetails != null) {
                    WritableArray createArray2 = Arguments.createArray();
                    for (ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails2 : subscriptionOfferDetails) {
                        WritableMap createMap3 = Arguments.createMap();
                        createMap3.putString(Constants.GP_IAP_BASE_PLAN_ID, subscriptionOfferDetails2.getBasePlanId());
                        createMap3.putString(Constants.GP_IAP_OFFER_ID, subscriptionOfferDetails2.getOfferId());
                        createMap3.putString("offerToken", subscriptionOfferDetails2.getOfferToken());
                        WritableArray createArray3 = Arguments.createArray();
                        List<String> offerTags = subscriptionOfferDetails2.getOfferTags();
                        Intrinsics.checkNotNullExpressionValue(offerTags, "getOfferTags(...)");
                        Iterator<T> it2 = offerTags.iterator();
                        while (it2.hasNext()) {
                            createArray3.pushString((String) it2.next());
                        }
                        createMap3.putArray("offerTags", createArray3);
                        WritableArray createArray4 = Arguments.createArray();
                        List<ProductDetails.PricingPhase> pricingPhaseList = subscriptionOfferDetails2.getPricingPhases().getPricingPhaseList();
                        Intrinsics.checkNotNullExpressionValue(pricingPhaseList, "getPricingPhaseList(...)");
                        for (ProductDetails.PricingPhase pricingPhase : pricingPhaseList) {
                            WritableMap createMap4 = Arguments.createMap();
                            createMap4.putString("formattedPrice", pricingPhase.getFormattedPrice());
                            createMap4.putString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7, pricingPhase.getPriceCurrencyCode());
                            createMap4.putString(Constants.GP_IAP_BILLING_PERIOD, pricingPhase.getBillingPeriod());
                            createMap4.putInt("billingCycleCount", pricingPhase.getBillingCycleCount());
                            createMap4.putString(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7, String.valueOf(pricingPhase.getPriceAmountMicros()));
                            createMap4.putInt(Constants.GP_IAP_RECURRENCE_MODE, pricingPhase.getRecurrenceMode());
                            createArray4.pushMap(createMap4);
                        }
                        WritableMap createMap5 = Arguments.createMap();
                        createMap5.putArray("pricingPhaseList", createArray4);
                        createMap3.putMap(Constants.GP_IAP_SUBSCRIPTION_PRICING_PHASES, createMap5);
                        createArray2.pushMap(createMap3);
                    }
                    createMap.putArray(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS, createArray2);
                }
                createArray.pushMap(createMap);
            }
            PromiseUtlisKt.safeResolve(promise, createArray);
        }
    }
}
