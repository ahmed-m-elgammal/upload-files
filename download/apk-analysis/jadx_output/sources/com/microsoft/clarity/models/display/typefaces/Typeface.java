package com.microsoft.clarity.models.display.typefaces;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.i.C0107a;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.common.Asset;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Typeface;
import com.microsoft.clarity.protomodels.mutationpayload.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\u0012\u0004\u0012\u00020\u00000\u0004B\u008f\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001f\u0010\u001eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b#\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b$\u0010\"R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010+\u001a\u0004\b.\u0010-R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u0010\u0010+\u001a\u0004\b/\u0010-R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b0\u0010-R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b1\u0010*R\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/microsoft/clarity/models/display/typefaces/Typeface;", "Lcom/microsoft/clarity/models/display/common/Asset;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Typeface;", "Lcom/microsoft/clarity/models/ICopyable;", "", "familyName", "fullName", "postscriptName", "Lcom/microsoft/clarity/models/display/typefaces/FontStyle;", "style", "", "collectionIndex", "", "weightValue", "widthValue", "slantValue", "italicValue", "paletteIndex", "", "Lcom/microsoft/clarity/models/display/typefaces/FontCoordinate;", "coordinates", "Lcom/microsoft/clarity/i/a;", "data", "dataHash", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/clarity/models/display/typefaces/FontStyle;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;Ljava/util/List;Lcom/microsoft/clarity/i/a;Ljava/lang/String;)V", "toProtobufInstance", "()Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Typeface;", "copy", "()Lcom/microsoft/clarity/models/display/typefaces/Typeface;", "copyWithNullData", "Ljava/lang/String;", "getFamilyName", "()Ljava/lang/String;", "getFullName", "getPostscriptName", "Lcom/microsoft/clarity/models/display/typefaces/FontStyle;", "getStyle", "()Lcom/microsoft/clarity/models/display/typefaces/FontStyle;", "Ljava/lang/Long;", "getCollectionIndex", "()Ljava/lang/Long;", "Ljava/lang/Float;", "getWeightValue", "()Ljava/lang/Float;", "getWidthValue", "getSlantValue", "getItalicValue", "getPaletteIndex", "Ljava/util/List;", "getCoordinates", "()Ljava/util/List;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Typeface extends Asset implements IProtoModel<MutationPayload$Typeface>, ICopyable<Typeface> {
    private final Long collectionIndex;
    private final List<FontCoordinate> coordinates;
    private final String familyName;
    private final String fullName;
    private final Float italicValue;
    private final Long paletteIndex;
    private final String postscriptName;
    private final Float slantValue;
    private final FontStyle style;
    private final Float weightValue;
    private final Float widthValue;

    public /* synthetic */ Typeface(String str, String str2, String str3, FontStyle fontStyle, Long l, Float f, Float f2, Float f3, Float f4, Long l2, List list, C0107a c0107a, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, fontStyle, l, f, f2, f3, f4, l2, list, c0107a, (i & 4096) != 0 ? null : str4);
    }

    public final Long getCollectionIndex() {
        return this.collectionIndex;
    }

    public final List<FontCoordinate> getCoordinates() {
        return this.coordinates;
    }

    public final String getFamilyName() {
        return this.familyName;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final Float getItalicValue() {
        return this.italicValue;
    }

    public final Long getPaletteIndex() {
        return this.paletteIndex;
    }

    public final String getPostscriptName() {
        return this.postscriptName;
    }

    public final Float getSlantValue() {
        return this.slantValue;
    }

    public final FontStyle getStyle() {
        return this.style;
    }

    public final Float getWeightValue() {
        return this.weightValue;
    }

    public final Float getWidthValue() {
        return this.widthValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Typeface(String str, String str2, String str3, FontStyle style, Long l, Float f, Float f2, Float f3, Float f4, Long l2, List<FontCoordinate> list, C0107a c0107a, String str4) {
        super(AssetType.Typeface, c0107a, str4);
        Intrinsics.checkNotNullParameter(style, "style");
        this.familyName = str;
        this.fullName = str2;
        this.postscriptName = str3;
        this.style = style;
        this.collectionIndex = l;
        this.weightValue = f;
        this.widthValue = f2;
        this.slantValue = f3;
        this.italicValue = f4;
        this.paletteIndex = l2;
        this.coordinates = list;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Typeface copy2() {
        ArrayList arrayList;
        String str = this.familyName;
        String str2 = this.fullName;
        String str3 = this.postscriptName;
        FontStyle copy2 = this.style.copy2();
        Long l = this.collectionIndex;
        Float f = this.weightValue;
        Float f2 = this.widthValue;
        Float f3 = this.slantValue;
        Float f4 = this.italicValue;
        Long l2 = this.paletteIndex;
        List<FontCoordinate> list = this.coordinates;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((FontCoordinate) it.next()).copy2());
            }
        } else {
            arrayList = null;
        }
        return new Typeface(str, str2, str3, copy2, l, f, f2, f3, f4, l2, arrayList, getData(), getDataHash());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public Typeface copyWithNullData() {
        ArrayList arrayList;
        String str = this.familyName;
        String str2 = this.fullName;
        String str3 = this.postscriptName;
        FontStyle copy2 = this.style.copy2();
        Long l = this.collectionIndex;
        Float f = this.weightValue;
        Float f2 = this.widthValue;
        Float f3 = this.slantValue;
        Float f4 = this.italicValue;
        Long l2 = this.paletteIndex;
        List<FontCoordinate> list = this.coordinates;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((FontCoordinate) it.next()).copy2());
            }
        } else {
            arrayList = null;
        }
        return new Typeface(str, str2, str3, copy2, l, f, f2, f3, f4, l2, arrayList, null, getDataHash());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Typeface toProtobufInstance() {
        f0 a2 = MutationPayload$Typeface.newBuilder().a(this.style.toProtobufInstance());
        if (getDataHash() != null) {
            a2.a(getDataHash());
        }
        String str = this.familyName;
        if (str != null) {
            a2.b(str);
        }
        String str2 = this.fullName;
        if (str2 != null) {
            a2.c(str2);
        }
        String str3 = this.postscriptName;
        if (str3 != null) {
            a2.d(str3);
        }
        if (this.collectionIndex != null) {
            a2.a(r1.longValue());
        }
        List<FontCoordinate> list = this.coordinates;
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((FontCoordinate) it.next()).toProtobufInstance());
            }
            a2.a(arrayList);
        }
        Float f = this.weightValue;
        if (f != null) {
            a2.c(f.floatValue());
        }
        Float f2 = this.widthValue;
        if (f2 != null) {
            a2.d(f2.floatValue());
        }
        Float f3 = this.slantValue;
        if (f3 != null) {
            a2.b(f3.floatValue());
        }
        Float f4 = this.italicValue;
        if (f4 != null) {
            a2.a(f4.floatValue());
        }
        if (this.paletteIndex != null) {
            a2.b(r1.longValue());
        }
        GeneratedMessageLite build = a2.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$Typeface) build;
    }
}
