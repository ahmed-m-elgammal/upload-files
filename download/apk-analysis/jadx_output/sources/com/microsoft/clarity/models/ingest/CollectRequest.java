package com.microsoft.clarity.models.ingest;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/microsoft/clarity/models/ingest/CollectRequest;", "", "e", "Lcom/microsoft/clarity/models/ingest/Envelope;", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "", "", "p", "(Lcom/microsoft/clarity/models/ingest/Envelope;Ljava/util/List;Ljava/util/List;)V", "getA", "()Ljava/util/List;", "getE", "()Lcom/microsoft/clarity/models/ingest/Envelope;", "getP", "serialize", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CollectRequest {
    private final List<String> a;
    private final Envelope e;
    private final List<String> p;

    public CollectRequest(Envelope e, List<String> a2, List<String> p) {
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(p, "p");
        this.e = e;
        this.a = a2;
        this.p = p;
    }

    public final List<String> getA() {
        return this.a;
    }

    public final Envelope getE() {
        return this.e;
    }

    public final List<String> getP() {
        return this.p;
    }

    public final String serialize() {
        return "{\"e\":" + this.e.serialize() + ",\"a\":" + ("[" + CollectionsKt.joinToString$default(this.a, ",", null, null, 0, null, null, 62, null) + ']') + ",\"p\":" + ("[" + CollectionsKt.joinToString$default(this.p, ",", null, null, 0, null, null, 62, null) + ']') + '}';
    }
}
