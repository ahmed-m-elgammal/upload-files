package com.microsoft.clarity.models.display.commands;

import com.google.protobuf.GeneratedMessageLite;
import com.henninghall.date_picker.props.ModeProp;
import com.microsoft.clarity.protomodels.mutationpayload.C0118g;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FloatList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\b¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0000H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001f\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawVertices;", "Lcom/microsoft/clarity/models/display/commands/PaintableCommand;", "verticesIndex", "", ModeProp.name, "", "paintIndex", "bones", "", "", "(IJILjava/util/List;)V", "getBones", "()Ljava/util/List;", "getMode", "()J", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getVerticesIndex", "()I", "setVerticesIndex", "(I)V", "copy", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DrawVertices extends PaintableCommand {
    private final List<List<Float>> bones;
    private final long mode;
    private final DisplayCommandType type;
    private int verticesIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public DrawVertices(int i, long j, int i2, List<? extends List<Float>> list) {
        super(i2);
        this.verticesIndex = i;
        this.mode = j;
        this.bones = list;
        this.type = DisplayCommandType.DrawVertices;
    }

    public final List<List<Float>> getBones() {
        return this.bones;
    }

    public final long getMode() {
        return this.mode;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    public final int getVerticesIndex() {
        return this.verticesIndex;
    }

    public final void setVerticesIndex(int i) {
        this.verticesIndex = i;
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public DisplayCommand copy2() {
        ArrayList arrayList;
        int i = this.verticesIndex;
        long j = this.mode;
        int paintIndex = getPaintIndex();
        List<List<Float>> list = this.bones;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                List list2 = (List) it.next();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Float.valueOf(((Number) it2.next()).floatValue()));
                }
                arrayList.add(arrayList2);
            }
        } else {
            arrayList = null;
        }
        return new DrawVertices(i, j, paintIndex, arrayList);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        C0118g j = MutationPayload$DisplayCommand.newBuilder().a(getType().toProtobufType()).m(this.verticesIndex).b(this.mode).j(getPaintIndex());
        List list = this.bones;
        if (list == null) {
            list = new ArrayList();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j.a((MutationPayload$FloatList) MutationPayload$FloatList.newBuilder().a((List) it.next()).build());
        }
        GeneratedMessageLite build = j.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$DisplayCommand) build;
    }
}
