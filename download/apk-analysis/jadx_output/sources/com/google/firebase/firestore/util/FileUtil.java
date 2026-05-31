package com.google.firebase.firestore.util;

import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/* loaded from: classes5.dex */
public class FileUtil {
    public static void delete(File file) throws IOException {
        if (Build.VERSION.SDK_INT >= 26) {
            DefaultFileDeleter.delete(file);
        } else {
            LegacyFileDeleter.delete(file);
        }
    }

    private static class DefaultFileDeleter {
        private DefaultFileDeleter() {
        }

        public static void delete(File file) throws IOException {
            Path path;
            try {
                path = file.toPath();
                Files.deleteIfExists(path);
            } catch (IOException e) {
                throw new IOException("Failed to delete file " + file + ": " + e);
            }
        }
    }

    private static class LegacyFileDeleter {
        private LegacyFileDeleter() {
        }

        public static void delete(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("Failed to delete file " + file);
        }
    }
}
