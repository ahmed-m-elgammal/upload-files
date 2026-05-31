package expo.modules.devmenu.fab;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReactContext;
import expo.interfaces.devmenu.DevMenuManagerInterface;
import expo.interfaces.devmenu.ReactHostWrapper;
import expo.modules.devmenu.DevMenuManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MovableFloatingActionButton.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0006\u0010\u0017\u001a\u00020\u0007J(\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0014J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lexpo/modules/devmenu/fab/MovableFloatingActionButton;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "updateSystemGestureExclusionRects", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "dX", "", "dY", "downRawX", "downRawY", "eventRegion", "Landroid/graphics/Region;", "isActive", "", "stencilPath", "Landroid/graphics/Path;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "onClick", "onSizeChanged", "w", "", CmcdData.Factory.STREAMING_FORMAT_HLS, "oldw", "oldh", "onTouch", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "motionEvent", "Landroid/view/MotionEvent;", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MovableFloatingActionButton extends FrameLayout implements View.OnTouchListener {
    private float dX;
    private float dY;
    private float downRawX;
    private float downRawY;
    private Region eventRegion;
    private boolean isActive;
    private final Path stencilPath;
    private final Function0<Unit> updateSystemGestureExclusionRects;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovableFloatingActionButton(Context context, Function0<Unit> updateSystemGestureExclusionRects) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updateSystemGestureExclusionRects, "updateSystemGestureExclusionRects");
        this.updateSystemGestureExclusionRects = updateSystemGestureExclusionRects;
        this.stencilPath = new Path();
        this.eventRegion = new Region();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(150, 150);
        layoutParams.gravity = 8388693;
        layoutParams.setMargins(24, 24, 24, 24);
        setLayoutParams(layoutParams);
        setZ(Float.MAX_VALUE);
        setOnTouchListener(this);
        View view = new View(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        view.setLayoutParams(layoutParams2);
        view.setBackgroundColor(-65281);
        addView(view);
    }

    public final void onClick() {
        ReactContext currentReactContext;
        Activity currentActivity;
        ReactHostWrapper reactHost = DevMenuManager.INSTANCE.getReactHost();
        if (reactHost == null || (currentReactContext = reactHost.getCurrentReactContext()) == null || (currentActivity = currentReactContext.getCurrentActivity()) == null) {
            return;
        }
        DevMenuManagerInterface.DefaultImpls.openMenu$default(DevMenuManager.INSTANCE, currentActivity, null, 2, null);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float f;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!this.eventRegion.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
            this.downRawX = motionEvent.getRawX();
            this.downRawY = motionEvent.getRawY();
            this.dX = view.getX() - this.downRawX;
            this.dY = view.getY() - this.downRawY;
            this.isActive = true;
            return true;
        }
        if (action != 1) {
            if (action == 2 || action == 4) {
                if (!this.isActive) {
                    return false;
                }
                int width = view.getWidth();
                int height = view.getHeight();
                Object parent = view.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                View view2 = (View) parent;
                int width2 = view2.getWidth();
                int height2 = view2.getHeight();
                view.animate().x((float) Math.min((width2 - width) - marginLayoutParams.rightMargin, (float) Math.max(marginLayoutParams.leftMargin, motionEvent.getRawX() + this.dX))).y((float) Math.min((height2 - height) - marginLayoutParams.bottomMargin, (float) Math.max(marginLayoutParams.topMargin, motionEvent.getRawY() + this.dY))).setDuration(0L).start();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (!this.isActive) {
            return false;
        }
        this.isActive = false;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f2 = rawX - this.downRawX;
        float f3 = rawY - this.downRawY;
        if (Math.abs(f2) < 10.0d && Math.abs(f3) < 10.0d) {
            onClick();
        } else {
            int width3 = view.getWidth();
            float x = view.getX() + (width3 / 2);
            Object parent2 = view.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
            int width4 = ((View) parent2).getWidth();
            if (x < width4 / 2) {
                f = marginLayoutParams.leftMargin;
            } else {
                f = (width4 - width3) - marginLayoutParams.rightMargin;
            }
            view.animate().x(f).setDuration(100L).scaleX(1.0f).scaleY(1.0f).withEndAction(new Runnable() { // from class: expo.modules.devmenu.fab.MovableFloatingActionButton$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MovableFloatingActionButton.onTouch$lambda$3(MovableFloatingActionButton.this);
                }
            }).start();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTouch$lambda$3(MovableFloatingActionButton this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateSystemGestureExclusionRects.invoke();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.stencilPath.reset();
        float f = w;
        float f2 = h;
        this.stencilPath.addRoundRect(0.0f, 0.0f, f, f2, f, f2, Path.Direction.CW);
        this.stencilPath.close();
        RectF rectF = new RectF();
        this.stencilPath.computeBounds(rectF, true);
        Region region = new Region();
        this.eventRegion = region;
        region.setPath(this.stencilPath, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        canvas.clipPath(this.stencilPath);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }
}
