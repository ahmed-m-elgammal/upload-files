package com.microsoft.clarity.reactnative;

import android.os.Handler;
import android.os.Looper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.microsoft.clarity.Clarity;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.models.ApplicationFramework;
import com.microsoft.clarity.models.LogLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClarityModule.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J$\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0007¨\u0006%"}, d2 = {"Lcom/microsoft/clarity/reactnative/ClarityModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getCurrentSessionId", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "getCurrentSessionUrl", "getName", "", "initialize", "projectId", "userId", "logLevel", "isPaused", "pause", "readableArrayToList", "", "arr", "Lcom/facebook/react/bridge/ReadableArray;", "resume", "sendCustomEvent", "value", "setCurrentScreenName", "screenName", "setCustomSessionId", "customSessionId", "setCustomTag", SDKConstants.PARAM_KEY, "setCustomUserId", "customUserId", "startNewSession", "callback", "Lcom/facebook/react/bridge/Callback;", "Companion", "microsoft_react-native-clarity_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClarityModule extends ReactContextBaseJavaModule {
    public static final String NAME = "Clarity";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClarityModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public final void initialize(String projectId, String userId, String logLevel, final Promise promise) {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final ClarityConfig clarityConfig = new ClarityConfig(projectId, userId, LogLevel.valueOf(logLevel), ApplicationFramework.ReactNative, null, 16, null);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.microsoft.clarity.reactnative.ClarityModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ClarityModule.initialize$lambda$0(Promise.this, this, clarityConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$0(Promise promise, ClarityModule this$0, ClarityConfig config) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(config, "$config");
        promise.resolve(Clarity.initialize(this$0.getCurrentActivity(), config));
    }

    @ReactMethod
    public final void pause(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Clarity.pause();
        promise.resolve(Clarity.isPaused());
    }

    @ReactMethod
    public final void resume(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Clarity.resume();
        promise.resolve(Boolean.valueOf(!Clarity.isPaused().booleanValue()));
    }

    @ReactMethod
    public final void isPaused(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Clarity.isPaused());
    }

    @ReactMethod
    public final void startNewSession(final Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Clarity.startNewSession(new Function1<String, Unit>() { // from class: com.microsoft.clarity.reactnative.ClarityModule$startNewSession$1
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
                Callback.this.invoke(str);
            }
        });
    }

    @ReactMethod
    public final void setCustomUserId(String customUserId, Promise promise) {
        Intrinsics.checkNotNullParameter(customUserId, "customUserId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Clarity.setCustomUserId(customUserId));
    }

    @ReactMethod
    public final void setCustomSessionId(String customSessionId, Promise promise) {
        Intrinsics.checkNotNullParameter(customSessionId, "customSessionId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Clarity.setCustomSessionId(customSessionId));
    }

    @ReactMethod
    public final void getCurrentSessionId(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Clarity.getCurrentSessionId());
    }

    @ReactMethod
    public final void setCustomTag(String key, String value, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(Clarity.setCustomTag(key, value)));
    }

    @ReactMethod
    public final void sendCustomEvent(String value, Promise promise) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(Clarity.sendCustomEvent(value)));
    }

    @ReactMethod
    public final void setCurrentScreenName(String screenName, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Clarity.setCurrentScreenName(screenName));
    }

    @ReactMethod
    public final void getCurrentSessionUrl(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Clarity.getCurrentSessionUrl());
    }

    private final List<String> readableArrayToList(ReadableArray arr) {
        ArrayList arrayList = new ArrayList();
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            String string = arr.getString(i);
            if (string == null) {
                string = "";
            }
            arrayList.add(string);
        }
        return arrayList;
    }
}
