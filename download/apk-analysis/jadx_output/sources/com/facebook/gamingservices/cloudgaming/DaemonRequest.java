package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.Intent;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.hermes.intl.Intl$$ExternalSyntheticApiModelOutline0;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DaemonRequest {
    private Callback mCallback;
    private Context mContext;
    private SDKLogger mLogger;
    private JSONObject mParameters;
    private ConcurrentHashMap<String, CompletableFuture<GraphResponse>> mRequestStore;

    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    DaemonRequest(Context context, JSONObject jSONObject, Callback callback) {
        this.mContext = context;
        this.mParameters = jSONObject;
        this.mCallback = callback;
        this.mRequestStore = DaemonReceiver.getInstance(context).getRequestStore();
        this.mLogger = SDKLogger.getInstance(context);
    }

    private void executeAsync() throws ExecutionException, InterruptedException {
        createRequest().thenAccept((Consumer<? super GraphResponse>) new Consumer<GraphResponse>() { // from class: com.facebook.gamingservices.cloudgaming.DaemonRequest.1
            @Override // java.util.function.Consumer
            public void accept(GraphResponse graphResponse) {
                if (DaemonRequest.this.mCallback != null) {
                    DaemonRequest.this.mCallback.onCompleted(graphResponse);
                }
            }
        });
    }

    private GraphResponse executeAndWait() throws ExecutionException, InterruptedException {
        Object obj;
        obj = createRequest().get();
        return (GraphResponse) obj;
    }

    private GraphResponse executeAndWait(int i) throws ExecutionException, InterruptedException, TimeoutException {
        Object obj;
        obj = createRequest().get(i, TimeUnit.SECONDS);
        return (GraphResponse) obj;
    }

    private CompletableFuture<GraphResponse> createRequest() {
        CompletableFuture<GraphResponse> supplyAsync;
        supplyAsync = CompletableFuture.supplyAsync(new Supplier<GraphResponse>() { // from class: com.facebook.gamingservices.cloudgaming.DaemonRequest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.function.Supplier
            public GraphResponse get() {
                Object obj;
                String uuid = UUID.randomUUID().toString();
                try {
                    DaemonRequest.this.mParameters.put(SDKConstants.REQUEST_ID, uuid);
                    Intent intent = new Intent();
                    String string = DaemonRequest.this.mParameters.getString("type");
                    DaemonRequest.this.mLogger.logPreparingRequest(string, uuid, DaemonRequest.this.mParameters);
                    if (!string.equals(SDKMessageEnum.GET_ACCESS_TOKEN.toString()) && !string.equals(SDKMessageEnum.IS_ENV_READY.toString())) {
                        String string2 = DaemonRequest.this.mContext.getSharedPreferences(SDKConstants.PREF_DAEMON_PACKAGE_NAME, 0).getString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME, null);
                        if (string2 == null) {
                            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request with a secure connection"), uuid);
                        }
                        intent.setPackage(string2);
                    }
                    intent.setAction(SDKConstants.REQUEST_ACTION);
                    Iterator<String> keys = DaemonRequest.this.mParameters.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        intent.putExtra(next, DaemonRequest.this.mParameters.getString(next));
                    }
                    Intl$$ExternalSyntheticApiModelOutline0.m1004m$2();
                    CompletableFuture m995m = Intl$$ExternalSyntheticApiModelOutline0.m995m();
                    DaemonRequest.this.mRequestStore.put(uuid, m995m);
                    DaemonRequest.this.mContext.sendBroadcast(intent);
                    DaemonRequest.this.mLogger.logSentRequest(string, uuid, DaemonRequest.this.mParameters);
                    obj = m995m.get();
                    return (GraphResponse) obj;
                } catch (InterruptedException | ExecutionException | JSONException unused) {
                    return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), uuid);
                }
            }
        });
        return supplyAsync;
    }

    public static void executeAsync(Context context, JSONObject jSONObject, Callback callback, SDKMessageEnum sDKMessageEnum) {
        try {
            new DaemonRequest(context, jSONObject == null ? new JSONObject().put("type", sDKMessageEnum.toString()) : jSONObject.put("type", sDKMessageEnum.toString()), callback).executeAsync();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            if (callback != null) {
                callback.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null));
            }
        }
    }

    public static GraphResponse executeAndWait(Context context, JSONObject jSONObject, SDKMessageEnum sDKMessageEnum) {
        try {
            return new DaemonRequest(context, jSONObject == null ? new JSONObject().put("type", sDKMessageEnum.toString()) : jSONObject.put("type", sDKMessageEnum.toString()), null).executeAndWait();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null);
        }
    }

    public static GraphResponse executeAndWait(Context context, JSONObject jSONObject, SDKMessageEnum sDKMessageEnum, int i) {
        try {
            return new DaemonRequest(context, jSONObject == null ? new JSONObject().put("type", sDKMessageEnum.toString()) : jSONObject.put("type", sDKMessageEnum.toString()), null).executeAndWait(i);
        } catch (InterruptedException | ExecutionException | TimeoutException | JSONException unused) {
            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null);
        }
    }

    public static void executeAsync(Context context, JSONObject jSONObject, Callback callback, String str) {
        JSONObject put;
        try {
            if (jSONObject == null) {
                put = new JSONObject().put("type", str);
            } else {
                put = jSONObject.put("type", str);
            }
            new DaemonRequest(context, put, callback).executeAsync();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            if (callback != null) {
                callback.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null));
            }
        }
    }
}
