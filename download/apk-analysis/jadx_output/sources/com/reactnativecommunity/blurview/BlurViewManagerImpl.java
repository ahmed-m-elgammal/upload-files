package com.reactnativecommunity.blurview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ThemedReactContext;
import eightbitlab.com.blurview.BlurView;
import java.util.Objects;
import javax.annotation.Nonnull;

/* loaded from: classes5.dex */
class BlurViewManagerImpl {
    public static final String REACT_CLASS = "AndroidBlurView";
    public static final int defaultRadius = 10;
    public static final int defaultSampling = 10;

    public static void setDownsampleFactor(BlurView blurView, int i) {
    }

    BlurViewManagerImpl() {
    }

    @Nonnull
    public static BlurView createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        BlurView blurView = new BlurView(themedReactContext);
        View decorView = ((Activity) Objects.requireNonNull(themedReactContext.getCurrentActivity())).getWindow().getDecorView();
        blurView.setupWith((ViewGroup) decorView.findViewById(android.R.id.content)).setFrameClearDrawable(decorView.getBackground()).setBlurRadius(10.0f);
        return blurView;
    }

    public static void setRadius(BlurView blurView, int i) {
        blurView.setBlurRadius(i);
        blurView.invalidate();
    }

    public static void setColor(BlurView blurView, int i) {
        blurView.setOverlayColor(i);
        blurView.invalidate();
    }

    public static void setAutoUpdate(BlurView blurView, boolean z) {
        blurView.setBlurAutoUpdate(z);
        blurView.invalidate();
    }

    public static void setBlurEnabled(BlurView blurView, boolean z) {
        blurView.setBlurEnabled(z);
    }
}
