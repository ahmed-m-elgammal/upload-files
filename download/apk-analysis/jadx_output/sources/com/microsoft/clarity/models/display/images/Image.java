package com.microsoft.clarity.models.display.images;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.i.C0107a;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.common.Asset;
import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.protomodels.mutationpayload.C0130t;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\u0012\u0004\u0012\u00020\u00000\u0004B/\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/microsoft/clarity/models/display/images/Image;", "Lcom/microsoft/clarity/models/display/common/Asset;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Image;", "Lcom/microsoft/clarity/models/ICopyable;", "Lcom/microsoft/clarity/models/display/common/IRect;", "subset", "Lcom/microsoft/clarity/i/a;", "data", "", "dataHash", "", "mipmap", "<init>", "(Lcom/microsoft/clarity/models/display/common/IRect;Lcom/microsoft/clarity/i/a;Ljava/lang/String;[B)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "toProtobufInstance", "()Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Image;", "copy", "()Lcom/microsoft/clarity/models/display/images/Image;", "copyWithNullData", "Lcom/microsoft/clarity/models/display/common/IRect;", "[B", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Image extends Asset implements IProtoModel<MutationPayload$Image>, ICopyable<Image> {
    private final byte[] mipmap;
    private final IRect subset;

    public Image(IRect iRect, C0107a c0107a, String str, byte[] bArr) {
        super(AssetType.Image, c0107a, str);
        this.subset = iRect;
        this.mipmap = bArr;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(Image.class, other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(toString(), other.toString());
    }

    public String toString() {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder("Image(" + this.subset + ", byteArrayOf(");
        C0107a data = getData();
        if (data != null) {
            i = data.c;
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        while (i2 < i) {
            C0107a data2 = getData();
            sb.append(data2 != null ? Integer.valueOf(data2.f169a[data2.b + i2]) : null);
            i2++;
        }
        sb.append("), ");
        if (this.mipmap == null) {
            sb.append("null, ");
        } else {
            sb.append("byteArrayOf(");
            for (byte b : this.mipmap) {
                sb.append((int) b);
            }
            sb.append("), ");
        }
        sb.append(getDataHash());
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "str.toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Image copy2() {
        IRect iRect = this.subset;
        return new Image(iRect != null ? iRect.copy2() : null, getData(), getDataHash(), this.mipmap);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public Image copyWithNullData() {
        IRect iRect = this.subset;
        return new Image(iRect != null ? iRect.copy2() : null, null, getDataHash(), this.mipmap);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Image toProtobufInstance() {
        C0130t newBuilder = MutationPayload$Image.newBuilder();
        if (getDataHash() != null) {
            newBuilder.a(getDataHash());
        }
        IRect iRect = this.subset;
        if (iRect != null) {
            newBuilder.a(iRect.toProtobufInstance());
        }
        byte[] bArr = this.mipmap;
        if (bArr != null) {
            newBuilder.a(ByteString.copyFrom(bArr));
        }
        GeneratedMessageLite build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$Image) build;
    }
}
