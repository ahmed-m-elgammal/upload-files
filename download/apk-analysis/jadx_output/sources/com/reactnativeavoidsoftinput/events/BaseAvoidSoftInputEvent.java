package com.reactnativeavoidsoftinput.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;

/* compiled from: BaseAvoidSoftInputEvent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reactnativeavoidsoftinput/events/BaseAvoidSoftInputEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewTag", "height", "(III)V", "createPayload", "Lcom/facebook/react/bridge/WritableMap;", "kotlin.jvm.PlatformType", "getEventData", "Companion", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseAvoidSoftInputEvent extends Event<BaseAvoidSoftInputEvent> {
    private static final String KEY = "softInputHeight";
    private final int height;

    public BaseAvoidSoftInputEvent(int i, int i2, int i3) {
        super(i, i2);
        this.height = i3;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return createPayload();
    }

    private final WritableMap createPayload() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("softInputHeight", this.height);
        return createMap;
    }
}
