package com.microsoft.clarity.models.viewhierarchy;

import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$ViewHierarchy;
import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bs\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\b\u0010,\u001a\u00020\u0002H\u0016R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&¨\u0006-"}, d2 = {"Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$ViewHierarchy;", "timestamp", "", CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID, "Lcom/microsoft/clarity/models/viewhierarchy/ViewNode;", "visibleFragments", "", "", "screenMetadata", "Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "webViewsData", "", "Lcom/microsoft/clarity/models/viewhierarchy/WebViewData;", "staleRenderNodeIds", "maskedViewRenderNodeIds", "", "", "unmaskedViewRenderNodeIds", "focusedEditTextInfo", "Lcom/microsoft/clarity/models/viewhierarchy/EditTextInfo;", "(JLcom/microsoft/clarity/models/viewhierarchy/ViewNode;Ljava/util/Set;Lcom/microsoft/clarity/models/observers/ScreenMetadata;Ljava/util/List;Ljava/util/List;Ljava/util/Set;Ljava/util/Set;Lcom/microsoft/clarity/models/viewhierarchy/EditTextInfo;)V", "getFocusedEditTextInfo", "()Lcom/microsoft/clarity/models/viewhierarchy/EditTextInfo;", "getMaskedViewRenderNodeIds", "()Ljava/util/Set;", "getRoot", "()Lcom/microsoft/clarity/models/viewhierarchy/ViewNode;", "rootDelta", "Lcom/microsoft/clarity/models/viewhierarchy/ViewNodeDelta;", "getRootDelta", "()Lcom/microsoft/clarity/models/viewhierarchy/ViewNodeDelta;", "setRootDelta", "(Lcom/microsoft/clarity/models/viewhierarchy/ViewNodeDelta;)V", "getScreenMetadata", "()Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "getStaleRenderNodeIds", "()Ljava/util/List;", "getTimestamp", "()J", "getUnmaskedViewRenderNodeIds", "getVisibleFragments", "getWebViewsData", "toProtobufInstance", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewHierarchy implements IProtoModel<MutationPayload$ViewHierarchy> {
    private final transient EditTextInfo focusedEditTextInfo;
    private final transient Set<Integer> maskedViewRenderNodeIds;
    private final transient ViewNode root;
    public ViewNodeDelta rootDelta;
    private final transient ScreenMetadata screenMetadata;
    private final transient List<Long> staleRenderNodeIds;
    private final long timestamp;
    private final transient Set<Integer> unmaskedViewRenderNodeIds;
    private final Set<String> visibleFragments;
    private final transient List<WebViewData> webViewsData;

    public ViewHierarchy(long j, ViewNode root, Set<String> visibleFragments, ScreenMetadata screenMetadata, List<WebViewData> webViewsData, List<Long> staleRenderNodeIds, Set<Integer> maskedViewRenderNodeIds, Set<Integer> unmaskedViewRenderNodeIds, EditTextInfo editTextInfo) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(visibleFragments, "visibleFragments");
        Intrinsics.checkNotNullParameter(webViewsData, "webViewsData");
        Intrinsics.checkNotNullParameter(staleRenderNodeIds, "staleRenderNodeIds");
        Intrinsics.checkNotNullParameter(maskedViewRenderNodeIds, "maskedViewRenderNodeIds");
        Intrinsics.checkNotNullParameter(unmaskedViewRenderNodeIds, "unmaskedViewRenderNodeIds");
        this.timestamp = j;
        this.root = root;
        this.visibleFragments = visibleFragments;
        this.screenMetadata = screenMetadata;
        this.webViewsData = webViewsData;
        this.staleRenderNodeIds = staleRenderNodeIds;
        this.maskedViewRenderNodeIds = maskedViewRenderNodeIds;
        this.unmaskedViewRenderNodeIds = unmaskedViewRenderNodeIds;
        this.focusedEditTextInfo = editTextInfo;
    }

    public final EditTextInfo getFocusedEditTextInfo() {
        return this.focusedEditTextInfo;
    }

    public final Set<Integer> getMaskedViewRenderNodeIds() {
        return this.maskedViewRenderNodeIds;
    }

    public final ViewNode getRoot() {
        return this.root;
    }

    public final ViewNodeDelta getRootDelta() {
        ViewNodeDelta viewNodeDelta = this.rootDelta;
        if (viewNodeDelta != null) {
            return viewNodeDelta;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootDelta");
        return null;
    }

    public final ScreenMetadata getScreenMetadata() {
        return this.screenMetadata;
    }

    public final List<Long> getStaleRenderNodeIds() {
        return this.staleRenderNodeIds;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Set<Integer> getUnmaskedViewRenderNodeIds() {
        return this.unmaskedViewRenderNodeIds;
    }

    public final Set<String> getVisibleFragments() {
        return this.visibleFragments;
    }

    public final List<WebViewData> getWebViewsData() {
        return this.webViewsData;
    }

    public final void setRootDelta(ViewNodeDelta viewNodeDelta) {
        Intrinsics.checkNotNullParameter(viewNodeDelta, "<set-?>");
        this.rootDelta = viewNodeDelta;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$ViewHierarchy toProtobufInstance() {
        GeneratedMessageLite build = MutationPayload$ViewHierarchy.newBuilder().a(getRootDelta().toProtobufInstance()).a(this.timestamp).a(this.visibleFragments).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …nts)\n            .build()");
        return (MutationPayload$ViewHierarchy) build;
    }

    public /* synthetic */ ViewHierarchy(long j, ViewNode viewNode, Set set, ScreenMetadata screenMetadata, List list, List list2, Set set2, Set set3, EditTextInfo editTextInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, viewNode, set, (i & 8) != 0 ? null : screenMetadata, (i & 16) != 0 ? CollectionsKt.emptyList() : list, list2, set2, set3, editTextInfo);
    }
}
