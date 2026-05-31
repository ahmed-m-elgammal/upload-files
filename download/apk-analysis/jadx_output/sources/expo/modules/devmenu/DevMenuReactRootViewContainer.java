package expo.modules.devmenu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.devmenu.fab.MovableFloatingActionButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuReactRootViewContainer.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J0\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lexpo/modules/devmenu/DevMenuReactRootViewContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fab", "Lexpo/modules/devmenu/fab/MovableFloatingActionButton;", "getFab", "()Lexpo/modules/devmenu/fab/MovableFloatingActionButton;", "fab$delegate", "Lkotlin/Lazy;", "updateSystemGestureExclusionRects", "Lkotlin/Function0;", "", "addView", "child", "Landroid/view/View;", "index", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", ViewProps.ON_LAYOUT, "changed", "left", "top", "right", ViewProps.BOTTOM, "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevMenuReactRootViewContainer extends FrameLayout {

    /* renamed from: fab$delegate, reason: from kotlin metadata */
    private final Lazy fab;
    private final Function0<Unit> updateSystemGestureExclusionRects;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevMenuReactRootViewContainer(final Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.updateSystemGestureExclusionRects = new Function0<Unit>() { // from class: expo.modules.devmenu.DevMenuReactRootViewContainer$updateSystemGestureExclusionRects$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MovableFloatingActionButton fab;
                MovableFloatingActionButton fab2;
                MovableFloatingActionButton fab3;
                MovableFloatingActionButton fab4;
                MovableFloatingActionButton fab5;
                MovableFloatingActionButton fab6;
                MovableFloatingActionButton fab7;
                fab = DevMenuReactRootViewContainer.this.getFab();
                ViewGroup.LayoutParams layoutParams = fab.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                fab2 = DevMenuReactRootViewContainer.this.getFab();
                int x = ((int) fab2.getX()) - marginLayoutParams.leftMargin;
                fab3 = DevMenuReactRootViewContainer.this.getFab();
                int y = ((int) fab3.getY()) - marginLayoutParams.bottomMargin;
                fab4 = DevMenuReactRootViewContainer.this.getFab();
                int x2 = (int) fab4.getX();
                fab5 = DevMenuReactRootViewContainer.this.getFab();
                int width = x2 + fab5.getWidth() + marginLayoutParams.rightMargin;
                fab6 = DevMenuReactRootViewContainer.this.getFab();
                int y2 = (int) fab6.getY();
                fab7 = DevMenuReactRootViewContainer.this.getFab();
                ViewCompat.setSystemGestureExclusionRects(DevMenuReactRootViewContainer.this, CollectionsKt.listOf(new Rect(x, y, width, y2 + fab7.getHeight() + marginLayoutParams.topMargin)));
            }
        };
        this.fab = LazyKt.lazy(new Function0<MovableFloatingActionButton>() { // from class: expo.modules.devmenu.DevMenuReactRootViewContainer$fab$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MovableFloatingActionButton invoke() {
                Context context2 = context;
                final DevMenuReactRootViewContainer devMenuReactRootViewContainer = this;
                return new MovableFloatingActionButton(context2, new Function0<Unit>() { // from class: expo.modules.devmenu.DevMenuReactRootViewContainer$fab$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function0 function0;
                        final DevMenuReactRootViewContainer devMenuReactRootViewContainer2 = DevMenuReactRootViewContainer.this;
                        DevMenuReactRootViewContainer devMenuReactRootViewContainer3 = devMenuReactRootViewContainer2;
                        if (ViewCompat.isLaidOut(devMenuReactRootViewContainer3) && !devMenuReactRootViewContainer3.isLayoutRequested()) {
                            function0 = devMenuReactRootViewContainer2.updateSystemGestureExclusionRects;
                            function0.invoke();
                        } else {
                            devMenuReactRootViewContainer3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: expo.modules.devmenu.DevMenuReactRootViewContainer$fab$2$1$invoke$$inlined$doOnLayout$1
                                @Override // android.view.View.OnLayoutChangeListener
                                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                                    Function0 function02;
                                    view.removeOnLayoutChangeListener(this);
                                    function02 = DevMenuReactRootViewContainer.this.updateSystemGestureExclusionRects;
                                    function02.invoke();
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MovableFloatingActionButton getFab() {
        return (MovableFloatingActionButton) this.fab.getValue();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.updateSystemGestureExclusionRects.invoke();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        DevMenuManager.INSTANCE.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
    }
}
