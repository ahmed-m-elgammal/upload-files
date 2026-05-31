package com.reactnativegooglesignin;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class RNGoogleSigninModule extends NativeGoogleSigninSpec {
    public static final String PLAY_SERVICES_NOT_AVAILABLE = "PLAY_SERVICES_NOT_AVAILABLE";
    public static final int RC_SIGN_IN = 9001;
    public static final int REQUEST_CODE_ADD_SCOPES = 53295;
    public static final int REQUEST_CODE_RECOVER_AUTH = 53294;
    private static final String SHOULD_RECOVER = "SHOULD_RECOVER";
    private GoogleSignInClient _apiClient;
    private PendingAuthRecovery pendingAuthRecovery;
    private final PromiseWrapper signInOrAddScopesPromiseWrapper;
    private final PromiseWrapper silentSignInPromiseWrapper;
    private final PromiseWrapper tokenClearingPromiseWrapper;
    private final PromiseWrapper tokenRetrievalPromiseWrapper;

    public PromiseWrapper getTokenClearingPromiseWrapper() {
        return this.tokenClearingPromiseWrapper;
    }

    public PromiseWrapper getTokenRetrievalPromiseWrapper() {
        return this.tokenRetrievalPromiseWrapper;
    }

    public RNGoogleSigninModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.signInOrAddScopesPromiseWrapper = new PromiseWrapper(NativeGoogleSigninSpec.NAME);
        this.silentSignInPromiseWrapper = new PromiseWrapper(NativeGoogleSigninSpec.NAME);
        this.tokenRetrievalPromiseWrapper = new PromiseWrapper(NativeGoogleSigninSpec.NAME);
        this.tokenClearingPromiseWrapper = new PromiseWrapper(NativeGoogleSigninSpec.NAME);
        reactApplicationContext.addActivityEventListener(new RNGoogleSigninActivityEventListener());
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    protected Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("BUTTON_SIZE_ICON", 2);
        hashMap.put("BUTTON_SIZE_STANDARD", 0);
        hashMap.put("BUTTON_SIZE_WIDE", 1);
        hashMap.put("SIGN_IN_CANCELLED", String.valueOf(GoogleSignInStatusCodes.SIGN_IN_CANCELLED));
        hashMap.put("SIGN_IN_REQUIRED", String.valueOf(4));
        hashMap.put("SCOPES_ALREADY_GRANTED", "NEVER_HAPPENS_ON_ANDROID");
        hashMap.put("ONE_TAP_START_FAILED", "ONE_TAP_START_FAILED");
        hashMap.put("NO_SAVED_CREDENTIAL_FOUND", "NO_SAVED_CREDENTIAL_FOUND");
        hashMap.put("IN_PROGRESS", PromiseWrapper.ASYNC_OP_IN_PROGRESS);
        hashMap.put(PLAY_SERVICES_NOT_AVAILABLE, PLAY_SERVICES_NOT_AVAILABLE);
        return hashMap;
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod
    public void playServicesAvailable(boolean z, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.w(NativeGoogleSigninSpec.NAME, "could not determine playServicesAvailable, activity is null");
            rejectWithNullActivity(promise);
            return;
        }
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(currentActivity);
        if (isGooglePlayServicesAvailable != 0) {
            if (z && googleApiAvailability.isUserResolvableError(isGooglePlayServicesAvailable)) {
                googleApiAvailability.getErrorDialog(currentActivity, isGooglePlayServicesAvailable, 2404).show();
            }
            promise.reject(PLAY_SERVICES_NOT_AVAILABLE, "Play services not available");
            return;
        }
        promise.resolve(true);
    }

    static void rejectWithNullActivity(Promise promise) {
        promise.reject(NativeGoogleSigninSpec.NAME, "activity is null");
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod
    public void configure(ReadableMap readableMap, Promise promise) {
        this._apiClient = GoogleSignIn.getClient(getReactApplicationContext(), Utils.getSignInOptions(Utils.createScopesArray(readableMap.hasKey("scopes") ? readableMap.getArray("scopes") : Arguments.createArray()), readableMap.hasKey("webClientId") ? readableMap.getString("webClientId") : null, readableMap.hasKey("offlineAccess") && readableMap.getBoolean("offlineAccess"), readableMap.hasKey("forceCodeForRefreshToken") && readableMap.getBoolean("forceCodeForRefreshToken"), readableMap.hasKey("accountName") ? readableMap.getString("accountName") : null, readableMap.hasKey("hostedDomain") ? readableMap.getString("hostedDomain") : null));
        promise.resolve(null);
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod
    public void signInSilently(Promise promise) {
        if (this._apiClient == null) {
            rejectWithNullClientError(promise);
        } else {
            this.silentSignInPromiseWrapper.setPromiseWithInProgressCheck(promise, "signInSilently");
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativegooglesignin.RNGoogleSigninModule$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    RNGoogleSigninModule.this.lambda$signInSilently$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInSilently$1() {
        Task<GoogleSignInAccount> silentSignIn = this._apiClient.silentSignIn();
        if (silentSignIn.isSuccessful()) {
            handleSignInTaskResult(silentSignIn, this.silentSignInPromiseWrapper);
        } else {
            silentSignIn.addOnCompleteListener(new OnCompleteListener() { // from class: com.reactnativegooglesignin.RNGoogleSigninModule$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    RNGoogleSigninModule.this.lambda$signInSilently$0(task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInSilently$0(Task task) {
        handleSignInTaskResult(task, this.silentSignInPromiseWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSignInTaskResult(Task<GoogleSignInAccount> task, PromiseWrapper promiseWrapper) {
        try {
            GoogleSignInAccount result = task.getResult(ApiException.class);
            if (result == null) {
                promiseWrapper.reject("GoogleSignInAccount instance was null");
            } else {
                promiseWrapper.resolve(Utils.getUserProperties(result));
            }
        } catch (ApiException e) {
            promiseWrapper.reject(e);
        }
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod
    public void signIn(ReadableMap readableMap, Promise promise) {
        if (this._apiClient == null) {
            rejectWithNullClientError(promise);
            return;
        }
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            rejectWithNullActivity(promise);
        } else {
            this.signInOrAddScopesPromiseWrapper.setPromiseWithInProgressCheck(promise, "signIn");
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativegooglesignin.RNGoogleSigninModule$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    RNGoogleSigninModule.this.lambda$signIn$2(currentActivity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signIn$2(Activity activity) {
        activity.startActivityForResult(this._apiClient.getSignInIntent(), RC_SIGN_IN);
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod
    public void addScopes(ReadableMap readableMap, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            rejectWithNullActivity(promise);
            return;
        }
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getReactApplicationContext());
        if (lastSignedInAccount == null) {
            promise.resolve(false);
        } else {
            this.signInOrAddScopesPromiseWrapper.setPromiseWithInProgressCheck(promise, "addScopes");
            GoogleSignIn.requestPermissions(currentActivity, REQUEST_CODE_ADD_SCOPES, lastSignedInAccount, Utils.createScopesArray(readableMap.getArray("scopes")));
        }
    }

    private class RNGoogleSigninActivityEventListener extends BaseActivityEventListener {
        private RNGoogleSigninActivityEventListener() {
        }

        @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            if (i == 9001) {
                Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(intent);
                RNGoogleSigninModule rNGoogleSigninModule = RNGoogleSigninModule.this;
                rNGoogleSigninModule.handleSignInTaskResult(signedInAccountFromIntent, rNGoogleSigninModule.signInOrAddScopesPromiseWrapper);
            } else {
                if (i == 53294) {
                    if (i2 == -1) {
                        RNGoogleSigninModule.this.rerunFailedAuthTokenTask();
                        return;
                    } else {
                        RNGoogleSigninModule.this.tokenRetrievalPromiseWrapper.reject("Failed authentication recovery attempt, probably user-rejected.");
                        return;
                    }
                }
                if (i == 53295) {
                    if (i2 == -1) {
                        RNGoogleSigninModule.this.signInOrAddScopesPromiseWrapper.resolve(true);
                    } else {
                        RNGoogleSigninModule.this.signInOrAddScopesPromiseWrapper.reject("Failed to add scopes.");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rerunFailedAuthTokenTask() {
        WritableMap userProperties = this.pendingAuthRecovery.getUserProperties();
        if (userProperties != null) {
            new AccessTokenRetrievalTask(this).execute(userProperties, null);
        } else {
            this.tokenRetrievalPromiseWrapper.reject("rerunFailedAuthTokenTask: recovery failed");
        }
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod
    public void signOut(final Promise promise) {
        GoogleSignInClient googleSignInClient = this._apiClient;
        if (googleSignInClient == null) {
            rejectWithNullClientError(promise);
        } else {
            googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener() { // from class: com.reactnativegooglesignin.RNGoogleSigninModule$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    RNGoogleSigninModule.this.lambda$signOut$3(promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleSignOutOrRevokeAccessTask, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$signOut$3(Task<Void> task, Promise promise) {
        if (task.isSuccessful()) {
            promise.resolve(null);
            return;
        }
        int exceptionCode = Utils.getExceptionCode(task);
        promise.reject(String.valueOf(exceptionCode), GoogleSignInStatusCodes.getStatusCodeString(exceptionCode));
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod
    public void revokeAccess(final Promise promise) {
        GoogleSignInClient googleSignInClient = this._apiClient;
        if (googleSignInClient == null) {
            rejectWithNullClientError(promise);
        } else {
            googleSignInClient.revokeAccess().addOnCompleteListener(new OnCompleteListener() { // from class: com.reactnativegooglesignin.RNGoogleSigninModule$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    RNGoogleSigninModule.this.lambda$revokeAccess$4(promise, task);
                }
            });
        }
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean hasPreviousSignIn() {
        return GoogleSignIn.getLastSignedInAccount(getReactApplicationContext()) != null;
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getCurrentUser() {
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getReactApplicationContext());
        if (lastSignedInAccount == null) {
            return null;
        }
        return Utils.getUserProperties(lastSignedInAccount);
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod
    public void clearCachedAccessToken(String str, Promise promise) {
        this.tokenClearingPromiseWrapper.setPromiseWithInProgressCheck(promise, "clearCachedAccessToken");
        new TokenClearingTask(this).execute(str);
    }

    @Override // com.reactnativegooglesignin.NativeGoogleSigninSpec
    @ReactMethod
    public void getTokens(Promise promise) {
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getReactApplicationContext());
        if (lastSignedInAccount == null) {
            promise.reject("getTokens", "getTokens requires a user to be signed in");
        } else {
            this.tokenRetrievalPromiseWrapper.setPromiseWithInProgressCheck(promise, "getTokens");
            startTokenRetrievalTaskWithRecovery(lastSignedInAccount);
        }
    }

    private void startTokenRetrievalTaskWithRecovery(GoogleSignInAccount googleSignInAccount) {
        WritableMap userProperties = Utils.getUserProperties(googleSignInAccount);
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean(SHOULD_RECOVER, true);
        new AccessTokenRetrievalTask(this).execute(userProperties, createMap);
    }

    private static class AccessTokenRetrievalTask extends AsyncTask<WritableMap, Void, Void> {
        private final WeakReference<RNGoogleSigninModule> weakModuleRef;

        AccessTokenRetrievalTask(RNGoogleSigninModule rNGoogleSigninModule) {
            this.weakModuleRef = new WeakReference<>(rNGoogleSigninModule);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(WritableMap... writableMapArr) {
            WritableMap writableMap = writableMapArr[0];
            RNGoogleSigninModule rNGoogleSigninModule = this.weakModuleRef.get();
            if (rNGoogleSigninModule == null) {
                return null;
            }
            try {
                insertAccessTokenIntoUserProperties(rNGoogleSigninModule, writableMap);
                rNGoogleSigninModule.getTokenRetrievalPromiseWrapper().resolve(writableMap);
            } catch (Exception e) {
                handleException(rNGoogleSigninModule, e, writableMap, writableMapArr.length >= 2 ? writableMapArr[1] : null);
            }
            return null;
        }

        private void insertAccessTokenIntoUserProperties(RNGoogleSigninModule rNGoogleSigninModule, WritableMap writableMap) throws IOException, GoogleAuthException {
            writableMap.putString(SDKConstants.PARAM_ACCESS_TOKEN, GoogleAuthUtil.getToken(rNGoogleSigninModule.getReactApplicationContext(), new Account(writableMap.getMap("user").getString("email"), "com.google"), Utils.scopesToString(writableMap.getArray("scopes"))));
        }

        private void handleException(RNGoogleSigninModule rNGoogleSigninModule, Exception exc, WritableMap writableMap, WritableMap writableMap2) {
            if (exc instanceof UserRecoverableAuthException) {
                if (writableMap2 != null && writableMap2.hasKey(RNGoogleSigninModule.SHOULD_RECOVER) && writableMap2.getBoolean(RNGoogleSigninModule.SHOULD_RECOVER)) {
                    attemptRecovery(rNGoogleSigninModule, exc, writableMap);
                    return;
                } else {
                    rNGoogleSigninModule.getTokenRetrievalPromiseWrapper().reject(exc);
                    return;
                }
            }
            rNGoogleSigninModule.getTokenRetrievalPromiseWrapper().reject(exc);
        }

        private void attemptRecovery(RNGoogleSigninModule rNGoogleSigninModule, Exception exc, WritableMap writableMap) {
            Activity currentActivity = rNGoogleSigninModule.getCurrentActivity();
            if (currentActivity == null) {
                rNGoogleSigninModule.pendingAuthRecovery = null;
                rNGoogleSigninModule.getTokenRetrievalPromiseWrapper().reject("Cannot attempt recovery auth because app is not in foreground. " + exc.getLocalizedMessage());
                return;
            }
            rNGoogleSigninModule.pendingAuthRecovery = new PendingAuthRecovery(writableMap);
            currentActivity.startActivityForResult(((UserRecoverableAuthException) exc).getIntent(), RNGoogleSigninModule.REQUEST_CODE_RECOVER_AUTH);
        }
    }

    private static class TokenClearingTask extends AsyncTask<String, Void, Void> {
        private final WeakReference<RNGoogleSigninModule> weakModuleRef;

        TokenClearingTask(RNGoogleSigninModule rNGoogleSigninModule) {
            this.weakModuleRef = new WeakReference<>(rNGoogleSigninModule);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(String... strArr) {
            RNGoogleSigninModule rNGoogleSigninModule = this.weakModuleRef.get();
            if (rNGoogleSigninModule == null) {
                return null;
            }
            PromiseWrapper tokenClearingPromiseWrapper = rNGoogleSigninModule.getTokenClearingPromiseWrapper();
            try {
                GoogleAuthUtil.clearToken(rNGoogleSigninModule.getReactApplicationContext(), strArr[0]);
                tokenClearingPromiseWrapper.resolve(null);
            } catch (Exception e) {
                tokenClearingPromiseWrapper.reject(e);
            }
            return null;
        }
    }

    private void rejectWithNullClientError(Promise promise) {
        promise.reject(NativeGoogleSigninSpec.NAME, "apiClient is null - call configure() first");
    }
}
