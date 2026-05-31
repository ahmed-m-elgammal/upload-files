package expo.modules.imagemanipulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Lexpo/modules/imagemanipulator/FileUtils;", "", "()V", "ensureDirExists", "Ljava/io/File;", "dir", "generateRandomOutputPath", "", "context", "Landroid/content/Context;", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "toExtension", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    /* compiled from: FileUtils.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            try {
                iArr[Bitmap.CompressFormat.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FileUtils() {
    }

    public final String generateRandomOutputPath(Context context, Bitmap.CompressFormat compressFormat) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        File file = new File(context.getCacheDir() + File.separator + "ImageManipulator");
        ensureDirExists(file);
        return file + File.separator + UUID.randomUUID() + toExtension(compressFormat);
    }

    private final File ensureDirExists(File dir) throws IOException {
        if (dir.isDirectory() || dir.mkdirs()) {
            return dir;
        }
        throw new IOException("Couldn't create directory '" + dir + "'");
    }

    private final String toExtension(Bitmap.CompressFormat compressFormat) {
        Bitmap.CompressFormat compressFormat2;
        int i = WhenMappings.$EnumSwitchMapping$0[compressFormat.ordinal()];
        if (i == 1) {
            return ".jpg";
        }
        if (i == 2) {
            return ".png";
        }
        if (Build.VERSION.SDK_INT >= 30) {
            compressFormat2 = Bitmap.CompressFormat.WEBP_LOSSY;
        } else {
            compressFormat2 = Bitmap.CompressFormat.WEBP;
        }
        if (compressFormat != compressFormat2) {
            return ".jpg";
        }
        return ".webp";
    }
}
