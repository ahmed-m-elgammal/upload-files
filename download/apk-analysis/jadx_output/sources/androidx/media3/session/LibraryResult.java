package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import androidx.core.app.BundleCompat;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.Bundleable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class LibraryResult<V> implements Bundleable {
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
    private static final int VALUE_TYPE_ERROR = 4;
    private static final int VALUE_TYPE_ITEM = 2;
    private static final int VALUE_TYPE_ITEM_LIST = 3;
    private static final int VALUE_TYPE_VOID = 1;
    public final long completionTimeMs;
    public final MediaLibraryService.LibraryParams params;
    public final int resultCode;
    public final V value;
    private final int valueType;
    private static final String FIELD_RESULT_CODE = Util.intToStringMaxRadix(0);
    private static final String FIELD_COMPLETION_TIME_MS = Util.intToStringMaxRadix(1);
    private static final String FIELD_PARAMS = Util.intToStringMaxRadix(2);
    private static final String FIELD_VALUE = Util.intToStringMaxRadix(3);
    private static final String FIELD_VALUE_TYPE = Util.intToStringMaxRadix(4);

    @Deprecated
    public static final Bundleable.Creator<LibraryResult<Void>> VOID_CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.LibraryResult$$ExternalSyntheticLambda2
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return LibraryResult.fromVoidBundle(bundle);
        }
    };

    @Deprecated
    public static final Bundleable.Creator<LibraryResult<MediaItem>> ITEM_CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.LibraryResult$$ExternalSyntheticLambda3
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return LibraryResult.fromItemBundle(bundle);
        }
    };

    @Deprecated
    public static final Bundleable.Creator<LibraryResult<ImmutableList<MediaItem>>> ITEM_LIST_CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.LibraryResult$$ExternalSyntheticLambda4
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return LibraryResult.fromItemListBundle(bundle);
        }
    };

    @Deprecated
    public static final Bundleable.Creator<LibraryResult<?>> UNKNOWN_TYPE_CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.LibraryResult$$ExternalSyntheticLambda5
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return LibraryResult.fromUnknownBundle(bundle);
        }
    };

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {
    }

    public static LibraryResult<Void> ofVoid() {
        return new LibraryResult<>(0, SystemClock.elapsedRealtime(), null, null, 1);
    }

    public static LibraryResult<Void> ofVoid(MediaLibraryService.LibraryParams libraryParams) {
        return new LibraryResult<>(0, SystemClock.elapsedRealtime(), libraryParams, null, 1);
    }

    public static LibraryResult<MediaItem> ofItem(MediaItem mediaItem, MediaLibraryService.LibraryParams libraryParams) {
        verifyMediaItem(mediaItem);
        return new LibraryResult<>(0, SystemClock.elapsedRealtime(), libraryParams, mediaItem, 2);
    }

    public static LibraryResult<ImmutableList<MediaItem>> ofItemList(List<MediaItem> list, MediaLibraryService.LibraryParams libraryParams) {
        Iterator<MediaItem> it = list.iterator();
        while (it.hasNext()) {
            verifyMediaItem(it.next());
        }
        return new LibraryResult<>(0, SystemClock.elapsedRealtime(), libraryParams, ImmutableList.copyOf((Collection) list), 3);
    }

    public static <V> LibraryResult<V> ofError(int i) {
        return ofError(i, null);
    }

    public static <V> LibraryResult<V> ofError(int i, MediaLibraryService.LibraryParams libraryParams) {
        Assertions.checkArgument(i != 0);
        return new LibraryResult<>(i, SystemClock.elapsedRealtime(), libraryParams, null, 4);
    }

    private LibraryResult(int i, long j, MediaLibraryService.LibraryParams libraryParams, V v, int i2) {
        this.resultCode = i;
        this.completionTimeMs = j;
        this.params = libraryParams;
        this.value = v;
        this.valueType = i2;
    }

    private static void verifyMediaItem(MediaItem mediaItem) {
        Assertions.checkNotEmpty(mediaItem.mediaId, "mediaId must not be empty");
        Assertions.checkArgument(mediaItem.mediaMetadata.isBrowsable != null, "mediaMetadata must specify isBrowsable");
        Assertions.checkArgument(mediaItem.mediaMetadata.isPlayable != null, "mediaMetadata must specify isPlayable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r2 != 4) goto L19;
     */
    @Override // androidx.media3.common.Bundleable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle toBundle() {
        /*
            r5 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = androidx.media3.session.LibraryResult.FIELD_RESULT_CODE
            int r2 = r5.resultCode
            r0.putInt(r1, r2)
            java.lang.String r1 = androidx.media3.session.LibraryResult.FIELD_COMPLETION_TIME_MS
            long r2 = r5.completionTimeMs
            r0.putLong(r1, r2)
            androidx.media3.session.MediaLibraryService$LibraryParams r1 = r5.params
            if (r1 == 0) goto L20
            java.lang.String r2 = androidx.media3.session.LibraryResult.FIELD_PARAMS
            android.os.Bundle r1 = r1.toBundle()
            r0.putBundle(r2, r1)
        L20:
            java.lang.String r1 = androidx.media3.session.LibraryResult.FIELD_VALUE_TYPE
            int r2 = r5.valueType
            r0.putInt(r1, r2)
            V r1 = r5.value
            if (r1 != 0) goto L2c
            return r0
        L2c:
            int r2 = r5.valueType
            r3 = 1
            if (r2 == r3) goto L5f
            r3 = 2
            if (r2 == r3) goto L53
            r1 = 3
            if (r2 == r1) goto L3b
            r1 = 4
            if (r2 == r1) goto L5f
            goto L5e
        L3b:
            java.lang.String r1 = androidx.media3.session.LibraryResult.FIELD_VALUE
            androidx.media3.common.BundleListRetriever r2 = new androidx.media3.common.BundleListRetriever
            V r3 = r5.value
            com.google.common.collect.ImmutableList r3 = (com.google.common.collect.ImmutableList) r3
            androidx.media3.session.LibraryResult$$ExternalSyntheticLambda0 r4 = new androidx.media3.session.LibraryResult$$ExternalSyntheticLambda0
            r4.<init>()
            com.google.common.collect.ImmutableList r3 = androidx.media3.common.util.BundleCollectionUtil.toBundleList(r3, r4)
            r2.<init>(r3)
            androidx.core.app.BundleCompat.putBinder(r0, r1, r2)
            goto L5e
        L53:
            java.lang.String r2 = androidx.media3.session.LibraryResult.FIELD_VALUE
            androidx.media3.common.MediaItem r1 = (androidx.media3.common.MediaItem) r1
            android.os.Bundle r1 = r1.toBundle()
            r0.putBundle(r2, r1)
        L5e:
            return r0
        L5f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.LibraryResult.toBundle():android.os.Bundle");
    }

    public static LibraryResult<Void> fromVoidBundle(Bundle bundle) {
        return fromUnknownBundle(bundle);
    }

    public static LibraryResult<MediaItem> fromItemBundle(Bundle bundle) {
        return fromBundle(bundle, 2);
    }

    public static LibraryResult<ImmutableList<MediaItem>> fromItemListBundle(Bundle bundle) {
        return fromBundle(bundle, 3);
    }

    public static LibraryResult<?> fromUnknownBundle(Bundle bundle) {
        return fromBundle(bundle, null);
    }

    private static LibraryResult<?> fromBundle(Bundle bundle, Integer num) {
        int i = bundle.getInt(FIELD_RESULT_CODE, 0);
        long j = bundle.getLong(FIELD_COMPLETION_TIME_MS, SystemClock.elapsedRealtime());
        Bundle bundle2 = bundle.getBundle(FIELD_PARAMS);
        Object obj = null;
        MediaLibraryService.LibraryParams fromBundle = bundle2 == null ? null : MediaLibraryService.LibraryParams.fromBundle(bundle2);
        int i2 = bundle.getInt(FIELD_VALUE_TYPE);
        if (i2 != 1) {
            if (i2 == 2) {
                Assertions.checkState(num == null || num.intValue() == 2);
                Bundle bundle3 = bundle.getBundle(FIELD_VALUE);
                if (bundle3 != null) {
                    obj = MediaItem.fromBundle(bundle3);
                }
            } else if (i2 == 3) {
                Assertions.checkState(num == null || num.intValue() == 3);
                IBinder binder = BundleCompat.getBinder(bundle, FIELD_VALUE);
                if (binder != null) {
                    obj = BundleCollectionUtil.fromBundleList(new LibraryResult$$ExternalSyntheticLambda1(), BundleListRetriever.getList(binder));
                }
            } else if (i2 != 4) {
                throw new IllegalStateException();
            }
        }
        return new LibraryResult<>(i, j, fromBundle, obj, i2);
    }
}
