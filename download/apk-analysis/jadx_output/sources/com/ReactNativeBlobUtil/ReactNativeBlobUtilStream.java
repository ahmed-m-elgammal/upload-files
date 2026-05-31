package com.ReactNativeBlobUtil;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes3.dex */
public class ReactNativeBlobUtilStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final HashMap<String, ReactNativeBlobUtilStream> fileStreams = new HashMap<>();
    private final DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private String encoding = "base64";
    private OutputStream writeStreamInstance = null;

    ReactNativeBlobUtilStream(ReactApplicationContext reactApplicationContext) {
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    void readStream(String str, String str2, int i, int i2, String str3, ReactApplicationContext reactApplicationContext) {
        String str4;
        int i3;
        InputStream openInputStream;
        int i4;
        int i5;
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        String str5 = normalizePath != null ? normalizePath : str;
        try {
            try {
                i3 = str2.equalsIgnoreCase("base64") ? 4095 : 4096;
                if (i > 0) {
                    i3 = i;
                }
                openInputStream = (normalizePath == null || !str5.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) ? normalizePath == null ? ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(str5)) : new FileInputStream(new File(str5)) : ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str5.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                str4 = -1;
                i5 = -1;
                i4 = 0;
            } catch (FileNotFoundException unused) {
                str4 = str5;
            }
            try {
                if (str2.equalsIgnoreCase(ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8)) {
                    InputStreamReader inputStreamReader = new InputStreamReader(openInputStream, Charset.forName("UTF-8"));
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader, i3);
                    char[] cArr = new char[i3];
                    while (true) {
                        int read = bufferedReader.read(cArr, i4, i3);
                        if (read == i5) {
                            break;
                        }
                        emitStreamEvent(str3, "data", new String(cArr, i4, read));
                        if (i2 > 0) {
                            SystemClock.sleep(i2);
                        }
                        i5 = -1;
                        i4 = 0;
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                } else if (str2.equalsIgnoreCase("ascii")) {
                    byte[] bArr = new byte[i3];
                    while (true) {
                        int read2 = openInputStream.read(bArr);
                        if (read2 == -1) {
                            break;
                        }
                        WritableArray createArray = Arguments.createArray();
                        for (int i6 = 0; i6 < read2; i6++) {
                            createArray.pushInt(bArr[i6]);
                        }
                        emitStreamEvent(str3, "data", createArray);
                        if (i2 > 0) {
                            SystemClock.sleep(i2);
                        }
                    }
                } else {
                    if (!str2.equalsIgnoreCase("base64")) {
                        str4 = str5;
                        emitStreamEvent(str3, "error", "EINVAL", "Unrecognized encoding `" + str2 + "`, should be one of `base64`, `utf8`, `ascii`");
                        openInputStream.close();
                    }
                    byte[] bArr2 = new byte[i3];
                    while (true) {
                        int read3 = openInputStream.read(bArr2);
                        if (read3 == -1) {
                            break;
                        }
                        if (read3 < i3) {
                            byte[] bArr3 = new byte[read3];
                            System.arraycopy(bArr2, 0, bArr3, 0, read3);
                            emitStreamEvent(str3, "data", Base64.encodeToString(bArr3, 2));
                        } else {
                            emitStreamEvent(str3, "data", Base64.encodeToString(bArr2, 2));
                        }
                        if (i2 > 0) {
                            String str6 = str5;
                            SystemClock.sleep(i2);
                            str5 = str6;
                        }
                    }
                }
                str4 = str5;
                emitStreamEvent(str3, "end", "");
                openInputStream.close();
            } catch (FileNotFoundException unused2) {
                emitStreamEvent(str3, "error", "ENOENT", "No such file '" + str4 + "'");
            }
        } catch (Exception e) {
            emitStreamEvent(str3, "error", "EUNSPECIFIED", "Failed to convert data to " + str2 + " encoded string. This might be because this encoding cannot be used for this data.");
            e.printStackTrace();
        }
    }

    void writeStream(String str, String str2, boolean z, Callback callback) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        if (normalizePath != null) {
            str = normalizePath;
        }
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (normalizePath == null || file.exists()) {
                if (file.isDirectory()) {
                    callback.invoke("EISDIR", "Expecting a file but '" + str + "' is a directory");
                    return;
                }
            } else {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    callback.invoke("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                }
                if (!file.createNewFile()) {
                    callback.invoke("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            OutputStream openOutputStream = (normalizePath == null || !str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) ? normalizePath == null ? ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openOutputStream(Uri.parse(str)) : new FileOutputStream(str, z) : ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")).createOutputStream();
            this.encoding = str2;
            String uuid = UUID.randomUUID().toString();
            fileStreams.put(uuid, this);
            this.writeStreamInstance = openOutputStream;
            callback.invoke(null, null, uuid);
        } catch (Exception e) {
            callback.invoke("EUNSPECIFIED", "Failed to create write stream at path `" + str + "`; " + e.getLocalizedMessage());
        }
    }

    static void writeChunk(String str, String str2, Callback callback) {
        ReactNativeBlobUtilStream reactNativeBlobUtilStream = fileStreams.get(str);
        try {
            reactNativeBlobUtilStream.writeStreamInstance.write(ReactNativeBlobUtilUtils.stringToBytes(str2, reactNativeBlobUtilStream.encoding));
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            outputStream.write(bArr);
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void closeStream(String str, Callback callback) {
        try {
            HashMap<String, ReactNativeBlobUtilStream> hashMap = fileStreams;
            OutputStream outputStream = hashMap.get(str).writeStreamInstance;
            hashMap.remove(str);
            outputStream.close();
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    private void emitStreamEvent(String str, String str2, String str3) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putString("detail", str3);
        createMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, createMap);
    }

    private void emitStreamEvent(String str, String str2, WritableArray writableArray) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putArray("detail", writableArray);
        createMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, createMap);
    }

    private void emitStreamEvent(String str, String str2, String str3, String str4) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putString("code", str3);
        createMap.putString("detail", str4);
        createMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, createMap);
    }
}
