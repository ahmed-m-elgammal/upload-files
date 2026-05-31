package com.tron;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ReactWheelCurvedPicker.java */
/* loaded from: classes5.dex */
class ItemSelectedEvent extends Event<ItemSelectedEvent> {
    public static final String EVENT_NAME = "wheelCurvedPickerPageSelected";
    private final Object mValue;

    protected ItemSelectedEvent(int i, Object obj) {
        super(i);
        this.mValue = obj;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        Class<?> cls = this.mValue.getClass();
        if (cls == Integer.class) {
            createMap.putInt("data", ((Integer) this.mValue).intValue());
        } else if (cls == String.class) {
            createMap.putString("data", this.mValue.toString());
        }
        return createMap;
    }
}
