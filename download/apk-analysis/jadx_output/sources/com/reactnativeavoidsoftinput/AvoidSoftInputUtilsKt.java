package com.reactnativeavoidsoftinput;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvoidSoftInputUtils.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\u001a\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0016\u001a\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a3\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142#\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c¨\u0006 "}, d2 = {"checkIfNestedInAvoidSoftInputView", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "rootView", "Lcom/facebook/react/uimanager/RootView;", "convertFromPixelToDIP", "", "to", "getEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "context", "Lcom/facebook/react/bridge/ReactContext;", "getNearestParentReactRootView", "getReactContext", "getReactRootView", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "getRootViewBottomInset", "getScrollViewParent", "Landroid/widget/ScrollView;", "getSurfaceId", "Landroid/content/Context;", "getViewDistanceToBottomEdge", "setScrollListenerCompat", "", "scrollView", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "scrollY", "react-native-avoid-softinput_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvoidSoftInputUtilsKt {
    public static final ScrollView getScrollViewParent(View view, View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (view == null || Intrinsics.areEqual(view.getParent(), rootView) || !(view.getParent() instanceof View)) {
            return null;
        }
        if (view.getParent() instanceof ScrollView) {
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.ScrollView");
            return (ScrollView) parent;
        }
        Object parent2 = view.getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
        return getScrollViewParent((View) parent2, rootView);
    }

    public static final boolean checkIfNestedInAvoidSoftInputView(View view, RootView rootView) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getParent() == null || Intrinsics.areEqual(view.getParent(), rootView) || !(view.getParent() instanceof View)) {
            return false;
        }
        if (view.getParent() instanceof AvoidSoftInputView) {
            return true;
        }
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        return checkIfNestedInAvoidSoftInputView((View) parent, rootView);
    }

    public static final int convertFromPixelToDIP(int i) {
        return (int) PixelUtil.toDIPFromPixel(i);
    }

    public static final RootView getReactRootView(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Activity currentActivity = reactContext.getCurrentActivity();
        Object obj = null;
        if (currentActivity == null) {
            return null;
        }
        View decorView = currentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        Iterator<View> it = ViewKt.getAllViews(decorView).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            View next = it.next();
            if (next instanceof RootView) {
                obj = next;
                break;
            }
        }
        return (RootView) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final RootView getNearestParentReactRootView(View view) {
        View view2 = view;
        while (view2 != 0) {
            if (view2 instanceof RootView) {
                return (RootView) view2;
            }
            Object parent = view2.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view2 = (View) parent;
        }
        return null;
    }

    public static final int getRootViewBottomInset(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        Insets insets = rootWindowInsets != null ? rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars()) : null;
        if (insets != null) {
            return insets.bottom;
        }
        return 0;
    }

    public static final int getViewDistanceToBottomEdge(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return (DisplayMetricsHolder.getScreenDisplayMetrics().heightPixels - (iArr[1] + view.getHeight())) - getRootViewBottomInset(view);
    }

    public static final void setScrollListenerCompat(ScrollView scrollView, final Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.reactnativeavoidsoftinput.AvoidSoftInputUtilsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                AvoidSoftInputUtilsKt.setScrollListenerCompat$lambda$1(Function1.this, view, i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setScrollListenerCompat$lambda$1(Function1 function1, View view, int i, int i2, int i3, int i4) {
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    public static final EventDispatcher getEventDispatcher(ReactContext context, View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        return UIManagerHelper.getEventDispatcherForReactTag(context, view.getId());
    }

    public static final ReactContext getReactContext(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ReactContext reactContext = UIManagerHelper.getReactContext(view);
        Intrinsics.checkNotNullExpressionValue(reactContext, "getReactContext(...)");
        return reactContext;
    }

    public static final int getSurfaceId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UIManagerHelper.getSurfaceId(context);
    }
}
