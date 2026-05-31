package com.dooboolab.rniap;

import androidx.core.app.NotificationCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PromiseUtils.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u0019J*\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/dooboolab/rniap/PromiseUtils;", "", "()V", PromiseUtils.E_ALREADY_OWNED, "", PromiseUtils.E_ALREADY_PREPARED, PromiseUtils.E_BILLING_RESPONSE_JSON_PARSE_ERROR, PromiseUtils.E_CONNECTION_CLOSED, PromiseUtils.E_DEVELOPER_ERROR, PromiseUtils.E_ITEM_UNAVAILABLE, PromiseUtils.E_NETWORK_ERROR, PromiseUtils.E_NOT_ENDED, PromiseUtils.E_NOT_PREPARED, PromiseUtils.E_PENDING, PromiseUtils.E_REMOTE_ERROR, PromiseUtils.E_SERVICE_ERROR, PromiseUtils.E_UNKNOWN, PromiseUtils.E_USER_CANCELLED, PromiseUtils.E_USER_ERROR, "TAG", "promises", "Ljava/util/HashMap;", "", "Lcom/facebook/react/bridge/Promise;", "addPromiseForKey", "", SDKConstants.PARAM_KEY, BaseJavaModule.METHOD_TYPE_PROMISE, "rejectAllPendingPromises", "rejectPromisesForKey", "code", "message", NotificationCompat.CATEGORY_ERROR, "Ljava/lang/Exception;", "resolvePromisesForKey", "value", "react-native-iap_playRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PromiseUtils {
    public static final String E_ALREADY_OWNED = "E_ALREADY_OWNED";
    public static final String E_ALREADY_PREPARED = "E_ALREADY_PREPARED";
    public static final String E_BILLING_RESPONSE_JSON_PARSE_ERROR = "E_BILLING_RESPONSE_JSON_PARSE_ERROR";
    public static final String E_CONNECTION_CLOSED = "E_CONNECTION_CLOSED";
    public static final String E_DEVELOPER_ERROR = "E_DEVELOPER_ERROR";
    public static final String E_ITEM_UNAVAILABLE = "E_ITEM_UNAVAILABLE";
    public static final String E_NETWORK_ERROR = "E_NETWORK_ERROR";
    public static final String E_NOT_ENDED = "E_NOT_ENDED";
    public static final String E_NOT_PREPARED = "E_NOT_PREPARED";
    public static final String E_PENDING = "E_PENDING";
    public static final String E_REMOTE_ERROR = "E_REMOTE_ERROR";
    public static final String E_SERVICE_ERROR = "E_SERVICE_ERROR";
    public static final String E_UNKNOWN = "E_UNKNOWN";
    public static final String E_USER_CANCELLED = "E_USER_CANCELLED";
    public static final String E_USER_ERROR = "E_USER_ERROR";
    private static final String TAG = "PromiseUtils";
    public static final PromiseUtils INSTANCE = new PromiseUtils();
    private static final HashMap<String, List<Promise>> promises = new HashMap<>();

    private PromiseUtils() {
    }

    public final void addPromiseForKey(String key, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        HashMap<String, List<Promise>> hashMap = promises;
        ArrayList arrayList = hashMap.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList();
            hashMap.put(key, arrayList);
        }
        arrayList.add(promise);
    }

    public final void resolvePromisesForKey(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        List<Promise> list = promises.get(key);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                PromiseUtlisKt.safeResolve((Promise) it.next(), value);
            }
        }
        promises.remove(key);
    }

    public final void rejectAllPendingPromises() {
        HashMap<String, List<Promise>> hashMap = promises;
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, List<Promise>>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, it.next().getValue());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            PromiseUtlisKt.safeReject((Promise) it2.next(), E_CONNECTION_CLOSED, "Connection has been closed", null);
        }
        promises.clear();
    }

    public final void rejectPromisesForKey(String key, String code, String message, Exception err) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(code, "code");
        List<Promise> list = promises.get(key);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                PromiseUtlisKt.safeReject((Promise) it.next(), code, message, err);
            }
        }
        promises.remove(key);
    }
}
