package com.microsoft.clarity.models.ingest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0003\u000b\f\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/microsoft/clarity/models/ingest/CollectResponse;", "", "successful", "", "data", "Lcom/microsoft/clarity/models/ingest/CollectResponse$CollectResponseData;", "(ZLcom/microsoft/clarity/models/ingest/CollectResponse$CollectResponseData;)V", "getData", "()Lcom/microsoft/clarity/models/ingest/CollectResponse$CollectResponseData;", "getSuccessful", "()Z", "CollectResponseData", "CollectResponseSignal", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CollectResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CollectResponseData data;
    private final boolean successful;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/microsoft/clarity/models/ingest/CollectResponse$CollectResponseData;", "", "signals", "", "Lcom/microsoft/clarity/models/ingest/CollectResponse$CollectResponseSignal;", "(Ljava/util/List;)V", "getSignals", "()Ljava/util/List;", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CollectResponseData {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<CollectResponseSignal> signals;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/ingest/CollectResponse$CollectResponseData$Companion;", "", "()V", "tryCreate", "Lcom/microsoft/clarity/models/ingest/CollectResponse$CollectResponseData;", "responseData", "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final CollectResponseData tryCreate(String responseData) {
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (responseData == null || StringsKt.isBlank(responseData)) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = StringsKt.split$default((CharSequence) responseData, new String[]{"\n"}, false, 0, 6, (Object) null).iterator();
                while (it.hasNext()) {
                    List split$default = StringsKt.split$default((CharSequence) it.next(), new String[]{" "}, false, 0, 6, (Object) null);
                    if (split$default.size() == 2) {
                        if (Intrinsics.areEqual(split$default.get(0), "SIGNAL")) {
                            JSONArray jSONArray = new JSONArray((String) split$default.get(1));
                            int length = jSONArray.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                                if (optJSONObject != null && optJSONObject.has("type")) {
                                    String string = optJSONObject.getString("type");
                                    Intrinsics.checkNotNullExpressionValue(string, "signalJson.getString(\"type\")");
                                    arrayList.add(new CollectResponseSignal(string, optJSONObject.has("value") ? optJSONObject.getString("value") : null));
                                }
                            }
                        }
                    }
                }
                return new CollectResponseData(arrayList, defaultConstructorMarker);
            }

            private Companion() {
            }
        }

        public /* synthetic */ CollectResponseData(List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(list);
        }

        public final List<CollectResponseSignal> getSignals() {
            return this.signals;
        }

        private CollectResponseData(List<CollectResponseSignal> list) {
            this.signals = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/microsoft/clarity/models/ingest/CollectResponse$CollectResponseSignal;", "", "type", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getValue", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CollectResponseSignal {
        private final String type;
        private final String value;

        public CollectResponseSignal(String type, String str) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.value = str;
        }

        public final String getType() {
            return this.type;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/microsoft/clarity/models/ingest/CollectResponse$Companion;", "", "()V", "create", "Lcom/microsoft/clarity/models/ingest/CollectResponse;", "responseCode", "", "responseData", "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CollectResponse create$default(Companion companion, int i, String str, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str = null;
            }
            return companion.create(i, str);
        }

        public final CollectResponse create(int responseCode, String responseData) {
            boolean z = responseCode == 200;
            return new CollectResponse(200 <= responseCode && responseCode < 300, z ? CollectResponseData.INSTANCE.tryCreate(responseData) : null, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ CollectResponse(boolean z, CollectResponseData collectResponseData, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, collectResponseData);
    }

    public final CollectResponseData getData() {
        return this.data;
    }

    public final boolean getSuccessful() {
        return this.successful;
    }

    private CollectResponse(boolean z, CollectResponseData collectResponseData) {
        this.successful = z;
        this.data = collectResponseData;
    }
}
