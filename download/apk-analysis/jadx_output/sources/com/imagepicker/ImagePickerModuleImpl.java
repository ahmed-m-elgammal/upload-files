package com.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.imagepicker.MediaTypes;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public class ImagePickerModuleImpl implements ActivityEventListener {
    static final String NAME = "ImagePicker";
    public static final int REQUEST_LAUNCH_IMAGE_CAPTURE = 13001;
    public static final int REQUEST_LAUNCH_LIBRARY = 13003;
    public static final int REQUEST_LAUNCH_VIDEO_CAPTURE = 13002;
    Callback callback;
    Uri cameraCaptureURI;
    private Uri fileUri;
    Options options;
    private ReactApplicationContext reactContext;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public ImagePickerModuleImpl(ReactApplicationContext reactApplicationContext) {
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    public void launchCamera(ReadableMap readableMap, Callback callback) {
        Intent intent;
        File createFile;
        int i;
        if (!Utils.isCameraAvailable(this.reactContext)) {
            callback.invoke(Utils.getErrorMap(Utils.errCameraUnavailable, null));
            return;
        }
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, "Activity error"));
            return;
        }
        if (!Utils.isCameraPermissionFulfilled(this.reactContext, currentActivity)) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, Utils.cameraPermissionDescription));
            return;
        }
        this.callback = callback;
        Options options = new Options(readableMap);
        this.options = options;
        if (options.saveToPhotos.booleanValue() && Build.VERSION.SDK_INT <= 28 && !Utils.hasPermission(currentActivity)) {
            callback.invoke(Utils.getErrorMap(Utils.errPermission, null));
            return;
        }
        if (this.options.mediaType.equals(Utils.mediaTypeVideo)) {
            intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", this.options.videoQuality);
            if (this.options.durationLimit > 0) {
                intent.putExtra("android.intent.extra.durationLimit", this.options.durationLimit);
            }
            createFile = Utils.createFile(this.reactContext, RRWebVideoEvent.REPLAY_CONTAINER);
            this.cameraCaptureURI = Utils.createUri(createFile, this.reactContext);
            i = REQUEST_LAUNCH_VIDEO_CAPTURE;
        } else {
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
            createFile = Utils.createFile(this.reactContext, "jpg");
            this.cameraCaptureURI = Utils.createUri(createFile, this.reactContext);
            i = REQUEST_LAUNCH_IMAGE_CAPTURE;
        }
        if (this.options.useFrontCamera.booleanValue()) {
            Utils.setFrontCamera(intent);
        }
        this.fileUri = Uri.fromFile(createFile);
        intent.putExtra("output", this.cameraCaptureURI);
        intent.addFlags(3);
        try {
            currentActivity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException e) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
            this.callback = null;
        }
    }

    public void launchImageLibrary(ReadableMap readableMap, Callback callback) {
        Intent intent;
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, "Activity error"));
            return;
        }
        this.callback = callback;
        Options options = new Options(readableMap);
        this.options = options;
        int i = options.selectionLimit;
        boolean z = i == 1;
        boolean equals = this.options.mediaType.equals(Utils.mediaTypePhoto);
        boolean equals2 = this.options.mediaType.equals(Utils.mediaTypeVideo);
        if (Build.VERSION.SDK_INT >= 33) {
            intent = new Intent("android.provider.action.PICK_IMAGES");
        } else if (z && (equals || equals2)) {
            intent = new Intent("android.intent.action.PICK");
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
        }
        if (!z) {
            if (Build.VERSION.SDK_INT < 33) {
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            } else if (i != 1) {
                if (i == 0) {
                    i = MediaStore.getPickImagesMaxLimit();
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", i);
            }
        }
        if (equals) {
            intent.setType(MediaTypes.ImageAllMimeType);
        } else if (equals2) {
            intent.setType(MediaTypes.VideoAllMimeType);
        } else if (Build.VERSION.SDK_INT < 33) {
            intent.setType(MediaTypes.AllMimeType);
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{MediaTypes.ImageAllMimeType, MediaTypes.VideoAllMimeType});
        }
        try {
            currentActivity.startActivityForResult(intent, REQUEST_LAUNCH_LIBRARY);
        } catch (ActivityNotFoundException e) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
            this.callback = null;
        }
    }

    void onAssetsObtained(final List<Uri> list) {
        Executors.newSingleThreadExecutor().submit(new Runnable() { // from class: com.imagepicker.ImagePickerModuleImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ImagePickerModuleImpl.this.lambda$onAssetsObtained$0(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAssetsObtained$0(List list) {
        try {
            try {
                this.callback.invoke(Utils.getResponseMap(list, this.options, this.reactContext));
            } catch (RuntimeException e) {
                this.callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
            }
        } finally {
            this.callback = null;
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (!Utils.isValidRequestCode(i) || this.callback == null) {
            return;
        }
        if (i2 != -1) {
            if (i == 13001) {
                Utils.deleteFile(this.fileUri);
            }
            try {
                this.callback.invoke(Utils.getCancelMap());
                return;
            } catch (RuntimeException e) {
                this.callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
            } finally {
                this.callback = null;
            }
        }
        switch (i) {
            case REQUEST_LAUNCH_IMAGE_CAPTURE /* 13001 */:
                if (this.options.saveToPhotos.booleanValue()) {
                    Utils.saveToPublicDirectory(this.cameraCaptureURI, this.reactContext, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                }
                onAssetsObtained(Collections.singletonList(this.fileUri));
                return;
            case REQUEST_LAUNCH_VIDEO_CAPTURE /* 13002 */:
                if (this.options.saveToPhotos.booleanValue()) {
                    Utils.saveToPublicDirectory(this.cameraCaptureURI, this.reactContext, "video");
                }
                onAssetsObtained(Collections.singletonList(this.fileUri));
                return;
            case REQUEST_LAUNCH_LIBRARY /* 13003 */:
                onAssetsObtained(Utils.collectUrisFromData(intent));
                return;
            default:
                return;
        }
    }
}
