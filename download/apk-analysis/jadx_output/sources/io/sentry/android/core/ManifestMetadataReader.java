package io.sentry.android.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.util.Objects;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
final class ManifestMetadataReader {
    static final String ANR_ATTACH_THREAD_DUMPS = "io.sentry.anr.attach-thread-dumps";
    static final String ANR_ENABLE = "io.sentry.anr.enable";
    static final String ANR_REPORT_DEBUG = "io.sentry.anr.report-debug";
    static final String ANR_TIMEOUT_INTERVAL_MILLIS = "io.sentry.anr.timeout-interval-millis";
    static final String ATTACH_SCREENSHOT = "io.sentry.attach-screenshot";
    static final String ATTACH_THREADS = "io.sentry.attach-threads";
    static final String ATTACH_VIEW_HIERARCHY = "io.sentry.attach-view-hierarchy";
    static final String AUTO_INIT = "io.sentry.auto-init";
    static final String AUTO_SESSION_TRACKING_ENABLE = "io.sentry.auto-session-tracking.enable";
    static final String BREADCRUMBS_ACTIVITY_LIFECYCLE_ENABLE = "io.sentry.breadcrumbs.activity-lifecycle";
    static final String BREADCRUMBS_APP_COMPONENTS_ENABLE = "io.sentry.breadcrumbs.app-components";
    static final String BREADCRUMBS_APP_LIFECYCLE_ENABLE = "io.sentry.breadcrumbs.app-lifecycle";
    static final String BREADCRUMBS_NETWORK_EVENTS_ENABLE = "io.sentry.breadcrumbs.network-events";
    static final String BREADCRUMBS_SYSTEM_EVENTS_ENABLE = "io.sentry.breadcrumbs.system-events";
    static final String BREADCRUMBS_USER_INTERACTION_ENABLE = "io.sentry.breadcrumbs.user-interaction";
    static final String CLIENT_REPORTS_ENABLE = "io.sentry.send-client-reports";
    static final String COLLECT_ADDITIONAL_CONTEXT = "io.sentry.additional-context";
    static final String DEBUG = "io.sentry.debug";
    static final String DEBUG_LEVEL = "io.sentry.debug.level";
    static final String DSN = "io.sentry.dsn";
    static final String ENABLE_APP_START_PROFILING = "io.sentry.profiling.enable-app-start";
    static final String ENABLE_METRICS = "io.sentry.enable-metrics";
    static final String ENABLE_PERFORMANCE_V2 = "io.sentry.performance-v2.enable";
    static final String ENABLE_ROOT_CHECK = "io.sentry.enable-root-check";
    static final String ENABLE_SCOPE_PERSISTENCE = "io.sentry.enable-scope-persistence";
    static final String ENABLE_SENTRY = "io.sentry.enabled";
    static final String ENVIRONMENT = "io.sentry.environment";
    static final String IDLE_TIMEOUT = "io.sentry.traces.idle-timeout";
    static final String MAX_BREADCRUMBS = "io.sentry.max-breadcrumbs";
    static final String NDK_ENABLE = "io.sentry.ndk.enable";
    static final String NDK_SCOPE_SYNC_ENABLE = "io.sentry.ndk.scope-sync.enable";
    static final String PERFORM_FRAMES_TRACKING = "io.sentry.traces.frames-tracking";
    static final String PROFILES_SAMPLE_RATE = "io.sentry.traces.profiling.sample-rate";
    static final String PROGUARD_UUID = "io.sentry.proguard-uuid";
    static final String RELEASE = "io.sentry.release";
    static final String REPLAYS_ERROR_SAMPLE_RATE = "io.sentry.session-replay.on-error-sample-rate";
    static final String REPLAYS_MASK_ALL_IMAGES = "io.sentry.session-replay.mask-all-images";
    static final String REPLAYS_MASK_ALL_TEXT = "io.sentry.session-replay.mask-all-text";
    static final String REPLAYS_SESSION_SAMPLE_RATE = "io.sentry.session-replay.session-sample-rate";
    static final String SAMPLE_RATE = "io.sentry.sample-rate";
    static final String SDK_NAME = "io.sentry.sdk.name";
    static final String SDK_VERSION = "io.sentry.sdk.version";
    static final String SEND_DEFAULT_PII = "io.sentry.send-default-pii";
    static final String SEND_MODULES = "io.sentry.send-modules";
    static final String SENTRY_GRADLE_PLUGIN_INTEGRATIONS = "io.sentry.gradle-plugin-integrations";
    static final String SESSION_TRACKING_ENABLE = "io.sentry.session-tracking.enable";
    static final String SESSION_TRACKING_TIMEOUT_INTERVAL_MILLIS = "io.sentry.session-tracking.timeout-interval-millis";
    static final String TRACES_ACTIVITY_AUTO_FINISH_ENABLE = "io.sentry.traces.activity.auto-finish.enable";
    static final String TRACES_ACTIVITY_ENABLE = "io.sentry.traces.activity.enable";
    static final String TRACES_PROFILING_ENABLE = "io.sentry.traces.profiling.enable";
    static final String TRACES_SAMPLE_RATE = "io.sentry.traces.sample-rate";
    static final String TRACES_UI_ENABLE = "io.sentry.traces.user-interaction.enable";
    static final String TRACE_PROPAGATION_TARGETS = "io.sentry.traces.trace-propagation-targets";
    static final String TRACE_SAMPLING = "io.sentry.traces.trace-sampling";

