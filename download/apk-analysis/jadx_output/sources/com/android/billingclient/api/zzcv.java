package com.android.billingclient.api;

import com.android.billingclient.api.ProductDetails;
import com.facebook.appevents.internal.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes3.dex */
public final class zzcv {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final ProductDetails.PricingPhase zzf;

    zzcv(JSONObject jSONObject) throws JSONException {
        this.zza = jSONObject.getString("productId");
        this.zzb = jSONObject.optString("title");
        this.zzc = jSONObject.optString("name");
        this.zzd = jSONObject.optString("description");
        this.zze = jSONObject.optString(Constants.GP_IAP_BASE_PLAN_ID);
        JSONObject optJSONObject = jSONObject.optJSONObject("pricingPhase");
        this.zzf = optJSONObject == null ? null : new ProductDetails.PricingPhase(optJSONObject);
    }
}
