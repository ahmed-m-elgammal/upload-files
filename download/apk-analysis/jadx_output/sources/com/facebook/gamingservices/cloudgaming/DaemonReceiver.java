package com.facebook.gamingservices.cloudgaming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0;
import java.net.HttpURLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DaemonReceiver {
    private static SDKLogger mLogger;
    private static ConcurrentHashMap<String, CompletableFuture<GraphResponse>> requestStore;
    private static DaemonReceiver single_instance;

    private DaemonReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter(SDKConstants.RECEIVER_INTENT);
        HandlerThread handlerThread = new HandlerThread(SDKConstants.RECEIVER_HANDLER);
        handlerThread.start();
        context.registerReceiver(new DaemonBroadcastReceiver(), intentFilter, null, new Handler(handlerThread.getLooper()));
        requestStore = new ConcurrentHashMap<>();
        mLogger = SDKLogger.getInstance(context);
    }

    synchronized ConcurrentHashMap<String, CompletableFuture<GraphResponse>> getRequestStore() {
        return requestStore;
    }

    static synchronized DaemonReceiver getInstance(Context context) {
        DaemonReceiver daemonReceiver;
        synchronized (DaemonReceiver.class) {
            if (single_instance == null) {
                single_instance = new DaemonReceiver(context);
            }
            daemonReceiver = single_instance;
        }
        return daemonReceiver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GraphResponse processResponse(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(GraphResponse.SUCCESS_KEY)) {
            return createSuccessResponse(jSONObject, str);
        }
        if (!jSONObject.isNull("error")) {
            return createErrorResponse(jSONObject, str);
        }
        return createDefaultErrorResponse(str);
    }

    private static GraphResponse createSuccessResponse(JSONObject jSONObject, String str) {
        if (jSONObject.optJSONObject(GraphResponse.SUCCESS_KEY) != null) {
            mLogger.logSendingSuccessResponse(str);
            return new GraphResponse(new GraphRequest(), (HttpURLConnection) null, "", jSONObject.optJSONObject(GraphResponse.SUCCESS_KEY));
        }
        if (jSONObject.optJSONArray(GraphResponse.SUCCESS_KEY) != null) {
            mLogger.logSendingSuccessResponse(str);
            return new GraphResponse(new GraphRequest(), (HttpURLConnection) null, "", jSONObject.optJSONArray(GraphResponse.SUCCESS_KEY));
        }
        return createDefaultErrorResponse(str);
    }

    static GraphResponse createErrorResponse(FacebookRequestError facebookRequestError, String str) {
        mLogger.logSendingErrorResponse(facebookRequestError, str);
        return new GraphResponse(new GraphRequest(), null, facebookRequestError);
    }

    private static GraphResponse createErrorResponse(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("error");
        if (optJSONObject != null) {
            return createErrorResponse(new FacebookRequestError(optJSONObject.optInt("code"), optJSONObject.optString("type"), optJSONObject.optString("message")), str);
        }
        return createDefaultErrorResponse(str);
    }

    private static GraphResponse createDefaultErrorResponse(String str) {
        return createErrorResponse(new FacebookRequestError(20, "UNSUPPORTED_FORMAT", "The response format is invalid."), str);
    }

    private static class DaemonBroadcastReceiver extends BroadcastReceiver {
        private DaemonBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CompletableFuture m$1;
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra(SDKConstants.RECEIVER_PAYLOAD));
                String string = jSONObject.getString(SDKConstants.REQUEST_ID);
                if (!DaemonReceiver.requestStore.containsKey(string) || (m$1 = Intl$$ExternalSyntheticApiModelOutline0.m$1(DaemonReceiver.requestStore.remove(string))) == null) {
                    return;
                }
                m$1.complete(DaemonReceiver.processResponse(jSONObject, string));
            } catch (JSONException unused) {
            }
        }
    }
}
