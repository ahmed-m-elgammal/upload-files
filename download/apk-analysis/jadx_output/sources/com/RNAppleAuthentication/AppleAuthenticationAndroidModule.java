package com.RNAppleAuthentication;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.RNAppleAuthentication.SignInWithAppleConfiguration;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.codec.language.bm.Rule;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AppleAuthenticationAndroidModule extends ReactContextBaseJavaModule {
    private static final String E_NOT_CONFIGURED_ERROR = "E_NOT_CONFIGURED_ERROR";
    private static final String E_SIGNIN_CANCELLED_ERROR = "E_SIGNIN_CANCELLED_ERROR";
    private static final String E_SIGNIN_FAILED_ERROR = "E_SIGNIN_FAILED_ERROR";
    private SignInWithAppleConfiguration configuration;
    private final ReactApplicationContext reactContext;

    public AppleAuthenticationAndroidModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNAppleAuthModuleAndroid";
    }

    private static String bytesToHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(Character.forDigit((bArr[i] >> 4) & 15, 16));
            stringBuffer.append(Character.forDigit(bArr[i] & Ascii.SI, 16));
        }
        return stringBuffer.toString();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put(Rule.ALL, SignInWithAppleConfiguration.ResponseType.ALL.toString());
        hashMap.put("CODE", SignInWithAppleConfiguration.ResponseType.CODE.toString());
        hashMap.put("ID_TOKEN", SignInWithAppleConfiguration.ResponseType.ID_TOKEN.toString());
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Rule.ALL, SignInWithAppleConfiguration.Scope.ALL.toString());
        hashMap2.put("EMAIL", SignInWithAppleConfiguration.Scope.EMAIL.toString());
        hashMap2.put("NAME", SignInWithAppleConfiguration.Scope.NAME.toString());
        HashMap hashMap3 = new HashMap();
        hashMap3.put(E_NOT_CONFIGURED_ERROR, E_NOT_CONFIGURED_ERROR);
        hashMap3.put(E_SIGNIN_FAILED_ERROR, E_SIGNIN_FAILED_ERROR);
        hashMap3.put(E_SIGNIN_CANCELLED_ERROR, E_SIGNIN_CANCELLED_ERROR);
        hashMap3.put("ResponseType", hashMap);
        hashMap3.put("Scope", hashMap2);
        hashMap3.put("isSupported", true);
        return hashMap3;
    }

    private FragmentManager getFragmentManagerHelper() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || !(currentActivity instanceof FragmentActivity)) {
            return null;
        }
        return ((FragmentActivity) currentActivity).getSupportFragmentManager();
    }

    @ReactMethod
    public void configure(ReadableMap readableMap) {
        String str;
        String uuid;
        String string;
        String string2;
        SignInWithAppleConfiguration.Scope scope = SignInWithAppleConfiguration.Scope.ALL;
        SignInWithAppleConfiguration.ResponseType responseType = SignInWithAppleConfiguration.ResponseType.ALL;
        String uuid2 = UUID.randomUUID().toString();
        boolean z = readableMap.hasKey("nonceEnabled") ? readableMap.getBoolean("nonceEnabled") : true;
        Boolean valueOf = Boolean.valueOf(z);
        String str2 = "";
        String string3 = readableMap.hasKey("clientId") ? readableMap.getString("clientId") : "";
        String string4 = readableMap.hasKey("redirectUri") ? readableMap.getString("redirectUri") : "";
        if (readableMap.hasKey("scope") && (string2 = readableMap.getString("scope")) != null) {
            scope = SignInWithAppleConfiguration.Scope.valueOf(string2);
        }
        if (readableMap.hasKey("responseType") && (string = readableMap.getString("responseType")) != null) {
            SignInWithAppleConfiguration.ResponseType.valueOf(string);
        }
        if (readableMap.hasKey("state")) {
            uuid2 = readableMap.getString("state");
        }
        valueOf.getClass();
        if (z) {
            if (readableMap.hasKey("nonce")) {
                uuid = readableMap.getString("nonce");
            } else {
                uuid = UUID.randomUUID().toString();
            }
            str2 = uuid;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(str2.getBytes());
                str = bytesToHex(messageDigest.digest());
            } catch (Exception unused) {
            }
            this.configuration = new SignInWithAppleConfiguration.Builder().clientId(string3).redirectUri(string4).responseType(SignInWithAppleConfiguration.ResponseType.ALL).scope(scope).state(uuid2).rawNonce(str2).nonce(str).build();
        }
        str = str2;
        this.configuration = new SignInWithAppleConfiguration.Builder().clientId(string3).redirectUri(string4).responseType(SignInWithAppleConfiguration.ResponseType.ALL).scope(scope).state(uuid2).rawNonce(str2).nonce(str).build();
    }

    @ReactMethod
    public void signIn(final Promise promise) {
        if (this.configuration == null) {
            promise.reject(E_NOT_CONFIGURED_ERROR);
            return;
        }
        FragmentManager fragmentManagerHelper = getFragmentManagerHelper();
        if (fragmentManagerHelper == null) {
            promise.reject(E_NOT_CONFIGURED_ERROR);
            return;
        }
        final SignInWithAppleService signInWithAppleService = new SignInWithAppleService(fragmentManagerHelper, "SignInWithAppleButton-$id-SignInWebViewDialogFragment", this.configuration, new SignInWithAppleCallback() { // from class: com.RNAppleAuthentication.AppleAuthenticationAndroidModule.1
            @Override // com.RNAppleAuthentication.SignInWithAppleCallback
            public void onSignInWithAppleSuccess(String str, String str2, String str3, String str4) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("code", str);
                createMap.putString("id_token", str2);
                createMap.putString("state", str3);
                String rawNonce = AppleAuthenticationAndroidModule.this.configuration.getRawNonce();
                if (!rawNonce.isEmpty()) {
                    createMap.putString("nonce", rawNonce);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    WritableMap createMap2 = Arguments.createMap();
                    if (jSONObject.has("name")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("name");
                        WritableMap createMap3 = Arguments.createMap();
                        if (jSONObject2.has("firstName")) {
                            createMap3.putString("firstName", jSONObject2.getString("firstName"));
                        }
                        if (jSONObject2.has("lastName")) {
                            createMap3.putString("lastName", jSONObject2.getString("lastName"));
                        }
                        if (createMap3.hasKey("firstName") || createMap3.hasKey("lastName")) {
                            createMap2.putMap("name", createMap3);
                        }
                    }
                    if (jSONObject.has("email")) {
                        createMap2.putString("email", jSONObject.getString("email"));
                    }
                    if (createMap2.hasKey("name") || createMap2.hasKey("email")) {
                        createMap.putMap("user", createMap2);
                    }
                } catch (Exception unused) {
                }
                promise.resolve(createMap);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleCallback
            public void onSignInWithAppleFailure(Throwable th) {
                promise.reject(AppleAuthenticationAndroidModule.E_SIGNIN_FAILED_ERROR, th);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleCallback
            public void onSignInWithAppleCancel() {
                promise.reject(AppleAuthenticationAndroidModule.E_SIGNIN_CANCELLED_ERROR);
            }
        });
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(new RuntimeException("Activity is not found"));
        } else {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.RNAppleAuthentication.AppleAuthenticationAndroidModule.2
                @Override // java.lang.Runnable
                public void run() {
                    signInWithAppleService.show();
                }
            });
        }
    }
}
