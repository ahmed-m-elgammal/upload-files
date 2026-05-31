package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.ViewManager;
import com.swmansion.reanimated.ReactNativeUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes5.dex */
public class Snapshot {
    public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
    public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
    public static final String BORDER_RADIUS = "borderRadius";
    public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
    public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
    public static final String CURRENT_TRANSFORM_MATRIX = "currentTransformMatrix";
    public static final String GLOBAL_ORIGIN_X = "globalOriginX";
    public static final String GLOBAL_ORIGIN_Y = "globalOriginY";
    public static final String HEIGHT = "height";
    public static final String ORIGIN_X = "originX";
    public static final String ORIGIN_Y = "originY";
    public static final String TARGET_TRANSFORM_MATRIX = "targetTransformMatrix";
    public static final String TRANSFORM_MATRIX = "transformMatrix";
    public static final String WIDTH = "width";
    public ReactNativeUtils.BorderRadii borderRadii;
    public int globalOriginX;
    public int globalOriginY;
    public int height;
    private float[] identityMatrix;
    public int originX;
    public int originXByParent;
    public int originY;
    public int originYByParent;
    public ViewGroup parent;
    public ViewManager parentViewManager;
    public List<Float> transformMatrix;
    public View view;
    public ViewManager viewManager;
    public int width;
    public static final String TARGET_WIDTH = "targetWidth";
    public static final String TARGET_HEIGHT = "targetHeight";
    public static final String TARGET_ORIGIN_X = "targetOriginX";
    public static final String TARGET_ORIGIN_Y = "targetOriginY";
    public static final String TARGET_GLOBAL_ORIGIN_X = "targetGlobalOriginX";
    public static final String TARGET_GLOBAL_ORIGIN_Y = "targetGlobalOriginY";
    public static final String TARGET_BORDER_RADIUS = "targetBorderRadius";
    public static final String TARGET_BORDER_TOP_LEFT_RADIUS = "targetBorderTopLeftRadius";
    public static final String TARGET_BORDER_TOP_RIGHT_RADIUS = "targetBorderTopRightRadius";
    public static final String TARGET_BORDER_BOTTOM_LEFT_RADIUS = "targetBorderBottomLeftRadius";
    public static final String TARGET_BORDER_BOTTOM_RIGHT_RADIUS = "targetBorderBottomRightRadius";
    public static ArrayList<String> targetKeysToTransform = new ArrayList<>(Arrays.asList(TARGET_WIDTH, TARGET_HEIGHT, TARGET_ORIGIN_X, TARGET_ORIGIN_Y, TARGET_GLOBAL_ORIGIN_X, TARGET_GLOBAL_ORIGIN_Y, TARGET_BORDER_RADIUS, TARGET_BORDER_TOP_LEFT_RADIUS, TARGET_BORDER_TOP_RIGHT_RADIUS, TARGET_BORDER_BOTTOM_LEFT_RADIUS, TARGET_BORDER_BOTTOM_RIGHT_RADIUS));
    public static final String CURRENT_WIDTH = "currentWidth";
    public static final String CURRENT_HEIGHT = "currentHeight";
    public static final String CURRENT_ORIGIN_X = "currentOriginX";
    public static final String CURRENT_ORIGIN_Y = "currentOriginY";
    public static final String CURRENT_GLOBAL_ORIGIN_X = "currentGlobalOriginX";
    public static final String CURRENT_GLOBAL_ORIGIN_Y = "currentGlobalOriginY";
    public static final String CURRENT_BORDER_RADIUS = "currentBorderRadius";
    public static final String CURRENT_BORDER_TOP_LEFT_RADIUS = "currentBorderTopLeftRadius";
    public static final String CURRENT_BORDER_TOP_RIGHT_RADIUS = "currentBorderTopRightRadius";
    public static final String CURRENT_BORDER_BOTTOM_LEFT_RADIUS = "currentBorderBottomLeftRadius";
    public static final String CURRENT_BORDER_BOTTOM_RIGHT_RADIUS = "currentBorderBottomRightRadius";
    public static ArrayList<String> currentKeysToTransform = new ArrayList<>(Arrays.asList(CURRENT_WIDTH, CURRENT_HEIGHT, CURRENT_ORIGIN_X, CURRENT_ORIGIN_Y, CURRENT_GLOBAL_ORIGIN_X, CURRENT_GLOBAL_ORIGIN_Y, CURRENT_BORDER_RADIUS, CURRENT_BORDER_TOP_LEFT_RADIUS, CURRENT_BORDER_TOP_RIGHT_RADIUS, CURRENT_BORDER_BOTTOM_LEFT_RADIUS, CURRENT_BORDER_BOTTOM_RIGHT_RADIUS));