    @Deprecated
    static final String TRACING_ENABLE = "io.sentry.traces.enable";

    @Deprecated
    static final String TRACING_ORIGINS = "io.sentry.traces.tracing-origins";
    static final String TTFD_ENABLE = "io.sentry.traces.time-to-full-display.enable";
    static final String UNCAUGHT_EXCEPTION_HANDLER_ENABLE = "io.sentry.uncaught-exception-handler.enable";

    private ManifestMetadataReader() {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x01e7 A[Catch: all -> 0x03d3, TryCatch #0 {all -> 0x03d3, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0053, B:12:0x007b, B:14:0x0089, B:15:0x008c, B:18:0x00cb, B:22:0x00d4, B:23:0x00ef, B:25:0x01e7, B:26:0x01f1, B:28:0x01f7, B:30:0x0205, B:31:0x0208, B:33:0x0242, B:35:0x0250, B:36:0x0253, B:38:0x0279, B:39:0x0280, B:43:0x028e, B:45:0x0294, B:46:0x0298, B:48:0x029e, B:51:0x02b0, B:52:0x02b3, B:54:0x02d0, B:55:0x02d5, B:57:0x0307, B:58:0x030b, B:60:0x0311, B:62:0x031f, B:64:0x0377, B:66:0x0385, B:67:0x038c, B:69:0x0396, B:71:0x03a4, B:72:0x03ab, B:74:0x02a6, B:75:0x00e2, B:76:0x03c5), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01f7 A[Catch: all -> 0x03d3, TryCatch #0 {all -> 0x03d3, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0053, B:12:0x007b, B:14:0x0089, B:15:0x008c, B:18:0x00cb, B:22:0x00d4, B:23:0x00ef, B:25:0x01e7, B:26:0x01f1, B:28:0x01f7, B:30:0x0205, B:31:0x0208, B:33:0x0242, B:35:0x0250, B:36:0x0253, B:38:0x0279, B:39:0x0280, B:43:0x028e, B:45:0x0294, B:46:0x0298, B:48:0x029e, B:51:0x02b0, B:52:0x02b3, B:54:0x02d0, B:55:0x02d5, B:57:0x0307, B:58:0x030b, B:60:0x0311, B:62:0x031f, B:64:0x0377, B:66:0x0385, B:67:0x038c, B:69:0x0396, B:71:0x03a4, B:72:0x03ab, B:74:0x02a6, B:75:0x00e2, B:76:0x03c5), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0242 A[Catch: all -> 0x03d3, TryCatch #0 {all -> 0x03d3, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0053, B:12:0x007b, B:14:0x0089, B:15:0x008c, B:18:0x00cb, B:22:0x00d4, B:23:0x00ef, B:25:0x01e7, B:26:0x01f1, B:28:0x01f7, B:30:0x0205, B:31:0x0208, B:33:0x0242, B:35:0x0250, B:36:0x0253, B:38:0x0279, B:39:0x0280, B:43:0x028e, B:45:0x0294, B:46:0x0298, B:48:0x029e, B:51:0x02b0, B:52:0x02b3, B:54:0x02d0, B:55:0x02d5, B:57:0x0307, B:58:0x030b, B:60:0x0311, B:62:0x031f, B:64:0x0377, B:66:0x0385, B:67:0x038c, B:69:0x0396, B:71:0x03a4, B:72:0x03ab, B:74:0x02a6, B:75:0x00e2, B:76:0x03c5), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0279 A[Catch: all -> 0x03d3, TryCatch #0 {all -> 0x03d3, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0053, B:12:0x007b, B:14:0x0089, B:15:0x008c, B:18:0x00cb, B:22:0x00d4, B:23:0x00ef, B:25:0x01e7, B:26:0x01f1, B:28:0x01f7, B:30:0x0205, B:31:0x0208, B:33:0x0242, B:35:0x0250, B:36:0x0253, B:38:0x0279, B:39:0x0280, B:43:0x028e, B:45:0x0294, B:46:0x0298, B:48:0x029e, B:51:0x02b0, B:52:0x02b3, B:54:0x02d0, B:55:0x02d5, B:57:0x0307, B:58:0x030b, B:60:0x0311, B:62:0x031f, B:64:0x0377, B:66:0x0385, B:67:0x038c, B:69:0x0396, B:71:0x03a4, B:72:0x03ab, B:74:0x02a6, B:75:0x00e2, B:76:0x03c5), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02d0 A[Catch: all -> 0x03d3, TryCatch #0 {all -> 0x03d3, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0053, B:12:0x007b, B:14:0x0089, B:15:0x008c, B:18:0x00cb, B:22:0x00d4, B:23:0x00ef, B:25:0x01e7, B:26:0x01f1, B:28:0x01f7, B:30:0x0205, B:31:0x0208, B:33:0x0242, B:35:0x0250, B:36:0x0253, B:38:0x0279, B:39:0x0280, B:43:0x028e, B:45:0x0294, B:46:0x0298, B:48:0x029e, B:51:0x02b0, B:52:0x02b3, B:54:0x02d0, B:55:0x02d5, B:57:0x0307, B:58:0x030b, B:60:0x0311, B:62:0x031f, B:64:0x0377, B:66:0x0385, B:67:0x038c, B:69:0x0396, B:71:0x03a4, B:72:0x03ab, B:74:0x02a6, B:75:0x00e2, B:76:0x03c5), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0307 A[Catch: all -> 0x03d3, TryCatch #0 {all -> 0x03d3, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0053, B:12:0x007b, B:14:0x0089, B:15:0x008c, B:18:0x00cb, B:22:0x00d4, B:23:0x00ef, B:25:0x01e7, B:26:0x01f1, B:28:0x01f7, B:30:0x0205, B:31:0x0208, B:33:0x0242, B:35:0x0250, B:36:0x0253, B:38:0x0279, B:39:0x0280, B:43:0x028e, B:45:0x0294, B:46:0x0298, B:48:0x029e, B:51:0x02b0, B:52:0x02b3, B:54:0x02d0, B:55:0x02d5, B:57:0x0307, B:58:0x030b, B:60:0x0311, B:62:0x031f, B:64:0x0377, B:66:0x0385, B:67:0x038c, B:69:0x0396, B:71:0x03a4, B:72:0x03ab, B:74:0x02a6, B:75:0x00e2, B:76:0x03c5), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0377 A[Catch: all -> 0x03d3, TryCatch #0 {all -> 0x03d3, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0053, B:12:0x007b, B:14:0x0089, B:15:0x008c, B:18:0x00cb, B:22:0x00d4, B:23:0x00ef, B:25:0x01e7, B:26:0x01f1, B:28:0x01f7, B:30:0x0205, B:31:0x0208, B:33:0x0242, B:35:0x0250, B:36:0x0253, B:38:0x0279, B:39:0x0280, B:43:0x028e, B:45:0x0294, B:46:0x0298, B:48:0x029e, B:51:0x02b0, B:52:0x02b3, B:54:0x02d0, B:55:0x02d5, B:57:0x0307, B:58:0x030b, B:60:0x0311, B:62:0x031f, B:64:0x0377, B:66:0x0385, B:67:0x038c, B:69:0x0396, B:71:0x03a4, B:72:0x03ab, B:74:0x02a6, B:75:0x00e2, B:76:0x03c5), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0396 A[Catch: all -> 0x03d3, TryCatch #0 {all -> 0x03d3, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0053, B:12:0x007b, B:14:0x0089, B:15:0x008c, B:18:0x00cb, B:22:0x00d4, B:23:0x00ef, B:25:0x01e7, B:26:0x01f1, B:28:0x01f7, B:30:0x0205, B:31:0x0208, B:33:0x0242, B:35:0x0250, B:36:0x0253, B:38:0x0279, B:39:0x0280, B:43:0x028e, B:45:0x0294, B:46:0x0298, B:48:0x029e, B:51:0x02b0, B:52:0x02b3, B:54:0x02d0, B:55:0x02d5, B:57:0x0307, B:58:0x030b, B:60:0x0311, B:62:0x031f, B:64:0x0377, B:66:0x0385, B:67:0x038c, B:69:0x0396, B:71:0x03a4, B:72:0x03ab, B:74:0x02a6, B:75:0x00e2, B:76:0x03c5), top: B:2:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void applyMetadata(android.content.Context r11, io.sentry.android.core.SentryAndroidOptions r12, io.sentry.android.core.BuildInfoProvider r13) {
        /*
            Method dump skipped, instructions count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.ManifestMetadataReader.applyMetadata(android.content.Context, io.sentry.android.core.SentryAndroidOptions, io.sentry.android.core.BuildInfoProvider):void");
    }

    private static boolean readBool(Bundle bundle, ILogger iLogger, String str, boolean z) {
        boolean z2 = bundle.getBoolean(str, z);
        iLogger.log(SentryLevel.DEBUG, str + " read: " + z2, new Object[0]);
        return z2;
    }

    private static Boolean readBoolNullable(Bundle bundle, ILogger iLogger, String str, Boolean bool) {
        if (bundle.getSerializable(str) != null) {
            boolean z = bundle.getBoolean(str, bool != null);
            iLogger.log(SentryLevel.DEBUG, str + " read: " + z, new Object[0]);
            return Boolean.valueOf(z);
        }
        iLogger.log(SentryLevel.DEBUG, str + " used default " + bool, new Object[0]);
        return bool;
    }

    private static String readString(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        iLogger.log(SentryLevel.DEBUG, str + " read: " + string, new Object[0]);
        return string;
    }

    private static String readStringNotNull(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        iLogger.log(SentryLevel.DEBUG, str + " read: " + string, new Object[0]);
        return string;
    }

    private static List<String> readList(Bundle bundle, ILogger iLogger, String str) {
        String string = bundle.getString(str);
        iLogger.log(SentryLevel.DEBUG, str + " read: " + string, new Object[0]);
        if (string != null) {
            return Arrays.asList(string.split(",", -1));
        }
        return null;
    }

    private static Double readDouble(Bundle bundle, ILogger iLogger, String str) {
        double doubleValue = Float.valueOf(bundle.getFloat(str, -1.0f)).doubleValue();
        if (doubleValue == -1.0d) {
            doubleValue = Integer.valueOf(bundle.getInt(str, -1)).doubleValue();
        }
        iLogger.log(SentryLevel.DEBUG, str + " read: " + doubleValue, new Object[0]);
        return Double.valueOf(doubleValue);
    }

    private static long readLong(Bundle bundle, ILogger iLogger, String str, long j) {
        long j2 = bundle.getInt(str, (int) j);
        iLogger.log(SentryLevel.DEBUG, str + " read: " + j2, new Object[0]);
        return j2;
    }

    static boolean isAutoInit(Context context, ILogger iLogger) {
        Objects.requireNonNull(context, "The application context is required.");
        try {
            Bundle metadata = getMetadata(context, iLogger, null);
            if (metadata != null) {
                return readBool(metadata, iLogger, AUTO_INIT, true);
            }
            return true;
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Failed to read auto-init from android manifest metadata.", th);
            return true;
        }
    }

    private static Bundle getMetadata(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider == null) {
            buildInfoProvider = new BuildInfoProvider(iLogger);
        }
        ApplicationInfo applicationInfo = ContextUtils.getApplicationInfo(context, buildInfoProvider);
        if (applicationInfo != null) {
            return applicationInfo.metaData;
        }
        return null;
    }
}
