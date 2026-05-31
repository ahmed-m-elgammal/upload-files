package expo.modules.sqlite;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SQLiteHelpers.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, d2 = {"ensureDirExists", "Ljava/io/File;", "dir", "expo-sqlite_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SQLiteHelpersKt {
    public static final File ensureDirExists(File dir) throws IOException {
        String str;
        Intrinsics.checkNotNullParameter(dir, "dir");
        if (!dir.isDirectory()) {
            if (dir.isFile()) {
                throw new IOException("Path '" + dir + "' points to a file, but must point to a directory.");
            }
            if (!dir.mkdirs()) {
                if (!dir.exists()) {
                    str = "";
                } else {
                    str = "Path already points to a non-normal file.";
                }
                if (dir.getParentFile() == null) {
                    str = "Parent directory is null.";
                }
                throw new IOException("Couldn't create directory '" + dir + "'. " + str);
            }
        }
        return dir;
    }
}
