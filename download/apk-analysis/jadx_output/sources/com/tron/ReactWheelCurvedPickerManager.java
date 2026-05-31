package com.tron;

import android.graphics.Color;
import android.os.Handler;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes5.dex */
public class ReactWheelCurvedPickerManager extends SimpleViewManager<ReactWheelCurvedPicker> {
    private static final int DEFAULT_ITEM_SPACE = 32;
    private static final int DEFAULT_TEXT_SIZE = 48;
    private static final String REACT_CLASS = "WheelCurvedPicker";

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(ItemSelectedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onValueChange"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactWheelCurvedPicker createViewInstance(ThemedReactContext themedReactContext) {
        ReactWheelCurvedPicker reactWheelCurvedPicker = new ReactWheelCurvedPicker(themedReactContext);
        reactWheelCurvedPicker.setItemTextColor(ViewCompat.MEASURED_STATE_MASK);
        reactWheelCurvedPicker.setItemTextSize(48);
        reactWheelCurvedPicker.setSelectedItemTextColor(-1);
        reactWheelCurvedPicker.setItemSpace(32);
        reactWheelCurvedPicker.setIndicator(true);
        reactWheelCurvedPicker.setIndicatorSize(4);
        reactWheelCurvedPicker.setIndicatorColor(Color.parseColor("#26808080"));
        reactWheelCurvedPicker.setCurtain(true);
        reactWheelCurvedPicker.setCurtainColor(Color.parseColor("#1A808080"));
        reactWheelCurvedPicker.setAtmospheric(true);
        reactWheelCurvedPicker.setCurved(true);
        reactWheelCurvedPicker.setVisibleItemCount(7);
        reactWheelCurvedPicker.setItemAlign(0);
        reactWheelCurvedPicker.setSelectedItemPosition(1);
        return reactWheelCurvedPicker;
    }

    @ReactProp(name = "data")
    public void setData(ReactWheelCurvedPicker reactWheelCurvedPicker, ReadableArray readableArray) {
        if (reactWheelCurvedPicker != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                if (map.getType("value") == ReadableType.String) {
                    arrayList.add(map.getString("value"));
                } else if (map.getType("value") == ReadableType.Number) {
                    arrayList.add(Integer.valueOf(map.getInt("value")));
                }
                arrayList2.add(map.getString("label"));
            }
            reactWheelCurvedPicker.setValueData(arrayList);
            reactWheelCurvedPicker.setData(arrayList2);
        }
    }

    @ReactProp(name = "selectedIndex")
    public void setSelectedIndex(final ReactWheelCurvedPicker reactWheelCurvedPicker, final int i) {
        if (reactWheelCurvedPicker != null) {
            new Handler().post(new Runnable() { // from class: com.tron.ReactWheelCurvedPickerManager.1
                @Override // java.lang.Runnable
                public void run() {
                    reactWheelCurvedPicker.setSelectedItemPosition(i);
                    reactWheelCurvedPicker.invalidate();
                }
            });
        }
    }

    @ReactProp(customType = "Color", name = "textColor")
    public void setTextColor(ReactWheelCurvedPicker reactWheelCurvedPicker, Integer num) {
        if (reactWheelCurvedPicker != null) {
            reactWheelCurvedPicker.setItemTextColor(num.intValue());
        }
    }

    @ReactProp(name = "textSize")
    public void setTextSize(ReactWheelCurvedPicker reactWheelCurvedPicker, int i) {
        if (reactWheelCurvedPicker != null) {
            reactWheelCurvedPicker.setItemTextSize((int) PixelUtil.toPixelFromDIP(i));
        }
    }

    @ReactProp(customType = "Color", name = "selectTextColor")
    public void setSelectedTextColor(ReactWheelCurvedPicker reactWheelCurvedPicker, Integer num) {
        if (reactWheelCurvedPicker != null) {
            reactWheelCurvedPicker.setSelectedItemTextColor(num.intValue());
        }
    }

    @ReactProp(name = "isShowSelectBackground")
    public void setCurtain(ReactWheelCurvedPicker reactWheelCurvedPicker, boolean z) {
        if (reactWheelCurvedPicker != null) {
            reactWheelCurvedPicker.setCurtain(z);
        }
    }

    @ReactProp(customType = "Color", name = "selectBackgroundColor")
    public void setCurtainColor(ReactWheelCurvedPicker reactWheelCurvedPicker, Integer num) {
        if (reactWheelCurvedPicker != null) {
            reactWheelCurvedPicker.setCurtainColor(num.intValue());
        }
    }

    @ReactProp(name = "isShowSelectLine")
    public void setIndicator(ReactWheelCurvedPicker reactWheelCurvedPicker, boolean z) {
        if (reactWheelCurvedPicker != null) {
            reactWheelCurvedPicker.setIndicator(z);
        }
    }

    @ReactProp(customType = "Color", name = "selectLineColor")
    public void setIndicatorColor(ReactWheelCurvedPicker reactWheelCurvedPicker, Integer num) {
        if (reactWheelCurvedPicker != null) {
            reactWheelCurvedPicker.setIndicatorColor(num.intValue());
        }
    }

    @ReactProp(name = "selectLineSize")
    public void setIndicatorSize(ReactWheelCurvedPicker reactWheelCurvedPicker, int i) {
        if (reactWheelCurvedPicker != null) {
            reactWheelCurvedPicker.setIndicatorSize(i);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }
}
