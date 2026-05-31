package com.microsoft.clarity.models.display.paths;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.I;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\b\u0010\u0010\u001a\u00020\u0000H\u0016J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/microsoft/clarity/models/display/paths/Path;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Path;", "Lcom/microsoft/clarity/models/ICopyable;", "fillType", "", "verbs", "", "Lcom/microsoft/clarity/models/display/paths/PathVerb;", "(ILjava/util/List;)V", "getFillType", "()I", "getVerbs", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Path implements IProtoModel<MutationPayload$Path>, ICopyable<Path> {
    private final int fillType;
    private final List<PathVerb> verbs;

    /* JADX WARN: Multi-variable type inference failed */
    public Path(int i, List<? extends PathVerb> verbs) {
        Intrinsics.checkNotNullParameter(verbs, "verbs");
        this.fillType = i;
        this.verbs = verbs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Path copy$default(Path path, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = path.fillType;
        }
        if ((i2 & 2) != 0) {
            list = path.verbs;
        }
        return path.copy(i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFillType() {
        return this.fillType;
    }

    public final List<PathVerb> component2() {
        return this.verbs;
    }

    public final Path copy(int fillType, List<? extends PathVerb> verbs) {
        Intrinsics.checkNotNullParameter(verbs, "verbs");
        return new Path(fillType, verbs);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public Path copyWithNullData() {
        return (Path) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Path)) {
            return false;
        }
        Path path = (Path) other;
        return this.fillType == path.fillType && Intrinsics.areEqual(this.verbs, path.verbs);
    }

    public final int getFillType() {
        return this.fillType;
    }

    public final List<PathVerb> getVerbs() {
        return this.verbs;
    }

    public int hashCode() {
        return this.verbs.hashCode() + (this.fillType * 31);
    }

    public String toString() {
        return "Path(fillType=" + this.fillType + ", verbs=" + this.verbs + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Path toProtobufInstance() {
        I a2 = MutationPayload$Path.newBuilder().a(this.fillType);
        List<PathVerb> list = this.verbs;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PathVerb) it.next()).toProtobufInstance());
        }
        GeneratedMessageLite build = a2.a(CollectionsKt.toList(arrayList)).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …t())\n            .build()");
        return (MutationPayload$Path) build;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Path copy2() {
        int i = this.fillType;
        List<PathVerb> list = this.verbs;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PathVerb) it.next()).copy2());
        }
        return new Path(i, arrayList);
    }
}