    Snapshot(View view, NativeViewHierarchyManager nativeViewHierarchyManager) {
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        this.transformMatrix = new ArrayList(Arrays.asList(valueOf, valueOf2, valueOf2, valueOf2, valueOf, valueOf2, valueOf2, valueOf2, valueOf));
        this.identityMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.parent = (ViewGroup) view.getParent();
        try {
            this.viewManager = nativeViewHierarchyManager.resolveViewManager(view.getId());
            this.parentViewManager = nativeViewHierarchyManager.resolveViewManager(this.parent.getId());
        } catch (IllegalViewOperationException | NullPointerException unused) {
        }
        this.width = view.getWidth();
        this.height = view.getHeight();
        this.originX = view.getLeft();
        this.originY = view.getTop();
        this.view = view;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.globalOriginX = iArr[0];
        this.globalOriginY = iArr[1];
        this.borderRadii = new ReactNativeUtils.BorderRadii(0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    private int[] tryGetRealPosition(View view) {
        int[] iArr = new int[2];
        while (view != null) {
            iArr[0] = (int) (iArr[0] + view.getX());
            iArr[1] = (int) (iArr[1] + view.getY());
            if (ScreensHelper.isScreen(view) && ScreensHelper.isScreensCoordinatorLayout(view.getParent())) {
                try {
                    view = (View) view.getClass().getMethod("getContainer", null).invoke(view, null);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                }
            } else {
                if (!(view.getParent() instanceof View)) {
                    break;
                }
                view = (View) view.getParent();
            }
        }
        return iArr;
    }

    public Snapshot(View view) {
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        this.transformMatrix = new ArrayList(Arrays.asList(valueOf, valueOf2, valueOf2, valueOf2, valueOf, valueOf2, valueOf2, valueOf2, valueOf));
        this.identityMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            iArr = tryGetRealPosition(view);
        }
        this.originX = iArr[0];
        this.originY = iArr[1];
        this.width = view.getWidth();
        this.height = view.getHeight();
        View findTransformedView = findTransformedView(view);
        if (findTransformedView != null) {
            float[] fArr = new float[9];
            findTransformedView.getMatrix().getValues(fArr);
            this.transformMatrix = new ArrayList();
            for (int i = 0; i < 9; i++) {
                this.transformMatrix.add(Float.valueOf(fArr[i]));
            }
            this.transformMatrix.set(0, Float.valueOf(findTransformedView.getScaleX()));
            this.transformMatrix.set(4, Float.valueOf(findTransformedView.getScaleY()));
            this.transformMatrix.set(2, Float.valueOf(findTransformedView.getTranslationX()));
            this.transformMatrix.set(5, Float.valueOf(findTransformedView.getTranslationY()));
            float f = this.originX;
            int i2 = this.width;
            this.originX = (int) (f - ((i2 - (i2 * findTransformedView.getScaleX())) / 2.0f));
            float f2 = this.originY;
            int i3 = this.height;
            this.originY = (int) (f2 - ((i3 - (i3 * findTransformedView.getScaleY())) / 2.0f));
        }
        this.originXByParent = view.getLeft();
        this.originYByParent = view.getTop();
        this.borderRadii = ReactNativeUtils.getBorderRadii(view);
    }

    private void addTargetConfig(HashMap<String, Object> hashMap) {
        hashMap.put(TARGET_ORIGIN_Y, Integer.valueOf(this.originY));
        hashMap.put(TARGET_ORIGIN_X, Integer.valueOf(this.originX));
        hashMap.put(TARGET_GLOBAL_ORIGIN_Y, Integer.valueOf(this.globalOriginY));
        hashMap.put(TARGET_GLOBAL_ORIGIN_X, Integer.valueOf(this.globalOriginX));
        hashMap.put(TARGET_HEIGHT, Integer.valueOf(this.height));
        hashMap.put(TARGET_WIDTH, Integer.valueOf(this.width));
        hashMap.put(TARGET_TRANSFORM_MATRIX, this.transformMatrix);
        hashMap.put(TARGET_BORDER_RADIUS, Float.valueOf(this.borderRadii.full));
        hashMap.put(TARGET_BORDER_TOP_LEFT_RADIUS, Float.valueOf(this.borderRadii.topLeft));
        hashMap.put(TARGET_BORDER_TOP_RIGHT_RADIUS, Float.valueOf(this.borderRadii.topRight));
        hashMap.put(TARGET_BORDER_BOTTOM_LEFT_RADIUS, Float.valueOf(this.borderRadii.bottomLeft));
        hashMap.put(TARGET_BORDER_BOTTOM_RIGHT_RADIUS, Float.valueOf(this.borderRadii.bottomRight));
    }

    private void addCurrentConfig(HashMap<String, Object> hashMap) {
        hashMap.put(CURRENT_ORIGIN_Y, Integer.valueOf(this.originY));
        hashMap.put(CURRENT_ORIGIN_X, Integer.valueOf(this.originX));
        hashMap.put(CURRENT_GLOBAL_ORIGIN_Y, Integer.valueOf(this.globalOriginY));
        hashMap.put(CURRENT_GLOBAL_ORIGIN_X, Integer.valueOf(this.globalOriginX));
        hashMap.put(CURRENT_HEIGHT, Integer.valueOf(this.height));
        hashMap.put(CURRENT_WIDTH, Integer.valueOf(this.width));
        hashMap.put(CURRENT_TRANSFORM_MATRIX, this.transformMatrix);
        hashMap.put(CURRENT_BORDER_RADIUS, Float.valueOf(this.borderRadii.full));
        hashMap.put(CURRENT_BORDER_TOP_LEFT_RADIUS, Float.valueOf(this.borderRadii.topLeft));
        hashMap.put(CURRENT_BORDER_TOP_RIGHT_RADIUS, Float.valueOf(this.borderRadii.topRight));
        hashMap.put(CURRENT_BORDER_BOTTOM_LEFT_RADIUS, Float.valueOf(this.borderRadii.bottomLeft));
        hashMap.put(CURRENT_BORDER_BOTTOM_RIGHT_RADIUS, Float.valueOf(this.borderRadii.bottomRight));
    }

    private void addBasicConfig(HashMap<String, Object> hashMap) {
        hashMap.put(ORIGIN_Y, Integer.valueOf(this.originY));
        hashMap.put(ORIGIN_X, Integer.valueOf(this.originX));
        hashMap.put(GLOBAL_ORIGIN_Y, Integer.valueOf(this.globalOriginY));
        hashMap.put(GLOBAL_ORIGIN_X, Integer.valueOf(this.globalOriginX));
        hashMap.put("height", Integer.valueOf(this.height));
        hashMap.put("width", Integer.valueOf(this.width));
        hashMap.put(TRANSFORM_MATRIX, this.transformMatrix);
        hashMap.put("borderRadius", Float.valueOf(this.borderRadii.full));
        hashMap.put("borderTopLeftRadius", Float.valueOf(this.borderRadii.topLeft));
        hashMap.put("borderTopRightRadius", Float.valueOf(this.borderRadii.topRight));
        hashMap.put("borderBottomLeftRadius", Float.valueOf(this.borderRadii.bottomLeft));
        hashMap.put("borderBottomRightRadius", Float.valueOf(this.borderRadii.bottomRight));
    }

    public HashMap<String, Object> toTargetMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        addTargetConfig(hashMap);
        return hashMap;
    }

    public HashMap<String, Object> toCurrentMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        addCurrentConfig(hashMap);
        return hashMap;
    }

    public HashMap<String, Object> toBasicMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        addBasicConfig(hashMap);
        return hashMap;
    }

    private View findTransformedView(View view) {
        boolean z;
        boolean z2 = false;
        View view2 = null;
        while (true) {
            if (view2 == null) {
                view2 = view;
            } else {
                if (!(view2.getParent() instanceof View)) {
                    break;
                }
                view2 = (View) view2.getParent();
            }
            if (view2 == null) {
                break;
            }
            float[] fArr = new float[9];
            view2.getMatrix().getValues(fArr);
            boolean equals = Arrays.equals(fArr, this.identityMatrix);
            z = !equals;
            if (!equals || view2 == null || view2.getClass().getSimpleName().equals("Screen")) {
                break;
            }
            z2 = z;
        }
        z2 = z;
        if (!z2 || view2 == null) {
            return null;
        }
        return view2;
    }
}
