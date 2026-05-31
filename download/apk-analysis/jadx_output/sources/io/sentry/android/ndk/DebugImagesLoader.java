package io.sentry.android.ndk;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.IDebugImagesLoader;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.protocol.DebugImage;
import io.sentry.util.Objects;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public final class DebugImagesLoader implements IDebugImagesLoader {
    private static volatile List<DebugImage> debugImages;
    private static final Object debugImagesLock = new Object();
    private final NativeModuleListLoader moduleListLoader;
    private final SentryOptions options;

    public DebugImagesLoader(SentryAndroidOptions sentryAndroidOptions, NativeModuleListLoader nativeModuleListLoader) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryAndroidOptions, "The SentryAndroidOptions is required.");
        this.moduleListLoader = (NativeModuleListLoader) Objects.requireNonNull(nativeModuleListLoader, "The NativeModuleListLoader is required.");
    }

    @Override // io.sentry.android.core.IDebugImagesLoader
    public List<DebugImage> loadDebugImages() {
        synchronized (debugImagesLock) {
            if (debugImages == null) {
                try {
                    DebugImage[] loadModuleList = this.moduleListLoader.loadModuleList();
                    if (loadModuleList != null) {
                        debugImages = Arrays.asList(loadModuleList);
                        this.options.getLogger().log(SentryLevel.DEBUG, "Debug images loaded: %d", Integer.valueOf(debugImages.size()));
                    }
                } catch (Throwable th) {
                    this.options.getLogger().log(SentryLevel.ERROR, th, "Failed to load debug images.", new Object[0]);
                }
            }
        }
        return debugImages;
    }

    @Override // io.sentry.android.core.IDebugImagesLoader
    public Set<DebugImage> loadDebugImagesForAddresses(Set<String> set) {
        synchronized (debugImagesLock) {
            List<DebugImage> loadDebugImages = loadDebugImages();
            if (loadDebugImages == null) {
                return null;
            }
            if (set.isEmpty()) {
                return null;
            }
            Set<DebugImage> filterImagesByAddresses = filterImagesByAddresses(loadDebugImages, set);
            if (!filterImagesByAddresses.isEmpty()) {
                return filterImagesByAddresses;
            }
            this.options.getLogger().log(SentryLevel.WARNING, "No debug images found for any of the %d addresses.", Integer.valueOf(set.size()));
            return null;
        }
    }

    private Set<DebugImage> filterImagesByAddresses(List<DebugImage> list, Set<String> set) {
        long parseLong;
        HashSet hashSet = new HashSet();
        int i = 0;
        while (i < list.size()) {
            DebugImage debugImage = list.get(i);
            i++;
            DebugImage debugImage2 = i < list.size() ? list.get(i) : null;
            String imageAddr = debugImage2 != null ? debugImage2.getImageAddr() : null;
            Iterator<String> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    try {
                        long parseLong2 = Long.parseLong(it.next().replace("0x", ""), 16);
                        String imageAddr2 = debugImage.getImageAddr();
                        if (imageAddr2 != null) {
                            long parseLong3 = Long.parseLong(imageAddr2.replace("0x", ""), 16);
                            Long imageSize = debugImage.getImageSize();
                            if (imageSize != null) {
                                parseLong = imageSize.longValue() + parseLong3;
                            } else {
                                parseLong = imageAddr != null ? Long.parseLong(imageAddr.replace("0x", ""), 16) : Long.MAX_VALUE;
                            }
                            if (parseLong2 >= parseLong3 && parseLong2 < parseLong) {
                                hashSet.add(debugImage);
                                break;
                            }
                        } else {
                            continue;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        return hashSet;
    }

    @Override // io.sentry.android.core.IDebugImagesLoader
    public void clearDebugImages() {
        synchronized (debugImagesLock) {
            try {
                this.moduleListLoader.clearModuleList();
                this.options.getLogger().log(SentryLevel.INFO, "Debug images cleared.", new Object[0]);
            } finally {
                debugImages = null;
            }
            debugImages = null;
        }
    }

    List<DebugImage> getCachedDebugImages() {
        return debugImages;
    }
}
