package com.facebook.reactnative.androidsdk;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class RCTLoginButton extends LoginButton {
    private final CallbackManager mCallbackManager;
    private final EventDispatcher mEventDispatcher;

    public RCTLoginButton(ThemedReactContext themedReactContext, CallbackManager callbackManager) {
        super(themedReactContext);
        setToolTipMode(LoginButton.ToolTipMode.NEVER_DISPLAY);
        this.mCallbackManager = callbackManager;
        this.mEventDispatcher = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) getContext(), getId());
        init();
    }

    public void init() {
        new AccessTokenTracker() { // from class: com.facebook.reactnative.androidsdk.RCTLoginButton.1
            @Override // com.facebook.AccessTokenTracker
            protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                if (accessToken2 == null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("type", "logoutFinished");
                    RCTLoginButton.this.mEventDispatcher.dispatchEvent(new RCTLoginButtonEvent(UIManagerHelper.getSurfaceId((ReactContext) RCTLoginButton.this.getContext()), RCTLoginButton.this.getId(), createMap));
                }
            }
        };
        registerCallback(this.mCallbackManager, new FacebookCallback<LoginResult>() { // from class: com.facebook.reactnative.androidsdk.RCTLoginButton.2
            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", null);
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", false);
                createMap2.putArray("grantedPermissions", Arguments.fromJavaArgs(RCTLoginButton.this.setToStringArray(loginResult.getRecentlyGrantedPermissions())));
                createMap2.putArray(SDKConstants.PARAM_DECLINED_PERMISSIONS, Arguments.fromJavaArgs(RCTLoginButton.this.setToStringArray(loginResult.getRecentlyDeniedPermissions())));
                createMap.putMap("result", createMap2);
                RCTLoginButton.this.mEventDispatcher.dispatchEvent(new RCTLoginButtonEvent(UIManagerHelper.getSurfaceId((ReactContext) RCTLoginButton.this.getContext()), RCTLoginButton.this.getId(), createMap));
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", facebookException.toString());
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", false);
                createMap.putMap("result", createMap2);
                RCTLoginButton.this.mEventDispatcher.dispatchEvent(new RCTLoginButtonEvent(UIManagerHelper.getSurfaceId((ReactContext) RCTLoginButton.this.getContext()), RCTLoginButton.this.getId(), createMap));
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", null);
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", true);
                createMap.putMap("result", createMap2);
                RCTLoginButton.this.mEventDispatcher.dispatchEvent(new RCTLoginButtonEvent(UIManagerHelper.getSurfaceId((ReactContext) RCTLoginButton.this.getContext()), RCTLoginButton.this.getId(), createMap));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] setToStringArray(Set<String> set) {
        String[] strArr = new String[set.size()];
        Iterator<String> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next();
            i++;
        }
        return strArr;
    }
}
