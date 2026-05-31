package com.reactnativegooglesignin;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public abstract class NativeGoogleSigninSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public static final String NAME = "RNGoogleSignin";

    @ReactMethod
    public abstract void addScopes(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void clearCachedAccessToken(String str, Promise promise);

    @ReactMethod
    public abstract void configure(ReadableMap readableMap, Promise promise);

    @ReactMethod(isBlockingSynchronousMethod = true)
    @Nullable
    public abstract WritableMap getCurrentUser();

    @ReactMethod
    public abstract void getTokens(Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean hasPreviousSignIn();

    @ReactMethod
    public abstract void playServicesAvailable(boolean z, Promise promise);

    @ReactMethod
    public abstract void revokeAccess(Promise promise);

    @ReactMethod
    public abstract void signIn(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void signInSilently(Promise promise);

    @ReactMethod
    public abstract void signOut(Promise promise);

    public NativeGoogleSigninSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }
}
