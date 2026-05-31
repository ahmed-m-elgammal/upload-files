package io.sentry.android.replay.viewhierarchy;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.TextUnit;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayOptions;
import io.sentry.android.replay.SentryReplayModifiers;
import io.sentry.android.replay.util.ComposeTextLayout;
import io.sentry.android.replay.util.NodesKt;
import io.sentry.android.replay.util.TextAttributes;
import io.sentry.android.replay.util.ViewsKt;
import io.sentry.android.replay.viewhierarchy.ViewHierarchyNode;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ComposeViewHierarchyNode.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0017\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0002\b!J\u001e\u0010\"\u001a\u00020\r*\u0004\u0018\u00010\u001f2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010#\u001a\u00020$*\u00020\u00112\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lio/sentry/android/replay/viewhierarchy/ComposeViewHierarchyNode;", "", "()V", "_rootCoordinates", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getSemanticsConfigurationMethod", "Ljava/lang/reflect/Method;", "getGetSemanticsConfigurationMethod", "()Ljava/lang/reflect/Method;", "getSemanticsConfigurationMethod$delegate", "Lkotlin/Lazy;", "semanticsRetrievalErrorLogged", "", "fromComposeNode", "Lio/sentry/android/replay/viewhierarchy/ViewHierarchyNode;", "node", "Landroidx/compose/ui/node/LayoutNode;", "parent", "distance", "", "isComposeRoot", "options", "Lio/sentry/SentryOptions;", "fromView", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "getProxyClassName", "", "isImage", "config", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "retrieveSemanticsConfiguration", "retrieveSemanticsConfiguration$sentry_android_replay_release", "shouldMask", "traverse", "", "parentNode", "sentry-android-replay_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ComposeViewHierarchyNode {
    private static WeakReference<LayoutCoordinates> _rootCoordinates;
    private static boolean semanticsRetrievalErrorLogged;
    public static final ComposeViewHierarchyNode INSTANCE = new ComposeViewHierarchyNode();

    /* renamed from: getSemanticsConfigurationMethod$delegate, reason: from kotlin metadata */
    private static final Lazy getSemanticsConfigurationMethod = LazyKt.lazy(new Function0<Method>() { // from class: io.sentry.android.replay.viewhierarchy.ComposeViewHierarchyNode$getSemanticsConfigurationMethod$2
        @Override // kotlin.jvm.functions.Function0
        public final Method invoke() {
            try {
                Method declaredMethod = LayoutNode.class.getDeclaredMethod("getSemanticsConfiguration", null);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
                return null;
            }
        }
    });

    private ComposeViewHierarchyNode() {
    }

    private final Method getGetSemanticsConfigurationMethod() {
        return (Method) getSemanticsConfigurationMethod.getValue();
    }

    @JvmStatic
    public static final SemanticsConfiguration retrieveSemanticsConfiguration$sentry_android_replay_release(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        Method getSemanticsConfigurationMethod2 = INSTANCE.getGetSemanticsConfigurationMethod();
        if (getSemanticsConfigurationMethod2 != null) {
            return (SemanticsConfiguration) getSemanticsConfigurationMethod2.invoke(node, null);
        }
        return node.getCollapsedSemantics$ui_release();
    }

    private final String getProxyClassName(boolean isImage, SemanticsConfiguration config) {
        if (isImage) {
            return SentryReplayOptions.IMAGE_VIEW_CLASS_NAME;
        }
        return (config == null || !(config.contains(SemanticsProperties.INSTANCE.getText()) || config.contains(SemanticsActions.INSTANCE.getSetText()) || config.contains(SemanticsProperties.INSTANCE.getEditableText()))) ? "android.view.View" : SentryReplayOptions.TEXT_VIEW_CLASS_NAME;
    }

    private final boolean shouldMask(SemanticsConfiguration semanticsConfiguration, boolean z, SentryOptions sentryOptions) {
        String str = semanticsConfiguration != null ? (String) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SentryReplayModifiers.INSTANCE.getSentryPrivacy()) : null;
        if (Intrinsics.areEqual(str, "unmask")) {
            return false;
        }
        if (Intrinsics.areEqual(str, "mask")) {
            return true;
        }
        String proxyClassName = getProxyClassName(z, semanticsConfiguration);
        if (sentryOptions.getSessionReplay().getUnmaskViewClasses().contains(proxyClassName)) {
            return false;
        }
        return sentryOptions.getSessionReplay().getMaskViewClasses().contains(proxyClassName);
    }

    private final ViewHierarchyNode fromComposeNode(LayoutNode node, ViewHierarchyNode parent, int distance, boolean isComposeRoot, SentryOptions options) {
        TextLayoutInput layoutInput;
        TextStyle style;
        TextLayoutInput layoutInput2;
        TextStyle style2;
        AccessibilityAction accessibilityAction;
        Function1 function1;
        if (!node.isPlaced() || !node.isAttached()) {
            return null;
        }
        if (isComposeRoot) {
            _rootCoordinates = new WeakReference<>(LayoutCoordinatesKt.findRootCoordinates(node.getCoordinates()));
        }
        LayoutCoordinates coordinates = node.getCoordinates();
        WeakReference<LayoutCoordinates> weakReference = _rootCoordinates;
        Rect boundsInWindow = NodesKt.boundsInWindow(coordinates, weakReference != null ? weakReference.get() : null);
        try {
            SemanticsConfiguration retrieveSemanticsConfiguration$sentry_android_replay_release = retrieveSemanticsConfiguration$sentry_android_replay_release(node);
            boolean z = !node.getOuterCoordinator$ui_release().isTransparent() && (retrieveSemanticsConfiguration$sentry_android_replay_release == null || !retrieveSemanticsConfiguration$sentry_android_replay_release.contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) && boundsInWindow.height() > 0 && boundsInWindow.width() > 0;
            boolean z2 = (retrieveSemanticsConfiguration$sentry_android_replay_release != null && retrieveSemanticsConfiguration$sentry_android_replay_release.contains(SemanticsActions.INSTANCE.getSetText())) || (retrieveSemanticsConfiguration$sentry_android_replay_release != null && retrieveSemanticsConfiguration$sentry_android_replay_release.contains(SemanticsProperties.INSTANCE.getEditableText()));
            if ((retrieveSemanticsConfiguration$sentry_android_replay_release != null && retrieveSemanticsConfiguration$sentry_android_replay_release.contains(SemanticsProperties.INSTANCE.getText())) || z2) {
                boolean z3 = z && shouldMask(retrieveSemanticsConfiguration$sentry_android_replay_release, false, options);
                if (parent != null) {
                    parent.setImportantForCaptureToAncestors(true);
                }
                ArrayList arrayList = new ArrayList();
                if (retrieveSemanticsConfiguration$sentry_android_replay_release != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(retrieveSemanticsConfiguration$sentry_android_replay_release, SemanticsActions.INSTANCE.getGetTextLayoutResult())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                }
                TextAttributes findTextAttributes = NodesKt.findTextAttributes(node);
                Color color = findTextAttributes.getColor();
                boolean hasFillModifier = findTextAttributes.getHasFillModifier();
                TextLayoutResult textLayoutResult = (TextLayoutResult) CollectionsKt.firstOrNull((List) arrayList);
                Color color2 = (textLayoutResult == null || (layoutInput2 = textLayoutResult.getLayoutInput()) == null || (style2 = layoutInput2.getStyle()) == null) ? null : Color.box-impl(style2.getColor-0d7_KjU());
                if (color2 == null || color2.unbox-impl() != Color.Companion.getUnspecified-0d7_KjU()) {
                    color = color2;
                }
                TextUnit textUnit = (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null || (style = layoutInput.getStyle()) == null) ? null : TextUnit.box-impl(style.getFontSize-XSAIIZE());
                return new ViewHierarchyNode.TextViewHierarchyNode((textLayoutResult == null || z2 || (textUnit != null ? TextUnit.equals-impl0(textUnit.unbox-impl(), TextUnit.Companion.getUnspecified-XSAIIZE()) : false)) ? null : new ComposeTextLayout(textLayoutResult, hasFillModifier), color != null ? Integer.valueOf(ViewsKt.toOpaque(ColorKt.toArgb-8_81llA(color.unbox-impl()))) : null, 0, 0, boundsInWindow.left, boundsInWindow.top, node.getWidth(), node.getHeight(), parent != null ? parent.getElevation() : 0.0f, distance, parent, z3, true, z, boundsInWindow, 12, null);
            }
            Painter findPainter = NodesKt.findPainter(node);
            if (findPainter != null) {
                boolean z4 = z && shouldMask(retrieveSemanticsConfiguration$sentry_android_replay_release, true, options);
                if (parent != null) {
                    parent.setImportantForCaptureToAncestors(true);
                }
                return new ViewHierarchyNode.ImageViewHierarchyNode(boundsInWindow.left, boundsInWindow.top, node.getWidth(), node.getHeight(), parent != null ? parent.getElevation() : 0.0f, distance, parent, z4 && NodesKt.isMaskable(findPainter), true, z, boundsInWindow);
            }
            return new ViewHierarchyNode.GenericViewHierarchyNode(boundsInWindow.left, boundsInWindow.top, node.getWidth(), node.getHeight(), parent != null ? parent.getElevation() : 0.0f, distance, parent, z && shouldMask(retrieveSemanticsConfiguration$sentry_android_replay_release, false, options), false, z, boundsInWindow);
        } catch (Throwable th) {
            if (!semanticsRetrievalErrorLogged) {
                semanticsRetrievalErrorLogged = true;
                options.getLogger().log(SentryLevel.ERROR, th, "Error retrieving semantics information from Compose tree. Most likely you're using\nan unsupported version of androidx.compose.ui:ui. The supported\nversion range is 1.5.0 - 1.8.0.\nIf you're using a newer version, please open a github issue with the version\nyou're using, so we can add support for it.", new Object[0]);
            }
            return new ViewHierarchyNode.GenericViewHierarchyNode(boundsInWindow.left, boundsInWindow.top, node.getWidth(), node.getHeight(), parent != null ? parent.getElevation() : 0.0f, distance, parent, true, false, !node.getOuterCoordinator$ui_release().isTransparent() && boundsInWindow.height() > 0 && boundsInWindow.width() > 0, boundsInWindow);
        }
    }

    public final boolean fromView(View view, ViewHierarchyNode parent, SentryOptions options) {
        LayoutNode root;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(options, "options");
        String name = view.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "view::class.java.name");
        if (!StringsKt.contains$default((CharSequence) name, (CharSequence) "AndroidComposeView", false, 2, (Object) null) || parent == null) {
            return false;
        }
        try {
            Owner owner = view instanceof Owner ? (Owner) view : null;
            if (owner != null && (root = owner.getRoot()) != null) {
                traverse(root, parent, true, options);
                return true;
            }
            return false;
        } catch (Throwable th) {
            options.getLogger().log(SentryLevel.ERROR, th, "Error traversing Compose tree. Most likely you're using an unsupported version of\nandroidx.compose.ui:ui. The minimum supported version is 1.5.0. If it's a newer\nversion, please open a github issue with the version you're using, so we can add\nsupport for it.", new Object[0]);
            return false;
        }
    }

    private final void traverse(LayoutNode layoutNode, ViewHierarchyNode viewHierarchyNode, boolean z, SentryOptions sentryOptions) {
        List children$ui_release = layoutNode.getChildren$ui_release();
        if (children$ui_release.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(children$ui_release.size());
        int size = children$ui_release.size();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = (LayoutNode) children$ui_release.get(i);
            ViewHierarchyNode fromComposeNode = fromComposeNode(layoutNode2, viewHierarchyNode, i, z, sentryOptions);
            if (fromComposeNode != null) {
                arrayList.add(fromComposeNode);
                traverse(layoutNode2, fromComposeNode, false, sentryOptions);
            }
        }
        viewHierarchyNode.setChildren(arrayList);
    }
}
