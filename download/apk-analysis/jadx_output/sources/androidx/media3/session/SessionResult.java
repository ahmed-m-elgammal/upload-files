package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes.dex */
public final class SessionResult implements Bundleable {
    public static final int RESULT_ERROR_BAD_VALUE = -3;
    public static final int RESULT_ERROR_INVALID_STATE = -2;
    public static final int RESULT_ERROR_IO = -5;
    public static final int RESULT_ERROR_NOT_SUPPORTED = -6;
    public static final int RESULT_ERROR_PERMISSION_DENIED = -4;
    public static final int RESULT_ERROR_SESSION_AUTHENTICATION_EXPIRED = -102;
    public static final int RESULT_ERROR_SESSION_CONCURRENT_STREAM_LIMIT = -104;
    public static final int RESULT_ERROR_SESSION_DISCONNECTED = -100;
    public static final int RESULT_ERROR_SESSION_NOT_AVAILABLE_IN_REGION = -106;
    public static final int RESULT_ERROR_SESSION_PARENTAL_CONTROL_RESTRICTED = -105;
    public static final int RESULT_ERROR_SESSION_PREMIUM_ACCOUNT_REQUIRED = -103;
    public static final int RESULT_ERROR_SESSION_SETUP_REQUIRED = -108;
    public static final int RESULT_ERROR_SESSION_SKIP_LIMIT_REACHED = -107;
    public static final int RESULT_ERROR_UNKNOWN = -1;
    public static final int RESULT_INFO_SKIPPED = 1;
    public static final int RESULT_SUCCESS = 0;
    public final long completionTimeMs;
    public final Bundle extras;
    public final int resultCode;
    private static final String FIELD_RESULT_CODE = Util.intToStringMaxRadix(0);
    private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(1);
    private static final String FIELD_COMPLETION_TIME_MS = Util.intToStringMaxRadix(2);

    @Deprecated
    public static final Bundleable.Creator<SessionResult> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.SessionResult$$ExternalSyntheticLambda0
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return SessionResult.fromBundle(bundle);
        }
    };

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {
    }

    public SessionResult(int i) {
        this(i, Bundle.EMPTY);
    }

    public SessionResult(int i, Bundle bundle) {
        this(i, bundle, SystemClock.elapsedRealtime());
    }

    private SessionResult(int i, Bundle bundle, long j) {
        this.resultCode = i;
        this.extras = new Bundle(bundle);
        this.completionTimeMs = j;
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_RESULT_CODE, this.resultCode);
        bundle.putBundle(FIELD_EXTRAS, this.extras);
        bundle.putLong(FIELD_COMPLETION_TIME_MS, this.completionTimeMs);
        return bundle;
    }

    public static SessionResult fromBundle(Bundle bundle) {
        int i = bundle.getInt(FIELD_RESULT_CODE, -1);
        Bundle bundle2 = bundle.getBundle(FIELD_EXTRAS);
        long j = bundle.getLong(FIELD_COMPLETION_TIME_MS, SystemClock.elapsedRealtime());
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new SessionResult(i, bundle2, j);
    }
}
