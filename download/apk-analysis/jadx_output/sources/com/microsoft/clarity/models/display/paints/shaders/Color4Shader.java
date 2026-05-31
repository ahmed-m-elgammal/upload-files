package com.microsoft.clarity.models.display.paints.shaders;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$IntList;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Shader;
import com.microsoft.clarity.protomodels.mutationpayload.Y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\b\u0010\u0012\u001a\u00020\u0000H\u0016J%\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/shaders/Color4Shader;", "Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "color4f", "Lcom/microsoft/clarity/models/display/paints/Color4f;", "colorSpaceData", "", "", "(Lcom/microsoft/clarity/models/display/paints/Color4f;Ljava/util/List;)V", "getColor4f", "()Lcom/microsoft/clarity/models/display/paints/Color4f;", "getColorSpaceData", "()Ljava/util/List;", "type", "Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Shader;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Color4Shader extends Shader {
    private final Color4f color4f;
    private final List<Integer> colorSpaceData;
    private final ShaderType type;

    public /* synthetic */ Color4Shader(Color4f color4f, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(color4f, (i & 2) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Color4Shader copy$default(Color4Shader color4Shader, Color4f color4f, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            color4f = color4Shader.color4f;
        }
        if ((i & 2) != 0) {
            list = color4Shader.colorSpaceData;
        }
        return color4Shader.copy(color4f, list);
    }

    /* renamed from: component1, reason: from getter */
    public final Color4f getColor4f() {
        return this.color4f;
    }

    public final List<Integer> component2() {
        return this.colorSpaceData;
    }

    public final Color4Shader copy(Color4f color4f, List<Integer> colorSpaceData) {
        Intrinsics.checkNotNullParameter(color4f, "color4f");
        return new Color4Shader(color4f, colorSpaceData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Color4Shader)) {
            return false;
        }
        Color4Shader color4Shader = (Color4Shader) other;
        return Intrinsics.areEqual(this.color4f, color4Shader.color4f) && Intrinsics.areEqual(this.colorSpaceData, color4Shader.colorSpaceData);
    }

    public final Color4f getColor4f() {
        return this.color4f;
    }

    public final List<Integer> getColorSpaceData() {
        return this.colorSpaceData;
    }

    @Override // com.microsoft.clarity.models.display.paints.shaders.Shader
    public ShaderType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.color4f.hashCode() * 31;
        List<Integer> list = this.colorSpaceData;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "Color4Shader(color4f=" + this.color4f + ", colorSpaceData=" + this.colorSpaceData + ')';
    }

    public Color4Shader(Color4f color4f, List<Integer> list) {
        Intrinsics.checkNotNullParameter(color4f, "color4f");
        this.color4f = color4f;
        this.colorSpaceData = list;
        this.type = ShaderType.Color4Shader;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Shader toProtobufInstance() {
        Y a2 = MutationPayload$Shader.newBuilder().a(getType().toProtobufType()).a(this.color4f.toProtobufInstance());
        if (this.colorSpaceData != null) {
            a2.a((MutationPayload$IntList) MutationPayload$IntList.newBuilder().a(this.colorSpaceData).build());
        }
        GeneratedMessageLite build = a2.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$Shader) build;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Shader copy2() {
        ArrayList arrayList;
        Color4f copy2 = this.color4f.copy2();
        List<Integer> list = this.colorSpaceData;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((Number) it.next()).intValue()));
            }
        } else {
            arrayList = null;
        }
        return new Color4Shader(copy2, arrayList);
    }
}
