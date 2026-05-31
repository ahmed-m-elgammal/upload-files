package com.reactnativecommunity.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Base64;
import androidx.webkit.internal.AssetHelper;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@ReactModule(name = ClipboardModule.NAME)
/* loaded from: classes5.dex */
public class ClipboardModule extends NativeClipboardModuleSpec {
    public static final String CLIPBOARD_TEXT_CHANGED = "RNCClipboard_TEXT_CHANGED";
    public static final String MIMETYPE_HEIC = "image/heic";
    public static final String MIMETYPE_HEIF = "image/heif";
    public static final String MIMETYPE_JPEG = "image/jpeg";
    public static final String MIMETYPE_JPG = "image/jpg";
    public static final String MIMETYPE_PNG = "image/png";
    public static final String MIMETYPE_WEBP = "image/webp";
    public static final String NAME = "RNCClipboard";
    private ClipboardManager.OnPrimaryClipChangedListener listener;
    private ReactApplicationContext reactContext;

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    public void removeListeners(double d) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    public void setStrings(ReadableArray readableArray) {
    }

    public ClipboardModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.listener = null;
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    private ClipboardManager getClipboardService() {
        return (ClipboardManager) this.reactContext.getSystemService("clipboard");
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    @ReactMethod
    public void getString(Promise promise) {
        try {
            ClipData primaryClip = getClipboardService().getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() >= 1) {
                promise.resolve("" + ((Object) primaryClip.getItemAt(0).getText()));
            } else {
                promise.resolve("");
            }
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    public void getStrings(Promise promise) {
        promise.reject("Clipboard:getStrings", "getStrings is not supported on Android");
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    public void getImagePNG(Promise promise) {
        promise.reject("Clipboard:getImagePNG", "getImagePNG is not supported on Android");
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    public void getImageJPG(Promise promise) {
        promise.reject("Clipboard:getImageJPG", "getImageJPG is not supported on Android");
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    public void setImage(String str, Promise promise) {
        promise.reject("Clipboard:setImage", "setImage is not supported on Android");
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    @ReactMethod
    public void setString(String str) {
        try {
            getClipboardService().setPrimaryClip(ClipData.newPlainText(null, str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    @ReactMethod
    public void hasString(Promise promise) {
        boolean z;
        try {
            ClipData primaryClip = getClipboardService().getPrimaryClip();
            if (primaryClip != null) {
                z = true;
                if (primaryClip.getItemCount() >= 1) {
                    promise.resolve(Boolean.valueOf(z));
                }
            }
            z = false;
            promise.resolve(Boolean.valueOf(z));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    public void hasImage(Promise promise) {
        promise.reject("Clipboard:hasImage", "hasImage is not supported on Android");
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    public void hasURL(Promise promise) {
        promise.reject("Clipboard:hasURL", "hasURL is not supported on Android");
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    public void hasNumber(Promise promise) {
        promise.reject("Clipboard:hasNumber", "hasNumber is not supported on Android");
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    public void hasWebURL(Promise promise) {
        promise.reject("Clipboard:hasWebURL", "hasWebURL is not supported on Android");
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    @ReactMethod
    public void getImage(Promise promise) {
        Uri uri;
        ContentResolver contentResolver;
        String type;
        char c;
        Bitmap.CompressFormat compressFormat;
        ClipboardManager clipboardService = getClipboardService();
        if (!clipboardService.hasPrimaryClip()) {
            promise.resolve("");
            return;
        }
        if (clipboardService.getPrimaryClipDescription().hasMimeType(AssetHelper.DEFAULT_MIME_TYPE)) {
            promise.resolve("");
            return;
        }
        ClipData primaryClip = clipboardService.getPrimaryClip();
        if (primaryClip != null && (uri = primaryClip.getItemAt(0).getUri()) != null && (type = (contentResolver = this.reactContext.getContentResolver()).getType(uri)) != null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                switch (type.hashCode()) {
                    case -1487464693:
                        if (type.equals(MIMETYPE_HEIC)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1487464690:
                        if (type.equals("image/heif")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1487394660:
                        if (type.equals("image/jpeg")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1487018032:
                        if (type.equals("image/webp")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -879264467:
                        if (type.equals(MIMETYPE_JPG)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -879258763:
                        if (type.equals("image/png")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0 || c == 1) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                } else if (c == 2 || c == 3 || c == 4) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                } else {
                    if (c != 5) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT > 29) {
                        compressFormat = Bitmap.CompressFormat.WEBP_LOSSLESS;
                        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                    } else {
                        bitmap.compress(Bitmap.CompressFormat.WEBP, 100, byteArrayOutputStream);
                    }
                }
                promise.resolve("data:" + type + ";base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
            } catch (IOException e) {
                promise.reject(e);
                e.printStackTrace();
            }
        }
        promise.resolve("");
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    @ReactMethod
    public void setListener() {
        try {
            ClipboardManager clipboardService = getClipboardService();
            ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: com.reactnativecommunity.clipboard.ClipboardModule.1
                @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                public void onPrimaryClipChanged() {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) ClipboardModule.this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ClipboardModule.CLIPBOARD_TEXT_CHANGED, null);
                }
            };
            this.listener = onPrimaryClipChangedListener;
            clipboardService.addPrimaryClipChangedListener(onPrimaryClipChangedListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.reactnativecommunity.clipboard.NativeClipboardModuleSpec
    @ReactMethod
    public void removeListener() {
        if (this.listener != null) {
            try {
                getClipboardService().removePrimaryClipChangedListener(this.listener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
