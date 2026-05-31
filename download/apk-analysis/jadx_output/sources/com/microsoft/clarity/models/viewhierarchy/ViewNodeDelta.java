package com.microsoft.clarity.models.viewhierarchy;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$ViewNodeDelta;
import com.microsoft.clarity.protomodels.mutationpayload.l0;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\b\u0000\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%BË\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u001bJ\u0014\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00000#J\b\u0010$\u001a\u00020\u0002H\u0016R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006&"}, d2 = {"Lcom/microsoft/clarity/models/viewhierarchy/ViewNodeDelta;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$ViewNodeDelta;", "renderNodeId", "", "id", "", "type", "", "x", "y", "width", "height", "viewX", "viewY", "viewWidth", "viewHeight", ViewProps.VISIBLE, "", "clickable", "ignoreClicks", "isWebView", "isMasked", "isBackgroundColorSet", "backgroundColor", "idEntryName", "text", "(JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Integer;", ViewHierarchyNode.JsonKeys.CHILDREN, "", "Ljava/lang/Boolean;", "addChildren", "", "viewNodeDeltas", "", "toProtobufInstance", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewNodeDelta implements IProtoModel<MutationPayload$ViewNodeDelta> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer backgroundColor;
    private final List<ViewNodeDelta> children;
    private final Boolean clickable;
    private final Integer height;
    private final Integer id;
    private final String idEntryName;
    private final Boolean ignoreClicks;
    private final boolean isBackgroundColorSet;
    private final Boolean isMasked;
    private final Boolean isWebView;
    private final long renderNodeId;
    private final String text;
    private final String type;
    private final Integer viewHeight;
    private final Integer viewWidth;
    private final Integer viewX;
    private final Integer viewY;
    private final Boolean visible;
    private final Integer width;
    private final Integer x;
    private final Integer y;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J1\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u0001H\t2\u0006\u0010\f\u001a\u0002H\tH\u0002¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/microsoft/clarity/models/viewhierarchy/ViewNodeDelta$Companion;", "", "()V", "build", "Lcom/microsoft/clarity/models/viewhierarchy/ViewNodeDelta;", "viewNode", "Lcom/microsoft/clarity/models/viewhierarchy/ViewNode;", "previousViewNode", "getNewValueIfDifferentOrNull", ExifInterface.GPS_DIRECTION_TRUE, "previousNode", "oldValue", "newValue", "(Lcom/microsoft/clarity/models/viewhierarchy/ViewNode;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final <T> T getNewValueIfDifferentOrNull(ViewNode previousNode, T oldValue, T newValue) {
            if (previousNode == null || !Intrinsics.areEqual(oldValue, newValue)) {
                return newValue;
            }
            return null;
        }

        public final ViewNodeDelta build(ViewNode viewNode, ViewNode previousViewNode) {
            Integer backgroundColor;
            boolean z;
            boolean z2;
            String str;
            String str2;
            String str3;
            Intrinsics.checkNotNullParameter(viewNode, "viewNode");
            long renderNodeId = viewNode.getRenderNodeId();
            Integer num = (Integer) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Integer.valueOf(previousViewNode.getId()) : null, Integer.valueOf(viewNode.getId()));
            String str4 = (String) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? previousViewNode.getType() : null, viewNode.getType());
            Integer num2 = (Integer) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Integer.valueOf(previousViewNode.getX()) : null, Integer.valueOf(viewNode.getX()));
            Integer num3 = (Integer) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Integer.valueOf(previousViewNode.getY()) : null, Integer.valueOf(viewNode.getY()));
            Integer num4 = (Integer) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Integer.valueOf(previousViewNode.getWidth()) : null, Integer.valueOf(viewNode.getWidth()));
            Integer num5 = (Integer) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Integer.valueOf(previousViewNode.getHeight()) : null, Integer.valueOf(viewNode.getHeight()));
            Integer num6 = (Integer) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Integer.valueOf(previousViewNode.getViewX()) : null, Integer.valueOf(viewNode.getViewX()));
            Integer num7 = (Integer) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Integer.valueOf(previousViewNode.getViewY()) : null, Integer.valueOf(viewNode.getViewY()));
            Integer num8 = (Integer) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Integer.valueOf(previousViewNode.getViewWidth()) : null, Integer.valueOf(viewNode.getViewWidth()));
            Integer num9 = (Integer) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Integer.valueOf(previousViewNode.getViewHeight()) : null, Integer.valueOf(viewNode.getViewHeight()));
            Boolean bool = (Boolean) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Boolean.valueOf(previousViewNode.getVisible()) : null, Boolean.valueOf(viewNode.getVisible()));
            Boolean bool2 = (Boolean) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Boolean.valueOf(previousViewNode.getClickable()) : null, Boolean.valueOf(viewNode.getClickable()));
            Boolean bool3 = (Boolean) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Boolean.valueOf(previousViewNode.getIgnoreClicks()) : null, Boolean.valueOf(viewNode.getIgnoreClicks()));
            Boolean bool4 = (Boolean) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Boolean.valueOf(previousViewNode.getIsWebView()) : null, Boolean.valueOf(viewNode.getIsWebView()));
            Boolean bool5 = (Boolean) getNewValueIfDifferentOrNull(previousViewNode, previousViewNode != null ? Boolean.valueOf(previousViewNode.getIsMasked()) : null, Boolean.valueOf(viewNode.getIsMasked()));
            if (previousViewNode == null || !Intrinsics.areEqual(previousViewNode.getBackgroundColor(), viewNode.getBackgroundColor())) {
                backgroundColor = viewNode.getBackgroundColor();
                z = true;
            } else {
                z = false;
                backgroundColor = null;
            }
            if (previousViewNode != null) {
                str = previousViewNode.getIdEntryName();
                z2 = z;
            } else {
                z2 = z;
                str = null;
            }
            String str5 = (String) getNewValueIfDifferentOrNull(previousViewNode, str, viewNode.getIdEntryName());
            if (previousViewNode != null) {
                str3 = previousViewNode.getText();
                str2 = str5;
            } else {
                str2 = str5;
                str3 = null;
            }
            return new ViewNodeDelta(renderNodeId, num, str4, num2, num3, num4, num5, num6, num7, num8, num9, bool, bool2, bool3, bool4, bool5, z2, backgroundColor, str2, (String) getNewValueIfDifferentOrNull(previousViewNode, str3, viewNode.getText()), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ ViewNodeDelta(long j, Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, boolean z, Integer num10, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, num, str, num2, num3, num4, num5, num6, num7, num8, num9, bool, bool2, bool3, bool4, bool5, z, num10, str2, str3);
    }

    public final void addChildren(Collection<ViewNodeDelta> viewNodeDeltas) {
        Intrinsics.checkNotNullParameter(viewNodeDeltas, "viewNodeDeltas");
        this.children.addAll(viewNodeDeltas);
    }

    private ViewNodeDelta(long j, Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, boolean z, Integer num10, String str2, String str3) {
        this.renderNodeId = j;
        this.id = num;
        this.type = str;
        this.x = num2;
        this.y = num3;
        this.width = num4;
        this.height = num5;
        this.viewX = num6;
        this.viewY = num7;
        this.viewWidth = num8;
        this.viewHeight = num9;
        this.visible = bool;
        this.clickable = bool2;
        this.ignoreClicks = bool3;
        this.isWebView = bool4;
        this.isMasked = bool5;
        this.isBackgroundColorSet = z;
        this.backgroundColor = num10;
        this.idEntryName = str2;
        this.text = str3;
        this.children = new ArrayList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$ViewNodeDelta toProtobufInstance() {
        l0 newBuilder = MutationPayload$ViewNodeDelta.newBuilder();
        newBuilder.a(this.renderNodeId);
        Integer num = this.id;
        if (num != null) {
            newBuilder.c(num.intValue());
        }
        String str = this.type;
        if (str != null) {
            newBuilder.c(str);
        }
        Integer num2 = this.x;
        if (num2 != null) {
            newBuilder.i(num2.intValue());
        }
        Integer num3 = this.y;
        if (num3 != null) {
            newBuilder.j(num3.intValue());
        }
        Integer num4 = this.width;
        if (num4 != null) {
            newBuilder.h(num4.intValue());
        }
        Integer num5 = this.height;
        if (num5 != null) {
            newBuilder.b(num5.intValue());
        }
        Integer num6 = this.viewX;
        if (num6 != null) {
            newBuilder.f(num6.intValue());
        }
        Integer num7 = this.viewY;
        if (num7 != null) {
            newBuilder.g(num7.intValue());
        }
        Integer num8 = this.viewWidth;
        if (num8 != null) {
            newBuilder.e(num8.intValue());
        }
        Integer num9 = this.viewHeight;
        if (num9 != null) {
            newBuilder.d(num9.intValue());
        }
        Boolean bool = this.visible;
        if (bool != null) {
            newBuilder.e(bool.booleanValue());
        }
        Boolean bool2 = this.clickable;
        if (bool2 != null) {
            newBuilder.a(bool2.booleanValue());
        }
        Boolean bool3 = this.ignoreClicks;
        if (bool3 != null) {
            newBuilder.b(bool3.booleanValue());
        }
        Boolean bool4 = this.isWebView;
        if (bool4 != null) {
            newBuilder.d(bool4.booleanValue());
        }
        Boolean bool5 = this.isMasked;
        if (bool5 != null) {
            newBuilder.c(bool5.booleanValue());
        }
        if (this.isBackgroundColorSet) {
            newBuilder.a();
            Integer num10 = this.backgroundColor;
            if (num10 != null) {
                newBuilder.a(num10.intValue());
            }
        }
        String str2 = this.idEntryName;
        if (str2 != null) {
            newBuilder.a(str2);
        }
        String string = this.text;
        if (string != null) {
            Intrinsics.checkNotNullParameter(string, "string");
            newBuilder.b(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(string, "\\", "\\\\", false, 4, (Object) null), "\"", "\\\"", false, 4, (Object) null), IOUtils.LINE_SEPARATOR_WINDOWS, " ", false, 4, (Object) null), "\n", " ", false, 4, (Object) null));
        }
        List<ViewNodeDelta> list = this.children;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ViewNodeDelta) it.next()).toProtobufInstance());
        }
        newBuilder.a(arrayList);
        GeneratedMessageLite build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (MutationPayload$ViewNodeDelta) build;
    }
}
