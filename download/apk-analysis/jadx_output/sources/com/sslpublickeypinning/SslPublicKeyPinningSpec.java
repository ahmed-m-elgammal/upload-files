package com.sslpublickeypinning;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes5.dex */
abstract class SslPublicKeyPinningSpec extends ReactContextBaseJavaModule {
    public abstract void addListener(String str);

    public abstract void disable(Promise promise);

    public abstract void initialize(ReadableMap readableMap, Promise promise);

    public abstract void removeListeners(double d);

    SslPublicKeyPinningSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
