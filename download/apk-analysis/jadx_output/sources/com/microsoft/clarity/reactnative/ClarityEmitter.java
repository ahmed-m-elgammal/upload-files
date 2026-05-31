package com.microsoft.clarity.reactnative;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.microsoft.clarity.Clarity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClarityEmitter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/microsoft/clarity/reactnative/ClarityEmitter;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "listenerCount", "", "registeredOnSessionStartedCallback", "", "addListener", "", "eventName", "", "getName", "registerOnSessionStartedCallback", "removeListeners", "count", "Companion", "microsoft_react-native-clarity_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClarityEmitter extends ReactContextBaseJavaModule {
    public static final String CLARITY_EVENT_SESSION_STARTED = "sessionStarted";
    public static final String CLARITY_SESSION_ID_PARAMETER = "sessionId";
    public static final String NAME = "ClarityEmitter";
    private int listenerCount;
    private final ReactApplicationContext reactContext;
    private boolean registeredOnSessionStartedCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClarityEmitter(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public final void addListener(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.listenerCount++;
        registerOnSessionStartedCallback();
    }

    @ReactMethod
    public final void removeListeners(int count) {
        this.listenerCount -= count;
    }

    private final void registerOnSessionStartedCallback() {
        if (this.registeredOnSessionStartedCallback) {
            return;
        }
        Boolean onSessionStartedCallback = Clarity.setOnSessionStartedCallback(new Function1<String, Unit>() { // from class: com.microsoft.clarity.reactnative.ClarityEmitter$registerOnSessionStartedCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                int i;
                ReactApplicationContext reactApplicationContext;
                i = ClarityEmitter.this.listenerCount;
                if (i <= 0) {
                    return;
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putString(ClarityEmitter.CLARITY_SESSION_ID_PARAMETER, str);
                reactApplicationContext = ClarityEmitter.this.reactContext;
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ClarityEmitter.CLARITY_EVENT_SESSION_STARTED, createMap);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onSessionStartedCallback, "setOnSessionStartedCallback(...)");
        this.registeredOnSessionStartedCallback = onSessionStartedCallback.booleanValue();
    }
}
