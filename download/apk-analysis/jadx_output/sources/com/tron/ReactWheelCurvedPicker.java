package com.tron;

import com.aigestudio.wheelpicker.WheelPicker;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.List;

/* loaded from: classes5.dex */
public class ReactWheelCurvedPicker extends WheelPicker {
    private final EventDispatcher mEventDispatcher;
    private List<Object> mValueData;

    public void getState() {
    }

    public ReactWheelCurvedPicker(ReactContext reactContext) {
        super(reactContext);
        this.mEventDispatcher = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        setOnWheelChangeListener(new WheelPicker.OnWheelChangeListener() { // from class: com.tron.ReactWheelCurvedPicker.1
            @Override // com.aigestudio.wheelpicker.WheelPicker.OnWheelChangeListener
            public void onWheelScrollStateChanged(int i) {
            }

            @Override // com.aigestudio.wheelpicker.WheelPicker.OnWheelChangeListener
            public void onWheelScrolled(int i) {
            }

            @Override // com.aigestudio.wheelpicker.WheelPicker.OnWheelChangeListener
            public void onWheelSelected(int i) {
                if (ReactWheelCurvedPicker.this.mValueData == null || i >= ReactWheelCurvedPicker.this.mValueData.size()) {
                    return;
                }
                ReactWheelCurvedPicker.this.mEventDispatcher.dispatchEvent(new ItemSelectedEvent(ReactWheelCurvedPicker.this.getId(), ReactWheelCurvedPicker.this.mValueData.get(i)));
            }
        });
    }

    @Override // com.aigestudio.wheelpicker.WheelPicker, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setValueData(List<Object> list) {
        this.mValueData = list;
    }
}
