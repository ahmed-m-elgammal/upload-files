package com.imagepicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import androidx.camera.video.AudioStats;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes5.dex */
public class Utils {
    public static String cameraPermissionDescription = "This library does not require Manifest.permission.CAMERA, if you add this permission in manifest then you have to obtain the same.";
    public static String errCameraUnavailable = "camera_unavailable";
    public static String errOthers = "others";
    public static String errPermission = "permission";
    public static String fileNamePrefix = "rn_image_picker_lib_temp_";
    public static String mediaTypePhoto = "photo";
    public static String mediaTypeVideo = "video";

    static boolean isValidRequestCode(int i) {
        switch (i) {
            case ImagePickerModuleImpl.REQUEST_LAUNCH_IMAGE_CAPTURE /* 13001 */:
            case ImagePickerModuleImpl.REQUEST_LAUNCH_VIDEO_CAPTURE /* 13002 */:
            case ImagePickerModuleImpl.REQUEST_LAUNCH_LIBRARY /* 13003 */:
                return true;
            default:
                return false;
        }
    }

    public static File createFile(Context context, String str) {
        try {
            File file = new File(context.getCacheDir(), fileNamePrefix + UUID.randomUUID() + "." + str);
            file.createNewFile();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Uri createUri(File file, Context context) {
        return FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".imagepickerprovider", file);
    }

    public static void saveToPublicDirectory(Uri uri, Context context, String str) {
        Uri insert;
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        if (str.equals("video")) {
            contentValues.put("_display_name", UUID.randomUUID().toString());
            contentValues.put("mime_type", contentResolver.getType(uri));
            insert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        } else {
            contentValues.put("_display_name", UUID.randomUUID().toString());
            contentValues.put("mime_type", contentResolver.getType(uri));
            insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        copyUri(uri, insert, contentResolver);
    }

    public static void copyUri(Uri uri, Uri uri2, ContentResolver contentResolver) {
        try {
            OutputStream openOutputStream = contentResolver.openOutputStream(uri2);
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            openOutputStream.write(bArr, 0, read);
                        }
                    }
                    if (openInputStream != null) {
                        openInputStream.close();
                    }
                    if (openOutputStream != null) {
                        openOutputStream.close();
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Uri getAppSpecificStorageUri(Uri uri, Context context) {
        String string;
        int lastIndexOf;
        if (uri == null) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        String fileTypeFromMime = getFileTypeFromMime(contentResolver.getType(uri));
        if (fileTypeFromMime == null) {
            Cursor query = contentResolver.query(uri, null, null, null, null);
            if (query.moveToFirst() && (lastIndexOf = (string = query.getString(query.getColumnIndex("_display_name"))).lastIndexOf(46)) != -1) {
                fileTypeFromMime = string.substring(lastIndexOf + 1);
            }
        }
        Uri fromFile = Uri.fromFile(createFile(context, fileTypeFromMime));
        copyUri(uri, fromFile, contentResolver);
        return fromFile;
    }

    public static boolean isCameraAvailable(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera") || context.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    public static void setFrontCamera(Intent intent) {
        intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
        if (Build.VERSION.SDK_INT >= 26) {
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        }
    }

    public static int[] getImageDimensions(Uri uri, Context context) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                String orientation = getOrientation(uri, context);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(openInputStream, null, options);
                if (needToSwapDimension(orientation)) {
                    int[] iArr = {options.outHeight, options.outWidth};
                    if (openInputStream != null) {
                        openInputStream.close();
                    }
                    return iArr;
                }
                int[] iArr2 = {options.outWidth, options.outHeight};
                if (openInputStream != null) {
                    openInputStream.close();
                }
                return iArr2;
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new int[]{0, 0};
        }
    }

    static boolean hasPermission(Activity activity) {
        return ActivityCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    static String getBase64String(Uri uri, Context context) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    byteArrayOutputStream.close();
                    if (openInputStream != null) {
                        openInputStream.close();
                    }
                    return encodeToString;
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean needToSwapDimension(String str) {
        return str.equals(String.valueOf(6)) || str.equals(String.valueOf(8));
    }

    public static Uri resizeImage(Uri uri, Context context, Options options) {
        Bitmap createScaledBitmap;
        try {
            int[] imageDimensions = getImageDimensions(uri, context);
            if (!shouldResizeImage(imageDimensions[0], imageDimensions[1], options)) {
                return uri;
            }
            int[] imageDimensBasedOnConstraints = getImageDimensBasedOnConstraints(imageDimensions[0], imageDimensions[1], options);
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                String mimeType = getMimeType(uri, context);
                Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream);
                String orientation = getOrientation(uri, context);
                if (needToSwapDimension(orientation)) {
                    createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, imageDimensBasedOnConstraints[1], imageDimensBasedOnConstraints[0], true);
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, imageDimensBasedOnConstraints[0], imageDimensBasedOnConstraints[1], true);
                }
                File createFile = createFile(context, getFileTypeFromMime(mimeType));
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(Uri.fromFile(createFile));
                try {
                    createScaledBitmap.compress(getBitmapCompressFormat(mimeType), options.quality, openOutputStream);
                    if (openOutputStream != null) {
                        openOutputStream.close();
                    }
                    setOrientation(createFile, orientation, context);
                    deleteFile(uri);
                    Uri fromFile = Uri.fromFile(createFile);
                    if (openInputStream != null) {
                        openInputStream.close();
                    }
                    return fromFile;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return uri;
        }
    }

