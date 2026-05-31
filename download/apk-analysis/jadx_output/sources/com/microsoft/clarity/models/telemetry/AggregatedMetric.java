package com.microsoft.clarity.models.telemetry;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.sentry.protocol.MetricSummary;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020(J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006*"}, d2 = {"Lcom/microsoft/clarity/models/telemetry/AggregatedMetric;", "", "version", "", "name", "count", "", MetricSummary.JsonKeys.SUM, "", MetricSummary.JsonKeys.MIN, MetricSummary.JsonKeys.MAX, "stdev", "sourcePlatform", "(Ljava/lang/String;Ljava/lang/String;IDDDDI)V", "getCount", "()I", "getMax", "()D", "getMin", "getName", "()Ljava/lang/String;", "getSourcePlatform", "getStdev", "getSum", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toJson", "toJsonObject", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AggregatedMetric {
    private final int count;
    private final double max;
    private final double min;
    private final String name;
    private final int sourcePlatform;
    private final double stdev;
    private final double sum;
    private final String version;

    public AggregatedMetric(String version, String name, int i, double d, double d2, double d3, double d4, int i2) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(name, "name");
        this.version = version;
        this.name = name;
        this.count = i;
        this.sum = d;
        this.min = d2;
        this.max = d3;
        this.stdev = d4;
        this.sourcePlatform = i2;
    }

    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: component4, reason: from getter */
    public final double getSum() {
        return this.sum;
    }

    /* renamed from: component5, reason: from getter */
    public final double getMin() {
        return this.min;
    }

    /* renamed from: component6, reason: from getter */
    public final double getMax() {
        return this.max;
    }

    /* renamed from: component7, reason: from getter */
    public final double getStdev() {
        return this.stdev;
    }

    /* renamed from: component8, reason: from getter */
    public final int getSourcePlatform() {
        return this.sourcePlatform;
    }

    public final AggregatedMetric copy(String version, String name, int count, double sum, double min, double max, double stdev, int sourcePlatform) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(name, "name");
        return new AggregatedMetric(version, name, count, sum, min, max, stdev, sourcePlatform);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AggregatedMetric)) {
            return false;
        }
        AggregatedMetric aggregatedMetric = (AggregatedMetric) other;
        return Intrinsics.areEqual(this.version, aggregatedMetric.version) && Intrinsics.areEqual(this.name, aggregatedMetric.name) && this.count == aggregatedMetric.count && Double.compare(this.sum, aggregatedMetric.sum) == 0 && Double.compare(this.min, aggregatedMetric.min) == 0 && Double.compare(this.max, aggregatedMetric.max) == 0 && Double.compare(this.stdev, aggregatedMetric.stdev) == 0 && this.sourcePlatform == aggregatedMetric.sourcePlatform;
    }

    public final int getCount() {
        return this.count;
    }

    public final double getMax() {
        return this.max;
    }

    public final double getMin() {
        return this.min;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSourcePlatform() {
        return this.sourcePlatform;
    }

    public final double getStdev() {
        return this.stdev;
    }

    public final double getSum() {
        return this.sum;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.sourcePlatform + ((UByte$$ExternalSyntheticBackport0.m(this.stdev) + ((UByte$$ExternalSyntheticBackport0.m(this.max) + ((UByte$$ExternalSyntheticBackport0.m(this.min) + ((UByte$$ExternalSyntheticBackport0.m(this.sum) + ((this.count + ((this.name.hashCode() + (this.version.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toJson() {
        String jSONObject = toJsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toJsonObject().toString()");
        return jSONObject;
    }

    public final JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("v", this.version);
        jSONObject.put("n", this.name);
        jSONObject.put("c", this.count);
        jSONObject.put(CmcdData.Factory.STREAMING_FORMAT_SS, this.sum);
        jSONObject.put(MetricSummary.JsonKeys.MIN, this.min);
        jSONObject.put(MetricSummary.JsonKeys.MAX, this.max);
        jSONObject.put("stdev", this.stdev);
        jSONObject.put("f", this.sourcePlatform);
        return jSONObject;
    }

    public String toString() {
        return "AggregatedMetric(version=" + this.version + ", name=" + this.name + ", count=" + this.count + ", sum=" + this.sum + ", min=" + this.min + ", max=" + this.max + ", stdev=" + this.stdev + ", sourcePlatform=" + this.sourcePlatform + ')';
    }

    public /* synthetic */ AggregatedMetric(String str, String str2, int i, double d, double d2, double d3, double d4, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, d, d2, d3, d4, (i3 & 128) != 0 ? 1 : i2);
    }
}
