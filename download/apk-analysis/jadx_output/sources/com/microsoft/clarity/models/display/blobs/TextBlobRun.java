package com.microsoft.clarity.models.display.blobs;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.common.Point;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FloatList;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$TextBlobRun;
import com.microsoft.clarity.protomodels.mutationpayload.d0;
import io.sentry.rrweb.RRWebInteractionMoveEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003Bs\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u0010\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010)J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0017\u00103\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u0010HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\b\u00106\u001a\u00020\u0000H\u0016J\u008e\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u000bHÖ\u0001J\b\u0010=\u001a\u00020\u0002H\u0016J\t\u0010>\u001a\u00020\u0013HÖ\u0001R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R(\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u001fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006?"}, d2 = {"Lcom/microsoft/clarity/models/display/blobs/TextBlobRun;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$TextBlobRun;", "Lcom/microsoft/clarity/models/ICopyable;", "point", "Lcom/microsoft/clarity/models/display/common/Point;", "fontSize", "", "fontScaleX", "fontSkewX", "typefaceIndex", "", "glyphs", "", "", RRWebInteractionMoveEvent.JsonKeys.POSITIONS, "", "clusters", "text", "", "(Lcom/microsoft/clarity/models/display/common/Point;FLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getClusters", "()Ljava/util/List;", "getFontScaleX", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFontSize", "()F", "getFontSkewX", "getGlyphs", "setGlyphs", "(Ljava/util/List;)V", "getPoint", "()Lcom/microsoft/clarity/models/display/common/Point;", "getPositions", "setPositions", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getTypefaceIndex", "()Ljava/lang/Integer;", "setTypefaceIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/microsoft/clarity/models/display/common/Point;FLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/microsoft/clarity/models/display/blobs/TextBlobRun;", "equals", "", "other", "", "hashCode", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TextBlobRun implements IProtoModel<MutationPayload$TextBlobRun>, ICopyable<TextBlobRun> {
    private final List<Long> clusters;
    private final Float fontScaleX;
    private final float fontSize;
    private final Float fontSkewX;
    private List<Long> glyphs;
    private final Point point;
    private List<? extends List<Float>> positions;
    private String text;
    private Integer typefaceIndex;

    public TextBlobRun(Point point, float f, Float f2, Float f3, Integer num, List<Long> list, List<? extends List<Float>> list2, List<Long> list3, String str) {
        Intrinsics.checkNotNullParameter(point, "point");
        this.point = point;
        this.fontSize = f;
        this.fontScaleX = f2;
        this.fontSkewX = f3;
        this.typefaceIndex = num;
        this.glyphs = list;
        this.positions = list2;
        this.clusters = list3;
        this.text = str;
    }

    /* renamed from: component1, reason: from getter */
    public final Point getPoint() {
        return this.point;
    }

    /* renamed from: component2, reason: from getter */
    public final float getFontSize() {
        return this.fontSize;
    }

    /* renamed from: component3, reason: from getter */
    public final Float getFontScaleX() {
        return this.fontScaleX;
    }

    /* renamed from: component4, reason: from getter */
    public final Float getFontSkewX() {
        return this.fontSkewX;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getTypefaceIndex() {
        return this.typefaceIndex;
    }

    public final List<Long> component6() {
        return this.glyphs;
    }

    public final List<List<Float>> component7() {
        return this.positions;
    }

    public final List<Long> component8() {
        return this.clusters;
    }

    /* renamed from: component9, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final TextBlobRun copy(Point point, float fontSize, Float fontScaleX, Float fontSkewX, Integer typefaceIndex, List<Long> glyphs, List<? extends List<Float>> positions, List<Long> clusters, String text) {
        Intrinsics.checkNotNullParameter(point, "point");
        return new TextBlobRun(point, fontSize, fontScaleX, fontSkewX, typefaceIndex, glyphs, positions, clusters, text);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public TextBlobRun copyWithNullData() {
        return (TextBlobRun) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextBlobRun)) {
            return false;
        }
        TextBlobRun textBlobRun = (TextBlobRun) other;
        return Intrinsics.areEqual(this.point, textBlobRun.point) && Float.compare(this.fontSize, textBlobRun.fontSize) == 0 && Intrinsics.areEqual((Object) this.fontScaleX, (Object) textBlobRun.fontScaleX) && Intrinsics.areEqual((Object) this.fontSkewX, (Object) textBlobRun.fontSkewX) && Intrinsics.areEqual(this.typefaceIndex, textBlobRun.typefaceIndex) && Intrinsics.areEqual(this.glyphs, textBlobRun.glyphs) && Intrinsics.areEqual(this.positions, textBlobRun.positions) && Intrinsics.areEqual(this.clusters, textBlobRun.clusters) && Intrinsics.areEqual(this.text, textBlobRun.text);
    }

    public final List<Long> getClusters() {
        return this.clusters;
    }

    public final Float getFontScaleX() {
        return this.fontScaleX;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final Float getFontSkewX() {
        return this.fontSkewX;
    }

    public final List<Long> getGlyphs() {
        return this.glyphs;
    }

    public final Point getPoint() {
        return this.point;
    }

    public final List<List<Float>> getPositions() {
        return this.positions;
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getTypefaceIndex() {
        return this.typefaceIndex;
    }

    public int hashCode() {
        int floatToIntBits = (Float.floatToIntBits(this.fontSize) + (this.point.hashCode() * 31)) * 31;
        Float f = this.fontScaleX;
        int hashCode = (floatToIntBits + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.fontSkewX;
        int hashCode2 = (hashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
        Integer num = this.typefaceIndex;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<Long> list = this.glyphs;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<? extends List<Float>> list2 = this.positions;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Long> list3 = this.clusters;
        int hashCode6 = (hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str = this.text;
        return hashCode6 + (str != null ? str.hashCode() : 0);
    }

    public final void setGlyphs(List<Long> list) {
        this.glyphs = list;
    }

    public final void setPositions(List<? extends List<Float>> list) {
        this.positions = list;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTypefaceIndex(Integer num) {
        this.typefaceIndex = num;
    }

    public String toString() {
        return "TextBlobRun(point=" + this.point + ", fontSize=" + this.fontSize + ", fontScaleX=" + this.fontScaleX + ", fontSkewX=" + this.fontSkewX + ", typefaceIndex=" + this.typefaceIndex + ", glyphs=" + this.glyphs + ", positions=" + this.positions + ", clusters=" + this.clusters + ", text=" + this.text + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$TextBlobRun toProtobufInstance() {
        d0 b = MutationPayload$TextBlobRun.newBuilder().a(this.point.toProtobufInstance()).b(this.fontSize);
        String str = this.text;
        if (str != null) {
            b.a(str);
        }
        Float f = this.fontScaleX;
        if (f != null) {
            b.a(f.floatValue());
        }
        Float f2 = this.fontSkewX;
        if (f2 != null) {
            b.c(f2.floatValue());
        }
        Integer num = this.typefaceIndex;
        if (num != null) {
            Intrinsics.checkNotNull(num);
            b.a(num.intValue());
        }
        List<Long> list = this.glyphs;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Double.valueOf(((Number) it.next()).longValue()));
            }
            b.b(arrayList);
        }
        List<Long> list2 = this.clusters;
        if (list2 != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Double.valueOf(((Number) it2.next()).longValue()));
            }
            b.a(arrayList2);
        }
        List<? extends List<Float>> list3 = this.positions;
        if (list3 != null) {
            Intrinsics.checkNotNull(list3);
            Iterator<? extends List<Float>> it3 = list3.iterator();
            while (it3.hasNext()) {
                b.a((MutationPayload$FloatList) MutationPayload$FloatList.newBuilder().a(it3.next()).build());
            }
        }
        GeneratedMessageLite build = b.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$TextBlobRun) build;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public TextBlobRun copy2() {
        List list;
        List list2;
        Point copy2 = this.point.copy2();
        float f = this.fontSize;
        Float f2 = this.fontScaleX;
        Float f3 = this.fontSkewX;
        Integer num = this.typefaceIndex;
        List<Long> list3 = this.glyphs;
        ArrayList arrayList = null;
        if (list3 != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(((Number) it.next()).longValue()));
            }
            list = CollectionsKt.toMutableList((Collection) arrayList2);
        } else {
            list = null;
        }
        List<? extends List<Float>> list4 = this.positions;
        if (list4 != null) {
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                List list5 = (List) it2.next();
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                Iterator it3 = list5.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(Float.valueOf(((Number) it3.next()).floatValue()));
                }
                arrayList3.add(arrayList4);
            }
            list2 = CollectionsKt.toMutableList((Collection) arrayList3);
        } else {
            list2 = null;
        }
        List<Long> list6 = this.clusters;
        if (list6 != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
            Iterator<T> it4 = list6.iterator();
            while (it4.hasNext()) {
                arrayList.add(Long.valueOf(((Number) it4.next()).longValue()));
            }
        }
        return new TextBlobRun(copy2, f, f2, f3, num, list, list2, arrayList, this.text);
    }
}
