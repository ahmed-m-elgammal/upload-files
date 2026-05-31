package com.reactnativeavoidsoftinput.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;

/* compiled from: AvoidSoftInputAppliedOffsetChangedEvent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reactnativeavoidsoftinput/events/AvoidSoftInputAppliedOffsetChangedEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewTag", "offset", "(III)V", "createPayload", "Lcom/facebook/react/bridge/WritableMap;", "kotlin.jvm.PlatformType", "getEventData", "getEventName", "", "Companion", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvoidSoftInputAppliedOffsetChangedEvent extends Event<AvoidSoftInputAppliedOffsetChangedEvent> {
    private static final String KEY = "appliedOffset";
    public static final String NAME = "topSoftInputAppliedOffsetChange";
    private final int offset;

    public AvoidSoftInputAppliedOffsetChangedEvent(int i, int i2, int i3) {
        super(i, i2);
        this.offset = i3;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return createPayload();
    }

    private final WritableMap createPayload() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("appliedOffset", this.offset);
        return createMap;
    }
}
