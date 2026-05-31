package com.microsoft.clarity.models.display;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.blobs.TextBlob;
import com.microsoft.clarity.models.display.commands.DisplayCommand;
import com.microsoft.clarity.models.display.common.Vertices;
import com.microsoft.clarity.models.display.images.Image;
import com.microsoft.clarity.models.display.paints.Paint;
import com.microsoft.clarity.models.display.paths.Path;
import com.microsoft.clarity.models.display.typefaces.Typeface;
import com.microsoft.clarity.protomodels.mutationpayload.C0122k;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayFrame;
import io.sentry.protocol.DebugMeta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bw\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001cJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u0006HÆ\u0003¢\u0006\u0004\b \u0010\u001cJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006HÆ\u0003¢\u0006\u0004\b!\u0010\u001cJ\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006HÆ\u0003¢\u0006\u0004\b\"\u0010\u001cJ\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006HÆ\u0003¢\u0006\u0004\b#\u0010\u001cJ\u0090\u0001\u0010$\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b/\u00100R(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00101\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u00104R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u00101\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u00104R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00101\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u00104R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00101\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u00104R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b;\u0010\u001cR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u00101\u001a\u0004\b<\u0010\u001cR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u00101\u001a\u0004\b=\u0010\u001cR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u00101\u001a\u0004\b>\u0010\u001c¨\u0006?"}, d2 = {"Lcom/microsoft/clarity/models/display/SubDisplayFrame;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayFrame;", "", "Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", "commands", "", "Lcom/microsoft/clarity/models/display/typefaces/Typeface;", "typefaces", "Lcom/microsoft/clarity/models/display/images/Image;", DebugMeta.JsonKeys.IMAGES, "Lcom/microsoft/clarity/models/display/blobs/TextBlob;", "textBlobs", "Lcom/microsoft/clarity/models/display/common/Vertices;", "vertices", "Lcom/microsoft/clarity/models/display/paints/Paint;", "paints", "Lcom/microsoft/clarity/models/display/paths/Path;", "paths", "subDisplayFrames", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "Lcom/microsoft/clarity/i/d;", "parseResult", "(Lcom/microsoft/clarity/i/d;)V", "toProtobufInstance", "()Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayFrame;", "component1", "()Ljava/util/List;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/microsoft/clarity/models/display/SubDisplayFrame;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getCommands", "setCommands", "(Ljava/util/List;)V", "getTypefaces", "setTypefaces", "getImages", "setImages", "getTextBlobs", "setTextBlobs", "getVertices", "getPaints", "getPaths", "getSubDisplayFrames", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SubDisplayFrame implements IProtoModel<MutationPayload$DisplayFrame> {
    private List<? extends DisplayCommand> commands;
    private List<Image> images;
    private final List<Paint> paints;
    private final List<Path> paths;
    private final List<SubDisplayFrame> subDisplayFrames;
    private List<TextBlob> textBlobs;
    private List<Typeface> typefaces;
    private final List<Vertices> vertices;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SubDisplayFrame(com.microsoft.clarity.i.C0110d r11) {
        /*
            r10 = this;
            java.lang.String r0 = "parseResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.util.List r2 = r11.f172a
            java.util.ArrayList r3 = r11.b
            java.util.ArrayList r4 = r11.c
            java.util.ArrayList r5 = r11.d
            java.util.ArrayList r6 = r11.e
            java.util.ArrayList r7 = r11.f
            java.util.ArrayList r8 = r11.g
            java.util.ArrayList r11 = r11.h
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r1)
            r0.<init>(r1)
            java.util.Iterator r11 = r11.iterator()
        L24:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L39
            java.lang.Object r1 = r11.next()
            com.microsoft.clarity.i.d r1 = (com.microsoft.clarity.i.C0110d) r1
            com.microsoft.clarity.models.display.SubDisplayFrame r9 = new com.microsoft.clarity.models.display.SubDisplayFrame
            r9.<init>(r1)
            r0.add(r9)
            goto L24
        L39:
            java.util.List r9 = kotlin.collections.CollectionsKt.toMutableList(r0)
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.models.display.SubDisplayFrame.<init>(com.microsoft.clarity.i.d):void");
    }

    public final List<DisplayCommand> component1() {
        return this.commands;
    }

    public final List<Typeface> component2() {
        return this.typefaces;
    }

    public final List<Image> component3() {
        return this.images;
    }

    public final List<TextBlob> component4() {
        return this.textBlobs;
    }

    public final List<Vertices> component5() {
        return this.vertices;
    }

    public final List<Paint> component6() {
        return this.paints;
    }

    public final List<Path> component7() {
        return this.paths;
    }

    public final List<SubDisplayFrame> component8() {
        return this.subDisplayFrames;
    }

    public final SubDisplayFrame copy(List<? extends DisplayCommand> commands, List<Typeface> typefaces, List<Image> images, List<TextBlob> textBlobs, List<Vertices> vertices, List<Paint> paints, List<Path> paths, List<SubDisplayFrame> subDisplayFrames) {
        Intrinsics.checkNotNullParameter(commands, "commands");
        Intrinsics.checkNotNullParameter(typefaces, "typefaces");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(textBlobs, "textBlobs");
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(subDisplayFrames, "subDisplayFrames");
        return new SubDisplayFrame(commands, typefaces, images, textBlobs, vertices, paints, paths, subDisplayFrames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubDisplayFrame)) {
            return false;
        }
        SubDisplayFrame subDisplayFrame = (SubDisplayFrame) other;
        return Intrinsics.areEqual(this.commands, subDisplayFrame.commands) && Intrinsics.areEqual(this.typefaces, subDisplayFrame.typefaces) && Intrinsics.areEqual(this.images, subDisplayFrame.images) && Intrinsics.areEqual(this.textBlobs, subDisplayFrame.textBlobs) && Intrinsics.areEqual(this.vertices, subDisplayFrame.vertices) && Intrinsics.areEqual(this.paints, subDisplayFrame.paints) && Intrinsics.areEqual(this.paths, subDisplayFrame.paths) && Intrinsics.areEqual(this.subDisplayFrames, subDisplayFrame.subDisplayFrames);
    }

    public final List<DisplayCommand> getCommands() {
        return this.commands;
    }

    public final List<Image> getImages() {
        return this.images;
    }

    public final List<Paint> getPaints() {
        return this.paints;
    }

    public final List<Path> getPaths() {
        return this.paths;
    }

    public final List<SubDisplayFrame> getSubDisplayFrames() {
        return this.subDisplayFrames;
    }

    public final List<TextBlob> getTextBlobs() {
        return this.textBlobs;
    }

    public final List<Typeface> getTypefaces() {
        return this.typefaces;
    }

    public final List<Vertices> getVertices() {
        return this.vertices;
    }

    public int hashCode() {
        return this.subDisplayFrames.hashCode() + ((this.paths.hashCode() + ((this.paints.hashCode() + ((this.vertices.hashCode() + ((this.textBlobs.hashCode() + ((this.images.hashCode() + ((this.typefaces.hashCode() + (this.commands.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final void setCommands(List<? extends DisplayCommand> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.commands = list;
    }

    public final void setImages(List<Image> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.images = list;
    }

    public final void setTextBlobs(List<TextBlob> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.textBlobs = list;
    }

    public final void setTypefaces(List<Typeface> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.typefaces = list;
    }

    public String toString() {
        return "SubDisplayFrame(commands=" + this.commands + ", typefaces=" + this.typefaces + ", images=" + this.images + ", textBlobs=" + this.textBlobs + ", vertices=" + this.vertices + ", paints=" + this.paints + ", paths=" + this.paths + ", subDisplayFrames=" + this.subDisplayFrames + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayFrame toProtobufInstance() {
        C0122k newBuilder = MutationPayload$DisplayFrame.newBuilder();
        List<? extends DisplayCommand> list = this.commands;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((DisplayCommand) it.next()).toProtobufInstance());
        }
        C0122k a2 = newBuilder.a(arrayList);
        List<Typeface> list2 = this.typefaces;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Typeface) it2.next()).toProtobufInstance());
        }
        C0122k b = a2.b(arrayList2);
        List<Image> list3 = this.images;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Image) it3.next()).toProtobufInstance());
        }
        C0122k a3 = b.a(CollectionsKt.toList(arrayList3));
        List<TextBlob> list4 = this.textBlobs;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it4 = list4.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((TextBlob) it4.next()).toProtobufInstance());
        }
        C0122k e = a3.e(CollectionsKt.toList(arrayList4));
        List<Vertices> list5 = this.vertices;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
        Iterator<T> it5 = list5.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((Vertices) it5.next()).toProtobufInstance());
        }
        C0122k f = e.f(CollectionsKt.toList(arrayList5));
        List<Paint> list6 = this.paints;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
        Iterator<T> it6 = list6.iterator();
        while (it6.hasNext()) {
            arrayList6.add(((Paint) it6.next()).toProtobufInstance());
        }
        C0122k b2 = f.b(CollectionsKt.toList(arrayList6));
        List<Path> list7 = this.paths;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
        Iterator<T> it7 = list7.iterator();
        while (it7.hasNext()) {
            arrayList7.add(((Path) it7.next()).toProtobufInstance());
        }
        C0122k c = b2.c(CollectionsKt.toList(arrayList7));
        List<SubDisplayFrame> list8 = this.subDisplayFrames;
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
        Iterator<T> it8 = list8.iterator();
        while (it8.hasNext()) {
            arrayList8.add(((SubDisplayFrame) it8.next()).toProtobufInstance());
        }
        GeneratedMessageLite build = c.d(CollectionsKt.toList(arrayList8)).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$DisplayFrame) build;
    }

    public SubDisplayFrame(List<? extends DisplayCommand> commands, List<Typeface> typefaces, List<Image> images, List<TextBlob> textBlobs, List<Vertices> vertices, List<Paint> paints, List<Path> paths, List<SubDisplayFrame> subDisplayFrames) {
        Intrinsics.checkNotNullParameter(commands, "commands");
        Intrinsics.checkNotNullParameter(typefaces, "typefaces");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(textBlobs, "textBlobs");
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(subDisplayFrames, "subDisplayFrames");
        this.commands = commands;
        this.typefaces = typefaces;
        this.images = images;
        this.textBlobs = textBlobs;
        this.vertices = vertices;
        this.paints = paints;
        this.paths = paths;
        this.subDisplayFrames = subDisplayFrames;
    }
}