    static String getOrientation(Uri uri, Context context) throws IOException {
        return new ExifInterface(context.getContentResolver().openInputStream(uri)).getAttribute(ExifInterface.TAG_ORIENTATION);
    }

    static void setOrientation(File file, String str, Context context) throws IOException {
        if (str.equals(String.valueOf(1)) || str.equals(String.valueOf(0))) {
            return;
        }
        ExifInterface exifInterface = new ExifInterface(file);
        exifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, str);
        exifInterface.saveAttributes();
    }

    static int[] getImageDimensBasedOnConstraints(int i, int i2, Options options) {
        if (options.maxWidth == 0 || options.maxHeight == 0) {
            return new int[]{i, i2};
        }
        if (options.maxWidth < i) {
            i2 = (int) ((options.maxWidth / i) * i2);
            i = options.maxWidth;
        }
        if (options.maxHeight < i2) {
            i = (int) ((options.maxHeight / i2) * i);
            i2 = options.maxHeight;
        }
        return new int[]{i, i2};
    }

    static double getFileSize(Uri uri, Context context) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            try {
                double statSize = openFileDescriptor.getStatSize();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return statSize;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    static boolean shouldResizeImage(int i, int i2, Options options) {
        if ((options.maxWidth == 0 || options.maxHeight == 0) && options.quality == 100) {
            return false;
        }
        return options.maxWidth < i || options.maxHeight < i2 || options.quality != 100;
    }

    static Bitmap.CompressFormat getBitmapCompressFormat(String str) {
        str.hashCode();
        if (str.equals("image/jpeg")) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (str.equals("image/png")) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    static String getFileTypeFromMime(String str) {
        if (str == null) {
            return "jpg";
        }
        str.hashCode();
        switch (str) {
            case "image/jpeg":
                return "jpg";
            case "image/gif":
                return "gif";
            case "image/png":
                return "png";
            default:
                return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
    }

    static void deleteFile(Uri uri) {
        new File(uri.getPath()).delete();
    }

    public static boolean isCameraPermissionFulfilled(Context context, Activity activity) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && Arrays.asList(strArr).contains("android.permission.CAMERA")) {
                if (ActivityCompat.checkSelfPermission(activity, "android.permission.CAMERA") != 0) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }

    static boolean isImageType(Uri uri, Context context) {
        return isContentType("image/", uri, context);
    }

    static boolean isVideoType(Uri uri, Context context) {
        return isContentType("video/", uri, context);
    }

    static boolean isContentType(String str, Uri uri, Context context) {
        String mimeType = getMimeType(uri, context);
        if (mimeType != null) {
            return mimeType.contains(str);
        }
        return false;
    }

    static String getMimeType(Uri uri, Context context) {
        if (uri.getScheme().equals("file")) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()));
        }
        if (uri.getScheme().equals(UriUtil.LOCAL_CONTENT_SCHEME)) {
            String type = context.getContentResolver().getType(uri);
            return Utils$$ExternalSyntheticBackport0.m(type) ? getMimeTypeForContent(uri, context) : type;
        }
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    static String getMimeTypeForContent(Uri uri, Context context) {
        String fileNameForContent = getFileNameForContent(uri, context);
        int lastIndexOf = fileNameForContent.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        return fileNameForContent.substring(lastIndexOf + 1);
    }

    static String getFileName(Uri uri, Context context) {
        if (uri.getScheme().equals("file")) {
            return uri.getLastPathSegment();
        }
        if (uri.getScheme().equals(UriUtil.LOCAL_CONTENT_SCHEME)) {
            return getFileNameForContent(uri, context);
        }
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    static String getOriginalFilePath(Uri uri, Context context) {
        if (uri.getScheme().contains(UriUtil.LOCAL_CONTENT_SCHEME)) {
            String filePathFromContent = getFilePathFromContent(uri, context);
            getAppSpecificStorageUri(uri, context);
            return filePathFromContent;
        }
        return uri.toString();
    }

    private static String getFilePathFromContent(Uri uri, Context context) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        try {
            int columnIndex = query.getColumnIndex("_data");
            if (columnIndex == -1) {
                if (query == null) {
                    return null;
                }
                query.close();
                return null;
            }
            query.moveToFirst();
            String string = query.getString(columnIndex);
            if (query != null) {
                query.close();
            }
            return string;
        } catch (Throwable th) {
            if (query != null) {
                try {
                    query.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static String getFileNameForContent(Uri uri, Context context) {
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        String lastPathSegment = uri.getLastPathSegment();
        try {
            if (query.moveToFirst()) {
                lastPathSegment = query.getString(query.getColumnIndex("_display_name"));
            }
            return lastPathSegment;
        } finally {
            query.close();
        }
    }

    static List<Uri> collectUrisFromData(Intent intent) {
        if (intent.getClipData() == null) {
            return Collections.singletonList(intent.getData());
        }
        ClipData clipData = intent.getClipData();
        ArrayList arrayList = new ArrayList(clipData.getItemCount());
        for (int i = 0; i < clipData.getItemCount(); i++) {
            arrayList.add(clipData.getItemAt(i).getUri());
        }
        return arrayList;
    }

    static ReadableMap getImageResponseMap(Uri uri, Uri uri2, Options options, Context context) {
        ImageMetadata imageMetadata = new ImageMetadata(uri2, context);
        int[] imageDimensions = getImageDimensions(uri2, context);
        String fileName = getFileName(uri, context);
        String originalFilePath = getOriginalFilePath(uri, context);
        WritableMap createMap = Arguments.createMap();
        createMap.putString("uri", uri2.toString());
        createMap.putDouble("fileSize", getFileSize(uri2, context));
        createMap.putString("fileName", fileName);
        createMap.putInt("width", imageDimensions[0]);
        createMap.putInt("height", imageDimensions[1]);
        createMap.putString("type", getMimeType(uri2, context));
        createMap.putString("originalPath", originalFilePath);
        if (options.includeBase64.booleanValue()) {
            createMap.putString("base64", getBase64String(uri2, context));
        }
        if (options.includeExtra.booleanValue()) {
            createMap.putString("timestamp", imageMetadata.getDateTime());
            createMap.putString("id", fileName);
        }
        return createMap;
    }

    static ReadableMap getVideoResponseMap(Uri uri, Uri uri2, Options options, Context context) {
        WritableMap createMap = Arguments.createMap();
        VideoMetadata videoMetadata = new VideoMetadata(uri2, context);
        String fileName = getFileName(uri, context);
        String originalFilePath = getOriginalFilePath(uri, context);
        createMap.putString("uri", uri2.toString());
        createMap.putDouble("fileSize", getFileSize(uri2, context));
        createMap.putInt("duration", videoMetadata.getDuration());
        createMap.putInt("bitrate", videoMetadata.getBitrate());
        createMap.putString("fileName", fileName);
        createMap.putString("type", getMimeType(uri2, context));
        createMap.putInt("width", videoMetadata.getWidth());
        createMap.putInt("height", videoMetadata.getHeight());
        createMap.putString("originalPath", originalFilePath);
        if (options.includeExtra.booleanValue()) {
            createMap.putString("timestamp", videoMetadata.getDateTime());
            createMap.putString("id", fileName);
        }
        return createMap;
    }

    static ReadableMap getResponseMap(List<Uri> list, Options options, Context context) throws RuntimeException {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < list.size(); i++) {
            Uri uri = list.get(i);
            Uri appSpecificStorageUri = uri.getScheme().contains(UriUtil.LOCAL_CONTENT_SCHEME) ? getAppSpecificStorageUri(uri, context) : uri;
            if (isImageType(uri, context)) {
                createArray.pushMap(getImageResponseMap(uri, resizeImage(appSpecificStorageUri, context, options), options, context));
            } else if (isVideoType(uri, context)) {
                if (uri.getScheme().contains(UriUtil.LOCAL_CONTENT_SCHEME)) {
                    appSpecificStorageUri = getAppSpecificStorageUri(uri, context);
                }
                createArray.pushMap(getVideoResponseMap(uri, appSpecificStorageUri, options, context));
            } else {
                throw new RuntimeException("Unsupported file type");
            }
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putArray("assets", createArray);
        return createMap;
    }

    static ReadableMap getErrorMap(String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("errorCode", str);
        if (str2 != null) {
            createMap.putString("errorMessage", str2);
        }
        return createMap;
    }

    static ReadableMap getCancelMap() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("didCancel", true);
        return createMap;
    }
}
