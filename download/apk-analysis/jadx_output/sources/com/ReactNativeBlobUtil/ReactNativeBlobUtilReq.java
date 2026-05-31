package com.ReactNativeBlobUtil;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilFileResp;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import io.sentry.ProfilingTraceData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public class ReactNativeBlobUtilReq extends BroadcastReceiver implements Runnable {
    Callback callback;
    boolean callbackfired;
    OkHttpClient client;
    long contentLength;
    String destPath;
    long downloadManagerId;
    private Future<?> future;
    ReadableMap headers;
    String method;
    ReactNativeBlobUtilConfig options;
    String rawRequestBody;
    ReadableArray rawRequestBodyArray;
    ReactNativeBlobUtilBody requestBody;
    RequestType requestType;
    WritableMap respInfo;
    ResponseType responseType;
    String taskId;
    String url;
    public static HashMap<String, Call> taskTable = new HashMap<>();
    public static HashMap<String, Long> androidDownloadManagerTaskTable = new HashMap<>();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> progressReport = new HashMap<>();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> uploadProgressReport = new HashMap<>();
    static ConnectionPool pool = new ConnectionPool();
    ResponseFormat responseFormat = ResponseFormat.Auto;
    boolean timeout = false;
    ArrayList<String> redirects = new ArrayList<>();
    private final int QUERY = 1314;
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1314 && message.getData().getLong("downloadManagerId") == ReactNativeBlobUtilReq.this.downloadManagerId) {
                DownloadManager downloadManager = (DownloadManager) ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getSystemService("download");
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(ReactNativeBlobUtilReq.this.downloadManagerId);
                Cursor query2 = downloadManager.query(query);
                if (query2 != null && query2.moveToFirst()) {
                    long j = query2.getInt(query2.getColumnIndex("bytes_so_far"));
                    long j2 = query2.getLong(query2.getColumnIndex("total_size"));
                    query2.close();
                    ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilReq.this.taskId);
                    float f = j2 > 0 ? j / j2 : 0.0f;
                    if (reportProgress != null && reportProgress.shouldReport(f)) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("taskId", String.valueOf(ReactNativeBlobUtilReq.this.taskId));
                        createMap.putString("written", String.valueOf(j));
                        createMap.putString("total", String.valueOf(j2));
                        createMap.putString("chunk", "");
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, createMap);
                    }
                    if (j2 == j) {
                        ReactNativeBlobUtilReq.this.future.cancel(true);
                    }
                }
            }
            return true;
        }
    });

    enum RequestType {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    enum ResponseFormat {
        Auto,
        UTF8,
        BASE64
    }

    enum ResponseType {
        KeepInMemory,
        FileStorage
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        return builder;
    }

    private boolean shouldTransformFile() {
        return this.options.transformFile.booleanValue() && (this.options.fileCache.booleanValue() || this.options.path != null);
    }

    public ReactNativeBlobUtilReq(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, OkHttpClient okHttpClient, Callback callback) {
        this.method = str2.toUpperCase(Locale.ROOT);
        ReactNativeBlobUtilConfig reactNativeBlobUtilConfig = new ReactNativeBlobUtilConfig(readableMap);
        this.options = reactNativeBlobUtilConfig;
        this.taskId = str;
        this.url = str3;
        this.headers = readableMap2;
        this.callback = callback;
        this.rawRequestBody = str4;
        this.rawRequestBodyArray = readableArray;
        this.client = okHttpClient;
        this.callbackfired = false;
        if ((reactNativeBlobUtilConfig.fileCache.booleanValue() || this.options.path != null) && !shouldTransformFile()) {
            this.responseType = ResponseType.FileStorage;
        } else {
            this.responseType = ResponseType.KeepInMemory;
        }
        if (str4 != null) {
            this.requestType = RequestType.SingleFile;
        } else if (readableArray != null) {
            this.requestType = RequestType.Form;
        } else {
            this.requestType = RequestType.WithoutBody;
        }
    }

    public static void cancelTask(String str) {
        Call call = taskTable.get(str);
        if (call != null) {
            call.cancel();
            taskTable.remove(str);
        }
        if (androidDownloadManagerTaskTable.containsKey(str)) {
            ((DownloadManager) ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getSystemService("download")).remove(androidDownloadManagerTaskTable.get(str).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invoke_callback(Object... objArr) {
        if (this.callbackfired) {
            return;
        }
        this.callback.invoke(objArr);
        this.callbackfired = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0501 A[Catch: Exception -> 0x0551, TryCatch #2 {Exception -> 0x0551, blocks: (B:81:0x026a, B:83:0x0274, B:84:0x0281, B:86:0x028c, B:88:0x02a0, B:94:0x02af, B:98:0x02b6, B:101:0x02bc, B:93:0x02c9, B:105:0x02cd, B:107:0x02df, B:109:0x02e4, B:110:0x02f3, B:112:0x02fc, B:113:0x0300, B:115:0x0306, B:122:0x0318, B:132:0x0320, B:125:0x0325, B:128:0x032e, B:118:0x0333, B:135:0x0346, B:138:0x0354, B:140:0x035c, B:143:0x0365, B:144:0x03f1, B:152:0x04e3, B:154:0x0501, B:155:0x0513, B:157:0x0413, B:159:0x041b, B:161:0x0423, B:164:0x042c, B:165:0x0434, B:166:0x0443, B:167:0x048e, B:168:0x04b9, B:169:0x036b, B:171:0x0379, B:172:0x0395, B:174:0x0399, B:176:0x03a1, B:179:0x03ac, B:181:0x03b8, B:184:0x03c7, B:185:0x03cc, B:187:0x03dc, B:188:0x03df, B:190:0x03e5, B:191:0x03e8, B:192:0x03ed, B:194:0x0380, B:196:0x0386, B:198:0x038c, B:199:0x0391, B:202:0x02f0, B:203:0x027b), top: B:80:0x026a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04b9 A[Catch: Exception -> 0x0551, TryCatch #2 {Exception -> 0x0551, blocks: (B:81:0x026a, B:83:0x0274, B:84:0x0281, B:86:0x028c, B:88:0x02a0, B:94:0x02af, B:98:0x02b6, B:101:0x02bc, B:93:0x02c9, B:105:0x02cd, B:107:0x02df, B:109:0x02e4, B:110:0x02f3, B:112:0x02fc, B:113:0x0300, B:115:0x0306, B:122:0x0318, B:132:0x0320, B:125:0x0325, B:128:0x032e, B:118:0x0333, B:135:0x0346, B:138:0x0354, B:140:0x035c, B:143:0x0365, B:144:0x03f1, B:152:0x04e3, B:154:0x0501, B:155:0x0513, B:157:0x0413, B:159:0x041b, B:161:0x0423, B:164:0x042c, B:165:0x0434, B:166:0x0443, B:167:0x048e, B:168:0x04b9, B:169:0x036b, B:171:0x0379, B:172:0x0395, B:174:0x0399, B:176:0x03a1, B:179:0x03ac, B:181:0x03b8, B:184:0x03c7, B:185:0x03cc, B:187:0x03dc, B:188:0x03df, B:190:0x03e5, B:191:0x03e8, B:192:0x03ed, B:194:0x0380, B:196:0x0386, B:198:0x038c, B:199:0x0391, B:202:0x02f0, B:203:0x027b), top: B:80:0x026a, inners: #1 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 1402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.run():void");
    }

    /* renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType;
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType;

        static {
            int[] iArr = new int[ResponseType.values().length];
            $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType = iArr;
            try {
                iArr[ResponseType.KeepInMemory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType[ResponseType.FileStorage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[RequestType.values().length];
            $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType = iArr2;
            try {
                iArr2[RequestType.SingleFile.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[RequestType.AsIs.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[RequestType.Form.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[RequestType.WithoutBody.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseTaskResource() {
        if (taskTable.containsKey(this.taskId)) {
            taskTable.remove(this.taskId);
        }
        if (androidDownloadManagerTaskTable.containsKey(this.taskId)) {
            androidDownloadManagerTaskTable.remove(this.taskId);
        }
        if (uploadProgressReport.containsKey(this.taskId)) {
            uploadProgressReport.remove(this.taskId);
        }
        if (progressReport.containsKey(this.taskId)) {
            progressReport.remove(this.taskId);
        }
        ReactNativeBlobUtilBody reactNativeBlobUtilBody = this.requestBody;
        if (reactNativeBlobUtilBody != null) {
            reactNativeBlobUtilBody.clearRequestBody();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void done(Response response) {
        boolean isBlobResponse = isBlobResponse(response);
        WritableMap responseInfo = getResponseInfo(response, isBlobResponse);
        emitStateEvent(responseInfo.copy());
        emitStateEvent(getResponseInfo(response, isBlobResponse));
        int i = AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType[this.responseType.ordinal()];
        String str = null;
        if (i == 1) {
            if (isBlobResponse) {
                try {
                    if (this.options.auto.booleanValue()) {
                        String tmpPath = ReactNativeBlobUtilFS.getTmpPath(this.taskId);
                        InputStream byteStream = response.body().byteStream();
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(tmpPath));
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        byteStream.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        invoke_callback(null, "path", tmpPath, responseInfo.copy());
                    }
                } catch (IOException unused) {
                    invoke_callback("ReactNativeBlobUtil failed to encode response data to BASE64 string.", responseInfo.copy());
                }
            }
            byte[] bytes = response.body().bytes();
            if (shouldTransformFile()) {
                if (ReactNativeBlobUtilFileTransformer.sharedFileTransformer == null) {
                    throw new IllegalStateException("Write file with transform was specified but the shared file transformer is not set");
                }
                this.destPath = this.destPath.replace("?append=true", "");
                File file = new File(this.destPath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(ReactNativeBlobUtilFileTransformer.sharedFileTransformer.onWriteFile(bytes));
                        fileOutputStream2.close();
                        invoke_callback(null, "path", this.destPath, responseInfo.copy());
                        return;
                    } finally {
                    }
                } catch (Exception e) {
                    invoke_callback("Error from file transformer:" + e.getLocalizedMessage(), responseInfo.copy());
                    return;
                }
            } else {
                if (this.responseFormat == ResponseFormat.BASE64) {
                    invoke_callback(null, "base64", Base64.encodeToString(bytes, 2), responseInfo.copy());
                    return;
                }
                try {
                    Charset forName = Charset.forName("UTF-8");
                    forName.newDecoder().decode(ByteBuffer.wrap(bytes));
                    invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(bytes, forName));
                } catch (CharacterCodingException unused2) {
                    if (this.responseFormat == ResponseFormat.UTF8) {
                        invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(bytes), responseInfo.copy());
                    } else {
                        invoke_callback(null, "base64", Base64.encodeToString(bytes, 2), responseInfo.copy());
                    }
                }
            }
            invoke_callback("ReactNativeBlobUtil failed to encode response data to BASE64 string.", responseInfo.copy());
        } else if (i == 2) {
            ResponseBody body = response.body();
            try {
                body.bytes();
            } catch (Exception unused3) {
            }
            try {
                ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp = (ReactNativeBlobUtilFileResp) body;
                if (reactNativeBlobUtilFileResp != null && !reactNativeBlobUtilFileResp.isDownloadComplete()) {
                    invoke_callback("Download interrupted.", responseInfo.copy());
                } else {
                    String replace = this.destPath.replace("?append=true", "");
                    this.destPath = replace;
                    invoke_callback(null, "path", replace, responseInfo.copy());
                }
            } catch (ClassCastException unused4) {
                if (body != null) {
                    try {
                        boolean z = body.getSource().getBufferField().size() > 0;
                        boolean z2 = body.getContentLength() > 0;
                        if (z && z2) {
                            str = body.string();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    invoke_callback("Unexpected FileStorage response file: " + str, responseInfo.copy());
                    return;
                }
                invoke_callback("Unexpected FileStorage response with no file.", responseInfo.copy());
                return;
            }
        } else {
            try {
                invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(response.body().bytes(), "UTF-8"), responseInfo.copy());
            } catch (IOException unused5) {
                invoke_callback("ReactNativeBlobUtil failed to encode response data to UTF8 string.", responseInfo.copy());
            }
        }
        response.body().close();
        releaseTaskResource();
    }

    public static ReactNativeBlobUtilProgressConfig getReportProgress(String str) {
        if (progressReport.containsKey(str)) {
            return progressReport.get(str);
        }
        return null;
    }

    public static ReactNativeBlobUtilProgressConfig getReportUploadProgress(String str) {
        if (uploadProgressReport.containsKey(str)) {
            return uploadProgressReport.get(str);
        }
        return null;
    }

    private WritableMap getResponseInfo(Response response, boolean z) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("status", response.code());
        createMap.putString("state", ExifInterface.GPS_MEASUREMENT_2D);
        createMap.putString("taskId", this.taskId);
        createMap.putBoolean(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, this.timeout);
        WritableMap createMap2 = Arguments.createMap();
        for (int i = 0; i < response.headers().size(); i++) {
            createMap2.putString(response.headers().name(i), response.headers().value(i));
        }
        WritableArray createArray = Arguments.createArray();
        Iterator<String> it = this.redirects.iterator();
        while (it.hasNext()) {
            createArray.pushString(it.next());
        }
        createMap.putArray("redirects", createArray);
        createMap.putMap("headers", createMap2);
        Headers headers = response.headers();
        if (z) {
            createMap.putString("respType", "blob");
        } else if (getHeaderIgnoreCases(headers, "content-type").equalsIgnoreCase("text/")) {
            createMap.putString("respType", "text");
        } else if (getHeaderIgnoreCases(headers, "content-type").contains("application/json")) {
            createMap.putString("respType", "json");
        } else {
            createMap.putString("respType", "");
        }
        return createMap;
    }

    private boolean isBlobResponse(Response response) {
        boolean z;
        String headerIgnoreCases = getHeaderIgnoreCases(response.headers(), "Content-Type");
        boolean equalsIgnoreCase = headerIgnoreCases.equalsIgnoreCase("text/");
        boolean equalsIgnoreCase2 = headerIgnoreCases.equalsIgnoreCase("application/json");
        if (this.options.binaryContentTypes != null) {
            for (int i = 0; i < this.options.binaryContentTypes.size(); i++) {
                if (headerIgnoreCases.toLowerCase(Locale.ROOT).contains(this.options.binaryContentTypes.getString(i).toLowerCase(Locale.ROOT))) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return (equalsIgnoreCase2 && equalsIgnoreCase) || z;
    }

    private String getHeaderIgnoreCases(Headers headers, String str) {
        String str2 = headers.get(str);
        return str2 != null ? str2 : headers.get(str.toLowerCase(Locale.ROOT)) == null ? "" : headers.get(str.toLowerCase(Locale.ROOT));
    }

    private String getHeaderIgnoreCases(HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = hashMap.get(str.toLowerCase(Locale.ROOT));
        return str3 == null ? "" : str3;
    }

    private void emitStateEvent(WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_HTTP_STATE, writableMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.onReceive(android.content.Context, android.content.Intent):void");
    }
}
