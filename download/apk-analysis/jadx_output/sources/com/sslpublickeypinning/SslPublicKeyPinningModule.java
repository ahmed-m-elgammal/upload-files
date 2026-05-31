package com.sslpublickeypinning;

import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.network.CustomClientBuilder;
import com.facebook.react.modules.network.NetworkingModule;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.CertificatePinner;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes5.dex */
public class SslPublicKeyPinningModule extends SslPublicKeyPinningSpec implements Interceptor {
    private static final String EXPIRATION_DATE_KEY = "expirationDate";
    private static final String INCLUDE_SUBDOMAINS_KEY = "includeSubdomains";
    public static final String NAME = "SslPublicKeyPinning";
    private static final String PUBLIC_KEY_HASHES_KEY = "publicKeyHashes";
    private static final String SSL_PINNING_ERROR_EVENT_NAME = "pinning-error";
    private static final String SSL_PINNING_ERROR_MESSAGE_EVENT_KEY = "message";
    private static final String SSL_PINNING_ERROR_SERVER_HOSTNAME_EVENT_KEY = "serverHostname";
    private static CertificatePinner certificatePinner = null;
    private static boolean isCustomClientBuilderInitialized = false;

    @Override // com.sslpublickeypinning.SslPublicKeyPinningSpec
    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.sslpublickeypinning.SslPublicKeyPinningSpec
    @ReactMethod
    public void removeListeners(double d) {
    }

    public SslPublicKeyPinningModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    public static CertificatePinner getCertificatePinner() {
        return certificatePinner;
    }

    private static void initializeCertificatePinner(ReadableMap readableMap) throws ParseException {
        CertificatePinner.Builder builder = new CertificatePinner.Builder();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableMap map = readableMap.getMap(nextKey);
            if (map != null) {
                String string = map.getString(EXPIRATION_DATE_KEY);
                if (string != null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    Date parse = simpleDateFormat.parse(string);
                    if (parse != null && System.currentTimeMillis() > parse.getTime()) {
                        Log.w(NAME, "Ignoring pinning configuration for " + nextKey + " as it has expired");
                    }
                }
                boolean z = map.hasKey(INCLUDE_SUBDOMAINS_KEY) && map.getBoolean(INCLUDE_SUBDOMAINS_KEY);
                ReadableArray array = map.getArray(PUBLIC_KEY_HASHES_KEY);
                if (array != null) {
                    int size = array.size();
                    String[] strArr = new String[size];
                    for (int i = 0; i < size; i++) {
                        strArr[i] = "sha256/" + array.getString(i);
                    }
                    if (z) {
                        nextKey = "**." + nextKey;
                    }
                    builder.add(nextKey, strArr);
                }
            }
        }
        certificatePinner = builder.build();
    }

    private static NetworkingModule.CustomClientBuilder getPreviousCustomClientBuilder() {
        try {
            Field declaredField = NetworkingModule.class.getDeclaredField("customClientBuilder");
            declaredField.setAccessible(true);
            return (NetworkingModule.CustomClientBuilder) declaredField.get(null);
        } catch (Throwable th) {
            Log.e(NAME, "Unable to retrieve previous custom client builder", th);
            return null;
        }
    }

    private void initializeCustomClientBuilder() {
        if (isCustomClientBuilderInitialized) {
            return;
        }
        isCustomClientBuilderInitialized = true;
        final NetworkingModule.CustomClientBuilder previousCustomClientBuilder = getPreviousCustomClientBuilder();
        NetworkingModule.setCustomClientBuilder(new CustomClientBuilder() { // from class: com.sslpublickeypinning.SslPublicKeyPinningModule$$ExternalSyntheticLambda0
            @Override // com.facebook.react.modules.network.CustomClientBuilder
            public final void apply(OkHttpClient.Builder builder) {
                SslPublicKeyPinningModule.this.lambda$initializeCustomClientBuilder$0(previousCustomClientBuilder, builder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeCustomClientBuilder$0(NetworkingModule.CustomClientBuilder customClientBuilder, OkHttpClient.Builder builder) {
        if (customClientBuilder != null) {
            customClientBuilder.apply(builder);
        }
        CertificatePinner certificatePinner2 = certificatePinner;
        if (certificatePinner2 != null) {
            builder.certificatePinner(certificatePinner2).addInterceptor(this);
        }
    }

    @Override // com.sslpublickeypinning.SslPublicKeyPinningSpec
    @ReactMethod
    public void initialize(ReadableMap readableMap, Promise promise) {
        try {
            initializeCertificatePinner(readableMap);
            initializeCustomClientBuilder();
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject(th);
        }
    }

    @Override // com.sslpublickeypinning.SslPublicKeyPinningSpec
    @ReactMethod
    public void disable(Promise promise) {
        certificatePinner = null;
        promise.resolve(null);
    }

    public void emitPinningErrorEvent(Request request, String str) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString(SSL_PINNING_ERROR_SERVER_HOSTNAME_EVENT_KEY, request.url().url().getHost());
        if (str != null) {
            writableNativeMap.putString("message", str);
        }
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(SSL_PINNING_ERROR_EVENT_NAME, writableNativeMap);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        try {
            return chain.proceed(request);
        } catch (SSLPeerUnverifiedException e) {
            String message = e.getMessage();
            if (message != null && message.startsWith("Certificate pinning failure")) {
                emitPinningErrorEvent(request, message);
            }
            throw e;
        }
    }
}
