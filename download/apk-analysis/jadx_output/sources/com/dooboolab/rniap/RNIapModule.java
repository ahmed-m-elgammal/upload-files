package com.dooboolab.rniap;

import android.app.Activity;
import android.util.Log;
import com.android.billingclient.api.AccountIdentifiers;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RNIapModule.kt */
@ReactModule(name = RNIapModule.TAG)
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0007JV\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u000e2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J(\u0010$\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u001eH\u0002J\"\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J1\u0010+\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00110-J\u0010\u00101\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J \u00103\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u00104\u001a\u00020\u000eH\u0016J\u0010\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u00106\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u00107\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u00108\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010>\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0016J\u0010\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020AH\u0007J\"\u0010B\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0010\u0010F\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010G\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/dooboolab/rniap/RNIapModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "builder", "Lcom/android/billingclient/api/BillingClient$Builder;", "googleApiAvailability", "Lcom/google/android/gms/common/GoogleApiAvailability;", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/android/billingclient/api/BillingClient$Builder;Lcom/google/android/gms/common/GoogleApiAvailability;)V", "billingClientCache", "Lcom/android/billingclient/api/BillingClient;", "skus", "", "", "Lcom/android/billingclient/api/ProductDetails;", "acknowledgePurchase", "", "token", "developerPayLoad", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "addListener", "eventName", "buyItemByType", "type", "skuArr", "Lcom/facebook/react/bridge/ReadableArray;", "purchaseToken", "replacementMode", "", "obfuscatedAccountId", "obfuscatedProfileId", "offerTokenArr", "isOfferPersonalized", "", "consumeItems", "purchases", "", "Lcom/android/billingclient/api/Purchase;", "expectedResponseCode", "consumeProduct", "endConnection", "ensureConnection", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "billingClient", "flushFailedPurchasesCachedAsPending", "getAvailableItemsByType", "getItemsByType", "getName", "getPackageName", "getPurchaseHistoryByType", "getStorefront", "initConnection", "isFeatureSupported", "feature", "isValidResult", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "onPurchasesUpdated", "removeListeners", "count", "", "sendEvent", "Lcom/facebook/react/bridge/ReactContext;", "params", "Lcom/facebook/react/bridge/WritableMap;", "sendUnconsumedPurchases", "startListening", "Companion", "react-native-iap_playRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RNIapModule extends ReactContextBaseJavaModule implements PurchasesUpdatedListener {
    private static final String PROMISE_BUY_ITEM = "PROMISE_BUY_ITEM";
    public static final String TAG = "RNIapModule";
    private BillingClient billingClientCache;
    private final BillingClient.Builder builder;
    private final GoogleApiAvailability googleApiAvailability;
    private final ReactApplicationContext reactContext;
    private final Map<String, ProductDetails> skus;

    @ReactMethod
    public final void addListener(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @ReactMethod
    public final void removeListeners(double count) {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ RNIapModule(com.facebook.react.bridge.ReactApplicationContext r1, com.android.billingclient.api.BillingClient.Builder r2, com.google.android.gms.common.GoogleApiAvailability r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L14
            r2 = r1
            android.content.Context r2 = (android.content.Context) r2
            com.android.billingclient.api.BillingClient$Builder r2 = com.android.billingclient.api.BillingClient.newBuilder(r2)
            com.android.billingclient.api.BillingClient$Builder r2 = r2.enablePendingPurchases()
            java.lang.String r5 = "enablePendingPurchases(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
        L14:
            r4 = r4 & 4
            if (r4 == 0) goto L21
            com.google.android.gms.common.GoogleApiAvailability r3 = com.google.android.gms.common.GoogleApiAvailability.getInstance()
            java.lang.String r4 = "getInstance(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L21:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dooboolab.rniap.RNIapModule.<init>(com.facebook.react.bridge.ReactApplicationContext, com.android.billingclient.api.BillingClient$Builder, com.google.android.gms.common.GoogleApiAvailability, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNIapModule(ReactApplicationContext reactContext, BillingClient.Builder builder, GoogleApiAvailability googleApiAvailability) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(googleApiAvailability, "googleApiAvailability");
        this.reactContext = reactContext;
        this.builder = builder;
        this.googleApiAvailability = googleApiAvailability;
        this.skus = new LinkedHashMap();
        reactContext.addLifecycleEventListener(new LifecycleEventListener() { // from class: com.dooboolab.rniap.RNIapModule$lifecycleEventListener$1
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostPause() {
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostResume() {
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostDestroy() {
                BillingClient billingClient;
                billingClient = RNIapModule.this.billingClientCache;
                if (billingClient != null) {
                    billingClient.endConnection();
                }
                RNIapModule.this.billingClientCache = null;
            }
        });
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    public final void ensureConnection(final Promise promise, final Function1<? super BillingClient, Unit> callback) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BillingClient billingClient = this.billingClientCache;
        if (billingClient != null && billingClient.isReady()) {
            callback.invoke(billingClient);
        } else {
            initConnection(new PromiseImpl(new Callback() { // from class: com.dooboolab.rniap.RNIapModule$$ExternalSyntheticLambda0
                @Override // com.facebook.react.bridge.Callback
                public final void invoke(Object[] objArr) {
                    RNIapModule.ensureConnection$lambda$0(RNIapModule.this, callback, promise, objArr);
                }
            }, new Callback() { // from class: com.dooboolab.rniap.RNIapModule$$ExternalSyntheticLambda1
                @Override // com.facebook.react.bridge.Callback
                public final void invoke(Object[] objArr) {
                    RNIapModule.ensureConnection$lambda$1(Promise.this, objArr);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureConnection$lambda$0(RNIapModule this$0, Function1 callback, Promise promise, Object[] objArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNull(objArr);
        if (!(objArr.length == 0)) {
            Object obj = objArr[0];
            if (obj instanceof Boolean) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) obj).booleanValue()) {
                    BillingClient billingClient = this$0.billingClientCache;
                    if (billingClient != null && billingClient.isReady()) {
                        callback.invoke(billingClient);
                        return;
                    } else {
                        PromiseUtlisKt.safeReject(promise, PromiseUtils.E_NOT_PREPARED, "Unable to auto-initialize connection");
                        return;
                    }
                }
            }
        }
        PromiseUtlisKt.safeReject(promise, PromiseUtils.E_UNKNOWN, "ensureConnection - incorrect parameter in resolve");
        Log.i(TAG, "Incorrect parameter in resolve");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004d A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ensureConnection$lambda$1(com.facebook.react.bridge.Promise r4, java.lang.Object[] r5) {
        /*
            java.lang.String r0 = "$promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r5.length
            r1 = 0
            r2 = 1
            if (r0 <= r2) goto L25
            r0 = r5[r1]
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L25
            r3 = r5[r2]
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L25
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.lang.String r0 = (java.lang.String) r0
            r5 = r5[r2]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r1)
            java.lang.String r5 = (java.lang.String) r5
            goto L4b
        L25:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r0 = r5.length
            if (r0 != 0) goto L2c
            goto L2d
        L2c:
            r2 = r1
        L2d:
            if (r2 != 0) goto L49
            r5 = r5[r1]
            boolean r0 = r5 instanceof com.facebook.react.bridge.WritableNativeMap
            if (r0 == 0) goto L49
            java.lang.String r0 = "null cannot be cast to non-null type com.facebook.react.bridge.WritableNativeMap"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r0)
            com.facebook.react.bridge.WritableNativeMap r5 = (com.facebook.react.bridge.WritableNativeMap) r5
            java.lang.String r0 = "code"
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r1 = "message"
            java.lang.String r5 = r5.getString(r1)
            goto L4b
        L49:
            r0 = 0
            r5 = r0
        L4b:
            if (r0 == 0) goto L53
            if (r5 == 0) goto L53
            com.dooboolab.rniap.PromiseUtlisKt.safeReject(r4, r0, r5)
            goto L61
        L53:
            java.lang.String r5 = "E_UNKNOWN"
            java.lang.String r0 = "ensureConnection - incorrect parameter in reject"
            com.dooboolab.rniap.PromiseUtlisKt.safeReject(r4, r5, r0)
            java.lang.String r4 = "RNIapModule"
            java.lang.String r5 = "Incorrect parameters in reject"
            android.util.Log.i(r4, r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dooboolab.rniap.RNIapModule.ensureConnection$lambda$1(com.facebook.react.bridge.Promise, java.lang.Object[]):void");
    }

    @ReactMethod
    public final void isFeatureSupported(final String feature, final Promise promise) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ensureConnection(promise, new Function1<BillingClient, Unit>() { // from class: com.dooboolab.rniap.RNIapModule$isFeatureSupported$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
                invoke2(billingClient);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
            java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BillingClient billingClient) {
                String str;
                Intrinsics.checkNotNullParameter(billingClient, "billingClient");
                String str2 = feature;
                switch (str2.hashCode()) {
                    case -91953012:
                        if (str2.equals("IN_APP_MESSAGING")) {
                            str = BillingClient.FeatureType.IN_APP_MESSAGING;
                            PromiseUtlisKt.safeResolve(promise, billingClient.isFeatureSupported(str));
                            return;
                        }
                        break;
                    case 755711666:
                        if (str2.equals("PRODUCT_DETAILS")) {
                            str = BillingClient.FeatureType.PRODUCT_DETAILS;
                            PromiseUtlisKt.safeResolve(promise, billingClient.isFeatureSupported(str));
                            return;
                        }
                        break;
                    case 808641238:
                        if (str2.equals("SUBSCRIPTIONS")) {
                            str = BillingClient.FeatureType.SUBSCRIPTIONS;
                            PromiseUtlisKt.safeResolve(promise, billingClient.isFeatureSupported(str));
                            return;
                        }
                        break;
                    case 1739975758:
                        if (str2.equals("PRICE_CHANGE_CONFIRMATION")) {
                            str = BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION;
                            PromiseUtlisKt.safeResolve(promise, billingClient.isFeatureSupported(str));
                            return;
                        }
                        break;
                    case 1785301586:
                        if (str2.equals("SUBSCRIPTIONS_UPDATE")) {
                            str = BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE;
                            PromiseUtlisKt.safeResolve(promise, billingClient.isFeatureSupported(str));
                            return;
                        }
                        break;
                }
                PromiseUtlisKt.safeReject(promise, "Invalid Feature name");
            }
        });
    }

    @ReactMethod
    public final void initConnection(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (this.googleApiAvailability.isGooglePlayServicesAvailable(this.reactContext) != 0) {
            Log.i(TAG, "Google Play Services are not available on this device");
            PromiseUtlisKt.safeReject(promise, PromiseUtils.E_NOT_PREPARED, "Google Play Services are not available on this device");
            return;
        }
        BillingClient billingClient = this.billingClientCache;
        if (billingClient != null && billingClient.isReady()) {
            Log.i(TAG, "Already initialized, you should only call initConnection() once when your app starts");
            PromiseUtlisKt.safeResolve(promise, true);
        } else {
            BillingClient build = this.builder.setListener(this).build();
            this.billingClientCache = build;
            build.startConnection(new BillingClientStateListener() { // from class: com.dooboolab.rniap.RNIapModule$initConnection$1$1
                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingSetupFinished(BillingResult billingResult) {
                    boolean isValidResult;
                    Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                    isValidResult = RNIapModule.this.isValidResult(billingResult, promise);
                    if (isValidResult) {
                        PromiseUtlisKt.safeResolve(promise, true);
                    }
                }

                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingServiceDisconnected() {
                    Log.i(RNIapModule.TAG, "Billing service disconnected");
                }
            });
        }
    }

    @ReactMethod
    public final void endConnection(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BillingClient billingClient = this.billingClientCache;
        if (billingClient != null) {
            billingClient.endConnection();
        }
        this.billingClientCache = null;
        this.skus.clear();
        PromiseUtils.INSTANCE.rejectAllPendingPromises();
        PromiseUtlisKt.safeResolve(promise, true);
    }

    static /* synthetic */ void consumeItems$default(RNIapModule rNIapModule, List list, Promise promise, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        rNIapModule.consumeItems(list, promise, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void consumeItems(List<? extends Purchase> purchases, Promise promise, int expectedResponseCode) {
        Iterator<? extends Purchase> it = purchases.iterator();
        while (it.hasNext()) {
            ensureConnection(promise, new RNIapModule$consumeItems$1(it.next(), expectedResponseCode, promise));
        }
    }

    @ReactMethod
    public final void flushFailedPurchasesCachedAsPending(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        ensureConnection(promise, new RNIapModule$flushFailedPurchasesCachedAsPending$1(this, promise));
    }

    @ReactMethod
    public final void getItemsByType(String type, ReadableArray skuArr, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(skuArr, "skuArr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ensureConnection(promise, new RNIapModule$getItemsByType$1(skuArr, promise, type, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidResult(BillingResult billingResult, Promise promise) {
        Log.d(TAG, "responseCode: " + billingResult.getResponseCode());
        if (billingResult.getResponseCode() == 0) {
            return true;
        }
        PlayUtils.INSTANCE.rejectPromiseWithBillingError(promise, billingResult.getResponseCode());
        return false;
    }

    @ReactMethod
    public final void getAvailableItemsByType(String type, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ensureConnection(promise, new RNIapModule$getAvailableItemsByType$1(type, this, promise));
    }

    @ReactMethod
    public final void getPurchaseHistoryByType(String type, Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ensureConnection(promise, new RNIapModule$getPurchaseHistoryByType$1(type, this, promise));
    }

    @ReactMethod
    public final void buyItemByType(final String type, final ReadableArray skuArr, final String purchaseToken, final int replacementMode, final String obfuscatedAccountId, final String obfuscatedProfileId, final ReadableArray offerTokenArr, final boolean isOfferPersonalized, final Promise promise) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(skuArr, "skuArr");
        Intrinsics.checkNotNullParameter(offerTokenArr, "offerTokenArr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            PromiseUtlisKt.safeReject(promise, PromiseUtils.E_UNKNOWN, "getCurrentActivity returned null");
        } else {
            ensureConnection(promise, new Function1<BillingClient, Unit>() { // from class: com.dooboolab.rniap.RNIapModule$buyItemByType$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BillingClient billingClient) {
                    invoke2(billingClient);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BillingClient billingClient) {
                    int i;
                    int i2;
                    Map map;
                    ReactApplicationContext reactApplicationContext;
                    String string;
                    ReactApplicationContext reactApplicationContext2;
                    Intrinsics.checkNotNullParameter(billingClient, "billingClient");
                    PromiseUtils.INSTANCE.addPromiseForKey("PROMISE_BUY_ITEM", Promise.this);
                    if (Intrinsics.areEqual(type, "subs") && skuArr.size() != offerTokenArr.size()) {
                        String str = "The number of skus (" + skuArr.size() + ") must match: the number of offerTokens (" + offerTokenArr.size() + ") for Subscriptions";
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("debugMessage", str);
                        createMap.putString("code", "PROMISE_BUY_ITEM");
                        createMap.putString("message", str);
                        RNIapModule rNIapModule = this;
                        reactApplicationContext2 = rNIapModule.reactContext;
                        rNIapModule.sendEvent(reactApplicationContext2, "purchase-error", createMap);
                        PromiseUtlisKt.safeReject(Promise.this, "PROMISE_BUY_ITEM", str);
                        return;
                    }
                    ArrayList<Object> arrayList = skuArr.toArrayList();
                    Intrinsics.checkNotNullExpressionValue(arrayList, "toArrayList(...)");
                    ArrayList<Object> arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator<T> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(it.next().toString());
                    }
                    ArrayList arrayList4 = arrayList3;
                    RNIapModule rNIapModule2 = this;
                    Promise promise2 = Promise.this;
                    String str2 = type;
                    ReadableArray readableArray = offerTokenArr;
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                    Iterator it2 = arrayList4.iterator();
                    int i3 = 0;
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String str3 = (String) next;
                        Iterator it3 = it2;
                        map = rNIapModule2.skus;
                        ProductDetails productDetails = (ProductDetails) map.get(str3);
                        if (productDetails == null) {
                            WritableMap createMap2 = Arguments.createMap();
                            createMap2.putString("debugMessage", "The sku was not found. Please fetch products first by calling getItems");
                            createMap2.putString("code", "PROMISE_BUY_ITEM");
                            createMap2.putString("message", "The sku was not found. Please fetch products first by calling getItems");
                            createMap2.putString("productId", str3);
                            reactApplicationContext = rNIapModule2.reactContext;
                            rNIapModule2.sendEvent(reactApplicationContext, "purchase-error", createMap2);
                            PromiseUtlisKt.safeReject(promise2, "PROMISE_BUY_ITEM", "The sku was not found. Please fetch products first by calling getItems");
                            return;
                        }
                        BillingFlowParams.ProductDetailsParams.Builder productDetails2 = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails);
                        Intrinsics.checkNotNullExpressionValue(productDetails2, "setProductDetails(...)");
                        if (Intrinsics.areEqual(str2, "subs") && (string = readableArray.getString(i3)) != null) {
                            productDetails2 = productDetails2.setOfferToken(string);
                            Intrinsics.checkNotNullExpressionValue(productDetails2, "setOfferToken(...)");
                        }
                        arrayList5.add(productDetails2.build());
                        it2 = it3;
                        i3 = i4;
                    }
                    BillingFlowParams.Builder newBuilder = BillingFlowParams.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder(...)");
                    newBuilder.setProductDetailsParamsList(arrayList5).setIsOfferPersonalized(isOfferPersonalized);
                    BillingFlowParams.SubscriptionUpdateParams.Builder newBuilder2 = BillingFlowParams.SubscriptionUpdateParams.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder(...)");
                    String str4 = purchaseToken;
                    if (str4 != null) {
                        newBuilder2.setOldPurchaseToken(str4);
                        if (Intrinsics.areEqual(type, "subs") && (i = replacementMode) != -1) {
                            int i5 = 1;
                            if (i != 1) {
                                i5 = 2;
                                if (i != 2) {
                                    i5 = 3;
                                    if (i != 3) {
                                        i5 = 5;
                                        if (i != 5) {
                                            i5 = 6;
                                            if (i != 6) {
                                                i2 = 0;
                                                newBuilder2.setSubscriptionReplacementMode(i2);
                                            }
                                        }
                                    }
                                }
                            }
                            i2 = i5;
                            newBuilder2.setSubscriptionReplacementMode(i2);
                        }
                        BillingFlowParams.SubscriptionUpdateParams build = newBuilder2.build();
                        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                        newBuilder.setSubscriptionUpdateParams(build);
                    }
                    String str5 = obfuscatedAccountId;
                    if (str5 != null) {
                        newBuilder.setObfuscatedAccountId(str5);
                    }
                    String str6 = obfuscatedProfileId;
                    if (str6 != null) {
                        newBuilder.setObfuscatedProfileId(str6);
                    }
                    BillingFlowParams build2 = newBuilder.build();
                    Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
                    int responseCode = billingClient.launchBillingFlow(currentActivity, build2).getResponseCode();
                    if (responseCode != 0) {
                        BillingResponse billingResponseData = PlayUtils.INSTANCE.getBillingResponseData(responseCode);
                        PromiseUtlisKt.safeReject(Promise.this, billingResponseData.getCode(), billingResponseData.getMessage());
                    }
                }
            });
        }
    }

    @ReactMethod
    public final void acknowledgePurchase(String token, String developerPayLoad, Promise promise) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ensureConnection(promise, new RNIapModule$acknowledgePurchase$1(token, this, promise));
    }

    @ReactMethod
    public final void consumeProduct(String token, String developerPayLoad, Promise promise) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ConsumeParams build = ConsumeParams.newBuilder().setPurchaseToken(token).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        ensureConnection(promise, new RNIapModule$consumeProduct$1(build, this, promise));
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult, List<? extends Purchase> purchases) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        if (responseCode != 0) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("responseCode", responseCode);
            createMap.putString("debugMessage", billingResult.getDebugMessage());
            BillingResponse billingResponseData = PlayUtils.INSTANCE.getBillingResponseData(responseCode);
            createMap.putString("code", billingResponseData.getCode());
            createMap.putString("message", billingResponseData.getMessage());
            sendEvent(this.reactContext, "purchase-error", createMap);
            PlayUtils.INSTANCE.rejectPromisesWithBillingError(PROMISE_BUY_ITEM, responseCode);
            return;
        }
        if (purchases != null) {
            WritableArray createArray = Arguments.createArray();
            Intrinsics.checkNotNullExpressionValue(createArray, "createArray(...)");
            for (Purchase purchase : purchases) {
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putString("productId", purchase.getProducts().get(0));
                WritableArray createArray2 = Arguments.createArray();
                List<String> products = purchase.getProducts();
                Intrinsics.checkNotNullExpressionValue(products, "getProducts(...)");
                Iterator<T> it = products.iterator();
                while (it.hasNext()) {
                    createArray2.pushString((String) it.next());
                }
                createMap2.putArray("productIds", createArray2);
                createMap2.putString("transactionId", purchase.getOrderId());
                createMap2.putDouble("transactionDate", purchase.getPurchaseTime());
                createMap2.putString("transactionReceipt", purchase.getOriginalJson());
                createMap2.putString("purchaseToken", purchase.getPurchaseToken());
                createMap2.putString("dataAndroid", purchase.getOriginalJson());
                createMap2.putString("signatureAndroid", purchase.getSignature());
                createMap2.putBoolean("autoRenewingAndroid", purchase.isAutoRenewing());
                createMap2.putBoolean("isAcknowledgedAndroid", purchase.isAcknowledged());
                createMap2.putInt("purchaseStateAndroid", purchase.getPurchaseState());
                createMap2.putString("packageNameAndroid", purchase.getPackageName());
                createMap2.putString("developerPayloadAndroid", purchase.getDeveloperPayload());
                AccountIdentifiers accountIdentifiers = purchase.getAccountIdentifiers();
                if (accountIdentifiers != null) {
                    createMap2.putString("obfuscatedAccountIdAndroid", accountIdentifiers.getObfuscatedAccountId());
                    createMap2.putString("obfuscatedProfileIdAndroid", accountIdentifiers.getObfuscatedProfileId());
                }
                createArray.pushMap(createMap2.copy());
                sendEvent(this.reactContext, "purchase-updated", createMap2);
            }
            PromiseUtils.INSTANCE.resolvePromisesForKey(PROMISE_BUY_ITEM, createArray);
            return;
        }
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putInt("responseCode", billingResult.getResponseCode());
        createMap3.putString("debugMessage", billingResult.getDebugMessage());
        createMap3.putString("extraMessage", "The purchases are null. This is a normal behavior if you have requested DEFERRED proration. If not please report an issue.");
        sendEvent(this.reactContext, "purchase-updated", createMap3);
        PromiseUtils.INSTANCE.resolvePromisesForKey(PROMISE_BUY_ITEM, null);
    }

    private final void sendUnconsumedPurchases(Promise promise) {
        ensureConnection(promise, new RNIapModule$sendUnconsumedPurchases$1(promise, this));
    }

    @ReactMethod
    public final void startListening(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        sendUnconsumedPurchases(promise);
    }

    @ReactMethod
    public final void getPackageName(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(getReactApplicationContext().getPackageName());
    }

    @ReactMethod
    public final void getStorefront(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        ensureConnection(promise, new RNIapModule$getStorefront$1(promise));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(ReactContext reactContext, String eventName, WritableMap params) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(eventName, params);
    }
}
