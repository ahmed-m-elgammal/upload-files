package com.swmansion.reanimated;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.react.views.view.ReactViewBackgroundDrawable;
import com.swmansion.reanimated.ReactNativeUtils;

/* loaded from: classes5.dex */
public class BorderRadiiDrawableUtils {
    public static ReactNativeUtils.BorderRadii getBorderRadii(View view) {
        Drawable background = view.getBackground();
        if (background instanceof ReactViewBackgroundDrawable) {
            ReactViewBackgroundDrawable reactViewBackgroundDrawable = (ReactViewBackgroundDrawable) background;
            return new ReactNativeUtils.BorderRadii(reactViewBackgroundDrawable.getFullBorderRadius(), reactViewBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_LEFT), reactViewBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_RIGHT), reactViewBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_LEFT), reactViewBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_RIGHT));
        }
        return new ReactNativeUtils.BorderRadii(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }
}
