package com.microsoft.clarity.models.display.common;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0002\u0010\u0005B%\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007J\b\u0010\u0015\u001a\u00020\u0000H\u0016J\u0013\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0000J\b\u0010\u001a\u001a\u00020\u0000H\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/microsoft/clarity/models/display/common/Rect;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Rect;", "Lcom/microsoft/clarity/models/ICopyable;", "rect", "(Lcom/microsoft/clarity/models/display/common/Rect;)V", "left", "", "top", "right", ViewProps.BOTTOM, "(FFFF)V", "getBottom", "()F", "getLeft", "getRight", "getTop", "contains", "", "x", "y", "copy", "equals", "other", "", "intersects", "makeSorted", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class Rect implements IProtoModel<MutationPayload$Rect>, ICopyable<Rect> {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public Rect(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public final boolean contains(float x, float y) {
        float f = this.left;
        if (x <= this.right && f <= x) {
            float f2 = this.top;
            if (y <= this.bottom && f2 <= y) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.ICopyable
    public Rect copyWithNullData() {
        return (Rect) ICopyable.DefaultImpls.copyWithNullData(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(getClass(), other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(toString(), other.toString());
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public final boolean intersects(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return this.right > rect.left && this.left < rect.right && this.bottom > rect.top && this.top < rect.bottom;
    }

    public final Rect makeSorted() {
        return new Rect(Math.min(this.left, this.right), Math.min(this.top, this.bottom), Math.max(this.left, this.right), Math.max(this.top, this.bottom));
    }

    public String toString() {
        return "Rect(" + this.left + "F, " + this.top + "F, " + this.right + "F, " + this.bottom + "F)";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rect(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        Intrinsics.checkNotNullParameter(rect, "rect");
    }

    @Override // com.microsoft.clarity.models.ICopyable
    /* renamed from: copy */
    public Rect copy2() {
        return new Rect(this.left, this.top, this.right, this.bottom);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Rect toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$Rect.newBuilder().a(this.bottom).b(this.left).c(this.right).d(this.top).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …top)\n            .build()");
        return (MutationPayload$Rect) build;
    }
}
