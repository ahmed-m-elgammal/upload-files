package com.reactnativeavoidsoftinput.events;

import kotlin.Metadata;

/* compiled from: AvoidSoftInputHeightChangedEvent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/reactnativeavoidsoftinput/events/AvoidSoftInputHeightChangedEvent;", "Lcom/reactnativeavoidsoftinput/events/BaseAvoidSoftInputEvent;", "surfaceId", "", "viewTag", "height", "(III)V", "getEventName", "", "Companion", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvoidSoftInputHeightChangedEvent extends BaseAvoidSoftInputEvent {
    public static final String NAME = "topSoftInputHeightChange";

    public AvoidSoftInputHeightChangedEvent(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return NAME;
    }
}
