package com.android.billingclient.api;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/android/billingclient/api/CreateExternalOfferReportingDetailsResult;", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "externalOfferReportingDetails", "Lcom/android/billingclient/api/ExternalOfferReportingDetails;", "(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/ExternalOfferReportingDetails;)V", "getBillingResult", "()Lcom/android/billingclient/api/BillingResult;", "getExternalOfferReportingDetails", "()Lcom/android/billingclient/api/ExternalOfferReportingDetails;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CreateExternalOfferReportingDetailsResult {
    private final BillingResult zza;
    private final ExternalOfferReportingDetails zzb;

    public CreateExternalOfferReportingDetailsResult(BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.zza = billingResult;
        this.zzb = externalOfferReportingDetails;
    }

    public static /* synthetic */ CreateExternalOfferReportingDetailsResult copy$default(CreateExternalOfferReportingDetailsResult createExternalOfferReportingDetailsResult, BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails, int i, Object obj) {
        if ((i & 1) != 0) {
            billingResult = createExternalOfferReportingDetailsResult.zza;
        }
        if ((i & 2) != 0) {
            externalOfferReportingDetails = createExternalOfferReportingDetailsResult.zzb;
        }
        return createExternalOfferReportingDetailsResult.copy(billingResult, externalOfferReportingDetails);
    }

    /* renamed from: component1, reason: from getter */
    public final BillingResult getZza() {
        return this.zza;
    }

    /* renamed from: component2, reason: from getter */
    public final ExternalOfferReportingDetails getZzb() {
        return this.zzb;
    }

    public final CreateExternalOfferReportingDetailsResult copy(BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        return new CreateExternalOfferReportingDetailsResult(billingResult, externalOfferReportingDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateExternalOfferReportingDetailsResult)) {
            return false;
        }
        CreateExternalOfferReportingDetailsResult createExternalOfferReportingDetailsResult = (CreateExternalOfferReportingDetailsResult) other;
        return Intrinsics.areEqual(this.zza, createExternalOfferReportingDetailsResult.zza) && Intrinsics.areEqual(this.zzb, createExternalOfferReportingDetailsResult.zzb);
    }

    public final BillingResult getBillingResult() {
        return this.zza;
    }

    public final ExternalOfferReportingDetails getExternalOfferReportingDetails() {
        return this.zzb;
    }

    public int hashCode() {
        int hashCode = this.zza.hashCode() * 31;
        ExternalOfferReportingDetails externalOfferReportingDetails = this.zzb;
        return hashCode + (externalOfferReportingDetails == null ? 0 : externalOfferReportingDetails.hashCode());
    }

    public String toString() {
        return "CreateExternalOfferReportingDetailsResult(billingResult=" + this.zza + ", externalOfferReportingDetails=" + this.zzb + ")";
    }
}
