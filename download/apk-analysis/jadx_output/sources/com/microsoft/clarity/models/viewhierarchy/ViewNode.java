package com.microsoft.clarity.models.viewhierarchy;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.ViewHierarchyNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\u000e\u0010G\u001a\u00020H2\u0006\u0010\u0016\u001a\u00020\u0000J\u0006\u0010I\u001a\u00020\u0011R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00000\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u001a\u00102\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\u0011\u0010\u0013\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u001a\u0010\u001b\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010(\"\u0004\b6\u00107R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010(R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010*R\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00100R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u00100R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u00100R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u00100R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bC\u0010(R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u00100R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00100R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00100¨\u0006J"}, d2 = {"Lcom/microsoft/clarity/models/viewhierarchy/ViewNode;", "", "id", "", "type", "", "renderNodeId", "", "x", "y", "width", "height", "viewX", "viewY", "viewWidth", "viewHeight", ViewProps.VISIBLE, "", "clickable", "ignoreClicks", "isWebView", "backgroundColor", ViewHierarchyConstants.VIEW_KEY, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "text", "contentDescription", "isMasked", "fragmentName", "(ILjava/lang/String;JIIIIIIIIZZZZLjava/lang/Integer;Ljava/lang/ref/WeakReference;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", ViewHierarchyNode.JsonKeys.CHILDREN, "", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getClickable", "()Z", "getContentDescription", "()Ljava/lang/String;", "setContentDescription", "(Ljava/lang/String;)V", "getFragmentName", "setFragmentName", "getHeight", "()I", "getId", "idEntryName", "getIdEntryName", "setIdEntryName", "getIgnoreClicks", "setMasked", "(Z)V", "getRenderNodeId", "()J", "getText", "setText", "getType", "getView", "()Ljava/lang/ref/WeakReference;", "getViewHeight", "getViewWidth", "getViewX", "getViewY", "getVisible", "getWidth", "getX", "getY", "addChildView", "", "isRoot", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewNode {
    private final Integer backgroundColor;
    private List<ViewNode> children;
    private final boolean clickable;
    private transient String contentDescription;
    private transient String fragmentName;
    private final int height;
    private final int id;
    private String idEntryName;
    private final boolean ignoreClicks;
    private boolean isMasked;
    private final boolean isWebView;
    private final long renderNodeId;
    private String text;
    private final String type;
    private final transient WeakReference<View> view;
    private final int viewHeight;
    private final int viewWidth;
    private final int viewX;
    private final int viewY;
    private final boolean visible;
    private final int width;
    private final int x;
    private final int y;

    public ViewNode(int i, String type, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, boolean z2, boolean z3, boolean z4, Integer num, WeakReference<View> weakReference, String text, String contentDescription, boolean z5, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        this.id = i;
        this.type = type;
        this.renderNodeId = j;
        this.x = i2;
        this.y = i3;
        this.width = i4;
        this.height = i5;
        this.viewX = i6;
        this.viewY = i7;
        this.viewWidth = i8;
        this.viewHeight = i9;
        this.visible = z;
        this.clickable = z2;
        this.ignoreClicks = z3;
        this.isWebView = z4;
        this.backgroundColor = num;
        this.view = weakReference;
        this.text = text;
        this.contentDescription = contentDescription;
        this.isMasked = z5;
        this.fragmentName = str;
        this.children = new ArrayList();
        this.idEntryName = "";
    }

    public final void addChildView(ViewNode view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.children.add(view);
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final List<ViewNode> getChildren() {
        return this.children;
    }

    public final boolean getClickable() {
        return this.clickable;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final String getFragmentName() {
        return this.fragmentName;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getId() {
        return this.id;
    }

    public final String getIdEntryName() {
        return this.idEntryName;
    }

    public final boolean getIgnoreClicks() {
        return this.ignoreClicks;
    }

    public final long getRenderNodeId() {
        return this.renderNodeId;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final WeakReference<View> getView() {
        return this.view;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final int getViewWidth() {
        return this.viewWidth;
    }

    public final int getViewX() {
        return this.viewX;
    }

    public final int getViewY() {
        return this.viewY;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    /* renamed from: isMasked, reason: from getter */
    public final boolean getIsMasked() {
        return this.isMasked;
    }

    public final boolean isRoot() {
        return this.id == 0;
    }

    /* renamed from: isWebView, reason: from getter */
    public final boolean getIsWebView() {
        return this.isWebView;
    }

    public final void setChildren(List<ViewNode> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.children = list;
    }

    public final void setContentDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contentDescription = str;
    }

    public final void setFragmentName(String str) {
        this.fragmentName = str;
    }

    public final void setIdEntryName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.idEntryName = str;
    }

    public final void setMasked(boolean z) {
        this.isMasked = z;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public /* synthetic */ ViewNode(int i, String str, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, boolean z2, boolean z3, boolean z4, Integer num, WeakReference weakReference, String str2, String str3, boolean z5, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, j, i2, i3, i4, i5, i6, i7, i8, i9, z, z2, z3, z4, (i10 & 32768) != 0 ? null : num, (i10 & 65536) != 0 ? null : weakReference, (i10 & 131072) != 0 ? "" : str2, (i10 & 262144) != 0 ? "" : str3, (i10 & 524288) != 0 ? false : z5, (i10 & 1048576) != 0 ? null : str4);
    }
}
