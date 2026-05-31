package io.sentry.react;

import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ReadableMap;
import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import java.util.Map;

/* loaded from: classes6.dex */
public final class RNSentryBreadcrumb {
    private RNSentryBreadcrumb() {
        throw new AssertionError("Utility class should not be instantiated");
    }

    public static String getCurrentScreenFrom(ReadableMap readableMap) {
        String string = readableMap.hasKey("category") ? readableMap.getString("category") : null;
        if (string == null || !NotificationCompat.CATEGORY_NAVIGATION.equals(string)) {
            return null;
        }
        ReadableMap map = readableMap.hasKey("data") ? readableMap.getMap("data") : null;
        if (map == null) {
            return null;
        }
        try {
            if (map.hasKey("to")) {
                return map.getString("to");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Breadcrumb fromMap(ReadableMap readableMap) {
        char c;
        Breadcrumb breadcrumb = new Breadcrumb();
        if (readableMap.hasKey("message")) {
            breadcrumb.setMessage(readableMap.getString("message"));
        }
        if (readableMap.hasKey("type")) {
            breadcrumb.setType(readableMap.getString("type"));
        }
        if (readableMap.hasKey("category")) {
            breadcrumb.setCategory(readableMap.getString("category"));
        }
        if (readableMap.hasKey("origin")) {
            breadcrumb.setOrigin(readableMap.getString("origin"));
        } else {
            breadcrumb.setOrigin("react-native");
        }
        if (readableMap.hasKey("level")) {
            String string = readableMap.getString("level");
            switch (string.hashCode()) {
                case 3237038:
                    if (string.equals("info")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 95458899:
                    if (string.equals("debug")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 96784904:
                    if (string.equals("error")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 97203460:
                    if (string.equals("fatal")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1124446108:
                    if (string.equals("warning")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                breadcrumb.setLevel(SentryLevel.FATAL);
            } else if (c == 1) {
                breadcrumb.setLevel(SentryLevel.WARNING);
            } else if (c == 2) {
                breadcrumb.setLevel(SentryLevel.DEBUG);
            } else if (c == 3) {
                breadcrumb.setLevel(SentryLevel.ERROR);
            } else {
                breadcrumb.setLevel(SentryLevel.INFO);
            }
        }
        if (readableMap.hasKey("data")) {
            for (Map.Entry<String, Object> entry : readableMap.getMap("data").toHashMap().entrySet()) {
                if (entry.getValue() != null) {
                    breadcrumb.setData(entry.getKey(), entry.getValue());
                }
            }
        }
        return breadcrumb;
    }
}
