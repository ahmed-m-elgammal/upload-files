package com.dooboolab.rniap;

import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000e"}, d2 = {"Lcom/dooboolab/rniap/PlayUtils;", "", "()V", "getBillingResponseData", "Lcom/dooboolab/rniap/BillingResponse;", "responseCode", "", "rejectPromiseWithBillingError", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "rejectPromisesWithBillingError", SDKConstants.PARAM_KEY, "", "react-native-iap_playRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlayUtils {
    public static final PlayUtils INSTANCE = new PlayUtils();

    private PlayUtils() {
    }

    public final void rejectPromiseWithBillingError(Promise promise, int responseCode) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BillingResponse billingResponseData = getBillingResponseData(responseCode);
        PromiseUtlisKt.safeReject(promise, billingResponseData.getCode(), billingResponseData.getMessage());
    }

    public final BillingResponse getBillingResponseData(int responseCode) {
        BillingResponse billingResponse;
        BillingResponse billingResponse2;
        if (responseCode != 12) {
            switch (responseCode) {
                case -2:
                    billingResponse2 = new BillingResponse(PromiseUtils.E_SERVICE_ERROR, "This feature is not available on your device.");
                    break;
                case -1:
                    billingResponse = new BillingResponse(PromiseUtils.E_NETWORK_ERROR, "The service is disconnected (check your internet connection.)");
                    break;
                case 0:
                    billingResponse2 = new BillingResponse("OK", "");
                    break;
                case 1:
                    billingResponse2 = new BillingResponse(PromiseUtils.E_USER_CANCELLED, "Payment is Cancelled.");
                    break;
                case 2:
                    billingResponse2 = new BillingResponse(PromiseUtils.E_SERVICE_ERROR, "The service is unreachable. This may be your internet connection, or the Play Store may be down.");
                    break;
                case 3:
                    billingResponse2 = new BillingResponse(PromiseUtils.E_SERVICE_ERROR, "Billing is unavailable. This may be a problem with your device, or the Play Store may be down.");
                    break;
                case 4:
                    billingResponse2 = new BillingResponse(PromiseUtils.E_ITEM_UNAVAILABLE, "That item is unavailable.");
                    break;
                case 5:
                    billingResponse2 = new BillingResponse(PromiseUtils.E_DEVELOPER_ERROR, "Google is indicating that we have some issue connecting to payment.");
                    break;
                case 6:
                    billingResponse2 = new BillingResponse(PromiseUtils.E_UNKNOWN, "An unknown or unexpected error has occurred. Please try again later.");
                    break;
                case 7:
                    billingResponse2 = new BillingResponse(PromiseUtils.E_ALREADY_OWNED, "You already own this item.");
                    break;
                default:
                    billingResponse2 = new BillingResponse(PromiseUtils.E_UNKNOWN, "Purchase failed with code: " + responseCode);
                    break;
            }
            Log.e(PromiseUtlisKt.TAG, "Error Code : " + responseCode);
            return billingResponse2;
        }
        billingResponse = new BillingResponse(PromiseUtils.E_NETWORK_ERROR, "You have problem with network connection.");
        billingResponse2 = billingResponse;
        Log.e(PromiseUtlisKt.TAG, "Error Code : " + responseCode);
        return billingResponse2;
    }

    public final void rejectPromisesWithBillingError(String key, int responseCode) {
        Intrinsics.checkNotNullParameter(key, "key");
        BillingResponse billingResponseData = getBillingResponseData(responseCode);
        PromiseUtils.INSTANCE.rejectPromisesForKey(key, billingResponseData.getCode(), billingResponseData.getMessage(), null);
    }
}
